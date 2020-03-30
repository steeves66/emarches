package com.sndi.models;
// Generated 30 mars 2020 01:35:59 by Hibernate Tools 4.3.5.Final

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
 * TTiers generated by hbm2java
 */
@Entity
@Table(name = "T_TIERS", schema = "EMAP")
public class TTiers implements java.io.Serializable {

	private String tieNum;
	private TOperateur TOperateur;
	private String tieInter;
	private String tieSigleSte;
	private String tieNomCom;
	private String tieStaCode;
	private String tieTel;
	private String tieAdresse;
	private Date tieDteSaisi;
	private String tieNcc;

	public TTiers() {
	}

	public TTiers(String tieNum) {
		this.tieNum = tieNum;
	}

	public TTiers(String tieNum, TOperateur TOperateur, String tieInter, String tieSigleSte, String tieNomCom,
			String tieStaCode, String tieTel, String tieAdresse, Date tieDteSaisi, String tieNcc) {
		this.tieNum = tieNum;
		this.TOperateur = TOperateur;
		this.tieInter = tieInter;
		this.tieSigleSte = tieSigleSte;
		this.tieNomCom = tieNomCom;
		this.tieStaCode = tieStaCode;
		this.tieTel = tieTel;
		this.tieAdresse = tieAdresse;
		this.tieDteSaisi = tieDteSaisi;
		this.tieNcc = tieNcc;
	}

	@Id

	@Column(name = "TIE_NUM", unique = true, nullable = false, length = 20)
	public String getTieNum() {
		return this.tieNum;
	}

	public void setTieNum(String tieNum) {
		this.tieNum = tieNum;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TIE_OPE_MATRICULE")
	public TOperateur getTOperateur() {
		return this.TOperateur;
	}

	public void setTOperateur(TOperateur TOperateur) {
		this.TOperateur = TOperateur;
	}

	@Column(name = "TIE_INTER", length = 1)
	public String getTieInter() {
		return this.tieInter;
	}

	public void setTieInter(String tieInter) {
		this.tieInter = tieInter;
	}

	@Column(name = "TIE_SIGLE_STE", length = 500)
	public String getTieSigleSte() {
		return this.tieSigleSte;
	}

	public void setTieSigleSte(String tieSigleSte) {
		this.tieSigleSte = tieSigleSte;
	}

	@Column(name = "TIE_NOM_COM", length = 500)
	public String getTieNomCom() {
		return this.tieNomCom;
	}

	public void setTieNomCom(String tieNomCom) {
		this.tieNomCom = tieNomCom;
	}

	@Column(name = "TIE_STA_CODE", length = 3)
	public String getTieStaCode() {
		return this.tieStaCode;
	}

	public void setTieStaCode(String tieStaCode) {
		this.tieStaCode = tieStaCode;
	}

	@Column(name = "TIE_TEL", length = 30)
	public String getTieTel() {
		return this.tieTel;
	}

	public void setTieTel(String tieTel) {
		this.tieTel = tieTel;
	}

	@Column(name = "TIE_ADRESSE", length = 200)
	public String getTieAdresse() {
		return this.tieAdresse;
	}

	public void setTieAdresse(String tieAdresse) {
		this.tieAdresse = tieAdresse;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "TIE_DTE_SAISI", length = 7)
	public Date getTieDteSaisi() {
		return this.tieDteSaisi;
	}

	public void setTieDteSaisi(Date tieDteSaisi) {
		this.tieDteSaisi = tieDteSaisi;
	}

	@Column(name = "TIE_NCC", length = 15)
	public String getTieNcc() {
		return this.tieNcc;
	}

	public void setTieNcc(String tieNcc) {
		this.tieNcc = tieNcc;
	}

}
