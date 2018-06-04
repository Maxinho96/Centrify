package it.mdm.centrify.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Attivita {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false, unique = true)
	private String nome;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataOraSvolgimento;
	
	@Column(nullable = false)
	private String nomeProfessore;
	
	@Column(nullable = false)
	private String cognomeProfessore;

	@Column(nullable = false)
	private String descrizione;

	@ManyToMany(fetch = FetchType.EAGER)
	@OrderBy("email")
	private Set<Allievo> allievi;

	public Attivita() {};
	
	public Attivita(String nome, Date dataOraSvolgimento, String nomeProfessore, String cognomeProfessore, String descrizione) {
		this.nome = nome;
		this.dataOraSvolgimento = dataOraSvolgimento;
		this.nomeProfessore = nomeProfessore;
		this.cognomeProfessore = cognomeProfessore;
		this.descrizione = descrizione;
		this.allievi = new HashSet<Allievo>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataOraSvolgimento() {
		return dataOraSvolgimento;
	}

	public void setDataOraSvolgimento(Date dataOraSvolgimento) {
		this.dataOraSvolgimento = dataOraSvolgimento;
	}

	public String getNomeProfessore() {
		return nomeProfessore;
	}

	public void setNomeProfessore(String nomeProfessore) {
		this.nomeProfessore = nomeProfessore;
	}

	public String getCognomeProfessore() {
		return cognomeProfessore;
	}

	public void setCognomeProfessore(String cognomeProfessore) {
		this.cognomeProfessore = cognomeProfessore;
	}

	public Set<Allievo> getAllievi() {
		return allievi;
	}

	public void setAllievi(Set<Allievo> allievi) {
		this.allievi = allievi;
	}
	
	public void addAllievo(Allievo allievo) {
		this.allievi.add(allievo);
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
}
