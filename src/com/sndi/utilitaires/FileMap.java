package com.sndi.utilitaires;


import org.primefaces.model.UploadedFile;


public class FileMap {
private UploadedFile file; 	
private String filename;


public String getFilename() {
	return filename;
}
public void setFilename(String filename) {
	this.filename = filename;
}
public UploadedFile getFile() {
	return file;
}
public void setFile(UploadedFile file) {
	this.file = file;
}


}
