package com.sndi.models;
// Generated 28 mars 2020 03:24:07 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VbTempParamId generated by hbm2java
 */
@Embeddable
public class VbTempParamId implements java.io.Serializable {

	private BigDecimal tempNum2;
	private String tempType;
	private String tempOpeMatricule;
	private Date tempDteSaisi;
	private String tempChamp01;
	private String tempChamp02;
	private String tempChamp03;
	private String tempChamp04;
	private String tempChamp05;
	private String tempChamp06;
	private String tempChamp07;
	private String tempChamp08;
	private String tempChamp09;
	private String tempChamp10;
	private String tempChamp11;
	private String tempChamp12;
	private String tempChamp13;
	private String tempChamp14;
	private String tempChamp15;
	private String tempChamp16;
	private String tempChamp17;
	private String tempChamp18;
	private String tempChamp19;
	private String tempChamp20;

	public VbTempParamId() {
	}

	public VbTempParamId(BigDecimal tempNum2) {
		this.tempNum2 = tempNum2;
	}

	public VbTempParamId(BigDecimal tempNum2, String tempType, String tempOpeMatricule, Date tempDteSaisi,
			String tempChamp01, String tempChamp02, String tempChamp03, String tempChamp04, String tempChamp05,
			String tempChamp06, String tempChamp07, String tempChamp08, String tempChamp09, String tempChamp10,
			String tempChamp11, String tempChamp12, String tempChamp13, String tempChamp14, String tempChamp15,
			String tempChamp16, String tempChamp17, String tempChamp18, String tempChamp19, String tempChamp20) {
		this.tempNum2 = tempNum2;
		this.tempType = tempType;
		this.tempOpeMatricule = tempOpeMatricule;
		this.tempDteSaisi = tempDteSaisi;
		this.tempChamp01 = tempChamp01;
		this.tempChamp02 = tempChamp02;
		this.tempChamp03 = tempChamp03;
		this.tempChamp04 = tempChamp04;
		this.tempChamp05 = tempChamp05;
		this.tempChamp06 = tempChamp06;
		this.tempChamp07 = tempChamp07;
		this.tempChamp08 = tempChamp08;
		this.tempChamp09 = tempChamp09;
		this.tempChamp10 = tempChamp10;
		this.tempChamp11 = tempChamp11;
		this.tempChamp12 = tempChamp12;
		this.tempChamp13 = tempChamp13;
		this.tempChamp14 = tempChamp14;
		this.tempChamp15 = tempChamp15;
		this.tempChamp16 = tempChamp16;
		this.tempChamp17 = tempChamp17;
		this.tempChamp18 = tempChamp18;
		this.tempChamp19 = tempChamp19;
		this.tempChamp20 = tempChamp20;
	}

	@Column(name = "TEMP_NUM2", nullable = false, precision = 22, scale = 0)
	public BigDecimal getTempNum2() {
		return this.tempNum2;
	}

	public void setTempNum2(BigDecimal tempNum2) {
		this.tempNum2 = tempNum2;
	}

	@Column(name = "TEMP_TYPE", length = 500)
	public String getTempType() {
		return this.tempType;
	}

	public void setTempType(String tempType) {
		this.tempType = tempType;
	}

	@Column(name = "TEMP_OPE_MATRICULE", length = 500)
	public String getTempOpeMatricule() {
		return this.tempOpeMatricule;
	}

	public void setTempOpeMatricule(String tempOpeMatricule) {
		this.tempOpeMatricule = tempOpeMatricule;
	}

	@Column(name = "TEMP_DTE_SAISI", length = 7)
	public Date getTempDteSaisi() {
		return this.tempDteSaisi;
	}

	public void setTempDteSaisi(Date tempDteSaisi) {
		this.tempDteSaisi = tempDteSaisi;
	}

	@Column(name = "TEMP_CHAMP_01", length = 500)
	public String getTempChamp01() {
		return this.tempChamp01;
	}

	public void setTempChamp01(String tempChamp01) {
		this.tempChamp01 = tempChamp01;
	}

	@Column(name = "TEMP_CHAMP_02", length = 500)
	public String getTempChamp02() {
		return this.tempChamp02;
	}

	public void setTempChamp02(String tempChamp02) {
		this.tempChamp02 = tempChamp02;
	}

	@Column(name = "TEMP_CHAMP_03", length = 500)
	public String getTempChamp03() {
		return this.tempChamp03;
	}

	public void setTempChamp03(String tempChamp03) {
		this.tempChamp03 = tempChamp03;
	}

	@Column(name = "TEMP_CHAMP_04", length = 500)
	public String getTempChamp04() {
		return this.tempChamp04;
	}

	public void setTempChamp04(String tempChamp04) {
		this.tempChamp04 = tempChamp04;
	}

	@Column(name = "TEMP_CHAMP_05", length = 500)
	public String getTempChamp05() {
		return this.tempChamp05;
	}

	public void setTempChamp05(String tempChamp05) {
		this.tempChamp05 = tempChamp05;
	}

	@Column(name = "TEMP_CHAMP_06", length = 500)
	public String getTempChamp06() {
		return this.tempChamp06;
	}

	public void setTempChamp06(String tempChamp06) {
		this.tempChamp06 = tempChamp06;
	}

	@Column(name = "TEMP_CHAMP_07", length = 500)
	public String getTempChamp07() {
		return this.tempChamp07;
	}

	public void setTempChamp07(String tempChamp07) {
		this.tempChamp07 = tempChamp07;
	}

	@Column(name = "TEMP_CHAMP_08", length = 500)
	public String getTempChamp08() {
		return this.tempChamp08;
	}

	public void setTempChamp08(String tempChamp08) {
		this.tempChamp08 = tempChamp08;
	}

	@Column(name = "TEMP_CHAMP_09", length = 500)
	public String getTempChamp09() {
		return this.tempChamp09;
	}

	public void setTempChamp09(String tempChamp09) {
		this.tempChamp09 = tempChamp09;
	}

	@Column(name = "TEMP_CHAMP_10", length = 500)
	public String getTempChamp10() {
		return this.tempChamp10;
	}

	public void setTempChamp10(String tempChamp10) {
		this.tempChamp10 = tempChamp10;
	}

	@Column(name = "TEMP_CHAMP_11", length = 500)
	public String getTempChamp11() {
		return this.tempChamp11;
	}

	public void setTempChamp11(String tempChamp11) {
		this.tempChamp11 = tempChamp11;
	}

	@Column(name = "TEMP_CHAMP_12", length = 500)
	public String getTempChamp12() {
		return this.tempChamp12;
	}

	public void setTempChamp12(String tempChamp12) {
		this.tempChamp12 = tempChamp12;
	}

	@Column(name = "TEMP_CHAMP_13", length = 500)
	public String getTempChamp13() {
		return this.tempChamp13;
	}

	public void setTempChamp13(String tempChamp13) {
		this.tempChamp13 = tempChamp13;
	}

	@Column(name = "TEMP_CHAMP_14", length = 500)
	public String getTempChamp14() {
		return this.tempChamp14;
	}

	public void setTempChamp14(String tempChamp14) {
		this.tempChamp14 = tempChamp14;
	}

	@Column(name = "TEMP_CHAMP_15", length = 500)
	public String getTempChamp15() {
		return this.tempChamp15;
	}

	public void setTempChamp15(String tempChamp15) {
		this.tempChamp15 = tempChamp15;
	}

	@Column(name = "TEMP_CHAMP_16", length = 500)
	public String getTempChamp16() {
		return this.tempChamp16;
	}

	public void setTempChamp16(String tempChamp16) {
		this.tempChamp16 = tempChamp16;
	}

	@Column(name = "TEMP_CHAMP_17", length = 500)
	public String getTempChamp17() {
		return this.tempChamp17;
	}

	public void setTempChamp17(String tempChamp17) {
		this.tempChamp17 = tempChamp17;
	}

	@Column(name = "TEMP_CHAMP_18", length = 500)
	public String getTempChamp18() {
		return this.tempChamp18;
	}

	public void setTempChamp18(String tempChamp18) {
		this.tempChamp18 = tempChamp18;
	}

	@Column(name = "TEMP_CHAMP_19", length = 500)
	public String getTempChamp19() {
		return this.tempChamp19;
	}

	public void setTempChamp19(String tempChamp19) {
		this.tempChamp19 = tempChamp19;
	}

	@Column(name = "TEMP_CHAMP_20", length = 500)
	public String getTempChamp20() {
		return this.tempChamp20;
	}

	public void setTempChamp20(String tempChamp20) {
		this.tempChamp20 = tempChamp20;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VbTempParamId))
			return false;
		VbTempParamId castOther = (VbTempParamId) other;

		return ((this.getTempNum2() == castOther.getTempNum2()) || (this.getTempNum2() != null
				&& castOther.getTempNum2() != null && this.getTempNum2().equals(castOther.getTempNum2())))
				&& ((this.getTempType() == castOther.getTempType()) || (this.getTempType() != null
						&& castOther.getTempType() != null && this.getTempType().equals(castOther.getTempType())))
				&& ((this.getTempOpeMatricule() == castOther.getTempOpeMatricule())
						|| (this.getTempOpeMatricule() != null && castOther.getTempOpeMatricule() != null
								&& this.getTempOpeMatricule().equals(castOther.getTempOpeMatricule())))
				&& ((this.getTempDteSaisi() == castOther.getTempDteSaisi())
						|| (this.getTempDteSaisi() != null && castOther.getTempDteSaisi() != null
								&& this.getTempDteSaisi().equals(castOther.getTempDteSaisi())))
				&& ((this.getTempChamp01() == castOther.getTempChamp01())
						|| (this.getTempChamp01() != null && castOther.getTempChamp01() != null
								&& this.getTempChamp01().equals(castOther.getTempChamp01())))
				&& ((this.getTempChamp02() == castOther.getTempChamp02())
						|| (this.getTempChamp02() != null && castOther.getTempChamp02() != null
								&& this.getTempChamp02().equals(castOther.getTempChamp02())))
				&& ((this.getTempChamp03() == castOther.getTempChamp03())
						|| (this.getTempChamp03() != null && castOther.getTempChamp03() != null
								&& this.getTempChamp03().equals(castOther.getTempChamp03())))
				&& ((this.getTempChamp04() == castOther.getTempChamp04())
						|| (this.getTempChamp04() != null && castOther.getTempChamp04() != null
								&& this.getTempChamp04().equals(castOther.getTempChamp04())))
				&& ((this.getTempChamp05() == castOther.getTempChamp05())
						|| (this.getTempChamp05() != null && castOther.getTempChamp05() != null
								&& this.getTempChamp05().equals(castOther.getTempChamp05())))
				&& ((this.getTempChamp06() == castOther.getTempChamp06())
						|| (this.getTempChamp06() != null && castOther.getTempChamp06() != null
								&& this.getTempChamp06().equals(castOther.getTempChamp06())))
				&& ((this.getTempChamp07() == castOther.getTempChamp07())
						|| (this.getTempChamp07() != null && castOther.getTempChamp07() != null
								&& this.getTempChamp07().equals(castOther.getTempChamp07())))
				&& ((this.getTempChamp08() == castOther.getTempChamp08())
						|| (this.getTempChamp08() != null && castOther.getTempChamp08() != null
								&& this.getTempChamp08().equals(castOther.getTempChamp08())))
				&& ((this.getTempChamp09() == castOther.getTempChamp09())
						|| (this.getTempChamp09() != null && castOther.getTempChamp09() != null
								&& this.getTempChamp09().equals(castOther.getTempChamp09())))
				&& ((this.getTempChamp10() == castOther.getTempChamp10())
						|| (this.getTempChamp10() != null && castOther.getTempChamp10() != null
								&& this.getTempChamp10().equals(castOther.getTempChamp10())))
				&& ((this.getTempChamp11() == castOther.getTempChamp11())
						|| (this.getTempChamp11() != null && castOther.getTempChamp11() != null
								&& this.getTempChamp11().equals(castOther.getTempChamp11())))
				&& ((this.getTempChamp12() == castOther.getTempChamp12())
						|| (this.getTempChamp12() != null && castOther.getTempChamp12() != null
								&& this.getTempChamp12().equals(castOther.getTempChamp12())))
				&& ((this.getTempChamp13() == castOther.getTempChamp13())
						|| (this.getTempChamp13() != null && castOther.getTempChamp13() != null
								&& this.getTempChamp13().equals(castOther.getTempChamp13())))
				&& ((this.getTempChamp14() == castOther.getTempChamp14())
						|| (this.getTempChamp14() != null && castOther.getTempChamp14() != null
								&& this.getTempChamp14().equals(castOther.getTempChamp14())))
				&& ((this.getTempChamp15() == castOther.getTempChamp15())
						|| (this.getTempChamp15() != null && castOther.getTempChamp15() != null
								&& this.getTempChamp15().equals(castOther.getTempChamp15())))
				&& ((this.getTempChamp16() == castOther.getTempChamp16())
						|| (this.getTempChamp16() != null && castOther.getTempChamp16() != null
								&& this.getTempChamp16().equals(castOther.getTempChamp16())))
				&& ((this.getTempChamp17() == castOther.getTempChamp17())
						|| (this.getTempChamp17() != null && castOther.getTempChamp17() != null
								&& this.getTempChamp17().equals(castOther.getTempChamp17())))
				&& ((this.getTempChamp18() == castOther.getTempChamp18())
						|| (this.getTempChamp18() != null && castOther.getTempChamp18() != null
								&& this.getTempChamp18().equals(castOther.getTempChamp18())))
				&& ((this.getTempChamp19() == castOther.getTempChamp19())
						|| (this.getTempChamp19() != null && castOther.getTempChamp19() != null
								&& this.getTempChamp19().equals(castOther.getTempChamp19())))
				&& ((this.getTempChamp20() == castOther.getTempChamp20())
						|| (this.getTempChamp20() != null && castOther.getTempChamp20() != null
								&& this.getTempChamp20().equals(castOther.getTempChamp20())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getTempNum2() == null ? 0 : this.getTempNum2().hashCode());
		result = 37 * result + (getTempType() == null ? 0 : this.getTempType().hashCode());
		result = 37 * result + (getTempOpeMatricule() == null ? 0 : this.getTempOpeMatricule().hashCode());
		result = 37 * result + (getTempDteSaisi() == null ? 0 : this.getTempDteSaisi().hashCode());
		result = 37 * result + (getTempChamp01() == null ? 0 : this.getTempChamp01().hashCode());
		result = 37 * result + (getTempChamp02() == null ? 0 : this.getTempChamp02().hashCode());
		result = 37 * result + (getTempChamp03() == null ? 0 : this.getTempChamp03().hashCode());
		result = 37 * result + (getTempChamp04() == null ? 0 : this.getTempChamp04().hashCode());
		result = 37 * result + (getTempChamp05() == null ? 0 : this.getTempChamp05().hashCode());
		result = 37 * result + (getTempChamp06() == null ? 0 : this.getTempChamp06().hashCode());
		result = 37 * result + (getTempChamp07() == null ? 0 : this.getTempChamp07().hashCode());
		result = 37 * result + (getTempChamp08() == null ? 0 : this.getTempChamp08().hashCode());
		result = 37 * result + (getTempChamp09() == null ? 0 : this.getTempChamp09().hashCode());
		result = 37 * result + (getTempChamp10() == null ? 0 : this.getTempChamp10().hashCode());
		result = 37 * result + (getTempChamp11() == null ? 0 : this.getTempChamp11().hashCode());
		result = 37 * result + (getTempChamp12() == null ? 0 : this.getTempChamp12().hashCode());
		result = 37 * result + (getTempChamp13() == null ? 0 : this.getTempChamp13().hashCode());
		result = 37 * result + (getTempChamp14() == null ? 0 : this.getTempChamp14().hashCode());
		result = 37 * result + (getTempChamp15() == null ? 0 : this.getTempChamp15().hashCode());
		result = 37 * result + (getTempChamp16() == null ? 0 : this.getTempChamp16().hashCode());
		result = 37 * result + (getTempChamp17() == null ? 0 : this.getTempChamp17().hashCode());
		result = 37 * result + (getTempChamp18() == null ? 0 : this.getTempChamp18().hashCode());
		result = 37 * result + (getTempChamp19() == null ? 0 : this.getTempChamp19().hashCode());
		result = 37 * result + (getTempChamp20() == null ? 0 : this.getTempChamp20().hashCode());
		return result;
	}

}
