package com.sndi.dao;

import java.util.List;

import com.sndi.model.TFonction;
import com.sndi.model.VFonctionAssignationRech;

public interface IFonctionDao extends ICrudDao<TFonction, String>
{
	List<TFonction> findByTyfCode(String tyfCode);

	List<TFonction> findByTyfCodAndCritereLibre(String tyfCod, String critereRechercheFonction);
	List<TFonction> findByStrCodeAndTyfCodAndCritereLibre(String strCode, String tyfCod, String critereRechercheFonction);
	List<VFonctionAssignationRech> findFonctionAssignationByStrCodeAndTyfCodAndCritereLibre(String strCode, String tyfCod, String critereRechercheFonction);
}
