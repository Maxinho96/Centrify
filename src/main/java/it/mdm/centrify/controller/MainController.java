package it.mdm.centrify.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import it.mdm.centrify.model.Direttore;
import it.mdm.centrify.model.Responsabile;
import it.mdm.centrify.service.DirettoreService;
import it.mdm.centrify.service.ResponsabileService;

@Controller
@SessionAttributes({"responsabile", "direttore"})
public class MainController {
	
	@Autowired
	private ResponsabileService responsabileService;
	
	@Autowired
	private DirettoreService direttoreService;
	
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
	
	@ModelAttribute("direttore")
    public Direttore getDirettore (Principal principal) {
		String oauthIdentifier = principal.getName();
		Direttore direttore = this.direttoreService.getByOauthIdentifier(oauthIdentifier);
		// System.out.println(oauthIdentifier);
		if(direttore != null) {
			return direttore;
		}
		else {
			return null;
		}
    }
	
	@RequestMapping("/")
	public String index(@ModelAttribute("responsabile") Responsabile responsabile,
			@ModelAttribute("direttore") Direttore direttore) {
		if(responsabile != null) {
			return "redirect:mainpage_r";
		}
		else if(direttore != null){
			return "redirect:mainpage_d"; // Implementare la pagina del direttore
		}
		else {
			return "errore_reg"; // Implementare la pagina d'errore
		}
	}

}
