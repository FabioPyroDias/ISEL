package bookcode.p09ExceptionHandling;

import java.util.Scanner;

/**
 * Throw exceptions and catch exceptions
 */
public class C05DoDivision {
	private int numerator;
	private int denominator;
	private double quotient;
	private Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args) {
		C05DoDivision doIt = new C05DoDivision();
		try {
			doIt.doNormalCase();
		} catch (C03DivideByZeroException e) {
			System.out.println(e.getMessage());
			doIt.giveSecondChance();
		}
		System.out.println("End of program.");
	}

	public void doNormalCase() throws C03DivideByZeroException {
		System.out.println("Enter numerator:");
		numerator = keyboard.nextInt();
		System.out.println("Enter denominator:");
		denominator = keyboard.nextInt();

		if (denominator == 0)
			throw new C03DivideByZeroException();

		quotient = numerator / (double) denominator;
		System.out.println(numerator + "/" + denominator + " = " + quotient);

		// close keyboard
		keyboard.close();
	}

	public void giveSecondChance() {
		System.out.println("Try again:");
		System.out.println("Enter numerator:");
		numerator = keyboard.nextInt();
		System.out.println("Enter denominator:");
		System.out.println("Be sure the denominator is not zero.");
		denominator = keyboard.nextInt();
		if (denominator == 0) {
			System.out.println("I cannot do division by zero.");
			System.out.println("Since I cannot do what you want,");
			System.out.println("the program will now end.");
			System.exit(0);
		}
		quotient = ((double) numerator) / denominator;
		System.out.println(numerator + "/" + denominator + " = " + quotient);
	}

}
