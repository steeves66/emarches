package com.sndi.model;
// Generated 7 f�vr. 2020 18:25:23 by Hibernate Tools 4.3.5.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sndi.model.TDossierDemande;

/**
 * TNatureDocuments generated by hbm2java
 */
@Entity
@Table(name = "T_NATURE_DOCUMENTS", schema = "EMAP")
public class TNatureDocuments implements java.io.Serializable {

	private short nadCode;
	private String nadLibelle;
	private String nadAbrege;
	private String nadType;
	private Set<TDossierDacs> TDossierDacses = new HashSet<TDossierDacs>(0);

	public TNatureDocuments() {
	}

	public TNatureDocuments(short nadCode) {
		this.nadCode = nadCode;
	}

	public TNatureDocuments(short nadCode, String nadLibelle, String nadAbrege, String nadType,
			Set<TDossierDacs> TDossierDacses) {
		this.nadCode = nadCode;
		this.nadLibelle = nadLibelle;
		this.nadAbrege = nadAbrege;
		this.nadType = nadType;
		this.TDossierDacses = TDossierDacses;
	}

	@Id

	@Column(name = "NAD_CODE", unique = true, nullable = false, length = 3)
	public short getNadCode() {
		return this.nadCode;
	}

	public void setNadCode(short nadCode) {
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
