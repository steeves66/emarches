package com.sndi.models;
// Generated 20 juin 2020 17:16:02 by Hibernate Tools 4.3.5.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VbMotdepasseId generated by hbm2java
 */
@Embeddable
public class VbMotdepasseId implements java.io.Serializable {

	private long mdpId;
	private String mdpOpeMatricule;
	private String mdpMotdepasse;
	private Boolean mdpStatut;
	private Date mdpDate;

	public VbMotdepasseId() {
	}

	public VbMotdepasseId(long mdpId) {
		this.mdpId = mdpId;
	}

	public VbMotdepasseId(long mdpId, String mdpOpeMatricule, String mdpMotdepasse, Boolean mdpStatut, Date mdpDate) {
		this.mdpId = mdpId;
		this.mdpOpeMatricule = mdpOpeMatricule;
		this.mdpMotdepasse = mdpMotdepasse;
		this.mdpStatut = mdpStatut;
		this.mdpDate = mdpDate;
	}

	@Column(name = "MDP_ID", nullable = false, precision = 10, scale = 0)
	public long getMdpId() {
		return this.mdpId;
	}

	public void setMdpId(long mdpId) {
		this.mdpId = mdpId;
	}

	@Column(name = "MDP_OPE_MATRICULE", length = 25)
	public String getMdpOpeMatricule() {
		return this.mdpOpeMatricule;
	}

	public void setMdpOpeMatricule(String mdpOpeMatricule) {
		this.mdpOpeMatricule = mdpOpeMatricule;
	}

	@Column(name = "MDP_MOTDEPASSE", length = 250)
	public String getMdpMotdepasse() {
		return this.mdpMotdepasse;
	}

	public void setMdpMotdepasse(String mdpMotdepasse) {
		this.mdpMotdepasse = mdpMotdepasse;
	}

	@Column(name = "MDP_STATUT", precision = 1, scale = 0)
	public Boolean getMdpStatut() {
		return this.mdpStatut;
	}

	public void setMdpStatut(Boolean mdpStatut) {
		this.mdpStatut = mdpStatut;
	}

	@Column(name = "MDP_DATE", length = 7)
	public Date getMdpDate() {
		return this.mdpDate;
	}

	public void setMdpDate(Date mdpDate) {
		this.mdpDate = mdpDate;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VbMotdepasseId))
			return false;
		VbMotdepasseId castOther = (VbMotdepasseId) other;

		return (this.getMdpId() == castOther.getMdpId())
				&& ((this.getMdpOpeMatricule() == castOther.getMdpOpeMatricule())
						|| (this.getMdpOpeMatricule() != null && castOther.getMdpOpeMatricule() != null
								&& this.getMdpOpeMatricule().equals(castOther.getMdpOpeMatricule())))
				&& ((this.getMdpMotdepasse() == castOther.getMdpMotdepasse())
						|| (this.getMdpMotdepasse() != null && castOther.getMdpMotdepasse() != null
								&& this.getMdpMotdepasse().equals(castOther.getMdpMotdepasse())))
				&& ((this.getMdpStatut() == castOther.getMdpStatut()) || (this.getMdpStatut() != null
						&& castOther.getMdpStatut() != null && this.getMdpStatut().equals(castOther.getMdpStatut())))
				&& ((this.getMdpDate() == castOther.getMdpDate()) || (this.getMdpDate() != null
						&& castOther.getMdpDate() != null && this.getMdpDate().equals(castOther.getMdpDate())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getMdpId();
		result = 37 * result + (getMdpOpeMatricule() == null ? 0 : this.getMdpOpeMatricule().hashCode());
		result = 37 * result + (getMdpMotdepasse() == null ? 0 : this.getMdpMotdepasse().hashCode());
		result = 37 * result + (getMdpStatut() == null ? 0 : this.getMdpStatut().hashCode());
		result = 37 * result + (getMdpDate() == null ? 0 : this.getMdpDate().hashCode());
		return result;
	}

}
