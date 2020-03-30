package com.sndi.models;
// Generated 30 mars 2020 01:35:59 by Hibernate Tools 4.3.5.Final

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
 * TDetCommissionSeance generated by hbm2java
 */
@Entity
@Table(name = "T_DET_COMMISSION_SEANCE", schema = "EMAP")
public class TDetCommissionSeance implements java.io.Serializable {

	private BigDecimal dcsNum;
	private TCommissionSpecifique TCommissionSpecifique;
	private TDacSpecs TDacSpecs;
	private TOperateur TOperateur;
	private TSeances TSeances;
	private TStructure TStructure;
	private TTypeCommission TTypeCommission;
	private String dcsFonCod;
	private String dcsOpeMatricule;
	private Date dcsDteSaisi;
	private String dcsFonCodSaisi;
	private String dcsObservation;
	private String dcsNomMbm;
	private String dcsPreMbm;
	private String dcsTelMbm;
	private String dcsPresent;
	private String dcsMbmRespo;
	private String dcsRepMandate;
	private Set<TAffichageDao> TAffichageDaos = new HashSet<TAffichageDao>(0);

	public TDetCommissionSeance() {
	}

	public TDetCommissionSeance(BigDecimal dcsNum) {
		this.dcsNum = dcsNum;
	}

	public TDetCommissionSeance(BigDecimal dcsNum, TCommissionSpecifique TCommissionSpecifique, TDacSpecs TDacSpecs,
			TOperateur TOperateur, TSeances TSeances, TStructure TStructure, TTypeCommission TTypeCommission,
			String dcsFonCod, String dcsOpeMatricule, Date dcsDteSaisi, String dcsFonCodSaisi, String dcsObservation,
			String dcsNomMbm, String dcsPreMbm, String dcsTelMbm, String dcsPresent, String dcsMbmRespo,
			String dcsRepMandate, Set<TAffichageDao> TAffichageDaos) {
		this.dcsNum = dcsNum;
		this.TCommissionSpecifique = TCommissionSpecifique;
		this.TDacSpecs = TDacSpecs;
		this.TOperateur = TOperateur;
		this.TSeances = TSeances;
		this.TStructure = TStructure;
		this.TTypeCommission = TTypeCommission;
		this.dcsFonCod = dcsFonCod;
		this.dcsOpeMatricule = dcsOpeMatricule;
		this.dcsDteSaisi = dcsDteSaisi;
		this.dcsFonCodSaisi = dcsFonCodSaisi;
		this.dcsObservation = dcsObservation;
		this.dcsNomMbm = dcsNomMbm;
		this.dcsPreMbm = dcsPreMbm;
		this.dcsTelMbm = dcsTelMbm;
		this.dcsPresent = dcsPresent;
		this.dcsMbmRespo = dcsMbmRespo;
		this.dcsRepMandate = dcsRepMandate;
		this.TAffichageDaos = TAffichageDaos;
	}

	@Id

	@Column(name = "DCS_NUM", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getDcsNum() {
		return this.dcsNum;
	}

	public void setDcsNum(BigDecimal dcsNum) {
		this.dcsNum = dcsNum;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DCS_COM_NUM")
	public TCommissionSpecifique getTCommissionSpecifique() {
		return this.TCommissionSpecifique;
	}

	public void setTCommissionSpecifique(TCommissionSpecifique TCommissionSpecifique) {
		this.TCommissionSpecifique = TCommissionSpecifique;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DCS_DAC_CODE")
	public TDacSpecs getTDacSpecs() {
		return this.TDacSpecs;
	}

	public void setTDacSpecs(TDacSpecs TDacSpecs) {
		this.TDacSpecs = TDacSpecs;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DCS_OPE_MAT_SAISI")
	public TOperateur getTOperateur() {
		return this.TOperateur;
	}

	public void setTOperateur(TOperateur TOperateur) {
		this.TOperateur = TOperateur;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DCS_SEA_NUM")
	public TSeances getTSeances() {
		return this.TSeances;
	}

	public void setTSeances(TSeances TSeances) {
		this.TSeances = TSeances;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DCS_COM_STR_CODE")
	public TStructure getTStructure() {
		return this.TStructure;
	}

	public void setTStructure(TStructure TStructure) {
		this.TStructure = TStructure;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DCS_COM_TCO_CODE")
	public TTypeCommission getTTypeCommission() {
		return this.TTypeCommission;
	}

	public void setTTypeCommission(TTypeCommission TTypeCommission) {
		this.TTypeCommission = TTypeCommission;
	}

	@Column(name = "DCS_FON_COD", length = 100)
	public String getDcsFonCod() {
		return this.dcsFonCod;
	}

	public void setDcsFonCod(String dcsFonCod) {
		this.dcsFonCod = dcsFonCod;
	}

	@Column(name = "DCS_OPE_MATRICULE", length = 20)
	public String getDcsOpeMatricule() {
		return this.dcsOpeMatricule;
	}

	public void setDcsOpeMatricule(String dcsOpeMatricule) {
		this.dcsOpeMatricule = dcsOpeMatricule;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DCS_DTE_SAISI", length = 7)
	public Date getDcsDteSaisi() {
		return this.dcsDteSaisi;
	}

	public void setDcsDteSaisi(Date dcsDteSaisi) {
		this.dcsDteSaisi = dcsDteSaisi;
	}

	@Column(name = "DCS_FON_COD_SAISI", length = 12)
	public String getDcsFonCodSaisi() {
		return this.dcsFonCodSaisi;
	}

	public void setDcsFonCodSaisi(String dcsFonCodSaisi) {
		this.dcsFonCodSaisi = dcsFonCodSaisi;
	}

	@Column(name = "DCS_OBSERVATION", length = 200)
	public String getDcsObservation() {
		return this.dcsObservation;
	}

	public void setDcsObservation(String dcsObservation) {
		this.dcsObservation = dcsObservation;
	}

	@Column(name = "DCS_NOM_MBM", length = 100)
	public String getDcsNomMbm() {
		return this.dcsNomMbm;
	}

	public void setDcsNomMbm(String dcsNomMbm) {
		this.dcsNomMbm = dcsNomMbm;
	}

	@Column(name = "DCS_PRE_MBM", length = 200)
	public String getDcsPreMbm() {
		return this.dcsPreMbm;
	}

	public void setDcsPreMbm(String dcsPreMbm) {
		this.dcsPreMbm = dcsPreMbm;
	}

	@Column(name = "DCS_TEL_MBM", length = 50)
	public String getDcsTelMbm() {
		return this.dcsTelMbm;
	}

	public void setDcsTelMbm(String dcsTelMbm) {
		this.dcsTelMbm = dcsTelMbm;
	}

	@Column(name = "DCS_PRESENT", length = 1)
	public String getDcsPresent() {
		return this.dcsPresent;
	}

	public void setDcsPresent(String dcsPresent) {
		this.dcsPresent = dcsPresent;
	}

	@Column(name = "DCS_MBM_RESPO", length = 1)
	public String getDcsMbmRespo() {
		return this.dcsMbmRespo;
	}

	public void setDcsMbmRespo(String dcsMbmRespo) {
		this.dcsMbmRespo = dcsMbmRespo;
	}

	@Column(name = "DCS_REP_MANDATE", length = 1)
	public String getDcsRepMandate() {
		return this.dcsRepMandate;
	}

	public void setDcsRepMandate(String dcsRepMandate) {
		this.dcsRepMandate = dcsRepMandate;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TDetCommissionSeance")
	public Set<TAffichageDao> getTAffichageDaos() {
		return this.TAffichageDaos;
	}

	public void setTAffichageDaos(Set<TAffichageDao> TAffichageDaos) {
		this.TAffichageDaos = TAffichageDaos;
	}

}
