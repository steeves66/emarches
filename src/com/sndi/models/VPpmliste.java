package com.sndi.models;
// Generated 23 nov. 2020 12:59:43 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VPpmliste generated by hbm2java
 */
@Entity
@Table(name = "V_PPMLISTE", schema = "EMAP")
public class VPpmliste implements java.io.Serializable {

	private VPpmlisteId id;

	public VPpmliste() {
	}

	public VPpmliste(VPpmlisteId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "dppId", column = @Column(name = "DPP_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "dppDteModif", column = @Column(name = "DPP_DTE_MODIF", length = 7)),
			@AttributeOverride(name = "dppObjet", column = @Column(name = "DPP_OBJET", length = 1000)),
			@AttributeOverride(name = "dppSourceFin", column = @Column(name = "DPP_SOURCE_FIN", length = 1000)),
			@AttributeOverride(name = "dppLbgCode", column = @Column(name = "DPP_LBG_CODE", length = 50)),
			@AttributeOverride(name = "dppStaCode", column = @Column(name = "DPP_STA_CODE", nullable = false, length = 3)),
			@AttributeOverride(name = "dppMopCode", column = @Column(name = "DPP_MOP_CODE", nullable = false, length = 3)),
			@AttributeOverride(name = "mopLibelleCourt", column = @Column(name = "MOP_LIBELLE_COURT", nullable = false, length = 500)),
			@AttributeOverride(name = "mopLibelleLong", column = @Column(name = "MOP_LIBELLE_LONG", length = 1000)),
			@AttributeOverride(name = "dppStrCode", column = @Column(name = "DPP_STR_CODE", length = 20)),
			@AttributeOverride(name = "strLibelleCourt", column = @Column(name = "STR_LIBELLE_COURT", nullable = false, length = 500)),
			@AttributeOverride(name = "strLibelleLong", column = @Column(name = "STR_LIBELLE_LONG", length = 1000)),
			@AttributeOverride(name = "lbgFonCodePf", column = @Column(name = "LBG_FON_CODE_PF", length = 30)),
			@AttributeOverride(name = "lbgFonCodeAc", column = @Column(name = "LBG_FON_CODE_AC", length = 30)),
			@AttributeOverride(name = "lbgFonCodeCf", column = @Column(name = "LBG_FON_CODE_CF", length = 30)),
			@AttributeOverride(name = "lbgFonCodeCor", column = @Column(name = "LBG_FON_CODE_COR", length = 30)),
			@AttributeOverride(name = "lbgImputation", column = @Column(name = "LBG_IMPUTATION", length = 50)),
			@AttributeOverride(name = "lbgTotDot", column = @Column(name = "LBG_TOT_DOT", precision = 20, scale = 0)),
			@AttributeOverride(name = "lbgDisTot", column = @Column(name = "LBG_DIS_TOT", precision = 20, scale = 0)),
			@AttributeOverride(name = "lbgAeTr", column = @Column(name = "LBG_AE_TR", precision = 20, scale = 0)),
			@AttributeOverride(name = "lbgFonCodeVal", column = @Column(name = "LBG_FON_CODE_VAL", length = 10)),
			@AttributeOverride(name = "dppDateValAc", column = @Column(name = "DPP_DATE_VAL_AC", length = 7)),
			@AttributeOverride(name = "dppDateValCpmp", column = @Column(name = "DPP_DATE_VAL_CPMP", length = 7)),
			@AttributeOverride(name = "dppDateValDmp", column = @Column(name = "DPP_DATE_VAL_DMP", length = 7)),
			@AttributeOverride(name = "dppPartiePmePmi", column = @Column(name = "DPP_PARTIE_PME_PMI", length = 1)),
			@AttributeOverride(name = "dppDateSaisie", column = @Column(name = "DPP_DATE_SAISIE", length = 7)),
			@AttributeOverride(name = "dppTypePlan", column = @Column(name = "DPP_TYPE_PLAN", nullable = false, length = 3)),
			@AttributeOverride(name = "tymLibelleCourt", column = @Column(name = "TYM_LIBELLE_COURT", nullable = false, length = 500)),
			@AttributeOverride(name = "dppStatutRetour", column = @Column(name = "DPP_STATUT_RETOUR", length = 4)),
			@AttributeOverride(name = "dppStructureConduc", column = @Column(name = "DPP_STRUCTURE_CONDUC", length = 500)),
			@AttributeOverride(name = "dppStructureBenefi", column = @Column(name = "DPP_STRUCTURE_BENEFI", length = 500)),
			@AttributeOverride(name = "dppRecherche", column = @Column(name = "DPP_RECHERCHE", length = 4000)),
			@AttributeOverride(name = "dppFonCodPf", column = @Column(name = "DPP_FON_COD_PF", length = 20)),
			@AttributeOverride(name = "dppFonCodDmp", column = @Column(name = "DPP_FON_COD_DMP", length = 20)),
			@AttributeOverride(name = "dppActeurSaisie", column = @Column(name = "DPP_ACTEUR_SAISIE", length = 12)),
			@AttributeOverride(name = "dppDateAttApprobCpmp", column = @Column(name = "DPP_DATE_ATT_APPROB_CPMP", length = 7)),
			@AttributeOverride(name = "dppDateAvisAoPublication", column = @Column(name = "DPP_DATE_AVIS_AO_PUBLICATION", length = 7)),
			@AttributeOverride(name = "dppDateDaoApprobBail", column = @Column(name = "DPP_DATE_DAO_APPROB_BAIL", length = 7)),
			@AttributeOverride(name = "dppDateDaoApprobDmp", column = @Column(name = "DPP_DATE_DAO_APPROB_DMP", length = 7)),
			@AttributeOverride(name = "dppDateDaoTrans", column = @Column(name = "DPP_DATE_DAO_TRANS", length = 7)),
			@AttributeOverride(name = "dppDateElabRapport", column = @Column(name = "DPP_DATE_ELAB_RAPPORT", length = 7)),
			@AttributeOverride(name = "dppDateJugementOffre", column = @Column(name = "DPP_DATE_JUGEMENT_OFFRE", length = 7)),
			@AttributeOverride(name = "dppDateJugementOffreTec", column = @Column(name = "DPP_DATE_JUGEMENT_OFFRE_TEC", length = 7)),
			@AttributeOverride(name = "dppDateNotAtt", column = @Column(name = "DPP_DATE_NOT_ATT", length = 7)),
			@AttributeOverride(name = "dppDateOuvertOf", column = @Column(name = "DPP_DATE_OUVERT_OF", length = 7)),
			@AttributeOverride(name = "dppDateOuvertOt", column = @Column(name = "DPP_DATE_OUVERT_OT", length = 7)),
			@AttributeOverride(name = "dppDateRecepFact", column = @Column(name = "DPP_DATE_RECEP_FACT", length = 7)),
			@AttributeOverride(name = "dppDateRecepLettr", column = @Column(name = "DPP_DATE_RECEP_LETTR", length = 7)),
			@AttributeOverride(name = "dppDateSolFact", column = @Column(name = "DPP_DATE_SOL_FACT", length = 7)),
			@AttributeOverride(name = "dppInvEntre", column = @Column(name = "DPP_INV_ENTRE", length = 7)),
			@AttributeOverride(name = "dppDateExecDebut", column = @Column(name = "DPP_DATE_EXEC_DEBUT", length = 7)),
			@AttributeOverride(name = "dppDateExecFin", column = @Column(name = "DPP_DATE_EXEC_FIN", length = 7)),
			@AttributeOverride(name = "dppDateSignatAc", column = @Column(name = "DPP_DATE_SIGNAT_AC", length = 7)),
			@AttributeOverride(name = "dppDateSignatAttrib", column = @Column(name = "DPP_DATE_SIGNAT_ATTRIB", length = 7)),
			@AttributeOverride(name = "dppApprobAno", column = @Column(name = "DPP_APPROB_ANO", length = 7)),
			@AttributeOverride(name = "dppDateNegociation", column = @Column(name = "DPP_DATE_NEGOCIATION", length = 7)),
			@AttributeOverride(name = "dppDateMarcheApprob", column = @Column(name = "DPP_DATE_MARCHE_APPROB", length = 7)),
			@AttributeOverride(name = "dppDateAttApproBail", column = @Column(name = "DPP_DATE_ATT_APPRO_BAIL", length = 7)),
			@AttributeOverride(name = "plpId", column = @Column(name = "PLP_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "plpGesCode", column = @Column(name = "PLP_GES_CODE", nullable = false, precision = 4, scale = 0)) })
	public VPpmlisteId getId() {
		return this.id;
	}

	public void setId(VPpmlisteId id) {
		this.id = id;
	}

}
