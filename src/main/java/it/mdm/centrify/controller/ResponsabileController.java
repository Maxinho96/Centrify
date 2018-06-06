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
@SessionAttributes("responsabileOauthIdentifier")
public class ResponsabileController {

	@Autowired
	private AttivitaService attivitaService; 
	
	@Autowired
	private AziendaService aziendaService; 
	
	@Autowired
	private AllievoService allievoService;
	
	@Autowired
	private ResponsabileService responsabileService;
	
	@ModelAttribute("responsabileOauthIdentifier")
    public String getResponsabileOauthIdentifier (Principal principal) {
		String oauthIdentifier = principal.getName();
		if(this.responsabileService.getByOauthIdentifier(oauthIdentifier) != null) {
			return oauthIdentifier;
		}
		else {
			return "notPresent";
		}
    }

//	@RequestMapping("/index")
//	public String index(Principal principal, Model model) {
//		String oauthIdentifier = principal.getName();
//		if(this.responsabileService.getByOauthIdentifier(oauthIdentifier) != null) {
//			model.addAttribute("responsabileOauthIdentifier", "a");
//			return "redirect:mainpage";
//		}
//		else {
//			return "a"; // Implementare il caso del direttore
//		}
//	}

	@RequestMapping("/scheda_attivita/scheda_allievo/{id}")
	public String schedaAllievo(@PathVariable("id") Long id, Model model) {
		model.addAttribute("allievo", this.allievoService.getOne(id));
		return "template_allievo";
	}

	@RequestMapping("/mainpage")
	public String mainPageResp(@ModelAttribute("responsabileOauthIdentifier") String responsabileOauthIdentifier, Model model) {
		Responsabile responsabile = this.responsabileService.getByOauthIdentifier(responsabileOauthIdentifier);
		if(responsabile != null) {
			Centro centro = responsabile.getCentro();
			model.addAttribute("attivita", centro.getAttivita());
			return "mainpage_resp";
		}
		else {
			return "errore_resp";
		}
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

	
    @GetMapping("/aggiungi_allievo")
    public ModelAndView showForm() {
        return new ModelAndView("aggiungi_allievo", "allievo", new Allievo());
    }
	
	@PostMapping("/submit_aggiungi_allievo")
	public String submitAggiungiAllievo(@Valid @ModelAttribute Allievo allievo, BindingResult result, Model model) {
		if (result.hasErrors()) {
			System.out.println(result.getAllErrors().toString());
			return "/error";	//TO DO
		}
		allievo.setDataDiIscrizione(new Date());
		
		//System.out.println(allievo.toString());
		
		Azienda azienda = this.aziendaService.get(1l); //provvisorio
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
