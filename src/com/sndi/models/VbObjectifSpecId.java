package com.sndi.models;
// Generated 30 juin 2020 16:42:29 by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VbObjectifSpecId generated by hbm2java
 */
@Embeddable
public class VbObjectifSpecId implements java.io.Serializable {

	private long obsId;
	private Long obsObgId;
	private String obsCode;
	private String obsLibelleCourt;
	private String obsLibelleLong;

	public VbObjectifSpecId() {
	}

	public VbObjectifSpecId(long obsId) {
		this.obsId = obsId;
	}

	public VbObjectifSpecId(long obsId, Long obsObgId, String obsCode, String obsLibelleCourt, String obsLibelleLong) {
		this.obsId = obsId;
		this.obsObgId = obsObgId;
		this.obsCode = obsCode;
		this.obsLibelleCourt = obsLibelleCourt;
		this.obsLibelleLong = obsLibelleLong;
	}

	@Column(name = "OBS_ID", nullable = false, precision = 10, scale = 0)
	public long getObsId() {
		return this.obsId;
	}

	public void setObsId(long obsId) {
		this.obsId = obsId;
	}

	@Column(name = "OBS_OBG_ID", precision = 10, scale = 0)
	public Long getObsObgId() {
		return this.obsObgId;
	}

	public void setObsObgId(Long obsObgId) {
		this.obsObgId = obsObgId;
	}

	@Column(name = "OBS_CODE", length = 10)
	public String getObsCode() {
		return this.obsCode;
	}

	public void setObsCode(String obsCode) {
		this.obsCode = obsCode;
	}

	@Column(name = "OBS_LIBELLE_COURT", length = 500)
	public String getObsLibelleCourt() {
		return this.obsLibelleCourt;
	}

	public void setObsLibelleCourt(String obsLibelleCourt) {
		this.obsLibelleCourt = obsLibelleCourt;
	}

	@Column(name = "OBS_LIBELLE_LONG", length = 1000)
	public String getObsLibelleLong() {
		return this.obsLibelleLong;
	}

	public void setObsLibelleLong(String obsLibelleLong) {
		this.obsLibelleLong = obsLibelleLong;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VbObjectifSpecId))
			return false;
		VbObjectifSpecId castOther = (VbObjectifSpecId) other;

		return (this.getObsId() == castOther.getObsId())
				&& ((this.getObsObgId() == castOther.getObsObgId()) || (this.getObsObgId() != null
						&& castOther.getObsObgId() != null && this.getObsObgId().equals(castOther.getObsObgId())))
				&& ((this.getObsCode() == castOther.getObsCode()) || (this.getObsCode() != null
						&& castOther.getObsCode() != null && this.getObsCode().equals(castOther.getObsCode())))
				&& ((this.getObsLibelleCourt() == castOther.getObsLibelleCourt())
						|| (this.getObsLibelleCourt() != null && castOther.getObsLibelleCourt() != null
								&& this.getObsLibelleCourt().equals(castOther.getObsLibelleCourt())))
				&& ((this.getObsLibelleLong() == castOther.getObsLibelleLong())
						|| (this.getObsLibelleLong() != null && castOther.getObsLibelleLong() != null
								&& this.getObsLibelleLong().equals(castOther.getObsLibelleLong())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getObsId();
		result = 37 * result + (getObsObgId() == null ? 0 : this.getObsObgId().hashCode());
		result = 37 * result + (getObsCode() == null ? 0 : this.getObsCode().hashCode());
		result = 37 * result + (getObsLibelleCourt() == null ? 0 : this.getObsLibelleCourt().hashCode());
		result = 37 * result + (getObsLibelleLong() == null ? 0 : this.getObsLibelleLong().hashCode());
		return result;
	}

}
