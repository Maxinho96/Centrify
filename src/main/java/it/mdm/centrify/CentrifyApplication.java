package it.mdm.centrify;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.mdm.centrify.model.Allievo;
import it.mdm.centrify.model.Attivita;
import it.mdm.centrify.model.Azienda;
import it.mdm.centrify.model.Centro;
import it.mdm.centrify.model.Direttore;
import it.mdm.centrify.model.Responsabile;
import it.mdm.centrify.service.AziendaService;

@SpringBootApplication
public class CentrifyApplication {
	
	@Autowired
	private AziendaService aziendaService;

	public static void main(String[] args) {
		SpringApplication.run(CentrifyApplication.class, args);
	}
	
	@PostConstruct
	public void init() {
		Azienda azienda = new Azienda("Centrify", "Via Giuseppe Rossi, 80");
		Centro centro1 = new Centro("Scuola Garibaldi", "Via Giuseppe Mazzini, 32", "garib@school.it", "06 823 2693", 12);
		Responsabile responsabile1 = new Responsabile("resp1", "pass", "Marco", "Rossi", 1300f);
		centro1.setResponsabile(responsabile1);
		azienda.addCentro(centro1);
		Centro centro2 = new Centro("Scuola Berlusconi", "Via Marco Salvini, 69", "berlusca@school.it", "06 823 2645", 14);
		Responsabile responsabile2 = new Responsabile("resp2", "pass", "Massimo", "Ottavi", 1400f);
		centro2.setResponsabile(responsabile2);
		azienda.addCentro(centro2);
		Direttore direttore = new Direttore("paolo.atzeni", "pass", "Paolo", "Atzeni");
		azienda.setDirettore(direttore);
		Allievo allievo1 = new Allievo("Massimiliano", "Bruni", "mas.bruni@school.it", "331 123 4567", new Date(96, 6, 10), new Date(118, 6, 4), "Roma", 'M');
		azienda.addAllievo(allievo1);
		Allievo allievo2 = new Allievo("Marco", "Berbeglia", "marco.berb@school.it", "331 234 6433", new Date(96, 3, 11), new Date(118, 6, 4), "Roma", 'M');
		azienda.addAllievo(allievo2);
		Allievo allievo3 = new Allievo("Diego", "Barbieri", "diego.barb@school.it", "331 043 2053", new Date(96, 2, 25), new Date(118, 6, 4), "Roma", 'M');
		azienda.addAllievo(allievo3);
		Attivita attivita1 = new Attivita("APS",new Date(118,8,23,17,30), "Luca", "Cabibbo", "Corso di Analisi e Progettazione del Software");
		Attivita attivita2 = new Attivita("Filosofia",new Date(118,11,27,17,30), "Marta", "Cialdea", "Corso di Filosofia");
		centro1.addAttivita(attivita1);
		centro1.addAttivita(attivita2);
		allievo1.addAttivita(attivita1);
		attivita1.addAllievo(allievo1);
		allievo1.addAttivita(attivita2);
		attivita2.addAllievo(allievo1);
		allievo2.addAttivita(attivita2);
		attivita2.addAllievo(allievo2);
		Attivita attivita3 = new Attivita("SIW", new Date(118,10,12,17,30),"Paolo", "Merialdo", "Corso di Sistemi Informativi per il web");
		centro2.addAttivita(attivita3);
		allievo3.addAttivita(attivita3);
		attivita3.addAllievo(allievo3);
		this.aziendaService.add(azienda);
	}
	
}
