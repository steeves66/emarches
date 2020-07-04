package com.sndi.models;
// Generated 4 juil. 2020 18:05:44 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbAffichagePgpm generated by hbm2java
 */
@Entity
@Table(name = "VB_AFFICHAGE_PGPM", schema = "EMAP")
public class VbAffichagePgpm implements java.io.Serializable {

	private VbAffichagePgpmId id;

	public VbAffichagePgpm() {
	}

	public VbAffichagePgpm(VbAffichagePgpmId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "affGpgId", column = @Column(name = "AFF_GPG_ID", precision = 10, scale = 0)),
			@AttributeOverride(name = "affGpgPlgId", column = @Column(name = "AFF_GPG_PLG_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "affGpgAgpId", column = @Column(name = "AFF_GPG_AGP_ID", precision = 10, scale = 0)),
			@AttributeOverride(name = "affGpgTypePlan", column = @Column(name = "AFF_GPG_TYPE_PLAN", nullable = false, length = 3)),
			@AttributeOverride(name = "affGpgStaCode", column = @Column(name = "AFF_GPG_STA_CODE", nullable = false, length = 3)),
			@AttributeOverride(name = "affGpgTymCode", column = @Column(name = "AFF_GPG_TYM_CODE", nullable = false, length = 3)),
			@AttributeOverride(name = "affGpgMopCode", column = @Column(name = "AFF_GPG_MOP_CODE", nullable = false, length = 3)),
			@AttributeOverride(name = "affGpgCode", column = @Column(name = "AFF_GPG_CODE", length = 50)),
			@AttributeOverride(name = "affGpgObjet", column = @Column(name = "AFF_GPG_OBJET", length = 1000)),
			@AttributeOverride(name = "affGpgNumeroOrdre", column = @Column(name = "AFF_GPG_NUMERO_ORDRE", precision = 8, scale = 0)),
			@AttributeOverride(name = "affGpgPartiePmePmi", column = @Column(name = "AFF_GPG_PARTIE_PME_PMI", length = 1)),
			@AttributeOverride(name = "affGpgCommentaire", column = @Column(name = "AFF_GPG_COMMENTAIRE", length = 1000)),
			@AttributeOverride(name = "affGpgSourceFin", column = @Column(name = "AFF_GPG_SOURCE_FIN", length = 5)),
			@AttributeOverride(name = "affGpgDateDao", column = @Column(name = "AFF_GPG_DATE_DAO", length = 7)),
			@AttributeOverride(name = "affGpgActeurSaisie", column = @Column(name = "AFF_GPG_ACTEUR_SAISIE", length = 12)),
			@AttributeOverride(name = "affGpgStatutRetour", column = @Column(name = "AFF_GPG_STATUT_RETOUR", length = 4)),
			@AttributeOverride(name = "affGpgDateSaisie", column = @Column(name = "AFF_GPG_DATE_SAISIE", length = 7)),
			@AttributeOverride(name = "affGpgFonCod", column = @Column(name = "AFF_GPG_FON_COD", length = 12)),
			@AttributeOverride(name = "affId", column = @Column(name = "AFF_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "affGpgStrCode", column = @Column(name = "AFF_GPG_STR_CODE", length = 20)),
			@AttributeOverride(name = "affGpgGesCode", column = @Column(name = "AFF_GPG_GES_CODE", precision = 4, scale = 0)) })
	public VbAffichagePgpmId getId() {
		return this.id;
	}

	public void setId(VbAffichagePgpmId id) {
		this.id = id;
	}

}
