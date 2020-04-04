package com.sndi.models;
// Generated 4 avr. 2020 18:03:14 by Hibernate Tools 4.3.5.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TContenuAgpm generated by hbm2java
 */
@Entity
@Table(name = "T_CONTENU_AGPM", schema = "EMAP")
public class TContenuAgpm implements java.io.Serializable {

	private String tcaCode;
	private String tcaLibelle;
	private Set<TDetailAgpm> TDetailAgpms = new HashSet<TDetailAgpm>(0);

	public TContenuAgpm() {
	}

	public TContenuAgpm(String tcaCode) {
		this.tcaCode = tcaCode;
	}

	public TContenuAgpm(String tcaCode, String tcaLibelle, Set<TDetailAgpm> TDetailAgpms) {
		this.tcaCode = tcaCode;
		this.tcaLibelle = tcaLibelle;
		this.TDetailAgpms = TDetailAgpms;
	}

	@Id

	@Column(name = "TCA_CODE", unique = true, nullable = false, length = 4)
	public String getTcaCode() {
		return this.tcaCode;
	}

	public void setTcaCode(String tcaCode) {
		this.tcaCode = tcaCode;
	}

	@Column(name = "TCA_LIBELLE", length = 200)
	public String getTcaLibelle() {
		return this.tcaLibelle;
	}

	public void setTcaLibelle(String tcaLibelle) {
		this.tcaLibelle = tcaLibelle;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TContenuAgpm")
	public Set<TDetailAgpm> getTDetailAgpms() {
		return this.TDetailAgpms;
	}

	public void setTDetailAgpms(Set<TDetailAgpm> TDetailAgpms) {
		this.TDetailAgpms = TDetailAgpms;
	}

}
