package mbkp.pi.common;

/**
 * @author Max
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	
	public static String version = "Version 0.6.3";
	
	public static String rawInput;
	public static int InputFromUser;
	
	public Main(String fileName, boolean append) throws FileNotFoundException {
		super();
	}
	
	public static void main(String[] args) throws IOException, Exception{
		
		//String consoleArgs[] = new String[] {"-version", "-filescreated"}; unused
		String filescreated = DiskInteract.readFile(DiskInteract.filedatadir + "filescreated.txt");
		
		//create a BufferedReader using System.in
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//Set the rawInput variable
		rawInput = br.readLine();
		
		
		
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
		ConsoleInteract.writeToConsole();
		ConsoleInteract.printPi();
		DiskInteract.writePi();
    	//GZipFile gZip = new GZipFile(); unused
    	//gZip.gzipIt(); unused
		
		//Print to the console under certain circumstances
		if(rawInput.equals("-version")){
			System.out.println(version);
		}
		if(rawInput.equals("-filescreated")){
			System.out.println(filescreated);
		}

	}
	
	
}
