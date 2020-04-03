package com.sndi.models;
// Generated 3 avr. 2020 00:55:57 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbTempParamVente generated by hbm2java
 */
@Entity
@Table(name = "VB_TEMP_PARAM_VENTE", schema = "EMAP")
public class VbTempParamVente implements java.io.Serializable {

	private VbTempParamVenteId id;

	public VbTempParamVente() {
	}

	public VbTempParamVente(VbTempParamVenteId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "tempNum", column = @Column(name = "TEMP_NUM")),
			@AttributeOverride(name = "dofDteSaisi", column = @Column(name = "DOF_DTE_SAISI")),
			@AttributeOverride(name = "dofOpeMatricule", column = @Column(name = "DOF_OPE_MATRICULE")),
			@AttributeOverride(name = "tempType", column = @Column(name = "TEMP_TYPE")),
			@AttributeOverride(name = "canCode", column = @Column(name = "CAN_CODE")),
			@AttributeOverride(name = "canNom", column = @Column(name = "CAN_NOM")),
			@AttributeOverride(name = "canNomResp", column = @Column(name = "CAN_NOM_RESP")),
			@AttributeOverride(name = "canSouNcc", column = @Column(name = "CAN_SOU_NCC")),
			@AttributeOverride(name = "canTel", column = @Column(name = "CAN_TEL")),
			@AttributeOverride(name = "canTieNcc", column = @Column(name = "CAN_TIE_NCC")),
			@AttributeOverride(name = "dveCout", column = @Column(name = "DVE_COUT")),
			@AttributeOverride(name = "dveDacCode", column = @Column(name = "DVE_DAC_CODE")),
			@AttributeOverride(name = "dveLaaNum", column = @Column(name = "DVE_LAA_NUM")),
			@AttributeOverride(name = "dveQte", column = @Column(name = "DVE_QTE")),
			@AttributeOverride(name = "venNum", column = @Column(name = "VEN_NUM")),
			@AttributeOverride(name = "venMrgCod", column = @Column(name = "VEN_MRG_COD")),
			@AttributeOverride(name = "canPrenoms", column = @Column(name = "CAN_PRENOMS")) })
	public VbTempParamVenteId getId() {
		return this.id;
	}

	public void setId(VbTempParamVenteId id) {
		this.id = id;
	}

}
