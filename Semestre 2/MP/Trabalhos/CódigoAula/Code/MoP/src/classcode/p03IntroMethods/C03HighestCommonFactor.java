package classcode.p03IntroMethods;

import java.util.Scanner;

/**
 * A program that read two positive integers a show the the Highest Common
 * Factor between them. O máximo divisor comum em português.
 * 
 */
public class C03HighestCommonFactor {

	public static Scanner keyboard = new Scanner(System.in);

	/**
	 * Main method
	 */
	public static void main(String[] args) {

		// the keyboard reader
		Scanner keyboard = new Scanner(System.in);

		// read the first number
		System.out.println("Entering the first number...");
		int n1 = C02LowestCommonMultipleV2.readPositiveNonZeroInteger(keyboard);

		System.out.println();

		// read the second number
		System.out.println("Entering the second" + " number...");
		int n2 = C02LowestCommonMultipleV2.readPositiveNonZeroInteger(keyboard);

		System.out.println();

		// show data
		System.out.println("First number -> " + n1);
		System.out.println("Second number -> " + n2);

		System.out.println();

		// calculate and return the Highest Common Factor
		int lcm = highestCommonFactor(n1, n2);

		// show the result
		System.out.println("The Highest Common Factor between " + n1 + " and "
				+ n2 + " is " + lcm);

		// close keyboard
		keyboard.close();
	}

	/**
	 * Method that calculate the Highest Common Factor between n1 and n2
	 * 
	 * @param n1
	 *            one value
	 * @param n2
	 *            another value
	 * @return the Highest Common Factor between n1 and n2
	 */
	public static int highestCommonFactor(int n1, int n2) {

		// auxiliary variables
		int n1aux = n1, n2aux = n2;

		// go and stop when both are equal
		while (n1aux != n2aux) {

			// find the greatest of them, then subtract the other number
			if (n1aux > n2aux)
				n1aux -= n2aux;
			else
				n2aux -= n1aux;

		}
		// return one of n1aux or n2aux, they are equal
		return n1aux;
	}
}