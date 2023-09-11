package bookcode.p09ExceptionHandling;

import java.util.Scanner;

/*
 * An method that throws exceptions
 */
public class C06TwoCathesDemo {

	private static Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args) {

		try {
			System.out.println("Enter number of widgets " + "produced:");

			int widgets = keyboard.nextInt();
			if (widgets < 0)
				throw new C07NegativeNumberException("widgets");

			System.out.println("How many were defective?");
			int defective = keyboard.nextInt();
			if (defective < 0)
				throw new C07NegativeNumberException("defective " + "widgets");

			double ratio = exceptionalDivision(widgets, defective);
			System.out.println("One in every " + ratio
					+ " widgets is defective.");
		}
		// catch Divide by Zero exception
		catch (C03DivideByZeroException e) {
			System.out.println("Congratulations! A perfect " + "record!");
		}
		// catch negative number exception
		catch (C07NegativeNumberException e) {
			System.out.println("Cannot have a negative number of "
					+ e.getMessage());
		}

		System.out.println("End of program.");

		// close keyboard
		keyboard.close();
	}

	public static double exceptionalDivision(double numerator,
			double denominator) throws C03DivideByZeroException {
		if (denominator == 0)
			throw new C03DivideByZeroException();
		return numerator / denominator;
	}
}