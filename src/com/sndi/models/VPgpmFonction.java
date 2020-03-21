package com.sndi.models;
// Generated 21 mars 2020 13:48:08 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VPgpmFonction generated by hbm2java
 */
@Entity
@Table(name = "V_PGPM_FONCTION", schema = "EMAP")
public class VPgpmFonction implements java.io.Serializable {

	private VPgpmFonctionId id;

	public VPgpmFonction() {
	}

	public VPgpmFonction(VPgpmFonctionId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "gpgId", column = @Column(name = "GPG_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "gpgPlgId", column = @Column(name = "GPG_PLG_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "gpgAgpId", column = @Column(name = "GPG_AGP_ID", precision = 10, scale = 0)),
			@AttributeOverride(name = "gpgTypePlan", column = @Column(name = "GPG_TYPE_PLAN", nullable = false, length = 3)),
			@AttributeOverride(name = "gpgStaCode", column = @Column(name = "GPG_STA_CODE", nullable = false, length = 3)),
			@AttributeOverride(name = "gpgTymCode", column = @Column(name = "GPG_TYM_CODE", nullable = false, length = 3)),
			@AttributeOverride(name = "gpgMopCode", column = @Column(name = "GPG_MOP_CODE", nullable = false, length = 3)),
			@AttributeOverride(name = "gpgCode", column = @Column(name = "GPG_CODE", length = 50)),
			@AttributeOverride(name = "gpgObjet", column = @Column(name = "GPG_OBJET", length = 1000)),
			@AttributeOverride(name = "gpgNumeroOrdre", column = @Column(name = "GPG_NUMERO_ORDRE", precision = 8, scale = 0)),
			@AttributeOverride(name = "gpgPartiePmePmi", column = @Column(name = "GPG_PARTIE_PME_PMI", length = 1)),
			@AttributeOverride(name = "gpgCommentaire", column = @Column(name = "GPG_COMMENTAIRE", length = 1000)),
			@AttributeOverride(name = "gpgSourceFin", column = @Column(name = "GPG_SOURCE_FIN", length = 1000)),
			@AttributeOverride(name = "gpgDateDao", column = @Column(name = "GPG_DATE_DAO", length = 7)),
			@AttributeOverride(name = "gpgActeurSaisie", column = @Column(name = "GPG_ACTEUR_SAISIE", length = 12)),
			@AttributeOverride(name = "gpgStatutRetour", column = @Column(name = "GPG_STATUT_RETOUR", length = 4)),
			@AttributeOverride(name = "gpgDateSaisie", column = @Column(name = "GPG_DATE_SAISIE", length = 7)),
			@AttributeOverride(name = "gpgStrCode", column = @Column(name = "GPG_STR_CODE", length = 3)),
			@AttributeOverride(name = "tymLibelleCourt", column = @Column(name = "TYM_LIBELLE_COURT", nullable = false, length = 500)),
			@AttributeOverride(name = "tymTymCode", column = @Column(name = "TYM_TYM_CODE", length = 3)),
			@AttributeOverride(name = "mopLibelleLong", column = @Column(name = "MOP_LIBELLE_LONG", length = 1000)),
			@AttributeOverride(name = "plgFonCod", column = @Column(name = "PLG_FON_COD", nullable = false, length = 12)),
			@AttributeOverride(name = "fonLibelle", column = @Column(name = "FON_LIBELLE", length = 500)) })
	public VPgpmFonctionId getId() {
		return this.id;
	}

	public void setId(VPgpmFonctionId id) {
		this.id = id;
	}

}
