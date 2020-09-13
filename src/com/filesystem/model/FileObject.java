package com.filesystem.model;

import java.io.File;
import java.time.LocalDate;

public class FileObject {
	
	private String name ; 
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
		return "FileObject [name=" + name + ", creatorName=" + creatorName + ", dateCreated=" + dateCreated
				+ ", extension=" + extension + ", description=" + description + "]";
	}



	

}
