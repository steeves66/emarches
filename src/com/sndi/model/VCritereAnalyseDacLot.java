package com.sndi.model;
// Generated 16 juil. 2020 14:33:17 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

/**
 * VCritereAnalyseDacLotId generated by hbm2java
 */
@Entity
@Immutable
@Table(name = "V_CRITERE_ANALYSE_DAC_LOT")
public class VCritereAnalyseDacLot implements java.io.Serializable {

	private BigDecimal dcadLaaId;
	private BigDecimal RId;
	private String craCode;
	private String craLibelle;
	private String codparent;
	private String codep;
	private String craTymCodex;
	private String craTypProc;
	private String craTypDac;
	private String craBailleurx;
	private String dcadDacCode;
	private String aaoRegQual;
	private BigDecimal valRegQual;
	private BigDecimal dcadNum;
	private String dcadCommentaire;
	private BigDecimal dcadNumDcad;

	public VCritereAnalyseDacLot() {
	}

	public VCritereAnalyseDacLot(BigDecimal dcadLaaId, BigDecimal RId, String craCode, String craLibelle,
			String codparent, String codep, String craTymCodex, String craTypProc, String craTypDac,
			String craBailleurx, String dcadDacCode, String aaoRegQual, BigDecimal valRegQual, BigDecimal dcadNum,
			String dcadCommentaire, BigDecimal dcadNumDcad) {
		this.dcadLaaId = dcadLaaId;
		this.RId = RId;
		this.craCode = craCode;
		this.craLibelle = craLibelle;
		this.codparent = codparent;
		this.codep = codep;
		this.craTymCodex = craTymCodex;
		this.craTypProc = craTypProc;
		this.craTypDac = craTypDac;
		this.craBailleurx = craBailleurx;
		this.dcadDacCode = dcadDacCode;
		this.aaoRegQual = aaoRegQual;
		this.valRegQual = valRegQual;
		this.dcadNum = dcadNum;
		this.dcadCommentaire = dcadCommentaire;
		this.dcadNumDcad = dcadNumDcad;
	}

	@Column(name = "DCAD_LAA_ID", precision = 22, scale = 0)
	public BigDecimal getDcadLaaId() {
		return this.dcadLaaId;
	}

	public void setDcadLaaId(BigDecimal dcadLaaId) {
		this.dcadLaaId = dcadLaaId;
	}

	@Id
	@Column(name = "R_ID", precision = 22, scale = 0)
	public BigDecimal getRId() {
		return this.RId;
	}

	public void setRId(BigDecimal RId) {
		this.RId = RId;
	}

	@Column(name = "CRA_CODE", length = 164)
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

	@Column(name = "CODPARENT", length = 100)
	public String getCodparent() {
		return this.codparent;
	}

	public void setCodparent(String codparent) {
		this.codparent = codparent;
	}

	@Column(name = "CODEP", length = 50)
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

	@Column(name = "DCAD_DAC_CODE", length = 50)
	public String getDcadDacCode() {
		return this.dcadDacCode;
	}

	public void setDcadDacCode(String dcadDacCode) {
		this.dcadDacCode = dcadDacCode;
	}

	@Column(name = "AAO_REG_QUAL", length = 100)
	public String getAaoRegQual() {
		return this.aaoRegQual;
	}

	public void setAaoRegQual(String aaoRegQual) {
		this.aaoRegQual = aaoRegQual;
	}

	@Column(name = "VAL_REG_QUAL", precision = 22, scale = 0)
	public BigDecimal getValRegQual() {
		return this.valRegQual;
	}

	public void setValRegQual(BigDecimal valRegQual) {
		this.valRegQual = valRegQual;
	}

	@Column(name = "DCAD_NUM", precision = 22, scale = 0)
	public BigDecimal getDcadNum() {
		return this.dcadNum;
	}

	public void setDcadNum(BigDecimal dcadNum) {
		this.dcadNum = dcadNum;
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
}
