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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.net.ssl.HttpsURLConnection;

//import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.primefaces.json.JSONException;
import org.primefaces.json.JSONObject;
import org.springframework.security.crypto.codec.Base64;
public class Paiement {
Logger _logger = Logger.getLogger(SendSms.class);

	private String numUser;
	private String message;
	private String clientID;
	private String clientSecret;
	private static String accesToken;
	private static String url;
	private static String transId;
	private static String signature;
	
	static public void genererTransId() {
		
		Random rand = new Random();
		String str="";
		for(int i = 0 ; i < 20 ; i++){
		  char c = (char)(rand.nextInt(26) + 97);
		  str += c;
		  
		}
		 transId=str;
	}
	
	static public void recupereSignature(String montant) throws IOException {
		 try {
		genererTransId();
		//preparation du format de date
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String dateTrans = df.format(Calendar.getInstance().getTime());
		
		url="https://api.cinetpay.com/v1/?method=getSignatureByPost";
		 URL urls = new URL(url);
		 HttpsURLConnection uc = (HttpsURLConnection) urls.openConnection();
		 
		 uc.setRequestMethod("POST");
		 
		 uc.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		 
		// String postData="grant_type=client_credentials";
//		 Map<String, Object> postData = new HashMap<String, Object>();
//		 postData.put("cpm_amount", montant);
//		 postData.put("cpm_currency", "CFA");
//		 postData.put("cpm_site_id", "621365");
//		 postData.put("cpm_trans_id", transId);
//		 postData.put("cpm_trans_date",dateTrans);
//		 postData.put("cpm_payment_config","SINGLE");
//		 postData.put("cpm_page_action", "PAYMENT");
//		 postData.put("cpm_version ", "V1");
//		 postData.put("cpm_language", "fr");
//		 postData.put("cpm_designation", "Paiement GUPC");
//		 postData.put("cpm_custom", "");
//		 postData.put("apikey", "982324575bdf58e253bfb2.47995096");
		 String postData="cpm_amount="+montant+"&cpm_currency=CFA&cpm_site_id=621365&cpm_trans_id="+transId+"&cpm_trans_date="+dateTrans+"&cpm_payment_config=SINGLE&cpm_page_action=PAYMENT&cpm_version=V1&cpm_language=fr&cpm_designation=paiementGUPC&cpm_custom=&apikey=982324575bdf58e253bfb2.47995096";
		 
		 uc.setDoOutput(true);
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
signature=response.toString();
System.out.println("Valeur retournée: "+response.toString());
		 }
catch (ConnectException e) {
	// TODO Auto-generated catch block
	System.out.println(" probleme de connexion");
}

	}
	
	static public void envoieInfo(String montant) throws IOException{
		
			genererTransId();
			//preparation du format de date
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String dateTrans = df.format(Calendar.getInstance().getTime());
			
			String lien="https://secure.cinetpay.com/";
			 URL urls = new URL(lien);
			 HttpsURLConnection uc = (HttpsURLConnection) urls.openConnection();
			 
			 uc.setRequestMethod("POST");
			 
			 uc.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		
			 String postData="cpm_amount="+montant+"&cpm_currency=CFA&cpm_site_id=621365&cpm_trans_id="+transId+"&cpm_trans_date="+dateTrans+"&cpm_payment_config=SINGLE&cpm_page_action=PAYMENT&cpm_version=V1&cpm_language=fr&cpm_designation=paiementGUPC&cpm_custom=&apikey=982324575bdf58e253bfb2.47995096&signature="+signature;
			 try {
			 uc.setDoOutput(true);
			 DataOutputStream wr= new DataOutputStream(uc.getOutputStream());
			 wr.writeBytes(postData);
			 wr.flush();
			// wr.close();
			 String retcode=uc.getResponseMessage();
			 int responseCode = uc.getResponseCode();
			 System.out.println("\nSending 'POST' request to URL: " + lien);
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
	
	
	System.out.println("Element retourné: "+response.toString());
	
	  FacesContext fc = FacesContext.getCurrentInstance();
      ExternalContext ec = fc.getExternalContext();
      ec.redirect(lien);
     System.out.println("Fin redirection: "+uc.toString());
     
			 }
	catch (ConnectException e) {
		// TODO Auto-generated catch block
		System.out.println(" probleme de connexion");
	}
			 
					 //uc.toString();

	}
	static public void actionPaiement(String montant) throws IOException{
		recupereSignature(montant);
		envoieInfo(montant);
		
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
	public static String getAccesToken() {
		return accesToken;
	}
	public static void setAccesToken(String accesToken) {
		Paiement.accesToken = accesToken;
	}
	public static String getUrl() {
		return url;
	}
	public static void setUrl(String url) {
		Paiement.url = url;
	}

	public String getTransId() {
		return transId;
	}

	public void setTransId(String transId) {
		Paiement.transId = transId;
	}

	public static String getSignature() {
		return signature;
	}

	public static void setSignature(String signature) {
		Paiement.signature = signature;
	}
	

}
