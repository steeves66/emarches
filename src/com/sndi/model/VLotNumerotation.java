package com.sndi.model;
// Generated 13 juil. 2021 18:20:56 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

/**
 * VLotNumerotationId generated by hbm2java
 */
@Entity
@Immutable
@Table(name = "V_LOT_NUMEROTATION")
public class VLotNumerotation implements java.io.Serializable {

	private BigDecimal laaId;
	private String laaAaoCode;
	private String laaObjet;
	private String laaObservation;
	private BigDecimal laaMtCaut;
	private BigDecimal laaMtEst;
	private String laaAno;
	private BigDecimal checktrt;
	private String laaObservationDmp;
	private String libAno;
	private String libAo;
	private String liblotnara;
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
	private String attSouNcc;
	private BigDecimal attMtAttr;
	private String souSigleSte;

	public VLotNumerotation() {
	}

	public VLotNumerotation(BigDecimal laaId, String laaAaoCode, String laaObjet, BigDecimal laaNum) {
		this.laaId = laaId;
		this.laaAaoCode = laaAaoCode;
		this.laaObjet = laaObjet;
		this.laaNum = laaNum;
	}

	public VLotNumerotation(BigDecimal laaId, String laaAaoCode, String laaObjet, String laaObservation,
			BigDecimal laaMtCaut, BigDecimal laaMtEst, String laaAno, BigDecimal checktrt, String laaObservationDmp,
			String libAno, String libAo, String liblotnara, Date laaDteSaisi, String laaStaCode, String laaFonCodSaisi,
			String laaFonCodCpmp, String laaOpeMatricule, String laaLieuExe, String laaLbgImputation, BigDecimal laaNum,
			BigDecimal laaCoutLot, String laaDacCode, String attSouNcc, BigDecimal attMtAttr, String souSigleSte) {
		this.laaId = laaId;
		this.laaAaoCode = laaAaoCode;
		this.laaObjet = laaObjet;
		this.laaObservation = laaObservation;
		this.laaMtCaut = laaMtCaut;
		this.laaMtEst = laaMtEst;
		this.laaAno = laaAno;
		this.checktrt = checktrt;
		this.laaObservationDmp = laaObservationDmp;
		this.libAno = libAno;
		this.libAo = libAo;
		this.liblotnara = liblotnara;
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
		this.attSouNcc = attSouNcc;
		this.attMtAttr = attMtAttr;
		this.souSigleSte = souSigleSte;
	}

	@Id
	@Column(name = "LAA_ID", nullable = false, precision = 22, scale = 0)
	public BigDecimal getLaaId() {
		return this.laaId;
	}

	public void setLaaId(BigDecimal laaId) {
		this.laaId = laaId;
	}

	@Column(name = "LAA_AAO_CODE", nullable = false, length = 20)
	public String getLaaAaoCode() {
		return this.laaAaoCode;
	}

	public void setLaaAaoCode(String laaAaoCode) {
		this.laaAaoCode = laaAaoCode;
	}

	@Column(name = "LAA_OBJET", nullable = false, length = 1000)
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

	@Column(name = "LAA_ANO", length = 3)
	public String getLaaAno() {
		return this.laaAno;
	}

	public void setLaaAno(String laaAno) {
		this.laaAno = laaAno;
	}

	@Column(name = "CHECKTRT", precision = 22, scale = 0)
	public BigDecimal getChecktrt() {
		return this.checktrt;
	}

	public void setChecktrt(BigDecimal checktrt) {
		this.checktrt = checktrt;
	}

	@Column(name = "LAA_OBSERVATION_DMP", length = 4000)
	public String getLaaObservationDmp() {
		return this.laaObservationDmp;
	}

	public void setLaaObservationDmp(String laaObservationDmp) {
		this.laaObservationDmp = laaObservationDmp;
	}

	@Column(name = "LIB_ANO", length = 4000)
	public String getLibAno() {
		return this.libAno;
	}

	public void setLibAno(String libAno) {
		this.libAno = libAno;
	}

	@Column(name = "LIB_AO", length = 4000)
	public String getLibAo() {
		return this.libAo;
	}

	public void setLibAo(String libAo) {
		this.libAo = libAo;
	}

	@Column(name = "LIBLOTNARA", length = 63)
	public String getLiblotnara() {
		return this.liblotnara;
	}

	public void setLiblotnara(String liblotnara) {
		this.liblotnara = liblotnara;
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

	@Column(name = "LAA_NUM", nullable = false, precision = 22, scale = 0)
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
	
	@Column(name = "ATT_SOU_NCC", length = 20)
	public String getAttSouNcc() {
		return this.attSouNcc;
	}

	public void setAttSouNcc(String attSouNcc) {
		this.attSouNcc = attSouNcc;
	}

	@Column(name = "ATT_MT_ATTR", precision = 22, scale = 0)
	public BigDecimal getAttMtAttr() {
		return this.attMtAttr;
	}

	public void setAttMtAttr(BigDecimal attMtAttr) {
		this.attMtAttr = attMtAttr;
	}

	@Column(name = "SOU_SIGLE_STE", length = 300)
	public String getSouSigleSte() {
		return this.souSigleSte;
	}

	public void setSouSigleSte(String souSigleSte) {
		this.souSigleSte = souSigleSte;
	}

}
