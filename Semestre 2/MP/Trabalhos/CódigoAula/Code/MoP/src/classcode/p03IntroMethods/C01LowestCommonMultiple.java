package classcode.p03IntroMethods;

import java.util.*;

/**
 * A program that read two positive integers a show the the lowest common
 * multiple. Minimo Múltiplo Comum em português.
 * 
 */
public class C01LowestCommonMultiple {

	/**
	 * Main method
	 */
	public static void main(String[] args) {

		// the keyboard reader
		Scanner keyboard = new Scanner(System.in);

		int number = 0;
		

		// read the first number
		System.out.println("Entering the first number...");
		boolean done = false;
		do {
			// ask and read a number
			System.out.print("Enter the a integer number bigger than 0 -> ");
			if (keyboard.hasNextInt()) {
				number = keyboard.nextInt();
				if (number > 0)
					done = true;
				else
					System.out.println("The number is not bigger than zero -> "
							+ number);
			} else {
				// not an integer
				System.out.println("What you wrote was not an integer!!! -> "
						+ keyboard.next());
			}

			// remove the garbage introduced by the user
			keyboard.nextLine();

		} while (!done);

		int n1 = number;

		System.out.println();

		// read the second number
		System.out.println("Entering the second" + " number...");
		done = false;
		do {
			// ask and read a number
			System.out.print("Enter the a integer number bigger than 0 -> ");
			if (keyboard.hasNextInt()) {
				number = keyboard.nextInt();
				if (number > 0)
					done = true;
				else
					System.out.println("The number is not bigger than zero -> "
							+ number);
			} else {
				// not an integer
				System.out.println("What you wrote was not an integer!!! -> "
						+ keyboard.next());
			}

			// remove the garbage introduced by the user
			keyboard.nextLine();

		} while (!done);

		int n2 = number;

		System.out.println();

		// show data
		System.out.println("First number -> " + n1);
		System.out.println("Second number -> " + n2);

		System.out.println();

		// calculate the lowest common multiple
		int n1aux = n1, n2aux = n2;
		while (n1aux != n2aux) {
			if (n1aux < n2aux)
				n1aux += n1;
			else
				n2aux += n2;
		}

		// show the result
		System.out.println("The lowest common multiple between " + n1 + " and "
				+ n2 + " is " + n1aux);

		// close keyboard
		keyboard.close();
	}
}