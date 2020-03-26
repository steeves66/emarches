package com.sndi.models;
// Generated 26 mars 2020 03:50:59 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TDaoAffectation generated by hbm2java
 */
@Entity
@Table(name = "T_DAO_AFFECTATION", schema = "EMAP")
public class TDaoAffectation implements java.io.Serializable {

	private long dafId;
	private String dafDacCode;
	private String dafOpeMatricule;
	private String dafStaCode;
	private BigDecimal dafDcsNum;
	private String dafDcsMbmRespo;
	private String dafStatutRetour;
	private String dafTymCode;
	private String dafMopCode;
	private BigDecimal dafDacGestion;
	private String dafDacObjet;
	private String dafTypeDac;
	private String dafMention;
	private String dafTypePlan;
	private String dafDacStr;

	public TDaoAffectation() {
	}

	public TDaoAffectation(long dafId) {
		this.dafId = dafId;
	}

	public TDaoAffectation(long dafId, String dafDacCode, String dafOpeMatricule, String dafStaCode,
			BigDecimal dafDcsNum, String dafDcsMbmRespo, String dafStatutRetour, String dafTymCode, String dafMopCode,
			BigDecimal dafDacGestion, String dafDacObjet, String dafTypeDac, String dafMention, String dafTypePlan,
			String dafDacStr) {
		this.dafId = dafId;
		this.dafDacCode = dafDacCode;
		this.dafOpeMatricule = dafOpeMatricule;
		this.dafStaCode = dafStaCode;
		this.dafDcsNum = dafDcsNum;
		this.dafDcsMbmRespo = dafDcsMbmRespo;
		this.dafStatutRetour = dafStatutRetour;
		this.dafTymCode = dafTymCode;
		this.dafMopCode = dafMopCode;
		this.dafDacGestion = dafDacGestion;
		this.dafDacObjet = dafDacObjet;
		this.dafTypeDac = dafTypeDac;
		this.dafMention = dafMention;
		this.dafTypePlan = dafTypePlan;
		this.dafDacStr = dafDacStr;
	}

	@Id

	@Column(name = "DAF_ID", unique = true, nullable = false, precision = 10, scale = 0)
	public long getDafId() {
		return this.dafId;
	}

	public void setDafId(long dafId) {
		this.dafId = dafId;
	}

	@Column(name = "DAF_DAC_CODE", length = 20)
	public String getDafDacCode() {
		return this.dafDacCode;
	}

	public void setDafDacCode(String dafDacCode) {
		this.dafDacCode = dafDacCode;
	}

	@Column(name = "DAF_OPE_MATRICULE", length = 25)
	public String getDafOpeMatricule() {
		return this.dafOpeMatricule;
	}

	public void setDafOpeMatricule(String dafOpeMatricule) {
		this.dafOpeMatricule = dafOpeMatricule;
	}

	@Column(name = "DAF_STA_CODE", length = 3)
	public String getDafStaCode() {
		return this.dafStaCode;
	}

	public void setDafStaCode(String dafStaCode) {
		this.dafStaCode = dafStaCode;
	}

	@Column(name = "DAF_DCS_NUM", precision = 22, scale = 0)
	public BigDecimal getDafDcsNum() {
		return this.dafDcsNum;
	}

	public void setDafDcsNum(BigDecimal dafDcsNum) {
		this.dafDcsNum = dafDcsNum;
	}

	@Column(name = "DAF_DCS_MBM_RESPO", length = 1)
	public String getDafDcsMbmRespo() {
		return this.dafDcsMbmRespo;
	}

	public void setDafDcsMbmRespo(String dafDcsMbmRespo) {
		this.dafDcsMbmRespo = dafDcsMbmRespo;
	}

	@Column(name = "DAF_STATUT_RETOUR", length = 1)
	public String getDafStatutRetour() {
		return this.dafStatutRetour;
	}

	public void setDafStatutRetour(String dafStatutRetour) {
		this.dafStatutRetour = dafStatutRetour;
	}

	@Column(name = "DAF_TYM_CODE", length = 3)
	public String getDafTymCode() {
		return this.dafTymCode;
	}

	public void setDafTymCode(String dafTymCode) {
		this.dafTymCode = dafTymCode;
	}

	@Column(name = "DAF_MOP_CODE", length = 3)
	public String getDafMopCode() {
		return this.dafMopCode;
	}

	public void setDafMopCode(String dafMopCode) {
		this.dafMopCode = dafMopCode;
	}

	@Column(name = "DAF_DAC_GESTION", precision = 22, scale = 0)
	public BigDecimal getDafDacGestion() {
		return this.dafDacGestion;
	}

	public void setDafDacGestion(BigDecimal dafDacGestion) {
		this.dafDacGestion = dafDacGestion;
	}

	@Column(name = "DAF_DAC_OBJET", length = 2000)
	public String getDafDacObjet() {
		return this.dafDacObjet;
	}

	public void setDafDacObjet(String dafDacObjet) {
		this.dafDacObjet = dafDacObjet;
	}

	@Column(name = "DAF_TYPE_DAC", length = 3)
	public String getDafTypeDac() {
		return this.dafTypeDac;
	}

	public void setDafTypeDac(String dafTypeDac) {
		this.dafTypeDac = dafTypeDac;
	}

	@Column(name = "DAF_MENTION", length = 100)
	public String getDafMention() {
		return this.dafMention;
	}

	public void setDafMention(String dafMention) {
		this.dafMention = dafMention;
	}

	@Column(name = "DAF_TYPE_PLAN", length = 4)
	public String getDafTypePlan() {
		return this.dafTypePlan;
	}

	public void setDafTypePlan(String dafTypePlan) {
		this.dafTypePlan = dafTypePlan;
	}

	@Column(name = "DAF_DAC_STR", length = 4)
	public String getDafDacStr() {
		return this.dafDacStr;
	}

	public void setDafDacStr(String dafDacStr) {
		this.dafDacStr = dafDacStr;
	}

}
