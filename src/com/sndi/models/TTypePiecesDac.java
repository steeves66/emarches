package com.sndi.models;
// Generated 22 mars 2020 01:52:15 by Hibernate Tools 4.3.5.Final

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

/**
 * TTypePiecesDac generated by hbm2java
 */
@Entity
@Table(name = "T_TYPE_PIECES_DAC", schema = "EMAP")
public class TTypePiecesDac implements java.io.Serializable {

	private String tpiCode;
	private TModeleDacType TModeleDacType;
	private String tpiLibelle;
	private String tpiDacPec;
	private String tpiSecNum;
	private Set<TPiecesDacs> TPiecesDacses = new HashSet<TPiecesDacs>(0);

	public TTypePiecesDac() {
	}

	public TTypePiecesDac(String tpiCode) {
		this.tpiCode = tpiCode;
	}

	public TTypePiecesDac(String tpiCode, TModeleDacType TModeleDacType, String tpiLibelle, String tpiDacPec,
			String tpiSecNum, Set<TPiecesDacs> TPiecesDacses) {
		this.tpiCode = tpiCode;
		this.TModeleDacType = TModeleDacType;
		this.tpiLibelle = tpiLibelle;
		this.tpiDacPec = tpiDacPec;
		this.tpiSecNum = tpiSecNum;
		this.TPiecesDacses = TPiecesDacses;
	}

	@Id

	@Column(name = "TPI_CODE", unique = true, nullable = false, length = 10)
	public String getTpiCode() {
		return this.tpiCode;
	}

	public void setTpiCode(String tpiCode) {
		this.tpiCode = tpiCode;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TPI_MDT_CODE")
	public TModeleDacType getTModeleDacType() {
		return this.TModeleDacType;
	}

	public void setTModeleDacType(TModeleDacType TModeleDacType) {
		this.TModeleDacType = TModeleDacType;
	}

	@Column(name = "TPI_LIBELLE", length = 1000)
	public String getTpiLibelle() {
		return this.tpiLibelle;
	}

	public void setTpiLibelle(String tpiLibelle) {
		this.tpiLibelle = tpiLibelle;
	}

	@Column(name = "TPI_DAC_PEC", length = 15)
	public String getTpiDacPec() {
		return this.tpiDacPec;
	}

	public void setTpiDacPec(String tpiDacPec) {
		this.tpiDacPec = tpiDacPec;
	}

	@Column(name = "TPI_SEC_NUM", length = 5)
	public String getTpiSecNum() {
		return this.tpiSecNum;
	}

	public void setTpiSecNum(String tpiSecNum) {
		this.tpiSecNum = tpiSecNum;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TTypePiecesDac")
	public Set<TPiecesDacs> getTPiecesDacses() {
		return this.TPiecesDacses;
	}

	public void setTPiecesDacses(Set<TPiecesDacs> TPiecesDacses) {
		this.TPiecesDacses = TPiecesDacses;
	}

}
