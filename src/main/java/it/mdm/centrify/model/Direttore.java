package it.mdm.centrify.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Direttore {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String cognome;
	
	@Column(nullable = false, unique = true)
	private String oauthIdentifier;
	
	public Direttore() {};

	public Direttore(String nome, String cognome, String oauthIdentifier) {
		this.nome = nome;
		this.cognome = cognome;
		this.oauthIdentifier = oauthIdentifier;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getOauthIdentifier() {
		return oauthIdentifier;
	}

	public void setOauthIdentifier(String oauthIdentifier) {
		this.oauthIdentifier = oauthIdentifier;
	}

}
