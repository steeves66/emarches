package com.sndi.models;
// Generated 31 mars 2020 01:27:37 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbTempParametreLot generated by hbm2java
 */
@Entity
@Table(name = "VB_TEMP_PARAMETRE_LOT", schema = "EMAP")
public class VbTempParametreLot implements java.io.Serializable {

	private VbTempParametreLotId id;

	public VbTempParametreLot() {
	}

	public VbTempParametreLot(VbTempParametreLotId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "tempNum", column = @Column(name = "TEMP_NUM", nullable = false, precision = 22, scale = 0)),
			@AttributeOverride(name = "tempType", column = @Column(name = "TEMP_TYPE", length = 500)),
			@AttributeOverride(name = "tempOpeMatricule", column = @Column(name = "TEMP_OPE_MATRICULE", length = 500)),
			@AttributeOverride(name = "tempLaaDteSaisi", column = @Column(name = "TEMP_LAA_DTE_SAISI", length = 7)),
			@AttributeOverride(name = "tempLaaNbrTotLot", column = @Column(name = "TEMP_LAA_NBR_TOT_LOT", length = 500)),
			@AttributeOverride(name = "tempLaaNbrLotDebut", column = @Column(name = "TEMP_LAA_NBR_LOT_DEBUT", length = 500)),
			@AttributeOverride(name = "tempLaaNbrLotFin", column = @Column(name = "TEMP_LAA_NBR_LOT_FIN", length = 500)),
			@AttributeOverride(name = "tempLaaLibGenerique", column = @Column(name = "TEMP_LAA_LIB_GENERIQUE", length = 500)),
			@AttributeOverride(name = "tempLaaImputation", column = @Column(name = "TEMP_LAA_IMPUTATION", length = 500)),
			@AttributeOverride(name = "tempLaaCautLot", column = @Column(name = "TEMP_LAA_CAUT_LOT", length = 500)),
			@AttributeOverride(name = "tempLaaMtLot", column = @Column(name = "TEMP_LAA_MT_LOT", length = 500)),
			@AttributeOverride(name = "tempLaaAaoCode", column = @Column(name = "TEMP_LAA_AAO_CODE", length = 500)),
			@AttributeOverride(name = "tempLaaAutre", column = @Column(name = "TEMP_LAA_AUTRE", length = 500)),
			@AttributeOverride(name = "tempLaaAutre1", column = @Column(name = "TEMP_LAA_AUTRE_1", length = 500)),
			@AttributeOverride(name = "tempLaaDacCode", column = @Column(name = "TEMP_LAA_DAC_CODE", length = 500)) })
	public VbTempParametreLotId getId() {
		return this.id;
	}

	public void setId(VbTempParametreLotId id) {
		this.id = id;
	}

}
