package it.mdm.centrify.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import it.mdm.centrify.service.ResponsabileService;

@Controller
public class ResponsabileController {
	
	@Autowired
	private ResponsabileService responsabileService; 
	
	@RequestMapping("/login")
	public String login() {
		return "mainpage_resp";
	}
	
	@RequestMapping("/aggiungi_allievo")
	public String aggiungiAllievo() {
		return "aggiungi_allievo";
	}
	
	@RequestMapping("/mainpage")
	public String mainPageResp(Model model) {
		model.addAttribute("attivita", this.responsabileService.findAllAttivita());
		return "mainpage_resp";
	}
	
	@RequestMapping("/scheda_attivita")
	public String schedaAttivita() {
		return "template_attivita";
	}
	
	@RequestMapping("/scheda_attivita/{id}")
	public String schedaAttivita(@PathVariable("id") Long id, Model model) {
		model.addAttribute("attivita", this.responsabileService.findByIdAttivita(id));
		return "template_attivita";
	}
	
	@RequestMapping("/aggiungi_attivita")
	public String aggiungiAttivita() {
		return "aggiungi_attivita";
	}

}
