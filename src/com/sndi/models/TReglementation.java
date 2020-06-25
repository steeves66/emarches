package com.sndi.models;
// Generated 25 juin 2020 13:53:46 by Hibernate Tools 4.3.5.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TReglementation generated by hbm2java
 */
@Entity
@Table(name = "T_REGLEMENTATION", schema = "EMAP")
public class TReglementation implements java.io.Serializable {

	private long regId;
	private String regLibelleCourt;
	private String regLibelleLong;
	private Set<TProjet> TProjets = new HashSet<TProjet>(0);
	private Set<TBesoin> TBesoins = new HashSet<TBesoin>(0);

	public TReglementation() {
	}

	public TReglementation(long regId) {
		this.regId = regId;
	}

	public TReglementation(long regId, String regLibelleCourt, String regLibelleLong, Set<TProjet> TProjets,
			Set<TBesoin> TBesoins) {
		this.regId = regId;
		this.regLibelleCourt = regLibelleCourt;
		this.regLibelleLong = regLibelleLong;
		this.TProjets = TProjets;
		this.TBesoins = TBesoins;
	}

	@Id

	@Column(name = "REG_ID", unique = true, nullable = false, precision = 10, scale = 0)
	public long getRegId() {
		return this.regId;
	}

	public void setRegId(long regId) {
		this.regId = regId;
	}

	@Column(name = "REG_LIBELLE_COURT", length = 500)
	public String getRegLibelleCourt() {
		return this.regLibelleCourt;
	}

	public void setRegLibelleCourt(String regLibelleCourt) {
		this.regLibelleCourt = regLibelleCourt;
	}

	@Column(name = "REG_LIBELLE_LONG", length = 1000)
	public String getRegLibelleLong() {
		return this.regLibelleLong;
	}

	public void setRegLibelleLong(String regLibelleLong) {
		this.regLibelleLong = regLibelleLong;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TReglementation")
	public Set<TProjet> getTProjets() {
		return this.TProjets;
	}

	public void setTProjets(Set<TProjet> TProjets) {
		this.TProjets = TProjets;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TReglementation")
	public Set<TBesoin> getTBesoins() {
		return this.TBesoins;
	}

	public void setTBesoins(Set<TBesoin> TBesoins) {
		this.TBesoins = TBesoins;
	}

}
