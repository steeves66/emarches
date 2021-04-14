package com.sndi.model;
// Generated 7 avr. 2021 17:29:45 by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

/**
 * VDetailHistoDacId generated by hbm2java
 */
@Entity
@Immutable
@Table(name = "V_DETAIL_HISTO_DAC")
public class VDetailHistoDac implements java.io.Serializable {

	private String dacObjet;
	private String dacCode;
	private String staCode;
	private String staLibelleCourt;

	public VDetailHistoDac() {
	}

	public VDetailHistoDac(String dacCode, String staCode) {
		this.dacCode = dacCode;
		this.staCode = staCode;
	}

	public VDetailHistoDac(String dacObjet, String dacCode, String staCode, String staLibelleCourt) {
		this.dacObjet = dacObjet;
		this.dacCode = dacCode;
		this.staCode = staCode;
		this.staLibelleCourt = staLibelleCourt;
	}

	@Column(name = "DAC_OBJET", length = 1000)
	public String getDacObjet() {
		return this.dacObjet;
	}

	public void setDacObjet(String dacObjet) {
		this.dacObjet = dacObjet;
	}

	@Id
	@Column(name = "DAC_CODE", nullable = false, length = 20)
	public String getDacCode() {
		return this.dacCode;
	}

	public void setDacCode(String dacCode) {
		this.dacCode = dacCode;
	}

	@Column(name = "STA_CODE", nullable = false, length = 3)
	public String getStaCode() {
		return this.staCode;
	}

	public void setStaCode(String staCode) {
		this.staCode = staCode;
	}

	@Column(name = "STA_LIBELLE_COURT", length = 500)
	public String getStaLibelleCourt() {
		return this.staLibelleCourt;
	}

	public void setStaLibelleCourt(String staLibelleCourt) {
		this.staLibelleCourt = staLibelleCourt;
	}

}