package it.mdm.centrify.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.mdm.centrify.model.Allievo;
import it.mdm.centrify.repository.AllievoRepository;

@Service
public class AllievoService {
	
	@Autowired
	private AllievoRepository allievoRepository;
	
	@Transactional
	public Allievo getOne(Long id) {
		Optional<Allievo> allievo = this.allievoRepository.findById(id);
		if(allievo.isPresent()) {
			return allievo.get();
		}
		else {
			return null;
		}
	}

//	@Transactional
//	public Allievo addAllievo(Allievo allievo) {
//		Optional<Allievo> a = this.allievoRepository.findByEmail(allievo.getEmail());
//		if(a.isPresent())
//			return null;
//		else
//			return this.allievoRepository.save(allievo);
//	}
	
}
