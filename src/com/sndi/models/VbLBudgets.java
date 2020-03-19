package com.sndi.models;
// Generated 19 mars 2020 18:39:08 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbLBudgets generated by hbm2java
 */
@Entity
@Table(name = "VB_L_BUDGETS", schema = "EMAP")
public class VbLBudgets implements java.io.Serializable {

	private VbLBudgetsId id;

	public VbLBudgets() {
	}

	public VbLBudgets(VbLBudgetsId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
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
			@AttributeOverride(name = "lbgFonCodeVerou", column = @Column(name = "LBG_FON_CODE_VEROU", length = 30)) })
	public VbLBudgetsId getId() {
		return this.id;
	}

	public void setId(VbLBudgetsId id) {
		this.id = id;
	}

}
