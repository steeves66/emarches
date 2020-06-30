package com.sndi.models;
// Generated 30 juin 2020 16:42:29 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * TLBudgets generated by hbm2java
 */
@Entity
@Table(name = "T_L_BUDGETS", schema = "EMAP", uniqueConstraints = @UniqueConstraint(columnNames = { "LBG_STR_CODE",
		"LBG_GES_CODE", "LBG_IMPUTATION" }))
public class TLBudgets implements java.io.Serializable {

	private String lbgCode;
	private TStructure TStructure;
	private TGestions TGestions;
	private TDestinations TDestinations;
	private TFonction TFonctionByLbgFonCode;
	private TFonction TFonctionByLbgFonCodeAc;
	private TNatures TNatures;
	private BigDecimal lbgResDon;
	private String lbgImputation;
	private Long lbgAnoCode;
	private BigDecimal lbgResTr;
	private Date lbgDteSaisi;
	private BigDecimal lbgAeTr;
	private BigDecimal lbgAeDon;
	private BigDecimal lbgAeEmp;
	private String lbgMp;
	private String lbgReglMp;
	private BigDecimal lbgTotDot;
	private String lbgUtilSaisi;
	private Date lbgDteModif;
	private BigDecimal lbgResEmp;
	private BigDecimal lbgResTot;
	private String lbgUtilModif;
	private BigDecimal lbgDisTre;
	private BigDecimal lbgDisDon;
	private BigDecimal lbgDisEmp;
	private BigDecimal lbgDisTot;
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
	private Set<TLotAao> TLotAaos = new HashSet<TLotAao>(0);
	private Set<TDetailDemandes> TDetailDemandeses = new HashSet<TDetailDemandes>(0);
	private Set<TAffichagePpm> TAffichagePpms = new HashSet<TAffichagePpm>(0);
	private Set<TDetailPlanPassation> TDetailPlanPassations = new HashSet<TDetailPlanPassation>(0);

	public TLBudgets() {
	}

	public TLBudgets(String lbgCode, TStructure TStructure, TGestions TGestions, TNatures TNatures,
			BigDecimal lbgResDon, String lbgImputation, BigDecimal lbgResTr, BigDecimal lbgAeTr, BigDecimal lbgAeDon,
			BigDecimal lbgAeEmp, BigDecimal lbgTotDot, String lbgAdmCentral) {
		this.lbgCode = lbgCode;
		this.TStructure = TStructure;
		this.TGestions = TGestions;
		this.TNatures = TNatures;
		this.lbgResDon = lbgResDon;
		this.lbgImputation = lbgImputation;
		this.lbgResTr = lbgResTr;
		this.lbgAeTr = lbgAeTr;
		this.lbgAeDon = lbgAeDon;
		this.lbgAeEmp = lbgAeEmp;
		this.lbgTotDot = lbgTotDot;
		this.lbgAdmCentral = lbgAdmCentral;
	}

	public TLBudgets(String lbgCode, TStructure TStructure, TGestions TGestions, TDestinations TDestinations,
			TFonction TFonctionByLbgFonCode, TFonction TFonctionByLbgFonCodeAc, TNatures TNatures, BigDecimal lbgResDon,
			String lbgImputation, Long lbgAnoCode, BigDecimal lbgResTr, Date lbgDteSaisi, BigDecimal lbgAeTr,
			BigDecimal lbgAeDon, BigDecimal lbgAeEmp, String lbgMp, String lbgReglMp, BigDecimal lbgTotDot,
			String lbgUtilSaisi, Date lbgDteModif, BigDecimal lbgResEmp, BigDecimal lbgResTot, String lbgUtilModif,
			BigDecimal lbgDisTre, BigDecimal lbgDisDon, BigDecimal lbgDisEmp, BigDecimal lbgDisTot, String lbgStaCode,
			String lbgActNumModif, Date lbgDteVal, String lbgFonCodeVal, String lbgTraitmt, String lbgTraitmtNotif,
			Date lbgDteStaCour, String lbgTitre, String lbgCor, String lbgAdmCentral, String lbgMotifCor,
			Date lbgDteCor, String lbgFonCodeCor, String lbgFonCodePf, String lbgFonCodeValAct, String lbgActif,
			String lbgFonCodeCf, BigDecimal lbgDotAnPlus1, BigDecimal lbgDotAnPlus2, BigDecimal lbgDotAnPlus0,
			String lbgTypBud, Date lbgDteMp, String lbgUtilSaisiAct, String lbgSigfip, String lbgFonCodePr,
			String lbgFonCodeVerou, Set<TLotAao> TLotAaos, Set<TDetailDemandes> TDetailDemandeses,
			Set<TAffichagePpm> TAffichagePpms, Set<TDetailPlanPassation> TDetailPlanPassations) {
		this.lbgCode = lbgCode;
		this.TStructure = TStructure;
		this.TGestions = TGestions;
		this.TDestinations = TDestinations;
		this.TFonctionByLbgFonCode = TFonctionByLbgFonCode;
		this.TFonctionByLbgFonCodeAc = TFonctionByLbgFonCodeAc;
		this.TNatures = TNatures;
		this.lbgResDon = lbgResDon;
		this.lbgImputation = lbgImputation;
		this.lbgAnoCode = lbgAnoCode;
		this.lbgResTr = lbgResTr;
		this.lbgDteSaisi = lbgDteSaisi;
		this.lbgAeTr = lbgAeTr;
		this.lbgAeDon = lbgAeDon;
		this.lbgAeEmp = lbgAeEmp;
		this.lbgMp = lbgMp;
		this.lbgReglMp = lbgReglMp;
		this.lbgTotDot = lbgTotDot;
		this.lbgUtilSaisi = lbgUtilSaisi;
		this.lbgDteModif = lbgDteModif;
		this.lbgResEmp = lbgResEmp;
		this.lbgResTot = lbgResTot;
		this.lbgUtilModif = lbgUtilModif;
		this.lbgDisTre = lbgDisTre;
		this.lbgDisDon = lbgDisDon;
		this.lbgDisEmp = lbgDisEmp;
		this.lbgDisTot = lbgDisTot;
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
		this.TLotAaos = TLotAaos;
		this.TDetailDemandeses = TDetailDemandeses;
		this.TAffichagePpms = TAffichagePpms;
		this.TDetailPlanPassations = TDetailPlanPassations;
	}

	@Id

	@Column(name = "LBG_CODE", unique = true, nullable = false, length = 50)
	public String getLbgCode() {
		return this.lbgCode;
	}

	public void setLbgCode(String lbgCode) {
		this.lbgCode = lbgCode;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LBG_STR_CODE", nullable = false)
	public TStructure getTStructure() {
		return this.TStructure;
	}

	public void setTStructure(TStructure TStructure) {
		this.TStructure = TStructure;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LBG_GES_CODE", nullable = false)
	public TGestions getTGestions() {
		return this.TGestions;
	}

	public void setTGestions(TGestions TGestions) {
		this.TGestions = TGestions;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LBG_DES_CODE")
	public TDestinations getTDestinations() {
		return this.TDestinations;
	}

	public void setTDestinations(TDestinations TDestinations) {
		this.TDestinations = TDestinations;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LBG_FON_CODE")
	public TFonction getTFonctionByLbgFonCode() {
		return this.TFonctionByLbgFonCode;
	}

	public void setTFonctionByLbgFonCode(TFonction TFonctionByLbgFonCode) {
		this.TFonctionByLbgFonCode = TFonctionByLbgFonCode;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LBG_FON_CODE_AC")
	public TFonction getTFonctionByLbgFonCodeAc() {
		return this.TFonctionByLbgFonCodeAc;
	}

	public void setTFonctionByLbgFonCodeAc(TFonction TFonctionByLbgFonCodeAc) {
		this.TFonctionByLbgFonCodeAc = TFonctionByLbgFonCodeAc;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LBG_NAT_CODE", nullable = false)
	public TNatures getTNatures() {
		return this.TNatures;
	}

	public void setTNatures(TNatures TNatures) {
		this.TNatures = TNatures;
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

	@Column(name = "LBG_RES_TR", nullable = false, precision = 20, scale = 0)
	public BigDecimal getLbgResTr() {
		return this.lbgResTr;
	}

	public void setLbgResTr(BigDecimal lbgResTr) {
		this.lbgResTr = lbgResTr;
	}

	@Temporal(TemporalType.DATE)
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

	@Temporal(TemporalType.DATE)
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

	@Temporal(TemporalType.DATE)
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

	@Temporal(TemporalType.DATE)
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

	@Temporal(TemporalType.DATE)
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

	@Temporal(TemporalType.DATE)
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TLBudgets")
	public Set<TLotAao> getTLotAaos() {
		return this.TLotAaos;
	}

	public void setTLotAaos(Set<TLotAao> TLotAaos) {
		this.TLotAaos = TLotAaos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TLBudgets")
	public Set<TDetailDemandes> getTDetailDemandeses() {
		return this.TDetailDemandeses;
	}

	public void setTDetailDemandeses(Set<TDetailDemandes> TDetailDemandeses) {
		this.TDetailDemandeses = TDetailDemandeses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TLBudgets")
	public Set<TAffichagePpm> getTAffichagePpms() {
		return this.TAffichagePpms;
	}

	public void setTAffichagePpms(Set<TAffichagePpm> TAffichagePpms) {
		this.TAffichagePpms = TAffichagePpms;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TLBudgets")
	public Set<TDetailPlanPassation> getTDetailPlanPassations() {
		return this.TDetailPlanPassations;
	}

	public void setTDetailPlanPassations(Set<TDetailPlanPassation> TDetailPlanPassations) {
		this.TDetailPlanPassations = TDetailPlanPassations;
	}

}
