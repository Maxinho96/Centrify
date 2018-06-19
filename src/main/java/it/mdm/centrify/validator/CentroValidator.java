package it.mdm.centrify.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import it.mdm.centrify.model.Azienda;
import it.mdm.centrify.model.Centro;

@Component
public class CentroValidator {
	public boolean validate(Centro c, Model m, Azienda a) {
		boolean valid = true;

		String nome = c.getNome();
		String indirizzo = c.getIndirizzo();
		String email = c.getEmail();
		String telefono = c.getTelefono();
		String descrizione = c.getDescrizione();
		Integer capienza = c.getCapienza();

		nome.trim();
		indirizzo.trim();
		email.trim();

		if (isStringInvalid(nome)) {
			valid = false;
			m.addAttribute("errNome", "Campo obbligatorio");
			m.addAttribute("valid_nome", "is-invalid");

		} else if (!isStringAlphabetic(nome)) {
			valid = false;
			m.addAttribute("errNome", "Inserisci solo lettere");
			m.addAttribute("valid_nome", "is-invalid");
		}

		if (isStringInvalid(indirizzo)) {
			valid = false;
			m.addAttribute("errIndirizzo", "Campo obbligatorio");
			m.addAttribute("valid_indirizzo", "is-invalid");
		}

		if (isStringInvalid(email)) {
			valid = false;
			m.addAttribute("errEmail", "Campo obbligatorio");
			m.addAttribute("valid_email", "is-invalid");

		}

		if (capienza == null) {
			valid = false;
			m.addAttribute("errCapienza", "Campo obbligatorio");
			m.addAttribute("valid_capienza", "is-invalid");

			if (isStringInvalid(telefono)) {
				valid = false;
				m.addAttribute("errTelefono", "Campo obbligatorio");
				m.addAttribute("valid_telefono", "is-invalid");
			}

			if (isStringInvalid(descrizione)) {
				valid = false;
				m.addAttribute("errDescrizione", "Campo obbligatorio");
				m.addAttribute("valid_descrizione", "is-invalid");
			}

			if (a.containsCentroWithName(nome)) {
				valid = false;
				m.addAttribute("valid_nome", "is-invalid");
				m.addAttribute("errNome", "Centro gia esistente");
			}

			if (a.containsCentroWithEmail(email)) {
				valid = false;
				m.addAttribute("valid_email", "is-invalid");
				m.addAttribute("errEmail", "Centro gia esistente");
			}
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
