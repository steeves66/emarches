package com.sndi.models;
// Generated 22 mars 2020 01:52:15 by Hibernate Tools 4.3.5.Final

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
 * TProjet generated by hbm2java
 */
@Entity
@Table(name = "T_PROJET", schema = "EMAP")
public class TProjet implements java.io.Serializable {

	private long proId;
	private TReglementation TReglementation;
	private String proCode;
	private String proTitre;
	private String proLibelle;
	private String proDescription;
	private BigDecimal proMontantTotCfa;
	private String proTypeProjet;
	private Set<TObjectifGen> TObjectifGens = new HashSet<TObjectifGen>(0);
	private Set<TComposante> TComposantes = new HashSet<TComposante>(0);
	private Set<TBesoin> TBesoins = new HashSet<TBesoin>(0);
	private Set<TAffichageAgpm> TAffichageAgpms = new HashSet<TAffichageAgpm>(0);
	private Set<TAgpm> TAgpms = new HashSet<TAgpm>(0);
	private Set<TFinancement> TFinancements = new HashSet<TFinancement>(0);

	public TProjet() {
	}

	public TProjet(long proId, String proTitre) {
		this.proId = proId;
		this.proTitre = proTitre;
	}

	public TProjet(long proId, TReglementation TReglementation, String proCode, String proTitre, String proLibelle,
			String proDescription, BigDecimal proMontantTotCfa, String proTypeProjet, Set<TObjectifGen> TObjectifGens,
			Set<TComposante> TComposantes, Set<TBesoin> TBesoins, Set<TAffichageAgpm> TAffichageAgpms,
			Set<TAgpm> TAgpms, Set<TFinancement> TFinancements) {
		this.proId = proId;
		this.TReglementation = TReglementation;
		this.proCode = proCode;
		this.proTitre = proTitre;
		this.proLibelle = proLibelle;
		this.proDescription = proDescription;
		this.proMontantTotCfa = proMontantTotCfa;
		this.proTypeProjet = proTypeProjet;
		this.TObjectifGens = TObjectifGens;
		this.TComposantes = TComposantes;
		this.TBesoins = TBesoins;
		this.TAffichageAgpms = TAffichageAgpms;
		this.TAgpms = TAgpms;
		this.TFinancements = TFinancements;
	}

	@Id

	@Column(name = "PRO_ID", unique = true, nullable = false, precision = 10, scale = 0)
	public long getProId() {
		return this.proId;
	}

	public void setProId(long proId) {
		this.proId = proId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PRO_REG_ID")
	public TReglementation getTReglementation() {
		return this.TReglementation;
	}

	public void setTReglementation(TReglementation TReglementation) {
		this.TReglementation = TReglementation;
	}

	@Column(name = "PRO_CODE", length = 50)
	public String getProCode() {
		return this.proCode;
	}

	public void setProCode(String proCode) {
		this.proCode = proCode;
	}

	@Column(name = "PRO_TITRE", nullable = false, length = 500)
	public String getProTitre() {
		return this.proTitre;
	}

	public void setProTitre(String proTitre) {
		this.proTitre = proTitre;
	}

	@Column(name = "PRO_LIBELLE", length = 500)
	public String getProLibelle() {
		return this.proLibelle;
	}

	public void setProLibelle(String proLibelle) {
		this.proLibelle = proLibelle;
	}

	@Column(name = "PRO_DESCRIPTION", length = 1000)
	public String getProDescription() {
		return this.proDescription;
	}

	public void setProDescription(String proDescription) {
		this.proDescription = proDescription;
	}

	@Column(name = "PRO_MONTANT_TOT_CFA", precision = 15)
	public BigDecimal getProMontantTotCfa() {
		return this.proMontantTotCfa;
	}

	public void setProMontantTotCfa(BigDecimal proMontantTotCfa) {
		this.proMontantTotCfa = proMontantTotCfa;
	}

	@Column(name = "PRO_TYPE_PROJET", length = 10)
	public String getProTypeProjet() {
		return this.proTypeProjet;
	}

	public void setProTypeProjet(String proTypeProjet) {
		this.proTypeProjet = proTypeProjet;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TProjet")
	public Set<TObjectifGen> getTObjectifGens() {
		return this.TObjectifGens;
	}

	public void setTObjectifGens(Set<TObjectifGen> TObjectifGens) {
		this.TObjectifGens = TObjectifGens;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TProjet")
	public Set<TComposante> getTComposantes() {
		return this.TComposantes;
	}

	public void setTComposantes(Set<TComposante> TComposantes) {
		this.TComposantes = TComposantes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TProjet")
	public Set<TBesoin> getTBesoins() {
		return this.TBesoins;
	}

	public void setTBesoins(Set<TBesoin> TBesoins) {
		this.TBesoins = TBesoins;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TProjet")
	public Set<TAffichageAgpm> getTAffichageAgpms() {
		return this.TAffichageAgpms;
	}

	public void setTAffichageAgpms(Set<TAffichageAgpm> TAffichageAgpms) {
		this.TAffichageAgpms = TAffichageAgpms;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TProjet")
	public Set<TAgpm> getTAgpms() {
		return this.TAgpms;
	}

	public void setTAgpms(Set<TAgpm> TAgpms) {
		this.TAgpms = TAgpms;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TProjet")
	public Set<TFinancement> getTFinancements() {
		return this.TFinancements;
	}

	public void setTFinancements(Set<TFinancement> TFinancements) {
		this.TFinancements = TFinancements;
	}

}
