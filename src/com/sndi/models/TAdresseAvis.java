package com.sndi.models;
// Generated 19 mars 2020 16:14:06 by Hibernate Tools 4.3.5.Final

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
 * TAdresseAvis generated by hbm2java
 */
@Entity
@Table(name = "T_ADRESSE_AVIS", schema = "EMAP")
public class TAdresseAvis implements java.io.Serializable {

	private BigDecimal adaNum;
	private TFonction TFonction;
	private String adaLibelle;
	private Set<TDetailAdresseAvis> TDetailAdresseAvises = new HashSet<TDetailAdresseAvis>(0);
	private Set<TAvisAppelOffre> TAvisAppelOffres = new HashSet<TAvisAppelOffre>(0);

	public TAdresseAvis() {
	}

	public TAdresseAvis(BigDecimal adaNum) {
		this.adaNum = adaNum;
	}

	public TAdresseAvis(BigDecimal adaNum, TFonction TFonction, String adaLibelle,
			Set<TDetailAdresseAvis> TDetailAdresseAvises, Set<TAvisAppelOffre> TAvisAppelOffres) {
		this.adaNum = adaNum;
		this.TFonction = TFonction;
		this.adaLibelle = adaLibelle;
		this.TDetailAdresseAvises = TDetailAdresseAvises;
		this.TAvisAppelOffres = TAvisAppelOffres;
	}

	@Id

	@Column(name = "ADA_NUM", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getAdaNum() {
		return this.adaNum;
	}

	public void setAdaNum(BigDecimal adaNum) {
		this.adaNum = adaNum;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ADA_FON_COD")
	public TFonction getTFonction() {
		return this.TFonction;
	}

	public void setTFonction(TFonction TFonction) {
		this.TFonction = TFonction;
	}

	@Column(name = "ADA_LIBELLE", length = 500)
	public String getAdaLibelle() {
		return this.adaLibelle;
	}

	public void setAdaLibelle(String adaLibelle) {
		this.adaLibelle = adaLibelle;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TAdresseAvis")
	public Set<TDetailAdresseAvis> getTDetailAdresseAvises() {
		return this.TDetailAdresseAvises;
	}

	public void setTDetailAdresseAvises(Set<TDetailAdresseAvis> TDetailAdresseAvises) {
		this.TDetailAdresseAvises = TDetailAdresseAvises;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TAdresseAvis")
	public Set<TAvisAppelOffre> getTAvisAppelOffres() {
		return this.TAvisAppelOffres;
	}

	public void setTAvisAppelOffres(Set<TAvisAppelOffre> TAvisAppelOffres) {
		this.TAvisAppelOffres = TAvisAppelOffres;
	}

}
