package com.filesystem.model;

import java.io.File;
import java.time.LocalDate;

public class FileObject {
	
	private String name ;
	private int file_id ; 
	private String creatorName ;
	private LocalDate dateCreated ; 
	private String extension ; 
	private String description ; 
	
	
	
	public String getName() {
		return name;
	}
	

	public void setName(String name) {
		this.name = name;
	}
	
	public int getFile_id() {
		return file_id;
	}


	public void setFile_id(int file_id) {
		this.file_id = file_id;
	}

	
	public String getCreatorName() {
		return creatorName;
	}

	
	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}

	public LocalDate getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public String toString() {
		return "FileObject [name=" + name + ", file_id=" + file_id + ", creatorName=" + creatorName + ", dateCreated="
				+ dateCreated + ", extension=" + extension + ", description=" + description + "]";
	}
	

	


	

}
