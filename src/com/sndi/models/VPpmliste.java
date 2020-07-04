package com.sndi.models;
// Generated 4 juil. 2020 18:05:44 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VPpmliste generated by hbm2java
 */
@Entity
@Table(name = "V_PPMLISTE", schema = "EMAP")
public class VPpmliste implements java.io.Serializable {

	private VPpmlisteId id;

	public VPpmliste() {
	}

	public VPpmliste(VPpmlisteId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "dppId", column = @Column(name = "DPP_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "dppDteModif", column = @Column(name = "DPP_DTE_MODIF", length = 7)),
			@AttributeOverride(name = "dppObjet", column = @Column(name = "DPP_OBJET", length = 1000)),
			@AttributeOverride(name = "dppSourceFin", column = @Column(name = "DPP_SOURCE_FIN", length = 1000)),
			@AttributeOverride(name = "dppLbgCode", column = @Column(name = "DPP_LBG_CODE", length = 50)),
			@AttributeOverride(name = "dppStaCode", column = @Column(name = "DPP_STA_CODE", nullable = false, length = 3)),
			@AttributeOverride(name = "dppMopCode", column = @Column(name = "DPP_MOP_CODE", nullable = false, length = 3)),
			@AttributeOverride(name = "mopLibelleCourt", column = @Column(name = "MOP_LIBELLE_COURT", nullable = false, length = 500)),
			@AttributeOverride(name = "mopLibelleLong", column = @Column(name = "MOP_LIBELLE_LONG", length = 1000)),
			@AttributeOverride(name = "dppStrCode", column = @Column(name = "DPP_STR_CODE", length = 20)),
			@AttributeOverride(name = "strLibelleCourt", column = @Column(name = "STR_LIBELLE_COURT", length = 500)),
			@AttributeOverride(name = "strLibelleLong", column = @Column(name = "STR_LIBELLE_LONG", length = 1000)),
			@AttributeOverride(name = "lbgFonCodePf", column = @Column(name = "LBG_FON_CODE_PF", length = 30)),
			@AttributeOverride(name = "lbgFonCodeAc", column = @Column(name = "LBG_FON_CODE_AC", length = 30)),
			@AttributeOverride(name = "lbgFonCodeCf", column = @Column(name = "LBG_FON_CODE_CF", length = 30)),
			@AttributeOverride(name = "lbgFonCodeCor", column = @Column(name = "LBG_FON_CODE_COR", length = 30)),
			@AttributeOverride(name = "lbgFonCodeVal", column = @Column(name = "LBG_FON_CODE_VAL", length = 10)),
			@AttributeOverride(name = "dppDateValAc", column = @Column(name = "DPP_DATE_VAL_AC", length = 7)),
			@AttributeOverride(name = "dppDateValCpmp", column = @Column(name = "DPP_DATE_VAL_CPMP", length = 7)),
			@AttributeOverride(name = "dppDateValDmp", column = @Column(name = "DPP_DATE_VAL_DMP", length = 7)),
			@AttributeOverride(name = "dppPartiePmePmi", column = @Column(name = "DPP_PARTIE_PME_PMI", length = 1)),
			@AttributeOverride(name = "dppDateSaisie", column = @Column(name = "DPP_DATE_SAISIE", length = 7)),
			@AttributeOverride(name = "dppTypePlan", column = @Column(name = "DPP_TYPE_PLAN", nullable = false, length = 3)),
			@AttributeOverride(name = "tymLibelleCourt", column = @Column(name = "TYM_LIBELLE_COURT", nullable = false, length = 500)),
			@AttributeOverride(name = "dppStatutRetour", column = @Column(name = "DPP_STATUT_RETOUR", length = 4)),
			@AttributeOverride(name = "dppStructureConduc", column = @Column(name = "DPP_STRUCTURE_CONDUC", length = 500)),
			@AttributeOverride(name = "dppStructureBenefi", column = @Column(name = "DPP_STRUCTURE_BENEFI", length = 500)),
			@AttributeOverride(name = "dppRecherche", column = @Column(name = "DPP_RECHERCHE", length = 4000)),
			@AttributeOverride(name = "dppFonCodPf", column = @Column(name = "DPP_FON_COD_PF", length = 20)),
			@AttributeOverride(name = "dppFonCodDmp", column = @Column(name = "DPP_FON_COD_DMP", length = 20)),
			@AttributeOverride(name = "dppActeurSaisie", column = @Column(name = "DPP_ACTEUR_SAISIE", length = 12)),
			@AttributeOverride(name = "plpId", column = @Column(name = "PLP_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "plpGesCode", column = @Column(name = "PLP_GES_CODE", nullable = false, precision = 4, scale = 0)) })
	public VPpmlisteId getId() {
		return this.id;
	}

	public void setId(VPpmlisteId id) {
		this.id = id;
	}

}
