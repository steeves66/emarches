package com.sndi.models;
// Generated 28 mars 2020 15:50:26 by Hibernate Tools 4.3.5.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TNaturePiece generated by hbm2java
 */
@Entity
@Table(name = "T_NATURE_PIECE", schema = "EMAP")
public class TNaturePiece implements java.io.Serializable {

	private String napCode;
	private String napNapLibelleCourt;
	private String napNapLibelleLong;
	private Set<TDossierAgpm> TDossierAgpms = new HashSet<TDossierAgpm>(0);
	private Set<TDossierPlanGeneral> TDossierPlanGenerals = new HashSet<TDossierPlanGeneral>(0);

	public TNaturePiece() {
	}

	public TNaturePiece(String napCode, String napNapLibelleCourt) {
		this.napCode = napCode;
		this.napNapLibelleCourt = napNapLibelleCourt;
	}

	public TNaturePiece(String napCode, String napNapLibelleCourt, String napNapLibelleLong,
			Set<TDossierAgpm> TDossierAgpms, Set<TDossierPlanGeneral> TDossierPlanGenerals) {
		this.napCode = napCode;
		this.napNapLibelleCourt = napNapLibelleCourt;
		this.napNapLibelleLong = napNapLibelleLong;
		this.TDossierAgpms = TDossierAgpms;
		this.TDossierPlanGenerals = TDossierPlanGenerals;
	}

	@Id

	@Column(name = "NAP_CODE", unique = true, nullable = false, length = 5)
	public String getNapCode() {
		return this.napCode;
	}

	public void setNapCode(String napCode) {
		this.napCode = napCode;
	}

	@Column(name = "NAP_NAP_LIBELLE_COURT", nullable = false, length = 500)
	public String getNapNapLibelleCourt() {
		return this.napNapLibelleCourt;
	}

	public void setNapNapLibelleCourt(String napNapLibelleCourt) {
		this.napNapLibelleCourt = napNapLibelleCourt;
	}

	@Column(name = "NAP_NAP_LIBELLE_LONG", length = 1000)
	public String getNapNapLibelleLong() {
		return this.napNapLibelleLong;
	}

	public void setNapNapLibelleLong(String napNapLibelleLong) {
		this.napNapLibelleLong = napNapLibelleLong;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TNaturePiece")
	public Set<TDossierAgpm> getTDossierAgpms() {
		return this.TDossierAgpms;
	}

	public void setTDossierAgpms(Set<TDossierAgpm> TDossierAgpms) {
		this.TDossierAgpms = TDossierAgpms;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TNaturePiece")
	public Set<TDossierPlanGeneral> getTDossierPlanGenerals() {
		return this.TDossierPlanGenerals;
	}

	public void setTDossierPlanGenerals(Set<TDossierPlanGeneral> TDossierPlanGenerals) {
		this.TDossierPlanGenerals = TDossierPlanGenerals;
	}

}
