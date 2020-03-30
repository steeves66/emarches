package com.sndi.models;
// Generated 30 mars 2020 01:35:59 by Hibernate Tools 4.3.5.Final

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
 * THistoAgpm generated by hbm2java
 */
@Entity
@Table(name = "T_HISTO_AGPM", schema = "EMAP")
public class THistoAgpm implements java.io.Serializable {

	private long hagId;
	private TAgpm TAgpm;
	private TOperateur TOperateur;
	private TStatut TStatut;
	private TFonction TFonction;
	private Date hagDate;
	private String hagMotif;

	public THistoAgpm() {
	}

	public THistoAgpm(long hagId, TAgpm TAgpm, TStatut TStatut) {
		this.hagId = hagId;
		this.TAgpm = TAgpm;
		this.TStatut = TStatut;
	}

	public THistoAgpm(long hagId, TAgpm TAgpm, TOperateur TOperateur, TStatut TStatut, TFonction TFonction,
			Date hagDate, String hagMotif) {
		this.hagId = hagId;
		this.TAgpm = TAgpm;
		this.TOperateur = TOperateur;
		this.TStatut = TStatut;
		this.TFonction = TFonction;
		this.hagDate = hagDate;
		this.hagMotif = hagMotif;
	}

	@Id

	@Column(name = "HAG_ID", unique = true, nullable = false, precision = 10, scale = 0)
	public long getHagId() {
		return this.hagId;
	}

	public void setHagId(long hagId) {
		this.hagId = hagId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "HAG_AGP_ID", nullable = false)
	public TAgpm getTAgpm() {
		return this.TAgpm;
	}

	public void setTAgpm(TAgpm TAgpm) {
		this.TAgpm = TAgpm;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "HAG_OPE_MATRICULE")
	public TOperateur getTOperateur() {
		return this.TOperateur;
	}

	public void setTOperateur(TOperateur TOperateur) {
		this.TOperateur = TOperateur;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "HAG_STA_CODE", nullable = false)
	public TStatut getTStatut() {
		return this.TStatut;
	}

	public void setTStatut(TStatut TStatut) {
		this.TStatut = TStatut;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "HAG_FON_COD")
	public TFonction getTFonction() {
		return this.TFonction;
	}

	public void setTFonction(TFonction TFonction) {
		this.TFonction = TFonction;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "HAG_DATE", length = 7)
	public Date getHagDate() {
		return this.hagDate;
	}

	public void setHagDate(Date hagDate) {
		this.hagDate = hagDate;
	}

	@Column(name = "HAG_MOTIF", length = 1000)
	public String getHagMotif() {
		return this.hagMotif;
	}

	public void setHagMotif(String hagMotif) {
		this.hagMotif = hagMotif;
	}

}
