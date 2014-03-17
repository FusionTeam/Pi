package mbkp.pi.common;

/**
 * @author Max
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main extends WritePiToFile{
	
	public Main(String fileName, boolean append) throws FileNotFoundException {
		super(fileName, append);
	}
	
	public static void main(String[] args) throws IOException, Exception{
		
		//create a BufferedReader using System.in
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		
		System.out.println("args are -version, null");
		System.out.println("How many digits of pi would you like to print?");
		System.out.println("Maximum is 4679 as of version 0.5.0.");
		str = br.readLine();
		try{
			InputFromUser = Integer.parseInt(str);
		}catch(NumberFormatException exc){
			if(!str.equals("-version")){
			System.out.println("Number Format Exception; Invalid Format." + exc);
			}
			if(InputFromUser < 1){
				throw new Exception("Input cannot be less than 1!!!");
			}
			InputFromUser = 0;
		}
		//4679 is highest
		System.out.println(pi(InputFromUser));
		if(str.equals("-version")){
			System.out.println("Version 0.5.0");
		}
	}

}
