package com.sndi.models;
// Generated 8 ao�t 2020 14:11:26 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * TFinancementPpm generated by hbm2java
 */
@Entity
@Table(name = "T_FINANCEMENT_PPM", schema = "EMAP")
public class TFinancementPpm implements java.io.Serializable {

	private long fppId;
	private TBailleur TBailleur;
	private TDetailPlanPassation TDetailPlanPassation;
	private TDevise TDevise;
	private TSourceFinancement TSourceFinancement;
	private BigDecimal fppMontantCfa;
	private BigDecimal fppMontantDevise;
	private String fppCommentaire;
	private String fppTypeFinance;
	private Long fppPartTresor;

	public TFinancementPpm() {
	}

	public TFinancementPpm(long fppId, TBailleur TBailleur, TDetailPlanPassation TDetailPlanPassation,
			TDevise TDevise) {
		this.fppId = fppId;
		this.TBailleur = TBailleur;
		this.TDetailPlanPassation = TDetailPlanPassation;
		this.TDevise = TDevise;
	}

	public TFinancementPpm(long fppId, TBailleur TBailleur, TDetailPlanPassation TDetailPlanPassation, TDevise TDevise,
			TSourceFinancement TSourceFinancement, BigDecimal fppMontantCfa, BigDecimal fppMontantDevise,
			String fppCommentaire, String fppTypeFinance, Long fppPartTresor) {
		this.fppId = fppId;
		this.TBailleur = TBailleur;
		this.TDetailPlanPassation = TDetailPlanPassation;
		this.TDevise = TDevise;
		this.TSourceFinancement = TSourceFinancement;
		this.fppMontantCfa = fppMontantCfa;
		this.fppMontantDevise = fppMontantDevise;
		this.fppCommentaire = fppCommentaire;
		this.fppTypeFinance = fppTypeFinance;
		this.fppPartTresor = fppPartTresor;
	}

	@Id

	@Column(name = "FPP_ID", unique = true, nullable = false, precision = 10, scale = 0)
	public long getFppId() {
		return this.fppId;
	}

	public void setFppId(long fppId) {
		this.fppId = fppId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FPP_BAI_CODE", nullable = false)
	public TBailleur getTBailleur() {
		return this.TBailleur;
	}

	public void setTBailleur(TBailleur TBailleur) {
		this.TBailleur = TBailleur;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FPP_DPP_ID", nullable = false)
	public TDetailPlanPassation getTDetailPlanPassation() {
		return this.TDetailPlanPassation;
	}

	public void setTDetailPlanPassation(TDetailPlanPassation TDetailPlanPassation) {
		this.TDetailPlanPassation = TDetailPlanPassation;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FPP_DEV_CODE", nullable = false)
	public TDevise getTDevise() {
		return this.TDevise;
	}

	public void setTDevise(TDevise TDevise) {
		this.TDevise = TDevise;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FPP_SOU_CODE")
	public TSourceFinancement getTSourceFinancement() {
		return this.TSourceFinancement;
	}

	public void setTSourceFinancement(TSourceFinancement TSourceFinancement) {
		this.TSourceFinancement = TSourceFinancement;
	}

	@Column(name = "FPP_MONTANT_CFA", precision = 15)
	public BigDecimal getFppMontantCfa() {
		return this.fppMontantCfa;
	}

	public void setFppMontantCfa(BigDecimal fppMontantCfa) {
		this.fppMontantCfa = fppMontantCfa;
	}

	@Column(name = "FPP_MONTANT_DEVISE", precision = 15)
	public BigDecimal getFppMontantDevise() {
		return this.fppMontantDevise;
	}

	public void setFppMontantDevise(BigDecimal fppMontantDevise) {
		this.fppMontantDevise = fppMontantDevise;
	}

	@Column(name = "FPP_COMMENTAIRE", length = 500)
	public String getFppCommentaire() {
		return this.fppCommentaire;
	}

	public void setFppCommentaire(String fppCommentaire) {
		this.fppCommentaire = fppCommentaire;
	}

	@Column(name = "FPP_TYPE_FINANCE", length = 20)
	public String getFppTypeFinance() {
		return this.fppTypeFinance;
	}

	public void setFppTypeFinance(String fppTypeFinance) {
		this.fppTypeFinance = fppTypeFinance;
	}

	@Column(name = "FPP_PART_TRESOR", precision = 15, scale = 0)
	public Long getFppPartTresor() {
		return this.fppPartTresor;
	}

	public void setFppPartTresor(Long fppPartTresor) {
		this.fppPartTresor = fppPartTresor;
	}

}
