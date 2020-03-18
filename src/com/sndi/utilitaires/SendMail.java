package com.sndi.utilitaires;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

public class SendMail {
	/**
	   Outgoing Mail (SMTP) Server
	   requires TLS or SSL: smtp.gmail.com (use authentication)
	   Use Authentication: Yes
	   Port for TLS/STARTTLS: 587
	 */
	
	public static void envoiMail(String codeExpImp, String objet, String pointFocal, String statut, String delai, String destinataireEmail, String initiateurEmail) {
		final String fromEmail = "herve.bah@sndi.ci"; //requires valid gmail id
		final String password = "bebechougerardineBB"; // correct password for gmail id
		//final String toEmail = "c.nguessan@sndi.ci"; // can be any email id 
		
		System.out.println("TLSEmail Start");
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp2.sndi.ci"); //SMTP Host
		props.put("mail.smtp.port", "25"); //TLS Port
		props.put("mail.smtp.auth", "true"); //enable authentication
		props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
		
                //create Authenticator object to pass in Session.getInstance argument
		Authenticator auth = new Authenticator() {
			//override the getPasswordAuthentication method
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		};
		Session session = Session.getInstance(props, auth);
		
		EmailUtil.sendEmail(session, destinataireEmail, initiateurEmail,"SIGMission- Dossier N° "+codeExpImp+" : s"+objet, "Une Mission du "+pointFocal +" Statut du Dossier: "+statut+" est en attente. Merci de bien vouloir traiter ce dossier dans un delai de "+delai);
		
	}
	@Async
	public static void envoiMailRelance(String objet, String msg, String statut, String delai ) {
		final String fromEmail = "herve.bah@sndi.ci"; //requires valid gmail id
		final String password = "bebechougerardineBB"; // correct password for gmail id
		final String toEmail = "c.nguessan@sndi.ci"; // can be any email id 
		
		System.out.println("TLSEmail Start");
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp2.sndi.ci"); //SMTP Host
		props.put("mail.smtp.port", "25"); //TLS Port
		props.put("mail.smtp.auth", "true"); //enable authentication
		props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
		
		//create Authenticator object to pass in Session.getInstance argument
		Authenticator auth = new Authenticator() {
			//override the getPasswordAuthentication method
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		};
		Session session = Session.getInstance(props, auth);
		
		EmailUtil.sendEmail(session, toEmail, "","SIGMission-"+objet, "TLSEmail Testing SIGMission Body");
		
	}

}	
