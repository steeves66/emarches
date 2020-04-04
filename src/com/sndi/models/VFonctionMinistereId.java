package com.sndi.models;
// Generated 4 avr. 2020 18:03:14 by Hibernate Tools 4.3.5.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VFonctionMinistereId generated by hbm2java
 */
@Embeddable
public class VFonctionMinistereId implements java.io.Serializable {

	private String fonCod;
	private String fonStrCode;
	private String fonLibelle;
	private Date fonDatDeb;
	private Date fonDatFin;
	private String fonTel;
	private String fonTyfCod;
	private String tyfLibelle;
	private String minLibelle;
	private String strLibelleLong;

	public VFonctionMinistereId() {
	}

	public VFonctionMinistereId(String fonCod) {
		this.fonCod = fonCod;
	}

	public VFonctionMinistereId(String fonCod, String fonStrCode, String fonLibelle, Date fonDatDeb, Date fonDatFin,
			String fonTel, String fonTyfCod, String tyfLibelle, String minLibelle, String strLibelleLong) {
		this.fonCod = fonCod;
		this.fonStrCode = fonStrCode;
		this.fonLibelle = fonLibelle;
		this.fonDatDeb = fonDatDeb;
		this.fonDatFin = fonDatFin;
		this.fonTel = fonTel;
		this.fonTyfCod = fonTyfCod;
		this.tyfLibelle = tyfLibelle;
		this.minLibelle = minLibelle;
		this.strLibelleLong = strLibelleLong;
	}

	@Column(name = "FON_COD", nullable = false, length = 20)
	public String getFonCod() {
		return this.fonCod;
	}

	public void setFonCod(String fonCod) {
		this.fonCod = fonCod;
	}

	@Column(name = "FON_STR_CODE", length = 20)
	public String getFonStrCode() {
		return this.fonStrCode;
	}

	public void setFonStrCode(String fonStrCode) {
		this.fonStrCode = fonStrCode;
	}

	@Column(name = "FON_LIBELLE", length = 500)
	public String getFonLibelle() {
		return this.fonLibelle;
	}

	public void setFonLibelle(String fonLibelle) {
		this.fonLibelle = fonLibelle;
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

	@Column(name = "FON_TEL", length = 240)
	public String getFonTel() {
		return this.fonTel;
	}

	public void setFonTel(String fonTel) {
		this.fonTel = fonTel;
	}

	@Column(name = "FON_TYF_COD", length = 3)
	public String getFonTyfCod() {
		return this.fonTyfCod;
	}

	public void setFonTyfCod(String fonTyfCod) {
		this.fonTyfCod = fonTyfCod;
	}

	@Column(name = "TYF_LIBELLE", length = 300)
	public String getTyfLibelle() {
		return this.tyfLibelle;
	}

	public void setTyfLibelle(String tyfLibelle) {
		this.tyfLibelle = tyfLibelle;
	}

	@Column(name = "MIN_LIBELLE", length = 1000)
	public String getMinLibelle() {
		return this.minLibelle;
	}

	public void setMinLibelle(String minLibelle) {
		this.minLibelle = minLibelle;
	}

	@Column(name = "STR_LIBELLE_LONG", length = 1000)
	public String getStrLibelleLong() {
		return this.strLibelleLong;
	}

	public void setStrLibelleLong(String strLibelleLong) {
		this.strLibelleLong = strLibelleLong;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VFonctionMinistereId))
			return false;
		VFonctionMinistereId castOther = (VFonctionMinistereId) other;

		return ((this.getFonCod() == castOther.getFonCod()) || (this.getFonCod() != null
				&& castOther.getFonCod() != null && this.getFonCod().equals(castOther.getFonCod())))
				&& ((this.getFonStrCode() == castOther.getFonStrCode()) || (this.getFonStrCode() != null
						&& castOther.getFonStrCode() != null && this.getFonStrCode().equals(castOther.getFonStrCode())))
				&& ((this.getFonLibelle() == castOther.getFonLibelle()) || (this.getFonLibelle() != null
						&& castOther.getFonLibelle() != null && this.getFonLibelle().equals(castOther.getFonLibelle())))
				&& ((this.getFonDatDeb() == castOther.getFonDatDeb()) || (this.getFonDatDeb() != null
						&& castOther.getFonDatDeb() != null && this.getFonDatDeb().equals(castOther.getFonDatDeb())))
				&& ((this.getFonDatFin() == castOther.getFonDatFin()) || (this.getFonDatFin() != null
						&& castOther.getFonDatFin() != null && this.getFonDatFin().equals(castOther.getFonDatFin())))
				&& ((this.getFonTel() == castOther.getFonTel()) || (this.getFonTel() != null
						&& castOther.getFonTel() != null && this.getFonTel().equals(castOther.getFonTel())))
				&& ((this.getFonTyfCod() == castOther.getFonTyfCod()) || (this.getFonTyfCod() != null
						&& castOther.getFonTyfCod() != null && this.getFonTyfCod().equals(castOther.getFonTyfCod())))
				&& ((this.getTyfLibelle() == castOther.getTyfLibelle()) || (this.getTyfLibelle() != null
						&& castOther.getTyfLibelle() != null && this.getTyfLibelle().equals(castOther.getTyfLibelle())))
				&& ((this.getMinLibelle() == castOther.getMinLibelle()) || (this.getMinLibelle() != null
						&& castOther.getMinLibelle() != null && this.getMinLibelle().equals(castOther.getMinLibelle())))
				&& ((this.getStrLibelleLong() == castOther.getStrLibelleLong())
						|| (this.getStrLibelleLong() != null && castOther.getStrLibelleLong() != null
								&& this.getStrLibelleLong().equals(castOther.getStrLibelleLong())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getFonCod() == null ? 0 : this.getFonCod().hashCode());
		result = 37 * result + (getFonStrCode() == null ? 0 : this.getFonStrCode().hashCode());
		result = 37 * result + (getFonLibelle() == null ? 0 : this.getFonLibelle().hashCode());
		result = 37 * result + (getFonDatDeb() == null ? 0 : this.getFonDatDeb().hashCode());
		result = 37 * result + (getFonDatFin() == null ? 0 : this.getFonDatFin().hashCode());
		result = 37 * result + (getFonTel() == null ? 0 : this.getFonTel().hashCode());
		result = 37 * result + (getFonTyfCod() == null ? 0 : this.getFonTyfCod().hashCode());
		result = 37 * result + (getTyfLibelle() == null ? 0 : this.getTyfLibelle().hashCode());
		result = 37 * result + (getMinLibelle() == null ? 0 : this.getMinLibelle().hashCode());
		result = 37 * result + (getStrLibelleLong() == null ? 0 : this.getStrLibelleLong().hashCode());
		return result;
	}

}
