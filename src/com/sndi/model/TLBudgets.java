package com.sndi.model;
// Generated 3 f?vr. 2020 13:07:31 by Hibernate Tools 4.3.5.Final

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
@Table(name = "T_L_BUDGETS", schema = "EMAP" , uniqueConstraints = @UniqueConstraint(columnNames = { "LBG_STR_CODE",
		"LBG_GES_CODE", "LBG_IMPUTATION" }))
public class TLBudgets implements java.io.Serializable {

	private String lbgCode;
	private TDestinations TDestinations;
	private TNatures TNatures;
	private TFonction TFonctionByLbgFonCode;
	private TFonction TFonctionByLbgFonCodeAc;
	private TStructure TStructure;
	private TGestion TGestion;
	private long lbgResDon;
	private String lbgImputation;
	private Long lbgAnoCode;
	private long lbgResTr;
	private Date lbgDteSaisi;
	private long lbgAeTr;
	private long lbgAeDon;
	private long lbgAeEmp;
	private String lbgMp;
	private String lbgReglMp;
	private long lbgTotDot;
	private String lbgUtilSaisi;
	private Date lbgDteModif;
	private long lbgResEmp;
	private long lbgResTot;
	private String lbgUtilModif;
	private long lbgDisTre;
	private long lbgDisDon;
	private long lbgDisEmp;
	private long lbgDisTot;
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
	private Long lbgDotAnPlus1;
	private Long lbgDotAnPlus2;
	private Long lbgDotAnPlus0;
	private String lbgTypBud;
	private Date lbgDteMp;
	private String lbgUtilSaisiAct;
	private String lbgSigfip;
	private String lbgFonCodePr;
	private String lbgFonCodeVerou;
	private Set<TDetailPlanPassation> TDetailPlanPassations = new HashSet<TDetailPlanPassation>(0);

	public TLBudgets() {
	}
	
	
	public TLBudgets(String lbgCode) {
		this.lbgCode = lbgCode;
	}

	public TLBudgets(String lbgCode, TNatures TNatures, TStructure TStructure, TGestion TGestion, long lbgResDon,
			String lbgImputation, long lbgResTr, long lbgAeTr, long lbgAeDon, long lbgAeEmp,
			long lbgTotDot, String lbgAdmCentral) {
		this.lbgCode = lbgCode;
		this.TNatures = TNatures;
		this.TStructure = TStructure;
		this.TGestion = TGestion;
		this.lbgResDon = lbgResDon;
		this.lbgImputation = lbgImputation;
		this.lbgResTr = lbgResTr;
		this.lbgAeTr = lbgAeTr;
		this.lbgAeDon = lbgAeDon;
		this.lbgAeEmp = lbgAeEmp;
		this.lbgTotDot = lbgTotDot;
		this.lbgAdmCentral = lbgAdmCentral;
	}

	public TLBudgets(String lbgCode, TDestinations TDestinations, TNatures TNatures, TFonction TFonctionByLbgFonCode,
			TFonction TFonctionByLbgFonCodeAc, TStructure TStructure, TGestion TGestion, long lbgResDon,
			String lbgImputation, Long lbgAnoCode, long lbgResTr, Date lbgDteSaisi, long lbgAeTr,
			long lbgAeDon, long lbgAeEmp, String lbgMp, String lbgReglMp, long lbgTotDot,
			String lbgUtilSaisi, Date lbgDteModif, long lbgResEmp, long lbgResTot, String lbgUtilModif,
			long lbgDisTre, long lbgDisDon, long lbgDisEmp, long lbgDisTot, String lbgStaCode,
			String lbgActNumModif, Date lbgDteVal, String lbgFonCodeVal, String lbgTraitmt, String lbgTraitmtNotif,
			Date lbgDteStaCour, String lbgTitre, String lbgCor, String lbgAdmCentral, String lbgMotifCor,
			Date lbgDteCor, String lbgFonCodeCor, String lbgFonCodePf, String lbgFonCodeValAct, String lbgActif,
			String lbgFonCodeCf, Long lbgDotAnPlus1, Long lbgDotAnPlus2, Long lbgDotAnPlus0,
			String lbgTypBud, Date lbgDteMp, String lbgUtilSaisiAct, String lbgSigfip, String lbgFonCodePr,
			String lbgFonCodeVerou,Set<TDetailPlanPassation> TDetailPlanPassations) {
		this.lbgCode = lbgCode;
		this.TDestinations = TDestinations;
		this.TNatures = TNatures;
		this.TFonctionByLbgFonCode = TFonctionByLbgFonCode;
		this.TFonctionByLbgFonCodeAc = TFonctionByLbgFonCodeAc;
		this.TStructure = TStructure;
		this.TGestion = TGestion;
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
	@JoinColumn(name = "LBG_DES_CODE")
	public TDestinations getTDestinations() {
		return this.TDestinations;
	}

	public void setTDestinations(TDestinations TDestinations) {
		this.TDestinations = TDestinations;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LBG_NAT_CODE", nullable = false)
	public TNatures getTNatures() {
		return this.TNatures;
	}

	public void setTNatures(TNatures TNatures) {
		this.TNatures = TNatures;
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
	@JoinColumn(name = "LBG_STR_CODE", nullable = false)
	public TStructure getTStructure() {
		return this.TStructure;
	}

	public void setTStructure(TStructure TStructure) {
		this.TStructure = TStructure;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LBG_GES_CODE", nullable = false)
	public TGestion getTGestion() {
		return this.TGestion;
	}

	public void setTGestion(TGestion TGestion) {
		this.TGestion = TGestion;
	}

	@Column(name = "LBG_RES_DON", nullable = false, precision = 20, scale = 0)
	public long getLbgResDon() {
		return this.lbgResDon;
	}

	public void setLbgResDon(long lbgResDon) {
		this.lbgResDon = lbgResDon;
	}

	@Column(name = "LBG_IMPUTATION", nullable = false, length = 20)
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
	public long getLbgResTr() {
		return this.lbgResTr;
	}

	public void setLbgResTr(long lbgResTr) {
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
	public long getLbgAeTr() {
		return this.lbgAeTr;
	}

	public void setLbgAeTr(long lbgAeTr) {
		this.lbgAeTr = lbgAeTr;
	}

	@Column(name = "LBG_AE_DON", nullable = false, precision = 20, scale = 0)
	public long getLbgAeDon() {
		return this.lbgAeDon;
	}

	public void setLbgAeDon(long lbgAeDon) {
		this.lbgAeDon = lbgAeDon;
	}

	@Column(name = "LBG_AE_EMP", nullable = false, precision = 20, scale = 0)
	public long getLbgAeEmp() {
		return this.lbgAeEmp;
	}

	public void setLbgAeEmp(long lbgAeEmp) {
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
	public long getLbgTotDot() {
		return this.lbgTotDot;
	}

	public void setLbgTotDot(long lbgTotDot) {
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
	public long getLbgResEmp() {
		return this.lbgResEmp;
	}

	public void setLbgResEmp(long lbgResEmp) {
		this.lbgResEmp = lbgResEmp;
	}

	@Column(name = "LBG_RES_TOT", precision = 20, scale = 0)
	public long getLbgResTot() {
		return this.lbgResTot;
	}

	public void setLbgResTot(long lbgResTot) {
		this.lbgResTot = lbgResTot;
	}

	@Column(name = "LBG_UTIL_MODIF", length = 12)
	public String getLbgUtilModif() {
		return this.lbgUtilModif;
	}

	public void setLbgUtilModif(String lbgUtilModif) {
		this.lbgUtilModif = lbgUtilModif;
	}

	@Column(name = "LBG_DIS_TRE", precision = 20, scale = 0)
	public long getLbgDisTre() {
		return this.lbgDisTre;
	}

	public void setLbgDisTre(long lbgDisTre) {
		this.lbgDisTre = lbgDisTre;
	}

	@Column(name = "LBG_DIS_DON", precision = 20, scale = 0)
	public long getLbgDisDon() {
		return this.lbgDisDon;
	}

	public void setLbgDisDon(long lbgDisDon) {
		this.lbgDisDon = lbgDisDon;
	}

	@Column(name = "LBG_DIS_EMP", precision = 20, scale = 0)
	public long getLbgDisEmp() {
		return this.lbgDisEmp;
	}

	public void setLbgDisEmp(long lbgDisEmp) {
		this.lbgDisEmp = lbgDisEmp;
	}

	@Column(name = "LBG_DIS_TOT", precision = 20, scale = 0)
	public long getLbgDisTot() {
		return this.lbgDisTot;
	}

	public void setLbgDisTot(long lbgDisTot) {
		this.lbgDisTot = lbgDisTot;
	}

	@Column(name = "LBG_STA_CODE", length = 3)
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

	@Column(name = "LBG_FON_CODE_COR", length = 10)
	public String getLbgFonCodeCor() {
		return this.lbgFonCodeCor;
	}

	public void setLbgFonCodeCor(String lbgFonCodeCor) {
		this.lbgFonCodeCor = lbgFonCodeCor;
	}

	@Column(name = "LBG_FON_CODE_PF", length = 12)
	public String getLbgFonCodePf() {
		return this.lbgFonCodePf;
	}

	public void setLbgFonCodePf(String lbgFonCodePf) {
		this.lbgFonCodePf = lbgFonCodePf;
	}

	@Column(name = "LBG_FON_CODE_VAL_ACT", length = 10)
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

	@Column(name = "LBG_FON_CODE_CF", length = 20)
	public String getLbgFonCodeCf() {
		return this.lbgFonCodeCf;
	}

	public void setLbgFonCodeCf(String lbgFonCodeCf) {
		this.lbgFonCodeCf = lbgFonCodeCf;
	}

	@Column(name = "LBG_DOT_AN_PLUS1", precision = 20, scale = 0)
	public Long getLbgDotAnPlus1() {
		return this.lbgDotAnPlus1;
	}

	public void setLbgDotAnPlus1(Long lbgDotAnPlus1) {
		this.lbgDotAnPlus1 = lbgDotAnPlus1;
	}

	@Column(name = "LBG_DOT_AN_PLUS2", precision = 20, scale = 0)
	public Long getLbgDotAnPlus2() {
		return this.lbgDotAnPlus2;
	}

	public void setLbgDotAnPlus2(Long lbgDotAnPlus2) {
		this.lbgDotAnPlus2 = lbgDotAnPlus2;
	}

	@Column(name = "LBG_DOT_AN_PLUS0", precision = 20, scale = 0)
	public Long getLbgDotAnPlus0() {
		return this.lbgDotAnPlus0;
	}

	public void setLbgDotAnPlus0(Long lbgDotAnPlus0) {
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

	@Column(name = "LBG_UTIL_SAISI_ACT", length = 10)
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

	@Column(name = "LBG_FON_CODE_PR", length = 20)
	public String getLbgFonCodePr() {
		return this.lbgFonCodePr;
	}

	public void setLbgFonCodePr(String lbgFonCodePr) {
		this.lbgFonCodePr = lbgFonCodePr;
	}

	@Column(name = "LBG_FON_CODE_VEROU", length = 20)
	public String getLbgFonCodeVerou() {
		return this.lbgFonCodeVerou;
	}

	public void setLbgFonCodeVerou(String lbgFonCodeVerou) {
		this.lbgFonCodeVerou = lbgFonCodeVerou;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TLBudgets")
	public Set<TDetailPlanPassation> getTDetailPlanPassations() {
		return this.TDetailPlanPassations;
	}

	public void setTDetailPlanPassations(Set<TDetailPlanPassation> TDetailPlanPassations) {
		this.TDetailPlanPassations = TDetailPlanPassations;
	}

}
