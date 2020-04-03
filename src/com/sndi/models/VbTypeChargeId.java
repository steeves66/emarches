package com.sndi.models;
// Generated 3 avr. 2020 00:55:57 by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VbTypeChargeId generated by hbm2java
 */
@Embeddable
public class VbTypeChargeId implements java.io.Serializable {

	private String tycCode;
	private String tycLibelleCourt;
	private String tycLibelleLong;
	private String tymTymCode;
	private String tymGroupe;

	public VbTypeChargeId() {
	}

	public VbTypeChargeId(String tycCode, String tycLibelleCourt) {
		this.tycCode = tycCode;
		this.tycLibelleCourt = tycLibelleCourt;
	}

	public VbTypeChargeId(String tycCode, String tycLibelleCourt, String tycLibelleLong, String tymTymCode,
			String tymGroupe) {
		this.tycCode = tycCode;
		this.tycLibelleCourt = tycLibelleCourt;
		this.tycLibelleLong = tycLibelleLong;
		this.tymTymCode = tymTymCode;
		this.tymGroupe = tymGroupe;
	}

	@Column(name = "TYC_CODE", nullable = false, length = 3)
	public String getTycCode() {
		return this.tycCode;
	}

	public void setTycCode(String tycCode) {
		this.tycCode = tycCode;
	}

	@Column(name = "TYC_LIBELLE_COURT", nullable = false, length = 500)
	public String getTycLibelleCourt() {
		return this.tycLibelleCourt;
	}

	public void setTycLibelleCourt(String tycLibelleCourt) {
		this.tycLibelleCourt = tycLibelleCourt;
	}

	@Column(name = "TYC_LIBELLE_LONG", length = 1000)
	public String getTycLibelleLong() {
		return this.tycLibelleLong;
	}

	public void setTycLibelleLong(String tycLibelleLong) {
		this.tycLibelleLong = tycLibelleLong;
	}

	@Column(name = "TYM_TYM_CODE", length = 3)
	public String getTymTymCode() {
		return this.tymTymCode;
	}

	public void setTymTymCode(String tymTymCode) {
		this.tymTymCode = tymTymCode;
	}

	@Column(name = "TYM_GROUPE", length = 3)
	public String getTymGroupe() {
		return this.tymGroupe;
	}

	public void setTymGroupe(String tymGroupe) {
		this.tymGroupe = tymGroupe;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VbTypeChargeId))
			return false;
		VbTypeChargeId castOther = (VbTypeChargeId) other;

		return ((this.getTycCode() == castOther.getTycCode()) || (this.getTycCode() != null
				&& castOther.getTycCode() != null && this.getTycCode().equals(castOther.getTycCode())))
				&& ((this.getTycLibelleCourt() == castOther.getTycLibelleCourt())
						|| (this.getTycLibelleCourt() != null && castOther.getTycLibelleCourt() != null
								&& this.getTycLibelleCourt().equals(castOther.getTycLibelleCourt())))
				&& ((this.getTycLibelleLong() == castOther.getTycLibelleLong())
						|| (this.getTycLibelleLong() != null && castOther.getTycLibelleLong() != null
								&& this.getTycLibelleLong().equals(castOther.getTycLibelleLong())))
				&& ((this.getTymTymCode() == castOther.getTymTymCode()) || (this.getTymTymCode() != null
						&& castOther.getTymTymCode() != null && this.getTymTymCode().equals(castOther.getTymTymCode())))
				&& ((this.getTymGroupe() == castOther.getTymGroupe()) || (this.getTymGroupe() != null
						&& castOther.getTymGroupe() != null && this.getTymGroupe().equals(castOther.getTymGroupe())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getTycCode() == null ? 0 : this.getTycCode().hashCode());
		result = 37 * result + (getTycLibelleCourt() == null ? 0 : this.getTycLibelleCourt().hashCode());
		result = 37 * result + (getTycLibelleLong() == null ? 0 : this.getTycLibelleLong().hashCode());
		result = 37 * result + (getTymTymCode() == null ? 0 : this.getTymTymCode().hashCode());
		result = 37 * result + (getTymGroupe() == null ? 0 : this.getTymGroupe().hashCode());
		return result;
	}

}
