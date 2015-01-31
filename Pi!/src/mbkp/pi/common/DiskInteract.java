package mbkp.pi.common;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;
import java.util.zip.GZIPOutputStream;

public class DiskInteract {
	
	public static String filedatadir = "C:\\data\\";
	public static String txtName = "pitothe" + Main.InputFromUser + "thdigit.txt";
	public static String fileNametxt = filedatadir + txtName;
	static final String SourceFile = fileNametxt;
	static final String OutputGZIPFile = filedatadir;
	
    /**
     * GZip it
     * @param zipFile output GZip file location
     */
    
    public static void gzipIt(){
 
    	byte[] buffer = new byte[1024];
 
    	try{
 
    		GZIPOutputStream gzos = new GZIPOutputStream(new FileOutputStream(OutputGZIPFile));
 
    		FileInputStream in = new FileInputStream(SourceFile);
 
    		int len;
    		while ((len = in.read(buffer)) > 0) {
    			gzos.write(buffer, 0, len);
    		}
 
    		in.close();
       
    		gzos.finish();
    		gzos.close();
 
    		System.out.println("Done");
 
    	}catch(IOException ex){
       ex.printStackTrace();   
    	}
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
	try{
	Writer w = new BufferedWriter(new FileWriter(fileNametxt));
    
	w.write("" + PiCalc.pi(Main.InputFromUser));
	w.close();
	
	recordFilesCreated();
	gzipIt();
    	}catch(IOException e){
        	System.out.println("IOException: "+e);
    	}
	}
	
	public static String readFile(String pathname) throws IOException {

	    File file = new File(pathname);
	    StringBuilder fileContents = new StringBuilder((int)file.length());
	    Scanner scanner = new Scanner(file);
	    String lineSeparator = System.getProperty("line.separator");

	    try {
	        while(scanner.hasNextLine()) {        
	            fileContents.append(scanner.nextLine() + lineSeparator);
	        }
	        return fileContents.toString();
	    } finally {
	        scanner.close();
	    }
}
	
}
