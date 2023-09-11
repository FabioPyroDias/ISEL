package bookcode.p07Arrays;

import java.util.Scanner;

/**
 * 
 * Auxiliary class for the next class
 * 
 * Class for sales associate records.
 */
public class C03SalesAssociate {

	static Scanner keyboard = new Scanner(System.in);

	private String name;
	private double sales;

	/**
	 * constructor
	 */
	public C03SalesAssociate() {
		name = "No record";
		sales = 0;
	}

	/**
	 * constructor
	 */
	public C03SalesAssociate(String initialName, double initialSales) {
		set(initialName, initialSales);
	}

	/**
	 * set data
	 */
	public void set(String newName, double newSales) {
		name = newName;
		sales = newSales;
	}

	/**
	 * read input
	 */
	public void readInput() {
		// read the name
		System.out.print("Enter name of sales associate: ");
		name = keyboard.nextLine();

		// read the sales amount
		System.out.print("Enter associate's sales: $");
		sales = keyboard.nextDouble();

		// clean the end of line
		keyboard.nextLine();
	}

	/**
	 * write to output
	 */
	public void writeOutput() {
		System.out.println("Name: " + name);
		System.out.println("Sales: $" + sales);
	}

	/**
	 * get name
	 */
	public String getName() {
		return name;
	}

	/**
	 * get sales
	 */
	public double getSales() {
		return sales;
	}
}
