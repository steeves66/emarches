package com.sndi.models;
// Generated 30 mars 2020 01:35:59 by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VbContenuAgpmId generated by hbm2java
 */
@Embeddable
public class VbContenuAgpmId implements java.io.Serializable {

	private String tcaCode;
	private String tcaLibelle;

	public VbContenuAgpmId() {
	}

	public VbContenuAgpmId(String tcaCode) {
		this.tcaCode = tcaCode;
	}

	public VbContenuAgpmId(String tcaCode, String tcaLibelle) {
		this.tcaCode = tcaCode;
		this.tcaLibelle = tcaLibelle;
	}

	@Column(name = "TCA_CODE", nullable = false, length = 4)
	public String getTcaCode() {
		return this.tcaCode;
	}

	public void setTcaCode(String tcaCode) {
		this.tcaCode = tcaCode;
	}

	@Column(name = "TCA_LIBELLE", length = 200)
	public String getTcaLibelle() {
		return this.tcaLibelle;
	}

	public void setTcaLibelle(String tcaLibelle) {
		this.tcaLibelle = tcaLibelle;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VbContenuAgpmId))
			return false;
		VbContenuAgpmId castOther = (VbContenuAgpmId) other;

		return ((this.getTcaCode() == castOther.getTcaCode()) || (this.getTcaCode() != null
				&& castOther.getTcaCode() != null && this.getTcaCode().equals(castOther.getTcaCode())))
				&& ((this.getTcaLibelle() == castOther.getTcaLibelle())
						|| (this.getTcaLibelle() != null && castOther.getTcaLibelle() != null
								&& this.getTcaLibelle().equals(castOther.getTcaLibelle())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getTcaCode() == null ? 0 : this.getTcaCode().hashCode());
		result = 37 * result + (getTcaLibelle() == null ? 0 : this.getTcaLibelle().hashCode());
		return result;
	}

}
