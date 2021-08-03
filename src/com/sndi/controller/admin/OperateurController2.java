package com.sndi.controller.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itextpdf.text.DocumentException;
import com.sndi.dao.IAssignationDao;
import com.sndi.dao.IOperateurDao;
import com.sndi.dao.IStructureDao;
import com.sndi.model.TOperateur;
import com.sndi.model.TStructure;
import com.sndi.report.ProjetReport;
import com.sndi.service.IOperateurService;
import com.sndi.service.Iservice;
import com.sndi.utilitaires.KeyGen;
import com.sndi.validator.OperateurValidator;

import lombok.Data;

@Component
@Data
public class OperateurController2
{
	@Autowired private Iservice iservice;
	@Autowired private IOperateurDao operateurDao;
	@Autowired private IAssignationDao assignationDao;
	@Autowired private IOperateurService operateurService;
	@Autowired KeyGen keyGen = new KeyGen();
	@Autowired private OperateurValidator operateurValidator;
	@Autowired private IStructureDao StructureDao;
	@Autowired private AssignationOperateurController assignationController;
	
	private TOperateur operateur = new TOperateur();
	private List<TStructure> listStructures =  new ArrayList<>();
	private List<TOperateur> listOperateurs =  new ArrayList<>();
	private String critereLibre = "";
	private String critereRechercheStructure = "";
	private String formMode = "new"; // new & update
	private static String globalMsg="";
	@Autowired private ProjetReport projetReport;
	
	
	@PostConstruct
	void init()
	{
		this.listStructures = this.StructureDao.findAll();
		this.operateur.setOpeMatricule(keyGen.getOperateurCode());
		this.listOperateurs = this.operateurDao.getListOperateurs();
	}
	
	public String goToListOperateurs()
	{
		this.listOperateurs = this.operateurDao.getListOperateurs();;
		return "/pages/administration/assignation-operateur/index.xhtml?faces-redirect=true";
	}
	public void beforeNewOperateur()
	{
		this.operateurValidator.setValid(true);
		this.operateur = new TOperateur();
		this.operateur.setOpeMatricule(keyGen.getOperateurCode());
		this.formMode = "new";
	}
	public String goToUpdateOperateurForm(TOperateur operateurToBeUpdated)
	{
		this.operateurValidator.setValid(true);
		this.operateur = operateurToBeUpdated;
		this.assignationController.setPrintable(this.assignationDao.countByOpeMatricule(operateurToBeUpdated.getOpeMatricule())>=1);
		return "/pages/administration/test-leni/operateur/operateurAssignationWorkFlow.xhtml?faces-redirect=true&successMsg="+this.globalMsg;
	}
	public String saveOperateurAndReinitializeForm()
	{
		String successMsg = "Opérateur enregistré avec succès!";
		this.operateurService.createOrUpdateOperateur(this.operateur);
		this.operateur = new TOperateur();
		this.operateur.setOpeMatricule(keyGen.getOperateurCode());
		this.globalMsg = Base64.getEncoder().encodeToString(successMsg.getBytes());
		return "/pages/administration/test-leni/operateur/operateurAssignationWorkFlow.xhtml?faces-redirect=true&successMsg="+this.globalMsg;
	}
	public void saveOpeAndGoToAssignation()
	{
		this.operateur = operateurService.createOrUpdateOperateur(this.operateur);
	}
	
	public void printOperateur(TOperateur operateur) throws IOException, DocumentException
	{
 		projetReport.showOperateurPDF(operateur.getOpeMatricule())	;
	}
	
	public void printOperateur() throws IOException, DocumentException
	{
 		projetReport.showOperateurPDF(this.operateur.getOpeMatricule())	;
	}
	
	public String base64UrlDecode(String urlParam)
	{
		String decodedUrl = "";
		try
		{
			decodedUrl = new String( Base64.getDecoder().decode((urlParam)));
		}
			catch (Exception e)
		{
			decodedUrl = "";
			this.globalMsg="";
		}
		return decodedUrl;
	}
	
	public void creerNouvelOperateur(TOperateur operateur)
	{
		operateurService.createOperateur(operateur);
	}
	
	public void rechercheParCritereLibre()
	{
		this.listOperateurs = this.operateurService.findByCritereLibre(this.critereLibre);
	}
	
	public void initialiserCritereLibre()
	{
		this.critereLibre = "";
		this.listOperateurs = this.operateurDao.getListOperateurs();
	}
	
	public void initialiserListStructures()
	{
		this.critereRechercheStructure = "";
		this.listStructures = this.StructureDao.getListStructures();
	}
	public void rechercherStrucure()
	{
		this.listStructures = this.StructureDao.findByStrCodeOrLibelle(this.critereRechercheStructure);
	}
	
	public String gotoNewOperateur()
	{
		this.operateurValidator.setValid(true);
		this.operateur = new TOperateur();
		this.operateur.setOpeMatricule(keyGen.getOperateurCode());
		return "/pages/administration/test-leni/operateur/operateurAssignationWorkFlow.xhtml?faces-redirect=true";
	}
}