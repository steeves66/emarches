package com.sndi.models;
// Generated 26 mars 2020 03:50:59 by Hibernate Tools 4.3.5.Final

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
 * TDacSpecs generated by hbm2java
 */
@Entity
@Table(name = "T_DAC_SPECS", schema = "EMAP")
public class TDacSpecs implements java.io.Serializable {

	private String dacCode;
	private TStatut TStatut;
	private TStructure TStructure;
	private TTypeDacSpecs TTypeDacSpecs;
	private TTypeMarche TTypeMarche;
	private TDetailPlanPassation TDetailPlanPassation;
	private TFonction TFonctionByDacFonCodeCpmp;
	private TFonction TFonctionByDacFonCodAc;
	private TGestion TGestion;
	private TModePassation TModePassation;
	private String dacObjet;
	private Date dacDteSaisi;
	private BigDecimal dacNbrOuv;
	private Date dacDteValCpmp;
	private Date dacDteValDmp;
	private Date dacDateReception;
	private String dacStatutRetour;
	private String dacMention;
	private Date dacDateValAc;
	private String dacAvisBailleur;
	private Date dacDateAvisBailleur;
	private String dacBailleur;
	private Long dacCout;
	private String dacTypePlan;
	private Set<TAvisAppelOffre> TAvisAppelOffres = new HashSet<TAvisAppelOffre>(0);
	private Set<TCommissionSpecifique> TCommissionSpecifiques = new HashSet<TCommissionSpecifique>(0);
	private Set<TDetailVente> TDetailVentes = new HashSet<TDetailVente>(0);
	private Set<TOffres> TOffreses = new HashSet<TOffres>(0);
	private Set<TAffichageDao> TAffichageDaos = new HashSet<TAffichageDao>(0);
	private Set<TPiecesOffres> TPiecesOffreses = new HashSet<TPiecesOffres>(0);
	private Set<TCorrectionDac> TCorrectionDacs = new HashSet<TCorrectionDac>(0);
	private Set<TDetailAvis> TDetailAvises = new HashSet<TDetailAvis>(0);
	private Set<TOffrePieceDac> TOffrePieceDacs = new HashSet<TOffrePieceDac>(0);
	private Set<THistoDac> THistoDacs = new HashSet<THistoDac>(0);
	private Set<TDossierDacs> TDossierDacses = new HashSet<TDossierDacs>(0);
	private Set<TDetailCorrection> TDetailCorrections = new HashSet<TDetailCorrection>(0);
	private Set<TDetailPlanPassation> TDetailPlanPassations = new HashSet<TDetailPlanPassation>(0);
	private Set<TDetailDemandes> TDetailDemandeses = new HashSet<TDetailDemandes>(0);
	private Set<TLotAao> TLotAaos = new HashSet<TLotAao>(0);
	private Set<TPiecesDacs> TPiecesDacses = new HashSet<TPiecesDacs>(0);
	private Set<TDetCommissionSeance> TDetCommissionSeances = new HashSet<TDetCommissionSeance>(0);
	private Set<TRetrait> TRetraits = new HashSet<TRetrait>(0);

	public TDacSpecs() {
	}

	public TDacSpecs(String dacCode) {
		this.dacCode = dacCode;
	}

	public TDacSpecs(String dacCode, TStatut TStatut, TStructure TStructure, TTypeDacSpecs TTypeDacSpecs,
			TTypeMarche TTypeMarche, TDetailPlanPassation TDetailPlanPassation, TFonction TFonctionByDacFonCodeCpmp,
			TFonction TFonctionByDacFonCodAc, TGestion TGestion, TModePassation TModePassation, String dacObjet,
			Date dacDteSaisi, BigDecimal dacNbrOuv, Date dacDteValCpmp, Date dacDteValDmp, Date dacDateReception,
			String dacStatutRetour, String dacMention, Date dacDateValAc, String dacAvisBailleur,
			Date dacDateAvisBailleur, String dacBailleur, Long dacCout, String dacTypePlan,
			Set<TAvisAppelOffre> TAvisAppelOffres, Set<TCommissionSpecifique> TCommissionSpecifiques,
			Set<TDetailVente> TDetailVentes, Set<TOffres> TOffreses, Set<TAffichageDao> TAffichageDaos,
			Set<TPiecesOffres> TPiecesOffreses, Set<TCorrectionDac> TCorrectionDacs, Set<TDetailAvis> TDetailAvises,
			Set<TOffrePieceDac> TOffrePieceDacs, Set<THistoDac> THistoDacs, Set<TDossierDacs> TDossierDacses,
			Set<TDetailCorrection> TDetailCorrections, Set<TDetailPlanPassation> TDetailPlanPassations,
			Set<TDetailDemandes> TDetailDemandeses, Set<TLotAao> TLotAaos, Set<TPiecesDacs> TPiecesDacses,
			Set<TDetCommissionSeance> TDetCommissionSeances, Set<TRetrait> TRetraits) {
		this.dacCode = dacCode;
		this.TStatut = TStatut;
		this.TStructure = TStructure;
		this.TTypeDacSpecs = TTypeDacSpecs;
		this.TTypeMarche = TTypeMarche;
		this.TDetailPlanPassation = TDetailPlanPassation;
		this.TFonctionByDacFonCodeCpmp = TFonctionByDacFonCodeCpmp;
		this.TFonctionByDacFonCodAc = TFonctionByDacFonCodAc;
		this.TGestion = TGestion;
		this.TModePassation = TModePassation;
		this.dacObjet = dacObjet;
		this.dacDteSaisi = dacDteSaisi;
		this.dacNbrOuv = dacNbrOuv;
		this.dacDteValCpmp = dacDteValCpmp;
		this.dacDteValDmp = dacDteValDmp;
		this.dacDateReception = dacDateReception;
		this.dacStatutRetour = dacStatutRetour;
		this.dacMention = dacMention;
		this.dacDateValAc = dacDateValAc;
		this.dacAvisBailleur = dacAvisBailleur;
		this.dacDateAvisBailleur = dacDateAvisBailleur;
		this.dacBailleur = dacBailleur;
		this.dacCout = dacCout;
		this.dacTypePlan = dacTypePlan;
		this.TAvisAppelOffres = TAvisAppelOffres;
		this.TCommissionSpecifiques = TCommissionSpecifiques;
		this.TDetailVentes = TDetailVentes;
		this.TOffreses = TOffreses;
		this.TAffichageDaos = TAffichageDaos;
		this.TPiecesOffreses = TPiecesOffreses;
		this.TCorrectionDacs = TCorrectionDacs;
		this.TDetailAvises = TDetailAvises;
		this.TOffrePieceDacs = TOffrePieceDacs;
		this.THistoDacs = THistoDacs;
		this.TDossierDacses = TDossierDacses;
		this.TDetailCorrections = TDetailCorrections;
		this.TDetailPlanPassations = TDetailPlanPassations;
		this.TDetailDemandeses = TDetailDemandeses;
		this.TLotAaos = TLotAaos;
		this.TPiecesDacses = TPiecesDacses;
		this.TDetCommissionSeances = TDetCommissionSeances;
		this.TRetraits = TRetraits;
	}

	@Id

	@Column(name = "DAC_CODE", unique = true, nullable = false, length = 20)
	public String getDacCode() {
		return this.dacCode;
	}

	public void setDacCode(String dacCode) {
		this.dacCode = dacCode;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DAC_STA_CODE")
	public TStatut getTStatut() {
		return this.TStatut;
	}

	public void setTStatut(TStatut TStatut) {
		this.TStatut = TStatut;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DAC_STR_CODE")
	public TStructure getTStructure() {
		return this.TStructure;
	}

	public void setTStructure(TStructure TStructure) {
		this.TStructure = TStructure;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DAC_TD_CODE")
	public TTypeDacSpecs getTTypeDacSpecs() {
		return this.TTypeDacSpecs;
	}

	public void setTTypeDacSpecs(TTypeDacSpecs TTypeDacSpecs) {
		this.TTypeDacSpecs = TTypeDacSpecs;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DAC_TYM_CODE")
	public TTypeMarche getTTypeMarche() {
		return this.TTypeMarche;
	}

	public void setTTypeMarche(TTypeMarche TTypeMarche) {
		this.TTypeMarche = TTypeMarche;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DAC_DPP_ID")
	public TDetailPlanPassation getTDetailPlanPassation() {
		return this.TDetailPlanPassation;
	}

	public void setTDetailPlanPassation(TDetailPlanPassation TDetailPlanPassation) {
		this.TDetailPlanPassation = TDetailPlanPassation;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DAC_FON_CODE_CPMP")
	public TFonction getTFonctionByDacFonCodeCpmp() {
		return this.TFonctionByDacFonCodeCpmp;
	}

	public void setTFonctionByDacFonCodeCpmp(TFonction TFonctionByDacFonCodeCpmp) {
		this.TFonctionByDacFonCodeCpmp = TFonctionByDacFonCodeCpmp;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DAC_FON_COD_AC")
	public TFonction getTFonctionByDacFonCodAc() {
		return this.TFonctionByDacFonCodAc;
	}

	public void setTFonctionByDacFonCodAc(TFonction TFonctionByDacFonCodAc) {
		this.TFonctionByDacFonCodAc = TFonctionByDacFonCodAc;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DAC_GES_CODE")
	public TGestion getTGestion() {
		return this.TGestion;
	}

	public void setTGestion(TGestion TGestion) {
		this.TGestion = TGestion;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DAC_MOP_CODE")
	public TModePassation getTModePassation() {
		return this.TModePassation;
	}

	public void setTModePassation(TModePassation TModePassation) {
		this.TModePassation = TModePassation;
	}

	@Column(name = "DAC_OBJET", length = 1000)
	public String getDacObjet() {
		return this.dacObjet;
	}

	public void setDacObjet(String dacObjet) {
		this.dacObjet = dacObjet;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DAC_DTE_SAISI", length = 7)
	public Date getDacDteSaisi() {
		return this.dacDteSaisi;
	}

	public void setDacDteSaisi(Date dacDteSaisi) {
		this.dacDteSaisi = dacDteSaisi;
	}

	@Column(name = "DAC_NBR_OUV", precision = 22, scale = 0)
	public BigDecimal getDacNbrOuv() {
		return this.dacNbrOuv;
	}

	public void setDacNbrOuv(BigDecimal dacNbrOuv) {
		this.dacNbrOuv = dacNbrOuv;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DAC_DTE_VAL_CPMP", length = 7)
	public Date getDacDteValCpmp() {
		return this.dacDteValCpmp;
	}

	public void setDacDteValCpmp(Date dacDteValCpmp) {
		this.dacDteValCpmp = dacDteValCpmp;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DAC_DTE_VAL_DMP", length = 7)
	public Date getDacDteValDmp() {
		return this.dacDteValDmp;
	}

	public void setDacDteValDmp(Date dacDteValDmp) {
		this.dacDteValDmp = dacDteValDmp;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DAC_DATE_RECEPTION", length = 7)
	public Date getDacDateReception() {
		return this.dacDateReception;
	}

	public void setDacDateReception(Date dacDateReception) {
		this.dacDateReception = dacDateReception;
	}

	@Column(name = "DAC_STATUT_RETOUR", length = 2)
	public String getDacStatutRetour() {
		return this.dacStatutRetour;
	}

	public void setDacStatutRetour(String dacStatutRetour) {
		this.dacStatutRetour = dacStatutRetour;
	}

	@Column(name = "DAC_MENTION", length = 100)
	public String getDacMention() {
		return this.dacMention;
	}

	public void setDacMention(String dacMention) {
		this.dacMention = dacMention;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DAC_DATE_VAL_AC", length = 7)
	public Date getDacDateValAc() {
		return this.dacDateValAc;
	}

	public void setDacDateValAc(Date dacDateValAc) {
		this.dacDateValAc = dacDateValAc;
	}

	@Column(name = "DAC_AVIS_BAILLEUR", length = 4000)
	public String getDacAvisBailleur() {
		return this.dacAvisBailleur;
	}

	public void setDacAvisBailleur(String dacAvisBailleur) {
		this.dacAvisBailleur = dacAvisBailleur;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DAC_DATE_AVIS_BAILLEUR", length = 7)
	public Date getDacDateAvisBailleur() {
		return this.dacDateAvisBailleur;
	}

	public void setDacDateAvisBailleur(Date dacDateAvisBailleur) {
		this.dacDateAvisBailleur = dacDateAvisBailleur;
	}

	@Column(name = "DAC_BAILLEUR", length = 1)
	public String getDacBailleur() {
		return this.dacBailleur;
	}

	public void setDacBailleur(String dacBailleur) {
		this.dacBailleur = dacBailleur;
	}

	@Column(name = "DAC_COUT", precision = 11, scale = 0)
	public Long getDacCout() {
		return this.dacCout;
	}

	public void setDacCout(Long dacCout) {
		this.dacCout = dacCout;
	}

	@Column(name = "DAC_TYPE_PLAN", length = 4)
	public String getDacTypePlan() {
		return this.dacTypePlan;
	}

	public void setDacTypePlan(String dacTypePlan) {
		this.dacTypePlan = dacTypePlan;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TDacSpecs")
	public Set<TAvisAppelOffre> getTAvisAppelOffres() {
		return this.TAvisAppelOffres;
	}

	public void setTAvisAppelOffres(Set<TAvisAppelOffre> TAvisAppelOffres) {
		this.TAvisAppelOffres = TAvisAppelOffres;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TDacSpecs")
	public Set<TCommissionSpecifique> getTCommissionSpecifiques() {
		return this.TCommissionSpecifiques;
	}

	public void setTCommissionSpecifiques(Set<TCommissionSpecifique> TCommissionSpecifiques) {
		this.TCommissionSpecifiques = TCommissionSpecifiques;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TDacSpecs")
	public Set<TDetailVente> getTDetailVentes() {
		return this.TDetailVentes;
	}

	public void setTDetailVentes(Set<TDetailVente> TDetailVentes) {
		this.TDetailVentes = TDetailVentes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TDacSpecs")
	public Set<TOffres> getTOffreses() {
		return this.TOffreses;
	}

	public void setTOffreses(Set<TOffres> TOffreses) {
		this.TOffreses = TOffreses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TDacSpecs")
	public Set<TAffichageDao> getTAffichageDaos() {
		return this.TAffichageDaos;
	}

	public void setTAffichageDaos(Set<TAffichageDao> TAffichageDaos) {
		this.TAffichageDaos = TAffichageDaos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TDacSpecs")
	public Set<TPiecesOffres> getTPiecesOffreses() {
		return this.TPiecesOffreses;
	}

	public void setTPiecesOffreses(Set<TPiecesOffres> TPiecesOffreses) {
		this.TPiecesOffreses = TPiecesOffreses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TDacSpecs")
	public Set<TCorrectionDac> getTCorrectionDacs() {
		return this.TCorrectionDacs;
	}

	public void setTCorrectionDacs(Set<TCorrectionDac> TCorrectionDacs) {
		this.TCorrectionDacs = TCorrectionDacs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TDacSpecs")
	public Set<TDetailAvis> getTDetailAvises() {
		return this.TDetailAvises;
	}

	public void setTDetailAvises(Set<TDetailAvis> TDetailAvises) {
		this.TDetailAvises = TDetailAvises;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TDacSpecs")
	public Set<TOffrePieceDac> getTOffrePieceDacs() {
		return this.TOffrePieceDacs;
	}

	public void setTOffrePieceDacs(Set<TOffrePieceDac> TOffrePieceDacs) {
		this.TOffrePieceDacs = TOffrePieceDacs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TDacSpecs")
	public Set<THistoDac> getTHistoDacs() {
		return this.THistoDacs;
	}

	public void setTHistoDacs(Set<THistoDac> THistoDacs) {
		this.THistoDacs = THistoDacs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TDacSpecs")
	public Set<TDossierDacs> getTDossierDacses() {
		return this.TDossierDacses;
	}

	public void setTDossierDacses(Set<TDossierDacs> TDossierDacses) {
		this.TDossierDacses = TDossierDacses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TDacSpecs")
	public Set<TDetailCorrection> getTDetailCorrections() {
		return this.TDetailCorrections;
	}

	public void setTDetailCorrections(Set<TDetailCorrection> TDetailCorrections) {
		this.TDetailCorrections = TDetailCorrections;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TDacSpecs")
	public Set<TDetailPlanPassation> getTDetailPlanPassations() {
		return this.TDetailPlanPassations;
	}

	public void setTDetailPlanPassations(Set<TDetailPlanPassation> TDetailPlanPassations) {
		this.TDetailPlanPassations = TDetailPlanPassations;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TDacSpecs")
	public Set<TDetailDemandes> getTDetailDemandeses() {
		return this.TDetailDemandeses;
	}

	public void setTDetailDemandeses(Set<TDetailDemandes> TDetailDemandeses) {
		this.TDetailDemandeses = TDetailDemandeses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TDacSpecs")
	public Set<TLotAao> getTLotAaos() {
		return this.TLotAaos;
	}

	public void setTLotAaos(Set<TLotAao> TLotAaos) {
		this.TLotAaos = TLotAaos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TDacSpecs")
	public Set<TPiecesDacs> getTPiecesDacses() {
		return this.TPiecesDacses;
	}

	public void setTPiecesDacses(Set<TPiecesDacs> TPiecesDacses) {
		this.TPiecesDacses = TPiecesDacses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TDacSpecs")
	public Set<TDetCommissionSeance> getTDetCommissionSeances() {
		return this.TDetCommissionSeances;
	}

	public void setTDetCommissionSeances(Set<TDetCommissionSeance> TDetCommissionSeances) {
		this.TDetCommissionSeances = TDetCommissionSeances;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TDacSpecs")
	public Set<TRetrait> getTRetraits() {
		return this.TRetraits;
	}

	public void setTRetraits(Set<TRetrait> TRetraits) {
		this.TRetraits = TRetraits;
	}

}
