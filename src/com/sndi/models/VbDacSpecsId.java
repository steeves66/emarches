package com.sndi.models;
// Generated 4 avr. 2020 18:03:14 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VbDacSpecsId generated by hbm2java
 */
@Embeddable
public class VbDacSpecsId implements java.io.Serializable {

	private String dacCode;
	private String dacObjet;
	private Date dacDteSaisi;
	private String dacStaCode;
	private String dacTymCode;
	private String dacMopCode;
	private BigDecimal dacNbrOuv;
	private BigDecimal dacGesCode;
	private String dacFonCodAc;
	private String dacStrCode;
	private String dacFonCodeCpmp;
	private Date dacDteValCpmp;
	private Date dacDteValDmp;
	private String dacTdCode;
	private Long dacDppId;
	private Date dacDateReception;
	private String dacStatutRetour;
	private String dacMention;

	public VbDacSpecsId() {
	}

	public VbDacSpecsId(String dacCode) {
		this.dacCode = dacCode;
	}

	public VbDacSpecsId(String dacCode, String dacObjet, Date dacDteSaisi, String dacStaCode, String dacTymCode,
			String dacMopCode, BigDecimal dacNbrOuv, BigDecimal dacGesCode, String dacFonCodAc, String dacStrCode,
			String dacFonCodeCpmp, Date dacDteValCpmp, Date dacDteValDmp, String dacTdCode, Long dacDppId,
			Date dacDateReception, String dacStatutRetour, String dacMention) {
		this.dacCode = dacCode;
		this.dacObjet = dacObjet;
		this.dacDteSaisi = dacDteSaisi;
		this.dacStaCode = dacStaCode;
		this.dacTymCode = dacTymCode;
		this.dacMopCode = dacMopCode;
		this.dacNbrOuv = dacNbrOuv;
		this.dacGesCode = dacGesCode;
		this.dacFonCodAc = dacFonCodAc;
		this.dacStrCode = dacStrCode;
		this.dacFonCodeCpmp = dacFonCodeCpmp;
		this.dacDteValCpmp = dacDteValCpmp;
		this.dacDteValDmp = dacDteValDmp;
		this.dacTdCode = dacTdCode;
		this.dacDppId = dacDppId;
		this.dacDateReception = dacDateReception;
		this.dacStatutRetour = dacStatutRetour;
		this.dacMention = dacMention;
	}

	@Column(name = "DAC_CODE", nullable = false, length = 20)
	public String getDacCode() {
		return this.dacCode;
	}

	public void setDacCode(String dacCode) {
		this.dacCode = dacCode;
	}

	@Column(name = "DAC_OBJET", length = 1000)
	public String getDacObjet() {
		return this.dacObjet;
	}

	public void setDacObjet(String dacObjet) {
		this.dacObjet = dacObjet;
	}

	@Column(name = "DAC_DTE_SAISI", length = 7)
	public Date getDacDteSaisi() {
		return this.dacDteSaisi;
	}

	public void setDacDteSaisi(Date dacDteSaisi) {
		this.dacDteSaisi = dacDteSaisi;
	}

	@Column(name = "DAC_STA_CODE", length = 3)
	public String getDacStaCode() {
		return this.dacStaCode;
	}

	public void setDacStaCode(String dacStaCode) {
		this.dacStaCode = dacStaCode;
	}

	@Column(name = "DAC_TYM_CODE", length = 5)
	public String getDacTymCode() {
		return this.dacTymCode;
	}

	public void setDacTymCode(String dacTymCode) {
		this.dacTymCode = dacTymCode;
	}

	@Column(name = "DAC_MOP_CODE", length = 3)
	public String getDacMopCode() {
		return this.dacMopCode;
	}

	public void setDacMopCode(String dacMopCode) {
		this.dacMopCode = dacMopCode;
	}

	@Column(name = "DAC_NBR_OUV", precision = 22, scale = 0)
	public BigDecimal getDacNbrOuv() {
		return this.dacNbrOuv;
	}

	public void setDacNbrOuv(BigDecimal dacNbrOuv) {
		this.dacNbrOuv = dacNbrOuv;
	}

	@Column(name = "DAC_GES_CODE", precision = 22, scale = 0)
	public BigDecimal getDacGesCode() {
		return this.dacGesCode;
	}

	public void setDacGesCode(BigDecimal dacGesCode) {
		this.dacGesCode = dacGesCode;
	}

	@Column(name = "DAC_FON_COD_AC", length = 12)
	public String getDacFonCodAc() {
		return this.dacFonCodAc;
	}

	public void setDacFonCodAc(String dacFonCodAc) {
		this.dacFonCodAc = dacFonCodAc;
	}

	@Column(name = "DAC_STR_CODE", length = 3)
	public String getDacStrCode() {
		return this.dacStrCode;
	}

	public void setDacStrCode(String dacStrCode) {
		this.dacStrCode = dacStrCode;
	}

	@Column(name = "DAC_FON_CODE_CPMP", length = 12)
	public String getDacFonCodeCpmp() {
		return this.dacFonCodeCpmp;
	}

	public void setDacFonCodeCpmp(String dacFonCodeCpmp) {
		this.dacFonCodeCpmp = dacFonCodeCpmp;
	}

	@Column(name = "DAC_DTE_VAL_CPMP", length = 7)
	public Date getDacDteValCpmp() {
		return this.dacDteValCpmp;
	}

	public void setDacDteValCpmp(Date dacDteValCpmp) {
		this.dacDteValCpmp = dacDteValCpmp;
	}

	@Column(name = "DAC_DTE_VAL_DMP", length = 7)
	public Date getDacDteValDmp() {
		return this.dacDteValDmp;
	}

	public void setDacDteValDmp(Date dacDteValDmp) {
		this.dacDteValDmp = dacDteValDmp;
	}

	@Column(name = "DAC_TD_CODE", length = 3)
	public String getDacTdCode() {
		return this.dacTdCode;
	}

	public void setDacTdCode(String dacTdCode) {
		this.dacTdCode = dacTdCode;
	}

	@Column(name = "DAC_DPP_ID", precision = 10, scale = 0)
	public Long getDacDppId() {
		return this.dacDppId;
	}

	public void setDacDppId(Long dacDppId) {
		this.dacDppId = dacDppId;
	}

	@Column(name = "DAC_DATE_RECEPTION", length = 7)
	public Date getDacDateReception() {
		return this.dacDateReception;
	}

	public void setDacDateReception(Date dacDateReception) {
		this.dacDateReception = dacDateReception;
	}

	@Column(name = "DAC_STATUT_RETOUR", length = 2)
	public String getDacStatutRetour() {
		return this.dacStatutRetour;
	}

	public void setDacStatutRetour(String dacStatutRetour) {
		this.dacStatutRetour = dacStatutRetour;
	}

	@Column(name = "DAC_MENTION", length = 100)
	public String getDacMention() {
		return this.dacMention;
	}

	public void setDacMention(String dacMention) {
		this.dacMention = dacMention;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VbDacSpecsId))
			return false;
		VbDacSpecsId castOther = (VbDacSpecsId) other;

		return ((this.getDacCode() == castOther.getDacCode()) || (this.getDacCode() != null
				&& castOther.getDacCode() != null && this.getDacCode().equals(castOther.getDacCode())))
				&& ((this.getDacObjet() == castOther.getDacObjet()) || (this.getDacObjet() != null
						&& castOther.getDacObjet() != null && this.getDacObjet().equals(castOther.getDacObjet())))
				&& ((this.getDacDteSaisi() == castOther.getDacDteSaisi())
						|| (this.getDacDteSaisi() != null && castOther.getDacDteSaisi() != null
								&& this.getDacDteSaisi().equals(castOther.getDacDteSaisi())))
				&& ((this.getDacStaCode() == castOther.getDacStaCode()) || (this.getDacStaCode() != null
						&& castOther.getDacStaCode() != null && this.getDacStaCode().equals(castOther.getDacStaCode())))
				&& ((this.getDacTymCode() == castOther.getDacTymCode()) || (this.getDacTymCode() != null
						&& castOther.getDacTymCode() != null && this.getDacTymCode().equals(castOther.getDacTymCode())))
				&& ((this.getDacMopCode() == castOther.getDacMopCode()) || (this.getDacMopCode() != null
						&& castOther.getDacMopCode() != null && this.getDacMopCode().equals(castOther.getDacMopCode())))
				&& ((this.getDacNbrOuv() == castOther.getDacNbrOuv()) || (this.getDacNbrOuv() != null
						&& castOther.getDacNbrOuv() != null && this.getDacNbrOuv().equals(castOther.getDacNbrOuv())))
				&& ((this.getDacGesCode() == castOther.getDacGesCode()) || (this.getDacGesCode() != null
						&& castOther.getDacGesCode() != null && this.getDacGesCode().equals(castOther.getDacGesCode())))
				&& ((this.getDacFonCodAc() == castOther.getDacFonCodAc())
						|| (this.getDacFonCodAc() != null && castOther.getDacFonCodAc() != null
								&& this.getDacFonCodAc().equals(castOther.getDacFonCodAc())))
				&& ((this.getDacStrCode() == castOther.getDacStrCode()) || (this.getDacStrCode() != null
						&& castOther.getDacStrCode() != null && this.getDacStrCode().equals(castOther.getDacStrCode())))
				&& ((this.getDacFonCodeCpmp() == castOther.getDacFonCodeCpmp())
						|| (this.getDacFonCodeCpmp() != null && castOther.getDacFonCodeCpmp() != null
								&& this.getDacFonCodeCpmp().equals(castOther.getDacFonCodeCpmp())))
				&& ((this.getDacDteValCpmp() == castOther.getDacDteValCpmp())
						|| (this.getDacDteValCpmp() != null && castOther.getDacDteValCpmp() != null
								&& this.getDacDteValCpmp().equals(castOther.getDacDteValCpmp())))
				&& ((this.getDacDteValDmp() == castOther.getDacDteValDmp())
						|| (this.getDacDteValDmp() != null && castOther.getDacDteValDmp() != null
								&& this.getDacDteValDmp().equals(castOther.getDacDteValDmp())))
				&& ((this.getDacTdCode() == castOther.getDacTdCode()) || (this.getDacTdCode() != null
						&& castOther.getDacTdCode() != null && this.getDacTdCode().equals(castOther.getDacTdCode())))
				&& ((this.getDacDppId() == castOther.getDacDppId()) || (this.getDacDppId() != null
						&& castOther.getDacDppId() != null && this.getDacDppId().equals(castOther.getDacDppId())))
				&& ((this.getDacDateReception() == castOther.getDacDateReception())
						|| (this.getDacDateReception() != null && castOther.getDacDateReception() != null
								&& this.getDacDateReception().equals(castOther.getDacDateReception())))
				&& ((this.getDacStatutRetour() == castOther.getDacStatutRetour())
						|| (this.getDacStatutRetour() != null && castOther.getDacStatutRetour() != null
								&& this.getDacStatutRetour().equals(castOther.getDacStatutRetour())))
				&& ((this.getDacMention() == castOther.getDacMention())
						|| (this.getDacMention() != null && castOther.getDacMention() != null
								&& this.getDacMention().equals(castOther.getDacMention())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getDacCode() == null ? 0 : this.getDacCode().hashCode());
		result = 37 * result + (getDacObjet() == null ? 0 : this.getDacObjet().hashCode());
		result = 37 * result + (getDacDteSaisi() == null ? 0 : this.getDacDteSaisi().hashCode());
		result = 37 * result + (getDacStaCode() == null ? 0 : this.getDacStaCode().hashCode());
		result = 37 * result + (getDacTymCode() == null ? 0 : this.getDacTymCode().hashCode());
		result = 37 * result + (getDacMopCode() == null ? 0 : this.getDacMopCode().hashCode());
		result = 37 * result + (getDacNbrOuv() == null ? 0 : this.getDacNbrOuv().hashCode());
		result = 37 * result + (getDacGesCode() == null ? 0 : this.getDacGesCode().hashCode());
		result = 37 * result + (getDacFonCodAc() == null ? 0 : this.getDacFonCodAc().hashCode());
		result = 37 * result + (getDacStrCode() == null ? 0 : this.getDacStrCode().hashCode());
		result = 37 * result + (getDacFonCodeCpmp() == null ? 0 : this.getDacFonCodeCpmp().hashCode());
		result = 37 * result + (getDacDteValCpmp() == null ? 0 : this.getDacDteValCpmp().hashCode());
		result = 37 * result + (getDacDteValDmp() == null ? 0 : this.getDacDteValDmp().hashCode());
		result = 37 * result + (getDacTdCode() == null ? 0 : this.getDacTdCode().hashCode());
		result = 37 * result + (getDacDppId() == null ? 0 : this.getDacDppId().hashCode());
		result = 37 * result + (getDacDateReception() == null ? 0 : this.getDacDateReception().hashCode());
		result = 37 * result + (getDacStatutRetour() == null ? 0 : this.getDacStatutRetour().hashCode());
		result = 37 * result + (getDacMention() == null ? 0 : this.getDacMention().hashCode());
		return result;
	}

}
