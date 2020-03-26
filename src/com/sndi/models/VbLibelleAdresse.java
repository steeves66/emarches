package com.sndi.models;
// Generated 26 mars 2020 03:50:59 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbLibelleAdresse generated by hbm2java
 */
@Entity
@Table(name = "VB_LIBELLE_ADRESSE", schema = "EMAP")
public class VbLibelleAdresse implements java.io.Serializable {

	private VbLibelleAdresseId id;

	public VbLibelleAdresse() {
	}

	public VbLibelleAdresse(VbLibelleAdresseId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "liaNum", column = @Column(name = "LIA_NUM", nullable = false, precision = 3, scale = 0)),
			@AttributeOverride(name = "liaLibelle", column = @Column(name = "LIA_LIBELLE", length = 500)) })
	public VbLibelleAdresseId getId() {
		return this.id;
	}

	public void setId(VbLibelleAdresseId id) {
		this.id = id;
	}

}
