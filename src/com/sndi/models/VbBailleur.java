package com.sndi.models;
// Generated 19 mars 2020 16:14:06 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbBailleur generated by hbm2java
 */
@Entity
@Table(name = "VB_BAILLEUR", schema = "EMAP")
public class VbBailleur implements java.io.Serializable {

	private VbBailleurId id;

	public VbBailleur() {
	}

	public VbBailleur(VbBailleurId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "baiCode", column = @Column(name = "BAI_CODE", nullable = false, length = 5)),
			@AttributeOverride(name = "baiLibelle", column = @Column(name = "BAI_LIBELLE", nullable = false, length = 1000)),
			@AttributeOverride(name = "baiAdresse", column = @Column(name = "BAI_ADRESSE", length = 500)),
			@AttributeOverride(name = "baiTelephone", column = @Column(name = "BAI_TELEPHONE", length = 500)) })
	public VbBailleurId getId() {
		return this.id;
	}

	public void setId(VbBailleurId id) {
		this.id = id;
	}

}
