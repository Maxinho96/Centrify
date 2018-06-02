package it.mdm.centrify.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Attivita {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataOraSvolgimento;

	private String professore;

	private String descrizione;

	@ManyToMany(fetch = FetchType.EAGER)
	private List<Allievo> allievi;

	public Attivita() {};
	
	public Attivita(String nome, Date dataOraSvolgimento, String professore, String descrizione) {
		this.nome = nome;
		this.dataOraSvolgimento = dataOraSvolgimento;
		this.professore = professore;
		this.allievi = new ArrayList<Allievo>();
		this.descrizione = descrizione;
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

	public String getProfessore() {
		return professore;
	}

	public void setProfessore(String professore) {
		this.professore = professore;
	}

	public List<Allievo> getAllievi() {
		return allievi;
	}

	public void setAllievi(List<Allievo> allievi) {
		this.allievi = allievi;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
}
