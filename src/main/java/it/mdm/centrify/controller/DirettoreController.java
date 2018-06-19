package it.mdm.centrify.controller;

import java.security.Principal;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import it.mdm.centrify.model.Azienda;
import it.mdm.centrify.model.Centro;
import it.mdm.centrify.model.Direttore;
import it.mdm.centrify.service.CentroService;
import it.mdm.centrify.service.DirettoreService;
import it.mdm.centrify.validator.CentroValidator;

@Controller
@SessionAttributes("direttore")
@Component
public class DirettoreController {

	@Autowired
	private DirettoreService direttoreService;

	@Autowired
	private CentroService centroService;
	
<<<<<<< HEAD
=======
	@Autowired
>>>>>>> Diego
	private CentroValidator centroValidator;

	@ModelAttribute("direttore")
	public Direttore getDirettore(Principal principal) {
		String oauthIdentifier = principal.getName();
		Direttore direttore = this.direttoreService.getByOauthIdentifier(oauthIdentifier);
		// System.out.println(oauthIdentifier);
		if (direttore != null) {
			return direttore;
		}
		return null;
	}

	@RequestMapping("/mainpage_d")
	public String mainPageDir(@ModelAttribute("direttore") Direttore direttore, Principal principal, Model model) {
		if (direttore == null) {
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
		if (direttore == null) {
			return "redirect:errore_dir.html";
		}
		return "aggiungi_centro";
	}

	@PostMapping("/submit_aggiungi_centro")
	public String submitAggiungiCentro(Principal principal, @ModelAttribute("direttore") Direttore direttore,
			@ModelAttribute Centro centro, BindingResult result, Model model) {

		if (direttore == null) {
			return "redirect:errore_dir.html";
		}

		direttore = this.getDirettore(principal);

		if (result.hasErrors()) {
			// System.out.println(result.getAllErrors().toString());
			// return "";
		}

		Azienda azienda = direttore.getAzienda();

		// if (azienda == null)
		// return "errore";
		//

		if (!centroValidator.validate(centro, model)) {
			return "aggiungi_centro";
		}
		return "redirect:/scheda_centro/" + centro.getId();
	}
}