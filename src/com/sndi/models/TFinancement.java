package com.sndi.models;
// Generated 20 juin 2020 17:16:02 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
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
 * TFinancement generated by hbm2java
 */
@Entity
@Table(name = "T_FINANCEMENT", schema = "EMAP")
public class TFinancement implements java.io.Serializable {

	private long finId;
	private TProjet TProjet;
	private TSourceFinancement TSourceFinancement;
	private TDevise TDevise;
	private TAgpm TAgpm;
	private TBailleur TBailleur;
	private BigDecimal finMontantCfa;
	private BigDecimal finMontantDevise;
	private String finNumeroAccord;
	private String finStatut;
	private String finTypeFinance;
	private Long finPartTresor;
	private Set<TAffichageAgpm> TAffichageAgpms = new HashSet<TAffichageAgpm>(0);

	public TFinancement() {
	}

	public TFinancement(long finId, TProjet TProjet, TSourceFinancement TSourceFinancement, TDevise TDevise) {
		this.finId = finId;
		this.TProjet = TProjet;
		this.TSourceFinancement = TSourceFinancement;
		this.TDevise = TDevise;
	}

	public TFinancement(long finId, TProjet TProjet, TSourceFinancement TSourceFinancement, TDevise TDevise,
			TAgpm TAgpm, TBailleur TBailleur, BigDecimal finMontantCfa, BigDecimal finMontantDevise,
			String finNumeroAccord, String finStatut, String finTypeFinance, Long finPartTresor,
			Set<TAffichageAgpm> TAffichageAgpms) {
		this.finId = finId;
		this.TProjet = TProjet;
		this.TSourceFinancement = TSourceFinancement;
		this.TDevise = TDevise;
		this.TAgpm = TAgpm;
		this.TBailleur = TBailleur;
		this.finMontantCfa = finMontantCfa;
		this.finMontantDevise = finMontantDevise;
		this.finNumeroAccord = finNumeroAccord;
		this.finStatut = finStatut;
		this.finTypeFinance = finTypeFinance;
		this.finPartTresor = finPartTresor;
		this.TAffichageAgpms = TAffichageAgpms;
	}

	@Id

	@Column(name = "FIN_ID", unique = true, nullable = false, precision = 10, scale = 0)
	public long getFinId() {
		return this.finId;
	}

	public void setFinId(long finId) {
		this.finId = finId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FIN_PRO_ID", nullable = false)
	public TProjet getTProjet() {
		return this.TProjet;
	}

	public void setTProjet(TProjet TProjet) {
		this.TProjet = TProjet;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FIN_SOU_CODE", nullable = false)
	public TSourceFinancement getTSourceFinancement() {
		return this.TSourceFinancement;
	}

	public void setTSourceFinancement(TSourceFinancement TSourceFinancement) {
		this.TSourceFinancement = TSourceFinancement;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FIN_DEV_CODE", nullable = false)
	public TDevise getTDevise() {
		return this.TDevise;
	}

	public void setTDevise(TDevise TDevise) {
		this.TDevise = TDevise;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FIN_AGP_ID")
	public TAgpm getTAgpm() {
		return this.TAgpm;
	}

	public void setTAgpm(TAgpm TAgpm) {
		this.TAgpm = TAgpm;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FIN_BAI_CODE")
	public TBailleur getTBailleur() {
		return this.TBailleur;
	}

	public void setTBailleur(TBailleur TBailleur) {
		this.TBailleur = TBailleur;
	}

	@Column(name = "FIN_MONTANT_CFA", precision = 15)
	public BigDecimal getFinMontantCfa() {
		return this.finMontantCfa;
	}

	public void setFinMontantCfa(BigDecimal finMontantCfa) {
		this.finMontantCfa = finMontantCfa;
	}

	@Column(name = "FIN_MONTANT_DEVISE", precision = 15)
	public BigDecimal getFinMontantDevise() {
		return this.finMontantDevise;
	}

	public void setFinMontantDevise(BigDecimal finMontantDevise) {
		this.finMontantDevise = finMontantDevise;
	}

	@Column(name = "FIN_NUMERO_ACCORD", length = 500)
	public String getFinNumeroAccord() {
		return this.finNumeroAccord;
	}

	public void setFinNumeroAccord(String finNumeroAccord) {
		this.finNumeroAccord = finNumeroAccord;
	}

	@Column(name = "FIN_STATUT", length = 10)
	public String getFinStatut() {
		return this.finStatut;
	}

	public void setFinStatut(String finStatut) {
		this.finStatut = finStatut;
	}

	@Column(name = "FIN_TYPE_FINANCE", length = 20)
	public String getFinTypeFinance() {
		return this.finTypeFinance;
	}

	public void setFinTypeFinance(String finTypeFinance) {
		this.finTypeFinance = finTypeFinance;
	}

	@Column(name = "FIN_PART_TRESOR", precision = 15, scale = 0)
	public Long getFinPartTresor() {
		return this.finPartTresor;
	}

	public void setFinPartTresor(Long finPartTresor) {
		this.finPartTresor = finPartTresor;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TFinancement")
	public Set<TAffichageAgpm> getTAffichageAgpms() {
		return this.TAffichageAgpms;
	}

	public void setTAffichageAgpms(Set<TAffichageAgpm> TAffichageAgpms) {
		this.TAffichageAgpms = TAffichageAgpms;
	}

}
