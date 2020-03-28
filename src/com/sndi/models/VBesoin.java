package com.sndi.models;
// Generated 28 mars 2020 15:50:26 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VBesoin generated by hbm2java
 */
@Entity
@Table(name = "V_BESOIN", schema = "EMAP")
public class VBesoin implements java.io.Serializable {

	private VBesoinId id;

	public VBesoin() {
	}

	public VBesoin(VBesoinId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "besId", column = @Column(name = "BES_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "besLibelle", column = @Column(name = "BES_LIBELLE", length = 1000)),
			@AttributeOverride(name = "besProId", column = @Column(name = "BES_PRO_ID", nullable = false, precision = 5, scale = 0)),
			@AttributeOverride(name = "besStatut", column = @Column(name = "BES_STATUT", length = 1)),
			@AttributeOverride(name = "regLibelleLong", column = @Column(name = "REG_LIBELLE_LONG", length = 1000)),
			@AttributeOverride(name = "regLibelleCourt", column = @Column(name = "REG_LIBELLE_COURT", length = 500)) })
	public VBesoinId getId() {
		return this.id;
	}

	public void setId(VBesoinId id) {
		this.id = id;
	}

}
