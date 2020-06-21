package com.sndi.models;
// Generated 20 juin 2020 17:16:02 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VDaoChargeEtude generated by hbm2java
 */
@Entity
@Table(name = "V_DAO_CHARGE_ETUDE", schema = "EMAP")
public class VDaoChargeEtude implements java.io.Serializable {

	private VDaoChargeEtudeId id;

	public VDaoChargeEtude() {
	}

	public VDaoChargeEtude(VDaoChargeEtudeId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "dacCode", column = @Column(name = "DAC_CODE", nullable = false, length = 20)),
			@AttributeOverride(name = "dacObjet", column = @Column(name = "DAC_OBJET", length = 1000)),
			@AttributeOverride(name = "dacDteSaisi", column = @Column(name = "DAC_DTE_SAISI", length = 7)),
			@AttributeOverride(name = "dacStaCode", column = @Column(name = "DAC_STA_CODE", length = 3)),
			@AttributeOverride(name = "dacTymCode", column = @Column(name = "DAC_TYM_CODE", length = 5)),
			@AttributeOverride(name = "dacTypePlan", column = @Column(name = "DAC_TYPE_PLAN", length = 4)),
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
			@AttributeOverride(name = "dacRecherche", column = @Column(name = "DAC_RECHERCHE", length = 4000)),
			@AttributeOverride(name = "dcsOpeMatricule", column = @Column(name = "DCS_OPE_MATRICULE", length = 20)),
			@AttributeOverride(name = "dcsPreMbm", column = @Column(name = "DCS_PRE_MBM", length = 200)),
			@AttributeOverride(name = "dcsComStrCode", column = @Column(name = "DCS_COM_STR_CODE", length = 20)),
			@AttributeOverride(name = "dcsMbmRespo", column = @Column(name = "DCS_MBM_RESPO", length = 1)),
			@AttributeOverride(name = "dcsFonCod", column = @Column(name = "DCS_FON_COD", length = 100)),
			@AttributeOverride(name = "tdcLibelle", column = @Column(name = "TDC_LIBELLE", length = 1000)),
			@AttributeOverride(name = "tymLibelleCourt", column = @Column(name = "TYM_LIBELLE_COURT", nullable = false, length = 500)),
			@AttributeOverride(name = "mopLibelleLong", column = @Column(name = "MOP_LIBELLE_LONG", length = 1000)) })
	public VDaoChargeEtudeId getId() {
		return this.id;
	}

	public void setId(VDaoChargeEtudeId id) {
		this.id = id;
	}

}
