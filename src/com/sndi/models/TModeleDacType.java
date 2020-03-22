package com.sndi.models;
// Generated 22 mars 2020 01:52:15 by Hibernate Tools 4.3.5.Final

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
 * TModeleDacType generated by hbm2java
 */
@Entity
@Table(name = "T_MODELE_DAC_TYPE", schema = "EMAP")
public class TModeleDacType implements java.io.Serializable {

	private String mdtCode;
	private TTypeMarche TTypeMarche;
	private TOperateur TOperateur;
	private String mdtLibelleLong;
	private String mdtLibelleCourt;
	private Date mdtDteSaisi;
	private Set<TTypePiecesDac> TTypePiecesDacs = new HashSet<TTypePiecesDac>(0);
	private Set<TDetailPlanPassation> TDetailPlanPassations = new HashSet<TDetailPlanPassation>(0);

	public TModeleDacType() {
	}

	public TModeleDacType(String mdtCode) {
		this.mdtCode = mdtCode;
	}

	public TModeleDacType(String mdtCode, TTypeMarche TTypeMarche, TOperateur TOperateur, String mdtLibelleLong,
			String mdtLibelleCourt, Date mdtDteSaisi, Set<TTypePiecesDac> TTypePiecesDacs,
			Set<TDetailPlanPassation> TDetailPlanPassations) {
		this.mdtCode = mdtCode;
		this.TTypeMarche = TTypeMarche;
		this.TOperateur = TOperateur;
		this.mdtLibelleLong = mdtLibelleLong;
		this.mdtLibelleCourt = mdtLibelleCourt;
		this.mdtDteSaisi = mdtDteSaisi;
		this.TTypePiecesDacs = TTypePiecesDacs;
		this.TDetailPlanPassations = TDetailPlanPassations;
	}

	@Id

	@Column(name = "MDT_CODE", unique = true, nullable = false, length = 15)
	public String getMdtCode() {
		return this.mdtCode;
	}

	public void setMdtCode(String mdtCode) {
		this.mdtCode = mdtCode;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MDT_TYM_CODE")
	public TTypeMarche getTTypeMarche() {
		return this.TTypeMarche;
	}

	public void setTTypeMarche(TTypeMarche TTypeMarche) {
		this.TTypeMarche = TTypeMarche;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MDT_OPE_MATRICULE")
	public TOperateur getTOperateur() {
		return this.TOperateur;
	}

	public void setTOperateur(TOperateur TOperateur) {
		this.TOperateur = TOperateur;
	}

	@Column(name = "MDT_LIBELLE_LONG", length = 500)
	public String getMdtLibelleLong() {
		return this.mdtLibelleLong;
	}

	public void setMdtLibelleLong(String mdtLibelleLong) {
		this.mdtLibelleLong = mdtLibelleLong;
	}

	@Column(name = "MDT_LIBELLE_COURT", length = 500)
	public String getMdtLibelleCourt() {
		return this.mdtLibelleCourt;
	}

	public void setMdtLibelleCourt(String mdtLibelleCourt) {
		this.mdtLibelleCourt = mdtLibelleCourt;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "MDT_DTE_SAISI", length = 7)
	public Date getMdtDteSaisi() {
		return this.mdtDteSaisi;
	}

	public void setMdtDteSaisi(Date mdtDteSaisi) {
		this.mdtDteSaisi = mdtDteSaisi;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TModeleDacType")
	public Set<TTypePiecesDac> getTTypePiecesDacs() {
		return this.TTypePiecesDacs;
	}

	public void setTTypePiecesDacs(Set<TTypePiecesDac> TTypePiecesDacs) {
		this.TTypePiecesDacs = TTypePiecesDacs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TModeleDacType")
	public Set<TDetailPlanPassation> getTDetailPlanPassations() {
		return this.TDetailPlanPassations;
	}

	public void setTDetailPlanPassations(Set<TDetailPlanPassation> TDetailPlanPassations) {
		this.TDetailPlanPassations = TDetailPlanPassations;
	}

}
