package bookcode.p07Arrays;

import java.util.Scanner;

/**
 * A class that have an array of Objects
 * 
 * The main method is at the end of the class. Program to generate sales report.
 */
public class C04SalesReporter {

	// simple attributes
	private double highestSales;
	private double averageSales;

	// The array object is created in getData.
	private C03SalesAssociate[] team;

	// Same as team.length
	private int numberOfAssociates;

	// the keyboard
	static Scanner keyboard = new Scanner(System.in);

	/**
	 * Reads the number of sales associates and data for each one.
	 */
	public void getData() {

		// ask and read the number of sales associates
		System.out.println("Enter number of sales associates:");
		numberOfAssociates = keyboard.nextInt();

		// Array of SalesAssociate created here.
		team = new C03SalesAssociate[numberOfAssociates];

		// read data for each one of the sales associate
		for (int i = 0; i < numberOfAssociates; i++) {

			// SalesAssociate objects created here.
			team[i] = new C03SalesAssociate();

			System.out.println("Enter data for associate " + i);
			team[i].readInput();

			System.out.println();
		}
	}

	/**
	 * Computes the average and highest sales figures. Precondition: There is at
	 * least one salesAssociate.
	 */
	public void computeStats() {

		double currentSales = team[0].getSales();

		// highest sales so far, this is instance varibale
		highestSales = currentSales;

		// total of sales
		double sum = currentSales;

		// Already processed team[1], so the loop starts with team[2].
		for (int i = 1; i < numberOfAssociates; i++) {
			currentSales = team[i].getSales();
			sum = sum + currentSales;
			if (currentSales > highestSales)
				highestSales = currentSales;
		}
		averageSales = sum / numberOfAssociates;
	}

	/**
	 * Displays sales report on the screen.
	 */
	public void displayResults() {

		// show average and high sales
		System.out.println("Average sales per associate is $" + averageSales);
		System.out.println("The highest sales figure is $" + highestSales);
		System.out.println();

		// show high sales
		System.out.println("The following had the highest sales:");
		for (int i = 0; i < numberOfAssociates; i++) {
			double nextSales = team[i].getSales();
			if (nextSales == highestSales) {
				team[i].writeOutput();
				System.out.println("$" + (nextSales - averageSales)
						+ " above the average.");
				System.out.println();
			}
		}

		// not high sales
		System.out.println("The rest performed as follows:");
		for (int i = 0; i < numberOfAssociates; i++) {
			double nextSales = team[i].getSales();
			if (team[i].getSales() != highestSales) {
				team[i].writeOutput();
				if (nextSales >= averageSales)
					System.out.println("$" + (nextSales - averageSales)
							+ " above the average.");
				else
					System.out.println("$" + (averageSales - nextSales)
							+ " below the average.");
				System.out.println();
			}
		}
	}

	/**
	 * Main method
	 */
	public static void main(String[] args) {

		// create one instance of SalesReporter
		C04SalesReporter clerk = new C04SalesReporter();

		// get data
		clerk.getData();

		// compute statistics
		clerk.computeStats();

		// display results
		clerk.displayResults();
	}
}
