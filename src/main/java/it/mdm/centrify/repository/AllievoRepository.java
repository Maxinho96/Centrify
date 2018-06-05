package it.mdm.centrify.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.mdm.centrify.model.Allievo;

public interface AllievoRepository extends CrudRepository<Allievo, Long> {
	
//	 @Query("SELECT a FROM Allievo a WHERE a.email = :email")
//	 public Optional<Allievo> findByEmail(@Param("email") String email);
//	     
	
}
 