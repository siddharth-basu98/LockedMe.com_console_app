package com.filesystem.dao;

import java.time.LocalDate;
import java.util.List;

import com.filesystem.exception.FileSystemException;
import com.filesystem.model.FileObject;

public interface FileSystemDAO {
	
	FileObject createFile(FileObject file) throws FileSystemException ; 
	void deleteFile(String fileName) throws FileSystemException ; 
	List<FileObject> getFiles() throws FileSystemException; 
	List<FileObject> getFilesByDate(LocalDate date) throws FileSystemException ; 

	List<FileObject> getFileByExtension(String extension) throws FileSystemException ; 
	
	List<FileObject> getFilesBeforeDate(LocalDate date) throws FileSystemException ; 
	List<FileObject> getFilesAfterDate(LocalDate date) throws FileSystemException ; 
	
	FileObject getFileByName(String name) throws FileSystemException ; 
	
	List<FileObject> getFilesByCreator(String name) throws FileSystemException ; 


}
