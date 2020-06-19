package com.sndi.models;
// Generated 18 juin 2020 16:45:49 by Hibernate Tools 4.3.5.Final

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
 * TAffichageAgpm generated by hbm2java
 */
@Entity
@Table(name = "T_AFFICHAGE_AGPM", schema = "EMAP")
public class TAffichageAgpm implements java.io.Serializable {

	private long affId;
	private TProjet TProjet;
	private TSourceFinancement TSourceFinancement;
	private TStatut TStatut;
	private TStructure TStructure;
	private TGestions TGestions;
	private TDeclarant TDeclarant;
	private TDevise TDevise;
	private TFinancement TFinancement;
	private TFonction TFonction;
	private TBailleur TBailleur;
	private long affAgpId;
	private String affAgpActeurSaisie;
	private String affAgpStatutRetour;
	private String affAgpActif;
	private String affAgpTypeDao;
	private String affAgpCommentaire;
	private String affAgpRecherche;
	private Date affAgpDateValAc;
	private Date affAgpDateValCpmp;
	private Date affAgpDateValDmp;
	private String affAgpCode;
	private Date affAgpDteModif;
	private String affFonCodPf;
	private String affFonCodDmp;

	public TAffichageAgpm() {
	}

	public TAffichageAgpm(long affId, TProjet TProjet, TSourceFinancement TSourceFinancement, TStatut TStatut,
			TStructure TStructure, TGestions TGestions, TDevise TDevise, TFinancement TFinancement, TFonction TFonction,
			long affAgpId) {
		this.affId = affId;
		this.TProjet = TProjet;
		this.TSourceFinancement = TSourceFinancement;
		this.TStatut = TStatut;
		this.TStructure = TStructure;
		this.TGestions = TGestions;
		this.TDevise = TDevise;
		this.TFinancement = TFinancement;
		this.TFonction = TFonction;
		this.affAgpId = affAgpId;
	}

	public TAffichageAgpm(long affId, TProjet TProjet, TSourceFinancement TSourceFinancement, TStatut TStatut,
			TStructure TStructure, TGestions TGestions, TDeclarant TDeclarant, TDevise TDevise,
			TFinancement TFinancement, TFonction TFonction, TBailleur TBailleur, long affAgpId,
			String affAgpActeurSaisie, String affAgpStatutRetour, String affAgpActif, String affAgpTypeDao,
			String affAgpCommentaire, String affAgpRecherche, Date affAgpDateValAc, Date affAgpDateValCpmp,
			Date affAgpDateValDmp, String affAgpCode, Date affAgpDteModif, String affFonCodPf, String affFonCodDmp) {
		this.affId = affId;
		this.TProjet = TProjet;
		this.TSourceFinancement = TSourceFinancement;
		this.TStatut = TStatut;
		this.TStructure = TStructure;
		this.TGestions = TGestions;
		this.TDeclarant = TDeclarant;
		this.TDevise = TDevise;
		this.TFinancement = TFinancement;
		this.TFonction = TFonction;
		this.TBailleur = TBailleur;
		this.affAgpId = affAgpId;
		this.affAgpActeurSaisie = affAgpActeurSaisie;
		this.affAgpStatutRetour = affAgpStatutRetour;
		this.affAgpActif = affAgpActif;
		this.affAgpTypeDao = affAgpTypeDao;
		this.affAgpCommentaire = affAgpCommentaire;
		this.affAgpRecherche = affAgpRecherche;
		this.affAgpDateValAc = affAgpDateValAc;
		this.affAgpDateValCpmp = affAgpDateValCpmp;
		this.affAgpDateValDmp = affAgpDateValDmp;
		this.affAgpCode = affAgpCode;
		this.affAgpDteModif = affAgpDteModif;
		this.affFonCodPf = affFonCodPf;
		this.affFonCodDmp = affFonCodDmp;
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
	@JoinColumn(name = "AFF_PRO_ID", nullable = false)
	public TProjet getTProjet() {
		return this.TProjet;
	}

	public void setTProjet(TProjet TProjet) {
		this.TProjet = TProjet;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AFF_SOU_CODE", nullable = false)
	public TSourceFinancement getTSourceFinancement() {
		return this.TSourceFinancement;
	}

	public void setTSourceFinancement(TSourceFinancement TSourceFinancement) {
		this.TSourceFinancement = TSourceFinancement;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AFF_AGP_STA_CODE", nullable = false)
	public TStatut getTStatut() {
		return this.TStatut;
	}

	public void setTStatut(TStatut TStatut) {
		this.TStatut = TStatut;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AFF_STR_CODE", nullable = false)
	public TStructure getTStructure() {
		return this.TStructure;
	}

	public void setTStructure(TStructure TStructure) {
		this.TStructure = TStructure;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AFF_GES_CODE", nullable = false)
	public TGestions getTGestions() {
		return this.TGestions;
	}

	public void setTGestions(TGestions TGestions) {
		this.TGestions = TGestions;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AFF_DEC_ID")
	public TDeclarant getTDeclarant() {
		return this.TDeclarant;
	}

	public void setTDeclarant(TDeclarant TDeclarant) {
		this.TDeclarant = TDeclarant;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AFF_DEV_CODE", nullable = false)
	public TDevise getTDevise() {
		return this.TDevise;
	}

	public void setTDevise(TDevise TDevise) {
		this.TDevise = TDevise;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AFF_FIN_ID", nullable = false)
	public TFinancement getTFinancement() {
		return this.TFinancement;
	}

	public void setTFinancement(TFinancement TFinancement) {
		this.TFinancement = TFinancement;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AFF_FON_COD", nullable = false)
	public TFonction getTFonction() {
		return this.TFonction;
	}

	public void setTFonction(TFonction TFonction) {
		this.TFonction = TFonction;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AFF_BAI_CODE")
	public TBailleur getTBailleur() {
		return this.TBailleur;
	}

	public void setTBailleur(TBailleur TBailleur) {
		this.TBailleur = TBailleur;
	}

	@Column(name = "AFF_AGP_ID", nullable = false, precision = 10, scale = 0)
	public long getAffAgpId() {
		return this.affAgpId;
	}

	public void setAffAgpId(long affAgpId) {
		this.affAgpId = affAgpId;
	}

	@Column(name = "AFF_AGP_ACTEUR_SAISIE", length = 12)
	public String getAffAgpActeurSaisie() {
		return this.affAgpActeurSaisie;
	}

	public void setAffAgpActeurSaisie(String affAgpActeurSaisie) {
		this.affAgpActeurSaisie = affAgpActeurSaisie;
	}

	@Column(name = "AFF_AGP_STATUT_RETOUR", length = 2)
	public String getAffAgpStatutRetour() {
		return this.affAgpStatutRetour;
	}

	public void setAffAgpStatutRetour(String affAgpStatutRetour) {
		this.affAgpStatutRetour = affAgpStatutRetour;
	}

	@Column(name = "AFF_AGP_ACTIF", length = 1)
	public String getAffAgpActif() {
		return this.affAgpActif;
	}

	public void setAffAgpActif(String affAgpActif) {
		this.affAgpActif = affAgpActif;
	}

	@Column(name = "AFF_AGP_TYPE_DAO", length = 1000)
	public String getAffAgpTypeDao() {
		return this.affAgpTypeDao;
	}

	public void setAffAgpTypeDao(String affAgpTypeDao) {
		this.affAgpTypeDao = affAgpTypeDao;
	}

	@Column(name = "AFF_AGP_COMMENTAIRE", length = 1000)
	public String getAffAgpCommentaire() {
		return this.affAgpCommentaire;
	}

	public void setAffAgpCommentaire(String affAgpCommentaire) {
		this.affAgpCommentaire = affAgpCommentaire;
	}

	@Column(name = "AFF_AGP_RECHERCHE", length = 4000)
	public String getAffAgpRecherche() {
		return this.affAgpRecherche;
	}

	public void setAffAgpRecherche(String affAgpRecherche) {
		this.affAgpRecherche = affAgpRecherche;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "AFF_AGP_DATE_VAL_AC", length = 7)
	public Date getAffAgpDateValAc() {
		return this.affAgpDateValAc;
	}

	public void setAffAgpDateValAc(Date affAgpDateValAc) {
		this.affAgpDateValAc = affAgpDateValAc;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "AFF_AGP_DATE_VAL_CPMP", length = 7)
	public Date getAffAgpDateValCpmp() {
		return this.affAgpDateValCpmp;
	}

	public void setAffAgpDateValCpmp(Date affAgpDateValCpmp) {
		this.affAgpDateValCpmp = affAgpDateValCpmp;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "AFF_AGP_DATE_VAL_DMP", length = 7)
	public Date getAffAgpDateValDmp() {
		return this.affAgpDateValDmp;
	}

	public void setAffAgpDateValDmp(Date affAgpDateValDmp) {
		this.affAgpDateValDmp = affAgpDateValDmp;
	}

	@Column(name = "AFF_AGP_CODE", length = 50)
	public String getAffAgpCode() {
		return this.affAgpCode;
	}

	public void setAffAgpCode(String affAgpCode) {
		this.affAgpCode = affAgpCode;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "AFF_AGP_DTE_MODIF", length = 7)
	public Date getAffAgpDteModif() {
		return this.affAgpDteModif;
	}

	public void setAffAgpDteModif(Date affAgpDteModif) {
		this.affAgpDteModif = affAgpDteModif;
	}

	@Column(name = "AFF_FON_COD_PF", length = 20)
	public String getAffFonCodPf() {
		return this.affFonCodPf;
	}

	public void setAffFonCodPf(String affFonCodPf) {
		this.affFonCodPf = affFonCodPf;
	}

	@Column(name = "AFF_FON_COD_DMP", length = 20)
	public String getAffFonCodDmp() {
		return this.affFonCodDmp;
	}

	public void setAffFonCodDmp(String affFonCodDmp) {
		this.affFonCodDmp = affFonCodDmp;
	}

}
