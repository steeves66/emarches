package com.sndi.model;
// Generated 31 janv. 2020 14:56:36 by Hibernate Tools 4.3.5.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TMinistere generated by hbm2java
 */
@Entity
@Table(name = "T_MINISTERE", schema = "EMAP")
public class TMinistere implements java.io.Serializable {

	private String minCode;
	private String minLibelle;
	private String minLibelleCourt;
	private String minDescription;
	private Set<TOperateur> TOperateurs = new HashSet<TOperateur>(0);
	private Set<TStructure> TStructures = new HashSet<TStructure>(0);

	public TMinistere() {
	}

	public TMinistere(String minCode) {
		this.minCode = minCode;
	}

	public TMinistere(String minCode, String minLibelle, String minLibelleCourt, String minDescription, Set<TOperateur> TOperateurs,
			Set<TStructure> TStructures) {
		this.minCode = minCode;
		this.minLibelle = minLibelle;
		this.minLibelleCourt = minLibelleCourt;
		this.minDescription = minDescription;
		this.TOperateurs = TOperateurs;
		this.TStructures = TStructures;
	}

	@Id

	@Column(name = "MIN_CODE", unique = true, nullable = false, length = 3)
	public String getMinCode() {
		return this.minCode;
	}

	public void setMinCode(String minCode) {
		this.minCode = minCode;
	}

	@Column(name = "MIN_LIBELLE", length = 1000)
	public String getMinLibelle() {
		return this.minLibelle;
	}

	public void setMinLibelle(String minLibelle) {
		this.minLibelle = minLibelle;
	}

	@Column(name = "MIN_LIBELLE_COURT", length = 500)
	public String getMinLibelleCourt() {
		return this.minLibelleCourt;
	}

	public void setMinLibelleCourt(String minLibelleCourt) {
		this.minLibelleCourt = minLibelleCourt;
	}

	@Column(name = "MIN_DESCRIPTION", length = 1000)
	public String getMinDescription() {
		return this.minDescription;
	}

	public void setMinDescription(String minDescription) {
		this.minDescription = minDescription;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TMinistere")
	public Set<TOperateur> getTOperateurs() {
		return this.TOperateurs;
	}

	public void setTOperateurs(Set<TOperateur> TOperateurs) {
		this.TOperateurs = TOperateurs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TMinistere")
	public Set<TStructure> getTStructures() {
		return this.TStructures;
	}

	public void setTStructures(Set<TStructure> TStructures) {
		this.TStructures = TStructures;
	}

}
