package com.sndi.models;
// Generated 26 mars 2020 03:50:59 by Hibernate Tools 4.3.5.Final

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
 * TFonction generated by hbm2java
 */
@Entity
@Table(name = "T_FONCTION", schema = "EMAP")
public class TFonction implements java.io.Serializable {

	private String fonCod;
	private TStructure TStructure;
	private TTypeFonction TTypeFonction;
	private TMinistere TMinistere;
	private TOperateur TOperateur;
	private Date fonDatDeb;
	private Date fonDatFin;
	private String fonLibelle;
	private String fonAdr;
	private String fonTel;
	private String fonFonCod;
	private String fonCourriel;
	private String fonMobil;
	private Date fonDteSaisi;
	private String fonLibelleCrt;
	private String fonCodeDmp;
	private String fonCodePf;
	private String fonLibelleLngDmp;
	private String fonSourceSigmap;
	private Set<THistoAgpm> THistoAgpms = new HashSet<THistoAgpm>(0);
	private Set<TAssignation> TAssignations = new HashSet<TAssignation>(0);
	private Set<TLBudgets> TLBudgetsesForLbgFonCode = new HashSet<TLBudgets>(0);
	private Set<TSeances> TSeanceses = new HashSet<TSeances>(0);
	private Set<TAffichagePgpm> TAffichagePgpms = new HashSet<TAffichagePgpm>(0);
	private Set<TAffichagePpm> TAffichagePpms = new HashSet<TAffichagePpm>(0);
	private Set<TAvisAppelOffre> TAvisAppelOffresForAaoFonCodAc = new HashSet<TAvisAppelOffre>(0);
	private Set<TDemande> TDemandes = new HashSet<TDemande>(0);
	private Set<TLotAao> TLotAaosForLaaFonCodCpmp = new HashSet<TLotAao>(0);
	private Set<THistoPlanGeneral> THistoPlanGenerals = new HashSet<THistoPlanGeneral>(0);
	private Set<TAvisAppelOffre> TAvisAppelOffresForAaoFonCodeCpmp = new HashSet<TAvisAppelOffre>(0);
	private Set<THistoDemande> THistoDemandes = new HashSet<THistoDemande>(0);
	private Set<TAdresseAvis> TAdresseAvises = new HashSet<TAdresseAvis>(0);
	private Set<TDetailCorrection> TDetailCorrections = new HashSet<TDetailCorrection>(0);
	private Set<TPlanGeneral> TPlanGenerals = new HashSet<TPlanGeneral>(0);
	private Set<TLotAao> TLotAaosForLaaFonCodSaisi = new HashSet<TLotAao>(0);
	private Set<TDacSpecs> TDacSpecsesForDacFonCodeCpmp = new HashSet<TDacSpecs>(0);
	private Set<THistoPlanPassation> THistoPlanPassations = new HashSet<THistoPlanPassation>(0);
	private Set<TLBudgets> TLBudgetsesForLbgFonCodeAc = new HashSet<TLBudgets>(0);
	private Set<TAgpm> TAgpms = new HashSet<TAgpm>(0);
	private Set<TAffichageAgpm> TAffichageAgpms = new HashSet<TAffichageAgpm>(0);
	private Set<TRetrait> TRetraits = new HashSet<TRetrait>(0);
	private Set<THistoDac> THistoDacs = new HashSet<THistoDac>(0);
	private Set<TDetOffres> TDetOffreses = new HashSet<TDetOffres>(0);
	private Set<TDacSpecs> TDacSpecsesForDacFonCodAc = new HashSet<TDacSpecs>(0);
	private Set<TPlanPassation> TPlanPassations = new HashSet<TPlanPassation>(0);

	public TFonction() {
	}

	public TFonction(String fonCod) {
		this.fonCod = fonCod;
	}

	public TFonction(String fonCod, TStructure TStructure, TTypeFonction TTypeFonction, TMinistere TMinistere,
			TOperateur TOperateur, Date fonDatDeb, Date fonDatFin, String fonLibelle, String fonAdr, String fonTel,
			String fonFonCod, String fonCourriel, String fonMobil, Date fonDteSaisi, String fonLibelleCrt,
			String fonCodeDmp, String fonCodePf, String fonLibelleLngDmp, String fonSourceSigmap,
			Set<THistoAgpm> THistoAgpms, Set<TAssignation> TAssignations, Set<TLBudgets> TLBudgetsesForLbgFonCode,
			Set<TSeances> TSeanceses, Set<TAffichagePgpm> TAffichagePgpms, Set<TAffichagePpm> TAffichagePpms,
			Set<TAvisAppelOffre> TAvisAppelOffresForAaoFonCodAc, Set<TDemande> TDemandes,
			Set<TLotAao> TLotAaosForLaaFonCodCpmp, Set<THistoPlanGeneral> THistoPlanGenerals,
			Set<TAvisAppelOffre> TAvisAppelOffresForAaoFonCodeCpmp, Set<THistoDemande> THistoDemandes,
			Set<TAdresseAvis> TAdresseAvises, Set<TDetailCorrection> TDetailCorrections,
			Set<TPlanGeneral> TPlanGenerals, Set<TLotAao> TLotAaosForLaaFonCodSaisi,
			Set<TDacSpecs> TDacSpecsesForDacFonCodeCpmp, Set<THistoPlanPassation> THistoPlanPassations,
			Set<TLBudgets> TLBudgetsesForLbgFonCodeAc, Set<TAgpm> TAgpms, Set<TAffichageAgpm> TAffichageAgpms,
			Set<TRetrait> TRetraits, Set<THistoDac> THistoDacs, Set<TDetOffres> TDetOffreses,
			Set<TDacSpecs> TDacSpecsesForDacFonCodAc, Set<TPlanPassation> TPlanPassations) {
		this.fonCod = fonCod;
		this.TStructure = TStructure;
		this.TTypeFonction = TTypeFonction;
		this.TMinistere = TMinistere;
		this.TOperateur = TOperateur;
		this.fonDatDeb = fonDatDeb;
		this.fonDatFin = fonDatFin;
		this.fonLibelle = fonLibelle;
		this.fonAdr = fonAdr;
		this.fonTel = fonTel;
		this.fonFonCod = fonFonCod;
		this.fonCourriel = fonCourriel;
		this.fonMobil = fonMobil;
		this.fonDteSaisi = fonDteSaisi;
		this.fonLibelleCrt = fonLibelleCrt;
		this.fonCodeDmp = fonCodeDmp;
		this.fonCodePf = fonCodePf;
		this.fonLibelleLngDmp = fonLibelleLngDmp;
		this.fonSourceSigmap = fonSourceSigmap;
		this.THistoAgpms = THistoAgpms;
		this.TAssignations = TAssignations;
		this.TLBudgetsesForLbgFonCode = TLBudgetsesForLbgFonCode;
		this.TSeanceses = TSeanceses;
		this.TAffichagePgpms = TAffichagePgpms;
		this.TAffichagePpms = TAffichagePpms;
		this.TAvisAppelOffresForAaoFonCodAc = TAvisAppelOffresForAaoFonCodAc;
		this.TDemandes = TDemandes;
		this.TLotAaosForLaaFonCodCpmp = TLotAaosForLaaFonCodCpmp;
		this.THistoPlanGenerals = THistoPlanGenerals;
		this.TAvisAppelOffresForAaoFonCodeCpmp = TAvisAppelOffresForAaoFonCodeCpmp;
		this.THistoDemandes = THistoDemandes;
		this.TAdresseAvises = TAdresseAvises;
		this.TDetailCorrections = TDetailCorrections;
		this.TPlanGenerals = TPlanGenerals;
		this.TLotAaosForLaaFonCodSaisi = TLotAaosForLaaFonCodSaisi;
		this.TDacSpecsesForDacFonCodeCpmp = TDacSpecsesForDacFonCodeCpmp;
		this.THistoPlanPassations = THistoPlanPassations;
		this.TLBudgetsesForLbgFonCodeAc = TLBudgetsesForLbgFonCodeAc;
		this.TAgpms = TAgpms;
		this.TAffichageAgpms = TAffichageAgpms;
		this.TRetraits = TRetraits;
		this.THistoDacs = THistoDacs;
		this.TDetOffreses = TDetOffreses;
		this.TDacSpecsesForDacFonCodAc = TDacSpecsesForDacFonCodAc;
		this.TPlanPassations = TPlanPassations;
	}

	@Id

	@Column(name = "FON_COD", unique = true, nullable = false, length = 20)
	public String getFonCod() {
		return this.fonCod;
	}

	public void setFonCod(String fonCod) {
		this.fonCod = fonCod;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FON_STR_CODE")
	public TStructure getTStructure() {
		return this.TStructure;
	}

	public void setTStructure(TStructure TStructure) {
		this.TStructure = TStructure;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FON_TYF_COD")
	public TTypeFonction getTTypeFonction() {
		return this.TTypeFonction;
	}

	public void setTTypeFonction(TTypeFonction TTypeFonction) {
		this.TTypeFonction = TTypeFonction;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FON_MIN_CODE")
	public TMinistere getTMinistere() {
		return this.TMinistere;
	}

	public void setTMinistere(TMinistere TMinistere) {
		this.TMinistere = TMinistere;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FON_OPE_MATRICULE")
	public TOperateur getTOperateur() {
		return this.TOperateur;
	}

	public void setTOperateur(TOperateur TOperateur) {
		this.TOperateur = TOperateur;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "FON_DAT_DEB", length = 7)
	public Date getFonDatDeb() {
		return this.fonDatDeb;
	}

	public void setFonDatDeb(Date fonDatDeb) {
		this.fonDatDeb = fonDatDeb;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "FON_DAT_FIN", length = 7)
	public Date getFonDatFin() {
		return this.fonDatFin;
	}

	public void setFonDatFin(Date fonDatFin) {
		this.fonDatFin = fonDatFin;
	}

	@Column(name = "FON_LIBELLE", length = 500)
	public String getFonLibelle() {
		return this.fonLibelle;
	}

	public void setFonLibelle(String fonLibelle) {
		this.fonLibelle = fonLibelle;
	}

	@Column(name = "FON_ADR", length = 240)
	public String getFonAdr() {
		return this.fonAdr;
	}

	public void setFonAdr(String fonAdr) {
		this.fonAdr = fonAdr;
	}

	@Column(name = "FON_TEL", length = 240)
	public String getFonTel() {
		return this.fonTel;
	}

	public void setFonTel(String fonTel) {
		this.fonTel = fonTel;
	}

	@Column(name = "FON_FON_COD", length = 12)
	public String getFonFonCod() {
		return this.fonFonCod;
	}

	public void setFonFonCod(String fonFonCod) {
		this.fonFonCod = fonFonCod;
	}

	@Column(name = "FON_COURRIEL", length = 100)
	public String getFonCourriel() {
		return this.fonCourriel;
	}

	public void setFonCourriel(String fonCourriel) {
		this.fonCourriel = fonCourriel;
	}

	@Column(name = "FON_MOBIL", length = 20)
	public String getFonMobil() {
		return this.fonMobil;
	}

	public void setFonMobil(String fonMobil) {
		this.fonMobil = fonMobil;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "FON_DTE_SAISI", length = 7)
	public Date getFonDteSaisi() {
		return this.fonDteSaisi;
	}

	public void setFonDteSaisi(Date fonDteSaisi) {
		this.fonDteSaisi = fonDteSaisi;
	}

	@Column(name = "FON_LIBELLE_CRT", length = 500)
	public String getFonLibelleCrt() {
		return this.fonLibelleCrt;
	}

	public void setFonLibelleCrt(String fonLibelleCrt) {
		this.fonLibelleCrt = fonLibelleCrt;
	}

	@Column(name = "FON_CODE_DMP", length = 20)
	public String getFonCodeDmp() {
		return this.fonCodeDmp;
	}

	public void setFonCodeDmp(String fonCodeDmp) {
		this.fonCodeDmp = fonCodeDmp;
	}

	@Column(name = "FON_CODE_PF", length = 20)
	public String getFonCodePf() {
		return this.fonCodePf;
	}

	public void setFonCodePf(String fonCodePf) {
		this.fonCodePf = fonCodePf;
	}

	@Column(name = "FON_LIBELLE_LNG_DMP", length = 500)
	public String getFonLibelleLngDmp() {
		return this.fonLibelleLngDmp;
	}

	public void setFonLibelleLngDmp(String fonLibelleLngDmp) {
		this.fonLibelleLngDmp = fonLibelleLngDmp;
	}

	@Column(name = "FON_SOURCE_SIGMAP", length = 1)
	public String getFonSourceSigmap() {
		return this.fonSourceSigmap;
	}

	public void setFonSourceSigmap(String fonSourceSigmap) {
		this.fonSourceSigmap = fonSourceSigmap;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TFonction")
	public Set<THistoAgpm> getTHistoAgpms() {
		return this.THistoAgpms;
	}

	public void setTHistoAgpms(Set<THistoAgpm> THistoAgpms) {
		this.THistoAgpms = THistoAgpms;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TFonction")
	public Set<TAssignation> getTAssignations() {
		return this.TAssignations;
	}

	public void setTAssignations(Set<TAssignation> TAssignations) {
		this.TAssignations = TAssignations;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TFonctionByLbgFonCode")
	public Set<TLBudgets> getTLBudgetsesForLbgFonCode() {
		return this.TLBudgetsesForLbgFonCode;
	}

	public void setTLBudgetsesForLbgFonCode(Set<TLBudgets> TLBudgetsesForLbgFonCode) {
		this.TLBudgetsesForLbgFonCode = TLBudgetsesForLbgFonCode;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TFonction")
	public Set<TSeances> getTSeanceses() {
		return this.TSeanceses;
	}

	public void setTSeanceses(Set<TSeances> TSeanceses) {
		this.TSeanceses = TSeanceses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TFonction")
	public Set<TAffichagePgpm> getTAffichagePgpms() {
		return this.TAffichagePgpms;
	}

	public void setTAffichagePgpms(Set<TAffichagePgpm> TAffichagePgpms) {
		this.TAffichagePgpms = TAffichagePgpms;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TFonction")
	public Set<TAffichagePpm> getTAffichagePpms() {
		return this.TAffichagePpms;
	}

	public void setTAffichagePpms(Set<TAffichagePpm> TAffichagePpms) {
		this.TAffichagePpms = TAffichagePpms;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TFonctionByAaoFonCodAc")
	public Set<TAvisAppelOffre> getTAvisAppelOffresForAaoFonCodAc() {
		return this.TAvisAppelOffresForAaoFonCodAc;
	}

	public void setTAvisAppelOffresForAaoFonCodAc(Set<TAvisAppelOffre> TAvisAppelOffresForAaoFonCodAc) {
		this.TAvisAppelOffresForAaoFonCodAc = TAvisAppelOffresForAaoFonCodAc;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TFonction")
	public Set<TDemande> getTDemandes() {
		return this.TDemandes;
	}

	public void setTDemandes(Set<TDemande> TDemandes) {
		this.TDemandes = TDemandes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TFonctionByLaaFonCodCpmp")
	public Set<TLotAao> getTLotAaosForLaaFonCodCpmp() {
		return this.TLotAaosForLaaFonCodCpmp;
	}

	public void setTLotAaosForLaaFonCodCpmp(Set<TLotAao> TLotAaosForLaaFonCodCpmp) {
		this.TLotAaosForLaaFonCodCpmp = TLotAaosForLaaFonCodCpmp;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TFonction")
	public Set<THistoPlanGeneral> getTHistoPlanGenerals() {
		return this.THistoPlanGenerals;
	}

	public void setTHistoPlanGenerals(Set<THistoPlanGeneral> THistoPlanGenerals) {
		this.THistoPlanGenerals = THistoPlanGenerals;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TFonctionByAaoFonCodeCpmp")
	public Set<TAvisAppelOffre> getTAvisAppelOffresForAaoFonCodeCpmp() {
		return this.TAvisAppelOffresForAaoFonCodeCpmp;
	}

	public void setTAvisAppelOffresForAaoFonCodeCpmp(Set<TAvisAppelOffre> TAvisAppelOffresForAaoFonCodeCpmp) {
		this.TAvisAppelOffresForAaoFonCodeCpmp = TAvisAppelOffresForAaoFonCodeCpmp;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TFonction")
	public Set<THistoDemande> getTHistoDemandes() {
		return this.THistoDemandes;
	}

	public void setTHistoDemandes(Set<THistoDemande> THistoDemandes) {
		this.THistoDemandes = THistoDemandes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TFonction")
	public Set<TAdresseAvis> getTAdresseAvises() {
		return this.TAdresseAvises;
	}

	public void setTAdresseAvises(Set<TAdresseAvis> TAdresseAvises) {
		this.TAdresseAvises = TAdresseAvises;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TFonction")
	public Set<TDetailCorrection> getTDetailCorrections() {
		return this.TDetailCorrections;
	}

	public void setTDetailCorrections(Set<TDetailCorrection> TDetailCorrections) {
		this.TDetailCorrections = TDetailCorrections;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TFonction")
	public Set<TPlanGeneral> getTPlanGenerals() {
		return this.TPlanGenerals;
	}

	public void setTPlanGenerals(Set<TPlanGeneral> TPlanGenerals) {
		this.TPlanGenerals = TPlanGenerals;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TFonctionByLaaFonCodSaisi")
	public Set<TLotAao> getTLotAaosForLaaFonCodSaisi() {
		return this.TLotAaosForLaaFonCodSaisi;
	}

	public void setTLotAaosForLaaFonCodSaisi(Set<TLotAao> TLotAaosForLaaFonCodSaisi) {
		this.TLotAaosForLaaFonCodSaisi = TLotAaosForLaaFonCodSaisi;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TFonctionByDacFonCodeCpmp")
	public Set<TDacSpecs> getTDacSpecsesForDacFonCodeCpmp() {
		return this.TDacSpecsesForDacFonCodeCpmp;
	}

	public void setTDacSpecsesForDacFonCodeCpmp(Set<TDacSpecs> TDacSpecsesForDacFonCodeCpmp) {
		this.TDacSpecsesForDacFonCodeCpmp = TDacSpecsesForDacFonCodeCpmp;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TFonction")
	public Set<THistoPlanPassation> getTHistoPlanPassations() {
		return this.THistoPlanPassations;
	}

	public void setTHistoPlanPassations(Set<THistoPlanPassation> THistoPlanPassations) {
		this.THistoPlanPassations = THistoPlanPassations;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TFonctionByLbgFonCodeAc")
	public Set<TLBudgets> getTLBudgetsesForLbgFonCodeAc() {
		return this.TLBudgetsesForLbgFonCodeAc;
	}

	public void setTLBudgetsesForLbgFonCodeAc(Set<TLBudgets> TLBudgetsesForLbgFonCodeAc) {
		this.TLBudgetsesForLbgFonCodeAc = TLBudgetsesForLbgFonCodeAc;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TFonction")
	public Set<TAgpm> getTAgpms() {
		return this.TAgpms;
	}

	public void setTAgpms(Set<TAgpm> TAgpms) {
		this.TAgpms = TAgpms;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TFonction")
	public Set<TAffichageAgpm> getTAffichageAgpms() {
		return this.TAffichageAgpms;
	}

	public void setTAffichageAgpms(Set<TAffichageAgpm> TAffichageAgpms) {
		this.TAffichageAgpms = TAffichageAgpms;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TFonction")
	public Set<TRetrait> getTRetraits() {
		return this.TRetraits;
	}

	public void setTRetraits(Set<TRetrait> TRetraits) {
		this.TRetraits = TRetraits;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TFonction")
	public Set<THistoDac> getTHistoDacs() {
		return this.THistoDacs;
	}

	public void setTHistoDacs(Set<THistoDac> THistoDacs) {
		this.THistoDacs = THistoDacs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TFonction")
	public Set<TDetOffres> getTDetOffreses() {
		return this.TDetOffreses;
	}

	public void setTDetOffreses(Set<TDetOffres> TDetOffreses) {
		this.TDetOffreses = TDetOffreses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TFonctionByDacFonCodAc")
	public Set<TDacSpecs> getTDacSpecsesForDacFonCodAc() {
		return this.TDacSpecsesForDacFonCodAc;
	}

	public void setTDacSpecsesForDacFonCodAc(Set<TDacSpecs> TDacSpecsesForDacFonCodAc) {
		this.TDacSpecsesForDacFonCodAc = TDacSpecsesForDacFonCodAc;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TFonction")
	public Set<TPlanPassation> getTPlanPassations() {
		return this.TPlanPassations;
	}

	public void setTPlanPassations(Set<TPlanPassation> TPlanPassations) {
		this.TPlanPassations = TPlanPassations;
	}

}
