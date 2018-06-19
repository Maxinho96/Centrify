package it.mdm.centrify.controller;

import java.security.Principal;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import it.mdm.centrify.model.Centro;
import it.mdm.centrify.model.Direttore;
import it.mdm.centrify.model.Responsabile;
import it.mdm.centrify.service.CentroService;
import it.mdm.centrify.service.DirettoreService;

@Controller
@SessionAttributes("direttore")
public class DirettoreController {

	@Autowired
	private DirettoreService direttoreService;

	@Autowired
	private CentroService centroService;

	@ModelAttribute("direttore")
	public Direttore getDirettore(Principal principal) {
		String oauthIdentifier = principal.getName();
		Direttore direttore = this.direttoreService.getByOauthIdentifier(oauthIdentifier);
		// System.out.println(oauthIdentifier);
		if (direttore != null) {
			return direttore;
		} else {
			return null;
		}
	}

	@RequestMapping("/mainpage_d")
	public String mainPageDir(@ModelAttribute("direttore") Direttore direttore) {
		if(direttore == null) {
			return "redirect:errore_dir.html";
		}
		direttore = this.getDirettore(principal);
		model.addAttribute("direttore", direttore);
		Set<Centro> centri = direttore.getAzienda().getCentri();
		model.addAttribute("centri", centri);
		return "mainpage_dir";
	}

	@RequestMapping("/aggiungi_centro")
	public String aggiungiCentro(@ModelAttribute("direttore") Direttore direttore, Model model) {
		if(direttore == null) {
			return "redirect:errore_dir.html";
		}
		return "aggiungi_centro";
	}

	@RequestMapping("/scheda_centro/{id}")
	public String schedaAllievo(
			@ModelAttribute("direttore") Direttore direttore,
			@PathVariable("id") Long id,
			Model model) {
		if(direttore == null) {
			return "errore_dir";
		}
		model.addAttribute("centro", this.centroService.getOne(id));
		return "template_centro";
	}
}
