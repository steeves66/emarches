package com.sndi.models;
// Generated 14 mars 2020 14:41:40 by Hibernate Tools 4.3.5.Final

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
 * THistoDemande generated by hbm2java
 */
@Entity
@Table(name = "T_HISTO_DEMANDE", schema = "EMAP")
public class THistoDemande implements java.io.Serializable {

	private short hdmNum;
	private TDemande TDemande;
	private TFonction TFonction;
	private TOperateur TOperateur;
	private TStatut TStatut;
	private Date hdmDteSaisi;

	public THistoDemande() {
	}

	public THistoDemande(short hdmNum, TDemande TDemande) {
		this.hdmNum = hdmNum;
		this.TDemande = TDemande;
	}

	public THistoDemande(short hdmNum, TDemande TDemande, TFonction TFonction, TOperateur TOperateur, TStatut TStatut,
			Date hdmDteSaisi) {
		this.hdmNum = hdmNum;
		this.TDemande = TDemande;
		this.TFonction = TFonction;
		this.TOperateur = TOperateur;
		this.TStatut = TStatut;
		this.hdmDteSaisi = hdmDteSaisi;
	}

	@Id

	@Column(name = "HDM_NUM", unique = true, nullable = false, precision = 4, scale = 0)
	public short getHdmNum() {
		return this.hdmNum;
	}

	public void setHdmNum(short hdmNum) {
		this.hdmNum = hdmNum;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "HDM_DEM_NUM", nullable = false)
	public TDemande getTDemande() {
		return this.TDemande;
	}

	public void setTDemande(TDemande TDemande) {
		this.TDemande = TDemande;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "HDM_FON_COD")
	public TFonction getTFonction() {
		return this.TFonction;
	}

	public void setTFonction(TFonction TFonction) {
		this.TFonction = TFonction;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "HDM_OPE_CODE")
	public TOperateur getTOperateur() {
		return this.TOperateur;
	}

	public void setTOperateur(TOperateur TOperateur) {
		this.TOperateur = TOperateur;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "HDM_STA_CODE")
	public TStatut getTStatut() {
		return this.TStatut;
	}

	public void setTStatut(TStatut TStatut) {
		this.TStatut = TStatut;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "HDM_DTE_SAISI", length = 7)
	public Date getHdmDteSaisi() {
		return this.hdmDteSaisi;
	}

	public void setHdmDteSaisi(Date hdmDteSaisi) {
		this.hdmDteSaisi = hdmDteSaisi;
	}

}
