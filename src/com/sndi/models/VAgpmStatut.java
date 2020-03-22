package com.sndi.models;
// Generated 22 mars 2020 01:52:15 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VAgpmStatut generated by hbm2java
 */
@Entity
@Table(name = "V_AGPM_STATUT", schema = "EMAP")
public class VAgpmStatut implements java.io.Serializable {

	private VAgpmStatutId id;

	public VAgpmStatut() {
	}

	public VAgpmStatut(VAgpmStatutId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "hagId", column = @Column(name = "HAG_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "hagDate", column = @Column(name = "HAG_DATE", length = 7)),
			@AttributeOverride(name = "hagMotif", column = @Column(name = "HAG_MOTIF", length = 1000)),
			@AttributeOverride(name = "hagStaCode", column = @Column(name = "HAG_STA_CODE", nullable = false, length = 3)),
			@AttributeOverride(name = "hagAgpId", column = @Column(name = "HAG_AGP_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "hagFonCod", column = @Column(name = "HAG_FON_COD", length = 12)),
			@AttributeOverride(name = "agpProId", column = @Column(name = "AGP_PRO_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "fonLibelle", column = @Column(name = "FON_LIBELLE", length = 500)) })
	public VAgpmStatutId getId() {
		return this.id;
	}

	public void setId(VAgpmStatutId id) {
		this.id = id;
	}

}
