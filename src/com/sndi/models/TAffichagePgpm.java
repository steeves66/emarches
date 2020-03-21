package com.sndi.models;
// Generated 21 mars 2020 13:48:08 by Hibernate Tools 4.3.5.Final

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
 * TAffichagePgpm generated by hbm2java
 */
@Entity
@Table(name = "T_AFFICHAGE_PGPM", schema = "EMAP")
public class TAffichagePgpm implements java.io.Serializable {

	private long affId;
	private TSourceFinancement TSourceFinancement;
	private TStatut TStatut;
	private TStructure TStructure;
	private TTypeMarche TTypeMarche;
	private TFonction TFonction;
	private TGestion TGestion;
	private TModePassation TModePassation;
	private TPlanGeneral TPlanGeneral;
	private Long affGpgId;
	private Long affGpgAgpId;
	private String affGpgTypePlan;
	private String affGpgCode;
	private String affGpgObjet;
	private Integer affGpgNumeroOrdre;
	private String affGpgPartiePmePmi;
	private String affGpgCommentaire;
	private Date affGpgDateDao;
	private String affGpgActeurSaisie;
	private String affGpgStatutRetour;
	private Date affGpgDateSaisie;
	private String affGpgRecherche;
	private Date affGpgDateValAc;
	private Date affGpgDateValCpmp;
	private Date affGpgDateValDmp;
	private String affGpgTypFinance;

	public TAffichagePgpm() {
	}

	public TAffichagePgpm(long affId, TStatut TStatut, TTypeMarche TTypeMarche, TModePassation TModePassation,
			TPlanGeneral TPlanGeneral, String affGpgTypePlan) {
		this.affId = affId;
		this.TStatut = TStatut;
		this.TTypeMarche = TTypeMarche;
		this.TModePassation = TModePassation;
		this.TPlanGeneral = TPlanGeneral;
		this.affGpgTypePlan = affGpgTypePlan;
	}

	public TAffichagePgpm(long affId, TSourceFinancement TSourceFinancement, TStatut TStatut, TStructure TStructure,
			TTypeMarche TTypeMarche, TFonction TFonction, TGestion TGestion, TModePassation TModePassation,
			TPlanGeneral TPlanGeneral, Long affGpgId, Long affGpgAgpId, String affGpgTypePlan, String affGpgCode,
			String affGpgObjet, Integer affGpgNumeroOrdre, String affGpgPartiePmePmi, String affGpgCommentaire,
			Date affGpgDateDao, String affGpgActeurSaisie, String affGpgStatutRetour, Date affGpgDateSaisie,
			String affGpgRecherche, Date affGpgDateValAc, Date affGpgDateValCpmp, Date affGpgDateValDmp,
			String affGpgTypFinance) {
		this.affId = affId;
		this.TSourceFinancement = TSourceFinancement;
		this.TStatut = TStatut;
		this.TStructure = TStructure;
		this.TTypeMarche = TTypeMarche;
		this.TFonction = TFonction;
		this.TGestion = TGestion;
		this.TModePassation = TModePassation;
		this.TPlanGeneral = TPlanGeneral;
		this.affGpgId = affGpgId;
		this.affGpgAgpId = affGpgAgpId;
		this.affGpgTypePlan = affGpgTypePlan;
		this.affGpgCode = affGpgCode;
		this.affGpgObjet = affGpgObjet;
		this.affGpgNumeroOrdre = affGpgNumeroOrdre;
		this.affGpgPartiePmePmi = affGpgPartiePmePmi;
		this.affGpgCommentaire = affGpgCommentaire;
		this.affGpgDateDao = affGpgDateDao;
		this.affGpgActeurSaisie = affGpgActeurSaisie;
		this.affGpgStatutRetour = affGpgStatutRetour;
		this.affGpgDateSaisie = affGpgDateSaisie;
		this.affGpgRecherche = affGpgRecherche;
		this.affGpgDateValAc = affGpgDateValAc;
		this.affGpgDateValCpmp = affGpgDateValCpmp;
		this.affGpgDateValDmp = affGpgDateValDmp;
		this.affGpgTypFinance = affGpgTypFinance;
	}

	@Id

	@Column(name = "AFF_ID", unique = true, nullable = false, precision = 10, scale = 0)
	public long getAffId() {
		return this.affId;
	}

	public void setAffId(long affId) {
		this.affId = affId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AFF_GPG_SOURCE_FIN")
	public TSourceFinancement getTSourceFinancement() {
		return this.TSourceFinancement;
	}

	public void setTSourceFinancement(TSourceFinancement TSourceFinancement) {
		this.TSourceFinancement = TSourceFinancement;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AFF_GPG_STA_CODE", nullable = false)
	public TStatut getTStatut() {
		return this.TStatut;
	}

	public void setTStatut(TStatut TStatut) {
		this.TStatut = TStatut;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AFF_GPG_STR_CODE")
	public TStructure getTStructure() {
		return this.TStructure;
	}

	public void setTStructure(TStructure TStructure) {
		this.TStructure = TStructure;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AFF_GPG_TYM_CODE", nullable = false)
	public TTypeMarche getTTypeMarche() {
		return this.TTypeMarche;
	}

	public void setTTypeMarche(TTypeMarche TTypeMarche) {
		this.TTypeMarche = TTypeMarche;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AFF_GPG_FON_COD")
	public TFonction getTFonction() {
		return this.TFonction;
	}

	public void setTFonction(TFonction TFonction) {
		this.TFonction = TFonction;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AFF_GPG_GES_CODE")
	public TGestion getTGestion() {
		return this.TGestion;
	}

	public void setTGestion(TGestion TGestion) {
		this.TGestion = TGestion;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AFF_GPG_MOP_CODE", nullable = false)
	public TModePassation getTModePassation() {
		return this.TModePassation;
	}

	public void setTModePassation(TModePassation TModePassation) {
		this.TModePassation = TModePassation;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AFF_GPG_PLG_ID", nullable = false)
	public TPlanGeneral getTPlanGeneral() {
		return this.TPlanGeneral;
	}

	public void setTPlanGeneral(TPlanGeneral TPlanGeneral) {
		this.TPlanGeneral = TPlanGeneral;
	}

	@Column(name = "AFF_GPG_ID", precision = 10, scale = 0)
	public Long getAffGpgId() {
		return this.affGpgId;
	}

	public void setAffGpgId(Long affGpgId) {
		this.affGpgId = affGpgId;
	}

	@Column(name = "AFF_GPG_AGP_ID", precision = 10, scale = 0)
	public Long getAffGpgAgpId() {
		return this.affGpgAgpId;
	}

	public void setAffGpgAgpId(Long affGpgAgpId) {
		this.affGpgAgpId = affGpgAgpId;
	}

	@Column(name = "AFF_GPG_TYPE_PLAN", nullable = false, length = 3)
	public String getAffGpgTypePlan() {
		return this.affGpgTypePlan;
	}

	public void setAffGpgTypePlan(String affGpgTypePlan) {
		this.affGpgTypePlan = affGpgTypePlan;
	}

	@Column(name = "AFF_GPG_CODE", length = 50)
	public String getAffGpgCode() {
		return this.affGpgCode;
	}

	public void setAffGpgCode(String affGpgCode) {
		this.affGpgCode = affGpgCode;
	}

	@Column(name = "AFF_GPG_OBJET", length = 1000)
	public String getAffGpgObjet() {
		return this.affGpgObjet;
	}

	public void setAffGpgObjet(String affGpgObjet) {
		this.affGpgObjet = affGpgObjet;
	}

	@Column(name = "AFF_GPG_NUMERO_ORDRE", precision = 8, scale = 0)
	public Integer getAffGpgNumeroOrdre() {
		return this.affGpgNumeroOrdre;
	}

	public void setAffGpgNumeroOrdre(Integer affGpgNumeroOrdre) {
		this.affGpgNumeroOrdre = affGpgNumeroOrdre;
	}

	@Column(name = "AFF_GPG_PARTIE_PME_PMI", length = 1)
	public String getAffGpgPartiePmePmi() {
		return this.affGpgPartiePmePmi;
	}

	public void setAffGpgPartiePmePmi(String affGpgPartiePmePmi) {
		this.affGpgPartiePmePmi = affGpgPartiePmePmi;
	}

	@Column(name = "AFF_GPG_COMMENTAIRE", length = 1000)
	public String getAffGpgCommentaire() {
		return this.affGpgCommentaire;
	}

	public void setAffGpgCommentaire(String affGpgCommentaire) {
		this.affGpgCommentaire = affGpgCommentaire;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "AFF_GPG_DATE_DAO", length = 7)
	public Date getAffGpgDateDao() {
		return this.affGpgDateDao;
	}

	public void setAffGpgDateDao(Date affGpgDateDao) {
		this.affGpgDateDao = affGpgDateDao;
	}

	@Column(name = "AFF_GPG_ACTEUR_SAISIE", length = 12)
	public String getAffGpgActeurSaisie() {
		return this.affGpgActeurSaisie;
	}

	public void setAffGpgActeurSaisie(String affGpgActeurSaisie) {
		this.affGpgActeurSaisie = affGpgActeurSaisie;
	}

	@Column(name = "AFF_GPG_STATUT_RETOUR", length = 4)
	public String getAffGpgStatutRetour() {
		return this.affGpgStatutRetour;
	}

	public void setAffGpgStatutRetour(String affGpgStatutRetour) {
		this.affGpgStatutRetour = affGpgStatutRetour;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "AFF_GPG_DATE_SAISIE", length = 7)
	public Date getAffGpgDateSaisie() {
		return this.affGpgDateSaisie;
	}

	public void setAffGpgDateSaisie(Date affGpgDateSaisie) {
		this.affGpgDateSaisie = affGpgDateSaisie;
	}

	@Column(name = "AFF_GPG_RECHERCHE", length = 4000)
	public String getAffGpgRecherche() {
		return this.affGpgRecherche;
	}

	public void setAffGpgRecherche(String affGpgRecherche) {
		this.affGpgRecherche = affGpgRecherche;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "AFF_GPG_DATE_VAL_AC", length = 7)
	public Date getAffGpgDateValAc() {
		return this.affGpgDateValAc;
	}

	public void setAffGpgDateValAc(Date affGpgDateValAc) {
		this.affGpgDateValAc = affGpgDateValAc;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "AFF_GPG_DATE_VAL_CPMP", length = 7)
	public Date getAffGpgDateValCpmp() {
		return this.affGpgDateValCpmp;
	}

	public void setAffGpgDateValCpmp(Date affGpgDateValCpmp) {
		this.affGpgDateValCpmp = affGpgDateValCpmp;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "AFF_GPG_DATE_VAL_DMP", length = 7)
	public Date getAffGpgDateValDmp() {
		return this.affGpgDateValDmp;
	}

	public void setAffGpgDateValDmp(Date affGpgDateValDmp) {
		this.affGpgDateValDmp = affGpgDateValDmp;
	}

	@Column(name = "AFF_GPG_TYP_FINANCE", length = 20)
	public String getAffGpgTypFinance() {
		return this.affGpgTypFinance;
	}

	public void setAffGpgTypFinance(String affGpgTypFinance) {
		this.affGpgTypFinance = affGpgTypFinance;
	}

}
