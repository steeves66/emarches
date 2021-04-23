package com.sndi.model;
// Generated 31 mai 2020 15:39:44 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Immutable;

/**
 * VPpmliste generated by hbm2java
 */
@Entity
@Immutable
@Table(name = "V_PPMLISTE")
public class VPpmliste implements java.io.Serializable {

	private long dppId;
	private Date dppDteModif;
	private String dppObjet;
	private String dppSourceFin;
	private String dppLbgCode;
	private String dppStaCode;
	private String dppMopCode;
	private String mopLibelleCourt;
	private String mopLibelleLong;
	private String dppStrCode;
	private String strLibelleCourt;
	private String strLibelleLong;
	private String lbgFonCodePf;
	private String lbgFonCodeAc;
	private String lbgFonCodeCf;
	private String lbgFonCodeCor;
	private String lbgImputation;
	private BigDecimal lbgTotDot;
	private BigDecimal lbgAeTr;
	private BigDecimal lbgDisTot;
	private String lbgFonCodeVal;
	private Date dppDateValAc;
	private Date dppDateValCpmp;
	private Date dppDateValDmp;
	private String dppPartiePmePmi;
	private Date dppDateSaisie;
	private String dppTypePlan;
	private String tymLibelleCourt;
	private String dppStatutRetour;
	private String dppStructureConduc;
	private String dppStructureBenefi;
	private String dppRecherche;
	private String dppFonCodPf;
	private String dppFonCodDmp;
	private String dppActeurSaisie;
	private Date dppDateAttApprobCpmp;
	private Date dppDateAvisAoPublication;
	private Date dppDateDaoApprobBail;
	private Date dppDateDaoApprobDmp;
	private Date dppDateDaoTrans;
	private Date dppDateElabRapport;
	private Date dppDateJugementOffre;
	private Date dppDateJugementOffreTec;
	private Date dppDateNotAtt;
	private Date dppDateOuvertOf;
	private Date dppDateOuvertOt;
	private Date dppDateRecepFact;
	private Date dppDateRecepLettr;
	private Date dppDateSolFact;
	private Date dppInvEntre;
	private Date dppDateExecDebut;
	private Date dppDateExecFin;
	private Date dppDateSignatAc;
	private Date dppDateSignatAttrib;
	private Date dppApprobAno;
	private Date dppDateNegociation;
	private Date dppDateMarcheApprob;
	private Date dppDateAttApproBail;
	private long plpId;
	private long plpGesCode;
	private Long dppNbOuv;
	private String cptFinancement;
	private String fonCodeDmp;
	private String fonCodeSpp;
	private String critere;
	private Date dppDateDaoTransPub;
	public VPpmliste() {
	}

	public VPpmliste(long dppId, String dppStaCode, String dppMopCode, String mopLibelleCourt, String dppTypePlan,
			String tymLibelleCourt, long plpId, long plpGesCode) {
		this.dppId = dppId;
		this.dppStaCode = dppStaCode;
		this.dppMopCode = dppMopCode;
		this.mopLibelleCourt = mopLibelleCourt;
		this.dppTypePlan = dppTypePlan;
		this.tymLibelleCourt = tymLibelleCourt;
		this.plpId = plpId;
		this.plpGesCode = plpGesCode;
	}

	public VPpmliste(long dppId, Date dppDteModif, String dppObjet, String dppSourceFin, String dppLbgCode,
			String dppStaCode, String dppMopCode, String mopLibelleCourt, String mopLibelleLong, String dppStrCode,
			String strLibelleCourt, String strLibelleLong,String lbgFonCodePf, String lbgFonCodeAc,
			String lbgFonCodeCf, String lbgFonCodeCor,String lbgImputation,BigDecimal lbgTotDot, BigDecimal lbgAeTr, BigDecimal lbgDisTot, String lbgFonCodeVal, Date dppDateValAc, Date dppDateValCpmp, Date dppDateValDmp,
			String dppPartiePmePmi, Date dppDateSaisie, String dppTypePlan, String tymLibelleCourt,
			String dppStatutRetour, String dppStructureConduc, String dppStructureBenefi, String dppRecherche,
			String dppFonCodPf, String dppFonCodDmp, String dppActeurSaisie,Date dppDateAttApprobCpmp,
			Date dppDateAvisAoPublication, Date dppDateDaoApprobBail, Date dppDateDaoApprobDmp, Date dppDateDaoTrans,
			Date dppDateElabRapport, Date dppDateJugementOffre, Date dppDateJugementOffreTec, Date dppDateNotAtt,
			Date dppDateOuvertOf, Date dppDateOuvertOt, Date dppDateRecepFact, Date dppDateRecepLettr,
			Date dppDateSolFact, Date dppInvEntre, Date dppDateExecDebut, Date dppDateExecFin, Date dppDateSignatAc,
			Date dppDateSignatAttrib, Date dppApprobAno, Date dppDateNegociation, Date dppDateMarcheApprob,Date dppDateAttApproBail,
			long plpId, long plpGesCode, Long dppNbOuv, String cptFinancement,
			String fonCodeDmp,String fonCodeSpp, String critere,Date dppDateDaoTransPub) {
		this.dppId = dppId;
		this.dppDteModif = dppDteModif;
		this.dppObjet = dppObjet;
		this.dppSourceFin = dppSourceFin;
		this.dppLbgCode = dppLbgCode;
		this.dppStaCode = dppStaCode;
		this.dppMopCode = dppMopCode;
		this.mopLibelleCourt = mopLibelleCourt;
		this.mopLibelleLong = mopLibelleLong;
		this.dppStrCode = dppStrCode;
		this.strLibelleCourt = strLibelleCourt;
		this.strLibelleLong = strLibelleLong;
		this.lbgFonCodePf = lbgFonCodePf;
		this.lbgFonCodeAc = lbgFonCodeAc;
		this.lbgFonCodeCf = lbgFonCodeCf;
		this.lbgFonCodeCor = lbgFonCodeCor;
		this.lbgImputation = lbgImputation;
		this.lbgTotDot = lbgTotDot;
		this.lbgAeTr = lbgAeTr;
		this.lbgDisTot = lbgDisTot;
		this.lbgFonCodeVal = lbgFonCodeVal;
		this.dppDateValAc = dppDateValAc;
		this.dppDateValCpmp = dppDateValCpmp;
		this.dppDateValDmp = dppDateValDmp;
		this.dppPartiePmePmi = dppPartiePmePmi;
		this.dppDateSaisie = dppDateSaisie;
		this.dppTypePlan = dppTypePlan;
		this.tymLibelleCourt = tymLibelleCourt;
		this.dppStatutRetour = dppStatutRetour;
		this.dppStructureConduc = dppStructureConduc;
		this.dppStructureBenefi = dppStructureBenefi;
		this.dppRecherche = dppRecherche;
		this.dppFonCodPf = dppFonCodPf;
		this.dppFonCodDmp = dppFonCodDmp;
		this.dppActeurSaisie = dppActeurSaisie;
		this.dppDateAttApprobCpmp = dppDateAttApprobCpmp;
		this.dppDateAvisAoPublication = dppDateAvisAoPublication;
		this.dppDateDaoApprobBail = dppDateDaoApprobBail;
		this.dppDateDaoApprobDmp = dppDateDaoApprobDmp;
		this.dppDateDaoTrans = dppDateDaoTrans;
		this.dppDateElabRapport = dppDateElabRapport;
		this.dppDateJugementOffre = dppDateJugementOffre;
		this.dppDateJugementOffreTec = dppDateJugementOffreTec;
		this.dppDateNotAtt = dppDateNotAtt;
		this.dppDateOuvertOf = dppDateOuvertOf;
		this.dppDateOuvertOt = dppDateOuvertOt;
		this.dppDateRecepFact = dppDateRecepFact;
		this.dppDateRecepLettr = dppDateRecepLettr;
		this.dppDateSolFact = dppDateSolFact;
		this.dppInvEntre = dppInvEntre;
		this.dppDateExecDebut = dppDateExecDebut;
		this.dppDateExecFin = dppDateExecFin;
		this.dppDateSignatAc = dppDateSignatAc;
		this.dppDateSignatAttrib = dppDateSignatAttrib;
		this.dppApprobAno = dppApprobAno;
		this.dppDateNegociation = dppDateNegociation;
		this.dppDateMarcheApprob = dppDateMarcheApprob;
		this.dppDateAttApproBail = dppDateAttApproBail;
		this.plpId = plpId;
		this.plpGesCode = plpGesCode;
		this.dppNbOuv = dppNbOuv;
		this.cptFinancement = cptFinancement;
		this.fonCodeDmp = fonCodeDmp;
		this.fonCodeSpp = fonCodeSpp;
		this.critere = critere;
		this.dppDateDaoTransPub = dppDateDaoTransPub;
	}

	@Id
	@Column(name = "DPP_ID", nullable = false, precision = 10, scale = 0)
	public long getDppId() {
		return this.dppId;
	}

	public void setDppId(long dppId) {
		this.dppId = dppId;
	}

	@Column(name = "DPP_DTE_MODIF", length = 7)
	public Date getDppDteModif() {
		return this.dppDteModif;
	}

	public void setDppDteModif(Date dppDteModif) {
		this.dppDteModif = dppDteModif;
	}

	@Column(name = "DPP_OBJET", length = 1000)
	public String getDppObjet() {
		return this.dppObjet;
	}

	public void setDppObjet(String dppObjet) {
		this.dppObjet = dppObjet;
	}

	@Column(name = "DPP_SOURCE_FIN", length = 1000)
	public String getDppSourceFin() {
		return this.dppSourceFin;
	}

	public void setDppSourceFin(String dppSourceFin) {
		this.dppSourceFin = dppSourceFin;
	}

	@Column(name = "DPP_LBG_CODE", length = 50)
	public String getDppLbgCode() {
		return this.dppLbgCode;
	}

	public void setDppLbgCode(String dppLbgCode) {
		this.dppLbgCode = dppLbgCode;
	}

	@Column(name = "DPP_STA_CODE", nullable = false, length = 3)
	public String getDppStaCode() {
		return this.dppStaCode;
	}

	public void setDppStaCode(String dppStaCode) {
		this.dppStaCode = dppStaCode;
	}

	@Column(name = "DPP_MOP_CODE", nullable = false, length = 3)
	public String getDppMopCode() {
		return this.dppMopCode;
	}

	public void setDppMopCode(String dppMopCode) {
		this.dppMopCode = dppMopCode;
	}

	@Column(name = "MOP_LIBELLE_COURT", nullable = false, length = 500)
	public String getMopLibelleCourt() {
		return this.mopLibelleCourt;
	}

	public void setMopLibelleCourt(String mopLibelleCourt) {
		this.mopLibelleCourt = mopLibelleCourt;
	}

	@Column(name = "MOP_LIBELLE_LONG", length = 1000)
	public String getMopLibelleLong() {
		return this.mopLibelleLong;
	}

	public void setMopLibelleLong(String mopLibelleLong) {
		this.mopLibelleLong = mopLibelleLong;
	}

	@Column(name = "DPP_STR_CODE", length = 20)
	public String getDppStrCode() {
		return this.dppStrCode;
	}

	public void setDppStrCode(String dppStrCode) {
		this.dppStrCode = dppStrCode;
	}

	@Column(name = "STR_LIBELLE_COURT", length = 500)
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
	
	@Column(name = "LBG_FON_CODE_PF", length = 30)
	public String getLbgFonCodePf() {
		return this.lbgFonCodePf;
	}

	public void setLbgFonCodePf(String lbgFonCodePf) {
		this.lbgFonCodePf = lbgFonCodePf;
	}

	@Column(name = "LBG_FON_CODE_AC", length = 30)
	public String getLbgFonCodeAc() {
		return this.lbgFonCodeAc;
	}

	public void setLbgFonCodeAc(String lbgFonCodeAc) {
		this.lbgFonCodeAc = lbgFonCodeAc;
	}

	@Column(name = "LBG_FON_CODE_CF", length = 30)
	public String getLbgFonCodeCf() {
		return this.lbgFonCodeCf;
	}

	public void setLbgFonCodeCf(String lbgFonCodeCf) {
		this.lbgFonCodeCf = lbgFonCodeCf;
	}

	@Column(name = "LBG_FON_CODE_COR", length = 30)
	public String getLbgFonCodeCor() {
		return this.lbgFonCodeCor;
	}

	public void setLbgFonCodeCor(String lbgFonCodeCor) {
		this.lbgFonCodeCor = lbgFonCodeCor;
	}
	
	@Column(name = "LBG_IMPUTATION", length = 50)
	public String getLbgImputation() {
		return this.lbgImputation;
	}

	public void setLbgImputation(String lbgImputation) {
		this.lbgImputation = lbgImputation;
	}
	
	@Column(name = "LBG_TOT_DOT", precision = 20, scale = 0)
	public BigDecimal getLbgTotDot() {
		return this.lbgTotDot;
	}

	public void setLbgTotDot(BigDecimal lbgTotDot) {
		this.lbgTotDot = lbgTotDot;
	}

	@Column(name = "LBG_AE_TR", precision = 20, scale = 0)
	public BigDecimal getLbgAeTr() {
		return this.lbgAeTr;
	}

	public void setLbgAeTr(BigDecimal lbgAeTr) {
		this.lbgAeTr = lbgAeTr;
	}

	@Column(name = "LBG_DIS_TOT", precision = 20, scale = 0)
	public BigDecimal getLbgDisTot() {
		return this.lbgDisTot;
	}

	public void setLbgDisTot(BigDecimal lbgDisTot) {
		this.lbgDisTot = lbgDisTot;
	}


	@Column(name = "LBG_FON_CODE_VAL", length = 10)
	public String getLbgFonCodeVal() {
		return this.lbgFonCodeVal;
	}

	public void setLbgFonCodeVal(String lbgFonCodeVal) {
		this.lbgFonCodeVal = lbgFonCodeVal;
	}

	@Column(name = "DPP_DATE_VAL_AC", length = 7)
	public Date getDppDateValAc() {
		return this.dppDateValAc;
	}

	public void setDppDateValAc(Date dppDateValAc) {
		this.dppDateValAc = dppDateValAc;
	}

	@Column(name = "DPP_DATE_VAL_CPMP", length = 7)
	public Date getDppDateValCpmp() {
		return this.dppDateValCpmp;
	}

	public void setDppDateValCpmp(Date dppDateValCpmp) {
		this.dppDateValCpmp = dppDateValCpmp;
	}

	@Column(name = "DPP_DATE_VAL_DMP", length = 7)
	public Date getDppDateValDmp() {
		return this.dppDateValDmp;
	}

	public void setDppDateValDmp(Date dppDateValDmp) {
		this.dppDateValDmp = dppDateValDmp;
	}

	@Column(name = "DPP_PARTIE_PME_PMI", length = 1)
	public String getDppPartiePmePmi() {
		return this.dppPartiePmePmi;
	}

	public void setDppPartiePmePmi(String dppPartiePmePmi) {
		this.dppPartiePmePmi = dppPartiePmePmi;
	}

	@Column(name = "DPP_DATE_SAISIE", length = 7)
	public Date getDppDateSaisie() {
		return this.dppDateSaisie;
	}

	public void setDppDateSaisie(Date dppDateSaisie) {
		this.dppDateSaisie = dppDateSaisie;
	}

	@Column(name = "DPP_TYPE_PLAN", nullable = false, length = 3)
	public String getDppTypePlan() {
		return this.dppTypePlan;
	}

	public void setDppTypePlan(String dppTypePlan) {
		this.dppTypePlan = dppTypePlan;
	}

	@Column(name = "TYM_LIBELLE_COURT", nullable = false, length = 500)
	public String getTymLibelleCourt() {
		return this.tymLibelleCourt;
	}

	public void setTymLibelleCourt(String tymLibelleCourt) {
		this.tymLibelleCourt = tymLibelleCourt;
	}

	@Column(name = "DPP_STATUT_RETOUR", length = 4)
	public String getDppStatutRetour() {
		return this.dppStatutRetour;
	}

	public void setDppStatutRetour(String dppStatutRetour) {
		this.dppStatutRetour = dppStatutRetour;
	}

	@Column(name = "DPP_STRUCTURE_CONDUC", length = 500)
	public String getDppStructureConduc() {
		return this.dppStructureConduc;
	}

	public void setDppStructureConduc(String dppStructureConduc) {
		this.dppStructureConduc = dppStructureConduc;
	}

	@Column(name = "DPP_STRUCTURE_BENEFI", length = 500)
	public String getDppStructureBenefi() {
		return this.dppStructureBenefi;
	}

	public void setDppStructureBenefi(String dppStructureBenefi) {
		this.dppStructureBenefi = dppStructureBenefi;
	}

	@Column(name = "DPP_RECHERCHE", length = 4000)
	public String getDppRecherche() {
		return this.dppRecherche;
	}

	public void setDppRecherche(String dppRecherche) {
		this.dppRecherche = dppRecherche;
	}

	@Column(name = "DPP_FON_COD_PF", length = 20)
	public String getDppFonCodPf() {
		return this.dppFonCodPf;
	}

	public void setDppFonCodPf(String dppFonCodPf) {
		this.dppFonCodPf = dppFonCodPf;
	}

	@Column(name = "DPP_FON_COD_DMP", length = 20)
	public String getDppFonCodDmp() {
		return this.dppFonCodDmp;
	}

	public void setDppFonCodDmp(String dppFonCodDmp) {
		this.dppFonCodDmp = dppFonCodDmp;
	}

	@Column(name = "DPP_ACTEUR_SAISIE", length = 12)
	public String getDppActeurSaisie() {
		return this.dppActeurSaisie;
	}

	public void setDppActeurSaisie(String dppActeurSaisie) {
		this.dppActeurSaisie = dppActeurSaisie;
	}
	
	@Column(name = "DPP_DATE_ATT_APPROB_CPMP", length = 7)
	public Date getDppDateAttApprobCpmp() {
		return this.dppDateAttApprobCpmp;
	}

	public void setDppDateAttApprobCpmp(Date dppDateAttApprobCpmp) {
		this.dppDateAttApprobCpmp = dppDateAttApprobCpmp;
	}

	@Column(name = "DPP_DATE_AVIS_AO_PUBLICATION", length = 7)
	public Date getDppDateAvisAoPublication() {
		return this.dppDateAvisAoPublication;
	}

	public void setDppDateAvisAoPublication(Date dppDateAvisAoPublication) {
		this.dppDateAvisAoPublication = dppDateAvisAoPublication;
	}

	@Column(name = "DPP_DATE_DAO_APPROB_BAIL", length = 7)
	public Date getDppDateDaoApprobBail() {
		return this.dppDateDaoApprobBail;
	}

	public void setDppDateDaoApprobBail(Date dppDateDaoApprobBail) {
		this.dppDateDaoApprobBail = dppDateDaoApprobBail;
	}

	@Column(name = "DPP_DATE_DAO_APPROB_DMP", length = 7)
	public Date getDppDateDaoApprobDmp() {
		return this.dppDateDaoApprobDmp;
	}

	public void setDppDateDaoApprobDmp(Date dppDateDaoApprobDmp) {
		this.dppDateDaoApprobDmp = dppDateDaoApprobDmp;
	}

	@Column(name = "DPP_DATE_DAO_TRANS", length = 7)
	public Date getDppDateDaoTrans() {
		return this.dppDateDaoTrans;
	}

	public void setDppDateDaoTrans(Date dppDateDaoTrans) {
		this.dppDateDaoTrans = dppDateDaoTrans;
	}

	@Column(name = "DPP_DATE_ELAB_RAPPORT", length = 7)
	public Date getDppDateElabRapport() {
		return this.dppDateElabRapport;
	}

	public void setDppDateElabRapport(Date dppDateElabRapport) {
		this.dppDateElabRapport = dppDateElabRapport;
	}

	@Column(name = "DPP_DATE_JUGEMENT_OFFRE", length = 7)
	public Date getDppDateJugementOffre() {
		return this.dppDateJugementOffre;
	}

	public void setDppDateJugementOffre(Date dppDateJugementOffre) {
		this.dppDateJugementOffre = dppDateJugementOffre;
	}

	@Column(name = "DPP_DATE_JUGEMENT_OFFRE_TEC", length = 7)
	public Date getDppDateJugementOffreTec() {
		return this.dppDateJugementOffreTec;
	}

	public void setDppDateJugementOffreTec(Date dppDateJugementOffreTec) {
		this.dppDateJugementOffreTec = dppDateJugementOffreTec;
	}

	@Column(name = "DPP_DATE_NOT_ATT", length = 7)
	public Date getDppDateNotAtt() {
		return this.dppDateNotAtt;
	}

	public void setDppDateNotAtt(Date dppDateNotAtt) {
		this.dppDateNotAtt = dppDateNotAtt;
	}

	@Column(name = "DPP_DATE_OUVERT_OF", length = 7)
	public Date getDppDateOuvertOf() {
		return this.dppDateOuvertOf;
	}

	public void setDppDateOuvertOf(Date dppDateOuvertOf) {
		this.dppDateOuvertOf = dppDateOuvertOf;
	}

	@Column(name = "DPP_DATE_OUVERT_OT", length = 7)
	public Date getDppDateOuvertOt() {
		return this.dppDateOuvertOt;
	}

	public void setDppDateOuvertOt(Date dppDateOuvertOt) {
		this.dppDateOuvertOt = dppDateOuvertOt;
	}

	@Column(name = "DPP_DATE_RECEP_FACT", length = 7)
	public Date getDppDateRecepFact() {
		return this.dppDateRecepFact;
	}

	public void setDppDateRecepFact(Date dppDateRecepFact) {
		this.dppDateRecepFact = dppDateRecepFact;
	}

	@Column(name = "DPP_DATE_RECEP_LETTR", length = 7)
	public Date getDppDateRecepLettr() {
		return this.dppDateRecepLettr;
	}

	public void setDppDateRecepLettr(Date dppDateRecepLettr) {
		this.dppDateRecepLettr = dppDateRecepLettr;
	}

	@Column(name = "DPP_DATE_SOL_FACT", length = 7)
	public Date getDppDateSolFact() {
		return this.dppDateSolFact;
	}

	public void setDppDateSolFact(Date dppDateSolFact) {
		this.dppDateSolFact = dppDateSolFact;
	}

	@Column(name = "DPP_INV_ENTRE", length = 7)
	public Date getDppInvEntre() {
		return this.dppInvEntre;
	}

	public void setDppInvEntre(Date dppInvEntre) {
		this.dppInvEntre = dppInvEntre;
	}

	@Column(name = "DPP_DATE_EXEC_DEBUT", length = 7)
	public Date getDppDateExecDebut() {
		return this.dppDateExecDebut;
	}

	public void setDppDateExecDebut(Date dppDateExecDebut) {
		this.dppDateExecDebut = dppDateExecDebut;
	}

	@Column(name = "DPP_DATE_EXEC_FIN", length = 7)
	public Date getDppDateExecFin() {
		return this.dppDateExecFin;
	}

	public void setDppDateExecFin(Date dppDateExecFin) {
		this.dppDateExecFin = dppDateExecFin;
	}

	@Column(name = "DPP_DATE_SIGNAT_AC", length = 7)
	public Date getDppDateSignatAc() {
		return this.dppDateSignatAc;
	}

	public void setDppDateSignatAc(Date dppDateSignatAc) {
		this.dppDateSignatAc = dppDateSignatAc;
	}

	@Column(name = "DPP_DATE_SIGNAT_ATTRIB", length = 7)
	public Date getDppDateSignatAttrib() {
		return this.dppDateSignatAttrib;
	}

	public void setDppDateSignatAttrib(Date dppDateSignatAttrib) {
		this.dppDateSignatAttrib = dppDateSignatAttrib;
	}
	
	@Column(name = "DPP_APPROB_ANO", length = 7)
	public Date getDppApprobAno() {
		return this.dppApprobAno;
	}

	public void setDppApprobAno(Date dppApprobAno) {
		this.dppApprobAno = dppApprobAno;
	}

	@Column(name = "DPP_DATE_NEGOCIATION", length = 7)
	public Date getDppDateNegociation() {
		return this.dppDateNegociation;
	}

	public void setDppDateNegociation(Date dppDateNegociation) {
		this.dppDateNegociation = dppDateNegociation;
	}

	@Column(name = "DPP_DATE_MARCHE_APPROB", length = 7)
	public Date getDppDateMarcheApprob() {
		return this.dppDateMarcheApprob;
	}

	public void setDppDateMarcheApprob(Date dppDateMarcheApprob) {
		this.dppDateMarcheApprob = dppDateMarcheApprob;
	}
	
	@Column(name = "DPP_DATE_ATT_APPRO_BAIL", length = 7)
	public Date getDppDateAttApproBail() {
		return this.dppDateAttApproBail;
	}

	public void setDppDateAttApproBail(Date dppDateAttApproBail) {
		this.dppDateAttApproBail = dppDateAttApproBail;
	}


	@Column(name = "PLP_ID", nullable = false, precision = 10, scale = 0)
	public long getPlpId() {
		return this.plpId;
	}

	public void setPlpId(long plpId) {
		this.plpId = plpId;
	}

	@Column(name = "PLP_GES_CODE", nullable = false, precision = 4, scale = 0)
	public long getPlpGesCode() {
		return this.plpGesCode;
	}

	public void setPlpGesCode(long plpGesCode) {
		this.plpGesCode = plpGesCode;
	}
	
	@Column(name = "DPP_NB_OUV")
	public Long getDppNbOuv() {
		return this.dppNbOuv;
	}

	public void setDppNbOuv(Long dppNbOuv) {
		this.dppNbOuv = dppNbOuv;
	}
	
	@Column(name = "CPT_FINANCEMENT")
	public String getCptFinancement() {
		return this.cptFinancement;
	}

	public void setCptFinancement(String cptFinancement) {
		this.cptFinancement = cptFinancement;
	}
	
	@Column(name = "FON_CODE_DMP")
	public String getFonCodeDmp() {
		return this.fonCodeDmp;
	}

	public void setFonCodeDmp(String fonCodeDmp) {
		this.fonCodeDmp = fonCodeDmp;
	}
	
	@Column(name = "FON_CODE_SPP", length = 150)
	public String getFonCodeSpp() {
		return this.fonCodeSpp;
	}

	public void setFonCodeSpp(String fonCodeSpp) {
		this.fonCodeSpp = fonCodeSpp;
	}
	
	@Column(name = "CRITERE")
	public String getCritere() {
		return this.critere;
	}

	public void setCritere(String critere) {
		this.critere = critere;
	}
	
	@Column(name = "DPP_DATE_DAO_TRANS_PUB", length = 7)
	public Date getDppDateDaoTransPub() {
		return dppDateDaoTransPub;
	}

	public void setDppDateDaoTransPub(Date dppDateDaoTransPub) {
		this.dppDateDaoTransPub = dppDateDaoTransPub;
	}


}
