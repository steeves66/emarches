package com.sndi.models;
// Generated 28 mars 2020 15:50:26 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VAdresseAvisId generated by hbm2java
 */
@Embeddable
public class VAdresseAvisId implements java.io.Serializable {

	private BigDecimal VAd;
	private String dacCode;
	private String adaFonCod;
	private BigDecimal adaNum;
	private String liaLibelle;
	private String dtaLibelle;

	public VAdresseAvisId() {
	}

	public VAdresseAvisId(String dacCode, BigDecimal adaNum) {
		this.dacCode = dacCode;
		this.adaNum = adaNum;
	}

	public VAdresseAvisId(BigDecimal VAd, String dacCode, String adaFonCod, BigDecimal adaNum, String liaLibelle,
			String dtaLibelle) {
		this.VAd = VAd;
		this.dacCode = dacCode;
		this.adaFonCod = adaFonCod;
		this.adaNum = adaNum;
		this.liaLibelle = liaLibelle;
		this.dtaLibelle = dtaLibelle;
	}

	@Column(name = "V_AD", precision = 22, scale = 0)
	public BigDecimal getVAd() {
		return this.VAd;
	}

	public void setVAd(BigDecimal VAd) {
		this.VAd = VAd;
	}

	@Column(name = "DAC_CODE", nullable = false, length = 20)
	public String getDacCode() {
		return this.dacCode;
	}

	public void setDacCode(String dacCode) {
		this.dacCode = dacCode;
	}

	@Column(name = "ADA_FON_COD", length = 12)
	public String getAdaFonCod() {
		return this.adaFonCod;
	}

	public void setAdaFonCod(String adaFonCod) {
		this.adaFonCod = adaFonCod;
	}

	@Column(name = "ADA_NUM", nullable = false, precision = 22, scale = 0)
	public BigDecimal getAdaNum() {
		return this.adaNum;
	}

	public void setAdaNum(BigDecimal adaNum) {
		this.adaNum = adaNum;
	}

	@Column(name = "LIA_LIBELLE", length = 500)
	public String getLiaLibelle() {
		return this.liaLibelle;
	}

	public void setLiaLibelle(String liaLibelle) {
		this.liaLibelle = liaLibelle;
	}

	@Column(name = "DTA_LIBELLE", length = 500)
	public String getDtaLibelle() {
		return this.dtaLibelle;
	}

	public void setDtaLibelle(String dtaLibelle) {
		this.dtaLibelle = dtaLibelle;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VAdresseAvisId))
			return false;
		VAdresseAvisId castOther = (VAdresseAvisId) other;

		return ((this.getVAd() == castOther.getVAd())
				|| (this.getVAd() != null && castOther.getVAd() != null && this.getVAd().equals(castOther.getVAd())))
				&& ((this.getDacCode() == castOther.getDacCode()) || (this.getDacCode() != null
						&& castOther.getDacCode() != null && this.getDacCode().equals(castOther.getDacCode())))
				&& ((this.getAdaFonCod() == castOther.getAdaFonCod()) || (this.getAdaFonCod() != null
						&& castOther.getAdaFonCod() != null && this.getAdaFonCod().equals(castOther.getAdaFonCod())))
				&& ((this.getAdaNum() == castOther.getAdaNum()) || (this.getAdaNum() != null
						&& castOther.getAdaNum() != null && this.getAdaNum().equals(castOther.getAdaNum())))
				&& ((this.getLiaLibelle() == castOther.getLiaLibelle()) || (this.getLiaLibelle() != null
						&& castOther.getLiaLibelle() != null && this.getLiaLibelle().equals(castOther.getLiaLibelle())))
				&& ((this.getDtaLibelle() == castOther.getDtaLibelle())
						|| (this.getDtaLibelle() != null && castOther.getDtaLibelle() != null
								&& this.getDtaLibelle().equals(castOther.getDtaLibelle())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getVAd() == null ? 0 : this.getVAd().hashCode());
		result = 37 * result + (getDacCode() == null ? 0 : this.getDacCode().hashCode());
		result = 37 * result + (getAdaFonCod() == null ? 0 : this.getAdaFonCod().hashCode());
		result = 37 * result + (getAdaNum() == null ? 0 : this.getAdaNum().hashCode());
		result = 37 * result + (getLiaLibelle() == null ? 0 : this.getLiaLibelle().hashCode());
		result = 37 * result + (getDtaLibelle() == null ? 0 : this.getDtaLibelle().hashCode());
		return result;
	}

}
