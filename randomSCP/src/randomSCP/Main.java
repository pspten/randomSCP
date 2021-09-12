package randomSCP;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.Random;
import java.util.Scanner;

public class Main {

 //this is the ugliest code i've ever written but it functions atleast
 public static void main(String[] args)  {
  
	Scanner keyboard = new Scanner(System.in);
	
	String webpageURL = "";
	boolean isFinished = false;
	int rangeStart = 0;
	int rangeEnd = 0;
	int quantity = 1;
    
    while(!isFinished) {
    	System.out.println("Type '1' for a random SCP, '2' for an SCP within a certain range, and '3' to quit.");
    	int input = keyboard.nextInt();
    	
    	System.out.println("How many articles?");
    	quantity = keyboard.nextInt();
    			
    	switch(input) {
    	case 1: for(int i = 0; i < quantity; i++) {
    		webpageURL = generateRandomSCP();
    		openWebpage(webpageURL);
    	}
	    		break;
	    		
    	case 2: System.out.println("Type a beginning range.");
				rangeStart = keyboard.nextInt();
				System.out.println("Type an ending range.");
				rangeEnd = keyboard.nextInt();
			
			    for(int i = 0; i < quantity; i++) {
			    	webpageURL = generateRandomRangedSCP(rangeStart, rangeEnd);
				    openWebpage(webpageURL);
			    }
			    break;
			    
    	case 3: isFinished = true;
    			break;
    	}
    	
    }
 }

public static void openWebpage(String webpageURL) {
	 try {
		   
		   URI uri= new URI(webpageURL);
		   
		   java.awt.Desktop.getDesktop().browse(uri);
		    
		  } catch (Exception e) {
		   
		   e.printStackTrace();
		  }
 }

public static String generateRandomRangedSCP(int lowerBounds, int upperBounds) {
	
	Random rand = new Random();

	int randomSCPNumber = rand.nextInt(upperBounds - lowerBounds) + lowerBounds;
	
	return ("https://scp-wiki.wikidot.com/scp-" + randomSCPNumber);
	
}

public static String generateRandomSCP() {
	
	Random rand = new Random();
	int upperBounds = 7000;
	
	int randomSCPNumber = rand.nextInt(upperBounds);
	
	return ("https://scp-wiki.wikidot.com/scp-" + randomSCPNumber);
	
}
 
}