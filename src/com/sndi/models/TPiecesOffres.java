package com.sndi.models;
// Generated 25 juin 2020 13:53:46 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
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
 * TPiecesOffres generated by hbm2java
 */
@Entity
@Table(name = "T_PIECES_OFFRES", schema = "EMAP")
public class TPiecesOffres implements java.io.Serializable {

	private BigDecimal pofNum;
	private TTypePieceOffre TTypePieceOffre;
	private TDacSpecs TDacSpecs;
	private TDetOffres TDetOffres;
	private TLotAao TLotAao;
	private TOffrePieceDac TOffrePieceDac;
	private TOperateur TOperateur;
	private String pofPresent;
	private String pofConforme;
	private String pofTypeAct;
	private Date pofDteSaisi;
	private String pofObs;

	public TPiecesOffres() {
	}

	public TPiecesOffres(BigDecimal pofNum) {
		this.pofNum = pofNum;
	}

	public TPiecesOffres(BigDecimal pofNum, TTypePieceOffre TTypePieceOffre, TDacSpecs TDacSpecs, TDetOffres TDetOffres,
			TLotAao TLotAao, TOffrePieceDac TOffrePieceDac, TOperateur TOperateur, String pofPresent,
			String pofConforme, String pofTypeAct, Date pofDteSaisi, String pofObs) {
		this.pofNum = pofNum;
		this.TTypePieceOffre = TTypePieceOffre;
		this.TDacSpecs = TDacSpecs;
		this.TDetOffres = TDetOffres;
		this.TLotAao = TLotAao;
		this.TOffrePieceDac = TOffrePieceDac;
		this.TOperateur = TOperateur;
		this.pofPresent = pofPresent;
		this.pofConforme = pofConforme;
		this.pofTypeAct = pofTypeAct;
		this.pofDteSaisi = pofDteSaisi;
		this.pofObs = pofObs;
	}

	@Id

	@Column(name = "POF_NUM", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getPofNum() {
		return this.pofNum;
	}

	public void setPofNum(BigDecimal pofNum) {
		this.pofNum = pofNum;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "POF_OPD_TPO_CODE")
	public TTypePieceOffre getTTypePieceOffre() {
		return this.TTypePieceOffre;
	}

	public void setTTypePieceOffre(TTypePieceOffre TTypePieceOffre) {
		this.TTypePieceOffre = TTypePieceOffre;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "POF_DAC_CODE")
	public TDacSpecs getTDacSpecs() {
		return this.TDacSpecs;
	}

	public void setTDacSpecs(TDacSpecs TDacSpecs) {
		this.TDacSpecs = TDacSpecs;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "POF_DOF_NUM")
	public TDetOffres getTDetOffres() {
		return this.TDetOffres;
	}

	public void setTDetOffres(TDetOffres TDetOffres) {
		this.TDetOffres = TDetOffres;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "POF_LAA_ID")
	public TLotAao getTLotAao() {
		return this.TLotAao;
	}

	public void setTLotAao(TLotAao TLotAao) {
		this.TLotAao = TLotAao;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "POF_OPD_NUM")
	public TOffrePieceDac getTOffrePieceDac() {
		return this.TOffrePieceDac;
	}

	public void setTOffrePieceDac(TOffrePieceDac TOffrePieceDac) {
		this.TOffrePieceDac = TOffrePieceDac;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "POF_OPE_MATRICULE")
	public TOperateur getTOperateur() {
		return this.TOperateur;
	}

	public void setTOperateur(TOperateur TOperateur) {
		this.TOperateur = TOperateur;
	}

	@Column(name = "POF_PRESENT", length = 1)
	public String getPofPresent() {
		return this.pofPresent;
	}

	public void setPofPresent(String pofPresent) {
		this.pofPresent = pofPresent;
	}

	@Column(name = "POF_CONFORME", length = 1)
	public String getPofConforme() {
		return this.pofConforme;
	}

	public void setPofConforme(String pofConforme) {
		this.pofConforme = pofConforme;
	}

	@Column(name = "POF_TYPE_ACT", length = 10)
	public String getPofTypeAct() {
		return this.pofTypeAct;
	}

	public void setPofTypeAct(String pofTypeAct) {
		this.pofTypeAct = pofTypeAct;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "POF_DTE_SAISI", length = 7)
	public Date getPofDteSaisi() {
		return this.pofDteSaisi;
	}

	public void setPofDteSaisi(Date pofDteSaisi) {
		this.pofDteSaisi = pofDteSaisi;
	}

	@Column(name = "POF_OBS", length = 500)
	public String getPofObs() {
		return this.pofObs;
	}

	public void setPofObs(String pofObs) {
		this.pofObs = pofObs;
	}

}
