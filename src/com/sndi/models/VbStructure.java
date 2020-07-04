package com.sndi.models;
// Generated 4 juil. 2020 18:05:44 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbStructure generated by hbm2java
 */
@Entity
@Table(name = "VB_STRUCTURE", schema = "EMAP")
public class VbStructure implements java.io.Serializable {

	private VbStructureId id;

	public VbStructure() {
	}

	public VbStructure(VbStructureId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "strCode", column = @Column(name = "STR_CODE", nullable = false, length = 20)),
			@AttributeOverride(name = "strLibelleCourt", column = @Column(name = "STR_LIBELLE_COURT", nullable = false, length = 500)),
			@AttributeOverride(name = "strLibelleLong", column = @Column(name = "STR_LIBELLE_LONG", length = 1000)),
			@AttributeOverride(name = "strAdresse", column = @Column(name = "STR_ADRESSE", length = 500)),
			@AttributeOverride(name = "strEmail", column = @Column(name = "STR_EMAIL", length = 500)),
			@AttributeOverride(name = "strMinCode", column = @Column(name = "STR_MIN_CODE", nullable = false, length = 20)),
			@AttributeOverride(name = "strTstCode", column = @Column(name = "STR_TST_CODE", length = 3)),
			@AttributeOverride(name = "strRegCode", column = @Column(name = "STR_REG_CODE", length = 10)),
			@AttributeOverride(name = "strAdrPost", column = @Column(name = "STR_ADR_POST", length = 200)),
			@AttributeOverride(name = "strAdrGeo", column = @Column(name = "STR_ADR_GEO", length = 200)),
			@AttributeOverride(name = "strTel", column = @Column(name = "STR_TEL", length = 100)),
			@AttributeOverride(name = "strFax", column = @Column(name = "STR_FAX", length = 50)),
			@AttributeOverride(name = "strOpeMatricule", column = @Column(name = "STR_OPE_MATRICULE", length = 25)),
			@AttributeOverride(name = "strDteSaisi", column = @Column(name = "STR_DTE_SAISI", length = 7)),
			@AttributeOverride(name = "strOpeRespo", column = @Column(name = "STR_OPE_RESPO", length = 1)) })
	public VbStructureId getId() {
		return this.id;
	}

	public void setId(VbStructureId id) {
		this.id = id;
	}

}
