package com.sndi.models;
// Generated 8 ao�t 2020 14:11:26 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VAgpmFonction generated by hbm2java
 */
@Entity
@Table(name = "V_AGPM_FONCTION", schema = "EMAP")
public class VAgpmFonction implements java.io.Serializable {

	private VAgpmFonctionId id;

	public VAgpmFonction() {
	}

	public VAgpmFonction(VAgpmFonctionId id) {
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
			@AttributeOverride(name = "agpFonCodPf", column = @Column(name = "AGP_FON_COD_PF", length = 20)),
			@AttributeOverride(name = "agpFonCodDmp", column = @Column(name = "AGP_FON_COD_DMP", length = 20)),
			@AttributeOverride(name = "agpRecherche", column = @Column(name = "AGP_RECHERCHE", length = 4000)),
			@AttributeOverride(name = "finId", column = @Column(name = "FIN_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "finDevCode", column = @Column(name = "FIN_DEV_CODE", nullable = false, length = 8)),
			@AttributeOverride(name = "finBaiCode", column = @Column(name = "FIN_BAI_CODE", length = 5)),
			@AttributeOverride(name = "finSouCode", column = @Column(name = "FIN_SOU_CODE", nullable = false, length = 5)),
			@AttributeOverride(name = "finProId", column = @Column(name = "FIN_PRO_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "finMontantCfa", column = @Column(name = "FIN_MONTANT_CFA", precision = 15)),
			@AttributeOverride(name = "finMontantDevise", column = @Column(name = "FIN_MONTANT_DEVISE", precision = 15)),
			@AttributeOverride(name = "finNumeroAccord", column = @Column(name = "FIN_NUMERO_ACCORD", length = 500)),
			@AttributeOverride(name = "finStatut", column = @Column(name = "FIN_STATUT", length = 10)),
			@AttributeOverride(name = "finAgpId", column = @Column(name = "FIN_AGP_ID", precision = 10, scale = 0)),
			@AttributeOverride(name = "finTypeFinance", column = @Column(name = "FIN_TYPE_FINANCE", length = 20)),
			@AttributeOverride(name = "finPartTresor", column = @Column(name = "FIN_PART_TRESOR", precision = 15, scale = 0)),
			@AttributeOverride(name = "proId", column = @Column(name = "PRO_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "proRegId", column = @Column(name = "PRO_REG_ID", precision = 10, scale = 0)),
			@AttributeOverride(name = "proCode", column = @Column(name = "PRO_CODE", length = 50)),
			@AttributeOverride(name = "proTitre", column = @Column(name = "PRO_TITRE", nullable = false, length = 500)),
			@AttributeOverride(name = "proLibelle", column = @Column(name = "PRO_LIBELLE", length = 500)),
			@AttributeOverride(name = "proDescription", column = @Column(name = "PRO_DESCRIPTION", length = 1000)),
			@AttributeOverride(name = "proMontantTotCfa", column = @Column(name = "PRO_MONTANT_TOT_CFA", precision = 15)),
			@AttributeOverride(name = "proTypeProjet", column = @Column(name = "PRO_TYPE_PROJET", length = 10)) })
	public VAgpmFonctionId getId() {
		return this.id;
	}

	public void setId(VAgpmFonctionId id) {
		this.id = id;
	}

}
