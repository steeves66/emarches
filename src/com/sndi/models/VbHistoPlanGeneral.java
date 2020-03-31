package com.sndi.models;
// Generated 31 mars 2020 01:27:37 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbHistoPlanGeneral generated by hbm2java
 */
@Entity
@Table(name = "VB_HISTO_PLAN_GENERAL", schema = "EMAP")
public class VbHistoPlanGeneral implements java.io.Serializable {

	private VbHistoPlanGeneralId id;

	public VbHistoPlanGeneral() {
	}

	public VbHistoPlanGeneral(VbHistoPlanGeneralId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "hpgId", column = @Column(name = "HPG_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "hpgFonCod", column = @Column(name = "HPG_FON_COD", nullable = false, length = 12)),
			@AttributeOverride(name = "hpgGpgId", column = @Column(name = "HPG_GPG_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "hpgStaCode", column = @Column(name = "HPG_STA_CODE", nullable = false, length = 3)),
			@AttributeOverride(name = "hpgDate", column = @Column(name = "HPG_DATE", length = 7)),
			@AttributeOverride(name = "hpgMotif", column = @Column(name = "HPG_MOTIF", length = 1000)) })
	public VbHistoPlanGeneralId getId() {
		return this.id;
	}

	public void setId(VbHistoPlanGeneralId id) {
		this.id = id;
	}

}
