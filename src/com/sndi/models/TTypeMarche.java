package com.sndi.models;
// Generated 25 juin 2020 13:53:46 by Hibernate Tools 4.3.5.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TTypeMarche generated by hbm2java
 */
@Entity
@Table(name = "T_TYPE_MARCHE", schema = "EMAP")
public class TTypeMarche implements java.io.Serializable {

	private String tymCode;
	private String tymLibelleCourt;
	private String tymLibelleLong;
	private String tymTymCode;
	private String tymGroupe;
	private Set<TDacSpecs> TDacSpecses = new HashSet<TDacSpecs>(0);
	private Set<TDetailPlanPassation> TDetailPlanPassations = new HashSet<TDetailPlanPassation>(0);
	private Set<TModeleDacType> TModeleDacTypes = new HashSet<TModeleDacType>(0);
	private Set<TAffichagePpm> TAffichagePpms = new HashSet<TAffichagePpm>(0);
	private Set<TAffichagePgpm> TAffichagePgpms = new HashSet<TAffichagePgpm>(0);
	private Set<TCritereAnalyse> TCritereAnalyses = new HashSet<TCritereAnalyse>(0);
	private Set<TPublicationAvis> TPublicationAvises = new HashSet<TPublicationAvis>(0);
	private Set<TDetailPlanGeneral> TDetailPlanGenerals = new HashSet<TDetailPlanGeneral>(0);

	public TTypeMarche() {
	}

	public TTypeMarche(String tymCode, String tymLibelleCourt) {
		this.tymCode = tymCode;
		this.tymLibelleCourt = tymLibelleCourt;
	}

	public TTypeMarche(String tymCode, String tymLibelleCourt, String tymLibelleLong, String tymTymCode,
			String tymGroupe, Set<TDacSpecs> TDacSpecses, Set<TDetailPlanPassation> TDetailPlanPassations,
			Set<TModeleDacType> TModeleDacTypes, Set<TAffichagePpm> TAffichagePpms, Set<TAffichagePgpm> TAffichagePgpms,
			Set<TCritereAnalyse> TCritereAnalyses, Set<TPublicationAvis> TPublicationAvises,
			Set<TDetailPlanGeneral> TDetailPlanGenerals) {
		this.tymCode = tymCode;
		this.tymLibelleCourt = tymLibelleCourt;
		this.tymLibelleLong = tymLibelleLong;
		this.tymTymCode = tymTymCode;
		this.tymGroupe = tymGroupe;
		this.TDacSpecses = TDacSpecses;
		this.TDetailPlanPassations = TDetailPlanPassations;
		this.TModeleDacTypes = TModeleDacTypes;
		this.TAffichagePpms = TAffichagePpms;
		this.TAffichagePgpms = TAffichagePgpms;
		this.TCritereAnalyses = TCritereAnalyses;
		this.TPublicationAvises = TPublicationAvises;
		this.TDetailPlanGenerals = TDetailPlanGenerals;
	}

	@Id

	@Column(name = "TYM_CODE", unique = true, nullable = false, length = 3)
	public String getTymCode() {
		return this.tymCode;
	}

	public void setTymCode(String tymCode) {
		this.tymCode = tymCode;
	}

	@Column(name = "TYM_LIBELLE_COURT", nullable = false, length = 500)
	public String getTymLibelleCourt() {
		return this.tymLibelleCourt;
	}

	public void setTymLibelleCourt(String tymLibelleCourt) {
		this.tymLibelleCourt = tymLibelleCourt;
	}

	@Column(name = "TYM_LIBELLE_LONG", length = 1000)
	public String getTymLibelleLong() {
		return this.tymLibelleLong;
	}

	public void setTymLibelleLong(String tymLibelleLong) {
		this.tymLibelleLong = tymLibelleLong;
	}

	@Column(name = "TYM_TYM_CODE", length = 3)
	public String getTymTymCode() {
		return this.tymTymCode;
	}

	public void setTymTymCode(String tymTymCode) {
		this.tymTymCode = tymTymCode;
	}

	@Column(name = "TYM_GROUPE", length = 2)
	public String getTymGroupe() {
		return this.tymGroupe;
	}

	public void setTymGroupe(String tymGroupe) {
		this.tymGroupe = tymGroupe;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TTypeMarche")
	public Set<TDacSpecs> getTDacSpecses() {
		return this.TDacSpecses;
	}

	public void setTDacSpecses(Set<TDacSpecs> TDacSpecses) {
		this.TDacSpecses = TDacSpecses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TTypeMarche")
	public Set<TDetailPlanPassation> getTDetailPlanPassations() {
		return this.TDetailPlanPassations;
	}

	public void setTDetailPlanPassations(Set<TDetailPlanPassation> TDetailPlanPassations) {
		this.TDetailPlanPassations = TDetailPlanPassations;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TTypeMarche")
	public Set<TModeleDacType> getTModeleDacTypes() {
		return this.TModeleDacTypes;
	}

	public void setTModeleDacTypes(Set<TModeleDacType> TModeleDacTypes) {
		this.TModeleDacTypes = TModeleDacTypes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TTypeMarche")
	public Set<TAffichagePpm> getTAffichagePpms() {
		return this.TAffichagePpms;
	}

	public void setTAffichagePpms(Set<TAffichagePpm> TAffichagePpms) {
		this.TAffichagePpms = TAffichagePpms;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TTypeMarche")
	public Set<TAffichagePgpm> getTAffichagePgpms() {
		return this.TAffichagePgpms;
	}

	public void setTAffichagePgpms(Set<TAffichagePgpm> TAffichagePgpms) {
		this.TAffichagePgpms = TAffichagePgpms;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TTypeMarche")
	public Set<TCritereAnalyse> getTCritereAnalyses() {
		return this.TCritereAnalyses;
	}

	public void setTCritereAnalyses(Set<TCritereAnalyse> TCritereAnalyses) {
		this.TCritereAnalyses = TCritereAnalyses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TTypeMarche")
	public Set<TPublicationAvis> getTPublicationAvises() {
		return this.TPublicationAvises;
	}

	public void setTPublicationAvises(Set<TPublicationAvis> TPublicationAvises) {
		this.TPublicationAvises = TPublicationAvises;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TTypeMarche")
	public Set<TDetailPlanGeneral> getTDetailPlanGenerals() {
		return this.TDetailPlanGenerals;
	}

	public void setTDetailPlanGenerals(Set<TDetailPlanGeneral> TDetailPlanGenerals) {
		this.TDetailPlanGenerals = TDetailPlanGenerals;
	}

}