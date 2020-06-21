package com.sndi.models;
// Generated 20 juin 2020 17:16:02 by Hibernate Tools 4.3.5.Final

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
 * TDetailAvis generated by hbm2java
 */
@Entity
@Table(name = "T_DETAIL_AVIS", schema = "EMAP")
public class TDetailAvis implements java.io.Serializable {

	private BigDecimal davCode;
	private TDacSpecs TDacSpecs;
	private TAvisAppelOffre TAvisAppelOffre;
	private BigDecimal davNumOrd;
	private String davTitre;
	private String davContenu;
	private Date davDteSaisi;
	private String davStaCode;
	private String davAutre;

	public TDetailAvis() {
	}

	public TDetailAvis(BigDecimal davCode) {
		this.davCode = davCode;
	}

	public TDetailAvis(BigDecimal davCode, TDacSpecs TDacSpecs, TAvisAppelOffre TAvisAppelOffre, BigDecimal davNumOrd,
			String davTitre, String davContenu, Date davDteSaisi, String davStaCode, String davAutre) {
		this.davCode = davCode;
		this.TDacSpecs = TDacSpecs;
		this.TAvisAppelOffre = TAvisAppelOffre;
		this.davNumOrd = davNumOrd;
		this.davTitre = davTitre;
		this.davContenu = davContenu;
		this.davDteSaisi = davDteSaisi;
		this.davStaCode = davStaCode;
		this.davAutre = davAutre;
	}

	@Id

	@Column(name = "DAV_CODE", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getDavCode() {
		return this.davCode;
	}

	public void setDavCode(BigDecimal davCode) {
		this.davCode = davCode;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DAV_DAC_CODE")
	public TDacSpecs getTDacSpecs() {
		return this.TDacSpecs;
	}

	public void setTDacSpecs(TDacSpecs TDacSpecs) {
		this.TDacSpecs = TDacSpecs;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DAV_AAO_CODE")
	public TAvisAppelOffre getTAvisAppelOffre() {
		return this.TAvisAppelOffre;
	}

	public void setTAvisAppelOffre(TAvisAppelOffre TAvisAppelOffre) {
		this.TAvisAppelOffre = TAvisAppelOffre;
	}

	@Column(name = "DAV_NUM_ORD", precision = 22, scale = 0)
	public BigDecimal getDavNumOrd() {
		return this.davNumOrd;
	}

	public void setDavNumOrd(BigDecimal davNumOrd) {
		this.davNumOrd = davNumOrd;
	}

	@Column(name = "DAV_TITRE", length = 200)
	public String getDavTitre() {
		return this.davTitre;
	}

	public void setDavTitre(String davTitre) {
		this.davTitre = davTitre;
	}

	@Column(name = "DAV_CONTENU", length = 2000)
	public String getDavContenu() {
		return this.davContenu;
	}

	public void setDavContenu(String davContenu) {
		this.davContenu = davContenu;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DAV_DTE_SAISI", length = 7)
	public Date getDavDteSaisi() {
		return this.davDteSaisi;
	}

	public void setDavDteSaisi(Date davDteSaisi) {
		this.davDteSaisi = davDteSaisi;
	}

	@Column(name = "DAV_STA_CODE", length = 3)
	public String getDavStaCode() {
		return this.davStaCode;
	}

	public void setDavStaCode(String davStaCode) {
		this.davStaCode = davStaCode;
	}

	@Column(name = "DAV_AUTRE", length = 200)
	public String getDavAutre() {
		return this.davAutre;
	}

	public void setDavAutre(String davAutre) {
		this.davAutre = davAutre;
	}

}
