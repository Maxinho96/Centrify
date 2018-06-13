package it.mdm.centrify.controller;

import java.security.Principal;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import it.mdm.centrify.model.Allievo;
import it.mdm.centrify.model.Azienda;
import it.mdm.centrify.model.Centro;
import it.mdm.centrify.model.Responsabile;
import it.mdm.centrify.service.AllievoService;
import it.mdm.centrify.service.AttivitaService;
import it.mdm.centrify.service.AziendaService;
import it.mdm.centrify.service.ResponsabileService;

@Controller
@SessionAttributes("responsabile")
public class ResponsabileController {

	@Autowired
	private AttivitaService attivitaService; 
	
	@Autowired
	private AziendaService aziendaService; 
	
	@Autowired
	private AllievoService allievoService;
	
	@Autowired
	private ResponsabileService responsabileService;
	
	@ModelAttribute("responsabile")
    public Responsabile getResponsabile (Principal principal) {
		String oauthIdentifier = principal.getName();
		Responsabile responsabile = this.responsabileService.getByOauthIdentifier(oauthIdentifier);
		// System.out.println(oauthIdentifier);
		if(responsabile != null) {
			return responsabile;
		}
		else {
			return null;
		}
    }

	@RequestMapping("/scheda_allievo/{id}")
	public String schedaAllievo(
			@ModelAttribute("responsabile") Responsabile responsabile,
			@PathVariable("id") Long id,
			Model model) {
		if(responsabile == null) {
			return "errore_resp";
		}
		model.addAttribute("allievo", this.allievoService.getOne(id));
		return "template_allievo";
	}

	@RequestMapping("/mainpage_r")
	public String mainPageResp(
			Principal principal,
			@ModelAttribute("responsabile") Responsabile responsabile,
			Model model) {
		if(responsabile == null) {
			return "errore_resp";
		}
		responsabile = this.getResponsabile(principal);
		model.addAttribute("responsabile", responsabile);
		Centro centro = responsabile.getCentro();
		model.addAttribute("attivita", centro.getAttivita());
		return "mainpage_resp";
	}

	@RequestMapping("/scheda_attivita/{id}")
	public String schedaAttivita(
			@ModelAttribute("responsabile") Responsabile responsabile, 
			@PathVariable("id") Long id,
			Model model) {
		if(responsabile == null) {
			return "errore_resp";
		}
		model.addAttribute("attivita", this.attivitaService.getOne(id));
		return "template_attivita";
	}

	@RequestMapping("/aggiungi_attivita")
	public String aggiungiAttivita(@ModelAttribute("responsabile") Responsabile responsabile) {
		if(responsabile == null) {
			return "errore_resp";
		}
		return "aggiungi_attivita";
	}

	
    @GetMapping("/aggiungi_allievo")
    public ModelAndView showForm(@ModelAttribute("responsabile") Responsabile responsabile) {
    	if(responsabile == null) {
    		return new ModelAndView("errore_resp");
    	}
        return new ModelAndView("aggiungi_allievo", "allievo", new Allievo());
    }
	
	@PostMapping("/submit_aggiungi_allievo")
	public String submitAggiungiAllievo(
			Principal principal,
			@ModelAttribute("responsabile") Responsabile responsabile, 
			@Valid @ModelAttribute Allievo allievo,
			BindingResult result,
			Model model) {
		if(responsabile == null) {
			return "errore_resp";
		}
		responsabile = this.getResponsabile(principal);
		if (result.hasErrors()) {
			System.out.println(result.getAllErrors().toString());
			return "/error";	//TO DO
		}
		allievo.setDataDiIscrizione(new Date());
		
		//System.out.println(allievo.toString());
		
		Azienda azienda = responsabile.getCentro().getAzienda();
		if (azienda != null) {
			if(azienda.containsAllievoWithEmail(allievo.getEmail())) {
				model.addAttribute("valid", "is-invalid");
				return "aggiungi_allievo";	//TO DO
			}
			else {
				azienda.addAllievo(allievo);
				this.aziendaService.save(azienda);
			}
		}	
		return "template_allievo";
	}

	//	@RequestMapping("/logout")
	//	public String logout() {
	//		return "index";
	//	}
}
