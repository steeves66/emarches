package com.sndi.models;
// Generated 31 mars 2020 01:27:37 by Hibernate Tools 4.3.5.Final

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
 * THistoDac generated by hbm2java
 */
@Entity
@Table(name = "T_HISTO_DAC", schema = "EMAP")
public class THistoDac implements java.io.Serializable {

	private long hacId;
	private TStatut TStatut;
	private TDacSpecs TDacSpecs;
	private TFonction TFonction;
	private TOperateur TOperateur;
	private Date hacDate;
	private String hacCommentaire;

	public THistoDac() {
	}

	public THistoDac(long hacId, TStatut TStatut, TDacSpecs TDacSpecs, TFonction TFonction, TOperateur TOperateur) {
		this.hacId = hacId;
		this.TStatut = TStatut;
		this.TDacSpecs = TDacSpecs;
		this.TFonction = TFonction;
		this.TOperateur = TOperateur;
	}

	public THistoDac(long hacId, TStatut TStatut, TDacSpecs TDacSpecs, TFonction TFonction, TOperateur TOperateur,
			Date hacDate, String hacCommentaire) {
		this.hacId = hacId;
		this.TStatut = TStatut;
		this.TDacSpecs = TDacSpecs;
		this.TFonction = TFonction;
		this.TOperateur = TOperateur;
		this.hacDate = hacDate;
		this.hacCommentaire = hacCommentaire;
	}

	@Id

	@Column(name = "HAC_ID", unique = true, nullable = false, precision = 10, scale = 0)
	public long getHacId() {
		return this.hacId;
	}

	public void setHacId(long hacId) {
		this.hacId = hacId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "HAC_STA_CODE", nullable = false)
	public TStatut getTStatut() {
		return this.TStatut;
	}

	public void setTStatut(TStatut TStatut) {
		this.TStatut = TStatut;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "HAC_DAC_CODE", nullable = false)
	public TDacSpecs getTDacSpecs() {
		return this.TDacSpecs;
	}

	public void setTDacSpecs(TDacSpecs TDacSpecs) {
		this.TDacSpecs = TDacSpecs;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "HAC_FON_COD", nullable = false)
	public TFonction getTFonction() {
		return this.TFonction;
	}

	public void setTFonction(TFonction TFonction) {
		this.TFonction = TFonction;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "HAC_OPE_MAT", nullable = false)
	public TOperateur getTOperateur() {
		return this.TOperateur;
	}

	public void setTOperateur(TOperateur TOperateur) {
		this.TOperateur = TOperateur;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "HAC_DATE", length = 7)
	public Date getHacDate() {
		return this.hacDate;
	}

	public void setHacDate(Date hacDate) {
		this.hacDate = hacDate;
	}

	@Column(name = "HAC_COMMENTAIRE", length = 1000)
	public String getHacCommentaire() {
		return this.hacCommentaire;
	}

	public void setHacCommentaire(String hacCommentaire) {
		this.hacCommentaire = hacCommentaire;
	}

}
