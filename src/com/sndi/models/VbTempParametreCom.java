package com.sndi.models;
// Generated 26 mars 2020 03:50:59 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbTempParametreCom generated by hbm2java
 */
@Entity
@Table(name = "VB_TEMP_PARAMETRE_COM", schema = "EMAP")
public class VbTempParametreCom implements java.io.Serializable {

	private VbTempParametreComId id;

	public VbTempParametreCom() {
	}

	public VbTempParametreCom(VbTempParametreComId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "tempNum", column = @Column(name = "TEMP_NUM", nullable = false, precision = 22, scale = 0)),
			@AttributeOverride(name = "tempType", column = @Column(name = "TEMP_TYPE", length = 500)),
			@AttributeOverride(name = "tempOpeMatricule", column = @Column(name = "TEMP_OPE_MATRICULE", length = 500)),
			@AttributeOverride(name = "tempDteSaisi", column = @Column(name = "TEMP_DTE_SAISI", length = 7)),
			@AttributeOverride(name = "dcsMbmRespo", column = @Column(name = "DCS_MBM_RESPO", length = 500)),
			@AttributeOverride(name = "dcsNum", column = @Column(name = "DCS_NUM", length = 500)),
			@AttributeOverride(name = "dcsDacCode", column = @Column(name = "DCS_DAC_CODE", length = 500)),
			@AttributeOverride(name = "dcsFonCod", column = @Column(name = "DCS_FON_COD", length = 500)),
			@AttributeOverride(name = "dcsSeaQuorum", column = @Column(name = "DCS_SEA_QUORUM", length = 500)),
			@AttributeOverride(name = "dcsSeaNum", column = @Column(name = "DCS_SEA_NUM", length = 500)),
			@AttributeOverride(name = "dcsDteSaisi", column = @Column(name = "DCS_DTE_SAISI", length = 500)),
			@AttributeOverride(name = "dcsFonCodSaisi", column = @Column(name = "DCS_FON_COD_SAISI", length = 500)),
			@AttributeOverride(name = "dcsObservation", column = @Column(name = "DCS_OBSERVATION", length = 500)),
			@AttributeOverride(name = "dcsComTcoCode", column = @Column(name = "DCS_COM_TCO_CODE", length = 500)),
			@AttributeOverride(name = "dcsComNum", column = @Column(name = "DCS_COM_NUM", length = 500)),
			@AttributeOverride(name = "dcsNomMbm", column = @Column(name = "DCS_NOM_MBM", length = 500)),
			@AttributeOverride(name = "dcsPreMbm", column = @Column(name = "DCS_PRE_MBM", length = 500)),
			@AttributeOverride(name = "dcsTelMbm", column = @Column(name = "DCS_TEL_MBM", length = 500)),
			@AttributeOverride(name = "dcsPresent", column = @Column(name = "DCS_PRESENT", length = 500)),
			@AttributeOverride(name = "dcsComStrCode", column = @Column(name = "DCS_COM_STR_CODE", length = 500)),
			@AttributeOverride(name = "dcsOpeMatSaisi", column = @Column(name = "DCS_OPE_MAT_SAISI", length = 500)),
			@AttributeOverride(name = "dcsNbrPli", column = @Column(name = "DCS_NBR_PLI", length = 500)),
			@AttributeOverride(name = "dcsComTctCode", column = @Column(name = "DCS_COM_TCT_CODE", length = 500)),
			@AttributeOverride(name = "dcsRepMandate", column = @Column(name = "DCS_REP_MANDATE", length = 500)),
			@AttributeOverride(name = "dcsSeaTseNum", column = @Column(name = "DCS_SEA_TSE_NUM", length = 500)),
			@AttributeOverride(name = "dcsAaoNbrOff", column = @Column(name = "DCS_AAO_NBR_OFF", length = 500)),
			@AttributeOverride(name = "dcsAaoNbrOffAccept", column = @Column(name = "DCS_AAO_NBR_OFF_ACCEPT", length = 500)),
			@AttributeOverride(name = "dcsAaoNbrOffRej", column = @Column(name = "DCS_AAO_NBR_OFF_REJ", length = 500)),
			@AttributeOverride(name = "dcsAaoNbrOffHorDelai", column = @Column(name = "DCS_AAO_NBR_OFF_HOR_DELAI", length = 500)) })
	public VbTempParametreComId getId() {
		return this.id;
	}

	public void setId(VbTempParametreComId id) {
		this.id = id;
	}

}
