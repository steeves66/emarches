package com.sndi.models;
// Generated 28 mars 2020 15:50:26 by Hibernate Tools 4.3.5.Final

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
	private String fonStrCode;
	private Date fonDatDeb;
	private Date fonDatFin;
	private String fonLibelle;
	private String fonOpeMatricule;

	public VFonctionAssignationId() {
	}

	public VFonctionAssignationId(String fonCod) {
		this.fonCod = fonCod;
	}

	public VFonctionAssignationId(String fonCod, String fonTyfCod, String fonStrCode, Date fonDatDeb, Date fonDatFin,
			String fonLibelle, String fonOpeMatricule) {
		this.fonCod = fonCod;
		this.fonTyfCod = fonTyfCod;
		this.fonStrCode = fonStrCode;
		this.fonDatDeb = fonDatDeb;
		this.fonDatFin = fonDatFin;
		this.fonLibelle = fonLibelle;
		this.fonOpeMatricule = fonOpeMatricule;
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

	@Column(name = "FON_STR_CODE", length = 20)
	public String getFonStrCode() {
		return this.fonStrCode;
	}

	public void setFonStrCode(String fonStrCode) {
		this.fonStrCode = fonStrCode;
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

	@Column(name = "FON_OPE_MATRICULE", length = 25)
	public String getFonOpeMatricule() {
		return this.fonOpeMatricule;
	}

	public void setFonOpeMatricule(String fonOpeMatricule) {
		this.fonOpeMatricule = fonOpeMatricule;
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
				&& ((this.getFonStrCode() == castOther.getFonStrCode()) || (this.getFonStrCode() != null
						&& castOther.getFonStrCode() != null && this.getFonStrCode().equals(castOther.getFonStrCode())))
				&& ((this.getFonDatDeb() == castOther.getFonDatDeb()) || (this.getFonDatDeb() != null
						&& castOther.getFonDatDeb() != null && this.getFonDatDeb().equals(castOther.getFonDatDeb())))
				&& ((this.getFonDatFin() == castOther.getFonDatFin()) || (this.getFonDatFin() != null
						&& castOther.getFonDatFin() != null && this.getFonDatFin().equals(castOther.getFonDatFin())))
				&& ((this.getFonLibelle() == castOther.getFonLibelle()) || (this.getFonLibelle() != null
						&& castOther.getFonLibelle() != null && this.getFonLibelle().equals(castOther.getFonLibelle())))
				&& ((this.getFonOpeMatricule() == castOther.getFonOpeMatricule())
						|| (this.getFonOpeMatricule() != null && castOther.getFonOpeMatricule() != null
								&& this.getFonOpeMatricule().equals(castOther.getFonOpeMatricule())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getFonCod() == null ? 0 : this.getFonCod().hashCode());
		result = 37 * result + (getFonTyfCod() == null ? 0 : this.getFonTyfCod().hashCode());
		result = 37 * result + (getFonStrCode() == null ? 0 : this.getFonStrCode().hashCode());
		result = 37 * result + (getFonDatDeb() == null ? 0 : this.getFonDatDeb().hashCode());
		result = 37 * result + (getFonDatFin() == null ? 0 : this.getFonDatFin().hashCode());
		result = 37 * result + (getFonLibelle() == null ? 0 : this.getFonLibelle().hashCode());
		result = 37 * result + (getFonOpeMatricule() == null ? 0 : this.getFonOpeMatricule().hashCode());
		return result;
	}

}
