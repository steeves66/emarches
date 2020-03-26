package com.sndi.models;
// Generated 26 mars 2020 03:50:59 by Hibernate Tools 4.3.5.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TTypeProcedure generated by hbm2java
 */
@Entity
@Table(name = "T_TYPE_PROCEDURE", schema = "EMAP")
public class TTypeProcedure implements java.io.Serializable {

	private String typId;
	private String typLib;
	private Set<TAffichagePpm> TAffichagePpms = new HashSet<TAffichagePpm>(0);
	private Set<TDetailPlanPassation> TDetailPlanPassations = new HashSet<TDetailPlanPassation>(0);

	public TTypeProcedure() {
	}

	public TTypeProcedure(String typId) {
		this.typId = typId;
	}

	public TTypeProcedure(String typId, String typLib, Set<TAffichagePpm> TAffichagePpms,
			Set<TDetailPlanPassation> TDetailPlanPassations) {
		this.typId = typId;
		this.typLib = typLib;
		this.TAffichagePpms = TAffichagePpms;
		this.TDetailPlanPassations = TDetailPlanPassations;
	}

	@Id

	@Column(name = "TYP_ID", unique = true, nullable = false, length = 5)
	public String getTypId() {
		return this.typId;
	}

	public void setTypId(String typId) {
		this.typId = typId;
	}

	@Column(name = "TYP_LIB", length = 1000)
	public String getTypLib() {
		return this.typLib;
	}

	public void setTypLib(String typLib) {
		this.typLib = typLib;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TTypeProcedure")
	public Set<TAffichagePpm> getTAffichagePpms() {
		return this.TAffichagePpms;
	}

	public void setTAffichagePpms(Set<TAffichagePpm> TAffichagePpms) {
		this.TAffichagePpms = TAffichagePpms;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TTypeProcedure")
	public Set<TDetailPlanPassation> getTDetailPlanPassations() {
		return this.TDetailPlanPassations;
	}

	public void setTDetailPlanPassations(Set<TDetailPlanPassation> TDetailPlanPassations) {
		this.TDetailPlanPassations = TDetailPlanPassations;
	}

}
