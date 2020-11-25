package com.sndi.models;
// Generated 23 nov. 2020 12:59:43 by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VAgpmBailleurId generated by hbm2java
 */
@Embeddable
public class VAgpmBailleurId implements java.io.Serializable {

	private long agpId;
	private long proId;
	private String proTitre;
	private String baiCode;
	private String baiLibelle;
	private String baiAdresse;
	private String baiTelephone;

	public VAgpmBailleurId() {
	}

	public VAgpmBailleurId(long agpId, long proId, String proTitre, String baiCode, String baiLibelle) {
		this.agpId = agpId;
		this.proId = proId;
		this.proTitre = proTitre;
		this.baiCode = baiCode;
		this.baiLibelle = baiLibelle;
	}

	public VAgpmBailleurId(long agpId, long proId, String proTitre, String baiCode, String baiLibelle,
			String baiAdresse, String baiTelephone) {
		this.agpId = agpId;
		this.proId = proId;
		this.proTitre = proTitre;
		this.baiCode = baiCode;
		this.baiLibelle = baiLibelle;
		this.baiAdresse = baiAdresse;
		this.baiTelephone = baiTelephone;
	}

	@Column(name = "AGP_ID", nullable = false, precision = 10, scale = 0)
	public long getAgpId() {
		return this.agpId;
	}

	public void setAgpId(long agpId) {
		this.agpId = agpId;
	}

	@Column(name = "PRO_ID", nullable = false, precision = 10, scale = 0)
	public long getProId() {
		return this.proId;
	}

	public void setProId(long proId) {
		this.proId = proId;
	}

	@Column(name = "PRO_TITRE", nullable = false, length = 500)
	public String getProTitre() {
		return this.proTitre;
	}

	public void setProTitre(String proTitre) {
		this.proTitre = proTitre;
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
		if (!(other instanceof VAgpmBailleurId))
			return false;
		VAgpmBailleurId castOther = (VAgpmBailleurId) other;

		return (this.getAgpId() == castOther.getAgpId()) && (this.getProId() == castOther.getProId())
				&& ((this.getProTitre() == castOther.getProTitre()) || (this.getProTitre() != null
						&& castOther.getProTitre() != null && this.getProTitre().equals(castOther.getProTitre())))
				&& ((this.getBaiCode() == castOther.getBaiCode()) || (this.getBaiCode() != null
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

		result = 37 * result + (int) this.getAgpId();
		result = 37 * result + (int) this.getProId();
		result = 37 * result + (getProTitre() == null ? 0 : this.getProTitre().hashCode());
		result = 37 * result + (getBaiCode() == null ? 0 : this.getBaiCode().hashCode());
		result = 37 * result + (getBaiLibelle() == null ? 0 : this.getBaiLibelle().hashCode());
		result = 37 * result + (getBaiAdresse() == null ? 0 : this.getBaiAdresse().hashCode());
		result = 37 * result + (getBaiTelephone() == null ? 0 : this.getBaiTelephone().hashCode());
		return result;
	}

}
