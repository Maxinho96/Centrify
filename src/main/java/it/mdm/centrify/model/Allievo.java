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
	
	//li ho messi per matchare con gli attributi della jsp al posto di dataNascita
	@Column(nullable = false)
	private int giorno_nascita;
	
	@Column(nullable = false)
	private int mese_nascita;
	
	@Column(nullable = false)
	private int anno_nascita;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataDiIscrizione;
	
	@Column(nullable = false)
	private String luogoDiNascita;
	
	@Column(nullable = false)
	private Character sesso;
	
	@ManyToMany(mappedBy = "allievi", fetch = FetchType.EAGER)
	@OrderBy("nomeAttivita")
	private Set<Attivita> attivita;
	
	public Allievo() {};

	public Allievo(String nome, String cognome, String email, String cellulare, int anno_nascita, int mese_nascita, int giorno_nascita,
			Date dataDiIscrizione, String luogoDiNascita, Character sesso) {
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.cellulare = cellulare;
		this.giorno_nascita = giorno_nascita;
		this.mese_nascita = mese_nascita;
		this.anno_nascita = anno_nascita;
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

	public int getGiorno_nascita() {
		return giorno_nascita;
	}

	public void setGiorno_nascita(int giorno_nascita) {
		this.giorno_nascita = giorno_nascita;
	}

	public int getMese_nascita() {
		return mese_nascita;
	}

	public void setMese_nascita(int mese_nascita) {
		this.mese_nascita = mese_nascita;
	}

	public int getAnno_nascita() {
		return anno_nascita;
	}

	public void setAnno_nascita(int anno_nascita) {
		this.anno_nascita = anno_nascita;
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

	@Override
	public String toString() {
		return "Allievo [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", email=" + email + ", cellulare="
				+ cellulare + ", giorno_nascita=" + giorno_nascita
				+ ", mese_nascita=" + mese_nascita + ", anno_nascita=" + anno_nascita + ", dataDiIscrizione="
				+ dataDiIscrizione + ", luogoDiNascita=" + luogoDiNascita + ", sesso=" + sesso + ", attivita="
				+ attivita + "]";
	}
}
