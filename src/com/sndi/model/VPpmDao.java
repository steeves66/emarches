package com.sndi.model;
// Generated 4 f�vr. 2020 21:00:13 by Hibernate Tools 4.3.5.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

/**
 * VPpmDaoId generated by hbm2java
 */
@Entity
@Immutable
@Table(name = "V_PPM_DAO")
public class VPpmDao implements java.io.Serializable {

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
	private String dppBailleur;
	private String dppRecherche;
	private String mdtCode;
	private String mdtTymCode;
	private String mdtLibelleCourt;
	private String tymCode;
	private String tymLibelleCourt;
	private String mopCode;
	private String mopLibelleLong;
	private String lbgImputation;
	private String natLibelle;
	private String strTstCode;
	private Long dppMontant;

	public VPpmDao() {
	}

	public VPpmDao(long dppId, long dppPlpId, long dppGpgId, String dppStaCode, String dppTymCode, String dppMopCode,
			String dppTypePlan, String tymCode, String tymLibelleCourt, String mopCode,
			String lbgImputation) {
		this.dppId = dppId;
		this.dppPlpId = dppPlpId;
		this.dppGpgId = dppGpgId;
		this.dppStaCode = dppStaCode;
		this.dppTymCode = dppTymCode;
		this.dppMopCode = dppMopCode;
		this.dppTypePlan = dppTypePlan;
		this.tymCode = tymCode;
		this.tymLibelleCourt = tymLibelleCourt;
		this.mopCode = mopCode;
		this.lbgImputation = lbgImputation;
	}

	public VPpmDao(long dppId, long dppPlpId, long dppGpgId, String dppStaCode, String dppTymCode, String dppMopCode,
			String dppLbgCode, String dppTypePlan, String dppCode, Integer dppNumeroOrdre, Date dppDate,
			String dppObjet, String dppSourceFin, Date dppDateDaoTrans, Date dppDateDaoApprobDmp,
			Date dppDateDaoApprobBail, Date dppDateAvisAoPublication, Date dppDateOuvertOt, Date dppDateOuvertOf,
			Date dppDateElabRapport, Date dppDateJugementOffre, Date dppDateAttApprobDmp, Date dppDateAttApproBail,
			Date dppDateNegociation, Date dppDateSignatAttrib, Date dppDateSignatAc, Date dppDateMarcheApprob,
			Date dppDateExecDebut, Date dppDateExecFin, String dppActeurSaisie, String dppStrCode,
			String dppStatutRetour, Date dppDateSaisie, String dppStructureConduc, String dppStructureBenefi,
			String dppPartiePmePmi, String dppTypId, String dppStatutDao, String dppPieceDao, String dppDacCode,
			String dppBailleur,String dppRecherche ,String mdtCode, String mdtTymCode, String mdtLibelleCourt,
			 String tymCode, String tymLibelleCourt, String mopCode, String mopLibelleLong,
			String lbgImputation, String natLibelle, String strTstCode,Long dppMontant) {
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
		this.dppBailleur = dppBailleur;
		this.dppRecherche = dppRecherche;
		this.mdtCode = mdtCode;
		this.mdtTymCode = mdtTymCode;
		this.mdtLibelleCourt = mdtLibelleCourt;
		this.tymCode = tymCode;
		this.tymLibelleCourt = tymLibelleCourt;
		this.mopCode = mopCode;
		this.mopLibelleLong = mopLibelleLong;
		this.lbgImputation = lbgImputation;
		this.natLibelle = natLibelle;
		this.strTstCode = strTstCode;
		this.dppMontant = dppMontant;
	}

	
	@Id
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

	@Column(name = "DPP_PIECE_DAO", length = 3)
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
	
	@Column(name = "DPP_BAILLEUR", length = 1)
	public String getDppBailleur() {
		return this.dppBailleur;
	}

	public void setDppBailleur(String dppBailleur) {
		this.dppBailleur = dppBailleur;
	}
	
	@Column(name = "DPP_RECHERCHE", length = 4000)
	public String getDppRecherche() {
		return this.dppRecherche;
	}

	public void setDppRecherche(String dppRecherche) {
		this.dppRecherche = dppRecherche;
	}
	
	@Column(name = "MDT_CODE", nullable = false, length = 15)
	public String getMdtCode() {
		return this.mdtCode;
	}

	public void setMdtCode(String mdtCode) {
		this.mdtCode = mdtCode;
	}

	@Column(name = "MDT_TYM_CODE", length = 3)
	public String getMdtTymCode() {
		return this.mdtTymCode;
	}

	public void setMdtTymCode(String mdtTymCode) {
		this.mdtTymCode = mdtTymCode;
	}

	@Column(name = "MDT_LIBELLE_COURT", length = 500)
	public String getMdtLibelleCourt() {
		return this.mdtLibelleCourt;
	}

	public void setMdtLibelleCourt(String mdtLibelleCourt) {
		this.mdtLibelleCourt = mdtLibelleCourt;
	}


	@Column(name = "TYM_CODE", nullable = false, length = 3)
	public String getTymCode() {
		return this.tymCode;
	}

	public void setTymCode(String tymCode) {
		this.tymCode = tymCode;
	}

	@Column(name = "TYM_LIBELLE_COURT", nullable = false, length = 500)
	public String getTymLibelleCourt() {
		return this.tymLibelleCourt;
	}

	public void setTymLibelleCourt(String tymLibelleCourt) {
		this.tymLibelleCourt = tymLibelleCourt;
	}

	@Column(name = "MOP_CODE", nullable = false, length = 3)
	public String getMopCode() {
		return this.mopCode;
	}

	public void setMopCode(String mopCode) {
		this.mopCode = mopCode;
	}

	@Column(name = "MOP_LIBELLE_LONG", length = 1000)
	public String getMopLibelleLong() {
		return this.mopLibelleLong;
	}

	public void setMopLibelleLong(String mopLibelleLong) {
		this.mopLibelleLong = mopLibelleLong;
	}

	@Column(name = "LBG_IMPUTATION", nullable = false, length = 20)
	public String getLbgImputation() {
		return this.lbgImputation;
	}

	public void setLbgImputation(String lbgImputation) {
		this.lbgImputation = lbgImputation;
	}

	@Column(name = "NAT_LIBELLE", length = 200)
	public String getNatLibelle() {
		return this.natLibelle;
	}

	public void setNatLibelle(String natLibelle) {
		this.natLibelle = natLibelle;
	}
	
	@Column(name = "STR_TST_CODE", length = 3)
	public String getStrTstCode() {
		return this.strTstCode;
	}

	public void setStrTstCode(String strTstCode) {
		this.strTstCode = strTstCode;
	}
	@Column(name = "DPP_MONTANT", precision = 15, scale = 0)
	public Long getDppMontant() {
		return this.dppMontant;
	}

	public void setDppMontant(Long dppMontant) {
		this.dppMontant = dppMontant;
	}
}
