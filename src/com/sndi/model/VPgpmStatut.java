package com.sndi.model;
// Generated 5 d�c. 2019 07:59:15 by Hibernate Tools 4.3.5.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

/**
 * VPgpmStatutId generated by hbm2java
 */
@Entity
@Immutable
@Table(name = "V_PGPM_STATUT")
public class VPgpmStatut implements java.io.Serializable {

	private long hpgId;
	private Date hpgDate;
	private String hpgMotif;
	private String hpgStaCode;
	private long hpgGpgId;
	private String hpgFonCod;
	private String fonLibelle;

	public VPgpmStatut() {
	}

	public VPgpmStatut(long hpgId, String hpgStaCode, long hpgGpgId, String hpgFonCod) {
		this.hpgId = hpgId;
		this.hpgStaCode = hpgStaCode;
		this.hpgGpgId = hpgGpgId;
		this.hpgFonCod = hpgFonCod;
	}

	public VPgpmStatut(long hpgId, Date hpgDate, String hpgMotif, String hpgStaCode, long hpgGpgId, String hpgFonCod,
			String fonLibelle) {
		this.hpgId = hpgId;
		this.hpgDate = hpgDate;
		this.hpgMotif = hpgMotif;
		this.hpgStaCode = hpgStaCode;
		this.hpgGpgId = hpgGpgId;
		this.hpgFonCod = hpgFonCod;
		this.fonLibelle = fonLibelle;
	}

	
	@Id
	@Column(name = "HPG_ID", nullable = false, precision = 10, scale = 0)
	public long getHpgId() {
		return this.hpgId;
	}

	public void setHpgId(long hpgId) {
		this.hpgId = hpgId;
	}

	@Column(name = "HPG_DATE", length = 7)
	public Date getHpgDate() {
		return this.hpgDate;
	}

	public void setHpgDate(Date hpgDate) {
		this.hpgDate = hpgDate;
	}

	@Column(name = "HPG_MOTIF", length = 1000)
	public String getHpgMotif() {
		return this.hpgMotif;
	}

	public void setHpgMotif(String hpgMotif) {
		this.hpgMotif = hpgMotif;
	}

	@Column(name = "HPG_STA_CODE", nullable = false, length = 3)
	public String getHpgStaCode() {
		return this.hpgStaCode;
	}

	public void setHpgStaCode(String hpgStaCode) {
		this.hpgStaCode = hpgStaCode;
	}

	@Column(name = "HPG_GPG_ID", nullable = false, precision = 10, scale = 0)
	public long getHpgGpgId() {
		return this.hpgGpgId;
	}

	public void setHpgGpgId(long hpgGpgId) {
		this.hpgGpgId = hpgGpgId;
	}

	@Column(name = "HPG_FON_COD", nullable = false, length = 12)
	public String getHpgFonCod() {
		return this.hpgFonCod;
	}

	public void setHpgFonCod(String hpgFonCod) {
		this.hpgFonCod = hpgFonCod;
	}

	@Column(name = "FON_LIBELLE", length = 240)
	public String getFonLibelle() {
		return this.fonLibelle;
	}

	public void setFonLibelle(String fonLibelle) {
		this.fonLibelle = fonLibelle;
	}

}
