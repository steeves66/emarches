package com.sndi.models;
// Generated 23 mars 2020 10:48:44 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbTypeCharge generated by hbm2java
 */
@Entity
@Table(name = "VB_TYPE_CHARGE", schema = "EMAP")
public class VbTypeCharge implements java.io.Serializable {

	private VbTypeChargeId id;

	public VbTypeCharge() {
	}

	public VbTypeCharge(VbTypeChargeId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "tycCode", column = @Column(name = "TYC_CODE", nullable = false, length = 3)),
			@AttributeOverride(name = "tycLibelleCourt", column = @Column(name = "TYC_LIBELLE_COURT", nullable = false, length = 500)),
			@AttributeOverride(name = "tycLibelleLong", column = @Column(name = "TYC_LIBELLE_LONG", length = 1000)),
			@AttributeOverride(name = "tymTymCode", column = @Column(name = "TYM_TYM_CODE", length = 3)),
			@AttributeOverride(name = "tymGroupe", column = @Column(name = "TYM_GROUPE", length = 3)) })
	public VbTypeChargeId getId() {
		return this.id;
	}

	public void setId(VbTypeChargeId id) {
		this.id = id;
	}

}
