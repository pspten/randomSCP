package randomSCP;

import java.net.URI;
import java.util.Random;
import java.util.Scanner;

//this is the ugliest code i've ever written but it functions at least

public class Main {

	final static int SCP_UPPER_BOUNDS = 6999;
	
 public static void main(String[] args)  {
  
	 printSCPLogo();
	 
	 startSCPFinder();
	 
 }
 
public static void printInstructions() {
	System.out.println("Type '1' for a random SCP, '2' for an SCP within a certain range,\n'3' for a specific series, "
			+ "'4' to access a specific SCP, and '5' to quit.");
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

public static void startSCPFinder() {
	Scanner keyboard = new Scanner(System.in);
	String webpageURL = "";
	boolean isFinished = false;
	int rangeStart = 0;
	int rangeEnd = 0;
	int quantity = 1;
    
    while(!isFinished) {
    	printInstructions();
    	int input = keyboard.nextInt();
    	
    	if(input == 5) {
    		break;
    	}
    	
    	if(input != 4) {
    		System.out.println("How many articles?");
        	quantity = keyboard.nextInt();
    	}
    			
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
			    
    	case 3: System.out.println("Which series? (i.e. 1, 2, 3, 4, 5, 6, or 7)");
    			int seriesNumber = keyboard.nextInt();
		    	for(int i = 0; i < quantity; i++) {
			    	switch(seriesNumber) {
			    	case 1: webpageURL = generateRandomRangedSCP(001, 999);
			    			break;
			    	case 2: webpageURL = generateRandomRangedSCP(1000, 1999);
	    					break;
			    	case 3: webpageURL = generateRandomRangedSCP(2000, 2999);
	    					break;
			    	case 4: webpageURL = generateRandomRangedSCP(3000, 3999);
	    					break;
			    	case 5: webpageURL = generateRandomRangedSCP(4000, 4999);
	    					break;
			    	case 6: webpageURL = generateRandomRangedSCP(5000, 5999);
	    					break;
			    	case 7: webpageURL = generateRandomRangedSCP(6000, 6999);
	    					break;
			    	default: System.out.println("Error, invalid series.");
			    			return;
			    	}
			    	System.out.println("Accessing " + webpageURL.substring(29));
				    openWebpage(webpageURL);
			    }
		    	System.out.println();
		    	break;
    		
    	case 4: System.out.println("Which SCP?");
				String skipSearch = keyboard.next();
				System.out.println("Accessing scp-" + skipSearch);
	    		openWebpage("https://scp-wiki.wikidot.com/scp-" + skipSearch);
	    		System.out.println();
	    		break;
    			
    	case 5:	isFinished = true;
    			keyboard.close();
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

	int randomSCPNumber = rand.nextInt(SCP_UPPER_BOUNDS);
	
	return ("https://scp-wiki.wikidot.com/scp-" + randomSCPNumber);
	
}
 
}