package com.sndi.models;
// Generated 20 juin 2020 17:16:02 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VDetailOffresId generated by hbm2java
 */
@Embeddable
public class VDetailOffresId implements java.io.Serializable {

	private BigDecimal dofNum;
	private BigDecimal laaNum;
	private String laaObjet;
	private BigDecimal dofLaaId;
	private String aaoCode;
	private String offSouSigleSte;
	private BigDecimal dofMtOfr;
	private String dofTyp;
	private String dofStatut;

	public VDetailOffresId() {
	}

	public VDetailOffresId(BigDecimal dofNum, BigDecimal dofLaaId, String aaoCode) {
		this.dofNum = dofNum;
		this.dofLaaId = dofLaaId;
		this.aaoCode = aaoCode;
	}

	public VDetailOffresId(BigDecimal dofNum, BigDecimal laaNum, String laaObjet, BigDecimal dofLaaId, String aaoCode,
			String offSouSigleSte, BigDecimal dofMtOfr, String dofTyp, String dofStatut) {
		this.dofNum = dofNum;
		this.laaNum = laaNum;
		this.laaObjet = laaObjet;
		this.dofLaaId = dofLaaId;
		this.aaoCode = aaoCode;
		this.offSouSigleSte = offSouSigleSte;
		this.dofMtOfr = dofMtOfr;
		this.dofTyp = dofTyp;
		this.dofStatut = dofStatut;
	}

	@Column(name = "DOF_NUM", nullable = false, precision = 22, scale = 0)
	public BigDecimal getDofNum() {
		return this.dofNum;
	}

	public void setDofNum(BigDecimal dofNum) {
		this.dofNum = dofNum;
	}

	@Column(name = "LAA_NUM", precision = 22, scale = 0)
	public BigDecimal getLaaNum() {
		return this.laaNum;
	}

	public void setLaaNum(BigDecimal laaNum) {
		this.laaNum = laaNum;
	}

	@Column(name = "LAA_OBJET", length = 1000)
	public String getLaaObjet() {
		return this.laaObjet;
	}

	public void setLaaObjet(String laaObjet) {
		this.laaObjet = laaObjet;
	}

	@Column(name = "DOF_LAA_ID", nullable = false, precision = 22, scale = 0)
	public BigDecimal getDofLaaId() {
		return this.dofLaaId;
	}

	public void setDofLaaId(BigDecimal dofLaaId) {
		this.dofLaaId = dofLaaId;
	}

	@Column(name = "AAO_CODE", nullable = false, length = 20)
	public String getAaoCode() {
		return this.aaoCode;
	}

	public void setAaoCode(String aaoCode) {
		this.aaoCode = aaoCode;
	}

	@Column(name = "OFF_SOU_SIGLE_STE", length = 500)
	public String getOffSouSigleSte() {
		return this.offSouSigleSte;
	}

	public void setOffSouSigleSte(String offSouSigleSte) {
		this.offSouSigleSte = offSouSigleSte;
	}

	@Column(name = "DOF_MT_OFR", precision = 20, scale = 0)
	public BigDecimal getDofMtOfr() {
		return this.dofMtOfr;
	}

	public void setDofMtOfr(BigDecimal dofMtOfr) {
		this.dofMtOfr = dofMtOfr;
	}

	@Column(name = "DOF_TYP", length = 1)
	public String getDofTyp() {
		return this.dofTyp;
	}

	public void setDofTyp(String dofTyp) {
		this.dofTyp = dofTyp;
	}

	@Column(name = "DOF_STATUT", length = 1)
	public String getDofStatut() {
		return this.dofStatut;
	}

	public void setDofStatut(String dofStatut) {
		this.dofStatut = dofStatut;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VDetailOffresId))
			return false;
		VDetailOffresId castOther = (VDetailOffresId) other;

		return ((this.getDofNum() == castOther.getDofNum()) || (this.getDofNum() != null
				&& castOther.getDofNum() != null && this.getDofNum().equals(castOther.getDofNum())))
				&& ((this.getLaaNum() == castOther.getLaaNum()) || (this.getLaaNum() != null
						&& castOther.getLaaNum() != null && this.getLaaNum().equals(castOther.getLaaNum())))
				&& ((this.getLaaObjet() == castOther.getLaaObjet()) || (this.getLaaObjet() != null
						&& castOther.getLaaObjet() != null && this.getLaaObjet().equals(castOther.getLaaObjet())))
				&& ((this.getDofLaaId() == castOther.getDofLaaId()) || (this.getDofLaaId() != null
						&& castOther.getDofLaaId() != null && this.getDofLaaId().equals(castOther.getDofLaaId())))
				&& ((this.getAaoCode() == castOther.getAaoCode()) || (this.getAaoCode() != null
						&& castOther.getAaoCode() != null && this.getAaoCode().equals(castOther.getAaoCode())))
				&& ((this.getOffSouSigleSte() == castOther.getOffSouSigleSte())
						|| (this.getOffSouSigleSte() != null && castOther.getOffSouSigleSte() != null
								&& this.getOffSouSigleSte().equals(castOther.getOffSouSigleSte())))
				&& ((this.getDofMtOfr() == castOther.getDofMtOfr()) || (this.getDofMtOfr() != null
						&& castOther.getDofMtOfr() != null && this.getDofMtOfr().equals(castOther.getDofMtOfr())))
				&& ((this.getDofTyp() == castOther.getDofTyp()) || (this.getDofTyp() != null
						&& castOther.getDofTyp() != null && this.getDofTyp().equals(castOther.getDofTyp())))
				&& ((this.getDofStatut() == castOther.getDofStatut()) || (this.getDofStatut() != null
						&& castOther.getDofStatut() != null && this.getDofStatut().equals(castOther.getDofStatut())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getDofNum() == null ? 0 : this.getDofNum().hashCode());
		result = 37 * result + (getLaaNum() == null ? 0 : this.getLaaNum().hashCode());
		result = 37 * result + (getLaaObjet() == null ? 0 : this.getLaaObjet().hashCode());
		result = 37 * result + (getDofLaaId() == null ? 0 : this.getDofLaaId().hashCode());
		result = 37 * result + (getAaoCode() == null ? 0 : this.getAaoCode().hashCode());
		result = 37 * result + (getOffSouSigleSte() == null ? 0 : this.getOffSouSigleSte().hashCode());
		result = 37 * result + (getDofMtOfr() == null ? 0 : this.getDofMtOfr().hashCode());
		result = 37 * result + (getDofTyp() == null ? 0 : this.getDofTyp().hashCode());
		result = 37 * result + (getDofStatut() == null ? 0 : this.getDofStatut().hashCode());
		return result;
	}

}
