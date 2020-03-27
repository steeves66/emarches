package com.sndi.models;
// Generated 27 mars 2020 22:20:54 by Hibernate Tools 4.3.5.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * TAssignation generated by hbm2java
 */
@Entity
@Table(name = "T_ASSIGNATION", schema = "EMAP")
public class TAssignation implements java.io.Serializable {

	private long assNum;
	private TFonction TFonction;
	private TOperateur TOperateur;
	private Date assDatDeb;
	private Date assDatFin;
	private String assCourant;
	private Boolean assStatut;

	public TAssignation() {
	}

	public TAssignation(long assNum) {
		this.assNum = assNum;
	}

	public TAssignation(long assNum, TFonction TFonction, TOperateur TOperateur, Date assDatDeb, Date assDatFin,
			String assCourant, Boolean assStatut) {
		this.assNum = assNum;
		this.TFonction = TFonction;
		this.TOperateur = TOperateur;
		this.assDatDeb = assDatDeb;
		this.assDatFin = assDatFin;
		this.assCourant = assCourant;
		this.assStatut = assStatut;
	}

	@Id

	@Column(name = "ASS_NUM", unique = true, nullable = false, precision = 10, scale = 0)
	public long getAssNum() {
		return this.assNum;
	}

	public void setAssNum(long assNum) {
		this.assNum = assNum;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ASS_FON_COD")
	public TFonction getTFonction() {
		return this.TFonction;
	}

	public void setTFonction(TFonction TFonction) {
		this.TFonction = TFonction;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ASS_OPE_MATRICULE")
	public TOperateur getTOperateur() {
		return this.TOperateur;
	}

	public void setTOperateur(TOperateur TOperateur) {
		this.TOperateur = TOperateur;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "ASS_DAT_DEB", length = 7)
	public Date getAssDatDeb() {
		return this.assDatDeb;
	}

	public void setAssDatDeb(Date assDatDeb) {
		this.assDatDeb = assDatDeb;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "ASS_DAT_FIN", length = 7)
	public Date getAssDatFin() {
		return this.assDatFin;
	}

	public void setAssDatFin(Date assDatFin) {
		this.assDatFin = assDatFin;
	}

	@Column(name = "ASS_COURANT", length = 10)
	public String getAssCourant() {
		return this.assCourant;
	}

	public void setAssCourant(String assCourant) {
		this.assCourant = assCourant;
	}

	@Column(name = "ASS_STATUT", precision = 1, scale = 0)
	public Boolean getAssStatut() {
		return this.assStatut;
	}

	public void setAssStatut(Boolean assStatut) {
		this.assStatut = assStatut;
	}

}
