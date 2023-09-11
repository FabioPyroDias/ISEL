package bookcode.p09ExceptionHandling;

import java.util.Scanner;

/**
 * Example of code with an input error
 */
public class C01GotMilk {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);

		System.out.println("Enter number of donuts:");
		int donutCount = keyboard.nextInt();

		System.out.println("Enter number of glasses of milk:");
		int milkCount = keyboard.nextInt();

		// Dealing with an unusual event without Java’s exception
		// handling features:
		if (milkCount < 1) {
			System.out.println("No milk!");
			System.out.println("Go buy some milk.");
		} else {
			double donutsPerGlass = donutCount / (double) milkCount;
			System.out.println(donutCount + " donuts.");
			System.out.println(milkCount + " glasses of milk.");
			System.out.println("You have " + donutsPerGlass
					+ " donuts for each glass of milk.");
		}
		System.out.println("End of program.");

		// close keyboard
		keyboard.close();
	}
}
