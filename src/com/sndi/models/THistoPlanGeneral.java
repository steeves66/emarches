package com.sndi.models;
// Generated 25 juin 2020 13:53:46 by Hibernate Tools 4.3.5.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * THistoPlanGeneral generated by hbm2java
 */
@Entity
@Table(name = "T_HISTO_PLAN_GENERAL", schema = "EMAP")
public class THistoPlanGeneral implements java.io.Serializable {

	private long hpgId;
	private TStatut TStatut;
	private TDetailPlanGeneral TDetailPlanGeneral;
	private TFonction TFonction;
	private TOperateur TOperateur;
	private Date hpgDate;
	private String hpgMotif;

	public THistoPlanGeneral() {
	}

	public THistoPlanGeneral(long hpgId, TStatut TStatut, TDetailPlanGeneral TDetailPlanGeneral, TFonction TFonction) {
		this.hpgId = hpgId;
		this.TStatut = TStatut;
		this.TDetailPlanGeneral = TDetailPlanGeneral;
		this.TFonction = TFonction;
	}

	public THistoPlanGeneral(long hpgId, TStatut TStatut, TDetailPlanGeneral TDetailPlanGeneral, TFonction TFonction,
			TOperateur TOperateur, Date hpgDate, String hpgMotif) {
		this.hpgId = hpgId;
		this.TStatut = TStatut;
		this.TDetailPlanGeneral = TDetailPlanGeneral;
		this.TFonction = TFonction;
		this.TOperateur = TOperateur;
		this.hpgDate = hpgDate;
		this.hpgMotif = hpgMotif;
	}

	@Id

	@Column(name = "HPG_ID", unique = true, nullable = false, precision = 10, scale = 0)
	public long getHpgId() {
		return this.hpgId;
	}

	public void setHpgId(long hpgId) {
		this.hpgId = hpgId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "HPG_STA_CODE", nullable = false)
	public TStatut getTStatut() {
		return this.TStatut;
	}

	public void setTStatut(TStatut TStatut) {
		this.TStatut = TStatut;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "HPG_GPG_ID", nullable = false)
	public TDetailPlanGeneral getTDetailPlanGeneral() {
		return this.TDetailPlanGeneral;
	}

	public void setTDetailPlanGeneral(TDetailPlanGeneral TDetailPlanGeneral) {
		this.TDetailPlanGeneral = TDetailPlanGeneral;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "HPG_FON_COD", nullable = false)
	public TFonction getTFonction() {
		return this.TFonction;
	}

	public void setTFonction(TFonction TFonction) {
		this.TFonction = TFonction;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "HPG_OPE_MATRICULE")
	public TOperateur getTOperateur() {
		return this.TOperateur;
	}

	public void setTOperateur(TOperateur TOperateur) {
		this.TOperateur = TOperateur;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "HPG_DATE", length = 7)
	public Date getHpgDate() {
		return this.hpgDate;
	}

	public void setHpgDate(Date hpgDate) {
		this.hpgDate = hpgDate;
	}

	@Column(name = "HPG_MOTIF", length = 1000)
	public String getHpgMotif() {
		return this.hpgMotif;
	}

	public void setHpgMotif(String hpgMotif) {
		this.hpgMotif = hpgMotif;
	}

}
