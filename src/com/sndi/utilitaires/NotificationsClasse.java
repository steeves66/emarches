/*package com.sndi.utilitaires;

import org.apache.log4j.Logger;

import com.sndi.model.TImputationStatuts;
import com.sndi.model.TImputations;



public class NotificationsClasse {
	Logger _logger = Logger.getLogger(NotificationsClasse.class);

	
	static public void sendNotififation(TImputations imp,String pointFocal, TImputationStatuts ist, String destinataireEmail, String initiateurEmail) {
		if(imp.getStatutImp().endsWith("T"))
		SendMail.envoiMail(imp.getCodeExpImp(),imp.getObjetImp(),pointFocal,ist.getTStatuts().getStatmissionLibelle(),StatutClasse.returnDelai(imp.getStatutImp()),destinataireEmail, initiateurEmail);
	}
	static public void sendNotififationTest(TImputations imp,String pointFocal, TImputationStatuts ist, String destinataireEmail, String initiateurEmail) {
		
			SendMail.envoiMail(imp.getCodeExpImp(),imp.getObjetImp(),pointFocal,ist.getTStatuts().getStatmissionLibelle(),StatutClasse.returnDelai(imp.getStatutImp()),destinataireEmail, initiateurEmail);
	}
	
	static public void sendNotififationDifferer(TImputations imp,String pointFocal, TImputationStatuts ist, String destinataireEmail, String initiateurEmail) {
			SendMail.envoiMail(imp.getCodeExpImp(),imp.getObjetImp(),pointFocal,ist.getTStatuts().getStatmissionLibelle(),StatutClasse.returnDelai(imp.getStatutImp()),destinataireEmail, initiateurEmail);
	}
	
	static public void sendNotififationReponseDifferer(TImputations imp,String pointFocal, TImputationStatuts ist, String destinataireEmail, String initiateurEmail) {
			SendMail.envoiMail(imp.getCodeExpImp(),imp.getObjetImp(),pointFocal,ist.getTStatuts().getStatmissionLibelle(),StatutClasse.returnDelai(imp.getStatutImp()),destinataireEmail, initiateurEmail);
	}
}
*/