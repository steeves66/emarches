package com.sndi.controller.dac;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBookmark;
import org.springframework.beans.factory.annotation.Autowired;

import com.sndi.controller.dao.DaoController;
import com.sndi.model.VbxDocDaoAao;
import com.sndi.security.UserController;
import com.sndi.utilitaires.GRFProperties;

public class HandleDac {
	
	Logger _logger = Logger.getLogger(DaoController.class);
	
	private VbxDocDaoAao infoDac = new VbxDocDaoAao();
	String dacType;
	Map<String, String> dacFileMap;
	private XWPFDocument dacFile ;
	List<String> dacBookmarkNames = new ArrayList<String>(); 
	List<String> bookmarkNames = new ArrayList<String>();
	
	String i;
	String j;
	String k;
	
	@Autowired
	UserController userController;
	
	public HandleDac(VbxDocDaoAao daoAao) {
		this.setInfoDac(daoAao);
	}

	public void openDac() throws FileNotFoundException, IOException {
		dacType = infoDac.getDacModType();
		dacFileMap = OpenDac.getDacFile();
		for(Map.Entry<String, String> map : dacFileMap.entrySet()) {
			if(dacType == map.getKey()) {
				//setDacFile(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+GRFProperties.FICHIER_UPLOAD_DAO_PRESTATIONS_LINUX))));
				setDacFile(new XWPFDocument(new FileInputStream(new File(""+userController.getWorkingDir()+"GRFProperties."+map.getValue()))));
				_logger.info("Fichier téléchargé: "+""+userController.getWorkingDir()+"GRFProperties."+map.getValue());
			}
		}
		
		/*for (Map.Entry<String, Integer> me : hm.entrySet()) {
			System.out.print(me.getKey() + ":");
			System.out.println(me.getValue());
		}*/
		
	}
	
	
	
	private List<XWPFParagraph> collectParagraphs() {
		 List<XWPFParagraph> paragraphs = new ArrayList<>();
		 paragraphs.addAll(getDacFile().getParagraphs());
		
		 for(XWPFTable table:getDacFile().getTables()) {
			 for(XWPFTableRow row:table.getRows()) {
				for(XWPFTableCell cell:row.getTableCells()) {
					paragraphs.addAll(cell.getParagraphs());
				}
			 }
		 }
		 return paragraphs;		
	 }

	public List<String> getDacBookmarkNames() {
			List<String> bookmarkNames = new ArrayList<>();
			Iterator<XWPFParagraph> paraIter = null;
			XWPFParagraph para = null;
			List<CTBookmark> bookmarkList = null;
			Iterator<CTBookmark> bookmarkIter = null;
			CTBookmark bookmark = null;
				
			paraIter = collectParagraphs().iterator();
			while(paraIter.hasNext()) {
					para = paraIter.next();
					bookmarkList = para.getCTP().getBookmarkStartList();
					bookmarkIter = bookmarkList.iterator();
					while(bookmarkIter.hasNext()) {
						bookmark = bookmarkIter.next();
						bookmarkNames.add(bookmark.getName());
					}
			}
			return bookmarkNames;
	}
		
	public void replaceBookmarkByValue() {
		dacBookmarkNames = getDacBookmarkNames();
		bookmarkNames = Bookmarks.getBookmarks();
		
		for( String i:dacBookmarkNames) {
			for( String j:dacBookmarkNames) {
				if(i == j) {
					 k = i;
				}
			}
		}
	}
	
	
	/*chargeDaoFile(); 
	printBmk();
	_logger.info("Document chargé");
	lBmkNm = getBookmarkNames();
	replaceBookmarkByValue(lBmkNm, lLts, lAdr, daoAao, lCom);
	setDocumentCreatorProperty("sigomap");
	setDocumentProperty("numeroDao", daoAao.getAaoDacCode().toString());
	_logger.info("Bookmark remplac");
	verrouillage();
	_logger.info("Verrou paramtr");
	setProtect();
	_logger.info("Document protg");
	saveDaoFile(); // linux
	_logger.info("Document enrgistr");
	telechargerDao();
	_logger.info("Document tlcharg");*/

	
	
	
	
	public VbxDocDaoAao getInfoDac() {
		return infoDac;
	}

	public void setInfoDac(VbxDocDaoAao infoDac) {
		this.infoDac = infoDac;
	}

	public XWPFDocument getDacFile() {
		return dacFile;
	}

	public void setDacFile(XWPFDocument dacFile) {
		this.dacFile = dacFile;
	}
}
