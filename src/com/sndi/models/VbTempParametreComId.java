package com.sndi.models;
// Generated 26 mars 2020 03:50:59 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VbTempParametreComId generated by hbm2java
 */
@Embeddable
public class VbTempParametreComId implements java.io.Serializable {

	private BigDecimal tempNum;
	private String tempType;
	private String tempOpeMatricule;
	private Date tempDteSaisi;
	private String dcsMbmRespo;
	private String dcsNum;
	private String dcsDacCode;
	private String dcsFonCod;
	private String dcsSeaQuorum;
	private String dcsSeaNum;
	private String dcsDteSaisi;
	private String dcsFonCodSaisi;
	private String dcsObservation;
	private String dcsComTcoCode;
	private String dcsComNum;
	private String dcsNomMbm;
	private String dcsPreMbm;
	private String dcsTelMbm;
	private String dcsPresent;
	private String dcsComStrCode;
	private String dcsOpeMatSaisi;
	private String dcsNbrPli;
	private String dcsComTctCode;
	private String dcsRepMandate;
	private String dcsSeaTseNum;
	private String dcsAaoNbrOff;
	private String dcsAaoNbrOffAccept;
	private String dcsAaoNbrOffRej;
	private String dcsAaoNbrOffHorDelai;

	public VbTempParametreComId() {
	}

	public VbTempParametreComId(BigDecimal tempNum) {
		this.tempNum = tempNum;
	}

	public VbTempParametreComId(BigDecimal tempNum, String tempType, String tempOpeMatricule, Date tempDteSaisi,
			String dcsMbmRespo, String dcsNum, String dcsDacCode, String dcsFonCod, String dcsSeaQuorum,
			String dcsSeaNum, String dcsDteSaisi, String dcsFonCodSaisi, String dcsObservation, String dcsComTcoCode,
			String dcsComNum, String dcsNomMbm, String dcsPreMbm, String dcsTelMbm, String dcsPresent,
			String dcsComStrCode, String dcsOpeMatSaisi, String dcsNbrPli, String dcsComTctCode, String dcsRepMandate,
			String dcsSeaTseNum, String dcsAaoNbrOff, String dcsAaoNbrOffAccept, String dcsAaoNbrOffRej,
			String dcsAaoNbrOffHorDelai) {
		this.tempNum = tempNum;
		this.tempType = tempType;
		this.tempOpeMatricule = tempOpeMatricule;
		this.tempDteSaisi = tempDteSaisi;
		this.dcsMbmRespo = dcsMbmRespo;
		this.dcsNum = dcsNum;
		this.dcsDacCode = dcsDacCode;
		this.dcsFonCod = dcsFonCod;
		this.dcsSeaQuorum = dcsSeaQuorum;
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
		this.dcsNbrPli = dcsNbrPli;
		this.dcsComTctCode = dcsComTctCode;
		this.dcsRepMandate = dcsRepMandate;
		this.dcsSeaTseNum = dcsSeaTseNum;
		this.dcsAaoNbrOff = dcsAaoNbrOff;
		this.dcsAaoNbrOffAccept = dcsAaoNbrOffAccept;
		this.dcsAaoNbrOffRej = dcsAaoNbrOffRej;
		this.dcsAaoNbrOffHorDelai = dcsAaoNbrOffHorDelai;
	}

	@Column(name = "TEMP_NUM", nullable = false, precision = 22, scale = 0)
	public BigDecimal getTempNum() {
		return this.tempNum;
	}

	public void setTempNum(BigDecimal tempNum) {
		this.tempNum = tempNum;
	}

	@Column(name = "TEMP_TYPE", length = 500)
	public String getTempType() {
		return this.tempType;
	}

	public void setTempType(String tempType) {
		this.tempType = tempType;
	}

	@Column(name = "TEMP_OPE_MATRICULE", length = 500)
	public String getTempOpeMatricule() {
		return this.tempOpeMatricule;
	}

	public void setTempOpeMatricule(String tempOpeMatricule) {
		this.tempOpeMatricule = tempOpeMatricule;
	}

	@Column(name = "TEMP_DTE_SAISI", length = 7)
	public Date getTempDteSaisi() {
		return this.tempDteSaisi;
	}

	public void setTempDteSaisi(Date tempDteSaisi) {
		this.tempDteSaisi = tempDteSaisi;
	}

	@Column(name = "DCS_MBM_RESPO", length = 500)
	public String getDcsMbmRespo() {
		return this.dcsMbmRespo;
	}

	public void setDcsMbmRespo(String dcsMbmRespo) {
		this.dcsMbmRespo = dcsMbmRespo;
	}

	@Column(name = "DCS_NUM", length = 500)
	public String getDcsNum() {
		return this.dcsNum;
	}

	public void setDcsNum(String dcsNum) {
		this.dcsNum = dcsNum;
	}

	@Column(name = "DCS_DAC_CODE", length = 500)
	public String getDcsDacCode() {
		return this.dcsDacCode;
	}

	public void setDcsDacCode(String dcsDacCode) {
		this.dcsDacCode = dcsDacCode;
	}

	@Column(name = "DCS_FON_COD", length = 500)
	public String getDcsFonCod() {
		return this.dcsFonCod;
	}

	public void setDcsFonCod(String dcsFonCod) {
		this.dcsFonCod = dcsFonCod;
	}

	@Column(name = "DCS_SEA_QUORUM", length = 500)
	public String getDcsSeaQuorum() {
		return this.dcsSeaQuorum;
	}

	public void setDcsSeaQuorum(String dcsSeaQuorum) {
		this.dcsSeaQuorum = dcsSeaQuorum;
	}

	@Column(name = "DCS_SEA_NUM", length = 500)
	public String getDcsSeaNum() {
		return this.dcsSeaNum;
	}

	public void setDcsSeaNum(String dcsSeaNum) {
		this.dcsSeaNum = dcsSeaNum;
	}

	@Column(name = "DCS_DTE_SAISI", length = 500)
	public String getDcsDteSaisi() {
		return this.dcsDteSaisi;
	}

	public void setDcsDteSaisi(String dcsDteSaisi) {
		this.dcsDteSaisi = dcsDteSaisi;
	}

	@Column(name = "DCS_FON_COD_SAISI", length = 500)
	public String getDcsFonCodSaisi() {
		return this.dcsFonCodSaisi;
	}

	public void setDcsFonCodSaisi(String dcsFonCodSaisi) {
		this.dcsFonCodSaisi = dcsFonCodSaisi;
	}

	@Column(name = "DCS_OBSERVATION", length = 500)
	public String getDcsObservation() {
		return this.dcsObservation;
	}

	public void setDcsObservation(String dcsObservation) {
		this.dcsObservation = dcsObservation;
	}

	@Column(name = "DCS_COM_TCO_CODE", length = 500)
	public String getDcsComTcoCode() {
		return this.dcsComTcoCode;
	}

	public void setDcsComTcoCode(String dcsComTcoCode) {
		this.dcsComTcoCode = dcsComTcoCode;
	}

	@Column(name = "DCS_COM_NUM", length = 500)
	public String getDcsComNum() {
		return this.dcsComNum;
	}

	public void setDcsComNum(String dcsComNum) {
		this.dcsComNum = dcsComNum;
	}

	@Column(name = "DCS_NOM_MBM", length = 500)
	public String getDcsNomMbm() {
		return this.dcsNomMbm;
	}

	public void setDcsNomMbm(String dcsNomMbm) {
		this.dcsNomMbm = dcsNomMbm;
	}

	@Column(name = "DCS_PRE_MBM", length = 500)
	public String getDcsPreMbm() {
		return this.dcsPreMbm;
	}

	public void setDcsPreMbm(String dcsPreMbm) {
		this.dcsPreMbm = dcsPreMbm;
	}

	@Column(name = "DCS_TEL_MBM", length = 500)
	public String getDcsTelMbm() {
		return this.dcsTelMbm;
	}

	public void setDcsTelMbm(String dcsTelMbm) {
		this.dcsTelMbm = dcsTelMbm;
	}

	@Column(name = "DCS_PRESENT", length = 500)
	public String getDcsPresent() {
		return this.dcsPresent;
	}

	public void setDcsPresent(String dcsPresent) {
		this.dcsPresent = dcsPresent;
	}

	@Column(name = "DCS_COM_STR_CODE", length = 500)
	public String getDcsComStrCode() {
		return this.dcsComStrCode;
	}

	public void setDcsComStrCode(String dcsComStrCode) {
		this.dcsComStrCode = dcsComStrCode;
	}

	@Column(name = "DCS_OPE_MAT_SAISI", length = 500)
	public String getDcsOpeMatSaisi() {
		return this.dcsOpeMatSaisi;
	}

	public void setDcsOpeMatSaisi(String dcsOpeMatSaisi) {
		this.dcsOpeMatSaisi = dcsOpeMatSaisi;
	}

	@Column(name = "DCS_NBR_PLI", length = 500)
	public String getDcsNbrPli() {
		return this.dcsNbrPli;
	}

	public void setDcsNbrPli(String dcsNbrPli) {
		this.dcsNbrPli = dcsNbrPli;
	}

	@Column(name = "DCS_COM_TCT_CODE", length = 500)
	public String getDcsComTctCode() {
		return this.dcsComTctCode;
	}

	public void setDcsComTctCode(String dcsComTctCode) {
		this.dcsComTctCode = dcsComTctCode;
	}

	@Column(name = "DCS_REP_MANDATE", length = 500)
	public String getDcsRepMandate() {
		return this.dcsRepMandate;
	}

	public void setDcsRepMandate(String dcsRepMandate) {
		this.dcsRepMandate = dcsRepMandate;
	}

	@Column(name = "DCS_SEA_TSE_NUM", length = 500)
	public String getDcsSeaTseNum() {
		return this.dcsSeaTseNum;
	}

	public void setDcsSeaTseNum(String dcsSeaTseNum) {
		this.dcsSeaTseNum = dcsSeaTseNum;
	}

	@Column(name = "DCS_AAO_NBR_OFF", length = 500)
	public String getDcsAaoNbrOff() {
		return this.dcsAaoNbrOff;
	}

	public void setDcsAaoNbrOff(String dcsAaoNbrOff) {
		this.dcsAaoNbrOff = dcsAaoNbrOff;
	}

	@Column(name = "DCS_AAO_NBR_OFF_ACCEPT", length = 500)
	public String getDcsAaoNbrOffAccept() {
		return this.dcsAaoNbrOffAccept;
	}

	public void setDcsAaoNbrOffAccept(String dcsAaoNbrOffAccept) {
		this.dcsAaoNbrOffAccept = dcsAaoNbrOffAccept;
	}

	@Column(name = "DCS_AAO_NBR_OFF_REJ", length = 500)
	public String getDcsAaoNbrOffRej() {
		return this.dcsAaoNbrOffRej;
	}

	public void setDcsAaoNbrOffRej(String dcsAaoNbrOffRej) {
		this.dcsAaoNbrOffRej = dcsAaoNbrOffRej;
	}

	@Column(name = "DCS_AAO_NBR_OFF_HOR_DELAI", length = 500)
	public String getDcsAaoNbrOffHorDelai() {
		return this.dcsAaoNbrOffHorDelai;
	}

	public void setDcsAaoNbrOffHorDelai(String dcsAaoNbrOffHorDelai) {
		this.dcsAaoNbrOffHorDelai = dcsAaoNbrOffHorDelai;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VbTempParametreComId))
			return false;
		VbTempParametreComId castOther = (VbTempParametreComId) other;

		return ((this.getTempNum() == castOther.getTempNum()) || (this.getTempNum() != null
				&& castOther.getTempNum() != null && this.getTempNum().equals(castOther.getTempNum())))
				&& ((this.getTempType() == castOther.getTempType()) || (this.getTempType() != null
						&& castOther.getTempType() != null && this.getTempType().equals(castOther.getTempType())))
				&& ((this.getTempOpeMatricule() == castOther.getTempOpeMatricule())
						|| (this.getTempOpeMatricule() != null && castOther.getTempOpeMatricule() != null
								&& this.getTempOpeMatricule().equals(castOther.getTempOpeMatricule())))
				&& ((this.getTempDteSaisi() == castOther.getTempDteSaisi())
						|| (this.getTempDteSaisi() != null && castOther.getTempDteSaisi() != null
								&& this.getTempDteSaisi().equals(castOther.getTempDteSaisi())))
				&& ((this.getDcsMbmRespo() == castOther.getDcsMbmRespo())
						|| (this.getDcsMbmRespo() != null && castOther.getDcsMbmRespo() != null
								&& this.getDcsMbmRespo().equals(castOther.getDcsMbmRespo())))
				&& ((this.getDcsNum() == castOther.getDcsNum()) || (this.getDcsNum() != null
						&& castOther.getDcsNum() != null && this.getDcsNum().equals(castOther.getDcsNum())))
				&& ((this.getDcsDacCode() == castOther.getDcsDacCode()) || (this.getDcsDacCode() != null
						&& castOther.getDcsDacCode() != null && this.getDcsDacCode().equals(castOther.getDcsDacCode())))
				&& ((this.getDcsFonCod() == castOther.getDcsFonCod()) || (this.getDcsFonCod() != null
						&& castOther.getDcsFonCod() != null && this.getDcsFonCod().equals(castOther.getDcsFonCod())))
				&& ((this.getDcsSeaQuorum() == castOther.getDcsSeaQuorum())
						|| (this.getDcsSeaQuorum() != null && castOther.getDcsSeaQuorum() != null
								&& this.getDcsSeaQuorum().equals(castOther.getDcsSeaQuorum())))
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
				&& ((this.getDcsNbrPli() == castOther.getDcsNbrPli()) || (this.getDcsNbrPli() != null
						&& castOther.getDcsNbrPli() != null && this.getDcsNbrPli().equals(castOther.getDcsNbrPli())))
				&& ((this.getDcsComTctCode() == castOther.getDcsComTctCode())
						|| (this.getDcsComTctCode() != null && castOther.getDcsComTctCode() != null
								&& this.getDcsComTctCode().equals(castOther.getDcsComTctCode())))
				&& ((this.getDcsRepMandate() == castOther.getDcsRepMandate())
						|| (this.getDcsRepMandate() != null && castOther.getDcsRepMandate() != null
								&& this.getDcsRepMandate().equals(castOther.getDcsRepMandate())))
				&& ((this.getDcsSeaTseNum() == castOther.getDcsSeaTseNum())
						|| (this.getDcsSeaTseNum() != null && castOther.getDcsSeaTseNum() != null
								&& this.getDcsSeaTseNum().equals(castOther.getDcsSeaTseNum())))
				&& ((this.getDcsAaoNbrOff() == castOther.getDcsAaoNbrOff())
						|| (this.getDcsAaoNbrOff() != null && castOther.getDcsAaoNbrOff() != null
								&& this.getDcsAaoNbrOff().equals(castOther.getDcsAaoNbrOff())))
				&& ((this.getDcsAaoNbrOffAccept() == castOther.getDcsAaoNbrOffAccept())
						|| (this.getDcsAaoNbrOffAccept() != null && castOther.getDcsAaoNbrOffAccept() != null
								&& this.getDcsAaoNbrOffAccept().equals(castOther.getDcsAaoNbrOffAccept())))
				&& ((this.getDcsAaoNbrOffRej() == castOther.getDcsAaoNbrOffRej())
						|| (this.getDcsAaoNbrOffRej() != null && castOther.getDcsAaoNbrOffRej() != null
								&& this.getDcsAaoNbrOffRej().equals(castOther.getDcsAaoNbrOffRej())))
				&& ((this.getDcsAaoNbrOffHorDelai() == castOther.getDcsAaoNbrOffHorDelai())
						|| (this.getDcsAaoNbrOffHorDelai() != null && castOther.getDcsAaoNbrOffHorDelai() != null
								&& this.getDcsAaoNbrOffHorDelai().equals(castOther.getDcsAaoNbrOffHorDelai())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getTempNum() == null ? 0 : this.getTempNum().hashCode());
		result = 37 * result + (getTempType() == null ? 0 : this.getTempType().hashCode());
		result = 37 * result + (getTempOpeMatricule() == null ? 0 : this.getTempOpeMatricule().hashCode());
		result = 37 * result + (getTempDteSaisi() == null ? 0 : this.getTempDteSaisi().hashCode());
		result = 37 * result + (getDcsMbmRespo() == null ? 0 : this.getDcsMbmRespo().hashCode());
		result = 37 * result + (getDcsNum() == null ? 0 : this.getDcsNum().hashCode());
		result = 37 * result + (getDcsDacCode() == null ? 0 : this.getDcsDacCode().hashCode());
		result = 37 * result + (getDcsFonCod() == null ? 0 : this.getDcsFonCod().hashCode());
		result = 37 * result + (getDcsSeaQuorum() == null ? 0 : this.getDcsSeaQuorum().hashCode());
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
		result = 37 * result + (getDcsNbrPli() == null ? 0 : this.getDcsNbrPli().hashCode());
		result = 37 * result + (getDcsComTctCode() == null ? 0 : this.getDcsComTctCode().hashCode());
		result = 37 * result + (getDcsRepMandate() == null ? 0 : this.getDcsRepMandate().hashCode());
		result = 37 * result + (getDcsSeaTseNum() == null ? 0 : this.getDcsSeaTseNum().hashCode());
		result = 37 * result + (getDcsAaoNbrOff() == null ? 0 : this.getDcsAaoNbrOff().hashCode());
		result = 37 * result + (getDcsAaoNbrOffAccept() == null ? 0 : this.getDcsAaoNbrOffAccept().hashCode());
		result = 37 * result + (getDcsAaoNbrOffRej() == null ? 0 : this.getDcsAaoNbrOffRej().hashCode());
		result = 37 * result + (getDcsAaoNbrOffHorDelai() == null ? 0 : this.getDcsAaoNbrOffHorDelai().hashCode());
		return result;
	}

}
