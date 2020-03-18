package com.sndi.utilitaires;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;

//import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.primefaces.json.JSONException;
import org.primefaces.json.JSONObject;
import org.springframework.security.crypto.codec.Base64;

public class SendSms {
	Logger _logger = Logger.getLogger(SendSms.class);
	
	private String numUser;
	private String message;
	private String clientID;
	private String clientSecret;
	private static String accesToken;
	private static String url;
	private static String basicAuth="Basic ZVRHM1JabmNvSk43U0IwVEd6UzlRWnR5RGZ3S1hST2E6dG12elV6R1RTUm11dGlvdg==";
	
	
	static public void recupererAccesToken() throws IOException {
	 try {
		url="https://api.orange.com/oauth/v2/token";
		 URL urls = new URL(url);
		 HttpsURLConnection uc = (HttpsURLConnection) urls.openConnection();
		 
		 uc.setRequestMethod("POST");
		 uc.setRequestProperty("Authorization", basicAuth);
		 uc.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		 
		 String postData="grant_type=client_credentials";

		 uc.setDoOutput(true);
		 
		 //uc.connect();
		 DataOutputStream wr= new DataOutputStream(uc.getOutputStream());
		 wr.writeBytes(postData);
		 wr.flush();
		 wr.close();
		 String retcode=uc.getResponseMessage();
		 int responseCode = uc.getResponseCode();
		 System.out.println("\nSending 'POST' request to URL: " + url);
		 System.out.println("Post parameters: " + postData);
		 System.out.println("Response Code: " + responseCode);
		 System.out.println(retcode);
		 
		BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
		String inputLine;
		StringBuffer response =  new StringBuffer();
		while((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
   in.close();
   System.out.println(response.toString());
		
   JSONObject obj= new JSONObject(response.toString());
   
   accesToken = obj.getString("access_token");
   System.out.println("Valeur du acces token "+accesToken);
   
 
		// InputStreamReader inputStreamReader = new InputStreamReader(uc.getInputStream());
	} catch(ConnectException e) {
		// TODO Auto-generated catch block
		System.out.println("Echec lors de l'envoie du SMS - probleme de connexion");
	}
	}
	
	static public void envoyerSms(String numero,String msg) throws IOException {
		  try {
			System.out.println("Valeur du acces token dans le send sms "+accesToken);
			//String numero="tel:+22507064709";
			//String msg="Enfin  cest bon";
			String lien="https://api.orange.com/smsmessaging/v1/outbound/tel%3A%2B22500000000/requests";
			String myAuth = "Bearer "+accesToken;
			URL urls = new URL(lien);
			 HttpsURLConnection uc = (HttpsURLConnection) urls.openConnection();
			 
			 uc.setRequestMethod("POST");
			 uc.setRequestProperty("Authorization", myAuth);
			 uc.setRequestProperty("Content-Type", "application/json");
			 
			 
			 JSONObject textMessage = new JSONObject();
			 textMessage.put("message", msg);
			 
			 JSONObject smsMessage = new JSONObject();
			 smsMessage.put("address", numero);
			 smsMessage.put("senderAddress","tel:+22500000000");
			 smsMessage.put("outboundSMSTextMessage", textMessage);
			 
			 
			 JSONObject message = new JSONObject();
			 message.put("outboundSMSMessageRequest",smsMessage);
			 
			 
			 uc.setDoOutput(true);
			 DataOutputStream wr= new DataOutputStream(uc.getOutputStream());
			 wr.writeBytes(message.toString());
			 wr.flush();
			 wr.close();
			 String retcode=uc.getResponseMessage();
			 int responseCode = uc.getResponseCode();
			 System.out.println("\nSending 'POST' request to URL: " + lien);
			 System.out.println("Post parameters: " + message.toString());
			 System.out.println("Response Code: " + responseCode);
			 System.out.println(retcode);
			 
			BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
			String inputLine;
			StringBuffer response =  new StringBuffer();
			while((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
   in.close();
   System.out.println(response.toString());
		} catch (ConnectException e) {
			// TODO Auto-generated catch block
			System.out.println("Echec lors de l'envoie du SMS - probleme de connexion");
		}
	}
	static public void send(String numero,String msg) throws IOException{
		recupererAccesToken();
		envoyerSms(numero,msg);
		
	}
	public String getNumUser() {
		return numUser;
	}
	public void setNumUser(String numUser) {
		this.numUser = numUser;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getClientID() {
		return clientID;
	}
	public void setClientID(String clientID) {
		this.clientID = clientID;
	}
	public String getClientSecret() {
		return clientSecret;
	}
	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}
	public String getAccesToken() {
		return accesToken;
	}
	public void setAccesToken(String accesToken) {
		this.accesToken = accesToken;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	public String getBasicAuth() {
		return basicAuth;
	}

	public void setBasicAuth(String basicAuth) {
		this.basicAuth = basicAuth;
	}
	
}
