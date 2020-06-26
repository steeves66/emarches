package com.sndi.models;
// Generated 25 juin 2020 13:53:46 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VbHistoDemandeId generated by hbm2java
 */
@Embeddable
public class VbHistoDemandeId implements java.io.Serializable {

	private short hdmNum;
	private BigDecimal hdmDemNum;
	private Date hdmDteSaisi;
	private String hdmStaCode;
	private String hdmFonCod;
	private String hdmOpeCode;

	public VbHistoDemandeId() {
	}

	public VbHistoDemandeId(short hdmNum, BigDecimal hdmDemNum) {
		this.hdmNum = hdmNum;
		this.hdmDemNum = hdmDemNum;
	}

	public VbHistoDemandeId(short hdmNum, BigDecimal hdmDemNum, Date hdmDteSaisi, String hdmStaCode, String hdmFonCod,
			String hdmOpeCode) {
		this.hdmNum = hdmNum;
		this.hdmDemNum = hdmDemNum;
		this.hdmDteSaisi = hdmDteSaisi;
		this.hdmStaCode = hdmStaCode;
		this.hdmFonCod = hdmFonCod;
		this.hdmOpeCode = hdmOpeCode;
	}

	@Column(name = "HDM_NUM", nullable = false, precision = 4, scale = 0)
	public short getHdmNum() {
		return this.hdmNum;
	}

	public void setHdmNum(short hdmNum) {
		this.hdmNum = hdmNum;
	}

	@Column(name = "HDM_DEM_NUM", nullable = false, precision = 22, scale = 0)
	public BigDecimal getHdmDemNum() {
		return this.hdmDemNum;
	}

	public void setHdmDemNum(BigDecimal hdmDemNum) {
		this.hdmDemNum = hdmDemNum;
	}

	@Column(name = "HDM_DTE_SAISI", length = 7)
	public Date getHdmDteSaisi() {
		return this.hdmDteSaisi;
	}

	public void setHdmDteSaisi(Date hdmDteSaisi) {
		this.hdmDteSaisi = hdmDteSaisi;
	}

	@Column(name = "HDM_STA_CODE", length = 3)
	public String getHdmStaCode() {
		return this.hdmStaCode;
	}

	public void setHdmStaCode(String hdmStaCode) {
		this.hdmStaCode = hdmStaCode;
	}

	@Column(name = "HDM_FON_COD", length = 20)
	public String getHdmFonCod() {
		return this.hdmFonCod;
	}

	public void setHdmFonCod(String hdmFonCod) {
		this.hdmFonCod = hdmFonCod;
	}

	@Column(name = "HDM_OPE_CODE", length = 25)
	public String getHdmOpeCode() {
		return this.hdmOpeCode;
	}

	public void setHdmOpeCode(String hdmOpeCode) {
		this.hdmOpeCode = hdmOpeCode;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VbHistoDemandeId))
			return false;
		VbHistoDemandeId castOther = (VbHistoDemandeId) other;

		return (this.getHdmNum() == castOther.getHdmNum())
				&& ((this.getHdmDemNum() == castOther.getHdmDemNum()) || (this.getHdmDemNum() != null
						&& castOther.getHdmDemNum() != null && this.getHdmDemNum().equals(castOther.getHdmDemNum())))
				&& ((this.getHdmDteSaisi() == castOther.getHdmDteSaisi())
						|| (this.getHdmDteSaisi() != null && castOther.getHdmDteSaisi() != null
								&& this.getHdmDteSaisi().equals(castOther.getHdmDteSaisi())))
				&& ((this.getHdmStaCode() == castOther.getHdmStaCode()) || (this.getHdmStaCode() != null
						&& castOther.getHdmStaCode() != null && this.getHdmStaCode().equals(castOther.getHdmStaCode())))
				&& ((this.getHdmFonCod() == castOther.getHdmFonCod()) || (this.getHdmFonCod() != null
						&& castOther.getHdmFonCod() != null && this.getHdmFonCod().equals(castOther.getHdmFonCod())))
				&& ((this.getHdmOpeCode() == castOther.getHdmOpeCode())
						|| (this.getHdmOpeCode() != null && castOther.getHdmOpeCode() != null
								&& this.getHdmOpeCode().equals(castOther.getHdmOpeCode())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getHdmNum();
		result = 37 * result + (getHdmDemNum() == null ? 0 : this.getHdmDemNum().hashCode());
		result = 37 * result + (getHdmDteSaisi() == null ? 0 : this.getHdmDteSaisi().hashCode());
		result = 37 * result + (getHdmStaCode() == null ? 0 : this.getHdmStaCode().hashCode());
		result = 37 * result + (getHdmFonCod() == null ? 0 : this.getHdmFonCod().hashCode());
		result = 37 * result + (getHdmOpeCode() == null ? 0 : this.getHdmOpeCode().hashCode());
		return result;
	}

}