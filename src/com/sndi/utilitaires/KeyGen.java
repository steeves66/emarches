package com.sndi.utilitaires;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sndi.service.Iservice;

@Component
public class KeyGen {
	@Autowired
	Iservice iservice;
	
	public String getApID(String paysCode, String TypeAp) {
		String p = paysCode.substring(0, 3);
		String pseudo = p + TypeAp;// 4 il reste 6 sur 10
		String IdAp = iservice.getCodeTable(pseudo, 4, 10,
				"air_protegee", "aip_cod");
		System.out.println("****Id de l' Aire Protegée =" + IdAp+" La Taille: "+IdAp.length());
		return IdAp;
	}
	 public String getNumeroOrdre() {
			String pseudo="";
			String numero=iservice.getCodeTable(pseudo, 0, 3,
					"T_DETAIL_AGPM", "TDA_NUM_ORDRE");
			return numero;
		  }
	
public String getFonctionID(String codeTypeFonc) {
		
		String pseudo = "FON-"+codeTypeFonc;//7 il reste 3 total 10
		String IdFonc = iservice.getCodeTable(pseudo, new Integer(GRFProperties.FON_COD_SIZE_PSEUDO), new Integer(GRFProperties.FON_COD_SIZE),
				"t_fonction", "fon_cod");
		System.out.println("****Id de la Fonction =" + IdFonc);
		return IdFonc;
	}
	
	public String getDossiersID(String demCode) {
		
		String pseudo = demCode+"-";//10 il reste 3 total 13
		String idDoss = iservice.getCodeTable(pseudo, new Integer(10), new Integer(14),
				"t_dossiers", "code_dos");
		System.out.println("****Code du dossier =" + idDoss);
		return idDoss;
	}
	
	public String getNumVente(String exo) {
		String pseudo=exo;
		String idDem=iservice.getCodeTable(pseudo, 8, 15,
				"T_VENTE_DAC", "VEN_PAIE_CODE");
		return idDem;
	}
	
	public String getCodeAvis() {
		String pseudo = "AAO-";//4 il reste 5 total 9
		String code = iservice.getCodeTable(pseudo, 4, 10,
				"T_AVIS_APPEL_OFFRE", "AAO_CODE");
		System.out.println("****code T_AVIS_APPEL_OFFRE =" + code);
		return code;
	}
	
	public String getCodeLibelleSeance() { 
		String pseudo = "SEANCE-DE-COMMISSION-INTERNE-D'ANALYSE-DU-DAO-N°";//4 il reste 5 total 9
		String code = iservice.getCodeTable(pseudo, 51, 60,
				"T_SEANCES", "SEA_LIBELLE");
		System.out.println("****code SEANCE_LIBELLE =" + code);
		return code;
	}
	
	public String getFonctionID(String codeTypeFonc, String minCode) {
		
		String pseudo = codeTypeFonc+minCode+"-";//7 il reste 5 total 12
		String IdFonc = iservice.getCodeTable(pseudo, new Integer(GRFProperties.FON_COD_SIZE_PSEUDO), new Integer(GRFProperties.FON_COD_SIZE),
				"fonction", "fon_cod");
		System.out.println("****Id de la Fonction =" + IdFonc);
		return IdFonc;
	}
	
	public String getDossierID(String imputationId) {
		
		String pseudo = imputationId+"D";//reste 1
		String IdDoss = iservice.getCodeTable(pseudo, 14, 16,
				"T_DOSSIERS", "CODE_DOS");
		System.out.println("****Id du Dossier =" + IdDoss);
		return IdDoss;
	}
	
	

	
public String genereCodeSection(String chaine) {
		String pseudo=chaine;
		String codesection=iservice.getCodeTable(pseudo, 1, 3,
				"T_SECTION", "SEC_CODE");
		return codesection;
	}
	
	

	
public String getTypeID(String pseudo, int taillePseudo, int taille, String table, String id) {
		
		String IdDoss = iservice.getCodeTable(pseudo, taillePseudo, taille,
				table, id);
		System.out.println("****Id du Type  =" + IdDoss);
		return IdDoss;
	}

public String getIdImputation(String minCode, String exoCode) {
	String exo=exoCode.substring(2);
	String pseudo=minCode+exo;
	String idImput=iservice.getCodeTable(pseudo, 5, 8,
			"T_IMPUTATIONS", "CODE_EXP_IMP");
	return idImput;
}


/* c'est ici que le code de la demande est generé
 chaine est la partie chaine de caractere du code, dans mon cas c'est PCAMU-
 exo est le cote annéé + le systeme de comptage
 15 signifie on compte 10 chiffre des code demande de la gauche a la la doite
  au dela des 10il commence a auto incrementer 
  20 signifie que le code aura une longueur de 15 caractere
  
 */
public String getIdNumArrete(String exo) {
	
	String pseudo=exo;
	String idDem=iservice.getCodeTable(pseudo, 5, 11,
			"T_DEMANDES", "DEM_NUM_ARRETE");
	return idDem;
}


/*public String getIdDemande(String chaine, String exo) {
	
	String pseudo=chaine+exo;
	String idDem=iservice.getCodeTable(pseudo, 15, 20,
			"T_DEMANDES", "DEM_CODE");
	return idDem;
}
*/
public String getCodeVisaDetail(String chaine, String exo) {
	
	String pseudo=chaine+exo;
	String codeVisa=iservice.getCodeTable(pseudo, 15, 20,
			"T_DEMANDE_DETAIL", "DED_CODE");
	return codeVisa;
}

public String getCodeDao(String exo) {
	
	String pseudo=exo;
	String codeDao=iservice.getCodeTable(pseudo, 9, 13,
			"T_DAC_SPECS", "DAC_CODE");
	return codeDao;
}

//Generer code beneficiaire T-00001
public String getCodeTier(String exo) {
	String pseudo=exo;
	String code=iservice.getCodeTable(pseudo, 2, 10,
			"T_TIERS", "TIER_COD");
	return code;
}

//Methode avec serie 2019-206-0000000003
public String getIdDemande(String exo) {
	String pseudo=exo;
	String idDem=iservice.getCodeTable(pseudo, 10, 20,
			"T_ACTE_DEPENSE", "ADEP_NUM_DE");
	return idDem;
}


//Methode avec serie 2019-206-0000000001
/*public String getIdOrdreRecette(String exo) {
	String pseudo=exo;
	String idRec=iservice.getCodeTable(pseudo, 10, 20,
			"T_ORDRE_RECETTE", "OREC_NUM_DE");
	return idRec;
}*/

//Methode avec serie 2019-206-0000000001
public String getNumRecette(String ex) {
	String pseudo=ex;
	String idRec=iservice.getCodeTable(pseudo, 10, 20,
			"T_ORDRE_RECETTE", "OREC_NUM_DE");
	return idRec;
}

/*//Methode avec serie PS-2019-206-0000000003
public String getIdDemande( String exo) {
	
	String pseudo=exo;
	String idDem=iservice.getCodeTable(pseudo, 12, 20,
			"T_ACTE_DEPENSE", "ADEP_NUM_DE");
	return idDem;
}*/
public String getCodePiece( String exo) {
	
	String pseudo=exo;
	String codepiece=iservice.getCodeTable(pseudo, 4, 10,
			"T_PIECE_JUSTIF", "PIJU_NUM");
	return codepiece;
}


public String getOperateurCode() {
	
	String pseudo = "EMAP";//4 il reste 5 total 9
	String code = iservice.getCodeTable(pseudo, 4, 10,
			"T_OPERATEUR", "OPE_MATRICULE");
	System.out.println("****code T_OPERATEUR =" + code);
	return code;
}

public String getCodeFonction(String codeTypeFonc, String strCode) {
	String pseudo = codeTypeFonc+strCode;//7 il reste 3 total 12
	String code = iservice.getCodeTable(pseudo, 7, 12,
			"T_FONCTION", "FON_COD");
	System.out.println("****code T_FONCTION =" + code);
	return code;
}

public String getRectCode(String pseudo) {
	
	String code = iservice.getCodeTable(pseudo, 11, 20,
			"T_RECTIF_BUD", "RECT_CODE");
	System.out.println("****code RECT_CODE =" + code);
	return code;
}


public String getfonctionCodeusa(String pseudo) {
	String code = iservice.getCodeTable(pseudo, 5, 9,
			"T_FONCTION", "FON_COD");
	System.out.println("****code T_FONCTION =" + code);
	return code;
}

public String getSessionCode(String chaine, String exo) {
	String pseudo=chaine+exo;
	String code = iservice.getCodeTable(pseudo, 9, 13,
			"T_SESSION", "SES_CODE");
	return code;
}
public String getCodeDossier(String chaine) {
	String pseudo=chaine;
	String idDoss=iservice.getCodeTable(pseudo, 25, 27,
			"T_DOSSIER_DACS", "DDA_COMMENTAIRE");
	return idDoss;
}

public String getCodeDossierAAO(String chaine) {
	String pseudo=chaine;
	String idDoss=iservice.getCodeTable(pseudo, 16, 20,
			"T_DOSSIER_AAO", "DAA_CODE");
	return idDoss;
}

public String getCodeDossierArchi(String chaine) {
	String pseudo=chaine;
	String idDoss=iservice.getCodeTable(pseudo, 25, 27,
			"T_DOSSIERS", "DOS_CODE");
	return idDoss;
}



public String getCodeGroupe(String chaine) {
	
	String pseudo=chaine;
	String codegrp=iservice.getCodeTable(pseudo, 1, 3,
			"T_GROUPE", "GRP_CODE");
	return codegrp;
}

public String getCodeBordereau(String chaine) {
	
	String pseudo=chaine;
	String codefonc=iservice.getCodeTable(pseudo, 7, 13,
			"T_BORD_TRANS", "BOTR_NUM");
	return codefonc;
}

public String getCodeCom(String chaine) {
	
	String pseudo=chaine;
	String codecom=iservice.getCodeTable(pseudo, 3, 5,
			"T_COMMISSION", "COM_CODE");
	return codecom;
}

public String getMat(String minCode) {
	
	String pseudo="PAR"+minCode;
	String idImput=iservice.getCodeTable(pseudo, 6, 9,
			"T_PARTICIPANTS", "PAR_MATRICULE");
	return idImput;
}

public String getNumProgrammation() {
	
	String pseudo="";
	String idProg=iservice.getCodeTable(pseudo, 0, 5,
			"T_IMPUTATIONS", "IMP_PRE_NUM");
	return idProg;
}

public String getNumAttestation() {
	
	String pseudo="";
	String idProg=iservice.getCodeTable(pseudo, 0, 4,
			"T_IMPUTATIONS", "IMP_NUM_ATT");
	return idProg;
}

public String getNumOrdreMission(String exoCode) {
	String exo=exoCode.substring(2);
	String pseudo=exo;
	String idPart=iservice.getCodeTable(pseudo, 2, 4,
			"T_PARTICIPATIONS", "PA_N_ORDRE");
	return idPart;
}

public String getNextOrdreMission(String num, int key) {

	BigDecimal	bv = new BigDecimal(num);
	String numOrd = "";
	String tC = String.valueOf(4);
		Integer v = bv.intValue();
		v = v +key;
		 numOrd= String.format("%0"+tC+"d", v);
		System.out.println("///////Verification requette numrd ="+numOrd);
	
	return numOrd;
}
	
}
