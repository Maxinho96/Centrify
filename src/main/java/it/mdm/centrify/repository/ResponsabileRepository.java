package it.mdm.centrify.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import it.mdm.centrify.model.Responsabile;

public interface ResponsabileRepository extends CrudRepository<Responsabile, Long> {
	
	public Optional<Responsabile> findByOauthIdentifier(String oauthIdentifier);

}
