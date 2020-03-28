package com.sndi.models;
// Generated 28 mars 2020 03:24:07 by Hibernate Tools 4.3.5.Final

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
	private TSourceFinancement TSourceFinancement;
	private TDetailPlanGeneral TDetailPlanGeneral;
	private TDevise TDevise;
	private TBailleur TBailleur;
	private BigDecimal fipMontantCfa;
	private BigDecimal fipMontantDevise;
	private String fipCommentaire;
	private String fipTypeFinance;
	private BigDecimal fipTresor;

	public TFinancementPgpm() {
	}

	public TFinancementPgpm(long fipId, TSourceFinancement TSourceFinancement, TDetailPlanGeneral TDetailPlanGeneral,
			TDevise TDevise) {
		this.fipId = fipId;
		this.TSourceFinancement = TSourceFinancement;
		this.TDetailPlanGeneral = TDetailPlanGeneral;
		this.TDevise = TDevise;
	}

	public TFinancementPgpm(long fipId, TSourceFinancement TSourceFinancement, TDetailPlanGeneral TDetailPlanGeneral,
			TDevise TDevise, TBailleur TBailleur, BigDecimal fipMontantCfa, BigDecimal fipMontantDevise,
			String fipCommentaire, String fipTypeFinance, BigDecimal fipTresor) {
		this.fipId = fipId;
		this.TSourceFinancement = TSourceFinancement;
		this.TDetailPlanGeneral = TDetailPlanGeneral;
		this.TDevise = TDevise;
		this.TBailleur = TBailleur;
		this.fipMontantCfa = fipMontantCfa;
		this.fipMontantDevise = fipMontantDevise;
		this.fipCommentaire = fipCommentaire;
		this.fipTypeFinance = fipTypeFinance;
		this.fipTresor = fipTresor;
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
	@JoinColumn(name = "FIP_SOU_CODE", nullable = false)
	public TSourceFinancement getTSourceFinancement() {
		return this.TSourceFinancement;
	}

	public void setTSourceFinancement(TSourceFinancement TSourceFinancement) {
		this.TSourceFinancement = TSourceFinancement;
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
	@JoinColumn(name = "FIP_BAI_CODE")
	public TBailleur getTBailleur() {
		return this.TBailleur;
	}

	public void setTBailleur(TBailleur TBailleur) {
		this.TBailleur = TBailleur;
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

	@Column(name = "FIP_TYPE_FINANCE", length = 20)
	public String getFipTypeFinance() {
		return this.fipTypeFinance;
	}

	public void setFipTypeFinance(String fipTypeFinance) {
		this.fipTypeFinance = fipTypeFinance;
	}

	@Column(name = "FIP_TRESOR", precision = 22, scale = 0)
	public BigDecimal getFipTresor() {
		return this.fipTresor;
	}

	public void setFipTresor(BigDecimal fipTresor) {
		this.fipTresor = fipTresor;
	}

}
