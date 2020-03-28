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
 * TDetailPlanGeneral generated by hbm2java
 */
@Entity
@Table(name = "T_DETAIL_PLAN_GENERAL", schema = "EMAP")
public class TDetailPlanGeneral implements java.io.Serializable {

	private long gpgId;
	private TStatut TStatut;
	private TTypeMarche TTypeMarche;
	private TModePassation TModePassation;
	private TPlanGeneral TPlanGeneral;
	private Long gpgAgpId;
	private String gpgTypePlan;
	private String gpgCode;
	private String gpgObjet;
	private Integer gpgNumeroOrdre;
	private String gpgPartiePmePmi;
	private String gpgCommentaire;
	private String gpgSourceFin;
	private Date gpgDateDao;
	private String gpgActeurSaisie;
	private String gpgStatutRetour;
	private Date gpgDateSaisie;
	private String gpgStrCode;
	private Date gpgDateValAc;
	private Date gpgDateValCpmp;
	private Date gpgDateValDmp;
	private Set<TAffichagePpm> TAffichagePpms = new HashSet<TAffichagePpm>(0);
	private Set<TDossierPlanGeneral> TDossierPlanGenerals = new HashSet<TDossierPlanGeneral>(0);
	private Set<TDetailPlanPassation> TDetailPlanPassations = new HashSet<TDetailPlanPassation>(0);
	private Set<TFinancementPgpm> TFinancementPgpms = new HashSet<TFinancementPgpm>(0);
	private Set<THistoPlanGeneral> THistoPlanGenerals = new HashSet<THistoPlanGeneral>(0);

	public TDetailPlanGeneral() {
	}

	public TDetailPlanGeneral(long gpgId, TStatut TStatut, TTypeMarche TTypeMarche, TModePassation TModePassation,
			TPlanGeneral TPlanGeneral, String gpgTypePlan) {
		this.gpgId = gpgId;
		this.TStatut = TStatut;
		this.TTypeMarche = TTypeMarche;
		this.TModePassation = TModePassation;
		this.TPlanGeneral = TPlanGeneral;
		this.gpgTypePlan = gpgTypePlan;
	}

	public TDetailPlanGeneral(long gpgId, TStatut TStatut, TTypeMarche TTypeMarche, TModePassation TModePassation,
			TPlanGeneral TPlanGeneral, Long gpgAgpId, String gpgTypePlan, String gpgCode, String gpgObjet,
			Integer gpgNumeroOrdre, String gpgPartiePmePmi, String gpgCommentaire, String gpgSourceFin, Date gpgDateDao,
			String gpgActeurSaisie, String gpgStatutRetour, Date gpgDateSaisie, String gpgStrCode, Date gpgDateValAc,
			Date gpgDateValCpmp, Date gpgDateValDmp, Set<TAffichagePpm> TAffichagePpms,
			Set<TDossierPlanGeneral> TDossierPlanGenerals, Set<TDetailPlanPassation> TDetailPlanPassations,
			Set<TFinancementPgpm> TFinancementPgpms, Set<THistoPlanGeneral> THistoPlanGenerals) {
		this.gpgId = gpgId;
		this.TStatut = TStatut;
		this.TTypeMarche = TTypeMarche;
		this.TModePassation = TModePassation;
		this.TPlanGeneral = TPlanGeneral;
		this.gpgAgpId = gpgAgpId;
		this.gpgTypePlan = gpgTypePlan;
		this.gpgCode = gpgCode;
		this.gpgObjet = gpgObjet;
		this.gpgNumeroOrdre = gpgNumeroOrdre;
		this.gpgPartiePmePmi = gpgPartiePmePmi;
		this.gpgCommentaire = gpgCommentaire;
		this.gpgSourceFin = gpgSourceFin;
		this.gpgDateDao = gpgDateDao;
		this.gpgActeurSaisie = gpgActeurSaisie;
		this.gpgStatutRetour = gpgStatutRetour;
		this.gpgDateSaisie = gpgDateSaisie;
		this.gpgStrCode = gpgStrCode;
		this.gpgDateValAc = gpgDateValAc;
		this.gpgDateValCpmp = gpgDateValCpmp;
		this.gpgDateValDmp = gpgDateValDmp;
		this.TAffichagePpms = TAffichagePpms;
		this.TDossierPlanGenerals = TDossierPlanGenerals;
		this.TDetailPlanPassations = TDetailPlanPassations;
		this.TFinancementPgpms = TFinancementPgpms;
		this.THistoPlanGenerals = THistoPlanGenerals;
	}

	@Id

	@Column(name = "GPG_ID", unique = true, nullable = false, precision = 10, scale = 0)
	public long getGpgId() {
		return this.gpgId;
	}

	public void setGpgId(long gpgId) {
		this.gpgId = gpgId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "GPG_STA_CODE", nullable = false)
	public TStatut getTStatut() {
		return this.TStatut;
	}

	public void setTStatut(TStatut TStatut) {
		this.TStatut = TStatut;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "GPG_TYM_CODE", nullable = false)
	public TTypeMarche getTTypeMarche() {
		return this.TTypeMarche;
	}

	public void setTTypeMarche(TTypeMarche TTypeMarche) {
		this.TTypeMarche = TTypeMarche;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "GPG_MOP_CODE", nullable = false)
	public TModePassation getTModePassation() {
		return this.TModePassation;
	}

	public void setTModePassation(TModePassation TModePassation) {
		this.TModePassation = TModePassation;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "GPG_PLG_ID", nullable = false)
	public TPlanGeneral getTPlanGeneral() {
		return this.TPlanGeneral;
	}

	public void setTPlanGeneral(TPlanGeneral TPlanGeneral) {
		this.TPlanGeneral = TPlanGeneral;
	}

	@Column(name = "GPG_AGP_ID", precision = 10, scale = 0)
	public Long getGpgAgpId() {
		return this.gpgAgpId;
	}

	public void setGpgAgpId(Long gpgAgpId) {
		this.gpgAgpId = gpgAgpId;
	}

	@Column(name = "GPG_TYPE_PLAN", nullable = false, length = 3)
	public String getGpgTypePlan() {
		return this.gpgTypePlan;
	}

	public void setGpgTypePlan(String gpgTypePlan) {
		this.gpgTypePlan = gpgTypePlan;
	}

	@Column(name = "GPG_CODE", length = 50)
	public String getGpgCode() {
		return this.gpgCode;
	}

	public void setGpgCode(String gpgCode) {
		this.gpgCode = gpgCode;
	}

	@Column(name = "GPG_OBJET", length = 1000)
	public String getGpgObjet() {
		return this.gpgObjet;
	}

	public void setGpgObjet(String gpgObjet) {
		this.gpgObjet = gpgObjet;
	}

	@Column(name = "GPG_NUMERO_ORDRE", precision = 8, scale = 0)
	public Integer getGpgNumeroOrdre() {
		return this.gpgNumeroOrdre;
	}

	public void setGpgNumeroOrdre(Integer gpgNumeroOrdre) {
		this.gpgNumeroOrdre = gpgNumeroOrdre;
	}

	@Column(name = "GPG_PARTIE_PME_PMI", length = 1)
	public String getGpgPartiePmePmi() {
		return this.gpgPartiePmePmi;
	}

	public void setGpgPartiePmePmi(String gpgPartiePmePmi) {
		this.gpgPartiePmePmi = gpgPartiePmePmi;
	}

	@Column(name = "GPG_COMMENTAIRE", length = 1000)
	public String getGpgCommentaire() {
		return this.gpgCommentaire;
	}

	public void setGpgCommentaire(String gpgCommentaire) {
		this.gpgCommentaire = gpgCommentaire;
	}

	@Column(name = "GPG_SOURCE_FIN", length = 1000)
	public String getGpgSourceFin() {
		return this.gpgSourceFin;
	}

	public void setGpgSourceFin(String gpgSourceFin) {
		this.gpgSourceFin = gpgSourceFin;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "GPG_DATE_DAO", length = 7)
	public Date getGpgDateDao() {
		return this.gpgDateDao;
	}

	public void setGpgDateDao(Date gpgDateDao) {
		this.gpgDateDao = gpgDateDao;
	}

	@Column(name = "GPG_ACTEUR_SAISIE", length = 12)
	public String getGpgActeurSaisie() {
		return this.gpgActeurSaisie;
	}

	public void setGpgActeurSaisie(String gpgActeurSaisie) {
		this.gpgActeurSaisie = gpgActeurSaisie;
	}

	@Column(name = "GPG_STATUT_RETOUR", length = 4)
	public String getGpgStatutRetour() {
		return this.gpgStatutRetour;
	}

	public void setGpgStatutRetour(String gpgStatutRetour) {
		this.gpgStatutRetour = gpgStatutRetour;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "GPG_DATE_SAISIE", length = 7)
	public Date getGpgDateSaisie() {
		return this.gpgDateSaisie;
	}

	public void setGpgDateSaisie(Date gpgDateSaisie) {
		this.gpgDateSaisie = gpgDateSaisie;
	}

	@Column(name = "GPG_STR_CODE", length = 3)
	public String getGpgStrCode() {
		return this.gpgStrCode;
	}

	public void setGpgStrCode(String gpgStrCode) {
		this.gpgStrCode = gpgStrCode;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "GPG_DATE_VAL_AC", length = 7)
	public Date getGpgDateValAc() {
		return this.gpgDateValAc;
	}

	public void setGpgDateValAc(Date gpgDateValAc) {
		this.gpgDateValAc = gpgDateValAc;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "GPG_DATE_VAL_CPMP", length = 7)
	public Date getGpgDateValCpmp() {
		return this.gpgDateValCpmp;
	}

	public void setGpgDateValCpmp(Date gpgDateValCpmp) {
		this.gpgDateValCpmp = gpgDateValCpmp;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "GPG_DATE_VAL_DMP", length = 7)
	public Date getGpgDateValDmp() {
		return this.gpgDateValDmp;
	}

	public void setGpgDateValDmp(Date gpgDateValDmp) {
		this.gpgDateValDmp = gpgDateValDmp;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TDetailPlanGeneral")
	public Set<TAffichagePpm> getTAffichagePpms() {
		return this.TAffichagePpms;
	}

	public void setTAffichagePpms(Set<TAffichagePpm> TAffichagePpms) {
		this.TAffichagePpms = TAffichagePpms;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TDetailPlanGeneral")
	public Set<TDossierPlanGeneral> getTDossierPlanGenerals() {
		return this.TDossierPlanGenerals;
	}

	public void setTDossierPlanGenerals(Set<TDossierPlanGeneral> TDossierPlanGenerals) {
		this.TDossierPlanGenerals = TDossierPlanGenerals;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TDetailPlanGeneral")
	public Set<TDetailPlanPassation> getTDetailPlanPassations() {
		return this.TDetailPlanPassations;
	}

	public void setTDetailPlanPassations(Set<TDetailPlanPassation> TDetailPlanPassations) {
		this.TDetailPlanPassations = TDetailPlanPassations;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TDetailPlanGeneral")
	public Set<TFinancementPgpm> getTFinancementPgpms() {
		return this.TFinancementPgpms;
	}

	public void setTFinancementPgpms(Set<TFinancementPgpm> TFinancementPgpms) {
		this.TFinancementPgpms = TFinancementPgpms;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TDetailPlanGeneral")
	public Set<THistoPlanGeneral> getTHistoPlanGenerals() {
		return this.THistoPlanGenerals;
	}

	public void setTHistoPlanGenerals(Set<THistoPlanGeneral> THistoPlanGenerals) {
		this.THistoPlanGenerals = THistoPlanGenerals;
	}

}
