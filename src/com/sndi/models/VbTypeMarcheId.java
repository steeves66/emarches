package com.sndi.models;
// Generated 4 avr. 2020 18:03:14 by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VbTypeMarcheId generated by hbm2java
 */
@Embeddable
public class VbTypeMarcheId implements java.io.Serializable {

	private String tymCode;
	private String tymLibelleCourt;
	private String tymLibelleLong;
	private String tymTymCode;
	private String tymGroupe;

	public VbTypeMarcheId() {
	}

	public VbTypeMarcheId(String tymCode, String tymLibelleCourt) {
		this.tymCode = tymCode;
		this.tymLibelleCourt = tymLibelleCourt;
	}

	public VbTypeMarcheId(String tymCode, String tymLibelleCourt, String tymLibelleLong, String tymTymCode,
			String tymGroupe) {
		this.tymCode = tymCode;
		this.tymLibelleCourt = tymLibelleCourt;
		this.tymLibelleLong = tymLibelleLong;
		this.tymTymCode = tymTymCode;
		this.tymGroupe = tymGroupe;
	}

	@Column(name = "TYM_CODE", nullable = false, length = 3)
	public String getTymCode() {
		return this.tymCode;
	}

	public void setTymCode(String tymCode) {
		this.tymCode = tymCode;
	}

	@Column(name = "TYM_LIBELLE_COURT", nullable = false, length = 500)
	public String getTymLibelleCourt() {
		return this.tymLibelleCourt;
	}

	public void setTymLibelleCourt(String tymLibelleCourt) {
		this.tymLibelleCourt = tymLibelleCourt;
	}

	@Column(name = "TYM_LIBELLE_LONG", length = 1000)
	public String getTymLibelleLong() {
		return this.tymLibelleLong;
	}

	public void setTymLibelleLong(String tymLibelleLong) {
		this.tymLibelleLong = tymLibelleLong;
	}

	@Column(name = "TYM_TYM_CODE", length = 3)
	public String getTymTymCode() {
		return this.tymTymCode;
	}

	public void setTymTymCode(String tymTymCode) {
		this.tymTymCode = tymTymCode;
	}

	@Column(name = "TYM_GROUPE", length = 2)
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
		if (!(other instanceof VbTypeMarcheId))
			return false;
		VbTypeMarcheId castOther = (VbTypeMarcheId) other;

		return ((this.getTymCode() == castOther.getTymCode()) || (this.getTymCode() != null
				&& castOther.getTymCode() != null && this.getTymCode().equals(castOther.getTymCode())))
				&& ((this.getTymLibelleCourt() == castOther.getTymLibelleCourt())
						|| (this.getTymLibelleCourt() != null && castOther.getTymLibelleCourt() != null
								&& this.getTymLibelleCourt().equals(castOther.getTymLibelleCourt())))
				&& ((this.getTymLibelleLong() == castOther.getTymLibelleLong())
						|| (this.getTymLibelleLong() != null && castOther.getTymLibelleLong() != null
								&& this.getTymLibelleLong().equals(castOther.getTymLibelleLong())))
				&& ((this.getTymTymCode() == castOther.getTymTymCode()) || (this.getTymTymCode() != null
						&& castOther.getTymTymCode() != null && this.getTymTymCode().equals(castOther.getTymTymCode())))
				&& ((this.getTymGroupe() == castOther.getTymGroupe()) || (this.getTymGroupe() != null
						&& castOther.getTymGroupe() != null && this.getTymGroupe().equals(castOther.getTymGroupe())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getTymCode() == null ? 0 : this.getTymCode().hashCode());
		result = 37 * result + (getTymLibelleCourt() == null ? 0 : this.getTymLibelleCourt().hashCode());
		result = 37 * result + (getTymLibelleLong() == null ? 0 : this.getTymLibelleLong().hashCode());
		result = 37 * result + (getTymTymCode() == null ? 0 : this.getTymTymCode().hashCode());
		result = 37 * result + (getTymGroupe() == null ? 0 : this.getTymGroupe().hashCode());
		return result;
	}

}
