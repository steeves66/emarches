package com.sndi.models;
// Generated 25 juin 2020 13:53:46 by Hibernate Tools 4.3.5.Final

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
 * TAgpm generated by hbm2java
 */
@Entity
@Table(name = "T_AGPM", schema = "EMAP")
public class TAgpm implements java.io.Serializable {

	private long agpId;
	private TProjet TProjet;
	private TStatut TStatut;
	private TStructure TStructure;
	private TGestions TGestions;
	private TDeclarant TDeclarant;
	private TFonction TFonction;
	private String agpCommentaire;
	private String agpTypeDao;
	private String agpModePassation;
	private String agpActif;
	private String agpStatutRetour;
	private String agpActeurSaisie;
	private Date agpDateValAc;
	private Date agpDateValCpmp;
	private Date agpDateValDmp;
	private String agpCode;
	private Date agpDteModif;
	private String agpFonCodPf;
	private String agpFonCodDmp;
	private String agpRecherche;
	private Set<TFinancement> TFinancements = new HashSet<TFinancement>(0);
	private Set<TDetailAgpm> TDetailAgpms = new HashSet<TDetailAgpm>(0);
	private Set<THistoAgpm> THistoAgpms = new HashSet<THistoAgpm>(0);
	private Set<TDossierAgpm> TDossierAgpms = new HashSet<TDossierAgpm>(0);

	public TAgpm() {
	}

	public TAgpm(long agpId, TProjet TProjet, TStatut TStatut, TStructure TStructure, TGestions TGestions,
			TFonction TFonction) {
		this.agpId = agpId;
		this.TProjet = TProjet;
		this.TStatut = TStatut;
		this.TStructure = TStructure;
		this.TGestions = TGestions;
		this.TFonction = TFonction;
	}

	public TAgpm(long agpId, TProjet TProjet, TStatut TStatut, TStructure TStructure, TGestions TGestions,
			TDeclarant TDeclarant, TFonction TFonction, String agpCommentaire, String agpTypeDao,
			String agpModePassation, String agpActif, String agpStatutRetour, String agpActeurSaisie, Date agpDateValAc,
			Date agpDateValCpmp, Date agpDateValDmp, String agpCode, Date agpDteModif, String agpFonCodPf,
			String agpFonCodDmp, String agpRecherche, Set<TFinancement> TFinancements, Set<TDetailAgpm> TDetailAgpms,
			Set<THistoAgpm> THistoAgpms, Set<TDossierAgpm> TDossierAgpms) {
		this.agpId = agpId;
		this.TProjet = TProjet;
		this.TStatut = TStatut;
		this.TStructure = TStructure;
		this.TGestions = TGestions;
		this.TDeclarant = TDeclarant;
		this.TFonction = TFonction;
		this.agpCommentaire = agpCommentaire;
		this.agpTypeDao = agpTypeDao;
		this.agpModePassation = agpModePassation;
		this.agpActif = agpActif;
		this.agpStatutRetour = agpStatutRetour;
		this.agpActeurSaisie = agpActeurSaisie;
		this.agpDateValAc = agpDateValAc;
		this.agpDateValCpmp = agpDateValCpmp;
		this.agpDateValDmp = agpDateValDmp;
		this.agpCode = agpCode;
		this.agpDteModif = agpDteModif;
		this.agpFonCodPf = agpFonCodPf;
		this.agpFonCodDmp = agpFonCodDmp;
		this.agpRecherche = agpRecherche;
		this.TFinancements = TFinancements;
		this.TDetailAgpms = TDetailAgpms;
		this.THistoAgpms = THistoAgpms;
		this.TDossierAgpms = TDossierAgpms;
	}

	@Id

	@Column(name = "AGP_ID", unique = true, nullable = false, precision = 10, scale = 0)
	public long getAgpId() {
		return this.agpId;
	}

	public void setAgpId(long agpId) {
		this.agpId = agpId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AGP_PRO_ID", nullable = false)
	public TProjet getTProjet() {
		return this.TProjet;
	}

	public void setTProjet(TProjet TProjet) {
		this.TProjet = TProjet;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AGP_STA_CODE", nullable = false)
	public TStatut getTStatut() {
		return this.TStatut;
	}

	public void setTStatut(TStatut TStatut) {
		this.TStatut = TStatut;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AGP_STR_CODE", nullable = false)
	public TStructure getTStructure() {
		return this.TStructure;
	}

	public void setTStructure(TStructure TStructure) {
		this.TStructure = TStructure;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AGP_GES_CODE", nullable = false)
	public TGestions getTGestions() {
		return this.TGestions;
	}

	public void setTGestions(TGestions TGestions) {
		this.TGestions = TGestions;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AGP_DEC_ID")
	public TDeclarant getTDeclarant() {
		return this.TDeclarant;
	}

	public void setTDeclarant(TDeclarant TDeclarant) {
		this.TDeclarant = TDeclarant;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AGP_FON_COD", nullable = false)
	public TFonction getTFonction() {
		return this.TFonction;
	}

	public void setTFonction(TFonction TFonction) {
		this.TFonction = TFonction;
	}

	@Column(name = "AGP_COMMENTAIRE", length = 1000)
	public String getAgpCommentaire() {
		return this.agpCommentaire;
	}

	public void setAgpCommentaire(String agpCommentaire) {
		this.agpCommentaire = agpCommentaire;
	}

	@Column(name = "AGP_TYPE_DAO", length = 1000)
	public String getAgpTypeDao() {
		return this.agpTypeDao;
	}

	public void setAgpTypeDao(String agpTypeDao) {
		this.agpTypeDao = agpTypeDao;
	}

	@Column(name = "AGP_MODE_PASSATION", length = 1000)
	public String getAgpModePassation() {
		return this.agpModePassation;
	}

	public void setAgpModePassation(String agpModePassation) {
		this.agpModePassation = agpModePassation;
	}

	@Column(name = "AGP_ACTIF", length = 1)
	public String getAgpActif() {
		return this.agpActif;
	}

	public void setAgpActif(String agpActif) {
		this.agpActif = agpActif;
	}

	@Column(name = "AGP_STATUT_RETOUR", length = 2)
	public String getAgpStatutRetour() {
		return this.agpStatutRetour;
	}

	public void setAgpStatutRetour(String agpStatutRetour) {
		this.agpStatutRetour = agpStatutRetour;
	}

	@Column(name = "AGP_ACTEUR_SAISIE", length = 12)
	public String getAgpActeurSaisie() {
		return this.agpActeurSaisie;
	}

	public void setAgpActeurSaisie(String agpActeurSaisie) {
		this.agpActeurSaisie = agpActeurSaisie;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "AGP_DATE_VAL_AC", length = 7)
	public Date getAgpDateValAc() {
		return this.agpDateValAc;
	}

	public void setAgpDateValAc(Date agpDateValAc) {
		this.agpDateValAc = agpDateValAc;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "AGP_DATE_VAL_CPMP", length = 7)
	public Date getAgpDateValCpmp() {
		return this.agpDateValCpmp;
	}

	public void setAgpDateValCpmp(Date agpDateValCpmp) {
		this.agpDateValCpmp = agpDateValCpmp;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "AGP_DATE_VAL_DMP", length = 7)
	public Date getAgpDateValDmp() {
		return this.agpDateValDmp;
	}

	public void setAgpDateValDmp(Date agpDateValDmp) {
		this.agpDateValDmp = agpDateValDmp;
	}

	@Column(name = "AGP_CODE", length = 50)
	public String getAgpCode() {
		return this.agpCode;
	}

	public void setAgpCode(String agpCode) {
		this.agpCode = agpCode;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "AGP_DTE_MODIF", length = 7)
	public Date getAgpDteModif() {
		return this.agpDteModif;
	}

	public void setAgpDteModif(Date agpDteModif) {
		this.agpDteModif = agpDteModif;
	}

	@Column(name = "AGP_FON_COD_PF", length = 20)
	public String getAgpFonCodPf() {
		return this.agpFonCodPf;
	}

	public void setAgpFonCodPf(String agpFonCodPf) {
		this.agpFonCodPf = agpFonCodPf;
	}

	@Column(name = "AGP_FON_COD_DMP", length = 20)
	public String getAgpFonCodDmp() {
		return this.agpFonCodDmp;
	}

	public void setAgpFonCodDmp(String agpFonCodDmp) {
		this.agpFonCodDmp = agpFonCodDmp;
	}

	@Column(name = "AGP_RECHERCHE", length = 4000)
	public String getAgpRecherche() {
		return this.agpRecherche;
	}

	public void setAgpRecherche(String agpRecherche) {
		this.agpRecherche = agpRecherche;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TAgpm")
	public Set<TFinancement> getTFinancements() {
		return this.TFinancements;
	}

	public void setTFinancements(Set<TFinancement> TFinancements) {
		this.TFinancements = TFinancements;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TAgpm")
	public Set<TDetailAgpm> getTDetailAgpms() {
		return this.TDetailAgpms;
	}

	public void setTDetailAgpms(Set<TDetailAgpm> TDetailAgpms) {
		this.TDetailAgpms = TDetailAgpms;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TAgpm")
	public Set<THistoAgpm> getTHistoAgpms() {
		return this.THistoAgpms;
	}

	public void setTHistoAgpms(Set<THistoAgpm> THistoAgpms) {
		this.THistoAgpms = THistoAgpms;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TAgpm")
	public Set<TDossierAgpm> getTDossierAgpms() {
		return this.TDossierAgpms;
	}

	public void setTDossierAgpms(Set<TDossierAgpm> TDossierAgpms) {
		this.TDossierAgpms = TDossierAgpms;
	}

}