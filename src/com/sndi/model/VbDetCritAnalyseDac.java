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

	private Long dcadNum;
	private String dcadDanCode;
	private String dcadDacCode;
	private String dcadLibAjust;
	private String dcadDanCraCode;
	private Date dcadDteSaisie;
	private String dcadOpeCode;
	private String dcadObser;
	private String dcadStatut;
	private long dcadLaaId;
	private String dcadCommentaire;
	private Long dcadNumDcad;
	private String dcadCraAuCode;
	private String dcadPetitCra;

	public VbDetCritAnalyseDac() {
	}

	public VbDetCritAnalyseDac(Long dcadNum, String dcadDanCode) {
		this.dcadNum = dcadNum;
		this.dcadDanCode = dcadDanCode;
	}

	public VbDetCritAnalyseDac(Long dcadNum, String dcadDanCode, String dcadDacCode, String dcadLibAjust,
			String dcadDanCraCode, Date dcadDteSaisie, String dcadOpeCode, String dcadObser, String dcadStatut, long dcadLaaId,
	String dcadCommentaire, Long dcadNumDcad, String dcadCraAuCode,
	String dcadPetitCra) {
		this.dcadNum = dcadNum;
		this.dcadDanCode = dcadDanCode;
		this.dcadDacCode = dcadDacCode;
		this.dcadLibAjust = dcadLibAjust;
		this.dcadDanCraCode = dcadDanCraCode;
		this.dcadDteSaisie = dcadDteSaisie;
		this.dcadOpeCode = dcadOpeCode;
		this.dcadObser = dcadObser;
		this.dcadStatut = dcadStatut;
		this.dcadLaaId = dcadLaaId;
		this.dcadCommentaire = dcadCommentaire;
		this.dcadNumDcad = dcadNumDcad;
		this.dcadCraAuCode = dcadCraAuCode;
		this.dcadPetitCra = dcadPetitCra;
	}

	@Id
	@SequenceGenerator(name = "SEQ_DET_CRIT_ANADAC_Sequence", sequenceName = "SEQ_DET_CRIT_ANADAC", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_DET_CRIT_ANADAC_Sequence")
	@Column(name = "DCAD_NUM", nullable = false, precision = 22, scale = 0)
	public Long getDcadNum() {
		return this.dcadNum;
	}

	public void setDcadNum(Long dcadNum) {
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
	
	@Column(name = "DCAD_LAA_ID", precision = 22, scale = 0)
	public long getDcadLaaId() {
		return this.dcadLaaId;
	}

	public void setDcadLaaId(long dcadLaaId) {
		this.dcadLaaId = dcadLaaId;
	}

	@Column(name = "DCAD_COMMENTAIRE", length = 1000)
	public String getDcadCommentaire() {
		return this.dcadCommentaire;
	}

	public void setDcadCommentaire(String dcadCommentaire) {
		this.dcadCommentaire = dcadCommentaire;
	}
	
	@Column(name = "DCAD_NUM_DCAD")
	public Long getDcadNumDcad() {
		return this.dcadNumDcad;
	}

	public void setDcadNumDcad(Long dcadNumDcad) {
		this.dcadNumDcad = dcadNumDcad;
	}
	
	@Column(name = "DCAD_CRA_AU_CODE")
	public String getDcadCraAuCode() {
		return this.dcadCraAuCode;
	}

	public void setDcadCraAuCode(String dcadCraAuCode) {
		this.dcadCraAuCode = dcadCraAuCode;
	}

	@Column(name = "DCAD_PETIT_CRA")
	public String getDcadPetitCra() {
		return this.dcadPetitCra;
	}

	public void setDcadPetitCra(String dcadPetitCra) {
		this.dcadPetitCra = dcadPetitCra;
	}
}
