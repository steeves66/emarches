package com.sndi.models;
// Generated 26 mars 2020 03:50:59 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbTypeProcedure generated by hbm2java
 */
@Entity
@Table(name = "VB_TYPE_PROCEDURE", schema = "EMAP")
public class VbTypeProcedure implements java.io.Serializable {

	private VbTypeProcedureId id;

	public VbTypeProcedure() {
	}

	public VbTypeProcedure(VbTypeProcedureId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "typId", column = @Column(name = "TYP_ID", nullable = false, length = 5)),
			@AttributeOverride(name = "typLib", column = @Column(name = "TYP_LIB", length = 1000)) })
	public VbTypeProcedureId getId() {
		return this.id;
	}

	public void setId(VbTypeProcedureId id) {
		this.id = id;
	}

}
