package com.sndi.models;
// Generated 22 mars 2020 01:52:15 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VAgpmBailleur generated by hbm2java
 */
@Entity
@Table(name = "V_AGPM_BAILLEUR", schema = "EMAP")
public class VAgpmBailleur implements java.io.Serializable {

	private VAgpmBailleurId id;

	public VAgpmBailleur() {
	}

	public VAgpmBailleur(VAgpmBailleurId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "agpId", column = @Column(name = "AGP_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "proId", column = @Column(name = "PRO_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "proTitre", column = @Column(name = "PRO_TITRE", nullable = false, length = 500)),
			@AttributeOverride(name = "baiCode", column = @Column(name = "BAI_CODE", nullable = false, length = 5)),
			@AttributeOverride(name = "baiLibelle", column = @Column(name = "BAI_LIBELLE", nullable = false, length = 1000)),
			@AttributeOverride(name = "baiAdresse", column = @Column(name = "BAI_ADRESSE", length = 500)),
			@AttributeOverride(name = "baiTelephone", column = @Column(name = "BAI_TELEPHONE", length = 500)) })
	public VAgpmBailleurId getId() {
		return this.id;
	}

	public void setId(VAgpmBailleurId id) {
		this.id = id;
	}

}
