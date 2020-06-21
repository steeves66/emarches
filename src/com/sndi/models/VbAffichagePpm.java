package com.sndi.models;
// Generated 20 juin 2020 17:16:02 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbAffichagePpm generated by hbm2java
 */
@Entity
@Table(name = "VB_AFFICHAGE_PPM", schema = "EMAP")
public class VbAffichagePpm implements java.io.Serializable {

	private VbAffichagePpmId id;

	public VbAffichagePpm() {
	}

	public VbAffichagePpm(VbAffichagePpmId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "affId", column = @Column(name = "AFF_ID", nullable = false, precision = 10, scale = 0)),
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
			@AttributeOverride(name = "affDppActeurSaisie", column = @Column(name = "AFF_DPP_ACTEUR_SAISIE", length = 12)),
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
			@AttributeOverride(name = "affDppId", column = @Column(name = "AFF_DPP_ID", precision = 10, scale = 0)),
			@AttributeOverride(name = "affDppStatutRetour", column = @Column(name = "AFF_DPP_STATUT_RETOUR", length = 10)),
			@AttributeOverride(name = "affDppFonCod", column = @Column(name = "AFF_DPP_FON_COD", length = 12)),
			@AttributeOverride(name = "affDppStrCode", column = @Column(name = "AFF_DPP_STR_CODE", length = 20)),
			@AttributeOverride(name = "affDppStrConduc", column = @Column(name = "AFF_DPP_STR_CONDUC", length = 1000)),
			@AttributeOverride(name = "affDppStrBenefi", column = @Column(name = "AFF_DPP_STR_BENEFI", length = 1000)),
			@AttributeOverride(name = "affDppDateSaisie", column = @Column(name = "AFF_DPP_DATE_SAISIE", length = 7)),
			@AttributeOverride(name = "affTypId", column = @Column(name = "AFF_TYP_ID", length = 5)),
			@AttributeOverride(name = "affDppPartiePmePmi", column = @Column(name = "AFF_DPP_PARTIE_PME_PMI", length = 1)),
			@AttributeOverride(name = "affDppStatutDao", column = @Column(name = "AFF_DPP_STATUT_DAO", length = 2)),
			@AttributeOverride(name = "affDppPieceDao", column = @Column(name = "AFF_DPP_PIECE_DAO", length = 15)),
			@AttributeOverride(name = "affDppInvEntre", column = @Column(name = "AFF_DPP_INV_ENTRE", length = 7)),
			@AttributeOverride(name = "affDppRecherche", column = @Column(name = "AFF_DPP_RECHERCHE", length = 4000)),
			@AttributeOverride(name = "affDppDateValAc", column = @Column(name = "AFF_DPP_DATE_VAL_AC", length = 7)),
			@AttributeOverride(name = "affDppDateValCpmp", column = @Column(name = "AFF_DPP_DATE_VAL_CPMP", length = 7)),
			@AttributeOverride(name = "affDppDateValDmp", column = @Column(name = "AFF_DPP_DATE_VAL_DMP", length = 7)),
			@AttributeOverride(name = "affDppBailleur", column = @Column(name = "AFF_DPP_BAILLEUR", length = 1)),
			@AttributeOverride(name = "affDppTypeFinance", column = @Column(name = "AFF_DPP_TYPE_FINANCE", length = 20)),
			@AttributeOverride(name = "affDppApprobAno", column = @Column(name = "AFF_DPP_APPROB_ANO", length = 7)),
			@AttributeOverride(name = "affDppDteModif", column = @Column(name = "AFF_DPP_DTE_MODIF", length = 7)),
			@AttributeOverride(name = "affDppDateAttApprobCmp", column = @Column(name = "AFF_DPP_DATE_ATT_APPROB_CMP", length = 7)),
			@AttributeOverride(name = "affDppDateJugementTech", column = @Column(name = "AFF_DPP_DATE_JUGEMENT_TECH", length = 7)),
			@AttributeOverride(name = "affFonCodPf", column = @Column(name = "AFF_FON_COD_PF", length = 20)),
			@AttributeOverride(name = "affFonCodDmp", column = @Column(name = "AFF_FON_COD_DMP", length = 20)),
			@AttributeOverride(name = "affDppMontant", column = @Column(name = "AFF_DPP_MONTANT", precision = 15, scale = 0)) })
	public VbAffichagePpmId getId() {
		return this.id;
	}

	public void setId(VbAffichagePpmId id) {
		this.id = id;
	}

}
