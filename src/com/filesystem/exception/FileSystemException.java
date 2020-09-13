package com.filesystem.exception;

public class FileSystemException extends Exception {
	
	private static final long serialVersionUID = 1L;

	
	public FileSystemException(){
		super() ; 
	}
	
	public FileSystemException(final String message) {
		super(message) ; 
	}

}
