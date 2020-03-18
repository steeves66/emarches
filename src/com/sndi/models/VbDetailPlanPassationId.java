package com.sndi.models;
// Generated 14 mars 2020 14:41:40 by Hibernate Tools 4.3.5.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VbDetailPlanPassationId generated by hbm2java
 */
@Embeddable
public class VbDetailPlanPassationId implements java.io.Serializable {

	private long dppId;
	private long dppPlpId;
	private long dppGpgId;
	private String dppStaCode;
	private String dppTymCode;
	private String dppMopCode;
	private String dppLbgCode;
	private String dppTypePlan;
	private String dppCode;
	private Integer dppNumeroOrdre;
	private Date dppDate;
	private String dppObjet;
	private String dppSourceFin;
	private Date dppDateDaoTrans;
	private Date dppDateDaoApprobDmp;
	private Date dppDateDaoApprobBail;
	private Date dppDateAvisAoPublication;
	private Date dppDateOuvertOt;
	private Date dppDateOuvertOf;
	private Date dppDateElabRapport;
	private Date dppDateJugementOffre;
	private Date dppDateAttApprobDmp;
	private Date dppDateAttApproBail;
	private Date dppDateNegociation;
	private Date dppDateSignatAttrib;
	private Date dppDateSignatAc;
	private Date dppDateMarcheApprob;
	private Date dppDateExecDebut;
	private Date dppDateExecFin;
	private String dppActeurSaisie;
	private String dppStrCode;
	private String dppStatutRetour;
	private Date dppDateSaisie;
	private String dppStructureConduc;
	private String dppStructureBenefi;
	private String dppPartiePmePmi;
	private String dppTypId;
	private String dppStatutDao;
	private String dppPieceDao;
	private String dppDacCode;
	private Date dppInvEntre;
	private Date dppDateAttApprobCpmp;
	private Date dppDateJugementOffreTec;

	public VbDetailPlanPassationId() {
	}

	public VbDetailPlanPassationId(long dppId, long dppPlpId, long dppGpgId, String dppStaCode, String dppTymCode,
			String dppMopCode, String dppTypePlan) {
		this.dppId = dppId;
		this.dppPlpId = dppPlpId;
		this.dppGpgId = dppGpgId;
		this.dppStaCode = dppStaCode;
		this.dppTymCode = dppTymCode;
		this.dppMopCode = dppMopCode;
		this.dppTypePlan = dppTypePlan;
	}

	public VbDetailPlanPassationId(long dppId, long dppPlpId, long dppGpgId, String dppStaCode, String dppTymCode,
			String dppMopCode, String dppLbgCode, String dppTypePlan, String dppCode, Integer dppNumeroOrdre,
			Date dppDate, String dppObjet, String dppSourceFin, Date dppDateDaoTrans, Date dppDateDaoApprobDmp,
			Date dppDateDaoApprobBail, Date dppDateAvisAoPublication, Date dppDateOuvertOt, Date dppDateOuvertOf,
			Date dppDateElabRapport, Date dppDateJugementOffre, Date dppDateAttApprobDmp, Date dppDateAttApproBail,
			Date dppDateNegociation, Date dppDateSignatAttrib, Date dppDateSignatAc, Date dppDateMarcheApprob,
			Date dppDateExecDebut, Date dppDateExecFin, String dppActeurSaisie, String dppStrCode,
			String dppStatutRetour, Date dppDateSaisie, String dppStructureConduc, String dppStructureBenefi,
			String dppPartiePmePmi, String dppTypId, String dppStatutDao, String dppPieceDao, String dppDacCode,
			Date dppInvEntre, Date dppDateAttApprobCpmp, Date dppDateJugementOffreTec) {
		this.dppId = dppId;
		this.dppPlpId = dppPlpId;
		this.dppGpgId = dppGpgId;
		this.dppStaCode = dppStaCode;
		this.dppTymCode = dppTymCode;
		this.dppMopCode = dppMopCode;
		this.dppLbgCode = dppLbgCode;
		this.dppTypePlan = dppTypePlan;
		this.dppCode = dppCode;
		this.dppNumeroOrdre = dppNumeroOrdre;
		this.dppDate = dppDate;
		this.dppObjet = dppObjet;
		this.dppSourceFin = dppSourceFin;
		this.dppDateDaoTrans = dppDateDaoTrans;
		this.dppDateDaoApprobDmp = dppDateDaoApprobDmp;
		this.dppDateDaoApprobBail = dppDateDaoApprobBail;
		this.dppDateAvisAoPublication = dppDateAvisAoPublication;
		this.dppDateOuvertOt = dppDateOuvertOt;
		this.dppDateOuvertOf = dppDateOuvertOf;
		this.dppDateElabRapport = dppDateElabRapport;
		this.dppDateJugementOffre = dppDateJugementOffre;
		this.dppDateAttApprobDmp = dppDateAttApprobDmp;
		this.dppDateAttApproBail = dppDateAttApproBail;
		this.dppDateNegociation = dppDateNegociation;
		this.dppDateSignatAttrib = dppDateSignatAttrib;
		this.dppDateSignatAc = dppDateSignatAc;
		this.dppDateMarcheApprob = dppDateMarcheApprob;
		this.dppDateExecDebut = dppDateExecDebut;
		this.dppDateExecFin = dppDateExecFin;
		this.dppActeurSaisie = dppActeurSaisie;
		this.dppStrCode = dppStrCode;
		this.dppStatutRetour = dppStatutRetour;
		this.dppDateSaisie = dppDateSaisie;
		this.dppStructureConduc = dppStructureConduc;
		this.dppStructureBenefi = dppStructureBenefi;
		this.dppPartiePmePmi = dppPartiePmePmi;
		this.dppTypId = dppTypId;
		this.dppStatutDao = dppStatutDao;
		this.dppPieceDao = dppPieceDao;
		this.dppDacCode = dppDacCode;
		this.dppInvEntre = dppInvEntre;
		this.dppDateAttApprobCpmp = dppDateAttApprobCpmp;
		this.dppDateJugementOffreTec = dppDateJugementOffreTec;
	}

	@Column(name = "DPP_ID", nullable = false, precision = 10, scale = 0)
	public long getDppId() {
		return this.dppId;
	}

	public void setDppId(long dppId) {
		this.dppId = dppId;
	}

	@Column(name = "DPP_PLP_ID", nullable = false, precision = 10, scale = 0)
	public long getDppPlpId() {
		return this.dppPlpId;
	}

	public void setDppPlpId(long dppPlpId) {
		this.dppPlpId = dppPlpId;
	}

	@Column(name = "DPP_GPG_ID", nullable = false, precision = 10, scale = 0)
	public long getDppGpgId() {
		return this.dppGpgId;
	}

	public void setDppGpgId(long dppGpgId) {
		this.dppGpgId = dppGpgId;
	}

	@Column(name = "DPP_STA_CODE", nullable = false, length = 3)
	public String getDppStaCode() {
		return this.dppStaCode;
	}

	public void setDppStaCode(String dppStaCode) {
		this.dppStaCode = dppStaCode;
	}

	@Column(name = "DPP_TYM_CODE", nullable = false, length = 3)
	public String getDppTymCode() {
		return this.dppTymCode;
	}

	public void setDppTymCode(String dppTymCode) {
		this.dppTymCode = dppTymCode;
	}

	@Column(name = "DPP_MOP_CODE", nullable = false, length = 3)
	public String getDppMopCode() {
		return this.dppMopCode;
	}

	public void setDppMopCode(String dppMopCode) {
		this.dppMopCode = dppMopCode;
	}

	@Column(name = "DPP_LBG_CODE", length = 50)
	public String getDppLbgCode() {
		return this.dppLbgCode;
	}

	public void setDppLbgCode(String dppLbgCode) {
		this.dppLbgCode = dppLbgCode;
	}

	@Column(name = "DPP_TYPE_PLAN", nullable = false, length = 3)
	public String getDppTypePlan() {
		return this.dppTypePlan;
	}

	public void setDppTypePlan(String dppTypePlan) {
		this.dppTypePlan = dppTypePlan;
	}

	@Column(name = "DPP_CODE", length = 50)
	public String getDppCode() {
		return this.dppCode;
	}

	public void setDppCode(String dppCode) {
		this.dppCode = dppCode;
	}

	@Column(name = "DPP_NUMERO_ORDRE", precision = 8, scale = 0)
	public Integer getDppNumeroOrdre() {
		return this.dppNumeroOrdre;
	}

	public void setDppNumeroOrdre(Integer dppNumeroOrdre) {
		this.dppNumeroOrdre = dppNumeroOrdre;
	}

	@Column(name = "DPP_DATE", length = 7)
	public Date getDppDate() {
		return this.dppDate;
	}

	public void setDppDate(Date dppDate) {
		this.dppDate = dppDate;
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

	@Column(name = "DPP_DATE_DAO_TRANS", length = 7)
	public Date getDppDateDaoTrans() {
		return this.dppDateDaoTrans;
	}

	public void setDppDateDaoTrans(Date dppDateDaoTrans) {
		this.dppDateDaoTrans = dppDateDaoTrans;
	}

	@Column(name = "DPP_DATE_DAO_APPROB_DMP", length = 7)
	public Date getDppDateDaoApprobDmp() {
		return this.dppDateDaoApprobDmp;
	}

	public void setDppDateDaoApprobDmp(Date dppDateDaoApprobDmp) {
		this.dppDateDaoApprobDmp = dppDateDaoApprobDmp;
	}

	@Column(name = "DPP_DATE_DAO_APPROB_BAIL", length = 7)
	public Date getDppDateDaoApprobBail() {
		return this.dppDateDaoApprobBail;
	}

	public void setDppDateDaoApprobBail(Date dppDateDaoApprobBail) {
		this.dppDateDaoApprobBail = dppDateDaoApprobBail;
	}

	@Column(name = "DPP_DATE_AVIS_AO_PUBLICATION", length = 7)
	public Date getDppDateAvisAoPublication() {
		return this.dppDateAvisAoPublication;
	}

	public void setDppDateAvisAoPublication(Date dppDateAvisAoPublication) {
		this.dppDateAvisAoPublication = dppDateAvisAoPublication;
	}

	@Column(name = "DPP_DATE_OUVERT_OT", length = 7)
	public Date getDppDateOuvertOt() {
		return this.dppDateOuvertOt;
	}

	public void setDppDateOuvertOt(Date dppDateOuvertOt) {
		this.dppDateOuvertOt = dppDateOuvertOt;
	}

	@Column(name = "DPP_DATE_OUVERT_OF", length = 7)
	public Date getDppDateOuvertOf() {
		return this.dppDateOuvertOf;
	}

	public void setDppDateOuvertOf(Date dppDateOuvertOf) {
		this.dppDateOuvertOf = dppDateOuvertOf;
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

	@Column(name = "DPP_DATE_ATT_APPROB_DMP", length = 7)
	public Date getDppDateAttApprobDmp() {
		return this.dppDateAttApprobDmp;
	}

	public void setDppDateAttApprobDmp(Date dppDateAttApprobDmp) {
		this.dppDateAttApprobDmp = dppDateAttApprobDmp;
	}

	@Column(name = "DPP_DATE_ATT_APPRO_BAIL", length = 7)
	public Date getDppDateAttApproBail() {
		return this.dppDateAttApproBail;
	}

	public void setDppDateAttApproBail(Date dppDateAttApproBail) {
		this.dppDateAttApproBail = dppDateAttApproBail;
	}

	@Column(name = "DPP_DATE_NEGOCIATION", length = 7)
	public Date getDppDateNegociation() {
		return this.dppDateNegociation;
	}

	public void setDppDateNegociation(Date dppDateNegociation) {
		this.dppDateNegociation = dppDateNegociation;
	}

	@Column(name = "DPP_DATE_SIGNAT_ATTRIB", length = 7)
	public Date getDppDateSignatAttrib() {
		return this.dppDateSignatAttrib;
	}

	public void setDppDateSignatAttrib(Date dppDateSignatAttrib) {
		this.dppDateSignatAttrib = dppDateSignatAttrib;
	}

	@Column(name = "DPP_DATE_SIGNAT_AC", length = 7)
	public Date getDppDateSignatAc() {
		return this.dppDateSignatAc;
	}

	public void setDppDateSignatAc(Date dppDateSignatAc) {
		this.dppDateSignatAc = dppDateSignatAc;
	}

	@Column(name = "DPP_DATE_MARCHE_APPROB", length = 7)
	public Date getDppDateMarcheApprob() {
		return this.dppDateMarcheApprob;
	}

	public void setDppDateMarcheApprob(Date dppDateMarcheApprob) {
		this.dppDateMarcheApprob = dppDateMarcheApprob;
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

	@Column(name = "DPP_ACTEUR_SAISIE", length = 12)
	public String getDppActeurSaisie() {
		return this.dppActeurSaisie;
	}

	public void setDppActeurSaisie(String dppActeurSaisie) {
		this.dppActeurSaisie = dppActeurSaisie;
	}

	@Column(name = "DPP_STR_CODE", length = 3)
	public String getDppStrCode() {
		return this.dppStrCode;
	}

	public void setDppStrCode(String dppStrCode) {
		this.dppStrCode = dppStrCode;
	}

	@Column(name = "DPP_STATUT_RETOUR", length = 4)
	public String getDppStatutRetour() {
		return this.dppStatutRetour;
	}

	public void setDppStatutRetour(String dppStatutRetour) {
		this.dppStatutRetour = dppStatutRetour;
	}

	@Column(name = "DPP_DATE_SAISIE", length = 7)
	public Date getDppDateSaisie() {
		return this.dppDateSaisie;
	}

	public void setDppDateSaisie(Date dppDateSaisie) {
		this.dppDateSaisie = dppDateSaisie;
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

	@Column(name = "DPP_PARTIE_PME_PMI", length = 1)
	public String getDppPartiePmePmi() {
		return this.dppPartiePmePmi;
	}

	public void setDppPartiePmePmi(String dppPartiePmePmi) {
		this.dppPartiePmePmi = dppPartiePmePmi;
	}

	@Column(name = "DPP_TYP_ID", length = 5)
	public String getDppTypId() {
		return this.dppTypId;
	}

	public void setDppTypId(String dppTypId) {
		this.dppTypId = dppTypId;
	}

	@Column(name = "DPP_STATUT_DAO", length = 2)
	public String getDppStatutDao() {
		return this.dppStatutDao;
	}

	public void setDppStatutDao(String dppStatutDao) {
		this.dppStatutDao = dppStatutDao;
	}

	@Column(name = "DPP_PIECE_DAO", length = 15)
	public String getDppPieceDao() {
		return this.dppPieceDao;
	}

	public void setDppPieceDao(String dppPieceDao) {
		this.dppPieceDao = dppPieceDao;
	}

	@Column(name = "DPP_DAC_CODE", length = 20)
	public String getDppDacCode() {
		return this.dppDacCode;
	}

	public void setDppDacCode(String dppDacCode) {
		this.dppDacCode = dppDacCode;
	}

	@Column(name = "DPP_INV_ENTRE", length = 7)
	public Date getDppInvEntre() {
		return this.dppInvEntre;
	}

	public void setDppInvEntre(Date dppInvEntre) {
		this.dppInvEntre = dppInvEntre;
	}

	@Column(name = "DPP_DATE_ATT_APPROB_CPMP", length = 7)
	public Date getDppDateAttApprobCpmp() {
		return this.dppDateAttApprobCpmp;
	}

	public void setDppDateAttApprobCpmp(Date dppDateAttApprobCpmp) {
		this.dppDateAttApprobCpmp = dppDateAttApprobCpmp;
	}

	@Column(name = "DPP_DATE_JUGEMENT_OFFRE_TEC", length = 7)
	public Date getDppDateJugementOffreTec() {
		return this.dppDateJugementOffreTec;
	}

	public void setDppDateJugementOffreTec(Date dppDateJugementOffreTec) {
		this.dppDateJugementOffreTec = dppDateJugementOffreTec;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VbDetailPlanPassationId))
			return false;
		VbDetailPlanPassationId castOther = (VbDetailPlanPassationId) other;

		return (this.getDppId() == castOther.getDppId()) && (this.getDppPlpId() == castOther.getDppPlpId())
				&& (this.getDppGpgId() == castOther.getDppGpgId())
				&& ((this.getDppStaCode() == castOther.getDppStaCode()) || (this.getDppStaCode() != null
						&& castOther.getDppStaCode() != null && this.getDppStaCode().equals(castOther.getDppStaCode())))
				&& ((this.getDppTymCode() == castOther.getDppTymCode()) || (this.getDppTymCode() != null
						&& castOther.getDppTymCode() != null && this.getDppTymCode().equals(castOther.getDppTymCode())))
				&& ((this.getDppMopCode() == castOther.getDppMopCode()) || (this.getDppMopCode() != null
						&& castOther.getDppMopCode() != null && this.getDppMopCode().equals(castOther.getDppMopCode())))
				&& ((this.getDppLbgCode() == castOther.getDppLbgCode()) || (this.getDppLbgCode() != null
						&& castOther.getDppLbgCode() != null && this.getDppLbgCode().equals(castOther.getDppLbgCode())))
				&& ((this.getDppTypePlan() == castOther.getDppTypePlan())
						|| (this.getDppTypePlan() != null && castOther.getDppTypePlan() != null
								&& this.getDppTypePlan().equals(castOther.getDppTypePlan())))
				&& ((this.getDppCode() == castOther.getDppCode()) || (this.getDppCode() != null
						&& castOther.getDppCode() != null && this.getDppCode().equals(castOther.getDppCode())))
				&& ((this.getDppNumeroOrdre() == castOther.getDppNumeroOrdre())
						|| (this.getDppNumeroOrdre() != null && castOther.getDppNumeroOrdre() != null
								&& this.getDppNumeroOrdre().equals(castOther.getDppNumeroOrdre())))
				&& ((this.getDppDate() == castOther.getDppDate()) || (this.getDppDate() != null
						&& castOther.getDppDate() != null && this.getDppDate().equals(castOther.getDppDate())))
				&& ((this.getDppObjet() == castOther.getDppObjet()) || (this.getDppObjet() != null
						&& castOther.getDppObjet() != null && this.getDppObjet().equals(castOther.getDppObjet())))
				&& ((this.getDppSourceFin() == castOther.getDppSourceFin())
						|| (this.getDppSourceFin() != null && castOther.getDppSourceFin() != null
								&& this.getDppSourceFin().equals(castOther.getDppSourceFin())))
				&& ((this.getDppDateDaoTrans() == castOther.getDppDateDaoTrans())
						|| (this.getDppDateDaoTrans() != null && castOther.getDppDateDaoTrans() != null
								&& this.getDppDateDaoTrans().equals(castOther.getDppDateDaoTrans())))
				&& ((this.getDppDateDaoApprobDmp() == castOther.getDppDateDaoApprobDmp())
						|| (this.getDppDateDaoApprobDmp() != null && castOther.getDppDateDaoApprobDmp() != null
								&& this.getDppDateDaoApprobDmp().equals(castOther.getDppDateDaoApprobDmp())))
				&& ((this.getDppDateDaoApprobBail() == castOther.getDppDateDaoApprobBail())
						|| (this.getDppDateDaoApprobBail() != null && castOther.getDppDateDaoApprobBail() != null
								&& this.getDppDateDaoApprobBail().equals(castOther.getDppDateDaoApprobBail())))
				&& ((this.getDppDateAvisAoPublication() == castOther.getDppDateAvisAoPublication())
						|| (this.getDppDateAvisAoPublication() != null
								&& castOther.getDppDateAvisAoPublication() != null
								&& this.getDppDateAvisAoPublication().equals(castOther.getDppDateAvisAoPublication())))
				&& ((this.getDppDateOuvertOt() == castOther.getDppDateOuvertOt())
						|| (this.getDppDateOuvertOt() != null && castOther.getDppDateOuvertOt() != null
								&& this.getDppDateOuvertOt().equals(castOther.getDppDateOuvertOt())))
				&& ((this.getDppDateOuvertOf() == castOther.getDppDateOuvertOf())
						|| (this.getDppDateOuvertOf() != null && castOther.getDppDateOuvertOf() != null
								&& this.getDppDateOuvertOf().equals(castOther.getDppDateOuvertOf())))
				&& ((this.getDppDateElabRapport() == castOther.getDppDateElabRapport())
						|| (this.getDppDateElabRapport() != null && castOther.getDppDateElabRapport() != null
								&& this.getDppDateElabRapport().equals(castOther.getDppDateElabRapport())))
				&& ((this.getDppDateJugementOffre() == castOther.getDppDateJugementOffre())
						|| (this.getDppDateJugementOffre() != null && castOther.getDppDateJugementOffre() != null
								&& this.getDppDateJugementOffre().equals(castOther.getDppDateJugementOffre())))
				&& ((this.getDppDateAttApprobDmp() == castOther.getDppDateAttApprobDmp())
						|| (this.getDppDateAttApprobDmp() != null && castOther.getDppDateAttApprobDmp() != null
								&& this.getDppDateAttApprobDmp().equals(castOther.getDppDateAttApprobDmp())))
				&& ((this.getDppDateAttApproBail() == castOther.getDppDateAttApproBail())
						|| (this.getDppDateAttApproBail() != null && castOther.getDppDateAttApproBail() != null
								&& this.getDppDateAttApproBail().equals(castOther.getDppDateAttApproBail())))
				&& ((this.getDppDateNegociation() == castOther.getDppDateNegociation())
						|| (this.getDppDateNegociation() != null && castOther.getDppDateNegociation() != null
								&& this.getDppDateNegociation().equals(castOther.getDppDateNegociation())))
				&& ((this.getDppDateSignatAttrib() == castOther.getDppDateSignatAttrib())
						|| (this.getDppDateSignatAttrib() != null && castOther.getDppDateSignatAttrib() != null
								&& this.getDppDateSignatAttrib().equals(castOther.getDppDateSignatAttrib())))
				&& ((this.getDppDateSignatAc() == castOther.getDppDateSignatAc())
						|| (this.getDppDateSignatAc() != null && castOther.getDppDateSignatAc() != null
								&& this.getDppDateSignatAc().equals(castOther.getDppDateSignatAc())))
				&& ((this.getDppDateMarcheApprob() == castOther.getDppDateMarcheApprob())
						|| (this.getDppDateMarcheApprob() != null && castOther.getDppDateMarcheApprob() != null
								&& this.getDppDateMarcheApprob().equals(castOther.getDppDateMarcheApprob())))
				&& ((this.getDppDateExecDebut() == castOther.getDppDateExecDebut())
						|| (this.getDppDateExecDebut() != null && castOther.getDppDateExecDebut() != null
								&& this.getDppDateExecDebut().equals(castOther.getDppDateExecDebut())))
				&& ((this.getDppDateExecFin() == castOther.getDppDateExecFin())
						|| (this.getDppDateExecFin() != null && castOther.getDppDateExecFin() != null
								&& this.getDppDateExecFin().equals(castOther.getDppDateExecFin())))
				&& ((this.getDppActeurSaisie() == castOther.getDppActeurSaisie())
						|| (this.getDppActeurSaisie() != null && castOther.getDppActeurSaisie() != null
								&& this.getDppActeurSaisie().equals(castOther.getDppActeurSaisie())))
				&& ((this.getDppStrCode() == castOther.getDppStrCode()) || (this.getDppStrCode() != null
						&& castOther.getDppStrCode() != null && this.getDppStrCode().equals(castOther.getDppStrCode())))
				&& ((this.getDppStatutRetour() == castOther.getDppStatutRetour())
						|| (this.getDppStatutRetour() != null && castOther.getDppStatutRetour() != null
								&& this.getDppStatutRetour().equals(castOther.getDppStatutRetour())))
				&& ((this.getDppDateSaisie() == castOther.getDppDateSaisie())
						|| (this.getDppDateSaisie() != null && castOther.getDppDateSaisie() != null
								&& this.getDppDateSaisie().equals(castOther.getDppDateSaisie())))
				&& ((this.getDppStructureConduc() == castOther.getDppStructureConduc())
						|| (this.getDppStructureConduc() != null && castOther.getDppStructureConduc() != null
								&& this.getDppStructureConduc().equals(castOther.getDppStructureConduc())))
				&& ((this.getDppStructureBenefi() == castOther.getDppStructureBenefi())
						|| (this.getDppStructureBenefi() != null && castOther.getDppStructureBenefi() != null
								&& this.getDppStructureBenefi().equals(castOther.getDppStructureBenefi())))
				&& ((this.getDppPartiePmePmi() == castOther.getDppPartiePmePmi())
						|| (this.getDppPartiePmePmi() != null && castOther.getDppPartiePmePmi() != null
								&& this.getDppPartiePmePmi().equals(castOther.getDppPartiePmePmi())))
				&& ((this.getDppTypId() == castOther.getDppTypId()) || (this.getDppTypId() != null
						&& castOther.getDppTypId() != null && this.getDppTypId().equals(castOther.getDppTypId())))
				&& ((this.getDppStatutDao() == castOther.getDppStatutDao())
						|| (this.getDppStatutDao() != null && castOther.getDppStatutDao() != null
								&& this.getDppStatutDao().equals(castOther.getDppStatutDao())))
				&& ((this.getDppPieceDao() == castOther.getDppPieceDao())
						|| (this.getDppPieceDao() != null && castOther.getDppPieceDao() != null
								&& this.getDppPieceDao().equals(castOther.getDppPieceDao())))
				&& ((this.getDppDacCode() == castOther.getDppDacCode()) || (this.getDppDacCode() != null
						&& castOther.getDppDacCode() != null && this.getDppDacCode().equals(castOther.getDppDacCode())))
				&& ((this.getDppInvEntre() == castOther.getDppInvEntre())
						|| (this.getDppInvEntre() != null && castOther.getDppInvEntre() != null
								&& this.getDppInvEntre().equals(castOther.getDppInvEntre())))
				&& ((this.getDppDateAttApprobCpmp() == castOther.getDppDateAttApprobCpmp())
						|| (this.getDppDateAttApprobCpmp() != null && castOther.getDppDateAttApprobCpmp() != null
								&& this.getDppDateAttApprobCpmp().equals(castOther.getDppDateAttApprobCpmp())))
				&& ((this.getDppDateJugementOffreTec() == castOther.getDppDateJugementOffreTec())
						|| (this.getDppDateJugementOffreTec() != null && castOther.getDppDateJugementOffreTec() != null
								&& this.getDppDateJugementOffreTec().equals(castOther.getDppDateJugementOffreTec())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getDppId();
		result = 37 * result + (int) this.getDppPlpId();
		result = 37 * result + (int) this.getDppGpgId();
		result = 37 * result + (getDppStaCode() == null ? 0 : this.getDppStaCode().hashCode());
		result = 37 * result + (getDppTymCode() == null ? 0 : this.getDppTymCode().hashCode());
		result = 37 * result + (getDppMopCode() == null ? 0 : this.getDppMopCode().hashCode());
		result = 37 * result + (getDppLbgCode() == null ? 0 : this.getDppLbgCode().hashCode());
		result = 37 * result + (getDppTypePlan() == null ? 0 : this.getDppTypePlan().hashCode());
		result = 37 * result + (getDppCode() == null ? 0 : this.getDppCode().hashCode());
		result = 37 * result + (getDppNumeroOrdre() == null ? 0 : this.getDppNumeroOrdre().hashCode());
		result = 37 * result + (getDppDate() == null ? 0 : this.getDppDate().hashCode());
		result = 37 * result + (getDppObjet() == null ? 0 : this.getDppObjet().hashCode());
		result = 37 * result + (getDppSourceFin() == null ? 0 : this.getDppSourceFin().hashCode());
		result = 37 * result + (getDppDateDaoTrans() == null ? 0 : this.getDppDateDaoTrans().hashCode());
		result = 37 * result + (getDppDateDaoApprobDmp() == null ? 0 : this.getDppDateDaoApprobDmp().hashCode());
		result = 37 * result + (getDppDateDaoApprobBail() == null ? 0 : this.getDppDateDaoApprobBail().hashCode());
		result = 37 * result
				+ (getDppDateAvisAoPublication() == null ? 0 : this.getDppDateAvisAoPublication().hashCode());
		result = 37 * result + (getDppDateOuvertOt() == null ? 0 : this.getDppDateOuvertOt().hashCode());
		result = 37 * result + (getDppDateOuvertOf() == null ? 0 : this.getDppDateOuvertOf().hashCode());
		result = 37 * result + (getDppDateElabRapport() == null ? 0 : this.getDppDateElabRapport().hashCode());
		result = 37 * result + (getDppDateJugementOffre() == null ? 0 : this.getDppDateJugementOffre().hashCode());
		result = 37 * result + (getDppDateAttApprobDmp() == null ? 0 : this.getDppDateAttApprobDmp().hashCode());
		result = 37 * result + (getDppDateAttApproBail() == null ? 0 : this.getDppDateAttApproBail().hashCode());
		result = 37 * result + (getDppDateNegociation() == null ? 0 : this.getDppDateNegociation().hashCode());
		result = 37 * result + (getDppDateSignatAttrib() == null ? 0 : this.getDppDateSignatAttrib().hashCode());
		result = 37 * result + (getDppDateSignatAc() == null ? 0 : this.getDppDateSignatAc().hashCode());
		result = 37 * result + (getDppDateMarcheApprob() == null ? 0 : this.getDppDateMarcheApprob().hashCode());
		result = 37 * result + (getDppDateExecDebut() == null ? 0 : this.getDppDateExecDebut().hashCode());
		result = 37 * result + (getDppDateExecFin() == null ? 0 : this.getDppDateExecFin().hashCode());
		result = 37 * result + (getDppActeurSaisie() == null ? 0 : this.getDppActeurSaisie().hashCode());
		result = 37 * result + (getDppStrCode() == null ? 0 : this.getDppStrCode().hashCode());
		result = 37 * result + (getDppStatutRetour() == null ? 0 : this.getDppStatutRetour().hashCode());
		result = 37 * result + (getDppDateSaisie() == null ? 0 : this.getDppDateSaisie().hashCode());
		result = 37 * result + (getDppStructureConduc() == null ? 0 : this.getDppStructureConduc().hashCode());
		result = 37 * result + (getDppStructureBenefi() == null ? 0 : this.getDppStructureBenefi().hashCode());
		result = 37 * result + (getDppPartiePmePmi() == null ? 0 : this.getDppPartiePmePmi().hashCode());
		result = 37 * result + (getDppTypId() == null ? 0 : this.getDppTypId().hashCode());
		result = 37 * result + (getDppStatutDao() == null ? 0 : this.getDppStatutDao().hashCode());
		result = 37 * result + (getDppPieceDao() == null ? 0 : this.getDppPieceDao().hashCode());
		result = 37 * result + (getDppDacCode() == null ? 0 : this.getDppDacCode().hashCode());
		result = 37 * result + (getDppInvEntre() == null ? 0 : this.getDppInvEntre().hashCode());
		result = 37 * result + (getDppDateAttApprobCpmp() == null ? 0 : this.getDppDateAttApprobCpmp().hashCode());
		result = 37 * result
				+ (getDppDateJugementOffreTec() == null ? 0 : this.getDppDateJugementOffreTec().hashCode());
		return result;
	}

}
