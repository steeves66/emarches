package com.sndi.models;
// Generated 18 juin 2020 16:45:49 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbVenteDac generated by hbm2java
 */
@Entity
@Table(name = "VB_VENTE_DAC", schema = "EMAP")
public class VbVenteDac implements java.io.Serializable {

	private VbVenteDacId id;

	public VbVenteDac() {
	}

	public VbVenteDac(VbVenteDacId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "venNum", column = @Column(name = "VEN_NUM", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "venCanCode", column = @Column(name = "VEN_CAN_CODE", nullable = false, precision = 22, scale = 0)),
			@AttributeOverride(name = "venMrgCod", column = @Column(name = "VEN_MRG_COD", nullable = false, length = 10)),
			@AttributeOverride(name = "venOpeMatricule", column = @Column(name = "VEN_OPE_MATRICULE", nullable = false, length = 25)),
			@AttributeOverride(name = "venDteSaisi", column = @Column(name = "VEN_DTE_SAISI", length = 7)) })
	public VbVenteDacId getId() {
		return this.id;
	}

	public void setId(VbVenteDacId id) {
		this.id = id;
	}

}
