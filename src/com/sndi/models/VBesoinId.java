package com.sndi.models;
// Generated 19 mars 2020 16:14:06 by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VBesoinId generated by hbm2java
 */
@Embeddable
public class VBesoinId implements java.io.Serializable {

	private long besId;
	private String besLibelle;
	private int besProId;
	private String besStatut;
	private String regLibelleLong;
	private String regLibelleCourt;

	public VBesoinId() {
	}

	public VBesoinId(long besId, int besProId) {
		this.besId = besId;
		this.besProId = besProId;
	}

	public VBesoinId(long besId, String besLibelle, int besProId, String besStatut, String regLibelleLong,
			String regLibelleCourt) {
		this.besId = besId;
		this.besLibelle = besLibelle;
		this.besProId = besProId;
		this.besStatut = besStatut;
		this.regLibelleLong = regLibelleLong;
		this.regLibelleCourt = regLibelleCourt;
	}

	@Column(name = "BES_ID", nullable = false, precision = 10, scale = 0)
	public long getBesId() {
		return this.besId;
	}

	public void setBesId(long besId) {
		this.besId = besId;
	}

	@Column(name = "BES_LIBELLE", length = 1000)
	public String getBesLibelle() {
		return this.besLibelle;
	}

	public void setBesLibelle(String besLibelle) {
		this.besLibelle = besLibelle;
	}

	@Column(name = "BES_PRO_ID", nullable = false, precision = 5, scale = 0)
	public int getBesProId() {
		return this.besProId;
	}

	public void setBesProId(int besProId) {
		this.besProId = besProId;
	}

	@Column(name = "BES_STATUT", length = 1)
	public String getBesStatut() {
		return this.besStatut;
	}

	public void setBesStatut(String besStatut) {
		this.besStatut = besStatut;
	}

	@Column(name = "REG_LIBELLE_LONG", length = 1000)
	public String getRegLibelleLong() {
		return this.regLibelleLong;
	}

	public void setRegLibelleLong(String regLibelleLong) {
		this.regLibelleLong = regLibelleLong;
	}

	@Column(name = "REG_LIBELLE_COURT", length = 500)
	public String getRegLibelleCourt() {
		return this.regLibelleCourt;
	}

	public void setRegLibelleCourt(String regLibelleCourt) {
		this.regLibelleCourt = regLibelleCourt;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VBesoinId))
			return false;
		VBesoinId castOther = (VBesoinId) other;

		return (this.getBesId() == castOther.getBesId())
				&& ((this.getBesLibelle() == castOther.getBesLibelle()) || (this.getBesLibelle() != null
						&& castOther.getBesLibelle() != null && this.getBesLibelle().equals(castOther.getBesLibelle())))
				&& (this.getBesProId() == castOther.getBesProId())
				&& ((this.getBesStatut() == castOther.getBesStatut()) || (this.getBesStatut() != null
						&& castOther.getBesStatut() != null && this.getBesStatut().equals(castOther.getBesStatut())))
				&& ((this.getRegLibelleLong() == castOther.getRegLibelleLong())
						|| (this.getRegLibelleLong() != null && castOther.getRegLibelleLong() != null
								&& this.getRegLibelleLong().equals(castOther.getRegLibelleLong())))
				&& ((this.getRegLibelleCourt() == castOther.getRegLibelleCourt())
						|| (this.getRegLibelleCourt() != null && castOther.getRegLibelleCourt() != null
								&& this.getRegLibelleCourt().equals(castOther.getRegLibelleCourt())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getBesId();
		result = 37 * result + (getBesLibelle() == null ? 0 : this.getBesLibelle().hashCode());
		result = 37 * result + this.getBesProId();
		result = 37 * result + (getBesStatut() == null ? 0 : this.getBesStatut().hashCode());
		result = 37 * result + (getRegLibelleLong() == null ? 0 : this.getRegLibelleLong().hashCode());
		result = 37 * result + (getRegLibelleCourt() == null ? 0 : this.getRegLibelleCourt().hashCode());
		return result;
	}

}
