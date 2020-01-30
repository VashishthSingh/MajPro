package com.count.folder;

import java.io.File;
public class CountSubFolderInAFolder {
 public static void main(String []args) throws InterruptedException {
	 File dir = new File("/home/local/ZOHOCORP/vashish-pt3323/workspace");
	 int noOfPreviousFiles=0,noOfPreviousDirectories=0,executeSecondTime=0;
	 int checkFileIncrement=0,checkDirIncrement=0;
	 int numberOfSubFiles=0,numberOfSubDirectory=0;
	 while(true) {
		 numberOfSubFiles=0;
		 numberOfSubDirectory=0;
		 checkFileIncrement=0;
		 checkDirIncrement=0;
		 File listDir[] = dir.listFiles();
		 for (int i = 0; i < listDir.length; i++) {
			 if (listDir[i].isFile()) {   // isFile()     isDirectory()
				 numberOfSubFiles++;
			 }
			 else if(listDir[i].isDirectory()) {
				 numberOfSubDirectory++;
			 }
		 }
		 if(executeSecondTime!=0){
			 if(numberOfSubFiles>noOfPreviousFiles)
				 checkFileIncrement=1;
			 if(numberOfSubDirectory>noOfPreviousDirectories)
				 checkDirIncrement=1;
			 if(checkFileIncrement==1 && checkDirIncrement==1)
				 System.out.println((numberOfSubFiles-noOfPreviousFiles)+" Files And "+(numberOfSubDirectory-noOfPreviousDirectories)+" Got Added");
			 else if(checkFileIncrement==1)
				 System.out.println((numberOfSubFiles-noOfPreviousFiles)+" Files Got Added");
			 else if(checkDirIncrement==1)
				 System.out.println((numberOfSubDirectory-noOfPreviousDirectories)+" Folders Got Added");
		 }
		 executeSecondTime=1;
		 System.out.println("No of SubFiles " + numberOfSubFiles);
		 System.out.println("No of dir " + numberOfSubDirectory);
		 System.out.println("-----------------");
		 noOfPreviousFiles=numberOfSubFiles;
		 noOfPreviousDirectories=numberOfSubDirectory;
		 Thread.sleep(10000);
	 }
 }
}

