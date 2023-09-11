package bookcode.p02Basic;

import java.util.Scanner;

/**
 * Scanner, nextDouble, nextInt, next, nextLine, nextBoolean, nextFloat,
 * nextByte, nextShort
 */
public class C05ScannerDemo {

	/**
	 * main method
	 */
	public static void main(String[] args) {

		// the keyboard reader
		Scanner scannerObject = new Scanner(System.in);

		// ask for two integers
		System.out.print("Enter two integer numbers "
				+ "seperated by one or more spaces: ");

		// reading two integers
		int n1 = scannerObject.nextInt();
		int n2 = scannerObject.nextInt();
		// show them
		System.out.println("You entered " + n1 + " and " + n2);

		// test of decimal numbers, ask for two decimal numbers
		System.out.print("Next enter two decimal numbers (exº 2,45): ");

		// reading two double numbers
		double d1 = scannerObject.nextDouble();
		double d2 = scannerObject.nextDouble();
		// print them to confirm
		System.out.println("You entered " + d1 + " and " + d2);

		// test of strings, ask for two words
		System.out.println("Next enter two words:");

		// read two words
		String s1 = scannerObject.next();
		String s2 = scannerObject.next();
		// show them to confirm - to write " we need to put \"
		System.out.println("You entered \"" + s1 + "\" and \"" + s2 + "\"");

		// read data until end of line
		s1 = scannerObject.nextLine(); // To get rid of '\n'

		// ask for text
		System.out.println("Next enter a line of text:");
		// read data until end of line
		s1 = scannerObject.nextLine();
		// show data
		System.out.println("You entered: \"" + s1 + "\"");

		// close keyboard
		scannerObject.close();
	}
}
