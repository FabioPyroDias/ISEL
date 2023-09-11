package bookcode.p04FlowCycles;

import java.util.*;

/**
 * Break demo. break enables to stop the current iteration and the current cycle
 * and jump to out of it
 */
public class C07BreakDemo {

	/**
	 * Main method
	 */
	public static void main(String[] args) {

		// the keyboard reader
		Scanner keyboard = new Scanner(System.in);

		// ask to enter ten number, but the total sum if them must not exceed
		// 100
		System.out.println("You may buy ten items, but");
		System.out.println("the total price must not exceed $100.");

		// total will contain the sum of the number read
		double total = 0;
		// itemNumber will contain the numbers read
		int itemNumber;

		// execute body of for with itemNumber = 1, 2, ..., 10
		for (itemNumber = 1; itemNumber <= 10; itemNumber++) {
			// ask for one number
			System.out.print("Enter cost of item #" + itemNumber + ": $");
			// read it
			double amount = keyboard.nextDouble();
			// sum the number
			total = total + amount;
			// check if with it, the sum exceed the total
			if (total >= 100) {
				// if so, terminate the for in a abruptly way
				System.out.println("You spent all your money.");
				break;
			}
			// everything ok, continue showing the new total
			System.out.println("Your total so far is $" + total);
			// and showing how much left to use
			System.out.println("You may purchase up to " + (10 - itemNumber)
					+ " more items.");
		}

		// end of for, show how much we spent
		System.out.println("You spent $" + total);

		// close keyboard
		keyboard.close();
	}
}
