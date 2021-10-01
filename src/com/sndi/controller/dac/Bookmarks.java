package com.sndi.controller.dac;

import java.util.Arrays;
import java.util.List;

public class Bookmarks {
	
	private static String[] bookmarksArray = new String[] { 
			"PG_min",
			"PG_min_02",
			"PG_ac",
			"PG_ac_02",
			"PG_gestion",
			"PG_gestion_02",
			"PG_objet",
			"PG_objet_03",
			"PG_moisAnGestion",
			"PG_objet_02",
			"PG_imputation_02",
					
			/* AVIS D'APPEL D'OFFRE */
			"AAO_ac",
			"AAO_min",
			"AAO_objet",
			"AAO_nombre_lots",
			"AAO_nombre_lots_02",
			"AAO_table_lots",
			"AAO_source_financement",
			"AAO_gestion",
			"AAO_cout_dao",
			"AAO_adresse_retrait",
			"AAO_date_remise",
			"AAO_heure_remise",
			"AAO_lieu_remise",
			"AAO_date_ouverture",
			"AAO_table_caution",
			"AAO_delai_validite",
			"AAO_date",
					
			/* LETTRE D'INVITATION AU CANDIDAT */
			"LC_date_invitation",
			"LC_ac_02",
			"LC_objet",
			"LC_reference_courrier",
			"LC_table_entreprise",
			"LC_adresse_retrait",
			"LC_cout_dao",
			"LC_date_remise",
			"LC_heure_remise",
			"LC_lieu_remise",
			"LC_lieu_remise",
			"LC_date_ouverture",
			"LC_delai_validite",
					
			/* DPAO - RPAO */
			"DPAO_ac",
			"DPAO_ac01",
			"DPAO_nombre_lots",
			"DPAO_nombre_lots_02",
			"DPAO_objet",
			"DPAO_table_lots",
			"DPAO_source_financement",
			"DPAO_imputation",
			"DPAO_table_du_personnel",
			"DPAO_table_des_materiels",
			"DPAO_lieu_destination",
			"DPAO_adresse_clarification",
			"DPAO_adresse_reunion_preparatoire",
			"AAO_table_cautionnement",
			"DPAO_adresse_visite_site",
			"DPAO_delai_execution",
			"DPAO_lieu_livraison",
			"DPAO_delai_validite",
			"DPAO_cautionnement_provisoire",
			"DPAO_nombre_copie",
			"DPAO_nombre_copie_02",
			"DPAO_adresse_remiseDPAO_date_remise",
			"DPAO_lieu_remise",
			"DPAO_heure_remise",
			"DPAO_adresse_ouverture",
			"DPAO_adresse_conference_prealable",
			"DPAO_adresse_demande_eclaircissement",
			"DPAO_date_ouverture",
			"DPAO_heure_ouverture",
			"AAO_table_cautionnement",
			"DPAO_heure_conference_prealable",
			"DPAO_reunion_preparatoire",
			"DPAO_heure_reunion_preparatoire",
			"DPAO_visite_site",
			"DPAO_heure_visite_site",
			"DPAO_mode_renumeration",
			"DPAO_texte_marche_renouvelable",
			"DPAO_marche_renouvelable",
	};
	
	static List<String> bookmarksList = Arrays.asList(bookmarksArray);
	
	public static List<String> getBookmarks(){
		return bookmarksList;
	}

}
