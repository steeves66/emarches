package com.sndi.models;
// Generated 8 ao�t 2020 14:11:26 by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VbNaturePieceId generated by hbm2java
 */
@Embeddable
public class VbNaturePieceId implements java.io.Serializable {

	private String napCode;
	private String napNapLibelleCourt;
	private String napNapLibelleLong;

	public VbNaturePieceId() {
	}

	public VbNaturePieceId(String napCode, String napNapLibelleCourt) {
		this.napCode = napCode;
		this.napNapLibelleCourt = napNapLibelleCourt;
	}

	public VbNaturePieceId(String napCode, String napNapLibelleCourt, String napNapLibelleLong) {
		this.napCode = napCode;
		this.napNapLibelleCourt = napNapLibelleCourt;
		this.napNapLibelleLong = napNapLibelleLong;
	}

	@Column(name = "NAP_CODE", nullable = false, length = 5)
	public String getNapCode() {
		return this.napCode;
	}

	public void setNapCode(String napCode) {
		this.napCode = napCode;
	}

	@Column(name = "NAP_NAP_LIBELLE_COURT", nullable = false, length = 500)
	public String getNapNapLibelleCourt() {
		return this.napNapLibelleCourt;
	}

	public void setNapNapLibelleCourt(String napNapLibelleCourt) {
		this.napNapLibelleCourt = napNapLibelleCourt;
	}

	@Column(name = "NAP_NAP_LIBELLE_LONG", length = 1000)
	public String getNapNapLibelleLong() {
		return this.napNapLibelleLong;
	}

	public void setNapNapLibelleLong(String napNapLibelleLong) {
		this.napNapLibelleLong = napNapLibelleLong;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VbNaturePieceId))
			return false;
		VbNaturePieceId castOther = (VbNaturePieceId) other;

		return ((this.getNapCode() == castOther.getNapCode()) || (this.getNapCode() != null
				&& castOther.getNapCode() != null && this.getNapCode().equals(castOther.getNapCode())))
				&& ((this.getNapNapLibelleCourt() == castOther.getNapNapLibelleCourt())
						|| (this.getNapNapLibelleCourt() != null && castOther.getNapNapLibelleCourt() != null
								&& this.getNapNapLibelleCourt().equals(castOther.getNapNapLibelleCourt())))
				&& ((this.getNapNapLibelleLong() == castOther.getNapNapLibelleLong())
						|| (this.getNapNapLibelleLong() != null && castOther.getNapNapLibelleLong() != null
								&& this.getNapNapLibelleLong().equals(castOther.getNapNapLibelleLong())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getNapCode() == null ? 0 : this.getNapCode().hashCode());
		result = 37 * result + (getNapNapLibelleCourt() == null ? 0 : this.getNapNapLibelleCourt().hashCode());
		result = 37 * result + (getNapNapLibelleLong() == null ? 0 : this.getNapNapLibelleLong().hashCode());
		return result;
	}

}
