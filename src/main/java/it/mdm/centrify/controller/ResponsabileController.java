package it.mdm.centrify.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ResponsabileController {
	
	@RequestMapping("/login")
	public String login() {
		return "mainpage_resp";
	}
	
	@RequestMapping("/aggiungi_allievo")
	public String aggiungiAllievo() {
		return "aggiungi_allievo";
	}
	
	@RequestMapping("/mainpage")
	public String mainPageResp() {
		return "mainpage_resp";
	}
	
	@RequestMapping("/scheda_attivita")
	public String schedaAttivita() {
		return "template_attivita";
	}
	
	@RequestMapping("/aggiungi_attivita")
	public String aggiungiAttivita() {
		return "aggiungi_attivita";
	}

}
