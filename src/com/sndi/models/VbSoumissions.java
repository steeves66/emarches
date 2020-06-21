package com.sndi.models;
// Generated 20 juin 2020 17:16:02 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbSoumissions generated by hbm2java
 */
@Entity
@Table(name = "VB_SOUMISSIONS", schema = "EMAP")
public class VbSoumissions implements java.io.Serializable {

	private VbSoumissionsId id;

	public VbSoumissions() {
	}

	public VbSoumissions(VbSoumissionsId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "souNcc", column = @Column(name = "SOU_NCC", nullable = false, length = 20)),
			@AttributeOverride(name = "souInter", column = @Column(name = "SOU_INTER", length = 1)),
			@AttributeOverride(name = "souSigleSte", column = @Column(name = "SOU_SIGLE_STE", length = 500)),
			@AttributeOverride(name = "souNomCom", column = @Column(name = "SOU_NOM_COM", length = 500)),
			@AttributeOverride(name = "souStaCode", column = @Column(name = "SOU_STA_CODE", length = 3)),
			@AttributeOverride(name = "souTel", column = @Column(name = "SOU_TEL", length = 200)),
			@AttributeOverride(name = "souAdresse", column = @Column(name = "SOU_ADRESSE", length = 200)),
			@AttributeOverride(name = "souDteSaisi", column = @Column(name = "SOU_DTE_SAISI", length = 7)),
			@AttributeOverride(name = "souOpeMatricule", column = @Column(name = "SOU_OPE_MATRICULE", length = 25)) })
	public VbSoumissionsId getId() {
		return this.id;
	}

	public void setId(VbSoumissionsId id) {
		this.id = id;
	}

}
