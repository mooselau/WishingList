package defaultPart;

import java.awt.Color;

import mainPart.EditDialog;
import supportPart.CommonExceptions;
import mainPart.*;

/**
 * This is a additional class for providing some useful utilities, which now includes: 
 * 1. get a randome number with 3 digits.
 * 2. ..
 * 
 * @author MooseLiu
 *
 */

public class SomeUtilities {
	
	/* Global Variables */	
	
	public SomeUtilities() {

	}
	
	private static double getARandomNumber() {
		return Math.random();
	}
	
	/**
	 * Get an array of 3 integers.
	 * @return a rgb color number with 3 digits.
	 */
	public Color getARandomColor() {
		
		int[] rgbNumber = new int[3];
		int redInt, greenInt, blueInt;
		
		for(int index=0;index<3;index++) {
			double aRandomNumber = getARandomNumber();
			int aColorNumber = (int)(aRandomNumber * 1000 % 255 + 1);
			rgbNumber[index] = aColorNumber;
		}
		
		redInt = rgbNumber[0];
		greenInt = rgbNumber[1];
		blueInt = rgbNumber[2];
		
		System.out.println("ColorNumber is: " + rgbNumber[0]+", "+ rgbNumber[1] +", "+rgbNumber[2]);
		return new Color(redInt, greenInt, blueInt);
	}
	
	/**
	 * Get a random integer number from 1 to 100;
	 * @return a int number with maximum 3 digits.
	 */
	public int getARandomPercentNumber() {
		double randomNumber = getARandomNumber();
		System.out.println(randomNumber);
		int percentage = (int)(randomNumber * 100 + 1);
		System.out.println("Percentage is: " + percentage);
		return percentage;
	}
	
	public String getAStringName() {
		
		char[] name = new char[3];
		for(int index=0;index<3;index++) {
			
			double randomNumber = getARandomNumber();
			int asciiNumber = (int)(randomNumber * 100) % 26 + 1 ;
			char asciiChar = (char)(asciiNumber + 96);
			name[index] = asciiChar;
			
		}
		String strName = String.valueOf(name);
		System.out.println("Name: " + strName);
		return strName;
	}
	
	/**
	 * For print customed information.
	 * @param message customed info.
	 */
	public void printThis(String message) {
		System.out.println(message);
	}
	
	public static void main(String args[]) {
		
		//1.
//		SomeUtilities su = new SomeUtilities();
//		for(int i=0;i<10;i++) {
//			su.getARandomColor();
//			su.getARandomPercentNumber();
//			su.getAStringName();
//		}
		
		//2.
//		EditDialog ed = new EditDialog();
//		ed.setVisible(true);
//		System.out.println("Starts..");
		
		//3.
//		System.out.println("Exception starts:");
//		try{
//			throw new CommonExceptions("There is an invalid wish with empty name!!");	
//		}catch(CommonExceptions e) {
//			e.printStackTrace();
//		}
		
	}
	
}
