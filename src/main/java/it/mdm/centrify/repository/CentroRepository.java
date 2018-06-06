package it.mdm.centrify.repository;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import it.mdm.centrify.model.Attivita;
import it.mdm.centrify.model.Centro;

public interface CentroRepository extends CrudRepository<Centro, Long> {
	
	public Set<Attivita> findAttivitaById(Long id);

}
