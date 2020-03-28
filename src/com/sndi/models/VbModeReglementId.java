package com.sndi.models;
// Generated 28 mars 2020 15:50:26 by Hibernate Tools 4.3.5.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VbModeReglementId generated by hbm2java
 */
@Embeddable
public class VbModeReglementId implements java.io.Serializable {

	private String mrgCod;
	private String mrgLibelle;
	private Date mrgDteSaisie;
	private String mrgOpeMatricule;

	public VbModeReglementId() {
	}

	public VbModeReglementId(String mrgCod) {
		this.mrgCod = mrgCod;
	}

	public VbModeReglementId(String mrgCod, String mrgLibelle, Date mrgDteSaisie, String mrgOpeMatricule) {
		this.mrgCod = mrgCod;
		this.mrgLibelle = mrgLibelle;
		this.mrgDteSaisie = mrgDteSaisie;
		this.mrgOpeMatricule = mrgOpeMatricule;
	}

	@Column(name = "MRG_COD", nullable = false, length = 10)
	public String getMrgCod() {
		return this.mrgCod;
	}

	public void setMrgCod(String mrgCod) {
		this.mrgCod = mrgCod;
	}

	@Column(name = "MRG_LIBELLE", length = 200)
	public String getMrgLibelle() {
		return this.mrgLibelle;
	}

	public void setMrgLibelle(String mrgLibelle) {
		this.mrgLibelle = mrgLibelle;
	}

	@Column(name = "MRG_DTE_SAISIE", length = 7)
	public Date getMrgDteSaisie() {
		return this.mrgDteSaisie;
	}

	public void setMrgDteSaisie(Date mrgDteSaisie) {
		this.mrgDteSaisie = mrgDteSaisie;
	}

	@Column(name = "MRG_OPE_MATRICULE", length = 25)
	public String getMrgOpeMatricule() {
		return this.mrgOpeMatricule;
	}

	public void setMrgOpeMatricule(String mrgOpeMatricule) {
		this.mrgOpeMatricule = mrgOpeMatricule;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VbModeReglementId))
			return false;
		VbModeReglementId castOther = (VbModeReglementId) other;

		return ((this.getMrgCod() == castOther.getMrgCod()) || (this.getMrgCod() != null
				&& castOther.getMrgCod() != null && this.getMrgCod().equals(castOther.getMrgCod())))
				&& ((this.getMrgLibelle() == castOther.getMrgLibelle()) || (this.getMrgLibelle() != null
						&& castOther.getMrgLibelle() != null && this.getMrgLibelle().equals(castOther.getMrgLibelle())))
				&& ((this.getMrgDteSaisie() == castOther.getMrgDteSaisie())
						|| (this.getMrgDteSaisie() != null && castOther.getMrgDteSaisie() != null
								&& this.getMrgDteSaisie().equals(castOther.getMrgDteSaisie())))
				&& ((this.getMrgOpeMatricule() == castOther.getMrgOpeMatricule())
						|| (this.getMrgOpeMatricule() != null && castOther.getMrgOpeMatricule() != null
								&& this.getMrgOpeMatricule().equals(castOther.getMrgOpeMatricule())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getMrgCod() == null ? 0 : this.getMrgCod().hashCode());
		result = 37 * result + (getMrgLibelle() == null ? 0 : this.getMrgLibelle().hashCode());
		result = 37 * result + (getMrgDteSaisie() == null ? 0 : this.getMrgDteSaisie().hashCode());
		result = 37 * result + (getMrgOpeMatricule() == null ? 0 : this.getMrgOpeMatricule().hashCode());
		return result;
	}

}
