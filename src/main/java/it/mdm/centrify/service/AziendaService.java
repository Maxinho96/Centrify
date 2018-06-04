package it.mdm.centrify.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.mdm.centrify.model.Azienda;
import it.mdm.centrify.repository.AziendaRepository;

@Service
public class AziendaService {
	
	@Autowired
	private AziendaRepository aziendaRepository;
	
	@Transactional
	public void add(Azienda azienda) {
		this.aziendaRepository.save(azienda);
	}

}
