package com.sndi.model;
// Generated 30 nov. 2019 13:40:49 by Hibernate Tools 4.3.5.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



/**
 * THistoPlanGeneral generated by hbm2java
 */
@Entity
@Table(name = "T_HISTO_PLAN_GENERAL", schema = "EMAP")
public class THistoPlanGeneral implements java.io.Serializable {

	private long hpgId;
	private TFonction TFonction;
	private TDetailPlanGeneral TDetailPlanGeneral;
	private TOperateur TOperateur;
	private TStatut TStatut;
	private Date hpgDate;
	private String hpgMotif;

	public THistoPlanGeneral() {
	}

	public THistoPlanGeneral(long hpgId, TFonction TFonction, TDetailPlanGeneral TDetailPlanGeneral, TStatut TStatut) {
		this.hpgId = hpgId;
		this.TFonction = TFonction;
		this.TDetailPlanGeneral = TDetailPlanGeneral;
		this.TStatut = TStatut;
	}

	public THistoPlanGeneral(long hpgId, TFonction TFonction, TDetailPlanGeneral TDetailPlanGeneral,TOperateur TOperateur, TStatut TStatut,
			Date hpgDate, String hpgMotif) {
		this.hpgId = hpgId;
		this.TFonction = TFonction;
		this.TDetailPlanGeneral = TDetailPlanGeneral;
		this.TOperateur = TOperateur;
		this.TStatut = TStatut;
		this.hpgDate = hpgDate;
		this.hpgMotif = hpgMotif;
	}

	@Id
	@SequenceGenerator(name = "SEQ_HPG_Sequence", sequenceName = "SEQ_HPG", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_HPG_Sequence")
	@Column(name = "HPG_ID", unique = true, nullable = false, precision = 10, scale = 0)
	public long getHpgId() {
		return this.hpgId;
	}

	public void setHpgId(long hpgId) {
		this.hpgId = hpgId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "HPG_FON_COD", nullable = false)
	public TFonction getTFonction() {
		return this.TFonction;
	}

	public void setTFonction(TFonction TFonction) {
		this.TFonction = TFonction;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "HPG_GPG_ID", nullable = false)
	public TDetailPlanGeneral getTDetailPlanGeneral() {
		return this.TDetailPlanGeneral;
	}

	public void setTDetailPlanGeneral(TDetailPlanGeneral TDetailPlanGeneral) {
		this.TDetailPlanGeneral = TDetailPlanGeneral;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "HPG_OPE_MATRICULE")
	public TOperateur getTOperateur() {
		return this.TOperateur;
	}

	public void setTOperateur(TOperateur TOperateur) {
		this.TOperateur = TOperateur;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "HPG_STA_CODE", nullable = false)
	public TStatut getTStatut() {
		return this.TStatut;
	}

	public void setTStatut(TStatut TStatut) {
		this.TStatut = TStatut;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "HPG_DATE", length = 7)
	public Date getHpgDate() {
		return this.hpgDate;
	}

	public void setHpgDate(Date hpgDate) {
		this.hpgDate = hpgDate;
	}

	@Column(name = "HPG_MOTIF", length = 1000)
	public String getHpgMotif() {
		return this.hpgMotif;
	}

	public void setHpgMotif(String hpgMotif) {
		this.hpgMotif = hpgMotif;
	}

}
