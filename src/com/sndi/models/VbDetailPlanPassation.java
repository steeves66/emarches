package com.sndi.models;
// Generated 25 juin 2020 13:53:46 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbDetailPlanPassation generated by hbm2java
 */
@Entity
@Table(name = "VB_DETAIL_PLAN_PASSATION", schema = "EMAP")
public class VbDetailPlanPassation implements java.io.Serializable {

	private VbDetailPlanPassationId id;

	public VbDetailPlanPassation() {
	}

	public VbDetailPlanPassation(VbDetailPlanPassationId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "dppId", column = @Column(name = "DPP_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "dppPlpId", column = @Column(name = "DPP_PLP_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "dppGpgId", column = @Column(name = "DPP_GPG_ID", precision = 10, scale = 0)),
			@AttributeOverride(name = "dppStaCode", column = @Column(name = "DPP_STA_CODE", nullable = false, length = 3)),
			@AttributeOverride(name = "dppTymCode", column = @Column(name = "DPP_TYM_CODE", nullable = false, length = 3)),
			@AttributeOverride(name = "dppMopCode", column = @Column(name = "DPP_MOP_CODE", nullable = false, length = 3)),
			@AttributeOverride(name = "dppLbgCode", column = @Column(name = "DPP_LBG_CODE", length = 50)),
			@AttributeOverride(name = "dppTypePlan", column = @Column(name = "DPP_TYPE_PLAN", nullable = false, length = 3)),
			@AttributeOverride(name = "dppCode", column = @Column(name = "DPP_CODE", length = 50)),
			@AttributeOverride(name = "dppNumeroOrdre", column = @Column(name = "DPP_NUMERO_ORDRE", precision = 8, scale = 0)),
			@AttributeOverride(name = "dppDate", column = @Column(name = "DPP_DATE", length = 7)),
			@AttributeOverride(name = "dppObjet", column = @Column(name = "DPP_OBJET", length = 1000)),
			@AttributeOverride(name = "dppSourceFin", column = @Column(name = "DPP_SOURCE_FIN", length = 1000)),
			@AttributeOverride(name = "dppDateDaoTrans", column = @Column(name = "DPP_DATE_DAO_TRANS", length = 7)),
			@AttributeOverride(name = "dppDateDaoApprobDmp", column = @Column(name = "DPP_DATE_DAO_APPROB_DMP", length = 7)),
			@AttributeOverride(name = "dppDateDaoApprobBail", column = @Column(name = "DPP_DATE_DAO_APPROB_BAIL", length = 7)),
			@AttributeOverride(name = "dppDateAvisAoPublication", column = @Column(name = "DPP_DATE_AVIS_AO_PUBLICATION", length = 7)),
			@AttributeOverride(name = "dppDateOuvertOt", column = @Column(name = "DPP_DATE_OUVERT_OT", length = 7)),
			@AttributeOverride(name = "dppDateOuvertOf", column = @Column(name = "DPP_DATE_OUVERT_OF", length = 7)),
			@AttributeOverride(name = "dppDateElabRapport", column = @Column(name = "DPP_DATE_ELAB_RAPPORT", length = 7)),
			@AttributeOverride(name = "dppDateJugementOffre", column = @Column(name = "DPP_DATE_JUGEMENT_OFFRE", length = 7)),
			@AttributeOverride(name = "dppDateAttApprobDmp", column = @Column(name = "DPP_DATE_ATT_APPROB_DMP", length = 7)),
			@AttributeOverride(name = "dppDateAttApproBail", column = @Column(name = "DPP_DATE_ATT_APPRO_BAIL", length = 7)),
			@AttributeOverride(name = "dppDateNegociation", column = @Column(name = "DPP_DATE_NEGOCIATION", length = 7)),
			@AttributeOverride(name = "dppDateSignatAttrib", column = @Column(name = "DPP_DATE_SIGNAT_ATTRIB", length = 7)),
			@AttributeOverride(name = "dppDateSignatAc", column = @Column(name = "DPP_DATE_SIGNAT_AC", length = 7)),
			@AttributeOverride(name = "dppDateMarcheApprob", column = @Column(name = "DPP_DATE_MARCHE_APPROB", length = 7)),
			@AttributeOverride(name = "dppDateExecDebut", column = @Column(name = "DPP_DATE_EXEC_DEBUT", length = 7)),
			@AttributeOverride(name = "dppDateExecFin", column = @Column(name = "DPP_DATE_EXEC_FIN", length = 7)),
			@AttributeOverride(name = "dppActeurSaisie", column = @Column(name = "DPP_ACTEUR_SAISIE", length = 12)),
			@AttributeOverride(name = "dppStrCode", column = @Column(name = "DPP_STR_CODE", length = 20)),
			@AttributeOverride(name = "dppStatutRetour", column = @Column(name = "DPP_STATUT_RETOUR", length = 4)),
			@AttributeOverride(name = "dppDateSaisie", column = @Column(name = "DPP_DATE_SAISIE", length = 7)),
			@AttributeOverride(name = "dppStructureConduc", column = @Column(name = "DPP_STRUCTURE_CONDUC", length = 500)),
			@AttributeOverride(name = "dppStructureBenefi", column = @Column(name = "DPP_STRUCTURE_BENEFI", length = 500)),
			@AttributeOverride(name = "dppPartiePmePmi", column = @Column(name = "DPP_PARTIE_PME_PMI", length = 1)),
			@AttributeOverride(name = "dppTypId", column = @Column(name = "DPP_TYP_ID", length = 5)),
			@AttributeOverride(name = "dppStatutDao", column = @Column(name = "DPP_STATUT_DAO", length = 2)),
			@AttributeOverride(name = "dppPieceDao", column = @Column(name = "DPP_PIECE_DAO", length = 15)),
			@AttributeOverride(name = "dppDacCode", column = @Column(name = "DPP_DAC_CODE", length = 20)),
			@AttributeOverride(name = "dppInvEntre", column = @Column(name = "DPP_INV_ENTRE", length = 7)),
			@AttributeOverride(name = "dppDateAttApprobCpmp", column = @Column(name = "DPP_DATE_ATT_APPROB_CPMP", length = 7)),
			@AttributeOverride(name = "dppDateJugementOffreTec", column = @Column(name = "DPP_DATE_JUGEMENT_OFFRE_TEC", length = 7)),
			@AttributeOverride(name = "dppDateValAc", column = @Column(name = "DPP_DATE_VAL_AC", length = 7)),
			@AttributeOverride(name = "dppDateValCpmp", column = @Column(name = "DPP_DATE_VAL_CPMP", length = 7)),
			@AttributeOverride(name = "dppDateValDmp", column = @Column(name = "DPP_DATE_VAL_DMP", length = 7)),
			@AttributeOverride(name = "dppBailleur", column = @Column(name = "DPP_BAILLEUR", length = 1)),
			@AttributeOverride(name = "dppTypeFinance", column = @Column(name = "DPP_TYPE_FINANCE", length = 20)),
			@AttributeOverride(name = "dppApprobAno", column = @Column(name = "DPP_APPROB_ANO", length = 7)),
			@AttributeOverride(name = "dppDteModif", column = @Column(name = "DPP_DTE_MODIF", length = 7)),
			@AttributeOverride(name = "dppRecherche", column = @Column(name = "DPP_RECHERCHE", length = 4000)),
			@AttributeOverride(name = "dppFonCodPf", column = @Column(name = "DPP_FON_COD_PF", length = 20)),
			@AttributeOverride(name = "dppFonCodDmp", column = @Column(name = "DPP_FON_COD_DMP", length = 20)),
			@AttributeOverride(name = "dppMontant", column = @Column(name = "DPP_MONTANT", precision = 15, scale = 0)) })
	public VbDetailPlanPassationId getId() {
		return this.id;
	}

	public void setId(VbDetailPlanPassationId id) {
		this.id = id;
	}

}
