package com.sndi.models;
// Generated 19 mars 2020 18:39:08 by Hibernate Tools 4.3.5.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TPlanGeneral generated by hbm2java
 */
@Entity
@Table(name = "T_PLAN_GENERAL", schema = "EMAP")
public class TPlanGeneral implements java.io.Serializable {

	private long plgId;
	private TStructure TStructure;
	private TFonction TFonction;
	private TGestion TGestion;
	private String plgCode;
	private String plgLibelle;
	private Set<TDetailPlanGeneral> TDetailPlanGenerals = new HashSet<TDetailPlanGeneral>(0);
	private Set<TAffichagePgpm> TAffichagePgpms = new HashSet<TAffichagePgpm>(0);

	public TPlanGeneral() {
	}

	public TPlanGeneral(long plgId, TStructure TStructure, TFonction TFonction, TGestion TGestion) {
		this.plgId = plgId;
		this.TStructure = TStructure;
		this.TFonction = TFonction;
		this.TGestion = TGestion;
	}

	public TPlanGeneral(long plgId, TStructure TStructure, TFonction TFonction, TGestion TGestion, String plgCode,
			String plgLibelle, Set<TDetailPlanGeneral> TDetailPlanGenerals, Set<TAffichagePgpm> TAffichagePgpms) {
		this.plgId = plgId;
		this.TStructure = TStructure;
		this.TFonction = TFonction;
		this.TGestion = TGestion;
		this.plgCode = plgCode;
		this.plgLibelle = plgLibelle;
		this.TDetailPlanGenerals = TDetailPlanGenerals;
		this.TAffichagePgpms = TAffichagePgpms;
	}

	@Id

	@Column(name = "PLG_ID", unique = true, nullable = false, precision = 10, scale = 0)
	public long getPlgId() {
		return this.plgId;
	}

	public void setPlgId(long plgId) {
		this.plgId = plgId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PLG_STR_CODE", nullable = false)
	public TStructure getTStructure() {
		return this.TStructure;
	}

	public void setTStructure(TStructure TStructure) {
		this.TStructure = TStructure;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PLG_FON_COD", nullable = false)
	public TFonction getTFonction() {
		return this.TFonction;
	}

	public void setTFonction(TFonction TFonction) {
		this.TFonction = TFonction;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PLG_GES_CODE", nullable = false)
	public TGestion getTGestion() {
		return this.TGestion;
	}

	public void setTGestion(TGestion TGestion) {
		this.TGestion = TGestion;
	}

	@Column(name = "PLG_CODE", length = 50)
	public String getPlgCode() {
		return this.plgCode;
	}

	public void setPlgCode(String plgCode) {
		this.plgCode = plgCode;
	}

	@Column(name = "PLG_LIBELLE", length = 1000)
	public String getPlgLibelle() {
		return this.plgLibelle;
	}

	public void setPlgLibelle(String plgLibelle) {
		this.plgLibelle = plgLibelle;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TPlanGeneral")
	public Set<TDetailPlanGeneral> getTDetailPlanGenerals() {
		return this.TDetailPlanGenerals;
	}

	public void setTDetailPlanGenerals(Set<TDetailPlanGeneral> TDetailPlanGenerals) {
		this.TDetailPlanGenerals = TDetailPlanGenerals;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TPlanGeneral")
	public Set<TAffichagePgpm> getTAffichagePgpms() {
		return this.TAffichagePgpms;
	}

	public void setTAffichagePgpms(Set<TAffichagePgpm> TAffichagePgpms) {
		this.TAffichagePgpms = TAffichagePgpms;
	}

}
