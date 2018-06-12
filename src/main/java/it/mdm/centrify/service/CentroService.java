package it.mdm.centrify.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.mdm.centrify.model.Centro;
import it.mdm.centrify.repository.CentroRepository;

@Service
public class CentroService {
	
	@Autowired
	private CentroRepository centroRepository;
	
	@Transactional
	public void save(Centro centro) {
		this.centroRepository.save(centro);
	}
	
	@Transactional
	public Centro getOne(Long id) {
		Optional<Centro> centro = this.centroRepository.findById(id);
		if(centro.isPresent()) {
			return centro.get();
		}
		else {
			return null;
		}
	}
	
}
