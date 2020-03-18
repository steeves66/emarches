package com.sndi.convertor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sndi.model.TTypeFonction;
import com.sndi.service.Iservice;


@Component
public class EntityList {
	@Autowired
	Iservice iservice;

	//les listes des listBoxes
	
	private List<TTypeFonction> listTTypeFonction = new ArrayList<TTypeFonction>();
	

	
	@PostConstruct
	public void postConstru() {
		List listTP = getIservice().getObjects("TTypeFonction");
		for (Iterator it = listTP.iterator(); it.hasNext();) {
			TTypeFonction TP = (TTypeFonction) it.next();
			getListTTypeFonction().add(TP);
		}
			//ordonner les TTypeParticipants
			 Collections.sort(getListTTypeFonction(), new Comparator<TTypeFonction>() {
			        @Override public int compare(TTypeFonction p1, TTypeFonction p2) {
			        	int n = p1.getTyfLibelle().compareTo(p2.getTyfLibelle());
			        	return n; // Ascending  
			        }

			    });
		
		
		
	}
	
	
	

	

	public List<TTypeFonction> getListTTypeFonction() {
		return listTTypeFonction;
	}

	public void setListTTypeFonction(List<TTypeFonction> listTTypeFonction) {
		this.listTTypeFonction = listTTypeFonction;
	}

	public Iservice getIservice() {
		return iservice;
	}

	public void setIservice(Iservice iservice) {
		this.iservice = iservice;
	}

}
