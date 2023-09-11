package bookcode.p04FlowCycles;

import java.util.*;

/**
 * Illustrates the use of a boolean variable to control loop ending.
 */
public class C03BooleanDemo {

	/**
	 * Main method
	 */
	public static void main(String[] args) {

		// the keyboard reader
		Scanner keyboard = new Scanner(System.in);

		// ask for several number terminating with one negative number
		System.out.println("Enter nonnegative numbers.");
		System.out.print("Place a negative number at the end"
				+ "to serve as an end marker.");

		// the total sum of the numbers read
		int sum = 0;
		// auxiliary variable that indicates that we are reading numbers, that
		// we don't read the terminate negative number. We call this two state
		// variables: a flag (that allow ou block).
		boolean numbersLeft = true;

		// teh cycle to read the number, until the flag say to stop
		while (numbersLeft) {
			// read the number
			int numberRead = keyboard.nextInt();
			// check if a negative number
			if (numberRead < 0) {
				// signal the flag
				numbersLeft = false;
			} else {
				// numberRead have a valid number, add it to sum
				sum = sum + numberRead;
			}
		}

		// at the end of the cycle, show the total summed
		System.out.println("The sum of the numbers is " + sum);

		// close keyboard
		keyboard.close();
	}
}
