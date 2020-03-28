package com.sndi.models;
// Generated 28 mars 2020 15:50:26 by Hibernate Tools 4.3.5.Final

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
import javax.persistence.UniqueConstraint;

/**
 * TOperateur generated by hbm2java
 */
@Entity
@Table(name = "T_OPERATEUR", schema = "EMAP", uniqueConstraints = @UniqueConstraint(columnNames = "OPE_LOGIN"))
public class TOperateur implements java.io.Serializable {

	private String opeMatricule;
	private TStructure TStructure;
	private String opeNom;
	private String opeContact;
	private String opeEtatCivil;
	private String opeMail;
	private String opeLogin;
	private String opeMinCode;
	private String opeFonctionAdminist;
	private Set<TRetrait> TRetraits = new HashSet<TRetrait>(0);
	private Set<THistoDemande> THistoDemandes = new HashSet<THistoDemande>(0);
	private Set<TVenteDac> TVenteDacs = new HashSet<TVenteDac>(0);
	private Set<TOffres> TOffreses = new HashSet<TOffres>(0);
	private Set<THistoDac> THistoDacs = new HashSet<THistoDac>(0);
	private Set<TDetOffres> TDetOffreses = new HashSet<TDetOffres>(0);
	private Set<TPiecesOffres> TPiecesOffreses = new HashSet<TPiecesOffres>(0);
	private Set<TTiers> TTierses = new HashSet<TTiers>(0);
	private Set<TFonction> TFonctions = new HashSet<TFonction>(0);
	private Set<TModeleDacType> TModeleDacTypes = new HashSet<TModeleDacType>(0);
	private Set<TNatures> TNatureses = new HashSet<TNatures>(0);
	private Set<TDestinations> TDestinationses = new HashSet<TDestinations>(0);
	private Set<THistoPlanPassation> THistoPlanPassations = new HashSet<THistoPlanPassation>(0);
	private Set<TMotdepasse> TMotdepasses = new HashSet<TMotdepasse>(0);
	private Set<TAssignation> TAssignations = new HashSet<TAssignation>(0);
	private Set<TSeances> TSeanceses = new HashSet<TSeances>(0);
	private Set<TTypeDemande> TTypeDemandes = new HashSet<TTypeDemande>(0);
	private Set<THistoPlanGeneral> THistoPlanGenerals = new HashSet<THistoPlanGeneral>(0);
	private Set<TModeReglement> TModeReglements = new HashSet<TModeReglement>(0);
	private Set<TTempParametre> TTempParametres = new HashSet<TTempParametre>(0);
	private Set<TTypeSeance> TTypeSeances = new HashSet<TTypeSeance>(0);
	private Set<TTypeFonction> TTypeFonctions = new HashSet<TTypeFonction>(0);
	private Set<THistoAgpm> THistoAgpms = new HashSet<THistoAgpm>(0);
	private Set<TTypeCommission> TTypeCommissions = new HashSet<TTypeCommission>(0);
	private Set<TTypePieceOffre> TTypePieceOffres = new HashSet<TTypePieceOffre>(0);
	private Set<TAvisPresel> TAvisPreselsForAprOpeMatricule = new HashSet<TAvisPresel>(0);
	private Set<TDemande> TDemandes = new HashSet<TDemande>(0);
	private Set<TDetCommissionSeance> TDetCommissionSeances = new HashSet<TDetCommissionSeance>(0);
	private Set<TDetailCorrection> TDetailCorrections = new HashSet<TDetailCorrection>(0);
	private Set<TSoumissions> TSoumissionses = new HashSet<TSoumissions>(0);
	private Set<TCommissionType> TCommissionTypes = new HashSet<TCommissionType>(0);
	private Set<TAvisPresel> TAvisPreselsForAprOpeMatMotif = new HashSet<TAvisPresel>(0);
	private Set<TTempParam> TTempParams = new HashSet<TTempParam>(0);

	public TOperateur() {
	}

	public TOperateur(String opeMatricule) {
		this.opeMatricule = opeMatricule;
	}

	public TOperateur(String opeMatricule, TStructure TStructure, String opeNom, String opeContact, String opeEtatCivil,
			String opeMail, String opeLogin, String opeMinCode, String opeFonctionAdminist, Set<TRetrait> TRetraits,
			Set<THistoDemande> THistoDemandes, Set<TVenteDac> TVenteDacs, Set<TOffres> TOffreses,
			Set<THistoDac> THistoDacs, Set<TDetOffres> TDetOffreses, Set<TPiecesOffres> TPiecesOffreses,
			Set<TTiers> TTierses, Set<TFonction> TFonctions, Set<TModeleDacType> TModeleDacTypes,
			Set<TNatures> TNatureses, Set<TDestinations> TDestinationses, Set<THistoPlanPassation> THistoPlanPassations,
			Set<TMotdepasse> TMotdepasses, Set<TAssignation> TAssignations, Set<TSeances> TSeanceses,
			Set<TTypeDemande> TTypeDemandes, Set<THistoPlanGeneral> THistoPlanGenerals,
			Set<TModeReglement> TModeReglements, Set<TTempParametre> TTempParametres, Set<TTypeSeance> TTypeSeances,
			Set<TTypeFonction> TTypeFonctions, Set<THistoAgpm> THistoAgpms, Set<TTypeCommission> TTypeCommissions,
			Set<TTypePieceOffre> TTypePieceOffres, Set<TAvisPresel> TAvisPreselsForAprOpeMatricule,
			Set<TDemande> TDemandes, Set<TDetCommissionSeance> TDetCommissionSeances,
			Set<TDetailCorrection> TDetailCorrections, Set<TSoumissions> TSoumissionses,
			Set<TCommissionType> TCommissionTypes, Set<TAvisPresel> TAvisPreselsForAprOpeMatMotif,
			Set<TTempParam> TTempParams) {
		this.opeMatricule = opeMatricule;
		this.TStructure = TStructure;
		this.opeNom = opeNom;
		this.opeContact = opeContact;
		this.opeEtatCivil = opeEtatCivil;
		this.opeMail = opeMail;
		this.opeLogin = opeLogin;
		this.opeMinCode = opeMinCode;
		this.opeFonctionAdminist = opeFonctionAdminist;
		this.TRetraits = TRetraits;
		this.THistoDemandes = THistoDemandes;
		this.TVenteDacs = TVenteDacs;
		this.TOffreses = TOffreses;
		this.THistoDacs = THistoDacs;
		this.TDetOffreses = TDetOffreses;
		this.TPiecesOffreses = TPiecesOffreses;
		this.TTierses = TTierses;
		this.TFonctions = TFonctions;
		this.TModeleDacTypes = TModeleDacTypes;
		this.TNatureses = TNatureses;
		this.TDestinationses = TDestinationses;
		this.THistoPlanPassations = THistoPlanPassations;
		this.TMotdepasses = TMotdepasses;
		this.TAssignations = TAssignations;
		this.TSeanceses = TSeanceses;
		this.TTypeDemandes = TTypeDemandes;
		this.THistoPlanGenerals = THistoPlanGenerals;
		this.TModeReglements = TModeReglements;
		this.TTempParametres = TTempParametres;
		this.TTypeSeances = TTypeSeances;
		this.TTypeFonctions = TTypeFonctions;
		this.THistoAgpms = THistoAgpms;
		this.TTypeCommissions = TTypeCommissions;
		this.TTypePieceOffres = TTypePieceOffres;
		this.TAvisPreselsForAprOpeMatricule = TAvisPreselsForAprOpeMatricule;
		this.TDemandes = TDemandes;
		this.TDetCommissionSeances = TDetCommissionSeances;
		this.TDetailCorrections = TDetailCorrections;
		this.TSoumissionses = TSoumissionses;
		this.TCommissionTypes = TCommissionTypes;
		this.TAvisPreselsForAprOpeMatMotif = TAvisPreselsForAprOpeMatMotif;
		this.TTempParams = TTempParams;
	}

	@Id

	@Column(name = "OPE_MATRICULE", unique = true, nullable = false, length = 25)
	public String getOpeMatricule() {
		return this.opeMatricule;
	}

	public void setOpeMatricule(String opeMatricule) {
		this.opeMatricule = opeMatricule;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OPE_STR_CODE")
	public TStructure getTStructure() {
		return this.TStructure;
	}

	public void setTStructure(TStructure TStructure) {
		this.TStructure = TStructure;
	}

	@Column(name = "OPE_NOM")
	public String getOpeNom() {
		return this.opeNom;
	}

	public void setOpeNom(String opeNom) {
		this.opeNom = opeNom;
	}

	@Column(name = "OPE_CONTACT", length = 250)
	public String getOpeContact() {
		return this.opeContact;
	}

	public void setOpeContact(String opeContact) {
		this.opeContact = opeContact;
	}

	@Column(name = "OPE_ETAT_CIVIL", length = 250)
	public String getOpeEtatCivil() {
		return this.opeEtatCivil;
	}

	public void setOpeEtatCivil(String opeEtatCivil) {
		this.opeEtatCivil = opeEtatCivil;
	}

	@Column(name = "OPE_MAIL", length = 250)
	public String getOpeMail() {
		return this.opeMail;
	}

	public void setOpeMail(String opeMail) {
		this.opeMail = opeMail;
	}

	@Column(name = "OPE_LOGIN", unique = true, length = 50)
	public String getOpeLogin() {
		return this.opeLogin;
	}

	public void setOpeLogin(String opeLogin) {
		this.opeLogin = opeLogin;
	}

	@Column(name = "OPE_MIN_CODE", length = 3)
	public String getOpeMinCode() {
		return this.opeMinCode;
	}

	public void setOpeMinCode(String opeMinCode) {
		this.opeMinCode = opeMinCode;
	}

	@Column(name = "OPE_FONCTION_ADMINIST", length = 500)
	public String getOpeFonctionAdminist() {
		return this.opeFonctionAdminist;
	}

	public void setOpeFonctionAdminist(String opeFonctionAdminist) {
		this.opeFonctionAdminist = opeFonctionAdminist;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TOperateur")
	public Set<TRetrait> getTRetraits() {
		return this.TRetraits;
	}

	public void setTRetraits(Set<TRetrait> TRetraits) {
		this.TRetraits = TRetraits;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TOperateur")
	public Set<THistoDemande> getTHistoDemandes() {
		return this.THistoDemandes;
	}

	public void setTHistoDemandes(Set<THistoDemande> THistoDemandes) {
		this.THistoDemandes = THistoDemandes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TOperateur")
	public Set<TVenteDac> getTVenteDacs() {
		return this.TVenteDacs;
	}

	public void setTVenteDacs(Set<TVenteDac> TVenteDacs) {
		this.TVenteDacs = TVenteDacs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TOperateur")
	public Set<TOffres> getTOffreses() {
		return this.TOffreses;
	}

	public void setTOffreses(Set<TOffres> TOffreses) {
		this.TOffreses = TOffreses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TOperateur")
	public Set<THistoDac> getTHistoDacs() {
		return this.THistoDacs;
	}

	public void setTHistoDacs(Set<THistoDac> THistoDacs) {
		this.THistoDacs = THistoDacs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TOperateur")
	public Set<TDetOffres> getTDetOffreses() {
		return this.TDetOffreses;
	}

	public void setTDetOffreses(Set<TDetOffres> TDetOffreses) {
		this.TDetOffreses = TDetOffreses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TOperateur")
	public Set<TPiecesOffres> getTPiecesOffreses() {
		return this.TPiecesOffreses;
	}

	public void setTPiecesOffreses(Set<TPiecesOffres> TPiecesOffreses) {
		this.TPiecesOffreses = TPiecesOffreses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TOperateur")
	public Set<TTiers> getTTierses() {
		return this.TTierses;
	}

	public void setTTierses(Set<TTiers> TTierses) {
		this.TTierses = TTierses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TOperateur")
	public Set<TFonction> getTFonctions() {
		return this.TFonctions;
	}

	public void setTFonctions(Set<TFonction> TFonctions) {
		this.TFonctions = TFonctions;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TOperateur")
	public Set<TModeleDacType> getTModeleDacTypes() {
		return this.TModeleDacTypes;
	}

	public void setTModeleDacTypes(Set<TModeleDacType> TModeleDacTypes) {
		this.TModeleDacTypes = TModeleDacTypes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TOperateur")
	public Set<TNatures> getTNatureses() {
		return this.TNatureses;
	}

	public void setTNatureses(Set<TNatures> TNatureses) {
		this.TNatureses = TNatureses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TOperateur")
	public Set<TDestinations> getTDestinationses() {
		return this.TDestinationses;
	}

	public void setTDestinationses(Set<TDestinations> TDestinationses) {
		this.TDestinationses = TDestinationses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TOperateur")
	public Set<THistoPlanPassation> getTHistoPlanPassations() {
		return this.THistoPlanPassations;
	}

	public void setTHistoPlanPassations(Set<THistoPlanPassation> THistoPlanPassations) {
		this.THistoPlanPassations = THistoPlanPassations;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TOperateur")
	public Set<TMotdepasse> getTMotdepasses() {
		return this.TMotdepasses;
	}

	public void setTMotdepasses(Set<TMotdepasse> TMotdepasses) {
		this.TMotdepasses = TMotdepasses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TOperateur")
	public Set<TAssignation> getTAssignations() {
		return this.TAssignations;
	}

	public void setTAssignations(Set<TAssignation> TAssignations) {
		this.TAssignations = TAssignations;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TOperateur")
	public Set<TSeances> getTSeanceses() {
		return this.TSeanceses;
	}

	public void setTSeanceses(Set<TSeances> TSeanceses) {
		this.TSeanceses = TSeanceses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TOperateur")
	public Set<TTypeDemande> getTTypeDemandes() {
		return this.TTypeDemandes;
	}

	public void setTTypeDemandes(Set<TTypeDemande> TTypeDemandes) {
		this.TTypeDemandes = TTypeDemandes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TOperateur")
	public Set<THistoPlanGeneral> getTHistoPlanGenerals() {
		return this.THistoPlanGenerals;
	}

	public void setTHistoPlanGenerals(Set<THistoPlanGeneral> THistoPlanGenerals) {
		this.THistoPlanGenerals = THistoPlanGenerals;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TOperateur")
	public Set<TModeReglement> getTModeReglements() {
		return this.TModeReglements;
	}

	public void setTModeReglements(Set<TModeReglement> TModeReglements) {
		this.TModeReglements = TModeReglements;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TOperateur")
	public Set<TTempParametre> getTTempParametres() {
		return this.TTempParametres;
	}

	public void setTTempParametres(Set<TTempParametre> TTempParametres) {
		this.TTempParametres = TTempParametres;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TOperateur")
	public Set<TTypeSeance> getTTypeSeances() {
		return this.TTypeSeances;
	}

	public void setTTypeSeances(Set<TTypeSeance> TTypeSeances) {
		this.TTypeSeances = TTypeSeances;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TOperateur")
	public Set<TTypeFonction> getTTypeFonctions() {
		return this.TTypeFonctions;
	}

	public void setTTypeFonctions(Set<TTypeFonction> TTypeFonctions) {
		this.TTypeFonctions = TTypeFonctions;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TOperateur")
	public Set<THistoAgpm> getTHistoAgpms() {
		return this.THistoAgpms;
	}

	public void setTHistoAgpms(Set<THistoAgpm> THistoAgpms) {
		this.THistoAgpms = THistoAgpms;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TOperateur")
	public Set<TTypeCommission> getTTypeCommissions() {
		return this.TTypeCommissions;
	}

	public void setTTypeCommissions(Set<TTypeCommission> TTypeCommissions) {
		this.TTypeCommissions = TTypeCommissions;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TOperateur")
	public Set<TTypePieceOffre> getTTypePieceOffres() {
		return this.TTypePieceOffres;
	}

	public void setTTypePieceOffres(Set<TTypePieceOffre> TTypePieceOffres) {
		this.TTypePieceOffres = TTypePieceOffres;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TOperateurByAprOpeMatricule")
	public Set<TAvisPresel> getTAvisPreselsForAprOpeMatricule() {
		return this.TAvisPreselsForAprOpeMatricule;
	}

	public void setTAvisPreselsForAprOpeMatricule(Set<TAvisPresel> TAvisPreselsForAprOpeMatricule) {
		this.TAvisPreselsForAprOpeMatricule = TAvisPreselsForAprOpeMatricule;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TOperateur")
	public Set<TDemande> getTDemandes() {
		return this.TDemandes;
	}

	public void setTDemandes(Set<TDemande> TDemandes) {
		this.TDemandes = TDemandes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TOperateur")
	public Set<TDetCommissionSeance> getTDetCommissionSeances() {
		return this.TDetCommissionSeances;
	}

	public void setTDetCommissionSeances(Set<TDetCommissionSeance> TDetCommissionSeances) {
		this.TDetCommissionSeances = TDetCommissionSeances;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TOperateur")
	public Set<TDetailCorrection> getTDetailCorrections() {
		return this.TDetailCorrections;
	}

	public void setTDetailCorrections(Set<TDetailCorrection> TDetailCorrections) {
		this.TDetailCorrections = TDetailCorrections;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TOperateur")
	public Set<TSoumissions> getTSoumissionses() {
		return this.TSoumissionses;
	}

	public void setTSoumissionses(Set<TSoumissions> TSoumissionses) {
		this.TSoumissionses = TSoumissionses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TOperateur")
	public Set<TCommissionType> getTCommissionTypes() {
		return this.TCommissionTypes;
	}

	public void setTCommissionTypes(Set<TCommissionType> TCommissionTypes) {
		this.TCommissionTypes = TCommissionTypes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TOperateurByAprOpeMatMotif")
	public Set<TAvisPresel> getTAvisPreselsForAprOpeMatMotif() {
		return this.TAvisPreselsForAprOpeMatMotif;
	}

	public void setTAvisPreselsForAprOpeMatMotif(Set<TAvisPresel> TAvisPreselsForAprOpeMatMotif) {
		this.TAvisPreselsForAprOpeMatMotif = TAvisPreselsForAprOpeMatMotif;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TOperateur")
	public Set<TTempParam> getTTempParams() {
		return this.TTempParams;
	}

	public void setTTempParams(Set<TTempParam> TTempParams) {
		this.TTempParams = TTempParams;
	}

}
