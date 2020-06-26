package com.sndi.models;
// Generated 25 juin 2020 13:53:46 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VUpdateAgpm generated by hbm2java
 */
@Entity
@Table(name = "V_UPDATE_AGPM", schema = "EMAP")
public class VUpdateAgpm implements java.io.Serializable {

	private VUpdateAgpmId id;

	public VUpdateAgpm() {
	}

	public VUpdateAgpm(VUpdateAgpmId id) {
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
			@AttributeOverride(name = "agpRecherche", column = @Column(name = "AGP_RECHERCHE", length = 4000)),
			@AttributeOverride(name = "decId", column = @Column(name = "DEC_ID", precision = 10, scale = 0)),
			@AttributeOverride(name = "decOrganExecLibelle", column = @Column(name = "DEC_ORGAN_EXEC_LIBELLE", length = 500)),
			@AttributeOverride(name = "decOrganExecAdresse", column = @Column(name = "DEC_ORGAN_EXEC_ADRESSE", length = 500)),
			@AttributeOverride(name = "decPersNomPrenom", column = @Column(name = "DEC_PERS_NOM_PRENOM", length = 500)),
			@AttributeOverride(name = "decPersFonction", column = @Column(name = "DEC_PERS_FONCTION", length = 500)),
			@AttributeOverride(name = "decLocalisation", column = @Column(name = "DEC_LOCALISATION", length = 500)),
			@AttributeOverride(name = "decNumeroPorte", column = @Column(name = "DEC_NUMERO_PORTE", length = 500)),
			@AttributeOverride(name = "decBp", column = @Column(name = "DEC_BP", length = 500)),
			@AttributeOverride(name = "decTelephone", column = @Column(name = "DEC_TELEPHONE", length = 500)),
			@AttributeOverride(name = "decEmail", column = @Column(name = "DEC_EMAIL", length = 500)),
			@AttributeOverride(name = "decCel", column = @Column(name = "DEC_CEL", length = 500)),
			@AttributeOverride(name = "proId", column = @Column(name = "PRO_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "proRegId", column = @Column(name = "PRO_REG_ID", precision = 10, scale = 0)),
			@AttributeOverride(name = "proCode", column = @Column(name = "PRO_CODE", length = 50)),
			@AttributeOverride(name = "proTitre", column = @Column(name = "PRO_TITRE", nullable = false, length = 500)),
			@AttributeOverride(name = "proLibelle", column = @Column(name = "PRO_LIBELLE", length = 500)),
			@AttributeOverride(name = "proDescription", column = @Column(name = "PRO_DESCRIPTION", length = 1000)),
			@AttributeOverride(name = "proMontantTotCfa", column = @Column(name = "PRO_MONTANT_TOT_CFA", precision = 15)),
			@AttributeOverride(name = "proTypeProjet", column = @Column(name = "PRO_TYPE_PROJET", length = 10)),
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
			@AttributeOverride(name = "baiCode", column = @Column(name = "BAI_CODE", nullable = false, length = 5)),
			@AttributeOverride(name = "baiLibelle", column = @Column(name = "BAI_LIBELLE", nullable = false, length = 1000)),
			@AttributeOverride(name = "baiAdresse", column = @Column(name = "BAI_ADRESSE", length = 500)),
			@AttributeOverride(name = "baiTelephone", column = @Column(name = "BAI_TELEPHONE", length = 500)) })
	public VUpdateAgpmId getId() {
		return this.id;
	}

	public void setId(VUpdateAgpmId id) {
		this.id = id;
	}

}