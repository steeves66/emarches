package com.sndi.models;
// Generated 28 mars 2020 03:24:07 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VPgpmStatut generated by hbm2java
 */
@Entity
@Table(name = "V_PGPM_STATUT", schema = "EMAP")
public class VPgpmStatut implements java.io.Serializable {

	private VPgpmStatutId id;

	public VPgpmStatut() {
	}

	public VPgpmStatut(VPgpmStatutId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "hpgId", column = @Column(name = "HPG_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "hpgDate", column = @Column(name = "HPG_DATE", length = 7)),
			@AttributeOverride(name = "hpgMotif", column = @Column(name = "HPG_MOTIF", length = 1000)),
			@AttributeOverride(name = "hpgStaCode", column = @Column(name = "HPG_STA_CODE", nullable = false, length = 3)),
			@AttributeOverride(name = "hpgGpgId", column = @Column(name = "HPG_GPG_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "hpgFonCod", column = @Column(name = "HPG_FON_COD", nullable = false, length = 12)),
			@AttributeOverride(name = "fonLibelle", column = @Column(name = "FON_LIBELLE", length = 500)) })
	public VPgpmStatutId getId() {
		return this.id;
	}

	public void setId(VPgpmStatutId id) {
		this.id = id;
	}

}
