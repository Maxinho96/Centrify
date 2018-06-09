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
import it.mdm.centrify.validator.AllievoValidator;

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
	public String mainPageResp(@ModelAttribute("responsabile") Responsabile responsabile, Model model) {
		if(responsabile == null) {
			return "errore_resp";
		}
		Centro centro = responsabile.getCentro();
		model.addAttribute("attivita", centro.getAttivita());
		return "mainpage_resp";
	}

	@RequestMapping("/scheda_attivita/{id}")
	public String schedaAttivita(@ModelAttribute("responsabile") Responsabile responsabile, @PathVariable("id") Long id, Model model) {
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
	public String submitAggiungiAllievo(@ModelAttribute("responsabile") Responsabile responsabile, @Valid @ModelAttribute Allievo allievo, BindingResult result, Model model) {
		if(responsabile == null) {
			return "errore_resp";
		}
		if (result.hasErrors()) {
			//System.out.println(result.getAllErrors().toString());
			//return "";
		}
		
		boolean error = false;
		AllievoValidator av = new AllievoValidator(allievo);
		
		if(!av.isNomeValid()) {
			model.addAttribute("valid_nome", "is-invalid");
			error = true;
		}
		
		if(!av.isCognomeValid()) {
			model.addAttribute("valid_cognome", "is-invalid");
			error = true;
		}
		
		if(!av.isEmailValid()) {
			model.addAttribute("valid_email", "is-invalid");
			error = true;
		}
		
		if(!av.isCellulareValid()) {
			model.addAttribute("valid_cellulare", "is-invalid");
			error = true;
		}
		
		if(!av.isLuogoDiNascitaValid()) {
			model.addAttribute("valid_luogoDiNascita", "is-invalid");
			error = true;
		}
		
		if(!av.isGiornoNascitaValid()) {
			model.addAttribute("valid_giornoNascita", "is-invalid");
			error = true;
		}
		
		if(!av.isMeseNascitaValid()) {
			model.addAttribute("valid_meseNascita", "is-invalid");
			error = true;
		}
		
		if(!av.isAnnoNascitaValid()) {
			model.addAttribute("valid_annoNascita", "is-invalid");
			error = true;
		}
		
		if(error)
			
			return "aggiungi_allievo";
		
		allievo.setDataDiIscrizione(new Date());
		
		//System.out.println(allievo.toString());
		Azienda azienda = this.aziendaService.get(1l); //provvisorio
		if (azienda != null) {
			if(azienda.containsAllievoWithEmail(allievo.getEmail())) {
				model.addAttribute("valid_email", "is-invalid");
				return "aggiungi_allievo";
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
