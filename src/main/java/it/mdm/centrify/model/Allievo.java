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
public class Allievo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String cognome;
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String telefono;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataDiNascita;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataDiIscrizione;
	
	@Column(nullable = false)
	private String luogoDiNascita;
	
	@Column(nullable = false)
	private Character sesso;
	
	@ManyToMany(mappedBy = "allievi", fetch = FetchType.EAGER)
	private List<Attivita> attivita;
	
	public Allievo() {};

	public Allievo(String nome, String cognome, String email, String telefono, Date dataDiNascita,
			Date dataDiIscrizione, String luogoDiNascita, Character sesso) {
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.telefono = telefono;
		this.dataDiNascita = dataDiNascita;
		this.dataDiIscrizione = dataDiIscrizione;
		this.luogoDiNascita = luogoDiNascita;
		this.sesso = sesso;
		this.attivita = new ArrayList<Attivita>();
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

	public Date getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(Date dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	public String getLuogoDiNascita() {
		return luogoDiNascita;
	}

	public void setLuogoDiNascita(String luogoDiNascita) {
		this.luogoDiNascita = luogoDiNascita;
	}

	public List<Attivita> getAttivita() {
		return attivita;
	}

	public void setAttivita(List<Attivita> attivita) {
		this.attivita = attivita;
	}
	
	public void addAttivita(Attivita attivita) {
		this.attivita.add(attivita);
	}

	public Date getDataDiIscrizione() {
		return dataDiIscrizione;
	}

	public void setDataDiIscrizione(Date dataDiIscrizione) {
		this.dataDiIscrizione = dataDiIscrizione;
	}

	public Character getSesso() {
		return sesso;
	}

	public void setSesso(Character sesso) {
		this.sesso = sesso;
	}

}
