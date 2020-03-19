package com.sndi.models;
// Generated 19 mars 2020 16:14:06 by Hibernate Tools 4.3.5.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * TRegion generated by hbm2java
 */
@Entity
@Table(name = "T_REGION", schema = "EMAP")
public class TRegion implements java.io.Serializable {

	private String regCode;
	private String regLibelle;
	private String regOpeMatricule;
	private Date regDteSaisi;
	private Set<TStructure> TStructures = new HashSet<TStructure>(0);

	public TRegion() {
	}

	public TRegion(String regCode) {
		this.regCode = regCode;
	}

	public TRegion(String regCode, String regLibelle, String regOpeMatricule, Date regDteSaisi,
			Set<TStructure> TStructures) {
		this.regCode = regCode;
		this.regLibelle = regLibelle;
		this.regOpeMatricule = regOpeMatricule;
		this.regDteSaisi = regDteSaisi;
		this.TStructures = TStructures;
	}

	@Id

	@Column(name = "REG_CODE", unique = true, nullable = false, length = 20)
	public String getRegCode() {
		return this.regCode;
	}

	public void setRegCode(String regCode) {
		this.regCode = regCode;
	}

	@Column(name = "REG_LIBELLE", length = 500)
	public String getRegLibelle() {
		return this.regLibelle;
	}

	public void setRegLibelle(String regLibelle) {
		this.regLibelle = regLibelle;
	}

	@Column(name = "REG_OPE_MATRICULE", length = 25)
	public String getRegOpeMatricule() {
		return this.regOpeMatricule;
	}

	public void setRegOpeMatricule(String regOpeMatricule) {
		this.regOpeMatricule = regOpeMatricule;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "REG_DTE_SAISI", length = 7)
	public Date getRegDteSaisi() {
		return this.regDteSaisi;
	}

	public void setRegDteSaisi(Date regDteSaisi) {
		this.regDteSaisi = regDteSaisi;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TRegion")
	public Set<TStructure> getTStructures() {
		return this.TStructures;
	}

	public void setTStructures(Set<TStructure> TStructures) {
		this.TStructures = TStructures;
	}

}
