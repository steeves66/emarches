package com.sndi.models;
// Generated 19 mars 2020 18:39:08 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbDestinations generated by hbm2java
 */
@Entity
@Table(name = "VB_DESTINATIONS", schema = "EMAP")
public class VbDestinations implements java.io.Serializable {

	private VbDestinationsId id;

	public VbDestinations() {
	}

	public VbDestinations(VbDestinationsId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "desCode", column = @Column(name = "DES_CODE")),
			@AttributeOverride(name = "desAdr", column = @Column(name = "DES_ADR")),
			@AttributeOverride(name = "desLib", column = @Column(name = "DES_LIB")),
			@AttributeOverride(name = "desUtilSaisi", column = @Column(name = "DES_UTIL_SAISI")),
			@AttributeOverride(name = "desUtilModif", column = @Column(name = "DES_UTIL_MODIF")),
			@AttributeOverride(name = "desDdteModif", column = @Column(name = "DES_DDTE_MODIF")),
			@AttributeOverride(name = "desDteSaisi", column = @Column(name = "DES_DTE_SAISI")),
			@AttributeOverride(name = "desRegCode", column = @Column(name = "DES_REG_CODE")) })
	public VbDestinationsId getId() {
		return this.id;
	}

	public void setId(VbDestinationsId id) {
		this.id = id;
	}

}
