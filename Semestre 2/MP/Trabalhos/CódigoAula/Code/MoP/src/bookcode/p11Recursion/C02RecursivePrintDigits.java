package bookcode.p11Recursion;

import java.util.Scanner;

public class C02RecursivePrintDigits {

	/**
	 * Precondition: number >= 0 Displays the digits in number as words.
	 */
	public static void displayAsWords(int number) {
		if (number < 10) {
			// the number has only one digit
			System.out.print(getWordFromDigit(number) + " ");
		} else {
			// number has two or more digits
			// process the higher part first
			displayAsWords(number / 10);
			// then write the last digit 
			System.out.print(getWordFromDigit(number % 10) + " ");
		}
	}

	// Precondition: 0 <= digit <= 9
	// Returns the word for the argument digit.
	private static String getWordFromDigit(int digit) {
		String result = null;
		switch (digit) {
		case 0:
			result = "zero";
			break;
		case 1:
			result = "one";
			break;
		case 2:
			result = "two";
			break;
		case 3:
			result = "three";
			break;
		case 4:
			result = "four";
			break;
		case 5:
			result = "five";
			break;
		case 6:
			result = "six";
			break;
		case 7:
			result = "seven";
			break;
		case 8:
			result = "eight";
			break;
		case 9:
			result = "nine";
			break;
		default:
			System.out.println("Fatal Error.");
			System.exit(0);
		}
		return result;
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