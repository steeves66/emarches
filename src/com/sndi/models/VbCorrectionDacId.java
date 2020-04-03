package com.sndi.models;
// Generated 3 avr. 2020 00:55:57 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VbCorrectionDacId generated by hbm2java
 */
@Embeddable
public class VbCorrectionDacId implements java.io.Serializable {

	private BigDecimal corNum;
	private String corDacCode;
	private String corLieblle;
	private Date corDteSaisi;
	private String corOpeMatricule;

	public VbCorrectionDacId() {
	}

	public VbCorrectionDacId(BigDecimal corNum) {
		this.corNum = corNum;
	}

	public VbCorrectionDacId(BigDecimal corNum, String corDacCode, String corLieblle, Date corDteSaisi,
			String corOpeMatricule) {
		this.corNum = corNum;
		this.corDacCode = corDacCode;
		this.corLieblle = corLieblle;
		this.corDteSaisi = corDteSaisi;
		this.corOpeMatricule = corOpeMatricule;
	}

	@Column(name = "COR_NUM", nullable = false, precision = 22, scale = 0)
	public BigDecimal getCorNum() {
		return this.corNum;
	}

	public void setCorNum(BigDecimal corNum) {
		this.corNum = corNum;
	}

	@Column(name = "COR_DAC_CODE", length = 20)
	public String getCorDacCode() {
		return this.corDacCode;
	}

	public void setCorDacCode(String corDacCode) {
		this.corDacCode = corDacCode;
	}

	@Column(name = "COR_LIEBLLE", length = 200)
	public String getCorLieblle() {
		return this.corLieblle;
	}

	public void setCorLieblle(String corLieblle) {
		this.corLieblle = corLieblle;
	}

	@Column(name = "COR_DTE_SAISI", length = 7)
	public Date getCorDteSaisi() {
		return this.corDteSaisi;
	}

	public void setCorDteSaisi(Date corDteSaisi) {
		this.corDteSaisi = corDteSaisi;
	}

	@Column(name = "COR_OPE_MATRICULE", length = 25)
	public String getCorOpeMatricule() {
		return this.corOpeMatricule;
	}

	public void setCorOpeMatricule(String corOpeMatricule) {
		this.corOpeMatricule = corOpeMatricule;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VbCorrectionDacId))
			return false;
		VbCorrectionDacId castOther = (VbCorrectionDacId) other;

		return ((this.getCorNum() == castOther.getCorNum()) || (this.getCorNum() != null
				&& castOther.getCorNum() != null && this.getCorNum().equals(castOther.getCorNum())))
				&& ((this.getCorDacCode() == castOther.getCorDacCode()) || (this.getCorDacCode() != null
						&& castOther.getCorDacCode() != null && this.getCorDacCode().equals(castOther.getCorDacCode())))
				&& ((this.getCorLieblle() == castOther.getCorLieblle()) || (this.getCorLieblle() != null
						&& castOther.getCorLieblle() != null && this.getCorLieblle().equals(castOther.getCorLieblle())))
				&& ((this.getCorDteSaisi() == castOther.getCorDteSaisi())
						|| (this.getCorDteSaisi() != null && castOther.getCorDteSaisi() != null
								&& this.getCorDteSaisi().equals(castOther.getCorDteSaisi())))
				&& ((this.getCorOpeMatricule() == castOther.getCorOpeMatricule())
						|| (this.getCorOpeMatricule() != null && castOther.getCorOpeMatricule() != null
								&& this.getCorOpeMatricule().equals(castOther.getCorOpeMatricule())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getCorNum() == null ? 0 : this.getCorNum().hashCode());
		result = 37 * result + (getCorDacCode() == null ? 0 : this.getCorDacCode().hashCode());
		result = 37 * result + (getCorLieblle() == null ? 0 : this.getCorLieblle().hashCode());
		result = 37 * result + (getCorDteSaisi() == null ? 0 : this.getCorDteSaisi().hashCode());
		result = 37 * result + (getCorOpeMatricule() == null ? 0 : this.getCorOpeMatricule().hashCode());
		return result;
	}

}
