package it.mdm.centrify.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.mdm.centrify.model.Allievo;

public interface AllievoRepository extends CrudRepository<Allievo, Long> {
	
	 @Query(value = "SELECT * FROM allievo WHERE allievo.azienda_id = :azienda_id AND (allievo.nome LIKE CONCAT('%', :nome, '%') OR allievo.cognome LIKE CONCAT('%', :cognome, '%'))", nativeQuery = true)
	 public List<Allievo> findByAziendaAndNomeOrCognome(@Param("azienda_id") Long azienda_id, @Param("nome") String nome, @Param("cognome") String cognome);
	 
}
 