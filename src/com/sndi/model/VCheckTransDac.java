package com.sndi.model;
// Generated 6 juil. 2021 12:39:56 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

/**
 * VCheckTransDacx generated by hbm2java
 */
@Entity
@Immutable
@Table(name = "V_CHECK_TRANS_DAC")
public class VCheckTransDac implements java.io.Serializable {

	private String dacCode;
	private String checkTrans;
	private String checkTransMsg;

	public VCheckTransDac() {
	}

	public VCheckTransDac(String dacCode) {
		this.dacCode = dacCode;
	}

	public VCheckTransDac(String dacCode, String checkTrans, String checkTransMsg) {
		this.dacCode = dacCode;
		this.checkTrans = checkTrans;
		this.checkTransMsg = checkTransMsg;
	}

	
	@Id
	@Column(name = "DAC_CODE", nullable = false, length = 20)
	public String getDacCode() {
		return this.dacCode;
	}

	public void setDacCode(String dacCode) {
		this.dacCode = dacCode;
	}

	@Column(name = "CHECK_TRANS")
	public String getCheckTrans() {
		return this.checkTrans;
	}

	public void setCheckTrans(String checkTrans) {
		this.checkTrans = checkTrans;
	}

	@Column(name = "CHECK_TRANS_MSG")
	public String getCheckTransMsg() {
		return this.checkTransMsg;
	}

	public void setCheckTransMsg(String checkTransMsg) {
		this.checkTransMsg = checkTransMsg;
	}

}