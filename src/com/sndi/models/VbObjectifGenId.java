package com.sndi.models;
// Generated 22 mars 2020 01:52:15 by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VbObjectifGenId generated by hbm2java
 */
@Embeddable
public class VbObjectifGenId implements java.io.Serializable {

	private long obgId;
	private Long obgProId;
	private String obgCode;
	private String obgLibelleCourt;
	private String obgLibelleLong;

	public VbObjectifGenId() {
	}

	public VbObjectifGenId(long obgId) {
		this.obgId = obgId;
	}

	public VbObjectifGenId(long obgId, Long obgProId, String obgCode, String obgLibelleCourt, String obgLibelleLong) {
		this.obgId = obgId;
		this.obgProId = obgProId;
		this.obgCode = obgCode;
		this.obgLibelleCourt = obgLibelleCourt;
		this.obgLibelleLong = obgLibelleLong;
	}

	@Column(name = "OBG_ID", nullable = false, precision = 10, scale = 0)
	public long getObgId() {
		return this.obgId;
	}

	public void setObgId(long obgId) {
		this.obgId = obgId;
	}

	@Column(name = "OBG_PRO_ID", precision = 10, scale = 0)
	public Long getObgProId() {
		return this.obgProId;
	}

	public void setObgProId(Long obgProId) {
		this.obgProId = obgProId;
	}

	@Column(name = "OBG_CODE", length = 10)
	public String getObgCode() {
		return this.obgCode;
	}

	public void setObgCode(String obgCode) {
		this.obgCode = obgCode;
	}

	@Column(name = "OBG_LIBELLE_COURT", length = 500)
	public String getObgLibelleCourt() {
		return this.obgLibelleCourt;
	}

	public void setObgLibelleCourt(String obgLibelleCourt) {
		this.obgLibelleCourt = obgLibelleCourt;
	}

	@Column(name = "OBG_LIBELLE_LONG", length = 1000)
	public String getObgLibelleLong() {
		return this.obgLibelleLong;
	}

	public void setObgLibelleLong(String obgLibelleLong) {
		this.obgLibelleLong = obgLibelleLong;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VbObjectifGenId))
			return false;
		VbObjectifGenId castOther = (VbObjectifGenId) other;

		return (this.getObgId() == castOther.getObgId())
				&& ((this.getObgProId() == castOther.getObgProId()) || (this.getObgProId() != null
						&& castOther.getObgProId() != null && this.getObgProId().equals(castOther.getObgProId())))
				&& ((this.getObgCode() == castOther.getObgCode()) || (this.getObgCode() != null
						&& castOther.getObgCode() != null && this.getObgCode().equals(castOther.getObgCode())))
				&& ((this.getObgLibelleCourt() == castOther.getObgLibelleCourt())
						|| (this.getObgLibelleCourt() != null && castOther.getObgLibelleCourt() != null
								&& this.getObgLibelleCourt().equals(castOther.getObgLibelleCourt())))
				&& ((this.getObgLibelleLong() == castOther.getObgLibelleLong())
						|| (this.getObgLibelleLong() != null && castOther.getObgLibelleLong() != null
								&& this.getObgLibelleLong().equals(castOther.getObgLibelleLong())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getObgId();
		result = 37 * result + (getObgProId() == null ? 0 : this.getObgProId().hashCode());
		result = 37 * result + (getObgCode() == null ? 0 : this.getObgCode().hashCode());
		result = 37 * result + (getObgLibelleCourt() == null ? 0 : this.getObgLibelleCourt().hashCode());
		result = 37 * result + (getObgLibelleLong() == null ? 0 : this.getObgLibelleLong().hashCode());
		return result;
	}

}
