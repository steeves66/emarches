package com.sndi.models;
// Generated 27 mars 2020 12:01:30 by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VbPlanPassationId generated by hbm2java
 */
@Embeddable
public class VbPlanPassationId implements java.io.Serializable {

	private long plpId;
	private String plpStrCode;
	private String plpFonCod;
	private short plpGesCode;
	private String plpCode;
	private String plpLibelle;

	public VbPlanPassationId() {
	}

	public VbPlanPassationId(long plpId, String plpStrCode, String plpFonCod, short plpGesCode) {
		this.plpId = plpId;
		this.plpStrCode = plpStrCode;
		this.plpFonCod = plpFonCod;
		this.plpGesCode = plpGesCode;
	}

	public VbPlanPassationId(long plpId, String plpStrCode, String plpFonCod, short plpGesCode, String plpCode,
			String plpLibelle) {
		this.plpId = plpId;
		this.plpStrCode = plpStrCode;
		this.plpFonCod = plpFonCod;
		this.plpGesCode = plpGesCode;
		this.plpCode = plpCode;
		this.plpLibelle = plpLibelle;
	}

	@Column(name = "PLP_ID", nullable = false, precision = 10, scale = 0)
	public long getPlpId() {
		return this.plpId;
	}

	public void setPlpId(long plpId) {
		this.plpId = plpId;
	}

	@Column(name = "PLP_STR_CODE", nullable = false, length = 3)
	public String getPlpStrCode() {
		return this.plpStrCode;
	}

	public void setPlpStrCode(String plpStrCode) {
		this.plpStrCode = plpStrCode;
	}

	@Column(name = "PLP_FON_COD", nullable = false, length = 12)
	public String getPlpFonCod() {
		return this.plpFonCod;
	}

	public void setPlpFonCod(String plpFonCod) {
		this.plpFonCod = plpFonCod;
	}

	@Column(name = "PLP_GES_CODE", nullable = false, precision = 4, scale = 0)
	public short getPlpGesCode() {
		return this.plpGesCode;
	}

	public void setPlpGesCode(short plpGesCode) {
		this.plpGesCode = plpGesCode;
	}

	@Column(name = "PLP_CODE", length = 50)
	public String getPlpCode() {
		return this.plpCode;
	}

	public void setPlpCode(String plpCode) {
		this.plpCode = plpCode;
	}

	@Column(name = "PLP_LIBELLE", length = 1000)
	public String getPlpLibelle() {
		return this.plpLibelle;
	}

	public void setPlpLibelle(String plpLibelle) {
		this.plpLibelle = plpLibelle;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VbPlanPassationId))
			return false;
		VbPlanPassationId castOther = (VbPlanPassationId) other;

		return (this.getPlpId() == castOther.getPlpId())
				&& ((this.getPlpStrCode() == castOther.getPlpStrCode()) || (this.getPlpStrCode() != null
						&& castOther.getPlpStrCode() != null && this.getPlpStrCode().equals(castOther.getPlpStrCode())))
				&& ((this.getPlpFonCod() == castOther.getPlpFonCod()) || (this.getPlpFonCod() != null
						&& castOther.getPlpFonCod() != null && this.getPlpFonCod().equals(castOther.getPlpFonCod())))
				&& (this.getPlpGesCode() == castOther.getPlpGesCode())
				&& ((this.getPlpCode() == castOther.getPlpCode()) || (this.getPlpCode() != null
						&& castOther.getPlpCode() != null && this.getPlpCode().equals(castOther.getPlpCode())))
				&& ((this.getPlpLibelle() == castOther.getPlpLibelle())
						|| (this.getPlpLibelle() != null && castOther.getPlpLibelle() != null
								&& this.getPlpLibelle().equals(castOther.getPlpLibelle())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getPlpId();
		result = 37 * result + (getPlpStrCode() == null ? 0 : this.getPlpStrCode().hashCode());
		result = 37 * result + (getPlpFonCod() == null ? 0 : this.getPlpFonCod().hashCode());
		result = 37 * result + this.getPlpGesCode();
		result = 37 * result + (getPlpCode() == null ? 0 : this.getPlpCode().hashCode());
		result = 37 * result + (getPlpLibelle() == null ? 0 : this.getPlpLibelle().hashCode());
		return result;
	}

}
