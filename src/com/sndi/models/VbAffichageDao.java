package com.sndi.models;
// Generated 23 mars 2020 10:48:44 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbAffichageDao generated by hbm2java
 */
@Entity
@Table(name = "VB_AFFICHAGE_DAO", schema = "EMAP")
public class VbAffichageDao implements java.io.Serializable {

	private VbAffichageDaoId id;

	public VbAffichageDao() {
	}

	public VbAffichageDao(VbAffichageDaoId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "affDaoId", column = @Column(name = "AFF_DAO_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "affDcsNum", column = @Column(name = "AFF_DCS_NUM", precision = 22, scale = 0)),
			@AttributeOverride(name = "affDacCode", column = @Column(name = "AFF_DAC_CODE", nullable = false, length = 20)),
			@AttributeOverride(name = "affOpeMatricule", column = @Column(name = "AFF_OPE_MATRICULE", length = 25)),
			@AttributeOverride(name = "affStaCode", column = @Column(name = "AFF_STA_CODE", length = 3)),
			@AttributeOverride(name = "affStatutRetour", column = @Column(name = "AFF_STATUT_RETOUR", length = 4)) })
	public VbAffichageDaoId getId() {
		return this.id;
	}

	public void setId(VbAffichageDaoId id) {
		this.id = id;
	}

}
