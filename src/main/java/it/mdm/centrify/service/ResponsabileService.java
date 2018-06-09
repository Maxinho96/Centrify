package it.mdm.centrify.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.mdm.centrify.model.Responsabile;
import it.mdm.centrify.repository.ResponsabileRepository;

@Service
public class ResponsabileService {
	
	@Autowired
	private ResponsabileRepository responsabileRepository;
	
	@Transactional
	public Responsabile getByOauthIdentifier(String oauthIdentifier) {
		Optional<Responsabile> responsabile = this.responsabileRepository.findByOauthIdentifier(oauthIdentifier);
		if(responsabile.isPresent()) {
			return responsabile.get();
		}
		else {
			return null;
		}
	}
	
}
