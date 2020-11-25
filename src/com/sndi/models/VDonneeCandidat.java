package com.sndi.models;
// Generated 23 nov. 2020 12:59:43 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VDonneeCandidat generated by hbm2java
 */
@Entity
@Table(name = "V_DONNEE_CANDIDAT", schema = "EMAP")
public class VDonneeCandidat implements java.io.Serializable {

	private VDonneeCandidatId id;

	public VDonneeCandidat() {
	}

	public VDonneeCandidat(VDonneeCandidatId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "dacCode", column = @Column(name = "DAC_CODE", nullable = false, length = 20)),
			@AttributeOverride(name = "canCode", column = @Column(name = "CAN_CODE", nullable = false, precision = 10, scale = 0)),
			@AttributeOverride(name = "canTieNcc", column = @Column(name = "CAN_TIE_NCC", length = 32)),
			@AttributeOverride(name = "canSouNcc", column = @Column(name = "CAN_SOU_NCC", length = 20)),
			@AttributeOverride(name = "canNomResp", column = @Column(name = "CAN_NOM_RESP", length = 500)),
			@AttributeOverride(name = "canNom", column = @Column(name = "CAN_NOM", length = 500)),
			@AttributeOverride(name = "canPrenoms", column = @Column(name = "CAN_PRENOMS", length = 500)),
			@AttributeOverride(name = "canTel", column = @Column(name = "CAN_TEL", length = 50)),
			@AttributeOverride(name = "canDteSaisi", column = @Column(name = "CAN_DTE_SAISI", length = 7)),
			@AttributeOverride(name = "canOpeMatricule", column = @Column(name = "CAN_OPE_MATRICULE", length = 25)),
			@AttributeOverride(name = "canEmail", column = @Column(name = "CAN_EMAIL", length = 50)),
			@AttributeOverride(name = "dveDacCode", column = @Column(name = "DVE_DAC_CODE", nullable = false, length = 20)) })
	public VDonneeCandidatId getId() {
		return this.id;
	}

	public void setId(VDonneeCandidatId id) {
		this.id = id;
	}

}
