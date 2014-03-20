package mbkp.pi.common;

/**
 * @author Max
 */

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WritePiToFile extends PiMeth{

	public static String txtName = "pitothe" + Main.InputFromUser + "thdigit.txt";
	public static String fileNametxt = "C:\\data\\" + txtName;
	
	public WritePiToFile(String fileName, boolean append) throws FileNotFoundException {
		super();
	}
	
	public static void recordFilesCreated(){
		try{
			Writer w = new BufferedWriter(new FileWriter("C:\\data\\filesCreated.txt"));
			
			w.write(txtName + ", ");
			w.close();
			
		}catch(IOException e){
			System.out.println("IOException: " + e);
		}
	}
	
	public static void writePi(){
	try
    {
	Writer w = new BufferedWriter(new FileWriter(fileNametxt));
    
	w.write("" + pi(InputFromUser));
	w.close();
	
	recordFilesCreated();
    }
    catch(IOException e)
    {
        System.out.println("IOException: "+e);
    }
	}
	
	/*{
	
		try{
        	Writer output = null;
        	File file = new File("results.txt");
        	output = new BufferedWriter(new FileWriter(file));

        	for(int i=0; i<100; i++){
        	//CODE TO FETCH RESULTS AND WRITE FILE
        	}

        	output.close();
        	System.out.println("File has been written");

    	}catch(Exception e){
    		System.out.println("Could not create file");
    	}
	}*/
}
