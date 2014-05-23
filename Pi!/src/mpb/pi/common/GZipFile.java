package mpb.pi.common;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

public class GZipFile {
    /**s
     * GZip it
     * @param zipFile output GZip file location
     */
    
    public static void gzipIt(){
 
    	byte[] buffer = new byte[1024];
 
    	try{
 
    		GZIPOutputStream gzos = new GZIPOutputStream(new FileOutputStream(Obs.OutputGZIPFile));
 
    		FileInputStream in = new FileInputStream(Obs.SourceFile);
 
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
}
