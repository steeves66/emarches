package com.sndi.models;
// Generated 28 mars 2020 15:50:26 by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * TCharge generated by hbm2java
 */
@Entity
@Table(name = "T_CHARGE", schema = "EMAP")
public class TCharge implements java.io.Serializable {

	private long chrId;
	private TStructure TStructure;
	private TTypeCharge TTypeCharge;
	private TDetailPlanPassation TDetailPlanPassation;
	private String chrCommentaire;
	private String chrStatut;

	public TCharge() {
	}

	public TCharge(long chrId, TStructure TStructure, TTypeCharge TTypeCharge,
			TDetailPlanPassation TDetailPlanPassation) {
		this.chrId = chrId;
		this.TStructure = TStructure;
		this.TTypeCharge = TTypeCharge;
		this.TDetailPlanPassation = TDetailPlanPassation;
	}

	public TCharge(long chrId, TStructure TStructure, TTypeCharge TTypeCharge,
			TDetailPlanPassation TDetailPlanPassation, String chrCommentaire, String chrStatut) {
		this.chrId = chrId;
		this.TStructure = TStructure;
		this.TTypeCharge = TTypeCharge;
		this.TDetailPlanPassation = TDetailPlanPassation;
		this.chrCommentaire = chrCommentaire;
		this.chrStatut = chrStatut;
	}

	@Id

	@Column(name = "CHR_ID", unique = true, nullable = false, precision = 10, scale = 0)
	public long getChrId() {
		return this.chrId;
	}

	public void setChrId(long chrId) {
		this.chrId = chrId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CHR_STR_CODE", nullable = false)
	public TStructure getTStructure() {
		return this.TStructure;
	}

	public void setTStructure(TStructure TStructure) {
		this.TStructure = TStructure;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CHR_TYC_CODE", nullable = false)
	public TTypeCharge getTTypeCharge() {
		return this.TTypeCharge;
	}

	public void setTTypeCharge(TTypeCharge TTypeCharge) {
		this.TTypeCharge = TTypeCharge;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CHR_DPP_ID", nullable = false)
	public TDetailPlanPassation getTDetailPlanPassation() {
		return this.TDetailPlanPassation;
	}

	public void setTDetailPlanPassation(TDetailPlanPassation TDetailPlanPassation) {
		this.TDetailPlanPassation = TDetailPlanPassation;
	}

	@Column(name = "CHR_COMMENTAIRE", length = 1000)
	public String getChrCommentaire() {
		return this.chrCommentaire;
	}

	public void setChrCommentaire(String chrCommentaire) {
		this.chrCommentaire = chrCommentaire;
	}

	@Column(name = "CHR_STATUT", length = 1)
	public String getChrStatut() {
		return this.chrStatut;
	}

	public void setChrStatut(String chrStatut) {
		this.chrStatut = chrStatut;
	}

}
