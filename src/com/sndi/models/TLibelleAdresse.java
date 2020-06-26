package com.sndi.models;
// Generated 25 juin 2020 13:53:46 by Hibernate Tools 4.3.5.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TLibelleAdresse generated by hbm2java
 */
@Entity
@Table(name = "T_LIBELLE_ADRESSE", schema = "EMAP")
public class TLibelleAdresse implements java.io.Serializable {

	private short liaNum;
	private String liaLibelle;
	private Set<TDetailAdresseAvis> TDetailAdresseAvises = new HashSet<TDetailAdresseAvis>(0);

	public TLibelleAdresse() {
	}

	public TLibelleAdresse(short liaNum) {
		this.liaNum = liaNum;
	}

	public TLibelleAdresse(short liaNum, String liaLibelle, Set<TDetailAdresseAvis> TDetailAdresseAvises) {
		this.liaNum = liaNum;
		this.liaLibelle = liaLibelle;
		this.TDetailAdresseAvises = TDetailAdresseAvises;
	}

	@Id

	@Column(name = "LIA_NUM", unique = true, nullable = false, precision = 3, scale = 0)
	public short getLiaNum() {
		return this.liaNum;
	}

	public void setLiaNum(short liaNum) {
		this.liaNum = liaNum;
	}

	@Column(name = "LIA_LIBELLE", length = 500)
	public String getLiaLibelle() {
		return this.liaLibelle;
	}

	public void setLiaLibelle(String liaLibelle) {
		this.liaLibelle = liaLibelle;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TLibelleAdresse")
	public Set<TDetailAdresseAvis> getTDetailAdresseAvises() {
		return this.TDetailAdresseAvises;
	}

	public void setTDetailAdresseAvises(Set<TDetailAdresseAvis> TDetailAdresseAvises) {
		this.TDetailAdresseAvises = TDetailAdresseAvises;
	}

}