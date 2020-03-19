package com.sndi.models;
// Generated 19 mars 2020 16:14:06 by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VbTypeDacSpecsId generated by hbm2java
 */
@Embeddable
public class VbTypeDacSpecsId implements java.io.Serializable {

	private String tdcCode;
	private String tdcLibelle;

	public VbTypeDacSpecsId() {
	}

	public VbTypeDacSpecsId(String tdcCode) {
		this.tdcCode = tdcCode;
	}

	public VbTypeDacSpecsId(String tdcCode, String tdcLibelle) {
		this.tdcCode = tdcCode;
		this.tdcLibelle = tdcLibelle;
	}

	@Column(name = "TDC_CODE", nullable = false, length = 3)
	public String getTdcCode() {
		return this.tdcCode;
	}

	public void setTdcCode(String tdcCode) {
		this.tdcCode = tdcCode;
	}

	@Column(name = "TDC_LIBELLE", length = 1000)
	public String getTdcLibelle() {
		return this.tdcLibelle;
	}

	public void setTdcLibelle(String tdcLibelle) {
		this.tdcLibelle = tdcLibelle;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VbTypeDacSpecsId))
			return false;
		VbTypeDacSpecsId castOther = (VbTypeDacSpecsId) other;

		return ((this.getTdcCode() == castOther.getTdcCode()) || (this.getTdcCode() != null
				&& castOther.getTdcCode() != null && this.getTdcCode().equals(castOther.getTdcCode())))
				&& ((this.getTdcLibelle() == castOther.getTdcLibelle())
						|| (this.getTdcLibelle() != null && castOther.getTdcLibelle() != null
								&& this.getTdcLibelle().equals(castOther.getTdcLibelle())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getTdcCode() == null ? 0 : this.getTdcCode().hashCode());
		result = 37 * result + (getTdcLibelle() == null ? 0 : this.getTdcLibelle().hashCode());
		return result;
	}

}
