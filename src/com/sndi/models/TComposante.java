package com.sndi.models;
// Generated 19 mars 2020 16:14:06 by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * TComposante generated by hbm2java
 */
@Entity
@Table(name = "T_COMPOSANTE", schema = "EMAP")
public class TComposante implements java.io.Serializable {

	private long comId;
	private TProjet TProjet;
	private String comCode;
	private String comLibelleCourt;
	private String comLibelleLong;

	public TComposante() {
	}

	public TComposante(long comId, String comLibelleCourt) {
		this.comId = comId;
		this.comLibelleCourt = comLibelleCourt;
	}

	public TComposante(long comId, TProjet TProjet, String comCode, String comLibelleCourt, String comLibelleLong) {
		this.comId = comId;
		this.TProjet = TProjet;
		this.comCode = comCode;
		this.comLibelleCourt = comLibelleCourt;
		this.comLibelleLong = comLibelleLong;
	}

	@Id

	@Column(name = "COM_ID", unique = true, nullable = false, precision = 10, scale = 0)
	public long getComId() {
		return this.comId;
	}

	public void setComId(long comId) {
		this.comId = comId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COM_PRO_ID")
	public TProjet getTProjet() {
		return this.TProjet;
	}

	public void setTProjet(TProjet TProjet) {
		this.TProjet = TProjet;
	}

	@Column(name = "COM_CODE", length = 50)
	public String getComCode() {
		return this.comCode;
	}

	public void setComCode(String comCode) {
		this.comCode = comCode;
	}

	@Column(name = "COM_LIBELLE_COURT", nullable = false, length = 500)
	public String getComLibelleCourt() {
		return this.comLibelleCourt;
	}

	public void setComLibelleCourt(String comLibelleCourt) {
		this.comLibelleCourt = comLibelleCourt;
	}

	@Column(name = "COM_LIBELLE_LONG", length = 1000)
	public String getComLibelleLong() {
		return this.comLibelleLong;
	}

	public void setComLibelleLong(String comLibelleLong) {
		this.comLibelleLong = comLibelleLong;
	}

}
