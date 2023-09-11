package bookcode.p02Basic;

import java.util.*;

/**
 * Input, calculation, output
 * 
 */
public class C03ChangeMaker {

	public static void main(String[] args) {

		// the keyboard reader
		Scanner keyboard = new Scanner(System.in);

		// the working amount
		int amount,
		// the original saved amount
		originalAmount,
		// to keep the number of quarters (0.25)
		quarters,
		// to keep the number of dimes (0.10)
		dimes,
		// to keep the number of quarters (0.05)
		nickels,
		// to keep the number of quarters (0.01)
		pennies;

		// ask to user to enter data
		System.out
				.println("Enter the number of cents (an integer) from 1 to 99.");
		System.out.println("I will output a combination of coins"
				+ " that equals that amount of change.");

		// read the number of cents
		amount = keyboard.nextInt();

		// save the original value
		originalAmount = amount;

		// get the number of quarters
		quarters = amount / 25;
		// get the remaining part
		amount = amount % 25;

		// get the number of dimes
		dimes = amount / 10;
		// get the remaining part
		amount = amount % 10;

		// get the number of nickels
		nickels = amount / 5;
		// get the remaining part
		amount = amount % 5;

		// get the number of pennies
		pennies = amount;

		// show the results
		System.out.println(originalAmount + " cents in coins can be given as:");
		System.out.println("  " + quarters + " quarters");
		System.out.println("  " + dimes + " dimes");
		System.out.println("  " + nickels + " nickels and");
		System.out.println("  " + pennies + " pennies");

		// close keyboard
		keyboard.close();
	}
}
