package com.sndi.models;
// Generated 18 juin 2020 16:45:49 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VDetailOffres generated by hbm2java
 */
@Entity
@Table(name = "V_DETAIL_OFFRES", schema = "EMAP")
public class VDetailOffres implements java.io.Serializable {

	private VDetailOffresId id;

	public VDetailOffres() {
	}

	public VDetailOffres(VDetailOffresId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "dofNum", column = @Column(name = "DOF_NUM", nullable = false, precision = 22, scale = 0)),
			@AttributeOverride(name = "laaNum", column = @Column(name = "LAA_NUM", precision = 22, scale = 0)),
			@AttributeOverride(name = "laaObjet", column = @Column(name = "LAA_OBJET", length = 1000)),
			@AttributeOverride(name = "dofLaaId", column = @Column(name = "DOF_LAA_ID", nullable = false, precision = 22, scale = 0)),
			@AttributeOverride(name = "aaoCode", column = @Column(name = "AAO_CODE", nullable = false, length = 20)),
			@AttributeOverride(name = "offSouSigleSte", column = @Column(name = "OFF_SOU_SIGLE_STE", length = 500)),
			@AttributeOverride(name = "dofMtOfr", column = @Column(name = "DOF_MT_OFR", precision = 20, scale = 0)),
			@AttributeOverride(name = "dofTyp", column = @Column(name = "DOF_TYP", length = 1)),
			@AttributeOverride(name = "dofStatut", column = @Column(name = "DOF_STATUT", length = 1)) })
	public VDetailOffresId getId() {
		return this.id;
	}

	public void setId(VDetailOffresId id) {
		this.id = id;
	}

}
