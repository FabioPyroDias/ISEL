package bookcode.p09ExceptionHandling;

import java.util.Scanner;

/**
 * Throw exceptions.
 * 
 * Now the error situation will be signalled and handled by exceptions.
 */
public class C02ExceptionDemo {

	private static Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args) {

		try {

			System.out.println("Enter number of donuts:");
			int donutCount = keyboard.nextInt();
			// if bad input throw an exception
			if (donutCount < 0)
				throw new Exception("Exception: No donuts!");

			System.out.println("Enter number of glasses of milk:");
			int milkCount = keyboard.nextInt();
			// if bad input throw an exception
			if (milkCount < 1)
				throw new Exception("Exception: No milk!");

			double donutsPerGlass = donutCount / (double) milkCount;
			System.out.println(donutCount + " donuts.");
			System.out.println(milkCount + " glasses of milk.");
			System.out.println("You have " + donutsPerGlass
					+ " donuts for each glass of milk.");
		}
		// here follows the code to deal with the exceptions
		catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Go buy some milk.");
		}

		System.out.println("End of program.");

		// close keyboard
		keyboard.close();
	}

}
