package com.sndi.models;
// Generated 22 mars 2020 01:52:15 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbDeclarant generated by hbm2java
 */
@Entity
@Table(name = "VB_DECLARANT", schema = "EMAP")
public class VbDeclarant implements java.io.Serializable {

	private VbDeclarantId id;

	public VbDeclarant() {
	}

	public VbDeclarant(VbDeclarantId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "decId", column = @Column(name = "DEC_ID", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "decOrganExecLibelle", column = @Column(name = "DEC_ORGAN_EXEC_LIBELLE", nullable = false, length = 500)),
			@AttributeOverride(name = "decOrganExecAdresse", column = @Column(name = "DEC_ORGAN_EXEC_ADRESSE", length = 500)),
			@AttributeOverride(name = "decPersNomPrenom", column = @Column(name = "DEC_PERS_NOM_PRENOM", length = 500)),
			@AttributeOverride(name = "decPersFonction", column = @Column(name = "DEC_PERS_FONCTION", nullable = false, length = 500)),
			@AttributeOverride(name = "decLocalisation", column = @Column(name = "DEC_LOCALISATION", length = 500)),
			@AttributeOverride(name = "decNumeroPorte", column = @Column(name = "DEC_NUMERO_PORTE", length = 500)),
			@AttributeOverride(name = "decBp", column = @Column(name = "DEC_BP", nullable = false, length = 500)),
			@AttributeOverride(name = "decTelephone", column = @Column(name = "DEC_TELEPHONE", length = 500)),
			@AttributeOverride(name = "decEmail", column = @Column(name = "DEC_EMAIL", length = 500)),
			@AttributeOverride(name = "decCel", column = @Column(name = "DEC_CEL", length = 500)) })
	public VbDeclarantId getId() {
		return this.id;
	}

	public void setId(VbDeclarantId id) {
		this.id = id;
	}

}
