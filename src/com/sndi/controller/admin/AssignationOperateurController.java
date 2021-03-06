package com.sndi.controller.admin;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.itextpdf.text.DocumentException;
import com.sndi.dao.IAssignationDao;
import com.sndi.dao.IFonctionDao;
import com.sndi.dao.IOperateurDao;
import com.sndi.dao.IStructureDao;
import com.sndi.model.TAssignation;
import com.sndi.model.TFonction;
import com.sndi.model.TOperateur;
import com.sndi.model.TStructure;
import com.sndi.model.VOperateurRech;
import com.sndi.report.ProjetReport;
import com.sndi.service.IOperateurService;
import com.sndi.utilitaires.KeyGen;
import com.sndi.validator.OperateurValidator;

import lombok.Data;

@Component
@Data
public class AssignationOperateurController 
{
	@Autowired private IFonctionDao fonctionDao;
	@Autowired private IAssignationDao assignationDao;
	@Autowired private IOperateurService operateurService;
	@Autowired private IOperateurDao operateurDao;
	@Autowired private IStructureDao StructureDao;
	@Autowired private OperateurValidator operateurValidator;
	@Autowired KeyGen keyGen = new KeyGen();
	@Autowired private ProjetReport projetReport;
	
	private TAssignation assignation = new TAssignation();
	private TAssignation updatedAssignation = new TAssignation();
	private TOperateur operateur = new TOperateur();
	private int operateurIndex = 0;
	private String tyfCod = "";
	private String critereRechercheFonction= "";
	private boolean printable = false;
	
	private List<TFonction> listFonctions; //List des fonctions, On les charge apr?s chaque changement du typeFonction (on charge unique les fonctions du typeFonction choisi, voir la fonction onSelectTypeFonction L36)
	private List<TStructure> listStructures =  new ArrayList<>();
	private List<VOperateurRech> listVOperateursRech =  new ArrayList<>();
	private String critereRechercheStructure = "";
	private String critereRechercheOperateur = "";
	private String formOperateurMode = "new"; // new & update
	private String formAssignationMode;
	private boolean successMsgVisible = false;
	private boolean errorMsgVisible = false;
	
	public void rechercherOperateur()
	{
		this.listVOperateursRech = this.operateurDao.findVOperateurRechByCritereLibre(this.critereRechercheOperateur);
	}
	
	public void initialiserCritereRechercheOperateur()
	{
		this.critereRechercheOperateur = "";
		this.listVOperateursRech = this.operateurDao.findAllVOperateurRech();
	}
	
	public void beforeNewOperateur()
	{
		this.operateurValidator.setValid(true);
		this.operateur = new TOperateur();
		this.operateur.setOpeMatricule(keyGen.getOperateurCode());
		this.printable = false;
		this.successMsgVisible = false;
		this.errorMsgVisible = false;
		this.formOperateurMode = "new";
		this.operateurIndex = 0;
	}
	public void beforeUpdateOperateur(TOperateur operateur, int index)
	{
		this.operateurIndex = index;
		System.out.println("index " + index);
		operateur.setTStructure(StructureDao.findById(operateur.getTStructure().getStrCode()));
		this.operateurValidator.setValid(true);
		this.operateur = operateur;
		this.printable = this.isPrintable(this.operateur);
		this.successMsgVisible = false;
		this.errorMsgVisible = false;
		this.formOperateurMode = "update";
	}
	
	public void saveOperateur()
	{
		try
		{
			this.operateur = this.operateurService.saveOrUpdateOperateur(this.operateur);
			this.successMsgVisible = true;
			this.errorMsgVisible = false;
			if(this.formOperateurMode.equalsIgnoreCase("new"))
			{
				this.listVOperateursRech.set(0, this.operateurDao.findVOperateurRechByOpeMatricule(this.operateur.getOpeMatricule())) ;
			}
			else
			{
				this.listVOperateursRech.set(this.operateurIndex, this.operateurDao.findVOperateurRechByOpeMatricule(this.operateur.getOpeMatricule())) ;
			}
		}
		catch(Exception e)
		{
			this.successMsgVisible = false;
			this.errorMsgVisible = true;
			e.printStackTrace();
		}
	}
	
	public void printOperateur() throws IOException, DocumentException
	{
 		projetReport.showOperateurPDF(this.operateur.getOpeMatricule())	;
	}
	public void printOperateur(TOperateur operateur) throws IOException, DocumentException
	{
 		projetReport.showOperateurPDF(operateur.getOpeMatricule())	;
	}
	
	public void beforeNewAssignation(TOperateur operateur) throws ParseException
	{
		operateur.setTStructure(StructureDao.findById(operateur.getTStructure().getStrCode()));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dernierJourAnne = sdf.parse(LocalDate.now().getYear() + "-" + "12-31");
		this.assignation = new TAssignation();
		this.formAssignationMode = "new";
		this.operateur = operateur;
		this.assignation.setTOperateur(operateur);
		this.assignation.setAssDatDeb(new Date());
		this.assignation.setAssDatFin(dernierJourAnne);
		this.assignation.setAssStatut(true);
		int nbrAssignation = this.assignationDao.countByOpeMatricule(this.operateur.getOpeMatricule());
		assignation.setAssCourant((nbrAssignation>=1 ? "N": "O"));
		this.printable = this.isPrintable(this.operateur);
		this.refreshListAssignation();
	}
	
	public boolean isPrintable(TOperateur operateur)
	{
		return this.assignationDao.findAssignationsByOpeMatricule(operateur.getOpeMatricule()).stream()
			.anyMatch(ass->ass.getAssCourant().equals("O"));
	}
	
	public void beforeUpdateAssignation(TAssignation assignation)
	{
		this.assignation = assignation;
		this.formAssignationMode = "update";
	}
	
	public void onSelectTypeFonction()
	{
		TFonction fonction = new TFonction();
		fonction.setFonCod("");
		fonction.setFonLibelle("");
		this.assignation.setTFonction(fonction);
		System.out.println("TYF_COD = " + this.tyfCod);
		this.listFonctions = fonctionDao.findByStrCodeAndTyfCodAndCritereLibre(this.assignation.getTOperateur().getTStructure().getStrCode(), this.tyfCod, "");
		this.printable = this.isPrintable(this.operateur);
	}
	
	public void enregistrerAssignation() throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dernierJourAnne = sdf.parse(LocalDate.now().getYear() + "-" + "12-31");
		this.assignationDao.save(this.assignation);
		this.refreshListAssignation();
		TAssignation newAssignation = new TAssignation();
		newAssignation.setTOperateur(this.assignation.getTOperateur());
		newAssignation.setAssDatDeb(new Date());
		newAssignation.setAssDatFin(dernierJourAnne);
		newAssignation.setAssStatut(true);
		newAssignation.setAssCourant("N");
		this.assignation = newAssignation;
		this.printable = this.isPrintable(this.operateur);
	}
	
	public void deleteAssignation(TAssignation assignation)
	{
		assignationDao.delete(assignation);
		this.refreshListAssignation();
		this.printable = this.isPrintable(this.operateur);
	}
	
	public void updateAssignation() throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dernierJourAnne = sdf.parse(LocalDate.now().getYear() + "-" + "12-31");
		this.assignationDao.save(this.updatedAssignation);
		TAssignation newAssignation = new TAssignation();
		newAssignation.setTOperateur(this.assignation.getTOperateur());
		newAssignation.setAssDatDeb(new Date());
		newAssignation.setAssDatFin(dernierJourAnne);
		newAssignation.setAssStatut(true);
		newAssignation.setAssCourant("N");
		updatedAssignation = newAssignation;
	}
	
	public String goToListOperateurs()
	{
		this.listVOperateursRech = this.operateurDao.findAllVOperateurRech();
		return "/pages/administration/assignation-operateur/index.xhtml?faces-redirect=true";
	}
	private void refreshListAssignation() //Rafraichit la liste des assignation de l'op?rateur en cours de modification
	{
		TOperateur operateur = this.assignation.getTOperateur();
		Set<TAssignation> opeAssignations = assignationDao.findAssignationsByOpeMatricule(operateur.getOpeMatricule()).stream().collect(Collectors.toSet());
		this.assignation.getTOperateur().setTAssignations(opeAssignations);
	}
	public void initialiserListStructures()
	{
		this.critereRechercheStructure = "";
		this.listStructures = this.StructureDao.findAll();
	}
	public void rechercherStrucure()
	{
		this.listStructures = this.StructureDao.findByStrCodeOrLibelle(this.critereRechercheStructure);
	}
	public void initialiserListFonctions()
	{
		this.critereRechercheFonction = "";
		this.listFonctions = fonctionDao.findByStrCodeAndTyfCodAndCritereLibre(this.assignation.getTOperateur().getTStructure().getStrCode(), tyfCod, "");
	}
	public void rechercherFonction()
	{
		this.listFonctions = fonctionDao.findByStrCodeAndTyfCodAndCritereLibre(this.assignation.getTOperateur().getTStructure().getStrCode(), this.tyfCod,  this.critereRechercheFonction);
	}
}