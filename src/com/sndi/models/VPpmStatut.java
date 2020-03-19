package com.sndi.models;
// Generated 19 mars 2020 16:14:06 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VPpmStatut generated by hbm2java
 */
@Entity
@Table(name = "V_PPM_STATUT", schema = "EMAP")
public class VPpmStatut implements java.io.Serializable {

	private VPpmStatutId id;

	public VPpmStatut() {
	}

	public VPpmStatut(VPpmStatutId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "hppStaCode", column = @Column(name = "HPP_STA_CODE", nullable = false, length = 3)),
			@AttributeOverride(name = "hppDppId", column = @Column(name = "HPP_DPP_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "hppId", column = @Column(name = "HPP_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "hppDate", column = @Column(name = "HPP_DATE", length = 7)),
			@AttributeOverride(name = "hppMotif", column = @Column(name = "HPP_MOTIF", length = 1000)),
			@AttributeOverride(name = "fonLibelle", column = @Column(name = "FON_LIBELLE", length = 500)) })
	public VPpmStatutId getId() {
		return this.id;
	}

	public void setId(VPpmStatutId id) {
		this.id = id;
	}

}
