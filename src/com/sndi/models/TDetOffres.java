package com.sndi.models;
// Generated 4 juil. 2020 18:05:44 by Hibernate Tools 4.3.5.Final

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

/**
 * TDetOffres generated by hbm2java
 */
@Entity
@Table(name = "T_DET_OFFRES", schema = "EMAP")
public class TDetOffres implements java.io.Serializable {

	private BigDecimal dofNum;
	private TFonction TFonction;
	private TLotAao TLotAao;
	private TOffres TOffres;
	private TOperateur TOperateur;
	private String dofLaaAaoCode;
	private String dofTyp;
	private BigDecimal dofDelai;
	private BigDecimal dofDelai2;
	private Long dofRangOfr;
	private BigDecimal dofMtCor;
	private BigDecimal dofMtOfr;
	private String dofRab;
	private BigDecimal dofEstimRab;
	private String dofCaut;
	private String dofBanCode;
	private String dofSeuil;
	private Short dofScore;
	private String dofRecevabl;
	private String dofRet;
	private String dofRetBai;
	private String dofRetDmp;
	private BigDecimal dofMtAtt;
	private String dofTot;
	private String dofTotAdm;
	private String dofTotTec;
	private String dofObsDmp;
	private String dofObsCom;
	private String dofObsAdm;
	private String dofObsAdmDmp;
	private String dofObsAdmBai;
	private String dofObsTec;
	private String dofObsTecDmp;
	private String dofObsTecBai;
	private Short dofNotAdm;
	private Short dofNotTec;
	private Short dofNotFin;
	private Short dofNotFin2;
	private Short dofNotAdmDmp;
	private Short dofNotTecDmp;
	private Short dofNotFinDmp;
	private Short dofNotFin2Dmp;
	private Short dofNotAdmBai;
	private String dofNotTecBai;
	private Short dofNotFinBai;
	private Short dofNotFin2Bai;
	private BigDecimal dofMtAttDmp;
	private BigDecimal dofMtAttBai;
	private Long dofRangOfrDmp;
	private BigDecimal dofMtCorDmp;
	private String dofRecevablDmp;
	private Short dofScoreDmp;
	private Long dofRangOfrBai;
	private BigDecimal dofMtCorBai;
	private String dofRecevablBai;
	private Short dofScoreBai;
	private String dofNomSign;
	private String dofFonctSign;
	private String dofTelSign;
	private Date dofDteSaisi;
	private String dofStatut;
	private String dofSouNcc;
	private String dofSigle;
	private String dofErrFin;
	private String dofObsFin;
	private String dofRepeche;
	private String dofObsRet;
	private String dofObsAnormal;
	private Set<TAnalyseOffre> TAnalyseOffres = new HashSet<TAnalyseOffre>(0);
	private Set<TPiecesOffres> TPiecesOffreses = new HashSet<TPiecesOffres>(0);

	public TDetOffres() {
	}

	public TDetOffres(BigDecimal dofNum, TLotAao TLotAao, TOffres TOffres, String dofLaaAaoCode, BigDecimal dofDelai) {
		this.dofNum = dofNum;
		this.TLotAao = TLotAao;
		this.TOffres = TOffres;
		this.dofLaaAaoCode = dofLaaAaoCode;
		this.dofDelai = dofDelai;
	}

	public TDetOffres(BigDecimal dofNum, TFonction TFonction, TLotAao TLotAao, TOffres TOffres, TOperateur TOperateur,
			String dofLaaAaoCode, String dofTyp, BigDecimal dofDelai, BigDecimal dofDelai2, Long dofRangOfr,
			BigDecimal dofMtCor, BigDecimal dofMtOfr, String dofRab, BigDecimal dofEstimRab, String dofCaut,
			String dofBanCode, String dofSeuil, Short dofScore, String dofRecevabl, String dofRet, String dofRetBai,
			String dofRetDmp, BigDecimal dofMtAtt, String dofTot, String dofTotAdm, String dofTotTec, String dofObsDmp,
			String dofObsCom, String dofObsAdm, String dofObsAdmDmp, String dofObsAdmBai, String dofObsTec,
			String dofObsTecDmp, String dofObsTecBai, Short dofNotAdm, Short dofNotTec, Short dofNotFin,
			Short dofNotFin2, Short dofNotAdmDmp, Short dofNotTecDmp, Short dofNotFinDmp, Short dofNotFin2Dmp,
			Short dofNotAdmBai, String dofNotTecBai, Short dofNotFinBai, Short dofNotFin2Bai, BigDecimal dofMtAttDmp,
			BigDecimal dofMtAttBai, Long dofRangOfrDmp, BigDecimal dofMtCorDmp, String dofRecevablDmp,
			Short dofScoreDmp, Long dofRangOfrBai, BigDecimal dofMtCorBai, String dofRecevablBai, Short dofScoreBai,
			String dofNomSign, String dofFonctSign, String dofTelSign, Date dofDteSaisi, String dofStatut,
			String dofSouNcc, String dofSigle, String dofErrFin, String dofObsFin, String dofRepeche, String dofObsRet,
			String dofObsAnormal, Set<TAnalyseOffre> TAnalyseOffres, Set<TPiecesOffres> TPiecesOffreses) {
		this.dofNum = dofNum;
		this.TFonction = TFonction;
		this.TLotAao = TLotAao;
		this.TOffres = TOffres;
		this.TOperateur = TOperateur;
		this.dofLaaAaoCode = dofLaaAaoCode;
		this.dofTyp = dofTyp;
		this.dofDelai = dofDelai;
		this.dofDelai2 = dofDelai2;
		this.dofRangOfr = dofRangOfr;
		this.dofMtCor = dofMtCor;
		this.dofMtOfr = dofMtOfr;
		this.dofRab = dofRab;
		this.dofEstimRab = dofEstimRab;
		this.dofCaut = dofCaut;
		this.dofBanCode = dofBanCode;
		this.dofSeuil = dofSeuil;
		this.dofScore = dofScore;
		this.dofRecevabl = dofRecevabl;
		this.dofRet = dofRet;
		this.dofRetBai = dofRetBai;
		this.dofRetDmp = dofRetDmp;
		this.dofMtAtt = dofMtAtt;
		this.dofTot = dofTot;
		this.dofTotAdm = dofTotAdm;
		this.dofTotTec = dofTotTec;
		this.dofObsDmp = dofObsDmp;
		this.dofObsCom = dofObsCom;
		this.dofObsAdm = dofObsAdm;
		this.dofObsAdmDmp = dofObsAdmDmp;
		this.dofObsAdmBai = dofObsAdmBai;
		this.dofObsTec = dofObsTec;
		this.dofObsTecDmp = dofObsTecDmp;
		this.dofObsTecBai = dofObsTecBai;
		this.dofNotAdm = dofNotAdm;
		this.dofNotTec = dofNotTec;
		this.dofNotFin = dofNotFin;
		this.dofNotFin2 = dofNotFin2;
		this.dofNotAdmDmp = dofNotAdmDmp;
		this.dofNotTecDmp = dofNotTecDmp;
		this.dofNotFinDmp = dofNotFinDmp;
		this.dofNotFin2Dmp = dofNotFin2Dmp;
		this.dofNotAdmBai = dofNotAdmBai;
		this.dofNotTecBai = dofNotTecBai;
		this.dofNotFinBai = dofNotFinBai;
		this.dofNotFin2Bai = dofNotFin2Bai;
		this.dofMtAttDmp = dofMtAttDmp;
		this.dofMtAttBai = dofMtAttBai;
		this.dofRangOfrDmp = dofRangOfrDmp;
		this.dofMtCorDmp = dofMtCorDmp;
		this.dofRecevablDmp = dofRecevablDmp;
		this.dofScoreDmp = dofScoreDmp;
		this.dofRangOfrBai = dofRangOfrBai;
		this.dofMtCorBai = dofMtCorBai;
		this.dofRecevablBai = dofRecevablBai;
		this.dofScoreBai = dofScoreBai;
		this.dofNomSign = dofNomSign;
		this.dofFonctSign = dofFonctSign;
		this.dofTelSign = dofTelSign;
		this.dofDteSaisi = dofDteSaisi;
		this.dofStatut = dofStatut;
		this.dofSouNcc = dofSouNcc;
		this.dofSigle = dofSigle;
		this.dofErrFin = dofErrFin;
		this.dofObsFin = dofObsFin;
		this.dofRepeche = dofRepeche;
		this.dofObsRet = dofObsRet;
		this.dofObsAnormal = dofObsAnormal;
		this.TAnalyseOffres = TAnalyseOffres;
		this.TPiecesOffreses = TPiecesOffreses;
	}

	@Id

	@Column(name = "DOF_NUM", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getDofNum() {
		return this.dofNum;
	}

	public void setDofNum(BigDecimal dofNum) {
		this.dofNum = dofNum;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DOF_FON_CODE_AC")
	public TFonction getTFonction() {
		return this.TFonction;
	}

	public void setTFonction(TFonction TFonction) {
		this.TFonction = TFonction;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DOF_LAA_ID", nullable = false)
	public TLotAao getTLotAao() {
		return this.TLotAao;
	}

	public void setTLotAao(TLotAao TLotAao) {
		this.TLotAao = TLotAao;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DOF_OFF_NUM", nullable = false)
	public TOffres getTOffres() {
		return this.TOffres;
	}

	public void setTOffres(TOffres TOffres) {
		this.TOffres = TOffres;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DOF_OPE_MATRICULE")
	public TOperateur getTOperateur() {
		return this.TOperateur;
	}

	public void setTOperateur(TOperateur TOperateur) {
		this.TOperateur = TOperateur;
	}

	@Column(name = "DOF_LAA_AAO_CODE", nullable = false, length = 20)
	public String getDofLaaAaoCode() {
		return this.dofLaaAaoCode;
	}

	public void setDofLaaAaoCode(String dofLaaAaoCode) {
		this.dofLaaAaoCode = dofLaaAaoCode;
	}

	@Column(name = "DOF_TYP", length = 1)
	public String getDofTyp() {
		return this.dofTyp;
	}

	public void setDofTyp(String dofTyp) {
		this.dofTyp = dofTyp;
	}

	@Column(name = "DOF_DELAI", nullable = false, precision = 20, scale = 0)
	public BigDecimal getDofDelai() {
		return this.dofDelai;
	}

	public void setDofDelai(BigDecimal dofDelai) {
		this.dofDelai = dofDelai;
	}

	@Column(name = "DOF_DELAI2", precision = 20, scale = 0)
	public BigDecimal getDofDelai2() {
		return this.dofDelai2;
	}

	public void setDofDelai2(BigDecimal dofDelai2) {
		this.dofDelai2 = dofDelai2;
	}

	@Column(name = "DOF_RANG_OFR", precision = 10, scale = 0)
	public Long getDofRangOfr() {
		return this.dofRangOfr;
	}

	public void setDofRangOfr(Long dofRangOfr) {
		this.dofRangOfr = dofRangOfr;
	}

	@Column(name = "DOF_MT_COR", precision = 20, scale = 0)
	public BigDecimal getDofMtCor() {
		return this.dofMtCor;
	}

	public void setDofMtCor(BigDecimal dofMtCor) {
		this.dofMtCor = dofMtCor;
	}

	@Column(name = "DOF_MT_OFR", precision = 20, scale = 0)
	public BigDecimal getDofMtOfr() {
		return this.dofMtOfr;
	}

	public void setDofMtOfr(BigDecimal dofMtOfr) {
		this.dofMtOfr = dofMtOfr;
	}

	@Column(name = "DOF_RAB", length = 5)
	public String getDofRab() {
		return this.dofRab;
	}

	public void setDofRab(String dofRab) {
		this.dofRab = dofRab;
	}

	@Column(name = "DOF_ESTIM_RAB", precision = 20, scale = 0)
	public BigDecimal getDofEstimRab() {
		return this.dofEstimRab;
	}

	public void setDofEstimRab(BigDecimal dofEstimRab) {
		this.dofEstimRab = dofEstimRab;
	}

	@Column(name = "DOF_CAUT", length = 1)
	public String getDofCaut() {
		return this.dofCaut;
	}

	public void setDofCaut(String dofCaut) {
		this.dofCaut = dofCaut;
	}

	@Column(name = "DOF_BAN_CODE", length = 10)
	public String getDofBanCode() {
		return this.dofBanCode;
	}

	public void setDofBanCode(String dofBanCode) {
		this.dofBanCode = dofBanCode;
	}

	@Column(name = "DOF_SEUIL", length = 1)
	public String getDofSeuil() {
		return this.dofSeuil;
	}

	public void setDofSeuil(String dofSeuil) {
		this.dofSeuil = dofSeuil;
	}

	@Column(name = "DOF_SCORE", precision = 3, scale = 0)
	public Short getDofScore() {
		return this.dofScore;
	}

	public void setDofScore(Short dofScore) {
		this.dofScore = dofScore;
	}

	@Column(name = "DOF_RECEVABL", length = 1)
	public String getDofRecevabl() {
		return this.dofRecevabl;
	}

	public void setDofRecevabl(String dofRecevabl) {
		this.dofRecevabl = dofRecevabl;
	}

	@Column(name = "DOF_RET", length = 1)
	public String getDofRet() {
		return this.dofRet;
	}

	public void setDofRet(String dofRet) {
		this.dofRet = dofRet;
	}

	@Column(name = "DOF_RET_BAI", length = 1)
	public String getDofRetBai() {
		return this.dofRetBai;
	}

	public void setDofRetBai(String dofRetBai) {
		this.dofRetBai = dofRetBai;
	}

	@Column(name = "DOF_RET_DMP", length = 1)
	public String getDofRetDmp() {
		return this.dofRetDmp;
	}

	public void setDofRetDmp(String dofRetDmp) {
		this.dofRetDmp = dofRetDmp;
	}

	@Column(name = "DOF_MT_ATT", precision = 20, scale = 0)
	public BigDecimal getDofMtAtt() {
		return this.dofMtAtt;
	}

	public void setDofMtAtt(BigDecimal dofMtAtt) {
		this.dofMtAtt = dofMtAtt;
	}

	@Column(name = "DOF_TOT", length = 2)
	public String getDofTot() {
		return this.dofTot;
	}

	public void setDofTot(String dofTot) {
		this.dofTot = dofTot;
	}

	@Column(name = "DOF_TOT_ADM", length = 2)
	public String getDofTotAdm() {
		return this.dofTotAdm;
	}

	public void setDofTotAdm(String dofTotAdm) {
		this.dofTotAdm = dofTotAdm;
	}

	@Column(name = "DOF_TOT_TEC", length = 2)
	public String getDofTotTec() {
		return this.dofTotTec;
	}

	public void setDofTotTec(String dofTotTec) {
		this.dofTotTec = dofTotTec;
	}

	@Column(name = "DOF_OBS_DMP", length = 500)
	public String getDofObsDmp() {
		return this.dofObsDmp;
	}

	public void setDofObsDmp(String dofObsDmp) {
		this.dofObsDmp = dofObsDmp;
	}

	@Column(name = "DOF_OBS_COM", length = 500)
	public String getDofObsCom() {
		return this.dofObsCom;
	}

	public void setDofObsCom(String dofObsCom) {
		this.dofObsCom = dofObsCom;
	}

	@Column(name = "DOF_OBS_ADM", length = 500)
	public String getDofObsAdm() {
		return this.dofObsAdm;
	}

	public void setDofObsAdm(String dofObsAdm) {
		this.dofObsAdm = dofObsAdm;
	}

	@Column(name = "DOF_OBS_ADM_DMP", length = 500)
	public String getDofObsAdmDmp() {
		return this.dofObsAdmDmp;
	}

	public void setDofObsAdmDmp(String dofObsAdmDmp) {
		this.dofObsAdmDmp = dofObsAdmDmp;
	}

	@Column(name = "DOF_OBS_ADM_BAI", length = 500)
	public String getDofObsAdmBai() {
		return this.dofObsAdmBai;
	}

	public void setDofObsAdmBai(String dofObsAdmBai) {
		this.dofObsAdmBai = dofObsAdmBai;
	}

	@Column(name = "DOF_OBS_TEC", length = 500)
	public String getDofObsTec() {
		return this.dofObsTec;
	}

	public void setDofObsTec(String dofObsTec) {
		this.dofObsTec = dofObsTec;
	}

	@Column(name = "DOF_OBS_TEC_DMP", length = 500)
	public String getDofObsTecDmp() {
		return this.dofObsTecDmp;
	}

	public void setDofObsTecDmp(String dofObsTecDmp) {
		this.dofObsTecDmp = dofObsTecDmp;
	}

	@Column(name = "DOF_OBS_TEC_BAI", length = 500)
	public String getDofObsTecBai() {
		return this.dofObsTecBai;
	}

	public void setDofObsTecBai(String dofObsTecBai) {
		this.dofObsTecBai = dofObsTecBai;
	}

	@Column(name = "DOF_NOT_ADM", precision = 3, scale = 0)
	public Short getDofNotAdm() {
		return this.dofNotAdm;
	}

	public void setDofNotAdm(Short dofNotAdm) {
		this.dofNotAdm = dofNotAdm;
	}

	@Column(name = "DOF_NOT_TEC", precision = 3, scale = 0)
	public Short getDofNotTec() {
		return this.dofNotTec;
	}

	public void setDofNotTec(Short dofNotTec) {
		this.dofNotTec = dofNotTec;
	}

	@Column(name = "DOF_NOT_FIN", precision = 3, scale = 0)
	public Short getDofNotFin() {
		return this.dofNotFin;
	}

	public void setDofNotFin(Short dofNotFin) {
		this.dofNotFin = dofNotFin;
	}

	@Column(name = "DOF_NOT_FIN2", precision = 3, scale = 0)
	public Short getDofNotFin2() {
		return this.dofNotFin2;
	}

	public void setDofNotFin2(Short dofNotFin2) {
		this.dofNotFin2 = dofNotFin2;
	}

	@Column(name = "DOF_NOT_ADM_DMP", precision = 3, scale = 0)
	public Short getDofNotAdmDmp() {
		return this.dofNotAdmDmp;
	}

	public void setDofNotAdmDmp(Short dofNotAdmDmp) {
		this.dofNotAdmDmp = dofNotAdmDmp;
	}

	@Column(name = "DOF_NOT_TEC_DMP", precision = 3, scale = 0)
	public Short getDofNotTecDmp() {
		return this.dofNotTecDmp;
	}

	public void setDofNotTecDmp(Short dofNotTecDmp) {
		this.dofNotTecDmp = dofNotTecDmp;
	}

	@Column(name = "DOF_NOT_FIN_DMP", precision = 3, scale = 0)
	public Short getDofNotFinDmp() {
		return this.dofNotFinDmp;
	}

	public void setDofNotFinDmp(Short dofNotFinDmp) {
		this.dofNotFinDmp = dofNotFinDmp;
	}

	@Column(name = "DOF_NOT_FIN2_DMP", precision = 3, scale = 0)
	public Short getDofNotFin2Dmp() {
		return this.dofNotFin2Dmp;
	}

	public void setDofNotFin2Dmp(Short dofNotFin2Dmp) {
		this.dofNotFin2Dmp = dofNotFin2Dmp;
	}

	@Column(name = "DOF_NOT_ADM_BAI", precision = 3, scale = 0)
	public Short getDofNotAdmBai() {
		return this.dofNotAdmBai;
	}

	public void setDofNotAdmBai(Short dofNotAdmBai) {
		this.dofNotAdmBai = dofNotAdmBai;
	}

	@Column(name = "DOF_NOT_TEC_BAI", length = 240)
	public String getDofNotTecBai() {
		return this.dofNotTecBai;
	}

	public void setDofNotTecBai(String dofNotTecBai) {
		this.dofNotTecBai = dofNotTecBai;
	}

	@Column(name = "DOF_NOT_FIN_BAI", precision = 3, scale = 0)
	public Short getDofNotFinBai() {
		return this.dofNotFinBai;
	}

	public void setDofNotFinBai(Short dofNotFinBai) {
		this.dofNotFinBai = dofNotFinBai;
	}

	@Column(name = "DOF_NOT_FIN2_BAI", precision = 3, scale = 0)
	public Short getDofNotFin2Bai() {
		return this.dofNotFin2Bai;
	}

	public void setDofNotFin2Bai(Short dofNotFin2Bai) {
		this.dofNotFin2Bai = dofNotFin2Bai;
	}

	@Column(name = "DOF_MT_ATT_DMP", precision = 20, scale = 0)
	public BigDecimal getDofMtAttDmp() {
		return this.dofMtAttDmp;
	}

	public void setDofMtAttDmp(BigDecimal dofMtAttDmp) {
		this.dofMtAttDmp = dofMtAttDmp;
	}

	@Column(name = "DOF_MT_ATT_BAI", precision = 20, scale = 0)
	public BigDecimal getDofMtAttBai() {
		return this.dofMtAttBai;
	}

	public void setDofMtAttBai(BigDecimal dofMtAttBai) {
		this.dofMtAttBai = dofMtAttBai;
	}

	@Column(name = "DOF_RANG_OFR_DMP", precision = 10, scale = 0)
	public Long getDofRangOfrDmp() {
		return this.dofRangOfrDmp;
	}

	public void setDofRangOfrDmp(Long dofRangOfrDmp) {
		this.dofRangOfrDmp = dofRangOfrDmp;
	}

	@Column(name = "DOF_MT_COR_DMP", precision = 20, scale = 0)
	public BigDecimal getDofMtCorDmp() {
		return this.dofMtCorDmp;
	}

	public void setDofMtCorDmp(BigDecimal dofMtCorDmp) {
		this.dofMtCorDmp = dofMtCorDmp;
	}

	@Column(name = "DOF_RECEVABL_DMP", length = 1)
	public String getDofRecevablDmp() {
		return this.dofRecevablDmp;
	}

	public void setDofRecevablDmp(String dofRecevablDmp) {
		this.dofRecevablDmp = dofRecevablDmp;
	}

	@Column(name = "DOF_SCORE_DMP", precision = 3, scale = 0)
	public Short getDofScoreDmp() {
		return this.dofScoreDmp;
	}

	public void setDofScoreDmp(Short dofScoreDmp) {
		this.dofScoreDmp = dofScoreDmp;
	}

	@Column(name = "DOF_RANG_OFR_BAI", precision = 10, scale = 0)
	public Long getDofRangOfrBai() {
		return this.dofRangOfrBai;
	}

	public void setDofRangOfrBai(Long dofRangOfrBai) {
		this.dofRangOfrBai = dofRangOfrBai;
	}

	@Column(name = "DOF_MT_COR_BAI", precision = 20, scale = 0)
	public BigDecimal getDofMtCorBai() {
		return this.dofMtCorBai;
	}

	public void setDofMtCorBai(BigDecimal dofMtCorBai) {
		this.dofMtCorBai = dofMtCorBai;
	}

	@Column(name = "DOF_RECEVABL_BAI", length = 1)
	public String getDofRecevablBai() {
		return this.dofRecevablBai;
	}

	public void setDofRecevablBai(String dofRecevablBai) {
		this.dofRecevablBai = dofRecevablBai;
	}

	@Column(name = "DOF_SCORE_BAI", precision = 3, scale = 0)
	public Short getDofScoreBai() {
		return this.dofScoreBai;
	}

	public void setDofScoreBai(Short dofScoreBai) {
		this.dofScoreBai = dofScoreBai;
	}

	@Column(name = "DOF_NOM_SIGN", length = 200)
	public String getDofNomSign() {
		return this.dofNomSign;
	}

	public void setDofNomSign(String dofNomSign) {
		this.dofNomSign = dofNomSign;
	}

	@Column(name = "DOF_FONCT_SIGN", length = 100)
	public String getDofFonctSign() {
		return this.dofFonctSign;
	}

	public void setDofFonctSign(String dofFonctSign) {
		this.dofFonctSign = dofFonctSign;
	}

	@Column(name = "DOF_TEL_SIGN", length = 50)
	public String getDofTelSign() {
		return this.dofTelSign;
	}

	public void setDofTelSign(String dofTelSign) {
		this.dofTelSign = dofTelSign;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DOF_DTE_SAISI", length = 7)
	public Date getDofDteSaisi() {
		return this.dofDteSaisi;
	}

	public void setDofDteSaisi(Date dofDteSaisi) {
		this.dofDteSaisi = dofDteSaisi;
	}

	@Column(name = "DOF_STATUT", length = 1)
	public String getDofStatut() {
		return this.dofStatut;
	}

	public void setDofStatut(String dofStatut) {
		this.dofStatut = dofStatut;
	}

	@Column(name = "DOF_SOU_NCC", length = 500)
	public String getDofSouNcc() {
		return this.dofSouNcc;
	}

	public void setDofSouNcc(String dofSouNcc) {
		this.dofSouNcc = dofSouNcc;
	}

	@Column(name = "DOF_SIGLE", length = 500)
	public String getDofSigle() {
		return this.dofSigle;
	}

	public void setDofSigle(String dofSigle) {
		this.dofSigle = dofSigle;
	}

	@Column(name = "DOF_ERR_FIN", length = 500)
	public String getDofErrFin() {
		return this.dofErrFin;
	}

	public void setDofErrFin(String dofErrFin) {
		this.dofErrFin = dofErrFin;
	}

	@Column(name = "DOF_OBS_FIN", length = 500)
	public String getDofObsFin() {
		return this.dofObsFin;
	}

	public void setDofObsFin(String dofObsFin) {
		this.dofObsFin = dofObsFin;
	}

	@Column(name = "DOF_REPECHE", length = 1)
	public String getDofRepeche() {
		return this.dofRepeche;
	}

	public void setDofRepeche(String dofRepeche) {
		this.dofRepeche = dofRepeche;
	}

	@Column(name = "DOF_OBS_RET", length = 500)
	public String getDofObsRet() {
		return this.dofObsRet;
	}

	public void setDofObsRet(String dofObsRet) {
		this.dofObsRet = dofObsRet;
	}

	@Column(name = "DOF_OBS_ANORMAL", length = 500)
	public String getDofObsAnormal() {
		return this.dofObsAnormal;
	}

	public void setDofObsAnormal(String dofObsAnormal) {
		this.dofObsAnormal = dofObsAnormal;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TDetOffres")
	public Set<TAnalyseOffre> getTAnalyseOffres() {
		return this.TAnalyseOffres;
	}

	public void setTAnalyseOffres(Set<TAnalyseOffre> TAnalyseOffres) {
		this.TAnalyseOffres = TAnalyseOffres;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TDetOffres")
	public Set<TPiecesOffres> getTPiecesOffreses() {
		return this.TPiecesOffreses;
	}

	public void setTPiecesOffreses(Set<TPiecesOffres> TPiecesOffreses) {
		this.TPiecesOffreses = TPiecesOffreses;
	}

}
