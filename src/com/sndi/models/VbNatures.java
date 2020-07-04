package com.sndi.models;
// Generated 4 juil. 2020 18:05:44 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbNatures generated by hbm2java
 */
@Entity
@Table(name = "VB_NATURES", schema = "EMAP")
public class VbNatures implements java.io.Serializable {

	private VbNaturesId id;

	public VbNatures() {
	}

	public VbNatures(VbNaturesId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "natLibelle", column = @Column(name = "NAT_LIBELLE")),
			@AttributeOverride(name = "natCode", column = @Column(name = "NAT_CODE")),
			@AttributeOverride(name = "natUtilSaisi", column = @Column(name = "NAT_UTIL_SAISI")),
			@AttributeOverride(name = "natUtilModif", column = @Column(name = "NAT_UTIL_MODIF")),
			@AttributeOverride(name = "natDteSaisi", column = @Column(name = "NAT_DTE_SAISI")),
			@AttributeOverride(name = "natDteModif", column = @Column(name = "NAT_DTE_MODIF")),
			@AttributeOverride(name = "natCClasse", column = @Column(name = "NAT_C_CLASSE")) })
	public VbNaturesId getId() {
		return this.id;
	}

	public void setId(VbNaturesId id) {
		this.id = id;
	}

}
