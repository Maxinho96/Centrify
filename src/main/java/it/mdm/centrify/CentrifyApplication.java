package it.mdm.centrify;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import it.mdm.centrify.model.Allievo;
import it.mdm.centrify.model.Attivita;
import it.mdm.centrify.model.Azienda;
import it.mdm.centrify.model.Centro;
import it.mdm.centrify.model.Direttore;
import it.mdm.centrify.model.Responsabile;
import it.mdm.centrify.service.AziendaService;

@SpringBootApplication
@EnableOAuth2Sso
public class CentrifyApplication extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private AziendaService aziendaService;
	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//	  http.antMatcher("/**").
//	  authorizeRequests()
//	  //.antMatchers("/", "/login**", "/webjars/**", "/error**")
//	  //.permitAll()
//	  .anyRequest()
//	  .authenticated()
//	  .and()
//	  .logout()
//	  .logoutSuccessUrl("/")
//	  .permitAll()
//	  .and()
//	  .csrf()
//	  .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
//	}

	public static void main(String[] args) {
		SpringApplication.run(CentrifyApplication.class, args);
	}
	
	@PostConstruct
	public void init() {
		
		Azienda azienda = new Azienda("Centrify", "Via Giuseppe Rossi, 80");
		Centro centro1 = new Centro("Scuola Garibaldi", "Via Giuseppe Mazzini, 32", "garib@school.it", "06 823 2693", 12);
		Responsabile responsabile1 = new Responsabile("Marco", "Rossi", 1300f, "104563227110019");
		// 100003246565067
		
		responsabile1.setCentro(centro1);
		centro1.setResponsabile(responsabile1);
		azienda.addCentro(centro1);
		centro1.setAzienda(azienda);
		
		Centro centro2 = new Centro("Scuola Berlusconi", "Via Marco Salvini, 69", "berlusca@school.it", "06 823 2645", 14);
		Responsabile responsabile2 = new Responsabile("Massimo", "Ottavi", 1400f, "a");
		
		responsabile2.setCentro(centro2);
		centro2.setResponsabile(responsabile2);
		azienda.addCentro(centro2);
		centro2.setAzienda(azienda);
		
		Direttore direttore = new Direttore("Paolo", "Atzeni", "118942502330805");
		azienda.setDirettore(direttore);
		
		Allievo allievo1 = new Allievo("Massimiliano", "Bruni", "mas.bruni@school.it", "331 123 4567", 1996, 6, 10, new Date(118, 6, 4), "Roma", 'M');
		azienda.addAllievo(allievo1);
		
		Allievo allievo2 = new Allievo("Marco", "Berbeglia", "marco.berb@school.it", "331 234 6433", 1996, 3, 11, new Date(118, 6, 4), "Roma", 'M');
		azienda.addAllievo(allievo2);
		
		Allievo allievo3 = new Allievo("Diego", "Barbieri", "diego.barb@school.it", "331 043 2053", 1996, 2, 25, new Date(118, 6, 4), "Roma", 'M');
		azienda.addAllievo(allievo3);
		
		Attivita attivita1 = new Attivita("APS","Luca", "Cabibbo", "Corso di Analisi e Progettazione del Software",2,4,2018,"16","30");
		Attivita attivita2 = new Attivita("Filosofia", "Marta", "Cialdea", "Corso di Filosofia",23,11,2018,"14","30");
		Attivita attivita3 = new Attivita("SIW","Paolo", "Merialdo", "Corso di Sistemi Informativi per il web",11,10,2018,"11","25");
		
		centro1.addAttivita(attivita1);
		centro1.addAttivita(attivita2);
		centro2.addAttivita(attivita3);
		
		allievo1.addAttivita(attivita1);
		attivita1.addAllievo(allievo1);
		
		allievo1.addAttivita(attivita2);
		attivita2.addAllievo(allievo1);
		
		allievo2.addAttivita(attivita2);
		attivita2.addAllievo(allievo2);	
		
		allievo3.addAttivita(attivita3);
		attivita3.addAllievo(allievo3);
				
		this.aziendaService.save(azienda);
	}
	
}
