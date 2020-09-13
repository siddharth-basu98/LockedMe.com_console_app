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

	@Override
	public FileObject createFile(FileObject file) throws FileSystemException {
		return dao.createFile(file) ; 
	}

	@Override
	public void deleteFile(String fileName) throws FileSystemException {
		dao.deleteFile(fileName);
	}

	@Override
	public List<FileObject> getFiles() throws FileSystemException {
		return dao.getFiles() ; 
	}

	@Override
	public List<FileObject> getFilesByDate(LocalDate date) throws FileSystemException {
		try{
			return dao.getFilesByDate(date) ; 
		}
		catch(Exception e) {
			throw new FileSystemException("The date entered is invalid") ; 
		}
	}

	@Override
	public List<FileObject> getFileByExtension(String extension) throws FileSystemException {
		return dao.getFileByExtension(extension) ; 
	}

	@Override
	public List<FileObject> getFilesBeforeDate(LocalDate date) throws FileSystemException {
		return dao.getFilesBeforeDate(date) ; 
	}

	@Override
	public List<FileObject> getFilesAfterDate(LocalDate date) throws FileSystemException {
		return dao.getFilesAfterDate(date) ; 
	}

	@Override
	public FileObject getFileByName(String name) throws FileSystemException {
		return dao.getFileByName(name) ; 
	}

	@Override
	public List<FileObject> getFilesByCreator(String name) throws FileSystemException {
		return dao.getFilesByCreator(name) ; 
	}
	
	
}
