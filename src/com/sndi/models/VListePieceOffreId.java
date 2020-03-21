package com.sndi.models;
// Generated 21 mars 2020 13:48:08 by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VListePieceOffreId generated by hbm2java
 */
@Embeddable
public class VListePieceOffreId implements java.io.Serializable {

	private Character code;
	private String libelle;

	public VListePieceOffreId() {
	}

	public VListePieceOffreId(Character code, String libelle) {
		this.code = code;
		this.libelle = libelle;
	}

	@Column(name = "CODE", length = 1)
	public Character getCode() {
		return this.code;
	}

	public void setCode(Character code) {
		this.code = code;
	}

	@Column(name = "LIBELLE", length = 43)
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
		if (!(other instanceof VListePieceOffreId))
			return false;
		VListePieceOffreId castOther = (VListePieceOffreId) other;

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
