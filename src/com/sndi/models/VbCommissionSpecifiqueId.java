package com.sndi.models;
// Generated 27 mars 2020 22:20:54 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VbCommissionSpecifiqueId generated by hbm2java
 */
@Embeddable
public class VbCommissionSpecifiqueId implements java.io.Serializable {

	private BigDecimal comNum;
	private Date comDteSaisi;
	private String comStrCode;
	private String comTctCode;
	private String comOpeMatricule;
	private String comDacCode;
	private String comMarCode;
	private String comAaoCode;
	private String comTcoCode;

	public VbCommissionSpecifiqueId() {
	}

	public VbCommissionSpecifiqueId(BigDecimal comNum) {
		this.comNum = comNum;
	}

	public VbCommissionSpecifiqueId(BigDecimal comNum, Date comDteSaisi, String comStrCode, String comTctCode,
			String comOpeMatricule, String comDacCode, String comMarCode, String comAaoCode, String comTcoCode) {
		this.comNum = comNum;
		this.comDteSaisi = comDteSaisi;
		this.comStrCode = comStrCode;
		this.comTctCode = comTctCode;
		this.comOpeMatricule = comOpeMatricule;
		this.comDacCode = comDacCode;
		this.comMarCode = comMarCode;
		this.comAaoCode = comAaoCode;
		this.comTcoCode = comTcoCode;
	}

	@Column(name = "COM_NUM", nullable = false, precision = 22, scale = 0)
	public BigDecimal getComNum() {
		return this.comNum;
	}

	public void setComNum(BigDecimal comNum) {
		this.comNum = comNum;
	}

	@Column(name = "COM_DTE_SAISI", length = 7)
	public Date getComDteSaisi() {
		return this.comDteSaisi;
	}

	public void setComDteSaisi(Date comDteSaisi) {
		this.comDteSaisi = comDteSaisi;
	}

	@Column(name = "COM_STR_CODE", length = 20)
	public String getComStrCode() {
		return this.comStrCode;
	}

	public void setComStrCode(String comStrCode) {
		this.comStrCode = comStrCode;
	}

	@Column(name = "COM_TCT_CODE", length = 3)
	public String getComTctCode() {
		return this.comTctCode;
	}

	public void setComTctCode(String comTctCode) {
		this.comTctCode = comTctCode;
	}

	@Column(name = "COM_OPE_MATRICULE", length = 20)
	public String getComOpeMatricule() {
		return this.comOpeMatricule;
	}

	public void setComOpeMatricule(String comOpeMatricule) {
		this.comOpeMatricule = comOpeMatricule;
	}

	@Column(name = "COM_DAC_CODE", length = 20)
	public String getComDacCode() {
		return this.comDacCode;
	}

	public void setComDacCode(String comDacCode) {
		this.comDacCode = comDacCode;
	}

	@Column(name = "COM_MAR_CODE", length = 20)
	public String getComMarCode() {
		return this.comMarCode;
	}

	public void setComMarCode(String comMarCode) {
		this.comMarCode = comMarCode;
	}

	@Column(name = "COM_AAO_CODE", length = 20)
	public String getComAaoCode() {
		return this.comAaoCode;
	}

	public void setComAaoCode(String comAaoCode) {
		this.comAaoCode = comAaoCode;
	}

	@Column(name = "COM_TCO_CODE", length = 3)
	public String getComTcoCode() {
		return this.comTcoCode;
	}

	public void setComTcoCode(String comTcoCode) {
		this.comTcoCode = comTcoCode;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VbCommissionSpecifiqueId))
			return false;
		VbCommissionSpecifiqueId castOther = (VbCommissionSpecifiqueId) other;

		return ((this.getComNum() == castOther.getComNum()) || (this.getComNum() != null
				&& castOther.getComNum() != null && this.getComNum().equals(castOther.getComNum())))
				&& ((this.getComDteSaisi() == castOther.getComDteSaisi())
						|| (this.getComDteSaisi() != null && castOther.getComDteSaisi() != null
								&& this.getComDteSaisi().equals(castOther.getComDteSaisi())))
				&& ((this.getComStrCode() == castOther.getComStrCode()) || (this.getComStrCode() != null
						&& castOther.getComStrCode() != null && this.getComStrCode().equals(castOther.getComStrCode())))
				&& ((this.getComTctCode() == castOther.getComTctCode()) || (this.getComTctCode() != null
						&& castOther.getComTctCode() != null && this.getComTctCode().equals(castOther.getComTctCode())))
				&& ((this.getComOpeMatricule() == castOther.getComOpeMatricule())
						|| (this.getComOpeMatricule() != null && castOther.getComOpeMatricule() != null
								&& this.getComOpeMatricule().equals(castOther.getComOpeMatricule())))
				&& ((this.getComDacCode() == castOther.getComDacCode()) || (this.getComDacCode() != null
						&& castOther.getComDacCode() != null && this.getComDacCode().equals(castOther.getComDacCode())))
				&& ((this.getComMarCode() == castOther.getComMarCode()) || (this.getComMarCode() != null
						&& castOther.getComMarCode() != null && this.getComMarCode().equals(castOther.getComMarCode())))
				&& ((this.getComAaoCode() == castOther.getComAaoCode()) || (this.getComAaoCode() != null
						&& castOther.getComAaoCode() != null && this.getComAaoCode().equals(castOther.getComAaoCode())))
				&& ((this.getComTcoCode() == castOther.getComTcoCode())
						|| (this.getComTcoCode() != null && castOther.getComTcoCode() != null
								&& this.getComTcoCode().equals(castOther.getComTcoCode())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getComNum() == null ? 0 : this.getComNum().hashCode());
		result = 37 * result + (getComDteSaisi() == null ? 0 : this.getComDteSaisi().hashCode());
		result = 37 * result + (getComStrCode() == null ? 0 : this.getComStrCode().hashCode());
		result = 37 * result + (getComTctCode() == null ? 0 : this.getComTctCode().hashCode());
		result = 37 * result + (getComOpeMatricule() == null ? 0 : this.getComOpeMatricule().hashCode());
		result = 37 * result + (getComDacCode() == null ? 0 : this.getComDacCode().hashCode());
		result = 37 * result + (getComMarCode() == null ? 0 : this.getComMarCode().hashCode());
		result = 37 * result + (getComAaoCode() == null ? 0 : this.getComAaoCode().hashCode());
		result = 37 * result + (getComTcoCode() == null ? 0 : this.getComTcoCode().hashCode());
		return result;
	}

}
