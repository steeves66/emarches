package com.sndi.models;
// Generated 4 avr. 2020 18:03:14 by Hibernate Tools 4.3.5.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * TMotdepasse generated by hbm2java
 */
@Entity
@Table(name = "T_MOTDEPASSE", schema = "EMAP")
public class TMotdepasse implements java.io.Serializable {

	private long mdpId;
	private TOperateur TOperateur;
	private String mdpMotdepasse;
	private Boolean mdpStatut;
	private Date mdpDate;

	public TMotdepasse() {
	}

	public TMotdepasse(long mdpId) {
		this.mdpId = mdpId;
	}

	public TMotdepasse(long mdpId, TOperateur TOperateur, String mdpMotdepasse, Boolean mdpStatut, Date mdpDate) {
		this.mdpId = mdpId;
		this.TOperateur = TOperateur;
		this.mdpMotdepasse = mdpMotdepasse;
		this.mdpStatut = mdpStatut;
		this.mdpDate = mdpDate;
	}

	@Id

	@Column(name = "MDP_ID", unique = true, nullable = false, precision = 10, scale = 0)
	public long getMdpId() {
		return this.mdpId;
	}

	public void setMdpId(long mdpId) {
		this.mdpId = mdpId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MDP_OPE_MATRICULE")
	public TOperateur getTOperateur() {
		return this.TOperateur;
	}

	public void setTOperateur(TOperateur TOperateur) {
		this.TOperateur = TOperateur;
	}

	@Column(name = "MDP_MOTDEPASSE", length = 250)
	public String getMdpMotdepasse() {
		return this.mdpMotdepasse;
	}

	public void setMdpMotdepasse(String mdpMotdepasse) {
		this.mdpMotdepasse = mdpMotdepasse;
	}

	@Column(name = "MDP_STATUT", precision = 1, scale = 0)
	public Boolean getMdpStatut() {
		return this.mdpStatut;
	}

	public void setMdpStatut(Boolean mdpStatut) {
		this.mdpStatut = mdpStatut;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "MDP_DATE", length = 7)
	public Date getMdpDate() {
		return this.mdpDate;
	}

	public void setMdpDate(Date mdpDate) {
		this.mdpDate = mdpDate;
	}

}
