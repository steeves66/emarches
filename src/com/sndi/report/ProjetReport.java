package com.sndi.report;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.GrayColor;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfGState;
import com.itextpdf.text.pdf.PdfImage;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfIndirectObject;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;
import com.sndi.service.Iservice;
import com.sndi.utilitaires.CheckSysTem;
import com.sndi.utilitaires.DownloadFileServlet;
import com.sndi.utilitaires.GRFProperties;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleDocxReportConfiguration;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;

@Controller
public class ProjetReport {
	@Autowired
	Iservice iservice;
	 @Autowired
	  DownloadFileServlet downloadFileServlet;
	 @Autowired
	 ConnectionUtils connectionUtils;
	 
	 static final String pathdir = "\\standalone\\deployments\\E-MarchesPublics.war\\report\\";
	static final String path = "\\standalone\\deployments\\E-MarchesPublics.war\\report\\";
	static final String pathdirLinux = "standalone/deployments/E-MarchesPublics.war/report/";
	static final String pathimagedir = "\\standalone\\deployments\\E-MarchesPublics.war\\report\\images\\";
	static final String pathimagedirLinux = "/report/images/";
	static  String workingDir = "";
	BigDecimal annee = BigDecimal.valueOf(2019);
	
	 public static final Font FONT = new Font(FontFamily.HELVETICA, 12, Font.NORMAL, GrayColor.GRAYWHITE);
	   
	 @PostConstruct
		public void postConstru() throws IOException {	
		 File dir = new File("..");
		 workingDir = dir.getCanonicalPath();	
		}

				//Fiche demande
				
			
				
				//Print Fiche avec 1 parametre de type long
				public void longparam1(long numero, String reportName, String jrxmlName ){
					
					String pathdir ="";
					 
					 pathdir = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/report/images/");
						pathdir += "/";
						
						Map<String, Object> param = new HashMap<String, Object>();
						param.put("param_code", numero);
						param.put("param_image", pathdir);
						try {
						Connection conn = connectionUtils.getConnection();
						String jrxmlFile = FacesContext.getCurrentInstance().getExternalContext()
								.getRealPath("/report/" + jrxmlName + ".jrxml");
						InputStream input = new FileInputStream(new File(jrxmlFile));
						JasperReport jasperReport = JasperCompileManager.compileReport(input);
						JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, param, conn);
						
						HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance()
								.getExternalContext().getResponse();
						httpServletResponse.addHeader("contentType", "application/pdf");
						httpServletResponse.addHeader("Content-disposition",
								"attachment; filename=" + reportName + "-" + numero + ".pdf");

						ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
						JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
						servletOutputStream.flush();
						servletOutputStream.close();
						FacesContext.getCurrentInstance().responseComplete();
						 
						} catch (Exception e) {
							System.out.println(e);
						}

				}
				//Fin Print Fiche avec 1 parametre de type long
				
				
				//Print Fiche avec 2 parametre de type long
				public void longparam2(long numero1,long numero2, String reportName, String jrxmlName ){
					
					String pathdir ="";
					 
					 pathdir = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/report/images/");
						pathdir += "/";
						
						Map<String, Object> param = new HashMap<String, Object>();
						param.put("param_code_1", numero1);
						param.put("param_code_2", numero2);
						param.put("param_image", pathdir);
						try {
						Connection conn = connectionUtils.getConnection();
						String jrxmlFile = FacesContext.getCurrentInstance().getExternalContext()
								.getRealPath("/report/" + jrxmlName + ".jrxml");
						InputStream input = new FileInputStream(new File(jrxmlFile));
						JasperReport jasperReport = JasperCompileManager.compileReport(input);
						JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, param, conn);
						
						HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance()
								.getExternalContext().getResponse();
						httpServletResponse.addHeader("contentType", "application/pdf");
						httpServletResponse.addHeader("Content-disposition",
								"attachment; filename=" + reportName + "-" + numero1+ numero2 + ".pdf");

						ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
						JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
						servletOutputStream.flush();
						servletOutputStream.close();
						FacesContext.getCurrentInstance().responseComplete();
						 
						} catch (Exception e) {
							System.out.println(e);
						}

				}
				//Fin Print Fiche avec 2 parametre de type long
				
				
				
				//Print Fiche avec 2 parametre de type long et String
				public void longStringparam2(long numero1,String code, String reportName, String jrxmlName ){
					
					String pathdir ="";
					 
					 pathdir = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/report/images/");
						pathdir += "/";
						
						Map<String, Object> param = new HashMap<String, Object>();
						param.put("param_code", numero1);
						param.put("param_op", code);
						param.put("param_image", pathdir);
						try {
						Connection conn = connectionUtils.getConnection();
						String jrxmlFile = FacesContext.getCurrentInstance().getExternalContext()
								.getRealPath("/report/" + jrxmlName + ".jrxml");
						InputStream input = new FileInputStream(new File(jrxmlFile));
						JasperReport jasperReport = JasperCompileManager.compileReport(input);
						JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, param, conn);
						
						HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance()
								.getExternalContext().getResponse();
						httpServletResponse.addHeader("contentType", "application/pdf");
						httpServletResponse.addHeader("Content-disposition",
								"attachment; filename=" + reportName + "-" + numero1+ code + ".pdf");

						ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
						JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
						servletOutputStream.flush();
						servletOutputStream.close();
						FacesContext.getCurrentInstance().responseComplete();
						 
						} catch (Exception e) {
							System.out.println(e);
						}

				}
				//Fin Print Fiche avec 2 parametre de type long
				
				
				
				//Print Fiche avec 2 parametres de type long et 4 String
				public void longStringparam6(long numero1,String code,String statut,String typePlan,String param_min,String param_pf, String reportName, String jrxmlName ){
					
					String pathdir ="";
					 
					 pathdir = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/report/images/");
						pathdir += "/";
						
						Map<String, Object> param = new HashMap<String, Object>();
						param.put("param_code", numero1);
						param.put("param_op", code);
						param.put("param_statut", statut);
						param.put("typePlan", typePlan);
						param.put("param_min", param_min);
						param.put("param_pf", param_pf);
						param.put("param_image", pathdir);
						try {
						Connection conn = connectionUtils.getConnection();
						String jrxmlFile = FacesContext.getCurrentInstance().getExternalContext()
								.getRealPath("/report/" + jrxmlName + ".jrxml");
						InputStream input = new FileInputStream(new File(jrxmlFile));
						JasperReport jasperReport = JasperCompileManager.compileReport(input);
						JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, param, conn);
						
						HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance()
								.getExternalContext().getResponse();
						httpServletResponse.addHeader("contentType", "application/pdf");
						httpServletResponse.addHeader("Content-disposition",
								"attachment; filename=" + reportName + "-" + numero1+ code + ".pdf");

						ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
						JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
						servletOutputStream.flush();
						servletOutputStream.close();
						FacesContext.getCurrentInstance().responseComplete();
						 
						} catch (Exception e) {
							System.out.println(e);
						}

				}
				//Fin Print Fiche 2 parametres de type long et 3 String
				
				
				//Print Fiche avec 1 parametre de type String
				public void stringparam1(String code,String reportName, String jrxmlName ){
					
					String pathdir ="";
					 
					 pathdir = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/report/images/");
						pathdir += "/";
						
						Map<String, Object> param = new HashMap<String, Object>();
						param.put("param_code_1", code);
						param.put("param_image", pathdir);
						try {
						Connection conn = connectionUtils.getConnection();
						String jrxmlFile = FacesContext.getCurrentInstance().getExternalContext()
								.getRealPath("/report/" + jrxmlName + ".jrxml");
						InputStream input = new FileInputStream(new File(jrxmlFile));
						JasperReport jasperReport = JasperCompileManager.compileReport(input);
						JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, param, conn);
						
						HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance()
								.getExternalContext().getResponse();
						httpServletResponse.addHeader("contentType", "application/pdf");
						httpServletResponse.addHeader("Content-disposition",
								"attachment; filename=" + reportName + "-" + code+ ".pdf");

						ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
						JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
						servletOutputStream.flush();
						servletOutputStream.close();
						FacesContext.getCurrentInstance().responseComplete();
						 
						} catch (Exception e) {
							System.out.println(e);
						}

				}
				//Fin Print Fiche avec 1 parametre de type string
				
				
				//Print Fiche avec 3 parametres de type String
				public void stringparam3(String code,String nom,String prenoms,String reportName, String jrxmlName ){
					
					String pathdir ="";
					 
					 pathdir = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/report/images/");
						pathdir += "/";
						
						Map<String, Object> param = new HashMap<String, Object>();
						param.put("param_code_1", code);
						param.put("param_nom", nom);
						param.put("param_prenom", prenoms);
						param.put("param_image", pathdir);
						try {
						Connection conn = connectionUtils.getConnection();
						String jrxmlFile = FacesContext.getCurrentInstance().getExternalContext()
								.getRealPath("/report/" + jrxmlName + ".jrxml");
						InputStream input = new FileInputStream(new File(jrxmlFile));
						JasperReport jasperReport = JasperCompileManager.compileReport(input);
						JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, param, conn);
						
						HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance()
								.getExternalContext().getResponse();
						httpServletResponse.addHeader("contentType", "application/pdf");
						httpServletResponse.addHeader("Content-disposition",
								"attachment; filename=" + reportName + "-" + code+ ".pdf");

						ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
						JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
						servletOutputStream.flush();
						servletOutputStream.close();
						FacesContext.getCurrentInstance().responseComplete();
						 
						} catch (Exception e) {
							System.out.println(e);
						}

				}
				//Fin Print Fiche avec 3 parametres de type String
				
				//Print Document Opérateur
				public void showOperateurPDF(String opeMatricule){
					
					
					 String pathdir ="";
					
					 if (CheckSysTem.isWindows()) {
						 pathdir = workingDir+pathimagedir;
						 
						 System.out.println("This is Windows");
					 } else {
						 pathdir = FacesContext.getCurrentInstance().getExternalContext()
				 					.getRealPath("/report/images/");
				        	pathdir +="/";
				        	System.out.println("Chemain "+pathdir);	
				        
					 }
					
					Map<String, Object> param = new HashMap<String, Object>();
					param.put("opeMatricule", opeMatricule);
					param.put("report_image", pathdir);
					System.out.println("path=  "+pathdir);
				try{
					Connection conn = connectionUtils.getConnection();
					
					
					String jrxmlFile = FacesContext.getCurrentInstance().getExternalContext()
							.getRealPath("/report/operateur.jrxml");
					InputStream input = new FileInputStream(new File(jrxmlFile));
					JasperReport jasperReport = JasperCompileManager.compileReport(input);
					JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, param, conn);
					
					HttpServletResponse httpServletResponse = (HttpServletResponse)FacesContext.getCurrentInstance()
							.getExternalContext().getResponse();
					httpServletResponse.addHeader("contentType", "application/pdf");
					 httpServletResponse.addHeader("Content-disposition", "attachment; filename=Operateur-"+opeMatricule+".pdf");  
					ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
					JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
					 servletOutputStream.flush();
					 servletOutputStream.close(); 
					FacesContext.getCurrentInstance().responseComplete();
					
					
				}catch(Exception e){
				System.out.println(e);	
				}
					
				}
				
				//Print Document Opérateur
				public void showAgpmPDF(long numero1, long numero2){
					
					
					 String pathdir ="";
					
					 if (CheckSysTem.isWindows()) {
						 pathdir = workingDir+pathimagedir;
						 
						 System.out.println("This is Windows");
					 } else {
						 pathdir = FacesContext.getCurrentInstance().getExternalContext()
				 					.getRealPath("/report/images/");
				        	pathdir +="/";
				        	System.out.println("Chemain "+pathdir);	
				        
					 }
					
					Map<String, Object> param = new HashMap<String, Object>();
					param.put("param_code_1", numero1);
					param.put("param_code_2", numero2);
					param.put("param_image", pathdir);
					System.out.println("path=  "+pathdir);
				try{
					Connection conn = connectionUtils.getConnection();
					
					
					String jrxmlFile = FacesContext.getCurrentInstance().getExternalContext()
							.getRealPath("/report/Agpm.jrxml");
					InputStream input = new FileInputStream(new File(jrxmlFile));
					JasperReport jasperReport = JasperCompileManager.compileReport(input);
					JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, param, conn);
					
					HttpServletResponse httpServletResponse = (HttpServletResponse)FacesContext.getCurrentInstance()
							.getExternalContext().getResponse();
					httpServletResponse.addHeader("contentType", "application/pdf");
					 httpServletResponse.addHeader("Content-disposition", "attachment; filename=Operateur-"+numero1+numero2+".pdf");  
					ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
					JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
					 servletOutputStream.flush();
					 servletOutputStream.close(); 
					FacesContext.getCurrentInstance().responseComplete();
					
					
				}catch(Exception e){
				System.out.println(e);	
				}
					
				}
}