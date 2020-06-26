package com.sndi.models;
// Generated 25 juin 2020 13:53:46 by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * TObjectifSpec generated by hbm2java
 */
@Entity
@Table(name = "T_OBJECTIF_SPEC", schema = "EMAP")
public class TObjectifSpec implements java.io.Serializable {

	private long obsId;
	private TObjectifGen TObjectifGen;
	private String obsCode;
	private String obsLibelleCourt;
	private String obsLibelleLong;

	public TObjectifSpec() {
	}

	public TObjectifSpec(long obsId) {
		this.obsId = obsId;
	}

	public TObjectifSpec(long obsId, TObjectifGen TObjectifGen, String obsCode, String obsLibelleCourt,
			String obsLibelleLong) {
		this.obsId = obsId;
		this.TObjectifGen = TObjectifGen;
		this.obsCode = obsCode;
		this.obsLibelleCourt = obsLibelleCourt;
		this.obsLibelleLong = obsLibelleLong;
	}

	@Id

	@Column(name = "OBS_ID", unique = true, nullable = false, precision = 10, scale = 0)
	public long getObsId() {
		return this.obsId;
	}

	public void setObsId(long obsId) {
		this.obsId = obsId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OBS_OBG_ID")
	public TObjectifGen getTObjectifGen() {
		return this.TObjectifGen;
	}

	public void setTObjectifGen(TObjectifGen TObjectifGen) {
		this.TObjectifGen = TObjectifGen;
	}

	@Column(name = "OBS_CODE", length = 10)
	public String getObsCode() {
		return this.obsCode;
	}

	public void setObsCode(String obsCode) {
		this.obsCode = obsCode;
	}

	@Column(name = "OBS_LIBELLE_COURT", length = 500)
	public String getObsLibelleCourt() {
		return this.obsLibelleCourt;
	}

	public void setObsLibelleCourt(String obsLibelleCourt) {
		this.obsLibelleCourt = obsLibelleCourt;
	}

	@Column(name = "OBS_LIBELLE_LONG", length = 1000)
	public String getObsLibelleLong() {
		return this.obsLibelleLong;
	}

	public void setObsLibelleLong(String obsLibelleLong) {
		this.obsLibelleLong = obsLibelleLong;
	}

}