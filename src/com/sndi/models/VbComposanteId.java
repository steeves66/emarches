package com.sndi.models;
// Generated 28 mars 2020 03:24:07 by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VbComposanteId generated by hbm2java
 */
@Embeddable
public class VbComposanteId implements java.io.Serializable {

	private long comId;
	private Long comProId;
	private String comCode;
	private String comLibelleCourt;
	private String comLibelleLong;

	public VbComposanteId() {
	}

	public VbComposanteId(long comId, String comLibelleCourt) {
		this.comId = comId;
		this.comLibelleCourt = comLibelleCourt;
	}

	public VbComposanteId(long comId, Long comProId, String comCode, String comLibelleCourt, String comLibelleLong) {
		this.comId = comId;
		this.comProId = comProId;
		this.comCode = comCode;
		this.comLibelleCourt = comLibelleCourt;
		this.comLibelleLong = comLibelleLong;
	}

	@Column(name = "COM_ID", nullable = false, precision = 10, scale = 0)
	public long getComId() {
		return this.comId;
	}

	public void setComId(long comId) {
		this.comId = comId;
	}

	@Column(name = "COM_PRO_ID", precision = 10, scale = 0)
	public Long getComProId() {
		return this.comProId;
	}

	public void setComProId(Long comProId) {
		this.comProId = comProId;
	}

	@Column(name = "COM_CODE", length = 50)
	public String getComCode() {
		return this.comCode;
	}

	public void setComCode(String comCode) {
		this.comCode = comCode;
	}

	@Column(name = "COM_LIBELLE_COURT", nullable = false, length = 500)
	public String getComLibelleCourt() {
		return this.comLibelleCourt;
	}

	public void setComLibelleCourt(String comLibelleCourt) {
		this.comLibelleCourt = comLibelleCourt;
	}

	@Column(name = "COM_LIBELLE_LONG", length = 1000)
	public String getComLibelleLong() {
		return this.comLibelleLong;
	}

	public void setComLibelleLong(String comLibelleLong) {
		this.comLibelleLong = comLibelleLong;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VbComposanteId))
			return false;
		VbComposanteId castOther = (VbComposanteId) other;

		return (this.getComId() == castOther.getComId())
				&& ((this.getComProId() == castOther.getComProId()) || (this.getComProId() != null
						&& castOther.getComProId() != null && this.getComProId().equals(castOther.getComProId())))
				&& ((this.getComCode() == castOther.getComCode()) || (this.getComCode() != null
						&& castOther.getComCode() != null && this.getComCode().equals(castOther.getComCode())))
				&& ((this.getComLibelleCourt() == castOther.getComLibelleCourt())
						|| (this.getComLibelleCourt() != null && castOther.getComLibelleCourt() != null
								&& this.getComLibelleCourt().equals(castOther.getComLibelleCourt())))
				&& ((this.getComLibelleLong() == castOther.getComLibelleLong())
						|| (this.getComLibelleLong() != null && castOther.getComLibelleLong() != null
								&& this.getComLibelleLong().equals(castOther.getComLibelleLong())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getComId();
		result = 37 * result + (getComProId() == null ? 0 : this.getComProId().hashCode());
		result = 37 * result + (getComCode() == null ? 0 : this.getComCode().hashCode());
		result = 37 * result + (getComLibelleCourt() == null ? 0 : this.getComLibelleCourt().hashCode());
		result = 37 * result + (getComLibelleLong() == null ? 0 : this.getComLibelleLong().hashCode());
		return result;
	}

}
