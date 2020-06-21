package com.sndi.models;
// Generated 20 juin 2020 17:16:02 by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VbNatureDocumentsId generated by hbm2java
 */
@Embeddable
public class VbNatureDocumentsId implements java.io.Serializable {

	private String nadCode;
	private String nadLibelle;
	private String nadAbrege;
	private String nadType;

	public VbNatureDocumentsId() {
	}

	public VbNatureDocumentsId(String nadCode) {
		this.nadCode = nadCode;
	}

	public VbNatureDocumentsId(String nadCode, String nadLibelle, String nadAbrege, String nadType) {
		this.nadCode = nadCode;
		this.nadLibelle = nadLibelle;
		this.nadAbrege = nadAbrege;
		this.nadType = nadType;
	}

	@Column(name = "NAD_CODE", nullable = false, length = 3)
	public String getNadCode() {
		return this.nadCode;
	}

	public void setNadCode(String nadCode) {
		this.nadCode = nadCode;
	}

	@Column(name = "NAD_LIBELLE", length = 500)
	public String getNadLibelle() {
		return this.nadLibelle;
	}

	public void setNadLibelle(String nadLibelle) {
		this.nadLibelle = nadLibelle;
	}

	@Column(name = "NAD_ABREGE", length = 20)
	public String getNadAbrege() {
		return this.nadAbrege;
	}

	public void setNadAbrege(String nadAbrege) {
		this.nadAbrege = nadAbrege;
	}

	@Column(name = "NAD_TYPE", length = 3)
	public String getNadType() {
		return this.nadType;
	}

	public void setNadType(String nadType) {
		this.nadType = nadType;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VbNatureDocumentsId))
			return false;
		VbNatureDocumentsId castOther = (VbNatureDocumentsId) other;

		return ((this.getNadCode() == castOther.getNadCode()) || (this.getNadCode() != null
				&& castOther.getNadCode() != null && this.getNadCode().equals(castOther.getNadCode())))
				&& ((this.getNadLibelle() == castOther.getNadLibelle()) || (this.getNadLibelle() != null
						&& castOther.getNadLibelle() != null && this.getNadLibelle().equals(castOther.getNadLibelle())))
				&& ((this.getNadAbrege() == castOther.getNadAbrege()) || (this.getNadAbrege() != null
						&& castOther.getNadAbrege() != null && this.getNadAbrege().equals(castOther.getNadAbrege())))
				&& ((this.getNadType() == castOther.getNadType()) || (this.getNadType() != null
						&& castOther.getNadType() != null && this.getNadType().equals(castOther.getNadType())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getNadCode() == null ? 0 : this.getNadCode().hashCode());
		result = 37 * result + (getNadLibelle() == null ? 0 : this.getNadLibelle().hashCode());
		result = 37 * result + (getNadAbrege() == null ? 0 : this.getNadAbrege().hashCode());
		result = 37 * result + (getNadType() == null ? 0 : this.getNadType().hashCode());
		return result;
	}

}
