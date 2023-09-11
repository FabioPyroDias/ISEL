package bookcode.p07Arrays;

/**
 * With the use of constants
 * 
 * Displays a two-dimensional table showing how interest rates affect bank
 * balances.
 */

public class C13InterestTable2 {

	public static final int ROWS = 10;
	public static final int COLUMNS = 6;

	/**
	 * Main method
	 */
	public static void main(String[] args) {

		final double amount = 1000.0;

		int[][] table = new int[ROWS][COLUMNS];

		for (int row = 0; row < ROWS; row++)
			for (int column = 0; column < COLUMNS; column++)
				table[row][column] = getBalance(amount, row + 1,
						(5 + 0.5 * column));

		System.out.println("Balances for Various Interest Rates "
				+ "Compounded Annually");
		System.out.println("(Rounded to Whole Dollar Amounts)");
		System.out.println("For initial amount of $" + amount);
		System.out.println();
		System.out.println("Years 5.00% 5.50% 6.00% 6.50% 7.00% 7.50%");
		showTable(table);
	}

	/**
	 * Precondition: The array anArray has ROWS rows and COLUMNS columns.
	 * Postcondition: The array contents are displayed with dollar signs.
	 */
	public static void showTable(int[][] anArray) {
		// A better definition of showTable is possible, as you will see.
		for (int row = 0; row < ROWS; row++) {
			System.out.print(" " + (row < 9 ? " " : "") + (row + 1) + "   ");
			for (int column = 0; column < COLUMNS; column++)
				System.out.print("$" + anArray[row][column] + " ");
			System.out.println();
		}
	}

	/**
	 * Returns the balance in an account after a given number of years and
	 * interest rate with an initial balance of startBalance. Interest is
	 * compounded annually. The balance is rounded to a whole number.
	 */
	public static int getBalance(double startBalance, int years, double rate) {
		double runningBalance = startBalance;
		for (int count = 1; count <= years; count++)
			runningBalance = runningBalance * (1 + rate / 100);
		return (int) (Math.round(runningBalance));
	}
}
