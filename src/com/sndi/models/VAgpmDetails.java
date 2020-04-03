package com.sndi.models;
// Generated 3 avr. 2020 00:55:57 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VAgpmDetails generated by hbm2java
 */
@Entity
@Table(name = "V_AGPM_DETAILS", schema = "EMAP")
public class VAgpmDetails implements java.io.Serializable {

	private VAgpmDetailsId id;

	public VAgpmDetails() {
	}

	public VAgpmDetails(VAgpmDetailsId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "affProId", column = @Column(name = "AFF_PRO_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "proId", column = @Column(name = "PRO_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "proLibelle", column = @Column(name = "PRO_LIBELLE", length = 500)),
			@AttributeOverride(name = "proDescription", column = @Column(name = "PRO_DESCRIPTION", length = 1000)),
			@AttributeOverride(name = "proTitre", column = @Column(name = "PRO_TITRE", nullable = false, length = 500)),
			@AttributeOverride(name = "proMontantTotCfa", column = @Column(name = "PRO_MONTANT_TOT_CFA", precision = 15)),
			@AttributeOverride(name = "minLibelle", column = @Column(name = "MIN_LIBELLE", length = 1000)),
			@AttributeOverride(name = "minDescription", column = @Column(name = "MIN_DESCRIPTION", length = 1000)),
			@AttributeOverride(name = "gesDateDebut", column = @Column(name = "GES_DATE_DEBUT", length = 7)),
			@AttributeOverride(name = "gesDateFin", column = @Column(name = "GES_DATE_FIN", length = 7)),
			@AttributeOverride(name = "decPersNomPrenom", column = @Column(name = "DEC_PERS_NOM_PRENOM", length = 500)),
			@AttributeOverride(name = "decPersFonction", column = @Column(name = "DEC_PERS_FONCTION", length = 500)),
			@AttributeOverride(name = "decTelephone", column = @Column(name = "DEC_TELEPHONE", length = 500)),
			@AttributeOverride(name = "decOrganExecLibelle", column = @Column(name = "DEC_ORGAN_EXEC_LIBELLE", length = 500)),
			@AttributeOverride(name = "decOrganExecAdresse", column = @Column(name = "DEC_ORGAN_EXEC_ADRESSE", length = 500)),
			@AttributeOverride(name = "decNumeroPorte", column = @Column(name = "DEC_NUMERO_PORTE", length = 500)),
			@AttributeOverride(name = "decLocalisation", column = @Column(name = "DEC_LOCALISATION", length = 500)),
			@AttributeOverride(name = "decEmail", column = @Column(name = "DEC_EMAIL", length = 500)),
			@AttributeOverride(name = "decBp", column = @Column(name = "DEC_BP", length = 500)),
			@AttributeOverride(name = "decCel", column = @Column(name = "DEC_CEL", length = 500)),
			@AttributeOverride(name = "affAgpId", column = @Column(name = "AFF_AGP_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "affGesCode", column = @Column(name = "AFF_GES_CODE", nullable = false, precision = 4, scale = 0)),
			@AttributeOverride(name = "affAgpCommentaire", column = @Column(name = "AFF_AGP_COMMENTAIRE", length = 1000)),
			@AttributeOverride(name = "affAgpActif", column = @Column(name = "AFF_AGP_ACTIF", length = 1)),
			@AttributeOverride(name = "affAgpTypeDao", column = @Column(name = "AFF_AGP_TYPE_DAO", length = 1000)),
			@AttributeOverride(name = "affAgpStaCode", column = @Column(name = "AFF_AGP_STA_CODE", nullable = false, length = 3)),
			@AttributeOverride(name = "regLibelleLong", column = @Column(name = "REG_LIBELLE_LONG", length = 1000)),
			@AttributeOverride(name = "regLibelleCourt", column = @Column(name = "REG_LIBELLE_COURT", length = 500)),
			@AttributeOverride(name = "fonLibelle", column = @Column(name = "FON_LIBELLE", length = 500)),
			@AttributeOverride(name = "strLibelleLong", column = @Column(name = "STR_LIBELLE_LONG", length = 1000)),
			@AttributeOverride(name = "strLibelleCourt", column = @Column(name = "STR_LIBELLE_COURT", length = 500)) })
	public VAgpmDetailsId getId() {
		return this.id;
	}

	public void setId(VAgpmDetailsId id) {
		this.id = id;
	}

}
