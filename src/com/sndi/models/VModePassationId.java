package com.sndi.models;
// Generated 25 juin 2020 13:53:46 by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VModePassationId generated by hbm2java
 */
@Embeddable
public class VModePassationId implements java.io.Serializable {

	private String mopCode;
	private String mopLibelleCourt;
	private String mopLibelleLong;

	public VModePassationId() {
	}

	public VModePassationId(String mopCode, String mopLibelleCourt) {
		this.mopCode = mopCode;
		this.mopLibelleCourt = mopLibelleCourt;
	}

	public VModePassationId(String mopCode, String mopLibelleCourt, String mopLibelleLong) {
		this.mopCode = mopCode;
		this.mopLibelleCourt = mopLibelleCourt;
		this.mopLibelleLong = mopLibelleLong;
	}

	@Column(name = "MOP_CODE", nullable = false, length = 3)
	public String getMopCode() {
		return this.mopCode;
	}

	public void setMopCode(String mopCode) {
		this.mopCode = mopCode;
	}

	@Column(name = "MOP_LIBELLE_COURT", nullable = false, length = 500)
	public String getMopLibelleCourt() {
		return this.mopLibelleCourt;
	}

	public void setMopLibelleCourt(String mopLibelleCourt) {
		this.mopLibelleCourt = mopLibelleCourt;
	}

	@Column(name = "MOP_LIBELLE_LONG", length = 1000)
	public String getMopLibelleLong() {
		return this.mopLibelleLong;
	}

	public void setMopLibelleLong(String mopLibelleLong) {
		this.mopLibelleLong = mopLibelleLong;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VModePassationId))
			return false;
		VModePassationId castOther = (VModePassationId) other;

		return ((this.getMopCode() == castOther.getMopCode()) || (this.getMopCode() != null
				&& castOther.getMopCode() != null && this.getMopCode().equals(castOther.getMopCode())))
				&& ((this.getMopLibelleCourt() == castOther.getMopLibelleCourt())
						|| (this.getMopLibelleCourt() != null && castOther.getMopLibelleCourt() != null
								&& this.getMopLibelleCourt().equals(castOther.getMopLibelleCourt())))
				&& ((this.getMopLibelleLong() == castOther.getMopLibelleLong())
						|| (this.getMopLibelleLong() != null && castOther.getMopLibelleLong() != null
								&& this.getMopLibelleLong().equals(castOther.getMopLibelleLong())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getMopCode() == null ? 0 : this.getMopCode().hashCode());
		result = 37 * result + (getMopLibelleCourt() == null ? 0 : this.getMopLibelleCourt().hashCode());
		result = 37 * result + (getMopLibelleLong() == null ? 0 : this.getMopLibelleLong().hashCode());
		return result;
	}

}
