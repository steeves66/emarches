package com.sndi.utilitaires;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map.Entry;

import java.util.Properties;

import javassist.bytecode.stackmap.TypeData.ClassName;

public class RenderPages {
	
	private HashMap<String, String> mapPages;
	private HashMap<String, String> mapStatut;
	

	
	public String getPage(String value)throws IOException{
		//System.out.println("Ligne I");
		Properties properties = new Properties();
		//System.out.println("Fin Ligne I");
		
			//System.out.println("Ligne II");
			/*InputStream in = getClass().getClassLoader()
                    .getResourceAsStream("page.properties");
			System.out.println("Ligne III");*/
			InputStream in = null;
			in = getClass().getClassLoader()
                    .getResourceAsStream("pages.properties");
			if(in != null){
				//System.out.println("Fichier trouvé page.properties ="+properties.size());
				properties.load(in);
			
				//System.out.println("Fichier trouvé  page.properties Fin= "+properties.size());
			}else{
				throw new FileNotFoundException("Le fichier page.properties n'existe pas");
			}
			 mapPages = new HashMap<String, String>();
			Enumeration<?> e = properties.propertyNames();
			while (e.hasMoreElements()) {
				String key = (String) e.nextElement();
				String val = properties.getProperty(key);
				mapPages.put(key, val);
				
				
				//System.out.println("Key : " + key + ", Value : " + val);
			}
			if(in != null){
			in.close();
			}
		/*for (final Entry<Object, Object> entry : properties.entrySet()) {
			mapPages.put((String) entry.getKey(), (String) entry.getValue());
			System.out.println("Cle= "+entry.getKey()+"Valeur= "+entry.getValue());
		}*/
		
		//String page = "";
		String page = "/pages/notfound";
		//System.out.println("Ligne I dans getPage");
		
		return (!mapPages.containsKey(value)) ? page : mapPages.get(value) ;
	}
	
	public String getStatut(String code_statut)throws IOException{
	
		Properties properties = new Properties();
		
			InputStream in = null;
			in = getClass().getClassLoader()
                    .getResourceAsStream("statut.properties");
			if(in != null){	
				properties.load(in);
			}else{
				throw new FileNotFoundException("Le ficfier statut.properties n'existe pas");
			}
			mapStatut = new HashMap<String, String>();
			Enumeration<?> e = properties.propertyNames();
			while (e.hasMoreElements()) {
				String key = (String) e.nextElement();
				String val = properties.getProperty(key);
				mapStatut.put(key, val);
			}
			if(in != null){
			in.close();
			}
	String statut = "Aucune valeur";	
		return (!mapStatut.containsKey(code_statut)) ? statut : mapStatut.get(code_statut) ;
	}
}
