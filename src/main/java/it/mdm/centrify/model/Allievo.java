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
public class Allievo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String cognome;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	@Column(nullable = false)
	private String cellulare;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataDiNascita;
	
	//inutilizzati, li ho messi per matchare con gli attributi della jsp
	private int giorno_nascita;
	private int mese_nascita;
	private int anno_nascita;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataDiIscrizione;
	
	@Column(nullable = false)
	private String luogoDiNascita;
	
	@Column(nullable = false)
	private Character sesso;
	
	@ManyToMany(mappedBy = "allievi", fetch = FetchType.EAGER)
	@OrderBy("nome")
	private Set<Attivita> attivita;
	
	public Allievo() {};

	public Allievo(String nome, String cognome, String email, String cellulare, Date dataDiNascita,
			Date dataDiIscrizione, String luogoDiNascita, Character sesso) {
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.cellulare = cellulare;
		this.dataDiNascita = dataDiNascita;
		this.dataDiIscrizione = dataDiIscrizione;
		this.luogoDiNascita = luogoDiNascita;
		this.sesso = sesso;
		this.attivita = new HashSet<Attivita>();
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

	public String getCellulare() {
		return cellulare;
	}

	public void setCellulare(String cellulare) {
		this.cellulare = cellulare;
	}

	public Date getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(Date dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}
	
	public int getGiornoNascita() {
		return dataDiNascita.getDay();
	}
	
	public void setGiornoNascita(int giorno) {
		this.dataDiNascita.setDate(giorno);
	}
	
	public int getMeseNascita() {
		return dataDiNascita.getMonth();
	}
	
	public void setMeseNascita(int mese) {
		this.dataDiNascita.setMonth(mese);
	}
	
	public int getAnnoNascita() {
		return dataDiNascita.getYear();
	}
	
	public void setAnnoNascita(int anno) {
		this.dataDiNascita.setYear(anno);
	}
	
	public String getLuogoDiNascita() {
		return luogoDiNascita;
	}

	public void setLuogoDiNascita(String luogoDiNascita) {
		this.luogoDiNascita = luogoDiNascita;
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
