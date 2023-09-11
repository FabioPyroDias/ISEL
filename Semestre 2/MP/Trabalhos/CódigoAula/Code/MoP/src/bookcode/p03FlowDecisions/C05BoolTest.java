package bookcode.p03FlowDecisions;

import java.util.Scanner;

/**
 * Boolean, read and print
 * 
 */
public class C05BoolTest {

	/**
	 * main method
	 */
	public static void main(String[] args) {

		// the keyboard reader
		Scanner keyboard = new Scanner(System.in);

		// the boolean
		boolean boolVar = false;

		// show the boolean, there is a conversion from boolean to string here
		System.out.println("boolVar have -> " + boolVar);

		// read a boolean from the keyboard
		System.out.print("Enter a boolean value: ");
		boolVar = keyboard.nextBoolean();

		// show the boolean
		System.out.println("You entered -> " + boolVar);

		// close keyboard
		keyboard.close();

	}

}
