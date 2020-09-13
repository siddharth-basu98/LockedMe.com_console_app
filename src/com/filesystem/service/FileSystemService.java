package com.filesystem.service;

import java.time.LocalDate;
import java.util.List;

import com.filesystem.exception.FileSystemException;
import com.filesystem.model.FileObject;

public interface FileSystemService {
	
	FileObject createFile(FileObject file) throws FileSystemException ; 
	void deleteFile(String fileName) throws FileSystemException ; 
	
	List<FileObject> getFiles() throws FileSystemException ; 
	List<FileObject> getFilesByDate(String date_string) throws FileSystemException ; 
	List<FileObject> getFileByExtension(String extension) throws FileSystemException ; 
	List<FileObject> getFilesBeforeDate(String date_string) throws FileSystemException ; 
	List<FileObject> getFilesAfterDate(String date_string) throws FileSystemException ; 
	FileObject getFileByName(String name) throws FileSystemException ; 
	List<FileObject> getFilesByCreator(String name) throws FileSystemException ; 
	FileObject updateCreatorName(String fileName, String newCreatorName) throws FileSystemException ; 
	
}
