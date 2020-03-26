package com.sndi.models;
// Generated 26 mars 2020 03:50:59 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbAgpm generated by hbm2java
 */
@Entity
@Table(name = "VB_AGPM", schema = "EMAP")
public class VbAgpm implements java.io.Serializable {

	private VbAgpmId id;

	public VbAgpm() {
	}

	public VbAgpm(VbAgpmId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "agpId", column = @Column(name = "AGP_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "agpStrCode", column = @Column(name = "AGP_STR_CODE", nullable = false, length = 3)),
			@AttributeOverride(name = "agpFonCod", column = @Column(name = "AGP_FON_COD", nullable = false, length = 12)),
			@AttributeOverride(name = "agpGesCode", column = @Column(name = "AGP_GES_CODE", nullable = false, precision = 4, scale = 0)),
			@AttributeOverride(name = "agpStaCode", column = @Column(name = "AGP_STA_CODE", nullable = false, length = 3)),
			@AttributeOverride(name = "agpProId", column = @Column(name = "AGP_PRO_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "agpDecId", column = @Column(name = "AGP_DEC_ID", precision = 10, scale = 0)),
			@AttributeOverride(name = "agpCommentaire", column = @Column(name = "AGP_COMMENTAIRE", length = 1000)),
			@AttributeOverride(name = "agpTypeDao", column = @Column(name = "AGP_TYPE_DAO", length = 1000)),
			@AttributeOverride(name = "agpModePassation", column = @Column(name = "AGP_MODE_PASSATION", length = 1000)),
			@AttributeOverride(name = "agpActif", column = @Column(name = "AGP_ACTIF", length = 1)),
			@AttributeOverride(name = "agpStatutRetour", column = @Column(name = "AGP_STATUT_RETOUR", length = 2)),
			@AttributeOverride(name = "agpActeurSaisie", column = @Column(name = "AGP_ACTEUR_SAISIE", length = 12)) })
	public VbAgpmId getId() {
		return this.id;
	}

	public void setId(VbAgpmId id) {
		this.id = id;
	}

}
