package com.sndi.models;
// Generated 28 mars 2020 03:24:07 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbTiers generated by hbm2java
 */
@Entity
@Table(name = "VB_TIERS", schema = "EMAP")
public class VbTiers implements java.io.Serializable {

	private VbTiersId id;

	public VbTiers() {
	}

	public VbTiers(VbTiersId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "tieNum", column = @Column(name = "TIE_NUM", nullable = false, length = 20)),
			@AttributeOverride(name = "tieInter", column = @Column(name = "TIE_INTER", length = 1)),
			@AttributeOverride(name = "tieSigleSte", column = @Column(name = "TIE_SIGLE_STE", length = 500)),
			@AttributeOverride(name = "tieNomCom", column = @Column(name = "TIE_NOM_COM", length = 500)),
			@AttributeOverride(name = "tieStaCode", column = @Column(name = "TIE_STA_CODE", length = 3)),
			@AttributeOverride(name = "tieTel", column = @Column(name = "TIE_TEL", length = 30)),
			@AttributeOverride(name = "tieAdresse", column = @Column(name = "TIE_ADRESSE", length = 200)),
			@AttributeOverride(name = "tieDteSaisi", column = @Column(name = "TIE_DTE_SAISI", length = 7)),
			@AttributeOverride(name = "tieOpeMatricule", column = @Column(name = "TIE_OPE_MATRICULE", length = 25)) })
	public VbTiersId getId() {
		return this.id;
	}

	public void setId(VbTiersId id) {
		this.id = id;
	}

}
