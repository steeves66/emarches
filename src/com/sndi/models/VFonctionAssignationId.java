package com.sndi.models;
// Generated 19 mars 2020 18:39:08 by Hibernate Tools 4.3.5.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VFonctionAssignationId generated by hbm2java
 */
@Embeddable
public class VFonctionAssignationId implements java.io.Serializable {

	private String fonCod;
	private String fonTyfCod;
	private Date fonDatDeb;
	private Date fonDatFin;
	private String fonLibelle;
	private String assOpeMatricule;

	public VFonctionAssignationId() {
	}

	public VFonctionAssignationId(String fonCod) {
		this.fonCod = fonCod;
	}

	public VFonctionAssignationId(String fonCod, String fonTyfCod, Date fonDatDeb, Date fonDatFin, String fonLibelle,
			String assOpeMatricule) {
		this.fonCod = fonCod;
		this.fonTyfCod = fonTyfCod;
		this.fonDatDeb = fonDatDeb;
		this.fonDatFin = fonDatFin;
		this.fonLibelle = fonLibelle;
		this.assOpeMatricule = assOpeMatricule;
	}

	@Column(name = "FON_COD", nullable = false, length = 20)
	public String getFonCod() {
		return this.fonCod;
	}

	public void setFonCod(String fonCod) {
		this.fonCod = fonCod;
	}

	@Column(name = "FON_TYF_COD", length = 3)
	public String getFonTyfCod() {
		return this.fonTyfCod;
	}

	public void setFonTyfCod(String fonTyfCod) {
		this.fonTyfCod = fonTyfCod;
	}

	@Column(name = "FON_DAT_DEB", length = 7)
	public Date getFonDatDeb() {
		return this.fonDatDeb;
	}

	public void setFonDatDeb(Date fonDatDeb) {
		this.fonDatDeb = fonDatDeb;
	}

	@Column(name = "FON_DAT_FIN", length = 7)
	public Date getFonDatFin() {
		return this.fonDatFin;
	}

	public void setFonDatFin(Date fonDatFin) {
		this.fonDatFin = fonDatFin;
	}

	@Column(name = "FON_LIBELLE", length = 500)
	public String getFonLibelle() {
		return this.fonLibelle;
	}

	public void setFonLibelle(String fonLibelle) {
		this.fonLibelle = fonLibelle;
	}

	@Column(name = "ASS_OPE_MATRICULE", length = 25)
	public String getAssOpeMatricule() {
		return this.assOpeMatricule;
	}

	public void setAssOpeMatricule(String assOpeMatricule) {
		this.assOpeMatricule = assOpeMatricule;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VFonctionAssignationId))
			return false;
		VFonctionAssignationId castOther = (VFonctionAssignationId) other;

		return ((this.getFonCod() == castOther.getFonCod()) || (this.getFonCod() != null
				&& castOther.getFonCod() != null && this.getFonCod().equals(castOther.getFonCod())))
				&& ((this.getFonTyfCod() == castOther.getFonTyfCod()) || (this.getFonTyfCod() != null
						&& castOther.getFonTyfCod() != null && this.getFonTyfCod().equals(castOther.getFonTyfCod())))
				&& ((this.getFonDatDeb() == castOther.getFonDatDeb()) || (this.getFonDatDeb() != null
						&& castOther.getFonDatDeb() != null && this.getFonDatDeb().equals(castOther.getFonDatDeb())))
				&& ((this.getFonDatFin() == castOther.getFonDatFin()) || (this.getFonDatFin() != null
						&& castOther.getFonDatFin() != null && this.getFonDatFin().equals(castOther.getFonDatFin())))
				&& ((this.getFonLibelle() == castOther.getFonLibelle()) || (this.getFonLibelle() != null
						&& castOther.getFonLibelle() != null && this.getFonLibelle().equals(castOther.getFonLibelle())))
				&& ((this.getAssOpeMatricule() == castOther.getAssOpeMatricule())
						|| (this.getAssOpeMatricule() != null && castOther.getAssOpeMatricule() != null
								&& this.getAssOpeMatricule().equals(castOther.getAssOpeMatricule())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getFonCod() == null ? 0 : this.getFonCod().hashCode());
		result = 37 * result + (getFonTyfCod() == null ? 0 : this.getFonTyfCod().hashCode());
		result = 37 * result + (getFonDatDeb() == null ? 0 : this.getFonDatDeb().hashCode());
		result = 37 * result + (getFonDatFin() == null ? 0 : this.getFonDatFin().hashCode());
		result = 37 * result + (getFonLibelle() == null ? 0 : this.getFonLibelle().hashCode());
		result = 37 * result + (getAssOpeMatricule() == null ? 0 : this.getAssOpeMatricule().hashCode());
		return result;
	}

}
