package com.sndi.models;
// Generated 14 mars 2020 14:41:40 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * TDemande generated by hbm2java
 */
@Entity
@Table(name = "T_DEMANDE", schema = "EMAP")
public class TDemande implements java.io.Serializable {

	private BigDecimal demNum;
	private TFonction TFonction;
	private TOperateur TOperateur;
	private TStatut TStatut;
	private TStructure TStructure;
	private TTypeDemande TTypeDemande;
	private String demObjet;
	private String demMotif;
	private Date demDteSaisi;
	private String demRefAvisMin;
	private String demRef;
	private Short demGesCode;
	private String demRefActIni;
	private Set<THistoDemande> THistoDemandes = new HashSet<THistoDemande>(0);
	private Set<TDetailDemandes> TDetailDemandeses = new HashSet<TDetailDemandes>(0);
	private Set<TAvisPresel> TAvisPresels = new HashSet<TAvisPresel>(0);

	public TDemande() {
	}

	public TDemande(BigDecimal demNum) {
		this.demNum = demNum;
	}

	public TDemande(BigDecimal demNum, TFonction TFonction, TOperateur TOperateur, TStatut TStatut,
			TStructure TStructure, TTypeDemande TTypeDemande, String demObjet, String demMotif, Date demDteSaisi,
			String demRefAvisMin, String demRef, Short demGesCode, String demRefActIni,
			Set<THistoDemande> THistoDemandes, Set<TDetailDemandes> TDetailDemandeses, Set<TAvisPresel> TAvisPresels) {
		this.demNum = demNum;
		this.TFonction = TFonction;
		this.TOperateur = TOperateur;
		this.TStatut = TStatut;
		this.TStructure = TStructure;
		this.TTypeDemande = TTypeDemande;
		this.demObjet = demObjet;
		this.demMotif = demMotif;
		this.demDteSaisi = demDteSaisi;
		this.demRefAvisMin = demRefAvisMin;
		this.demRef = demRef;
		this.demGesCode = demGesCode;
		this.demRefActIni = demRefActIni;
		this.THistoDemandes = THistoDemandes;
		this.TDetailDemandeses = TDetailDemandeses;
		this.TAvisPresels = TAvisPresels;
	}

	@Id

	@Column(name = "DEM_NUM", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getDemNum() {
		return this.demNum;
	}

	public void setDemNum(BigDecimal demNum) {
		this.demNum = demNum;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DEM_FON_CODE_AC")
	public TFonction getTFonction() {
		return this.TFonction;
	}

	public void setTFonction(TFonction TFonction) {
		this.TFonction = TFonction;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DEM_OPE_MATRICULE")
	public TOperateur getTOperateur() {
		return this.TOperateur;
	}

	public void setTOperateur(TOperateur TOperateur) {
		this.TOperateur = TOperateur;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DEM_STA_CODE")
	public TStatut getTStatut() {
		return this.TStatut;
	}

	public void setTStatut(TStatut TStatut) {
		this.TStatut = TStatut;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DEM_STR_CODE")
	public TStructure getTStructure() {
		return this.TStructure;
	}

	public void setTStructure(TStructure TStructure) {
		this.TStructure = TStructure;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DEM_TDM_CODE")
	public TTypeDemande getTTypeDemande() {
		return this.TTypeDemande;
	}

	public void setTTypeDemande(TTypeDemande TTypeDemande) {
		this.TTypeDemande = TTypeDemande;
	}

	@Column(name = "DEM_OBJET", length = 1000)
	public String getDemObjet() {
		return this.demObjet;
	}

	public void setDemObjet(String demObjet) {
		this.demObjet = demObjet;
	}

	@Column(name = "DEM_MOTIF", length = 1000)
	public String getDemMotif() {
		return this.demMotif;
	}

	public void setDemMotif(String demMotif) {
		this.demMotif = demMotif;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DEM_DTE_SAISI", length = 7)
	public Date getDemDteSaisi() {
		return this.demDteSaisi;
	}

	public void setDemDteSaisi(Date demDteSaisi) {
		this.demDteSaisi = demDteSaisi;
	}

	@Column(name = "DEM_REF_AVIS_MIN", length = 200)
	public String getDemRefAvisMin() {
		return this.demRefAvisMin;
	}

	public void setDemRefAvisMin(String demRefAvisMin) {
		this.demRefAvisMin = demRefAvisMin;
	}

	@Column(name = "DEM_REF", length = 200)
	public String getDemRef() {
		return this.demRef;
	}

	public void setDemRef(String demRef) {
		this.demRef = demRef;
	}

	@Column(name = "DEM_GES_CODE", precision = 4, scale = 0)
	public Short getDemGesCode() {
		return this.demGesCode;
	}

	public void setDemGesCode(Short demGesCode) {
		this.demGesCode = demGesCode;
	}

	@Column(name = "DEM_REF_ACT_INI", length = 20)
	public String getDemRefActIni() {
		return this.demRefActIni;
	}

	public void setDemRefActIni(String demRefActIni) {
		this.demRefActIni = demRefActIni;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TDemande")
	public Set<THistoDemande> getTHistoDemandes() {
		return this.THistoDemandes;
	}

	public void setTHistoDemandes(Set<THistoDemande> THistoDemandes) {
		this.THistoDemandes = THistoDemandes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TDemande")
	public Set<TDetailDemandes> getTDetailDemandeses() {
		return this.TDetailDemandeses;
	}

	public void setTDetailDemandeses(Set<TDetailDemandes> TDetailDemandeses) {
		this.TDetailDemandeses = TDetailDemandeses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TDemande")
	public Set<TAvisPresel> getTAvisPresels() {
		return this.TAvisPresels;
	}

	public void setTAvisPresels(Set<TAvisPresel> TAvisPresels) {
		this.TAvisPresels = TAvisPresels;
	}

}
