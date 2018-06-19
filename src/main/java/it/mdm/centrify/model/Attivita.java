package it.mdm.centrify.model;

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
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Table(uniqueConstraints=@UniqueConstraint(columnNames={"nomeAttivita", "centro_id"}))
@Entity 
public class Attivita {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String nomeAttivita;

	//li ho messi per matchare con gli attributi della jsp al posto di dataSvolgimento
	@Column(nullable = false)
	private int giorno_svolgimento;
	
	@Column(nullable = false)
	private int mese_svolgimento;
	
	@Column(nullable = false)
	private int anno_svolgimento;
	
	@Column(nullable = false)
	private String ora_svolgimento;
	
	@Column(nullable = false)
	private String minuto_svolgimento;
	
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
	
	public Attivita(String nomeAttivita, String nomeProfessore, String cognomeProfessore, 
			String descrizione, int giornoSvolgimento, int meseSvolgimento, int annoSvolgimento, String oraSvolgimento, String minutoSvolgimento) {
		this.nomeAttivita = nomeAttivita;
		this.nomeProfessore = nomeProfessore;
		this.cognomeProfessore = cognomeProfessore;
		this.descrizione = descrizione;
		this.giorno_svolgimento = giornoSvolgimento;
		this.mese_svolgimento = meseSvolgimento;
		this.anno_svolgimento = annoSvolgimento;
		this.ora_svolgimento = oraSvolgimento;
		this.minuto_svolgimento = minutoSvolgimento;
		this.allievi = new HashSet<Allievo>();
	}

	public Long getId() {
		return id;
	}

	public String getNomeAttivita() {
		return nomeAttivita;
	}

	public void setNomeAttivita(String nomeAttivita) {
		this.nomeAttivita = nomeAttivita;
	}

	public int getGiorno_svolgimento() {
		return giorno_svolgimento;
	}

	public void setGiorno_svolgimento(int giorno_svolgimento) {
		this.giorno_svolgimento = giorno_svolgimento;
	}

	public int getMese_svolgimento() {
		return mese_svolgimento;
	}

	public void setMese_svolgimento(int mese_svolgimento) {
		this.mese_svolgimento = mese_svolgimento;
	}

	public int getAnno_svolgimento() {
		return anno_svolgimento;
	}

	public void setAnno_svolgimento(int anno_svolgimento) {
		this.anno_svolgimento = anno_svolgimento;
	}

	public String getOra_svolgimento() {
		return ora_svolgimento;
	}

	public void setOra_svolgimento(String ora_svolgimento) {
		this.ora_svolgimento = ora_svolgimento;
	}

	public String getMinuto_svolgimento() {
		return minuto_svolgimento;
	}

	public void setMinuto_svolgimento(String minuto_svolgimento) {
		this.minuto_svolgimento = minuto_svolgimento;
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
