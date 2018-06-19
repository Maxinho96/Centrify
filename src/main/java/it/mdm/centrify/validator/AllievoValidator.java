package it.mdm.centrify.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import it.mdm.centrify.model.Allievo;
import it.mdm.centrify.model.Azienda;

@Component
public class AllievoValidator {

	public boolean validate(Allievo allievo, Model m, Azienda azienda) {

		boolean valid = true;

		String nome = allievo.getNome();
		String cognome = allievo.getCognome();
		String email = allievo.getEmail();
		String cellulare = allievo.getCellulare();
		int giorno = allievo.getGiorno_nascita();
		int mese = allievo.getMese_nascita();
		int anno = allievo.getAnno_nascita();
		String luogoDiNascita = allievo.getLuogoDiNascita();

		String pattern_email = "[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}";
		String pattern_cellulare = "^[0-9]{3} [0-9]{3} [0-9]{4}$";

		if (isStringInvalid(nome)) {
			valid = false;
			m.addAttribute("errNome", "Campo obbligatorio");
			m.addAttribute("valid_nome", "is-invalid");
		} else if (!isStringAlphabetic(nome)) {
			valid = false;
			m.addAttribute("errNome", "Inserisci solo lettere");
			m.addAttribute("valid_nome", "is-invalid");
		}

		if (isStringInvalid(cognome)) {
			valid = false;
			m.addAttribute("errCognome", "Campo obbligatorio");
			m.addAttribute("valid_cognome", "is-invalid");
		} else if (!isStringAlphabetic(cognome)) {
			valid = false;
			m.addAttribute("errCognome", "Inserisci solo lettere");
			m.addAttribute("valid_cognome", "is-invalid");
		}

		if (isStringInvalid(email)) {
			valid = false;
			m.addAttribute("errEmail", "Campo obbligatorio");
			m.addAttribute("valid_email", "is-invalid");
		} else if (!email.matches(pattern_email)) {
			valid = false;
			m.addAttribute("errEmail", "Compila correttamente");
			m.addAttribute("valid_email", "is-invalid");
		}

		if (isStringInvalid(cellulare)) {
			valid = false;
			m.addAttribute("errCellulare", "Campo obbligatorio");
			m.addAttribute("valid_cellulare", "is-invalid");
		} else if (!cellulare.matches(pattern_cellulare)) {
			valid = false;
			m.addAttribute("errCellulare", "Compila correttamente");
			m.addAttribute("valid_cellulare", "is-invalid");
		}

		if (giorno == 0) {
			valid = false;
			m.addAttribute("errGiorno", "Campo obbligatorio");
			m.addAttribute("valid_giorno", "is-invalid");
		} else if (giorno < 0 || giorno > 31) {
			valid = false;
			m.addAttribute("errGiorno", "Compila correttamente");
			m.addAttribute("valid_giorno", "is-invalid");
		}

		if (mese == 0) {
			valid = false;
			m.addAttribute("errMese", "Campo obbligatorio");
			m.addAttribute("valid_mese", "is-invalid");
		} else if (mese < 0 || mese > 12) {
			valid = false;
			m.addAttribute("errMese", "Compila correttamente");
			m.addAttribute("valid_mese", "is-invalid");
		}

		if (anno == 0) {
			valid = false;
			m.addAttribute("errAnno", "Campo obbligatorio");
			m.addAttribute("valid_anno", "is-invalid");
		}

		if (isStringInvalid(luogoDiNascita)) {
			valid = false;
			m.addAttribute("errLuogo", "Campo obbligatorio");
			m.addAttribute("valid_luogo", "is-invalid");
		} else if (!isStringAlphabetic(luogoDiNascita)) {
			valid = false;
			m.addAttribute("errLuogo", "Inserisci solo lettere");
			m.addAttribute("valid_luogo", "is-invalid");
		}

		if (azienda.containsAllievoWithEmail(allievo.getEmail())) {
			valid = false;
			m.addAttribute("valid_email", "is-invalid");
			m.addAttribute("errEmail", "Email già registrata");
		}

		return valid;
	}

	private boolean isStringInvalid(String s) {
		return (s == null || s.isEmpty());
	}

	private boolean isStringAlphabetic(String s) {
		return Pattern.matches("^[a-zA-Z]+$", s);
	}
}
