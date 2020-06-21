package com.sndi.model;
// Generated 20 juin 2020 12:34:16 by Hibernate Tools 4.3.5.Final

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
@Table(name = "VB_CRITERE_ANALYSE_SPEC")
public class VbCritereAnalyseSpec implements java.io.Serializable {

	private BigDecimal casNum;
	private String casCraCode;
	private String casDacCode;
	private Date casDteSaisie;
	private String casDteModif;
	private String casOpeMatricule;
	private String casValeur;
	private String casOpeModif;
	private String casStatut;
	private String casObser;

	public VbCritereAnalyseSpec() {
	}

	public VbCritereAnalyseSpec(BigDecimal casNum, String casCraCode) {
		this.casNum = casNum;
		this.casCraCode = casCraCode;
	}

	public VbCritereAnalyseSpec(BigDecimal casNum, String casCraCode, String casDacCode, Date casDteSaisie,
			String casDteModif, String casOpeMatricule, String casValeur, String casOpeModif, String casStatut,
			String casObser) {
		this.casNum = casNum;
		this.casCraCode = casCraCode;
		this.casDacCode = casDacCode;
		this.casDteSaisie = casDteSaisie;
		this.casDteModif = casDteModif;
		this.casOpeMatricule = casOpeMatricule;
		this.casValeur = casValeur;
		this.casOpeModif = casOpeModif;
		this.casStatut = casStatut;
		this.casObser = casObser;
	}

	@Id
	@Column(name = "CAS_NUM", nullable = false, precision = 22, scale = 0)
	public BigDecimal getCasNum() {
		return this.casNum;
	}

	public void setCasNum(BigDecimal casNum) {
		this.casNum = casNum;
	}

	@Column(name = "CAS_CRA_CODE", nullable = false, length = 20)
	public String getCasCraCode() {
		return this.casCraCode;
	}

	public void setCasCraCode(String casCraCode) {
		this.casCraCode = casCraCode;
	}

	@Column(name = "CAS_DAC_CODE", length = 32)
	public String getCasDacCode() {
		return this.casDacCode;
	}

	public void setCasDacCode(String casDacCode) {
		this.casDacCode = casDacCode;
	}

	@Column(name = "CAS_DTE_SAISIE", length = 7)
	public Date getCasDteSaisie() {
		return this.casDteSaisie;
	}

	public void setCasDteSaisie(Date casDteSaisie) {
		this.casDteSaisie = casDteSaisie;
	}

	@Column(name = "CAS_DTE_MODIF", length = 32)
	public String getCasDteModif() {
		return this.casDteModif;
	}

	public void setCasDteModif(String casDteModif) {
		this.casDteModif = casDteModif;
	}

	@Column(name = "CAS_OPE_MATRICULE", length = 25)
	public String getCasOpeMatricule() {
		return this.casOpeMatricule;
	}

	public void setCasOpeMatricule(String casOpeMatricule) {
		this.casOpeMatricule = casOpeMatricule;
	}

	@Column(name = "CAS_VALEUR", length = 500)
	public String getCasValeur() {
		return this.casValeur;
	}

	public void setCasValeur(String casValeur) {
		this.casValeur = casValeur;
	}

	@Column(name = "CAS_OPE_MODIF", length = 25)
	public String getCasOpeModif() {
		return this.casOpeModif;
	}

	public void setCasOpeModif(String casOpeModif) {
		this.casOpeModif = casOpeModif;
	}

	@Column(name = "CAS_STATUT", length = 1)
	public String getCasStatut() {
		return this.casStatut;
	}

	public void setCasStatut(String casStatut) {
		this.casStatut = casStatut;
	}

	@Column(name = "CAS_OBSER", length = 500)
	public String getCasObser() {
		return this.casObser;
	}

	public void setCasObser(String casObser) {
		this.casObser = casObser;
	}
}
