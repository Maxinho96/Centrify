package it.mdm.centrify.validator;

import java.util.regex.Pattern;

import it.mdm.centrify.model.Allievo;

public class AllievoValidator {

	private final Allievo allievo;
	
	public AllievoValidator(Allievo allievo) {
		this.allievo = allievo;
	}
	
	public boolean isStringInvalid(String s) {
		return (s == null || s.isEmpty());
	}
	
	public boolean isStringAlphabetic(String s) {
		return Pattern.matches("^[a-zA-Z]+$", s);
	}
	
	public boolean isNomeValid() {
		boolean isValid = true;
		String nome = this.allievo.getNome();

		if(isStringInvalid(nome) || !isStringAlphabetic(nome))
			isValid = false;
		
		return isValid;
	}
	
	public boolean isCognomeValid() {
		boolean isValid = true;
		String cognome = this.allievo.getCognome();
		
		if(isStringInvalid(cognome) || !isStringAlphabetic(cognome))
			isValid = false;	
		
		return isValid;
	}

	public boolean isEmailValid() {
		boolean isValid = true;
		String email = this.allievo.getEmail();
		String pattern_email = "[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}";

		if(isStringInvalid(email) || !Pattern.matches(pattern_email,email))
			isValid = false;
		
		return isValid;
	}
	
	public boolean isCellulareValid() {
		boolean isValid = true;
		String cellulare = this.allievo.getCellulare();
		String pattern_cellulare = "^[0-9]{3} [0-9]{3} [0-9]{4}$";
		
		if(isStringInvalid(cellulare) || !Pattern.matches(pattern_cellulare, cellulare))
			isValid = false;
		
		return isValid;
	}
	
	public boolean isGiornoNascitaValid() {
		boolean isValid = true;
		int giorno = this.allievo.getGiorno_nascita();
		
		if(giorno == 0)
			isValid = false;
		
		return isValid;
	}
	
	public boolean isMeseNascitaValid() {
		boolean isValid = true;
		int mese = this.allievo.getMese_nascita();
		
		if(mese == 0)
			isValid = false;
		
		return isValid;
	}
	
	public boolean isAnnoNascitaValid() {
		boolean isValid = true;
		int anno = this.allievo.getAnno_nascita();
		
		if(anno == 0)
			isValid = false;
		
		return isValid;
	}
	
	public boolean isLuogoDiNascitaValid() {
		boolean isValid = true;
		String luogoDiNascita = this.allievo.getLuogoDiNascita();
		
		if(isStringInvalid(luogoDiNascita) || !isStringAlphabetic(luogoDiNascita))
			isValid = false;
		
		return isValid;
	}
	
}
