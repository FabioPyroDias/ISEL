package bookcode.p06MoreAboutObjectsAndMethod;

import java.util.Scanner;

/*
 * test the DollarFormat class
 */
public class C12DollarFormatDriver {

	/**
	 * This kind of testing program is often called a driver program.
	 */
	public static void main(String[] args) {
		// the keyboard reader
		Scanner keyboard = new Scanner(System.in);

		// local variable, the while expression only can use outside while
		// variables
		String response;

		// show initial message
		System.out.println("Testing C12DollarFormat.write:");
		// cycle to enter value and show dollars and cents

		do {
			// ask and read amount
			System.out.println("Enter a value of type double:");
			double amount = keyboard.nextDouble();

			// write dollars and cents
			C12DollarFormat.write(amount);

			System.out.println();

			// ask and read if user want more
			System.out.println("Test again?");
			response = keyboard.next();

		} while (response.equalsIgnoreCase("yes"));

		// end of execution
		System.out.println("End of test.");

		// close keyboard
		keyboard.close();
	}
}
