package it.mdm.centrify.validator;

import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

import java.util.regex.Pattern;

import it.mdm.centrify.model.Attivita;

public class AttivitaValidator {

	private final Attivita attivita;
	
	public AttivitaValidator(Attivita attivita) {
		this.attivita = attivita;
	}
	
	public boolean isStringInvalid(String s) {
		return (s == null || s.isEmpty());
	}
	
	public boolean isStringAlphabetic(String s) {
		return Pattern.matches("^[a-zA-Z]+$", s);
	}
	
	public boolean isNomeValid() {
		boolean isValid = true;
		String nome = this.attivita.getNomeAttivita();
		
		if(isStringInvalid(nome) || !isStringAlphabetic(nome))
			isValid = false;
		
		return isValid;
	}
	
	public boolean isGiornoSvolgimentoValid() {
		boolean isValid = true;
		int giorno = this.attivita.getGiorno_svolgimento();
		
		if(giorno == 0)
			isValid = false;
		
		return isValid;
	}
	
	public boolean isMeseSvolgimentoValid() {
		boolean isValid = true;
		int mese = this.attivita.getMese_svolgimento();
		
		if(mese == 0)
			isValid = false;
		
		return isValid;
	}
	
	public boolean isAnnoSvolgimentoValid() {
		boolean isValid = true;
		int anno = this.attivita.getAnno_svolgimento();
		
		if(anno == 0)
			isValid = false;
		
		return isValid;
	}
	
	public boolean isOraSvolgimentoValid() {
		boolean isValid = true;
		String ora = this.attivita.getOra_svolgimento();
		
		if(isStringInvalid(ora))
			isValid = false;
		
		return isValid;
	}
	
	public boolean isMinutoSvolgimentoValid() {
		boolean isValid = true;
		String minuto = this.attivita.getMinuto_svolgimento();
		
		if(isStringInvalid(minuto))
			isValid = false;
		
		return isValid;
	}
	
	public boolean isNomeProfessoreValid() {
		boolean isValid = true;
		String nome_professore = this.attivita.getNomeProfessore();
		
		if(isStringInvalid(nome_professore) || !isStringAlphabetic(nome_professore))
			isValid = false;
		
		return isValid;
	}
	
	public boolean isCognomeProfessoreValid() {
		boolean isValid = true;
		String cognome_professore = this.attivita.getCognomeProfessore();
		
		if(isStringInvalid(cognome_professore) || !isStringAlphabetic(cognome_professore))
			isValid = false;
		
		return isValid;
	}
	
	public boolean isDescrizioneValid() {
		boolean isValid = true;
		String descrizione = this.attivita.getDescrizione();
		
		if(isStringInvalid(descrizione))
			isValid = false;
		
		return isValid;
	}
	
	
}
