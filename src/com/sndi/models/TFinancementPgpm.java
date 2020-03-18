package com.sndi.models;
// Generated 14 mars 2020 14:41:40 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * TFinancementPgpm generated by hbm2java
 */
@Entity
@Table(name = "T_FINANCEMENT_PGPM", schema = "EMAP")
public class TFinancementPgpm implements java.io.Serializable {

	private long fipId;
	private TBailleur TBailleur;
	private TDetailPlanGeneral TDetailPlanGeneral;
	private TDevise TDevise;
	private TSourceFinancement TSourceFinancement;
	private BigDecimal fipMontantCfa;
	private BigDecimal fipMontantDevise;
	private String fipCommentaire;

	public TFinancementPgpm() {
	}

	public TFinancementPgpm(long fipId, TBailleur TBailleur, TDetailPlanGeneral TDetailPlanGeneral, TDevise TDevise,
			TSourceFinancement TSourceFinancement) {
		this.fipId = fipId;
		this.TBailleur = TBailleur;
		this.TDetailPlanGeneral = TDetailPlanGeneral;
		this.TDevise = TDevise;
		this.TSourceFinancement = TSourceFinancement;
	}

	public TFinancementPgpm(long fipId, TBailleur TBailleur, TDetailPlanGeneral TDetailPlanGeneral, TDevise TDevise,
			TSourceFinancement TSourceFinancement, BigDecimal fipMontantCfa, BigDecimal fipMontantDevise,
			String fipCommentaire) {
		this.fipId = fipId;
		this.TBailleur = TBailleur;
		this.TDetailPlanGeneral = TDetailPlanGeneral;
		this.TDevise = TDevise;
		this.TSourceFinancement = TSourceFinancement;
		this.fipMontantCfa = fipMontantCfa;
		this.fipMontantDevise = fipMontantDevise;
		this.fipCommentaire = fipCommentaire;
	}

	@Id

	@Column(name = "FIP_ID", unique = true, nullable = false, precision = 10, scale = 0)
	public long getFipId() {
		return this.fipId;
	}

	public void setFipId(long fipId) {
		this.fipId = fipId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FIP_BAI_CODE", nullable = false)
	public TBailleur getTBailleur() {
		return this.TBailleur;
	}

	public void setTBailleur(TBailleur TBailleur) {
		this.TBailleur = TBailleur;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FIP_GPG_ID", nullable = false)
	public TDetailPlanGeneral getTDetailPlanGeneral() {
		return this.TDetailPlanGeneral;
	}

	public void setTDetailPlanGeneral(TDetailPlanGeneral TDetailPlanGeneral) {
		this.TDetailPlanGeneral = TDetailPlanGeneral;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FIP_DEV_CODE", nullable = false)
	public TDevise getTDevise() {
		return this.TDevise;
	}

	public void setTDevise(TDevise TDevise) {
		this.TDevise = TDevise;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FIP_SOU_CODE", nullable = false)
	public TSourceFinancement getTSourceFinancement() {
		return this.TSourceFinancement;
	}

	public void setTSourceFinancement(TSourceFinancement TSourceFinancement) {
		this.TSourceFinancement = TSourceFinancement;
	}

	@Column(name = "FIP_MONTANT_CFA", precision = 15)
	public BigDecimal getFipMontantCfa() {
		return this.fipMontantCfa;
	}

	public void setFipMontantCfa(BigDecimal fipMontantCfa) {
		this.fipMontantCfa = fipMontantCfa;
	}

	@Column(name = "FIP_MONTANT_DEVISE", precision = 15)
	public BigDecimal getFipMontantDevise() {
		return this.fipMontantDevise;
	}

	public void setFipMontantDevise(BigDecimal fipMontantDevise) {
		this.fipMontantDevise = fipMontantDevise;
	}

	@Column(name = "FIP_COMMENTAIRE", length = 500)
	public String getFipCommentaire() {
		return this.fipCommentaire;
	}

	public void setFipCommentaire(String fipCommentaire) {
		this.fipCommentaire = fipCommentaire;
	}

}
