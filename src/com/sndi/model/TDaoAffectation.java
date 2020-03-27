package com.sndi.model;
// Generated 26 f�vr. 2020 16:42:38 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



/**
 * TDaoAffectation generated by hbm2java
 */
@Entity
@Table(name = "T_DAO_AFFECTATION", schema = "EMAP")
public class TDaoAffectation implements java.io.Serializable {

	private long dafId;
	private TDetCommissionSeance TDetCommissionSeance;
	private TModePassation TModePassation;
	private TTypeMarche TTypeMarche;
	private String dafDacCode;
	private String dafOpeMatricule;
	private String dafStaCode;
	private String dafDcsMbmRespo;
	private String dafStatutRetour;
	private Long dafDacGestion;
	private String dafDacObjet;
	private String dafTypeDac;
	private String dafMention;
	private String dafTypePlan;
	private String dafDacStr;
	private String dafDacRecherche;

	public TDaoAffectation() {
	}

	public TDaoAffectation(long dafId) {
		this.dafId = dafId;
	}

	public TDaoAffectation(long dafId, TDetCommissionSeance TDetCommissionSeance,TModePassation TModePassation,
			TTypeMarche TTypeMarche, String dafDacCode,String dafOpeMatricule, String dafStaCode, String dafDcsMbmRespo, String dafStatutRetour, Long  dafDacGestion, String dafDacObjet,
			String dafTypeDac,String dafMention, String dafTypePlan,String dafDacStr, String dafDacRecherche) {
		this.dafId = dafId;
		this.TDetCommissionSeance = TDetCommissionSeance;
		this.TModePassation = TModePassation;
		this.TTypeMarche = TTypeMarche;
		this.dafDacCode = dafDacCode;
		this.dafOpeMatricule = dafOpeMatricule;
		this.dafStaCode = dafStaCode;
		this.dafDcsMbmRespo = dafDcsMbmRespo;
		this.dafStatutRetour = dafStatutRetour;
		this.dafDacGestion = dafDacGestion;
		this.dafDacObjet = dafDacObjet;
		this.dafTypeDac = dafTypeDac;
		this.dafMention = dafMention;
		this.dafTypePlan = dafTypePlan;
		this.dafDacStr = dafDacStr;
		this.dafDacRecherche = dafDacRecherche;
	}

	@Id   
	@SequenceGenerator(name = "SEQ_DAO_AFF_Sequence", sequenceName = "SEQ_DAO_AFF", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_DAO_AFF_Sequence")
	@Column(name = "DAF_ID", unique = true, nullable = false, precision = 10, scale = 0)
	public long getDafId() {
		return this.dafId;
	}

	public void setDafId(long dafId) {
		this.dafId = dafId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DAF_DCS_NUM")
	public TDetCommissionSeance getTDetCommissionSeance() {
		return this.TDetCommissionSeance;
	}

	public void setTDetCommissionSeance(TDetCommissionSeance TDetCommissionSeance) {
		this.TDetCommissionSeance = TDetCommissionSeance;
	}	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "DAF_MOP_CODE")
	public TModePassation getTModePassation() {
		return this.TModePassation;
	}

	public void setTModePassation(TModePassation TModePassation) {
		this.TModePassation = TModePassation;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "DAF_TYM_CODE")
	public TTypeMarche getTTypeMarche() {
		return this.TTypeMarche;
	}

	public void setTTypeMarche(TTypeMarche TTypeMarche) {
		this.TTypeMarche = TTypeMarche;
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
	
	@Column(name = "DAF_DAC_GESTION", precision = 22, scale = 0)
	public Long  getDafDacGestion() {
		return this.dafDacGestion;
	}

	public void setDafDacGestion(Long  dafDacGestion) {
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
	
	@Column(name = "DAF_DAC_RECHERCHE", length = 4000)
	public String getDafDacRecherche() {
		return this.dafDacRecherche;
	}

	public void setDafDacRecherche(String dafDacRecherche) {
		this.dafDacRecherche = dafDacRecherche;
	}

}
