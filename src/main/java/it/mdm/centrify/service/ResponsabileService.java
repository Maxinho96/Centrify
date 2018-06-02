package it.mdm.centrify.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.mdm.centrify.model.Attivita;
import it.mdm.centrify.repository.AttivitaRepository;

@Service
public class ResponsabileService {
	@Autowired
	private AttivitaRepository attivitaRepository;
	
	public void addAttivita(Attivita attivita) {
		this.attivitaRepository.save(attivita);
	}
	
	public Iterable<Attivita> findAllAttivita() {
		return this.attivitaRepository.findAll();
	}
	public Attivita findByIdAttivita(Long id) {
		Optional<Attivita> attivita = this.attivitaRepository.findById(id);
		if(attivita.isPresent()) {
			return attivita.get();
		}
		else {
			return null;
		}
	}
}
