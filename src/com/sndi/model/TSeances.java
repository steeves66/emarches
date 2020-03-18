package com.sndi.model;
// Generated 14 mars 2020 13:28:49 by Hibernate Tools 4.3.5.Final

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

/**
 * TSeances generated by hbm2java
 */
@Entity
@Table(name = "T_SEANCES", schema = "EMAP")
public class TSeances implements java.io.Serializable {

	private BigDecimal seaNum;
	private TFonction TFonction;
	private TOperateur TOperateur;
	private TTypeSeance TTypeSeance;
	private String seaLibelle;
	private String seaQuorum;
	private BigDecimal seaNbrPli;
	private String seaRes;
	private Date seaSteSaisi;
	private String seaObservation;
	private Set<TDetCommissionSeance> TDetCommissionSeances = new HashSet<TDetCommissionSeance>(0);

	public TSeances() {
	}

	public TSeances(BigDecimal seaNum) {
		this.seaNum = seaNum;
	}

	public TSeances(BigDecimal seaNum, TFonction TFonction, TOperateur TOperateur, TTypeSeance TTypeSeance,
			String seaLibelle, String seaQuorum, BigDecimal seaNbrPli, String seaRes, Date seaSteSaisi,
			String seaObservation, Set<TDetCommissionSeance> TDetCommissionSeances) {
		this.seaNum = seaNum;
		this.TFonction = TFonction;
		this.TOperateur = TOperateur;
		this.TTypeSeance = TTypeSeance;
		this.seaLibelle = seaLibelle;
		this.seaQuorum = seaQuorum;
		this.seaNbrPli = seaNbrPli;
		this.seaRes = seaRes;
		this.seaSteSaisi = seaSteSaisi;
		this.seaObservation = seaObservation;
		this.TDetCommissionSeances = TDetCommissionSeances;
	}

	@Id
	@SequenceGenerator(name = "SEQ_SEA_Sequence", sequenceName = "SEQ_SEA", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_SEA_Sequence")
	@Column(name = "SEA_NUM", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getSeaNum() {
		return this.seaNum;
	}

	public void setSeaNum(BigDecimal seaNum) {
		this.seaNum = seaNum;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SEA_FON_CODE")
	public TFonction getTFonction() {
		return this.TFonction;
	}

	public void setTFonction(TFonction TFonction) {
		this.TFonction = TFonction;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SEA_OPE_MATRICULE")
	public TOperateur getTOperateur() {
		return this.TOperateur;
	}

	public void setTOperateur(TOperateur TOperateur) {
		this.TOperateur = TOperateur;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SEA_TSE_CODE")
	public TTypeSeance getTTypeSeance() {
		return this.TTypeSeance;
	}

	public void setTTypeSeance(TTypeSeance TTypeSeance) {
		this.TTypeSeance = TTypeSeance;
	}

	@Column(name = "SEA_LIBELLE", length = 500)
	public String getSeaLibelle() {
		return this.seaLibelle;
	}

	public void setSeaLibelle(String seaLibelle) {
		this.seaLibelle = seaLibelle;
	}

	@Column(name = "SEA_QUORUM", length = 1)
	public String getSeaQuorum() {
		return this.seaQuorum;
	}

	public void setSeaQuorum(String seaQuorum) {
		this.seaQuorum = seaQuorum;
	}

	@Column(name = "SEA_NBR_PLI", precision = 22, scale = 0)
	public BigDecimal getSeaNbrPli() {
		return this.seaNbrPli;
	}

	public void setSeaNbrPli(BigDecimal seaNbrPli) {
		this.seaNbrPli = seaNbrPli;
	}

	@Column(name = "SEA_RES", length = 1)
	public String getSeaRes() {
		return this.seaRes;
	}

	public void setSeaRes(String seaRes) {
		this.seaRes = seaRes;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "SEA_STE_SAISI", length = 7)
	public Date getSeaSteSaisi() {
		return this.seaSteSaisi;
	}

	public void setSeaSteSaisi(Date seaSteSaisi) {
		this.seaSteSaisi = seaSteSaisi;
	}

	@Column(name = "SEA_OBSERVATION", length = 500)
	public String getSeaObservation() {
		return this.seaObservation;
	}

	public void setSeaObservation(String seaObservation) {
		this.seaObservation = seaObservation;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TSeances")
	public Set<TDetCommissionSeance> getTDetCommissionSeances() {
		return this.TDetCommissionSeances;
	}

	public void setTDetCommissionSeances(Set<TDetCommissionSeance> TDetCommissionSeances) {
		this.TDetCommissionSeances = TDetCommissionSeances;
	}

}
