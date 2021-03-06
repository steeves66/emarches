package com.sndi.model;
// Generated 5 f?vr. 2020 15:37:15 by Hibernate Tools 4.3.5.Final

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
 * TTypeCommission generated by hbm2java
 */
@Entity
@Table(name = "T_TYPE_COMMISSION", schema = "EMAP")
public class TTypeCommission implements java.io.Serializable {

	private String tcoCode;
	private TOperateur TOperateur;
	private String tcoLibelle;
	private Date tcoDteSaisi;
	private Set<TDetCommissionSeance> TDetCommissionSeances = new HashSet<TDetCommissionSeance>(0);
	private Set<TCommissionSpecifique> TCommissionSpecifiques = new HashSet<TCommissionSpecifique>(0);
	private Set<TCommissionType> TCommissionTypes = new HashSet<TCommissionType>(0);

	public TTypeCommission() {
	}

	public TTypeCommission(String tcoCode) {
		this.tcoCode = tcoCode;
	}

	public TTypeCommission(String tcoCode, TOperateur TOperateur, String tcoLibelle, Date tcoDteSaisi,
			Set<TDetCommissionSeance> TDetCommissionSeances, Set<TCommissionSpecifique> TCommissionSpecifiques,
			Set<TCommissionType> TCommissionTypes) {
		this.tcoCode = tcoCode;
		this.TOperateur = TOperateur;
		this.tcoLibelle = tcoLibelle;
		this.tcoDteSaisi = tcoDteSaisi;
		this.TDetCommissionSeances = TDetCommissionSeances;
		this.TCommissionSpecifiques = TCommissionSpecifiques;
		this.TCommissionTypes = TCommissionTypes;
	}

	@Id

	@Column(name = "TCO_CODE", unique = true, nullable = false, length = 3)
	public String getTcoCode() {
		return this.tcoCode;
	}

	public void setTcoCode(String tcoCode) {
		this.tcoCode = tcoCode;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TCO_OPE_MATRICULE")
	public TOperateur getTOperateur() {
		return this.TOperateur;
	}

	public void setTOperateur(TOperateur TOperateur) {
		this.TOperateur = TOperateur;
	}

	@Column(name = "TCO_LIBELLE", length = 500)
	public String getTcoLibelle() {
		return this.tcoLibelle;
	}

	public void setTcoLibelle(String tcoLibelle) {
		this.tcoLibelle = tcoLibelle;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "TCO_DTE_SAISI", length = 7)
	public Date getTcoDteSaisi() {
		return this.tcoDteSaisi;
	}

	public void setTcoDteSaisi(Date tcoDteSaisi) {
		this.tcoDteSaisi = tcoDteSaisi;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TTypeCommission")
	public Set<TDetCommissionSeance> getTDetCommissionSeances() {
		return this.TDetCommissionSeances;
	}

	public void setTDetCommissionSeances(Set<TDetCommissionSeance> TDetCommissionSeances) {
		this.TDetCommissionSeances = TDetCommissionSeances;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TTypeCommission")
	public Set<TCommissionSpecifique> getTCommissionSpecifiques() {
		return this.TCommissionSpecifiques;
	}

	public void setTCommissionSpecifiques(Set<TCommissionSpecifique> TCommissionSpecifiques) {
		this.TCommissionSpecifiques = TCommissionSpecifiques;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TTypeCommission")
	public Set<TCommissionType> getTCommissionTypes() {
		return this.TCommissionTypes;
	}

	public void setTCommissionTypes(Set<TCommissionType> TCommissionTypes) {
		this.TCommissionTypes = TCommissionTypes;
	}

}
