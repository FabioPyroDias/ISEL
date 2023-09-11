package bookcode.p11Recursion;

import java.util.Scanner;

/**
 * Show an recursive method that returns the number of zero digits in n.
 */
public class C04RecursiveDemo2 {

	/**
	 * Returns the number of zero digits in n.
	 * 
	 * Precondition: n >= 0
	 */
	public static int getNumberOfZeros(int n) {
		int result;
		if (n == 0)
			result = 1;
		else if (n < 10)
			// n has one digit that is not 0
			result = 0;
		else if (n % 10 == 0)
			result = getNumberOfZeros(n / 10) + 1;
		else
			// n % 10 != 0
			result = getNumberOfZeros(n / 10);
		return result;
	}

	/**
	 * the same method but with less code
	 */
	public static int getNumberOfZeros2(int n) {

		// check if n has one digit, return 1 if number is zero
		if (n < 10)
			return n == 0 ? 1 : 0;

		// return the number of zero in number except last digit
		// add 1 if last digit is zero
		return (n % 10 == 0 ? 1 : 0) + getNumberOfZeros(n / 10);
	}

	/**
	 * main
	 */
	public static void main(String[] args) {

		// keyboard reader
		Scanner keyboard = new Scanner(System.in);

		// ask and read an number
		System.out.print("Enter a nonnegative number -> ");
		int number = keyboard.nextInt();

		// show the number of zeros of it
		System.out.println(number + " contains " + getNumberOfZeros(number)
				+ " zeros.");

		System.out.println(number * 1010 + " contains "
				+ getNumberOfZeros2(number * 1010) + " zeros.");

		// close keyboard
		keyboard.close();
	}
}
