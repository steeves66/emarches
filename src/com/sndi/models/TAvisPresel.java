package com.sndi.models;
// Generated 20 juin 2020 17:16:02 by Hibernate Tools 4.3.5.Final

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
 * TAvisPresel generated by hbm2java
 */
@Entity
@Table(name = "T_AVIS_PRESEL", schema = "EMAP")
public class TAvisPresel implements java.io.Serializable {

	private BigDecimal aprNum;
	private TSoumissions TSoumissions;
	private TDemande TDemande;
	private TOperateur TOperateurByAprOpeMatricule;
	private TOperateur TOperateurByAprOpeMatMotif;
	private String aprType;
	private String aprModeInvit;
	private String aprDetailInvit;
	private Date aprDteSaisi;
	private Date aprDteModif;
	private BigDecimal aprMtInit;
	private BigDecimal aprMtDef;
	private String aprRet;

	public TAvisPresel() {
	}

	public TAvisPresel(BigDecimal aprNum) {
		this.aprNum = aprNum;
	}

	public TAvisPresel(BigDecimal aprNum, TSoumissions TSoumissions, TDemande TDemande,
			TOperateur TOperateurByAprOpeMatricule, TOperateur TOperateurByAprOpeMatMotif, String aprType,
			String aprModeInvit, String aprDetailInvit, Date aprDteSaisi, Date aprDteModif, BigDecimal aprMtInit,
			BigDecimal aprMtDef, String aprRet) {
		this.aprNum = aprNum;
		this.TSoumissions = TSoumissions;
		this.TDemande = TDemande;
		this.TOperateurByAprOpeMatricule = TOperateurByAprOpeMatricule;
		this.TOperateurByAprOpeMatMotif = TOperateurByAprOpeMatMotif;
		this.aprType = aprType;
		this.aprModeInvit = aprModeInvit;
		this.aprDetailInvit = aprDetailInvit;
		this.aprDteSaisi = aprDteSaisi;
		this.aprDteModif = aprDteModif;
		this.aprMtInit = aprMtInit;
		this.aprMtDef = aprMtDef;
		this.aprRet = aprRet;
	}

	@Id

	@Column(name = "APR_NUM", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getAprNum() {
		return this.aprNum;
	}

	public void setAprNum(BigDecimal aprNum) {
		this.aprNum = aprNum;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "APR_SOU_NCC")
	public TSoumissions getTSoumissions() {
		return this.TSoumissions;
	}

	public void setTSoumissions(TSoumissions TSoumissions) {
		this.TSoumissions = TSoumissions;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "APR_DEM_NUM")
	public TDemande getTDemande() {
		return this.TDemande;
	}

	public void setTDemande(TDemande TDemande) {
		this.TDemande = TDemande;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "APR_OPE_MATRICULE")
	public TOperateur getTOperateurByAprOpeMatricule() {
		return this.TOperateurByAprOpeMatricule;
	}

	public void setTOperateurByAprOpeMatricule(TOperateur TOperateurByAprOpeMatricule) {
		this.TOperateurByAprOpeMatricule = TOperateurByAprOpeMatricule;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "APR_OPE_MAT_MOTIF")
	public TOperateur getTOperateurByAprOpeMatMotif() {
		return this.TOperateurByAprOpeMatMotif;
	}

	public void setTOperateurByAprOpeMatMotif(TOperateur TOperateurByAprOpeMatMotif) {
		this.TOperateurByAprOpeMatMotif = TOperateurByAprOpeMatMotif;
	}

	@Column(name = "APR_TYPE", length = 1)
	public String getAprType() {
		return this.aprType;
	}

	public void setAprType(String aprType) {
		this.aprType = aprType;
	}

	@Column(name = "APR_MODE_INVIT", length = 100)
	public String getAprModeInvit() {
		return this.aprModeInvit;
	}

	public void setAprModeInvit(String aprModeInvit) {
		this.aprModeInvit = aprModeInvit;
	}

	@Column(name = "APR_DETAIL_INVIT", length = 2)
	public String getAprDetailInvit() {
		return this.aprDetailInvit;
	}

	public void setAprDetailInvit(String aprDetailInvit) {
		this.aprDetailInvit = aprDetailInvit;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "APR_DTE_SAISI", length = 7)
	public Date getAprDteSaisi() {
		return this.aprDteSaisi;
	}

	public void setAprDteSaisi(Date aprDteSaisi) {
		this.aprDteSaisi = aprDteSaisi;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "APR_DTE_MODIF", length = 7)
	public Date getAprDteModif() {
		return this.aprDteModif;
	}

	public void setAprDteModif(Date aprDteModif) {
		this.aprDteModif = aprDteModif;
	}

	@Column(name = "APR_MT_INIT", precision = 20, scale = 0)
	public BigDecimal getAprMtInit() {
		return this.aprMtInit;
	}

	public void setAprMtInit(BigDecimal aprMtInit) {
		this.aprMtInit = aprMtInit;
	}

	@Column(name = "APR_MT_DEF", precision = 20, scale = 0)
	public BigDecimal getAprMtDef() {
		return this.aprMtDef;
	}

	public void setAprMtDef(BigDecimal aprMtDef) {
		this.aprMtDef = aprMtDef;
	}

	@Column(name = "APR_RET", length = 1)
	public String getAprRet() {
		return this.aprRet;
	}

	public void setAprRet(String aprRet) {
		this.aprRet = aprRet;
	}

}
