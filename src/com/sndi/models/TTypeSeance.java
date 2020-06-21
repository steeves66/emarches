package com.sndi.models;
// Generated 20 juin 2020 17:16:02 by Hibernate Tools 4.3.5.Final

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
 * TTypeSeance generated by hbm2java
 */
@Entity
@Table(name = "T_TYPE_SEANCE", schema = "EMAP")
public class TTypeSeance implements java.io.Serializable {

	private String tseCode;
	private TOperateur TOperateur;
	private String tseLibelle;
	private Date tseDteSaisi;
	private String tseFonCode;
	private Set<TSeances> TSeanceses = new HashSet<TSeances>(0);

	public TTypeSeance() {
	}

	public TTypeSeance(String tseCode) {
		this.tseCode = tseCode;
	}

	public TTypeSeance(String tseCode, TOperateur TOperateur, String tseLibelle, Date tseDteSaisi, String tseFonCode,
			Set<TSeances> TSeanceses) {
		this.tseCode = tseCode;
		this.TOperateur = TOperateur;
		this.tseLibelle = tseLibelle;
		this.tseDteSaisi = tseDteSaisi;
		this.tseFonCode = tseFonCode;
		this.TSeanceses = TSeanceses;
	}

	@Id

	@Column(name = "TSE_CODE", unique = true, nullable = false, length = 3)
	public String getTseCode() {
		return this.tseCode;
	}

	public void setTseCode(String tseCode) {
		this.tseCode = tseCode;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TSE_OPE_MATRICULE")
	public TOperateur getTOperateur() {
		return this.TOperateur;
	}

	public void setTOperateur(TOperateur TOperateur) {
		this.TOperateur = TOperateur;
	}

	@Column(name = "TSE_LIBELLE", length = 500)
	public String getTseLibelle() {
		return this.tseLibelle;
	}

	public void setTseLibelle(String tseLibelle) {
		this.tseLibelle = tseLibelle;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "TSE_DTE_SAISI", length = 7)
	public Date getTseDteSaisi() {
		return this.tseDteSaisi;
	}

	public void setTseDteSaisi(Date tseDteSaisi) {
		this.tseDteSaisi = tseDteSaisi;
	}

	@Column(name = "TSE_FON_CODE", length = 12)
	public String getTseFonCode() {
		return this.tseFonCode;
	}

	public void setTseFonCode(String tseFonCode) {
		this.tseFonCode = tseFonCode;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TTypeSeance")
	public Set<TSeances> getTSeanceses() {
		return this.TSeanceses;
	}

	public void setTSeanceses(Set<TSeances> TSeanceses) {
		this.TSeanceses = TSeanceses;
	}

}
