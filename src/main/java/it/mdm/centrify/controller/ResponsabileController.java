package it.mdm.centrify.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import it.mdm.centrify.model.Allievo;
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

//	@RequestMapping("/aggiungi_allievo")
//	public String aggiungiAllievo() {
//		return "aggiungi_allievo";
//	}

	@RequestMapping("/mainpage")
	public String mainPageResp(Model model) {
		model.addAttribute("attivita", this.attivitaService.getAllByCentro(6l));
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

	
    @RequestMapping(value = "/aggiungi_allievo", method = RequestMethod.GET)
    public ModelAndView showForm() {
        return new ModelAndView("aggiungi_allievo", "allievo", new Allievo());
    }
	
	@RequestMapping(value = "/submit_aggiungi_allievo", method = RequestMethod.POST)
	public String submitAggiungiAllievo(@Valid @ModelAttribute Allievo allievo, BindingResult result) {
		if (result.hasErrors()) {
			return "aggiungi_allievo";
		}
		System.out.println(allievo.getCognome()); 
		System.out.println(allievo.getDataDiNascita().toString());
		System.out.println(allievo.getEmail());
		return "mainpage_resp";//provvisorio
	}

	//	@RequestMapping("/logout")
	//	public String logout() {
	//		return "index";
	//	}
}
