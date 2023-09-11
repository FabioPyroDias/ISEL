package bookcode.p06MoreAboutObjectsAndMethod;

public class C12DollarFormat {
	/**
	 * Displays amount in dollars and cents notation. Rounds after two decimal
	 * places. Does not advance to the next line after output.
	 */
	public static void write(double amount) {
		System.out.print('$');
		// The case for negative amounts of money
		if (amount < 0) {
			System.out.print('-');
			amount = -amount;
		}
		writePositive(amount);
	}

	// Precondition: amount >= 0;
	// Displays amount in dollars and cents notation. Rounds
	// after two decimal places. Omits the dollar sign.
	private static void writePositive(double amount) {

		// get total cents
		int allCents = (int) (Math.round(amount * 100));

		// get dollars
		int dollars = allCents / 100;

		// get cents
		int cents = allCents % 100;

		System.out.print(dollars);
		System.out.print('.');

		if (cents < 10)
			System.out.print('0');

		System.out.print(cents);
	}

	/**
	 * Displays amount in dollars and cents notation. Rounds after two decimal
	 * places. Advances to the next line after output.
	 */
	public static void writeln(double amount) {
		write(amount);
		System.out.println();
	}
}
