package com.sndi.models;
// Generated 4 juil. 2020 18:05:44 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VbAffichageDaoId generated by hbm2java
 */
@Embeddable
public class VbAffichageDaoId implements java.io.Serializable {

	private long affDaoId;
	private BigDecimal affDcsNum;
	private String affDacCode;
	private String affOpeMatricule;
	private String affStaCode;
	private String affStatutRetour;

	public VbAffichageDaoId() {
	}

	public VbAffichageDaoId(long affDaoId, String affDacCode) {
		this.affDaoId = affDaoId;
		this.affDacCode = affDacCode;
	}

	public VbAffichageDaoId(long affDaoId, BigDecimal affDcsNum, String affDacCode, String affOpeMatricule,
			String affStaCode, String affStatutRetour) {
		this.affDaoId = affDaoId;
		this.affDcsNum = affDcsNum;
		this.affDacCode = affDacCode;
		this.affOpeMatricule = affOpeMatricule;
		this.affStaCode = affStaCode;
		this.affStatutRetour = affStatutRetour;
	}

	@Column(name = "AFF_DAO_ID", nullable = false, precision = 10, scale = 0)
	public long getAffDaoId() {
		return this.affDaoId;
	}

	public void setAffDaoId(long affDaoId) {
		this.affDaoId = affDaoId;
	}

	@Column(name = "AFF_DCS_NUM", precision = 22, scale = 0)
	public BigDecimal getAffDcsNum() {
		return this.affDcsNum;
	}

	public void setAffDcsNum(BigDecimal affDcsNum) {
		this.affDcsNum = affDcsNum;
	}

	@Column(name = "AFF_DAC_CODE", nullable = false, length = 20)
	public String getAffDacCode() {
		return this.affDacCode;
	}

	public void setAffDacCode(String affDacCode) {
		this.affDacCode = affDacCode;
	}

	@Column(name = "AFF_OPE_MATRICULE", length = 25)
	public String getAffOpeMatricule() {
		return this.affOpeMatricule;
	}

	public void setAffOpeMatricule(String affOpeMatricule) {
		this.affOpeMatricule = affOpeMatricule;
	}

	@Column(name = "AFF_STA_CODE", length = 3)
	public String getAffStaCode() {
		return this.affStaCode;
	}

	public void setAffStaCode(String affStaCode) {
		this.affStaCode = affStaCode;
	}

	@Column(name = "AFF_STATUT_RETOUR", length = 4)
	public String getAffStatutRetour() {
		return this.affStatutRetour;
	}

	public void setAffStatutRetour(String affStatutRetour) {
		this.affStatutRetour = affStatutRetour;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VbAffichageDaoId))
			return false;
		VbAffichageDaoId castOther = (VbAffichageDaoId) other;

		return (this.getAffDaoId() == castOther.getAffDaoId())
				&& ((this.getAffDcsNum() == castOther.getAffDcsNum()) || (this.getAffDcsNum() != null
						&& castOther.getAffDcsNum() != null && this.getAffDcsNum().equals(castOther.getAffDcsNum())))
				&& ((this.getAffDacCode() == castOther.getAffDacCode()) || (this.getAffDacCode() != null
						&& castOther.getAffDacCode() != null && this.getAffDacCode().equals(castOther.getAffDacCode())))
				&& ((this.getAffOpeMatricule() == castOther.getAffOpeMatricule())
						|| (this.getAffOpeMatricule() != null && castOther.getAffOpeMatricule() != null
								&& this.getAffOpeMatricule().equals(castOther.getAffOpeMatricule())))
				&& ((this.getAffStaCode() == castOther.getAffStaCode()) || (this.getAffStaCode() != null
						&& castOther.getAffStaCode() != null && this.getAffStaCode().equals(castOther.getAffStaCode())))
				&& ((this.getAffStatutRetour() == castOther.getAffStatutRetour())
						|| (this.getAffStatutRetour() != null && castOther.getAffStatutRetour() != null
								&& this.getAffStatutRetour().equals(castOther.getAffStatutRetour())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getAffDaoId();
		result = 37 * result + (getAffDcsNum() == null ? 0 : this.getAffDcsNum().hashCode());
		result = 37 * result + (getAffDacCode() == null ? 0 : this.getAffDacCode().hashCode());
		result = 37 * result + (getAffOpeMatricule() == null ? 0 : this.getAffOpeMatricule().hashCode());
		result = 37 * result + (getAffStaCode() == null ? 0 : this.getAffStaCode().hashCode());
		result = 37 * result + (getAffStatutRetour() == null ? 0 : this.getAffStatutRetour().hashCode());
		return result;
	}

}
