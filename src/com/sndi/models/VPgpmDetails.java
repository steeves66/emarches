package com.sndi.models;
// Generated 22 mars 2020 01:52:15 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VPgpmDetails generated by hbm2java
 */
@Entity
@Table(name = "V_PGPM_DETAILS", schema = "EMAP")
public class VPgpmDetails implements java.io.Serializable {

	private VPgpmDetailsId id;

	public VPgpmDetails() {
	}

	public VPgpmDetails(VPgpmDetailsId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "affGpgId", column = @Column(name = "AFF_GPG_ID", precision = 10, scale = 0)),
			@AttributeOverride(name = "souLibelle", column = @Column(name = "SOU_LIBELLE", length = 500)),
			@AttributeOverride(name = "affGpgObjet", column = @Column(name = "AFF_GPG_OBJET", length = 1000)),
			@AttributeOverride(name = "affGpgStaCode", column = @Column(name = "AFF_GPG_STA_CODE", nullable = false, length = 3)),
			@AttributeOverride(name = "affGpgTypePlan", column = @Column(name = "AFF_GPG_TYPE_PLAN", nullable = false, length = 3)),
			@AttributeOverride(name = "affGpgActeurSaisie", column = @Column(name = "AFF_GPG_ACTEUR_SAISIE", length = 12)),
			@AttributeOverride(name = "fonLibelle", column = @Column(name = "FON_LIBELLE", length = 500)),
			@AttributeOverride(name = "tymCode", column = @Column(name = "TYM_CODE", nullable = false, length = 3)),
			@AttributeOverride(name = "tymLibelleCourt", column = @Column(name = "TYM_LIBELLE_COURT", nullable = false, length = 500)),
			@AttributeOverride(name = "mopCode", column = @Column(name = "MOP_CODE", nullable = false, length = 3)),
			@AttributeOverride(name = "mopLibelleCourt", column = @Column(name = "MOP_LIBELLE_COURT", nullable = false, length = 500)),
			@AttributeOverride(name = "mopLibelleLong", column = @Column(name = "MOP_LIBELLE_LONG", length = 1000)),
			@AttributeOverride(name = "affGpgPartiePmePmi", column = @Column(name = "AFF_GPG_PARTIE_PME_PMI", length = 1)),
			@AttributeOverride(name = "affGpgDateDao", column = @Column(name = "AFF_GPG_DATE_DAO", length = 7)),
			@AttributeOverride(name = "affGpgCommentaire", column = @Column(name = "AFF_GPG_COMMENTAIRE", length = 1000)),
			@AttributeOverride(name = "affGpgNumeroOrdre", column = @Column(name = "AFF_GPG_NUMERO_ORDRE", precision = 8, scale = 0)),
			@AttributeOverride(name = "affGpgDateSaisie", column = @Column(name = "AFF_GPG_DATE_SAISIE", length = 7)),
			@AttributeOverride(name = "plgId", column = @Column(name = "PLG_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "plgGesCode", column = @Column(name = "PLG_GES_CODE", nullable = false, precision = 4, scale = 0)),
			@AttributeOverride(name = "minLibelle", column = @Column(name = "MIN_LIBELLE", length = 1000)),
			@AttributeOverride(name = "minLibelleCourt", column = @Column(name = "MIN_LIBELLE_COURT", length = 500)),
			@AttributeOverride(name = "strCode", column = @Column(name = "STR_CODE", nullable = false, length = 20)),
			@AttributeOverride(name = "strLibelleCourt", column = @Column(name = "STR_LIBELLE_COURT", nullable = false, length = 500)),
			@AttributeOverride(name = "strLibelleLong", column = @Column(name = "STR_LIBELLE_LONG", length = 1000)) })
	public VPgpmDetailsId getId() {
		return this.id;
	}

	public void setId(VPgpmDetailsId id) {
		this.id = id;
	}

}
