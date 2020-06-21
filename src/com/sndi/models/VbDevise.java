package com.sndi.models;
// Generated 20 juin 2020 17:16:02 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbDevise generated by hbm2java
 */
@Entity
@Table(name = "VB_DEVISE", schema = "EMAP")
public class VbDevise implements java.io.Serializable {

	private VbDeviseId id;

	public VbDevise() {
	}

	public VbDevise(VbDeviseId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "devCode", column = @Column(name = "DEV_CODE", nullable = false, length = 8)),
			@AttributeOverride(name = "devLibelle", column = @Column(name = "DEV_LIBELLE", length = 500)),
			@AttributeOverride(name = "devSymbole", column = @Column(name = "DEV_SYMBOLE", length = 500)) })
	public VbDeviseId getId() {
		return this.id;
	}

	public void setId(VbDeviseId id) {
		this.id = id;
	}

}
