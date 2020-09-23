package com.sndi.model;
// Generated 4 mars 2020 19:07:27 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.sndi.model.TPieceDemande;
import com.sndi.model.TDossierDemande;

/**
 * TDemande generated by hbm2java
 */
@Entity
@Table(name = "T_DEMANDE", schema = "EMAP")
public class TDemande implements java.io.Serializable {

	private BigDecimal demNum;
	private TTypeDemande TTypeDemande;
	private TStatut TStatut;
	private TStructure TStructure;
	private TFonction TFonction;
	private TOperateur TOperateur;
	private String demObjet;
	private String demMotif;
	private Date demDteSaisi;
	private String demRefAvisMin;
	private String demRef;
	private Short demGesCode;
	private String demRefActIni;
	private String demFonCodePf;
	private String demFonCodeDmp;
	private String demStatutRetour;
	private String demAaoCode;
	private String demDacCode;
	private String demMarCode;
	private Set<TPieceDemande> TPieceDemandes = new HashSet<TPieceDemande>(0);
	private Set<THistoDemande> THistoDemandes = new HashSet<THistoDemande>(0);
	private Set<TDetailDemandes> TDetailDemandeses = new HashSet<TDetailDemandes>(0);
	private Set<TDossierDemande> TDossierDemandes = new HashSet<TDossierDemande>(0);
	private Set<TAvisPresel> TAvisPresels = new HashSet<TAvisPresel>(0);

	public TDemande() {
	}

	public TDemande(BigDecimal demNum) {
		this.demNum = demNum;
	}

	public TDemande(BigDecimal demNum, TTypeDemande TTypeDemande, TStatut TStatut, TStructure TStructure,
			TFonction TFonction, TOperateur TOperateur, String demObjet, String demMotif, Date demDteSaisi,String demFonCodePf, String demAaoCode, String demDacCode, String demMarCode,
            String demFonCodeDmp,String demRefAvisMin, String demRef, Short demGesCode, String demRefActIni,String demStatutRetour,Set<TPieceDemande> TPieceDemandes,
			Set<THistoDemande> THistoDemandes, Set<TDetailDemandes> TDetailDemandeses,Set<TDossierDemande> TDossierDemandes, Set<TAvisPresel> TAvisPresels) {
		this.demNum = demNum;
		this.TTypeDemande = TTypeDemande;
		this.TStatut = TStatut;
		this.TStructure = TStructure;
		this.TFonction = TFonction;
		this.TOperateur = TOperateur;
		this.demObjet = demObjet;
		this.demMotif = demMotif;
		this.demDteSaisi = demDteSaisi;
		this.demRefAvisMin = demRefAvisMin;
		this.demRef = demRef;
		this.demGesCode = demGesCode;
		this.demRefActIni = demRefActIni;
		this.demStatutRetour = demStatutRetour;
		this.TPieceDemandes = TPieceDemandes;
		this.THistoDemandes = THistoDemandes;
		this.TDetailDemandeses = TDetailDemandeses;
		this.TDossierDemandes = TDossierDemandes;
		this.TAvisPresels = TAvisPresels;
		this.demFonCodePf =demFonCodePf;
		this.demFonCodeDmp = demFonCodeDmp;
		this.demAaoCode = demAaoCode;
		this.demDacCode =demDacCode;
		this.demMarCode = demMarCode;
	}

	@Id
	@SequenceGenerator(name = "SEQ_DEM_Sequence", sequenceName = "SEQ_DEM", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_DEM_Sequence")
	@Column(name = "DEM_NUM", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getDemNum() {
		return this.demNum;
	}

	public void setDemNum(BigDecimal demNum) {
		this.demNum = demNum;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "DEM_TDM_CODE")
	public TTypeDemande getTTypeDemande() {
		return this.TTypeDemande;
	}

	public void setTTypeDemande(TTypeDemande TTypeDemande) {
		this.TTypeDemande = TTypeDemande;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "DEM_STA_CODE")
	public TStatut getTStatut() {
		return this.TStatut;
	}

	public void setTStatut(TStatut TStatut) {
		this.TStatut = TStatut;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "DEM_STR_CODE")
	public TStructure getTStructure() {
		return this.TStructure;
	}

	public void setTStructure(TStructure TStructure) {
		this.TStructure = TStructure;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "DEM_FON_CODE_AC")
	public TFonction getTFonction() {
		return this.TFonction;
	}

	public void setTFonction(TFonction TFonction) {
		this.TFonction = TFonction;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "DEM_OPE_MATRICULE")
	public TOperateur getTOperateur() {
		return this.TOperateur;
	}

	public void setTOperateur(TOperateur TOperateur) {
		this.TOperateur = TOperateur;
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
	
	@Column(name = "DEM_STATUT_RETOUR", length = 1)
	public String getDemStatutRetour() {
		return this.demStatutRetour;
	}

	public void setDemStatutRetour(String demStatutRetour) {
		this.demStatutRetour = demStatutRetour;
	}
	@Column(name = "DEM_AAO_CODE", length = 25)
	public String getDemAaoCode() {
		return this.demAaoCode;
	}

	public void setDemAaoCode(String demAaoCode) {
		this.demAaoCode = demAaoCode;
	}

	@Column(name = "DEM_DAC_CODE", length = 25)
	public String getDemDacCode() {
		return this.demDacCode;
	}

	public void setDemDacCode(String demDacCode) {
		this.demDacCode = demDacCode;
	}

	@Column(name = "DEM_MAR_CODE", length = 25)
	public String getDemMarCode() {
		return this.demMarCode;
	}

	public void setDemMarCode(String demMarCode) {
		this.demMarCode = demMarCode;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TDemande")
	public Set<TPieceDemande> getTPieceDemandes() {
		return this.TPieceDemandes;
	}

	public void setTPieceDemandes(Set<TPieceDemande> TPieceDemandes) {
		this.TPieceDemandes = TPieceDemandes;
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
	public Set<TDossierDemande> getTDossierDemandes() {
		return this.TDossierDemandes;
	}

	public void setTDossierDemandes(Set<TDossierDemande> TDossierDemandes) {
		this.TDossierDemandes = TDossierDemandes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TDemande")
	public Set<TAvisPresel> getTAvisPresels() {
		return this.TAvisPresels;
	}

	public void setTAvisPresels(Set<TAvisPresel> TAvisPresels) {
		this.TAvisPresels = TAvisPresels;
	}

	@Column(name = "DEM_FON_CODE_PF")
	public String getDemFonCodePf() {
		return demFonCodePf;
	}

	public void setDemFonCodePf(String demFonCodePf) {
		this.demFonCodePf = demFonCodePf;
	}

	@Column(name = "DEM_FON_CODE_DMP")
	public String getDemFonCodeDmp() {
		return demFonCodeDmp;
	}

	public void setDemFonCodeDmp(String demFonCodeDmp) {
		this.demFonCodeDmp = demFonCodeDmp;
	}

}
