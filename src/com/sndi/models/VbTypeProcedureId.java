package com.sndi.models;
// Generated 18 juin 2020 16:45:49 by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VbTypeProcedureId generated by hbm2java
 */
@Embeddable
public class VbTypeProcedureId implements java.io.Serializable {

	private String typId;
	private String typLib;

	public VbTypeProcedureId() {
	}

	public VbTypeProcedureId(String typId) {
		this.typId = typId;
	}

	public VbTypeProcedureId(String typId, String typLib) {
		this.typId = typId;
		this.typLib = typLib;
	}

	@Column(name = "TYP_ID", nullable = false, length = 5)
	public String getTypId() {
		return this.typId;
	}

	public void setTypId(String typId) {
		this.typId = typId;
	}

	@Column(name = "TYP_LIB", length = 1000)
	public String getTypLib() {
		return this.typLib;
	}

	public void setTypLib(String typLib) {
		this.typLib = typLib;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VbTypeProcedureId))
			return false;
		VbTypeProcedureId castOther = (VbTypeProcedureId) other;

		return ((this.getTypId() == castOther.getTypId()) || (this.getTypId() != null && castOther.getTypId() != null
				&& this.getTypId().equals(castOther.getTypId())))
				&& ((this.getTypLib() == castOther.getTypLib()) || (this.getTypLib() != null
						&& castOther.getTypLib() != null && this.getTypLib().equals(castOther.getTypLib())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getTypId() == null ? 0 : this.getTypId().hashCode());
		result = 37 * result + (getTypLib() == null ? 0 : this.getTypLib().hashCode());
		return result;
	}

}
