package com.sndi.models;
// Generated 23 mars 2020 10:48:44 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbAssignation generated by hbm2java
 */
@Entity
@Table(name = "VB_ASSIGNATION", schema = "EMAP")
public class VbAssignation implements java.io.Serializable {

	private VbAssignationId id;

	public VbAssignation() {
	}

	public VbAssignation(VbAssignationId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "assNum", column = @Column(name = "ASS_NUM", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "assFonCod", column = @Column(name = "ASS_FON_COD", length = 12)),
			@AttributeOverride(name = "assOpeMatricule", column = @Column(name = "ASS_OPE_MATRICULE", length = 25)),
			@AttributeOverride(name = "assDatDeb", column = @Column(name = "ASS_DAT_DEB", length = 7)),
			@AttributeOverride(name = "assDatFin", column = @Column(name = "ASS_DAT_FIN", length = 7)),
			@AttributeOverride(name = "assCourant", column = @Column(name = "ASS_COURANT", length = 10)),
			@AttributeOverride(name = "assStatut", column = @Column(name = "ASS_STATUT", precision = 1, scale = 0)) })
	public VbAssignationId getId() {
		return this.id;
	}

	public void setId(VbAssignationId id) {
		this.id = id;
	}

}
