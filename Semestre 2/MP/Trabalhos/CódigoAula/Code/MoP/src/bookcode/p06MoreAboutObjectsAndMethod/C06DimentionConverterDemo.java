package bookcode.p06MoreAboutObjectsAndMethod;

import java.util.Scanner;

/**
 * Demonstration of using the class DimensionConverter.
 */
public class C06DimentionConverterDemo {

	/**
	 * Main method
	 */
	public static void main(String[] args) {

		// main context is a static context, can directly use only static
		// members

		// keyboard reader
		Scanner keyboard = new Scanner(System.in);

		// ask and read in inches
		System.out.print("Enter a measurement in inches -> ");
		double inches = keyboard.nextDouble();

		// use the static method to convert to feet
		double feet = C05DimensionConverter.convertInchesToFeet(inches);
		System.out.println(inches + " inches = " + feet + " feet.");

		System.out.println();

		// ask and read in feet
		System.out.print("Enter a measurement in feet -> ");
		feet = keyboard.nextDouble();

		// use the static method to convert to inches
		inches = C05DimensionConverter.convertFeetToInches(feet);
		System.out.println(feet + " feet = " + inches + " inches.");

		// close keyboard
		keyboard.close();
	}
}
