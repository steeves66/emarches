package com.sndi.model;
// Generated 22 juin 2020 19:02:45 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

/**
 * VTabBordAcId generated by hbm2java
 */
@Entity
@Immutable
@Table(name = "V_TAB_BORD_AC")
public class VTabBordAc implements java.io.Serializable {

	private BigDecimal codeId;
	private String codeAc;
	private String typ;
	private String typProc;
	private long saisi;
	private long transAc;
	private long valPf;
	private long difPf;
	private long valDmp;
	private long difDmp;
	private long pub;
	private String typDac;

	public VTabBordAc() {
	}

	public VTabBordAc(BigDecimal codeId, String codeAc, String typ, String typProc, long saisi,
			long transAc, long valPf, long difPf, long valDmp, long difDmp,
			long pub, String typDac) {
		this.codeId = codeId;
		this.codeAc = codeAc;
		this.typ = typ;
		this.typProc = typProc;
		this.saisi = saisi;
		this.transAc = transAc;
		this.valPf = valPf;
		this.difPf = difPf;
		this.valDmp = valDmp;
		this.difDmp = difDmp;
		this.pub = pub;
		this.typDac = typDac;
	}

	@Id
	@Column(name = "CODE_ID", precision = 22, scale = 0)
	public BigDecimal getCodeId() {
		return this.codeId;
	}

	public void setCodeId(BigDecimal codeId) {
		this.codeId = codeId;
	}

	@Column(name = "CODE_AC", length = 12)
	public String getCodeAc() {
		return this.codeAc;
	}

	public void setCodeAc(String codeAc) {
		this.codeAc = codeAc;
	}

	@Column(name = "TYP", length = 4)
	public String getTyp() {
		return this.typ;
	}

	public void setTyp(String typ) {
		this.typ = typ;
	}

	@Column(name = "TYP_PROC", length = 4)
	public String getTypProc() {
		return this.typProc;
	}

	public void setTypProc(String typProc) {
		this.typProc = typProc;
	}

	@Column(name = "SAISI", precision = 22, scale = 0)
	public long getSaisi() {
		return this.saisi;
	}

	public void setSaisi(long saisi) {
		this.saisi = saisi;
	}

	@Column(name = "TRANS_AC", precision = 22, scale = 0)
	public long getTransAc() {
		return this.transAc;
	}

	public void setTransAc(long transAc) {
		this.transAc = transAc;
	}

	@Column(name = "VAL_PF", precision = 22, scale = 0)
	public long getValPf() {
		return this.valPf;
	}

	public void setValPf(long valPf) {
		this.valPf = valPf;
	}

	@Column(name = "DIF_PF", precision = 22, scale = 0)
	public long getDifPf() {
		return this.difPf;
	}

	public void setDifPf(long difPf) {
		this.difPf = difPf;
	}

	@Column(name = "VAL_DMP", precision = 22, scale = 0)
	public long getValDmp() {
		return this.valDmp;
	}

	public void setValDmp(long valDmp) {
		this.valDmp = valDmp;
	}

	@Column(name = "DIF_DMP", precision = 22, scale = 0)
	public long getDifDmp() {
		return this.difDmp;
	}

	public void setDifDmp(long difDmp) {
		this.difDmp = difDmp;
	}

	@Column(name = "PUB", precision = 22, scale = 0)
	public long getPub() {
		return this.pub;
	}

	public void setPub(long pub) {
		this.pub = pub;
	}

	@Column(name = "TYP_DAC", length = 3)
	public String getTypDac() {
		return this.typDac;
	}

	public void setTypDac(String typDac) {
		this.typDac = typDac;
	}

}
