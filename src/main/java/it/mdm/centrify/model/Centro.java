package it.mdm.centrify.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;

@Entity
public class Centro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false, unique = true)
	private String nome;
	
	@Column(nullable = false)
	private String indirizzo;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	@Column(nullable = false)
	private String telefono;
	
	@Column(nullable = false)
	private Integer capienza;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Responsabile responsabile;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "centro_id")
	@OrderBy("nome")
	private Set<Attivita> attivita;
	
	public Centro() {};

	public Centro(String nome, String indirizzo, String email, String telefono, Integer capienza) {
		this.nome = nome;
		this.indirizzo = indirizzo;
		this.email = email;
		this.telefono = telefono;
		this.capienza = capienza;
		this.attivita = new HashSet<Attivita>();
		System.out.println();
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

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Integer getCapienza() {
		return capienza;
	}

	public void setCapienza(Integer capienza) {
		this.capienza = capienza;
	}

	public Responsabile getResponsabile() {
		return responsabile;
	}

	public void setResponsabile(Responsabile responsabile) {
		this.responsabile = responsabile;
	}

	public Set<Attivita> getAttivita() {
		return attivita;
	}

	public void setAttivita(Set<Attivita> attivita) {
		this.attivita = attivita;
	}
	
	public void addAttivita(Attivita attivita) {
		this.attivita.add(attivita);
	}
	
}
