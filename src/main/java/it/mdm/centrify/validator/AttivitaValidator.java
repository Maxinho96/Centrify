package it.mdm.centrify.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import it.mdm.centrify.model.Attivita;
import it.mdm.centrify.model.Centro;

@Component
public class AttivitaValidator {

	public boolean validate(Attivita a, Model m, Centro c) {
		boolean valid=true;
		
		String nomeAttivita = a.getNomeAttivita();
		int giorno = a.getGiorno_svolgimento();
		int mese = a.getMese_svolgimento();
		int anno = a.getAnno_svolgimento();
		String ora = a.getOra_svolgimento();
		String minuto = a.getMinuto_svolgimento();
		String nomeProf = a.getNomeProfessore();
		String cognomeProf = a.getCognomeProfessore();
		String descrizione = a.getDescrizione();
		
		if(isStringInvalid(nomeAttivita)) {
			valid=false;
			m.addAttribute("errNomeAttivita","Campo obbligatorio");
			m.addAttribute("valid_nomeAttivita", "is-invalid");
		}
		
		if(giorno == 0) {
			valid = false;
			m.addAttribute("errGiorno","Campo obbligatorio");
			m.addAttribute("valid_giorno", "is-invalid");
		}
		else if(giorno < 0 || giorno > 31) {
			valid = false;
			m.addAttribute("errGiorno", "Compila correttamente");
			m.addAttribute("valid_giorno", "is-invalid");
		}
		
		if(mese == 0) {
			valid = false;
			m.addAttribute("errMese", "Campo obbligatorio");
			m.addAttribute("valid_mese", "is-invalid");
		}
		else if(mese < 0 || mese > 12) {
			valid = false;
			m.addAttribute("errMese", "Compila correttamente");
			m.addAttribute("valid_mese", "is-invalid");
		}
		
		if(anno == 0) {
			valid = false;
			m.addAttribute("errAnno", "Campo obbligatorio");
			m.addAttribute("valid_anno", "is-invalid");
		}
		
		if(isStringInvalid(ora)) {
			valid = false;
			m.addAttribute("errOra", "Campo obbligatorio");
			m.addAttribute("valid_ora", "is-invalid");
		}
		
		if(isStringInvalid(minuto)) {
			valid = false;
			m.addAttribute("errMinuto", "Campo obbligatorio");
			m.addAttribute("valid_minuto", "is-invalid");
		}
		
		if(isStringInvalid(nomeProf)) {
			valid=false;
			m.addAttribute("errNomeProf","Campo obbligatorio");
			m.addAttribute("valid_nomeProf", "is-invalid");
		}
		else if(!isStringAlphabetic(nomeProf)) {
			valid=false;
			m.addAttribute("errNomeProf","Inserisci solo lettere");
			m.addAttribute("valid_NomeProf", "is-invalid");			
		}
		
		if(isStringInvalid(cognomeProf)) {
			valid=false;
			m.addAttribute("errCognomeProf","Campo obbligatorio");
			m.addAttribute("valid_cognomeProf", "is-invalid");
		}
		else if(!isStringAlphabetic(cognomeProf)) {
			valid=false;
			m.addAttribute("errCognomeProf","Inserisci solo lettere");
			m.addAttribute("valid_cognomeProf", "is-invalid");			
		}
		
		if(isStringInvalid(descrizione)) {
			valid=false;
			m.addAttribute("errDescrizione","Campo obbligatorio");
			m.addAttribute("valid_descrizione", "is-invalid");
		}
		
		if(c.containsAttivitaWithName(nomeAttivita)) {
			valid=false;
			m.addAttribute("valid_nomeAttivita", "is-invalid");
			m.addAttribute("errNomeAttivita", "Attività gia esistente");
		}
		
		return valid;
	}
	
	public boolean isStringInvalid(String s) {
		return (s == null || s.isEmpty());
	}
	
	public boolean isStringAlphabetic(String s) {
		return Pattern.matches("^[a-zA-Z]+$", s);
	}	
}
