package simplilearnFinalProject;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class LockedMe
{
	static final String projectFilesPath="D:\\Feb_Development\\LockedMeFiles";
	
	
	

       public static void displayMenu ()
  {
	  System.out.println("******************************************************");
	  System.out.println("\tWelocme to LockedMe.com Secure app");
	  System.out.println("\tDeveloped by : Vivek Kumar");
	  System.out.println("******************************************************");
      System.out.println("\t1.Display all files ");
      System.out.println("\t2.Add a new file");
      System.out.println("\t3.Deleted a files ");
      System.out.println("\t4.Search files");
      System.out.println("\t5. Exit");
      System.out.println("*************************************");
  }
       /**
        * This method will retrieve all the files
        */
       
 
       public static void getAllfiles()
      {
    	File folder = new File(projectFilesPath); 
    	
    	File[] listOfFiles = folder.listFiles();
    	
    if (listOfFiles.length>0)	
    {
    	System.out.println("FILES LIST IS BELOW:\n");
    	
      for(var l:listOfFiles)
      {
   System.out.println(l.getName());  	  
  }
     
      }  
    
      
    else
    {
    	System.out.println("The folder is Empty");
    }
      }
      /**
       * This method will read the file details from user and creates files
       */
       public static void createFiles()
     {
    	 try
    	 {
    		 // Variable declaration	
    		 
    	Scanner obj =new Scanner (System.in);
    	String fileName;
    	// Read file name from user
    	
    	System.out.println("Enter file name;");
    	fileName =obj.nextLine();
    
    	int linesCount;
    	System.out.println("Enter how many lines in the file");
    	linesCount=Integer.parseInt(obj.nextLine());
    	
    	FileWriter fw = new FileWriter(projectFilesPath+"\\"+fileName);
    	
     //Read line by line from user
    	for(int i=1;i<linesCount;i++)
    	{
    		System.out.println("Enter file line:");
    		fw.write(obj.nextLine()+"f");
    	}
    	System.out.println("File Created Sucessfully");
    	fw.close();
    	 }
    	 catch(Exception Ex)
    	 {
    	 }
     }
/**
 * This method will take file name as parameters and check if 
 * it is present  in the project folder or not	
 * @param fileName String
 * @return boolean
 */
       public static boolean checkFileExits(String fileName)
       {
    	   //Get all files names  into 	a list
    	   ArrayList<String> allFilesNames =new ArrayList<String>();
    	   File folder = new File (projectFilesPath);
    	   File[] listOfFiles = folder.listFiles();
    	   if (listOfFiles.length>0)
    	   {
    		   for (var l:listOfFiles)
    		   {
    			   allFilesNames.add(l.getName());	   
    		   }
    	   }
    	return allFilesNames.contains(fileName);
    			 
       }

       public static void deleteFiles()
   {
     try
     {
   
     Scanner obj = new Scanner (System.in);
	  String fileName;
	  System.out.println("Enter file name");
	  fileName=obj.nextLine();
	  
	  File f= new File(projectFilesPath+"\\"+fileName);
	   if (checkFileExits(fileName))	
	   {  
		   f.delete();
		   System.out.println("File deleted sucessfully");
		   
	   }
	   else
	   {
		   System.out.println("File does not exist");
	   }
     }
	   catch (Exception Ex)
     {
		   System.out.println("Unable to delete file. Pleaes contact admin@.com");
     }
   
   }
       
      public static void searchFiles()
      {
    	  try
    	  {
            Scanner obj = new Scanner (System.in);
            String fileName;
           System.out.println("Enter the file to be Searched");
           fileName=obj.nextLine();
          
    	  if (checkFileExits(fileName))
    	  {
    		 System.out.println("File is available"); 
    	  
    	  }
    	  else 
    		  System.out.println("File is not available");
          }
    	  catch (Exception Ex)
    	  {
}
    	  
      }
}
