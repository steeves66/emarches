package com.sndi.models;
// Generated 4 avr. 2020 18:03:14 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VbVenteDacId generated by hbm2java
 */
@Embeddable
public class VbVenteDacId implements java.io.Serializable {

	private long venNum;
	private BigDecimal venCanCode;
	private String venMrgCod;
	private String venOpeMatricule;
	private Date venDteSaisi;

	public VbVenteDacId() {
	}

	public VbVenteDacId(long venNum, BigDecimal venCanCode, String venMrgCod, String venOpeMatricule) {
		this.venNum = venNum;
		this.venCanCode = venCanCode;
		this.venMrgCod = venMrgCod;
		this.venOpeMatricule = venOpeMatricule;
	}

	public VbVenteDacId(long venNum, BigDecimal venCanCode, String venMrgCod, String venOpeMatricule,
			Date venDteSaisi) {
		this.venNum = venNum;
		this.venCanCode = venCanCode;
		this.venMrgCod = venMrgCod;
		this.venOpeMatricule = venOpeMatricule;
		this.venDteSaisi = venDteSaisi;
	}

	@Column(name = "VEN_NUM", nullable = false, precision = 10, scale = 0)
	public long getVenNum() {
		return this.venNum;
	}

	public void setVenNum(long venNum) {
		this.venNum = venNum;
	}

	@Column(name = "VEN_CAN_CODE", nullable = false, precision = 22, scale = 0)
	public BigDecimal getVenCanCode() {
		return this.venCanCode;
	}

	public void setVenCanCode(BigDecimal venCanCode) {
		this.venCanCode = venCanCode;
	}

	@Column(name = "VEN_MRG_COD", nullable = false, length = 10)
	public String getVenMrgCod() {
		return this.venMrgCod;
	}

	public void setVenMrgCod(String venMrgCod) {
		this.venMrgCod = venMrgCod;
	}

	@Column(name = "VEN_OPE_MATRICULE", nullable = false, length = 25)
	public String getVenOpeMatricule() {
		return this.venOpeMatricule;
	}

	public void setVenOpeMatricule(String venOpeMatricule) {
		this.venOpeMatricule = venOpeMatricule;
	}

	@Column(name = "VEN_DTE_SAISI", length = 7)
	public Date getVenDteSaisi() {
		return this.venDteSaisi;
	}

	public void setVenDteSaisi(Date venDteSaisi) {
		this.venDteSaisi = venDteSaisi;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VbVenteDacId))
			return false;
		VbVenteDacId castOther = (VbVenteDacId) other;

		return (this.getVenNum() == castOther.getVenNum())
				&& ((this.getVenCanCode() == castOther.getVenCanCode()) || (this.getVenCanCode() != null
						&& castOther.getVenCanCode() != null && this.getVenCanCode().equals(castOther.getVenCanCode())))
				&& ((this.getVenMrgCod() == castOther.getVenMrgCod()) || (this.getVenMrgCod() != null
						&& castOther.getVenMrgCod() != null && this.getVenMrgCod().equals(castOther.getVenMrgCod())))
				&& ((this.getVenOpeMatricule() == castOther.getVenOpeMatricule())
						|| (this.getVenOpeMatricule() != null && castOther.getVenOpeMatricule() != null
								&& this.getVenOpeMatricule().equals(castOther.getVenOpeMatricule())))
				&& ((this.getVenDteSaisi() == castOther.getVenDteSaisi())
						|| (this.getVenDteSaisi() != null && castOther.getVenDteSaisi() != null
								&& this.getVenDteSaisi().equals(castOther.getVenDteSaisi())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getVenNum();
		result = 37 * result + (getVenCanCode() == null ? 0 : this.getVenCanCode().hashCode());
		result = 37 * result + (getVenMrgCod() == null ? 0 : this.getVenMrgCod().hashCode());
		result = 37 * result + (getVenOpeMatricule() == null ? 0 : this.getVenOpeMatricule().hashCode());
		result = 37 * result + (getVenDteSaisi() == null ? 0 : this.getVenDteSaisi().hashCode());
		return result;
	}

}
