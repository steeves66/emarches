package com.sndi.models;
// Generated 4 juil. 2020 18:05:44 by Hibernate Tools 4.3.5.Final

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
 * TDestinations generated by hbm2java
 */
@Entity
@Table(name = "T_DESTINATIONS", schema = "EMAP")
public class TDestinations implements java.io.Serializable {

	private String desCode;
	private TOperateur TOperateur;
	private String desAdr;
	private String desLib;
	private String desOpeModif;
	private Date desDteModif;
	private Date desDteSaisi;
	private String desRegCode;
	private Set<TLBudgets> TLBudgetses = new HashSet<TLBudgets>(0);

	public TDestinations() {
	}

	public TDestinations(String desCode, String desLib) {
		this.desCode = desCode;
		this.desLib = desLib;
	}

	public TDestinations(String desCode, TOperateur TOperateur, String desAdr, String desLib, String desOpeModif,
			Date desDteModif, Date desDteSaisi, String desRegCode, Set<TLBudgets> TLBudgetses) {
		this.desCode = desCode;
		this.TOperateur = TOperateur;
		this.desAdr = desAdr;
		this.desLib = desLib;
		this.desOpeModif = desOpeModif;
		this.desDteModif = desDteModif;
		this.desDteSaisi = desDteSaisi;
		this.desRegCode = desRegCode;
		this.TLBudgetses = TLBudgetses;
	}

	@Id

	@Column(name = "DES_CODE", unique = true, nullable = false, length = 20)
	public String getDesCode() {
		return this.desCode;
	}

	public void setDesCode(String desCode) {
		this.desCode = desCode;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DES_OPE_MATRICULE")
	public TOperateur getTOperateur() {
		return this.TOperateur;
	}

	public void setTOperateur(TOperateur TOperateur) {
		this.TOperateur = TOperateur;
	}

	@Column(name = "DES_ADR", length = 200)
	public String getDesAdr() {
		return this.desAdr;
	}

	public void setDesAdr(String desAdr) {
		this.desAdr = desAdr;
	}

	@Column(name = "DES_LIB", nullable = false, length = 500)
	public String getDesLib() {
		return this.desLib;
	}

	public void setDesLib(String desLib) {
		this.desLib = desLib;
	}

	@Column(name = "DES_OPE_MODIF", length = 25)
	public String getDesOpeModif() {
		return this.desOpeModif;
	}

	public void setDesOpeModif(String desOpeModif) {
		this.desOpeModif = desOpeModif;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DES_DTE_MODIF", length = 7)
	public Date getDesDteModif() {
		return this.desDteModif;
	}

	public void setDesDteModif(Date desDteModif) {
		this.desDteModif = desDteModif;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DES_DTE_SAISI", length = 7)
	public Date getDesDteSaisi() {
		return this.desDteSaisi;
	}

	public void setDesDteSaisi(Date desDteSaisi) {
		this.desDteSaisi = desDteSaisi;
	}

	@Column(name = "DES_REG_CODE", length = 2)
	public String getDesRegCode() {
		return this.desRegCode;
	}

	public void setDesRegCode(String desRegCode) {
		this.desRegCode = desRegCode;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TDestinations")
	public Set<TLBudgets> getTLBudgetses() {
		return this.TLBudgetses;
	}

	public void setTLBudgetses(Set<TLBudgets> TLBudgetses) {
		this.TLBudgetses = TLBudgetses;
	}

}
