package com.sndi.model;
// Generated 30 nov. 2019 13:40:49 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
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

/**
 * TFinancementPgpm generated by hbm2java
 */
@Entity
@Table(name = "T_FINANCEMENT_PGPM", schema = "EMAP")
public class TFinancementPgpm implements java.io.Serializable {

	private long fipId;
	private TDetailPlanGeneral TDetailPlanGeneral;
	private TBailleur TBailleur;
	private TSourceFinancement TSourceFinancement;
	private TDevise TDevise;
	private long fipMontantCfa;
	private BigDecimal fipMontantDevise;
	private String fipCommentaire;
	private String fipTypeFinance;
	private long fipPartTresor;

	public TFinancementPgpm() {
	}

	public TFinancementPgpm(long fipId, TDetailPlanGeneral TDetailPlanGeneral, TBailleur TBailleur,
			TSourceFinancement TSourceFinancement, TDevise TDevise) {
		this.fipId = fipId;
		this.TDetailPlanGeneral = TDetailPlanGeneral;
		this.TBailleur = TBailleur;
		this.TSourceFinancement = TSourceFinancement;
		this.TDevise = TDevise;
	}

	public TFinancementPgpm(long fipId, TDetailPlanGeneral TDetailPlanGeneral, TBailleur TBailleur,
			TSourceFinancement TSourceFinancement, TDevise TDevise, long fipMontantCfa,
			BigDecimal fipMontantDevise, String fipCommentaire, String fipTypeFinance,long fipPartTresor) {
		this.fipId = fipId;
		this.TDetailPlanGeneral = TDetailPlanGeneral;
		this.TBailleur = TBailleur;
		this.TSourceFinancement = TSourceFinancement;
		this.TDevise = TDevise;
		this.fipMontantCfa = fipMontantCfa;
		this.fipMontantDevise = fipMontantDevise;
		this.fipCommentaire = fipCommentaire;
		this.fipTypeFinance = fipTypeFinance;
		this.fipPartTresor = fipPartTresor;
	}

	@Id
	@SequenceGenerator(name = "SEQ_FIP_Sequence", sequenceName = "SEQ_FIP", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_FIP_Sequence")
	@Column(name = "FIP_ID", unique = true, nullable = false, precision = 10, scale = 0)
	public long getFipId() {
		return this.fipId;
	}

	public void setFipId(long fipId) {
		this.fipId = fipId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "FIP_GPG_ID", nullable = false)
	public TDetailPlanGeneral getTDetailPlanGeneral() {
		return this.TDetailPlanGeneral;
	}

	public void setTDetailPlanGeneral(TDetailPlanGeneral TDetailPlanGeneral) {
		this.TDetailPlanGeneral = TDetailPlanGeneral;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "FIP_BAI_CODE")
	public TBailleur getTBailleur() {
		return this.TBailleur;
	}

	public void setTBailleur(TBailleur TBailleur) {
		this.TBailleur = TBailleur;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "FIP_SOU_CODE", nullable = false)
	public TSourceFinancement getTSourceFinancement() {
		return this.TSourceFinancement;
	}

	public void setTSourceFinancement(TSourceFinancement TSourceFinancement) {
		this.TSourceFinancement = TSourceFinancement;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "FIP_DEV_CODE", nullable = false)
	public TDevise getTDevise() {
		return this.TDevise;
	}

	public void setTDevise(TDevise TDevise) {
		this.TDevise = TDevise;
	}

	@Column(name = "FIP_MONTANT_CFA", precision = 15)
	public long getFipMontantCfa() {
		return this.fipMontantCfa;
	}

	public void setFipMontantCfa(long fipMontantCfa) {
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
	
	@Column(name = "FIP_PART_TRESOR", precision = 15, scale = 0)
	public long getFipPartTresor() {
		return this.fipPartTresor;
	}

	public void setFipPartTresor(long fipPartTresor) {
		this.fipPartTresor = fipPartTresor;
	}

}
