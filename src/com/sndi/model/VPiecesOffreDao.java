package com.sndi.model;
// Generated 26 mars 2020 00:44:45 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

/**
 * VPiecesOffreDaoId generated by hbm2java
 */
@Entity
@Immutable
@Table(name = "V_PIECES_OFFRE_DAO")
public class VPiecesOffreDao implements java.io.Serializable {

	private BigDecimal opdNum;
	private String opdDacCode;
	private String opdTpoCode;
	private String odpTpoEtapPiece;
	private Date odpDteSaisi;
	private String odpOpeMatricule;

	public VPiecesOffreDao() {
	}

	public VPiecesOffreDao(BigDecimal opdNum) {
		this.opdNum = opdNum;
	}

	public VPiecesOffreDao(BigDecimal opdNum, String opdDacCode, String opdTpoCode, String odpTpoEtapPiece,
			Date odpDteSaisi, String odpOpeMatricule) {
		this.opdNum = opdNum;
		this.opdDacCode = opdDacCode;
		this.opdTpoCode = opdTpoCode;
		this.odpTpoEtapPiece = odpTpoEtapPiece;
		this.odpDteSaisi = odpDteSaisi;
		this.odpOpeMatricule = odpOpeMatricule;
	}

	
	@Id
	@Column(name = "OPD_NUM", nullable = false, precision = 22, scale = 0)
	public BigDecimal getOpdNum() {
		return this.opdNum;
	}

	public void setOpdNum(BigDecimal opdNum) {
		this.opdNum = opdNum;
	}

	@Column(name = "OPD_DAC_CODE", length = 25)
	public String getOpdDacCode() {
		return this.opdDacCode;
	}

	public void setOpdDacCode(String opdDacCode) {
		this.opdDacCode = opdDacCode;
	}

	@Column(name = "OPD_TPO_CODE", length = 10)
	public String getOpdTpoCode() {
		return this.opdTpoCode;
	}

	public void setOpdTpoCode(String opdTpoCode) {
		this.opdTpoCode = opdTpoCode;
	}

	@Column(name = "ODP_TPO_ETAP_PIECE", length = 20)
	public String getOdpTpoEtapPiece() {
		return this.odpTpoEtapPiece;
	}

	public void setOdpTpoEtapPiece(String odpTpoEtapPiece) {
		this.odpTpoEtapPiece = odpTpoEtapPiece;
	}

	@Column(name = "ODP_DTE_SAISI", length = 7)
	public Date getOdpDteSaisi() {
		return this.odpDteSaisi;
	}

	public void setOdpDteSaisi(Date odpDteSaisi) {
		this.odpDteSaisi = odpDteSaisi;
	}

	@Column(name = "ODP_OPE_MATRICULE", length = 25)
	public String getOdpOpeMatricule() {
		return this.odpOpeMatricule;
	}

	public void setOdpOpeMatricule(String odpOpeMatricule) {
		this.odpOpeMatricule = odpOpeMatricule;
	}


}
