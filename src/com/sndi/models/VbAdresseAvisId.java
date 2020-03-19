package com.sndi.models;
// Generated 19 mars 2020 18:39:08 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VbAdresseAvisId generated by hbm2java
 */
@Embeddable
public class VbAdresseAvisId implements java.io.Serializable {

	private BigDecimal adaNum;
	private String adaLibelle;
	private String adaFonCod;

	public VbAdresseAvisId() {
	}

	public VbAdresseAvisId(BigDecimal adaNum) {
		this.adaNum = adaNum;
	}

	public VbAdresseAvisId(BigDecimal adaNum, String adaLibelle, String adaFonCod) {
		this.adaNum = adaNum;
		this.adaLibelle = adaLibelle;
		this.adaFonCod = adaFonCod;
	}

	@Column(name = "ADA_NUM", nullable = false, precision = 22, scale = 0)
	public BigDecimal getAdaNum() {
		return this.adaNum;
	}

	public void setAdaNum(BigDecimal adaNum) {
		this.adaNum = adaNum;
	}

	@Column(name = "ADA_LIBELLE", length = 500)
	public String getAdaLibelle() {
		return this.adaLibelle;
	}

	public void setAdaLibelle(String adaLibelle) {
		this.adaLibelle = adaLibelle;
	}

	@Column(name = "ADA_FON_COD", length = 12)
	public String getAdaFonCod() {
		return this.adaFonCod;
	}

	public void setAdaFonCod(String adaFonCod) {
		this.adaFonCod = adaFonCod;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VbAdresseAvisId))
			return false;
		VbAdresseAvisId castOther = (VbAdresseAvisId) other;

		return ((this.getAdaNum() == castOther.getAdaNum()) || (this.getAdaNum() != null
				&& castOther.getAdaNum() != null && this.getAdaNum().equals(castOther.getAdaNum())))
				&& ((this.getAdaLibelle() == castOther.getAdaLibelle()) || (this.getAdaLibelle() != null
						&& castOther.getAdaLibelle() != null && this.getAdaLibelle().equals(castOther.getAdaLibelle())))
				&& ((this.getAdaFonCod() == castOther.getAdaFonCod()) || (this.getAdaFonCod() != null
						&& castOther.getAdaFonCod() != null && this.getAdaFonCod().equals(castOther.getAdaFonCod())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getAdaNum() == null ? 0 : this.getAdaNum().hashCode());
		result = 37 * result + (getAdaLibelle() == null ? 0 : this.getAdaLibelle().hashCode());
		result = 37 * result + (getAdaFonCod() == null ? 0 : this.getAdaFonCod().hashCode());
		return result;
	}

}
