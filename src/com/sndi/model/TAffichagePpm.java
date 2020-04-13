package com.sndi.model;
// Generated 9 d�c. 2019 18:21:13 by Hibernate Tools 4.3.5.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



/**
 * TAffichagePpm generated by hbm2java
 */
@Entity
@Table(name = "T_AFFICHAGE_PPM", schema = "EMAP")
public class TAffichagePpm implements java.io.Serializable {

	private long affId;
	private TLBudgets TLBudgets;
	private TTypeProcedure TTypeProcedure;
	private TFonction TFonction;
	private TModePassation TModePassation;
	private TDetailPlanGeneral TDetailPlanGeneral;
	private TPlanPassation TPlanPassation;
	private TStatut TStatut;
	private TTypeMarche TTypeMarche;
	private TStructure TStructure;
	private String affDppTypePlan;
	private String affDppCode;
	private Integer affDppNumeroOrdre;
	private Date affDppDate;
	private String affDppObjet;
	private String affDppSourceFin;
	private String affDppActeurSaisie;
	private Date affDppDateDaoTrans;
	private Date affDppDateDaoApprobDmp;
	private Date affDppDateDaoApprobBail;
	private Date affDppDateAvisAoPublicat;
	private Date affDppDateOuvertOt;
	private Date affDppDateOuvertOf;
	private Date affDppDateElabRapport;
	private Date affDppDateJugementOffre;
	private Date affDppDateAttApprobDmp;
	private Date affDppDateAttApproBail;
	private Date affDppDateNegociation;
	private Date affDppDateSignatAttrib;
	private Date affDppDateSignatAc;
	private Date affDppDateMarcheApprob;
	private Date affDppDateExecDebut;
	private Date affDppDateExecFin;
	private long affDppId;
	private String affDppStatutRetour;
	private String affDppStrConduc;
	private String affDppStrBenefi;
	private Date affDppDateSaisie;
	private String affDppPartiePmePmi;
	private String affDppStatutDao;
	private String affDppPieceDao;
	private Date affDppInvEntre;
	private String affDppRecherche;
	private Date affDppDateValAc;
	private Date affDppDateValCpmp;
	private Date affDppDateValDmp;
	private String affDppBailleur;
	private String affDppTypeFinance;
	private Date affDppApprobAno;
	private Date affDppDteModif;
	private Date affDppDateAttApprobCmp;
	private Date affDppDateJugementTech;
	


	public TAffichagePpm() {
	}
	
	public TAffichagePpm(long affId) {
		this.affId = affId;
	}

	public TAffichagePpm(long affId, TLBudgets TLBudgets,TModePassation TModePassation, TDetailPlanGeneral TDetailPlanGeneral,
			 TPlanPassation TPlanPassation, TStatut TStatut, TTypeMarche TTypeMarche,
			String affDppTypePlan) {
		this.affId = affId;
		this.TLBudgets = TLBudgets;
		this.TModePassation = TModePassation;
		this.TDetailPlanGeneral = TDetailPlanGeneral;
		this.TPlanPassation = TPlanPassation;
		this.TStatut = TStatut;
		this.TTypeMarche = TTypeMarche;
		this.affDppTypePlan = affDppTypePlan;
	}

	public TAffichagePpm(long affId,TLBudgets TLBudgets,TTypeProcedure TTypeProcedure, TFonction TFonction, TModePassation TModePassation, TDetailPlanGeneral TDetailPlanGeneral,
			 TPlanPassation TPlanPassation, TStatut TStatut, TTypeMarche TTypeMarche,TStructure TStructure,
			String affDppTypePlan, String affDppCode, Integer affDppNumeroOrdre, Date affDppDate, String affDppObjet,
			String affDppSourceFin, String affDppActeurSaisie, Date affDppDateDaoTrans, Date affDppDateDaoApprobDmp,
			Date affDppDateDaoApprobBail, Date affDppDateAvisAoPublicat, Date affDppDateOuvertOt,
			Date affDppDateOuvertOf, Date affDppDateElabRapport, Date affDppDateJugementOffre,Date affDppApprobAno,
			Date affDppDateAttApprobDmp, Date affDppDateAttApproBail, Date affDppDateNegociation,
			Date affDppDateSignatAttrib, Date affDppDateSignatAc, Date affDppDateMarcheApprob, Date affDppDateExecDebut,
			Date affDppDateExecFin,long  affDppId, String affDppStatutRetour,String affDppStrConduc,
			String affDppStrBenefi, Date affDppDateSaisie,String affDppPartiePmePmi, String affDppStatutDao,String affDppPieceDao,Date affDppInvEntre, String affDppRecherche, Date affDppDateValAc,
			Date affDppDateValCpmp, Date affDppDateValDmp, String affDppBailleur, String affDppTypeFinance, Date affDppDteModif,Date affDppDateAttApprobCmp, Date affDppDateJugementTech) {
		this.affId = affId;
		this.TLBudgets = TLBudgets;
		this.TFonction = TFonction;
		this.TModePassation = TModePassation;
		this.TDetailPlanGeneral = TDetailPlanGeneral;
		this.TPlanPassation = TPlanPassation;
		this.TStatut = TStatut;
		this.TTypeMarche = TTypeMarche;
		this.TStructure = TStructure;
		this.affDppTypePlan = affDppTypePlan;
		this.affDppCode = affDppCode;
		this.affDppNumeroOrdre = affDppNumeroOrdre;
		this.affDppDate = affDppDate;
		this.affDppObjet = affDppObjet;
		this.affDppSourceFin = affDppSourceFin;
		this.affDppActeurSaisie = affDppActeurSaisie;
		this.affDppDateDaoTrans = affDppDateDaoTrans;
		this.affDppDateDaoApprobDmp = affDppDateDaoApprobDmp;
		this.affDppDateDaoApprobBail = affDppDateDaoApprobBail;
		this.affDppDateAvisAoPublicat = affDppDateAvisAoPublicat;
		this.affDppDateOuvertOt = affDppDateOuvertOt;
		this.affDppDateOuvertOf = affDppDateOuvertOf;
		this.affDppDateElabRapport = affDppDateElabRapport;
		this.affDppDateJugementOffre = affDppDateJugementOffre;
		this.affDppDateAttApprobDmp = affDppDateAttApprobDmp;
		this.affDppDateAttApproBail = affDppDateAttApproBail;
		this.affDppDateNegociation = affDppDateNegociation;
		this.affDppDateSignatAttrib = affDppDateSignatAttrib;
		this.affDppDateSignatAc = affDppDateSignatAc;
		this.affDppDateMarcheApprob = affDppDateMarcheApprob;
		this.affDppDateExecDebut = affDppDateExecDebut;
		this.affDppDateExecFin = affDppDateExecFin;
		this.affDppId = affDppId;
		this.affDppStatutRetour = affDppStatutRetour;
		this.affDppStrConduc = affDppStrConduc;
		this.affDppStrBenefi = affDppStrBenefi;
		this.affDppDateSaisie = affDppDateSaisie;
		this.affDppPartiePmePmi = affDppPartiePmePmi;
		this.affDppStatutDao = affDppStatutDao;
		this.affDppPieceDao = affDppPieceDao;
		this.affDppInvEntre = affDppInvEntre;
		this.affDppRecherche = affDppRecherche;
		this.affDppDateValAc = affDppDateValAc;
		this.affDppDateValCpmp = affDppDateValCpmp;
		this.affDppDateValDmp = affDppDateValDmp;
		this.affDppApprobAno = affDppApprobAno;
		this.affDppBailleur = affDppBailleur;
		this.affDppTypeFinance = affDppTypeFinance;
		this.affDppDteModif = affDppDteModif;
		this.affDppDateAttApprobCmp = affDppDateAttApprobCmp;
		this.affDppDateJugementTech = affDppDateJugementTech;
	}

	@Id
	@SequenceGenerator(name = "SEQ_AFF_PPM_Sequence", sequenceName = "SEQ_AFF_PPM", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_AFF_PPM_Sequence")
	@Column(name = "AFF_ID", unique = true, nullable = false, precision = 10, scale = 0)
	public long getAffId() {
		return this.affId;
	}

	public void setAffId(long affId) {
		this.affId = affId;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "AFF_DPP_LBG_CODE", nullable = false)
	public TLBudgets getTLBudgets() {
		return this.TLBudgets;
	}

	public void setTLBudgets(TLBudgets TLBudgets) {
		this.TLBudgets = TLBudgets;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AFF_TYP_ID")
	public TTypeProcedure getTTypeProcedure() {
		return this.TTypeProcedure;
	}

	public void setTTypeProcedure(TTypeProcedure TTypeProcedure) {
		this.TTypeProcedure = TTypeProcedure;
	}
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "AFF_DPP_FON_COD")
	public TFonction getTFonction() {
		return this.TFonction;
	}

	public void setTFonction(TFonction TFonction) {
		this.TFonction = TFonction;
	}
	

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "AFF_DPP_MOP_CODE", nullable = false)
	public TModePassation getTModePassation() {
		return this.TModePassation;
	}

	public void setTModePassation(TModePassation TModePassation) {
		this.TModePassation = TModePassation;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "AFF_DPP_GPG_ID", nullable = false)
	public TDetailPlanGeneral getTDetailPlanGeneral() {
		return this.TDetailPlanGeneral;
	}

	public void setTDetailPlanGeneral(TDetailPlanGeneral TDetailPlanGeneral) {
		this.TDetailPlanGeneral = TDetailPlanGeneral;
	}



	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "AFF_DPP_PLP_ID", nullable = false)
	public TPlanPassation getTPlanPassation() {
		return this.TPlanPassation;
	}

	public void setTPlanPassation(TPlanPassation TPlanPassation) {
		this.TPlanPassation = TPlanPassation;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AFF_DPP_STA_CODE", nullable = false)
	public TStatut getTStatut() {
		return this.TStatut;
	}

	public void setTStatut(TStatut TStatut) {
		this.TStatut = TStatut;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "AFF_DPP_TYM_CODE", nullable = false)
	public TTypeMarche getTTypeMarche() {
		return this.TTypeMarche;
	}

	public void setTTypeMarche(TTypeMarche TTypeMarche) {
		this.TTypeMarche = TTypeMarche;
	}
	

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "AFF_DPP_STR_CODE")
	public TStructure getTStructure() {
		return this.TStructure;
	}

	public void setTStructure(TStructure TStructure) {
		this.TStructure = TStructure;
	}

	@Column(name = "AFF_DPP_TYPE_PLAN", nullable = false, length = 3)
	public String getAffDppTypePlan() {
		return this.affDppTypePlan;
	}

	public void setAffDppTypePlan(String affDppTypePlan) {
		this.affDppTypePlan = affDppTypePlan;
	}

	@Column(name = "AFF_DPP_CODE", length = 50)
	public String getAffDppCode() {
		return this.affDppCode;
	}

	public void setAffDppCode(String affDppCode) {
		this.affDppCode = affDppCode;
	}

	@Column(name = "AFF_DPP_NUMERO_ORDRE", precision = 8, scale = 0)
	public Integer getAffDppNumeroOrdre() {
		return this.affDppNumeroOrdre;
	}

	public void setAffDppNumeroOrdre(Integer affDppNumeroOrdre) {
		this.affDppNumeroOrdre = affDppNumeroOrdre;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "AFF_DPP_DATE", length = 7)
	public Date getAffDppDate() {
		return this.affDppDate;
	}

	public void setAffDppDate(Date affDppDate) {
		this.affDppDate = affDppDate;
	}

	@Column(name = "AFF_DPP_OBJET", length = 1000)
	public String getAffDppObjet() {
		return this.affDppObjet;
	}

	public void setAffDppObjet(String affDppObjet) {
		this.affDppObjet = affDppObjet;
	}

	@Column(name = "AFF_DPP_SOURCE_FIN", length = 1000)
	public String getAffDppSourceFin() {
		return this.affDppSourceFin;
	}

	public void setAffDppSourceFin(String affDppSourceFin) {
		this.affDppSourceFin = affDppSourceFin;
	}

	@Column(name = "AFF_DPP_ACTEUR_SAISIE", length = 12)
	public String getAffDppActeurSaisie() {
		return this.affDppActeurSaisie;
	}

	public void setAffDppActeurSaisie(String affDppActeurSaisie) {
		this.affDppActeurSaisie = affDppActeurSaisie;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "AFF_DPP_DATE_DAO_TRANS", length = 7)
	public Date getAffDppDateDaoTrans() {
		return this.affDppDateDaoTrans;
	}

	public void setAffDppDateDaoTrans(Date affDppDateDaoTrans) {
		this.affDppDateDaoTrans = affDppDateDaoTrans;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "AFF_DPP_DATE_DAO_APPROB_DMP", length = 7)
	public Date getAffDppDateDaoApprobDmp() {
		return this.affDppDateDaoApprobDmp;
	}

	public void setAffDppDateDaoApprobDmp(Date affDppDateDaoApprobDmp) {
		this.affDppDateDaoApprobDmp = affDppDateDaoApprobDmp;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "AFF_DPP_DATE_DAO_APPROB_BAIL", length = 7)
	public Date getAffDppDateDaoApprobBail() {
		return this.affDppDateDaoApprobBail;
	}

	public void setAffDppDateDaoApprobBail(Date affDppDateDaoApprobBail) {
		this.affDppDateDaoApprobBail = affDppDateDaoApprobBail;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "AFF_DPP_DATE_AVIS_AO_PUBLICAT", length = 7)
	public Date getAffDppDateAvisAoPublicat() {
		return this.affDppDateAvisAoPublicat;
	}

	public void setAffDppDateAvisAoPublicat(Date affDppDateAvisAoPublicat) {
		this.affDppDateAvisAoPublicat = affDppDateAvisAoPublicat;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "AFF_DPP_DATE_OUVERT_OT", length = 7)
	public Date getAffDppDateOuvertOt() {
		return this.affDppDateOuvertOt;
	}

	public void setAffDppDateOuvertOt(Date affDppDateOuvertOt) {
		this.affDppDateOuvertOt = affDppDateOuvertOt;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "AFF_DPP_DATE_OUVERT_OF", length = 7)
	public Date getAffDppDateOuvertOf() {
		return this.affDppDateOuvertOf;
	}

	public void setAffDppDateOuvertOf(Date affDppDateOuvertOf) {
		this.affDppDateOuvertOf = affDppDateOuvertOf;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "AFF_DPP_DATE_ELAB_RAPPORT", length = 7)
	public Date getAffDppDateElabRapport() {
		return this.affDppDateElabRapport;
	}

	public void setAffDppDateElabRapport(Date affDppDateElabRapport) {
		this.affDppDateElabRapport = affDppDateElabRapport;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "AFF_DPP_DATE_JUGEMENT_OFFRE", length = 7)
	public Date getAffDppDateJugementOffre() {
		return this.affDppDateJugementOffre;
	}

	public void setAffDppDateJugementOffre(Date affDppDateJugementOffre) {
		this.affDppDateJugementOffre = affDppDateJugementOffre;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "AFF_DPP_DATE_ATT_APPROB_DMP", length = 7)
	public Date getAffDppDateAttApprobDmp() {
		return this.affDppDateAttApprobDmp;
	}

	public void setAffDppDateAttApprobDmp(Date affDppDateAttApprobDmp) {
		this.affDppDateAttApprobDmp = affDppDateAttApprobDmp;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "AFF_DPP_DATE_ATT_APPRO_BAIL", length = 7)
	public Date getAffDppDateAttApproBail() {
		return this.affDppDateAttApproBail;
	}

	public void setAffDppDateAttApproBail(Date affDppDateAttApproBail) {
		this.affDppDateAttApproBail = affDppDateAttApproBail;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "AFF_DPP_DATE_NEGOCIATION", length = 7)
	public Date getAffDppDateNegociation() {
		return this.affDppDateNegociation;
	}

	public void setAffDppDateNegociation(Date affDppDateNegociation) {
		this.affDppDateNegociation = affDppDateNegociation;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "AFF_DPP_DATE_SIGNAT_ATTRIB", length = 7)
	public Date getAffDppDateSignatAttrib() {
		return this.affDppDateSignatAttrib;
	}

	public void setAffDppDateSignatAttrib(Date affDppDateSignatAttrib) {
		this.affDppDateSignatAttrib = affDppDateSignatAttrib;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "AFF_DPP_DATE_SIGNAT_AC", length = 7)
	public Date getAffDppDateSignatAc() {
		return this.affDppDateSignatAc;
	}

	public void setAffDppDateSignatAc(Date affDppDateSignatAc) {
		this.affDppDateSignatAc = affDppDateSignatAc;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "AFF_DPP_DATE_MARCHE_APPROB", length = 7)
	public Date getAffDppDateMarcheApprob() {
		return this.affDppDateMarcheApprob;
	}

	public void setAffDppDateMarcheApprob(Date affDppDateMarcheApprob) {
		this.affDppDateMarcheApprob = affDppDateMarcheApprob;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "AFF_DPP_DATE_EXEC_DEBUT", length = 7)
	public Date getAffDppDateExecDebut() {
		return this.affDppDateExecDebut;
	}

	public void setAffDppDateExecDebut(Date affDppDateExecDebut) {
		this.affDppDateExecDebut = affDppDateExecDebut;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "AFF_DPP_DATE_EXEC_FIN", length = 7)
	public Date getAffDppDateExecFin() {
		return this.affDppDateExecFin;
	}

	public void setAffDppDateExecFin(Date affDppDateExecFin) {
		this.affDppDateExecFin = affDppDateExecFin;
	}
	
	@Column(name = "AFF_DPP_ID", precision = 10, scale = 0)
	public long  getAffDppId() {
		return this.affDppId;
	}

	public void setAffDppId(long  affDppId) {
		this.affDppId = affDppId;
	}
	
	@Column(name = "AFF_DPP_STATUT_RETOUR", length = 10)
	public String getAffDppStatutRetour() {
		return this.affDppStatutRetour;
	}

	public void setAffDppStatutRetour(String affDppStatutRetour) {
		this.affDppStatutRetour = affDppStatutRetour;
	}
	
	@Column(name = "AFF_DPP_STR_CONDUC", length = 1000)
	public String getAffDppStrConduc() {
		return this.affDppStrConduc;
	}

	public void setAffDppStrConduc(String affDppStrConduc) {
		this.affDppStrConduc = affDppStrConduc;
	}

	@Column(name = "AFF_DPP_STR_BENEFI", length = 1000)
	public String getAffDppStrBenefi() {
		return this.affDppStrBenefi;
	}

	public void setAffDppStrBenefi(String affDppStrBenefi) {
		this.affDppStrBenefi = affDppStrBenefi;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "AFF_DPP_DATE_SAISIE", length = 7)
	public Date getAffDppDateSaisie() {
		return this.affDppDateSaisie;
	}

	public void setAffDppDateSaisie(Date affDppDateSaisie) {
		this.affDppDateSaisie = affDppDateSaisie;
	}
	
	@Column(name = "AFF_DPP_PARTIE_PME_PMI", length = 1)
	public String getAffDppPartiePmePmi() {
		return this.affDppPartiePmePmi;
	}

	public void setAffDppPartiePmePmi(String affDppPartiePmePmi) {
		this.affDppPartiePmePmi = affDppPartiePmePmi;
	}
	
	@Column(name = "AFF_DPP_STATUT_DAO", length = 2)
	public String getAffDppStatutDao() {
		return this.affDppStatutDao;
	}

	public void setAffDppStatutDao(String affDppStatutDao) {
		this.affDppStatutDao = affDppStatutDao;
	}
	
	@Column(name = "AFF_DPP_PIECE_DAO", length = 3)
	public String getAffDppPieceDao() {
		return this.affDppPieceDao;
	}

	public void setAffDppPieceDao(String affDppPieceDao) {
		this.affDppPieceDao = affDppPieceDao;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "AFF_DPP_INV_ENTRE", length = 7)
	public Date getAffDppInvEntre() {
		return this.affDppInvEntre;
	}

	public void setAffDppInvEntre(Date affDppInvEntre) {
		this.affDppInvEntre = affDppInvEntre;
	}
	
	@Column(name = "AFF_DPP_RECHERCHE", length = 4000)
	public String getAffDppRecherche() {
		return this.affDppRecherche;
	}

	public void setAffDppRecherche(String affDppRecherche) {
		this.affDppRecherche = affDppRecherche;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "AFF_DPP_DATE_VAL_AC", length = 7)
	public Date getAffDppDateValAc() {
		return this.affDppDateValAc;
	}

	public void setAffDppDateValAc(Date affDppDateValAc) {
		this.affDppDateValAc = affDppDateValAc;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "AFF_DPP_DATE_VAL_CPMP", length = 7)
	public Date getAffDppDateValCpmp() {
		return this.affDppDateValCpmp;
	}

	public void setAffDppDateValCpmp(Date affDppDateValCpmp) {
		this.affDppDateValCpmp = affDppDateValCpmp;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "AFF_DPP_DATE_VAL_DMP", length = 7)
	public Date getAffDppDateValDmp() {
		return this.affDppDateValDmp;
	}

	public void setAffDppDateValDmp(Date affDppDateValDmp) {
		this.affDppDateValDmp = affDppDateValDmp;
	}
	
	@Column(name = "AFF_DPP_BAILLEUR", length = 1)
	public String getAffDppBailleur() {
		return this.affDppBailleur;
	}

	public void setAffDppBailleur(String affDppBailleur) {
		this.affDppBailleur = affDppBailleur;
	}
	
	@Column(name = "AFF_DPP_TYPE_FINANCE", length = 20)
	public String getAffDppTypeFinance() {
		return this.affDppTypeFinance;
	}

	public void setAffDppTypeFinance(String affDppTypeFinance) {
		this.affDppTypeFinance = affDppTypeFinance;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "AFF_DPP_APPROB_ANO", length = 7)
	public Date getAffDppApprobAno() {
		return affDppApprobAno;
	}

	public void setAffDppApprobAno(Date affDppApprobAno) {
		this.affDppApprobAno = affDppApprobAno;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "AFF_DPP_DTE_MODIF", length = 7)
	public Date getAffDppDteModif() {
		return this.affDppDteModif;
	}

	public void setAffDppDteModif(Date affDppDteModif) {
		this.affDppDteModif = affDppDteModif;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "AFF_DPP_DATE_ATT_APPROB_CMP", length = 7)
	public Date getAffDppDateAttApprobCmp() {
		return this.affDppDateAttApprobCmp;
	}

	public void setAffDppDateAttApprobCmp(Date affDppDateAttApprobCmp) {
		this.affDppDateAttApprobCmp = affDppDateAttApprobCmp;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "AFF_DPP_DATE_JUGEMENT_TECH", length = 7)
	public Date getAffDppDateJugementTech() {
		return this.affDppDateJugementTech;
	}

	public void setAffDppDateJugementTech(Date affDppDateJugementTech) {
		this.affDppDateJugementTech = affDppDateJugementTech;
	}

}
