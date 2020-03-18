package com.sndi.utilitaires;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="session")
public class ChangeLocale implements Serializable{
	// la locale des pages
	 private String locale="fr";
	
	 public ChangeLocale() {
	 }
	
	 public String setFrenchLocale(){
	 locale="fr";
	 return null;
	 }
	
	 public String setEnglishLocale(){
	 locale="en";
	 return null;
	 }
	
	 public String getLocale() {
	 return locale;
	 }
}
