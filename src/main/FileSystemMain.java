package main;

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
		System.out.println("---------------------------------------------");
		
		int ch = 0;
		Scanner scanner = new Scanner(System.in);
		
		FileSystemService service = new FileSystemServiceImpl() ; 
		String file_name ; 
		String dateString ; 
		
		System.out.println("All file system actions will be performed in the directory: " + System.getProperty("user.dir") + "/Files");

		

		
		do {
			
			System.out.println();
			System.out.println();
			System.out.println();

			
			System.out.println("\nFile System Services Menu");
			System.out.println("============================");
			System.out.println("1)Create and add a file");
			System.out.println("2)Delete a file");
			System.out.println("3)Get a sorted list of all the files");
			System.out.println("4)Get files created on a particular date");
			System.out.println("5)Get files created before a particular date");
			System.out.println("6)Get files created after a particular date");
			System.out.println("7)Get files by file extension");
			System.out.println("8)Get files by Creator name");
			System.out.println("9)Get file by file name");
			System.out.println("10)EXITTT") ; 
			
			
			System.out.println("Please Enter your appropriate choice(1-9)");
			
			try {
				ch = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.out.println(e);
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
					System.out.println("File created with details "+ fileObj);
				} catch (FileSystemException e) {
					System.out.println(e.getMessage());
				}
				break;
			
			
			
			case 2:
				
				System.out.println();
				System.out.println();
				System.out.println();

				
				System.out.println("Enter File Name you want to delete below.....");
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

				System.out.println("You chose to see the list of files in the directory " + System.getProperty("user.dir") + "/Files");
					
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

				System.out.println("Please enter the date strictly in the following format YYYY-MM-DD");
			    dateString = scanner.nextLine();
				
			    try {
					LocalDate date = LocalDate.parse(dateString);
					List<FileObject> filesOnDate = service.getFilesByDate(date) ; 
					for(FileObject f: filesOnDate) {
						System.out.println(f);
					}
				} catch (FileSystemException e) {
					System.out.println(e.getMessage());
				} catch (Exception e){
					System.out.println("Invalid date entered. Please adhere to the format strictly");
				}
				
			    break;
			
			
			
			case 5:
				
				System.out.println();
				System.out.println();
				System.out.println();

				System.out.println("Please Enter the date strictly in the following format YYYY-MM-DD");
			    dateString = scanner.nextLine();
				
			    try {
					LocalDate date = LocalDate.parse(dateString);
					List<FileObject> filesBeforeDate = service.getFilesBeforeDate(date) ; 
					for(FileObject f: filesBeforeDate) {
						System.out.println(f);
					}
				} catch (FileSystemException e) {
					System.out.println(e.getMessage());
				} catch (Exception e){
					System.out.println("Invalid date entered. Please adhere to the format strictly");
				}
			    
				
			    break;			
			
			
			case 6:
				
				System.out.println();
				System.out.println();
				System.out.println();

				System.out.println("Please Enter the date strictly in the following format YYYY-MM-DD");
			    dateString = scanner.nextLine();
				
			    try {
					LocalDate date = LocalDate.parse(dateString);
					List<FileObject> filesAfterDate = service.getFilesAfterDate(date) ; 
					for(FileObject f: filesAfterDate) {
						System.out.println(f);
					}
				} catch (FileSystemException e) {
					System.out.println(e.getMessage());
				} catch (Exception e){
					System.out.println("Invalid date entered. Please adhere to the format strictly");
				}
				
			    break;		
			
			
			
			case 7:
				System.out.println();
				System.out.println();
				System.out.println();

				System.out.println("Enter Extension name without the '.' (ex. html, pdf) you want the list of files for.....");
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

				System.out.println("Enter the creator name whose created files you want to check.....");
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

				System.out.println("Enter the file name whose details you want to check.....");
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

				System.out.println("Thank you for using our system.") ;
				System.out.println("################################") ; 
				break ; 
			
			
			
			default:
				System.out.println("Entered choice is invalid it should be numbers between 1-9 only");
				break;
			}

		} while (ch != 10);
		
		
	}

}
