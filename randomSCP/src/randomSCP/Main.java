package randomSCP;

import java.awt.Desktop;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.Random;
import java.util.Scanner;

//this is the ugliest code i've ever written but it functions at least

public class Main {

 public static void main(String[] args)  {
  
	Scanner keyboard = new Scanner(System.in);
	
	String webpageURL = "";
	boolean isFinished = false;
	int rangeStart = 0;
	int rangeEnd = 0;
	int quantity = 1;
	
	printSCPLogo();
    
    while(!isFinished) {
    	printInstructions();
    	int input = keyboard.nextInt();
    	
    	System.out.println("How many articles?");
    	quantity = keyboard.nextInt();
    			
    	switch(input) {
    	case 1: for(int i = 0; i < quantity; i++) {
	    		webpageURL = generateRandomSCP();
	    		System.out.println("Accessing " + webpageURL.substring(29));
	    		openWebpage(webpageURL);
	    		}
    	
    	System.out.println();
	    		break;
	    		
    	case 2: System.out.println("Type a beginning range.");
				rangeStart = keyboard.nextInt();
				System.out.println("Type an ending range.");
				rangeEnd = keyboard.nextInt();
			
			    for(int i = 0; i < quantity; i++) {
			    	webpageURL = generateRandomRangedSCP(rangeStart, rangeEnd);
			    	System.out.println("Accessing " + webpageURL.substring(29));
				    openWebpage(webpageURL);
			    }
			    System.out.println();
			    break;
			    
    	case 3: isFinished = true;
    			break;
    	}
    	
    }
 }
 
public static void printInstructions() {
	System.out.println("Type '1' for a random SCP, '2' for an SCP within a certain range, and '3' to quit.");
}
 
public static void printSCPLogo() {
	System.out.println("WARNING: THE FOUNDATION DATABASE IS CLASSIFIED\r\n"
			+ "ACCESS BY UNAUTHORIZED PERSONNEL IS STRICTLY PROHIBITED\r\n"
			+ "PERPETRATORS WILL BE TRACKED, LOCATED, AND DETAINED");
	
	System.out.println(
			"  ______     ______  _______   \r\n"
			+ ".' ____ \\  .' ___  ||_   __ \\  \r\n"
			+ "| (___ \\_|/ .'   \\_|  | |__) | \r\n"
			+ " _.____`. | |         |  ___/  \r\n"
			+ "| \\____) |\\ `.___.'\\ _| |_     \r\n"
			+ " \\______.' `.____ .'|_____|    \r\n"
			+ "   SECURE CONTAIN PROTECT    \r\n"
			+ "");
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