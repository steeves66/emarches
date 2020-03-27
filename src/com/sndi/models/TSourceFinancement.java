package com.sndi.models;
// Generated 27 mars 2020 12:01:30 by Hibernate Tools 4.3.5.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TSourceFinancement generated by hbm2java
 */
@Entity
@Table(name = "T_SOURCE_FINANCEMENT", schema = "EMAP")
public class TSourceFinancement implements java.io.Serializable {

	private String souCode;
	private String souLibelle;
	private Set<TFinancementPpm> TFinancementPpms = new HashSet<TFinancementPpm>(0);
	private Set<TAffichageAgpm> TAffichageAgpms = new HashSet<TAffichageAgpm>(0);
	private Set<TAffichagePgpm> TAffichagePgpms = new HashSet<TAffichagePgpm>(0);
	private Set<TFinancement> TFinancements = new HashSet<TFinancement>(0);
	private Set<TFinancementPgpm> TFinancementPgpms = new HashSet<TFinancementPgpm>(0);

	public TSourceFinancement() {
	}

	public TSourceFinancement(String souCode) {
		this.souCode = souCode;
	}

	public TSourceFinancement(String souCode, String souLibelle, Set<TFinancementPpm> TFinancementPpms,
			Set<TAffichageAgpm> TAffichageAgpms, Set<TAffichagePgpm> TAffichagePgpms, Set<TFinancement> TFinancements,
			Set<TFinancementPgpm> TFinancementPgpms) {
		this.souCode = souCode;
		this.souLibelle = souLibelle;
		this.TFinancementPpms = TFinancementPpms;
		this.TAffichageAgpms = TAffichageAgpms;
		this.TAffichagePgpms = TAffichagePgpms;
		this.TFinancements = TFinancements;
		this.TFinancementPgpms = TFinancementPgpms;
	}

	@Id

	@Column(name = "SOU_CODE", unique = true, nullable = false, length = 5)
	public String getSouCode() {
		return this.souCode;
	}

	public void setSouCode(String souCode) {
		this.souCode = souCode;
	}

	@Column(name = "SOU_LIBELLE", length = 500)
	public String getSouLibelle() {
		return this.souLibelle;
	}

	public void setSouLibelle(String souLibelle) {
		this.souLibelle = souLibelle;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TSourceFinancement")
	public Set<TFinancementPpm> getTFinancementPpms() {
		return this.TFinancementPpms;
	}

	public void setTFinancementPpms(Set<TFinancementPpm> TFinancementPpms) {
		this.TFinancementPpms = TFinancementPpms;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TSourceFinancement")
	public Set<TAffichageAgpm> getTAffichageAgpms() {
		return this.TAffichageAgpms;
	}

	public void setTAffichageAgpms(Set<TAffichageAgpm> TAffichageAgpms) {
		this.TAffichageAgpms = TAffichageAgpms;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TSourceFinancement")
	public Set<TAffichagePgpm> getTAffichagePgpms() {
		return this.TAffichagePgpms;
	}

	public void setTAffichagePgpms(Set<TAffichagePgpm> TAffichagePgpms) {
		this.TAffichagePgpms = TAffichagePgpms;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TSourceFinancement")
	public Set<TFinancement> getTFinancements() {
		return this.TFinancements;
	}

	public void setTFinancements(Set<TFinancement> TFinancements) {
		this.TFinancements = TFinancements;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TSourceFinancement")
	public Set<TFinancementPgpm> getTFinancementPgpms() {
		return this.TFinancementPgpms;
	}

	public void setTFinancementPgpms(Set<TFinancementPgpm> TFinancementPgpms) {
		this.TFinancementPgpms = TFinancementPgpms;
	}

}
