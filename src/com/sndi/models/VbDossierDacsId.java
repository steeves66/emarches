package com.sndi.models;
// Generated 23 mars 2020 10:48:44 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VbDossierDacsId generated by hbm2java
 */
@Embeddable
public class VbDossierDacsId implements java.io.Serializable {

	private BigDecimal ddaId;
	private String ddaNom;
	private Date ddaDteSaisi;
	private String ddaStaCode;
	private String ddaDacCode;
	private BigDecimal ddaPidCode;
	private String ddaReference;
	private String ddaCommentaire;
	private String ddaNadCode;

	public VbDossierDacsId() {
	}

	public VbDossierDacsId(BigDecimal ddaId) {
		this.ddaId = ddaId;
	}

	public VbDossierDacsId(BigDecimal ddaId, String ddaNom, Date ddaDteSaisi, String ddaStaCode, String ddaDacCode,
			BigDecimal ddaPidCode, String ddaReference, String ddaCommentaire, String ddaNadCode) {
		this.ddaId = ddaId;
		this.ddaNom = ddaNom;
		this.ddaDteSaisi = ddaDteSaisi;
		this.ddaStaCode = ddaStaCode;
		this.ddaDacCode = ddaDacCode;
		this.ddaPidCode = ddaPidCode;
		this.ddaReference = ddaReference;
		this.ddaCommentaire = ddaCommentaire;
		this.ddaNadCode = ddaNadCode;
	}

	@Column(name = "DDA_ID", nullable = false, precision = 22, scale = 0)
	public BigDecimal getDdaId() {
		return this.ddaId;
	}

	public void setDdaId(BigDecimal ddaId) {
		this.ddaId = ddaId;
	}

	@Column(name = "DDA_NOM", length = 200)
	public String getDdaNom() {
		return this.ddaNom;
	}

	public void setDdaNom(String ddaNom) {
		this.ddaNom = ddaNom;
	}

	@Column(name = "DDA_DTE_SAISI", length = 7)
	public Date getDdaDteSaisi() {
		return this.ddaDteSaisi;
	}

	public void setDdaDteSaisi(Date ddaDteSaisi) {
		this.ddaDteSaisi = ddaDteSaisi;
	}

	@Column(name = "DDA_STA_CODE", length = 3)
	public String getDdaStaCode() {
		return this.ddaStaCode;
	}

	public void setDdaStaCode(String ddaStaCode) {
		this.ddaStaCode = ddaStaCode;
	}

	@Column(name = "DDA_DAC_CODE", length = 20)
	public String getDdaDacCode() {
		return this.ddaDacCode;
	}

	public void setDdaDacCode(String ddaDacCode) {
		this.ddaDacCode = ddaDacCode;
	}

	@Column(name = "DDA_PID_CODE", precision = 22, scale = 0)
	public BigDecimal getDdaPidCode() {
		return this.ddaPidCode;
	}

	public void setDdaPidCode(BigDecimal ddaPidCode) {
		this.ddaPidCode = ddaPidCode;
	}

	@Column(name = "DDA_REFERENCE", length = 500)
	public String getDdaReference() {
		return this.ddaReference;
	}

	public void setDdaReference(String ddaReference) {
		this.ddaReference = ddaReference;
	}

	@Column(name = "DDA_COMMENTAIRE", length = 500)
	public String getDdaCommentaire() {
		return this.ddaCommentaire;
	}

	public void setDdaCommentaire(String ddaCommentaire) {
		this.ddaCommentaire = ddaCommentaire;
	}

	@Column(name = "DDA_NAD_CODE", length = 3)
	public String getDdaNadCode() {
		return this.ddaNadCode;
	}

	public void setDdaNadCode(String ddaNadCode) {
		this.ddaNadCode = ddaNadCode;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VbDossierDacsId))
			return false;
		VbDossierDacsId castOther = (VbDossierDacsId) other;

		return ((this.getDdaId() == castOther.getDdaId()) || (this.getDdaId() != null && castOther.getDdaId() != null
				&& this.getDdaId().equals(castOther.getDdaId())))
				&& ((this.getDdaNom() == castOther.getDdaNom()) || (this.getDdaNom() != null
						&& castOther.getDdaNom() != null && this.getDdaNom().equals(castOther.getDdaNom())))
				&& ((this.getDdaDteSaisi() == castOther.getDdaDteSaisi())
						|| (this.getDdaDteSaisi() != null && castOther.getDdaDteSaisi() != null
								&& this.getDdaDteSaisi().equals(castOther.getDdaDteSaisi())))
				&& ((this.getDdaStaCode() == castOther.getDdaStaCode()) || (this.getDdaStaCode() != null
						&& castOther.getDdaStaCode() != null && this.getDdaStaCode().equals(castOther.getDdaStaCode())))
				&& ((this.getDdaDacCode() == castOther.getDdaDacCode()) || (this.getDdaDacCode() != null
						&& castOther.getDdaDacCode() != null && this.getDdaDacCode().equals(castOther.getDdaDacCode())))
				&& ((this.getDdaPidCode() == castOther.getDdaPidCode()) || (this.getDdaPidCode() != null
						&& castOther.getDdaPidCode() != null && this.getDdaPidCode().equals(castOther.getDdaPidCode())))
				&& ((this.getDdaReference() == castOther.getDdaReference())
						|| (this.getDdaReference() != null && castOther.getDdaReference() != null
								&& this.getDdaReference().equals(castOther.getDdaReference())))
				&& ((this.getDdaCommentaire() == castOther.getDdaCommentaire())
						|| (this.getDdaCommentaire() != null && castOther.getDdaCommentaire() != null
								&& this.getDdaCommentaire().equals(castOther.getDdaCommentaire())))
				&& ((this.getDdaNadCode() == castOther.getDdaNadCode())
						|| (this.getDdaNadCode() != null && castOther.getDdaNadCode() != null
								&& this.getDdaNadCode().equals(castOther.getDdaNadCode())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getDdaId() == null ? 0 : this.getDdaId().hashCode());
		result = 37 * result + (getDdaNom() == null ? 0 : this.getDdaNom().hashCode());
		result = 37 * result + (getDdaDteSaisi() == null ? 0 : this.getDdaDteSaisi().hashCode());
		result = 37 * result + (getDdaStaCode() == null ? 0 : this.getDdaStaCode().hashCode());
		result = 37 * result + (getDdaDacCode() == null ? 0 : this.getDdaDacCode().hashCode());
		result = 37 * result + (getDdaPidCode() == null ? 0 : this.getDdaPidCode().hashCode());
		result = 37 * result + (getDdaReference() == null ? 0 : this.getDdaReference().hashCode());
		result = 37 * result + (getDdaCommentaire() == null ? 0 : this.getDdaCommentaire().hashCode());
		result = 37 * result + (getDdaNadCode() == null ? 0 : this.getDdaNadCode().hashCode());
		return result;
	}

}
