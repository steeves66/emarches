package com.sndi.models;
// Generated 14 mars 2020 14:41:40 by Hibernate Tools 4.3.5.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VbFonctionId generated by hbm2java
 */
@Embeddable
public class VbFonctionId implements java.io.Serializable {

	private String fonCod;
	private String fonTyfCod;
	private Date fonDatDeb;
	private Date fonDatFin;
	private String fonLibelle;
	private String fonAdr;
	private String fonTel;
	private String fonFonCod;
	private String fonCourriel;
	private String fonMobil;
	private String fonStrCode;

	public VbFonctionId() {
	}

	public VbFonctionId(String fonCod) {
		this.fonCod = fonCod;
	}

	public VbFonctionId(String fonCod, String fonTyfCod, Date fonDatDeb, Date fonDatFin, String fonLibelle,
			String fonAdr, String fonTel, String fonFonCod, String fonCourriel, String fonMobil, String fonStrCode) {
		this.fonCod = fonCod;
		this.fonTyfCod = fonTyfCod;
		this.fonDatDeb = fonDatDeb;
		this.fonDatFin = fonDatFin;
		this.fonLibelle = fonLibelle;
		this.fonAdr = fonAdr;
		this.fonTel = fonTel;
		this.fonFonCod = fonFonCod;
		this.fonCourriel = fonCourriel;
		this.fonMobil = fonMobil;
		this.fonStrCode = fonStrCode;
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

	@Column(name = "FON_ADR", length = 240)
	public String getFonAdr() {
		return this.fonAdr;
	}

	public void setFonAdr(String fonAdr) {
		this.fonAdr = fonAdr;
	}

	@Column(name = "FON_TEL", length = 240)
	public String getFonTel() {
		return this.fonTel;
	}

	public void setFonTel(String fonTel) {
		this.fonTel = fonTel;
	}

	@Column(name = "FON_FON_COD", length = 12)
	public String getFonFonCod() {
		return this.fonFonCod;
	}

	public void setFonFonCod(String fonFonCod) {
		this.fonFonCod = fonFonCod;
	}

	@Column(name = "FON_COURRIEL", length = 100)
	public String getFonCourriel() {
		return this.fonCourriel;
	}

	public void setFonCourriel(String fonCourriel) {
		this.fonCourriel = fonCourriel;
	}

	@Column(name = "FON_MOBIL", length = 20)
	public String getFonMobil() {
		return this.fonMobil;
	}

	public void setFonMobil(String fonMobil) {
		this.fonMobil = fonMobil;
	}

	@Column(name = "FON_STR_CODE", length = 20)
	public String getFonStrCode() {
		return this.fonStrCode;
	}

	public void setFonStrCode(String fonStrCode) {
		this.fonStrCode = fonStrCode;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VbFonctionId))
			return false;
		VbFonctionId castOther = (VbFonctionId) other;

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
				&& ((this.getFonAdr() == castOther.getFonAdr()) || (this.getFonAdr() != null
						&& castOther.getFonAdr() != null && this.getFonAdr().equals(castOther.getFonAdr())))
				&& ((this.getFonTel() == castOther.getFonTel()) || (this.getFonTel() != null
						&& castOther.getFonTel() != null && this.getFonTel().equals(castOther.getFonTel())))
				&& ((this.getFonFonCod() == castOther.getFonFonCod()) || (this.getFonFonCod() != null
						&& castOther.getFonFonCod() != null && this.getFonFonCod().equals(castOther.getFonFonCod())))
				&& ((this.getFonCourriel() == castOther.getFonCourriel())
						|| (this.getFonCourriel() != null && castOther.getFonCourriel() != null
								&& this.getFonCourriel().equals(castOther.getFonCourriel())))
				&& ((this.getFonMobil() == castOther.getFonMobil()) || (this.getFonMobil() != null
						&& castOther.getFonMobil() != null && this.getFonMobil().equals(castOther.getFonMobil())))
				&& ((this.getFonStrCode() == castOther.getFonStrCode())
						|| (this.getFonStrCode() != null && castOther.getFonStrCode() != null
								&& this.getFonStrCode().equals(castOther.getFonStrCode())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getFonCod() == null ? 0 : this.getFonCod().hashCode());
		result = 37 * result + (getFonTyfCod() == null ? 0 : this.getFonTyfCod().hashCode());
		result = 37 * result + (getFonDatDeb() == null ? 0 : this.getFonDatDeb().hashCode());
		result = 37 * result + (getFonDatFin() == null ? 0 : this.getFonDatFin().hashCode());
		result = 37 * result + (getFonLibelle() == null ? 0 : this.getFonLibelle().hashCode());
		result = 37 * result + (getFonAdr() == null ? 0 : this.getFonAdr().hashCode());
		result = 37 * result + (getFonTel() == null ? 0 : this.getFonTel().hashCode());
		result = 37 * result + (getFonFonCod() == null ? 0 : this.getFonFonCod().hashCode());
		result = 37 * result + (getFonCourriel() == null ? 0 : this.getFonCourriel().hashCode());
		result = 37 * result + (getFonMobil() == null ? 0 : this.getFonMobil().hashCode());
		result = 37 * result + (getFonStrCode() == null ? 0 : this.getFonStrCode().hashCode());
		return result;
	}

}
