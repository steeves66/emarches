package com.sndi.models;
// Generated 23 mars 2020 10:48:44 by Hibernate Tools 4.3.5.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VbRegionId generated by hbm2java
 */
@Embeddable
public class VbRegionId implements java.io.Serializable {

	private String regCode;
	private String regLibelle;
	private String regOpeMatricule;
	private Date regDteSaisi;

	public VbRegionId() {
	}

	public VbRegionId(String regCode) {
		this.regCode = regCode;
	}

	public VbRegionId(String regCode, String regLibelle, String regOpeMatricule, Date regDteSaisi) {
		this.regCode = regCode;
		this.regLibelle = regLibelle;
		this.regOpeMatricule = regOpeMatricule;
		this.regDteSaisi = regDteSaisi;
	}

	@Column(name = "REG_CODE", nullable = false, length = 20)
	public String getRegCode() {
		return this.regCode;
	}

	public void setRegCode(String regCode) {
		this.regCode = regCode;
	}

	@Column(name = "REG_LIBELLE", length = 500)
	public String getRegLibelle() {
		return this.regLibelle;
	}

	public void setRegLibelle(String regLibelle) {
		this.regLibelle = regLibelle;
	}

	@Column(name = "REG_OPE_MATRICULE", length = 25)
	public String getRegOpeMatricule() {
		return this.regOpeMatricule;
	}

	public void setRegOpeMatricule(String regOpeMatricule) {
		this.regOpeMatricule = regOpeMatricule;
	}

	@Column(name = "REG_DTE_SAISI", length = 7)
	public Date getRegDteSaisi() {
		return this.regDteSaisi;
	}

	public void setRegDteSaisi(Date regDteSaisi) {
		this.regDteSaisi = regDteSaisi;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VbRegionId))
			return false;
		VbRegionId castOther = (VbRegionId) other;

		return ((this.getRegCode() == castOther.getRegCode()) || (this.getRegCode() != null
				&& castOther.getRegCode() != null && this.getRegCode().equals(castOther.getRegCode())))
				&& ((this.getRegLibelle() == castOther.getRegLibelle()) || (this.getRegLibelle() != null
						&& castOther.getRegLibelle() != null && this.getRegLibelle().equals(castOther.getRegLibelle())))
				&& ((this.getRegOpeMatricule() == castOther.getRegOpeMatricule())
						|| (this.getRegOpeMatricule() != null && castOther.getRegOpeMatricule() != null
								&& this.getRegOpeMatricule().equals(castOther.getRegOpeMatricule())))
				&& ((this.getRegDteSaisi() == castOther.getRegDteSaisi())
						|| (this.getRegDteSaisi() != null && castOther.getRegDteSaisi() != null
								&& this.getRegDteSaisi().equals(castOther.getRegDteSaisi())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getRegCode() == null ? 0 : this.getRegCode().hashCode());
		result = 37 * result + (getRegLibelle() == null ? 0 : this.getRegLibelle().hashCode());
		result = 37 * result + (getRegOpeMatricule() == null ? 0 : this.getRegOpeMatricule().hashCode());
		result = 37 * result + (getRegDteSaisi() == null ? 0 : this.getRegDteSaisi().hashCode());
		return result;
	}

}
