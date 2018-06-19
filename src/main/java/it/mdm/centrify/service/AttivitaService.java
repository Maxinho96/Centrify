package it.mdm.centrify.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.mdm.centrify.model.Attivita;
import it.mdm.centrify.repository.AttivitaRepository;

@Service
public class AttivitaService {
	
	@Autowired
	private AttivitaRepository attivitaRepository;
	
	@Transactional
	public void save(Attivita attivita) {
		this.attivitaRepository.save(attivita);
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
