package com.sndi.controller.admin;

public class OperateurFilter {
	  private String statut="", matricule="", nom="", prenom="",nomComplet="", email="",login="",contact="", lettre="";

		public String getStatut() {
			return statut;
		}
		public void setStatut(String statut) {
			this.statut = statut==null?"":statut.trim();
		}
		public String getMatricule() {
			return matricule;
		}
		public void setMatricule(String matricule) {
			this.matricule = matricule==null?"":matricule.trim();
		}
		public String getNom() {
			return nom;
		}
		public void setNom(String nom) {
			this.nom = nom==null?"":nom.trim();
		}
		public String getPrenom() {
			return prenom;
		}
		public void setPrenom(String prenom) {
			this.prenom = prenom==null?"":prenom.trim();
		}
		public String getNomComplet() {
			return nomComplet;
		}
		public void setNomComplet(String nomComplet) {
			this.nomComplet = nomComplet==null?"":nomComplet.trim();
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email==null?"":email.trim();
		}
		public String getLogin() {
			return login;
		}
		public void setLogin(String login) {
			this.login = login==null?"":login.trim();
		}
		public String getContact() {
			return contact;
		}
		public void setContact(String contact) {
			this.contact = contact==null?"":contact.trim();
		}
		public String getLettre() {
			return lettre;
		}
		public void setLettre(String lettre) {
			this.lettre = lettre==null?"":lettre.trim();
		}
		
		

}
