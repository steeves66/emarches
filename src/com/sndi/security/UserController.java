package com.sndi.security;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.sndi.dao.WhereClause;
import com.sndi.dao.WhereClause.Comparateur;
/*import com.sndi.model.Statut;
import com.sndi.model.SysJournal;*/
import com.sndi.model.TAssignation;
import com.sndi.model.TFonction;
import com.sndi.model.TMotdepasse;
import com.sndi.model.TOperateur;
import com.sndi.service.Iservice;
import com.sndi.utilitaires.AutorityClass;
import com.sndi.utilitaires.RenderPages;

@Component
@Scope(value="session")
public class UserController implements Serializable{
	Logger _logger = Logger.getLogger(UserController.class);

	private static final long serialVersionUID = 1L;
	private File fileProp = new File(getClass().getClassLoader().getResource("sigmicap.properties").getFile());
	private List<TAssignation> listeAss = new ArrayList<TAssignation>();
	private TOperateur operateur = new TOperateur();
	private TMotdepasse motdepasse = new TMotdepasse();
	private TFonction fonction = new TFonction();
	private Date dateCon;
	private TAssignation slctd = new TAssignation();
	private TAssignation slctdTb = new TAssignation();
	//private TExercices exercice = new TExercices();
	private AutorityClass autority = new AutorityClass();
	private String name;
	private String password;
	private String page="/pages/accueil";
	private String menu="/template/menu";
	private String EtatPanelPrincipal="true";
	private String EtatPanelAdmin="false";
	private  String workingDir="";
	private  String texteMsg="";
	private  String sevrityMsg="";
	private boolean  creer = true;
	private boolean  renderMsg = false;
	private RenderPages rp = new RenderPages();
	private HashSet <String> hsPrivileges = new HashSet <String >();
	//private Map<String, Statut> HM_STATUS = new HashMap<String, Statut>();


	@Autowired
	UserService userService;
	
	@Autowired
	Iservice iservice;
	
	@PostConstruct
	public void postConstru() throws IOException {
		 try {
		 File dir = new File("..");
		 workingDir = dir.getCanonicalPath();	
		
		//_logger.info("Une connexion de l'Opérateur: "+GRFProperties.updateProperty("EXERCICE", "2017",fileProp));
		creer = true;
		setOperateur(userService.getTOperateur());
		getListeAss().addAll(userService.getListeAss());
		getAssignation();
		//TODO REdireger vers la page de choix de fonction si il n'y a pas d'TAssignation default
		setFonction(getSlctd().getTFonction());
		userService.cleanAutority();
		userService.getAutorisation(getAutority(), getSlctd().getTFonction().getTTypeFonction());
		setAutority(userService.getAutoritys());
		//userService.setPrivileges(getSlctd().getTFonction());
		//setHmPrivileges(getSlctd().getTFonction());
		//setTOperateur(userService.getTOperateurs());
		setDateCon(userService.getDateCons());
		//traceSysJournal("Une connexion de l'Opérateur");
		_logger.info("Une connexion de l'Opérateur: "+userService.getTOperateur().getOpeMatricule());
		
		//setTStatuts();
		//chargeExo();
	
			} catch (Exception e) {
					       FacesContext.getCurrentInstance().getExternalContext().redirect("assign.jsf");
			
			}
}
	/*public void chargeExo() {
		 exercice = (new ArrayList<TExercices>(iservice.getObjectsByColumn("TExercices", new WhereClause("EXO_ETAT",Comparateur.EQ,GRFProperties.ETAT_ACTIVER)))).get(0);
	}*/
	
	public void initMessage() {
		 texteMsg="";
		 sevrityMsg="success";
		 renderMsg = false;
		
	}
	
	public  boolean getPrivillege(String fonCode) {
		boolean val =false;
		
		if (getSlctd().getTFonction().getFonCod().contains(fonCode)) val=true;  
		return val;
	}
	
	/*public void traceSysJournal(String traitement) {
		//String ip = getClientIp();
		//	String mac = getHostMac(ip);
		
		//String ipAdresse = "IP: "+ip+" MAC: "+mac;
		//	String ipAdresse = "IP: "+ip;
		SysJournal sj = new SysJournal();
		sj.setSyjDateaction(Calendar.getInstance().getTime());
		//sj.setSyjIpAdresse(ipAdresse);
		sj.setTFonction(getSlctd().getTFonction());
		sj.setSyjOpeMatricule(getSlctd().getTOperateur().getOpeMatricule()+ " "+getSlctd().getTOperateur().getOpeNom());
		sj.setSyjDescription(traitement);
		
		iservice.addObject(sj);
		
	}*/
	
	private static String getClientIp(){
		HttpServletRequest request = (HttpServletRequest)
	       FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String remoteAddr = "";

        if (request != null) {
            remoteAddr = request.getHeader("X-FORWARDED-FOR");
            if (remoteAddr == null) {
                remoteAddr = request.getRemoteAddr();
            }
        }

        return remoteAddr;
    }
	
	private static String getHostMac(String ipAdresse){
		String macAdresse = "";
		try {
			InetAddress adr = InetAddress.getByName(ipAdresse);
			
			NetworkInterface network = NetworkInterface.getByInetAddress(adr);
			if (network != null) {
				byte[] mac = network.getHardwareAddress();
			
				if (mac != null) {
					StringBuffer sb = new StringBuffer();
					for(int i = 0; i < mac.length; i++) {
						sb.append(String.format("%02X%s", mac[i], (i< mac.length-1) ? "-" : ""));
					}
					macAdresse = sb.toString();
				}
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return macAdresse;
	}
	
	public String renderPage(String value) throws IOException{
		//_logger.info("----------------Value Page ouverte: "+value);
		//if(rp.getPage(value).)
		setPage(rp.getPage(value));
		_logger.info("----------------Page ouverte: "+getPage());
		
		return getPage()+"?faces-redirect=true";
	}
	
	/*public void setTStatuts(){
		List<Statut> statutList =  iservice.getObjects("Statut");
	     //  _logger.info("statutList.size :"+ statutList.size());
	
		HashMap<String, Statut> aMap = new HashMap<String, Statut>();
		for (Statut st: statutList) {
			aMap.put(""+st.getIdstat(), st);
		      // _logger.info("st.getStCode() :"+ st.getStatmissionCode());
		     //  _logger.info("st.getStLibelle() :"+ st.getStatmissionLibelle());

		}
		HM_STATUS =  Collections.unmodifiableMap(aMap);
	   // _logger.info("HM_STATUS.size :"+ HM_STATUS.size());

	}*/
	
	public String checkSaisie(){
		String typeFon = fonction.getTTypeFonction().getTyfCod();
		String val= "false";
			 	 if(typeFon.equalsIgnoreCase("AXX")||typeFon.equalsIgnoreCase("MXX")
			 	||typeFon.equalsIgnoreCase("MAX")||typeFon.equalsIgnoreCase("MTX")
			 	||typeFon.equalsIgnoreCase("MTA")||typeFon.equalsIgnoreCase("TXX")
			 	||typeFon.equalsIgnoreCase("TAX")){ val = "true";}else {val= "false";}

		return val;
	
	}	
	
	public String checkSaisieA(){
		String typeFon = fonction.getTTypeFonction().getTyfCod();
		String val= "";
		
		
		if(typeFon.equalsIgnoreCase("AXX")
				||typeFon.equalsIgnoreCase("MAX")||typeFon.equalsIgnoreCase("MTA")
				||typeFon.equalsIgnoreCase("TAX")){val= "AA";}
		// _logger.info("Value check :"+ val);
		return val;
		
	}	
	public String checkSaisieM(){
		String typeFon = fonction.getTTypeFonction().getTyfCod();
		String val= "";
		if(typeFon.equalsIgnoreCase("MXX")
				||typeFon.equalsIgnoreCase("MAX")||typeFon.equalsIgnoreCase("MTX")
				||typeFon.equalsIgnoreCase("MTA")){ val = "MN";}
					
				
		//_logger.info("Value check :"+ val);
		return val;
		
	}	
	public String checkSaisieT(){
		String typeFon = fonction.getTTypeFonction().getTyfCod();
		String val= "";
		
					
					if(typeFon.equalsIgnoreCase("MTX")
							||typeFon.equalsIgnoreCase("MTA")||typeFon.equalsIgnoreCase("TXX")
							||typeFon.equalsIgnoreCase("TAX")){val= "TR";}
		//_logger.info("Value check :"+ val);
		return val;
		
	}	
	
	
	
	/*public String renderTStatuts(String code_statut){
		return HM_STATUS.get(code_statut).getLibellestat();
	
	}*/
	
	/*public Statut getTStatuts(String code_statut){
		return HM_STATUS.get(code_statut);
	
	}*/
	
	public void getAssignation(){
		for(TAssignation ass: getListeAss()){
			if(ass.getAssCourant().equalsIgnoreCase("O")){
				setSlctd(ass);
			}
		}
	}
	

	public TOperateur getEmploye(TFonction f){
		TOperateur e = new TOperateur();
		for(TAssignation ass: f.getTAssignations()){
			if(ass.getAssCourant().equalsIgnoreCase("O")){
				e = ass.getTOperateur();
			}
		}
		return e;
	}
	public String getEmailEmploye(String foncCode){
		try {
			TOperateur e = new TOperateur();
			TFonction f = ((List<TFonction>) iservice.getObjectsByColumn("TFonction", new WhereClause("fonCod",Comparateur.LIKE,"%"+foncCode+"%"))).get(0);
			for(TAssignation ass: f.getTAssignations()){
				//if(ass.getAssCourant().equalsIgnoreCase("O")){
					e = ass.getTOperateur();
				//}
			}
			
			_logger.info("email employé :"+ e.getOpeMail());
			return e.getOpeMail()== null ? "s.youin@sndi.ci": e.getOpeMail();
		} catch (java.lang.IndexOutOfBoundsException e) {
			_logger.info(" pas d'email d'employé trouvé :");
			return "s.youin@sndi.ci";
		}
	}	
	public void changFonction() throws IOException{
	//	renderPage("0");
		if(!creer){
			setFonction(getSlctd().getTFonction());
			//setHmPrivileges(getSlctd().getTFonction());
			userService.cleanAutority();
			userService.getAutorisation(getAutority(), getSlctd().getTFonction().getTTypeFonction());
			setAutority(userService.getAutoritys());
			//On pourrait recharger le menu à cette étape mais il n'ai pas judicieux de le faire
			_logger.info("Changement de fonction: Opérateur: "+userService.getTOperateur().getOpeMatricule()+" Fonction: "+getSlctd().getTFonction().getFonLibelle());
			renderPage("accueil");
		
		}else{
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Sélectionner une fonction dans la liste ! ", ""));	
		}		
	}
	
	public void onRowSelect() {
		setSlctd(getSlctdTb());
		creer = false;	
					
	}
//	public void setHmPrivileges(TFonction fct){
//		hsPrivileges.clear();
//		for(TTypefonctionaction atf : userService.getHmPrivileges().get(fct.getTTypeFonction().getTyfCod())){//privileges of the TYPE FONCTION
//			hsPrivileges.add(atf.getSysAction().getSyaCode());
//		}
//		for(TTypefonctionaction atf : userService.getHmPrivileges().get(fct.getFonCod())){//specific privileges of this FONCTION
//			hsPrivileges.add(atf.getSysAction().getSyaCode());
//		}
//	}
	
	public String logOut(){
		creer = true;
		return "../E-MarchesPublics/logout.jsp";
	}
	public void logout() throws IOException,
    ServletException {
    System.out.println("log out called");
    HttpServletRequest request = (HttpServletRequest)
		       FacesContext.getCurrentInstance().getExternalContext().getRequest();
    HttpServletResponse response =
            (HttpServletResponse) FacesContext.getCurrentInstance()
           .getExternalContext().getResponse();

     HttpSession session = request.getSession();
     session.invalidate();
    // request.getRequestDispatcher("/logout.jsp").forward(request, response);
     response.sendRedirect("../E-MarchesPublics/logout.jsp");
   
}

	public void afficherMenuPrincipal() {
		setEtatPanelAdmin("false");
		setEtatPanelPrincipal("true");
	}
public void afficherMenuAdmin() {
	setEtatPanelAdmin("true");
	setEtatPanelPrincipal("false");
	}
	public TOperateur getOperateur() {
		return operateur;
	}

	public void setOperateur(TOperateur operateur) {
		this.operateur = operateur;
	}

	public TMotdepasse getMotdepasse() {
		return motdepasse;
	}
	public void setMotdepasse(TMotdepasse motdepasse) {
		this.motdepasse = motdepasse;
	}
	public TFonction getFonction() {
		return fonction;
	}
	public void setFonction(TFonction fonction) {
		this.fonction = fonction;
	}
	public Date getDateCon() {
		return dateCon;
	}
	public void setDateCon(Date dateCon) {
		this.dateCon = dateCon;
	}
	public AutorityClass getAutority() {
		return autority;
	}
	public void setAutority(AutorityClass autority) {
		this.autority = autority;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public List<TAssignation> getListeAss() {
		return listeAss;
	}


	public void setListeAss(List<TAssignation> listeAss) {
		this.listeAss = listeAss;
	}

	public TAssignation getSlctd() {
		return slctd;
	}

	public void setSlctd(TAssignation slctd) {
		this.slctd = slctd;
	}

	public TAssignation getSlctdTb() {
		return slctdTb;
	}

	public void setSlctdTb(TAssignation slctdTb) {
		this.slctdTb = slctdTb;
	}

	public boolean isCreer() {
		return creer;
	}

	public void setCreer(boolean creer) {
		this.creer = creer;
	}
	
	public void setHsPrivileges(HashSet <String> hsPrivileges){
		this.hsPrivileges = hsPrivileges;
	}
	
	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}
	
	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public boolean hasCredentials(String actCod){
		return hsPrivileges.contains(actCod);
	}

	
	public boolean hasAnyCredentials(List<String> actCodList){
		for(String actCod : actCodList){
			if(hsPrivileges.contains(actCod)){ return true;}
		}
		return false;
	}

	/*public TExercices getExercice() {
		return exercice;
	}

	public void setExercice(TExercices exercice) {
		this.exercice = exercice;
	}*/
	public String getEtatPanelPrincipal() {
		return EtatPanelPrincipal;
	}
	public void setEtatPanelPrincipal(String etatPanelPrincipal) {
		EtatPanelPrincipal = etatPanelPrincipal;
	}
	public String getEtatPanelAdmin() {
		return EtatPanelAdmin;
	}
	public void setEtatPanelAdmin(String etatPanelAdmin) {
		EtatPanelAdmin = etatPanelAdmin;
	}
	public String getWorkingDir() {
		return workingDir;
	}
	public void setWorkingDir(String workingDir) {
		this.workingDir = workingDir;
	}
	
	public boolean isRenderMsg() {
		return renderMsg;
	}

	public void setRenderMsg(boolean renderMsg) {
		this.renderMsg = renderMsg;
	}

	public String getTexteMsg() {
		return texteMsg;
	}

	public void setTexteMsg(String texteMsg) {
		this.texteMsg = texteMsg;
	}

	public String getSevrityMsg() {
		return sevrityMsg;
	}

	public void setSevrityMsg(String sevrityMsg) {
		this.sevrityMsg = sevrityMsg;
	}
	

}
