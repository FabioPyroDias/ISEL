package bookcode.p05ClassesAndMethods;

import java.util.Scanner;

/**
 * Class for the purchase of one kind of item, such as 3 oranges. Prices are set
 * supermarket style, such as 5 for $1.25.
 */
public class C14Purchase {

	// name of the product
	private String name;

	// number of units per group. Part of price, like the 2 in 2 for $1.99.
	private int groupCount;

	// group price
	private double groupPrice;

	// Total number being purchased.
	private int numberBought;

	/**
	 * Set name of this item
	 * 
	 * @param newName
	 */
	public void setName(String newName) {
		name = newName;
	}

	/**
	 * Sets price to count pieces for $costForCount. For example, 2 for $1.99.
	 */
	public void setPrice(int count, double costForCount) {
		// if negative values, terminate the program showing an error
		if ((count <= 0) || (costForCount <= 0)) {
			System.out.println("Error: Bad parameter in setPrice.");
			System.exit(0);
		} else {
			groupCount = count;
			groupPrice = costForCount;
		}
	}

	/**
	 * Set the number of elements purchased
	 * 
	 * @param number
	 */
	public void setNumberBought(int number) {
		// if a negative value, terminate the program showing an error
		if (number <= 0) {
			System.out.println("Error: Bad parameter in setNumberBought.");
			System.exit(0);
		} else
			numberBought = number;
	}

	/**
	 * Gets price and number being purchased from keyboard.
	 */
	public void readInput() {

		// the keyboard reader
		Scanner keyboard = new Scanner(System.in);

		// ask and enter the name of the item
		System.out.print("Enter name of item you are purchasing -> ");
		name = keyboard.nextLine();

		// ask and read the number of items in group and group cost
		System.out.println("Enter price of item as two numbers.");
		System.out.println("For example, 3 for $2.99 is entered as -> 3 2.99");
		System.out.print("Enter price of item as two numbers -> ");
		groupCount = keyboard.nextInt();
		groupPrice = keyboard.nextDouble();

		// check if inputs are ok and repeat the reading until they are ok
		while ((groupCount <= 0) || (groupPrice <= 0)) {// Try again:
			// show error message
			System.out.println("Both numbers must be positive. Try again.");
			// ask and read the number of items in group and group cost
			System.out.println("Enter price of item as two numbers.");
			System.out.println("For example, 3 for $2.99 is entered as 3 2.99");
			System.out.print("Enter price of item as two numbers -> ");
			groupCount = keyboard.nextInt();
			groupPrice = keyboard.nextDouble();
		}

		// ask and read the number of items purchased
		System.out.print("Enter number of items purchased -> ");
		numberBought = keyboard.nextInt();
		// check and read again until we get a positive number > 0
		while (numberBought <= 0) {
			System.out.println("Number must be positive. Try again.");
			System.out.print("Enter number of items purchased -> ");
			numberBought = keyboard.nextInt();
		}

		// close keyboard
		keyboard.close();
	}

	/**
	 * Outputs price and number being purchased to screen.
	 */
	public void writeOutput() {
		System.out.println(numberBought + " " + name + " at " + groupCount
				+ " for $" + groupPrice);
	}

	/**
	 * get name
	 * 
	 * @return the name of this item
	 */
	public String getName() {
		return name;
	}

	/**
	 * get total cost
	 * 
	 * @return the total cost
	 */
	public double getTotalCost() {
		// return ((groupPrice / groupCount) * numberBought);
		return (getUnitCost() * numberBought);
	}

	/**
	 * get units cost
	 * 
	 * @return the cost of units purchased
	 */
	public double getUnitCost() {
		return (groupPrice / groupCount);
	}

	/**
	 * get the number elements bought
	 * 
	 * @return the number of elements bought
	 */
	public int getNumberBought() {
		return numberBought;
	}
}
