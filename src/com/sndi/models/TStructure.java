package com.sndi.models;
// Generated 28 mars 2020 03:24:07 by Hibernate Tools 4.3.5.Final

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
 * TStructure generated by hbm2java
 */
@Entity
@Table(name = "T_STRUCTURE", schema = "EMAP")
public class TStructure implements java.io.Serializable {

	private String strCode;
	private TRegion TRegion;
	private TTypeStructure TTypeStructure;
	private TMinistere TMinistere;
	private String strLibelleCourt;
	private String strLibelleLong;
	private String strAdresse;
	private String strEmail;
	private String strAdrPost;
	private String strAdrGeo;
	private String strTel;
	private String strFax;
	private String strOpeMatricule;
	private Date strDteSaisi;
	private String strOpeRespo;
	private Set<TAgpm> TAgpms = new HashSet<TAgpm>(0);
	private Set<TDetCommissionSeance> TDetCommissionSeances = new HashSet<TDetCommissionSeance>(0);
	private Set<TDacSpecs> TDacSpecses = new HashSet<TDacSpecs>(0);
	private Set<TAffichagePgpm> TAffichagePgpms = new HashSet<TAffichagePgpm>(0);
	private Set<TAffichagePpm> TAffichagePpms = new HashSet<TAffichagePpm>(0);
	private Set<TCharge> TCharges = new HashSet<TCharge>(0);
	private Set<TPlanPassation> TPlanPassations = new HashSet<TPlanPassation>(0);
	private Set<TFonction> TFonctions = new HashSet<TFonction>(0);
	private Set<TCommissionSpecifique> TCommissionSpecifiques = new HashSet<TCommissionSpecifique>(0);
	private Set<TDetailDemandes> TDetailDemandeses = new HashSet<TDetailDemandes>(0);
	private Set<TOperateur> TOperateurs = new HashSet<TOperateur>(0);
	private Set<TAffichageAgpm> TAffichageAgpms = new HashSet<TAffichageAgpm>(0);
	private Set<TDemande> TDemandes = new HashSet<TDemande>(0);
	private Set<TDetailPlanPassation> TDetailPlanPassations = new HashSet<TDetailPlanPassation>(0);
	private Set<TPlanGeneral> TPlanGenerals = new HashSet<TPlanGeneral>(0);
	private Set<TLBudgets> TLBudgetses = new HashSet<TLBudgets>(0);

	public TStructure() {
	}

	public TStructure(String strCode, TMinistere TMinistere, String strLibelleCourt) {
		this.strCode = strCode;
		this.TMinistere = TMinistere;
		this.strLibelleCourt = strLibelleCourt;
	}

	public TStructure(String strCode, TRegion TRegion, TTypeStructure TTypeStructure, TMinistere TMinistere,
			String strLibelleCourt, String strLibelleLong, String strAdresse, String strEmail, String strAdrPost,
			String strAdrGeo, String strTel, String strFax, String strOpeMatricule, Date strDteSaisi,
			String strOpeRespo, Set<TAgpm> TAgpms, Set<TDetCommissionSeance> TDetCommissionSeances,
			Set<TDacSpecs> TDacSpecses, Set<TAffichagePgpm> TAffichagePgpms, Set<TAffichagePpm> TAffichagePpms,
			Set<TCharge> TCharges, Set<TPlanPassation> TPlanPassations, Set<TFonction> TFonctions,
			Set<TCommissionSpecifique> TCommissionSpecifiques, Set<TDetailDemandes> TDetailDemandeses,
			Set<TOperateur> TOperateurs, Set<TAffichageAgpm> TAffichageAgpms, Set<TDemande> TDemandes,
			Set<TDetailPlanPassation> TDetailPlanPassations, Set<TPlanGeneral> TPlanGenerals,
			Set<TLBudgets> TLBudgetses) {
		this.strCode = strCode;
		this.TRegion = TRegion;
		this.TTypeStructure = TTypeStructure;
		this.TMinistere = TMinistere;
		this.strLibelleCourt = strLibelleCourt;
		this.strLibelleLong = strLibelleLong;
		this.strAdresse = strAdresse;
		this.strEmail = strEmail;
		this.strAdrPost = strAdrPost;
		this.strAdrGeo = strAdrGeo;
		this.strTel = strTel;
		this.strFax = strFax;
		this.strOpeMatricule = strOpeMatricule;
		this.strDteSaisi = strDteSaisi;
		this.strOpeRespo = strOpeRespo;
		this.TAgpms = TAgpms;
		this.TDetCommissionSeances = TDetCommissionSeances;
		this.TDacSpecses = TDacSpecses;
		this.TAffichagePgpms = TAffichagePgpms;
		this.TAffichagePpms = TAffichagePpms;
		this.TCharges = TCharges;
		this.TPlanPassations = TPlanPassations;
		this.TFonctions = TFonctions;
		this.TCommissionSpecifiques = TCommissionSpecifiques;
		this.TDetailDemandeses = TDetailDemandeses;
		this.TOperateurs = TOperateurs;
		this.TAffichageAgpms = TAffichageAgpms;
		this.TDemandes = TDemandes;
		this.TDetailPlanPassations = TDetailPlanPassations;
		this.TPlanGenerals = TPlanGenerals;
		this.TLBudgetses = TLBudgetses;
	}

	@Id

	@Column(name = "STR_CODE", unique = true, nullable = false, length = 20)
	public String getStrCode() {
		return this.strCode;
	}

	public void setStrCode(String strCode) {
		this.strCode = strCode;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STR_REG_CODE")
	public TRegion getTRegion() {
		return this.TRegion;
	}

	public void setTRegion(TRegion TRegion) {
		this.TRegion = TRegion;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STR_TST_CODE")
	public TTypeStructure getTTypeStructure() {
		return this.TTypeStructure;
	}

	public void setTTypeStructure(TTypeStructure TTypeStructure) {
		this.TTypeStructure = TTypeStructure;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STR_MIN_CODE", nullable = false)
	public TMinistere getTMinistere() {
		return this.TMinistere;
	}

	public void setTMinistere(TMinistere TMinistere) {
		this.TMinistere = TMinistere;
	}

	@Column(name = "STR_LIBELLE_COURT", nullable = false, length = 500)
	public String getStrLibelleCourt() {
		return this.strLibelleCourt;
	}

	public void setStrLibelleCourt(String strLibelleCourt) {
		this.strLibelleCourt = strLibelleCourt;
	}

	@Column(name = "STR_LIBELLE_LONG", length = 1000)
	public String getStrLibelleLong() {
		return this.strLibelleLong;
	}

	public void setStrLibelleLong(String strLibelleLong) {
		this.strLibelleLong = strLibelleLong;
	}

	@Column(name = "STR_ADRESSE", length = 500)
	public String getStrAdresse() {
		return this.strAdresse;
	}

	public void setStrAdresse(String strAdresse) {
		this.strAdresse = strAdresse;
	}

	@Column(name = "STR_EMAIL", length = 500)
	public String getStrEmail() {
		return this.strEmail;
	}

	public void setStrEmail(String strEmail) {
		this.strEmail = strEmail;
	}

	@Column(name = "STR_ADR_POST", length = 200)
	public String getStrAdrPost() {
		return this.strAdrPost;
	}

	public void setStrAdrPost(String strAdrPost) {
		this.strAdrPost = strAdrPost;
	}

	@Column(name = "STR_ADR_GEO", length = 200)
	public String getStrAdrGeo() {
		return this.strAdrGeo;
	}

	public void setStrAdrGeo(String strAdrGeo) {
		this.strAdrGeo = strAdrGeo;
	}

	@Column(name = "STR_TEL", length = 100)
	public String getStrTel() {
		return this.strTel;
	}

	public void setStrTel(String strTel) {
		this.strTel = strTel;
	}

	@Column(name = "STR_FAX", length = 50)
	public String getStrFax() {
		return this.strFax;
	}

	public void setStrFax(String strFax) {
		this.strFax = strFax;
	}

	@Column(name = "STR_OPE_MATRICULE", length = 25)
	public String getStrOpeMatricule() {
		return this.strOpeMatricule;
	}

	public void setStrOpeMatricule(String strOpeMatricule) {
		this.strOpeMatricule = strOpeMatricule;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "STR_DTE_SAISI", length = 7)
	public Date getStrDteSaisi() {
		return this.strDteSaisi;
	}

	public void setStrDteSaisi(Date strDteSaisi) {
		this.strDteSaisi = strDteSaisi;
	}

	@Column(name = "STR_OPE_RESPO", length = 1)
	public String getStrOpeRespo() {
		return this.strOpeRespo;
	}

	public void setStrOpeRespo(String strOpeRespo) {
		this.strOpeRespo = strOpeRespo;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TStructure")
	public Set<TAgpm> getTAgpms() {
		return this.TAgpms;
	}

	public void setTAgpms(Set<TAgpm> TAgpms) {
		this.TAgpms = TAgpms;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TStructure")
	public Set<TDetCommissionSeance> getTDetCommissionSeances() {
		return this.TDetCommissionSeances;
	}

	public void setTDetCommissionSeances(Set<TDetCommissionSeance> TDetCommissionSeances) {
		this.TDetCommissionSeances = TDetCommissionSeances;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TStructure")
	public Set<TDacSpecs> getTDacSpecses() {
		return this.TDacSpecses;
	}

	public void setTDacSpecses(Set<TDacSpecs> TDacSpecses) {
		this.TDacSpecses = TDacSpecses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TStructure")
	public Set<TAffichagePgpm> getTAffichagePgpms() {
		return this.TAffichagePgpms;
	}

	public void setTAffichagePgpms(Set<TAffichagePgpm> TAffichagePgpms) {
		this.TAffichagePgpms = TAffichagePgpms;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TStructure")
	public Set<TAffichagePpm> getTAffichagePpms() {
		return this.TAffichagePpms;
	}

	public void setTAffichagePpms(Set<TAffichagePpm> TAffichagePpms) {
		this.TAffichagePpms = TAffichagePpms;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TStructure")
	public Set<TCharge> getTCharges() {
		return this.TCharges;
	}

	public void setTCharges(Set<TCharge> TCharges) {
		this.TCharges = TCharges;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TStructure")
	public Set<TPlanPassation> getTPlanPassations() {
		return this.TPlanPassations;
	}

	public void setTPlanPassations(Set<TPlanPassation> TPlanPassations) {
		this.TPlanPassations = TPlanPassations;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TStructure")
	public Set<TFonction> getTFonctions() {
		return this.TFonctions;
	}

	public void setTFonctions(Set<TFonction> TFonctions) {
		this.TFonctions = TFonctions;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TStructure")
	public Set<TCommissionSpecifique> getTCommissionSpecifiques() {
		return this.TCommissionSpecifiques;
	}

	public void setTCommissionSpecifiques(Set<TCommissionSpecifique> TCommissionSpecifiques) {
		this.TCommissionSpecifiques = TCommissionSpecifiques;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TStructure")
	public Set<TDetailDemandes> getTDetailDemandeses() {
		return this.TDetailDemandeses;
	}

	public void setTDetailDemandeses(Set<TDetailDemandes> TDetailDemandeses) {
		this.TDetailDemandeses = TDetailDemandeses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TStructure")
	public Set<TOperateur> getTOperateurs() {
		return this.TOperateurs;
	}

	public void setTOperateurs(Set<TOperateur> TOperateurs) {
		this.TOperateurs = TOperateurs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TStructure")
	public Set<TAffichageAgpm> getTAffichageAgpms() {
		return this.TAffichageAgpms;
	}

	public void setTAffichageAgpms(Set<TAffichageAgpm> TAffichageAgpms) {
		this.TAffichageAgpms = TAffichageAgpms;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TStructure")
	public Set<TDemande> getTDemandes() {
		return this.TDemandes;
	}

	public void setTDemandes(Set<TDemande> TDemandes) {
		this.TDemandes = TDemandes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TStructure")
	public Set<TDetailPlanPassation> getTDetailPlanPassations() {
		return this.TDetailPlanPassations;
	}

	public void setTDetailPlanPassations(Set<TDetailPlanPassation> TDetailPlanPassations) {
		this.TDetailPlanPassations = TDetailPlanPassations;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TStructure")
	public Set<TPlanGeneral> getTPlanGenerals() {
		return this.TPlanGenerals;
	}

	public void setTPlanGenerals(Set<TPlanGeneral> TPlanGenerals) {
		this.TPlanGenerals = TPlanGenerals;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TStructure")
	public Set<TLBudgets> getTLBudgetses() {
		return this.TLBudgetses;
	}

	public void setTLBudgetses(Set<TLBudgets> TLBudgetses) {
		this.TLBudgetses = TLBudgetses;
	}

}
