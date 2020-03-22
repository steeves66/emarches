package com.sndi.models;
// Generated 22 mars 2020 01:52:15 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbTypeSeance generated by hbm2java
 */
@Entity
@Table(name = "VB_TYPE_SEANCE", schema = "EMAP")
public class VbTypeSeance implements java.io.Serializable {

	private VbTypeSeanceId id;

	public VbTypeSeance() {
	}

	public VbTypeSeance(VbTypeSeanceId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "tseCode", column = @Column(name = "TSE_CODE", nullable = false, length = 3)),
			@AttributeOverride(name = "tseLibelle", column = @Column(name = "TSE_LIBELLE", length = 500)),
			@AttributeOverride(name = "tseDteSaisi", column = @Column(name = "TSE_DTE_SAISI", length = 7)),
			@AttributeOverride(name = "tseFonCode", column = @Column(name = "TSE_FON_CODE", length = 12)),
			@AttributeOverride(name = "tseOpeMatricule", column = @Column(name = "TSE_OPE_MATRICULE", length = 25)) })
	public VbTypeSeanceId getId() {
		return this.id;
	}

	public void setId(VbTypeSeanceId id) {
		this.id = id;
	}

}
