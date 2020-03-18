package com.sndi.model;
// Generated 30 nov. 2019 14:39:00 by Hibernate Tools 4.3.5.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TTypeCharge generated by hbm2java
 */
@Entity
@Table(name = "T_TYPE_CHARGE", schema = "EMAP")
public class TTypeCharge implements java.io.Serializable {

	private String tycCode;
	private String tycLibelleCourt;
	private String tycLibelleLong;
	private String tymTymCode;
	private String tymGroupe;
	private Set<TCharge> TCharges = new HashSet<TCharge>(0);

	public TTypeCharge() {
	}
	
	public TTypeCharge(String tycCode) {
		this.tycCode = tycCode;
	}

	public TTypeCharge(String tycCode, String tycLibelleCourt) {
		this.tycCode = tycCode;
		this.tycLibelleCourt = tycLibelleCourt;
	}

	public TTypeCharge(String tycCode, String tycLibelleCourt, String tycLibelleLong, String tymTymCode,
			String tymGroupe, Set<TCharge> TCharges) {
		this.tycCode = tycCode;
		this.tycLibelleCourt = tycLibelleCourt;
		this.tycLibelleLong = tycLibelleLong;
		this.tymTymCode = tymTymCode;
		this.tymGroupe = tymGroupe;
		this.TCharges = TCharges;
	}

	@Id
	@Column(name = "TYC_CODE", unique = true, nullable = false, length = 3)
	public String getTycCode() {
		return this.tycCode;
	}

	public void setTycCode(String tycCode) {
		this.tycCode = tycCode;
	}

	@Column(name = "TYC_LIBELLE_COURT", nullable = false, length = 500)
	public String getTycLibelleCourt() {
		return this.tycLibelleCourt;
	}

	public void setTycLibelleCourt(String tycLibelleCourt) {
		this.tycLibelleCourt = tycLibelleCourt;
	}

	@Column(name = "TYC_LIBELLE_LONG", length = 1000)
	public String getTycLibelleLong() {
		return this.tycLibelleLong;
	}

	public void setTycLibelleLong(String tycLibelleLong) {
		this.tycLibelleLong = tycLibelleLong;
	}

	@Column(name = "TYM_TYM_CODE", length = 3)
	public String getTymTymCode() {
		return this.tymTymCode;
	}

	public void setTymTymCode(String tymTymCode) {
		this.tymTymCode = tymTymCode;
	}

	@Column(name = "TYM_GROUPE", length = 3)
	public String getTymGroupe() {
		return this.tymGroupe;
	}

	public void setTymGroupe(String tymGroupe) {
		this.tymGroupe = tymGroupe;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TTypeCharge")
	public Set<TCharge> getTCharges() {
		return this.TCharges;
	}

	public void setTCharges(Set<TCharge> TCharges) {
		this.TCharges = TCharges;
	}

}
