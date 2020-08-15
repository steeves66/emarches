package com.sndi.model;
// Generated 15 ao�t 2020 13:52:19 by Hibernate Tools 4.3.5.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

/**
 * VbTempParamDetCriId generated by hbm2java
 */
@Entity
@Immutable
@Table(name = "VB_TEMP_PARAM_DET_CRI")
public class VbTempParamDetCri implements java.io.Serializable {

	private String criDacCode;
	private String criDcadDanCode;
	private String criDcadLaaId;
	private Date criDteSaisi;
	private String criLibelle;
	private String criOpeMatricule;
	private String criDcadStatut;
	private String tempType;

	public VbTempParamDetCri() {
	}

	public VbTempParamDetCri(String criDacCode, String criDcadDanCode, String criDcadLaaId, Date criDteSaisi,
			String criLibelle, String criOpeMatricule, String criDcadStatut, String tempType) {
		this.criDacCode = criDacCode;
		this.criDcadDanCode = criDcadDanCode;
		this.criDcadLaaId = criDcadLaaId;
		this.criDteSaisi = criDteSaisi;
		this.criLibelle = criLibelle;
		this.criOpeMatricule = criOpeMatricule;
		this.criDcadStatut = criDcadStatut;
		this.tempType = tempType;
	}

	@Id
	@Column(name = "CRI_DAC_CODE", length = 500)
	public String getCriDacCode() {
		return this.criDacCode;
	}

	public void setCriDacCode(String criDacCode) {
		this.criDacCode = criDacCode;
	}

	@Column(name = "CRI_DCAD_DAN_CODE", length = 500)
	public String getCriDcadDanCode() {
		return this.criDcadDanCode;
	}

	public void setCriDcadDanCode(String criDcadDanCode) {
		this.criDcadDanCode = criDcadDanCode;
	}

	@Column(name = "CRI_DCAD_LAA_ID", length = 500)
	public String getCriDcadLaaId() {
		return this.criDcadLaaId;
	}

	public void setCriDcadLaaId(String criDcadLaaId) {
		this.criDcadLaaId = criDcadLaaId;
	}

	@Column(name = "CRI_DTE_SAISI", length = 7)
	public Date getCriDteSaisi() {
		return this.criDteSaisi;
	}

	public void setCriDteSaisi(Date criDteSaisi) {
		this.criDteSaisi = criDteSaisi;
	}

	@Column(name = "CRI_LIBELLE", length = 500)
	public String getCriLibelle() {
		return this.criLibelle;
	}

	public void setCriLibelle(String criLibelle) {
		this.criLibelle = criLibelle;
	}

	@Column(name = "CRI_OPE_MATRICULE", length = 500)
	public String getCriOpeMatricule() {
		return this.criOpeMatricule;
	}

	public void setCriOpeMatricule(String criOpeMatricule) {
		this.criOpeMatricule = criOpeMatricule;
	}

	@Column(name = "CRI_DCAD_STATUT", length = 500)
	public String getCriDcadStatut() {
		return this.criDcadStatut;
	}

	public void setCriDcadStatut(String criDcadStatut) {
		this.criDcadStatut = criDcadStatut;
	}

	@Column(name = "TEMP_TYPE", length = 500)
	public String getTempType() {
		return this.tempType;
	}

	public void setTempType(String tempType) {
		this.tempType = tempType;
	}
}
