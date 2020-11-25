package com.sndi.models;
// Generated 23 nov. 2020 12:59:43 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VProjetAgpm generated by hbm2java
 */
@Entity
@Table(name = "V_PROJET_AGPM", schema = "EMAP")
public class VProjetAgpm implements java.io.Serializable {

	private VProjetAgpmId id;

	public VProjetAgpm() {
	}

	public VProjetAgpm(VProjetAgpmId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "proId", column = @Column(name = "PRO_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "proTitre", column = @Column(name = "PRO_TITRE", nullable = false, length = 500)),
			@AttributeOverride(name = "proTypeProjet", column = @Column(name = "PRO_TYPE_PROJET", length = 10)),
			@AttributeOverride(name = "agpTypeDao", column = @Column(name = "AGP_TYPE_DAO", length = 1000)),
			@AttributeOverride(name = "agpStaCode", column = @Column(name = "AGP_STA_CODE", nullable = false, length = 3)),
			@AttributeOverride(name = "agpActif", column = @Column(name = "AGP_ACTIF", length = 1)),
			@AttributeOverride(name = "proMontantTotCfa", column = @Column(name = "PRO_MONTANT_TOT_CFA", precision = 15)),
			@AttributeOverride(name = "proDescription", column = @Column(name = "PRO_DESCRIPTION", length = 1000)),
			@AttributeOverride(name = "agpId", column = @Column(name = "AGP_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "agpDecId", column = @Column(name = "AGP_DEC_ID", precision = 10, scale = 0)),
			@AttributeOverride(name = "agpModePassation", column = @Column(name = "AGP_MODE_PASSATION", length = 1000)),
			@AttributeOverride(name = "agpGesCode", column = @Column(name = "AGP_GES_CODE", nullable = false, precision = 4, scale = 0)),
			@AttributeOverride(name = "agpCommentaire", column = @Column(name = "AGP_COMMENTAIRE", length = 1000)),
			@AttributeOverride(name = "agpStrCode", column = @Column(name = "AGP_STR_CODE", nullable = false, length = 20)),
			@AttributeOverride(name = "agpActeurSaisie", column = @Column(name = "AGP_ACTEUR_SAISIE", length = 12)),
			@AttributeOverride(name = "regId", column = @Column(name = "REG_ID", precision = 10, scale = 0)),
			@AttributeOverride(name = "regLibelleLong", column = @Column(name = "REG_LIBELLE_LONG", length = 1000)),
			@AttributeOverride(name = "regLibelleCourt", column = @Column(name = "REG_LIBELLE_COURT", length = 500)),
			@AttributeOverride(name = "minLibelle", column = @Column(name = "MIN_LIBELLE", length = 1000)),
			@AttributeOverride(name = "minLibelleCourt", column = @Column(name = "MIN_LIBELLE_COURT", length = 500)),
			@AttributeOverride(name = "baiLibelle", column = @Column(name = "BAI_LIBELLE", nullable = false, length = 1000)),
			@AttributeOverride(name = "devLibelle", column = @Column(name = "DEV_LIBELLE", length = 500)),
			@AttributeOverride(name = "souLibelle", column = @Column(name = "SOU_LIBELLE", length = 500)),
			@AttributeOverride(name = "finNumeroAccord", column = @Column(name = "FIN_NUMERO_ACCORD", length = 500)),
			@AttributeOverride(name = "finMontantCfa", column = @Column(name = "FIN_MONTANT_CFA", precision = 15)),
			@AttributeOverride(name = "finMontantDevise", column = @Column(name = "FIN_MONTANT_DEVISE", precision = 15)),
			@AttributeOverride(name = "fonLibelle", column = @Column(name = "FON_LIBELLE", length = 500)),
			@AttributeOverride(name = "strCode", column = @Column(name = "STR_CODE", length = 20)),
			@AttributeOverride(name = "strLibelleCourt", column = @Column(name = "STR_LIBELLE_COURT", length = 500)),
			@AttributeOverride(name = "strLibelleLong", column = @Column(name = "STR_LIBELLE_LONG", length = 1000)) })
	public VProjetAgpmId getId() {
		return this.id;
	}

	public void setId(VProjetAgpmId id) {
		this.id = id;
	}

}
