package com.sndi.dao;

import java.util.HashMap;

public class WhereClause {
	public enum Comparateur{ 
		EQ, NEQ, LIKE, INF, SUP, IS_NULL, IS_NOT_NULL,BET,NOTL,IN;		
	}
	private String colonne;
	private String valeur;
	private Comparateur comparateur;


   public WhereClause(String colonne, Comparateur comparateur, String valeur) {
		super();
		this.colonne = colonne;
		this.comparateur = comparateur;
		this.valeur = valeur;
	}

   public WhereClause(String colonne, Comparateur comparateur) {
		super();
		this.colonne = colonne;
		this.comparateur = comparateur;
		this.valeur = null;

	}
   public String getColonne() {
		return colonne;
	}

	public void setColonne(String colonne) {
		this.colonne = colonne;
	}

	public String getValeur() {
		return valeur;
	}

	public void setValeur(String valeur) {
		this.valeur = valeur;
	}

	public String getComparateur( ) {
		String result = "";
		   switch (comparateur) {
           case EQ:
        	   result = " = ";
               break;
           case NEQ:
        	   result = " <> ";
               break;
                   
           case LIKE:
        	   result = " LIKE ";
        	   break;
                        
           case INF: 
        	   result = " <= ";
               break;
               
           case SUP:
        	   result = " >= ";
        	   break;
        	   
           case IS_NULL:
        	   result = " IS NULL ";
               break;
               
           case IS_NOT_NULL:
        	   result = " IS NOT NULL ";
               break;
               
           case BET:
        	   result=" BETWEEN ";
               break;
           
           case NOTL:
           		result=" NOT LIKE ";
           		break;
           case IN:
          		result=" IN ";
          		break;		
               
           default:
        	   result = " = ";
               break;
       }
		return result;
	}
	
	public void setComparateur(Comparateur comparateur) {
		this.comparateur = comparateur;
	}



}
