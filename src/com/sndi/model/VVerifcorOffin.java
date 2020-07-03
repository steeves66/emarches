package com.sndi.model;
// Generated 2 juil. 2020 21:16:58 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

/**
 * VVerifcorOffin generated by hbm2java
 */
@Entity
@Immutable
@Table(name = "V_VERIFCOR_OFFIN")
public class VVerifcorOffin implements java.io.Serializable {

	private BigDecimal RId;
	private BigDecimal ordre;
	private String offSouNcc;
	private String offSouSigleSte;
	private BigDecimal dofMtOfr;
	private String dofErrFin;
	private BigDecimal dofMtCor;
	private BigDecimal dofLaaId;
	private BigDecimal laaNum;
	private BigDecimal dofNum;
	private BigDecimal laaMtEst;
	private BigDecimal dofDelai;
	private String laaObjet;
	private String dofRepeche;
	private String laaAaoCode;
	private String laaDacCode;
	private String commentaireOffin;
	private String commentaireAnormal;
	private String commentaireOffret;

	public VVerifcorOffin() {
	}

	public VVerifcorOffin(BigDecimal dofLaaId, BigDecimal dofNum, BigDecimal dofDelai) {
		this.dofLaaId = dofLaaId;
		this.dofNum = dofNum;
		this.dofDelai = dofDelai;
	}

	public VVerifcorOffin(BigDecimal RId, BigDecimal ordre, String offSouNcc, String offSouSigleSte,
			BigDecimal dofMtOfr, String dofErrFin, BigDecimal dofMtCor, BigDecimal dofLaaId, BigDecimal laaNum,
			BigDecimal dofNum, BigDecimal laaMtEst, BigDecimal dofDelai, String laaObjet, String dofRepeche,
			String laaAaoCode, String laaDacCode, String commentaireOffin, String commentaireAnormal,
			String commentaireOffret) {
		this.RId = RId;
		this.ordre = ordre;
		this.offSouNcc = offSouNcc;
		this.offSouSigleSte = offSouSigleSte;
		this.dofMtOfr = dofMtOfr;
		this.dofErrFin = dofErrFin;
		this.dofMtCor = dofMtCor;
		this.dofLaaId = dofLaaId;
		this.laaNum = laaNum;
		this.dofNum = dofNum;
		this.laaMtEst = laaMtEst;
		this.dofDelai = dofDelai;
		this.laaObjet = laaObjet;
		this.dofRepeche = dofRepeche;
		this.laaAaoCode = laaAaoCode;
		this.laaDacCode = laaDacCode;
		this.commentaireOffin = commentaireOffin;
		this.commentaireAnormal = commentaireAnormal;
		this.commentaireOffret = commentaireOffret;
	}

	@Id
	@Column(name = "R_ID", precision = 22, scale = 0)
	public BigDecimal getRId() {
		return this.RId;
	}

	public void setRId(BigDecimal RId) {
		this.RId = RId;
	}

	@Column(name = "ORDRE", precision = 22, scale = 0)
	public BigDecimal getOrdre() {
		return this.ordre;
	}

	public void setOrdre(BigDecimal ordre) {
		this.ordre = ordre;
	}

	@Column(name = "OFF_SOU_NCC", length = 20)
	public String getOffSouNcc() {
		return this.offSouNcc;
	}

	public void setOffSouNcc(String offSouNcc) {
		this.offSouNcc = offSouNcc;
	}

	@Column(name = "OFF_SOU_SIGLE_STE", length = 500)
	public String getOffSouSigleSte() {
		return this.offSouSigleSte;
	}

	public void setOffSouSigleSte(String offSouSigleSte) {
		this.offSouSigleSte = offSouSigleSte;
	}

	@Column(name = "DOF_MT_OFR", precision = 20, scale = 0)
	public BigDecimal getDofMtOfr() {
		return this.dofMtOfr;
	}

	public void setDofMtOfr(BigDecimal dofMtOfr) {
		this.dofMtOfr = dofMtOfr;
	}

	@Column(name = "DOF_ERR_FIN", length = 500)
	public String getDofErrFin() {
		return this.dofErrFin;
	}

	public void setDofErrFin(String dofErrFin) {
		this.dofErrFin = dofErrFin;
	}

	@Column(name = "DOF_MT_COR", precision = 20, scale = 0)
	public BigDecimal getDofMtCor() {
		return this.dofMtCor;
	}

	public void setDofMtCor(BigDecimal dofMtCor) {
		this.dofMtCor = dofMtCor;
	}

	@Column(name = "DOF_LAA_ID", nullable = false, precision = 22, scale = 0)
	public BigDecimal getDofLaaId() {
		return this.dofLaaId;
	}

	public void setDofLaaId(BigDecimal dofLaaId) {
		this.dofLaaId = dofLaaId;
	}

	@Column(name = "LAA_NUM", precision = 22, scale = 0)
	public BigDecimal getLaaNum() {
		return this.laaNum;
	}

	public void setLaaNum(BigDecimal laaNum) {
		this.laaNum = laaNum;
	}

	@Column(name = "DOF_NUM", nullable = false, precision = 22, scale = 0)
	public BigDecimal getDofNum() {
		return this.dofNum;
	}

	public void setDofNum(BigDecimal dofNum) {
		this.dofNum = dofNum;
	}

	@Column(name = "LAA_MT_EST", precision = 22, scale = 0)
	public BigDecimal getLaaMtEst() {
		return this.laaMtEst;
	}

	public void setLaaMtEst(BigDecimal laaMtEst) {
		this.laaMtEst = laaMtEst;
	}

	@Column(name = "DOF_DELAI", nullable = false, precision = 20, scale = 0)
	public BigDecimal getDofDelai() {
		return this.dofDelai;
	}

	public void setDofDelai(BigDecimal dofDelai) {
		this.dofDelai = dofDelai;
	}

	@Column(name = "LAA_OBJET", length = 1000)
	public String getLaaObjet() {
		return this.laaObjet;
	}

	public void setLaaObjet(String laaObjet) {
		this.laaObjet = laaObjet;
	}

	@Column(name = "DOF_REPECHE", length = 1)
	public String getDofRepeche() {
		return this.dofRepeche;
	}

	public void setDofRepeche(String dofRepeche) {
		this.dofRepeche = dofRepeche;
	}

	@Column(name = "LAA_AAO_CODE", length = 20)
	public String getLaaAaoCode() {
		return this.laaAaoCode;
	}

	public void setLaaAaoCode(String laaAaoCode) {
		this.laaAaoCode = laaAaoCode;
	}

	@Column(name = "LAA_DAC_CODE", length = 20)
	public String getLaaDacCode() {
		return this.laaDacCode;
	}

	public void setLaaDacCode(String laaDacCode) {
		this.laaDacCode = laaDacCode;
	}

	@Column(name = "COMMENTAIRE_OFFIN", length = 500)
	public String getCommentaireOffin() {
		return this.commentaireOffin;
	}

	public void setCommentaireOffin(String commentaireOffin) {
		this.commentaireOffin = commentaireOffin;
	}

	@Column(name = "COMMENTAIRE_ANORMAL", length = 500)
	public String getCommentaireAnormal() {
		return this.commentaireAnormal;
	}

	public void setCommentaireAnormal(String commentaireAnormal) {
		this.commentaireAnormal = commentaireAnormal;
	}

	@Column(name = "COMMENTAIRE_OFFRET", length = 500)
	public String getCommentaireOffret() {
		return this.commentaireOffret;
	}

	public void setCommentaireOffret(String commentaireOffret) {
		this.commentaireOffret = commentaireOffret;
	}

}
