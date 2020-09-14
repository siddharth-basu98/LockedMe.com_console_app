package com.filesystem.main;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.filesystem.exception.FileSystemException;
import com.filesystem.model.FileObject;
import com.filesystem.service.FileSystemService;
import com.filesystem.service.impl.FileSystemServiceImpl;

public class FileSystemMain {

	public static void main(String[] args) {
		
		
		System.out.println("Welcome to the LockedMe.com Console App V1.0");
		System.out.println("Developed by Siddharth Basu");
		System.out.println("---------------------------------------------");
		
		
		int ch = 0;
		Scanner scanner = new Scanner(System.in);
		
		FileSystemService service = new FileSystemServiceImpl() ; 
		String file_name ; 
		String dateString ; 
		
		System.out.println("All file system actions will be performed in the directory: " + System.getProperty("user.dir") + "/Files");
		System.out.println();
		System.out.println();

		int enter = 0 ; 
		
		do {
			
			System.out.println("\nWelome to the home screen of LockedMe.com");
			System.out.println("============================================");
			System.out.println();
			System.out.println("1) View the services offered by the application");
			System.out.println("2) EXIT AND TERMINATE THE APP COMPLETELY");
			
			System.out.println();
			System.out.println();
			
			
			
			try {
				System.out.println("Please enter your input below");
				enter = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("You didn't enter a valid number. Please try again");
				continue ; 
			}
			
			
			switch(enter) {
			
			case 1: 
				
				do {
					
					System.out.println();
					System.out.println();
					System.out.println();

					
					System.out.println("\nFile System Services Menu");
					System.out.println("============================");
					System.out.println("1) -> Create and add a file");
					System.out.println("2) -> Delete a file");
					System.out.println("3) -> Get a sorted list of all the files");
					System.out.println("4) -> Get files created on a particular date");
					System.out.println("5) -> Get files created before a particular date");
					System.out.println("6) -> Get files created after a particular date");
					System.out.println("7) -> Get files by file extension");
					System.out.println("8) -> Get files by Creator name");
					System.out.println("9) -> Get file by file name");
					System.out.println("10) -> Update the creator name of a file");
					System.out.println("11) -> Return back to the Main menu") ; 
					
					
					System.out.println();
					System.out.println();
					
					System.out.println("Please Enter your appropriate choice(1-11)");
					
					
					try {
						ch = Integer.parseInt(scanner.nextLine());
					} catch (NumberFormatException e) {
						System.out.println("You didn't enter a valid number. Please try again");
						continue ; 
					}
					
					switch (ch) {
					
					case 1:
						
						
						System.out.println();
						System.out.println();
						System.out.println();

						
						System.out.println("Enter File Details Below.....");
						
						FileObject fileObj =new FileObject();
						
						System.out.println("Enter File Name");
						file_name = scanner.nextLine() ; 
						fileObj.setName(file_name);
						
						System.out.println("Enter Creator's name");
						fileObj.setCreatorName(scanner.nextLine());
						
						fileObj.setDateCreated(LocalDate.now());
						
						fileObj.setExtension(file_name.substring(file_name.lastIndexOf(".") + 1));
						
						System.out.println("Enter some short description about the file");
						fileObj.setDescription(scanner.nextLine());
						
						try {
							fileObj=service.createFile(fileObj) ; 
							System.out.println("\n \nFile created with details "+ fileObj);
						} catch (FileSystemException e) {
							System.out.println(e.getMessage());
						}
						break;
					
					
					
					case 2:
						
						System.out.println();
						System.out.println();
						System.out.println();

						
						System.out.println("\n\nEnter File Name you want to delete below.....");
						file_name = scanner.nextLine() ;
						
						try {
							service.deleteFile(file_name);
						}
						catch (Exception e) {
							System.out.println(e.getMessage());
						}
						
						break ; 
			
					
					case 3:
						
						System.out.println();
						System.out.println();
						System.out.println();

						System.out.println("\n\nYou chose to see the list of files in the directory " + System.getProperty("user.dir") + "/Files");
							
						try {
							List<FileObject> filesInDirectory = service.getFiles();
							for(FileObject f: filesInDirectory) {
								System.out.println(f);
							}
						} catch (FileSystemException e) {
							System.out.println(e.getMessage());
						}

						break;
					
					
					
					case 4:
						
						System.out.println();
						System.out.println();
						System.out.println();

						System.out.println("\n\nPlease enter the date strictly in the following format YYYY-MM-DD");
					    dateString = scanner.nextLine();
						
					    try {
							
					    	List<FileObject> filesOnDate = service.getFilesByDate(dateString) ; 
							
							for(FileObject f: filesOnDate) {
								System.out.println(f);
							}
							
						} catch (FileSystemException e) {
							System.out.println(e.getMessage());
						} 
						
					    break;
					
					
					
					case 5:
						
						System.out.println();
						System.out.println();
						System.out.println();

						System.out.println("\n\nPlease Enter the date strictly in the following format YYYY-MM-DD");
					    dateString = scanner.nextLine();
						
					    try {
							
							List<FileObject> filesBeforeDate = service.getFilesBeforeDate(dateString) ; 
							
							for(FileObject f: filesBeforeDate) {
								System.out.println(f);
							}
							
						} catch (FileSystemException e) {
							System.out.println(e.getMessage());
						} 
						
					    break;			
					
					
					case 6:
						
						System.out.println();
						System.out.println();
						System.out.println();

						System.out.println("\n\nPlease Enter the date strictly in the following format YYYY-MM-DD");
					    dateString = scanner.nextLine();
						
					    try {
					    	
							List<FileObject> filesAfterDate = service.getFilesAfterDate(dateString) ; 
							for(FileObject f: filesAfterDate) {
								System.out.println(f);
							}
							
						} catch (FileSystemException e) {
							System.out.println(e.getMessage());
						} 
						
					    break;		
					
					
					
					case 7:
						System.out.println();
						System.out.println();
						System.out.println();

						System.out.println("\n\nEnter Extension name without the '.' (ex. html, pdf) you want the list of files for.....");
						String extension_name = scanner.nextLine() ;
						
						try {
							List<FileObject> filesWithExtension = service.getFileByExtension(extension_name) ; 
							for(FileObject f: filesWithExtension) {
								System.out.println(f);
							}
						}
						catch (Exception e) {
							System.out.println(e.getMessage());
						}
						
						break ; 
						
					
					
					
					case 8:
						System.out.println();
						System.out.println();
						System.out.println();

						System.out.println("\n\nEnter the creator name whose created files you want to check.....");
						String creator_name = scanner.nextLine() ;
						
						try {
							List<FileObject> filesOfCreator = service.getFilesByCreator(creator_name) ; 
							for(FileObject f: filesOfCreator) {
								System.out.println(f);
							}
						}
						catch (Exception e) {
							System.out.println(e.getMessage());
						}
						
						break ; 
					
					
					
					case 9:
						System.out.println();
						System.out.println();
						System.out.println();

						System.out.println("\n\nEnter the file name whose details you want to check.....");
						file_name = scanner.nextLine() ;
						
						try {
							System.out.println(service.getFileByName(file_name));
						}
						catch (Exception e) {
							System.out.println(e.getMessage());
						}

						break;
						
						
					case 10: 
						System.out.println();
						System.out.println();
						System.out.println();
						
						System.out.println("\n\nEnter the file name whose details you want to check.....");
						file_name = scanner.nextLine() ;
						
						System.out.println("\nEnter the updated creator name for this file.....");
						String new_creator_name = scanner.nextLine() ;
						
						try {
							System.out.println(service.updateCreatorName(file_name, new_creator_name));
						} catch (FileSystemException e) {
							System.out.println(e.getMessage());
						}
						break ; 
						
					
					case 11:
						
						System.out.println();

						System.out.println("\nThank you for using our system. Taking you back to the main menu") ;
						System.out.println("################################################################") ; 
						System.out.println();
						System.out.println();
						
						break ; 
						
					
					
					
					default:
						System.out.println("\n\nEntered choice is invalid it should be numbers between 1-11 only");
						break;
					}

				} while (ch != 11);
				
				
				break; 
				
			case 2: 
				
				System.out.println();
				
				System.out.println("EXITING FROM THE APPLICATION COMPLETELY, PLEASE VISIT AGAIN");
				System.out.println("*************************************************************");
				break ; 
			
			
			default: System.out.println("You can only enter values 1 and 2. All other inputs are invalid");
				break ; 
			}
			
		} while(enter!=2) ; 
		
		
	}

}
