package bookcode.p06MoreAboutObjectsAndMethod;

/**
 * An Utility class for money. Use o utility methods from class Math
 * 
 */

public class C10DollarFormatFirstTry {
	
	/**
	 * Displays amount in dollars and cents notation. Rounds after two decimal
	 * places. Does not advance to the next line after output.
	 */
	public static void write(double amount) {
		// get the total cents
		int allCents = (int) (Math.round(amount * 100));

		// get the dollars
		int dollars = allCents / 100;

		// get the cents
		int cents = allCents % 100;

		// show results
		System.out.print('$');
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
