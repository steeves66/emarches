package com.sndi.models;
// Generated 19 mars 2020 18:39:08 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VLBudgets generated by hbm2java
 */
@Entity
@Table(name = "V_L_BUDGETS", schema = "EMAP")
public class VLBudgets implements java.io.Serializable {

	private VLBudgetsId id;

	public VLBudgets() {
	}

	public VLBudgets(VLBudgetsId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "lbgStrCode", column = @Column(name = "LBG_STR_CODE")),
			@AttributeOverride(name = "lbgGesCode", column = @Column(name = "LBG_GES_CODE")),
			@AttributeOverride(name = "lbgResDon", column = @Column(name = "LBG_RES_DON")),
			@AttributeOverride(name = "lbgImputation", column = @Column(name = "LBG_IMPUTATION")),
			@AttributeOverride(name = "lbgAnoCode", column = @Column(name = "LBG_ANO_CODE")),
			@AttributeOverride(name = "lbgNatCode", column = @Column(name = "LBG_NAT_CODE")),
			@AttributeOverride(name = "lbgResTr", column = @Column(name = "LBG_RES_TR")),
			@AttributeOverride(name = "lbgDteSaisi", column = @Column(name = "LBG_DTE_SAISI")),
			@AttributeOverride(name = "lbgAeTr", column = @Column(name = "LBG_AE_TR")),
			@AttributeOverride(name = "lbgAeDon", column = @Column(name = "LBG_AE_DON")),
			@AttributeOverride(name = "lbgAeEmp", column = @Column(name = "LBG_AE_EMP")),
			@AttributeOverride(name = "lbgMp", column = @Column(name = "LBG_MP")),
			@AttributeOverride(name = "lbgReglMp", column = @Column(name = "LBG_REGL_MP")),
			@AttributeOverride(name = "lbgTotDot", column = @Column(name = "LBG_TOT_DOT")),
			@AttributeOverride(name = "lbgUtilSaisi", column = @Column(name = "LBG_UTIL_SAISI")),
			@AttributeOverride(name = "lbgDesCode", column = @Column(name = "LBG_DES_CODE")),
			@AttributeOverride(name = "lbgDteModif", column = @Column(name = "LBG_DTE_MODIF")),
			@AttributeOverride(name = "lbgResEmp", column = @Column(name = "LBG_RES_EMP")),
			@AttributeOverride(name = "lbgResTot", column = @Column(name = "LBG_RES_TOT")),
			@AttributeOverride(name = "lbgUtilModif", column = @Column(name = "LBG_UTIL_MODIF")),
			@AttributeOverride(name = "lbgFonCode", column = @Column(name = "LBG_FON_CODE")),
			@AttributeOverride(name = "lbgDisTre", column = @Column(name = "LBG_DIS_TRE")),
			@AttributeOverride(name = "lbgDisDon", column = @Column(name = "LBG_DIS_DON")),
			@AttributeOverride(name = "lbgDisEmp", column = @Column(name = "LBG_DIS_EMP")),
			@AttributeOverride(name = "lbgDisTot", column = @Column(name = "LBG_DIS_TOT")),
			@AttributeOverride(name = "lbgFonCodeAc", column = @Column(name = "LBG_FON_CODE_AC")),
			@AttributeOverride(name = "lbgStaCode", column = @Column(name = "LBG_STA_CODE")),
			@AttributeOverride(name = "lbgActNumModif", column = @Column(name = "LBG_ACT_NUM_MODIF")),
			@AttributeOverride(name = "lbgDteVal", column = @Column(name = "LBG_DTE_VAL")),
			@AttributeOverride(name = "lbgFonCodeVal", column = @Column(name = "LBG_FON_CODE_VAL")),
			@AttributeOverride(name = "lbgTraitmt", column = @Column(name = "LBG_TRAITMT")),
			@AttributeOverride(name = "lbgTraitmtNotif", column = @Column(name = "LBG_TRAITMT_NOTIF")),
			@AttributeOverride(name = "lbgDteStaCour", column = @Column(name = "LBG_DTE_STA_COUR")),
			@AttributeOverride(name = "lbgTitre", column = @Column(name = "LBG_TITRE")),
			@AttributeOverride(name = "lbgCor", column = @Column(name = "LBG_COR")),
			@AttributeOverride(name = "lbgAdmCentral", column = @Column(name = "LBG_ADM_CENTRAL")),
			@AttributeOverride(name = "lbgMotifCor", column = @Column(name = "LBG_MOTIF_COR")),
			@AttributeOverride(name = "lbgDteCor", column = @Column(name = "LBG_DTE_COR")),
			@AttributeOverride(name = "lbgFonCodeCor", column = @Column(name = "LBG_FON_CODE_COR")),
			@AttributeOverride(name = "lbgFonCodePf", column = @Column(name = "LBG_FON_CODE_PF")),
			@AttributeOverride(name = "lbgFonCodeValAct", column = @Column(name = "LBG_FON_CODE_VAL_ACT")),
			@AttributeOverride(name = "lbgActif", column = @Column(name = "LBG_ACTIF")),
			@AttributeOverride(name = "lbgFonCodeCf", column = @Column(name = "LBG_FON_CODE_CF")),
			@AttributeOverride(name = "lbgDotAnPlus1", column = @Column(name = "LBG_DOT_AN_PLUS1")),
			@AttributeOverride(name = "lbgDotAnPlus2", column = @Column(name = "LBG_DOT_AN_PLUS2")),
			@AttributeOverride(name = "lbgDotAnPlus0", column = @Column(name = "LBG_DOT_AN_PLUS0")),
			@AttributeOverride(name = "lbgTypBud", column = @Column(name = "LBG_TYP_BUD")),
			@AttributeOverride(name = "lbgDteMp", column = @Column(name = "LBG_DTE_MP")),
			@AttributeOverride(name = "lbgUtilSaisiAct", column = @Column(name = "LBG_UTIL_SAISI_ACT")),
			@AttributeOverride(name = "lbgSigfip", column = @Column(name = "LBG_SIGFIP")),
			@AttributeOverride(name = "lbgFonCodePr", column = @Column(name = "LBG_FON_CODE_PR")),
			@AttributeOverride(name = "lbgFonCodeVerou", column = @Column(name = "LBG_FON_CODE_VEROU")),
			@AttributeOverride(name = "lbgCode", column = @Column(name = "LBG_CODE")) })
	public VLBudgetsId getId() {
		return this.id;
	}

	public void setId(VLBudgetsId id) {
		this.id = id;
	}

}
