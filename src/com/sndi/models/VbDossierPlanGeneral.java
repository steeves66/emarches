package com.sndi.models;
// Generated 25 juin 2020 13:53:46 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbDossierPlanGeneral generated by hbm2java
 */
@Entity
@Table(name = "VB_DOSSIER_PLAN_GENERAL", schema = "EMAP")
public class VbDossierPlanGeneral implements java.io.Serializable {

	private VbDossierPlanGeneralId id;

	public VbDossierPlanGeneral() {
	}

	public VbDossierPlanGeneral(VbDossierPlanGeneralId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "dpgId", column = @Column(name = "DPG_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "dpgNapCode", column = @Column(name = "DPG_NAP_CODE", nullable = false, length = 5)),
			@AttributeOverride(name = "dpgGpgId", column = @Column(name = "DPG_GPG_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "dpgCode", column = @Column(name = "DPG_CODE", length = 500)),
			@AttributeOverride(name = "dpgLibelle", column = @Column(name = "DPG_LIBELLE", length = 500)),
			@AttributeOverride(name = "dpgCommentaire", column = @Column(name = "DPG_COMMENTAIRE", length = 500)),
			@AttributeOverride(name = "dpgReference", column = @Column(name = "DPG_REFERENCE", length = 500)) })
	public VbDossierPlanGeneralId getId() {
		return this.id;
	}

	public void setId(VbDossierPlanGeneralId id) {
		this.id = id;
	}

}