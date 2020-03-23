package com.sndi.models;
// Generated 23 mars 2020 10:48:44 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VbLotAaoId generated by hbm2java
 */
@Embeddable
public class VbLotAaoId implements java.io.Serializable {

	private BigDecimal laaId;
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

	public VbLotAaoId() {
	}

	public VbLotAaoId(BigDecimal laaId) {
		this.laaId = laaId;
	}

	public VbLotAaoId(BigDecimal laaId, String laaAaoCode, String laaObjet, String laaObservation, BigDecimal laaMtCaut,
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

	@Column(name = "LAA_ID", nullable = false, precision = 22, scale = 0)
	public BigDecimal getLaaId() {
		return this.laaId;
	}

	public void setLaaId(BigDecimal laaId) {
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

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VbLotAaoId))
			return false;
		VbLotAaoId castOther = (VbLotAaoId) other;

		return ((this.getLaaId() == castOther.getLaaId()) || (this.getLaaId() != null && castOther.getLaaId() != null
				&& this.getLaaId().equals(castOther.getLaaId())))
				&& ((this.getLaaAaoCode() == castOther.getLaaAaoCode()) || (this.getLaaAaoCode() != null
						&& castOther.getLaaAaoCode() != null && this.getLaaAaoCode().equals(castOther.getLaaAaoCode())))
				&& ((this.getLaaObjet() == castOther.getLaaObjet()) || (this.getLaaObjet() != null
						&& castOther.getLaaObjet() != null && this.getLaaObjet().equals(castOther.getLaaObjet())))
				&& ((this.getLaaObservation() == castOther.getLaaObservation())
						|| (this.getLaaObservation() != null && castOther.getLaaObservation() != null
								&& this.getLaaObservation().equals(castOther.getLaaObservation())))
				&& ((this.getLaaMtCaut() == castOther.getLaaMtCaut()) || (this.getLaaMtCaut() != null
						&& castOther.getLaaMtCaut() != null && this.getLaaMtCaut().equals(castOther.getLaaMtCaut())))
				&& ((this.getLaaMtEst() == castOther.getLaaMtEst()) || (this.getLaaMtEst() != null
						&& castOther.getLaaMtEst() != null && this.getLaaMtEst().equals(castOther.getLaaMtEst())))
				&& ((this.getLaaDteSaisi() == castOther.getLaaDteSaisi())
						|| (this.getLaaDteSaisi() != null && castOther.getLaaDteSaisi() != null
								&& this.getLaaDteSaisi().equals(castOther.getLaaDteSaisi())))
				&& ((this.getLaaStaCode() == castOther.getLaaStaCode()) || (this.getLaaStaCode() != null
						&& castOther.getLaaStaCode() != null && this.getLaaStaCode().equals(castOther.getLaaStaCode())))
				&& ((this.getLaaFonCodSaisi() == castOther.getLaaFonCodSaisi())
						|| (this.getLaaFonCodSaisi() != null && castOther.getLaaFonCodSaisi() != null
								&& this.getLaaFonCodSaisi().equals(castOther.getLaaFonCodSaisi())))
				&& ((this.getLaaFonCodCpmp() == castOther.getLaaFonCodCpmp())
						|| (this.getLaaFonCodCpmp() != null && castOther.getLaaFonCodCpmp() != null
								&& this.getLaaFonCodCpmp().equals(castOther.getLaaFonCodCpmp())))
				&& ((this.getLaaOpeMatricule() == castOther.getLaaOpeMatricule())
						|| (this.getLaaOpeMatricule() != null && castOther.getLaaOpeMatricule() != null
								&& this.getLaaOpeMatricule().equals(castOther.getLaaOpeMatricule())))
				&& ((this.getLaaLieuExe() == castOther.getLaaLieuExe()) || (this.getLaaLieuExe() != null
						&& castOther.getLaaLieuExe() != null && this.getLaaLieuExe().equals(castOther.getLaaLieuExe())))
				&& ((this.getLaaLbgImputation() == castOther.getLaaLbgImputation())
						|| (this.getLaaLbgImputation() != null && castOther.getLaaLbgImputation() != null
								&& this.getLaaLbgImputation().equals(castOther.getLaaLbgImputation())))
				&& ((this.getLaaNum() == castOther.getLaaNum()) || (this.getLaaNum() != null
						&& castOther.getLaaNum() != null && this.getLaaNum().equals(castOther.getLaaNum())))
				&& ((this.getLaaCoutLot() == castOther.getLaaCoutLot()) || (this.getLaaCoutLot() != null
						&& castOther.getLaaCoutLot() != null && this.getLaaCoutLot().equals(castOther.getLaaCoutLot())))
				&& ((this.getLaaDacCode() == castOther.getLaaDacCode())
						|| (this.getLaaDacCode() != null && castOther.getLaaDacCode() != null
								&& this.getLaaDacCode().equals(castOther.getLaaDacCode())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getLaaId() == null ? 0 : this.getLaaId().hashCode());
		result = 37 * result + (getLaaAaoCode() == null ? 0 : this.getLaaAaoCode().hashCode());
		result = 37 * result + (getLaaObjet() == null ? 0 : this.getLaaObjet().hashCode());
		result = 37 * result + (getLaaObservation() == null ? 0 : this.getLaaObservation().hashCode());
		result = 37 * result + (getLaaMtCaut() == null ? 0 : this.getLaaMtCaut().hashCode());
		result = 37 * result + (getLaaMtEst() == null ? 0 : this.getLaaMtEst().hashCode());
		result = 37 * result + (getLaaDteSaisi() == null ? 0 : this.getLaaDteSaisi().hashCode());
		result = 37 * result + (getLaaStaCode() == null ? 0 : this.getLaaStaCode().hashCode());
		result = 37 * result + (getLaaFonCodSaisi() == null ? 0 : this.getLaaFonCodSaisi().hashCode());
		result = 37 * result + (getLaaFonCodCpmp() == null ? 0 : this.getLaaFonCodCpmp().hashCode());
		result = 37 * result + (getLaaOpeMatricule() == null ? 0 : this.getLaaOpeMatricule().hashCode());
		result = 37 * result + (getLaaLieuExe() == null ? 0 : this.getLaaLieuExe().hashCode());
		result = 37 * result + (getLaaLbgImputation() == null ? 0 : this.getLaaLbgImputation().hashCode());
		result = 37 * result + (getLaaNum() == null ? 0 : this.getLaaNum().hashCode());
		result = 37 * result + (getLaaCoutLot() == null ? 0 : this.getLaaCoutLot().hashCode());
		result = 37 * result + (getLaaDacCode() == null ? 0 : this.getLaaDacCode().hashCode());
		return result;
	}

}
