package com.sndi.model;
// Generated 14 f?vr. 2020 12:10:21 by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

/**
 * VTypeMarcheFils generated by hbm2java
 */
@Entity
@Immutable
@Table(name = "V_TYPE_MARCHE_FILS")
public class VTypeMarcheFils implements java.io.Serializable {

	private String tymCode;
	private String tymLibelleCourt;
	private String tymLibelleLong;
	private String tymTymCode;
	private String critere;

	public VTypeMarcheFils() {
	}

	public VTypeMarcheFils(String tymCode) {
		this.tymCode = tymCode;
	}

	public VTypeMarcheFils(String tymCode,String tymLibelleCourt, String tymLibelleLong, String tymTymCode,String critere) {
		this.tymCode = tymCode;
		this.tymLibelleCourt = tymLibelleCourt;
		this.tymLibelleLong = tymLibelleLong;
		this.tymTymCode = tymTymCode;
		this.critere = critere;
	}

	@Id
	@Column(name = "TYM_CODE", nullable = false, length = 3)
	public String getTymCode() {
		return this.tymCode;
	}

	public void setTymCode(String tymCode) {
		this.tymCode = tymCode;
	}
	
	@Column(name = "TYM_LIBELLE_COURT", nullable = false, length = 500)
	public String getTymLibelleCourt() {
		return this.tymLibelleCourt;
	}

	public void setTymLibelleCourt(String tymLibelleCourt) {
		this.tymLibelleCourt = tymLibelleCourt;
	}

	@Column(name = "TYM_LIBELLE_LONG", length = 1000)
	public String getTymLibelleLong() {
		return this.tymLibelleLong;
	}

	public void setTymLibelleLong(String tymLibelleLong) {
		this.tymLibelleLong = tymLibelleLong;
	}

	@Column(name = "TYM_TYM_CODE", length = 3)
	public String getTymTymCode() {
		return this.tymTymCode;
	}

	public void setTymTymCode(String tymTymCode) {
		this.tymTymCode = tymTymCode;
	}
	
	@Column(name = "CRITERE")
	public String getCritere() {
		return this.critere;
	}

	public void setCritere(String critere) {
		this.critere = critere;
	}

}
