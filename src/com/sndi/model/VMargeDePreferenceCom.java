package com.sndi.model;
// Generated 28 sept. 2020 13:03:28 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

/**
 * VMargeDePreferenceCom generated by hbm2java
 */
@Entity
@Immutable
@Table(name = "V_MARGE_DE_PREFERENCE_COM")
public class VMargeDePreferenceCom implements java.io.Serializable {

	private BigDecimal id;
	private BigDecimal margePrefMinCom;
	private BigDecimal margePefMaxCom;
	private String margePefTextCom;
	private BigDecimal tauxMargePrefCom;

	public VMargeDePreferenceCom() {
	}

	public VMargeDePreferenceCom(BigDecimal id, BigDecimal margePrefMinCom, BigDecimal margePefMaxCom,
			String margePefTextCom, BigDecimal tauxMargePrefCom) {
		this.id = id;
		this.margePrefMinCom = margePrefMinCom;
		this.margePefMaxCom = margePefMaxCom;
		this.margePefTextCom = margePefTextCom;
		this.tauxMargePrefCom = tauxMargePrefCom;
	}

	
	@Id
	@Column(name = "ID", precision = 22, scale = 0)
	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	@Column(name = "MARGE_PREF_MIN_COM", precision = 22, scale = 0)
	public BigDecimal getMargePrefMinCom() {
		return this.margePrefMinCom;
	}

	public void setMargePrefMinCom(BigDecimal margePrefMinCom) {
		this.margePrefMinCom = margePrefMinCom;
	}

	@Column(name = "MARGE_PEF_MAX_COM", precision = 22, scale = 0)
	public BigDecimal getMargePefMaxCom() {
		return this.margePefMaxCom;
	}

	public void setMargePefMaxCom(BigDecimal margePefMaxCom) {
		this.margePefMaxCom = margePefMaxCom;
	}

	@Column(name = "MARGE_PEF_TEXT_COM", length = 4000)
	public String getMargePefTextCom() {
		return this.margePefTextCom;
	}

	public void setMargePefTextCom(String margePefTextCom) {
		this.margePefTextCom = margePefTextCom;
	}

	@Column(name = "TAUX_MARGE_PREF_COM", precision = 22, scale = 0)
	public BigDecimal getTauxMargePrefCom() {
		return this.tauxMargePrefCom;
	}

	public void setTauxMargePrefCom(BigDecimal tauxMargePrefCom) {
		this.tauxMargePrefCom = tauxMargePrefCom;
	}	

}
