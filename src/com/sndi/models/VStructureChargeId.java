package com.sndi.models;
// Generated 27 mars 2020 12:01:30 by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VStructureChargeId generated by hbm2java
 */
@Embeddable
public class VStructureChargeId implements java.io.Serializable {

	private long chrId;
	private String strLibelleLong;
	private String tycLibelleLong;

	public VStructureChargeId() {
	}

	public VStructureChargeId(long chrId) {
		this.chrId = chrId;
	}

	public VStructureChargeId(long chrId, String strLibelleLong, String tycLibelleLong) {
		this.chrId = chrId;
		this.strLibelleLong = strLibelleLong;
		this.tycLibelleLong = tycLibelleLong;
	}

	@Column(name = "CHR_ID", nullable = false, precision = 10, scale = 0)
	public long getChrId() {
		return this.chrId;
	}

	public void setChrId(long chrId) {
		this.chrId = chrId;
	}

	@Column(name = "STR_LIBELLE_LONG", length = 1000)
	public String getStrLibelleLong() {
		return this.strLibelleLong;
	}

	public void setStrLibelleLong(String strLibelleLong) {
		this.strLibelleLong = strLibelleLong;
	}

	@Column(name = "TYC_LIBELLE_LONG", length = 1000)
	public String getTycLibelleLong() {
		return this.tycLibelleLong;
	}

	public void setTycLibelleLong(String tycLibelleLong) {
		this.tycLibelleLong = tycLibelleLong;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VStructureChargeId))
			return false;
		VStructureChargeId castOther = (VStructureChargeId) other;

		return (this.getChrId() == castOther.getChrId())
				&& ((this.getStrLibelleLong() == castOther.getStrLibelleLong())
						|| (this.getStrLibelleLong() != null && castOther.getStrLibelleLong() != null
								&& this.getStrLibelleLong().equals(castOther.getStrLibelleLong())))
				&& ((this.getTycLibelleLong() == castOther.getTycLibelleLong())
						|| (this.getTycLibelleLong() != null && castOther.getTycLibelleLong() != null
								&& this.getTycLibelleLong().equals(castOther.getTycLibelleLong())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getChrId();
		result = 37 * result + (getStrLibelleLong() == null ? 0 : this.getStrLibelleLong().hashCode());
		result = 37 * result + (getTycLibelleLong() == null ? 0 : this.getTycLibelleLong().hashCode());
		return result;
	}

}
