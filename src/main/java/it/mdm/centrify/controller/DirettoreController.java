package it.mdm.centrify.controller;

import java.security.Principal;
import java.util.Set;

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

import it.mdm.centrify.model.Attivita;
import it.mdm.centrify.model.Azienda;
import it.mdm.centrify.model.Centro;
import it.mdm.centrify.model.Direttore;
import it.mdm.centrify.model.Responsabile;
import it.mdm.centrify.service.AziendaService;
import it.mdm.centrify.service.CentroService;
import it.mdm.centrify.service.DirettoreService;
import it.mdm.centrify.validator.CentroValidator;

@Controller
@SessionAttributes("direttore")
public class DirettoreController {

	@Autowired
	private DirettoreService direttoreService;

	@Autowired
	private CentroService centroService;

	@Autowired
	private CentroValidator centroValidator;

	private AziendaService aziendaService;

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

	@RequestMapping("/scheda_centro/{id}")
	public String schedaAttivita(@ModelAttribute("direttore") Direttore direttore, @PathVariable("id") Long id,
			Model model) {
		if (direttore == null) {
			return "redirect:errore_dir.html";
		}
		model.addAttribute("centro", this.centroService.getOne(id));
		return "template_centro";
	}

	@GetMapping("/aggiungi_centro")
	public ModelAndView aggiungiAttivita(@ModelAttribute("direttore") Direttore direttore) {
		if (direttore == null) {
			return new ModelAndView("redirect:errore_dir.html");
		}
		return new ModelAndView("aggiungi_centro", "centro", new Centro());
	}

	@PostMapping("submit_aggiungi_centro")
	public String submitAggiungiCentro(Principal principal, 
			@ModelAttribute("direttore") Direttore direttore, 
			@Valid @ModelAttribute Centro centro, 
			BindingResult result, 
			Model model) {
		
		if(direttore == null) {
			return "redirect:errore_dir.html";
		}
		
		direttore = this.getDirettore(principal);
		
		if (result.hasErrors()) {
			//System.out.println(result.getAllErrors().toString());
			//return "";
		}
		
		Azienda azienda = direttore.getAzienda();
		
//		if (centro == null) {
//			return "error";
//		}
		
		if(!centroValidator.validate(centro, model)) {
			return "aggiungi_centro";
		}
			
		azienda.addCentro(centro);;
		this.centroService.save(centro);
		Long id_centro = azienda.getCentroByNome(centro.getNome()).getId();
	
		return "redirect:/scheda_attivita/"+id_centro;
	}
}