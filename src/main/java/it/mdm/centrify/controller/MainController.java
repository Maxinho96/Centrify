package it.mdm.centrify.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import it.mdm.centrify.model.Direttore;
import it.mdm.centrify.model.Responsabile;

@Controller
//@SessionAttributes({"responsabile", "direttore"})
public class MainController {
	
//	@Autowired
//	private ResponsabileService responsabileService;
//	
//	@Autowired
//	private DirettoreService direttoreService;
//	
//	@ModelAttribute("responsabile")
//    public Responsabile getResponsabile (Principal principal) {
//		String oauthIdentifier = principal.getName();
//		Responsabile responsabile = this.responsabileService.getByOauthIdentifier(oauthIdentifier);
//		// System.out.println(oauthIdentifier);
//		if(responsabile != null) {
//			return responsabile;
//		}
//		else {
//			return null;
//		}
//    }
//	
//	@ModelAttribute("direttore")
//    public Direttore getDirettore (Principal principal) {
//		String oauthIdentifier = principal.getName();
//		Direttore direttore = this.direttoreService.getByOauthIdentifier(oauthIdentifier);
//		// System.out.println(oauthIdentifier);
//		if(direttore != null) {
//			return direttore;
//		}
//		else {
//			return null;
//		}
//    }
	
//	@RequestMapping("/")
//	public String index(@ModelAttribute("responsabile") Responsabile responsabile,
//			@ModelAttribute("direttore") Direttore direttore) {
//		if(responsabile != null) {
//			return "redirect:mainpage_r";
//		}
//		else if(direttore != null){
//			return "redirect:mainpage_d";
//		}
//		else {
//			return "errore_reg"; // Implementare la pagina d'errore
//		}
//	}

}
