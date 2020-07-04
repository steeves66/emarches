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
 * TAvisAppelOffre generated by hbm2java
 */
@Entity
@Table(name = "T_AVIS_APPEL_OFFRE", schema = "EMAP")
public class TAvisAppelOffre implements java.io.Serializable {

	private String aaoCode;
	private TAdresseAvis TAdresseAvis;
	private TDacSpecs TDacSpecs;
	private TFonction TFonctionByAaoFonCodAc;
	private TFonction TFonctionByAaoFonCodeCpmp;
	private TStatut TStatut;
	private String aaoLibelle;
	private Date aaoDteSaisi;
	private Date aaoDtePub;
	private Date aaoDteOuvTec;
	private String aaoDteHeurOuv;
	private Date aaoDteOuvFin;
	private BigDecimal aaoNbrLot;
	private BigDecimal aaoNbrOuv;
	private BigDecimal aaoDelaiVal;
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
	private String aaoHeureRecep;
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
	private Set<TDetailAvis> TDetailAvises = new HashSet<TDetailAvis>(0);
	private Set<TLotAao> TLotAaos = new HashSet<TLotAao>(0);

	public TAvisAppelOffre() {
	}

	public TAvisAppelOffre(String aaoCode) {
		this.aaoCode = aaoCode;
	}

	public TAvisAppelOffre(String aaoCode, TAdresseAvis TAdresseAvis, TDacSpecs TDacSpecs,
			TFonction TFonctionByAaoFonCodAc, TFonction TFonctionByAaoFonCodeCpmp, TStatut TStatut, String aaoLibelle,
			Date aaoDteSaisi, Date aaoDtePub, Date aaoDteOuvTec, String aaoDteHeurOuv, Date aaoDteOuvFin,
			BigDecimal aaoNbrLot, BigDecimal aaoNbrOuv, BigDecimal aaoDelaiVal, String aaoNatInt, String aaoTaux,
			String aaoLieuExe, String aaoNomResp, String aaoInterPub, String aaoCautDefExig, String aaoBompPub,
			String aaoVenteParLot, String aaoAvisBail, BigDecimal aaoMtCaut, String aaoModePaiement,
			BigDecimal aaoCoutDac, String aaoLieuRecep, Date aaoDateRecep, String aaoHeureRecep, String aaoNatPrix,
			String aaoRegQual, String aaoAvisBai, String aaoRespBai, String aaoPrecisModEval, Date aaoDteValAc,
			Date aaoDteValCpmp, Date aaoDteValDmp, Short aaoNbrOff, Short aaoNbrOffAccpet, Short aaoNbrOffRej,
			Short aaoNbrOffHorDelai, Set<TDetailAvis> TDetailAvises, Set<TLotAao> TLotAaos) {
		this.aaoCode = aaoCode;
		this.TAdresseAvis = TAdresseAvis;
		this.TDacSpecs = TDacSpecs;
		this.TFonctionByAaoFonCodAc = TFonctionByAaoFonCodAc;
		this.TFonctionByAaoFonCodeCpmp = TFonctionByAaoFonCodeCpmp;
		this.TStatut = TStatut;
		this.aaoLibelle = aaoLibelle;
		this.aaoDteSaisi = aaoDteSaisi;
		this.aaoDtePub = aaoDtePub;
		this.aaoDteOuvTec = aaoDteOuvTec;
		this.aaoDteHeurOuv = aaoDteHeurOuv;
		this.aaoDteOuvFin = aaoDteOuvFin;
		this.aaoNbrLot = aaoNbrLot;
		this.aaoNbrOuv = aaoNbrOuv;
		this.aaoDelaiVal = aaoDelaiVal;
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
		this.TDetailAvises = TDetailAvises;
		this.TLotAaos = TLotAaos;
	}

	@Id

	@Column(name = "AAO_CODE", unique = true, nullable = false, length = 20)
	public String getAaoCode() {
		return this.aaoCode;
	}

	public void setAaoCode(String aaoCode) {
		this.aaoCode = aaoCode;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AAO_ADA_NUM")
	public TAdresseAvis getTAdresseAvis() {
		return this.TAdresseAvis;
	}

	public void setTAdresseAvis(TAdresseAvis TAdresseAvis) {
		this.TAdresseAvis = TAdresseAvis;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AAO_DAC_CODE")
	public TDacSpecs getTDacSpecs() {
		return this.TDacSpecs;
	}

	public void setTDacSpecs(TDacSpecs TDacSpecs) {
		this.TDacSpecs = TDacSpecs;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AAO_FON_COD_AC")
	public TFonction getTFonctionByAaoFonCodAc() {
		return this.TFonctionByAaoFonCodAc;
	}

	public void setTFonctionByAaoFonCodAc(TFonction TFonctionByAaoFonCodAc) {
		this.TFonctionByAaoFonCodAc = TFonctionByAaoFonCodAc;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AAO_FON_CODE_CPMP")
	public TFonction getTFonctionByAaoFonCodeCpmp() {
		return this.TFonctionByAaoFonCodeCpmp;
	}

	public void setTFonctionByAaoFonCodeCpmp(TFonction TFonctionByAaoFonCodeCpmp) {
		this.TFonctionByAaoFonCodeCpmp = TFonctionByAaoFonCodeCpmp;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AAO_STA_CODE")
	public TStatut getTStatut() {
		return this.TStatut;
	}

	public void setTStatut(TStatut TStatut) {
		this.TStatut = TStatut;
	}

	@Column(name = "AAO_LIBELLE", length = 1000)
	public String getAaoLibelle() {
		return this.aaoLibelle;
	}

	public void setAaoLibelle(String aaoLibelle) {
		this.aaoLibelle = aaoLibelle;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "AAO_DTE_SAISI", length = 7)
	public Date getAaoDteSaisi() {
		return this.aaoDteSaisi;
	}

	public void setAaoDteSaisi(Date aaoDteSaisi) {
		this.aaoDteSaisi = aaoDteSaisi;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "AAO_DTE_PUB", length = 7)
	public Date getAaoDtePub() {
		return this.aaoDtePub;
	}

	public void setAaoDtePub(Date aaoDtePub) {
		this.aaoDtePub = aaoDtePub;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "AAO_DTE_OUV_TEC", length = 7)
	public Date getAaoDteOuvTec() {
		return this.aaoDteOuvTec;
	}

	public void setAaoDteOuvTec(Date aaoDteOuvTec) {
		this.aaoDteOuvTec = aaoDteOuvTec;
	}

	@Column(name = "AAO_DTE_HEUR_OUV", length = 20)
	public String getAaoDteHeurOuv() {
		return this.aaoDteHeurOuv;
	}

	public void setAaoDteHeurOuv(String aaoDteHeurOuv) {
		this.aaoDteHeurOuv = aaoDteHeurOuv;
	}

	@Temporal(TemporalType.DATE)
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

	@Temporal(TemporalType.DATE)
	@Column(name = "AAO_DATE_RECEP", length = 7)
	public Date getAaoDateRecep() {
		return this.aaoDateRecep;
	}

	public void setAaoDateRecep(Date aaoDateRecep) {
		this.aaoDateRecep = aaoDateRecep;
	}

	@Column(name = "AAO_HEURE_RECEP", length = 20)
	public String getAaoHeureRecep() {
		return this.aaoHeureRecep;
	}

	public void setAaoHeureRecep(String aaoHeureRecep) {
		this.aaoHeureRecep = aaoHeureRecep;
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

	@Temporal(TemporalType.DATE)
	@Column(name = "AAO_DTE_VAL_AC", length = 7)
	public Date getAaoDteValAc() {
		return this.aaoDteValAc;
	}

	public void setAaoDteValAc(Date aaoDteValAc) {
		this.aaoDteValAc = aaoDteValAc;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "AAO_DTE_VAL_CPMP", length = 7)
	public Date getAaoDteValCpmp() {
		return this.aaoDteValCpmp;
	}

	public void setAaoDteValCpmp(Date aaoDteValCpmp) {
		this.aaoDteValCpmp = aaoDteValCpmp;
	}

	@Temporal(TemporalType.DATE)
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TAvisAppelOffre")
	public Set<TDetailAvis> getTDetailAvises() {
		return this.TDetailAvises;
	}

	public void setTDetailAvises(Set<TDetailAvis> TDetailAvises) {
		this.TDetailAvises = TDetailAvises;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TAvisAppelOffre")
	public Set<TLotAao> getTLotAaos() {
		return this.TLotAaos;
	}

	public void setTLotAaos(Set<TLotAao> TLotAaos) {
		this.TLotAaos = TLotAaos;
	}

}
