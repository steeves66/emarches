package com.sndi.models;
// Generated 22 mars 2020 01:52:15 by Hibernate Tools 4.3.5.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TObjectifGen generated by hbm2java
 */
@Entity
@Table(name = "T_OBJECTIF_GEN", schema = "EMAP")
public class TObjectifGen implements java.io.Serializable {

	private long obgId;
	private TProjet TProjet;
	private String obgCode;
	private String obgLibelleCourt;
	private String obgLibelleLong;
	private Set<TObjectifSpec> TObjectifSpecs = new HashSet<TObjectifSpec>(0);

	public TObjectifGen() {
	}

	public TObjectifGen(long obgId) {
		this.obgId = obgId;
	}

	public TObjectifGen(long obgId, TProjet TProjet, String obgCode, String obgLibelleCourt, String obgLibelleLong,
			Set<TObjectifSpec> TObjectifSpecs) {
		this.obgId = obgId;
		this.TProjet = TProjet;
		this.obgCode = obgCode;
		this.obgLibelleCourt = obgLibelleCourt;
		this.obgLibelleLong = obgLibelleLong;
		this.TObjectifSpecs = TObjectifSpecs;
	}

	@Id

	@Column(name = "OBG_ID", unique = true, nullable = false, precision = 10, scale = 0)
	public long getObgId() {
		return this.obgId;
	}

	public void setObgId(long obgId) {
		this.obgId = obgId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OBG_PRO_ID")
	public TProjet getTProjet() {
		return this.TProjet;
	}

	public void setTProjet(TProjet TProjet) {
		this.TProjet = TProjet;
	}

	@Column(name = "OBG_CODE", length = 10)
	public String getObgCode() {
		return this.obgCode;
	}

	public void setObgCode(String obgCode) {
		this.obgCode = obgCode;
	}

	@Column(name = "OBG_LIBELLE_COURT", length = 500)
	public String getObgLibelleCourt() {
		return this.obgLibelleCourt;
	}

	public void setObgLibelleCourt(String obgLibelleCourt) {
		this.obgLibelleCourt = obgLibelleCourt;
	}

	@Column(name = "OBG_LIBELLE_LONG", length = 1000)
	public String getObgLibelleLong() {
		return this.obgLibelleLong;
	}

	public void setObgLibelleLong(String obgLibelleLong) {
		this.obgLibelleLong = obgLibelleLong;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TObjectifGen")
	public Set<TObjectifSpec> getTObjectifSpecs() {
		return this.TObjectifSpecs;
	}

	public void setTObjectifSpecs(Set<TObjectifSpec> TObjectifSpecs) {
		this.TObjectifSpecs = TObjectifSpecs;
	}

}
