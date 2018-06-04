package it.mdm.centrify.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import it.mdm.centrify.service.AttivitaService;

@Controller
public class ResponsabileController {
	
	@Autowired
	private AttivitaService attivitaService; 
	
	@RequestMapping("/login")
	public String login() {
		return "mainpage_resp";
	}
	
	@RequestMapping("/scheda_allievo")
	public String schedaAllievo() {
		return "template_allievo";
	}
	
	@RequestMapping("/aggiungi_allievo")
	public String aggiungiAllievo() {
		return "aggiungi_allievo";
	}
	
	@RequestMapping("/mainpage")
	public String mainPageResp(Model model) {
		model.addAttribute("attivita", this.attivitaService.getAll());
		return "mainpage_resp";
	}
	
	@RequestMapping("/scheda_attivita/{id}")
	public String schedaAttivita(@PathVariable("id") Long id, Model model) {
		model.addAttribute("attivita", this.attivitaService.getOne(id));
		return "template_attivita";
	}
	
	@RequestMapping("/aggiungi_attivita")
	public String aggiungiAttivita() {
		return "aggiungi_attivita";
	}

//	@RequestMapping("/logout")
//	public String logout() {
//		return "index";
//	}
}
