package com.sndi.controller.admin;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.primefaces.event.FlowEvent;
import org.primefaces.event.SelectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sndi.dao.IAssignationDao;
import com.sndi.dao.IFonctionDao;
import com.sndi.model.TAssignation;
import com.sndi.model.TFonction;
import com.sndi.model.TOperateur;
import com.sndi.service.IOperateurService;

import lombok.Data;

@Component
@Data
public class AssignationController2 
{
	@Autowired OperateurController2 operateurController;
	@Autowired private IFonctionDao fonctionDao;
	@Autowired private IAssignationDao assignationDao;
	@Autowired private IOperateurService operateurService;
	
	private TAssignation assignation = new TAssignation();
	private TAssignation updatedAssignation = new TAssignation();
	private String tyfCod = "";
	private String critereRechercheFonction= "";
	private boolean printable = false;
	
	private List<TFonction> listFonctions; //List des fonctions, On les charge après chaque changement du typeFonction (on charge unique les fonctions du typeFonction choisi, voir la fonction onSelectTypeFonction L36)
	
	public void onSelectTypeFonction(SelectEvent selectEvent)
	{
		/*
		System.out.println("=====onSelectTypeFonction======= ");
		UIInput component = (UIInput)selectEvent.getSource();
		String tyfCod = (String) component.getValue();
		TFonction fonction = new TFonction();
		fonction.setFonCod("");
		fonction.setFonLibelle("");
		System.out.println("=====initialisation fonction onSelectTypeFonction======= ");
		this.assignation.setTFonction(fonction);
		this.listFonctions = fonctionDao.findByStrCodeAndTyfCodAndCritereLibre(this.assignation.getTOperateur().getTStructure().getStrCode(), tyfCod, "");
		System.out.println("=====Fin chargement listFonction=====");
		this.printable = this.assignationDao.countByOpeMatricule(this.assignation.getTOperateur().getOpeMatricule())>=1;
		System.out.println("=====Fin Méthode=====");
	*/
		
	}
	
	public void onSelectTypeFonction()
	{
		TFonction fonction = new TFonction();
		fonction.setFonCod("");
		fonction.setFonLibelle("");
		this.assignation.setTFonction(fonction);
		this.listFonctions = fonctionDao.findByStrCodeAndTyfCodAndCritereLibre(this.assignation.getTOperateur().getTStructure().getStrCode(), this.tyfCod, "");
		this.printable = this.assignationDao.countByOpeMatricule(this.assignation.getTOperateur().getOpeMatricule())>=1;
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
	public String onFlowProcess(FlowEvent event) throws ParseException //Fonction qui s'exécute lors de la navigation sur le composant p:wizard
	{
		String oldStepId = event.getOldStep();
		String newStepId = event.getNewStep();
		
		if(oldStepId.equals("tabFrmOperateur") && newStepId.equals("tabAssignationOperateur"))
		{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date dernierJourAnne = sdf.parse(LocalDate.now().getYear() + "-" + "12-31");

			TOperateur operateur = operateurController.getOperateur();
			this.assignation.setTOperateur(operateur);
			this.assignation.setAssDatDeb(new Date());
			this.assignation.setAssDatFin(dernierJourAnne);
			this.assignation.setAssStatut(true);
			assignation.setAssCourant("N");
			this.operateurService.createOrUpdateOperateur(this.assignation.getTOperateur());
			this.refreshListAssignation();
		}
		return event.getNewStep();
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
		
		this.printable = this.assignationDao.countByOpeMatricule(this.assignation.getTOperateur().getOpeMatricule())>=1;
	}
	
	public void deleteAssignation(TAssignation assignation)
	{
		assignationDao.delete(assignation);
		this.refreshListAssignation();
		this.printable = this.assignationDao.countByOpeMatricule(this.assignation.getTOperateur().getOpeMatricule())>=1;
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
	
	private void refreshListAssignation() //Rafraichit la liste des assignation de l'opérateur en cours de modification
	{
		TOperateur operateur = this.assignation.getTOperateur();
		Set<TAssignation> opeAssignations = assignationDao.findAssignationsByOpeMatricule(operateur.getOpeMatricule()).stream().collect(Collectors.toSet());
		this.assignation.getTOperateur().setTAssignations(opeAssignations);
	}
}