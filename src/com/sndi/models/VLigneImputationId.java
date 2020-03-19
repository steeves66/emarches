package com.sndi.models;
// Generated 19 mars 2020 16:14:06 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VLigneImputationId generated by hbm2java
 */
@Embeddable
public class VLigneImputationId implements java.io.Serializable {

	private String lbgCode;
	private String lbgStrCode;
	private short lbgGesCode;
	private BigDecimal lbgResDon;
	private String lbgImputation;
	private Long lbgAnoCode;
	private String lbgNatCode;
	private BigDecimal lbgResTr;
	private Date lbgDteSaisi;
	private BigDecimal lbgAeTr;
	private BigDecimal lbgAeDon;
	private BigDecimal lbgAeEmp;
	private String lbgMp;
	private String lbgReglMp;
	private BigDecimal lbgTotDot;
	private String lbgUtilSaisi;
	private String lbgDesCode;
	private Date lbgDteModif;
	private BigDecimal lbgResEmp;
	private BigDecimal lbgResTot;
	private String lbgUtilModif;
	private String lbgFonCode;
	private BigDecimal lbgDisTre;
	private BigDecimal lbgDisDon;
	private BigDecimal lbgDisEmp;
	private BigDecimal lbgDisTot;
	private String lbgFonCodeAc;
	private String lbgStaCode;
	private String lbgActNumModif;
	private Date lbgDteVal;
	private String lbgFonCodeVal;
	private String lbgTraitmt;
	private String lbgTraitmtNotif;
	private Date lbgDteStaCour;
	private String lbgTitre;
	private String lbgCor;
	private String lbgAdmCentral;
	private String lbgMotifCor;
	private Date lbgDteCor;
	private String lbgFonCodeCor;
	private String lbgFonCodePf;
	private String lbgFonCodeValAct;
	private String lbgActif;
	private String lbgFonCodeCf;
	private BigDecimal lbgDotAnPlus1;
	private BigDecimal lbgDotAnPlus2;
	private BigDecimal lbgDotAnPlus0;
	private String lbgTypBud;
	private Date lbgDteMp;
	private String lbgUtilSaisiAct;
	private String lbgSigfip;
	private String lbgFonCodePr;
	private String lbgFonCodeVerou;
	private String natLibelle;

	public VLigneImputationId() {
	}

	public VLigneImputationId(String lbgCode, String lbgStrCode, short lbgGesCode, BigDecimal lbgResDon,
			String lbgImputation, String lbgNatCode, BigDecimal lbgResTr, BigDecimal lbgAeTr, BigDecimal lbgAeDon,
			BigDecimal lbgAeEmp, BigDecimal lbgTotDot, String lbgAdmCentral) {
		this.lbgCode = lbgCode;
		this.lbgStrCode = lbgStrCode;
		this.lbgGesCode = lbgGesCode;
		this.lbgResDon = lbgResDon;
		this.lbgImputation = lbgImputation;
		this.lbgNatCode = lbgNatCode;
		this.lbgResTr = lbgResTr;
		this.lbgAeTr = lbgAeTr;
		this.lbgAeDon = lbgAeDon;
		this.lbgAeEmp = lbgAeEmp;
		this.lbgTotDot = lbgTotDot;
		this.lbgAdmCentral = lbgAdmCentral;
	}

	public VLigneImputationId(String lbgCode, String lbgStrCode, short lbgGesCode, BigDecimal lbgResDon,
			String lbgImputation, Long lbgAnoCode, String lbgNatCode, BigDecimal lbgResTr, Date lbgDteSaisi,
			BigDecimal lbgAeTr, BigDecimal lbgAeDon, BigDecimal lbgAeEmp, String lbgMp, String lbgReglMp,
			BigDecimal lbgTotDot, String lbgUtilSaisi, String lbgDesCode, Date lbgDteModif, BigDecimal lbgResEmp,
			BigDecimal lbgResTot, String lbgUtilModif, String lbgFonCode, BigDecimal lbgDisTre, BigDecimal lbgDisDon,
			BigDecimal lbgDisEmp, BigDecimal lbgDisTot, String lbgFonCodeAc, String lbgStaCode, String lbgActNumModif,
			Date lbgDteVal, String lbgFonCodeVal, String lbgTraitmt, String lbgTraitmtNotif, Date lbgDteStaCour,
			String lbgTitre, String lbgCor, String lbgAdmCentral, String lbgMotifCor, Date lbgDteCor,
			String lbgFonCodeCor, String lbgFonCodePf, String lbgFonCodeValAct, String lbgActif, String lbgFonCodeCf,
			BigDecimal lbgDotAnPlus1, BigDecimal lbgDotAnPlus2, BigDecimal lbgDotAnPlus0, String lbgTypBud,
			Date lbgDteMp, String lbgUtilSaisiAct, String lbgSigfip, String lbgFonCodePr, String lbgFonCodeVerou,
			String natLibelle) {
		this.lbgCode = lbgCode;
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
		this.natLibelle = natLibelle;
	}

	@Column(name = "LBG_CODE", nullable = false, length = 50)
	public String getLbgCode() {
		return this.lbgCode;
	}

	public void setLbgCode(String lbgCode) {
		this.lbgCode = lbgCode;
	}

	@Column(name = "LBG_STR_CODE", nullable = false, length = 30)
	public String getLbgStrCode() {
		return this.lbgStrCode;
	}

	public void setLbgStrCode(String lbgStrCode) {
		this.lbgStrCode = lbgStrCode;
	}

	@Column(name = "LBG_GES_CODE", nullable = false, precision = 4, scale = 0)
	public short getLbgGesCode() {
		return this.lbgGesCode;
	}

	public void setLbgGesCode(short lbgGesCode) {
		this.lbgGesCode = lbgGesCode;
	}

	@Column(name = "LBG_RES_DON", nullable = false, precision = 20, scale = 0)
	public BigDecimal getLbgResDon() {
		return this.lbgResDon;
	}

	public void setLbgResDon(BigDecimal lbgResDon) {
		this.lbgResDon = lbgResDon;
	}

	@Column(name = "LBG_IMPUTATION", nullable = false, length = 50)
	public String getLbgImputation() {
		return this.lbgImputation;
	}

	public void setLbgImputation(String lbgImputation) {
		this.lbgImputation = lbgImputation;
	}

	@Column(name = "LBG_ANO_CODE", precision = 10, scale = 0)
	public Long getLbgAnoCode() {
		return this.lbgAnoCode;
	}

	public void setLbgAnoCode(Long lbgAnoCode) {
		this.lbgAnoCode = lbgAnoCode;
	}

	@Column(name = "LBG_NAT_CODE", nullable = false, length = 20)
	public String getLbgNatCode() {
		return this.lbgNatCode;
	}

	public void setLbgNatCode(String lbgNatCode) {
		this.lbgNatCode = lbgNatCode;
	}

	@Column(name = "LBG_RES_TR", nullable = false, precision = 20, scale = 0)
	public BigDecimal getLbgResTr() {
		return this.lbgResTr;
	}

	public void setLbgResTr(BigDecimal lbgResTr) {
		this.lbgResTr = lbgResTr;
	}

	@Column(name = "LBG_DTE_SAISI", length = 7)
	public Date getLbgDteSaisi() {
		return this.lbgDteSaisi;
	}

	public void setLbgDteSaisi(Date lbgDteSaisi) {
		this.lbgDteSaisi = lbgDteSaisi;
	}

	@Column(name = "LBG_AE_TR", nullable = false, precision = 20, scale = 0)
	public BigDecimal getLbgAeTr() {
		return this.lbgAeTr;
	}

	public void setLbgAeTr(BigDecimal lbgAeTr) {
		this.lbgAeTr = lbgAeTr;
	}

	@Column(name = "LBG_AE_DON", nullable = false, precision = 20, scale = 0)
	public BigDecimal getLbgAeDon() {
		return this.lbgAeDon;
	}

	public void setLbgAeDon(BigDecimal lbgAeDon) {
		this.lbgAeDon = lbgAeDon;
	}

	@Column(name = "LBG_AE_EMP", nullable = false, precision = 20, scale = 0)
	public BigDecimal getLbgAeEmp() {
		return this.lbgAeEmp;
	}

	public void setLbgAeEmp(BigDecimal lbgAeEmp) {
		this.lbgAeEmp = lbgAeEmp;
	}

	@Column(name = "LBG_MP", length = 1)
	public String getLbgMp() {
		return this.lbgMp;
	}

	public void setLbgMp(String lbgMp) {
		this.lbgMp = lbgMp;
	}

	@Column(name = "LBG_REGL_MP", length = 1)
	public String getLbgReglMp() {
		return this.lbgReglMp;
	}

	public void setLbgReglMp(String lbgReglMp) {
		this.lbgReglMp = lbgReglMp;
	}

	@Column(name = "LBG_TOT_DOT", nullable = false, precision = 20, scale = 0)
	public BigDecimal getLbgTotDot() {
		return this.lbgTotDot;
	}

	public void setLbgTotDot(BigDecimal lbgTotDot) {
		this.lbgTotDot = lbgTotDot;
	}

	@Column(name = "LBG_UTIL_SAISI", length = 10)
	public String getLbgUtilSaisi() {
		return this.lbgUtilSaisi;
	}

	public void setLbgUtilSaisi(String lbgUtilSaisi) {
		this.lbgUtilSaisi = lbgUtilSaisi;
	}

	@Column(name = "LBG_DES_CODE", length = 30)
	public String getLbgDesCode() {
		return this.lbgDesCode;
	}

	public void setLbgDesCode(String lbgDesCode) {
		this.lbgDesCode = lbgDesCode;
	}

	@Column(name = "LBG_DTE_MODIF", length = 7)
	public Date getLbgDteModif() {
		return this.lbgDteModif;
	}

	public void setLbgDteModif(Date lbgDteModif) {
		this.lbgDteModif = lbgDteModif;
	}

	@Column(name = "LBG_RES_EMP", precision = 20, scale = 0)
	public BigDecimal getLbgResEmp() {
		return this.lbgResEmp;
	}

	public void setLbgResEmp(BigDecimal lbgResEmp) {
		this.lbgResEmp = lbgResEmp;
	}

	@Column(name = "LBG_RES_TOT", precision = 20, scale = 0)
	public BigDecimal getLbgResTot() {
		return this.lbgResTot;
	}

	public void setLbgResTot(BigDecimal lbgResTot) {
		this.lbgResTot = lbgResTot;
	}

	@Column(name = "LBG_UTIL_MODIF", length = 20)
	public String getLbgUtilModif() {
		return this.lbgUtilModif;
	}

	public void setLbgUtilModif(String lbgUtilModif) {
		this.lbgUtilModif = lbgUtilModif;
	}

	@Column(name = "LBG_FON_CODE", length = 20)
	public String getLbgFonCode() {
		return this.lbgFonCode;
	}

	public void setLbgFonCode(String lbgFonCode) {
		this.lbgFonCode = lbgFonCode;
	}

	@Column(name = "LBG_DIS_TRE", precision = 20, scale = 0)
	public BigDecimal getLbgDisTre() {
		return this.lbgDisTre;
	}

	public void setLbgDisTre(BigDecimal lbgDisTre) {
		this.lbgDisTre = lbgDisTre;
	}

	@Column(name = "LBG_DIS_DON", precision = 20, scale = 0)
	public BigDecimal getLbgDisDon() {
		return this.lbgDisDon;
	}

	public void setLbgDisDon(BigDecimal lbgDisDon) {
		this.lbgDisDon = lbgDisDon;
	}

	@Column(name = "LBG_DIS_EMP", precision = 20, scale = 0)
	public BigDecimal getLbgDisEmp() {
		return this.lbgDisEmp;
	}

	public void setLbgDisEmp(BigDecimal lbgDisEmp) {
		this.lbgDisEmp = lbgDisEmp;
	}

	@Column(name = "LBG_DIS_TOT", precision = 20, scale = 0)
	public BigDecimal getLbgDisTot() {
		return this.lbgDisTot;
	}

	public void setLbgDisTot(BigDecimal lbgDisTot) {
		this.lbgDisTot = lbgDisTot;
	}

	@Column(name = "LBG_FON_CODE_AC", length = 30)
	public String getLbgFonCodeAc() {
		return this.lbgFonCodeAc;
	}

	public void setLbgFonCodeAc(String lbgFonCodeAc) {
		this.lbgFonCodeAc = lbgFonCodeAc;
	}

	@Column(name = "LBG_STA_CODE", length = 10)
	public String getLbgStaCode() {
		return this.lbgStaCode;
	}

	public void setLbgStaCode(String lbgStaCode) {
		this.lbgStaCode = lbgStaCode;
	}

	@Column(name = "LBG_ACT_NUM_MODIF", length = 100)
	public String getLbgActNumModif() {
		return this.lbgActNumModif;
	}

	public void setLbgActNumModif(String lbgActNumModif) {
		this.lbgActNumModif = lbgActNumModif;
	}

	@Column(name = "LBG_DTE_VAL", length = 7)
	public Date getLbgDteVal() {
		return this.lbgDteVal;
	}

	public void setLbgDteVal(Date lbgDteVal) {
		this.lbgDteVal = lbgDteVal;
	}

	@Column(name = "LBG_FON_CODE_VAL", length = 10)
	public String getLbgFonCodeVal() {
		return this.lbgFonCodeVal;
	}

	public void setLbgFonCodeVal(String lbgFonCodeVal) {
		this.lbgFonCodeVal = lbgFonCodeVal;
	}

	@Column(name = "LBG_TRAITMT", length = 1)
	public String getLbgTraitmt() {
		return this.lbgTraitmt;
	}

	public void setLbgTraitmt(String lbgTraitmt) {
		this.lbgTraitmt = lbgTraitmt;
	}

	@Column(name = "LBG_TRAITMT_NOTIF", length = 1)
	public String getLbgTraitmtNotif() {
		return this.lbgTraitmtNotif;
	}

	public void setLbgTraitmtNotif(String lbgTraitmtNotif) {
		this.lbgTraitmtNotif = lbgTraitmtNotif;
	}

	@Column(name = "LBG_DTE_STA_COUR", length = 7)
	public Date getLbgDteStaCour() {
		return this.lbgDteStaCour;
	}

	public void setLbgDteStaCour(Date lbgDteStaCour) {
		this.lbgDteStaCour = lbgDteStaCour;
	}

	@Column(name = "LBG_TITRE", length = 20)
	public String getLbgTitre() {
		return this.lbgTitre;
	}

	public void setLbgTitre(String lbgTitre) {
		this.lbgTitre = lbgTitre;
	}

	@Column(name = "LBG_COR", length = 1)
	public String getLbgCor() {
		return this.lbgCor;
	}

	public void setLbgCor(String lbgCor) {
		this.lbgCor = lbgCor;
	}

	@Column(name = "LBG_ADM_CENTRAL", nullable = false, length = 1)
	public String getLbgAdmCentral() {
		return this.lbgAdmCentral;
	}

	public void setLbgAdmCentral(String lbgAdmCentral) {
		this.lbgAdmCentral = lbgAdmCentral;
	}

	@Column(name = "LBG_MOTIF_COR", length = 200)
	public String getLbgMotifCor() {
		return this.lbgMotifCor;
	}

	public void setLbgMotifCor(String lbgMotifCor) {
		this.lbgMotifCor = lbgMotifCor;
	}

	@Column(name = "LBG_DTE_COR", length = 7)
	public Date getLbgDteCor() {
		return this.lbgDteCor;
	}

	public void setLbgDteCor(Date lbgDteCor) {
		this.lbgDteCor = lbgDteCor;
	}

	@Column(name = "LBG_FON_CODE_COR", length = 30)
	public String getLbgFonCodeCor() {
		return this.lbgFonCodeCor;
	}

	public void setLbgFonCodeCor(String lbgFonCodeCor) {
		this.lbgFonCodeCor = lbgFonCodeCor;
	}

	@Column(name = "LBG_FON_CODE_PF", length = 30)
	public String getLbgFonCodePf() {
		return this.lbgFonCodePf;
	}

	public void setLbgFonCodePf(String lbgFonCodePf) {
		this.lbgFonCodePf = lbgFonCodePf;
	}

	@Column(name = "LBG_FON_CODE_VAL_ACT", length = 30)
	public String getLbgFonCodeValAct() {
		return this.lbgFonCodeValAct;
	}

	public void setLbgFonCodeValAct(String lbgFonCodeValAct) {
		this.lbgFonCodeValAct = lbgFonCodeValAct;
	}

	@Column(name = "LBG_ACTIF", length = 1)
	public String getLbgActif() {
		return this.lbgActif;
	}

	public void setLbgActif(String lbgActif) {
		this.lbgActif = lbgActif;
	}

	@Column(name = "LBG_FON_CODE_CF", length = 30)
	public String getLbgFonCodeCf() {
		return this.lbgFonCodeCf;
	}

	public void setLbgFonCodeCf(String lbgFonCodeCf) {
		this.lbgFonCodeCf = lbgFonCodeCf;
	}

	@Column(name = "LBG_DOT_AN_PLUS1", precision = 20, scale = 0)
	public BigDecimal getLbgDotAnPlus1() {
		return this.lbgDotAnPlus1;
	}

	public void setLbgDotAnPlus1(BigDecimal lbgDotAnPlus1) {
		this.lbgDotAnPlus1 = lbgDotAnPlus1;
	}

	@Column(name = "LBG_DOT_AN_PLUS2", precision = 20, scale = 0)
	public BigDecimal getLbgDotAnPlus2() {
		return this.lbgDotAnPlus2;
	}

	public void setLbgDotAnPlus2(BigDecimal lbgDotAnPlus2) {
		this.lbgDotAnPlus2 = lbgDotAnPlus2;
	}

	@Column(name = "LBG_DOT_AN_PLUS0", precision = 20, scale = 0)
	public BigDecimal getLbgDotAnPlus0() {
		return this.lbgDotAnPlus0;
	}

	public void setLbgDotAnPlus0(BigDecimal lbgDotAnPlus0) {
		this.lbgDotAnPlus0 = lbgDotAnPlus0;
	}

	@Column(name = "LBG_TYP_BUD", length = 10)
	public String getLbgTypBud() {
		return this.lbgTypBud;
	}

	public void setLbgTypBud(String lbgTypBud) {
		this.lbgTypBud = lbgTypBud;
	}

	@Column(name = "LBG_DTE_MP", length = 7)
	public Date getLbgDteMp() {
		return this.lbgDteMp;
	}

	public void setLbgDteMp(Date lbgDteMp) {
		this.lbgDteMp = lbgDteMp;
	}

	@Column(name = "LBG_UTIL_SAISI_ACT", length = 30)
	public String getLbgUtilSaisiAct() {
		return this.lbgUtilSaisiAct;
	}

	public void setLbgUtilSaisiAct(String lbgUtilSaisiAct) {
		this.lbgUtilSaisiAct = lbgUtilSaisiAct;
	}

	@Column(name = "LBG_SIGFIP", length = 1)
	public String getLbgSigfip() {
		return this.lbgSigfip;
	}

	public void setLbgSigfip(String lbgSigfip) {
		this.lbgSigfip = lbgSigfip;
	}

	@Column(name = "LBG_FON_CODE_PR", length = 30)
	public String getLbgFonCodePr() {
		return this.lbgFonCodePr;
	}

	public void setLbgFonCodePr(String lbgFonCodePr) {
		this.lbgFonCodePr = lbgFonCodePr;
	}

	@Column(name = "LBG_FON_CODE_VEROU", length = 30)
	public String getLbgFonCodeVerou() {
		return this.lbgFonCodeVerou;
	}

	public void setLbgFonCodeVerou(String lbgFonCodeVerou) {
		this.lbgFonCodeVerou = lbgFonCodeVerou;
	}

	@Column(name = "NAT_LIBELLE", length = 200)
	public String getNatLibelle() {
		return this.natLibelle;
	}

	public void setNatLibelle(String natLibelle) {
		this.natLibelle = natLibelle;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VLigneImputationId))
			return false;
		VLigneImputationId castOther = (VLigneImputationId) other;

		return ((this.getLbgCode() == castOther.getLbgCode()) || (this.getLbgCode() != null
				&& castOther.getLbgCode() != null && this.getLbgCode().equals(castOther.getLbgCode())))
				&& ((this.getLbgStrCode() == castOther.getLbgStrCode()) || (this.getLbgStrCode() != null
						&& castOther.getLbgStrCode() != null && this.getLbgStrCode().equals(castOther.getLbgStrCode())))
				&& (this.getLbgGesCode() == castOther.getLbgGesCode())
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
				&& ((this.getNatLibelle() == castOther.getNatLibelle())
						|| (this.getNatLibelle() != null && castOther.getNatLibelle() != null
								&& this.getNatLibelle().equals(castOther.getNatLibelle())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getLbgCode() == null ? 0 : this.getLbgCode().hashCode());
		result = 37 * result + (getLbgStrCode() == null ? 0 : this.getLbgStrCode().hashCode());
		result = 37 * result + this.getLbgGesCode();
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
		result = 37 * result + (getNatLibelle() == null ? 0 : this.getNatLibelle().hashCode());
		return result;
	}

}
