package com.sndi.models;
// Generated 19 mars 2020 16:14:06 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VbDetCommissionSeanceId generated by hbm2java
 */
@Embeddable
public class VbDetCommissionSeanceId implements java.io.Serializable {

	private BigDecimal dcsNum;
	private String dcsDacCode;
	private String dcsFonCod;
	private String dcsOpeMatricule;
	private BigDecimal dcsSeaNum;
	private Date dcsDteSaisi;
	private String dcsFonCodSaisi;
	private String dcsObservation;
	private String dcsComTcoCode;
	private BigDecimal dcsComNum;
	private String dcsNomMbm;
	private String dcsPreMbm;
	private String dcsTelMbm;
	private String dcsPresent;
	private String dcsComStrCode;
	private String dcsOpeMatSaisi;
	private String dcsMbmRespo;
	private String dcsRepMandate;

	public VbDetCommissionSeanceId() {
	}

	public VbDetCommissionSeanceId(BigDecimal dcsNum) {
		this.dcsNum = dcsNum;
	}

	public VbDetCommissionSeanceId(BigDecimal dcsNum, String dcsDacCode, String dcsFonCod, String dcsOpeMatricule,
			BigDecimal dcsSeaNum, Date dcsDteSaisi, String dcsFonCodSaisi, String dcsObservation, String dcsComTcoCode,
			BigDecimal dcsComNum, String dcsNomMbm, String dcsPreMbm, String dcsTelMbm, String dcsPresent,
			String dcsComStrCode, String dcsOpeMatSaisi, String dcsMbmRespo, String dcsRepMandate) {
		this.dcsNum = dcsNum;
		this.dcsDacCode = dcsDacCode;
		this.dcsFonCod = dcsFonCod;
		this.dcsOpeMatricule = dcsOpeMatricule;
		this.dcsSeaNum = dcsSeaNum;
		this.dcsDteSaisi = dcsDteSaisi;
		this.dcsFonCodSaisi = dcsFonCodSaisi;
		this.dcsObservation = dcsObservation;
		this.dcsComTcoCode = dcsComTcoCode;
		this.dcsComNum = dcsComNum;
		this.dcsNomMbm = dcsNomMbm;
		this.dcsPreMbm = dcsPreMbm;
		this.dcsTelMbm = dcsTelMbm;
		this.dcsPresent = dcsPresent;
		this.dcsComStrCode = dcsComStrCode;
		this.dcsOpeMatSaisi = dcsOpeMatSaisi;
		this.dcsMbmRespo = dcsMbmRespo;
		this.dcsRepMandate = dcsRepMandate;
	}

	@Column(name = "DCS_NUM", nullable = false, precision = 22, scale = 0)
	public BigDecimal getDcsNum() {
		return this.dcsNum;
	}

	public void setDcsNum(BigDecimal dcsNum) {
		this.dcsNum = dcsNum;
	}

	@Column(name = "DCS_DAC_CODE", length = 20)
	public String getDcsDacCode() {
		return this.dcsDacCode;
	}

	public void setDcsDacCode(String dcsDacCode) {
		this.dcsDacCode = dcsDacCode;
	}

	@Column(name = "DCS_FON_COD", length = 100)
	public String getDcsFonCod() {
		return this.dcsFonCod;
	}

	public void setDcsFonCod(String dcsFonCod) {
		this.dcsFonCod = dcsFonCod;
	}

	@Column(name = "DCS_OPE_MATRICULE", length = 20)
	public String getDcsOpeMatricule() {
		return this.dcsOpeMatricule;
	}

	public void setDcsOpeMatricule(String dcsOpeMatricule) {
		this.dcsOpeMatricule = dcsOpeMatricule;
	}

	@Column(name = "DCS_SEA_NUM", precision = 22, scale = 0)
	public BigDecimal getDcsSeaNum() {
		return this.dcsSeaNum;
	}

	public void setDcsSeaNum(BigDecimal dcsSeaNum) {
		this.dcsSeaNum = dcsSeaNum;
	}

	@Column(name = "DCS_DTE_SAISI", length = 7)
	public Date getDcsDteSaisi() {
		return this.dcsDteSaisi;
	}

	public void setDcsDteSaisi(Date dcsDteSaisi) {
		this.dcsDteSaisi = dcsDteSaisi;
	}

	@Column(name = "DCS_FON_COD_SAISI", length = 12)
	public String getDcsFonCodSaisi() {
		return this.dcsFonCodSaisi;
	}

	public void setDcsFonCodSaisi(String dcsFonCodSaisi) {
		this.dcsFonCodSaisi = dcsFonCodSaisi;
	}

	@Column(name = "DCS_OBSERVATION", length = 200)
	public String getDcsObservation() {
		return this.dcsObservation;
	}

	public void setDcsObservation(String dcsObservation) {
		this.dcsObservation = dcsObservation;
	}

	@Column(name = "DCS_COM_TCO_CODE", length = 3)
	public String getDcsComTcoCode() {
		return this.dcsComTcoCode;
	}

	public void setDcsComTcoCode(String dcsComTcoCode) {
		this.dcsComTcoCode = dcsComTcoCode;
	}

	@Column(name = "DCS_COM_NUM", precision = 22, scale = 0)
	public BigDecimal getDcsComNum() {
		return this.dcsComNum;
	}

	public void setDcsComNum(BigDecimal dcsComNum) {
		this.dcsComNum = dcsComNum;
	}

	@Column(name = "DCS_NOM_MBM", length = 100)
	public String getDcsNomMbm() {
		return this.dcsNomMbm;
	}

	public void setDcsNomMbm(String dcsNomMbm) {
		this.dcsNomMbm = dcsNomMbm;
	}

	@Column(name = "DCS_PRE_MBM", length = 200)
	public String getDcsPreMbm() {
		return this.dcsPreMbm;
	}

	public void setDcsPreMbm(String dcsPreMbm) {
		this.dcsPreMbm = dcsPreMbm;
	}

	@Column(name = "DCS_TEL_MBM", length = 50)
	public String getDcsTelMbm() {
		return this.dcsTelMbm;
	}

	public void setDcsTelMbm(String dcsTelMbm) {
		this.dcsTelMbm = dcsTelMbm;
	}

	@Column(name = "DCS_PRESENT", length = 1)
	public String getDcsPresent() {
		return this.dcsPresent;
	}

	public void setDcsPresent(String dcsPresent) {
		this.dcsPresent = dcsPresent;
	}

	@Column(name = "DCS_COM_STR_CODE", length = 20)
	public String getDcsComStrCode() {
		return this.dcsComStrCode;
	}

	public void setDcsComStrCode(String dcsComStrCode) {
		this.dcsComStrCode = dcsComStrCode;
	}

	@Column(name = "DCS_OPE_MAT_SAISI", length = 20)
	public String getDcsOpeMatSaisi() {
		return this.dcsOpeMatSaisi;
	}

	public void setDcsOpeMatSaisi(String dcsOpeMatSaisi) {
		this.dcsOpeMatSaisi = dcsOpeMatSaisi;
	}

	@Column(name = "DCS_MBM_RESPO", length = 1)
	public String getDcsMbmRespo() {
		return this.dcsMbmRespo;
	}

	public void setDcsMbmRespo(String dcsMbmRespo) {
		this.dcsMbmRespo = dcsMbmRespo;
	}

	@Column(name = "DCS_REP_MANDATE", length = 1)
	public String getDcsRepMandate() {
		return this.dcsRepMandate;
	}

	public void setDcsRepMandate(String dcsRepMandate) {
		this.dcsRepMandate = dcsRepMandate;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VbDetCommissionSeanceId))
			return false;
		VbDetCommissionSeanceId castOther = (VbDetCommissionSeanceId) other;

		return ((this.getDcsNum() == castOther.getDcsNum()) || (this.getDcsNum() != null
				&& castOther.getDcsNum() != null && this.getDcsNum().equals(castOther.getDcsNum())))
				&& ((this.getDcsDacCode() == castOther.getDcsDacCode()) || (this.getDcsDacCode() != null
						&& castOther.getDcsDacCode() != null && this.getDcsDacCode().equals(castOther.getDcsDacCode())))
				&& ((this.getDcsFonCod() == castOther.getDcsFonCod()) || (this.getDcsFonCod() != null
						&& castOther.getDcsFonCod() != null && this.getDcsFonCod().equals(castOther.getDcsFonCod())))
				&& ((this.getDcsOpeMatricule() == castOther.getDcsOpeMatricule())
						|| (this.getDcsOpeMatricule() != null && castOther.getDcsOpeMatricule() != null
								&& this.getDcsOpeMatricule().equals(castOther.getDcsOpeMatricule())))
				&& ((this.getDcsSeaNum() == castOther.getDcsSeaNum()) || (this.getDcsSeaNum() != null
						&& castOther.getDcsSeaNum() != null && this.getDcsSeaNum().equals(castOther.getDcsSeaNum())))
				&& ((this.getDcsDteSaisi() == castOther.getDcsDteSaisi())
						|| (this.getDcsDteSaisi() != null && castOther.getDcsDteSaisi() != null
								&& this.getDcsDteSaisi().equals(castOther.getDcsDteSaisi())))
				&& ((this.getDcsFonCodSaisi() == castOther.getDcsFonCodSaisi())
						|| (this.getDcsFonCodSaisi() != null && castOther.getDcsFonCodSaisi() != null
								&& this.getDcsFonCodSaisi().equals(castOther.getDcsFonCodSaisi())))
				&& ((this.getDcsObservation() == castOther.getDcsObservation())
						|| (this.getDcsObservation() != null && castOther.getDcsObservation() != null
								&& this.getDcsObservation().equals(castOther.getDcsObservation())))
				&& ((this.getDcsComTcoCode() == castOther.getDcsComTcoCode())
						|| (this.getDcsComTcoCode() != null && castOther.getDcsComTcoCode() != null
								&& this.getDcsComTcoCode().equals(castOther.getDcsComTcoCode())))
				&& ((this.getDcsComNum() == castOther.getDcsComNum()) || (this.getDcsComNum() != null
						&& castOther.getDcsComNum() != null && this.getDcsComNum().equals(castOther.getDcsComNum())))
				&& ((this.getDcsNomMbm() == castOther.getDcsNomMbm()) || (this.getDcsNomMbm() != null
						&& castOther.getDcsNomMbm() != null && this.getDcsNomMbm().equals(castOther.getDcsNomMbm())))
				&& ((this.getDcsPreMbm() == castOther.getDcsPreMbm()) || (this.getDcsPreMbm() != null
						&& castOther.getDcsPreMbm() != null && this.getDcsPreMbm().equals(castOther.getDcsPreMbm())))
				&& ((this.getDcsTelMbm() == castOther.getDcsTelMbm()) || (this.getDcsTelMbm() != null
						&& castOther.getDcsTelMbm() != null && this.getDcsTelMbm().equals(castOther.getDcsTelMbm())))
				&& ((this.getDcsPresent() == castOther.getDcsPresent()) || (this.getDcsPresent() != null
						&& castOther.getDcsPresent() != null && this.getDcsPresent().equals(castOther.getDcsPresent())))
				&& ((this.getDcsComStrCode() == castOther.getDcsComStrCode())
						|| (this.getDcsComStrCode() != null && castOther.getDcsComStrCode() != null
								&& this.getDcsComStrCode().equals(castOther.getDcsComStrCode())))
				&& ((this.getDcsOpeMatSaisi() == castOther.getDcsOpeMatSaisi())
						|| (this.getDcsOpeMatSaisi() != null && castOther.getDcsOpeMatSaisi() != null
								&& this.getDcsOpeMatSaisi().equals(castOther.getDcsOpeMatSaisi())))
				&& ((this.getDcsMbmRespo() == castOther.getDcsMbmRespo())
						|| (this.getDcsMbmRespo() != null && castOther.getDcsMbmRespo() != null
								&& this.getDcsMbmRespo().equals(castOther.getDcsMbmRespo())))
				&& ((this.getDcsRepMandate() == castOther.getDcsRepMandate())
						|| (this.getDcsRepMandate() != null && castOther.getDcsRepMandate() != null
								&& this.getDcsRepMandate().equals(castOther.getDcsRepMandate())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getDcsNum() == null ? 0 : this.getDcsNum().hashCode());
		result = 37 * result + (getDcsDacCode() == null ? 0 : this.getDcsDacCode().hashCode());
		result = 37 * result + (getDcsFonCod() == null ? 0 : this.getDcsFonCod().hashCode());
		result = 37 * result + (getDcsOpeMatricule() == null ? 0 : this.getDcsOpeMatricule().hashCode());
		result = 37 * result + (getDcsSeaNum() == null ? 0 : this.getDcsSeaNum().hashCode());
		result = 37 * result + (getDcsDteSaisi() == null ? 0 : this.getDcsDteSaisi().hashCode());
		result = 37 * result + (getDcsFonCodSaisi() == null ? 0 : this.getDcsFonCodSaisi().hashCode());
		result = 37 * result + (getDcsObservation() == null ? 0 : this.getDcsObservation().hashCode());
		result = 37 * result + (getDcsComTcoCode() == null ? 0 : this.getDcsComTcoCode().hashCode());
		result = 37 * result + (getDcsComNum() == null ? 0 : this.getDcsComNum().hashCode());
		result = 37 * result + (getDcsNomMbm() == null ? 0 : this.getDcsNomMbm().hashCode());
		result = 37 * result + (getDcsPreMbm() == null ? 0 : this.getDcsPreMbm().hashCode());
		result = 37 * result + (getDcsTelMbm() == null ? 0 : this.getDcsTelMbm().hashCode());
		result = 37 * result + (getDcsPresent() == null ? 0 : this.getDcsPresent().hashCode());
		result = 37 * result + (getDcsComStrCode() == null ? 0 : this.getDcsComStrCode().hashCode());
		result = 37 * result + (getDcsOpeMatSaisi() == null ? 0 : this.getDcsOpeMatSaisi().hashCode());
		result = 37 * result + (getDcsMbmRespo() == null ? 0 : this.getDcsMbmRespo().hashCode());
		result = 37 * result + (getDcsRepMandate() == null ? 0 : this.getDcsRepMandate().hashCode());
		return result;
	}

}
