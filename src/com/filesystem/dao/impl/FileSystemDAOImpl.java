package com.filesystem.dao.impl;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import com.filesystem.dao.FileSystemDAO;
import com.filesystem.exception.FileSystemException;
import com.filesystem.model.FileObject;

public class FileSystemDAOImpl implements FileSystemDAO {
	
	
	
	private Map<String, FileObject> fileSystemMap = new TreeMap<String, FileObject>() ;
	private String dir = System.getProperty("user.dir") + "/Files"; 

	
	
	
	@Override
	public FileObject createFile(FileObject file) throws FileSystemException {
		
		
		if(fileSystemMap.containsKey(file.getName())==true){
			throw new FileSystemException("The entered file name already exists in the directory. Try with a different file name") ; 
		}
		
		
		try {
			File f = new File(dir + "/" + file.getName()) ; 
			f.createNewFile() ; 
		}
		catch(Exception ex){
			System.out.println("File I/O Error occured while creating file in the directory") ; 
		}
		
		
		fileSystemMap.put(file.getName(), file) ; 
		return file;
	}
	
	
	

	@Override
	public void deleteFile(String fileName) throws FileSystemException {
		
		String file_name = dir+"/" + fileName ; 
		File toDeleteObj = new File(file_name); 
		
//		if(fileSystemMap.containsKey(fileName)==false){
//			throw new FileSystemException("The entered file name doesn't exists in the directory.") ; 
//		}
		
	 
		if (toDeleteObj.delete()) { 
	      System.out.println("Deleted the file: " + fileName);
	    } else {
	      throw new FileSystemException("The entered file name doesn't exist in the directory") ; 
	    } 
			
		fileSystemMap.remove(fileName) ; 
	}
	
	
	

	@Override
	public List<FileObject> getFiles() throws FileSystemException {
		
		List<FileObject> file_list= new ArrayList<FileObject>(fileSystemMap.values()) ; 
		
		if(file_list.size()==0) {
			throw new FileSystemException("There are currently no files in the directory") ; 
		}
		else {
			return file_list ; 
		}
	
	}



	@Override
	public List<FileObject> getFileByExtension(String extension) throws FileSystemException {
		
		List<FileObject> fileList = fileSystemMap.values().stream()
				.filter(s -> s.getExtension().compareTo(extension)==0)
				.collect(Collectors.toList());
		
		if(fileList.size()==0) {
			throw new FileSystemException("There are currently no files with this extension") ; 
		}
		else {
			return fileList ; 
		}
		
	}
	
	
	
	
	
	@Override
	public List<FileObject> getFilesByDate(LocalDate date) throws FileSystemException {
		
	
		List<FileObject> fileList = fileSystemMap.values().stream()
				.filter(s -> s.getDateCreated().compareTo(date)==0)
				.collect(Collectors.toList());
		
		if(fileList.size()==0) {
			throw new FileSystemException("There are no files created on this date") ; 
		}
		else {
			return fileList ; 
		}
		
	}
	
	
	
	
	

	@Override
	public List<FileObject> getFilesBeforeDate(LocalDate date) throws FileSystemException {
		
		
		
		List<FileObject> fileList = fileSystemMap.values().stream()
				.filter(s -> s.getDateCreated().compareTo(date)<0)
				.collect(Collectors.toList());
		
		
		if(fileList.size()==0) {
			throw new FileSystemException("There are currently no files created before this date") ; 
		}
		else {
			return fileList ; 
		}
	
	}
	
	
	

	@Override
	public List<FileObject> getFilesAfterDate(LocalDate date) throws FileSystemException {
		
	
		
		List<FileObject> fileList = fileSystemMap.values().stream()
				.filter(s -> s.getDateCreated().compareTo(date)>0)
				.collect(Collectors.toList());
		
		
		if(fileList.size()==0) {
			throw new FileSystemException("There are currently no files created after this date") ; 
		}
		else {
			return fileList ; 
		}
		
	}



	@Override
	public FileObject getFileByName(String name) throws FileSystemException {
		
		if(fileSystemMap.containsKey(name)==false) {
			throw new FileSystemException("The file you requested for doesn't exist in the directory") ; 
		}
		else {
			return fileSystemMap.get(name) ; 
		}
		
	}




	@Override
	public List<FileObject> getFilesByCreator(String name) throws FileSystemException {
		
		List<FileObject> fileList = fileSystemMap.values().stream()
				.filter(s -> s.getCreatorName().compareTo(name)==0)
				.collect(Collectors.toList());
		
		if(fileList.size()==0) {
			throw new FileSystemException("There are no files created by the entered user.") ; 
		}
		else {
			return fileList ; 
		}
		
	}




	@Override
	public FileObject updateCreatorName(String fileName, String newCreatorName) throws FileSystemException {
		
		if(fileSystemMap.containsKey(fileName)==false) {
			throw new FileSystemException("There is no file in the directory with the given name") ; 
		}
		
		FileObject currentFile = fileSystemMap.get(fileName) ; 
		currentFile.setCreatorName(newCreatorName);
		
		fileSystemMap.put(fileName, currentFile) ; 
		
		return currentFile;
	}

	
	

}
