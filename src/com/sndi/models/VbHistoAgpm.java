package com.sndi.models;
// Generated 20 juin 2020 17:16:02 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbHistoAgpm generated by hbm2java
 */
@Entity
@Table(name = "VB_HISTO_AGPM", schema = "EMAP")
public class VbHistoAgpm implements java.io.Serializable {

	private VbHistoAgpmId id;

	public VbHistoAgpm() {
	}

	public VbHistoAgpm(VbHistoAgpmId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "hagId", column = @Column(name = "HAG_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "hagAgpId", column = @Column(name = "HAG_AGP_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "hagStaCode", column = @Column(name = "HAG_STA_CODE", nullable = false, length = 3)),
			@AttributeOverride(name = "hagDate", column = @Column(name = "HAG_DATE", length = 7)),
			@AttributeOverride(name = "hagMotif", column = @Column(name = "HAG_MOTIF", length = 1000)),
			@AttributeOverride(name = "hagFonCod", column = @Column(name = "HAG_FON_COD", length = 12)) })
	public VbHistoAgpmId getId() {
		return this.id;
	}

	public void setId(VbHistoAgpmId id) {
		this.id = id;
	}

}
