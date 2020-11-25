package com.sndi.models;
// Generated 23 nov. 2020 12:59:43 by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VbBailleurId generated by hbm2java
 */
@Embeddable
public class VbBailleurId implements java.io.Serializable {

	private String baiCode;
	private String baiLibelle;
	private String baiAdresse;
	private String baiTelephone;

	public VbBailleurId() {
	}

	public VbBailleurId(String baiCode, String baiLibelle) {
		this.baiCode = baiCode;
		this.baiLibelle = baiLibelle;
	}

	public VbBailleurId(String baiCode, String baiLibelle, String baiAdresse, String baiTelephone) {
		this.baiCode = baiCode;
		this.baiLibelle = baiLibelle;
		this.baiAdresse = baiAdresse;
		this.baiTelephone = baiTelephone;
	}

	@Column(name = "BAI_CODE", nullable = false, length = 20)
	public String getBaiCode() {
		return this.baiCode;
	}

	public void setBaiCode(String baiCode) {
		this.baiCode = baiCode;
	}

	@Column(name = "BAI_LIBELLE", nullable = false, length = 1000)
	public String getBaiLibelle() {
		return this.baiLibelle;
	}

	public void setBaiLibelle(String baiLibelle) {
		this.baiLibelle = baiLibelle;
	}

	@Column(name = "BAI_ADRESSE", length = 500)
	public String getBaiAdresse() {
		return this.baiAdresse;
	}

	public void setBaiAdresse(String baiAdresse) {
		this.baiAdresse = baiAdresse;
	}

	@Column(name = "BAI_TELEPHONE", length = 500)
	public String getBaiTelephone() {
		return this.baiTelephone;
	}

	public void setBaiTelephone(String baiTelephone) {
		this.baiTelephone = baiTelephone;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VbBailleurId))
			return false;
		VbBailleurId castOther = (VbBailleurId) other;

		return ((this.getBaiCode() == castOther.getBaiCode()) || (this.getBaiCode() != null
				&& castOther.getBaiCode() != null && this.getBaiCode().equals(castOther.getBaiCode())))
				&& ((this.getBaiLibelle() == castOther.getBaiLibelle()) || (this.getBaiLibelle() != null
						&& castOther.getBaiLibelle() != null && this.getBaiLibelle().equals(castOther.getBaiLibelle())))
				&& ((this.getBaiAdresse() == castOther.getBaiAdresse()) || (this.getBaiAdresse() != null
						&& castOther.getBaiAdresse() != null && this.getBaiAdresse().equals(castOther.getBaiAdresse())))
				&& ((this.getBaiTelephone() == castOther.getBaiTelephone())
						|| (this.getBaiTelephone() != null && castOther.getBaiTelephone() != null
								&& this.getBaiTelephone().equals(castOther.getBaiTelephone())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getBaiCode() == null ? 0 : this.getBaiCode().hashCode());
		result = 37 * result + (getBaiLibelle() == null ? 0 : this.getBaiLibelle().hashCode());
		result = 37 * result + (getBaiAdresse() == null ? 0 : this.getBaiAdresse().hashCode());
		result = 37 * result + (getBaiTelephone() == null ? 0 : this.getBaiTelephone().hashCode());
		return result;
	}

}
