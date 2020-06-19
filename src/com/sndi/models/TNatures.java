package com.sndi.models;
// Generated 18 juin 2020 16:45:49 by Hibernate Tools 4.3.5.Final

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
 * TNatures generated by hbm2java
 */
@Entity
@Table(name = "T_NATURES", schema = "EMAP")
public class TNatures implements java.io.Serializable {

	private String natCode;
	private TOperateur TOperateur;
	private String natLibelle;
	private String natOpeModif;
	private Date natDteSaisi;
	private Date natDteModif;
	private String natCClasse;
	private Set<TLBudgets> TLBudgetses = new HashSet<TLBudgets>(0);

	public TNatures() {
	}

	public TNatures(String natCode) {
		this.natCode = natCode;
	}

	public TNatures(String natCode, TOperateur TOperateur, String natLibelle, String natOpeModif, Date natDteSaisi,
			Date natDteModif, String natCClasse, Set<TLBudgets> TLBudgetses) {
		this.natCode = natCode;
		this.TOperateur = TOperateur;
		this.natLibelle = natLibelle;
		this.natOpeModif = natOpeModif;
		this.natDteSaisi = natDteSaisi;
		this.natDteModif = natDteModif;
		this.natCClasse = natCClasse;
		this.TLBudgetses = TLBudgetses;
	}

	@Id

	@Column(name = "NAT_CODE", unique = true, nullable = false, length = 20)
	public String getNatCode() {
		return this.natCode;
	}

	public void setNatCode(String natCode) {
		this.natCode = natCode;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NAT_OPE_MATRICULE")
	public TOperateur getTOperateur() {
		return this.TOperateur;
	}

	public void setTOperateur(TOperateur TOperateur) {
		this.TOperateur = TOperateur;
	}

	@Column(name = "NAT_LIBELLE", length = 200)
	public String getNatLibelle() {
		return this.natLibelle;
	}

	public void setNatLibelle(String natLibelle) {
		this.natLibelle = natLibelle;
	}

	@Column(name = "NAT_OPE_MODIF", length = 25)
	public String getNatOpeModif() {
		return this.natOpeModif;
	}

	public void setNatOpeModif(String natOpeModif) {
		this.natOpeModif = natOpeModif;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "NAT_DTE_SAISI", length = 7)
	public Date getNatDteSaisi() {
		return this.natDteSaisi;
	}

	public void setNatDteSaisi(Date natDteSaisi) {
		this.natDteSaisi = natDteSaisi;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "NAT_DTE_MODIF", length = 7)
	public Date getNatDteModif() {
		return this.natDteModif;
	}

	public void setNatDteModif(Date natDteModif) {
		this.natDteModif = natDteModif;
	}

	@Column(name = "NAT_C_CLASSE", length = 1)
	public String getNatCClasse() {
		return this.natCClasse;
	}

	public void setNatCClasse(String natCClasse) {
		this.natCClasse = natCClasse;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TNatures")
	public Set<TLBudgets> getTLBudgetses() {
		return this.TLBudgetses;
	}

	public void setTLBudgetses(Set<TLBudgets> TLBudgetses) {
		this.TLBudgetses = TLBudgetses;
	}

}
