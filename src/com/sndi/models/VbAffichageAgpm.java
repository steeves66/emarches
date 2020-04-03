package com.sndi.models;
// Generated 3 avr. 2020 00:55:57 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbAffichageAgpm generated by hbm2java
 */
@Entity
@Table(name = "VB_AFFICHAGE_AGPM", schema = "EMAP")
public class VbAffichageAgpm implements java.io.Serializable {

	private VbAffichageAgpmId id;

	public VbAffichageAgpm() {
	}

	public VbAffichageAgpm(VbAffichageAgpmId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "affId", column = @Column(name = "AFF_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "affProId", column = @Column(name = "AFF_PRO_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "affFinId", column = @Column(name = "AFF_FIN_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "affGesCode", column = @Column(name = "AFF_GES_CODE", nullable = false, precision = 4, scale = 0)),
			@AttributeOverride(name = "affDecId", column = @Column(name = "AFF_DEC_ID", precision = 10, scale = 0)),
			@AttributeOverride(name = "affAgpStaCode", column = @Column(name = "AFF_AGP_STA_CODE", nullable = false, length = 3)),
			@AttributeOverride(name = "affAgpId", column = @Column(name = "AFF_AGP_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "affBaiCode", column = @Column(name = "AFF_BAI_CODE", length = 5)),
			@AttributeOverride(name = "affSouCode", column = @Column(name = "AFF_SOU_CODE", nullable = false, length = 5)),
			@AttributeOverride(name = "affDevCode", column = @Column(name = "AFF_DEV_CODE", nullable = false, length = 8)),
			@AttributeOverride(name = "affStrCode", column = @Column(name = "AFF_STR_CODE", nullable = false, length = 3)),
			@AttributeOverride(name = "affFonCod", column = @Column(name = "AFF_FON_COD", nullable = false, length = 12)),
			@AttributeOverride(name = "affAgpActeurSaisie", column = @Column(name = "AFF_AGP_ACTEUR_SAISIE", length = 12)),
			@AttributeOverride(name = "affAgpStatutRetour", column = @Column(name = "AFF_AGP_STATUT_RETOUR", length = 2)),
			@AttributeOverride(name = "affAgpActif", column = @Column(name = "AFF_AGP_ACTIF", length = 1)),
			@AttributeOverride(name = "affAgpTypeDao", column = @Column(name = "AFF_AGP_TYPE_DAO", length = 1000)),
			@AttributeOverride(name = "affAgpCommentaire", column = @Column(name = "AFF_AGP_COMMENTAIRE", length = 1000)) })
	public VbAffichageAgpmId getId() {
		return this.id;
	}

	public void setId(VbAffichageAgpmId id) {
		this.id = id;
	}

}
