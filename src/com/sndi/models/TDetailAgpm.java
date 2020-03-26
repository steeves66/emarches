package com.sndi.models;
// Generated 26 mars 2020 03:50:59 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * TDetailAgpm generated by hbm2java
 */
@Entity
@Table(name = "T_DETAIL_AGPM", schema = "EMAP")
public class TDetailAgpm implements java.io.Serializable {

	private BigDecimal tdaId;
	private TContenuAgpm TContenuAgpm;
	private TAgpm TAgpm;
	private String tdaCommentaire;
	private String tdaNumOrdre;
	private String tdaTitre;

	public TDetailAgpm() {
	}

	public TDetailAgpm(BigDecimal tdaId, TAgpm TAgpm) {
		this.tdaId = tdaId;
		this.TAgpm = TAgpm;
	}

	public TDetailAgpm(BigDecimal tdaId, TContenuAgpm TContenuAgpm, TAgpm TAgpm, String tdaCommentaire,
			String tdaNumOrdre, String tdaTitre) {
		this.tdaId = tdaId;
		this.TContenuAgpm = TContenuAgpm;
		this.TAgpm = TAgpm;
		this.tdaCommentaire = tdaCommentaire;
		this.tdaNumOrdre = tdaNumOrdre;
		this.tdaTitre = tdaTitre;
	}

	@Id

	@Column(name = "TDA_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getTdaId() {
		return this.tdaId;
	}

	public void setTdaId(BigDecimal tdaId) {
		this.tdaId = tdaId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TDA_TCA_CODE")
	public TContenuAgpm getTContenuAgpm() {
		return this.TContenuAgpm;
	}

	public void setTContenuAgpm(TContenuAgpm TContenuAgpm) {
		this.TContenuAgpm = TContenuAgpm;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TDA_AGP_ID", nullable = false)
	public TAgpm getTAgpm() {
		return this.TAgpm;
	}

	public void setTAgpm(TAgpm TAgpm) {
		this.TAgpm = TAgpm;
	}

	@Column(name = "TDA_COMMENTAIRE", length = 4000)
	public String getTdaCommentaire() {
		return this.tdaCommentaire;
	}

	public void setTdaCommentaire(String tdaCommentaire) {
		this.tdaCommentaire = tdaCommentaire;
	}

	@Column(name = "TDA_NUM_ORDRE", length = 3)
	public String getTdaNumOrdre() {
		return this.tdaNumOrdre;
	}

	public void setTdaNumOrdre(String tdaNumOrdre) {
		this.tdaNumOrdre = tdaNumOrdre;
	}

	@Column(name = "TDA_TITRE", length = 100)
	public String getTdaTitre() {
		return this.tdaTitre;
	}

	public void setTdaTitre(String tdaTitre) {
		this.tdaTitre = tdaTitre;
	}

}
