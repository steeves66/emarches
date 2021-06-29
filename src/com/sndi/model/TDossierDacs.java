package com.sndi.model;
// Generated 23 janv. 2020 16:00:05 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * TDossierDacs generated by hbm2java
 */
@Entity
@Table(name = "T_DOSSIER_DACS", schema = "EMAP")
public class TDossierDacs implements java.io.Serializable {

	private long ddaId;
	private TDacSpecs TDacSpecs;
	private TPiecesDacs TPiecesDacs;
	private TNatureDocuments TNatureDocuments;
	private TOperateur TOperateur;
	private TFonction TFonction;
	private String ddaNom;
	private Date ddaDteSaisi;
	private String ddaStaCode;
	private String ddaReference;
	private String ddaCommentaire;

	public TDossierDacs() {
	}

	public TDossierDacs(long ddaId) {
		this.ddaId = ddaId;
	}

	public TDossierDacs(long ddaId, TDacSpecs TDacSpecs, TPiecesDacs TPiecesDacs, TNatureDocuments TNatureDocuments, TOperateur TOperateur,TFonction TFonction, String ddaNom, Date ddaDteSaisi,
			String ddaStaCode, String ddaReference, String ddaCommentaire) {
		this.ddaId = ddaId;
		this.TDacSpecs = TDacSpecs;
		this.TPiecesDacs = TPiecesDacs;
		this.TNatureDocuments = TNatureDocuments;
		this.TOperateur = TOperateur;
		this.TFonction = TFonction;
		this.ddaNom = ddaNom;
		this.ddaDteSaisi = ddaDteSaisi;
		this.ddaStaCode = ddaStaCode;
		this.ddaReference = ddaReference;
		this.ddaCommentaire = ddaCommentaire;
	}

	@Id
	@SequenceGenerator(name = "SEQ_DDA_Sequence", sequenceName = "SEQ_DDA", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_DDA_Sequence")
	@Column(name = "DDA_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public long getDdaId() {
		return this.ddaId;
	}

	public void setDdaId(long ddaId) {
		this.ddaId = ddaId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "DDA_DAC_CODE")
	public TDacSpecs getTDacSpecs() {
		return this.TDacSpecs;
	}

	public void setTDacSpecs(TDacSpecs TDacSpecs) {
		this.TDacSpecs = TDacSpecs;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "DDA_NAD_CODE")
	public TNatureDocuments getTNatureDocuments() {
		return this.TNatureDocuments;
	}

	public void setTNatureDocuments(TNatureDocuments TNatureDocuments) {
		this.TNatureDocuments = TNatureDocuments;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "DDA_PID_CODE")
	public TPiecesDacs getTPiecesDacs() {
		return this.TPiecesDacs;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "OPE_MATRICULE")
	public TOperateur getTOperateur() {
		return this.TOperateur;
	}

	public void setTOperateur(TOperateur TOperateur) {
		this.TOperateur = TOperateur;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DDA_FON_COD")
	public TFonction getTFonction() {
		return this.TFonction;
	}

	public void setTFonction(TFonction TFonction) {
		this.TFonction = TFonction;
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
