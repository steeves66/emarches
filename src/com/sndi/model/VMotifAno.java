package com.sndi.model;
// Generated 19 nov. 2020 14:19:31 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

/**
 * VMotifAnoId generated by hbm2java
 */
@Entity
@Immutable
@Table(name = "V_MOTIF_ANO")
public class VMotifAno implements java.io.Serializable {

	private long mtfNum;
	private String mtfLibelle;
	private String mtfLibelleCrt;
	private String mtfType;
	private String mtfOpeMatricule;
	private String mtfOpeModif;
	private Date mtfDteSaisi;
	private Date mtfDteModif;

	public VMotifAno() {
	}

	public VMotifAno(long mtfNum) {
		this.mtfNum = mtfNum;
	}

	public VMotifAno(long mtfNum, String mtfLibelle, String mtfLibelleCrt, String mtfType,
			String mtfOpeMatricule, String mtfOpeModif, Date mtfDteSaisi, Date mtfDteModif) {
		this.mtfNum = mtfNum;
		this.mtfLibelle = mtfLibelle;
		this.mtfLibelleCrt = mtfLibelleCrt;
		this.mtfType = mtfType;
		this.mtfOpeMatricule = mtfOpeMatricule;
		this.mtfOpeModif = mtfOpeModif;
		this.mtfDteSaisi = mtfDteSaisi;
		this.mtfDteModif = mtfDteModif;
	}

	@Id
	@Column(name = "MTF_NUM", nullable = false, precision = 22, scale = 0)
	public long getMtfNum() {
		return this.mtfNum;
	}

	public void setMtfNum(long mtfNum) {
		this.mtfNum = mtfNum;
	}

	@Column(name = "MTF_LIBELLE", length = 500)
	public String getMtfLibelle() {
		return this.mtfLibelle;
	}

	public void setMtfLibelle(String mtfLibelle) {
		this.mtfLibelle = mtfLibelle;
	}

	@Column(name = "MTF_LIBELLE_CRT", length = 200)
	public String getMtfLibelleCrt() {
		return this.mtfLibelleCrt;
	}

	public void setMtfLibelleCrt(String mtfLibelleCrt) {
		this.mtfLibelleCrt = mtfLibelleCrt;
	}

	@Column(name = "MTF_TYPE", length = 10)
	public String getMtfType() {
		return this.mtfType;
	}

	public void setMtfType(String mtfType) {
		this.mtfType = mtfType;
	}

	@Column(name = "MTF_OPE_MATRICULE", length = 25)
	public String getMtfOpeMatricule() {
		return this.mtfOpeMatricule;
	}

	public void setMtfOpeMatricule(String mtfOpeMatricule) {
		this.mtfOpeMatricule = mtfOpeMatricule;
	}

	@Column(name = "MTF_OPE_MODIF", length = 25)
	public String getMtfOpeModif() {
		return this.mtfOpeModif;
	}

	public void setMtfOpeModif(String mtfOpeModif) {
		this.mtfOpeModif = mtfOpeModif;
	}

	@Column(name = "MTF_DTE_SAISI", length = 7)
	public Date getMtfDteSaisi() {
		return this.mtfDteSaisi;
	}

	public void setMtfDteSaisi(Date mtfDteSaisi) {
		this.mtfDteSaisi = mtfDteSaisi;
	}

	@Column(name = "MTF_DTE_MODIF", length = 7)
	public Date getMtfDteModif() {
		return this.mtfDteModif;
	}

	public void setMtfDteModif(Date mtfDteModif) {
		this.mtfDteModif = mtfDteModif;
	}
}
