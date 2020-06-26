package com.sndi.models;
// Generated 25 juin 2020 13:53:46 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbSourceFinancement generated by hbm2java
 */
@Entity
@Table(name = "VB_SOURCE_FINANCEMENT", schema = "EMAP")
public class VbSourceFinancement implements java.io.Serializable {

	private VbSourceFinancementId id;

	public VbSourceFinancement() {
	}

	public VbSourceFinancement(VbSourceFinancementId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "souCode", column = @Column(name = "SOU_CODE", nullable = false, length = 5)),
			@AttributeOverride(name = "souLibelle", column = @Column(name = "SOU_LIBELLE", length = 500)) })
	public VbSourceFinancementId getId() {
		return this.id;
	}

	public void setId(VbSourceFinancementId id) {
		this.id = id;
	}

}