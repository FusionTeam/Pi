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
	public static int InputFromUser;
	
	public Main(String fileName, boolean append) throws FileNotFoundException {
		super(fileName, append);
	}
	
	public static void main(String[] args) throws IOException, Exception{
		
		//String consoleArgs[] = new String[] {"-version", "-filescreated"}; unused
		String filescreated = readFile(Obs.filedatadir + "filescreated.txt");
		
		//create a BufferedReader using System.in
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//Set the rawInput variable
		rawInput = br.readLine();
		
		//Print to the console
		System.out.println("args are -version, -filescreated, null");
		System.out.println("How many digits of pi would you like to print?");
		System.out.println("Maximum is 4679 as of version 0.6.2"
				+ "\nEDIT: Fixed with version 0.6.3, just cant see in console"
				+ "\nCheck file for full in C:\\data");
		
		//set the input to an int and return an error unless some things are some things
		try{
			InputFromUser = Integer.parseInt(rawInput);
		}catch(NumberFormatException exc){
			
			if(!rawInput.equals("-version") && !rawInput.equals("-filescreated")){
			System.out.println("Number Format Exception; Invalid Format." + exc);
			}
			
			if(InputFromUser < 1 && !(InputFromUser < 999999999)){
				if(!rawInput.equals("-version") && !rawInput.equals("-filescreated")){
					throw new Exception("Input cannot be less than 1!!!");
				}
			}
			
			InputFromUser = 0;
		}
		//call methods
		printPi();
		writePi();
    	//GZipFile gZip = new GZipFile();
    	//gZip.gzipIt();
		//Print to the console under certain circumstances
		if(rawInput.equals("-version")){
			System.out.println(Obs.version);
		}
		if(rawInput.equals("-filescreated")){
			System.out.println(filescreated);
		}

	}
	//Set the printPi method to printing pi()
	public static void printPi(){
		System.out.println(pi(InputFromUser));
	}
	
}
