package bookcode.p02Basic;

/**
 * Only output and calculation.
 * 
 */
public class C01EggBasket {

	/**
	 * main method
	 */
	public static void main(String[] args) {

		// variable declaration
		int numberOfBaskets, eggsPerBasket, totalEggs;

		// variable initialization
		eggsPerBasket = 6;
		numberOfBaskets = 10;

		// show base data
		System.out.println("If you have" + eggsPerBasket
				+ " eggs per basket and" + numberOfBaskets + " baskets then,");

		// calculate total of eggs
		totalEggs = numberOfBaskets * eggsPerBasket;

		// show new info
		System.out.println("the total number of eggs is " + totalEggs);
		System.out.println("Now we take two eggs out of each basket.");

		// new data
		eggsPerBasket = eggsPerBasket - 2;
		totalEggs = numberOfBaskets * eggsPerBasket;
		
		// show results
		System.out.println("You now have" + eggsPerBasket
				+ " eggs per basket and" + "and " + numberOfBaskets
				+ " baskets.");
		System.out.println("The new total number of eggs is " + totalEggs);
	}
}
