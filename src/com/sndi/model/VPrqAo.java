package com.sndi.model;
// Generated 16 d�c. 2020 17:06:41 by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

/**
 * VPrqAoId generated by hbm2java
 */
@Entity
@Immutable
@Table(name = "V_PRQ_AO")
public class VPrqAo implements java.io.Serializable {

	private long dppId;
	private String dppObjet;
	private String dppTypePlan;

	public VPrqAo() {
	}

	public VPrqAo(long dppId, String dppTypePlan) {
		this.dppId = dppId;
		this.dppTypePlan = dppTypePlan;
	}

	public VPrqAo(long dppId, String dppObjet, String dppTypePlan) {
		this.dppId = dppId;
		this.dppObjet = dppObjet;
		this.dppTypePlan = dppTypePlan;
	}

	@Id
	@Column(name = "DPP_ID", nullable = false, precision = 10, scale = 0)
	public long getDppId() {
		return this.dppId;
	}

	public void setDppId(long dppId) {
		this.dppId = dppId;
	}

	@Column(name = "DPP_OBJET", length = 1000)
	public String getDppObjet() {
		return this.dppObjet;
	}

	public void setDppObjet(String dppObjet) {
		this.dppObjet = dppObjet;
	}

	@Column(name = "DPP_TYPE_PLAN", nullable = false, length = 3)
	public String getDppTypePlan() {
		return this.dppTypePlan;
	}

	public void setDppTypePlan(String dppTypePlan) {
		this.dppTypePlan = dppTypePlan;
	}

}
