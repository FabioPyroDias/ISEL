package bookcode.p11Recursion;

import java.util.Scanner;

/**
 * Iterative print digist of a number
 * 
 */
public class C03IterativePrintDigits {

	/**
	 * Precondition: number >= 0 Displays the digits in number as words.
	 */
	public static void displayAsWords(int number) {
		int divisor = getPowerOfTen(number);
		int next = number;
		while (divisor >= 10) {
			System.out.print(getWordFromDigit(next / divisor) + " ");
			next = next % divisor;
			divisor = divisor / 10;
		}
		System.out.print(getWordFromDigit(next / divisor) + " ");
	}

	// Precondition: n >= 0.
	// Returns 10 raised to the power n.
	private static int getPowerOfTen(int n) {
		int result = 1;
		while (n >= 10) {
			result = result * 10;
			n = n / 10;
		}
		return result;
	}

	private static String getWordFromDigit(int digit) {

		// array of numbers in words
		String[] nums = { "zero", "one", "two", "three", "four", "five", "six",
				"seven", "eight", "nine" };

		// check is argument is ok
		if (digit < 0 || digit > 9) {
			System.out.println("Fatal Error.");
			System.exit(0);
		}

		// return the correct word
		return nums[digit];
	}

	/**
	 * main
	 */

	public static void main(String[] args) {
		// keyboard reader
		Scanner keyboard = new Scanner(System.in);

		// ask and read a number
		System.out.println("Enter an integer:");
		int number = keyboard.nextInt();

		// display its digits
		System.out.print("The digits in " + number + " are -> ");
		displayAsWords(number);

		System.out.println();

		// second scenario
		number += 10;
		System.out.print("The digits in " + number + " are -> ");
		displayAsWords(number);

		// close keyboard
		keyboard.close();
	}

}
