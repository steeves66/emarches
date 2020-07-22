package com.sndi.model;
// Generated 18 juin 2020 11:53:04 by Hibernate Tools 4.3.5.Final

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
@Table(name = "VB_COMMISSION_SPECIFIQUE")
public class VbCommissionSpecifique implements java.io.Serializable {

	private BigDecimal comNum;
	private Date comDteSaisi;
	private String comStrCode;
	private String comTctCode;
	private String comOpeMatricule;
	private String comDacCode;
	private String comMarCode;
	private String comAaoCode;
	private String comTcoCode;
	private String comTctLibelle;

	public VbCommissionSpecifique() {
	}

	public VbCommissionSpecifique(BigDecimal comNum) {
		this.comNum = comNum;
	}

	public VbCommissionSpecifique(BigDecimal comNum, Date comDteSaisi, String comStrCode, String comTctCode,
			String comOpeMatricule, String comDacCode, String comMarCode, String comAaoCode, String comTcoCode, String comTctLibelle) {
		this.comNum = comNum;
		this.comDteSaisi = comDteSaisi;
		this.comStrCode = comStrCode;
		this.comTctCode = comTctCode;
		this.comOpeMatricule = comOpeMatricule;
		this.comDacCode = comDacCode;
		this.comMarCode = comMarCode;
		this.comAaoCode = comAaoCode;
		this.comTcoCode = comTcoCode;
		this.comTctLibelle = comTctLibelle;
	}

	@Id
	@SequenceGenerator(name = "SEQ_COMS_Sequence", sequenceName = "SEQ_COMS", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_COMS_Sequence")
	@Column(name = "COM_NUM", nullable = false, precision = 22, scale = 0)
	public BigDecimal getComNum() {
		return this.comNum;
	}

	public void setComNum(BigDecimal comNum) {
		this.comNum = comNum;
	}

	@Column(name = "COM_DTE_SAISI", length = 7)
	public Date getComDteSaisi() {
		return this.comDteSaisi;
	}

	public void setComDteSaisi(Date comDteSaisi) {
		this.comDteSaisi = comDteSaisi;
	}

	@Column(name = "COM_STR_CODE", length = 20)
	public String getComStrCode() {
		return this.comStrCode;
	}

	public void setComStrCode(String comStrCode) {
		this.comStrCode = comStrCode;
	}

	@Column(name = "COM_TCT_CODE", length = 3)
	public String getComTctCode() {
		return this.comTctCode;
	}

	public void setComTctCode(String comTctCode) {
		this.comTctCode = comTctCode;
	}

	@Column(name = "COM_OPE_MATRICULE", length = 20)
	public String getComOpeMatricule() {
		return this.comOpeMatricule;
	}

	public void setComOpeMatricule(String comOpeMatricule) {
		this.comOpeMatricule = comOpeMatricule;
	}

	@Column(name = "COM_DAC_CODE", length = 20)
	public String getComDacCode() {
		return this.comDacCode;
	}

	public void setComDacCode(String comDacCode) {
		this.comDacCode = comDacCode;
	}

	@Column(name = "COM_MAR_CODE", length = 20)
	public String getComMarCode() {
		return this.comMarCode;
	}

	public void setComMarCode(String comMarCode) {
		this.comMarCode = comMarCode;
	}

	@Column(name = "COM_AAO_CODE", length = 20)
	public String getComAaoCode() {
		return this.comAaoCode;
	}

	public void setComAaoCode(String comAaoCode) {
		this.comAaoCode = comAaoCode;
	}

	@Column(name = "COM_TCO_CODE", length = 3)
	public String getComTcoCode() {
		return this.comTcoCode;
	}

	public void setComTcoCode(String comTcoCode) {
		this.comTcoCode = comTcoCode;
	}
	
	@Column(name = "COM_TCT_LIBELLE", length = 500)
	public String getComTctLibelle() {
		return this.comTctLibelle;
	}

	public void setComTctLibelle(String comTctLibelle) {
		this.comTctLibelle = comTctLibelle;
	}

}
