package it.mdm.centrify.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.mdm.centrify.model.Direttore;
import it.mdm.centrify.repository.DirettoreRepository;

@Service
public class DirettoreService {
	
	@Autowired
	private DirettoreRepository direttoreRepository;

	@Transactional
	public Direttore getByOauthIdentifier(String oauthIdentifier) {
		Optional<Direttore> direttore = this.direttoreRepository.findByOauthIdentifier(oauthIdentifier);
		if(direttore.isPresent()) {
			return direttore.get();
		}
		else {
			return null;
		}
	}

}
