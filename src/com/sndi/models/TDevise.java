package com.sndi.models;
// Generated 23 mars 2020 10:48:44 by Hibernate Tools 4.3.5.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TDevise generated by hbm2java
 */
@Entity
@Table(name = "T_DEVISE", schema = "EMAP")
public class TDevise implements java.io.Serializable {

	private String devCode;
	private String devLibelle;
	private String devSymbole;
	private Set<TAffichageAgpm> TAffichageAgpms = new HashSet<TAffichageAgpm>(0);
	private Set<TFinancementPgpm> TFinancementPgpms = new HashSet<TFinancementPgpm>(0);
	private Set<TFinancement> TFinancements = new HashSet<TFinancement>(0);
	private Set<TFinancementPpm> TFinancementPpms = new HashSet<TFinancementPpm>(0);

	public TDevise() {
	}

	public TDevise(String devCode) {
		this.devCode = devCode;
	}

	public TDevise(String devCode, String devLibelle, String devSymbole, Set<TAffichageAgpm> TAffichageAgpms,
			Set<TFinancementPgpm> TFinancementPgpms, Set<TFinancement> TFinancements,
			Set<TFinancementPpm> TFinancementPpms) {
		this.devCode = devCode;
		this.devLibelle = devLibelle;
		this.devSymbole = devSymbole;
		this.TAffichageAgpms = TAffichageAgpms;
		this.TFinancementPgpms = TFinancementPgpms;
		this.TFinancements = TFinancements;
		this.TFinancementPpms = TFinancementPpms;
	}

	@Id

	@Column(name = "DEV_CODE", unique = true, nullable = false, length = 8)
	public String getDevCode() {
		return this.devCode;
	}

	public void setDevCode(String devCode) {
		this.devCode = devCode;
	}

	@Column(name = "DEV_LIBELLE", length = 500)
	public String getDevLibelle() {
		return this.devLibelle;
	}

	public void setDevLibelle(String devLibelle) {
		this.devLibelle = devLibelle;
	}

	@Column(name = "DEV_SYMBOLE", length = 500)
	public String getDevSymbole() {
		return this.devSymbole;
	}

	public void setDevSymbole(String devSymbole) {
		this.devSymbole = devSymbole;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TDevise")
	public Set<TAffichageAgpm> getTAffichageAgpms() {
		return this.TAffichageAgpms;
	}

	public void setTAffichageAgpms(Set<TAffichageAgpm> TAffichageAgpms) {
		this.TAffichageAgpms = TAffichageAgpms;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TDevise")
	public Set<TFinancementPgpm> getTFinancementPgpms() {
		return this.TFinancementPgpms;
	}

	public void setTFinancementPgpms(Set<TFinancementPgpm> TFinancementPgpms) {
		this.TFinancementPgpms = TFinancementPgpms;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TDevise")
	public Set<TFinancement> getTFinancements() {
		return this.TFinancements;
	}

	public void setTFinancements(Set<TFinancement> TFinancements) {
		this.TFinancements = TFinancements;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TDevise")
	public Set<TFinancementPpm> getTFinancementPpms() {
		return this.TFinancementPpms;
	}

	public void setTFinancementPpms(Set<TFinancementPpm> TFinancementPpms) {
		this.TFinancementPpms = TFinancementPpms;
	}

}
