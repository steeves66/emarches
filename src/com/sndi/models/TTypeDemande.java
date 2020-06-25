package com.sndi.models;
// Generated 25 juin 2020 13:53:46 by Hibernate Tools 4.3.5.Final

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
 * TTypeDemande generated by hbm2java
 */
@Entity
@Table(name = "T_TYPE_DEMANDE", schema = "EMAP")
public class TTypeDemande implements java.io.Serializable {

	private String tdmCode;
	private TOperateur TOperateur;
	private String tdmLibelle;
	private Date tdmDteSaisi;
	private Character tdmProDer;
	private Set<TDemande> TDemandes = new HashSet<TDemande>(0);
	private Set<TParamPieceDemande> TParamPieceDemandes = new HashSet<TParamPieceDemande>(0);

	public TTypeDemande() {
	}

	public TTypeDemande(String tdmCode) {
		this.tdmCode = tdmCode;
	}

	public TTypeDemande(String tdmCode, TOperateur TOperateur, String tdmLibelle, Date tdmDteSaisi, Character tdmProDer,
			Set<TDemande> TDemandes, Set<TParamPieceDemande> TParamPieceDemandes) {
		this.tdmCode = tdmCode;
		this.TOperateur = TOperateur;
		this.tdmLibelle = tdmLibelle;
		this.tdmDteSaisi = tdmDteSaisi;
		this.tdmProDer = tdmProDer;
		this.TDemandes = TDemandes;
		this.TParamPieceDemandes = TParamPieceDemandes;
	}

	@Id

	@Column(name = "TDM_CODE", unique = true, nullable = false, length = 10)
	public String getTdmCode() {
		return this.tdmCode;
	}

	public void setTdmCode(String tdmCode) {
		this.tdmCode = tdmCode;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TDM_OPE_MATRICULE")
	public TOperateur getTOperateur() {
		return this.TOperateur;
	}

	public void setTOperateur(TOperateur TOperateur) {
		this.TOperateur = TOperateur;
	}

	@Column(name = "TDM_LIBELLE", length = 500)
	public String getTdmLibelle() {
		return this.tdmLibelle;
	}

	public void setTdmLibelle(String tdmLibelle) {
		this.tdmLibelle = tdmLibelle;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "TDM_DTE_SAISI", length = 7)
	public Date getTdmDteSaisi() {
		return this.tdmDteSaisi;
	}

	public void setTdmDteSaisi(Date tdmDteSaisi) {
		this.tdmDteSaisi = tdmDteSaisi;
	}

	@Column(name = "TDM_PRO_DER", length = 1)
	public Character getTdmProDer() {
		return this.tdmProDer;
	}

	public void setTdmProDer(Character tdmProDer) {
		this.tdmProDer = tdmProDer;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TTypeDemande")
	public Set<TDemande> getTDemandes() {
		return this.TDemandes;
	}

	public void setTDemandes(Set<TDemande> TDemandes) {
		this.TDemandes = TDemandes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TTypeDemande")
	public Set<TParamPieceDemande> getTParamPieceDemandes() {
		return this.TParamPieceDemandes;
	}

	public void setTParamPieceDemandes(Set<TParamPieceDemande> TParamPieceDemandes) {
		this.TParamPieceDemandes = TParamPieceDemandes;
	}

}
