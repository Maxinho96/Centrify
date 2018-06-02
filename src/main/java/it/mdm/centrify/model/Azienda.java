package it.mdm.centrify.model;

import java.util.List;

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

@Entity
public class Azienda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String indirizzo;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "azienda_id")
	private List<Allievo> allievi;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "azienda_id")
	private List<Centro> centri;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Direttore direttore;

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

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public List<Allievo> getAllievi() {
		return allievi;
	}

	public void setAllievi(List<Allievo> allievi) {
		this.allievi = allievi;
	}

	public List<Centro> getCentri() {
		return centri;
	}

	public void setCentri(List<Centro> centri) {
		this.centri = centri;
	}

	public Direttore getDirettore() {
		return direttore;
	}

	public void setDirettore(Direttore direttore) {
		this.direttore = direttore;
	}

}
