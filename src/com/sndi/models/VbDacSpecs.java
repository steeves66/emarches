package com.sndi.models;
// Generated 20 juin 2020 17:16:02 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbDacSpecs generated by hbm2java
 */
@Entity
@Table(name = "VB_DAC_SPECS", schema = "EMAP")
public class VbDacSpecs implements java.io.Serializable {

	private VbDacSpecsId id;

	public VbDacSpecs() {
	}

	public VbDacSpecs(VbDacSpecsId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
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
			@AttributeOverride(name = "dacRecherche", column = @Column(name = "DAC_RECHERCHE", length = 4000)) })
	public VbDacSpecsId getId() {
		return this.id;
	}

	public void setId(VbDacSpecsId id) {
		this.id = id;
	}

}
