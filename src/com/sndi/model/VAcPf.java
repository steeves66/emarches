package com.sndi.model;
// Generated 5 nov. 2020 12:23:22 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

/**
 * VAcPfId generated by hbm2java
 */
@Entity
@Immutable
@Table(name = "V_AC_PF")
public class VAcPf implements java.io.Serializable {

	private BigDecimal RIdpf;
	private String fonCodePf;
	private String libpf;
	private String fonCodeDmp;
	private String fonTyfCodac;
	private String fonTyfCodpf;
	private String fonTyfCoddmp;
	private String minCode;

	public VAcPf() {
	}

	public VAcPf(BigDecimal RIdpf, String fonCodePf, String libpf, String fonCodeDmp, String fonTyfCodac,
			String fonTyfCodpf, String fonTyfCoddmp,String minCode) {
		this.RIdpf = RIdpf;
		this.fonCodePf = fonCodePf;
		this.libpf = libpf;
		this.fonCodeDmp = fonCodeDmp;
		this.fonTyfCodac = fonTyfCodac;
		this.fonTyfCodpf = fonTyfCodpf;
		this.fonTyfCoddmp = fonTyfCoddmp;
		this.minCode = minCode;
	}

	@Id
	@Column(name = "R_IDPF", precision = 22, scale = 0)
	public BigDecimal getRIdpf() {
		return this.RIdpf;
	}

	public void setRIdpf(BigDecimal RIdpf) {
		this.RIdpf = RIdpf;
	}

	@Column(name = "FON_CODE_PF", length = 20)
	public String getFonCodePf() {
		return this.fonCodePf;
	}

	public void setFonCodePf(String fonCodePf) {
		this.fonCodePf = fonCodePf;
	}

	@Column(name = "LIBPF", length = 525)
	public String getLibpf() {
		return this.libpf;
	}

	public void setLibpf(String libpf) {
		this.libpf = libpf;
	}

	@Column(name = "FON_CODE_DMP", length = 20)
	public String getFonCodeDmp() {
		return this.fonCodeDmp;
	}

	public void setFonCodeDmp(String fonCodeDmp) {
		this.fonCodeDmp = fonCodeDmp;
	}

	@Column(name = "FON_TYF_CODAC", length = 3)
	public String getFonTyfCodac() {
		return this.fonTyfCodac;
	}

	public void setFonTyfCodac(String fonTyfCodac) {
		this.fonTyfCodac = fonTyfCodac;
	}

	@Column(name = "FON_TYF_CODPF", length = 3)
	public String getFonTyfCodpf() {
		return this.fonTyfCodpf;
	}

	public void setFonTyfCodpf(String fonTyfCodpf) {
		this.fonTyfCodpf = fonTyfCodpf;
	}

	@Column(name = "FON_TYF_CODDMP", length = 3)
	public String getFonTyfCoddmp() {
		return this.fonTyfCoddmp;
	}

	public void setFonTyfCoddmp(String fonTyfCoddmp) {
		this.fonTyfCoddmp = fonTyfCoddmp;
	}

	@Column(name = "MIN_CODE")
	public String getMinCode() {
		return minCode;
	}

	public void setMinCode(String minCode) {
		this.minCode = minCode;
	}
}
