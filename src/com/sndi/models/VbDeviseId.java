package com.sndi.models;
// Generated 27 mars 2020 12:01:30 by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VbDeviseId generated by hbm2java
 */
@Embeddable
public class VbDeviseId implements java.io.Serializable {

	private String devCode;
	private String devLibelle;
	private String devSymbole;

	public VbDeviseId() {
	}

	public VbDeviseId(String devCode) {
		this.devCode = devCode;
	}

	public VbDeviseId(String devCode, String devLibelle, String devSymbole) {
		this.devCode = devCode;
		this.devLibelle = devLibelle;
		this.devSymbole = devSymbole;
	}

	@Column(name = "DEV_CODE", nullable = false, length = 8)
	public String getDevCode() {
		return this.devCode;
	}

	public void setDevCode(String devCode) {
		this.devCode = devCode;
	}

	@Column(name = "DEV_LIBELLE", length = 500)
	public String getDevLibelle() {
		return this.devLibelle;
	}

	public void setDevLibelle(String devLibelle) {
		this.devLibelle = devLibelle;
	}

	@Column(name = "DEV_SYMBOLE", length = 500)
	public String getDevSymbole() {
		return this.devSymbole;
	}

	public void setDevSymbole(String devSymbole) {
		this.devSymbole = devSymbole;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VbDeviseId))
			return false;
		VbDeviseId castOther = (VbDeviseId) other;

		return ((this.getDevCode() == castOther.getDevCode()) || (this.getDevCode() != null
				&& castOther.getDevCode() != null && this.getDevCode().equals(castOther.getDevCode())))
				&& ((this.getDevLibelle() == castOther.getDevLibelle()) || (this.getDevLibelle() != null
						&& castOther.getDevLibelle() != null && this.getDevLibelle().equals(castOther.getDevLibelle())))
				&& ((this.getDevSymbole() == castOther.getDevSymbole())
						|| (this.getDevSymbole() != null && castOther.getDevSymbole() != null
								&& this.getDevSymbole().equals(castOther.getDevSymbole())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getDevCode() == null ? 0 : this.getDevCode().hashCode());
		result = 37 * result + (getDevLibelle() == null ? 0 : this.getDevLibelle().hashCode());
		result = 37 * result + (getDevSymbole() == null ? 0 : this.getDevSymbole().hashCode());
		return result;
	}

}
