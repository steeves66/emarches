package com.sndi.models;
// Generated 21 mars 2020 13:48:08 by Hibernate Tools 4.3.5.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TNatureDocuments generated by hbm2java
 */
@Entity
@Table(name = "T_NATURE_DOCUMENTS", schema = "EMAP")
public class TNatureDocuments implements java.io.Serializable {

	private String nadCode;
	private String nadLibelle;
	private String nadAbrege;
	private String nadType;
	private Set<TDossierDacs> TDossierDacses = new HashSet<TDossierDacs>(0);

	public TNatureDocuments() {
	}

	public TNatureDocuments(String nadCode) {
		this.nadCode = nadCode;
	}

	public TNatureDocuments(String nadCode, String nadLibelle, String nadAbrege, String nadType,
			Set<TDossierDacs> TDossierDacses) {
		this.nadCode = nadCode;
		this.nadLibelle = nadLibelle;
		this.nadAbrege = nadAbrege;
		this.nadType = nadType;
		this.TDossierDacses = TDossierDacses;
	}

	@Id

	@Column(name = "NAD_CODE", unique = true, nullable = false, length = 3)
	public String getNadCode() {
		return this.nadCode;
	}

	public void setNadCode(String nadCode) {
		this.nadCode = nadCode;
	}

	@Column(name = "NAD_LIBELLE", length = 500)
	public String getNadLibelle() {
		return this.nadLibelle;
	}

	public void setNadLibelle(String nadLibelle) {
		this.nadLibelle = nadLibelle;
	}

	@Column(name = "NAD_ABREGE", length = 20)
	public String getNadAbrege() {
		return this.nadAbrege;
	}

	public void setNadAbrege(String nadAbrege) {
		this.nadAbrege = nadAbrege;
	}

	@Column(name = "NAD_TYPE", length = 3)
	public String getNadType() {
		return this.nadType;
	}

	public void setNadType(String nadType) {
		this.nadType = nadType;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TNatureDocuments")
	public Set<TDossierDacs> getTDossierDacses() {
		return this.TDossierDacses;
	}

	public void setTDossierDacses(Set<TDossierDacs> TDossierDacses) {
		this.TDossierDacses = TDossierDacses;
	}

}
