package com.sndi.models;
// Generated 19 mars 2020 18:39:08 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbNatureDocuments generated by hbm2java
 */
@Entity
@Table(name = "VB_NATURE_DOCUMENTS", schema = "EMAP")
public class VbNatureDocuments implements java.io.Serializable {

	private VbNatureDocumentsId id;

	public VbNatureDocuments() {
	}

	public VbNatureDocuments(VbNatureDocumentsId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "nadCode", column = @Column(name = "NAD_CODE", nullable = false, length = 3)),
			@AttributeOverride(name = "nadLibelle", column = @Column(name = "NAD_LIBELLE", length = 500)),
			@AttributeOverride(name = "nadAbrege", column = @Column(name = "NAD_ABREGE", length = 20)),
			@AttributeOverride(name = "nadType", column = @Column(name = "NAD_TYPE", length = 3)) })
	public VbNatureDocumentsId getId() {
		return this.id;
	}

	public void setId(VbNatureDocumentsId id) {
		this.id = id;
	}

}
