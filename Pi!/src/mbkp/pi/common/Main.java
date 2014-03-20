package mbkp.pi.common;

/**
 * @author Max
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main extends WritePiToFile{
	
	public static String rawInput;
	
	public Main(String fileName, boolean append) throws FileNotFoundException {
		super(fileName, append);
	}
	
	public static void main(String[] args) throws IOException, Exception{
		
		String version = "Version 0.6.3";
		//String consoleArgs[] = new String[] {"-version", "-filescreated"}; unused
		String filescreated = readFile("C:\\data\\filescreated.txt");
		
		//create a BufferedReader using System.in
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("args are -version, -filescreated, null");
		System.out.println("How many digits of pi would you like to print?");
		System.out.println("Maximum is 4679 as of version 0.6.2"
				+ "\nEDIT: Fixed with version 0.6.3, just cant see in console"
				+ "\nCheck file for full in C:\\data");
		rawInput = br.readLine();
		try{
			InputFromUser = Integer.parseInt(rawInput);
		}catch(NumberFormatException exc){
			
			if(!rawInput.equals("-version") && !rawInput.equals("-filescreated")){
			System.out.println("Number Format Exception; Invalid Format." + exc);
			}
			
			if(InputFromUser < 1){
				if(!rawInput.equals("-version") && !rawInput.equals("-filescreated")){
					throw new Exception("Input cannot be less than 1!!!");
				}
			}
			
			InputFromUser = 0;
		}
		//4679 is highest
		printPi();
		writePi();
		if(rawInput.equals("-version")){
			System.out.println(version);
		}
		if(rawInput.equals("-filescreated")){
			System.out.println(filescreated);
		}

	}
	
	public static void printPi(){
		System.out.println(pi(InputFromUser));
	}
	
}
