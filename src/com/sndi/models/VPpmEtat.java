package com.sndi.models;
// Generated 4 avr. 2020 18:03:14 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VPpmEtat generated by hbm2java
 */
@Entity
@Table(name = "V_PPM_ETAT", schema = "EMAP")
public class VPpmEtat implements java.io.Serializable {

	private VPpmEtatId id;

	public VPpmEtat() {
	}

	public VPpmEtat(VPpmEtatId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "VId", column = @Column(name = "V_ID", precision = 22, scale = 0)),
			@AttributeOverride(name = "affId", column = @Column(name = "AFF_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "affDppId", column = @Column(name = "AFF_DPP_ID", precision = 10, scale = 0)),
			@AttributeOverride(name = "fonLibelle", column = @Column(name = "FON_LIBELLE", length = 500)),
			@AttributeOverride(name = "affDppObjet", column = @Column(name = "AFF_DPP_OBJET", length = 1000)),
			@AttributeOverride(name = "affDppSourceFin", column = @Column(name = "AFF_DPP_SOURCE_FIN", length = 1000)),
			@AttributeOverride(name = "lbgCode", column = @Column(name = "LBG_CODE", nullable = false, length = 50)),
			@AttributeOverride(name = "lbgImputation", column = @Column(name = "LBG_IMPUTATION", nullable = false, length = 50)),
			@AttributeOverride(name = "natCode", column = @Column(name = "NAT_CODE", nullable = false, length = 20)),
			@AttributeOverride(name = "natLibelle", column = @Column(name = "NAT_LIBELLE", length = 200)),
			@AttributeOverride(name = "tymLibelleCourt", column = @Column(name = "TYM_LIBELLE_COURT", nullable = false, length = 500)),
			@AttributeOverride(name = "mopLibelleLong", column = @Column(name = "MOP_LIBELLE_LONG", length = 1000)),
			@AttributeOverride(name = "affDppDateAvisAoPublicat", column = @Column(name = "AFF_DPP_DATE_AVIS_AO_PUBLICAT", length = 7)),
			@AttributeOverride(name = "affDppDateOuvertOt", column = @Column(name = "AFF_DPP_DATE_OUVERT_OT", length = 7)),
			@AttributeOverride(name = "affDppDateOuvertOf", column = @Column(name = "AFF_DPP_DATE_OUVERT_OF", length = 7)),
			@AttributeOverride(name = "affDppDateJugementOffre", column = @Column(name = "AFF_DPP_DATE_JUGEMENT_OFFRE", length = 7)),
			@AttributeOverride(name = "affDppDateAttApprobDmp", column = @Column(name = "AFF_DPP_DATE_ATT_APPROB_DMP", length = 7)),
			@AttributeOverride(name = "affDppDateAttApproBail", column = @Column(name = "AFF_DPP_DATE_ATT_APPRO_BAIL", length = 7)),
			@AttributeOverride(name = "affDppPlpId", column = @Column(name = "AFF_DPP_PLP_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "affDppStrBenefi", column = @Column(name = "AFF_DPP_STR_BENEFI", length = 1000)),
			@AttributeOverride(name = "affDppStrConduc", column = @Column(name = "AFF_DPP_STR_CONDUC", length = 1000)),
			@AttributeOverride(name = "affDppTypePlan", column = @Column(name = "AFF_DPP_TYPE_PLAN", nullable = false, length = 3)),
			@AttributeOverride(name = "affDppDateNegociation", column = @Column(name = "AFF_DPP_DATE_NEGOCIATION", length = 7)),
			@AttributeOverride(name = "affDppDateElabRapport", column = @Column(name = "AFF_DPP_DATE_ELAB_RAPPORT", length = 7)),
			@AttributeOverride(name = "affDppDateSignatAttrib", column = @Column(name = "AFF_DPP_DATE_SIGNAT_ATTRIB", length = 7)),
			@AttributeOverride(name = "affDppDateSignatAc", column = @Column(name = "AFF_DPP_DATE_SIGNAT_AC", length = 7)),
			@AttributeOverride(name = "affDppDateExecDebut", column = @Column(name = "AFF_DPP_DATE_EXEC_DEBUT", length = 7)),
			@AttributeOverride(name = "affDppDateExecFin", column = @Column(name = "AFF_DPP_DATE_EXEC_FIN", length = 7)),
			@AttributeOverride(name = "affDppDateDaoTrans", column = @Column(name = "AFF_DPP_DATE_DAO_TRANS", length = 7)),
			@AttributeOverride(name = "affDppDateDaoApprobDmp", column = @Column(name = "AFF_DPP_DATE_DAO_APPROB_DMP", length = 7)),
			@AttributeOverride(name = "affDppDateDaoApprobBail", column = @Column(name = "AFF_DPP_DATE_DAO_APPROB_BAIL", length = 7)),
			@AttributeOverride(name = "affDppInvEntre", column = @Column(name = "AFF_DPP_INV_ENTRE", length = 7)),
			@AttributeOverride(name = "affDppApprobAno", column = @Column(name = "AFF_DPP_APPROB_ANO", length = 7)),
			@AttributeOverride(name = "affDppTypeFinance", column = @Column(name = "AFF_DPP_TYPE_FINANCE", length = 20)) })
	public VPpmEtatId getId() {
		return this.id;
	}

	public void setId(VPpmEtatId id) {
		this.id = id;
	}

}
