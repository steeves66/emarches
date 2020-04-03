package com.sndi.models;
// Generated 3 avr. 2020 00:55:57 by Hibernate Tools 4.3.5.Final

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
 * THistoPlanPassation generated by hbm2java
 */
@Entity
@Table(name = "T_HISTO_PLAN_PASSATION", schema = "EMAP")
public class THistoPlanPassation implements java.io.Serializable {

	private long hppId;
	private TDetailPlanPassation TDetailPlanPassation;
	private TFonction TFonction;
	private TStatut TStatut;
	private TOperateur TOperateur;
	private Date hppDate;
	private String hppMotif;

	public THistoPlanPassation() {
	}

	public THistoPlanPassation(long hppId, TDetailPlanPassation TDetailPlanPassation, TFonction TFonction,
			TStatut TStatut) {
		this.hppId = hppId;
		this.TDetailPlanPassation = TDetailPlanPassation;
		this.TFonction = TFonction;
		this.TStatut = TStatut;
	}

	public THistoPlanPassation(long hppId, TDetailPlanPassation TDetailPlanPassation, TFonction TFonction,
			TStatut TStatut, TOperateur TOperateur, Date hppDate, String hppMotif) {
		this.hppId = hppId;
		this.TDetailPlanPassation = TDetailPlanPassation;
		this.TFonction = TFonction;
		this.TStatut = TStatut;
		this.TOperateur = TOperateur;
		this.hppDate = hppDate;
		this.hppMotif = hppMotif;
	}

	@Id

	@Column(name = "HPP_ID", unique = true, nullable = false, precision = 10, scale = 0)
	public long getHppId() {
		return this.hppId;
	}

	public void setHppId(long hppId) {
		this.hppId = hppId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "HPP_DPP_ID", nullable = false)
	public TDetailPlanPassation getTDetailPlanPassation() {
		return this.TDetailPlanPassation;
	}

	public void setTDetailPlanPassation(TDetailPlanPassation TDetailPlanPassation) {
		this.TDetailPlanPassation = TDetailPlanPassation;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "HPP_FON_COD", nullable = false)
	public TFonction getTFonction() {
		return this.TFonction;
	}

	public void setTFonction(TFonction TFonction) {
		this.TFonction = TFonction;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "HPP_STA_CODE", nullable = false)
	public TStatut getTStatut() {
		return this.TStatut;
	}

	public void setTStatut(TStatut TStatut) {
		this.TStatut = TStatut;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "HPP_OPE_MATRICULE")
	public TOperateur getTOperateur() {
		return this.TOperateur;
	}

	public void setTOperateur(TOperateur TOperateur) {
		this.TOperateur = TOperateur;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "HPP_DATE", length = 7)
	public Date getHppDate() {
		return this.hppDate;
	}

	public void setHppDate(Date hppDate) {
		this.hppDate = hppDate;
	}

	@Column(name = "HPP_MOTIF", length = 1000)
	public String getHppMotif() {
		return this.hppMotif;
	}

	public void setHppMotif(String hppMotif) {
		this.hppMotif = hppMotif;
	}

}
