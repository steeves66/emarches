/*package com.sndi.utilitaires;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import com.sndi.model.TStatuts;



public class FileReadCSVToData {

	 private static final char DEFAULT_SEPARATOR = ';';
	    private static final char DEFAULT_QUOTE = '"';
	    
	    public  List<TLigneBudgetairePrepa> getLigneBudgetairePrepa(InputStream fileCSV) throws Exception {
		    
			List<TLigneBudgetairePrepa> paysList = new ArrayList<>();

			Scanner scanner = new Scanner(fileCSV);
			try {
				
				
				while (scanner.hasNext()) {
					TLigneBudgetairePrepa p = new TLigneBudgetairePrepa();
					List<String> data = parseLine(scanner.nextLine());
					
					
					
					p.setLbpNum((short)Integer.parseInt(data.get(0)));
					
					p.setTExercices(new TExercices(data.get(1)));
					p.setTBudgets(new TBudgets((short)Integer.parseInt(data.get(0))));
					p.setTMinisteres(new TMinisteres((short)Integer.parseInt(data.get(0))));
					p.setTStatuts(new TStatuts("P1N"));
					p.setLbpImputBudgetaire(data.get(1));
					
					p.setLbpDesignation(data.get(1));
					p.setLbpPeriode(data.get(1));
					p.setLbpDuree(data.get(1));
					
					p.setLbpLieu(data.get(1));
					p.setLbpParticipanth((short)Integer.parseInt(data.get(0)));
					p.setLbpParticipanta((short)Integer.parseInt(data.get(0)));
					p.setLbpParticipantb((short)Integer.parseInt(data.get(0)));
					p.setLbpTransport(new BigDecimal(data.get(0)));
					p.setLbpIndemnite(new BigDecimal(data.get(0)));
					p.setLbpAutreFrais(new BigDecimal(data.get(0)));
					p.setLbpMontantDot(new BigDecimal(data.get(0)));
					p.setLbpObjectifResultat(data.get(1));
					
					
					paysList.add(p);
						  System.out.println("Ligne Budgétaire [id= " + data.get(0) + ", Libelle= " + data.get(1) + "]");
				}
				scanner.close();
			} catch (java.lang.IndexOutOfBoundsException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		

			System.out.println("Les Lignes Budgétaires CSV Liste Taille :"+paysList.size());
	    return paysList;	
	    }
	    
 public  List<TLigneBudgetairePrepa> getLigneBudgetairePrepa(InputStream file, String minCodeString) {
		    
			List<TLigneBudgetairePrepa> paysList = new ArrayList<>();
			int minCode =Integer.valueOf(minCodeString);
			
			try {
				HSSFWorkbook wb = new HSSFWorkbook(file);
				HSSFSheet sheet = wb.getSheetAt(0);
				HSSFRow row;
				HSSFCell cell;
				Iterator rows = sheet.rowIterator();
				while (rows.hasNext()) {
					row = (HSSFRow) rows.next();
					//traitement des lignes autres que la première
					if (row.getRowNum() != 0) {
						Iterator cells = row.cellIterator();

						TLigneBudgetairePrepa p = new TLigneBudgetairePrepa();
						
						System.out.println("cell " + row.getRowNum() + " ");
						while (cells.hasNext()) {
							String val = "";
							cell = (HSSFCell) cells.next();

							if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
								val = cell.getStringCellValue();
							} else if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {

								int i = Double.valueOf(cell.getNumericCellValue()).intValue();
								val = "" + i;
							} else {
								//U Can Handel Boolean, Formula, Errors
							}

							//set de la ligne budgetaire prepa

							switch (cell.getColumnIndex()) {
							case 0:
								p.setLbpNum((short) Integer.parseInt(val));
								break;
							case 1:
								
								p.setLbpDesignation(val);
								break;
							case 2:
								p.setLbpPeriode(val);
								break;
							case 3:
								if(val==null || val=="") {
									p.setLbpLieu("");}else {
									p.setLbpLieu(val);
								}
								
								break;
							case 4:
								p.setLbpDuree(val);
								break;
							case 5:
								if(!(val==null || val=="")) {
									System.out.print("Val h " + val);
								p.setLbpParticipanth((short) Integer.parseInt(val));}else {
									p.setLbpParticipanth((short) 0);
								}
								break;
							case 6:
								if(!(val==null || val=="")) {
									System.out.print("Val b " + val);
								p.setLbpParticipantb((short) Integer.parseInt(val));}else {
									p.setLbpParticipantb((short) 0);
								}
								break;
							case 7:
								if(!(val==null || val=="")) {
									System.out.print("Val a " + val);
								p.setLbpParticipanta((short) Integer.parseInt(val));}else {
									p.setLbpParticipanta((short) 0);
								}
								break;
							case 8:
							
								p.setLbpTransport(new BigDecimal(val));

								break;
							case 9:
								p.setLbpIndemnite(new BigDecimal(val));

								break;
							case 10:
								if(!(val==null || val=="")) {
								p.setLbpAutreFrais(new BigDecimal(val));}else {
									p.setLbpAutreFrais(new BigDecimal(0));
								}

								break;
							case 11:
								p.setLbpObjectifResultat(val);
								break;
							
							
							case 12:
								p.setLbpDestinationLibelle(val);
								break;
							}
							System.out.print("col " + cell.getColumnIndex() + " ");
						}
						System.out.println("-----------------------------------------------------------");
						p.setTBudgets(new TBudgets((short) 1));
						p.setTExercices(new TExercices("2017"));
						p.setTStatuts(new TStatuts("P1N"));
						p.setLbpMontantEngage(BigDecimal.ZERO);
						p.setLbpMontantDot(BigDecimal.ZERO);
						p.setTMinisteres(new TMinisteres((short) minCode));


						paysList.add(p);
						System.out.println("Ligne Budgétaire prepa [num= " + p.getLbpNum()
								+ ", Lieu= " + p.getLbpLieu() + ", Duree= " + p.getLbpDuree() + ", Transport= "
								+ p.getLbpTransport()+ ", Indemnité= " + p.getLbpIndemnite() + ", Autres frais= " + p.getLbpAutreFrais() + ", Dotation "
								+ p.getLbpMontantDot() + ", Objectif= " + p.getLbpObjectifResultat() + ", Ministère= "
								+ p.getTMinisteres().getMinCode() + ",  Direction= " + p.getLbpDestinationLibelle()
								+ "]");
					}
				} // Fin traitement des lignes autres que la première
				System.out.println("Les Lignes Budgétaires CSV Liste Taille :" + paysList.size());
			} catch (Exception e) {
				e.printStackTrace();
			}
		return paysList;	
	    }
	
	
	    public  List<PosteComptable> getPosteComptable(InputStream fileCSV) throws Exception {
		    
			List<PosteComptable> dList = new ArrayList<>();

			Scanner scanner = new Scanner(fileCSV);
			try {
				
				
				while (scanner.hasNext()) {
					PosteComptable d = new PosteComptable();
					List<String> data = parseLine(scanner.nextLine());
					d.setPcLibelle(data.get(0));
					dList.add(d);
						  System.out.println("PosteComptable [Libelle= " + data.get(0) + "]");
				}
				scanner.close();
			} catch (java.lang.IndexOutOfBoundsException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		

			System.out.println("PosteComptable CSV Liste Taille :"+dList.size());
	    return dList;	
	    }
	    
	    public  List<AutreAdministration> getAutreAdministrations(InputStream fileCSV) throws Exception {
		    
			List<AutreAdministration> dList = new ArrayList<>();

			Scanner scanner = new Scanner(fileCSV);
			try {
				
				
				while (scanner.hasNext()) {
					AutreAdministration d = new AutreAdministration();
					List<String> data = parseLine(scanner.nextLine());
					d.setAtraLibelle(data.get(0));
					d.setAtraType(data.get(1));
					dList.add(d);
						  System.out.println("AutreAdministration [Libelle= " + data.get(0) + ", Libelle= " + data.get(1) + "]");
				}
				scanner.close();
			} catch (java.lang.IndexOutOfBoundsException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		

			System.out.println("AutreAdministration CSV Liste Taille :"+dList.size());
	    return dList;	
	    }
 
	    public  List<Ministeres> getMinisteres(InputStream fileCSV) throws Exception {
		    
			List<Ministeres> paysList = new ArrayList<>();

			Scanner scanner = new Scanner(fileCSV);
			try {
				
				
				while (scanner.hasNext()) {
					Ministeres p = new Ministeres();
					List<String> data = parseLine(scanner.nextLine());
					p.setMinId(Integer.parseInt(data.get(0)));
					p.setMinLibelle(data.get(1));
					paysList.add(p);
						  System.out.println("Ministeres [id= " + data.get(0) + ", Libelle= " + data.get(1) + "]");
				}
				scanner.close();
			} catch (java.lang.IndexOutOfBoundsException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		

			System.out.println("Ministeres CSV Liste Taille :"+paysList.size());
	    return paysList;	
	    }
	    
	    public  List<Cabinet> getCabinets(InputStream fileCSV) throws Exception {
		    
			List<Cabinet> dList = new ArrayList<>();

			Scanner scanner = new Scanner(fileCSV);
			try {
				
				
				while (scanner.hasNext()) {
					Cabinet d = new Cabinet();
					Ministeres dp = new Ministeres();
					List<String> data = parseLine(scanner.nextLine());
					d.setCabId(Integer.parseInt(data.get(0)));
					dp.setMinId(Integer.parseInt(data.get(1)));
					d.setCabLibelle(data.get(2));
					d.setMinisteres(dp);
					
					dList.add(d);
						  System.out.println("Cabinet [id= " + data.get(0) + ", Ministère= " + data.get(1) + ", Libelle= " + data.get(2) + "]");
				}
				scanner.close();
			} catch (java.lang.IndexOutOfBoundsException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		

			System.out.println("Cabinet CSV Liste Taille :"+dList.size());
	  return dList;	
	  }
	    
	    public  List<Dg> getDgs(InputStream fileCSV) throws Exception {
		    
			List<Dg> dList = new ArrayList<>();

			Scanner scanner = new Scanner(fileCSV);
			try {
				
				
				while (scanner.hasNext()) {
					Dg d = new Dg();
					Cabinet dp = new Cabinet();
					List<String> data = parseLine(scanner.nextLine());
					d.setDgId(Integer.parseInt(data.get(0)));
					dp.setCabId(Integer.parseInt(data.get(1)));
					d.setDgLibelle(data.get(2));
					d.setCabinet(dp);
					
					dList.add(d);
						  System.out.println("Dg [id= " + data.get(0) + ", Cabinet= " + data.get(1) + ", Libelle= " + data.get(2) + "]");
				}
				scanner.close();
			} catch (java.lang.IndexOutOfBoundsException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		

			System.out.println("Dg CSV Liste Taille :"+dList.size());
	  return dList;	
	  }
	    
	    public  List<Direction> getDirections(InputStream fileCSV) throws Exception {
		    
			List<Direction> dList = new ArrayList<>();

			Scanner scanner = new Scanner(fileCSV);
			try {
				
				
				while (scanner.hasNext()) {
					Direction d = new Direction();
					Dg dp = new Dg();
					List<String> data = parseLine(scanner.nextLine());
					d.setDirId(Integer.parseInt(data.get(0)));
					dp.setDgId(Integer.parseInt(data.get(1)));
					d.setDirLibelle(data.get(2));
					d.setDg(dp);
					
					dList.add(d);
						  System.out.println("Direction [id= " + data.get(0) + ", DG= " + data.get(1) + ", Libelle= " + data.get(2) + "]");
				}
				scanner.close();
			} catch (java.lang.IndexOutOfBoundsException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		

			System.out.println("Directions CSV Liste Taille :"+dList.size());
	  return dList;	
	  }
	  
	    public  List<Service> getServices(InputStream fileCSV) throws Exception {
		    
			List<Service> dList = new ArrayList<>();

			Scanner scanner = new Scanner(fileCSV);
			try {
				
				
				while (scanner.hasNext()) {
					Service d = new Service();
					Direction dp = new Direction();
					List<String> data = parseLine(scanner.nextLine());
					d.setServId(Integer.parseInt(data.get(0)));
					dp.setDirId(Integer.parseInt(data.get(1)));
					d.setServLibelle(data.get(2));
					d.setDirection(dp);
					
					dList.add(d);
						  System.out.println("Service [id= " + data.get(0) + ", Direction= " + data.get(1) + ", Libelle= " + data.get(2) + "]");
				}
				scanner.close();
			} catch (java.lang.IndexOutOfBoundsException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		

			System.out.println("Services CSV Liste Taille :"+dList.size());
	  return dList;	
	  }
 
	    public  List<Pays> getPays(InputStream fileCSV) throws Exception {
	    
			List<Pays> paysList = new ArrayList<>();

			Scanner scanner = new Scanner(fileCSV);
			try {
				
				
				while (scanner.hasNext()) {
					Pays p = new Pays();
					List<String> data = parseLine(scanner.nextLine());
					p.setPayId(Integer.parseInt(data.get(0)));
					p.setPayLibelle(data.get(1));
					paysList.add(p);
						  System.out.println("Pays [id= " + data.get(0) + ", Libelle= " + data.get(1) + "]");
				}
				scanner.close();
			} catch (java.lang.IndexOutOfBoundsException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		

			System.out.println("Pays CSV Liste Taille :"+paysList.size());
	    return paysList;	
	    }
	    
	    public  List<Districts> getDistricts(InputStream fileCSV) throws Exception {
		    
			List<Districts> dList = new ArrayList<>();

			Scanner scanner = new Scanner(fileCSV);
			try {
				
				
				while (scanner.hasNext()) {
					Districts d = new Districts();
					Pays dp = new Pays();
					List<String> data = parseLine(scanner.nextLine());
					d.setDistId(Integer.parseInt(data.get(0)));
					dp.setPayId(Integer.parseInt(data.get(1)));
					d.setDistLibelle(data.get(2));
					d.setPays(dp);
					
					dList.add(d);
						  System.out.println("Districts [id= " + data.get(0) + ", Pays= " + data.get(1) + ", Libelle= " + data.get(2) + "]");
				}
				scanner.close();
			} catch (java.lang.IndexOutOfBoundsException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		

			System.out.println("Districts CSV Liste Taille :"+dList.size());
	    return dList;	
	    }
	    
  public  List<Regions> getRegions(InputStream fileCSV) throws Exception {
		    
			List<Regions> dList = new ArrayList<>();

			Scanner scanner = new Scanner(fileCSV);
			try {
				
				
				while (scanner.hasNext()) {
					Regions d = new Regions();
					Districts dp = new Districts();
					List<String> data = parseLine(scanner.nextLine());
					d.setRegId(Integer.parseInt(data.get(0)));
					dp.setDistId(Integer.parseInt(data.get(1)));
					d.setRegLibelle(data.get(2));
					d.setDistricts(dp);
					
					dList.add(d);
						  System.out.println("Regions [id= " + data.get(0) + ", District= " + data.get(1) + ", Libelle= " + data.get(2) + "]");
				}
				scanner.close();
			} catch (java.lang.IndexOutOfBoundsException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		

			System.out.println("Regions CSV Liste Taille :"+dList.size());
	    return dList;	
	    }
  
  public  List<Departements> getDepartements(InputStream fileCSV) throws Exception {
	    
		List<Departements> dList = new ArrayList<>();

		Scanner scanner = new Scanner(fileCSV);
		try {
			
			
			while (scanner.hasNext()) {
				Departements d = new Departements();
				Regions dp = new Regions();
				List<String> data = parseLine(scanner.nextLine());
				d.setDeptId(Integer.parseInt(data.get(0)));
				dp.setRegId(Integer.parseInt(data.get(1)));
				d.setDeptLibelle(data.get(2));
				d.setRegions(dp);
				
				dList.add(d);
					  System.out.println("Departements [id= " + data.get(0) + ", Région= " + data.get(1) + ", Libelle= " + data.get(2) + "]");
			}
			scanner.close();
		} catch (java.lang.IndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

		System.out.println("Departements CSV Liste Taille :"+dList.size());
  return dList;	
  }
  
  public  List<Villes> getVilles(InputStream fileCSV) throws Exception {
	    
		List<Villes> dList = new ArrayList<>();

		Scanner scanner = new Scanner(fileCSV);
		try {
			
			
			while (scanner.hasNext()) {
				Villes d = new Villes();
				Departements dp = new Departements();
				List<String> data = parseLine(scanner.nextLine());
				d.setVilId(Integer.parseInt(data.get(0)));
				dp.setDeptId(Integer.parseInt(data.get(1)));
				d.setVilLibelle(data.get(2));
				d.setDepartements(dp);
				
				dList.add(d);
					  System.out.println("Villes [id= " + data.get(0) + ", Departement= " + data.get(1) + ", Libelle= " + data.get(2) + "]");
			}
			scanner.close();
		} catch (java.lang.IndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

		System.out.println("Villes CSV Liste Taille :"+dList.size());
  return dList;	
  }
	    
	    
	    

	    public static List<String> parseLine(String cvsLine) {
	        return parseLine(cvsLine, DEFAULT_SEPARATOR, DEFAULT_QUOTE);
	    }

	    public static List<String> parseLine(String cvsLine, char separators) {
	        return parseLine(cvsLine, separators, DEFAULT_QUOTE);
	    }

	    public static List<String> parseLine(String cvsLine, char separators, char customQuote) {

	        List<String> result = new ArrayList<>();

	        //if empty, return!
	        if (cvsLine == null && cvsLine.isEmpty()) {
	            return result;
	        }

	        if (customQuote == ' ') {
	            customQuote = DEFAULT_QUOTE;
	        }

	        if (separators == ' ') {
	            separators = DEFAULT_SEPARATOR;
	        }

	        StringBuffer curVal = new StringBuffer();
	        boolean inQuotes = false;
	        boolean startCollectChar = false;
	        boolean doubleQuotesInColumn = false;

	        char[] chars = cvsLine.toCharArray();

	        for (char ch : chars) {

	            if (inQuotes) {
	                startCollectChar = true;
	                if (ch == customQuote) {
	                    inQuotes = false;
	                    doubleQuotesInColumn = false;
	                } else {

	                    //Fixed : allow "" in custom quote enclosed
	                    if (ch == '\"') {
	                        if (!doubleQuotesInColumn) {
	                            curVal.append(ch);
	                            doubleQuotesInColumn = true;
	                        }
	                    } else {
	                        curVal.append(ch);
	                    }

	                }
	            } else {
	                if (ch == customQuote) {

	                    inQuotes = true;

	                    //Fixed : allow "" in empty quote enclosed
	                    if (chars[0] != '"' && customQuote == '\"') {
	                        curVal.append('"');
	                    }

	                    //double quotes in column will hit this!
	                    if (startCollectChar) {
	                        curVal.append('"');
	                    }

	                } else if (ch == separators) {

	                    result.add(curVal.toString());

	                    curVal = new StringBuffer();
	                    startCollectChar = false;

	                } else if (ch == '\r') {
	                    //ignore LF characters
	                    continue;
	                } else if (ch == '\n') {
	                    //the end, break!
	                    break;
	                } else {
	                    curVal.append(ch);
	                }
	            }

	        }

	        result.add(curVal.toString());

	        return result;
	    }

	    public InputStream  xlsToCSV(InputStream xlsFile) 
	    {
	    	
	    	
	    	
		     InputStream csvFile=null;
	    	OutputStream csvStream = new ByteArrayOutputStream();
	            // For storing data into CSV files
	            StringBuffer data = new StringBuffer();
	            try 
	            {
	           // FileOutputStream fos = new FileOutputStream(csvStream);

	            // Get the workbook object for XLS file
	            HSSFWorkbook workbook = new HSSFWorkbook(xlsFile);
	            // Get first sheet from the workbook
	            HSSFSheet sheet = workbook.getSheetAt(0);
	            Cell cell;
	            Row row;

	            // Iterate through each rows from first sheet
	            Iterator<Row> rowIterator = sheet.iterator();
	            while (rowIterator.hasNext()) 
	            {
	                    row = rowIterator.next();
	                    // For each row, iterate through each columns
	                    Iterator<Cell> cellIterator = row.cellIterator();
	                    while (cellIterator.hasNext()) 
	                    {
	                            cell = cellIterator.next();
	                            
	                           
	                            
	                            
	                            switch (cell.getCellType()) 
	                            {
	                            case Cell.CELL_TYPE_BOOLEAN:
	                                    data.append(cell.getBooleanCellValue() + ",");
	                                    break;
	                                    
	                            case Cell.CELL_TYPE_NUMERIC:
	                            Double d=cell.getNumericCellValue();
	                                    data.append(d.intValue() + ",");
	                                    break;
	                                    
	                            case Cell.CELL_TYPE_STRING:
	                                    data.append(cell.getStringCellValue() + ",");
	                                    break;

	                            case Cell.CELL_TYPE_BLANK:
	                                    data.append("");
	                                    break;
	                            
	                            default:
	                                    data.append(cell.getStringCellValue() + ",");
	                                   
	                            } 
	                            
	                             
	                    }
	                    data.append('\n');
	            }

	            csvStream.write(data.toString().getBytes());
	            
	            ByteArrayOutputStream buffer = (ByteArrayOutputStream) csvStream;
		    	byte[] bytes = buffer.toByteArray();
		    	 csvFile = new ByteArrayInputStream(bytes);
		    	// csvFile= new ByteArrayInputStream(buffer.toByteArray()); 
	            
		    	csvStream.close();
	            }
	            catch (FileNotFoundException e) 
	            {
	                    e.printStackTrace();
	            }
	            catch (IOException e) 
	            {
	                    e.printStackTrace();
	            }
	            return csvFile;
	            }



}
*/