package com.sndi.models;
// Generated 27 mars 2020 22:20:54 by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VbBesoinId generated by hbm2java
 */
@Embeddable
public class VbBesoinId implements java.io.Serializable {

	private long besId;
	private long besRegId;
	private int besProId;
	private String besLibelle;
	private String besStatut;

	public VbBesoinId() {
	}

	public VbBesoinId(long besId, long besRegId, int besProId) {
		this.besId = besId;
		this.besRegId = besRegId;
		this.besProId = besProId;
	}

	public VbBesoinId(long besId, long besRegId, int besProId, String besLibelle, String besStatut) {
		this.besId = besId;
		this.besRegId = besRegId;
		this.besProId = besProId;
		this.besLibelle = besLibelle;
		this.besStatut = besStatut;
	}

	@Column(name = "BES_ID", nullable = false, precision = 10, scale = 0)
	public long getBesId() {
		return this.besId;
	}

	public void setBesId(long besId) {
		this.besId = besId;
	}

	@Column(name = "BES_REG_ID", nullable = false, precision = 10, scale = 0)
	public long getBesRegId() {
		return this.besRegId;
	}

	public void setBesRegId(long besRegId) {
		this.besRegId = besRegId;
	}

	@Column(name = "BES_PRO_ID", nullable = false, precision = 5, scale = 0)
	public int getBesProId() {
		return this.besProId;
	}

	public void setBesProId(int besProId) {
		this.besProId = besProId;
	}

	@Column(name = "BES_LIBELLE", length = 1000)
	public String getBesLibelle() {
		return this.besLibelle;
	}

	public void setBesLibelle(String besLibelle) {
		this.besLibelle = besLibelle;
	}

	@Column(name = "BES_STATUT", length = 1)
	public String getBesStatut() {
		return this.besStatut;
	}

	public void setBesStatut(String besStatut) {
		this.besStatut = besStatut;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VbBesoinId))
			return false;
		VbBesoinId castOther = (VbBesoinId) other;

		return (this.getBesId() == castOther.getBesId()) && (this.getBesRegId() == castOther.getBesRegId())
				&& (this.getBesProId() == castOther.getBesProId())
				&& ((this.getBesLibelle() == castOther.getBesLibelle()) || (this.getBesLibelle() != null
						&& castOther.getBesLibelle() != null && this.getBesLibelle().equals(castOther.getBesLibelle())))
				&& ((this.getBesStatut() == castOther.getBesStatut()) || (this.getBesStatut() != null
						&& castOther.getBesStatut() != null && this.getBesStatut().equals(castOther.getBesStatut())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getBesId();
		result = 37 * result + (int) this.getBesRegId();
		result = 37 * result + this.getBesProId();
		result = 37 * result + (getBesLibelle() == null ? 0 : this.getBesLibelle().hashCode());
		result = 37 * result + (getBesStatut() == null ? 0 : this.getBesStatut().hashCode());
		return result;
	}

}
