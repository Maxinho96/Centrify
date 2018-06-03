package it.mdm.centrify;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.mdm.centrify.model.Attivita;
import it.mdm.centrify.service.AttivitaService;

@SpringBootApplication
public class CentrifyApplication {
	
	@Autowired
	private AttivitaService responsabileService;

	public static void main(String[] args) {
		SpringApplication.run(CentrifyApplication.class, args);
	}
	
	@PostConstruct
	public void init() {
		this.responsabileService.add(new Attivita("Informatica",new Date(118,8,23,17,30),"Bruni","Attivita Molto Carina"));
		this.responsabileService.add(new Attivita("ANALEsi e Progettazione Software",new Date(118,11,27,17,30),"Cabibbo","Martellata sulle Mani"));
		this.responsabileService.add(new Attivita("Sistemi Informativi sul Web",new Date(118,10,12,17,30),"Pelato di Brazzers","JSP JPA JSTL JMERDA JDIOCANE"));
	}
	
}
