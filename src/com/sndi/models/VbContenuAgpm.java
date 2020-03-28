package com.sndi.models;
// Generated 27 mars 2020 22:20:54 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbContenuAgpm generated by hbm2java
 */
@Entity
@Table(name = "VB_CONTENU_AGPM", schema = "EMAP")
public class VbContenuAgpm implements java.io.Serializable {

	private VbContenuAgpmId id;

	public VbContenuAgpm() {
	}

	public VbContenuAgpm(VbContenuAgpmId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "tcaCode", column = @Column(name = "TCA_CODE", nullable = false, length = 4)),
			@AttributeOverride(name = "tcaLibelle", column = @Column(name = "TCA_LIBELLE", length = 200)) })
	public VbContenuAgpmId getId() {
		return this.id;
	}

	public void setId(VbContenuAgpmId id) {
		this.id = id;
	}

}
