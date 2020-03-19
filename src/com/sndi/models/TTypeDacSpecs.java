package com.sndi.models;
// Generated 19 mars 2020 16:14:06 by Hibernate Tools 4.3.5.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TTypeDacSpecs generated by hbm2java
 */
@Entity
@Table(name = "T_TYPE_DAC_SPECS", schema = "EMAP")
public class TTypeDacSpecs implements java.io.Serializable {

	private String tdcCode;
	private String tdcLibelle;
	private Set<TDacSpecs> TDacSpecses = new HashSet<TDacSpecs>(0);

	public TTypeDacSpecs() {
	}

	public TTypeDacSpecs(String tdcCode) {
		this.tdcCode = tdcCode;
	}

	public TTypeDacSpecs(String tdcCode, String tdcLibelle, Set<TDacSpecs> TDacSpecses) {
		this.tdcCode = tdcCode;
		this.tdcLibelle = tdcLibelle;
		this.TDacSpecses = TDacSpecses;
	}

	@Id

	@Column(name = "TDC_CODE", unique = true, nullable = false, length = 3)
	public String getTdcCode() {
		return this.tdcCode;
	}

	public void setTdcCode(String tdcCode) {
		this.tdcCode = tdcCode;
	}

	@Column(name = "TDC_LIBELLE", length = 1000)
	public String getTdcLibelle() {
		return this.tdcLibelle;
	}

	public void setTdcLibelle(String tdcLibelle) {
		this.tdcLibelle = tdcLibelle;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TTypeDacSpecs")
	public Set<TDacSpecs> getTDacSpecses() {
		return this.TDacSpecses;
	}

	public void setTDacSpecses(Set<TDacSpecs> TDacSpecses) {
		this.TDacSpecses = TDacSpecses;
	}

}
