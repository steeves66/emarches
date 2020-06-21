package com.sndi.models;
// Generated 20 juin 2020 17:16:02 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VDetailCommission generated by hbm2java
 */
@Entity
@Table(name = "V_DETAIL_COMMISSION", schema = "EMAP")
public class VDetailCommission implements java.io.Serializable {

	private VDetailCommissionId id;

	public VDetailCommission() {
	}

	public VDetailCommission(VDetailCommissionId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "aaoCode", column = @Column(name = "AAO_CODE", nullable = false, length = 20)),
			@AttributeOverride(name = "aaoLibelle", column = @Column(name = "AAO_LIBELLE", length = 1000)),
			@AttributeOverride(name = "aaoDacCode", column = @Column(name = "AAO_DAC_CODE", length = 20)),
			@AttributeOverride(name = "aaoDteSaisi", column = @Column(name = "AAO_DTE_SAISI", length = 7)),
			@AttributeOverride(name = "aaoStaCode", column = @Column(name = "AAO_STA_CODE", length = 3)),
			@AttributeOverride(name = "aaoDtePub", column = @Column(name = "AAO_DTE_PUB", length = 7)),
			@AttributeOverride(name = "aaoDteOuvTec", column = @Column(name = "AAO_DTE_OUV_TEC", length = 7)),
			@AttributeOverride(name = "aaoDteHeurOuv", column = @Column(name = "AAO_DTE_HEUR_OUV", length = 20)),
			@AttributeOverride(name = "aaoDteOuvFin", column = @Column(name = "AAO_DTE_OUV_FIN", length = 7)),
			@AttributeOverride(name = "aaoNbrLot", column = @Column(name = "AAO_NBR_LOT", precision = 22, scale = 0)),
			@AttributeOverride(name = "aaoNbrOuv", column = @Column(name = "AAO_NBR_OUV", precision = 22, scale = 0)),
			@AttributeOverride(name = "aaoDelaiVal", column = @Column(name = "AAO_DELAI_VAL", precision = 22, scale = 0)),
			@AttributeOverride(name = "aaoFonCodAc", column = @Column(name = "AAO_FON_COD_AC", length = 12)),
			@AttributeOverride(name = "aaoFonCodeCpmp", column = @Column(name = "AAO_FON_CODE_CPMP", length = 12)),
			@AttributeOverride(name = "aaoNatInt", column = @Column(name = "AAO_NAT_INT", length = 1)),
			@AttributeOverride(name = "aaoTaux", column = @Column(name = "AAO_TAUX", length = 3)),
			@AttributeOverride(name = "aaoLieuExe", column = @Column(name = "AAO_LIEU_EXE", length = 200)),
			@AttributeOverride(name = "aaoNomResp", column = @Column(name = "AAO_NOM_RESP", length = 200)),
			@AttributeOverride(name = "aaoInterPub", column = @Column(name = "AAO_INTER_PUB", length = 1)),
			@AttributeOverride(name = "aaoCautDefExig", column = @Column(name = "AAO_CAUT_DEF_EXIG", length = 1)),
			@AttributeOverride(name = "aaoBompPub", column = @Column(name = "AAO_BOMP_PUB", length = 1)),
			@AttributeOverride(name = "aaoVenteParLot", column = @Column(name = "AAO_VENTE_PAR_LOT", length = 1)),
			@AttributeOverride(name = "aaoAvisBail", column = @Column(name = "AAO_AVIS_BAIL", length = 1)),
			@AttributeOverride(name = "aaoMtCaut", column = @Column(name = "AAO_MT_CAUT", precision = 22, scale = 0)),
			@AttributeOverride(name = "aaoModePaiement", column = @Column(name = "AAO_MODE_PAIEMENT", length = 20)),
			@AttributeOverride(name = "aaoCoutDac", column = @Column(name = "AAO_COUT_DAC", precision = 22, scale = 0)),
			@AttributeOverride(name = "aaoLieuRecep", column = @Column(name = "AAO_LIEU_RECEP", length = 1000)),
			@AttributeOverride(name = "aaoDateRecep", column = @Column(name = "AAO_DATE_RECEP", length = 7)),
			@AttributeOverride(name = "aaoHeureRecep", column = @Column(name = "AAO_HEURE_RECEP", length = 20)),
			@AttributeOverride(name = "aaoAdaNum", column = @Column(name = "AAO_ADA_NUM", precision = 22, scale = 0)),
			@AttributeOverride(name = "aaoNatPrix", column = @Column(name = "AAO_NAT_PRIX", length = 20)),
			@AttributeOverride(name = "aaoRegQual", column = @Column(name = "AAO_REG_QUAL", length = 100)),
			@AttributeOverride(name = "aaoAvisBai", column = @Column(name = "AAO_AVIS_BAI", length = 1)),
			@AttributeOverride(name = "aaoRespBai", column = @Column(name = "AAO_RESP_BAI", length = 200)),
			@AttributeOverride(name = "aaoPrecisModEval", column = @Column(name = "AAO_PRECIS_MOD_EVAL", length = 200)),
			@AttributeOverride(name = "aaoDteValAc", column = @Column(name = "AAO_DTE_VAL_AC", length = 7)),
			@AttributeOverride(name = "aaoDteValCpmp", column = @Column(name = "AAO_DTE_VAL_CPMP", length = 7)),
			@AttributeOverride(name = "aaoDteValDmp", column = @Column(name = "AAO_DTE_VAL_DMP", length = 7)),
			@AttributeOverride(name = "aaoNbrOff", column = @Column(name = "AAO_NBR_OFF", precision = 4, scale = 0)),
			@AttributeOverride(name = "aaoNbrOffAccpet", column = @Column(name = "AAO_NBR_OFF_ACCPET", precision = 4, scale = 0)),
			@AttributeOverride(name = "aaoNbrOffRej", column = @Column(name = "AAO_NBR_OFF_REJ", precision = 4, scale = 0)),
			@AttributeOverride(name = "aaoNbrOffHorDelai", column = @Column(name = "AAO_NBR_OFF_HOR_DELAI", precision = 4, scale = 0)),
			@AttributeOverride(name = "dofNum", column = @Column(name = "DOF_NUM", precision = 22, scale = 0)),
			@AttributeOverride(name = "dofLaaId", column = @Column(name = "DOF_LAA_ID", precision = 22, scale = 0)),
			@AttributeOverride(name = "dofLaaAaoCode", column = @Column(name = "DOF_LAA_AAO_CODE", length = 20)),
			@AttributeOverride(name = "dofOffNum", column = @Column(name = "DOF_OFF_NUM", precision = 22, scale = 0)),
			@AttributeOverride(name = "dofTyp", column = @Column(name = "DOF_TYP", length = 1)),
			@AttributeOverride(name = "dofDelai", column = @Column(name = "DOF_DELAI", precision = 20, scale = 0)),
			@AttributeOverride(name = "dofDelai2", column = @Column(name = "DOF_DELAI2", precision = 20, scale = 0)),
			@AttributeOverride(name = "dofRangOfr", column = @Column(name = "DOF_RANG_OFR", precision = 10, scale = 0)),
			@AttributeOverride(name = "dofMtCor", column = @Column(name = "DOF_MT_COR", precision = 20, scale = 0)),
			@AttributeOverride(name = "dofMtOfr", column = @Column(name = "DOF_MT_OFR", precision = 20, scale = 0)),
			@AttributeOverride(name = "dofRab", column = @Column(name = "DOF_RAB", length = 5)),
			@AttributeOverride(name = "dofEstimRab", column = @Column(name = "DOF_ESTIM_RAB", precision = 20, scale = 0)),
			@AttributeOverride(name = "dofCaut", column = @Column(name = "DOF_CAUT", length = 1)),
			@AttributeOverride(name = "dofBanCode", column = @Column(name = "DOF_BAN_CODE", length = 10)),
			@AttributeOverride(name = "dofSeuil", column = @Column(name = "DOF_SEUIL", length = 1)),
			@AttributeOverride(name = "dofScore", column = @Column(name = "DOF_SCORE", precision = 3, scale = 0)),
			@AttributeOverride(name = "dofRecevabl", column = @Column(name = "DOF_RECEVABL", length = 1)),
			@AttributeOverride(name = "dofRet", column = @Column(name = "DOF_RET", length = 1)),
			@AttributeOverride(name = "dofRetBai", column = @Column(name = "DOF_RET_BAI", length = 1)),
			@AttributeOverride(name = "dofRetDmp", column = @Column(name = "DOF_RET_DMP", length = 1)),
			@AttributeOverride(name = "dofMtAtt", column = @Column(name = "DOF_MT_ATT", precision = 20, scale = 0)),
			@AttributeOverride(name = "dofTot", column = @Column(name = "DOF_TOT", length = 2)),
			@AttributeOverride(name = "dofTotAdm", column = @Column(name = "DOF_TOT_ADM", length = 2)),
			@AttributeOverride(name = "dofTotTec", column = @Column(name = "DOF_TOT_TEC", length = 2)),
			@AttributeOverride(name = "dofObsDmp", column = @Column(name = "DOF_OBS_DMP", length = 200)),
			@AttributeOverride(name = "dofObsCom", column = @Column(name = "DOF_OBS_COM", length = 200)),
			@AttributeOverride(name = "dofObsAdm", column = @Column(name = "DOF_OBS_ADM", length = 200)),
			@AttributeOverride(name = "dofObsAdmDmp", column = @Column(name = "DOF_OBS_ADM_DMP", length = 200)),
			@AttributeOverride(name = "dofObsAdmBai", column = @Column(name = "DOF_OBS_ADM_BAI", length = 200)),
			@AttributeOverride(name = "dofObsTec", column = @Column(name = "DOF_OBS_TEC", length = 200)),
			@AttributeOverride(name = "dofObsTecDmp", column = @Column(name = "DOF_OBS_TEC_DMP", length = 200)),
			@AttributeOverride(name = "dofObsTecBai", column = @Column(name = "DOF_OBS_TEC_BAI", length = 200)),
			@AttributeOverride(name = "dofNotAdm", column = @Column(name = "DOF_NOT_ADM", precision = 3, scale = 0)),
			@AttributeOverride(name = "dofNotTec", column = @Column(name = "DOF_NOT_TEC", precision = 3, scale = 0)),
			@AttributeOverride(name = "dofNotFin", column = @Column(name = "DOF_NOT_FIN", precision = 3, scale = 0)),
			@AttributeOverride(name = "dofNotFin2", column = @Column(name = "DOF_NOT_FIN2", precision = 3, scale = 0)),
			@AttributeOverride(name = "dofNotAdmDmp", column = @Column(name = "DOF_NOT_ADM_DMP", precision = 3, scale = 0)),
			@AttributeOverride(name = "dofNotTecDmp", column = @Column(name = "DOF_NOT_TEC_DMP", precision = 3, scale = 0)),
			@AttributeOverride(name = "dofNotFinDmp", column = @Column(name = "DOF_NOT_FIN_DMP", precision = 3, scale = 0)),
			@AttributeOverride(name = "dofNotFin2Dmp", column = @Column(name = "DOF_NOT_FIN2_DMP", precision = 3, scale = 0)),
			@AttributeOverride(name = "dofNotAdmBai", column = @Column(name = "DOF_NOT_ADM_BAI", precision = 3, scale = 0)),
			@AttributeOverride(name = "dofNotTecBai", column = @Column(name = "DOF_NOT_TEC_BAI", length = 240)),
			@AttributeOverride(name = "dofNotFinBai", column = @Column(name = "DOF_NOT_FIN_BAI", precision = 3, scale = 0)),
			@AttributeOverride(name = "dofNotFin2Bai", column = @Column(name = "DOF_NOT_FIN2_BAI", precision = 3, scale = 0)),
			@AttributeOverride(name = "dofMtAttDmp", column = @Column(name = "DOF_MT_ATT_DMP", precision = 20, scale = 0)),
			@AttributeOverride(name = "dofMtAttBai", column = @Column(name = "DOF_MT_ATT_BAI", precision = 20, scale = 0)),
			@AttributeOverride(name = "dofRangOfrDmp", column = @Column(name = "DOF_RANG_OFR_DMP", precision = 10, scale = 0)),
			@AttributeOverride(name = "dofMtCorDmp", column = @Column(name = "DOF_MT_COR_DMP", precision = 20, scale = 0)),
			@AttributeOverride(name = "dofRecevablDmp", column = @Column(name = "DOF_RECEVABL_DMP", length = 1)),
			@AttributeOverride(name = "dofScoreDmp", column = @Column(name = "DOF_SCORE_DMP", precision = 3, scale = 0)),
			@AttributeOverride(name = "dofRangOfrBai", column = @Column(name = "DOF_RANG_OFR_BAI", precision = 10, scale = 0)),
			@AttributeOverride(name = "dofMtCorBai", column = @Column(name = "DOF_MT_COR_BAI", precision = 20, scale = 0)),
			@AttributeOverride(name = "dofRecevablBai", column = @Column(name = "DOF_RECEVABL_BAI", length = 1)),
			@AttributeOverride(name = "dofScoreBai", column = @Column(name = "DOF_SCORE_BAI", precision = 3, scale = 0)),
			@AttributeOverride(name = "dofNomSign", column = @Column(name = "DOF_NOM_SIGN", length = 200)),
			@AttributeOverride(name = "dofFonctSign", column = @Column(name = "DOF_FONCT_SIGN", length = 100)),
			@AttributeOverride(name = "dofTelSign", column = @Column(name = "DOF_TEL_SIGN", length = 50)),
			@AttributeOverride(name = "dofDteSaisi", column = @Column(name = "DOF_DTE_SAISI", length = 7)),
			@AttributeOverride(name = "dofFonCodeAc", column = @Column(name = "DOF_FON_CODE_AC", length = 25)),
			@AttributeOverride(name = "dofOpeMatricule", column = @Column(name = "DOF_OPE_MATRICULE", length = 25)),
			@AttributeOverride(name = "dofStatut", column = @Column(name = "DOF_STATUT", length = 1)),
			@AttributeOverride(name = "dofSouNcc", column = @Column(name = "DOF_SOU_NCC", length = 500)),
			@AttributeOverride(name = "dofSigle", column = @Column(name = "DOF_SIGLE", length = 500)),
			@AttributeOverride(name = "dacCode", column = @Column(name = "DAC_CODE", nullable = false, length = 20)),
			@AttributeOverride(name = "dacObjet", column = @Column(name = "DAC_OBJET", length = 1000)),
			@AttributeOverride(name = "dacDteSaisi", column = @Column(name = "DAC_DTE_SAISI", length = 7)),
			@AttributeOverride(name = "dacStaCode", column = @Column(name = "DAC_STA_CODE", length = 3)),
			@AttributeOverride(name = "dacTymCode", column = @Column(name = "DAC_TYM_CODE", length = 5)),
			@AttributeOverride(name = "dacMopCode", column = @Column(name = "DAC_MOP_CODE", length = 3)),
			@AttributeOverride(name = "dacNbrOuv", column = @Column(name = "DAC_NBR_OUV", precision = 22, scale = 0)),
			@AttributeOverride(name = "dacGesCode", column = @Column(name = "DAC_GES_CODE", precision = 22, scale = 0)),
			@AttributeOverride(name = "dacFonCodAc", column = @Column(name = "DAC_FON_COD_AC", length = 12)),
			@AttributeOverride(name = "dacStrCode", column = @Column(name = "DAC_STR_CODE", length = 20)),
			@AttributeOverride(name = "dacFonCodeCpmp", column = @Column(name = "DAC_FON_CODE_CPMP", length = 12)),
			@AttributeOverride(name = "dacDteValCpmp", column = @Column(name = "DAC_DTE_VAL_CPMP", length = 7)),
			@AttributeOverride(name = "dacDteValDmp", column = @Column(name = "DAC_DTE_VAL_DMP", length = 7)),
			@AttributeOverride(name = "dacTdCode", column = @Column(name = "DAC_TD_CODE", length = 3)),
			@AttributeOverride(name = "dacDateReception", column = @Column(name = "DAC_DATE_RECEPTION", length = 7)),
			@AttributeOverride(name = "dacStatutRetour", column = @Column(name = "DAC_STATUT_RETOUR", length = 2)),
			@AttributeOverride(name = "dacMention", column = @Column(name = "DAC_MENTION", length = 100)),
			@AttributeOverride(name = "dacDateValAc", column = @Column(name = "DAC_DATE_VAL_AC", length = 7)),
			@AttributeOverride(name = "dacAvisBailleur", column = @Column(name = "DAC_AVIS_BAILLEUR", length = 4000)),
			@AttributeOverride(name = "dacDateAvisBailleur", column = @Column(name = "DAC_DATE_AVIS_BAILLEUR", length = 7)),
			@AttributeOverride(name = "dacBailleur", column = @Column(name = "DAC_BAILLEUR", length = 1)),
			@AttributeOverride(name = "dacCout", column = @Column(name = "DAC_COUT", precision = 11, scale = 0)),
			@AttributeOverride(name = "dacTypePlan", column = @Column(name = "DAC_TYPE_PLAN", length = 4)),
			@AttributeOverride(name = "dacRecherche", column = @Column(name = "DAC_RECHERCHE", length = 4000)),
			@AttributeOverride(name = "tymCode", column = @Column(name = "TYM_CODE", length = 3)),
			@AttributeOverride(name = "tymLibelleCourt", column = @Column(name = "TYM_LIBELLE_COURT", length = 500)),
			@AttributeOverride(name = "tymLibelleLong", column = @Column(name = "TYM_LIBELLE_LONG", length = 1000)),
			@AttributeOverride(name = "tymTymCode", column = @Column(name = "TYM_TYM_CODE", length = 3)),
			@AttributeOverride(name = "tymGroupe", column = @Column(name = "TYM_GROUPE", length = 2)),
			@AttributeOverride(name = "mopCode", column = @Column(name = "MOP_CODE", length = 3)),
			@AttributeOverride(name = "mopLibelleCourt", column = @Column(name = "MOP_LIBELLE_COURT", length = 500)),
			@AttributeOverride(name = "mopLibelleLong", column = @Column(name = "MOP_LIBELLE_LONG", length = 1000)) })
	public VDetailCommissionId getId() {
		return this.id;
	}

	public void setId(VDetailCommissionId id) {
		this.id = id;
	}

}
