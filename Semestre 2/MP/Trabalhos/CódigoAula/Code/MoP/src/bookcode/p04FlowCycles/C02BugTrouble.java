package bookcode.p04FlowCycles;

import java.util.*;

/**
 * 
 * While, cast
 * 
 * Program to calculate how long it will take a population of roaches to
 * completely fill a house from floor to ceiling.
 */
public class C02BugTrouble {
	public static final double GROWTH_RATE = 0.95;// 95% per week
	public static final double ONE_BUG_VOLUME = 0.002;// cubic feet

	/**
	 * Main method
	 */
	public static void main(String[] args) {

		// the keyboard reader
		Scanner keyboard = new Scanner(System.in);

		// ask and read the cubic feet of the house
		System.out.println("Enter the total volume of your house"
				+ " in cubic feet: ");
		double houseVolume = keyboard.nextDouble();

		// ask and read the initially estimated number of roaches in the house
		System.out.println("Enter the estimated number of"
				+ " roaches in your house: ");
		int startPopulation = keyboard.nextInt();

		// week counter
		int countWeeks = 0;

		// current population
		double population = startPopulation;

		// the current total
		double totalBugVolume = population * ONE_BUG_VOLUME;

		// the cycle that will repeat the calculation for every week
		while (totalBugVolume < houseVolume) {
			population = population + (GROWTH_RATE * population);
			totalBugVolume = population * ONE_BUG_VOLUME;
			countWeeks++;
		}

		// show the results
		System.out.println("Starting with a roach population of "
				+ startPopulation);
		System.out.println("and a house with a volume of " + houseVolume
				+ " cubic feet,");
		System.out.println("after " + countWeeks + " weeks,");
		System.out
				.println("the house will be filled floor to ceiling with roaches.");
		// cast from double to int, the integer part of the double will go to
		// the int
		System.out.println("There will be " + (int) population + " roaches.");
		System.out.println("They will fill a volume of " + (int) totalBugVolume
				+ " cubic feet.");

		System.out.println("Better call Debugging Experts Inc.");

		// close keyboard
		keyboard.close();
	}
}
