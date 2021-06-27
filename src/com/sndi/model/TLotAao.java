package com.sndi.model;
// Generated 6 f�vr. 2020 11:56:51 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.sndi.model.TPiecesOffres;


/**
 * TLotAao generated by hbm2java
 */
@Entity
@Table(name = "T_LOT_AAO", schema = "EMAP")
public class TLotAao implements java.io.Serializable {

	private Long laaId;
	private String laaLbgImputation;
	private TFonction TFonctionByLaaFonCodSaisi;
	private TFonction TFonctionByLaaFonCodCpmp;
	private TAvisAppelOffre TAvisAppelOffre;
	private TDacSpecs TDacSpecs;
	private String laaObjet;
	private String laaObservation;
	public Long laaMtCaut;
	public Long laaMtEst;
	private Date laaDteSaisi;
	private String laaStaCode;
	private String laaOpeMatricule;
	private String laaLieuExe;
	private Long laaNum;
	private Long laaCoutLot;
	private String laaAjoutPanier;
	private Long laaDelaiExe;
	private String laaVariante;
	private String laaAno;
	private String laaObservationDmp;
	private Set<TPiecesOffres> TPiecesOffres = new HashSet<TPiecesOffres>(0);

	public TLotAao() {
	}

	public TLotAao(long laaId) {
		this.laaId = laaId;
	}

	public TLotAao(Long laaId, String laaLbgImputation, TFonction TFonctionByLaaFonCodSaisi,
			TFonction TFonctionByLaaFonCodCpmp, TAvisAppelOffre TAvisAppelOffre,TDacSpecs TDacSpecs, String laaObjet, String laaObservation,
			Long laaMtCaut, long laaMtEst, Date laaDteSaisi, String laaStaCode, String laaOpeMatricule,String laaObservationDmp,
			String laaLieuExe, Long laaNum, Long laaCoutLot,String laaAjoutPanier, Long laaDelaiExe,String laaVariante,String laaAno,
			Set<TPiecesOffres> TPiecesOffres) {
		this.laaId = laaId;
		this.laaLbgImputation = laaLbgImputation;
		this.TFonctionByLaaFonCodSaisi = TFonctionByLaaFonCodSaisi;
		this.TFonctionByLaaFonCodCpmp = TFonctionByLaaFonCodCpmp;
		this.TAvisAppelOffre = TAvisAppelOffre;
		this.TDacSpecs = TDacSpecs;
		this.laaObjet = laaObjet;
		this.laaObservation = laaObservation;
		this.laaMtCaut = laaMtCaut;
		this.laaMtEst = laaMtEst;
		this.laaDteSaisi = laaDteSaisi;
		this.laaStaCode = laaStaCode;
		this.laaOpeMatricule = laaOpeMatricule;
		this.laaLieuExe = laaLieuExe;
		this.laaNum = laaNum;
		this.laaCoutLot = laaCoutLot;
		this.laaAjoutPanier = laaAjoutPanier;
		this.laaDelaiExe = laaDelaiExe;
		this.laaVariante = laaVariante;
		this.TPiecesOffres = TPiecesOffres;
		this.laaAno = laaAno;
		this.laaObservationDmp = laaObservationDmp;
	}

	@Id
	@SequenceGenerator(name = "SEQ_LOT_Sequence", sequenceName = "SEQ_LOT", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_LOT_Sequence")
	@Column(name = "LAA_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Long getLaaId() {
		return this.laaId;
	}

	public void setLaaId(Long laaId) {
		this.laaId = laaId;
	}

	@Column(name = "LAA_LBG_IMPUTATION")
	public String getLaaLbgImputation() {
		return laaLbgImputation;
	}

	public void setLaaLbgImputation(String laaLbgImputation) {
		this.laaLbgImputation = laaLbgImputation;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "LAA_FON_COD_SAISI")
	public TFonction getTFonctionByLaaFonCodSaisi() {
		return this.TFonctionByLaaFonCodSaisi;
	}

	public void setTFonctionByLaaFonCodSaisi(TFonction TFonctionByLaaFonCodSaisi) {
		this.TFonctionByLaaFonCodSaisi = TFonctionByLaaFonCodSaisi;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LAA_FON_COD_CPMP")
	public TFonction getTFonctionByLaaFonCodCpmp() {
		return this.TFonctionByLaaFonCodCpmp;
	}

	public void setTFonctionByLaaFonCodCpmp(TFonction TFonctionByLaaFonCodCpmp) {
		this.TFonctionByLaaFonCodCpmp = TFonctionByLaaFonCodCpmp;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "LAA_AAO_CODE")
	public TAvisAppelOffre getTAvisAppelOffre() {
		return this.TAvisAppelOffre;
	}

	public void setTAvisAppelOffre(TAvisAppelOffre TAvisAppelOffre) {
		this.TAvisAppelOffre = TAvisAppelOffre;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "LAA_DAC_CODE")
	public TDacSpecs getTDacSpecs() {
		return this.TDacSpecs;
	}

	public void setTDacSpecs(TDacSpecs TDacSpecs) {
		this.TDacSpecs = TDacSpecs;
	}

	@Column(name = "LAA_OBJET", length = 1000)
	public String getLaaObjet() {
		return this.laaObjet;
	}

	public void setLaaObjet(String laaObjet) {
		this.laaObjet = laaObjet;
	}

	@Column(name = "LAA_OBSERVATION", length = 200)
	public String getLaaObservation() {
		return this.laaObservation;
	}

	public void setLaaObservation(String laaObservation) {
		this.laaObservation = laaObservation;
	}

	@Column(name = "LAA_MT_CAUT", precision = 22, scale = 0)
	public Long getLaaMtCaut() {
		return this.laaMtCaut;
	}

	public void setLaaMtCaut(Long laaMtCaut) {
		this.laaMtCaut = laaMtCaut;
	}

	@Column(name = "LAA_MT_EST")
	public Long getLaaMtEst() {
		return this.laaMtEst;
	}

	public void setLaaMtEst(Long laaMtEst) {
		this.laaMtEst = laaMtEst;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "LAA_DTE_SAISI", length = 7)
	public Date getLaaDteSaisi() {
		return this.laaDteSaisi;
	}

	public void setLaaDteSaisi(Date laaDteSaisi) {
		this.laaDteSaisi = laaDteSaisi;
	}

	@Column(name = "LAA_STA_CODE", length = 3)
	public String getLaaStaCode() {
		return this.laaStaCode;
	}

	public void setLaaStaCode(String laaStaCode) {
		this.laaStaCode = laaStaCode;
	}

	@Column(name = "LAA_OPE_MATRICULE", length = 20)
	public String getLaaOpeMatricule() {
		return this.laaOpeMatricule;
	}

	public void setLaaOpeMatricule(String laaOpeMatricule) {
		this.laaOpeMatricule = laaOpeMatricule;
	}

	@Column(name = "LAA_LIEU_EXE", length = 1000)
	public String getLaaLieuExe() {
		return this.laaLieuExe;
	}

	public void setLaaLieuExe(String laaLieuExe) {
		this.laaLieuExe = laaLieuExe;
	}

	@Column(name = "LAA_NUM", precision = 22, scale = 0)
	public Long getLaaNum() {
		return this.laaNum;
	}

	public void setLaaNum(Long laaNum) {
		this.laaNum = laaNum;
	}

	@Column(name = "LAA_COUT_LOT", precision = 22, scale = 0)
	public Long getLaaCoutLot() {
		return this.laaCoutLot;
	}

	public void setLaaCoutLot(Long laaCoutLot) {
		this.laaCoutLot = laaCoutLot;
	}

	@Column(name = "LAA_AJOUT_PANIER", length = 1)
	public String getLaaAjoutPanier() {
		return this.laaAjoutPanier;
	}

	public void setLaaAjoutPanier(String laaAjoutPanier) {
		this.laaAjoutPanier = laaAjoutPanier;
	}
	
	@Column(name = "LAA_DELAI_EXE", precision = 10, scale = 0)
	public Long getLaaDelaiExe() {
		return this.laaDelaiExe;
	}

	public void setLaaDelaiExe(Long laaDelaiExe) {
		this.laaDelaiExe = laaDelaiExe;
	}

	@Column(name = "LAA_VARIANTE", length = 1)
	public String getLaaVariante() {
		return this.laaVariante;
	}

	public void setLaaVariante(String laaVariante) {
		this.laaVariante = laaVariante;
	}


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TLotAao")
	public Set<TPiecesOffres> getTPiecesOffres() {
		return TPiecesOffres;
	}

	public void setTPiecesOffres(Set<TPiecesOffres> tPiecesOffres) {
		TPiecesOffres = tPiecesOffres;
	}

	@Column(name = "LAA_ANO")
	public String getLaaAno() {
		return laaAno;
	}

	public void setLaaAno(String laaAno) {
		this.laaAno = laaAno;
	}
	
	@Column(name = "LAA_OBSERVATION_DMP", length = 100)
	public String getLaaObservationDmp() {
		return this.laaObservationDmp;
	}

	public void setLaaObservationDmp(String laaObservationDmp) {
		this.laaObservationDmp = laaObservationDmp;
	}

}
