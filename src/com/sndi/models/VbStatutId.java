package com.sndi.models;
// Generated 28 mars 2020 03:24:07 by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VbStatutId generated by hbm2java
 */
@Embeddable
public class VbStatutId implements java.io.Serializable {

	private String staCode;
	private String staLibelleCourt;
	private String staLibelleLong;

	public VbStatutId() {
	}

	public VbStatutId(String staCode) {
		this.staCode = staCode;
	}

	public VbStatutId(String staCode, String staLibelleCourt, String staLibelleLong) {
		this.staCode = staCode;
		this.staLibelleCourt = staLibelleCourt;
		this.staLibelleLong = staLibelleLong;
	}

	@Column(name = "STA_CODE", nullable = false, length = 3)
	public String getStaCode() {
		return this.staCode;
	}

	public void setStaCode(String staCode) {
		this.staCode = staCode;
	}

	@Column(name = "STA_LIBELLE_COURT", length = 500)
	public String getStaLibelleCourt() {
		return this.staLibelleCourt;
	}

	public void setStaLibelleCourt(String staLibelleCourt) {
		this.staLibelleCourt = staLibelleCourt;
	}

	@Column(name = "STA_LIBELLE_LONG", length = 1000)
	public String getStaLibelleLong() {
		return this.staLibelleLong;
	}

	public void setStaLibelleLong(String staLibelleLong) {
		this.staLibelleLong = staLibelleLong;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VbStatutId))
			return false;
		VbStatutId castOther = (VbStatutId) other;

		return ((this.getStaCode() == castOther.getStaCode()) || (this.getStaCode() != null
				&& castOther.getStaCode() != null && this.getStaCode().equals(castOther.getStaCode())))
				&& ((this.getStaLibelleCourt() == castOther.getStaLibelleCourt())
						|| (this.getStaLibelleCourt() != null && castOther.getStaLibelleCourt() != null
								&& this.getStaLibelleCourt().equals(castOther.getStaLibelleCourt())))
				&& ((this.getStaLibelleLong() == castOther.getStaLibelleLong())
						|| (this.getStaLibelleLong() != null && castOther.getStaLibelleLong() != null
								&& this.getStaLibelleLong().equals(castOther.getStaLibelleLong())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getStaCode() == null ? 0 : this.getStaCode().hashCode());
		result = 37 * result + (getStaLibelleCourt() == null ? 0 : this.getStaLibelleCourt().hashCode());
		result = 37 * result + (getStaLibelleLong() == null ? 0 : this.getStaLibelleLong().hashCode());
		return result;
	}

}
