package com.sndi.models;
// Generated 27 mars 2020 22:20:54 by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VbPlanGeneralId generated by hbm2java
 */
@Embeddable
public class VbPlanGeneralId implements java.io.Serializable {

	private long plgId;
	private String plgStrCode;
	private String plgFonCod;
	private short plgGesCode;
	private String plgCode;
	private String plgLibelle;

	public VbPlanGeneralId() {
	}

	public VbPlanGeneralId(long plgId, String plgStrCode, String plgFonCod, short plgGesCode) {
		this.plgId = plgId;
		this.plgStrCode = plgStrCode;
		this.plgFonCod = plgFonCod;
		this.plgGesCode = plgGesCode;
	}

	public VbPlanGeneralId(long plgId, String plgStrCode, String plgFonCod, short plgGesCode, String plgCode,
			String plgLibelle) {
		this.plgId = plgId;
		this.plgStrCode = plgStrCode;
		this.plgFonCod = plgFonCod;
		this.plgGesCode = plgGesCode;
		this.plgCode = plgCode;
		this.plgLibelle = plgLibelle;
	}

	@Column(name = "PLG_ID", nullable = false, precision = 10, scale = 0)
	public long getPlgId() {
		return this.plgId;
	}

	public void setPlgId(long plgId) {
		this.plgId = plgId;
	}

	@Column(name = "PLG_STR_CODE", nullable = false, length = 3)
	public String getPlgStrCode() {
		return this.plgStrCode;
	}

	public void setPlgStrCode(String plgStrCode) {
		this.plgStrCode = plgStrCode;
	}

	@Column(name = "PLG_FON_COD", nullable = false, length = 12)
	public String getPlgFonCod() {
		return this.plgFonCod;
	}

	public void setPlgFonCod(String plgFonCod) {
		this.plgFonCod = plgFonCod;
	}

	@Column(name = "PLG_GES_CODE", nullable = false, precision = 4, scale = 0)
	public short getPlgGesCode() {
		return this.plgGesCode;
	}

	public void setPlgGesCode(short plgGesCode) {
		this.plgGesCode = plgGesCode;
	}

	@Column(name = "PLG_CODE", length = 50)
	public String getPlgCode() {
		return this.plgCode;
	}

	public void setPlgCode(String plgCode) {
		this.plgCode = plgCode;
	}

	@Column(name = "PLG_LIBELLE", length = 1000)
	public String getPlgLibelle() {
		return this.plgLibelle;
	}

	public void setPlgLibelle(String plgLibelle) {
		this.plgLibelle = plgLibelle;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VbPlanGeneralId))
			return false;
		VbPlanGeneralId castOther = (VbPlanGeneralId) other;

		return (this.getPlgId() == castOther.getPlgId())
				&& ((this.getPlgStrCode() == castOther.getPlgStrCode()) || (this.getPlgStrCode() != null
						&& castOther.getPlgStrCode() != null && this.getPlgStrCode().equals(castOther.getPlgStrCode())))
				&& ((this.getPlgFonCod() == castOther.getPlgFonCod()) || (this.getPlgFonCod() != null
						&& castOther.getPlgFonCod() != null && this.getPlgFonCod().equals(castOther.getPlgFonCod())))
				&& (this.getPlgGesCode() == castOther.getPlgGesCode())
				&& ((this.getPlgCode() == castOther.getPlgCode()) || (this.getPlgCode() != null
						&& castOther.getPlgCode() != null && this.getPlgCode().equals(castOther.getPlgCode())))
				&& ((this.getPlgLibelle() == castOther.getPlgLibelle())
						|| (this.getPlgLibelle() != null && castOther.getPlgLibelle() != null
								&& this.getPlgLibelle().equals(castOther.getPlgLibelle())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getPlgId();
		result = 37 * result + (getPlgStrCode() == null ? 0 : this.getPlgStrCode().hashCode());
		result = 37 * result + (getPlgFonCod() == null ? 0 : this.getPlgFonCod().hashCode());
		result = 37 * result + this.getPlgGesCode();
		result = 37 * result + (getPlgCode() == null ? 0 : this.getPlgCode().hashCode());
		result = 37 * result + (getPlgLibelle() == null ? 0 : this.getPlgLibelle().hashCode());
		return result;
	}

}
