package it.mdm.centrify.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.mdm.centrify.model.Allievo;

public interface AllievoRepository extends CrudRepository<Allievo, Long> {
	
	 @Query("SELECT a FROM Allievo a WHERE a.azienda_id = :azienda_id AND (a.nome = :nome OR a.cognome = :cognome)")
	 public List<Allievo> findByAziendaAndNomeOrCognome(@Param("azienda_id") Long azienda_id, @Param("nome") String nome, @Param("cognome") String cognome);
	 
}
 