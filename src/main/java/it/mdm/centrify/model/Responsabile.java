package it.mdm.centrify.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Responsabile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String nomeUtente;

	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String cognome;
	
	@Column(nullable = false)
	private Float stipendio;
	
	public Responsabile() {};

	public Responsabile(String nomeUtente, String password, String nome, String cognome, Float stipendio) {
		this.nomeUtente = nomeUtente;
		this.password = password;
		this.nome = nome;
		this.cognome = cognome;
		this.stipendio = stipendio;
	}

	public Long getId() {
		return id;
	}

	public String getNomeUtente() {
		return nomeUtente;
	}

	public void setNomeUtente(String nomeUtente) {
		this.nomeUtente = nomeUtente;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public Float getStipendio() {
		return stipendio;
	}

	public void setStipendio(Float stipendio) {
		this.stipendio = stipendio;
	}

}
