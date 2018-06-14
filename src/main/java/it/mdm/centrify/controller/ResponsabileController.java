package it.mdm.centrify.controller;

import java.security.Principal;
import java.util.Date;
import java.util.List;
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

import it.mdm.centrify.model.Allievo;
import it.mdm.centrify.model.Attivita;
import it.mdm.centrify.model.Azienda;
import it.mdm.centrify.model.Centro;
import it.mdm.centrify.model.Responsabile;
import it.mdm.centrify.service.AllievoService;
import it.mdm.centrify.service.AttivitaService;
import it.mdm.centrify.service.AziendaService;
import it.mdm.centrify.service.CentroService;
import it.mdm.centrify.service.ResponsabileService;
import it.mdm.centrify.validator.AllievoValidator;
import it.mdm.centrify.validator.AttivitaValidator;

@Controller
@SessionAttributes("responsabile")
public class ResponsabileController {

	@Autowired
	private AttivitaService attivitaService; 
	
	@Autowired
	private AziendaService aziendaService; 

	@Autowired
	private CentroService centroService;
	
	@Autowired
	private AllievoService allievoService;
	
	@Autowired
	private ResponsabileService responsabileService;
	
	@Autowired
	private AllievoValidator allievoValidator;
	
	@Autowired
	private AttivitaValidator attivitaValidator;
	
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
			Principal principal,
			@ModelAttribute("responsabile") Responsabile responsabile,
			@PathVariable("id") Long id,
			Model model) {
		if(responsabile == null) {
			return "errore_resp";
		}
		
		Allievo allievo = this.allievoService.getOne(id);
		model.addAttribute("allievo", allievo);
		
		Set<Attivita> attivitaCentro = this.getResponsabile(principal).getCentro().getAttivita();
		Set<Attivita> attivitaAllievo = allievo.getAttivita();
		
		for(Attivita a : attivitaCentro) {
			if(attivitaAllievo.contains(a))
				attivitaCentro.remove(a);
		}
	
		model.addAttribute("listAttivita", attivitaCentro);
		return "template_allievo";
	}
	
	@RequestMapping("/iscrivi_allievo")
	public String iscriviAllievo(
			Principal principal,
			@ModelAttribute("responsabile") Responsabile responsabile,
			@ModelAttribute("allievo") Allievo allievo,
			@ModelAttribute("attivitaDaAggiungere") Long id_attivitaDaAggiungere,
			Model model) {
		
		if(responsabile == null) {
			return "errore_resp";
		}
		
		System.out.println(id_attivitaDaAggiungere);
		
		//allievo.addAttivita(attivita_selezionata);
		//attivita_selezionata.addAllievo(allievo);
		//System.out.println(allievo.getId());
		
		return "redirect:/scheda_allievo/4"; //+ allievo.getId();
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
		//System.out.println(centro.getAttivita());
		return "mainpage_resp";
	}
	
	@RequestMapping("/submit_ricercaAllievo")
	public String submitRicercaAllievo(
			Principal principal,
			@ModelAttribute("responsabile") Responsabile responsabile,
			@ModelAttribute("stringa_ricerca") String stringa_ricerca,
			Model model) {
		if(responsabile == null) {
			return "errore_resp";
		}
		// responsabile = this.getResponsabile(principal);
		// model.addAttribute("responsabile", responsabile);
		Azienda azienda = responsabile.getCentro().getAzienda();
		System.out.println(stringa_ricerca);
		String[] splitted = stringa_ricerca.split("\\s+");
		if(splitted.length == 1)
			model.addAttribute("allievi", this.allievoService.getByAziendaAndNomeOrCognome(azienda.getId(), splitted[0], splitted[0]));
		else
			model.addAttribute("allievi", this.allievoService.getByAziendaAndNomeOrCognome(azienda.getId(), splitted[0], splitted[1]));
		return "template_risultatiRicercaAllievo";
	}

	@RequestMapping("/scheda_attivita/{id}")
	public String schedaAttivita(@ModelAttribute("responsabile") Responsabile responsabile, @PathVariable("id") Long id, Model model) {
		if(responsabile == null) {
			return "errore_resp";
		}
		model.addAttribute("attivita", this.attivitaService.getOne(id));
		return "template_attivita";
	}

	@GetMapping("/aggiungi_attivita")
	public ModelAndView aggiungiAttivita(@ModelAttribute("responsabile") Responsabile responsabile) {
		if(responsabile == null) {
			return new ModelAndView("errore_resp");
		}
		return new ModelAndView("aggiungi_attivita", "attivita", new Attivita());
	}
	
	@PostMapping("submit_aggiungi_attivita")
	public String submitAggiungiAttivita(Principal principal, 
			@ModelAttribute("responsabile") Responsabile responsabile, 
			@Valid @ModelAttribute Attivita attivita, 
			BindingResult result, 
			Model model) {
		
		if(responsabile == null) {
			return "errore_resp";
		}
		
		responsabile = this.getResponsabile(principal);
		
		if (result.hasErrors()) {
			//System.out.println(result.getAllErrors().toString());
			//return "";
		}
		
		Centro centro = responsabile.getCentro();
		
//		if (centro == null) {
//			return "error";
//		}
		
		if(!attivitaValidator.validate(attivita, model, centro)) {
			return "aggiungi_attivita";
		}
			
		centro.addAttivita(attivita);
		this.centroService.save(centro);
		Long id_attivita = centro.getAttivitaByNome(attivita.getNomeAttivita()).getId();
	
		return "redirect:/scheda_attivita/"+id_attivita;
	}
	
    @GetMapping("/aggiungi_allievo")
    public ModelAndView aggiungiAllievo(@ModelAttribute("responsabile") Responsabile responsabile) {
    	if(responsabile == null) {
    		return new ModelAndView("errore_resp");
    	}
        return new ModelAndView("aggiungi_allievo", "allievo", new Allievo());
    }
	
	@PostMapping("/submit_aggiungi_allievo")
	public String submitAggiungiAllievo(
			Principal principal,
			@ModelAttribute("responsabile") Responsabile responsabile, 
			@ModelAttribute Allievo allievo,
			BindingResult result,
			Model model) {
		
		if(responsabile == null) {
			return "errore_resp";
		}
		
		responsabile = this.getResponsabile(principal);
		
		if (result.hasErrors()) {
			//System.out.println(result.getAllErrors().toString());
			//return "";
		}
		
		Azienda azienda = responsabile.getCentro().getAzienda();
		
//		if (azienda == null) 
//			return "errore";
//		
		
		if(!allievoValidator.validate(allievo, model, azienda)) {
			return "aggiungi_allievo";
		}
		
		allievo.setDataDiIscrizione(new Date());

		azienda.addAllievo(allievo);			
		this.aziendaService.save(azienda);
		
		List<Allievo> allievi = azienda.getAllievi();
		Long id_allievo = allievi.get(allievi.size() - 1).getId();
		
		return "redirect:/scheda_allievo/"+id_allievo;				

	}
}
