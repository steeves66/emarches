package com.sndi.models;
// Generated 19 mars 2020 18:39:08 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * TDetailAdresseAvis generated by hbm2java
 */
@Entity
@Table(name = "T_DETAIL_ADRESSE_AVIS", schema = "EMAP")
public class TDetailAdresseAvis implements java.io.Serializable {

	private BigDecimal dtaNum;
	private TLibelleAdresse TLibelleAdresse;
	private TAdresseAvis TAdresseAvis;
	private String dtaTitre;
	private String dtaLibelle;
	private Date dtaDteSaisi;

	public TDetailAdresseAvis() {
	}

	public TDetailAdresseAvis(BigDecimal dtaNum) {
		this.dtaNum = dtaNum;
	}

	public TDetailAdresseAvis(BigDecimal dtaNum, TLibelleAdresse TLibelleAdresse, TAdresseAvis TAdresseAvis,
			String dtaTitre, String dtaLibelle, Date dtaDteSaisi) {
		this.dtaNum = dtaNum;
		this.TLibelleAdresse = TLibelleAdresse;
		this.TAdresseAvis = TAdresseAvis;
		this.dtaTitre = dtaTitre;
		this.dtaLibelle = dtaLibelle;
		this.dtaDteSaisi = dtaDteSaisi;
	}

	@Id

	@Column(name = "DTA_NUM", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getDtaNum() {
		return this.dtaNum;
	}

	public void setDtaNum(BigDecimal dtaNum) {
		this.dtaNum = dtaNum;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DTA_LIA_NUM")
	public TLibelleAdresse getTLibelleAdresse() {
		return this.TLibelleAdresse;
	}

	public void setTLibelleAdresse(TLibelleAdresse TLibelleAdresse) {
		this.TLibelleAdresse = TLibelleAdresse;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DTA_ADA_NUM")
	public TAdresseAvis getTAdresseAvis() {
		return this.TAdresseAvis;
	}

	public void setTAdresseAvis(TAdresseAvis TAdresseAvis) {
		this.TAdresseAvis = TAdresseAvis;
	}

	@Column(name = "DTA_TITRE", length = 200)
	public String getDtaTitre() {
		return this.dtaTitre;
	}

	public void setDtaTitre(String dtaTitre) {
		this.dtaTitre = dtaTitre;
	}

	@Column(name = "DTA_LIBELLE", length = 500)
	public String getDtaLibelle() {
		return this.dtaLibelle;
	}

	public void setDtaLibelle(String dtaLibelle) {
		this.dtaLibelle = dtaLibelle;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DTA_DTE_SAISI", length = 7)
	public Date getDtaDteSaisi() {
		return this.dtaDteSaisi;
	}

	public void setDtaDteSaisi(Date dtaDteSaisi) {
		this.dtaDteSaisi = dtaDteSaisi;
	}

}
