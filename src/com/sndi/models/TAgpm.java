package com.sndi.models;
// Generated 23 nov. 2020 12:59:43 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * TAgpm generated by hbm2java
 */
@Entity
@Table(name = "T_AGPM", schema = "EMAP")
public class TAgpm implements java.io.Serializable {

	private TAgpmId id;

	public TAgpm() {
	}

	public TAgpm(TAgpmId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "agpId", column = @Column(name = "AGP_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "agpStrCode", column = @Column(name = "AGP_STR_CODE", nullable = false, length = 20)),
			@AttributeOverride(name = "agpFonCod", column = @Column(name = "AGP_FON_COD", nullable = false, length = 20)),
			@AttributeOverride(name = "agpGesCode", column = @Column(name = "AGP_GES_CODE", nullable = false, precision = 4, scale = 0)),
			@AttributeOverride(name = "agpStaCode", column = @Column(name = "AGP_STA_CODE", nullable = false, length = 3)),
			@AttributeOverride(name = "agpProId", column = @Column(name = "AGP_PRO_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "agpDecId", column = @Column(name = "AGP_DEC_ID", precision = 10, scale = 0)),
			@AttributeOverride(name = "agpCommentaire", column = @Column(name = "AGP_COMMENTAIRE", length = 1000)),
			@AttributeOverride(name = "agpTypeDao", column = @Column(name = "AGP_TYPE_DAO", length = 1000)),
			@AttributeOverride(name = "agpModePassation", column = @Column(name = "AGP_MODE_PASSATION", length = 1000)),
			@AttributeOverride(name = "agpActif", column = @Column(name = "AGP_ACTIF", length = 1)),
			@AttributeOverride(name = "agpStatutRetour", column = @Column(name = "AGP_STATUT_RETOUR", length = 2)),
			@AttributeOverride(name = "agpActeurSaisie", column = @Column(name = "AGP_ACTEUR_SAISIE", length = 12)),
			@AttributeOverride(name = "agpDateValAc", column = @Column(name = "AGP_DATE_VAL_AC", length = 7)),
			@AttributeOverride(name = "agpDateValCpmp", column = @Column(name = "AGP_DATE_VAL_CPMP", length = 7)),
			@AttributeOverride(name = "agpDateValDmp", column = @Column(name = "AGP_DATE_VAL_DMP", length = 7)),
			@AttributeOverride(name = "agpCode", column = @Column(name = "AGP_CODE", length = 50)),
			@AttributeOverride(name = "agpDteModif", column = @Column(name = "AGP_DTE_MODIF", length = 7)),
			@AttributeOverride(name = "agpFonCodPf", column = @Column(name = "AGP_FON_COD_PF", length = 20)),
			@AttributeOverride(name = "agpFonCodDmp", column = @Column(name = "AGP_FON_COD_DMP", length = 20)),
			@AttributeOverride(name = "agpRecherche", column = @Column(name = "AGP_RECHERCHE", length = 400)) })
	public TAgpmId getId() {
		return this.id;
	}

	public void setId(TAgpmId id) {
		this.id = id;
	}

}
