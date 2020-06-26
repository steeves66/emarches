package com.sndi.models;
// Generated 25 juin 2020 13:53:46 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VbDetailDemandesId generated by hbm2java
 */
@Embeddable
public class VbDetailDemandesId implements java.io.Serializable {

	private BigDecimal ddeNum;
	private BigDecimal ddeDemNum;
	private String ddeDacCode;
	private Short ddeLaaId;
	private String ddeLbgCode;
	private String ddeMarCode;
	private String ddeStrCode;
	private String ddeActNum;
	private String ddeActNumIni;

	public VbDetailDemandesId() {
	}

	public VbDetailDemandesId(BigDecimal ddeNum) {
		this.ddeNum = ddeNum;
	}

	public VbDetailDemandesId(BigDecimal ddeNum, BigDecimal ddeDemNum, String ddeDacCode, Short ddeLaaId,
			String ddeLbgCode, String ddeMarCode, String ddeStrCode, String ddeActNum, String ddeActNumIni) {
		this.ddeNum = ddeNum;
		this.ddeDemNum = ddeDemNum;
		this.ddeDacCode = ddeDacCode;
		this.ddeLaaId = ddeLaaId;
		this.ddeLbgCode = ddeLbgCode;
		this.ddeMarCode = ddeMarCode;
		this.ddeStrCode = ddeStrCode;
		this.ddeActNum = ddeActNum;
		this.ddeActNumIni = ddeActNumIni;
	}

	@Column(name = "DDE_NUM", nullable = false, precision = 22, scale = 0)
	public BigDecimal getDdeNum() {
		return this.ddeNum;
	}

	public void setDdeNum(BigDecimal ddeNum) {
		this.ddeNum = ddeNum;
	}

	@Column(name = "DDE_DEM_NUM", precision = 22, scale = 0)
	public BigDecimal getDdeDemNum() {
		return this.ddeDemNum;
	}

	public void setDdeDemNum(BigDecimal ddeDemNum) {
		this.ddeDemNum = ddeDemNum;
	}

	@Column(name = "DDE_DAC_CODE", length = 20)
	public String getDdeDacCode() {
		return this.ddeDacCode;
	}

	public void setDdeDacCode(String ddeDacCode) {
		this.ddeDacCode = ddeDacCode;
	}

	@Column(name = "DDE_LAA_ID", precision = 4, scale = 0)
	public Short getDdeLaaId() {
		return this.ddeLaaId;
	}

	public void setDdeLaaId(Short ddeLaaId) {
		this.ddeLaaId = ddeLaaId;
	}

	@Column(name = "DDE_LBG_CODE", length = 50)
	public String getDdeLbgCode() {
		return this.ddeLbgCode;
	}

	public void setDdeLbgCode(String ddeLbgCode) {
		this.ddeLbgCode = ddeLbgCode;
	}

	@Column(name = "DDE_MAR_CODE", length = 20)
	public String getDdeMarCode() {
		return this.ddeMarCode;
	}

	public void setDdeMarCode(String ddeMarCode) {
		this.ddeMarCode = ddeMarCode;
	}

	@Column(name = "DDE_STR_CODE", length = 20)
	public String getDdeStrCode() {
		return this.ddeStrCode;
	}

	public void setDdeStrCode(String ddeStrCode) {
		this.ddeStrCode = ddeStrCode;
	}

	@Column(name = "DDE_ACT_NUM", length = 200)
	public String getDdeActNum() {
		return this.ddeActNum;
	}

	public void setDdeActNum(String ddeActNum) {
		this.ddeActNum = ddeActNum;
	}

	@Column(name = "DDE_ACT_NUM_INI", length = 200)
	public String getDdeActNumIni() {
		return this.ddeActNumIni;
	}

	public void setDdeActNumIni(String ddeActNumIni) {
		this.ddeActNumIni = ddeActNumIni;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VbDetailDemandesId))
			return false;
		VbDetailDemandesId castOther = (VbDetailDemandesId) other;

		return ((this.getDdeNum() == castOther.getDdeNum()) || (this.getDdeNum() != null
				&& castOther.getDdeNum() != null && this.getDdeNum().equals(castOther.getDdeNum())))
				&& ((this.getDdeDemNum() == castOther.getDdeDemNum()) || (this.getDdeDemNum() != null
						&& castOther.getDdeDemNum() != null && this.getDdeDemNum().equals(castOther.getDdeDemNum())))
				&& ((this.getDdeDacCode() == castOther.getDdeDacCode()) || (this.getDdeDacCode() != null
						&& castOther.getDdeDacCode() != null && this.getDdeDacCode().equals(castOther.getDdeDacCode())))
				&& ((this.getDdeLaaId() == castOther.getDdeLaaId()) || (this.getDdeLaaId() != null
						&& castOther.getDdeLaaId() != null && this.getDdeLaaId().equals(castOther.getDdeLaaId())))
				&& ((this.getDdeLbgCode() == castOther.getDdeLbgCode()) || (this.getDdeLbgCode() != null
						&& castOther.getDdeLbgCode() != null && this.getDdeLbgCode().equals(castOther.getDdeLbgCode())))
				&& ((this.getDdeMarCode() == castOther.getDdeMarCode()) || (this.getDdeMarCode() != null
						&& castOther.getDdeMarCode() != null && this.getDdeMarCode().equals(castOther.getDdeMarCode())))
				&& ((this.getDdeStrCode() == castOther.getDdeStrCode()) || (this.getDdeStrCode() != null
						&& castOther.getDdeStrCode() != null && this.getDdeStrCode().equals(castOther.getDdeStrCode())))
				&& ((this.getDdeActNum() == castOther.getDdeActNum()) || (this.getDdeActNum() != null
						&& castOther.getDdeActNum() != null && this.getDdeActNum().equals(castOther.getDdeActNum())))
				&& ((this.getDdeActNumIni() == castOther.getDdeActNumIni())
						|| (this.getDdeActNumIni() != null && castOther.getDdeActNumIni() != null
								&& this.getDdeActNumIni().equals(castOther.getDdeActNumIni())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getDdeNum() == null ? 0 : this.getDdeNum().hashCode());
		result = 37 * result + (getDdeDemNum() == null ? 0 : this.getDdeDemNum().hashCode());
		result = 37 * result + (getDdeDacCode() == null ? 0 : this.getDdeDacCode().hashCode());
		result = 37 * result + (getDdeLaaId() == null ? 0 : this.getDdeLaaId().hashCode());
		result = 37 * result + (getDdeLbgCode() == null ? 0 : this.getDdeLbgCode().hashCode());
		result = 37 * result + (getDdeMarCode() == null ? 0 : this.getDdeMarCode().hashCode());
		result = 37 * result + (getDdeStrCode() == null ? 0 : this.getDdeStrCode().hashCode());
		result = 37 * result + (getDdeActNum() == null ? 0 : this.getDdeActNum().hashCode());
		result = 37 * result + (getDdeActNumIni() == null ? 0 : this.getDdeActNumIni().hashCode());
		return result;
	}

}