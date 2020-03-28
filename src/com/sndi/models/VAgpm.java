package com.sndi.models;
// Generated 28 mars 2020 03:24:07 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VAgpm generated by hbm2java
 */
@Entity
@Table(name = "V_AGPM", schema = "EMAP")
public class VAgpm implements java.io.Serializable {

	private VAgpmId id;

	public VAgpm() {
	}

	public VAgpm(VAgpmId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "agpId", column = @Column(name = "AGP_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "agpGesCode", column = @Column(name = "AGP_GES_CODE", nullable = false, precision = 4, scale = 0)),
			@AttributeOverride(name = "minLibelleCourt", column = @Column(name = "MIN_LIBELLE_COURT", length = 500)),
			@AttributeOverride(name = "minLibelle", column = @Column(name = "MIN_LIBELLE", length = 1000)),
			@AttributeOverride(name = "fonCod", column = @Column(name = "FON_COD", nullable = false, length = 20)),
			@AttributeOverride(name = "ac", column = @Column(name = "AC", length = 523)),
			@AttributeOverride(name = "proLibelle", column = @Column(name = "PRO_LIBELLE", length = 500)),
			@AttributeOverride(name = "agpTypeDao", column = @Column(name = "AGP_TYPE_DAO", length = 1000)),
			@AttributeOverride(name = "agpModePassation", column = @Column(name = "AGP_MODE_PASSATION", length = 1000)),
			@AttributeOverride(name = "proMontantTotCfa", column = @Column(name = "PRO_MONTANT_TOT_CFA", precision = 15)),
			@AttributeOverride(name = "agpStaCode", column = @Column(name = "AGP_STA_CODE", nullable = false, length = 3)),
			@AttributeOverride(name = "agpStrCode", column = @Column(name = "AGP_STR_CODE", nullable = false, length = 3)),
			@AttributeOverride(name = "agpActif", column = @Column(name = "AGP_ACTIF", length = 1)),
			@AttributeOverride(name = "agpStatutRetour", column = @Column(name = "AGP_STATUT_RETOUR", length = 2)),
			@AttributeOverride(name = "decOrganExecLibelle", column = @Column(name = "DEC_ORGAN_EXEC_LIBELLE", nullable = false, length = 500)) })
	public VAgpmId getId() {
		return this.id;
	}

	public void setId(VAgpmId id) {
		this.id = id;
	}

}
