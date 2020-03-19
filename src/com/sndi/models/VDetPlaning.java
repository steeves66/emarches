package com.sndi.models;
// Generated 19 mars 2020 16:14:06 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VDetPlaning generated by hbm2java
 */
@Entity
@Table(name = "V_DET_PLANING", schema = "EMAP")
public class VDetPlaning implements java.io.Serializable {

	private VDetPlaningId id;

	public VDetPlaning() {
	}

	public VDetPlaning(VDetPlaningId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "dppDateExecFin", column = @Column(name = "DPP_DATE_EXEC_FIN")),
			@AttributeOverride(name = "dppDateExecDebut", column = @Column(name = "DPP_DATE_EXEC_DEBUT")),
			@AttributeOverride(name = "dppDateMarcheApprob", column = @Column(name = "DPP_DATE_MARCHE_APPROB")),
			@AttributeOverride(name = "dppDateSignatAc", column = @Column(name = "DPP_DATE_SIGNAT_AC")),
			@AttributeOverride(name = "dppDateSignatAttrib", column = @Column(name = "DPP_DATE_SIGNAT_ATTRIB")),
			@AttributeOverride(name = "dppDateNegociation", column = @Column(name = "DPP_DATE_NEGOCIATION")),
			@AttributeOverride(name = "dppDateAttApproBail", column = @Column(name = "DPP_DATE_ATT_APPRO_BAIL")),
			@AttributeOverride(name = "dppDateAttApprobDmp", column = @Column(name = "DPP_DATE_ATT_APPROB_DMP")),
			@AttributeOverride(name = "dppDateJugementOffre", column = @Column(name = "DPP_DATE_JUGEMENT_OFFRE")),
			@AttributeOverride(name = "dppDateElabRapport", column = @Column(name = "DPP_DATE_ELAB_RAPPORT")),
			@AttributeOverride(name = "dppDateOuvertOf", column = @Column(name = "DPP_DATE_OUVERT_OF")),
			@AttributeOverride(name = "dppDateOuvertOt", column = @Column(name = "DPP_DATE_OUVERT_OT")),
			@AttributeOverride(name = "dppDateAvisAoPublication", column = @Column(name = "DPP_DATE_AVIS_AO_PUBLICATION")),
			@AttributeOverride(name = "dppDateDaoApprobBail", column = @Column(name = "DPP_DATE_DAO_APPROB_BAIL")),
			@AttributeOverride(name = "dppDateDaoApprobDmp", column = @Column(name = "DPP_DATE_DAO_APPROB_DMP")),
			@AttributeOverride(name = "dppDateDaoTrans", column = @Column(name = "DPP_DATE_DAO_TRANS")),
			@AttributeOverride(name = "dppSourceFin", column = @Column(name = "DPP_SOURCE_FIN")),
			@AttributeOverride(name = "dppObjet", column = @Column(name = "DPP_OBJET")),
			@AttributeOverride(name = "dppDate", column = @Column(name = "DPP_DATE")),
			@AttributeOverride(name = "dppNumeroOrdre", column = @Column(name = "DPP_NUMERO_ORDRE")),
			@AttributeOverride(name = "dppCode", column = @Column(name = "DPP_CODE")),
			@AttributeOverride(name = "dppTypePlan", column = @Column(name = "DPP_TYPE_PLAN")),
			@AttributeOverride(name = "dppLbgCode", column = @Column(name = "DPP_LBG_CODE")),
			@AttributeOverride(name = "dppMopCode", column = @Column(name = "DPP_MOP_CODE")),
			@AttributeOverride(name = "dppTymCode", column = @Column(name = "DPP_TYM_CODE")),
			@AttributeOverride(name = "dppStaCode", column = @Column(name = "DPP_STA_CODE")),
			@AttributeOverride(name = "dppGpgId", column = @Column(name = "DPP_GPG_ID")),
			@AttributeOverride(name = "dppPlpId", column = @Column(name = "DPP_PLP_ID")),
			@AttributeOverride(name = "dppId", column = @Column(name = "DPP_ID")),
			@AttributeOverride(name = "dppDateAttApprobCpmp", column = @Column(name = "DPP_DATE_ATT_APPROB_CPMP")),
			@AttributeOverride(name = "dppInvEntre", column = @Column(name = "DPP_INV_ENTRE")),
			@AttributeOverride(name = "dppDacCode", column = @Column(name = "DPP_DAC_CODE")),
			@AttributeOverride(name = "dppPieceDao", column = @Column(name = "DPP_PIECE_DAO")),
			@AttributeOverride(name = "dppStatutDao", column = @Column(name = "DPP_STATUT_DAO")),
			@AttributeOverride(name = "dppTypId", column = @Column(name = "DPP_TYP_ID")),
			@AttributeOverride(name = "dppPartiePmePmi", column = @Column(name = "DPP_PARTIE_PME_PMI")),
			@AttributeOverride(name = "dppStructureBenefi", column = @Column(name = "DPP_STRUCTURE_BENEFI")),
			@AttributeOverride(name = "dppStructureConduc", column = @Column(name = "DPP_STRUCTURE_CONDUC")),
			@AttributeOverride(name = "dppDateSaisie", column = @Column(name = "DPP_DATE_SAISIE")),
			@AttributeOverride(name = "dppStatutRetour", column = @Column(name = "DPP_STATUT_RETOUR")),
			@AttributeOverride(name = "dppStrCode", column = @Column(name = "DPP_STR_CODE")),
			@AttributeOverride(name = "dppActeurSaisie", column = @Column(name = "DPP_ACTEUR_SAISIE")),
			@AttributeOverride(name = "dppDateJugementOffreTec", column = @Column(name = "DPP_DATE_JUGEMENT_OFFRE_TEC")) })
	public VDetPlaningId getId() {
		return this.id;
	}

	public void setId(VDetPlaningId id) {
		this.id = id;
	}

}
