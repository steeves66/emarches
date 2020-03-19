package com.sndi.models;
// Generated 19 mars 2020 18:39:08 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * TTempParametre generated by hbm2java
 */
@Entity
@Table(name = "T_TEMP_PARAMETRE", schema = "EMAP")
public class TTempParametre implements java.io.Serializable {

	private BigDecimal tempNum;
	private TOperateur TOperateur;
	private String tempType;
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
	private String tempChamp21;
	private String tempChamp22;
	private String tempChamp23;
	private String tempChamp24;
	private String tempChamp25;

	public TTempParametre() {
	}

	public TTempParametre(BigDecimal tempNum) {
		this.tempNum = tempNum;
	}

	public TTempParametre(BigDecimal tempNum, TOperateur TOperateur, String tempType, Date tempDteSaisi,
			String tempChamp01, String tempChamp02, String tempChamp03, String tempChamp04, String tempChamp05,
			String tempChamp06, String tempChamp07, String tempChamp08, String tempChamp09, String tempChamp10,
			String tempChamp11, String tempChamp12, String tempChamp13, String tempChamp14, String tempChamp15,
			String tempChamp16, String tempChamp17, String tempChamp18, String tempChamp19, String tempChamp20,
			String tempChamp21, String tempChamp22, String tempChamp23, String tempChamp24, String tempChamp25) {
		this.tempNum = tempNum;
		this.TOperateur = TOperateur;
		this.tempType = tempType;
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
		this.tempChamp21 = tempChamp21;
		this.tempChamp22 = tempChamp22;
		this.tempChamp23 = tempChamp23;
		this.tempChamp24 = tempChamp24;
		this.tempChamp25 = tempChamp25;
	}

	@Id

	@Column(name = "TEMP_NUM", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getTempNum() {
		return this.tempNum;
	}

	public void setTempNum(BigDecimal tempNum) {
		this.tempNum = tempNum;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TEMP_OPE_MATRICULE")
	public TOperateur getTOperateur() {
		return this.TOperateur;
	}

	public void setTOperateur(TOperateur TOperateur) {
		this.TOperateur = TOperateur;
	}

	@Column(name = "TEMP_TYPE", length = 500)
	public String getTempType() {
		return this.tempType;
	}

	public void setTempType(String tempType) {
		this.tempType = tempType;
	}

	@Temporal(TemporalType.DATE)
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

	@Column(name = "TEMP_CHAMP_21", length = 500)
	public String getTempChamp21() {
		return this.tempChamp21;
	}

	public void setTempChamp21(String tempChamp21) {
		this.tempChamp21 = tempChamp21;
	}

	@Column(name = "TEMP_CHAMP_22", length = 500)
	public String getTempChamp22() {
		return this.tempChamp22;
	}

	public void setTempChamp22(String tempChamp22) {
		this.tempChamp22 = tempChamp22;
	}

	@Column(name = "TEMP_CHAMP_23", length = 500)
	public String getTempChamp23() {
		return this.tempChamp23;
	}

	public void setTempChamp23(String tempChamp23) {
		this.tempChamp23 = tempChamp23;
	}

	@Column(name = "TEMP_CHAMP_24", length = 500)
	public String getTempChamp24() {
		return this.tempChamp24;
	}

	public void setTempChamp24(String tempChamp24) {
		this.tempChamp24 = tempChamp24;
	}

	@Column(name = "TEMP_CHAMP_25", length = 500)
	public String getTempChamp25() {
		return this.tempChamp25;
	}

	public void setTempChamp25(String tempChamp25) {
		this.tempChamp25 = tempChamp25;
	}

}
