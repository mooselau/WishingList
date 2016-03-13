package defaultPart;
/**
 * This is a additional class for providing some useful utilities, which now includes: 
 * 1. get a randome number with 3 digits.
 * 2. ..
 * 
 * @author MooseLiu
 *
 */

public class SomeUtilities {
	
	public SomeUtilities() {
		
	}
	
	
	/**
	 * Get a random integer number from 0 to 999.
	 * @return a int number with 3 digits.
	 */
	public static int getARandomColor() {

		double randomNumber = Math.random();
//		System.out.println("randomNum: " + randomNumber);
		int colorNumber = (int)(randomNumber * 1000);
//		System.out.println("colorNumber: " + colorNumber);
		return colorNumber;
	
	}
	
	public static void main(String args[]) {
		SomeUtilities su = new SomeUtilities();
		su.getARandomColor();
	}
	
}
