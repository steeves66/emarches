package com.sndi.models;
// Generated 27 mars 2020 22:20:54 by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VDetailEtatId generated by hbm2java
 */
@Embeddable
public class VDetailEtatId implements java.io.Serializable {

	private long agpId;
	private String tcaLibelle;
	private String tdaTitre;
	private String tdaCommentaire;
	private String tcaCode;
	private String tdaNumOrdre;

	public VDetailEtatId() {
	}

	public VDetailEtatId(long agpId) {
		this.agpId = agpId;
	}

	public VDetailEtatId(long agpId, String tcaLibelle, String tdaTitre, String tdaCommentaire, String tcaCode,
			String tdaNumOrdre) {
		this.agpId = agpId;
		this.tcaLibelle = tcaLibelle;
		this.tdaTitre = tdaTitre;
		this.tdaCommentaire = tdaCommentaire;
		this.tcaCode = tcaCode;
		this.tdaNumOrdre = tdaNumOrdre;
	}

	@Column(name = "AGP_ID", nullable = false, precision = 10, scale = 0)
	public long getAgpId() {
		return this.agpId;
	}

	public void setAgpId(long agpId) {
		this.agpId = agpId;
	}

	@Column(name = "TCA_LIBELLE", length = 200)
	public String getTcaLibelle() {
		return this.tcaLibelle;
	}

	public void setTcaLibelle(String tcaLibelle) {
		this.tcaLibelle = tcaLibelle;
	}

	@Column(name = "TDA_TITRE", length = 100)
	public String getTdaTitre() {
		return this.tdaTitre;
	}

	public void setTdaTitre(String tdaTitre) {
		this.tdaTitre = tdaTitre;
	}

	@Column(name = "TDA_COMMENTAIRE", length = 4000)
	public String getTdaCommentaire() {
		return this.tdaCommentaire;
	}

	public void setTdaCommentaire(String tdaCommentaire) {
		this.tdaCommentaire = tdaCommentaire;
	}

	@Column(name = "TCA_CODE", length = 4)
	public String getTcaCode() {
		return this.tcaCode;
	}

	public void setTcaCode(String tcaCode) {
		this.tcaCode = tcaCode;
	}

	@Column(name = "TDA_NUM_ORDRE", length = 3)
	public String getTdaNumOrdre() {
		return this.tdaNumOrdre;
	}

	public void setTdaNumOrdre(String tdaNumOrdre) {
		this.tdaNumOrdre = tdaNumOrdre;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VDetailEtatId))
			return false;
		VDetailEtatId castOther = (VDetailEtatId) other;

		return (this.getAgpId() == castOther.getAgpId())
				&& ((this.getTcaLibelle() == castOther.getTcaLibelle()) || (this.getTcaLibelle() != null
						&& castOther.getTcaLibelle() != null && this.getTcaLibelle().equals(castOther.getTcaLibelle())))
				&& ((this.getTdaTitre() == castOther.getTdaTitre()) || (this.getTdaTitre() != null
						&& castOther.getTdaTitre() != null && this.getTdaTitre().equals(castOther.getTdaTitre())))
				&& ((this.getTdaCommentaire() == castOther.getTdaCommentaire())
						|| (this.getTdaCommentaire() != null && castOther.getTdaCommentaire() != null
								&& this.getTdaCommentaire().equals(castOther.getTdaCommentaire())))
				&& ((this.getTcaCode() == castOther.getTcaCode()) || (this.getTcaCode() != null
						&& castOther.getTcaCode() != null && this.getTcaCode().equals(castOther.getTcaCode())))
				&& ((this.getTdaNumOrdre() == castOther.getTdaNumOrdre())
						|| (this.getTdaNumOrdre() != null && castOther.getTdaNumOrdre() != null
								&& this.getTdaNumOrdre().equals(castOther.getTdaNumOrdre())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getAgpId();
		result = 37 * result + (getTcaLibelle() == null ? 0 : this.getTcaLibelle().hashCode());
		result = 37 * result + (getTdaTitre() == null ? 0 : this.getTdaTitre().hashCode());
		result = 37 * result + (getTdaCommentaire() == null ? 0 : this.getTdaCommentaire().hashCode());
		result = 37 * result + (getTcaCode() == null ? 0 : this.getTcaCode().hashCode());
		result = 37 * result + (getTdaNumOrdre() == null ? 0 : this.getTdaNumOrdre().hashCode());
		return result;
	}

}
