package com.sndi.models;
// Generated 22 mars 2020 01:52:15 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbOperateur generated by hbm2java
 */
@Entity
@Table(name = "VB_OPERATEUR", schema = "EMAP")
public class VbOperateur implements java.io.Serializable {

	private VbOperateurId id;

	public VbOperateur() {
	}

	public VbOperateur(VbOperateurId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "opeMatricule", column = @Column(name = "OPE_MATRICULE", nullable = false, length = 25)),
			@AttributeOverride(name = "opeNom", column = @Column(name = "OPE_NOM")),
			@AttributeOverride(name = "opeContact", column = @Column(name = "OPE_CONTACT", length = 250)),
			@AttributeOverride(name = "opeEtatCivil", column = @Column(name = "OPE_ETAT_CIVIL", length = 250)),
			@AttributeOverride(name = "opeMail", column = @Column(name = "OPE_MAIL", length = 250)),
			@AttributeOverride(name = "opeLogin", column = @Column(name = "OPE_LOGIN", length = 50)),
			@AttributeOverride(name = "opeMinCode", column = @Column(name = "OPE_MIN_CODE", length = 3)),
			@AttributeOverride(name = "opeFonctionAdminist", column = @Column(name = "OPE_FONCTION_ADMINIST", length = 500)),
			@AttributeOverride(name = "opeStrCode", column = @Column(name = "OPE_STR_CODE", length = 30)) })
	public VbOperateurId getId() {
		return this.id;
	}

	public void setId(VbOperateurId id) {
		this.id = id;
	}

}
