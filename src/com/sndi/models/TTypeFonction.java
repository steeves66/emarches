package com.sndi.models;
// Generated 19 mars 2020 16:14:06 by Hibernate Tools 4.3.5.Final

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * TTypeFonction generated by hbm2java
 */
@Entity
@Table(name = "T_TYPE_FONCTION", schema = "EMAP")
public class TTypeFonction implements java.io.Serializable {

	private String tyfCod;
	private TOperateur TOperateur;
	private String tyfLibelle;
	private Date tyfDteSaisi;
	private String tyfLibelleCrt;
	private Set<TFonction> TFonctions = new HashSet<TFonction>(0);

	public TTypeFonction() {
	}

	public TTypeFonction(String tyfCod) {
		this.tyfCod = tyfCod;
	}

	public TTypeFonction(String tyfCod, TOperateur TOperateur, String tyfLibelle, Date tyfDteSaisi,
			String tyfLibelleCrt, Set<TFonction> TFonctions) {
		this.tyfCod = tyfCod;
		this.TOperateur = TOperateur;
		this.tyfLibelle = tyfLibelle;
		this.tyfDteSaisi = tyfDteSaisi;
		this.tyfLibelleCrt = tyfLibelleCrt;
		this.TFonctions = TFonctions;
	}

	@Id

	@Column(name = "TYF_COD", unique = true, nullable = false, length = 3)
	public String getTyfCod() {
		return this.tyfCod;
	}

	public void setTyfCod(String tyfCod) {
		this.tyfCod = tyfCod;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TYF_OPE_MATRICULE")
	public TOperateur getTOperateur() {
		return this.TOperateur;
	}

	public void setTOperateur(TOperateur TOperateur) {
		this.TOperateur = TOperateur;
	}

	@Column(name = "TYF_LIBELLE", length = 300)
	public String getTyfLibelle() {
		return this.tyfLibelle;
	}

	public void setTyfLibelle(String tyfLibelle) {
		this.tyfLibelle = tyfLibelle;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "TYF_DTE_SAISI", length = 7)
	public Date getTyfDteSaisi() {
		return this.tyfDteSaisi;
	}

	public void setTyfDteSaisi(Date tyfDteSaisi) {
		this.tyfDteSaisi = tyfDteSaisi;
	}

	@Column(name = "TYF_LIBELLE_CRT", length = 300)
	public String getTyfLibelleCrt() {
		return this.tyfLibelleCrt;
	}

	public void setTyfLibelleCrt(String tyfLibelleCrt) {
		this.tyfLibelleCrt = tyfLibelleCrt;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TTypeFonction")
	public Set<TFonction> getTFonctions() {
		return this.TFonctions;
	}

	public void setTFonctions(Set<TFonction> TFonctions) {
		this.TFonctions = TFonctions;
	}

}
