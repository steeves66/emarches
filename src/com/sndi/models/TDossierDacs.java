package com.sndi.models;
// Generated 27 mars 2020 12:01:30 by Hibernate Tools 4.3.5.Final

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
 * TDossierDacs generated by hbm2java
 */
@Entity
@Table(name = "T_DOSSIER_DACS", schema = "EMAP")
public class TDossierDacs implements java.io.Serializable {

	private BigDecimal ddaId;
	private TDacSpecs TDacSpecs;
	private TNatureDocuments TNatureDocuments;
	private TPiecesDacs TPiecesDacs;
	private String ddaNom;
	private Date ddaDteSaisi;
	private String ddaStaCode;
	private String ddaReference;
	private String ddaCommentaire;

	public TDossierDacs() {
	}

	public TDossierDacs(BigDecimal ddaId) {
		this.ddaId = ddaId;
	}

	public TDossierDacs(BigDecimal ddaId, TDacSpecs TDacSpecs, TNatureDocuments TNatureDocuments,
			TPiecesDacs TPiecesDacs, String ddaNom, Date ddaDteSaisi, String ddaStaCode, String ddaReference,
			String ddaCommentaire) {
		this.ddaId = ddaId;
		this.TDacSpecs = TDacSpecs;
		this.TNatureDocuments = TNatureDocuments;
		this.TPiecesDacs = TPiecesDacs;
		this.ddaNom = ddaNom;
		this.ddaDteSaisi = ddaDteSaisi;
		this.ddaStaCode = ddaStaCode;
		this.ddaReference = ddaReference;
		this.ddaCommentaire = ddaCommentaire;
	}

	@Id

	@Column(name = "DDA_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getDdaId() {
		return this.ddaId;
	}

	public void setDdaId(BigDecimal ddaId) {
		this.ddaId = ddaId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DDA_DAC_CODE")
	public TDacSpecs getTDacSpecs() {
		return this.TDacSpecs;
	}

	public void setTDacSpecs(TDacSpecs TDacSpecs) {
		this.TDacSpecs = TDacSpecs;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DDA_NAD_CODE")
	public TNatureDocuments getTNatureDocuments() {
		return this.TNatureDocuments;
	}

	public void setTNatureDocuments(TNatureDocuments TNatureDocuments) {
		this.TNatureDocuments = TNatureDocuments;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DDA_PID_CODE")
	public TPiecesDacs getTPiecesDacs() {
		return this.TPiecesDacs;
	}

	public void setTPiecesDacs(TPiecesDacs TPiecesDacs) {
		this.TPiecesDacs = TPiecesDacs;
	}

	@Column(name = "DDA_NOM", length = 200)
	public String getDdaNom() {
		return this.ddaNom;
	}

	public void setDdaNom(String ddaNom) {
		this.ddaNom = ddaNom;
	}

	@Temporal(TemporalType.DATE)
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

}
