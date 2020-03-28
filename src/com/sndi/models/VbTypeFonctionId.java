package com.sndi.models;
// Generated 28 mars 2020 15:50:26 by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VbTypeFonctionId generated by hbm2java
 */
@Embeddable
public class VbTypeFonctionId implements java.io.Serializable {

	private String tyfCod;
	private String tyfLibelle;

	public VbTypeFonctionId() {
	}

	public VbTypeFonctionId(String tyfCod) {
		this.tyfCod = tyfCod;
	}

	public VbTypeFonctionId(String tyfCod, String tyfLibelle) {
		this.tyfCod = tyfCod;
		this.tyfLibelle = tyfLibelle;
	}

	@Column(name = "TYF_COD", nullable = false, length = 3)
	public String getTyfCod() {
		return this.tyfCod;
	}

	public void setTyfCod(String tyfCod) {
		this.tyfCod = tyfCod;
	}

	@Column(name = "TYF_LIBELLE", length = 300)
	public String getTyfLibelle() {
		return this.tyfLibelle;
	}

	public void setTyfLibelle(String tyfLibelle) {
		this.tyfLibelle = tyfLibelle;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VbTypeFonctionId))
			return false;
		VbTypeFonctionId castOther = (VbTypeFonctionId) other;

		return ((this.getTyfCod() == castOther.getTyfCod()) || (this.getTyfCod() != null
				&& castOther.getTyfCod() != null && this.getTyfCod().equals(castOther.getTyfCod())))
				&& ((this.getTyfLibelle() == castOther.getTyfLibelle())
						|| (this.getTyfLibelle() != null && castOther.getTyfLibelle() != null
								&& this.getTyfLibelle().equals(castOther.getTyfLibelle())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getTyfCod() == null ? 0 : this.getTyfCod().hashCode());
		result = 37 * result + (getTyfLibelle() == null ? 0 : this.getTyfLibelle().hashCode());
		return result;
	}

}
