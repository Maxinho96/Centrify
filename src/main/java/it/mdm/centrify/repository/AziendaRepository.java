package it.mdm.centrify.repository;

import org.springframework.data.repository.CrudRepository;

import it.mdm.centrify.model.Azienda;

public interface AziendaRepository extends CrudRepository<Azienda, Long> {
	
	// public List<Allievo> findAllieviByNomeOrCognome(String nome, String cognome);

}
