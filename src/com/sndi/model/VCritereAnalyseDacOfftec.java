package com.sndi.model;
// Generated 2 oct. 2020 20:58:51 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

/**
 * VCritereAnalyseDacOfftec generated by hbm2java
 */
@Entity
@Immutable
@Table(name = "V_CRITERE_ANALYSE_DAC_OFFTEC")
public class VCritereAnalyseDacOfftec implements java.io.Serializable {

	private BigDecimal RId;
	private BigDecimal dcadLaaId;
	private String offSouNcc;
	private BigDecimal offNum;
	private BigDecimal dofNum;
	private BigDecimal dcadNum;
	private BigDecimal RTri;
	private String craCode;
	private String craLibelle;
	private String codparent;
	private String codep;
	private String craTymCodex;
	private String craTypProc;
	private String craTypDac;
	private String craBailleurx;
	private String analyseStatut;
	private String dcadDacCode;
	private String aaoRegQual;
	private String aaoRegQualx;
	private long valRegQual;
	private String dcadCommentaire;
	private BigDecimal dcadNumDcad;
	private String dcadCraAuCode;
	private String dcadPetitCra;
	private String anfValeurConf;
	private String anfObser;
	private long anfValeurScore;
	private BigDecimal nbfich;
	private BigDecimal fichStatut;
	private String anfCommentaire;
	private String anfPresence;
	private BigDecimal anfNum;
	private String btnAnfValeurConf;
	private String btnAnfPresence;

	public VCritereAnalyseDacOfftec() {
	}

	public VCritereAnalyseDacOfftec(BigDecimal dcadLaaId, BigDecimal offNum, BigDecimal dofNum, BigDecimal dcadNum,
			String codep) {
		this.dcadLaaId = dcadLaaId;
		this.offNum = offNum;
		this.dofNum = dofNum;
		this.dcadNum = dcadNum;
		this.codep = codep;
	}

	public VCritereAnalyseDacOfftec(BigDecimal RId, BigDecimal dcadLaaId, String offSouNcc, BigDecimal offNum,
			BigDecimal dofNum, BigDecimal dcadNum, BigDecimal RTri, String craCode, String craLibelle, String codparent,
			String codep, String craTymCodex, String craTypProc, String craTypDac, String craBailleurx,
			String analyseStatut, String dcadDacCode, String aaoRegQual, String aaoRegQualx, long valRegQual,
			String dcadCommentaire, BigDecimal dcadNumDcad, String dcadCraAuCode, String dcadPetitCra,
			String anfValeurConf, String anfObser, Long anfValeurScore, BigDecimal nbfich, BigDecimal fichStatut,
			String anfCommentaire, String anfPresence, BigDecimal anfNum, String btnAnfValeurConf,
			String btnAnfPresence) {
		this.RId = RId;
		this.dcadLaaId = dcadLaaId;
		this.offSouNcc = offSouNcc;
		this.offNum = offNum;
		this.dofNum = dofNum;
		this.dcadNum = dcadNum;
		this.RTri = RTri;
		this.craCode = craCode;
		this.craLibelle = craLibelle;
		this.codparent = codparent;
		this.codep = codep;
		this.craTymCodex = craTymCodex;
		this.craTypProc = craTypProc;
		this.craTypDac = craTypDac;
		this.craBailleurx = craBailleurx;
		this.analyseStatut = analyseStatut;
		this.dcadDacCode = dcadDacCode;
		this.aaoRegQual = aaoRegQual;
		this.aaoRegQualx = aaoRegQualx;
		this.valRegQual = valRegQual;
		this.dcadCommentaire = dcadCommentaire;
		this.dcadNumDcad = dcadNumDcad;
		this.dcadCraAuCode = dcadCraAuCode;
		this.dcadPetitCra = dcadPetitCra;
		this.anfValeurConf = anfValeurConf;
		this.anfObser = anfObser;
		this.anfValeurScore = anfValeurScore;
		this.nbfich = nbfich;
		this.fichStatut = fichStatut;
		this.anfCommentaire = anfCommentaire;
		this.anfPresence = anfPresence;
		this.anfNum = anfNum;
		this.btnAnfValeurConf = btnAnfValeurConf;
		this.btnAnfPresence = btnAnfPresence;
	}

	@Id
	@Column(name = "R_ID", precision = 22, scale = 0)
	public BigDecimal getRId() {
		return this.RId;
	}

	public void setRId(BigDecimal RId) {
		this.RId = RId;
	}

	@Column(name = "DCAD_LAA_ID", nullable = false, precision = 22, scale = 0)
	public BigDecimal getDcadLaaId() {
		return this.dcadLaaId;
	}

	public void setDcadLaaId(BigDecimal dcadLaaId) {
		this.dcadLaaId = dcadLaaId;
	}

	@Column(name = "OFF_SOU_NCC", length = 20)
	public String getOffSouNcc() {
		return this.offSouNcc;
	}

	public void setOffSouNcc(String offSouNcc) {
		this.offSouNcc = offSouNcc;
	}

	@Column(name = "OFF_NUM", nullable = false, precision = 22, scale = 0)
	public BigDecimal getOffNum() {
		return this.offNum;
	}

	public void setOffNum(BigDecimal offNum) {
		this.offNum = offNum;
	}

	@Column(name = "DOF_NUM", nullable = false, precision = 22, scale = 0)
	public BigDecimal getDofNum() {
		return this.dofNum;
	}

	public void setDofNum(BigDecimal dofNum) {
		this.dofNum = dofNum;
	}

	@Column(name = "DCAD_NUM", nullable = false, precision = 22, scale = 0)
	public BigDecimal getDcadNum() {
		return this.dcadNum;
	}

	public void setDcadNum(BigDecimal dcadNum) {
		this.dcadNum = dcadNum;
	}

	@Column(name = "R_TRI", precision = 22, scale = 0)
	public BigDecimal getRTri() {
		return this.RTri;
	}

	public void setRTri(BigDecimal RTri) {
		this.RTri = RTri;
	}

	@Column(name = "CRA_CODE", length = 50)
	public String getCraCode() {
		return this.craCode;
	}

	public void setCraCode(String craCode) {
		this.craCode = craCode;
	}

	@Column(name = "CRA_LIBELLE", length = 4000)
	public String getCraLibelle() {
		return this.craLibelle;
	}

	public void setCraLibelle(String craLibelle) {
		this.craLibelle = craLibelle;
	}

	@Column(name = "CODPARENT", length = 50)
	public String getCodparent() {
		return this.codparent;
	}

	public void setCodparent(String codparent) {
		this.codparent = codparent;
	}

	@Column(name = "CODEP", nullable = false, length = 50)
	public String getCodep() {
		return this.codep;
	}

	public void setCodep(String codep) {
		this.codep = codep;
	}

	@Column(name = "CRA_TYM_CODEX", length = 4)
	public String getCraTymCodex() {
		return this.craTymCodex;
	}

	public void setCraTymCodex(String craTymCodex) {
		this.craTymCodex = craTymCodex;
	}

	@Column(name = "CRA_TYP_PROC", length = 3)
	public String getCraTypProc() {
		return this.craTypProc;
	}

	public void setCraTypProc(String craTypProc) {
		this.craTypProc = craTypProc;
	}

	@Column(name = "CRA_TYP_DAC", length = 3)
	public String getCraTypDac() {
		return this.craTypDac;
	}

	public void setCraTypDac(String craTypDac) {
		this.craTypDac = craTypDac;
	}

	@Column(name = "CRA_BAILLEURX", length = 20)
	public String getCraBailleurx() {
		return this.craBailleurx;
	}

	public void setCraBailleurx(String craBailleurx) {
		this.craBailleurx = craBailleurx;
	}

	@Column(name = "ANALYSE_STATUT", length = 1)
	public String getAnalyseStatut() {
		return this.analyseStatut;
	}

	public void setAnalyseStatut(String analyseStatut) {
		this.analyseStatut = analyseStatut;
	}

	@Column(name = "DCAD_DAC_CODE", length = 50)
	public String getDcadDacCode() {
		return this.dcadDacCode;
	}

	public void setDcadDacCode(String dcadDacCode) {
		this.dcadDacCode = dcadDacCode;
	}

	@Column(name = "AAO_REG_QUAL", length = 38)
	public String getAaoRegQual() {
		return this.aaoRegQual;
	}

	public void setAaoRegQual(String aaoRegQual) {
		this.aaoRegQual = aaoRegQual;
	}

	@Column(name = "AAO_REG_QUALX", length = 100)
	public String getAaoRegQualx() {
		return this.aaoRegQualx;
	}

	public void setAaoRegQualx(String aaoRegQualx) {
		this.aaoRegQualx = aaoRegQualx;
	}

	@Column(name = "VAL_REG_QUAL", precision = 22, scale = 0)
	public long getValRegQual() {
		return this.valRegQual;
	}

	public void setValRegQual(long valRegQual) {
		this.valRegQual = valRegQual;
	}

	@Column(name = "DCAD_COMMENTAIRE", length = 1000)
	public String getDcadCommentaire() {
		return this.dcadCommentaire;
	}

	public void setDcadCommentaire(String dcadCommentaire) {
		this.dcadCommentaire = dcadCommentaire;
	}

	@Column(name = "DCAD_NUM_DCAD", precision = 22, scale = 0)
	public BigDecimal getDcadNumDcad() {
		return this.dcadNumDcad;
	}

	public void setDcadNumDcad(BigDecimal dcadNumDcad) {
		this.dcadNumDcad = dcadNumDcad;
	}

	@Column(name = "DCAD_CRA_AU_CODE", length = 50)
	public String getDcadCraAuCode() {
		return this.dcadCraAuCode;
	}

	public void setDcadCraAuCode(String dcadCraAuCode) {
		this.dcadCraAuCode = dcadCraAuCode;
	}

	@Column(name = "DCAD_PETIT_CRA", length = 50)
	public String getDcadPetitCra() {
		return this.dcadPetitCra;
	}

	public void setDcadPetitCra(String dcadPetitCra) {
		this.dcadPetitCra = dcadPetitCra;
	}

	@Column(name = "ANF_VALEUR_CONF", length = 100)
	public String getAnfValeurConf() {
		return this.anfValeurConf;
	}

	public void setAnfValeurConf(String anfValeurConf) {
		this.anfValeurConf = anfValeurConf;
	}

	@Column(name = "ANF_OBSER", length = 500)
	public String getAnfObser() {
		return this.anfObser;
	}

	public void setAnfObser(String anfObser) {
		this.anfObser = anfObser;
	}

	@Column(name = "ANF_VALEUR_SCORE", precision = 10, scale = 0)
	public long getAnfValeurScore() {
		return this.anfValeurScore;
	}

	public void setAnfValeurScore(long anfValeurScore) {
		this.anfValeurScore = anfValeurScore;
	}

	@Column(name = "NBFICH", precision = 22, scale = 0)
	public BigDecimal getNbfich() {
		return this.nbfich;
	}

	public void setNbfich(BigDecimal nbfich) {
		this.nbfich = nbfich;
	}

	@Column(name = "FICH_STATUT", precision = 22, scale = 0)
	public BigDecimal getFichStatut() {
		return this.fichStatut;
	}

	public void setFichStatut(BigDecimal fichStatut) {
		this.fichStatut = fichStatut;
	}

	@Column(name = "ANF_COMMENTAIRE", length = 1000)
	public String getAnfCommentaire() {
		return this.anfCommentaire;
	}

	public void setAnfCommentaire(String anfCommentaire) {
		this.anfCommentaire = anfCommentaire;
	}

	@Column(name = "ANF_PRESENCE", length = 1)
	public String getAnfPresence() {
		return this.anfPresence;
	}

	public void setAnfPresence(String anfPresence) {
		this.anfPresence = anfPresence;
	}

	@Column(name = "ANF_NUM", precision = 22, scale = 0)
	public BigDecimal getAnfNum() {
		return this.anfNum;
	}

	public void setAnfNum(BigDecimal anfNum) {
		this.anfNum = anfNum;
	}

	@Column(name = "BTN_ANF_VALEUR_CONF", precision = 22, scale = 0)
	public String getBtnAnfValeurConf() {
		return this.btnAnfValeurConf;
	}

	public void setBtnAnfValeurConf(String btnAnfValeurConf) {
		this.btnAnfValeurConf = btnAnfValeurConf;
	}

	@Column(name = "BTN_ANF_PRESENCE", precision = 22, scale = 0)
	public String getBtnAnfPresence() {
		return this.btnAnfPresence;
	}

	public void setBtnAnfPresence(String btnAnfPresence) {
		this.btnAnfPresence = btnAnfPresence;
	}	

}
