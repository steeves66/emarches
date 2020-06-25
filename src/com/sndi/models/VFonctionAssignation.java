package com.sndi.models;
// Generated 25 juin 2020 13:53:46 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VFonctionAssignation generated by hbm2java
 */
@Entity
@Table(name = "V_FONCTION_ASSIGNATION", schema = "EMAP")
public class VFonctionAssignation implements java.io.Serializable {

	private VFonctionAssignationId id;

	public VFonctionAssignation() {
	}

	public VFonctionAssignation(VFonctionAssignationId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "fonCod", column = @Column(name = "FON_COD", nullable = false, length = 20)),
			@AttributeOverride(name = "fonTyfCod", column = @Column(name = "FON_TYF_COD", length = 3)),
			@AttributeOverride(name = "fonStrCode", column = @Column(name = "FON_STR_CODE", length = 20)),
			@AttributeOverride(name = "fonDatDeb", column = @Column(name = "FON_DAT_DEB", length = 7)),
			@AttributeOverride(name = "fonDatFin", column = @Column(name = "FON_DAT_FIN", length = 7)),
			@AttributeOverride(name = "fonLibelle", column = @Column(name = "FON_LIBELLE", length = 500)),
			@AttributeOverride(name = "fonOpeMatricule", column = @Column(name = "FON_OPE_MATRICULE", length = 25)) })
	public VFonctionAssignationId getId() {
		return this.id;
	}

	public void setId(VFonctionAssignationId id) {
		this.id = id;
	}

}
