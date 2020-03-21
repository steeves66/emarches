package com.sndi.models;
// Generated 21 mars 2020 13:48:08 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbStatut generated by hbm2java
 */
@Entity
@Table(name = "VB_STATUT", schema = "EMAP")
public class VbStatut implements java.io.Serializable {

	private VbStatutId id;

	public VbStatut() {
	}

	public VbStatut(VbStatutId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "staCode", column = @Column(name = "STA_CODE", nullable = false, length = 3)),
			@AttributeOverride(name = "staLibelleCourt", column = @Column(name = "STA_LIBELLE_COURT", length = 500)),
			@AttributeOverride(name = "staLibelleLong", column = @Column(name = "STA_LIBELLE_LONG", length = 1000)) })
	public VbStatutId getId() {
		return this.id;
	}

	public void setId(VbStatutId id) {
		this.id = id;
	}

}
