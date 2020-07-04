package com.sndi.models;
// Generated 4 juil. 2020 18:05:44 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VModeleDaoId generated by hbm2java
 */
@Embeddable
public class VModeleDaoId implements java.io.Serializable {

	private BigDecimal VId;
	private long gpgId;
	private String mdtCode;
	private String mdtLibelleCourt;
	private String mdtLibelleLong;
	private String mdtTymCode;
	private String gpgMopCode;

	public VModeleDaoId() {
	}

	public VModeleDaoId(long gpgId, String mdtCode, String gpgMopCode) {
		this.gpgId = gpgId;
		this.mdtCode = mdtCode;
		this.gpgMopCode = gpgMopCode;
	}

	public VModeleDaoId(BigDecimal VId, long gpgId, String mdtCode, String mdtLibelleCourt, String mdtLibelleLong,
			String mdtTymCode, String gpgMopCode) {
		this.VId = VId;
		this.gpgId = gpgId;
		this.mdtCode = mdtCode;
		this.mdtLibelleCourt = mdtLibelleCourt;
		this.mdtLibelleLong = mdtLibelleLong;
		this.mdtTymCode = mdtTymCode;
		this.gpgMopCode = gpgMopCode;
	}

	@Column(name = "V_ID", precision = 22, scale = 0)
	public BigDecimal getVId() {
		return this.VId;
	}

	public void setVId(BigDecimal VId) {
		this.VId = VId;
	}

	@Column(name = "GPG_ID", nullable = false, precision = 10, scale = 0)
	public long getGpgId() {
		return this.gpgId;
	}

	public void setGpgId(long gpgId) {
		this.gpgId = gpgId;
	}

	@Column(name = "MDT_CODE", nullable = false, length = 15)
	public String getMdtCode() {
		return this.mdtCode;
	}

	public void setMdtCode(String mdtCode) {
		this.mdtCode = mdtCode;
	}

	@Column(name = "MDT_LIBELLE_COURT", length = 500)
	public String getMdtLibelleCourt() {
		return this.mdtLibelleCourt;
	}

	public void setMdtLibelleCourt(String mdtLibelleCourt) {
		this.mdtLibelleCourt = mdtLibelleCourt;
	}

	@Column(name = "MDT_LIBELLE_LONG", length = 500)
	public String getMdtLibelleLong() {
		return this.mdtLibelleLong;
	}

	public void setMdtLibelleLong(String mdtLibelleLong) {
		this.mdtLibelleLong = mdtLibelleLong;
	}

	@Column(name = "MDT_TYM_CODE", length = 3)
	public String getMdtTymCode() {
		return this.mdtTymCode;
	}

	public void setMdtTymCode(String mdtTymCode) {
		this.mdtTymCode = mdtTymCode;
	}

	@Column(name = "GPG_MOP_CODE", nullable = false, length = 3)
	public String getGpgMopCode() {
		return this.gpgMopCode;
	}

	public void setGpgMopCode(String gpgMopCode) {
		this.gpgMopCode = gpgMopCode;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VModeleDaoId))
			return false;
		VModeleDaoId castOther = (VModeleDaoId) other;

		return ((this.getVId() == castOther.getVId())
				|| (this.getVId() != null && castOther.getVId() != null && this.getVId().equals(castOther.getVId())))
				&& (this.getGpgId() == castOther.getGpgId())
				&& ((this.getMdtCode() == castOther.getMdtCode()) || (this.getMdtCode() != null
						&& castOther.getMdtCode() != null && this.getMdtCode().equals(castOther.getMdtCode())))
				&& ((this.getMdtLibelleCourt() == castOther.getMdtLibelleCourt())
						|| (this.getMdtLibelleCourt() != null && castOther.getMdtLibelleCourt() != null
								&& this.getMdtLibelleCourt().equals(castOther.getMdtLibelleCourt())))
				&& ((this.getMdtLibelleLong() == castOther.getMdtLibelleLong())
						|| (this.getMdtLibelleLong() != null && castOther.getMdtLibelleLong() != null
								&& this.getMdtLibelleLong().equals(castOther.getMdtLibelleLong())))
				&& ((this.getMdtTymCode() == castOther.getMdtTymCode()) || (this.getMdtTymCode() != null
						&& castOther.getMdtTymCode() != null && this.getMdtTymCode().equals(castOther.getMdtTymCode())))
				&& ((this.getGpgMopCode() == castOther.getGpgMopCode())
						|| (this.getGpgMopCode() != null && castOther.getGpgMopCode() != null
								&& this.getGpgMopCode().equals(castOther.getGpgMopCode())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getVId() == null ? 0 : this.getVId().hashCode());
		result = 37 * result + (int) this.getGpgId();
		result = 37 * result + (getMdtCode() == null ? 0 : this.getMdtCode().hashCode());
		result = 37 * result + (getMdtLibelleCourt() == null ? 0 : this.getMdtLibelleCourt().hashCode());
		result = 37 * result + (getMdtLibelleLong() == null ? 0 : this.getMdtLibelleLong().hashCode());
		result = 37 * result + (getMdtTymCode() == null ? 0 : this.getMdtTymCode().hashCode());
		result = 37 * result + (getGpgMopCode() == null ? 0 : this.getGpgMopCode().hashCode());
		return result;
	}

}
