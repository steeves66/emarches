package com.sndi.model;
// Generated 28 nov. 2020 13:47:13 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

/**
 * VObservationAno generated by hbm2java
 */
@Entity
@Immutable
@Table(name = "V_OBSERVATION_ANO")
public class VObservationAno implements java.io.Serializable {

	private BigDecimal obsNum;
	private BigDecimal mtfNum;
	private String mtfLibelle;
	private String mtfLibelleCrt;
	private BigDecimal obsLaaNum;
	private String obsSouNcc;
	private String canSouSigleSte;

	public VObservationAno() {
	}

	public VObservationAno(BigDecimal obsNum, BigDecimal mtfNum, String mtfLibelle, String mtfLibelleCrt,
			BigDecimal obsLaaNum, String obsSouNcc, String canSouSigleSte) {
		this.obsNum = obsNum;
		this.mtfNum = mtfNum;
		this.mtfLibelle = mtfLibelle;
		this.mtfLibelleCrt = mtfLibelleCrt;
		this.obsLaaNum = obsLaaNum;
		this.obsSouNcc = obsSouNcc;
		this.canSouSigleSte = canSouSigleSte;
	}

	
	@Id
	@Column(name = "OBS_NUM", precision = 22, scale = 0)
	public BigDecimal getObsNum() {
		return this.obsNum;
	}

	public void setObsNum(BigDecimal obsNum) {
		this.obsNum = obsNum;
	}

	@Column(name = "MTF_NUM", precision = 22, scale = 0)
	public BigDecimal getMtfNum() {
		return this.mtfNum;
	}

	public void setMtfNum(BigDecimal mtfNum) {
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

	@Column(name = "OBS_LAA_NUM", precision = 22, scale = 0)
	public BigDecimal getObsLaaNum() {
		return this.obsLaaNum;
	}

	public void setObsLaaNum(BigDecimal obsLaaNum) {
		this.obsLaaNum = obsLaaNum;
	}

	@Column(name = "OBS_SOU_NCC", length = 20)
	public String getObsSouNcc() {
		return this.obsSouNcc;
	}

	public void setObsSouNcc(String obsSouNcc) {
		this.obsSouNcc = obsSouNcc;
	}

	@Column(name = "CAN_SOU_SIGLE_STE", length = 500)
	public String getCanSouSigleSte() {
		return this.canSouSigleSte;
	}

	public void setCanSouSigleSte(String canSouSigleSte) {
		this.canSouSigleSte = canSouSigleSte;
	}

}
