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
 * TSoumissions generated by hbm2java
 */
@Entity
@Table(name = "T_SOUMISSIONS", schema = "EMAP")
public class TSoumissions implements java.io.Serializable {

	private String souNcc;
	private TOperateur TOperateur;
	private Character souInter;
	private String souSigleSte;
	private String souNomCom;
	private String souStaCode;
	private String souTel;
	private String souAdresse;
	private Date souDteSaisi;
	private Set<TAvisPresel> TAvisPresels = new HashSet<TAvisPresel>(0);
	private Set<TOffres> TOffreses = new HashSet<TOffres>(0);

	public TSoumissions() {
	}

	public TSoumissions(String souNcc) {
		this.souNcc = souNcc;
	}

	public TSoumissions(String souNcc, TOperateur TOperateur, Character souInter, String souSigleSte, String souNomCom,
			String souStaCode, String souTel, String souAdresse, Date souDteSaisi, Set<TAvisPresel> TAvisPresels,
			Set<TOffres> TOffreses) {
		this.souNcc = souNcc;
		this.TOperateur = TOperateur;
		this.souInter = souInter;
		this.souSigleSte = souSigleSte;
		this.souNomCom = souNomCom;
		this.souStaCode = souStaCode;
		this.souTel = souTel;
		this.souAdresse = souAdresse;
		this.souDteSaisi = souDteSaisi;
		this.TAvisPresels = TAvisPresels;
		this.TOffreses = TOffreses;
	}

	@Id

	@Column(name = "SOU_NCC", unique = true, nullable = false, length = 20)
	public String getSouNcc() {
		return this.souNcc;
	}

	public void setSouNcc(String souNcc) {
		this.souNcc = souNcc;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SOU_OPE_MATRICULE")
	public TOperateur getTOperateur() {
		return this.TOperateur;
	}

	public void setTOperateur(TOperateur TOperateur) {
		this.TOperateur = TOperateur;
	}

	@Column(name = "SOU_INTER", length = 1)
	public Character getSouInter() {
		return this.souInter;
	}

	public void setSouInter(Character souInter) {
		this.souInter = souInter;
	}

	@Column(name = "SOU_SIGLE_STE", length = 500)
	public String getSouSigleSte() {
		return this.souSigleSte;
	}

	public void setSouSigleSte(String souSigleSte) {
		this.souSigleSte = souSigleSte;
	}

	@Column(name = "SOU_NOM_COM", length = 500)
	public String getSouNomCom() {
		return this.souNomCom;
	}

	public void setSouNomCom(String souNomCom) {
		this.souNomCom = souNomCom;
	}

	@Column(name = "SOU_STA_CODE", length = 3)
	public String getSouStaCode() {
		return this.souStaCode;
	}

	public void setSouStaCode(String souStaCode) {
		this.souStaCode = souStaCode;
	}

	@Column(name = "SOU_TEL", length = 200)
	public String getSouTel() {
		return this.souTel;
	}

	public void setSouTel(String souTel) {
		this.souTel = souTel;
	}

	@Column(name = "SOU_ADRESSE", length = 200)
	public String getSouAdresse() {
		return this.souAdresse;
	}

	public void setSouAdresse(String souAdresse) {
		this.souAdresse = souAdresse;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "SOU_DTE_SAISI", length = 7)
	public Date getSouDteSaisi() {
		return this.souDteSaisi;
	}

	public void setSouDteSaisi(Date souDteSaisi) {
		this.souDteSaisi = souDteSaisi;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TSoumissions")
	public Set<TAvisPresel> getTAvisPresels() {
		return this.TAvisPresels;
	}

	public void setTAvisPresels(Set<TAvisPresel> TAvisPresels) {
		this.TAvisPresels = TAvisPresels;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TSoumissions")
	public Set<TOffres> getTOffreses() {
		return this.TOffreses;
	}

	public void setTOffreses(Set<TOffres> TOffreses) {
		this.TOffreses = TOffreses;
	}

}