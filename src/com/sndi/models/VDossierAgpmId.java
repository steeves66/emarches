package com.sndi.models;
// Generated 8 ao�t 2020 14:11:26 by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VDossierAgpmId generated by hbm2java
 */
@Embeddable
public class VDossierAgpmId implements java.io.Serializable {

	private long dagId;
	private String dagNapCode;
	private long dagAgpId;
	private String dagCode;
	private String dagLibelle;
	private String dagCommentaire;
	private String dagReference;

	public VDossierAgpmId() {
	}

	public VDossierAgpmId(long dagId, String dagNapCode, long dagAgpId) {
		this.dagId = dagId;
		this.dagNapCode = dagNapCode;
		this.dagAgpId = dagAgpId;
	}

	public VDossierAgpmId(long dagId, String dagNapCode, long dagAgpId, String dagCode, String dagLibelle,
			String dagCommentaire, String dagReference) {
		this.dagId = dagId;
		this.dagNapCode = dagNapCode;
		this.dagAgpId = dagAgpId;
		this.dagCode = dagCode;
		this.dagLibelle = dagLibelle;
		this.dagCommentaire = dagCommentaire;
		this.dagReference = dagReference;
	}

	@Column(name = "DAG_ID", nullable = false, precision = 10, scale = 0)
	public long getDagId() {
		return this.dagId;
	}

	public void setDagId(long dagId) {
		this.dagId = dagId;
	}

	@Column(name = "DAG_NAP_CODE", nullable = false, length = 5)
	public String getDagNapCode() {
		return this.dagNapCode;
	}

	public void setDagNapCode(String dagNapCode) {
		this.dagNapCode = dagNapCode;
	}

	@Column(name = "DAG_AGP_ID", nullable = false, precision = 10, scale = 0)
	public long getDagAgpId() {
		return this.dagAgpId;
	}

	public void setDagAgpId(long dagAgpId) {
		this.dagAgpId = dagAgpId;
	}

	@Column(name = "DAG_CODE", length = 500)
	public String getDagCode() {
		return this.dagCode;
	}

	public void setDagCode(String dagCode) {
		this.dagCode = dagCode;
	}

	@Column(name = "DAG_LIBELLE", length = 500)
	public String getDagLibelle() {
		return this.dagLibelle;
	}

	public void setDagLibelle(String dagLibelle) {
		this.dagLibelle = dagLibelle;
	}

	@Column(name = "DAG_COMMENTAIRE", length = 500)
	public String getDagCommentaire() {
		return this.dagCommentaire;
	}

	public void setDagCommentaire(String dagCommentaire) {
		this.dagCommentaire = dagCommentaire;
	}

	@Column(name = "DAG_REFERENCE", length = 500)
	public String getDagReference() {
		return this.dagReference;
	}

	public void setDagReference(String dagReference) {
		this.dagReference = dagReference;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VDossierAgpmId))
			return false;
		VDossierAgpmId castOther = (VDossierAgpmId) other;

		return (this.getDagId() == castOther.getDagId())
				&& ((this.getDagNapCode() == castOther.getDagNapCode()) || (this.getDagNapCode() != null
						&& castOther.getDagNapCode() != null && this.getDagNapCode().equals(castOther.getDagNapCode())))
				&& (this.getDagAgpId() == castOther.getDagAgpId())
				&& ((this.getDagCode() == castOther.getDagCode()) || (this.getDagCode() != null
						&& castOther.getDagCode() != null && this.getDagCode().equals(castOther.getDagCode())))
				&& ((this.getDagLibelle() == castOther.getDagLibelle()) || (this.getDagLibelle() != null
						&& castOther.getDagLibelle() != null && this.getDagLibelle().equals(castOther.getDagLibelle())))
				&& ((this.getDagCommentaire() == castOther.getDagCommentaire())
						|| (this.getDagCommentaire() != null && castOther.getDagCommentaire() != null
								&& this.getDagCommentaire().equals(castOther.getDagCommentaire())))
				&& ((this.getDagReference() == castOther.getDagReference())
						|| (this.getDagReference() != null && castOther.getDagReference() != null
								&& this.getDagReference().equals(castOther.getDagReference())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getDagId();
		result = 37 * result + (getDagNapCode() == null ? 0 : this.getDagNapCode().hashCode());
		result = 37 * result + (int) this.getDagAgpId();
		result = 37 * result + (getDagCode() == null ? 0 : this.getDagCode().hashCode());
		result = 37 * result + (getDagLibelle() == null ? 0 : this.getDagLibelle().hashCode());
		result = 37 * result + (getDagCommentaire() == null ? 0 : this.getDagCommentaire().hashCode());
		result = 37 * result + (getDagReference() == null ? 0 : this.getDagReference().hashCode());
		return result;
	}

}
