package com.sndi.model;
// Generated 26 f?vr. 2020 14:01:06 by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

/**
 * VModePassationPn generated by hbm2java
 */
@Entity
@Immutable
@Table(name = "V_MODE_PASSATION_PN")
public class VModePassationPn implements java.io.Serializable {

	private String mopCode;
	private String mopLibelleCourt;
	private String mopLibelleLong;
	private String mopTypPlan;
	private String critere;

	public VModePassationPn() {
	}

	public VModePassationPn(String mopCode, String mopLibelleCourt) {
		this.mopCode = mopCode;
		this.mopLibelleCourt = mopLibelleCourt;
	}

	public VModePassationPn(String mopCode, String mopLibelleCourt, String mopLibelleLong, String mopTypPlan,String critere) {
		this.mopCode = mopCode;
		this.mopLibelleCourt = mopLibelleCourt;
		this.mopLibelleLong = mopLibelleLong;
		this.mopTypPlan = mopTypPlan;
		this.critere = critere;
	}

	
	
	@Id
	@Column(name = "MOP_CODE", nullable = false, length = 3)
	public String getMopCode() {
		return this.mopCode;
	}

	public void setMopCode(String mopCode) {
		this.mopCode = mopCode;
	}

	@Column(name = "MOP_LIBELLE_COURT", nullable = false, length = 500)
	public String getMopLibelleCourt() {
		return this.mopLibelleCourt;
	}

	public void setMopLibelleCourt(String mopLibelleCourt) {
		this.mopLibelleCourt = mopLibelleCourt;
	}

	@Column(name = "MOP_LIBELLE_LONG", length = 1000)
	public String getMopLibelleLong() {
		return this.mopLibelleLong;
	}

	public void setMopLibelleLong(String mopLibelleLong) {
		this.mopLibelleLong = mopLibelleLong;
	}
	
	
	@Column(name = "MOP_TYP_PLAN", length = 10)
	public String getMopTypPlan() {
		return this.mopTypPlan;
	}

	public void setMopTypPlan(String mopTypPlan) {
		this.mopTypPlan = mopTypPlan;
	}
	
	@Column(name = "CRITERE")
	public String getCritere() {
		return this.critere;
	}

	public void setCritere(String critere) {
		this.critere = critere;
	}

}
