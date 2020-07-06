package com.sndi.model;
// Generated 18 juin 2020 17:55:39 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "V_DAC_MEMBRE")
public class VDacMembre implements java.io.Serializable {

	private String tctCode;
	private String tctLibelle;
	private String tctTitre;
	private String tctTstCode;
	private String tctTcoCode;
	private Date tctDteSaisi;
	private String tctOpeMatricule;
	private String tctGrpCode;
	private String tctNomMbm;
	private String tctPreMbm;
	private String tctTelMbm;
	private String tctRepMandate;
	private BigDecimal comNum;
	private Date comDteSaisi;
	private String comStrCode;
	private String comTctCode;
	private String comOpeMatricule;
	private String comDacCode;
	private String comMarCode;
	private String comAaoCode;
	private String comTcoCode;
	private String comStrCom;
	private String comFonAdmin;

	public VDacMembre() {
	}

	public VDacMembre(String tctCode) {
		this.tctCode = tctCode;
	}

	public VDacMembre(String tctCode, String tctLibelle, String tctTitre, String tctTstCode, String tctTcoCode,
			Date tctDteSaisi, String tctOpeMatricule, String tctGrpCode, String tctNomMbm, String tctPreMbm,
			String tctTelMbm, String tctRepMandate, BigDecimal comNum, Date comDteSaisi, String comStrCode,
			String comTctCode, String comOpeMatricule, String comDacCode, String comMarCode, String comAaoCode,
			String comTcoCode,String comStrCom, String comFonAdmin) {
		this.tctCode = tctCode;
		this.tctLibelle = tctLibelle;
		this.tctTitre = tctTitre;
		this.tctTstCode = tctTstCode;
		this.tctTcoCode = tctTcoCode;
		this.tctDteSaisi = tctDteSaisi;
		this.tctOpeMatricule = tctOpeMatricule;
		this.tctGrpCode = tctGrpCode;
		this.tctNomMbm = tctNomMbm;
		this.tctPreMbm = tctPreMbm;
		this.tctTelMbm = tctTelMbm;
		this.tctRepMandate = tctRepMandate;
		this.comNum = comNum;
		this.comDteSaisi = comDteSaisi;
		this.comStrCode = comStrCode;
		this.comTctCode = comTctCode;
		this.comOpeMatricule = comOpeMatricule;
		this.comDacCode = comDacCode;
		this.comMarCode = comMarCode;
		this.comAaoCode = comAaoCode;
		this.comTcoCode = comTcoCode;
		this.comStrCom = comStrCom;
		this.comFonAdmin = comFonAdmin;
	}

	@Id
	@Column(name = "TCT_CODE", nullable = false, length = 3)
	public String getTctCode() {
		return this.tctCode;
	}

	public void setTctCode(String tctCode) {
		this.tctCode = tctCode;
	}

	@Column(name = "TCT_LIBELLE", length = 500)
	public String getTctLibelle() {
		return this.tctLibelle;
	}

	public void setTctLibelle(String tctLibelle) {
		this.tctLibelle = tctLibelle;
	}

	@Column(name = "TCT_TITRE", length = 200)
	public String getTctTitre() {
		return this.tctTitre;
	}

	public void setTctTitre(String tctTitre) {
		this.tctTitre = tctTitre;
	}

	@Column(name = "TCT_TST_CODE", length = 3)
	public String getTctTstCode() {
		return this.tctTstCode;
	}

	public void setTctTstCode(String tctTstCode) {
		this.tctTstCode = tctTstCode;
	}

	@Column(name = "TCT_TCO_CODE", length = 3)
	public String getTctTcoCode() {
		return this.tctTcoCode;
	}

	public void setTctTcoCode(String tctTcoCode) {
		this.tctTcoCode = tctTcoCode;
	}

	@Column(name = "TCT_DTE_SAISI", length = 7)
	public Date getTctDteSaisi() {
		return this.tctDteSaisi;
	}

	public void setTctDteSaisi(Date tctDteSaisi) {
		this.tctDteSaisi = tctDteSaisi;
	}

	@Column(name = "TCT_OPE_MATRICULE", length = 20)
	public String getTctOpeMatricule() {
		return this.tctOpeMatricule;
	}

	public void setTctOpeMatricule(String tctOpeMatricule) {
		this.tctOpeMatricule = tctOpeMatricule;
	}

	@Column(name = "TCT_GRP_CODE", length = 20)
	public String getTctGrpCode() {
		return this.tctGrpCode;
	}

	public void setTctGrpCode(String tctGrpCode) {
		this.tctGrpCode = tctGrpCode;
	}

	@Column(name = "TCT_NOM_MBM", length = 100)
	public String getTctNomMbm() {
		return this.tctNomMbm;
	}

	public void setTctNomMbm(String tctNomMbm) {
		this.tctNomMbm = tctNomMbm;
	}

	@Column(name = "TCT_PRE_MBM", length = 200)
	public String getTctPreMbm() {
		return this.tctPreMbm;
	}

	public void setTctPreMbm(String tctPreMbm) {
		this.tctPreMbm = tctPreMbm;
	}

	@Column(name = "TCT_TEL_MBM", length = 20)
	public String getTctTelMbm() {
		return this.tctTelMbm;
	}

	public void setTctTelMbm(String tctTelMbm) {
		this.tctTelMbm = tctTelMbm;
	}

	@Column(name = "TCT_REP_MANDATE", length = 1)
	public String getTctRepMandate() {
		return this.tctRepMandate;
	}

	public void setTctRepMandate(String tctRepMandate) {
		this.tctRepMandate = tctRepMandate;
	}

	@Column(name = "COM_NUM", precision = 22, scale = 0)
	public BigDecimal getComNum() {
		return this.comNum;
	}

	public void setComNum(BigDecimal comNum) {
		this.comNum = comNum;
	}

	@Column(name = "COM_DTE_SAISI", length = 7)
	public Date getComDteSaisi() {
		return this.comDteSaisi;
	}

	public void setComDteSaisi(Date comDteSaisi) {
		this.comDteSaisi = comDteSaisi;
	}

	@Column(name = "COM_STR_CODE", length = 20)
	public String getComStrCode() {
		return this.comStrCode;
	}

	public void setComStrCode(String comStrCode) {
		this.comStrCode = comStrCode;
	}

	@Column(name = "COM_TCT_CODE", length = 3)
	public String getComTctCode() {
		return this.comTctCode;
	}

	public void setComTctCode(String comTctCode) {
		this.comTctCode = comTctCode;
	}

	@Column(name = "COM_OPE_MATRICULE", length = 20)
	public String getComOpeMatricule() {
		return this.comOpeMatricule;
	}

	public void setComOpeMatricule(String comOpeMatricule) {
		this.comOpeMatricule = comOpeMatricule;
	}

	@Column(name = "COM_DAC_CODE", length = 20)
	public String getComDacCode() {
		return this.comDacCode;
	}

	public void setComDacCode(String comDacCode) {
		this.comDacCode = comDacCode;
	}

	@Column(name = "COM_MAR_CODE", length = 20)
	public String getComMarCode() {
		return this.comMarCode;
	}

	public void setComMarCode(String comMarCode) {
		this.comMarCode = comMarCode;
	}

	@Column(name = "COM_AAO_CODE", length = 20)
	public String getComAaoCode() {
		return this.comAaoCode;
	}

	public void setComAaoCode(String comAaoCode) {
		this.comAaoCode = comAaoCode;
	}

	@Column(name = "COM_TCO_CODE", length = 3)
	public String getComTcoCode() {
		return this.comTcoCode;
	}

	public void setComTcoCode(String comTcoCode) {
		this.comTcoCode = comTcoCode;
	}
	
	

	@Column(name = "COM_STR_COM", length = 500)
	public String getComStrCom() {
		return this.comStrCom;
	}

	public void setComStrCom(String comStrCom) {
		this.comStrCom = comStrCom;
	}

	@Column(name = "COM_FON_ADMIN", length = 500)
	public String getComFonAdmin() {
		return this.comFonAdmin;
	}

	public void setComFonAdmin(String comFonAdmin) {
		this.comFonAdmin = comFonAdmin;
	}	

}
