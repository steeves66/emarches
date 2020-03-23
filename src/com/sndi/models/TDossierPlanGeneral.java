package com.sndi.models;
// Generated 23 mars 2020 10:48:44 by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * TDossierPlanGeneral generated by hbm2java
 */
@Entity
@Table(name = "T_DOSSIER_PLAN_GENERAL", schema = "EMAP")
public class TDossierPlanGeneral implements java.io.Serializable {

	private long dpgId;
	private TDetailPlanGeneral TDetailPlanGeneral;
	private TNaturePiece TNaturePiece;
	private String dpgCode;
	private String dpgLibelle;
	private String dpgCommentaire;
	private String dpgReference;

	public TDossierPlanGeneral() {
	}

	public TDossierPlanGeneral(long dpgId, TDetailPlanGeneral TDetailPlanGeneral, TNaturePiece TNaturePiece) {
		this.dpgId = dpgId;
		this.TDetailPlanGeneral = TDetailPlanGeneral;
		this.TNaturePiece = TNaturePiece;
	}

	public TDossierPlanGeneral(long dpgId, TDetailPlanGeneral TDetailPlanGeneral, TNaturePiece TNaturePiece,
			String dpgCode, String dpgLibelle, String dpgCommentaire, String dpgReference) {
		this.dpgId = dpgId;
		this.TDetailPlanGeneral = TDetailPlanGeneral;
		this.TNaturePiece = TNaturePiece;
		this.dpgCode = dpgCode;
		this.dpgLibelle = dpgLibelle;
		this.dpgCommentaire = dpgCommentaire;
		this.dpgReference = dpgReference;
	}

	@Id

	@Column(name = "DPG_ID", unique = true, nullable = false, precision = 10, scale = 0)
	public long getDpgId() {
		return this.dpgId;
	}

	public void setDpgId(long dpgId) {
		this.dpgId = dpgId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DPG_GPG_ID", nullable = false)
	public TDetailPlanGeneral getTDetailPlanGeneral() {
		return this.TDetailPlanGeneral;
	}

	public void setTDetailPlanGeneral(TDetailPlanGeneral TDetailPlanGeneral) {
		this.TDetailPlanGeneral = TDetailPlanGeneral;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DPG_NAP_CODE", nullable = false)
	public TNaturePiece getTNaturePiece() {
		return this.TNaturePiece;
	}

	public void setTNaturePiece(TNaturePiece TNaturePiece) {
		this.TNaturePiece = TNaturePiece;
	}

	@Column(name = "DPG_CODE", length = 500)
	public String getDpgCode() {
		return this.dpgCode;
	}

	public void setDpgCode(String dpgCode) {
		this.dpgCode = dpgCode;
	}

	@Column(name = "DPG_LIBELLE", length = 500)
	public String getDpgLibelle() {
		return this.dpgLibelle;
	}

	public void setDpgLibelle(String dpgLibelle) {
		this.dpgLibelle = dpgLibelle;
	}

	@Column(name = "DPG_COMMENTAIRE", length = 500)
	public String getDpgCommentaire() {
		return this.dpgCommentaire;
	}

	public void setDpgCommentaire(String dpgCommentaire) {
		this.dpgCommentaire = dpgCommentaire;
	}

	@Column(name = "DPG_REFERENCE", length = 500)
	public String getDpgReference() {
		return this.dpgReference;
	}

	public void setDpgReference(String dpgReference) {
		this.dpgReference = dpgReference;
	}

}
