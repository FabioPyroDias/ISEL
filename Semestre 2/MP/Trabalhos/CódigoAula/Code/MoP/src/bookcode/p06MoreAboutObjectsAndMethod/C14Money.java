package bookcode.p06MoreAboutObjectsAndMethod;

import java.util.Scanner;

/**
 * OVERLOADING in instance methods
 * 
 * Class representing nonnegative amounts of money, such as $100, $41.99, $0.05.
 * 
 */
public class C14Money {
	private long dollars;
	private long cents;

	private static Scanner keyboard = new Scanner(System.in);

	/**
	 * method overloaded
	 */
	public void set(long newDollars) {
		if (newDollars < 0) {
			System.out
					.println("Error: Negative amounts of money are not allowed.");
			System.exit(0);
		} else {
			dollars = newDollars;
			cents = 0;
		}
	}

	/**
	 * method overloaded
	 */
	public void set(double newAmount) {
		if (newAmount < 0) {
			System.out
					.println("Error: Negative amounts of money are not allowed.");
			System.exit(0);
		} else {
			long allCents = Math.round(newAmount * 100);
			dollars = allCents / 100;
			cents = allCents % 100;
		}
	}

	/**
	 * method overloaded
	 */
	public void set(C14Money moneyObject) {
		this.dollars = moneyObject.dollars;
		this.cents = moneyObject.cents;
	}

	// Precondition: The argument is an ordinary representation
	// of an amount of money, with or without a dollar sign.
	// Fractions of a cent are not allowed.
	/**
	 * method overloaded
	 */
	public void set(String amountString) {
		// Delete '$' if any:
		if (amountString.charAt(0) == '$')
			amountString = amountString.substring(1);

		amountString = amountString.trim();

		// Locate decimal point:
		int pointLocation = amountString.indexOf(".");

		// If no decimal point
		if (pointLocation < 0) {
			cents = 0;
			dollars = Long.parseLong(amountString);

		} else {
			// String has a decimal point.
			String dollarsString = amountString.substring(0, pointLocation);
			String centsString = amountString.substring(pointLocation + 1);
			// one digit in cents means tenths of a dollar

			if (centsString.length() <= 1)
				centsString = centsString + "0";
			// convert to numeric
			dollars = Long.parseLong(dollarsString);
			cents = Long.parseLong(centsString);

			if ((dollars < 0) || (cents < 0) || (cents > 99)) {
				System.out.println("Error: Illegal representation of money.");
				System.exit(0);
			}
		}
	}

	/**
	 * readInput
	 */
	public void readInput() {
		// We used nextLine instead of next because
		// there may be a space between the dollar
		System.out.print("Enter amount -> ");

		// read the amount as string
		String amount = keyboard.nextLine();

		// trim removes the staring and ending spaces
		set(amount.trim());

		// close keyboard
		keyboard.close();
	}

	/**
	 * sign and the number. Does not go to the next line after displaying money.
	 */
	public void writeOutput() {
		System.out.print("$" + dollars);
		if (cents < 10)
			System.out.print(".0" + cents);
		else
			System.out.print("." + cents);
	}

	/**
	 * Returns n times the calling object.
	 */
	public C14Money times(int n) {
		C14Money product = new C14Money();
		product.cents = n * cents;
		long carryDollars = product.cents / 100;
		product.cents = product.cents % 100;
		product.dollars = n * dollars + carryDollars;
		return product;
	}

	/**
	 * Returns the sum of the calling object and the argument.
	 */
	public C14Money add(C14Money otherAmount) {
		C14Money sum = new C14Money();
		sum.cents = this.cents + otherAmount.cents;
		long carryDollars = sum.cents / 100;
		sum.cents = sum.cents % 100;
		sum.dollars = this.dollars + otherAmount.dollars + carryDollars;
		return sum;
	}
}
