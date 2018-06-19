package it.mdm.centrify.service;

import java.util.List;
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
	public void save(Allievo allievo) {
		this.allievoRepository.save(allievo);
	}
		
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

	@Transactional
	public List<Allievo> getByAziendaAndNomeOrCognome(Long azienda_id, String nome, String cognome) {
		return this.allievoRepository.findByAziendaAndNomeOrCognome(azienda_id, nome, cognome);
	}
	
}
