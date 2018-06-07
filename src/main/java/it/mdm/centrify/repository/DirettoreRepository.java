package it.mdm.centrify.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import it.mdm.centrify.model.Direttore;

public interface DirettoreRepository extends CrudRepository<Direttore, Long>{
	
	public Optional<Direttore> findByOauthIdentifier(String oauthIdentifier);

}
