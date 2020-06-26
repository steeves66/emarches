package com.sndi.models;
// Generated 25 juin 2020 13:53:46 by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VbLibelleAdresseId generated by hbm2java
 */
@Embeddable
public class VbLibelleAdresseId implements java.io.Serializable {

	private short liaNum;
	private String liaLibelle;

	public VbLibelleAdresseId() {
	}

	public VbLibelleAdresseId(short liaNum) {
		this.liaNum = liaNum;
	}

	public VbLibelleAdresseId(short liaNum, String liaLibelle) {
		this.liaNum = liaNum;
		this.liaLibelle = liaLibelle;
	}

	@Column(name = "LIA_NUM", nullable = false, precision = 3, scale = 0)
	public short getLiaNum() {
		return this.liaNum;
	}

	public void setLiaNum(short liaNum) {
		this.liaNum = liaNum;
	}

	@Column(name = "LIA_LIBELLE", length = 500)
	public String getLiaLibelle() {
		return this.liaLibelle;
	}

	public void setLiaLibelle(String liaLibelle) {
		this.liaLibelle = liaLibelle;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VbLibelleAdresseId))
			return false;
		VbLibelleAdresseId castOther = (VbLibelleAdresseId) other;

		return (this.getLiaNum() == castOther.getLiaNum()) && ((this.getLiaLibelle() == castOther.getLiaLibelle())
				|| (this.getLiaLibelle() != null && castOther.getLiaLibelle() != null
						&& this.getLiaLibelle().equals(castOther.getLiaLibelle())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getLiaNum();
		result = 37 * result + (getLiaLibelle() == null ? 0 : this.getLiaLibelle().hashCode());
		return result;
	}

}