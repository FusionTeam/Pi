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
		String consoleArgs[] = {"-version"};
		
		//create a BufferedReader using System.in
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("args are -version, null");
		System.out.println("How many digits of pi would you like to print?");
		System.out.println("Maximum is 4679 as of "+ version);
		rawInput = br.readLine();
		try{
			InputFromUser = Integer.parseInt(rawInput);
		}catch(NumberFormatException exc){
			if(!rawInput.equals("-version")){
			System.out.println("Number Format Exception; Invalid Format." + exc);
			}
			if(InputFromUser < 1 && !rawInput.equals(consoleArgs)){
				throw new Exception("Input cannot be less than 1!!!");
			}
			InputFromUser = 0;
		}
		//4679 is highest
		printPi();
		writePi();
		if(rawInput.equals("-version")){
			System.out.println(version);
		}

	}
	
	public static void printPi(){
		System.out.println(pi(InputFromUser));
	}
	
}
