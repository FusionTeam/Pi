package mbkp.pi.common;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class WritePiToFile extends FileOutputStream{

	public WritePiToFile(String fileName, boolean append) throws FileNotFoundException {
		super(fileName, append);
	}
	
	public static void WritePi(){
	try
    {
    BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\pinumber\\pi.txt"));
    bw.write(String.valueOf(pi(InputFromUser)));
    bw.close();
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
