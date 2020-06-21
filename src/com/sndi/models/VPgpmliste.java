package com.sndi.models;
// Generated 20 juin 2020 17:16:02 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VPgpmliste generated by hbm2java
 */
@Entity
@Table(name = "V_PGPMLISTE", schema = "EMAP")
public class VPgpmliste implements java.io.Serializable {

	private VPgpmlisteId id;

	public VPgpmliste() {
	}

	public VPgpmliste(VPgpmlisteId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "fipTypeFinance", column = @Column(name = "FIP_TYPE_FINANCE", length = 20)),
			@AttributeOverride(name = "gpgLibFin", column = @Column(name = "GPG_LIB_FIN", length = 200)),
			@AttributeOverride(name = "gpgId", column = @Column(name = "GPG_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "gpgDteModif", column = @Column(name = "GPG_DTE_MODIF", length = 7)),
			@AttributeOverride(name = "gpgObjet", column = @Column(name = "GPG_OBJET", length = 1000)),
			@AttributeOverride(name = "gpgStaCode", column = @Column(name = "GPG_STA_CODE", nullable = false, length = 3)),
			@AttributeOverride(name = "gpgTypePlan", column = @Column(name = "GPG_TYPE_PLAN", nullable = false, length = 3)),
			@AttributeOverride(name = "gpgActeurSaisie", column = @Column(name = "GPG_ACTEUR_SAISIE", length = 12)),
			@AttributeOverride(name = "gpgDateDao", column = @Column(name = "GPG_DATE_DAO", length = 7)),
			@AttributeOverride(name = "gpgFonCodPf", column = @Column(name = "GPG_FON_COD_PF", length = 20)),
			@AttributeOverride(name = "gpgFonCodDmp", column = @Column(name = "GPG_FON_COD_DMP", length = 20)),
			@AttributeOverride(name = "gpgStatutRetour", column = @Column(name = "GPG_STATUT_RETOUR", length = 4)),
			@AttributeOverride(name = "tymCode", column = @Column(name = "TYM_CODE", nullable = false, length = 3)),
			@AttributeOverride(name = "tymLibelleCourt", column = @Column(name = "TYM_LIBELLE_COURT", nullable = false, length = 500)),
			@AttributeOverride(name = "mopCode", column = @Column(name = "MOP_CODE", nullable = false, length = 3)),
			@AttributeOverride(name = "mopLibelleCourt", column = @Column(name = "MOP_LIBELLE_COURT", nullable = false, length = 500)),
			@AttributeOverride(name = "mopLibelleLong", column = @Column(name = "MOP_LIBELLE_LONG", length = 1000)),
			@AttributeOverride(name = "gpgRecherche", column = @Column(name = "GPG_RECHERCHE", length = 4000)),
			@AttributeOverride(name = "gpgDateValAc", column = @Column(name = "GPG_DATE_VAL_AC", length = 7)),
			@AttributeOverride(name = "gpgDateValCpmp", column = @Column(name = "GPG_DATE_VAL_CPMP", length = 7)),
			@AttributeOverride(name = "gpgDateValDmp", column = @Column(name = "GPG_DATE_VAL_DMP", length = 7)),
			@AttributeOverride(name = "ac", column = @Column(name = "AC", length = 515)),
			@AttributeOverride(name = "gpgAgpId", column = @Column(name = "GPG_AGP_ID", precision = 10, scale = 0)),
			@AttributeOverride(name = "gpgCommentaire", column = @Column(name = "GPG_COMMENTAIRE", length = 1000)),
			@AttributeOverride(name = "gpgPartiePmePmi", column = @Column(name = "GPG_PARTIE_PME_PMI", length = 1)),
			@AttributeOverride(name = "gpgStrCode", column = @Column(name = "GPG_STR_CODE", length = 20)),
			@AttributeOverride(name = "tstCode", column = @Column(name = "TST_CODE", length = 3)),
			@AttributeOverride(name = "plgId", column = @Column(name = "PLG_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "plgGesCode", column = @Column(name = "PLG_GES_CODE", nullable = false, precision = 4, scale = 0)) })
	public VPgpmlisteId getId() {
		return this.id;
	}

	public void setId(VPgpmlisteId id) {
		this.id = id;
	}

}
