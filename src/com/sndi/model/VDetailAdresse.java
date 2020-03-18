package com.sndi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "V_DETAIL_ADRESSE")
public class VDetailAdresse {
	private long vId;
	private String adaFonCod;
	private long adaNum;
	private String liaLibelle;
	private String dtaLibelle;
	
	public VDetailAdresse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VDetailAdresse(long vId, String adaFonCod, long adaNum, String liaLibelle, String dtaLibelle) {
		super();
		this.vId = vId;
		this.adaFonCod = adaFonCod;
		this.adaNum = adaNum;
		this.liaLibelle = liaLibelle;
		this.dtaLibelle = dtaLibelle;
	}

	@Id
	@Column(name = "V_ID")
	public long getvId() {
		return vId;
	}

	public void setvId(long vId) {
		this.vId = vId;
	}
	@Column(name = "ADA_FON_COD")
	public String getAdaFonCod() {
		return adaFonCod;
	}

	public void setAdaFonCod(String adaFonCod) {
		this.adaFonCod = adaFonCod;
	}

	@Column(name = "ADA_NUM")
	public long getAdaNum() {
		return adaNum;
	}

	public void setAdaNum(long adaNum) {
		this.adaNum = adaNum;
	}

	@Column(name = "LIA_LIBELLE")
	public String getLiaLibelle() {
		return liaLibelle;
	}

	public void setLiaLibelle(String liaLibelle) {
		this.liaLibelle = liaLibelle;
	}

	@Column(name = "DTA_LIBELLE")
	public String getDtaLibelle() {
		return dtaLibelle;
	}

	public void setDtaLibelle(String dtaLibelle) {
		this.dtaLibelle = dtaLibelle;
	}
	
}
