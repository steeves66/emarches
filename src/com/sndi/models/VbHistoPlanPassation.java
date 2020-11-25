package com.sndi.models;
// Generated 23 nov. 2020 12:59:43 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbHistoPlanPassation generated by hbm2java
 */
@Entity
@Table(name = "VB_HISTO_PLAN_PASSATION", schema = "EMAP")
public class VbHistoPlanPassation implements java.io.Serializable {

	private VbHistoPlanPassationId id;

	public VbHistoPlanPassation() {
	}

	public VbHistoPlanPassation(VbHistoPlanPassationId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "hppId", column = @Column(name = "HPP_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "hppFonCod", column = @Column(name = "HPP_FON_COD", nullable = false, length = 12)),
			@AttributeOverride(name = "hppDppId", column = @Column(name = "HPP_DPP_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "hppStaCode", column = @Column(name = "HPP_STA_CODE", nullable = false, length = 3)),
			@AttributeOverride(name = "hppDate", column = @Column(name = "HPP_DATE", length = 7)),
			@AttributeOverride(name = "hppMotif", column = @Column(name = "HPP_MOTIF", length = 1000)),
			@AttributeOverride(name = "hppOpeMatricule", column = @Column(name = "HPP_OPE_MATRICULE", length = 25)) })
	public VbHistoPlanPassationId getId() {
		return this.id;
	}

	public void setId(VbHistoPlanPassationId id) {
		this.id = id;
	}

}
