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
 * TDetailCorrection generated by hbm2java
 */
@Entity
@Table(name = "T_DETAIL_CORRECTION", schema = "EMAP")
public class TDetailCorrection implements java.io.Serializable {

	private BigDecimal dcoNum;
	private TCorrectionDac TCorrectionDac;
	private TDacSpecs TDacSpecs;
	private TFonction TFonction;
	private TOperateur TOperateur;
	private TPiecesDacs TPiecesDacs;
	private String dcoTitre;
	private String dcoLibelle;
	private Date dcoDteSaisi;
	private String dcoObservation;
	private String dcoConforme;
	private String dcoPresente;
	private String dcoRespo;

	public TDetailCorrection() {
	}

	public TDetailCorrection(BigDecimal dcoNum) {
		this.dcoNum = dcoNum;
	}

	public TDetailCorrection(BigDecimal dcoNum, TCorrectionDac TCorrectionDac, TDacSpecs TDacSpecs, TFonction TFonction,
			TOperateur TOperateur, TPiecesDacs TPiecesDacs, String dcoTitre, String dcoLibelle, Date dcoDteSaisi,
			String dcoObservation, String dcoConforme, String dcoPresente, String dcoRespo) {
		this.dcoNum = dcoNum;
		this.TCorrectionDac = TCorrectionDac;
		this.TDacSpecs = TDacSpecs;
		this.TFonction = TFonction;
		this.TOperateur = TOperateur;
		this.TPiecesDacs = TPiecesDacs;
		this.dcoTitre = dcoTitre;
		this.dcoLibelle = dcoLibelle;
		this.dcoDteSaisi = dcoDteSaisi;
		this.dcoObservation = dcoObservation;
		this.dcoConforme = dcoConforme;
		this.dcoPresente = dcoPresente;
		this.dcoRespo = dcoRespo;
	}

	@Id

	@Column(name = "DCO_NUM", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getDcoNum() {
		return this.dcoNum;
	}

	public void setDcoNum(BigDecimal dcoNum) {
		this.dcoNum = dcoNum;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DCO_COR_NUM")
	public TCorrectionDac getTCorrectionDac() {
		return this.TCorrectionDac;
	}

	public void setTCorrectionDac(TCorrectionDac TCorrectionDac) {
		this.TCorrectionDac = TCorrectionDac;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DCO_DAC_CODE")
	public TDacSpecs getTDacSpecs() {
		return this.TDacSpecs;
	}

	public void setTDacSpecs(TDacSpecs TDacSpecs) {
		this.TDacSpecs = TDacSpecs;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DCO_FON_COD_SAISI")
	public TFonction getTFonction() {
		return this.TFonction;
	}

	public void setTFonction(TFonction TFonction) {
		this.TFonction = TFonction;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DCO_OPE_MATRICULE")
	public TOperateur getTOperateur() {
		return this.TOperateur;
	}

	public void setTOperateur(TOperateur TOperateur) {
		this.TOperateur = TOperateur;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DCO_PID_CODE")
	public TPiecesDacs getTPiecesDacs() {
		return this.TPiecesDacs;
	}

	public void setTPiecesDacs(TPiecesDacs TPiecesDacs) {
		this.TPiecesDacs = TPiecesDacs;
	}

	@Column(name = "DCO_TITRE", length = 200)
	public String getDcoTitre() {
		return this.dcoTitre;
	}

	public void setDcoTitre(String dcoTitre) {
		this.dcoTitre = dcoTitre;
	}

	@Column(name = "DCO_LIBELLE", length = 1000)
	public String getDcoLibelle() {
		return this.dcoLibelle;
	}

	public void setDcoLibelle(String dcoLibelle) {
		this.dcoLibelle = dcoLibelle;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DCO_DTE_SAISI", length = 7)
	public Date getDcoDteSaisi() {
		return this.dcoDteSaisi;
	}

	public void setDcoDteSaisi(Date dcoDteSaisi) {
		this.dcoDteSaisi = dcoDteSaisi;
	}

	@Column(name = "DCO_OBSERVATION", length = 4000)
	public String getDcoObservation() {
		return this.dcoObservation;
	}

	public void setDcoObservation(String dcoObservation) {
		this.dcoObservation = dcoObservation;
	}

	@Column(name = "DCO_CONFORME", length = 3)
	public String getDcoConforme() {
		return this.dcoConforme;
	}

	public void setDcoConforme(String dcoConforme) {
		this.dcoConforme = dcoConforme;
	}

	@Column(name = "DCO_PRESENTE", length = 3)
	public String getDcoPresente() {
		return this.dcoPresente;
	}

	public void setDcoPresente(String dcoPresente) {
		this.dcoPresente = dcoPresente;
	}

	@Column(name = "DCO_RESPO", length = 1)
	public String getDcoRespo() {
		return this.dcoRespo;
	}

	public void setDcoRespo(String dcoRespo) {
		this.dcoRespo = dcoRespo;
	}

}
