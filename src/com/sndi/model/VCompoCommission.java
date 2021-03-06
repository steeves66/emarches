package com.sndi.model;
// Generated 8 avr. 2020 14:38:40 by Hibernate Tools 4.3.5.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

/**
 * VCompoCommission generated by hbm2java
 */
@Entity
@Immutable
@Table(name = "V_COMPO_COMMISSION")
public class VCompoCommission implements java.io.Serializable {

	private String strCode;
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

	public VCompoCommission() {
	}

	public VCompoCommission(String strCode, String tctCode) {
		this.strCode = strCode;
		this.tctCode = tctCode;
	}

	public VCompoCommission(String strCode, String tctCode, String tctLibelle, String tctTitre, String tctTstCode,
			String tctTcoCode, Date tctDteSaisi, String tctOpeMatricule, String tctGrpCode, String tctNomMbm,
			String tctPreMbm, String tctTelMbm, String tctRepMandate) {
		this.strCode = strCode;
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
	}

	
	@Id
	@Column(name = "TCT_CODE", nullable = false, length = 3)
	public String getTctCode() {
		return this.tctCode;
	}

	public void setTctCode(String tctCode) {
		this.tctCode = tctCode;
	}	
	
	@Column(name = "STR_CODE", nullable = false, length = 20)
	public String getStrCode() {
		return this.strCode;
	}

	public void setStrCode(String strCode) {
		this.strCode = strCode;
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

}
