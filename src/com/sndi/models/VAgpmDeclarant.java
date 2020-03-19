package com.sndi.models;
// Generated 19 mars 2020 16:14:06 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VAgpmDeclarant generated by hbm2java
 */
@Entity
@Table(name = "V_AGPM_DECLARANT", schema = "EMAP")
public class VAgpmDeclarant implements java.io.Serializable {

	private VAgpmDeclarantId id;

	public VAgpmDeclarant() {
	}

	public VAgpmDeclarant(VAgpmDeclarantId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "agpId", column = @Column(name = "AGP_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "agpFonCod", column = @Column(name = "AGP_FON_COD", nullable = false, length = 12)),
			@AttributeOverride(name = "agpStrCode", column = @Column(name = "AGP_STR_CODE", nullable = false, length = 3)),
			@AttributeOverride(name = "agpProId", column = @Column(name = "AGP_PRO_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "agpActeurSaisie", column = @Column(name = "AGP_ACTEUR_SAISIE", length = 12)),
			@AttributeOverride(name = "decPersNomPrenom", column = @Column(name = "DEC_PERS_NOM_PRENOM", length = 500)),
			@AttributeOverride(name = "decOrganExecLibelle", column = @Column(name = "DEC_ORGAN_EXEC_LIBELLE", nullable = false, length = 500)),
			@AttributeOverride(name = "decPersFonction", column = @Column(name = "DEC_PERS_FONCTION", nullable = false, length = 500)),
			@AttributeOverride(name = "decTelephone", column = @Column(name = "DEC_TELEPHONE", length = 500)),
			@AttributeOverride(name = "decNumeroPorte", column = @Column(name = "DEC_NUMERO_PORTE", length = 500)),
			@AttributeOverride(name = "decOrganExecAdresse", column = @Column(name = "DEC_ORGAN_EXEC_ADRESSE", length = 500)),
			@AttributeOverride(name = "decLocalisation", column = @Column(name = "DEC_LOCALISATION", length = 500)),
			@AttributeOverride(name = "decEmail", column = @Column(name = "DEC_EMAIL", length = 500)),
			@AttributeOverride(name = "decBp", column = @Column(name = "DEC_BP", nullable = false, length = 500)),
			@AttributeOverride(name = "decCel", column = @Column(name = "DEC_CEL", length = 500)),
			@AttributeOverride(name = "agpDecId", column = @Column(name = "AGP_DEC_ID", precision = 10, scale = 0)) })
	public VAgpmDeclarantId getId() {
		return this.id;
	}

	public void setId(VAgpmDeclarantId id) {
		this.id = id;
	}

}
