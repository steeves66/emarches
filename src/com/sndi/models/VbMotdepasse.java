package com.sndi.models;
// Generated 8 ao�t 2020 14:11:26 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbMotdepasse generated by hbm2java
 */
@Entity
@Table(name = "VB_MOTDEPASSE", schema = "EMAP")
public class VbMotdepasse implements java.io.Serializable {

	private VbMotdepasseId id;

	public VbMotdepasse() {
	}

	public VbMotdepasse(VbMotdepasseId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "mdpId", column = @Column(name = "MDP_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "mdpOpeMatricule", column = @Column(name = "MDP_OPE_MATRICULE", length = 25)),
			@AttributeOverride(name = "mdpMotdepasse", column = @Column(name = "MDP_MOTDEPASSE", length = 250)),
			@AttributeOverride(name = "mdpStatut", column = @Column(name = "MDP_STATUT", precision = 1, scale = 0)),
			@AttributeOverride(name = "mdpDate", column = @Column(name = "MDP_DATE", length = 7)) })
	public VbMotdepasseId getId() {
		return this.id;
	}

	public void setId(VbMotdepasseId id) {
		this.id = id;
	}

}
