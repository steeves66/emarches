package com.sndi.models;
// Generated 23 nov. 2020 12:59:43 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * TAffichageDao generated by hbm2java
 */
@Entity
@Table(name = "T_AFFICHAGE_DAO", schema = "EMAP")
public class TAffichageDao implements java.io.Serializable {

	private TAffichageDaoId id;

	public TAffichageDao() {
	}

	public TAffichageDao(TAffichageDaoId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "affDaoId", column = @Column(name = "AFF_DAO_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "affDcsNum", column = @Column(name = "AFF_DCS_NUM", precision = 22, scale = 0)),
			@AttributeOverride(name = "affDacCode", column = @Column(name = "AFF_DAC_CODE", nullable = false, length = 20)),
			@AttributeOverride(name = "affOpeMatricule", column = @Column(name = "AFF_OPE_MATRICULE", length = 25)),
			@AttributeOverride(name = "affStaCode", column = @Column(name = "AFF_STA_CODE", length = 3)),
			@AttributeOverride(name = "affStatutRetour", column = @Column(name = "AFF_STATUT_RETOUR", length = 4)),
			@AttributeOverride(name = "affDacDteSaisi", column = @Column(name = "AFF_DAC_DTE_SAISI", length = 7)),
			@AttributeOverride(name = "affDacObjet", column = @Column(name = "AFF_DAC_OBJET", length = 1000)),
			@AttributeOverride(name = "affDacTymCode", column = @Column(name = "AFF_DAC_TYM_CODE", length = 5)),
			@AttributeOverride(name = "affDacMopCode", column = @Column(name = "AFF_DAC_MOP_CODE", length = 3)),
			@AttributeOverride(name = "affNbrOuv", column = @Column(name = "AFF_NBR_OUV", precision = 22, scale = 0)),
			@AttributeOverride(name = "affDacStrCode", column = @Column(name = "AFF_DAC_STR_CODE", length = 20)),
			@AttributeOverride(name = "affDacGesCode", column = @Column(name = "AFF_DAC_GES_CODE", precision = 22, scale = 0)),
			@AttributeOverride(name = "affDacFonCodeCpmp", column = @Column(name = "AFF_DAC_FON_CODE_CPMP", length = 12)),
			@AttributeOverride(name = "affDacFonCodAc", column = @Column(name = "AFF_DAC_FON_COD_AC", length = 12)),
			@AttributeOverride(name = "affDacDacDteValCpmp", column = @Column(name = "AFF_DAC_DAC_DTE_VAL_CPMP", length = 7)),
			@AttributeOverride(name = "affDacDacDteValDmp", column = @Column(name = "AFF_DAC_DAC_DTE_VAL_DMP", length = 7)),
			@AttributeOverride(name = "affDacTdCode", column = @Column(name = "AFF_DAC_TD_CODE", length = 3)),
			@AttributeOverride(name = "affDacDppId", column = @Column(name = "AFF_DAC_DPP_ID", precision = 20, scale = 0)),
			@AttributeOverride(name = "affDacDateReception", column = @Column(name = "AFF_DAC_DATE_RECEPTION", length = 7)),
			@AttributeOverride(name = "affDacStatutRetour", column = @Column(name = "AFF_DAC_STATUT_RETOUR", length = 2)),
			@AttributeOverride(name = "affDacMention", column = @Column(name = "AFF_DAC_MENTION", length = 100)),
			@AttributeOverride(name = "affDacRecherche", column = @Column(name = "AFF_DAC_RECHERCHE", length = 4000)),
			@AttributeOverride(name = "affDacValAc", column = @Column(name = "AFF_DAC_VAL_AC", length = 7)),
			@AttributeOverride(name = "affDacAvisBailleur", column = @Column(name = "AFF_DAC_AVIS_BAILLEUR", length = 4000)),
			@AttributeOverride(name = "affDacDateBailleur", column = @Column(name = "AFF_DAC_DATE_BAILLEUR", length = 7)),
			@AttributeOverride(name = "affDacBailleur", column = @Column(name = "AFF_DAC_BAILLEUR", length = 1)),
			@AttributeOverride(name = "affDacCout", column = @Column(name = "AFF_DAC_COUT", precision = 11, scale = 0)),
			@AttributeOverride(name = "affDacTypePlan", column = @Column(name = "AFF_DAC_TYPE_PLAN", length = 4)),
			@AttributeOverride(name = "affFonCodeDmp", column = @Column(name = "AFF_FON_CODE_DMP", length = 20)),
			@AttributeOverride(name = "affFonCodePf", column = @Column(name = "AFF_FON_CODE_PF", length = 20)) })
	public TAffichageDaoId getId() {
		return this.id;
	}

	public void setId(TAffichageDaoId id) {
		this.id = id;
	}

}
