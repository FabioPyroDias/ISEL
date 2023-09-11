package bookcode.p02Basic;

import java.util.Scanner;

/**
 * now with input
 * 
 */
public class C02EggBasket2 {

	/**
	 * main method
	 */
	public static void main(String[] args) {

		// the object that reads from the keyboard - we will clarify this later
		Scanner keyboard = new Scanner(System.in);

		// variables
		int numberOfBaskets, eggsPerBasket, totalEggs;

		// ask the value of eggs in each basket
		System.out.print("Enter the number of eggs in each basket: ");
		// read eggs per basket as one integer
		eggsPerBasket = keyboard.nextInt();

		// ask the number of baskets
		System.out.print("Enter the number of baskets: ");
		// read number of baskets as one int
		numberOfBaskets = keyboard.nextInt();

		// calculate total of eggs
		totalEggs = numberOfBaskets * eggsPerBasket;

		// show results in a nice message
		System.out.println("If you have " + eggsPerBasket
				+ " eggs per basket and " + numberOfBaskets + " baskets,");
		System.out.println("then the total number of eggs is " + totalEggs);

		// now, a second situation, two eggs out of each basket
		System.out.println("Now we take two eggs out of each basket.");

		// subtract two eggs in each basket
		eggsPerBasket = eggsPerBasket - 2;
		// calculate the new total number of eggs
		totalEggs = numberOfBaskets * eggsPerBasket;

		// show the new results
		System.out.println("You now have " + " eggs per basket and "
				+ numberOfBaskets + " baskets.");
		System.out.println("The new total number of eggs is " + totalEggs);

		// close keyboard
		keyboard.close();

	}
}
