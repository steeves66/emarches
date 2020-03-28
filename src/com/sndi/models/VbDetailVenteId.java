package com.sndi.models;
// Generated 28 mars 2020 03:24:07 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VbDetailVenteId generated by hbm2java
 */
@Embeddable
public class VbDetailVenteId implements java.io.Serializable {

	private long dveNum;
	private String dveDacCode;
	private byte dveVenNum;
	private BigDecimal dveLaaNum;
	private String dveQte;
	private String dveCout;

	public VbDetailVenteId() {
	}

	public VbDetailVenteId(long dveNum, String dveDacCode, byte dveVenNum, BigDecimal dveLaaNum) {
		this.dveNum = dveNum;
		this.dveDacCode = dveDacCode;
		this.dveVenNum = dveVenNum;
		this.dveLaaNum = dveLaaNum;
	}

	public VbDetailVenteId(long dveNum, String dveDacCode, byte dveVenNum, BigDecimal dveLaaNum, String dveQte,
			String dveCout) {
		this.dveNum = dveNum;
		this.dveDacCode = dveDacCode;
		this.dveVenNum = dveVenNum;
		this.dveLaaNum = dveLaaNum;
		this.dveQte = dveQte;
		this.dveCout = dveCout;
	}

	@Column(name = "DVE_NUM", nullable = false, precision = 10, scale = 0)
	public long getDveNum() {
		return this.dveNum;
	}

	public void setDveNum(long dveNum) {
		this.dveNum = dveNum;
	}

	@Column(name = "DVE_DAC_CODE", nullable = false, length = 20)
	public String getDveDacCode() {
		return this.dveDacCode;
	}

	public void setDveDacCode(String dveDacCode) {
		this.dveDacCode = dveDacCode;
	}

	@Column(name = "DVE_VEN_NUM", nullable = false, precision = 2, scale = 0)
	public byte getDveVenNum() {
		return this.dveVenNum;
	}

	public void setDveVenNum(byte dveVenNum) {
		this.dveVenNum = dveVenNum;
	}

	@Column(name = "DVE_LAA_NUM", nullable = false, precision = 20, scale = 0)
	public BigDecimal getDveLaaNum() {
		return this.dveLaaNum;
	}

	public void setDveLaaNum(BigDecimal dveLaaNum) {
		this.dveLaaNum = dveLaaNum;
	}

	@Column(name = "DVE_QTE", length = 3)
	public String getDveQte() {
		return this.dveQte;
	}

	public void setDveQte(String dveQte) {
		this.dveQte = dveQte;
	}

	@Column(name = "DVE_COUT", length = 20)
	public String getDveCout() {
		return this.dveCout;
	}

	public void setDveCout(String dveCout) {
		this.dveCout = dveCout;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VbDetailVenteId))
			return false;
		VbDetailVenteId castOther = (VbDetailVenteId) other;

		return (this.getDveNum() == castOther.getDveNum())
				&& ((this.getDveDacCode() == castOther.getDveDacCode()) || (this.getDveDacCode() != null
						&& castOther.getDveDacCode() != null && this.getDveDacCode().equals(castOther.getDveDacCode())))
				&& (this.getDveVenNum() == castOther.getDveVenNum())
				&& ((this.getDveLaaNum() == castOther.getDveLaaNum()) || (this.getDveLaaNum() != null
						&& castOther.getDveLaaNum() != null && this.getDveLaaNum().equals(castOther.getDveLaaNum())))
				&& ((this.getDveQte() == castOther.getDveQte()) || (this.getDveQte() != null
						&& castOther.getDveQte() != null && this.getDveQte().equals(castOther.getDveQte())))
				&& ((this.getDveCout() == castOther.getDveCout()) || (this.getDveCout() != null
						&& castOther.getDveCout() != null && this.getDveCout().equals(castOther.getDveCout())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getDveNum();
		result = 37 * result + (getDveDacCode() == null ? 0 : this.getDveDacCode().hashCode());
		result = 37 * result + this.getDveVenNum();
		result = 37 * result + (getDveLaaNum() == null ? 0 : this.getDveLaaNum().hashCode());
		result = 37 * result + (getDveQte() == null ? 0 : this.getDveQte().hashCode());
		result = 37 * result + (getDveCout() == null ? 0 : this.getDveCout().hashCode());
		return result;
	}

}
