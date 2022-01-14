package com.sl.phase1project;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.sl.phase1project.FileUtility;

public class Operations implements FileUtility  {
	List<String> retrieve= new ArrayList<String>();
	File[] files = new File("/Users/abhishekraj/Desktop/WORKSPACE JAVA/SimpliLearnProject").listFiles();
	@Override
	public void showAllFiles() {
		// TODO Auto-generated method stub
		for(File file : files) {
			if(file.isFile()) {
				retrieve.add(file.getName());
				//System.out.println(file.getName());
			}
		}
		retrieve.forEach(System.out::println);

	}

	@Override
	public void addFile() {
		// TODO Auto-generated method stub
		System.out.println("Enter the file which you want to add:");
		//sc.next();
		Scanner scan=new Scanner(System.in);
		String filename=scan.nextLine();
		File F= new File(filename);
		try {
			if(F.createNewFile()) {
				System.out.println(filename+" file is added to the directory");
				Desktop.getDesktop().edit(F);
			}
			else {
				System.out.println("This file is already there");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

	}

	@Override
	public void deleteFile() {
		// TODO Auto-generated method stub
		System.out.println("Enter the file which you want to delete:");
		//sc.next();
		Scanner scan=new Scanner(System.in);
		String filename=scan.nextLine();
		File F= new File(filename);
		if(F.delete())
			System.out.println(filename+" got Deleted");
		else
			System.out.println("File Not Found");
	}
	
	/*
	@Override
	public void searchFile() {
		// TODO Auto-generated method stub
		try {	
			Scanner scan= new Scanner(System.in);
			File directory = new File("/Users/abhishekraj/Desktop/WORKSPACE JAVA/SimpliLearnProject");
			System.out.println("Enter the file name which you want to search:");
			String fileName=scan.nextLine();
            File[] files=directory.listFiles();
            int flag=0;
            for (File file : files) {
                String name = file.getName();
                //System.out.println(name);
                if (name.equals(fileName)) {
                       // System.out.println("The filename "+fileName+" is present in the directory");
        				File f= new File(fileName);
        				Scanner sc1 = new Scanner(f);
        				while(sc1.hasNextLine()) {
        				System.out.println(sc1.nextLine());
        				}
        			flag=1;	
                }
			}
        if(flag==0) {
        	System.out.println("File not found");
        }

		}catch(FileNotFoundException ex) {
			System.out.println("file not found");
		}

	}
	*/
	
	
	@Override
	public void searchFile() throws FileNotFoundException{
		Scanner scan= new Scanner(System.in);
		File directory = new File("/Users/abhishekraj/Desktop/WORKSPACE JAVA/SimpliLearnProject");
		System.out.println("Enter the file name which you want to search:");
		String fileName=scan.nextLine();
		File[] files=directory.listFiles();
		int flag=0;
		for (File file : files) {
			 
		     if (fileName.equalsIgnoreCase(file.getName()))
		     {
		         System.out.println("File saved at " + file.getParentFile());
		         System.out.println("Contents inside the file :\n");
		         Scanner sc1 = new Scanner(file);
		         while(sc1.hasNextLine()) {
        				System.out.println(sc1.nextLine());
        				}
		         
		         flag = 1;
		     }
		    
		}
      if(flag==0) {
		System.out.println("File not found");
      }

	}


}