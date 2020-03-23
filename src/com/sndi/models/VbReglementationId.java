package com.sndi.models;
// Generated 23 mars 2020 10:48:44 by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VbReglementationId generated by hbm2java
 */
@Embeddable
public class VbReglementationId implements java.io.Serializable {

	private long regId;
	private String regLibelleCourt;
	private String regLibelleLong;

	public VbReglementationId() {
	}

	public VbReglementationId(long regId) {
		this.regId = regId;
	}

	public VbReglementationId(long regId, String regLibelleCourt, String regLibelleLong) {
		this.regId = regId;
		this.regLibelleCourt = regLibelleCourt;
		this.regLibelleLong = regLibelleLong;
	}

	@Column(name = "REG_ID", nullable = false, precision = 10, scale = 0)
	public long getRegId() {
		return this.regId;
	}

	public void setRegId(long regId) {
		this.regId = regId;
	}

	@Column(name = "REG_LIBELLE_COURT", length = 500)
	public String getRegLibelleCourt() {
		return this.regLibelleCourt;
	}

	public void setRegLibelleCourt(String regLibelleCourt) {
		this.regLibelleCourt = regLibelleCourt;
	}

	@Column(name = "REG_LIBELLE_LONG", length = 1000)
	public String getRegLibelleLong() {
		return this.regLibelleLong;
	}

	public void setRegLibelleLong(String regLibelleLong) {
		this.regLibelleLong = regLibelleLong;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VbReglementationId))
			return false;
		VbReglementationId castOther = (VbReglementationId) other;

		return (this.getRegId() == castOther.getRegId())
				&& ((this.getRegLibelleCourt() == castOther.getRegLibelleCourt())
						|| (this.getRegLibelleCourt() != null && castOther.getRegLibelleCourt() != null
								&& this.getRegLibelleCourt().equals(castOther.getRegLibelleCourt())))
				&& ((this.getRegLibelleLong() == castOther.getRegLibelleLong())
						|| (this.getRegLibelleLong() != null && castOther.getRegLibelleLong() != null
								&& this.getRegLibelleLong().equals(castOther.getRegLibelleLong())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getRegId();
		result = 37 * result + (getRegLibelleCourt() == null ? 0 : this.getRegLibelleCourt().hashCode());
		result = 37 * result + (getRegLibelleLong() == null ? 0 : this.getRegLibelleLong().hashCode());
		return result;
	}

}
