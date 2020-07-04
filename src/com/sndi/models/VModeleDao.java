package com.sndi.models;
// Generated 4 juil. 2020 18:05:44 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VModeleDao generated by hbm2java
 */
@Entity
@Table(name = "V_MODELE_DAO", schema = "EMAP")
public class VModeleDao implements java.io.Serializable {

	private VModeleDaoId id;

	public VModeleDao() {
	}

	public VModeleDao(VModeleDaoId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "VId", column = @Column(name = "V_ID", precision = 22, scale = 0)),
			@AttributeOverride(name = "gpgId", column = @Column(name = "GPG_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "mdtCode", column = @Column(name = "MDT_CODE", nullable = false, length = 15)),
			@AttributeOverride(name = "mdtLibelleCourt", column = @Column(name = "MDT_LIBELLE_COURT", length = 500)),
			@AttributeOverride(name = "mdtLibelleLong", column = @Column(name = "MDT_LIBELLE_LONG", length = 500)),
			@AttributeOverride(name = "mdtTymCode", column = @Column(name = "MDT_TYM_CODE", length = 3)),
			@AttributeOverride(name = "gpgMopCode", column = @Column(name = "GPG_MOP_CODE", nullable = false, length = 3)) })
	public VModeleDaoId getId() {
		return this.id;
	}

	public void setId(VModeleDaoId id) {
		this.id = id;
	}

}
