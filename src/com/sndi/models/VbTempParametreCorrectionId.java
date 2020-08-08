package com.sndi.models;
// Generated 8 ao�t 2020 14:11:26 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VbTempParametreCorrectionId generated by hbm2java
 */
@Embeddable
public class VbTempParametreCorrectionId implements java.io.Serializable {

	private BigDecimal tempNum;
	private String tempType;
	private String dcoOpeMatricule;
	private Date dcoDteSaisi;
	private String dcoTitre;
	private String dcoLibelle;
	private String dcoPidCode;
	private String dcoDacCode;
	private String dcoFonCodSaisi;
	private String dcoObservation;
	private String dcoCorNum;

	public VbTempParametreCorrectionId() {
	}

	public VbTempParametreCorrectionId(BigDecimal tempNum) {
		this.tempNum = tempNum;
	}

	public VbTempParametreCorrectionId(BigDecimal tempNum, String tempType, String dcoOpeMatricule, Date dcoDteSaisi,
			String dcoTitre, String dcoLibelle, String dcoPidCode, String dcoDacCode, String dcoFonCodSaisi,
			String dcoObservation, String dcoCorNum) {
		this.tempNum = tempNum;
		this.tempType = tempType;
		this.dcoOpeMatricule = dcoOpeMatricule;
		this.dcoDteSaisi = dcoDteSaisi;
		this.dcoTitre = dcoTitre;
		this.dcoLibelle = dcoLibelle;
		this.dcoPidCode = dcoPidCode;
		this.dcoDacCode = dcoDacCode;
		this.dcoFonCodSaisi = dcoFonCodSaisi;
		this.dcoObservation = dcoObservation;
		this.dcoCorNum = dcoCorNum;
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

	@Column(name = "DCO_OPE_MATRICULE", length = 500)
	public String getDcoOpeMatricule() {
		return this.dcoOpeMatricule;
	}

	public void setDcoOpeMatricule(String dcoOpeMatricule) {
		this.dcoOpeMatricule = dcoOpeMatricule;
	}

	@Column(name = "DCO_DTE_SAISI", length = 7)
	public Date getDcoDteSaisi() {
		return this.dcoDteSaisi;
	}

	public void setDcoDteSaisi(Date dcoDteSaisi) {
		this.dcoDteSaisi = dcoDteSaisi;
	}

	@Column(name = "DCO_TITRE", length = 500)
	public String getDcoTitre() {
		return this.dcoTitre;
	}

	public void setDcoTitre(String dcoTitre) {
		this.dcoTitre = dcoTitre;
	}

	@Column(name = "DCO_LIBELLE", length = 500)
	public String getDcoLibelle() {
		return this.dcoLibelle;
	}

	public void setDcoLibelle(String dcoLibelle) {
		this.dcoLibelle = dcoLibelle;
	}

	@Column(name = "DCO_PID_CODE", length = 500)
	public String getDcoPidCode() {
		return this.dcoPidCode;
	}

	public void setDcoPidCode(String dcoPidCode) {
		this.dcoPidCode = dcoPidCode;
	}

	@Column(name = "DCO_DAC_CODE", length = 500)
	public String getDcoDacCode() {
		return this.dcoDacCode;
	}

	public void setDcoDacCode(String dcoDacCode) {
		this.dcoDacCode = dcoDacCode;
	}

	@Column(name = "DCO_FON_COD_SAISI", length = 500)
	public String getDcoFonCodSaisi() {
		return this.dcoFonCodSaisi;
	}

	public void setDcoFonCodSaisi(String dcoFonCodSaisi) {
		this.dcoFonCodSaisi = dcoFonCodSaisi;
	}

	@Column(name = "DCO_OBSERVATION", length = 500)
	public String getDcoObservation() {
		return this.dcoObservation;
	}

	public void setDcoObservation(String dcoObservation) {
		this.dcoObservation = dcoObservation;
	}

	@Column(name = "DCO_COR_NUM", length = 500)
	public String getDcoCorNum() {
		return this.dcoCorNum;
	}

	public void setDcoCorNum(String dcoCorNum) {
		this.dcoCorNum = dcoCorNum;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VbTempParametreCorrectionId))
			return false;
		VbTempParametreCorrectionId castOther = (VbTempParametreCorrectionId) other;

		return ((this.getTempNum() == castOther.getTempNum()) || (this.getTempNum() != null
				&& castOther.getTempNum() != null && this.getTempNum().equals(castOther.getTempNum())))
				&& ((this.getTempType() == castOther.getTempType()) || (this.getTempType() != null
						&& castOther.getTempType() != null && this.getTempType().equals(castOther.getTempType())))
				&& ((this.getDcoOpeMatricule() == castOther.getDcoOpeMatricule())
						|| (this.getDcoOpeMatricule() != null && castOther.getDcoOpeMatricule() != null
								&& this.getDcoOpeMatricule().equals(castOther.getDcoOpeMatricule())))
				&& ((this.getDcoDteSaisi() == castOther.getDcoDteSaisi())
						|| (this.getDcoDteSaisi() != null && castOther.getDcoDteSaisi() != null
								&& this.getDcoDteSaisi().equals(castOther.getDcoDteSaisi())))
				&& ((this.getDcoTitre() == castOther.getDcoTitre()) || (this.getDcoTitre() != null
						&& castOther.getDcoTitre() != null && this.getDcoTitre().equals(castOther.getDcoTitre())))
				&& ((this.getDcoLibelle() == castOther.getDcoLibelle()) || (this.getDcoLibelle() != null
						&& castOther.getDcoLibelle() != null && this.getDcoLibelle().equals(castOther.getDcoLibelle())))
				&& ((this.getDcoPidCode() == castOther.getDcoPidCode()) || (this.getDcoPidCode() != null
						&& castOther.getDcoPidCode() != null && this.getDcoPidCode().equals(castOther.getDcoPidCode())))
				&& ((this.getDcoDacCode() == castOther.getDcoDacCode()) || (this.getDcoDacCode() != null
						&& castOther.getDcoDacCode() != null && this.getDcoDacCode().equals(castOther.getDcoDacCode())))
				&& ((this.getDcoFonCodSaisi() == castOther.getDcoFonCodSaisi())
						|| (this.getDcoFonCodSaisi() != null && castOther.getDcoFonCodSaisi() != null
								&& this.getDcoFonCodSaisi().equals(castOther.getDcoFonCodSaisi())))
				&& ((this.getDcoObservation() == castOther.getDcoObservation())
						|| (this.getDcoObservation() != null && castOther.getDcoObservation() != null
								&& this.getDcoObservation().equals(castOther.getDcoObservation())))
				&& ((this.getDcoCorNum() == castOther.getDcoCorNum()) || (this.getDcoCorNum() != null
						&& castOther.getDcoCorNum() != null && this.getDcoCorNum().equals(castOther.getDcoCorNum())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getTempNum() == null ? 0 : this.getTempNum().hashCode());
		result = 37 * result + (getTempType() == null ? 0 : this.getTempType().hashCode());
		result = 37 * result + (getDcoOpeMatricule() == null ? 0 : this.getDcoOpeMatricule().hashCode());
		result = 37 * result + (getDcoDteSaisi() == null ? 0 : this.getDcoDteSaisi().hashCode());
		result = 37 * result + (getDcoTitre() == null ? 0 : this.getDcoTitre().hashCode());
		result = 37 * result + (getDcoLibelle() == null ? 0 : this.getDcoLibelle().hashCode());
		result = 37 * result + (getDcoPidCode() == null ? 0 : this.getDcoPidCode().hashCode());
		result = 37 * result + (getDcoDacCode() == null ? 0 : this.getDcoDacCode().hashCode());
		result = 37 * result + (getDcoFonCodSaisi() == null ? 0 : this.getDcoFonCodSaisi().hashCode());
		result = 37 * result + (getDcoObservation() == null ? 0 : this.getDcoObservation().hashCode());
		result = 37 * result + (getDcoCorNum() == null ? 0 : this.getDcoCorNum().hashCode());
		return result;
	}

}
