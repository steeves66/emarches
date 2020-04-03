package com.sndi.models;
// Generated 3 avr. 2020 00:55:57 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VDetailAdresseId generated by hbm2java
 */
@Embeddable
public class VDetailAdresseId implements java.io.Serializable {

	private BigDecimal VId;
	private String adaFonCod;
	private BigDecimal adaNum;
	private String liaLibelle;
	private String dtaLibelle;

	public VDetailAdresseId() {
	}

	public VDetailAdresseId(BigDecimal adaNum) {
		this.adaNum = adaNum;
	}

	public VDetailAdresseId(BigDecimal VId, String adaFonCod, BigDecimal adaNum, String liaLibelle, String dtaLibelle) {
		this.VId = VId;
		this.adaFonCod = adaFonCod;
		this.adaNum = adaNum;
		this.liaLibelle = liaLibelle;
		this.dtaLibelle = dtaLibelle;
	}

	@Column(name = "V_ID", precision = 22, scale = 0)
	public BigDecimal getVId() {
		return this.VId;
	}

	public void setVId(BigDecimal VId) {
		this.VId = VId;
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
		if (!(other instanceof VDetailAdresseId))
			return false;
		VDetailAdresseId castOther = (VDetailAdresseId) other;

		return ((this.getVId() == castOther.getVId())
				|| (this.getVId() != null && castOther.getVId() != null && this.getVId().equals(castOther.getVId())))
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

		result = 37 * result + (getVId() == null ? 0 : this.getVId().hashCode());
		result = 37 * result + (getAdaFonCod() == null ? 0 : this.getAdaFonCod().hashCode());
		result = 37 * result + (getAdaNum() == null ? 0 : this.getAdaNum().hashCode());
		result = 37 * result + (getLiaLibelle() == null ? 0 : this.getLiaLibelle().hashCode());
		result = 37 * result + (getDtaLibelle() == null ? 0 : this.getDtaLibelle().hashCode());
		return result;
	}

}
