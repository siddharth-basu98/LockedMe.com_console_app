package com.filesystem.service.impl;

import java.time.LocalDate;
import java.util.List;

import com.filesystem.dao.FileSystemDAO;
import com.filesystem.dao.impl.FileSystemDAOImpl;
import com.filesystem.exception.FileSystemException;
import com.filesystem.model.FileObject;
import com.filesystem.service.FileSystemService;

public class FileSystemServiceImpl implements FileSystemService {
	
	private FileSystemDAO dao = new FileSystemDAOImpl() ;
	
	
	private boolean isValidFileName(String file_name) {
		if(file_name.trim().length()<3) {
			return false ; 
		}
		
		return true ; 
	}
	
	
	private boolean isValidName(String name) {
		if(name.length()==0) {
			return false ; 
		}
		
		return true ; 
	}
	
	
	private boolean isValidExtension(String extension) {
		
		if(extension.length()>0) {
			return true ; 
		}
		return false; 
	}
	
	private boolean isExtensionPresent(String file_name) {
		if(file_name.lastIndexOf(".")>0 && file_name.lastIndexOf(".")<file_name.length()) {
			return true ; 
		}
		return false; 
	}
	
	
	private boolean isValidDate(String date_string) {
		try {
			LocalDate date = LocalDate.parse(date_string);
			return true ; 
		}
		catch(Exception e){
			return false ; 
		}
		
	}
	
	

	@Override
	public FileObject createFile(FileObject file) throws FileSystemException {
		
		if(isValidFileName(file.getName())==false) {
			throw new FileSystemException("The file name after trimming including the extension should be of minimum 3 character length") ; 

		}
		else if(isExtensionPresent(file.getName())==false) {
			throw new FileSystemException("The file name must have an extension like for example index.html, data.pdf etc..") ; 

		}
		else {
			file.setName(file.getName().trim());
			return dao.createFile(file) ; 
		}
		
	}

	@Override
	public void deleteFile(String fileName) throws FileSystemException {
		
		if(fileName.length()>0) {
			dao.deleteFile(fileName);
		}
		else {
			throw new FileSystemException("The file name entered is a null having zero length. Enter valid file name") ; 
		}
		
		
	}

	@Override
	public List<FileObject> getFiles() throws FileSystemException {
		return dao.getFiles() ; 
	}

	@Override
	public List<FileObject> getFilesByDate(String date_string) throws FileSystemException {
		
		if(isValidDate(date_string)) {
			LocalDate date = LocalDate.parse(date_string);
			return dao.getFilesByDate(date) ; 
		}
		else {
			throw new FileSystemException("The date entered is an invalid date") ; 
		}
	}

	@Override
	public List<FileObject> getFileByExtension(String extension) throws FileSystemException {
		
		if(isValidExtension(extension)) {
			return dao.getFileByExtension(extension) ; 
		}
		else {
			throw new FileSystemException("The entered extension name is not valid") ; 
		}
		
	}

	
	@Override
	public List<FileObject> getFilesBeforeDate(String date_string) throws FileSystemException {
		
		if(isValidDate(date_string)) {
			LocalDate date = LocalDate.parse(date_string);
			return dao.getFilesBeforeDate(date) ; 
		}
		else {
			throw new FileSystemException("The date entered is an invalid date") ; 
		}
		
	}

	@Override
	public List<FileObject> getFilesAfterDate(String date_string) throws FileSystemException {
		if(isValidDate(date_string)) {
			LocalDate date = LocalDate.parse(date_string);
			return dao.getFilesAfterDate(date) ; 
		}
		else {
			throw new FileSystemException("The date entered is an invalid date") ; 
		}
		
	}

	@Override
	public FileObject getFileByName(String name) throws FileSystemException {
		
		if(isValidName(name)) {
			return dao.getFileByName(name) ; 
		}
		else {
			throw new FileSystemException("The file name entered is a null having zero length. Enter valid file name") ; 
		}
		
	}

	@Override
	public List<FileObject> getFilesByCreator(String name) throws FileSystemException {
		
		if(isValidName(name)) {
			return dao.getFilesByCreator(name) ; 
		}
		else {
			throw new FileSystemException("The creator name entered is a null having zero length. Enter valid file name") ; 
		}
		
	}


	@Override
	public FileObject updateCreatorName(String fileName, String newCreatorName) throws FileSystemException {
		
		if(isValidName(newCreatorName)==false) {
			throw new FileSystemException("The creator name entered is a null having zero length. Enter valid file name") ; 
		}
		else if(isValidFileName(fileName)==false) {
			throw new FileSystemException("The file name you want to update is an invalid name") ; 
		}
		else {
			return dao.updateCreatorName(fileName, newCreatorName) ; 
		}
		
	}


	
	
}
