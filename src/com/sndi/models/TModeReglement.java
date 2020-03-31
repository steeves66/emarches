package com.sndi.models;
// Generated 31 mars 2020 01:27:37 by Hibernate Tools 4.3.5.Final

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
 * TModeReglement generated by hbm2java
 */
@Entity
@Table(name = "T_MODE_REGLEMENT", schema = "EMAP")
public class TModeReglement implements java.io.Serializable {

	private String mrgCod;
	private TOperateur TOperateur;
	private String mrgLibelle;
	private Date mrgDteSaisie;
	private Set<TVenteDac> TVenteDacs = new HashSet<TVenteDac>(0);

	public TModeReglement() {
	}

	public TModeReglement(String mrgCod) {
		this.mrgCod = mrgCod;
	}

	public TModeReglement(String mrgCod, TOperateur TOperateur, String mrgLibelle, Date mrgDteSaisie,
			Set<TVenteDac> TVenteDacs) {
		this.mrgCod = mrgCod;
		this.TOperateur = TOperateur;
		this.mrgLibelle = mrgLibelle;
		this.mrgDteSaisie = mrgDteSaisie;
		this.TVenteDacs = TVenteDacs;
	}

	@Id

	@Column(name = "MRG_COD", unique = true, nullable = false, length = 10)
	public String getMrgCod() {
		return this.mrgCod;
	}

	public void setMrgCod(String mrgCod) {
		this.mrgCod = mrgCod;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MRG_OPE_MATRICULE")
	public TOperateur getTOperateur() {
		return this.TOperateur;
	}

	public void setTOperateur(TOperateur TOperateur) {
		this.TOperateur = TOperateur;
	}

	@Column(name = "MRG_LIBELLE", length = 200)
	public String getMrgLibelle() {
		return this.mrgLibelle;
	}

	public void setMrgLibelle(String mrgLibelle) {
		this.mrgLibelle = mrgLibelle;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "MRG_DTE_SAISIE", length = 7)
	public Date getMrgDteSaisie() {
		return this.mrgDteSaisie;
	}

	public void setMrgDteSaisie(Date mrgDteSaisie) {
		this.mrgDteSaisie = mrgDteSaisie;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TModeReglement")
	public Set<TVenteDac> getTVenteDacs() {
		return this.TVenteDacs;
	}

	public void setTVenteDacs(Set<TVenteDac> TVenteDacs) {
		this.TVenteDacs = TVenteDacs;
	}

}
