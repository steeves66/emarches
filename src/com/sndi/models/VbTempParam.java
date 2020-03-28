package com.sndi.models;
// Generated 28 mars 2020 03:24:07 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VbTempParam generated by hbm2java
 */
@Entity
@Table(name = "VB_TEMP_PARAM", schema = "EMAP")
public class VbTempParam implements java.io.Serializable {

	private VbTempParamId id;

	public VbTempParam() {
	}

	public VbTempParam(VbTempParamId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "tempNum2", column = @Column(name = "TEMP_NUM2", nullable = false, precision = 22, scale = 0)),
			@AttributeOverride(name = "tempType", column = @Column(name = "TEMP_TYPE", length = 500)),
			@AttributeOverride(name = "tempOpeMatricule", column = @Column(name = "TEMP_OPE_MATRICULE", length = 500)),
			@AttributeOverride(name = "tempDteSaisi", column = @Column(name = "TEMP_DTE_SAISI", length = 7)),
			@AttributeOverride(name = "tempChamp01", column = @Column(name = "TEMP_CHAMP_01", length = 500)),
			@AttributeOverride(name = "tempChamp02", column = @Column(name = "TEMP_CHAMP_02", length = 500)),
			@AttributeOverride(name = "tempChamp03", column = @Column(name = "TEMP_CHAMP_03", length = 500)),
			@AttributeOverride(name = "tempChamp04", column = @Column(name = "TEMP_CHAMP_04", length = 500)),
			@AttributeOverride(name = "tempChamp05", column = @Column(name = "TEMP_CHAMP_05", length = 500)),
			@AttributeOverride(name = "tempChamp06", column = @Column(name = "TEMP_CHAMP_06", length = 500)),
			@AttributeOverride(name = "tempChamp07", column = @Column(name = "TEMP_CHAMP_07", length = 500)),
			@AttributeOverride(name = "tempChamp08", column = @Column(name = "TEMP_CHAMP_08", length = 500)),
			@AttributeOverride(name = "tempChamp09", column = @Column(name = "TEMP_CHAMP_09", length = 500)),
			@AttributeOverride(name = "tempChamp10", column = @Column(name = "TEMP_CHAMP_10", length = 500)),
			@AttributeOverride(name = "tempChamp11", column = @Column(name = "TEMP_CHAMP_11", length = 500)),
			@AttributeOverride(name = "tempChamp12", column = @Column(name = "TEMP_CHAMP_12", length = 500)),
			@AttributeOverride(name = "tempChamp13", column = @Column(name = "TEMP_CHAMP_13", length = 500)),
			@AttributeOverride(name = "tempChamp14", column = @Column(name = "TEMP_CHAMP_14", length = 500)),
			@AttributeOverride(name = "tempChamp15", column = @Column(name = "TEMP_CHAMP_15", length = 500)),
			@AttributeOverride(name = "tempChamp16", column = @Column(name = "TEMP_CHAMP_16", length = 500)),
			@AttributeOverride(name = "tempChamp17", column = @Column(name = "TEMP_CHAMP_17", length = 500)),
			@AttributeOverride(name = "tempChamp18", column = @Column(name = "TEMP_CHAMP_18", length = 500)),
			@AttributeOverride(name = "tempChamp19", column = @Column(name = "TEMP_CHAMP_19", length = 500)),
			@AttributeOverride(name = "tempChamp20", column = @Column(name = "TEMP_CHAMP_20", length = 500)) })
	public VbTempParamId getId() {
		return this.id;
	}

	public void setId(VbTempParamId id) {
		this.id = id;
	}

}
