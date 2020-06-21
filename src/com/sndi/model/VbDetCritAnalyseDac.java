package com.sndi.model;
// Generated 20 juin 2020 12:34:16 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "VB_DET_CRIT_ANALYSE_DAC")
public class VbDetCritAnalyseDac implements java.io.Serializable {

	private BigDecimal dcadNum;
	private String dcadDanCode;
	private String dcadDacCode;
	private String dcadLibAjust;
	private String dcadDanCraCode;
	private Date dcadDteSaisie;
	private String dcadOpeCode;
	private String dcadObser;
	private String dcadStatut;

	public VbDetCritAnalyseDac() {
	}

	public VbDetCritAnalyseDac(BigDecimal dcadNum, String dcadDanCode) {
		this.dcadNum = dcadNum;
		this.dcadDanCode = dcadDanCode;
	}

	public VbDetCritAnalyseDac(BigDecimal dcadNum, String dcadDanCode, String dcadDacCode, String dcadLibAjust,
			String dcadDanCraCode, Date dcadDteSaisie, String dcadOpeCode, String dcadObser, String dcadStatut) {
		this.dcadNum = dcadNum;
		this.dcadDanCode = dcadDanCode;
		this.dcadDacCode = dcadDacCode;
		this.dcadLibAjust = dcadLibAjust;
		this.dcadDanCraCode = dcadDanCraCode;
		this.dcadDteSaisie = dcadDteSaisie;
		this.dcadOpeCode = dcadOpeCode;
		this.dcadObser = dcadObser;
		this.dcadStatut = dcadStatut;
	}

	@Id
	@SequenceGenerator(name = "SEQ_DET_CRIT_ANADAC_Sequence", sequenceName = "SEQ_DET_CRIT_ANADAC", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_DET_CRIT_ANADAC_Sequence")
	@Column(name = "DCAD_NUM", nullable = false, precision = 22, scale = 0)
	public BigDecimal getDcadNum() {
		return this.dcadNum;
	}

	public void setDcadNum(BigDecimal dcadNum) {
		this.dcadNum = dcadNum;
	}

	@Column(name = "DCAD_DAN_CODE", nullable = false, length = 20)
	public String getDcadDanCode() {
		return this.dcadDanCode;
	}

	public void setDcadDanCode(String dcadDanCode) {
		this.dcadDanCode = dcadDanCode;
	}

	@Column(name = "DCAD_DAC_CODE", length = 20)
	public String getDcadDacCode() {
		return this.dcadDacCode;
	}

	public void setDcadDacCode(String dcadDacCode) {
		this.dcadDacCode = dcadDacCode;
	}

	@Column(name = "DCAD_LIB_AJUST", length = 500)
	public String getDcadLibAjust() {
		return this.dcadLibAjust;
	}

	public void setDcadLibAjust(String dcadLibAjust) {
		this.dcadLibAjust = dcadLibAjust;
	}

	@Column(name = "DCAD_DAN_CRA_CODE", length = 20)
	public String getDcadDanCraCode() {
		return this.dcadDanCraCode;
	}

	public void setDcadDanCraCode(String dcadDanCraCode) {
		this.dcadDanCraCode = dcadDanCraCode;
	}

	@Column(name = "DCAD_DTE_SAISIE", length = 7)
	public Date getDcadDteSaisie() {
		return this.dcadDteSaisie;
	}

	public void setDcadDteSaisie(Date dcadDteSaisie) {
		this.dcadDteSaisie = dcadDteSaisie;
	}

	@Column(name = "DCAD_OPE_CODE", length = 25)
	public String getDcadOpeCode() {
		return this.dcadOpeCode;
	}

	public void setDcadOpeCode(String dcadOpeCode) {
		this.dcadOpeCode = dcadOpeCode;
	}

	@Column(name = "DCAD_OBSER", length = 500)
	public String getDcadObser() {
		return this.dcadObser;
	}

	public void setDcadObser(String dcadObser) {
		this.dcadObser = dcadObser;
	}

	@Column(name = "DCAD_STATUT", length = 1)
	public String getDcadStatut() {
		return this.dcadStatut;
	}

	public void setDcadStatut(String dcadStatut) {
		this.dcadStatut = dcadStatut;
	}
}
