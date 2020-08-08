package com.sndi.models;
// Generated 8 ao�t 2020 14:11:26 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VPiecesOffreAnalyseId generated by hbm2java
 */
@Embeddable
public class VPiecesOffreAnalyseId implements java.io.Serializable {

	private BigDecimal pofNum;
	private BigDecimal pofDofNum;
	private String tpoCode;
	private BigDecimal pofLaaId;
	private String tpoLibelle;
	private String pofConforme;
	private String pofObs;

	public VPiecesOffreAnalyseId() {
	}

	public VPiecesOffreAnalyseId(BigDecimal pofNum, String tpoCode) {
		this.pofNum = pofNum;
		this.tpoCode = tpoCode;
	}

	public VPiecesOffreAnalyseId(BigDecimal pofNum, BigDecimal pofDofNum, String tpoCode, BigDecimal pofLaaId,
			String tpoLibelle, String pofConforme, String pofObs) {
		this.pofNum = pofNum;
		this.pofDofNum = pofDofNum;
		this.tpoCode = tpoCode;
		this.pofLaaId = pofLaaId;
		this.tpoLibelle = tpoLibelle;
		this.pofConforme = pofConforme;
		this.pofObs = pofObs;
	}

	@Column(name = "POF_NUM", nullable = false, precision = 22, scale = 0)
	public BigDecimal getPofNum() {
		return this.pofNum;
	}

	public void setPofNum(BigDecimal pofNum) {
		this.pofNum = pofNum;
	}

	@Column(name = "POF_DOF_NUM", precision = 22, scale = 0)
	public BigDecimal getPofDofNum() {
		return this.pofDofNum;
	}

	public void setPofDofNum(BigDecimal pofDofNum) {
		this.pofDofNum = pofDofNum;
	}

	@Column(name = "TPO_CODE", nullable = false, length = 10)
	public String getTpoCode() {
		return this.tpoCode;
	}

	public void setTpoCode(String tpoCode) {
		this.tpoCode = tpoCode;
	}

	@Column(name = "POF_LAA_ID", precision = 22, scale = 0)
	public BigDecimal getPofLaaId() {
		return this.pofLaaId;
	}

	public void setPofLaaId(BigDecimal pofLaaId) {
		this.pofLaaId = pofLaaId;
	}

	@Column(name = "TPO_LIBELLE", length = 200)
	public String getTpoLibelle() {
		return this.tpoLibelle;
	}

	public void setTpoLibelle(String tpoLibelle) {
		this.tpoLibelle = tpoLibelle;
	}

	@Column(name = "POF_CONFORME", length = 1)
	public String getPofConforme() {
		return this.pofConforme;
	}

	public void setPofConforme(String pofConforme) {
		this.pofConforme = pofConforme;
	}

	@Column(name = "POF_OBS", length = 500)
	public String getPofObs() {
		return this.pofObs;
	}

	public void setPofObs(String pofObs) {
		this.pofObs = pofObs;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VPiecesOffreAnalyseId))
			return false;
		VPiecesOffreAnalyseId castOther = (VPiecesOffreAnalyseId) other;

		return ((this.getPofNum() == castOther.getPofNum()) || (this.getPofNum() != null
				&& castOther.getPofNum() != null && this.getPofNum().equals(castOther.getPofNum())))
				&& ((this.getPofDofNum() == castOther.getPofDofNum()) || (this.getPofDofNum() != null
						&& castOther.getPofDofNum() != null && this.getPofDofNum().equals(castOther.getPofDofNum())))
				&& ((this.getTpoCode() == castOther.getTpoCode()) || (this.getTpoCode() != null
						&& castOther.getTpoCode() != null && this.getTpoCode().equals(castOther.getTpoCode())))
				&& ((this.getPofLaaId() == castOther.getPofLaaId()) || (this.getPofLaaId() != null
						&& castOther.getPofLaaId() != null && this.getPofLaaId().equals(castOther.getPofLaaId())))
				&& ((this.getTpoLibelle() == castOther.getTpoLibelle()) || (this.getTpoLibelle() != null
						&& castOther.getTpoLibelle() != null && this.getTpoLibelle().equals(castOther.getTpoLibelle())))
				&& ((this.getPofConforme() == castOther.getPofConforme())
						|| (this.getPofConforme() != null && castOther.getPofConforme() != null
								&& this.getPofConforme().equals(castOther.getPofConforme())))
				&& ((this.getPofObs() == castOther.getPofObs()) || (this.getPofObs() != null
						&& castOther.getPofObs() != null && this.getPofObs().equals(castOther.getPofObs())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getPofNum() == null ? 0 : this.getPofNum().hashCode());
		result = 37 * result + (getPofDofNum() == null ? 0 : this.getPofDofNum().hashCode());
		result = 37 * result + (getTpoCode() == null ? 0 : this.getTpoCode().hashCode());
		result = 37 * result + (getPofLaaId() == null ? 0 : this.getPofLaaId().hashCode());
		result = 37 * result + (getTpoLibelle() == null ? 0 : this.getTpoLibelle().hashCode());
		result = 37 * result + (getPofConforme() == null ? 0 : this.getPofConforme().hashCode());
		result = 37 * result + (getPofObs() == null ? 0 : this.getPofObs().hashCode());
		return result;
	}

}
