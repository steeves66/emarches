package com.sndi.controller.dac;

import java.util.HashMap;
import java.util.Map;

public class OpenDac {

	public static Map<String, String> getDacFile(){
		Map<String, String> fo = new HashMap<String, String>();
		fo.put("DEL", "FICHIER_UPLOAD_DAO_ENTRETIEN_DES_LOCAUX_LINUX"); // DAO ENTRETIEN DES LOCAUX
		fo.put("DRE", "FICHIER_UPLOAD_DAO_RESTAURATIONS_LINUX"); // DAO RESTAURATION
		fo.put("DFS", "FICHIER_UPLOAD_DAO_FOURNITURES_LINUX"); // DAO FOURNITURE ET SERVICES CONNEXES
		fo.put("DLM", "FICHIER_UPLOAD_DAO_LOCATION_MAIN_DOEUVRES_LINUX"); // DAO LOCATION MAIN D'OEUVRE
		fo.put("DGM", "FICHIER_UPLOAD_DAO_GESTION_DES_DOEUVRES_LINUX"); // DAO GESTION DE MAIN D'�UVRE OCCASIONNELLE
		fo.put("DSP", "FICHIER_UPLOAD_DAO_SECURITE_PRIVEE_LINUX"); // DAO SECURITE PRIVEE
		fo.put("DCA", "FICHIER_UPLOAD_DAO_CARBURANT_LEGER_LINUX"); // DAO CARBURANT
		fo.put("DTR", "FICHIER_UPLOAD_DAO_TRAVAUX_LINUX"); // DAO TRAVAUX
		fo.put("DPC", "FICHIER_UPLOAD_DAO_PRESTATIONS_LINUX"); // PRESTATIONS COURANTES
		fo.put("LVM", ""); // LETTRE DE COMMANDE VALANT MARCHE
		fo.put("DAS", "FICHIER_UPLOAD_DAO_ASSURANCE_LINUX"); // DAO ASSURANCE PN
		fo.put("DOM", "FICHIER_UPLOAD_DAO_PRESTATIONS_LINUX"); // DAO ORDURES MENAGERES
		fo.put("AMI", ""); // AVIS A MANIFESTATION D'INTERET
		fo.put("PRQ", ""); // PREQUALIFICATION
		fo.put("DPR", "FICHIER_UPLOAD_PRESTATION_INTELLECTUEL_PS_LINUX"); // DAO PRESTATION (intellectuelle)
		
		fo.put("AMIPS", "");  // AVIS A MANIFESTATION D'INTERET (Proc�dure Simplifi�e)
		fo.put("DAP", ""); // DAO ASSURANCE PS
		fo.put("AMS", ""); // AVIS A MANIFESTATION D'INTERET (Proc�dure Simplifi�e)
		fo.put("SLT", "FICHIER_UPLOAD_TRAVAUX_PSL_LINUX"); // DOSSIER DE CONSULTATION PSL TRAVAUX
		fo.put("SLF", "FICHIER_UPLOAD_FOURNITURES_PSL_LINUX"); // DOSSIER DE CONSULTATION PSL FOURNITURES
		fo.put("SLP", "FICHIER_UPLOAD_SERVICES_COURANTS_PSL_LINUX"); // DOSSIER DE CONSULTATION PSL PRESTATIONS
		fo.put("SOT", "FICHIER_UPLOAD_TRAVAUX_PSO_LINUX"); // DOSSIER DE CONSULTATION PSO TRAVAUX
		fo.put("SOF", "FICHIER_UPLOAD_FOURNITURES_PSO_LINUX"); // DOSSIER DE CONSULTATION PSO FOURNITURES
		fo.put("SOP", "FICHIER_UPLOAD_SERVICES_COURANTS_PSO_LINUX"); // DOSSIER DE CONSULTATION PSO PRESTATIONS
		fo.put("SIP", "FICHIER_UPLOAD_PRESTATION_INTELLECTUEL_PS_LINUX"); // DOSSIER DE CONSULTATION PSI PRESTATIONS
		fo.put("SCT", ""); // DOSSIER DE CONSULTATION PSC TRAVAUX
		fo.put("SCF", ""); // DOSSIER DE CONSULTATION PSC FOURNITURES
		fo.put("SCP", ""); // DOSSIER DE CONSULTATION PSC PRESTATIONS
		fo.put("DFC", ""); // DAO CARBURANTS
		
		fo.put("BT-BM", ""); // DAO TRAVAUX BANQUE MONDIALE (BM)
		fo.put("BF-BM", ""); // DAO FOURNITURES BANQUE MONDIALE (BM)
		fo.put("BP-BM", ""); // DAO PRESTATIONS INTELLECTUELLES (DP)  BANQUE MONDIALE (BM)
		fo.put("BPC-BM", ""); // DAO PRESTATIONS COURANTES (DP) BANQUE MONDIALE (BM)
		fo.put("BA-BM", ""); // AMI BANQUE MONDIALE
		fo.put("BQ-BM", ""); // PRQ BANQUE MONDIALE
		
		fo.put("BT-BAD", ""); // DAO TRAVAUX BANQUE AFRICAINE DE DEVELOPPEMENT (BAD)
		fo.put("BF-BAD", ""); // DAO FOURNITURESBANQUE AFRICAINE DE DEVELOPPEMENT (BAD)
		fo.put("BP-BAD", ""); // DAO PRESTATIONS INTELLECTUELLES (DP) BANQUE AFRICAINE DE DEVELOPPEMENT (BAD)
		fo.put("BPC-BAD", ""); // DAO PRESTATIONS (COURANTES (DP) BANQUE AFRICAINE DE DEVELOPPEMENT (BAD)
		fo.put("BA-BAD", ""); // AMI BANQUE AFRICAINE DE DEVELOPPEMENT (BAD)
		fo.put("BQ-BAD", ""); // PRQ BANQUE AFRICAINE DE DEVELOPPEMENT (BAD)
		
		fo.put("BT-BID", ""); // DAO TRAVAUX BANQUE ISLAMIQUE DE D�VELOPPEMENT (BID)
		fo.put("BF-BID", "FICHIER_UPLOAD_DAO_BID_FOURNITURE"); // DAO FOURNITURES BANQUE ISLAMIQUE DE D�VELOPPEMENT (BID)
		fo.put("BP-BID", ""); // DAO PRESTATIONS INTELLECTUELLES (DP)  BANQUE ISLAMIQUE DE D�VELOPPEMENT (BID)
		fo.put("BPC-BID", ""); // DAO PRESTATIONS COURANTES (DP) BANQUE ISLAMIQUE DE D�VELOPPEMENT (BID)
		fo.put("BA-BID", ""); // AMI BANQUE ISLAMIQUE DE D�VELOPPEMENT (BID)
		fo.put("BQ-BID", ""); // PRQ BANQUE ISLAMIQUE DE D�VELOPPEMENT (BID)
		
		fo.put("BT-BOAD", ""); // DAO TRAVAUX BANQUE OUEST AFRICAINE DE D�VELOPPEMENT (BOAD)
		fo.put("BF-BOAD", ""); // DAO FOURNITURES BANQUE OUEST AFRICAINE DE D�VELOPPEMENT (BOAD)
		fo.put("BP-BOAD", ""); // DAO PRESTATIONS INTELLECTUELLES (DP)  BANQUE OUEST AFRICAINE DE D�VELOPPEMENT (BOAD)
		fo.put("BPC-BOAD", ""); // DAO PRESTATIONS COURANTES (DP) BANQUE OUEST AFRICAINE DE D�VELOPPEMENT (BOAD)
		fo.put("BA-BOAD", ""); // AMI BANQUE OUEST AFRICAINE DE D�VELOPPEMENT (BOAD)
		fo.put("BQ-BOAD", ""); // PRQ BANQUE OUEST AFRICAINE DE D�VELOPPEMENT (BOAD)
		
		fo.put("BT-JICA", ""); // DAO TRAVAUX AGENCE DE COOP�RATION INTERNATIONALE DU JAPON (JICA)
		fo.put("BF-JICA", ""); // DAO FOURNITURES AGENCE DE COOP�RATION INTERNATIONALE DU JAPON (JICA)
		fo.put("BP-JICA", ""); // DAO PRESTATIONS INTELLECTUELLES (DP)  AGENCE DE COOP�RATION INTERNATIONALE DU JAPON (JICA)
		fo.put("BPC-JICA", ""); // DAO PRESTATIONS COURANTES (DP) AGENCE DE COOP�RATION INTERNATIONALE DU JAPON (JICA)
		fo.put("BA-JICA", ""); // AMI AGENCE DE COOP�RATION INTERNATIONALE DU JAPON (JICA)
		fo.put("BQ-JICA", ""); // PRQ AGENCE DE COOP�RATION INTERNATIONALE DU JAPON (JICA)
		
		fo.put("BT-BOC", ""); // DAO TRAVAUX BANK OF CHINA
		fo.put("BF-BOC", ""); // DAO FOURNITURES BANK OF CHINA
		fo.put("BP-BOC", ""); // DAO PRESTATIONS INTELLECTUELLES (DP)  BANK OF CHINA
		fo.put("BPC-BOC", ""); // DAO PRESTATIONS COURANTES (DP) BANK OF CHINA
		fo.put("BA-BOC", ""); // AMI BANK OF CHINA
		fo.put("BQ-BOC", ""); // PRQ BANK OF CHINA
		
		fo.put("BT-BADEA", ""); // DAO TRAVAUX BANQUE ARABE POUR LE D�VELOPPEMENT ECONOMIQUE EN AFRIQUE (BADEA)
		fo.put("BF-BADEA", ""); // DAO FOURNITURES BANQUE ARABE POUR LE D�VELOPPEMENT ECONOMIQUE EN AFRIQUE (BADEA)
		fo.put("BP-BADEA", ""); // DAO PRESTATIONS INTELLECTUELLES (DP)  BANQUE ARABE POUR LE D�VELOPPEMENT ECONOMIQUE EN AFRIQUE (BADEA)
		fo.put("BPC-BADEA", ""); // DAO PRESTATIONS COURANTES (DP) BANQUE ARABE POUR LE D�VELOPPEMENT ECONOMIQUE EN AFRIQUE (BADEA)
		fo.put("BA-BADEA", ""); // AMI BANQUE ARABE POUR LE D�VELOPPEMENT ECONOMIQUE EN AFRIQUE (BADEA)
		fo.put("BQ-BADEA", ""); // PRQ BANQUE ARABE POUR LE D�VELOPPEMENT ECONOMIQUE EN AFRIQUE (BADEA)
		
		fo.put("BT-FK", ""); // DAO TRAVAUX FONDS KOWEITIEN
		fo.put("BF-FK", ""); // DAO FOURNITURES FONDS KOWEITIEN
		fo.put("BP-FK", ""); // DAO PRESTATIONS INTELLECTUELLES (DP)  FONDS KOWEITIEN
		fo.put("BPC-FK", ""); // DAO PRESTATIONS COURANTES (DP) FONDS KOWEITIEN
		fo.put("BA-FK", ""); // AMI FONDS KOWEITIEN
		fo.put("BQ-FK", ""); // PRQ FONDS KOWEITIEN
		
		fo.put("BF-AFD", ""); // DAO FOURNITURE AGENCE FRANCAISE DE DEVELOPPEMENT
		fo.put("BP-AFD", ""); // DAO PRESTATION AGENCE FRANCAISE DE DEVELOPPEMENT
		fo.put("BT-AFD", ""); // DAO TRAVAUX AGENCE FRANCAISE DE DEVELOPPEMENT
		
		fo.put("BT-GAVIAL", ""); // DAO TRAVAUX GAVIAL-ALLIANCE

		return fo;
	}
	
	

	// Traversing through the map
	/*for (Map.Entry<String, Integer> me : hm.entrySet()) {
		System.out.print(me.getKey() + ":");
		System.out.println(me.getValue());
	}*/
}