package com.sndi.models;
// Generated 8 ao�t 2020 14:11:26 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbTypeCommission generated by hbm2java
 */
@Entity
@Table(name = "VB_TYPE_COMMISSION", schema = "EMAP")
public class VbTypeCommission implements java.io.Serializable {

	private VbTypeCommissionId id;

	public VbTypeCommission() {
	}

	public VbTypeCommission(VbTypeCommissionId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "tcoCode", column = @Column(name = "TCO_CODE", nullable = false, length = 3)),
			@AttributeOverride(name = "tcoLibelle", column = @Column(name = "TCO_LIBELLE", length = 500)),
			@AttributeOverride(name = "tcoDteSaisi", column = @Column(name = "TCO_DTE_SAISI", length = 7)),
			@AttributeOverride(name = "tcoOpeMatricule", column = @Column(name = "TCO_OPE_MATRICULE", length = 20)) })
	public VbTypeCommissionId getId() {
		return this.id;
	}

	public void setId(VbTypeCommissionId id) {
		this.id = id;
	}

}
