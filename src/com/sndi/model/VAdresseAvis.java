package com.sndi.model;
// Generated 21 f?vr. 2020 11:36:33 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

/**
 * VAdresseAvisId generated by hbm2java
 */
@Entity
@Immutable
@Table(name = "V_ADRESSE_AVIS")
public class VAdresseAvis implements java.io.Serializable {

	private BigDecimal VAd;
	private String dacCode;
	private String adaFonCod;
	private BigDecimal adaNum;
	private String liaLibelle;
	private String dtaLibelle;

	public VAdresseAvis() {
	}

	public VAdresseAvis(String dacCode, BigDecimal adaNum) {
		this.dacCode = dacCode;
		this.adaNum = adaNum;
	}

	public VAdresseAvis(BigDecimal VAd, String dacCode, String adaFonCod, BigDecimal adaNum, String liaLibelle,
			String dtaLibelle) {
		this.VAd = VAd;
		this.dacCode = dacCode;
		this.adaFonCod = adaFonCod;
		this.adaNum = adaNum;
		this.liaLibelle = liaLibelle;
		this.dtaLibelle = dtaLibelle;
	}

	
	@Id
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
}
