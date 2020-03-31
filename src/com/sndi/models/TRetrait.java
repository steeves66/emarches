package com.sndi.models;
// Generated 31 mars 2020 01:27:37 by Hibernate Tools 4.3.5.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * TRetrait generated by hbm2java
 */
@Entity
@Table(name = "T_RETRAIT", schema = "EMAP")
public class TRetrait implements java.io.Serializable {

	private long retId;
	private TDacSpecs TDacSpecs;
	private TFonction TFonction;
	private TOperateur TOperateur;
	private String retNom;
	private String retAdresse;
	private String retMail;
	private String retTel;
	private String retPieceNumero;
	private Date retDate;
	private String retTypePiece;

	public TRetrait() {
	}

	public TRetrait(long retId) {
		this.retId = retId;
	}

	public TRetrait(long retId, TDacSpecs TDacSpecs, TFonction TFonction, TOperateur TOperateur, String retNom,
			String retAdresse, String retMail, String retTel, String retPieceNumero, Date retDate,
			String retTypePiece) {
		this.retId = retId;
		this.TDacSpecs = TDacSpecs;
		this.TFonction = TFonction;
		this.TOperateur = TOperateur;
		this.retNom = retNom;
		this.retAdresse = retAdresse;
		this.retMail = retMail;
		this.retTel = retTel;
		this.retPieceNumero = retPieceNumero;
		this.retDate = retDate;
		this.retTypePiece = retTypePiece;
	}

	@Id

	@Column(name = "RET_ID", unique = true, nullable = false, precision = 10, scale = 0)
	public long getRetId() {
		return this.retId;
	}

	public void setRetId(long retId) {
		this.retId = retId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RET_DAC_CODE")
	public TDacSpecs getTDacSpecs() {
		return this.TDacSpecs;
	}

	public void setTDacSpecs(TDacSpecs TDacSpecs) {
		this.TDacSpecs = TDacSpecs;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RET_FON_COD")
	public TFonction getTFonction() {
		return this.TFonction;
	}

	public void setTFonction(TFonction TFonction) {
		this.TFonction = TFonction;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RET_OPE_MATRICULE")
	public TOperateur getTOperateur() {
		return this.TOperateur;
	}

	public void setTOperateur(TOperateur TOperateur) {
		this.TOperateur = TOperateur;
	}

	@Column(name = "RET_NOM", length = 1000)
	public String getRetNom() {
		return this.retNom;
	}

	public void setRetNom(String retNom) {
		this.retNom = retNom;
	}

	@Column(name = "RET_ADRESSE", length = 500)
	public String getRetAdresse() {
		return this.retAdresse;
	}

	public void setRetAdresse(String retAdresse) {
		this.retAdresse = retAdresse;
	}

	@Column(name = "RET_MAIL", length = 500)
	public String getRetMail() {
		return this.retMail;
	}

	public void setRetMail(String retMail) {
		this.retMail = retMail;
	}

	@Column(name = "RET_TEL", length = 500)
	public String getRetTel() {
		return this.retTel;
	}

	public void setRetTel(String retTel) {
		this.retTel = retTel;
	}

	@Column(name = "RET_PIECE_NUMERO", length = 500)
	public String getRetPieceNumero() {
		return this.retPieceNumero;
	}

	public void setRetPieceNumero(String retPieceNumero) {
		this.retPieceNumero = retPieceNumero;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "RET_DATE", length = 7)
	public Date getRetDate() {
		return this.retDate;
	}

	public void setRetDate(Date retDate) {
		this.retDate = retDate;
	}

	@Column(name = "RET_TYPE_PIECE", length = 50)
	public String getRetTypePiece() {
		return this.retTypePiece;
	}

	public void setRetTypePiece(String retTypePiece) {
		this.retTypePiece = retTypePiece;
	}

}
