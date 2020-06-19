package com.sndi.models;
// Generated 18 juin 2020 16:45:49 by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VTypeStructConducId generated by hbm2java
 */
@Embeddable
public class VTypeStructConducId implements java.io.Serializable {

	private String code;
	private String libelle;

	public VTypeStructConducId() {
	}

	public VTypeStructConducId(String code, String libelle) {
		this.code = code;
		this.libelle = libelle;
	}

	@Column(name = "CODE", length = 3)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "LIBELLE", length = 28)
	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VTypeStructConducId))
			return false;
		VTypeStructConducId castOther = (VTypeStructConducId) other;

		return ((this.getCode() == castOther.getCode()) || (this.getCode() != null && castOther.getCode() != null
				&& this.getCode().equals(castOther.getCode())))
				&& ((this.getLibelle() == castOther.getLibelle()) || (this.getLibelle() != null
						&& castOther.getLibelle() != null && this.getLibelle().equals(castOther.getLibelle())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getCode() == null ? 0 : this.getCode().hashCode());
		result = 37 * result + (getLibelle() == null ? 0 : this.getLibelle().hashCode());
		return result;
	}

}
