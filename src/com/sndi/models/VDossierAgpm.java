package com.sndi.models;
// Generated 27 mars 2020 12:01:30 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VDossierAgpm generated by hbm2java
 */
@Entity
@Table(name = "V_DOSSIER_AGPM", schema = "EMAP")
public class VDossierAgpm implements java.io.Serializable {

	private VDossierAgpmId id;

	public VDossierAgpm() {
	}

	public VDossierAgpm(VDossierAgpmId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "dagId", column = @Column(name = "DAG_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "dagNapCode", column = @Column(name = "DAG_NAP_CODE", nullable = false, length = 5)),
			@AttributeOverride(name = "dagAgpId", column = @Column(name = "DAG_AGP_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "dagCode", column = @Column(name = "DAG_CODE", length = 500)),
			@AttributeOverride(name = "dagLibelle", column = @Column(name = "DAG_LIBELLE", length = 500)),
			@AttributeOverride(name = "dagCommentaire", column = @Column(name = "DAG_COMMENTAIRE", length = 500)),
			@AttributeOverride(name = "dagReference", column = @Column(name = "DAG_REFERENCE", length = 500)) })
	public VDossierAgpmId getId() {
		return this.id;
	}

	public void setId(VDossierAgpmId id) {
		this.id = id;
	}

}
