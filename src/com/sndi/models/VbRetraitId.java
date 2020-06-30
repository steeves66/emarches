package com.sndi.models;
// Generated 30 juin 2020 16:42:29 by Hibernate Tools 4.3.5.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VbRetraitId generated by hbm2java
 */
@Embeddable
public class VbRetraitId implements java.io.Serializable {

	private long retId;
	private String retDacCode;
	private String retNom;
	private String retAdresse;
	private String retMail;
	private String retTel;
	private String retPieceNumero;
	private Date retDate;
	private String retTypePiece;
	private String retFonCod;
	private String retOpeMatricule;

	public VbRetraitId() {
	}

	public VbRetraitId(long retId) {
		this.retId = retId;
	}

	public VbRetraitId(long retId, String retDacCode, String retNom, String retAdresse, String retMail, String retTel,
			String retPieceNumero, Date retDate, String retTypePiece, String retFonCod, String retOpeMatricule) {
		this.retId = retId;
		this.retDacCode = retDacCode;
		this.retNom = retNom;
		this.retAdresse = retAdresse;
		this.retMail = retMail;
		this.retTel = retTel;
		this.retPieceNumero = retPieceNumero;
		this.retDate = retDate;
		this.retTypePiece = retTypePiece;
		this.retFonCod = retFonCod;
		this.retOpeMatricule = retOpeMatricule;
	}

	@Column(name = "RET_ID", nullable = false, precision = 10, scale = 0)
	public long getRetId() {
		return this.retId;
	}

	public void setRetId(long retId) {
		this.retId = retId;
	}

	@Column(name = "RET_DAC_CODE", length = 20)
	public String getRetDacCode() {
		return this.retDacCode;
	}

	public void setRetDacCode(String retDacCode) {
		this.retDacCode = retDacCode;
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

	@Column(name = "RET_FON_COD", length = 12)
	public String getRetFonCod() {
		return this.retFonCod;
	}

	public void setRetFonCod(String retFonCod) {
		this.retFonCod = retFonCod;
	}

	@Column(name = "RET_OPE_MATRICULE", length = 25)
	public String getRetOpeMatricule() {
		return this.retOpeMatricule;
	}

	public void setRetOpeMatricule(String retOpeMatricule) {
		this.retOpeMatricule = retOpeMatricule;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VbRetraitId))
			return false;
		VbRetraitId castOther = (VbRetraitId) other;

		return (this.getRetId() == castOther.getRetId())
				&& ((this.getRetDacCode() == castOther.getRetDacCode()) || (this.getRetDacCode() != null
						&& castOther.getRetDacCode() != null && this.getRetDacCode().equals(castOther.getRetDacCode())))
				&& ((this.getRetNom() == castOther.getRetNom()) || (this.getRetNom() != null
						&& castOther.getRetNom() != null && this.getRetNom().equals(castOther.getRetNom())))
				&& ((this.getRetAdresse() == castOther.getRetAdresse()) || (this.getRetAdresse() != null
						&& castOther.getRetAdresse() != null && this.getRetAdresse().equals(castOther.getRetAdresse())))
				&& ((this.getRetMail() == castOther.getRetMail()) || (this.getRetMail() != null
						&& castOther.getRetMail() != null && this.getRetMail().equals(castOther.getRetMail())))
				&& ((this.getRetTel() == castOther.getRetTel()) || (this.getRetTel() != null
						&& castOther.getRetTel() != null && this.getRetTel().equals(castOther.getRetTel())))
				&& ((this.getRetPieceNumero() == castOther.getRetPieceNumero())
						|| (this.getRetPieceNumero() != null && castOther.getRetPieceNumero() != null
								&& this.getRetPieceNumero().equals(castOther.getRetPieceNumero())))
				&& ((this.getRetDate() == castOther.getRetDate()) || (this.getRetDate() != null
						&& castOther.getRetDate() != null && this.getRetDate().equals(castOther.getRetDate())))
				&& ((this.getRetTypePiece() == castOther.getRetTypePiece())
						|| (this.getRetTypePiece() != null && castOther.getRetTypePiece() != null
								&& this.getRetTypePiece().equals(castOther.getRetTypePiece())))
				&& ((this.getRetFonCod() == castOther.getRetFonCod()) || (this.getRetFonCod() != null
						&& castOther.getRetFonCod() != null && this.getRetFonCod().equals(castOther.getRetFonCod())))
				&& ((this.getRetOpeMatricule() == castOther.getRetOpeMatricule())
						|| (this.getRetOpeMatricule() != null && castOther.getRetOpeMatricule() != null
								&& this.getRetOpeMatricule().equals(castOther.getRetOpeMatricule())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getRetId();
		result = 37 * result + (getRetDacCode() == null ? 0 : this.getRetDacCode().hashCode());
		result = 37 * result + (getRetNom() == null ? 0 : this.getRetNom().hashCode());
		result = 37 * result + (getRetAdresse() == null ? 0 : this.getRetAdresse().hashCode());
		result = 37 * result + (getRetMail() == null ? 0 : this.getRetMail().hashCode());
		result = 37 * result + (getRetTel() == null ? 0 : this.getRetTel().hashCode());
		result = 37 * result + (getRetPieceNumero() == null ? 0 : this.getRetPieceNumero().hashCode());
		result = 37 * result + (getRetDate() == null ? 0 : this.getRetDate().hashCode());
		result = 37 * result + (getRetTypePiece() == null ? 0 : this.getRetTypePiece().hashCode());
		result = 37 * result + (getRetFonCod() == null ? 0 : this.getRetFonCod().hashCode());
		result = 37 * result + (getRetOpeMatricule() == null ? 0 : this.getRetOpeMatricule().hashCode());
		return result;
	}

}
