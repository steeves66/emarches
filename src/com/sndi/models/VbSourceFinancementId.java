package com.sndi.models;
// Generated 19 mars 2020 16:14:06 by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VbSourceFinancementId generated by hbm2java
 */
@Embeddable
public class VbSourceFinancementId implements java.io.Serializable {

	private String souCode;
	private String souLibelle;

	public VbSourceFinancementId() {
	}

	public VbSourceFinancementId(String souCode) {
		this.souCode = souCode;
	}

	public VbSourceFinancementId(String souCode, String souLibelle) {
		this.souCode = souCode;
		this.souLibelle = souLibelle;
	}

	@Column(name = "SOU_CODE", nullable = false, length = 5)
	public String getSouCode() {
		return this.souCode;
	}

	public void setSouCode(String souCode) {
		this.souCode = souCode;
	}

	@Column(name = "SOU_LIBELLE", length = 500)
	public String getSouLibelle() {
		return this.souLibelle;
	}

	public void setSouLibelle(String souLibelle) {
		this.souLibelle = souLibelle;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VbSourceFinancementId))
			return false;
		VbSourceFinancementId castOther = (VbSourceFinancementId) other;

		return ((this.getSouCode() == castOther.getSouCode()) || (this.getSouCode() != null
				&& castOther.getSouCode() != null && this.getSouCode().equals(castOther.getSouCode())))
				&& ((this.getSouLibelle() == castOther.getSouLibelle())
						|| (this.getSouLibelle() != null && castOther.getSouLibelle() != null
								&& this.getSouLibelle().equals(castOther.getSouLibelle())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getSouCode() == null ? 0 : this.getSouCode().hashCode());
		result = 37 * result + (getSouLibelle() == null ? 0 : this.getSouLibelle().hashCode());
		return result;
	}

}
