package com.sndi.models;
// Generated 18 juin 2020 16:45:49 by Hibernate Tools 4.3.5.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TModePassation generated by hbm2java
 */
@Entity
@Table(name = "T_MODE_PASSATION", schema = "EMAP")
public class TModePassation implements java.io.Serializable {

	private String mopCode;
	private String mopLibelleCourt;
	private String mopLibelleLong;
	private Set<TAffichagePgpm> TAffichagePgpms = new HashSet<TAffichagePgpm>(0);
	private Set<TDetailPlanGeneral> TDetailPlanGenerals = new HashSet<TDetailPlanGeneral>(0);
	private Set<TAffichagePpm> TAffichagePpms = new HashSet<TAffichagePpm>(0);
	private Set<TDetailPlanPassation> TDetailPlanPassations = new HashSet<TDetailPlanPassation>(0);
	private Set<TDacSpecs> TDacSpecses = new HashSet<TDacSpecs>(0);

	public TModePassation() {
	}

	public TModePassation(String mopCode, String mopLibelleCourt) {
		this.mopCode = mopCode;
		this.mopLibelleCourt = mopLibelleCourt;
	}

	public TModePassation(String mopCode, String mopLibelleCourt, String mopLibelleLong,
			Set<TAffichagePgpm> TAffichagePgpms, Set<TDetailPlanGeneral> TDetailPlanGenerals,
			Set<TAffichagePpm> TAffichagePpms, Set<TDetailPlanPassation> TDetailPlanPassations,
			Set<TDacSpecs> TDacSpecses) {
		this.mopCode = mopCode;
		this.mopLibelleCourt = mopLibelleCourt;
		this.mopLibelleLong = mopLibelleLong;
		this.TAffichagePgpms = TAffichagePgpms;
		this.TDetailPlanGenerals = TDetailPlanGenerals;
		this.TAffichagePpms = TAffichagePpms;
		this.TDetailPlanPassations = TDetailPlanPassations;
		this.TDacSpecses = TDacSpecses;
	}

	@Id

	@Column(name = "MOP_CODE", unique = true, nullable = false, length = 3)
	public String getMopCode() {
		return this.mopCode;
	}

	public void setMopCode(String mopCode) {
		this.mopCode = mopCode;
	}

	@Column(name = "MOP_LIBELLE_COURT", nullable = false, length = 500)
	public String getMopLibelleCourt() {
		return this.mopLibelleCourt;
	}

	public void setMopLibelleCourt(String mopLibelleCourt) {
		this.mopLibelleCourt = mopLibelleCourt;
	}

	@Column(name = "MOP_LIBELLE_LONG", length = 1000)
	public String getMopLibelleLong() {
		return this.mopLibelleLong;
	}

	public void setMopLibelleLong(String mopLibelleLong) {
		this.mopLibelleLong = mopLibelleLong;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TModePassation")
	public Set<TAffichagePgpm> getTAffichagePgpms() {
		return this.TAffichagePgpms;
	}

	public void setTAffichagePgpms(Set<TAffichagePgpm> TAffichagePgpms) {
		this.TAffichagePgpms = TAffichagePgpms;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TModePassation")
	public Set<TDetailPlanGeneral> getTDetailPlanGenerals() {
		return this.TDetailPlanGenerals;
	}

	public void setTDetailPlanGenerals(Set<TDetailPlanGeneral> TDetailPlanGenerals) {
		this.TDetailPlanGenerals = TDetailPlanGenerals;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TModePassation")
	public Set<TAffichagePpm> getTAffichagePpms() {
		return this.TAffichagePpms;
	}

	public void setTAffichagePpms(Set<TAffichagePpm> TAffichagePpms) {
		this.TAffichagePpms = TAffichagePpms;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TModePassation")
	public Set<TDetailPlanPassation> getTDetailPlanPassations() {
		return this.TDetailPlanPassations;
	}

	public void setTDetailPlanPassations(Set<TDetailPlanPassation> TDetailPlanPassations) {
		this.TDetailPlanPassations = TDetailPlanPassations;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TModePassation")
	public Set<TDacSpecs> getTDacSpecses() {
		return this.TDacSpecses;
	}

	public void setTDacSpecses(Set<TDacSpecs> TDacSpecses) {
		this.TDacSpecses = TDacSpecses;
	}

}
