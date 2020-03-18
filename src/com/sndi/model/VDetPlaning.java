package com.sndi.model;
// Generated 17 f�vr. 2020 20:49:04 by Hibernate Tools 4.3.5.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;

/**
 * VDetPlaningId generated by hbm2java
 */
@Embeddable
public class VDetPlaning implements java.io.Serializable {

	private Date dppDateExecFin;
	private Date dppDateExecDebut;
	private Date dppDateMarcheApprob;
	private Date dppDateSignatAc;
	private Date dppDateSignatAttrib;
	private Date dppDateNegociation;
	private Date dppDateAttApproBail;
	private Date dppDateAttApprobDmp;
	private Date dppDateJugementOffre;
	private Date dppDateElabRapport;
	private Date dppDateOuvertOf;
	private Date dppDateOuvertOt;
	private Date dppDateAvisAoPublication;
	private Date dppDateDaoApprobBail;
	private Date dppDateDaoApprobDmp;
	private Date dppDateDaoTrans;
	private String dppSourceFin;
	private String dppObjet;
	private Date dppDate;
	private Integer dppNumeroOrdre;
	private String dppCode;
	private String dppTypePlan;
	private String dppLbgCode;
	private String dppMopCode;
	private String dppTymCode;
	private String dppStaCode;
	private long dppGpgId;
	private long dppPlpId;
	private long dppId;
	private Date dppDateAttApprobCpmp;
	private Date dppInvEntre;
	private String dppDacCode;
	private String dppPieceDao;
	private String dppStatutDao;
	private String dppTypId;
	private String dppPartiePmePmi;
	private String dppStructureBenefi;
	private String dppStructureConduc;
	private Date dppDateSaisie;
	private String dppStatutRetour;
	private String dppStrCode;
	private String dppActeurSaisie;
	private Date dppDateJugementOffreTec;

	public VDetPlaning() {
	}

	public VDetPlaning(String dppTypePlan, String dppMopCode, String dppTymCode, String dppStaCode, long dppGpgId,
			long dppPlpId, long dppId) {
		this.dppTypePlan = dppTypePlan;
		this.dppMopCode = dppMopCode;
		this.dppTymCode = dppTymCode;
		this.dppStaCode = dppStaCode;
		this.dppGpgId = dppGpgId;
		this.dppPlpId = dppPlpId;
		this.dppId = dppId;
	}

	public VDetPlaning(Date dppDateExecFin, Date dppDateExecDebut, Date dppDateMarcheApprob, Date dppDateSignatAc,
			Date dppDateSignatAttrib, Date dppDateNegociation, Date dppDateAttApproBail, Date dppDateAttApprobDmp,
			Date dppDateJugementOffre, Date dppDateElabRapport, Date dppDateOuvertOf, Date dppDateOuvertOt,
			Date dppDateAvisAoPublication, Date dppDateDaoApprobBail, Date dppDateDaoApprobDmp, Date dppDateDaoTrans,
			String dppSourceFin, String dppObjet, Date dppDate, Integer dppNumeroOrdre, String dppCode,
			String dppTypePlan, String dppLbgCode, String dppMopCode, String dppTymCode, String dppStaCode,
			long dppGpgId, long dppPlpId, long dppId, Date dppDateAttApprobCpmp, Date dppInvEntre, String dppDacCode,
			String dppPieceDao, String dppStatutDao, String dppTypId, String dppPartiePmePmi, String dppStructureBenefi,
			String dppStructureConduc, Date dppDateSaisie, String dppStatutRetour, String dppStrCode,
			String dppActeurSaisie, Date dppDateJugementOffreTec) {
		this.dppDateExecFin = dppDateExecFin;
		this.dppDateExecDebut = dppDateExecDebut;
		this.dppDateMarcheApprob = dppDateMarcheApprob;
		this.dppDateSignatAc = dppDateSignatAc;
		this.dppDateSignatAttrib = dppDateSignatAttrib;
		this.dppDateNegociation = dppDateNegociation;
		this.dppDateAttApproBail = dppDateAttApproBail;
		this.dppDateAttApprobDmp = dppDateAttApprobDmp;
		this.dppDateJugementOffre = dppDateJugementOffre;
		this.dppDateElabRapport = dppDateElabRapport;
		this.dppDateOuvertOf = dppDateOuvertOf;
		this.dppDateOuvertOt = dppDateOuvertOt;
		this.dppDateAvisAoPublication = dppDateAvisAoPublication;
		this.dppDateDaoApprobBail = dppDateDaoApprobBail;
		this.dppDateDaoApprobDmp = dppDateDaoApprobDmp;
		this.dppDateDaoTrans = dppDateDaoTrans;
		this.dppSourceFin = dppSourceFin;
		this.dppObjet = dppObjet;
		this.dppDate = dppDate;
		this.dppNumeroOrdre = dppNumeroOrdre;
		this.dppCode = dppCode;
		this.dppTypePlan = dppTypePlan;
		this.dppLbgCode = dppLbgCode;
		this.dppMopCode = dppMopCode;
		this.dppTymCode = dppTymCode;
		this.dppStaCode = dppStaCode;
		this.dppGpgId = dppGpgId;
		this.dppPlpId = dppPlpId;
		this.dppId = dppId;
		this.dppDateAttApprobCpmp = dppDateAttApprobCpmp;
		this.dppInvEntre = dppInvEntre;
		this.dppDacCode = dppDacCode;
		this.dppPieceDao = dppPieceDao;
		this.dppStatutDao = dppStatutDao;
		this.dppTypId = dppTypId;
		this.dppPartiePmePmi = dppPartiePmePmi;
		this.dppStructureBenefi = dppStructureBenefi;
		this.dppStructureConduc = dppStructureConduc;
		this.dppDateSaisie = dppDateSaisie;
		this.dppStatutRetour = dppStatutRetour;
		this.dppStrCode = dppStrCode;
		this.dppActeurSaisie = dppActeurSaisie;
		this.dppDateJugementOffreTec = dppDateJugementOffreTec;
	}
	
	@Id
	@Column(name = "DPP_ID", nullable = false, precision = 10, scale = 0)
	public long getDppId() {
		return this.dppId;
	}

	public void setDppId(long dppId) {
		this.dppId = dppId;
	}

	@Column(name = "DPP_DATE_EXEC_FIN", length = 7)
	public Date getDppDateExecFin() {
		return this.dppDateExecFin;
	}

	public void setDppDateExecFin(Date dppDateExecFin) {
		this.dppDateExecFin = dppDateExecFin;
	}

	@Column(name = "DPP_DATE_EXEC_DEBUT", length = 7)
	public Date getDppDateExecDebut() {
		return this.dppDateExecDebut;
	}

	public void setDppDateExecDebut(Date dppDateExecDebut) {
		this.dppDateExecDebut = dppDateExecDebut;
	}

	@Column(name = "DPP_DATE_MARCHE_APPROB", length = 7)
	public Date getDppDateMarcheApprob() {
		return this.dppDateMarcheApprob;
	}

	public void setDppDateMarcheApprob(Date dppDateMarcheApprob) {
		this.dppDateMarcheApprob = dppDateMarcheApprob;
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

	@Column(name = "DPP_DATE_NEGOCIATION", length = 7)
	public Date getDppDateNegociation() {
		return this.dppDateNegociation;
	}

	public void setDppDateNegociation(Date dppDateNegociation) {
		this.dppDateNegociation = dppDateNegociation;
	}

	@Column(name = "DPP_DATE_ATT_APPRO_BAIL", length = 7)
	public Date getDppDateAttApproBail() {
		return this.dppDateAttApproBail;
	}

	public void setDppDateAttApproBail(Date dppDateAttApproBail) {
		this.dppDateAttApproBail = dppDateAttApproBail;
	}

	@Column(name = "DPP_DATE_ATT_APPROB_DMP", length = 7)
	public Date getDppDateAttApprobDmp() {
		return this.dppDateAttApprobDmp;
	}

	public void setDppDateAttApprobDmp(Date dppDateAttApprobDmp) {
		this.dppDateAttApprobDmp = dppDateAttApprobDmp;
	}

	@Column(name = "DPP_DATE_JUGEMENT_OFFRE", length = 7)
	public Date getDppDateJugementOffre() {
		return this.dppDateJugementOffre;
	}

	public void setDppDateJugementOffre(Date dppDateJugementOffre) {
		this.dppDateJugementOffre = dppDateJugementOffre;
	}

	@Column(name = "DPP_DATE_ELAB_RAPPORT", length = 7)
	public Date getDppDateElabRapport() {
		return this.dppDateElabRapport;
	}

	public void setDppDateElabRapport(Date dppDateElabRapport) {
		this.dppDateElabRapport = dppDateElabRapport;
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

	@Column(name = "DPP_SOURCE_FIN", length = 1000)
	public String getDppSourceFin() {
		return this.dppSourceFin;
	}

	public void setDppSourceFin(String dppSourceFin) {
		this.dppSourceFin = dppSourceFin;
	}

	@Column(name = "DPP_OBJET", length = 1000)
	public String getDppObjet() {
		return this.dppObjet;
	}

	public void setDppObjet(String dppObjet) {
		this.dppObjet = dppObjet;
	}

	@Column(name = "DPP_DATE", length = 7)
	public Date getDppDate() {
		return this.dppDate;
	}

	public void setDppDate(Date dppDate) {
		this.dppDate = dppDate;
	}

	@Column(name = "DPP_NUMERO_ORDRE", precision = 8, scale = 0)
	public Integer getDppNumeroOrdre() {
		return this.dppNumeroOrdre;
	}

	public void setDppNumeroOrdre(Integer dppNumeroOrdre) {
		this.dppNumeroOrdre = dppNumeroOrdre;
	}

	@Column(name = "DPP_CODE", length = 50)
	public String getDppCode() {
		return this.dppCode;
	}

	public void setDppCode(String dppCode) {
		this.dppCode = dppCode;
	}

	@Column(name = "DPP_TYPE_PLAN", nullable = false, length = 3)
	public String getDppTypePlan() {
		return this.dppTypePlan;
	}

	public void setDppTypePlan(String dppTypePlan) {
		this.dppTypePlan = dppTypePlan;
	}

	@Column(name = "DPP_LBG_CODE", length = 50)
	public String getDppLbgCode() {
		return this.dppLbgCode;
	}

	public void setDppLbgCode(String dppLbgCode) {
		this.dppLbgCode = dppLbgCode;
	}

	@Column(name = "DPP_MOP_CODE", nullable = false, length = 3)
	public String getDppMopCode() {
		return this.dppMopCode;
	}

	public void setDppMopCode(String dppMopCode) {
		this.dppMopCode = dppMopCode;
	}

	@Column(name = "DPP_TYM_CODE", nullable = false, length = 3)
	public String getDppTymCode() {
		return this.dppTymCode;
	}

	public void setDppTymCode(String dppTymCode) {
		this.dppTymCode = dppTymCode;
	}

	@Column(name = "DPP_STA_CODE", nullable = false, length = 3)
	public String getDppStaCode() {
		return this.dppStaCode;
	}

	public void setDppStaCode(String dppStaCode) {
		this.dppStaCode = dppStaCode;
	}

	@Column(name = "DPP_GPG_ID", nullable = false, precision = 10, scale = 0)
	public long getDppGpgId() {
		return this.dppGpgId;
	}

	public void setDppGpgId(long dppGpgId) {
		this.dppGpgId = dppGpgId;
	}

	@Column(name = "DPP_PLP_ID", nullable = false, precision = 10, scale = 0)
	public long getDppPlpId() {
		return this.dppPlpId;
	}

	public void setDppPlpId(long dppPlpId) {
		this.dppPlpId = dppPlpId;
	}


	@Column(name = "DPP_DATE_ATT_APPROB_CPMP", length = 7)
	public Date getDppDateAttApprobCpmp() {
		return this.dppDateAttApprobCpmp;
	}

	public void setDppDateAttApprobCpmp(Date dppDateAttApprobCpmp) {
		this.dppDateAttApprobCpmp = dppDateAttApprobCpmp;
	}

	@Column(name = "DPP_INV_ENTRE", length = 7)
	public Date getDppInvEntre() {
		return this.dppInvEntre;
	}

	public void setDppInvEntre(Date dppInvEntre) {
		this.dppInvEntre = dppInvEntre;
	}

	@Column(name = "DPP_DAC_CODE", length = 20)
	public String getDppDacCode() {
		return this.dppDacCode;
	}

	public void setDppDacCode(String dppDacCode) {
		this.dppDacCode = dppDacCode;
	}

	@Column(name = "DPP_PIECE_DAO", length = 15)
	public String getDppPieceDao() {
		return this.dppPieceDao;
	}

	public void setDppPieceDao(String dppPieceDao) {
		this.dppPieceDao = dppPieceDao;
	}

	@Column(name = "DPP_STATUT_DAO", length = 2)
	public String getDppStatutDao() {
		return this.dppStatutDao;
	}

	public void setDppStatutDao(String dppStatutDao) {
		this.dppStatutDao = dppStatutDao;
	}

	@Column(name = "DPP_TYP_ID", length = 5)
	public String getDppTypId() {
		return this.dppTypId;
	}

	public void setDppTypId(String dppTypId) {
		this.dppTypId = dppTypId;
	}

	@Column(name = "DPP_PARTIE_PME_PMI", length = 1)
	public String getDppPartiePmePmi() {
		return this.dppPartiePmePmi;
	}

	public void setDppPartiePmePmi(String dppPartiePmePmi) {
		this.dppPartiePmePmi = dppPartiePmePmi;
	}

	@Column(name = "DPP_STRUCTURE_BENEFI", length = 500)
	public String getDppStructureBenefi() {
		return this.dppStructureBenefi;
	}

	public void setDppStructureBenefi(String dppStructureBenefi) {
		this.dppStructureBenefi = dppStructureBenefi;
	}

	@Column(name = "DPP_STRUCTURE_CONDUC", length = 500)
	public String getDppStructureConduc() {
		return this.dppStructureConduc;
	}

	public void setDppStructureConduc(String dppStructureConduc) {
		this.dppStructureConduc = dppStructureConduc;
	}

	@Column(name = "DPP_DATE_SAISIE", length = 7)
	public Date getDppDateSaisie() {
		return this.dppDateSaisie;
	}

	public void setDppDateSaisie(Date dppDateSaisie) {
		this.dppDateSaisie = dppDateSaisie;
	}

	@Column(name = "DPP_STATUT_RETOUR", length = 4)
	public String getDppStatutRetour() {
		return this.dppStatutRetour;
	}

	public void setDppStatutRetour(String dppStatutRetour) {
		this.dppStatutRetour = dppStatutRetour;
	}

	@Column(name = "DPP_STR_CODE", length = 3)
	public String getDppStrCode() {
		return this.dppStrCode;
	}

	public void setDppStrCode(String dppStrCode) {
		this.dppStrCode = dppStrCode;
	}

	@Column(name = "DPP_ACTEUR_SAISIE", length = 12)
	public String getDppActeurSaisie() {
		return this.dppActeurSaisie;
	}

	public void setDppActeurSaisie(String dppActeurSaisie) {
		this.dppActeurSaisie = dppActeurSaisie;
	}

	@Column(name = "DPP_DATE_JUGEMENT_OFFRE_TEC", length = 7)
	public Date getDppDateJugementOffreTec() {
		return this.dppDateJugementOffreTec;
	}

	public void setDppDateJugementOffreTec(Date dppDateJugementOffreTec) {
		this.dppDateJugementOffreTec = dppDateJugementOffreTec;
	}

}
