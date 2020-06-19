package com.sndi.models;
// Generated 18 juin 2020 16:45:49 by Hibernate Tools 4.3.5.Final

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

	@AttributeOverrides({ @AttributeOverride(name = "VId", column = @Column(name = "V_ID", precision = 22, scale = 0)),
			@AttributeOverride(name = "affStatut", column = @Column(name = "AFF_STATUT", length = 19)),
			@AttributeOverride(name = "gpgId", column = @Column(name = "GPG_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "souLibelle", column = @Column(name = "SOU_LIBELLE", length = 500)),
			@AttributeOverride(name = "gpgObjet", column = @Column(name = "GPG_OBJET", length = 1000)),
			@AttributeOverride(name = "gpgStaCode", column = @Column(name = "GPG_STA_CODE", nullable = false, length = 3)),
			@AttributeOverride(name = "gpgTypePlan", column = @Column(name = "GPG_TYPE_PLAN", nullable = false, length = 3)),
			@AttributeOverride(name = "gpgActeurSaisie", column = @Column(name = "GPG_ACTEUR_SAISIE", length = 12)),
			@AttributeOverride(name = "gpgLibFin", column = @Column(name = "GPG_LIB_FIN", length = 200)),
			@AttributeOverride(name = "fonLibelle", column = @Column(name = "FON_LIBELLE", length = 500)),
			@AttributeOverride(name = "tymCode", column = @Column(name = "TYM_CODE", nullable = false, length = 3)),
			@AttributeOverride(name = "tymLibelleCourt", column = @Column(name = "TYM_LIBELLE_COURT", nullable = false, length = 500)),
			@AttributeOverride(name = "mopCode", column = @Column(name = "MOP_CODE", nullable = false, length = 3)),
			@AttributeOverride(name = "mopLibelleCourt", column = @Column(name = "MOP_LIBELLE_COURT", nullable = false, length = 500)),
			@AttributeOverride(name = "mopLibelleLong", column = @Column(name = "MOP_LIBELLE_LONG", length = 1000)),
			@AttributeOverride(name = "gpgPartiePmePmi", column = @Column(name = "GPG_PARTIE_PME_PMI", length = 1)),
			@AttributeOverride(name = "gpgDateDao", column = @Column(name = "GPG_DATE_DAO", length = 7)),
			@AttributeOverride(name = "gpgCommentaire", column = @Column(name = "GPG_COMMENTAIRE", length = 1000)),
			@AttributeOverride(name = "gpgNumeroOrdre", column = @Column(name = "GPG_NUMERO_ORDRE", precision = 8, scale = 0)),
			@AttributeOverride(name = "gpgDateSaisie", column = @Column(name = "GPG_DATE_SAISIE", length = 7)),
			@AttributeOverride(name = "plgId", column = @Column(name = "PLG_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "plgGesCode", column = @Column(name = "PLG_GES_CODE", nullable = false, precision = 4, scale = 0)),
			@AttributeOverride(name = "minLibelle", column = @Column(name = "MIN_LIBELLE", length = 1000)),
			@AttributeOverride(name = "minLibelleCourt", column = @Column(name = "MIN_LIBELLE_COURT", length = 500)),
			@AttributeOverride(name = "strCode", column = @Column(name = "STR_CODE", length = 20)),
			@AttributeOverride(name = "strLibelleCourt", column = @Column(name = "STR_LIBELLE_COURT", length = 500)),
			@AttributeOverride(name = "strLibelleLong", column = @Column(name = "STR_LIBELLE_LONG", length = 1000)) })
	public VPgpmDetailsId getId() {
		return this.id;
	}

	public void setId(VPgpmDetailsId id) {
		this.id = id;
	}

}
