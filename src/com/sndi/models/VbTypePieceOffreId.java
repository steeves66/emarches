package com.sndi.models;
// Generated 28 mars 2020 15:50:26 by Hibernate Tools 4.3.5.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VbTypePieceOffreId generated by hbm2java
 */
@Embeddable
public class VbTypePieceOffreId implements java.io.Serializable {

	private String tpoCode;
	private String tpoLibelle;
	private Date tpoDteSaisi;
	private String tpoOpeMatricule;
	private String tpoEtapPiece;

	public VbTypePieceOffreId() {
	}

	public VbTypePieceOffreId(String tpoCode) {
		this.tpoCode = tpoCode;
	}

	public VbTypePieceOffreId(String tpoCode, String tpoLibelle, Date tpoDteSaisi, String tpoOpeMatricule,
			String tpoEtapPiece) {
		this.tpoCode = tpoCode;
		this.tpoLibelle = tpoLibelle;
		this.tpoDteSaisi = tpoDteSaisi;
		this.tpoOpeMatricule = tpoOpeMatricule;
		this.tpoEtapPiece = tpoEtapPiece;
	}

	@Column(name = "TPO_CODE", nullable = false, length = 10)
	public String getTpoCode() {
		return this.tpoCode;
	}

	public void setTpoCode(String tpoCode) {
		this.tpoCode = tpoCode;
	}

	@Column(name = "TPO_LIBELLE", length = 200)
	public String getTpoLibelle() {
		return this.tpoLibelle;
	}

	public void setTpoLibelle(String tpoLibelle) {
		this.tpoLibelle = tpoLibelle;
	}

	@Column(name = "TPO_DTE_SAISI", length = 7)
	public Date getTpoDteSaisi() {
		return this.tpoDteSaisi;
	}

	public void setTpoDteSaisi(Date tpoDteSaisi) {
		this.tpoDteSaisi = tpoDteSaisi;
	}

	@Column(name = "TPO_OPE_MATRICULE", length = 25)
	public String getTpoOpeMatricule() {
		return this.tpoOpeMatricule;
	}

	public void setTpoOpeMatricule(String tpoOpeMatricule) {
		this.tpoOpeMatricule = tpoOpeMatricule;
	}

	@Column(name = "TPO_ETAP_PIECE", length = 10)
	public String getTpoEtapPiece() {
		return this.tpoEtapPiece;
	}

	public void setTpoEtapPiece(String tpoEtapPiece) {
		this.tpoEtapPiece = tpoEtapPiece;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VbTypePieceOffreId))
			return false;
		VbTypePieceOffreId castOther = (VbTypePieceOffreId) other;

		return ((this.getTpoCode() == castOther.getTpoCode()) || (this.getTpoCode() != null
				&& castOther.getTpoCode() != null && this.getTpoCode().equals(castOther.getTpoCode())))
				&& ((this.getTpoLibelle() == castOther.getTpoLibelle()) || (this.getTpoLibelle() != null
						&& castOther.getTpoLibelle() != null && this.getTpoLibelle().equals(castOther.getTpoLibelle())))
				&& ((this.getTpoDteSaisi() == castOther.getTpoDteSaisi())
						|| (this.getTpoDteSaisi() != null && castOther.getTpoDteSaisi() != null
								&& this.getTpoDteSaisi().equals(castOther.getTpoDteSaisi())))
				&& ((this.getTpoOpeMatricule() == castOther.getTpoOpeMatricule())
						|| (this.getTpoOpeMatricule() != null && castOther.getTpoOpeMatricule() != null
								&& this.getTpoOpeMatricule().equals(castOther.getTpoOpeMatricule())))
				&& ((this.getTpoEtapPiece() == castOther.getTpoEtapPiece())
						|| (this.getTpoEtapPiece() != null && castOther.getTpoEtapPiece() != null
								&& this.getTpoEtapPiece().equals(castOther.getTpoEtapPiece())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getTpoCode() == null ? 0 : this.getTpoCode().hashCode());
		result = 37 * result + (getTpoLibelle() == null ? 0 : this.getTpoLibelle().hashCode());
		result = 37 * result + (getTpoDteSaisi() == null ? 0 : this.getTpoDteSaisi().hashCode());
		result = 37 * result + (getTpoOpeMatricule() == null ? 0 : this.getTpoOpeMatricule().hashCode());
		result = 37 * result + (getTpoEtapPiece() == null ? 0 : this.getTpoEtapPiece().hashCode());
		return result;
	}

}
