package it.mdm.centrify.service;

import java.util.Optional;

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
	public void save(Azienda azienda) {
		this.aziendaRepository.save(azienda);
	}
	
	@Transactional
	public Azienda getOne(Long id) {
		Optional<Azienda> azienda =this.aziendaRepository.findById(id);
		if(azienda.isPresent())
			return azienda.get();
		else
			return null;
	}
	

}
