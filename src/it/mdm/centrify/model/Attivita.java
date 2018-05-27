package it.mdm.centrify.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Attivita {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private Date dataOraSvolgimento;
	
	private String professore;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Allievo> allievi;

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

}
