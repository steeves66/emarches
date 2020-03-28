package com.sndi.models;
// Generated 28 mars 2020 03:24:07 by Hibernate Tools 4.3.5.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TBailleur generated by hbm2java
 */
@Entity
@Table(name = "T_BAILLEUR", schema = "EMAP")
public class TBailleur implements java.io.Serializable {

	private String baiCode;
	private String baiLibelle;
	private String baiAdresse;
	private String baiTelephone;
	private Set<TFinancement> TFinancements = new HashSet<TFinancement>(0);
	private Set<TFinancementPpm> TFinancementPpms = new HashSet<TFinancementPpm>(0);
	private Set<TFinancementPgpm> TFinancementPgpms = new HashSet<TFinancementPgpm>(0);
	private Set<TAffichageAgpm> TAffichageAgpms = new HashSet<TAffichageAgpm>(0);

	public TBailleur() {
	}

	public TBailleur(String baiCode, String baiLibelle) {
		this.baiCode = baiCode;
		this.baiLibelle = baiLibelle;
	}

	public TBailleur(String baiCode, String baiLibelle, String baiAdresse, String baiTelephone,
			Set<TFinancement> TFinancements, Set<TFinancementPpm> TFinancementPpms,
			Set<TFinancementPgpm> TFinancementPgpms, Set<TAffichageAgpm> TAffichageAgpms) {
		this.baiCode = baiCode;
		this.baiLibelle = baiLibelle;
		this.baiAdresse = baiAdresse;
		this.baiTelephone = baiTelephone;
		this.TFinancements = TFinancements;
		this.TFinancementPpms = TFinancementPpms;
		this.TFinancementPgpms = TFinancementPgpms;
		this.TAffichageAgpms = TAffichageAgpms;
	}

	@Id

	@Column(name = "BAI_CODE", unique = true, nullable = false, length = 5)
	public String getBaiCode() {
		return this.baiCode;
	}

	public void setBaiCode(String baiCode) {
		this.baiCode = baiCode;
	}

	@Column(name = "BAI_LIBELLE", nullable = false, length = 1000)
	public String getBaiLibelle() {
		return this.baiLibelle;
	}

	public void setBaiLibelle(String baiLibelle) {
		this.baiLibelle = baiLibelle;
	}

	@Column(name = "BAI_ADRESSE", length = 500)
	public String getBaiAdresse() {
		return this.baiAdresse;
	}

	public void setBaiAdresse(String baiAdresse) {
		this.baiAdresse = baiAdresse;
	}

	@Column(name = "BAI_TELEPHONE", length = 500)
	public String getBaiTelephone() {
		return this.baiTelephone;
	}

	public void setBaiTelephone(String baiTelephone) {
		this.baiTelephone = baiTelephone;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TBailleur")
	public Set<TFinancement> getTFinancements() {
		return this.TFinancements;
	}

	public void setTFinancements(Set<TFinancement> TFinancements) {
		this.TFinancements = TFinancements;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TBailleur")
	public Set<TFinancementPpm> getTFinancementPpms() {
		return this.TFinancementPpms;
	}

	public void setTFinancementPpms(Set<TFinancementPpm> TFinancementPpms) {
		this.TFinancementPpms = TFinancementPpms;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TBailleur")
	public Set<TFinancementPgpm> getTFinancementPgpms() {
		return this.TFinancementPgpms;
	}

	public void setTFinancementPgpms(Set<TFinancementPgpm> TFinancementPgpms) {
		this.TFinancementPgpms = TFinancementPgpms;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TBailleur")
	public Set<TAffichageAgpm> getTAffichageAgpms() {
		return this.TAffichageAgpms;
	}

	public void setTAffichageAgpms(Set<TAffichageAgpm> TAffichageAgpms) {
		this.TAffichageAgpms = TAffichageAgpms;
	}

}
