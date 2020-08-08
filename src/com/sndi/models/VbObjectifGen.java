package com.sndi.models;
// Generated 8 ao�t 2020 14:11:26 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbObjectifGen generated by hbm2java
 */
@Entity
@Table(name = "VB_OBJECTIF_GEN", schema = "EMAP")
public class VbObjectifGen implements java.io.Serializable {

	private VbObjectifGenId id;

	public VbObjectifGen() {
	}

	public VbObjectifGen(VbObjectifGenId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "obgId", column = @Column(name = "OBG_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "obgProId", column = @Column(name = "OBG_PRO_ID", precision = 10, scale = 0)),
			@AttributeOverride(name = "obgCode", column = @Column(name = "OBG_CODE", length = 10)),
			@AttributeOverride(name = "obgLibelleCourt", column = @Column(name = "OBG_LIBELLE_COURT", length = 500)),
			@AttributeOverride(name = "obgLibelleLong", column = @Column(name = "OBG_LIBELLE_LONG", length = 1000)) })
	public VbObjectifGenId getId() {
		return this.id;
	}

	public void setId(VbObjectifGenId id) {
		this.id = id;
	}

}
