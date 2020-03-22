package com.sndi.models;
// Generated 22 mars 2020 01:52:15 by Hibernate Tools 4.3.5.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * TGestion generated by hbm2java
 */
@Entity
@Table(name = "T_GESTION", schema = "EMAP")
public class TGestion implements java.io.Serializable {

	private short gesCode;
	private Date gesDateDebut;
	private Date gesDateFin;
	private Set<TPlanGeneral> TPlanGenerals = new HashSet<TPlanGeneral>(0);
	private Set<TDacSpecs> TDacSpecses = new HashSet<TDacSpecs>(0);
	private Set<TAgpm> TAgpms = new HashSet<TAgpm>(0);
	private Set<TAffichagePgpm> TAffichagePgpms = new HashSet<TAffichagePgpm>(0);
	private Set<TAffichageAgpm> TAffichageAgpms = new HashSet<TAffichageAgpm>(0);
	private Set<TLBudgets> TLBudgetses = new HashSet<TLBudgets>(0);
	private Set<TPlanPassation> TPlanPassations = new HashSet<TPlanPassation>(0);

	public TGestion() {
	}

	public TGestion(short gesCode) {
		this.gesCode = gesCode;
	}

	public TGestion(short gesCode, Date gesDateDebut, Date gesDateFin, Set<TPlanGeneral> TPlanGenerals,
			Set<TDacSpecs> TDacSpecses, Set<TAgpm> TAgpms, Set<TAffichagePgpm> TAffichagePgpms,
			Set<TAffichageAgpm> TAffichageAgpms, Set<TLBudgets> TLBudgetses, Set<TPlanPassation> TPlanPassations) {
		this.gesCode = gesCode;
		this.gesDateDebut = gesDateDebut;
		this.gesDateFin = gesDateFin;
		this.TPlanGenerals = TPlanGenerals;
		this.TDacSpecses = TDacSpecses;
		this.TAgpms = TAgpms;
		this.TAffichagePgpms = TAffichagePgpms;
		this.TAffichageAgpms = TAffichageAgpms;
		this.TLBudgetses = TLBudgetses;
		this.TPlanPassations = TPlanPassations;
	}

	@Id

	@Column(name = "GES_CODE", unique = true, nullable = false, precision = 4, scale = 0)
	public short getGesCode() {
		return this.gesCode;
	}

	public void setGesCode(short gesCode) {
		this.gesCode = gesCode;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "GES_DATE_DEBUT", length = 7)
	public Date getGesDateDebut() {
		return this.gesDateDebut;
	}

	public void setGesDateDebut(Date gesDateDebut) {
		this.gesDateDebut = gesDateDebut;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "GES_DATE_FIN", length = 7)
	public Date getGesDateFin() {
		return this.gesDateFin;
	}

	public void setGesDateFin(Date gesDateFin) {
		this.gesDateFin = gesDateFin;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TGestion")
	public Set<TPlanGeneral> getTPlanGenerals() {
		return this.TPlanGenerals;
	}

	public void setTPlanGenerals(Set<TPlanGeneral> TPlanGenerals) {
		this.TPlanGenerals = TPlanGenerals;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TGestion")
	public Set<TDacSpecs> getTDacSpecses() {
		return this.TDacSpecses;
	}

	public void setTDacSpecses(Set<TDacSpecs> TDacSpecses) {
		this.TDacSpecses = TDacSpecses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TGestion")
	public Set<TAgpm> getTAgpms() {
		return this.TAgpms;
	}

	public void setTAgpms(Set<TAgpm> TAgpms) {
		this.TAgpms = TAgpms;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TGestion")
	public Set<TAffichagePgpm> getTAffichagePgpms() {
		return this.TAffichagePgpms;
	}

	public void setTAffichagePgpms(Set<TAffichagePgpm> TAffichagePgpms) {
		this.TAffichagePgpms = TAffichagePgpms;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TGestion")
	public Set<TAffichageAgpm> getTAffichageAgpms() {
		return this.TAffichageAgpms;
	}

	public void setTAffichageAgpms(Set<TAffichageAgpm> TAffichageAgpms) {
		this.TAffichageAgpms = TAffichageAgpms;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TGestion")
	public Set<TLBudgets> getTLBudgetses() {
		return this.TLBudgetses;
	}

	public void setTLBudgetses(Set<TLBudgets> TLBudgetses) {
		this.TLBudgetses = TLBudgetses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TGestion")
	public Set<TPlanPassation> getTPlanPassations() {
		return this.TPlanPassations;
	}

	public void setTPlanPassations(Set<TPlanPassation> TPlanPassations) {
		this.TPlanPassations = TPlanPassations;
	}

}
