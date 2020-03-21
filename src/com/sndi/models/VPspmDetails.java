package com.sndi.models;
// Generated 21 mars 2020 13:48:08 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VPspmDetails generated by hbm2java
 */
@Entity
@Table(name = "V_PSPM_DETAILS", schema = "EMAP")
public class VPspmDetails implements java.io.Serializable {

	private VPspmDetailsId id;

	public VPspmDetails() {
	}

	public VPspmDetails(VPspmDetailsId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "affDppId", column = @Column(name = "AFF_DPP_ID", precision = 10, scale = 0)),
			@AttributeOverride(name = "affDppPlpId", column = @Column(name = "AFF_DPP_PLP_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "affDppGpgId", column = @Column(name = "AFF_DPP_GPG_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "affDppStaCode", column = @Column(name = "AFF_DPP_STA_CODE", nullable = false, length = 3)),
			@AttributeOverride(name = "affDppTymCode", column = @Column(name = "AFF_DPP_TYM_CODE", nullable = false, length = 3)),
			@AttributeOverride(name = "affDppMopCode", column = @Column(name = "AFF_DPP_MOP_CODE", nullable = false, length = 3)),
			@AttributeOverride(name = "affDppLbgCode", column = @Column(name = "AFF_DPP_LBG_CODE", nullable = false, length = 50)),
			@AttributeOverride(name = "affDppTypePlan", column = @Column(name = "AFF_DPP_TYPE_PLAN", nullable = false, length = 3)),
			@AttributeOverride(name = "affDppCode", column = @Column(name = "AFF_DPP_CODE", length = 50)),
			@AttributeOverride(name = "affDppNumeroOrdre", column = @Column(name = "AFF_DPP_NUMERO_ORDRE", precision = 8, scale = 0)),
			@AttributeOverride(name = "affDppDate", column = @Column(name = "AFF_DPP_DATE", length = 7)),
			@AttributeOverride(name = "affDppObjet", column = @Column(name = "AFF_DPP_OBJET", length = 1000)),
			@AttributeOverride(name = "affDppSourceFin", column = @Column(name = "AFF_DPP_SOURCE_FIN", length = 1000)),
			@AttributeOverride(name = "affDppDateDaoTrans", column = @Column(name = "AFF_DPP_DATE_DAO_TRANS", length = 7)),
			@AttributeOverride(name = "affDppDateDaoApprobDmp", column = @Column(name = "AFF_DPP_DATE_DAO_APPROB_DMP", length = 7)),
			@AttributeOverride(name = "affDppDateDaoApprobBail", column = @Column(name = "AFF_DPP_DATE_DAO_APPROB_BAIL", length = 7)),
			@AttributeOverride(name = "affDppDateAvisAoPublicat", column = @Column(name = "AFF_DPP_DATE_AVIS_AO_PUBLICAT", length = 7)),
			@AttributeOverride(name = "affDppDateOuvertOt", column = @Column(name = "AFF_DPP_DATE_OUVERT_OT", length = 7)),
			@AttributeOverride(name = "affDppDateOuvertOf", column = @Column(name = "AFF_DPP_DATE_OUVERT_OF", length = 7)),
			@AttributeOverride(name = "affDppDateElabRapport", column = @Column(name = "AFF_DPP_DATE_ELAB_RAPPORT", length = 7)),
			@AttributeOverride(name = "affDppDateJugementOffre", column = @Column(name = "AFF_DPP_DATE_JUGEMENT_OFFRE", length = 7)),
			@AttributeOverride(name = "affDppDateAttApprobDmp", column = @Column(name = "AFF_DPP_DATE_ATT_APPROB_DMP", length = 7)),
			@AttributeOverride(name = "affDppDateAttApproBail", column = @Column(name = "AFF_DPP_DATE_ATT_APPRO_BAIL", length = 7)),
			@AttributeOverride(name = "affDppDateNegociation", column = @Column(name = "AFF_DPP_DATE_NEGOCIATION", length = 7)),
			@AttributeOverride(name = "affDppDateSignatAttrib", column = @Column(name = "AFF_DPP_DATE_SIGNAT_ATTRIB", length = 7)),
			@AttributeOverride(name = "affDppDateSignatAc", column = @Column(name = "AFF_DPP_DATE_SIGNAT_AC", length = 7)),
			@AttributeOverride(name = "affDppDateMarcheApprob", column = @Column(name = "AFF_DPP_DATE_MARCHE_APPROB", length = 7)),
			@AttributeOverride(name = "affDppDateExecDebut", column = @Column(name = "AFF_DPP_DATE_EXEC_DEBUT", length = 7)),
			@AttributeOverride(name = "affDppDateExecFin", column = @Column(name = "AFF_DPP_DATE_EXEC_FIN", length = 7)),
			@AttributeOverride(name = "plpGesCode", column = @Column(name = "PLP_GES_CODE", nullable = false, precision = 4, scale = 0)),
			@AttributeOverride(name = "affDppDateSaisie", column = @Column(name = "AFF_DPP_DATE_SAISIE", length = 7)),
			@AttributeOverride(name = "plpLibelle", column = @Column(name = "PLP_LIBELLE", length = 1000)),
			@AttributeOverride(name = "gpgObjet", column = @Column(name = "GPG_OBJET", length = 1000)),
			@AttributeOverride(name = "chrCommentaire", column = @Column(name = "CHR_COMMENTAIRE", length = 1000)),
			@AttributeOverride(name = "strLibelleLong", column = @Column(name = "STR_LIBELLE_LONG", length = 1000)),
			@AttributeOverride(name = "strLibelleCourt", column = @Column(name = "STR_LIBELLE_COURT", length = 500)),
			@AttributeOverride(name = "strEmail", column = @Column(name = "STR_EMAIL", length = 500)),
			@AttributeOverride(name = "tymCode", column = @Column(name = "TYM_CODE", nullable = false, length = 3)),
			@AttributeOverride(name = "tymLibelleCourt", column = @Column(name = "TYM_LIBELLE_COURT", nullable = false, length = 500)),
			@AttributeOverride(name = "tymLibelleLong", column = @Column(name = "TYM_LIBELLE_LONG", length = 1000)),
			@AttributeOverride(name = "mopCode", column = @Column(name = "MOP_CODE", nullable = false, length = 3)),
			@AttributeOverride(name = "mopLibelleCourt", column = @Column(name = "MOP_LIBELLE_COURT", nullable = false, length = 500)),
			@AttributeOverride(name = "mopLibelleLong", column = @Column(name = "MOP_LIBELLE_LONG", length = 1000)),
			@AttributeOverride(name = "lbgCode", column = @Column(name = "LBG_CODE", nullable = false, length = 50)),
			@AttributeOverride(name = "lbgStrCode", column = @Column(name = "LBG_STR_CODE", nullable = false, length = 30)),
			@AttributeOverride(name = "lbgGesCode", column = @Column(name = "LBG_GES_CODE", nullable = false, precision = 4, scale = 0)),
			@AttributeOverride(name = "lbgResDon", column = @Column(name = "LBG_RES_DON", nullable = false, precision = 20, scale = 0)),
			@AttributeOverride(name = "lbgImputation", column = @Column(name = "LBG_IMPUTATION", nullable = false, length = 50)),
			@AttributeOverride(name = "lbgAnoCode", column = @Column(name = "LBG_ANO_CODE", precision = 10, scale = 0)),
			@AttributeOverride(name = "lbgNatCode", column = @Column(name = "LBG_NAT_CODE", nullable = false, length = 20)),
			@AttributeOverride(name = "lbgResTr", column = @Column(name = "LBG_RES_TR", nullable = false, precision = 20, scale = 0)),
			@AttributeOverride(name = "lbgDteSaisi", column = @Column(name = "LBG_DTE_SAISI", length = 7)),
			@AttributeOverride(name = "lbgAeTr", column = @Column(name = "LBG_AE_TR", nullable = false, precision = 20, scale = 0)),
			@AttributeOverride(name = "lbgAeDon", column = @Column(name = "LBG_AE_DON", nullable = false, precision = 20, scale = 0)),
			@AttributeOverride(name = "lbgAeEmp", column = @Column(name = "LBG_AE_EMP", nullable = false, precision = 20, scale = 0)),
			@AttributeOverride(name = "lbgMp", column = @Column(name = "LBG_MP", length = 1)),
			@AttributeOverride(name = "lbgReglMp", column = @Column(name = "LBG_REGL_MP", length = 1)),
			@AttributeOverride(name = "lbgTotDot", column = @Column(name = "LBG_TOT_DOT", nullable = false, precision = 20, scale = 0)),
			@AttributeOverride(name = "lbgUtilSaisi", column = @Column(name = "LBG_UTIL_SAISI", length = 10)),
			@AttributeOverride(name = "lbgDesCode", column = @Column(name = "LBG_DES_CODE", length = 30)),
			@AttributeOverride(name = "lbgDteModif", column = @Column(name = "LBG_DTE_MODIF", length = 7)),
			@AttributeOverride(name = "lbgResEmp", column = @Column(name = "LBG_RES_EMP", precision = 20, scale = 0)),
			@AttributeOverride(name = "lbgResTot", column = @Column(name = "LBG_RES_TOT", precision = 20, scale = 0)),
			@AttributeOverride(name = "lbgUtilModif", column = @Column(name = "LBG_UTIL_MODIF", length = 20)),
			@AttributeOverride(name = "lbgFonCode", column = @Column(name = "LBG_FON_CODE", length = 20)),
			@AttributeOverride(name = "lbgDisTre", column = @Column(name = "LBG_DIS_TRE", precision = 20, scale = 0)),
			@AttributeOverride(name = "lbgDisDon", column = @Column(name = "LBG_DIS_DON", precision = 20, scale = 0)),
			@AttributeOverride(name = "lbgDisEmp", column = @Column(name = "LBG_DIS_EMP", precision = 20, scale = 0)),
			@AttributeOverride(name = "lbgDisTot", column = @Column(name = "LBG_DIS_TOT", precision = 20, scale = 0)),
			@AttributeOverride(name = "lbgFonCodeAc", column = @Column(name = "LBG_FON_CODE_AC", length = 30)),
			@AttributeOverride(name = "lbgStaCode", column = @Column(name = "LBG_STA_CODE", length = 10)),
			@AttributeOverride(name = "lbgActNumModif", column = @Column(name = "LBG_ACT_NUM_MODIF", length = 100)),
			@AttributeOverride(name = "lbgDteVal", column = @Column(name = "LBG_DTE_VAL", length = 7)),
			@AttributeOverride(name = "lbgFonCodeVal", column = @Column(name = "LBG_FON_CODE_VAL", length = 10)),
			@AttributeOverride(name = "lbgTraitmt", column = @Column(name = "LBG_TRAITMT", length = 1)),
			@AttributeOverride(name = "lbgTraitmtNotif", column = @Column(name = "LBG_TRAITMT_NOTIF", length = 1)),
			@AttributeOverride(name = "lbgDteStaCour", column = @Column(name = "LBG_DTE_STA_COUR", length = 7)),
			@AttributeOverride(name = "lbgTitre", column = @Column(name = "LBG_TITRE", length = 20)),
			@AttributeOverride(name = "lbgCor", column = @Column(name = "LBG_COR", length = 1)),
			@AttributeOverride(name = "lbgAdmCentral", column = @Column(name = "LBG_ADM_CENTRAL", nullable = false, length = 1)),
			@AttributeOverride(name = "lbgMotifCor", column = @Column(name = "LBG_MOTIF_COR", length = 200)),
			@AttributeOverride(name = "lbgDteCor", column = @Column(name = "LBG_DTE_COR", length = 7)),
			@AttributeOverride(name = "lbgFonCodeCor", column = @Column(name = "LBG_FON_CODE_COR", length = 30)),
			@AttributeOverride(name = "lbgFonCodePf", column = @Column(name = "LBG_FON_CODE_PF", length = 30)),
			@AttributeOverride(name = "lbgFonCodeValAct", column = @Column(name = "LBG_FON_CODE_VAL_ACT", length = 30)),
			@AttributeOverride(name = "lbgActif", column = @Column(name = "LBG_ACTIF", length = 1)),
			@AttributeOverride(name = "lbgFonCodeCf", column = @Column(name = "LBG_FON_CODE_CF", length = 30)),
			@AttributeOverride(name = "lbgDotAnPlus1", column = @Column(name = "LBG_DOT_AN_PLUS1", precision = 20, scale = 0)),
			@AttributeOverride(name = "lbgDotAnPlus2", column = @Column(name = "LBG_DOT_AN_PLUS2", precision = 20, scale = 0)),
			@AttributeOverride(name = "lbgDotAnPlus0", column = @Column(name = "LBG_DOT_AN_PLUS0", precision = 20, scale = 0)),
			@AttributeOverride(name = "lbgTypBud", column = @Column(name = "LBG_TYP_BUD", length = 10)),
			@AttributeOverride(name = "lbgDteMp", column = @Column(name = "LBG_DTE_MP", length = 7)),
			@AttributeOverride(name = "lbgUtilSaisiAct", column = @Column(name = "LBG_UTIL_SAISI_ACT", length = 30)),
			@AttributeOverride(name = "lbgSigfip", column = @Column(name = "LBG_SIGFIP", length = 1)),
			@AttributeOverride(name = "lbgFonCodePr", column = @Column(name = "LBG_FON_CODE_PR", length = 30)),
			@AttributeOverride(name = "lbgFonCodeVerou", column = @Column(name = "LBG_FON_CODE_VEROU", length = 30)),
			@AttributeOverride(name = "fppMontantCfa", column = @Column(name = "FPP_MONTANT_CFA", precision = 15)),
			@AttributeOverride(name = "fppMontantDevise", column = @Column(name = "FPP_MONTANT_DEVISE", precision = 15)),
			@AttributeOverride(name = "fppCommentaire", column = @Column(name = "FPP_COMMENTAIRE", length = 500)),
			@AttributeOverride(name = "baiLibelle", column = @Column(name = "BAI_LIBELLE", length = 1000)),
			@AttributeOverride(name = "devLibelle", column = @Column(name = "DEV_LIBELLE", length = 500)),
			@AttributeOverride(name = "devSymbole", column = @Column(name = "DEV_SYMBOLE", length = 500)),
			@AttributeOverride(name = "minLibelle", column = @Column(name = "MIN_LIBELLE", length = 1000)),
			@AttributeOverride(name = "affDppStrConduc", column = @Column(name = "AFF_DPP_STR_CONDUC", length = 1000)),
			@AttributeOverride(name = "affDppStrBenefi", column = @Column(name = "AFF_DPP_STR_BENEFI", length = 1000)) })
	public VPspmDetailsId getId() {
		return this.id;
	}

	public void setId(VPspmDetailsId id) {
		this.id = id;
	}

}
