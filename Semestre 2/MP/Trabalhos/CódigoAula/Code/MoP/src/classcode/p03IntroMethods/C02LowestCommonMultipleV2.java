package classcode.p03IntroMethods;

import java.util.*;

/**
 * A program that read two positive integers a show the the lowest common
 * multiple
 * 
 */
public class C02LowestCommonMultipleV2 {

	static int x = 0;

	/**
	 * Main method
	 */
	public static void main(String[] args) {

		System.out.println(x);

		// the keyboard reader
		Scanner keyboard = new Scanner(System.in);

		// read the first number
		System.out.println("Entering the first number...");
		int n1 = readPositiveNonZeroInteger(keyboard);

		System.out.println();

		// read the second number
		System.out.println("Entering the second" + " number...");
		int n2 = readPositiveNonZeroInteger(keyboard);

		System.out.println();

		// show data
		System.out.println("First number -> " + n1);
		System.out.println("Second number -> " + n2);

		System.out.println();

		// calculate and return the lowest common multiple
		int lcm = lowestCommonMultiple(n1, n2);

		// show the result
		System.out.println("The lowest common multiple between " + n1 + " and "
				+ n2 + " is " + lcm);

		// ==================================================================
		// now LCM with 3 arguments
		int n3 = 20;
		int lcm3 = lowestCommonMultiple(n1, n2, n3);

		// show the result
		System.out.println("The lowest common multiple between " + n1 + ", "
				+ +n2 + " and " + n3 + " is " + lcm3);

		// close keyboard
		keyboard.close();
	}

	/**
	 * Method that ask and read a positive integer number greater than zero and
	 * returns it
	 * 
	 * @param keyboard
	 *            receives the keyboard reader
	 * @return a positive greater than zero integer
	 */
	public static int readPositiveNonZeroInteger(Scanner keyboard) {
		// local variables
		boolean done = false;
		int number = 0;

		// reading cycle
		do {
			// ask and read a number
			System.out.print("Enter the a integer number bigger than 0 -> ");
			if (keyboard.hasNextInt()) {
				number = keyboard.nextInt();
				if (number > 0)
					done = true;
				else
					System.out.println(
							"The number is not bigger than zero -> " + number);
			} else {
				// not an integer
				System.out.println("What you wrote was not an integer!!! -> "
						+ keyboard.next());
			}

			// remove the garbage introduced by the user
			keyboard.nextLine();

		} while (!done);

		// return the number
		return number;
	}

	/**
	 * Method that calculate the lowest common multiple between n1 and n2
	 * 
	 * @param n1
	 *            one value
	 * @param n2
	 *            another value
	 * @return the lowest common multiple between n1 and n2
	 */
	public static int lowestCommonMultiple(int n1, int n2) {

		// use auxiliary variables
		int n1aux = n1, n2aux = n2;

		// go and stop when both are equal
		while (n1aux != n2aux) {

			// find the lowest of them, in it add its base value
			if (n1aux < n2aux)
				n1aux += n1;
			else
				n2aux += n2;

		}

		// return one of n1aux or n2aux, they are equal
		return n1aux;
	}

	/**
	 * Method that calculate the lowest common multiple between three number
	 * 
	 * @param n1
	 *            first value
	 * @param n2
	 *            second value
	 * @param n3
	 *            third value
	 * @return the lowest common multiple between n1, n2 and n3
	 */
	public static int lowestCommonMultiple(int n1, int n2, int n3) {
		// TODO
		return 0;
	}

}