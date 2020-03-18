package com.sndi.model;
// Generated 13 f�vr. 2020 11:47:53 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

/**
 * VbLotAao generated by hbm2java
 */
@Entity
@Immutable
@Table(name = "VB_LOT_AAO")
public class VbLotAao implements java.io.Serializable {

	private long laaId;
	private String laaAaoCode;
	private String laaObjet;
	private String laaObservation;
	private BigDecimal laaMtCaut;
	private BigDecimal laaMtEst;
	private Date laaDteSaisi;
	private String laaStaCode;
	private String laaFonCodSaisi;
	private String laaFonCodCpmp;
	private String laaOpeMatricule;
	private String laaLieuExe;
	private String laaLbgImputation;
	private BigDecimal laaNum;
	private BigDecimal laaCoutLot;
	private String laaDacCode;

	public VbLotAao() {
	}

	public VbLotAao(long laaId) {
		this.laaId = laaId;
	}

	public VbLotAao(long laaId, String laaAaoCode, String laaObjet, String laaObservation, BigDecimal laaMtCaut,
			BigDecimal laaMtEst, Date laaDteSaisi, String laaStaCode, String laaFonCodSaisi, String laaFonCodCpmp,
			String laaOpeMatricule, String laaLieuExe, String laaLbgImputation, BigDecimal laaNum,
			BigDecimal laaCoutLot, String laaDacCode) {
		this.laaId = laaId;
		this.laaAaoCode = laaAaoCode;
		this.laaObjet = laaObjet;
		this.laaObservation = laaObservation;
		this.laaMtCaut = laaMtCaut;
		this.laaMtEst = laaMtEst;
		this.laaDteSaisi = laaDteSaisi;
		this.laaStaCode = laaStaCode;
		this.laaFonCodSaisi = laaFonCodSaisi;
		this.laaFonCodCpmp = laaFonCodCpmp;
		this.laaOpeMatricule = laaOpeMatricule;
		this.laaLieuExe = laaLieuExe;
		this.laaLbgImputation = laaLbgImputation;
		this.laaNum = laaNum;
		this.laaCoutLot = laaCoutLot;
		this.laaDacCode = laaDacCode;
	}

	
	@Id
	@Column(name = "LAA_ID", nullable = false, precision = 22, scale = 0)
	public long getLaaId() {
		return this.laaId;
	}

	public void setLaaId(long laaId) {
		this.laaId = laaId;
	}

	@Column(name = "LAA_AAO_CODE", length = 20)
	public String getLaaAaoCode() {
		return this.laaAaoCode;
	}

	public void setLaaAaoCode(String laaAaoCode) {
		this.laaAaoCode = laaAaoCode;
	}

	@Column(name = "LAA_OBJET", length = 1000)
	public String getLaaObjet() {
		return this.laaObjet;
	}

	public void setLaaObjet(String laaObjet) {
		this.laaObjet = laaObjet;
	}

	@Column(name = "LAA_OBSERVATION", length = 200)
	public String getLaaObservation() {
		return this.laaObservation;
	}

	public void setLaaObservation(String laaObservation) {
		this.laaObservation = laaObservation;
	}

	@Column(name = "LAA_MT_CAUT", precision = 22, scale = 0)
	public BigDecimal getLaaMtCaut() {
		return this.laaMtCaut;
	}

	public void setLaaMtCaut(BigDecimal laaMtCaut) {
		this.laaMtCaut = laaMtCaut;
	}

	@Column(name = "LAA_MT_EST", precision = 22, scale = 0)
	public BigDecimal getLaaMtEst() {
		return this.laaMtEst;
	}

	public void setLaaMtEst(BigDecimal laaMtEst) {
		this.laaMtEst = laaMtEst;
	}

	@Column(name = "LAA_DTE_SAISI", length = 7)
	public Date getLaaDteSaisi() {
		return this.laaDteSaisi;
	}

	public void setLaaDteSaisi(Date laaDteSaisi) {
		this.laaDteSaisi = laaDteSaisi;
	}

	@Column(name = "LAA_STA_CODE", length = 3)
	public String getLaaStaCode() {
		return this.laaStaCode;
	}

	public void setLaaStaCode(String laaStaCode) {
		this.laaStaCode = laaStaCode;
	}

	@Column(name = "LAA_FON_COD_SAISI", length = 20)
	public String getLaaFonCodSaisi() {
		return this.laaFonCodSaisi;
	}

	public void setLaaFonCodSaisi(String laaFonCodSaisi) {
		this.laaFonCodSaisi = laaFonCodSaisi;
	}

	@Column(name = "LAA_FON_COD_CPMP", length = 20)
	public String getLaaFonCodCpmp() {
		return this.laaFonCodCpmp;
	}

	public void setLaaFonCodCpmp(String laaFonCodCpmp) {
		this.laaFonCodCpmp = laaFonCodCpmp;
	}

	@Column(name = "LAA_OPE_MATRICULE", length = 20)
	public String getLaaOpeMatricule() {
		return this.laaOpeMatricule;
	}

	public void setLaaOpeMatricule(String laaOpeMatricule) {
		this.laaOpeMatricule = laaOpeMatricule;
	}

	@Column(name = "LAA_LIEU_EXE", length = 1000)
	public String getLaaLieuExe() {
		return this.laaLieuExe;
	}

	public void setLaaLieuExe(String laaLieuExe) {
		this.laaLieuExe = laaLieuExe;
	}

	@Column(name = "LAA_LBG_IMPUTATION", length = 50)
	public String getLaaLbgImputation() {
		return this.laaLbgImputation;
	}

	public void setLaaLbgImputation(String laaLbgImputation) {
		this.laaLbgImputation = laaLbgImputation;
	}

	@Column(name = "LAA_NUM", precision = 22, scale = 0)
	public BigDecimal getLaaNum() {
		return this.laaNum;
	}

	public void setLaaNum(BigDecimal laaNum) {
		this.laaNum = laaNum;
	}

	@Column(name = "LAA_COUT_LOT", precision = 22, scale = 0)
	public BigDecimal getLaaCoutLot() {
		return this.laaCoutLot;
	}

	public void setLaaCoutLot(BigDecimal laaCoutLot) {
		this.laaCoutLot = laaCoutLot;
	}

	@Column(name = "LAA_DAC_CODE", length = 20)
	public String getLaaDacCode() {
		return this.laaDacCode;
	}

	public void setLaaDacCode(String laaDacCode) {
		this.laaDacCode = laaDacCode;
	}


}
