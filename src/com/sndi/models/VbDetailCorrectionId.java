package com.sndi.models;
// Generated 21 mars 2020 13:48:08 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VbDetailCorrectionId generated by hbm2java
 */
@Embeddable
public class VbDetailCorrectionId implements java.io.Serializable {

	private BigDecimal dcoNum;
	private String dcoTitre;
	private String dcoLibelle;
	private Date dcoDteSaisi;
	private BigDecimal dcoPidCode;
	private String dcoDacCode;
	private String dcoFonCodSaisi;
	private String dcoOpeMatricule;
	private String dcoObservation;
	private BigDecimal dcoCorNum;

	public VbDetailCorrectionId() {
	}

	public VbDetailCorrectionId(BigDecimal dcoNum) {
		this.dcoNum = dcoNum;
	}

	public VbDetailCorrectionId(BigDecimal dcoNum, String dcoTitre, String dcoLibelle, Date dcoDteSaisi,
			BigDecimal dcoPidCode, String dcoDacCode, String dcoFonCodSaisi, String dcoOpeMatricule,
			String dcoObservation, BigDecimal dcoCorNum) {
		this.dcoNum = dcoNum;
		this.dcoTitre = dcoTitre;
		this.dcoLibelle = dcoLibelle;
		this.dcoDteSaisi = dcoDteSaisi;
		this.dcoPidCode = dcoPidCode;
		this.dcoDacCode = dcoDacCode;
		this.dcoFonCodSaisi = dcoFonCodSaisi;
		this.dcoOpeMatricule = dcoOpeMatricule;
		this.dcoObservation = dcoObservation;
		this.dcoCorNum = dcoCorNum;
	}

	@Column(name = "DCO_NUM", nullable = false, precision = 22, scale = 0)
	public BigDecimal getDcoNum() {
		return this.dcoNum;
	}

	public void setDcoNum(BigDecimal dcoNum) {
		this.dcoNum = dcoNum;
	}

	@Column(name = "DCO_TITRE", length = 200)
	public String getDcoTitre() {
		return this.dcoTitre;
	}

	public void setDcoTitre(String dcoTitre) {
		this.dcoTitre = dcoTitre;
	}

	@Column(name = "DCO_LIBELLE", length = 1000)
	public String getDcoLibelle() {
		return this.dcoLibelle;
	}

	public void setDcoLibelle(String dcoLibelle) {
		this.dcoLibelle = dcoLibelle;
	}

	@Column(name = "DCO_DTE_SAISI", length = 7)
	public Date getDcoDteSaisi() {
		return this.dcoDteSaisi;
	}

	public void setDcoDteSaisi(Date dcoDteSaisi) {
		this.dcoDteSaisi = dcoDteSaisi;
	}

	@Column(name = "DCO_PID_CODE", precision = 22, scale = 0)
	public BigDecimal getDcoPidCode() {
		return this.dcoPidCode;
	}

	public void setDcoPidCode(BigDecimal dcoPidCode) {
		this.dcoPidCode = dcoPidCode;
	}

	@Column(name = "DCO_DAC_CODE", length = 20)
	public String getDcoDacCode() {
		return this.dcoDacCode;
	}

	public void setDcoDacCode(String dcoDacCode) {
		this.dcoDacCode = dcoDacCode;
	}

	@Column(name = "DCO_FON_COD_SAISI", length = 12)
	public String getDcoFonCodSaisi() {
		return this.dcoFonCodSaisi;
	}

	public void setDcoFonCodSaisi(String dcoFonCodSaisi) {
		this.dcoFonCodSaisi = dcoFonCodSaisi;
	}

	@Column(name = "DCO_OPE_MATRICULE", length = 25)
	public String getDcoOpeMatricule() {
		return this.dcoOpeMatricule;
	}

	public void setDcoOpeMatricule(String dcoOpeMatricule) {
		this.dcoOpeMatricule = dcoOpeMatricule;
	}

	@Column(name = "DCO_OBSERVATION", length = 4000)
	public String getDcoObservation() {
		return this.dcoObservation;
	}

	public void setDcoObservation(String dcoObservation) {
		this.dcoObservation = dcoObservation;
	}

	@Column(name = "DCO_COR_NUM", precision = 22, scale = 0)
	public BigDecimal getDcoCorNum() {
		return this.dcoCorNum;
	}

	public void setDcoCorNum(BigDecimal dcoCorNum) {
		this.dcoCorNum = dcoCorNum;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VbDetailCorrectionId))
			return false;
		VbDetailCorrectionId castOther = (VbDetailCorrectionId) other;

		return ((this.getDcoNum() == castOther.getDcoNum()) || (this.getDcoNum() != null
				&& castOther.getDcoNum() != null && this.getDcoNum().equals(castOther.getDcoNum())))
				&& ((this.getDcoTitre() == castOther.getDcoTitre()) || (this.getDcoTitre() != null
						&& castOther.getDcoTitre() != null && this.getDcoTitre().equals(castOther.getDcoTitre())))
				&& ((this.getDcoLibelle() == castOther.getDcoLibelle()) || (this.getDcoLibelle() != null
						&& castOther.getDcoLibelle() != null && this.getDcoLibelle().equals(castOther.getDcoLibelle())))
				&& ((this.getDcoDteSaisi() == castOther.getDcoDteSaisi())
						|| (this.getDcoDteSaisi() != null && castOther.getDcoDteSaisi() != null
								&& this.getDcoDteSaisi().equals(castOther.getDcoDteSaisi())))
				&& ((this.getDcoPidCode() == castOther.getDcoPidCode()) || (this.getDcoPidCode() != null
						&& castOther.getDcoPidCode() != null && this.getDcoPidCode().equals(castOther.getDcoPidCode())))
				&& ((this.getDcoDacCode() == castOther.getDcoDacCode()) || (this.getDcoDacCode() != null
						&& castOther.getDcoDacCode() != null && this.getDcoDacCode().equals(castOther.getDcoDacCode())))
				&& ((this.getDcoFonCodSaisi() == castOther.getDcoFonCodSaisi())
						|| (this.getDcoFonCodSaisi() != null && castOther.getDcoFonCodSaisi() != null
								&& this.getDcoFonCodSaisi().equals(castOther.getDcoFonCodSaisi())))
				&& ((this.getDcoOpeMatricule() == castOther.getDcoOpeMatricule())
						|| (this.getDcoOpeMatricule() != null && castOther.getDcoOpeMatricule() != null
								&& this.getDcoOpeMatricule().equals(castOther.getDcoOpeMatricule())))
				&& ((this.getDcoObservation() == castOther.getDcoObservation())
						|| (this.getDcoObservation() != null && castOther.getDcoObservation() != null
								&& this.getDcoObservation().equals(castOther.getDcoObservation())))
				&& ((this.getDcoCorNum() == castOther.getDcoCorNum()) || (this.getDcoCorNum() != null
						&& castOther.getDcoCorNum() != null && this.getDcoCorNum().equals(castOther.getDcoCorNum())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getDcoNum() == null ? 0 : this.getDcoNum().hashCode());
		result = 37 * result + (getDcoTitre() == null ? 0 : this.getDcoTitre().hashCode());
		result = 37 * result + (getDcoLibelle() == null ? 0 : this.getDcoLibelle().hashCode());
		result = 37 * result + (getDcoDteSaisi() == null ? 0 : this.getDcoDteSaisi().hashCode());
		result = 37 * result + (getDcoPidCode() == null ? 0 : this.getDcoPidCode().hashCode());
		result = 37 * result + (getDcoDacCode() == null ? 0 : this.getDcoDacCode().hashCode());
		result = 37 * result + (getDcoFonCodSaisi() == null ? 0 : this.getDcoFonCodSaisi().hashCode());
		result = 37 * result + (getDcoOpeMatricule() == null ? 0 : this.getDcoOpeMatricule().hashCode());
		result = 37 * result + (getDcoObservation() == null ? 0 : this.getDcoObservation().hashCode());
		result = 37 * result + (getDcoCorNum() == null ? 0 : this.getDcoCorNum().hashCode());
		return result;
	}

}
