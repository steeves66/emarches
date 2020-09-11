package com.sndi.model;
// Generated 11 sept. 2020 13:57:55 by Hibernate Tools 4.3.5.Final

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

/**
 * VbTempParamAnalyseOffId generated by hbm2java
 */
@Entity
@Immutable
@Table(name = "VB_TEMP_PARAM_ANALYSE_OFF")
public class VbTempParamAnalyseOff implements java.io.Serializable {

	private BigDecimal tempNum;
	private String tempType;
	private String tempOpeMatricule;
	private Date tempDteSaisi;
	private BigDecimal anfNum;
	private String anfValeurConf;
	private long anfValeurScore;
	private String anfPresence;
	private String anfCommentaire;
	private String anfDacCode;

	public VbTempParamAnalyseOff() {
	}

	public VbTempParamAnalyseOff(BigDecimal tempNum) {
		this.tempNum = tempNum;
	}

	public VbTempParamAnalyseOff(BigDecimal tempNum, String tempType, String tempOpeMatricule, Date tempDteSaisi,
			BigDecimal anfNum, String anfValeurConf, long anfValeurScore, String anfPresence, String anfCommentaire,
			String anfDacCode) {
		this.tempNum = tempNum;
		this.tempType = tempType;
		this.tempOpeMatricule = tempOpeMatricule;
		this.tempDteSaisi = tempDteSaisi;
		this.anfNum = anfNum;
		this.anfValeurConf = anfValeurConf;
		this.anfValeurScore = anfValeurScore;
		this.anfPresence = anfPresence;
		this.anfCommentaire = anfCommentaire;
		this.anfDacCode = anfDacCode;
	}

	@Id
	@SequenceGenerator(name = "SEQ_TEM_PAR2_NUM_Sequence", sequenceName = "SEQ_TEM_PAR2_NUM", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_TEM_PAR2_NUM_Sequence")
	@Column(name = "TEMP_NUM", nullable = false, precision = 22, scale = 0)
	public BigDecimal getTempNum() {
		return this.tempNum;
	}

	public void setTempNum(BigDecimal tempNum) {
		this.tempNum = tempNum;
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

	@Column(name = "ANF_NUM", length = 500)
	public BigDecimal getAnfNum() {
		return this.anfNum;
	}

	public void setAnfNum(BigDecimal anfNum) {
		this.anfNum = anfNum;
	}

	@Column(name = "ANF_VALEUR_CONF", length = 500)
	public String getAnfValeurConf() {
		return this.anfValeurConf;
	}

	public void setAnfValeurConf(String anfValeurConf) {
		this.anfValeurConf = anfValeurConf;
	}

	@Column(name = "ANF_VALEUR_SCORE", length = 500)
	public long getAnfValeurScore() {
		return this.anfValeurScore;
	}

	public void setAnfValeurScore(long anfValeurScore) {
		this.anfValeurScore = anfValeurScore;
	}

	@Column(name = "ANF_PRESENCE", length = 500)
	public String getAnfPresence() {
		return this.anfPresence;
	}

	public void setAnfPresence(String anfPresence) {
		this.anfPresence = anfPresence;
	}

	@Column(name = "ANF_COMMENTAIRE", length = 500)
	public String getAnfCommentaire() {
		return this.anfCommentaire;
	}

	public void setAnfCommentaire(String anfCommentaire) {
		this.anfCommentaire = anfCommentaire;
	}

	@Column(name = "ANF_DAC_CODE", length = 500)
	public String getAnfDacCode() {
		return this.anfDacCode;
	}

	public void setAnfDacCode(String anfDacCode) {
		this.anfDacCode = anfDacCode;
	}

}
