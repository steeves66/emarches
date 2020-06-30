package com.sndi.models;
// Generated 30 juin 2020 16:42:29 by Hibernate Tools 4.3.5.Final

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
 * TCommissionType generated by hbm2java
 */
@Entity
@Table(name = "T_COMMISSION_TYPE", schema = "EMAP")
public class TCommissionType implements java.io.Serializable {

	private String tctCode;
	private TTypeCommission TTypeCommission;
	private TTypeStructure TTypeStructure;
	private TOperateur TOperateur;
	private String tctLibelle;
	private String tctTitre;
	private Date tctDteSaisi;
	private String tctGrpCode;
	private String tctNomMbm;
	private String tctPreMbm;
	private String tctTelMbm;
	private String tctRepMandate;
	private Set<TCommissionSpecifique> TCommissionSpecifiques = new HashSet<TCommissionSpecifique>(0);

	public TCommissionType() {
	}

	public TCommissionType(String tctCode) {
		this.tctCode = tctCode;
	}

	public TCommissionType(String tctCode, TTypeCommission TTypeCommission, TTypeStructure TTypeStructure,
			TOperateur TOperateur, String tctLibelle, String tctTitre, Date tctDteSaisi, String tctGrpCode,
			String tctNomMbm, String tctPreMbm, String tctTelMbm, String tctRepMandate,
			Set<TCommissionSpecifique> TCommissionSpecifiques) {
		this.tctCode = tctCode;
		this.TTypeCommission = TTypeCommission;
		this.TTypeStructure = TTypeStructure;
		this.TOperateur = TOperateur;
		this.tctLibelle = tctLibelle;
		this.tctTitre = tctTitre;
		this.tctDteSaisi = tctDteSaisi;
		this.tctGrpCode = tctGrpCode;
		this.tctNomMbm = tctNomMbm;
		this.tctPreMbm = tctPreMbm;
		this.tctTelMbm = tctTelMbm;
		this.tctRepMandate = tctRepMandate;
		this.TCommissionSpecifiques = TCommissionSpecifiques;
	}

	@Id

	@Column(name = "TCT_CODE", unique = true, nullable = false, length = 3)
	public String getTctCode() {
		return this.tctCode;
	}

	public void setTctCode(String tctCode) {
		this.tctCode = tctCode;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TCT_TCO_CODE")
	public TTypeCommission getTTypeCommission() {
		return this.TTypeCommission;
	}

	public void setTTypeCommission(TTypeCommission TTypeCommission) {
		this.TTypeCommission = TTypeCommission;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TCT_TST_CODE")
	public TTypeStructure getTTypeStructure() {
		return this.TTypeStructure;
	}

	public void setTTypeStructure(TTypeStructure TTypeStructure) {
		this.TTypeStructure = TTypeStructure;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TCT_OPE_MATRICULE")
	public TOperateur getTOperateur() {
		return this.TOperateur;
	}

	public void setTOperateur(TOperateur TOperateur) {
		this.TOperateur = TOperateur;
	}

	@Column(name = "TCT_LIBELLE", length = 500)
	public String getTctLibelle() {
		return this.tctLibelle;
	}

	public void setTctLibelle(String tctLibelle) {
		this.tctLibelle = tctLibelle;
	}

	@Column(name = "TCT_TITRE", length = 200)
	public String getTctTitre() {
		return this.tctTitre;
	}

	public void setTctTitre(String tctTitre) {
		this.tctTitre = tctTitre;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "TCT_DTE_SAISI", length = 7)
	public Date getTctDteSaisi() {
		return this.tctDteSaisi;
	}

	public void setTctDteSaisi(Date tctDteSaisi) {
		this.tctDteSaisi = tctDteSaisi;
	}

	@Column(name = "TCT_GRP_CODE", length = 20)
	public String getTctGrpCode() {
		return this.tctGrpCode;
	}

	public void setTctGrpCode(String tctGrpCode) {
		this.tctGrpCode = tctGrpCode;
	}

	@Column(name = "TCT_NOM_MBM", length = 100)
	public String getTctNomMbm() {
		return this.tctNomMbm;
	}

	public void setTctNomMbm(String tctNomMbm) {
		this.tctNomMbm = tctNomMbm;
	}

	@Column(name = "TCT_PRE_MBM", length = 200)
	public String getTctPreMbm() {
		return this.tctPreMbm;
	}

	public void setTctPreMbm(String tctPreMbm) {
		this.tctPreMbm = tctPreMbm;
	}

	@Column(name = "TCT_TEL_MBM", length = 20)
	public String getTctTelMbm() {
		return this.tctTelMbm;
	}

	public void setTctTelMbm(String tctTelMbm) {
		this.tctTelMbm = tctTelMbm;
	}

	@Column(name = "TCT_REP_MANDATE", length = 1)
	public String getTctRepMandate() {
		return this.tctRepMandate;
	}

	public void setTctRepMandate(String tctRepMandate) {
		this.tctRepMandate = tctRepMandate;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TCommissionType")
	public Set<TCommissionSpecifique> getTCommissionSpecifiques() {
		return this.TCommissionSpecifiques;
	}

	public void setTCommissionSpecifiques(Set<TCommissionSpecifique> TCommissionSpecifiques) {
		this.TCommissionSpecifiques = TCommissionSpecifiques;
	}

}
