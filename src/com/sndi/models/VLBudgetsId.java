package com.sndi.models;
// Generated 4 juil. 2020 18:05:44 by Hibernate Tools 4.3.5.Final

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VLBudgetsId generated by hbm2java
 */
@Embeddable
public class VLBudgetsId implements java.io.Serializable {

	private Serializable lbgStrCode;
	private Serializable lbgGesCode;
	private Serializable lbgResDon;
	private Serializable lbgImputation;
	private Serializable lbgAnoCode;
	private Serializable lbgNatCode;
	private Serializable lbgResTr;
	private Serializable lbgDteSaisi;
	private Serializable lbgAeTr;
	private Serializable lbgAeDon;
	private Serializable lbgAeEmp;
	private Serializable lbgMp;
	private Serializable lbgReglMp;
	private Serializable lbgTotDot;
	private Serializable lbgUtilSaisi;
	private Serializable lbgDesCode;
	private Serializable lbgDteModif;
	private Serializable lbgResEmp;
	private Serializable lbgResTot;
	private Serializable lbgUtilModif;
	private Serializable lbgFonCode;
	private Serializable lbgDisTre;
	private Serializable lbgDisDon;
	private Serializable lbgDisEmp;
	private Serializable lbgDisTot;
	private Serializable lbgFonCodeAc;
	private Serializable lbgStaCode;
	private Serializable lbgActNumModif;
	private Serializable lbgDteVal;
	private Serializable lbgFonCodeVal;
	private Serializable lbgTraitmt;
	private Serializable lbgTraitmtNotif;
	private Serializable lbgDteStaCour;
	private Serializable lbgTitre;
	private Serializable lbgCor;
	private Serializable lbgAdmCentral;
	private Serializable lbgMotifCor;
	private Serializable lbgDteCor;
	private Serializable lbgFonCodeCor;
	private Serializable lbgFonCodePf;
	private Serializable lbgFonCodeValAct;
	private Serializable lbgActif;
	private Serializable lbgFonCodeCf;
	private Serializable lbgDotAnPlus1;
	private Serializable lbgDotAnPlus2;
	private Serializable lbgDotAnPlus0;
	private Serializable lbgTypBud;
	private Serializable lbgDteMp;
	private Serializable lbgUtilSaisiAct;
	private Serializable lbgSigfip;
	private Serializable lbgFonCodePr;
	private Serializable lbgFonCodeVerou;
	private Serializable lbgCode;

	public VLBudgetsId() {
	}

	public VLBudgetsId(Serializable lbgStrCode, Serializable lbgGesCode, Serializable lbgResDon,
			Serializable lbgImputation, Serializable lbgAnoCode, Serializable lbgNatCode, Serializable lbgResTr,
			Serializable lbgDteSaisi, Serializable lbgAeTr, Serializable lbgAeDon, Serializable lbgAeEmp,
			Serializable lbgMp, Serializable lbgReglMp, Serializable lbgTotDot, Serializable lbgUtilSaisi,
			Serializable lbgDesCode, Serializable lbgDteModif, Serializable lbgResEmp, Serializable lbgResTot,
			Serializable lbgUtilModif, Serializable lbgFonCode, Serializable lbgDisTre, Serializable lbgDisDon,
			Serializable lbgDisEmp, Serializable lbgDisTot, Serializable lbgFonCodeAc, Serializable lbgStaCode,
			Serializable lbgActNumModif, Serializable lbgDteVal, Serializable lbgFonCodeVal, Serializable lbgTraitmt,
			Serializable lbgTraitmtNotif, Serializable lbgDteStaCour, Serializable lbgTitre, Serializable lbgCor,
			Serializable lbgAdmCentral, Serializable lbgMotifCor, Serializable lbgDteCor, Serializable lbgFonCodeCor,
			Serializable lbgFonCodePf, Serializable lbgFonCodeValAct, Serializable lbgActif, Serializable lbgFonCodeCf,
			Serializable lbgDotAnPlus1, Serializable lbgDotAnPlus2, Serializable lbgDotAnPlus0, Serializable lbgTypBud,
			Serializable lbgDteMp, Serializable lbgUtilSaisiAct, Serializable lbgSigfip, Serializable lbgFonCodePr,
			Serializable lbgFonCodeVerou, Serializable lbgCode) {
		this.lbgStrCode = lbgStrCode;
		this.lbgGesCode = lbgGesCode;
		this.lbgResDon = lbgResDon;
		this.lbgImputation = lbgImputation;
		this.lbgAnoCode = lbgAnoCode;
		this.lbgNatCode = lbgNatCode;
		this.lbgResTr = lbgResTr;
		this.lbgDteSaisi = lbgDteSaisi;
		this.lbgAeTr = lbgAeTr;
		this.lbgAeDon = lbgAeDon;
		this.lbgAeEmp = lbgAeEmp;
		this.lbgMp = lbgMp;
		this.lbgReglMp = lbgReglMp;
		this.lbgTotDot = lbgTotDot;
		this.lbgUtilSaisi = lbgUtilSaisi;
		this.lbgDesCode = lbgDesCode;
		this.lbgDteModif = lbgDteModif;
		this.lbgResEmp = lbgResEmp;
		this.lbgResTot = lbgResTot;
		this.lbgUtilModif = lbgUtilModif;
		this.lbgFonCode = lbgFonCode;
		this.lbgDisTre = lbgDisTre;
		this.lbgDisDon = lbgDisDon;
		this.lbgDisEmp = lbgDisEmp;
		this.lbgDisTot = lbgDisTot;
		this.lbgFonCodeAc = lbgFonCodeAc;
		this.lbgStaCode = lbgStaCode;
		this.lbgActNumModif = lbgActNumModif;
		this.lbgDteVal = lbgDteVal;
		this.lbgFonCodeVal = lbgFonCodeVal;
		this.lbgTraitmt = lbgTraitmt;
		this.lbgTraitmtNotif = lbgTraitmtNotif;
		this.lbgDteStaCour = lbgDteStaCour;
		this.lbgTitre = lbgTitre;
		this.lbgCor = lbgCor;
		this.lbgAdmCentral = lbgAdmCentral;
		this.lbgMotifCor = lbgMotifCor;
		this.lbgDteCor = lbgDteCor;
		this.lbgFonCodeCor = lbgFonCodeCor;
		this.lbgFonCodePf = lbgFonCodePf;
		this.lbgFonCodeValAct = lbgFonCodeValAct;
		this.lbgActif = lbgActif;
		this.lbgFonCodeCf = lbgFonCodeCf;
		this.lbgDotAnPlus1 = lbgDotAnPlus1;
		this.lbgDotAnPlus2 = lbgDotAnPlus2;
		this.lbgDotAnPlus0 = lbgDotAnPlus0;
		this.lbgTypBud = lbgTypBud;
		this.lbgDteMp = lbgDteMp;
		this.lbgUtilSaisiAct = lbgUtilSaisiAct;
		this.lbgSigfip = lbgSigfip;
		this.lbgFonCodePr = lbgFonCodePr;
		this.lbgFonCodeVerou = lbgFonCodeVerou;
		this.lbgCode = lbgCode;
	}

	@Column(name = "LBG_STR_CODE")
	public Serializable getLbgStrCode() {
		return this.lbgStrCode;
	}

	public void setLbgStrCode(Serializable lbgStrCode) {
		this.lbgStrCode = lbgStrCode;
	}

	@Column(name = "LBG_GES_CODE")
	public Serializable getLbgGesCode() {
		return this.lbgGesCode;
	}

	public void setLbgGesCode(Serializable lbgGesCode) {
		this.lbgGesCode = lbgGesCode;
	}

	@Column(name = "LBG_RES_DON")
	public Serializable getLbgResDon() {
		return this.lbgResDon;
	}

	public void setLbgResDon(Serializable lbgResDon) {
		this.lbgResDon = lbgResDon;
	}

	@Column(name = "LBG_IMPUTATION")
	public Serializable getLbgImputation() {
		return this.lbgImputation;
	}

	public void setLbgImputation(Serializable lbgImputation) {
		this.lbgImputation = lbgImputation;
	}

	@Column(name = "LBG_ANO_CODE")
	public Serializable getLbgAnoCode() {
		return this.lbgAnoCode;
	}

	public void setLbgAnoCode(Serializable lbgAnoCode) {
		this.lbgAnoCode = lbgAnoCode;
	}

	@Column(name = "LBG_NAT_CODE")
	public Serializable getLbgNatCode() {
		return this.lbgNatCode;
	}

	public void setLbgNatCode(Serializable lbgNatCode) {
		this.lbgNatCode = lbgNatCode;
	}

	@Column(name = "LBG_RES_TR")
	public Serializable getLbgResTr() {
		return this.lbgResTr;
	}

	public void setLbgResTr(Serializable lbgResTr) {
		this.lbgResTr = lbgResTr;
	}

	@Column(name = "LBG_DTE_SAISI")
	public Serializable getLbgDteSaisi() {
		return this.lbgDteSaisi;
	}

	public void setLbgDteSaisi(Serializable lbgDteSaisi) {
		this.lbgDteSaisi = lbgDteSaisi;
	}

	@Column(name = "LBG_AE_TR")
	public Serializable getLbgAeTr() {
		return this.lbgAeTr;
	}

	public void setLbgAeTr(Serializable lbgAeTr) {
		this.lbgAeTr = lbgAeTr;
	}

	@Column(name = "LBG_AE_DON")
	public Serializable getLbgAeDon() {
		return this.lbgAeDon;
	}

	public void setLbgAeDon(Serializable lbgAeDon) {
		this.lbgAeDon = lbgAeDon;
	}

	@Column(name = "LBG_AE_EMP")
	public Serializable getLbgAeEmp() {
		return this.lbgAeEmp;
	}

	public void setLbgAeEmp(Serializable lbgAeEmp) {
		this.lbgAeEmp = lbgAeEmp;
	}

	@Column(name = "LBG_MP")
	public Serializable getLbgMp() {
		return this.lbgMp;
	}

	public void setLbgMp(Serializable lbgMp) {
		this.lbgMp = lbgMp;
	}

	@Column(name = "LBG_REGL_MP")
	public Serializable getLbgReglMp() {
		return this.lbgReglMp;
	}

	public void setLbgReglMp(Serializable lbgReglMp) {
		this.lbgReglMp = lbgReglMp;
	}

	@Column(name = "LBG_TOT_DOT")
	public Serializable getLbgTotDot() {
		return this.lbgTotDot;
	}

	public void setLbgTotDot(Serializable lbgTotDot) {
		this.lbgTotDot = lbgTotDot;
	}

	@Column(name = "LBG_UTIL_SAISI")
	public Serializable getLbgUtilSaisi() {
		return this.lbgUtilSaisi;
	}

	public void setLbgUtilSaisi(Serializable lbgUtilSaisi) {
		this.lbgUtilSaisi = lbgUtilSaisi;
	}

	@Column(name = "LBG_DES_CODE")
	public Serializable getLbgDesCode() {
		return this.lbgDesCode;
	}

	public void setLbgDesCode(Serializable lbgDesCode) {
		this.lbgDesCode = lbgDesCode;
	}

	@Column(name = "LBG_DTE_MODIF")
	public Serializable getLbgDteModif() {
		return this.lbgDteModif;
	}

	public void setLbgDteModif(Serializable lbgDteModif) {
		this.lbgDteModif = lbgDteModif;
	}

	@Column(name = "LBG_RES_EMP")
	public Serializable getLbgResEmp() {
		return this.lbgResEmp;
	}

	public void setLbgResEmp(Serializable lbgResEmp) {
		this.lbgResEmp = lbgResEmp;
	}

	@Column(name = "LBG_RES_TOT")
	public Serializable getLbgResTot() {
		return this.lbgResTot;
	}

	public void setLbgResTot(Serializable lbgResTot) {
		this.lbgResTot = lbgResTot;
	}

	@Column(name = "LBG_UTIL_MODIF")
	public Serializable getLbgUtilModif() {
		return this.lbgUtilModif;
	}

	public void setLbgUtilModif(Serializable lbgUtilModif) {
		this.lbgUtilModif = lbgUtilModif;
	}

	@Column(name = "LBG_FON_CODE")
	public Serializable getLbgFonCode() {
		return this.lbgFonCode;
	}

	public void setLbgFonCode(Serializable lbgFonCode) {
		this.lbgFonCode = lbgFonCode;
	}

	@Column(name = "LBG_DIS_TRE")
	public Serializable getLbgDisTre() {
		return this.lbgDisTre;
	}

	public void setLbgDisTre(Serializable lbgDisTre) {
		this.lbgDisTre = lbgDisTre;
	}

	@Column(name = "LBG_DIS_DON")
	public Serializable getLbgDisDon() {
		return this.lbgDisDon;
	}

	public void setLbgDisDon(Serializable lbgDisDon) {
		this.lbgDisDon = lbgDisDon;
	}

	@Column(name = "LBG_DIS_EMP")
	public Serializable getLbgDisEmp() {
		return this.lbgDisEmp;
	}

	public void setLbgDisEmp(Serializable lbgDisEmp) {
		this.lbgDisEmp = lbgDisEmp;
	}

	@Column(name = "LBG_DIS_TOT")
	public Serializable getLbgDisTot() {
		return this.lbgDisTot;
	}

	public void setLbgDisTot(Serializable lbgDisTot) {
		this.lbgDisTot = lbgDisTot;
	}

	@Column(name = "LBG_FON_CODE_AC")
	public Serializable getLbgFonCodeAc() {
		return this.lbgFonCodeAc;
	}

	public void setLbgFonCodeAc(Serializable lbgFonCodeAc) {
		this.lbgFonCodeAc = lbgFonCodeAc;
	}

	@Column(name = "LBG_STA_CODE")
	public Serializable getLbgStaCode() {
		return this.lbgStaCode;
	}

	public void setLbgStaCode(Serializable lbgStaCode) {
		this.lbgStaCode = lbgStaCode;
	}

	@Column(name = "LBG_ACT_NUM_MODIF")
	public Serializable getLbgActNumModif() {
		return this.lbgActNumModif;
	}

	public void setLbgActNumModif(Serializable lbgActNumModif) {
		this.lbgActNumModif = lbgActNumModif;
	}

	@Column(name = "LBG_DTE_VAL")
	public Serializable getLbgDteVal() {
		return this.lbgDteVal;
	}

	public void setLbgDteVal(Serializable lbgDteVal) {
		this.lbgDteVal = lbgDteVal;
	}

	@Column(name = "LBG_FON_CODE_VAL")
	public Serializable getLbgFonCodeVal() {
		return this.lbgFonCodeVal;
	}

	public void setLbgFonCodeVal(Serializable lbgFonCodeVal) {
		this.lbgFonCodeVal = lbgFonCodeVal;
	}

	@Column(name = "LBG_TRAITMT")
	public Serializable getLbgTraitmt() {
		return this.lbgTraitmt;
	}

	public void setLbgTraitmt(Serializable lbgTraitmt) {
		this.lbgTraitmt = lbgTraitmt;
	}

	@Column(name = "LBG_TRAITMT_NOTIF")
	public Serializable getLbgTraitmtNotif() {
		return this.lbgTraitmtNotif;
	}

	public void setLbgTraitmtNotif(Serializable lbgTraitmtNotif) {
		this.lbgTraitmtNotif = lbgTraitmtNotif;
	}

	@Column(name = "LBG_DTE_STA_COUR")
	public Serializable getLbgDteStaCour() {
		return this.lbgDteStaCour;
	}

	public void setLbgDteStaCour(Serializable lbgDteStaCour) {
		this.lbgDteStaCour = lbgDteStaCour;
	}

	@Column(name = "LBG_TITRE")
	public Serializable getLbgTitre() {
		return this.lbgTitre;
	}

	public void setLbgTitre(Serializable lbgTitre) {
		this.lbgTitre = lbgTitre;
	}

	@Column(name = "LBG_COR")
	public Serializable getLbgCor() {
		return this.lbgCor;
	}

	public void setLbgCor(Serializable lbgCor) {
		this.lbgCor = lbgCor;
	}

	@Column(name = "LBG_ADM_CENTRAL")
	public Serializable getLbgAdmCentral() {
		return this.lbgAdmCentral;
	}

	public void setLbgAdmCentral(Serializable lbgAdmCentral) {
		this.lbgAdmCentral = lbgAdmCentral;
	}

	@Column(name = "LBG_MOTIF_COR")
	public Serializable getLbgMotifCor() {
		return this.lbgMotifCor;
	}

	public void setLbgMotifCor(Serializable lbgMotifCor) {
		this.lbgMotifCor = lbgMotifCor;
	}

	@Column(name = "LBG_DTE_COR")
	public Serializable getLbgDteCor() {
		return this.lbgDteCor;
	}

	public void setLbgDteCor(Serializable lbgDteCor) {
		this.lbgDteCor = lbgDteCor;
	}

	@Column(name = "LBG_FON_CODE_COR")
	public Serializable getLbgFonCodeCor() {
		return this.lbgFonCodeCor;
	}

	public void setLbgFonCodeCor(Serializable lbgFonCodeCor) {
		this.lbgFonCodeCor = lbgFonCodeCor;
	}

	@Column(name = "LBG_FON_CODE_PF")
	public Serializable getLbgFonCodePf() {
		return this.lbgFonCodePf;
	}

	public void setLbgFonCodePf(Serializable lbgFonCodePf) {
		this.lbgFonCodePf = lbgFonCodePf;
	}

	@Column(name = "LBG_FON_CODE_VAL_ACT")
	public Serializable getLbgFonCodeValAct() {
		return this.lbgFonCodeValAct;
	}

	public void setLbgFonCodeValAct(Serializable lbgFonCodeValAct) {
		this.lbgFonCodeValAct = lbgFonCodeValAct;
	}

	@Column(name = "LBG_ACTIF")
	public Serializable getLbgActif() {
		return this.lbgActif;
	}

	public void setLbgActif(Serializable lbgActif) {
		this.lbgActif = lbgActif;
	}

	@Column(name = "LBG_FON_CODE_CF")
	public Serializable getLbgFonCodeCf() {
		return this.lbgFonCodeCf;
	}

	public void setLbgFonCodeCf(Serializable lbgFonCodeCf) {
		this.lbgFonCodeCf = lbgFonCodeCf;
	}

	@Column(name = "LBG_DOT_AN_PLUS1")
	public Serializable getLbgDotAnPlus1() {
		return this.lbgDotAnPlus1;
	}

	public void setLbgDotAnPlus1(Serializable lbgDotAnPlus1) {
		this.lbgDotAnPlus1 = lbgDotAnPlus1;
	}

	@Column(name = "LBG_DOT_AN_PLUS2")
	public Serializable getLbgDotAnPlus2() {
		return this.lbgDotAnPlus2;
	}

	public void setLbgDotAnPlus2(Serializable lbgDotAnPlus2) {
		this.lbgDotAnPlus2 = lbgDotAnPlus2;
	}

	@Column(name = "LBG_DOT_AN_PLUS0")
	public Serializable getLbgDotAnPlus0() {
		return this.lbgDotAnPlus0;
	}

	public void setLbgDotAnPlus0(Serializable lbgDotAnPlus0) {
		this.lbgDotAnPlus0 = lbgDotAnPlus0;
	}

	@Column(name = "LBG_TYP_BUD")
	public Serializable getLbgTypBud() {
		return this.lbgTypBud;
	}

	public void setLbgTypBud(Serializable lbgTypBud) {
		this.lbgTypBud = lbgTypBud;
	}

	@Column(name = "LBG_DTE_MP")
	public Serializable getLbgDteMp() {
		return this.lbgDteMp;
	}

	public void setLbgDteMp(Serializable lbgDteMp) {
		this.lbgDteMp = lbgDteMp;
	}

	@Column(name = "LBG_UTIL_SAISI_ACT")
	public Serializable getLbgUtilSaisiAct() {
		return this.lbgUtilSaisiAct;
	}

	public void setLbgUtilSaisiAct(Serializable lbgUtilSaisiAct) {
		this.lbgUtilSaisiAct = lbgUtilSaisiAct;
	}

	@Column(name = "LBG_SIGFIP")
	public Serializable getLbgSigfip() {
		return this.lbgSigfip;
	}

	public void setLbgSigfip(Serializable lbgSigfip) {
		this.lbgSigfip = lbgSigfip;
	}

	@Column(name = "LBG_FON_CODE_PR")
	public Serializable getLbgFonCodePr() {
		return this.lbgFonCodePr;
	}

	public void setLbgFonCodePr(Serializable lbgFonCodePr) {
		this.lbgFonCodePr = lbgFonCodePr;
	}

	@Column(name = "LBG_FON_CODE_VEROU")
	public Serializable getLbgFonCodeVerou() {
		return this.lbgFonCodeVerou;
	}

	public void setLbgFonCodeVerou(Serializable lbgFonCodeVerou) {
		this.lbgFonCodeVerou = lbgFonCodeVerou;
	}

	@Column(name = "LBG_CODE")
	public Serializable getLbgCode() {
		return this.lbgCode;
	}

	public void setLbgCode(Serializable lbgCode) {
		this.lbgCode = lbgCode;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VLBudgetsId))
			return false;
		VLBudgetsId castOther = (VLBudgetsId) other;

		return ((this.getLbgStrCode() == castOther.getLbgStrCode()) || (this.getLbgStrCode() != null
				&& castOther.getLbgStrCode() != null && this.getLbgStrCode().equals(castOther.getLbgStrCode())))
				&& ((this.getLbgGesCode() == castOther.getLbgGesCode()) || (this.getLbgGesCode() != null
						&& castOther.getLbgGesCode() != null && this.getLbgGesCode().equals(castOther.getLbgGesCode())))
				&& ((this.getLbgResDon() == castOther.getLbgResDon()) || (this.getLbgResDon() != null
						&& castOther.getLbgResDon() != null && this.getLbgResDon().equals(castOther.getLbgResDon())))
				&& ((this.getLbgImputation() == castOther.getLbgImputation())
						|| (this.getLbgImputation() != null && castOther.getLbgImputation() != null
								&& this.getLbgImputation().equals(castOther.getLbgImputation())))
				&& ((this.getLbgAnoCode() == castOther.getLbgAnoCode()) || (this.getLbgAnoCode() != null
						&& castOther.getLbgAnoCode() != null && this.getLbgAnoCode().equals(castOther.getLbgAnoCode())))
				&& ((this.getLbgNatCode() == castOther.getLbgNatCode()) || (this.getLbgNatCode() != null
						&& castOther.getLbgNatCode() != null && this.getLbgNatCode().equals(castOther.getLbgNatCode())))
				&& ((this.getLbgResTr() == castOther.getLbgResTr()) || (this.getLbgResTr() != null
						&& castOther.getLbgResTr() != null && this.getLbgResTr().equals(castOther.getLbgResTr())))
				&& ((this.getLbgDteSaisi() == castOther.getLbgDteSaisi())
						|| (this.getLbgDteSaisi() != null && castOther.getLbgDteSaisi() != null
								&& this.getLbgDteSaisi().equals(castOther.getLbgDteSaisi())))
				&& ((this.getLbgAeTr() == castOther.getLbgAeTr()) || (this.getLbgAeTr() != null
						&& castOther.getLbgAeTr() != null && this.getLbgAeTr().equals(castOther.getLbgAeTr())))
				&& ((this.getLbgAeDon() == castOther.getLbgAeDon()) || (this.getLbgAeDon() != null
						&& castOther.getLbgAeDon() != null && this.getLbgAeDon().equals(castOther.getLbgAeDon())))
				&& ((this.getLbgAeEmp() == castOther.getLbgAeEmp()) || (this.getLbgAeEmp() != null
						&& castOther.getLbgAeEmp() != null && this.getLbgAeEmp().equals(castOther.getLbgAeEmp())))
				&& ((this.getLbgMp() == castOther.getLbgMp()) || (this.getLbgMp() != null
						&& castOther.getLbgMp() != null && this.getLbgMp().equals(castOther.getLbgMp())))
				&& ((this.getLbgReglMp() == castOther.getLbgReglMp()) || (this.getLbgReglMp() != null
						&& castOther.getLbgReglMp() != null && this.getLbgReglMp().equals(castOther.getLbgReglMp())))
				&& ((this.getLbgTotDot() == castOther.getLbgTotDot()) || (this.getLbgTotDot() != null
						&& castOther.getLbgTotDot() != null && this.getLbgTotDot().equals(castOther.getLbgTotDot())))
				&& ((this.getLbgUtilSaisi() == castOther.getLbgUtilSaisi())
						|| (this.getLbgUtilSaisi() != null && castOther.getLbgUtilSaisi() != null
								&& this.getLbgUtilSaisi().equals(castOther.getLbgUtilSaisi())))
				&& ((this.getLbgDesCode() == castOther.getLbgDesCode()) || (this.getLbgDesCode() != null
						&& castOther.getLbgDesCode() != null && this.getLbgDesCode().equals(castOther.getLbgDesCode())))
				&& ((this.getLbgDteModif() == castOther.getLbgDteModif())
						|| (this.getLbgDteModif() != null && castOther.getLbgDteModif() != null
								&& this.getLbgDteModif().equals(castOther.getLbgDteModif())))
				&& ((this.getLbgResEmp() == castOther.getLbgResEmp()) || (this.getLbgResEmp() != null
						&& castOther.getLbgResEmp() != null && this.getLbgResEmp().equals(castOther.getLbgResEmp())))
				&& ((this.getLbgResTot() == castOther.getLbgResTot()) || (this.getLbgResTot() != null
						&& castOther.getLbgResTot() != null && this.getLbgResTot().equals(castOther.getLbgResTot())))
				&& ((this.getLbgUtilModif() == castOther.getLbgUtilModif())
						|| (this.getLbgUtilModif() != null && castOther.getLbgUtilModif() != null
								&& this.getLbgUtilModif().equals(castOther.getLbgUtilModif())))
				&& ((this.getLbgFonCode() == castOther.getLbgFonCode()) || (this.getLbgFonCode() != null
						&& castOther.getLbgFonCode() != null && this.getLbgFonCode().equals(castOther.getLbgFonCode())))
				&& ((this.getLbgDisTre() == castOther.getLbgDisTre()) || (this.getLbgDisTre() != null
						&& castOther.getLbgDisTre() != null && this.getLbgDisTre().equals(castOther.getLbgDisTre())))
				&& ((this.getLbgDisDon() == castOther.getLbgDisDon()) || (this.getLbgDisDon() != null
						&& castOther.getLbgDisDon() != null && this.getLbgDisDon().equals(castOther.getLbgDisDon())))
				&& ((this.getLbgDisEmp() == castOther.getLbgDisEmp()) || (this.getLbgDisEmp() != null
						&& castOther.getLbgDisEmp() != null && this.getLbgDisEmp().equals(castOther.getLbgDisEmp())))
				&& ((this.getLbgDisTot() == castOther.getLbgDisTot()) || (this.getLbgDisTot() != null
						&& castOther.getLbgDisTot() != null && this.getLbgDisTot().equals(castOther.getLbgDisTot())))
				&& ((this.getLbgFonCodeAc() == castOther.getLbgFonCodeAc())
						|| (this.getLbgFonCodeAc() != null && castOther.getLbgFonCodeAc() != null
								&& this.getLbgFonCodeAc().equals(castOther.getLbgFonCodeAc())))
				&& ((this.getLbgStaCode() == castOther.getLbgStaCode()) || (this.getLbgStaCode() != null
						&& castOther.getLbgStaCode() != null && this.getLbgStaCode().equals(castOther.getLbgStaCode())))
				&& ((this.getLbgActNumModif() == castOther.getLbgActNumModif())
						|| (this.getLbgActNumModif() != null && castOther.getLbgActNumModif() != null
								&& this.getLbgActNumModif().equals(castOther.getLbgActNumModif())))
				&& ((this.getLbgDteVal() == castOther.getLbgDteVal()) || (this.getLbgDteVal() != null
						&& castOther.getLbgDteVal() != null && this.getLbgDteVal().equals(castOther.getLbgDteVal())))
				&& ((this.getLbgFonCodeVal() == castOther.getLbgFonCodeVal())
						|| (this.getLbgFonCodeVal() != null && castOther.getLbgFonCodeVal() != null
								&& this.getLbgFonCodeVal().equals(castOther.getLbgFonCodeVal())))
				&& ((this.getLbgTraitmt() == castOther.getLbgTraitmt()) || (this.getLbgTraitmt() != null
						&& castOther.getLbgTraitmt() != null && this.getLbgTraitmt().equals(castOther.getLbgTraitmt())))
				&& ((this.getLbgTraitmtNotif() == castOther.getLbgTraitmtNotif())
						|| (this.getLbgTraitmtNotif() != null && castOther.getLbgTraitmtNotif() != null
								&& this.getLbgTraitmtNotif().equals(castOther.getLbgTraitmtNotif())))
				&& ((this.getLbgDteStaCour() == castOther.getLbgDteStaCour())
						|| (this.getLbgDteStaCour() != null && castOther.getLbgDteStaCour() != null
								&& this.getLbgDteStaCour().equals(castOther.getLbgDteStaCour())))
				&& ((this.getLbgTitre() == castOther.getLbgTitre()) || (this.getLbgTitre() != null
						&& castOther.getLbgTitre() != null && this.getLbgTitre().equals(castOther.getLbgTitre())))
				&& ((this.getLbgCor() == castOther.getLbgCor()) || (this.getLbgCor() != null
						&& castOther.getLbgCor() != null && this.getLbgCor().equals(castOther.getLbgCor())))
				&& ((this.getLbgAdmCentral() == castOther.getLbgAdmCentral())
						|| (this.getLbgAdmCentral() != null && castOther.getLbgAdmCentral() != null
								&& this.getLbgAdmCentral().equals(castOther.getLbgAdmCentral())))
				&& ((this.getLbgMotifCor() == castOther.getLbgMotifCor())
						|| (this.getLbgMotifCor() != null && castOther.getLbgMotifCor() != null
								&& this.getLbgMotifCor().equals(castOther.getLbgMotifCor())))
				&& ((this.getLbgDteCor() == castOther.getLbgDteCor()) || (this.getLbgDteCor() != null
						&& castOther.getLbgDteCor() != null && this.getLbgDteCor().equals(castOther.getLbgDteCor())))
				&& ((this.getLbgFonCodeCor() == castOther.getLbgFonCodeCor())
						|| (this.getLbgFonCodeCor() != null && castOther.getLbgFonCodeCor() != null
								&& this.getLbgFonCodeCor().equals(castOther.getLbgFonCodeCor())))
				&& ((this.getLbgFonCodePf() == castOther.getLbgFonCodePf())
						|| (this.getLbgFonCodePf() != null && castOther.getLbgFonCodePf() != null
								&& this.getLbgFonCodePf().equals(castOther.getLbgFonCodePf())))
				&& ((this.getLbgFonCodeValAct() == castOther.getLbgFonCodeValAct())
						|| (this.getLbgFonCodeValAct() != null && castOther.getLbgFonCodeValAct() != null
								&& this.getLbgFonCodeValAct().equals(castOther.getLbgFonCodeValAct())))
				&& ((this.getLbgActif() == castOther.getLbgActif()) || (this.getLbgActif() != null
						&& castOther.getLbgActif() != null && this.getLbgActif().equals(castOther.getLbgActif())))
				&& ((this.getLbgFonCodeCf() == castOther.getLbgFonCodeCf())
						|| (this.getLbgFonCodeCf() != null && castOther.getLbgFonCodeCf() != null
								&& this.getLbgFonCodeCf().equals(castOther.getLbgFonCodeCf())))
				&& ((this.getLbgDotAnPlus1() == castOther.getLbgDotAnPlus1())
						|| (this.getLbgDotAnPlus1() != null && castOther.getLbgDotAnPlus1() != null
								&& this.getLbgDotAnPlus1().equals(castOther.getLbgDotAnPlus1())))
				&& ((this.getLbgDotAnPlus2() == castOther.getLbgDotAnPlus2())
						|| (this.getLbgDotAnPlus2() != null && castOther.getLbgDotAnPlus2() != null
								&& this.getLbgDotAnPlus2().equals(castOther.getLbgDotAnPlus2())))
				&& ((this.getLbgDotAnPlus0() == castOther.getLbgDotAnPlus0())
						|| (this.getLbgDotAnPlus0() != null && castOther.getLbgDotAnPlus0() != null
								&& this.getLbgDotAnPlus0().equals(castOther.getLbgDotAnPlus0())))
				&& ((this.getLbgTypBud() == castOther.getLbgTypBud()) || (this.getLbgTypBud() != null
						&& castOther.getLbgTypBud() != null && this.getLbgTypBud().equals(castOther.getLbgTypBud())))
				&& ((this.getLbgDteMp() == castOther.getLbgDteMp()) || (this.getLbgDteMp() != null
						&& castOther.getLbgDteMp() != null && this.getLbgDteMp().equals(castOther.getLbgDteMp())))
				&& ((this.getLbgUtilSaisiAct() == castOther.getLbgUtilSaisiAct())
						|| (this.getLbgUtilSaisiAct() != null && castOther.getLbgUtilSaisiAct() != null
								&& this.getLbgUtilSaisiAct().equals(castOther.getLbgUtilSaisiAct())))
				&& ((this.getLbgSigfip() == castOther.getLbgSigfip()) || (this.getLbgSigfip() != null
						&& castOther.getLbgSigfip() != null && this.getLbgSigfip().equals(castOther.getLbgSigfip())))
				&& ((this.getLbgFonCodePr() == castOther.getLbgFonCodePr())
						|| (this.getLbgFonCodePr() != null && castOther.getLbgFonCodePr() != null
								&& this.getLbgFonCodePr().equals(castOther.getLbgFonCodePr())))
				&& ((this.getLbgFonCodeVerou() == castOther.getLbgFonCodeVerou())
						|| (this.getLbgFonCodeVerou() != null && castOther.getLbgFonCodeVerou() != null
								&& this.getLbgFonCodeVerou().equals(castOther.getLbgFonCodeVerou())))
				&& ((this.getLbgCode() == castOther.getLbgCode()) || (this.getLbgCode() != null
						&& castOther.getLbgCode() != null && this.getLbgCode().equals(castOther.getLbgCode())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getLbgStrCode() == null ? 0 : this.getLbgStrCode().hashCode());
		result = 37 * result + (getLbgGesCode() == null ? 0 : this.getLbgGesCode().hashCode());
		result = 37 * result + (getLbgResDon() == null ? 0 : this.getLbgResDon().hashCode());
		result = 37 * result + (getLbgImputation() == null ? 0 : this.getLbgImputation().hashCode());
		result = 37 * result + (getLbgAnoCode() == null ? 0 : this.getLbgAnoCode().hashCode());
		result = 37 * result + (getLbgNatCode() == null ? 0 : this.getLbgNatCode().hashCode());
		result = 37 * result + (getLbgResTr() == null ? 0 : this.getLbgResTr().hashCode());
		result = 37 * result + (getLbgDteSaisi() == null ? 0 : this.getLbgDteSaisi().hashCode());
		result = 37 * result + (getLbgAeTr() == null ? 0 : this.getLbgAeTr().hashCode());
		result = 37 * result + (getLbgAeDon() == null ? 0 : this.getLbgAeDon().hashCode());
		result = 37 * result + (getLbgAeEmp() == null ? 0 : this.getLbgAeEmp().hashCode());
		result = 37 * result + (getLbgMp() == null ? 0 : this.getLbgMp().hashCode());
		result = 37 * result + (getLbgReglMp() == null ? 0 : this.getLbgReglMp().hashCode());
		result = 37 * result + (getLbgTotDot() == null ? 0 : this.getLbgTotDot().hashCode());
		result = 37 * result + (getLbgUtilSaisi() == null ? 0 : this.getLbgUtilSaisi().hashCode());
		result = 37 * result + (getLbgDesCode() == null ? 0 : this.getLbgDesCode().hashCode());
		result = 37 * result + (getLbgDteModif() == null ? 0 : this.getLbgDteModif().hashCode());
		result = 37 * result + (getLbgResEmp() == null ? 0 : this.getLbgResEmp().hashCode());
		result = 37 * result + (getLbgResTot() == null ? 0 : this.getLbgResTot().hashCode());
		result = 37 * result + (getLbgUtilModif() == null ? 0 : this.getLbgUtilModif().hashCode());
		result = 37 * result + (getLbgFonCode() == null ? 0 : this.getLbgFonCode().hashCode());
		result = 37 * result + (getLbgDisTre() == null ? 0 : this.getLbgDisTre().hashCode());
		result = 37 * result + (getLbgDisDon() == null ? 0 : this.getLbgDisDon().hashCode());
		result = 37 * result + (getLbgDisEmp() == null ? 0 : this.getLbgDisEmp().hashCode());
		result = 37 * result + (getLbgDisTot() == null ? 0 : this.getLbgDisTot().hashCode());
		result = 37 * result + (getLbgFonCodeAc() == null ? 0 : this.getLbgFonCodeAc().hashCode());
		result = 37 * result + (getLbgStaCode() == null ? 0 : this.getLbgStaCode().hashCode());
		result = 37 * result + (getLbgActNumModif() == null ? 0 : this.getLbgActNumModif().hashCode());
		result = 37 * result + (getLbgDteVal() == null ? 0 : this.getLbgDteVal().hashCode());
		result = 37 * result + (getLbgFonCodeVal() == null ? 0 : this.getLbgFonCodeVal().hashCode());
		result = 37 * result + (getLbgTraitmt() == null ? 0 : this.getLbgTraitmt().hashCode());
		result = 37 * result + (getLbgTraitmtNotif() == null ? 0 : this.getLbgTraitmtNotif().hashCode());
		result = 37 * result + (getLbgDteStaCour() == null ? 0 : this.getLbgDteStaCour().hashCode());
		result = 37 * result + (getLbgTitre() == null ? 0 : this.getLbgTitre().hashCode());
		result = 37 * result + (getLbgCor() == null ? 0 : this.getLbgCor().hashCode());
		result = 37 * result + (getLbgAdmCentral() == null ? 0 : this.getLbgAdmCentral().hashCode());
		result = 37 * result + (getLbgMotifCor() == null ? 0 : this.getLbgMotifCor().hashCode());
		result = 37 * result + (getLbgDteCor() == null ? 0 : this.getLbgDteCor().hashCode());
		result = 37 * result + (getLbgFonCodeCor() == null ? 0 : this.getLbgFonCodeCor().hashCode());
		result = 37 * result + (getLbgFonCodePf() == null ? 0 : this.getLbgFonCodePf().hashCode());
		result = 37 * result + (getLbgFonCodeValAct() == null ? 0 : this.getLbgFonCodeValAct().hashCode());
		result = 37 * result + (getLbgActif() == null ? 0 : this.getLbgActif().hashCode());
		result = 37 * result + (getLbgFonCodeCf() == null ? 0 : this.getLbgFonCodeCf().hashCode());
		result = 37 * result + (getLbgDotAnPlus1() == null ? 0 : this.getLbgDotAnPlus1().hashCode());
		result = 37 * result + (getLbgDotAnPlus2() == null ? 0 : this.getLbgDotAnPlus2().hashCode());
		result = 37 * result + (getLbgDotAnPlus0() == null ? 0 : this.getLbgDotAnPlus0().hashCode());
		result = 37 * result + (getLbgTypBud() == null ? 0 : this.getLbgTypBud().hashCode());
		result = 37 * result + (getLbgDteMp() == null ? 0 : this.getLbgDteMp().hashCode());
		result = 37 * result + (getLbgUtilSaisiAct() == null ? 0 : this.getLbgUtilSaisiAct().hashCode());
		result = 37 * result + (getLbgSigfip() == null ? 0 : this.getLbgSigfip().hashCode());
		result = 37 * result + (getLbgFonCodePr() == null ? 0 : this.getLbgFonCodePr().hashCode());
		result = 37 * result + (getLbgFonCodeVerou() == null ? 0 : this.getLbgFonCodeVerou().hashCode());
		result = 37 * result + (getLbgCode() == null ? 0 : this.getLbgCode().hashCode());
		return result;
	}

}
