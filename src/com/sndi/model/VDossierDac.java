package com.sndi.model;
// Generated 27 juil. 2021 11:24:27 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

/**
 * VDossierDacId generated by hbm2java
 */
@Entity
@Immutable
@Table(name = "V_DOSSIER_DAC")
public class VDossierDac implements java.io.Serializable {

	private BigDecimal ddaId;
	private String ddaNom;
	private Date ddaDteSaisi;
	private String ddaStaCode;
	private String ddaDacCode;
	private BigDecimal ddaPidCode;
	private String ddaReference;
	private String ddaCommentaire;
	private String ddaNadCode;
	private String opeMatricule;
	private String ddaFonCod;
	private String nadLibelle;
	private String opeNom;

	public VDossierDac() {
	}

	public VDossierDac(BigDecimal ddaId) {
		this.ddaId = ddaId;
	}

	public VDossierDac(BigDecimal ddaId, String ddaNom, Date ddaDteSaisi, String ddaStaCode, String ddaDacCode,
			BigDecimal ddaPidCode, String ddaReference, String ddaCommentaire, String ddaNadCode, String opeMatricule,
			String ddaFonCod, String nadLibelle,String opeNom) {
		this.ddaId = ddaId;
		this.ddaNom = ddaNom;
		this.ddaDteSaisi = ddaDteSaisi;
		this.ddaStaCode = ddaStaCode;
		this.ddaDacCode = ddaDacCode;
		this.ddaPidCode = ddaPidCode;
		this.ddaReference = ddaReference;
		this.ddaCommentaire = ddaCommentaire;
		this.ddaNadCode = ddaNadCode;
		this.opeMatricule = opeMatricule;
		this.ddaFonCod = ddaFonCod;
		this.nadLibelle = nadLibelle;
	}

	
	@Id
	@Column(name = "DDA_ID", nullable = false, precision = 22, scale = 0)
	public BigDecimal getDdaId() {
		return this.ddaId;
	}

	public void setDdaId(BigDecimal ddaId) {
		this.ddaId = ddaId;
	}

	@Column(name = "DDA_NOM", length = 200)
	public String getDdaNom() {
		return this.ddaNom;
	}

	public void setDdaNom(String ddaNom) {
		this.ddaNom = ddaNom;
	}

	@Column(name = "DDA_DTE_SAISI", length = 7)
	public Date getDdaDteSaisi() {
		return this.ddaDteSaisi;
	}

	public void setDdaDteSaisi(Date ddaDteSaisi) {
		this.ddaDteSaisi = ddaDteSaisi;
	}

	@Column(name = "DDA_STA_CODE", length = 3)
	public String getDdaStaCode() {
		return this.ddaStaCode;
	}

	public void setDdaStaCode(String ddaStaCode) {
		this.ddaStaCode = ddaStaCode;
	}

	@Column(name = "DDA_DAC_CODE", length = 20)
	public String getDdaDacCode() {
		return this.ddaDacCode;
	}

	public void setDdaDacCode(String ddaDacCode) {
		this.ddaDacCode = ddaDacCode;
	}

	@Column(name = "DDA_PID_CODE", precision = 22, scale = 0)
	public BigDecimal getDdaPidCode() {
		return this.ddaPidCode;
	}

	public void setDdaPidCode(BigDecimal ddaPidCode) {
		this.ddaPidCode = ddaPidCode;
	}

	@Column(name = "DDA_REFERENCE", length = 500)
	public String getDdaReference() {
		return this.ddaReference;
	}

	public void setDdaReference(String ddaReference) {
		this.ddaReference = ddaReference;
	}

	@Column(name = "DDA_COMMENTAIRE", length = 500)
	public String getDdaCommentaire() {
		return this.ddaCommentaire;
	}

	public void setDdaCommentaire(String ddaCommentaire) {
		this.ddaCommentaire = ddaCommentaire;
	}

	@Column(name = "DDA_NAD_CODE", length = 3)
	public String getDdaNadCode() {
		return this.ddaNadCode;
	}

	public void setDdaNadCode(String ddaNadCode) {
		this.ddaNadCode = ddaNadCode;
	}

	@Column(name = "OPE_MATRICULE", length = 25)
	public String getOpeMatricule() {
		return this.opeMatricule;
	}

	public void setOpeMatricule(String opeMatricule) {
		this.opeMatricule = opeMatricule;
	}

	@Column(name = "DDA_FON_COD", length = 12)
	public String getDdaFonCod() {
		return this.ddaFonCod;
	}

	public void setDdaFonCod(String ddaFonCod) {
		this.ddaFonCod = ddaFonCod;
	}
	
	@Column(name = "NAD_LIBELLE", length = 500)
	public String getNadLibelle() {
		return this.nadLibelle;
	}

	public void setNadLibelle(String nadLibelle) {
		this.nadLibelle = nadLibelle;
	}
	
	@Column(name = "OPE_NOM")
	public String getOpeNom() {
		return this.opeNom;
	}

	public void setOpeNom(String opeNom) {
		this.opeNom = opeNom;
	}

}
