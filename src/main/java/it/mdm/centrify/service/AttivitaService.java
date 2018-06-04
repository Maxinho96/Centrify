package it.mdm.centrify.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.mdm.centrify.model.Attivita;
import it.mdm.centrify.model.Centro;
import it.mdm.centrify.repository.AttivitaRepository;

@Service
public class AttivitaService {
	
	@Autowired
	private AttivitaRepository attivitaRepository;
	@Autowired
	private CentroRepository centroRepository;

	@Transactional
	public Set<Attivita> getAllByCentro(Long id) {
		Optional<Centro> centro = this.centroRepository.findById(id);
		if(centro.isPresent()) {
			return centro.get().getAttivita();
		}
		else {
			return null;
		}
	}
	
	@Transactional
	public Attivita getOne(Long id) {
		Optional<Attivita> attivita = this.attivitaRepository.findById(id);
		if(attivita.isPresent()) {
			return attivita.get();
		}
		else {
			return null;
		}
	}
	
}
