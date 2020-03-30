package com.sndi.models;
// Generated 30 mars 2020 01:35:59 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbTypeDacSpecs generated by hbm2java
 */
@Entity
@Table(name = "VB_TYPE_DAC_SPECS", schema = "EMAP")
public class VbTypeDacSpecs implements java.io.Serializable {

	private VbTypeDacSpecsId id;

	public VbTypeDacSpecs() {
	}

	public VbTypeDacSpecs(VbTypeDacSpecsId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "tdcCode", column = @Column(name = "TDC_CODE", nullable = false, length = 3)),
			@AttributeOverride(name = "tdcLibelle", column = @Column(name = "TDC_LIBELLE", length = 1000)) })
	public VbTypeDacSpecsId getId() {
		return this.id;
	}

	public void setId(VbTypeDacSpecsId id) {
		this.id = id;
	}

}
