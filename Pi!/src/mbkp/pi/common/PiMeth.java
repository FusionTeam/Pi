package mbkp.pi.common;

/**
 * @author Max
 * Contains nearly all methods in the program
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;
import java.util.zip.GZIPOutputStream;

public class PiMeth {
	
	double pi; 
	float circum, diameter;
	public static int InputFromUser;
	
	double getPi(){
		return pi;
	}
	
	void setCircum(){
		
	}
	
	private static final BigDecimal TWO = new BigDecimal("2");
	private static final BigDecimal FOUR = new BigDecimal("4");
	private static final BigDecimal FIVE = new BigDecimal("5");
	private static final BigDecimal TWO_THIRTY_NINE = new BigDecimal("239");

	protected PiMeth() {}

	public static BigDecimal pi(int numDigits) {

	  int calcDigits = numDigits + 10;

	  return FOUR.multiply((FOUR.multiply(arccot(FIVE, calcDigits)))
	    .subtract(arccot(TWO_THIRTY_NINE, calcDigits)))
	    .setScale(numDigits, RoundingMode.DOWN);
	}

	 private static BigDecimal arccot(BigDecimal x, int numDigits) {

	BigDecimal unity = BigDecimal.ONE.setScale(numDigits,
	  RoundingMode.DOWN);
	BigDecimal sum = unity.divide(x, RoundingMode.DOWN);
	BigDecimal xpower = new BigDecimal(sum.toString());
	BigDecimal term = null;
	
	boolean add = false;

	for (BigDecimal n = new BigDecimal("3"); term == null ||
	  term.compareTo(BigDecimal.ZERO) != 0; n = n.add(TWO)) {

	  xpower = xpower.divide(x.pow(2), RoundingMode.DOWN);
	  term = xpower.divide(n, RoundingMode.DOWN);
	  sum = add ? sum.add(term) : sum.subtract(term);
	  add = ! add;
	}
	return sum;
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
	

    /**
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