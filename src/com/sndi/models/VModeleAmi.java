package com.sndi.models;
// Generated 25 juin 2020 13:53:46 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VModeleAmi generated by hbm2java
 */
@Entity
@Table(name = "V_MODELE_AMI", schema = "EMAP")
public class VModeleAmi implements java.io.Serializable {

	private VModeleAmiId id;

	public VModeleAmi() {
	}

	public VModeleAmi(VModeleAmiId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "gpgId", column = @Column(name = "GPG_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "mdtCode", column = @Column(name = "MDT_CODE", nullable = false, length = 15)),
			@AttributeOverride(name = "mdtLibelleLong", column = @Column(name = "MDT_LIBELLE_LONG", length = 500)),
			@AttributeOverride(name = "mdtLibelleCourt", column = @Column(name = "MDT_LIBELLE_COURT", length = 500)),
			@AttributeOverride(name = "mdtDteSaisi", column = @Column(name = "MDT_DTE_SAISI", length = 7)),
			@AttributeOverride(name = "mdtOpeMatricule", column = @Column(name = "MDT_OPE_MATRICULE", length = 25)),
			@AttributeOverride(name = "mdtTymCode", column = @Column(name = "MDT_TYM_CODE", length = 3)) })
	public VModeleAmiId getId() {
		return this.id;
	}

	public void setId(VModeleAmiId id) {
		this.id = id;
	}

}