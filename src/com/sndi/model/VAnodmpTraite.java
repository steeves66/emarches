package com.sndi.model;
// Generated 25 ao�t 2021 14:59:49 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

/**
 * VAnodmpTraiteId generated by hbm2java
 */
@Entity
@Immutable
@Table(name = "V_ANODMP_TRAITE")
public class VAnodmpTraite implements java.io.Serializable {

	private String aaoCode;
	private String aaoDacCode;
	private String aaoLibelle;
	private BigDecimal aaoNbrLot;
	private BigDecimal demNum;
	private String demObjet;
	private String demMotif;
	private String demRef;
	private Date demDteSaisi;
	private String demStaCode;
	private BigDecimal aaoNbrOuv;
	private Date aaoDtePub;
	private Short aaoNbrOff;
	private Short aaoNbrOffAccpet;
	private Date aaoDteOuv;
	private Date aaoDteOuvTec;
	private String aaoObsOuv;
	private String aaoLieuOuvPrecis;
	private String aaoHeurFinOuv;
	private Date aaoDteSaisi;
	private Date aaoDteFinOuv;
	private String aaoFonCodAc;
	private String aaoStaCode;
	private Short aaoNbrOffRej;
	private String demOpeMatricule;
	private String demFonCodeAc;
	private Short aaoNbrOffHorDelai;
	private String aaoStatut;
	private Character aaoAno;
	private BigDecimal dacGesCode;
	private String aaoFonCodeCpmp;
	private String fonCodeCva;
	private String fonCodeDmp;

	public VAnodmpTraite() {
	}

	public VAnodmpTraite(String aaoCode, BigDecimal demNum) {
		this.aaoCode = aaoCode;
		this.demNum = demNum;
	}

	public VAnodmpTraite(String aaoCode, String aaoDacCode, String aaoLibelle, BigDecimal aaoNbrLot,
			BigDecimal demNum, String demObjet, String demMotif, String demRef, Date demDteSaisi, String demStaCode,
			BigDecimal aaoNbrOuv, Date aaoDtePub, Short aaoNbrOff, Short aaoNbrOffAccpet, Date aaoDteOuv,
			Date aaoDteOuvTec, String aaoObsOuv, String aaoLieuOuvPrecis, String aaoHeurFinOuv, Date aaoDteSaisi,
			Date aaoDteFinOuv, String aaoFonCodAc, String aaoStaCode, Short aaoNbrOffRej, String demOpeMatricule,
			String demFonCodeAc, Short aaoNbrOffHorDelai, String aaoStatut, Character aaoAno, BigDecimal dacGesCode,
			String aaoFonCodeCpmp, String fonCodeCva, String fonCodeDmp) {
		this.aaoCode = aaoCode;
		this.aaoDacCode = aaoDacCode;
		this.aaoLibelle = aaoLibelle;
		this.aaoNbrLot = aaoNbrLot;
		this.demNum = demNum;
		this.demObjet = demObjet;
		this.demMotif = demMotif;
		this.demRef = demRef;
		this.demDteSaisi = demDteSaisi;
		this.demStaCode = demStaCode;
		this.aaoNbrOuv = aaoNbrOuv;
		this.aaoDtePub = aaoDtePub;
		this.aaoNbrOff = aaoNbrOff;
		this.aaoNbrOffAccpet = aaoNbrOffAccpet;
		this.aaoDteOuv = aaoDteOuv;
		this.aaoDteOuvTec = aaoDteOuvTec;
		this.aaoObsOuv = aaoObsOuv;
		this.aaoLieuOuvPrecis = aaoLieuOuvPrecis;
		this.aaoHeurFinOuv = aaoHeurFinOuv;
		this.aaoDteSaisi = aaoDteSaisi;
		this.aaoDteFinOuv = aaoDteFinOuv;
		this.aaoFonCodAc = aaoFonCodAc;
		this.aaoStaCode = aaoStaCode;
		this.aaoNbrOffRej = aaoNbrOffRej;
		this.demOpeMatricule = demOpeMatricule;
		this.demFonCodeAc = demFonCodeAc;
		this.aaoNbrOffHorDelai = aaoNbrOffHorDelai;
		this.aaoStatut = aaoStatut;
		this.aaoAno = aaoAno;
		this.dacGesCode = dacGesCode;
		this.aaoFonCodeCpmp = aaoFonCodeCpmp;
		this.fonCodeCva = fonCodeCva;
		this.fonCodeDmp = fonCodeDmp;
	}

	@Column(name = "AAO_CODE", nullable = false, length = 22)
	public String getAaoCode() {
		return this.aaoCode;
	}

	public void setAaoCode(String aaoCode) {
		this.aaoCode = aaoCode;
	}

	@Column(name = "AAO_DAC_CODE", length = 20)
	public String getAaoDacCode() {
		return this.aaoDacCode;
	}

	public void setAaoDacCode(String aaoDacCode) {
		this.aaoDacCode = aaoDacCode;
	}

	@Column(name = "AAO_LIBELLE", length = 1000)
	public String getAaoLibelle() {
		return this.aaoLibelle;
	}

	public void setAaoLibelle(String aaoLibelle) {
		this.aaoLibelle = aaoLibelle;
	}

	@Column(name = "AAO_NBR_LOT", precision = 22, scale = 0)
	public BigDecimal getAaoNbrLot() {
		return this.aaoNbrLot;
	}

	public void setAaoNbrLot(BigDecimal aaoNbrLot) {
		this.aaoNbrLot = aaoNbrLot;
	}

	@Id
	@Column(name = "DEM_NUM", nullable = false, precision = 22, scale = 0)
	public BigDecimal getDemNum() {
		return this.demNum;
	}

	public void setDemNum(BigDecimal demNum) {
		this.demNum = demNum;
	}

	@Column(name = "DEM_OBJET", length = 1000)
	public String getDemObjet() {
		return this.demObjet;
	}

	public void setDemObjet(String demObjet) {
		this.demObjet = demObjet;
	}

	@Column(name = "DEM_MOTIF", length = 1000)
	public String getDemMotif() {
		return this.demMotif;
	}

	public void setDemMotif(String demMotif) {
		this.demMotif = demMotif;
	}

	@Column(name = "DEM_REF", length = 200)
	public String getDemRef() {
		return this.demRef;
	}

	public void setDemRef(String demRef) {
		this.demRef = demRef;
	}

	@Column(name = "DEM_DTE_SAISI", length = 7)
	public Date getDemDteSaisi() {
		return this.demDteSaisi;
	}

	public void setDemDteSaisi(Date demDteSaisi) {
		this.demDteSaisi = demDteSaisi;
	}

	@Column(name = "DEM_STA_CODE", length = 3)
	public String getDemStaCode() {
		return this.demStaCode;
	}

	public void setDemStaCode(String demStaCode) {
		this.demStaCode = demStaCode;
	}

	@Column(name = "AAO_NBR_OUV", precision = 22, scale = 0)
	public BigDecimal getAaoNbrOuv() {
		return this.aaoNbrOuv;
	}

	public void setAaoNbrOuv(BigDecimal aaoNbrOuv) {
		this.aaoNbrOuv = aaoNbrOuv;
	}

	@Column(name = "AAO_DTE_PUB", length = 7)
	public Date getAaoDtePub() {
		return this.aaoDtePub;
	}

	public void setAaoDtePub(Date aaoDtePub) {
		this.aaoDtePub = aaoDtePub;
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

	@Column(name = "AAO_DTE_OUV", length = 7)
	public Date getAaoDteOuv() {
		return this.aaoDteOuv;
	}

	public void setAaoDteOuv(Date aaoDteOuv) {
		this.aaoDteOuv = aaoDteOuv;
	}

	@Column(name = "AAO_DTE_OUV_TEC", length = 7)
	public Date getAaoDteOuvTec() {
		return this.aaoDteOuvTec;
	}

	public void setAaoDteOuvTec(Date aaoDteOuvTec) {
		this.aaoDteOuvTec = aaoDteOuvTec;
	}

	@Column(name = "AAO_OBS_OUV", length = 4000)
	public String getAaoObsOuv() {
		return this.aaoObsOuv;
	}

	public void setAaoObsOuv(String aaoObsOuv) {
		this.aaoObsOuv = aaoObsOuv;
	}

	@Column(name = "AAO_LIEU_OUV_PRECIS", length = 500)
	public String getAaoLieuOuvPrecis() {
		return this.aaoLieuOuvPrecis;
	}

	public void setAaoLieuOuvPrecis(String aaoLieuOuvPrecis) {
		this.aaoLieuOuvPrecis = aaoLieuOuvPrecis;
	}

	@Column(name = "AAO_HEUR_FIN_OUV", length = 20)
	public String getAaoHeurFinOuv() {
		return this.aaoHeurFinOuv;
	}

	public void setAaoHeurFinOuv(String aaoHeurFinOuv) {
		this.aaoHeurFinOuv = aaoHeurFinOuv;
	}

	@Column(name = "AAO_DTE_SAISI", length = 7)
	public Date getAaoDteSaisi() {
		return this.aaoDteSaisi;
	}

	public void setAaoDteSaisi(Date aaoDteSaisi) {
		this.aaoDteSaisi = aaoDteSaisi;
	}

	@Column(name = "AAO_DTE_FIN_OUV", length = 7)
	public Date getAaoDteFinOuv() {
		return this.aaoDteFinOuv;
	}

	public void setAaoDteFinOuv(Date aaoDteFinOuv) {
		this.aaoDteFinOuv = aaoDteFinOuv;
	}

	@Column(name = "AAO_FON_COD_AC", length = 12)
	public String getAaoFonCodAc() {
		return this.aaoFonCodAc;
	}

	public void setAaoFonCodAc(String aaoFonCodAc) {
		this.aaoFonCodAc = aaoFonCodAc;
	}

	@Column(name = "AAO_STA_CODE", length = 3)
	public String getAaoStaCode() {
		return this.aaoStaCode;
	}

	public void setAaoStaCode(String aaoStaCode) {
		this.aaoStaCode = aaoStaCode;
	}

	@Column(name = "AAO_NBR_OFF_REJ", precision = 4, scale = 0)
	public Short getAaoNbrOffRej() {
		return this.aaoNbrOffRej;
	}

	public void setAaoNbrOffRej(Short aaoNbrOffRej) {
		this.aaoNbrOffRej = aaoNbrOffRej;
	}

	@Column(name = "DEM_OPE_MATRICULE", length = 128)
	public String getDemOpeMatricule() {
		return this.demOpeMatricule;
	}

	public void setDemOpeMatricule(String demOpeMatricule) {
		this.demOpeMatricule = demOpeMatricule;
	}

	@Column(name = "DEM_FON_CODE_AC", length = 20)
	public String getDemFonCodeAc() {
		return this.demFonCodeAc;
	}

	public void setDemFonCodeAc(String demFonCodeAc) {
		this.demFonCodeAc = demFonCodeAc;
	}

	@Column(name = "AAO_NBR_OFF_HOR_DELAI", precision = 4, scale = 0)
	public Short getAaoNbrOffHorDelai() {
		return this.aaoNbrOffHorDelai;
	}

	public void setAaoNbrOffHorDelai(Short aaoNbrOffHorDelai) {
		this.aaoNbrOffHorDelai = aaoNbrOffHorDelai;
	}

	@Column(name = "AAO_STATUT", length = 3)
	public String getAaoStatut() {
		return this.aaoStatut;
	}

	public void setAaoStatut(String aaoStatut) {
		this.aaoStatut = aaoStatut;
	}

	@Column(name = "AAO_ANO", length = 1)
	public Character getAaoAno() {
		return this.aaoAno;
	}

	public void setAaoAno(Character aaoAno) {
		this.aaoAno = aaoAno;
	}

	@Column(name = "DAC_GES_CODE", precision = 22, scale = 0)
	public BigDecimal getDacGesCode() {
		return this.dacGesCode;
	}

	public void setDacGesCode(BigDecimal dacGesCode) {
		this.dacGesCode = dacGesCode;
	}

	@Column(name = "AAO_FON_CODE_CPMP", length = 12)
	public String getAaoFonCodeCpmp() {
		return this.aaoFonCodeCpmp;
	}

	public void setAaoFonCodeCpmp(String aaoFonCodeCpmp) {
		this.aaoFonCodeCpmp = aaoFonCodeCpmp;
	}

	@Column(name = "FON_CODE_CVA", length = 450)
	public String getFonCodeCva() {
		return this.fonCodeCva;
	}

	public void setFonCodeCva(String fonCodeCva) {
		this.fonCodeCva = fonCodeCva;
	}

	@Column(name = "FON_CODE_DMP", length = 90)
	public String getFonCodeDmp() {
		return this.fonCodeDmp;
	}

	public void setFonCodeDmp(String fonCodeDmp) {
		this.fonCodeDmp = fonCodeDmp;
	}
}
