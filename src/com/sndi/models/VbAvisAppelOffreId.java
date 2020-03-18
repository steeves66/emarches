package com.sndi.models;
// Generated 14 mars 2020 14:41:40 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VbAvisAppelOffreId generated by hbm2java
 */
@Embeddable
public class VbAvisAppelOffreId implements java.io.Serializable {

	private String aaoCode;
	private String aaoLibelle;
	private String aaoDacCode;
	private Date aaoDteSaisi;
	private String aaoStaCode;
	private Date aaoDtePub;
	private Date aaoDteOuvTec;
	private Date aaoDteHeurOuv;
	private Date aaoDteOuvFin;
	private BigDecimal aaoNbrLot;
	private BigDecimal aaoNbrOuv;
	private BigDecimal aaoDelaiVal;
	private String aaoFonCodAc;
	private String aaoFonCodeCpmp;
	private String aaoNatInt;
	private String aaoTaux;
	private String aaoLieuExe;
	private String aaoNomResp;
	private String aaoInterPub;
	private String aaoCautDefExig;
	private String aaoBompPub;
	private String aaoVenteParLot;
	private String aaoAvisBail;
	private BigDecimal aaoMtCaut;
	private String aaoModePaiement;
	private BigDecimal aaoCoutDac;
	private String aaoLieuRecep;
	private Date aaoDateRecep;
	private Date aaoHeureRecep;
	private BigDecimal aaoAdaNum;
	private String aaoNatPrix;
	private String aaoRegQual;
	private String aaoAvisBai;
	private String aaoRespBai;
	private String aaoPrecisModEval;
	private Date aaoDteValAc;
	private Date aaoDteValCpmp;
	private Date aaoDteValDmp;
	private Short aaoNbrOff;
	private Short aaoNbrOffAccpet;
	private Short aaoNbrOffRej;
	private Short aaoNbrOffHorDelai;

	public VbAvisAppelOffreId() {
	}

	public VbAvisAppelOffreId(String aaoCode) {
		this.aaoCode = aaoCode;
	}

	public VbAvisAppelOffreId(String aaoCode, String aaoLibelle, String aaoDacCode, Date aaoDteSaisi, String aaoStaCode,
			Date aaoDtePub, Date aaoDteOuvTec, Date aaoDteHeurOuv, Date aaoDteOuvFin, BigDecimal aaoNbrLot,
			BigDecimal aaoNbrOuv, BigDecimal aaoDelaiVal, String aaoFonCodAc, String aaoFonCodeCpmp, String aaoNatInt,
			String aaoTaux, String aaoLieuExe, String aaoNomResp, String aaoInterPub, String aaoCautDefExig,
			String aaoBompPub, String aaoVenteParLot, String aaoAvisBail, BigDecimal aaoMtCaut, String aaoModePaiement,
			BigDecimal aaoCoutDac, String aaoLieuRecep, Date aaoDateRecep, Date aaoHeureRecep, BigDecimal aaoAdaNum,
			String aaoNatPrix, String aaoRegQual, String aaoAvisBai, String aaoRespBai, String aaoPrecisModEval,
			Date aaoDteValAc, Date aaoDteValCpmp, Date aaoDteValDmp, Short aaoNbrOff, Short aaoNbrOffAccpet,
			Short aaoNbrOffRej, Short aaoNbrOffHorDelai) {
		this.aaoCode = aaoCode;
		this.aaoLibelle = aaoLibelle;
		this.aaoDacCode = aaoDacCode;
		this.aaoDteSaisi = aaoDteSaisi;
		this.aaoStaCode = aaoStaCode;
		this.aaoDtePub = aaoDtePub;
		this.aaoDteOuvTec = aaoDteOuvTec;
		this.aaoDteHeurOuv = aaoDteHeurOuv;
		this.aaoDteOuvFin = aaoDteOuvFin;
		this.aaoNbrLot = aaoNbrLot;
		this.aaoNbrOuv = aaoNbrOuv;
		this.aaoDelaiVal = aaoDelaiVal;
		this.aaoFonCodAc = aaoFonCodAc;
		this.aaoFonCodeCpmp = aaoFonCodeCpmp;
		this.aaoNatInt = aaoNatInt;
		this.aaoTaux = aaoTaux;
		this.aaoLieuExe = aaoLieuExe;
		this.aaoNomResp = aaoNomResp;
		this.aaoInterPub = aaoInterPub;
		this.aaoCautDefExig = aaoCautDefExig;
		this.aaoBompPub = aaoBompPub;
		this.aaoVenteParLot = aaoVenteParLot;
		this.aaoAvisBail = aaoAvisBail;
		this.aaoMtCaut = aaoMtCaut;
		this.aaoModePaiement = aaoModePaiement;
		this.aaoCoutDac = aaoCoutDac;
		this.aaoLieuRecep = aaoLieuRecep;
		this.aaoDateRecep = aaoDateRecep;
		this.aaoHeureRecep = aaoHeureRecep;
		this.aaoAdaNum = aaoAdaNum;
		this.aaoNatPrix = aaoNatPrix;
		this.aaoRegQual = aaoRegQual;
		this.aaoAvisBai = aaoAvisBai;
		this.aaoRespBai = aaoRespBai;
		this.aaoPrecisModEval = aaoPrecisModEval;
		this.aaoDteValAc = aaoDteValAc;
		this.aaoDteValCpmp = aaoDteValCpmp;
		this.aaoDteValDmp = aaoDteValDmp;
		this.aaoNbrOff = aaoNbrOff;
		this.aaoNbrOffAccpet = aaoNbrOffAccpet;
		this.aaoNbrOffRej = aaoNbrOffRej;
		this.aaoNbrOffHorDelai = aaoNbrOffHorDelai;
	}

	@Column(name = "AAO_CODE", nullable = false, length = 20)
	public String getAaoCode() {
		return this.aaoCode;
	}

	public void setAaoCode(String aaoCode) {
		this.aaoCode = aaoCode;
	}

	@Column(name = "AAO_LIBELLE", length = 1000)
	public String getAaoLibelle() {
		return this.aaoLibelle;
	}

	public void setAaoLibelle(String aaoLibelle) {
		this.aaoLibelle = aaoLibelle;
	}

	@Column(name = "AAO_DAC_CODE", length = 20)
	public String getAaoDacCode() {
		return this.aaoDacCode;
	}

	public void setAaoDacCode(String aaoDacCode) {
		this.aaoDacCode = aaoDacCode;
	}

	@Column(name = "AAO_DTE_SAISI", length = 7)
	public Date getAaoDteSaisi() {
		return this.aaoDteSaisi;
	}

	public void setAaoDteSaisi(Date aaoDteSaisi) {
		this.aaoDteSaisi = aaoDteSaisi;
	}

	@Column(name = "AAO_STA_CODE", length = 3)
	public String getAaoStaCode() {
		return this.aaoStaCode;
	}

	public void setAaoStaCode(String aaoStaCode) {
		this.aaoStaCode = aaoStaCode;
	}

	@Column(name = "AAO_DTE_PUB", length = 7)
	public Date getAaoDtePub() {
		return this.aaoDtePub;
	}

	public void setAaoDtePub(Date aaoDtePub) {
		this.aaoDtePub = aaoDtePub;
	}

	@Column(name = "AAO_DTE_OUV_TEC", length = 7)
	public Date getAaoDteOuvTec() {
		return this.aaoDteOuvTec;
	}

	public void setAaoDteOuvTec(Date aaoDteOuvTec) {
		this.aaoDteOuvTec = aaoDteOuvTec;
	}

	@Column(name = "AAO_DTE_HEUR_OUV", length = 7)
	public Date getAaoDteHeurOuv() {
		return this.aaoDteHeurOuv;
	}

	public void setAaoDteHeurOuv(Date aaoDteHeurOuv) {
		this.aaoDteHeurOuv = aaoDteHeurOuv;
	}

	@Column(name = "AAO_DTE_OUV_FIN", length = 7)
	public Date getAaoDteOuvFin() {
		return this.aaoDteOuvFin;
	}

	public void setAaoDteOuvFin(Date aaoDteOuvFin) {
		this.aaoDteOuvFin = aaoDteOuvFin;
	}

	@Column(name = "AAO_NBR_LOT", precision = 22, scale = 0)
	public BigDecimal getAaoNbrLot() {
		return this.aaoNbrLot;
	}

	public void setAaoNbrLot(BigDecimal aaoNbrLot) {
		this.aaoNbrLot = aaoNbrLot;
	}

	@Column(name = "AAO_NBR_OUV", precision = 22, scale = 0)
	public BigDecimal getAaoNbrOuv() {
		return this.aaoNbrOuv;
	}

	public void setAaoNbrOuv(BigDecimal aaoNbrOuv) {
		this.aaoNbrOuv = aaoNbrOuv;
	}

	@Column(name = "AAO_DELAI_VAL", precision = 22, scale = 0)
	public BigDecimal getAaoDelaiVal() {
		return this.aaoDelaiVal;
	}

	public void setAaoDelaiVal(BigDecimal aaoDelaiVal) {
		this.aaoDelaiVal = aaoDelaiVal;
	}

	@Column(name = "AAO_FON_COD_AC", length = 12)
	public String getAaoFonCodAc() {
		return this.aaoFonCodAc;
	}

	public void setAaoFonCodAc(String aaoFonCodAc) {
		this.aaoFonCodAc = aaoFonCodAc;
	}

	@Column(name = "AAO_FON_CODE_CPMP", length = 12)
	public String getAaoFonCodeCpmp() {
		return this.aaoFonCodeCpmp;
	}

	public void setAaoFonCodeCpmp(String aaoFonCodeCpmp) {
		this.aaoFonCodeCpmp = aaoFonCodeCpmp;
	}

	@Column(name = "AAO_NAT_INT", length = 1)
	public String getAaoNatInt() {
		return this.aaoNatInt;
	}

	public void setAaoNatInt(String aaoNatInt) {
		this.aaoNatInt = aaoNatInt;
	}

	@Column(name = "AAO_TAUX", length = 3)
	public String getAaoTaux() {
		return this.aaoTaux;
	}

	public void setAaoTaux(String aaoTaux) {
		this.aaoTaux = aaoTaux;
	}

	@Column(name = "AAO_LIEU_EXE", length = 200)
	public String getAaoLieuExe() {
		return this.aaoLieuExe;
	}

	public void setAaoLieuExe(String aaoLieuExe) {
		this.aaoLieuExe = aaoLieuExe;
	}

	@Column(name = "AAO_NOM_RESP", length = 200)
	public String getAaoNomResp() {
		return this.aaoNomResp;
	}

	public void setAaoNomResp(String aaoNomResp) {
		this.aaoNomResp = aaoNomResp;
	}

	@Column(name = "AAO_INTER_PUB", length = 1)
	public String getAaoInterPub() {
		return this.aaoInterPub;
	}

	public void setAaoInterPub(String aaoInterPub) {
		this.aaoInterPub = aaoInterPub;
	}

	@Column(name = "AAO_CAUT_DEF_EXIG", length = 1)
	public String getAaoCautDefExig() {
		return this.aaoCautDefExig;
	}

	public void setAaoCautDefExig(String aaoCautDefExig) {
		this.aaoCautDefExig = aaoCautDefExig;
	}

	@Column(name = "AAO_BOMP_PUB", length = 1)
	public String getAaoBompPub() {
		return this.aaoBompPub;
	}

	public void setAaoBompPub(String aaoBompPub) {
		this.aaoBompPub = aaoBompPub;
	}

	@Column(name = "AAO_VENTE_PAR_LOT", length = 1)
	public String getAaoVenteParLot() {
		return this.aaoVenteParLot;
	}

	public void setAaoVenteParLot(String aaoVenteParLot) {
		this.aaoVenteParLot = aaoVenteParLot;
	}

	@Column(name = "AAO_AVIS_BAIL", length = 1)
	public String getAaoAvisBail() {
		return this.aaoAvisBail;
	}

	public void setAaoAvisBail(String aaoAvisBail) {
		this.aaoAvisBail = aaoAvisBail;
	}

	@Column(name = "AAO_MT_CAUT", precision = 22, scale = 0)
	public BigDecimal getAaoMtCaut() {
		return this.aaoMtCaut;
	}

	public void setAaoMtCaut(BigDecimal aaoMtCaut) {
		this.aaoMtCaut = aaoMtCaut;
	}

	@Column(name = "AAO_MODE_PAIEMENT", length = 20)
	public String getAaoModePaiement() {
		return this.aaoModePaiement;
	}

	public void setAaoModePaiement(String aaoModePaiement) {
		this.aaoModePaiement = aaoModePaiement;
	}

	@Column(name = "AAO_COUT_DAC", precision = 22, scale = 0)
	public BigDecimal getAaoCoutDac() {
		return this.aaoCoutDac;
	}

	public void setAaoCoutDac(BigDecimal aaoCoutDac) {
		this.aaoCoutDac = aaoCoutDac;
	}

	@Column(name = "AAO_LIEU_RECEP", length = 1000)
	public String getAaoLieuRecep() {
		return this.aaoLieuRecep;
	}

	public void setAaoLieuRecep(String aaoLieuRecep) {
		this.aaoLieuRecep = aaoLieuRecep;
	}

	@Column(name = "AAO_DATE_RECEP", length = 7)
	public Date getAaoDateRecep() {
		return this.aaoDateRecep;
	}

	public void setAaoDateRecep(Date aaoDateRecep) {
		this.aaoDateRecep = aaoDateRecep;
	}

	@Column(name = "AAO_HEURE_RECEP", length = 7)
	public Date getAaoHeureRecep() {
		return this.aaoHeureRecep;
	}

	public void setAaoHeureRecep(Date aaoHeureRecep) {
		this.aaoHeureRecep = aaoHeureRecep;
	}

	@Column(name = "AAO_ADA_NUM", precision = 22, scale = 0)
	public BigDecimal getAaoAdaNum() {
		return this.aaoAdaNum;
	}

	public void setAaoAdaNum(BigDecimal aaoAdaNum) {
		this.aaoAdaNum = aaoAdaNum;
	}

	@Column(name = "AAO_NAT_PRIX", length = 20)
	public String getAaoNatPrix() {
		return this.aaoNatPrix;
	}

	public void setAaoNatPrix(String aaoNatPrix) {
		this.aaoNatPrix = aaoNatPrix;
	}

	@Column(name = "AAO_REG_QUAL", length = 100)
	public String getAaoRegQual() {
		return this.aaoRegQual;
	}

	public void setAaoRegQual(String aaoRegQual) {
		this.aaoRegQual = aaoRegQual;
	}

	@Column(name = "AAO_AVIS_BAI", length = 1)
	public String getAaoAvisBai() {
		return this.aaoAvisBai;
	}

	public void setAaoAvisBai(String aaoAvisBai) {
		this.aaoAvisBai = aaoAvisBai;
	}

	@Column(name = "AAO_RESP_BAI", length = 200)
	public String getAaoRespBai() {
		return this.aaoRespBai;
	}

	public void setAaoRespBai(String aaoRespBai) {
		this.aaoRespBai = aaoRespBai;
	}

	@Column(name = "AAO_PRECIS_MOD_EVAL", length = 200)
	public String getAaoPrecisModEval() {
		return this.aaoPrecisModEval;
	}

	public void setAaoPrecisModEval(String aaoPrecisModEval) {
		this.aaoPrecisModEval = aaoPrecisModEval;
	}

	@Column(name = "AAO_DTE_VAL_AC", length = 7)
	public Date getAaoDteValAc() {
		return this.aaoDteValAc;
	}

	public void setAaoDteValAc(Date aaoDteValAc) {
		this.aaoDteValAc = aaoDteValAc;
	}

	@Column(name = "AAO_DTE_VAL_CPMP", length = 7)
	public Date getAaoDteValCpmp() {
		return this.aaoDteValCpmp;
	}

	public void setAaoDteValCpmp(Date aaoDteValCpmp) {
		this.aaoDteValCpmp = aaoDteValCpmp;
	}

	@Column(name = "AAO_DTE_VAL_DMP", length = 7)
	public Date getAaoDteValDmp() {
		return this.aaoDteValDmp;
	}

	public void setAaoDteValDmp(Date aaoDteValDmp) {
		this.aaoDteValDmp = aaoDteValDmp;
	}

	@Column(name = "AAO_NBR_OFF", precision = 4, scale = 0)
	public Short getAaoNbrOff() {
		return this.aaoNbrOff;
	}

	public void setAaoNbrOff(Short aaoNbrOff) {
		this.aaoNbrOff = aaoNbrOff;
	}

	@Column(name = "AAO_NBR_OFF_ACCPET", precision = 4, scale = 0)
	public Short getAaoNbrOffAccpet() {
		return this.aaoNbrOffAccpet;
	}

	public void setAaoNbrOffAccpet(Short aaoNbrOffAccpet) {
		this.aaoNbrOffAccpet = aaoNbrOffAccpet;
	}

	@Column(name = "AAO_NBR_OFF_REJ", precision = 4, scale = 0)
	public Short getAaoNbrOffRej() {
		return this.aaoNbrOffRej;
	}

	public void setAaoNbrOffRej(Short aaoNbrOffRej) {
		this.aaoNbrOffRej = aaoNbrOffRej;
	}

	@Column(name = "AAO_NBR_OFF_HOR_DELAI", precision = 4, scale = 0)
	public Short getAaoNbrOffHorDelai() {
		return this.aaoNbrOffHorDelai;
	}

	public void setAaoNbrOffHorDelai(Short aaoNbrOffHorDelai) {
		this.aaoNbrOffHorDelai = aaoNbrOffHorDelai;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VbAvisAppelOffreId))
			return false;
		VbAvisAppelOffreId castOther = (VbAvisAppelOffreId) other;

		return ((this.getAaoCode() == castOther.getAaoCode()) || (this.getAaoCode() != null
				&& castOther.getAaoCode() != null && this.getAaoCode().equals(castOther.getAaoCode())))
				&& ((this.getAaoLibelle() == castOther.getAaoLibelle()) || (this.getAaoLibelle() != null
						&& castOther.getAaoLibelle() != null && this.getAaoLibelle().equals(castOther.getAaoLibelle())))
				&& ((this.getAaoDacCode() == castOther.getAaoDacCode()) || (this.getAaoDacCode() != null
						&& castOther.getAaoDacCode() != null && this.getAaoDacCode().equals(castOther.getAaoDacCode())))
				&& ((this.getAaoDteSaisi() == castOther.getAaoDteSaisi())
						|| (this.getAaoDteSaisi() != null && castOther.getAaoDteSaisi() != null
								&& this.getAaoDteSaisi().equals(castOther.getAaoDteSaisi())))
				&& ((this.getAaoStaCode() == castOther.getAaoStaCode()) || (this.getAaoStaCode() != null
						&& castOther.getAaoStaCode() != null && this.getAaoStaCode().equals(castOther.getAaoStaCode())))
				&& ((this.getAaoDtePub() == castOther.getAaoDtePub()) || (this.getAaoDtePub() != null
						&& castOther.getAaoDtePub() != null && this.getAaoDtePub().equals(castOther.getAaoDtePub())))
				&& ((this.getAaoDteOuvTec() == castOther.getAaoDteOuvTec())
						|| (this.getAaoDteOuvTec() != null && castOther.getAaoDteOuvTec() != null
								&& this.getAaoDteOuvTec().equals(castOther.getAaoDteOuvTec())))
				&& ((this.getAaoDteHeurOuv() == castOther.getAaoDteHeurOuv())
						|| (this.getAaoDteHeurOuv() != null && castOther.getAaoDteHeurOuv() != null
								&& this.getAaoDteHeurOuv().equals(castOther.getAaoDteHeurOuv())))
				&& ((this.getAaoDteOuvFin() == castOther.getAaoDteOuvFin())
						|| (this.getAaoDteOuvFin() != null && castOther.getAaoDteOuvFin() != null
								&& this.getAaoDteOuvFin().equals(castOther.getAaoDteOuvFin())))
				&& ((this.getAaoNbrLot() == castOther.getAaoNbrLot()) || (this.getAaoNbrLot() != null
						&& castOther.getAaoNbrLot() != null && this.getAaoNbrLot().equals(castOther.getAaoNbrLot())))
				&& ((this.getAaoNbrOuv() == castOther.getAaoNbrOuv()) || (this.getAaoNbrOuv() != null
						&& castOther.getAaoNbrOuv() != null && this.getAaoNbrOuv().equals(castOther.getAaoNbrOuv())))
				&& ((this.getAaoDelaiVal() == castOther.getAaoDelaiVal())
						|| (this.getAaoDelaiVal() != null && castOther.getAaoDelaiVal() != null
								&& this.getAaoDelaiVal().equals(castOther.getAaoDelaiVal())))
				&& ((this.getAaoFonCodAc() == castOther.getAaoFonCodAc())
						|| (this.getAaoFonCodAc() != null && castOther.getAaoFonCodAc() != null
								&& this.getAaoFonCodAc().equals(castOther.getAaoFonCodAc())))
				&& ((this.getAaoFonCodeCpmp() == castOther.getAaoFonCodeCpmp())
						|| (this.getAaoFonCodeCpmp() != null && castOther.getAaoFonCodeCpmp() != null
								&& this.getAaoFonCodeCpmp().equals(castOther.getAaoFonCodeCpmp())))
				&& ((this.getAaoNatInt() == castOther.getAaoNatInt()) || (this.getAaoNatInt() != null
						&& castOther.getAaoNatInt() != null && this.getAaoNatInt().equals(castOther.getAaoNatInt())))
				&& ((this.getAaoTaux() == castOther.getAaoTaux()) || (this.getAaoTaux() != null
						&& castOther.getAaoTaux() != null && this.getAaoTaux().equals(castOther.getAaoTaux())))
				&& ((this.getAaoLieuExe() == castOther.getAaoLieuExe()) || (this.getAaoLieuExe() != null
						&& castOther.getAaoLieuExe() != null && this.getAaoLieuExe().equals(castOther.getAaoLieuExe())))
				&& ((this.getAaoNomResp() == castOther.getAaoNomResp()) || (this.getAaoNomResp() != null
						&& castOther.getAaoNomResp() != null && this.getAaoNomResp().equals(castOther.getAaoNomResp())))
				&& ((this.getAaoInterPub() == castOther.getAaoInterPub())
						|| (this.getAaoInterPub() != null && castOther.getAaoInterPub() != null
								&& this.getAaoInterPub().equals(castOther.getAaoInterPub())))
				&& ((this.getAaoCautDefExig() == castOther.getAaoCautDefExig())
						|| (this.getAaoCautDefExig() != null && castOther.getAaoCautDefExig() != null
								&& this.getAaoCautDefExig().equals(castOther.getAaoCautDefExig())))
				&& ((this.getAaoBompPub() == castOther.getAaoBompPub()) || (this.getAaoBompPub() != null
						&& castOther.getAaoBompPub() != null && this.getAaoBompPub().equals(castOther.getAaoBompPub())))
				&& ((this.getAaoVenteParLot() == castOther.getAaoVenteParLot())
						|| (this.getAaoVenteParLot() != null && castOther.getAaoVenteParLot() != null
								&& this.getAaoVenteParLot().equals(castOther.getAaoVenteParLot())))
				&& ((this.getAaoAvisBail() == castOther.getAaoAvisBail())
						|| (this.getAaoAvisBail() != null && castOther.getAaoAvisBail() != null
								&& this.getAaoAvisBail().equals(castOther.getAaoAvisBail())))
				&& ((this.getAaoMtCaut() == castOther.getAaoMtCaut()) || (this.getAaoMtCaut() != null
						&& castOther.getAaoMtCaut() != null && this.getAaoMtCaut().equals(castOther.getAaoMtCaut())))
				&& ((this.getAaoModePaiement() == castOther.getAaoModePaiement())
						|| (this.getAaoModePaiement() != null && castOther.getAaoModePaiement() != null
								&& this.getAaoModePaiement().equals(castOther.getAaoModePaiement())))
				&& ((this.getAaoCoutDac() == castOther.getAaoCoutDac()) || (this.getAaoCoutDac() != null
						&& castOther.getAaoCoutDac() != null && this.getAaoCoutDac().equals(castOther.getAaoCoutDac())))
				&& ((this.getAaoLieuRecep() == castOther.getAaoLieuRecep())
						|| (this.getAaoLieuRecep() != null && castOther.getAaoLieuRecep() != null
								&& this.getAaoLieuRecep().equals(castOther.getAaoLieuRecep())))
				&& ((this.getAaoDateRecep() == castOther.getAaoDateRecep())
						|| (this.getAaoDateRecep() != null && castOther.getAaoDateRecep() != null
								&& this.getAaoDateRecep().equals(castOther.getAaoDateRecep())))
				&& ((this.getAaoHeureRecep() == castOther.getAaoHeureRecep())
						|| (this.getAaoHeureRecep() != null && castOther.getAaoHeureRecep() != null
								&& this.getAaoHeureRecep().equals(castOther.getAaoHeureRecep())))
				&& ((this.getAaoAdaNum() == castOther.getAaoAdaNum()) || (this.getAaoAdaNum() != null
						&& castOther.getAaoAdaNum() != null && this.getAaoAdaNum().equals(castOther.getAaoAdaNum())))
				&& ((this.getAaoNatPrix() == castOther.getAaoNatPrix()) || (this.getAaoNatPrix() != null
						&& castOther.getAaoNatPrix() != null && this.getAaoNatPrix().equals(castOther.getAaoNatPrix())))
				&& ((this.getAaoRegQual() == castOther.getAaoRegQual()) || (this.getAaoRegQual() != null
						&& castOther.getAaoRegQual() != null && this.getAaoRegQual().equals(castOther.getAaoRegQual())))
				&& ((this.getAaoAvisBai() == castOther.getAaoAvisBai()) || (this.getAaoAvisBai() != null
						&& castOther.getAaoAvisBai() != null && this.getAaoAvisBai().equals(castOther.getAaoAvisBai())))
				&& ((this.getAaoRespBai() == castOther.getAaoRespBai()) || (this.getAaoRespBai() != null
						&& castOther.getAaoRespBai() != null && this.getAaoRespBai().equals(castOther.getAaoRespBai())))
				&& ((this.getAaoPrecisModEval() == castOther.getAaoPrecisModEval())
						|| (this.getAaoPrecisModEval() != null && castOther.getAaoPrecisModEval() != null
								&& this.getAaoPrecisModEval().equals(castOther.getAaoPrecisModEval())))
				&& ((this.getAaoDteValAc() == castOther.getAaoDteValAc())
						|| (this.getAaoDteValAc() != null && castOther.getAaoDteValAc() != null
								&& this.getAaoDteValAc().equals(castOther.getAaoDteValAc())))
				&& ((this.getAaoDteValCpmp() == castOther.getAaoDteValCpmp())
						|| (this.getAaoDteValCpmp() != null && castOther.getAaoDteValCpmp() != null
								&& this.getAaoDteValCpmp().equals(castOther.getAaoDteValCpmp())))
				&& ((this.getAaoDteValDmp() == castOther.getAaoDteValDmp())
						|| (this.getAaoDteValDmp() != null && castOther.getAaoDteValDmp() != null
								&& this.getAaoDteValDmp().equals(castOther.getAaoDteValDmp())))
				&& ((this.getAaoNbrOff() == castOther.getAaoNbrOff()) || (this.getAaoNbrOff() != null
						&& castOther.getAaoNbrOff() != null && this.getAaoNbrOff().equals(castOther.getAaoNbrOff())))
				&& ((this.getAaoNbrOffAccpet() == castOther.getAaoNbrOffAccpet())
						|| (this.getAaoNbrOffAccpet() != null && castOther.getAaoNbrOffAccpet() != null
								&& this.getAaoNbrOffAccpet().equals(castOther.getAaoNbrOffAccpet())))
				&& ((this.getAaoNbrOffRej() == castOther.getAaoNbrOffRej())
						|| (this.getAaoNbrOffRej() != null && castOther.getAaoNbrOffRej() != null
								&& this.getAaoNbrOffRej().equals(castOther.getAaoNbrOffRej())))
				&& ((this.getAaoNbrOffHorDelai() == castOther.getAaoNbrOffHorDelai())
						|| (this.getAaoNbrOffHorDelai() != null && castOther.getAaoNbrOffHorDelai() != null
								&& this.getAaoNbrOffHorDelai().equals(castOther.getAaoNbrOffHorDelai())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getAaoCode() == null ? 0 : this.getAaoCode().hashCode());
		result = 37 * result + (getAaoLibelle() == null ? 0 : this.getAaoLibelle().hashCode());
		result = 37 * result + (getAaoDacCode() == null ? 0 : this.getAaoDacCode().hashCode());
		result = 37 * result + (getAaoDteSaisi() == null ? 0 : this.getAaoDteSaisi().hashCode());
		result = 37 * result + (getAaoStaCode() == null ? 0 : this.getAaoStaCode().hashCode());
		result = 37 * result + (getAaoDtePub() == null ? 0 : this.getAaoDtePub().hashCode());
		result = 37 * result + (getAaoDteOuvTec() == null ? 0 : this.getAaoDteOuvTec().hashCode());
		result = 37 * result + (getAaoDteHeurOuv() == null ? 0 : this.getAaoDteHeurOuv().hashCode());
		result = 37 * result + (getAaoDteOuvFin() == null ? 0 : this.getAaoDteOuvFin().hashCode());
		result = 37 * result + (getAaoNbrLot() == null ? 0 : this.getAaoNbrLot().hashCode());
		result = 37 * result + (getAaoNbrOuv() == null ? 0 : this.getAaoNbrOuv().hashCode());
		result = 37 * result + (getAaoDelaiVal() == null ? 0 : this.getAaoDelaiVal().hashCode());
		result = 37 * result + (getAaoFonCodAc() == null ? 0 : this.getAaoFonCodAc().hashCode());
		result = 37 * result + (getAaoFonCodeCpmp() == null ? 0 : this.getAaoFonCodeCpmp().hashCode());
		result = 37 * result + (getAaoNatInt() == null ? 0 : this.getAaoNatInt().hashCode());
		result = 37 * result + (getAaoTaux() == null ? 0 : this.getAaoTaux().hashCode());
		result = 37 * result + (getAaoLieuExe() == null ? 0 : this.getAaoLieuExe().hashCode());
		result = 37 * result + (getAaoNomResp() == null ? 0 : this.getAaoNomResp().hashCode());
		result = 37 * result + (getAaoInterPub() == null ? 0 : this.getAaoInterPub().hashCode());
		result = 37 * result + (getAaoCautDefExig() == null ? 0 : this.getAaoCautDefExig().hashCode());
		result = 37 * result + (getAaoBompPub() == null ? 0 : this.getAaoBompPub().hashCode());
		result = 37 * result + (getAaoVenteParLot() == null ? 0 : this.getAaoVenteParLot().hashCode());
		result = 37 * result + (getAaoAvisBail() == null ? 0 : this.getAaoAvisBail().hashCode());
		result = 37 * result + (getAaoMtCaut() == null ? 0 : this.getAaoMtCaut().hashCode());
		result = 37 * result + (getAaoModePaiement() == null ? 0 : this.getAaoModePaiement().hashCode());
		result = 37 * result + (getAaoCoutDac() == null ? 0 : this.getAaoCoutDac().hashCode());
		result = 37 * result + (getAaoLieuRecep() == null ? 0 : this.getAaoLieuRecep().hashCode());
		result = 37 * result + (getAaoDateRecep() == null ? 0 : this.getAaoDateRecep().hashCode());
		result = 37 * result + (getAaoHeureRecep() == null ? 0 : this.getAaoHeureRecep().hashCode());
		result = 37 * result + (getAaoAdaNum() == null ? 0 : this.getAaoAdaNum().hashCode());
		result = 37 * result + (getAaoNatPrix() == null ? 0 : this.getAaoNatPrix().hashCode());
		result = 37 * result + (getAaoRegQual() == null ? 0 : this.getAaoRegQual().hashCode());
		result = 37 * result + (getAaoAvisBai() == null ? 0 : this.getAaoAvisBai().hashCode());
		result = 37 * result + (getAaoRespBai() == null ? 0 : this.getAaoRespBai().hashCode());
		result = 37 * result + (getAaoPrecisModEval() == null ? 0 : this.getAaoPrecisModEval().hashCode());
		result = 37 * result + (getAaoDteValAc() == null ? 0 : this.getAaoDteValAc().hashCode());
		result = 37 * result + (getAaoDteValCpmp() == null ? 0 : this.getAaoDteValCpmp().hashCode());
		result = 37 * result + (getAaoDteValDmp() == null ? 0 : this.getAaoDteValDmp().hashCode());
		result = 37 * result + (getAaoNbrOff() == null ? 0 : this.getAaoNbrOff().hashCode());
		result = 37 * result + (getAaoNbrOffAccpet() == null ? 0 : this.getAaoNbrOffAccpet().hashCode());
		result = 37 * result + (getAaoNbrOffRej() == null ? 0 : this.getAaoNbrOffRej().hashCode());
		result = 37 * result + (getAaoNbrOffHorDelai() == null ? 0 : this.getAaoNbrOffHorDelai().hashCode());
		return result;
	}

}
