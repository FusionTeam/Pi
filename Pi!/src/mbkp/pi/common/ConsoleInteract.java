package mbkp.pi.common;

public class ConsoleInteract {
	
	
	public static void writeToConsole(){
	//Print to the console
	System.out.println("args are -version, -filescreated, null");
	System.out.println("How many digits of pi would you like to print?");
	System.out.println("Maximum is 4679 as of version 0.6.2"
			+ "\nEDIT: Fixed with version 0.6.3, just cant see in console"
			+ "\nCheck file for full in C:\\data");
	
	}
	
	//Set the printPi() method to printing pi()
	public static void printPi(){
			System.out.println(PiCalc.pi(Main.InputFromUser));
	}
	
}
