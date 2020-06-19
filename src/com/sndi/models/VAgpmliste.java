package com.sndi.models;
// Generated 18 juin 2020 16:45:49 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VAgpmliste generated by hbm2java
 */
@Entity
@Table(name = "V_AGPMLISTE", schema = "EMAP")
public class VAgpmliste implements java.io.Serializable {

	private VAgpmlisteId id;

	public VAgpmliste() {
	}

	public VAgpmliste(VAgpmlisteId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "agpId", column = @Column(name = "AGP_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "agpCode", column = @Column(name = "AGP_CODE", length = 50)),
			@AttributeOverride(name = "finNumeroAccord", column = @Column(name = "FIN_NUMERO_ACCORD", length = 500)),
			@AttributeOverride(name = "proTitre", column = @Column(name = "PRO_TITRE", nullable = false, length = 500)),
			@AttributeOverride(name = "baiLibelle", column = @Column(name = "BAI_LIBELLE", length = 1000)),
			@AttributeOverride(name = "fonctionAc", column = @Column(name = "FONCTION_AC", length = 523)),
			@AttributeOverride(name = "decOrganExecLibelle", column = @Column(name = "DEC_ORGAN_EXEC_LIBELLE", length = 500)),
			@AttributeOverride(name = "minLibelleCourt", column = @Column(name = "MIN_LIBELLE_COURT", length = 500)),
			@AttributeOverride(name = "strTstCode", column = @Column(name = "STR_TST_CODE", length = 3)),
			@AttributeOverride(name = "agpActif", column = @Column(name = "AGP_ACTIF", length = 1)),
			@AttributeOverride(name = "agpFonCod", column = @Column(name = "AGP_FON_COD", nullable = false, length = 20)),
			@AttributeOverride(name = "agpFonCodPf", column = @Column(name = "AGP_FON_COD_PF", length = 20)),
			@AttributeOverride(name = "agpStaCode", column = @Column(name = "AGP_STA_CODE", nullable = false, length = 3)),
			@AttributeOverride(name = "agpStatutRetour", column = @Column(name = "AGP_STATUT_RETOUR", length = 2)),
			@AttributeOverride(name = "agpDateValAc", column = @Column(name = "AGP_DATE_VAL_AC", length = 7)),
			@AttributeOverride(name = "agpDateValCpmp", column = @Column(name = "AGP_DATE_VAL_CPMP", length = 7)),
			@AttributeOverride(name = "agpDateValDmp", column = @Column(name = "AGP_DATE_VAL_DMP", length = 7)),
			@AttributeOverride(name = "agpDteModif", column = @Column(name = "AGP_DTE_MODIF", length = 7)),
			@AttributeOverride(name = "agpFonCodDmp", column = @Column(name = "AGP_FON_COD_DMP", length = 20)),
			@AttributeOverride(name = "agpGesCode", column = @Column(name = "AGP_GES_CODE", nullable = false, precision = 4, scale = 0)),
			@AttributeOverride(name = "finId", column = @Column(name = "FIN_ID", precision = 10, scale = 0)),
			@AttributeOverride(name = "proId", column = @Column(name = "PRO_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "decId", column = @Column(name = "DEC_ID", precision = 10, scale = 0)),
			@AttributeOverride(name = "agpRecherche", column = @Column(name = "AGP_RECHERCHE", length = 4000)),
			@AttributeOverride(name = "agpStrCode", column = @Column(name = "AGP_STR_CODE", nullable = false, length = 20)) })
	public VAgpmlisteId getId() {
		return this.id;
	}

	public void setId(VAgpmlisteId id) {
		this.id = id;
	}

}
