package bookcode.p05ClassesAndMethods;

import java.util.*;

/**
 * Species with getter and setter methods
 * 
 */

public class C12SpeciesFourthTry {
	// the instance attributes
	private String name;
	private int population;
	private double growthRate;

	/**
	 * read input
	 */
	public void readInput() {
		// keyboard access
		Scanner keyboard = new Scanner(System.in);

		// ask and read species name
		System.out.print("Enter the species' name -> ");
		name = keyboard.nextLine();

		// species population
		System.out.print("Enter the population of the species (int value) -> ");
		population = keyboard.nextInt();

		// check and read population until it is greater than 0
		while (population < 0) {
			System.out.println("Population cannot be negative.");
			System.out
					.print("Reenter population (% and decimal value exº: 1,8) -> ");
			population = keyboard.nextInt();
		}

		// species growth rate
		System.out.print("Enter the growth rate "
				+ "(% increase per year, a decimal value ex. 1,8) -> ");
		growthRate = keyboard.nextDouble();

		// close keyboard
		keyboard.close();
	}

	/**
	 * write ouput
	 */
	public void writeOutput() {
		System.out.println("Name = " + name);
		System.out.println("Population = " + population);
		System.out.println("Growth rate = " + growthRate + "%");
	}

	/**
	 * Precondition: years is a nonnegative number. Returns the projected
	 * population of the calling object after the specified number of years.
	 */
	public int projectedPopulation(int years) {
		// the current population
		double populationAmount = population;
		// we will do it for "year" times
		int count = years;

		// execute population calculation for "year" times
		while ((count > 0) && (populationAmount > 0)) {
			// population calculation from one year to the next
			populationAmount = (populationAmount + (growthRate / 100)
					* populationAmount);
			// one less time to do
			count--;
		}

		// if we did something useful put it in the result
		if (populationAmount > 0)
			return (int) populationAmount;
		else
			return 0;
		// or just: return (int) populationAmount;
	}

	/**
	 * set new values to species
	 * 
	 * @param newName
	 *            the population name
	 * @param newPopulation
	 *            the population number
	 * @param newGrowthRate
	 *            the population growth rate
	 */
	// put the mouse over the name of the method set, you will set the
	// documentation that is above
	public void set(String newName, int newPopulation, double newGrowthRate) {
		// set name
		name = newName;

		// set population
		if (newPopulation >= 0)
			population = newPopulation;
		else {
			System.out.println("ERROR: using a negative population.");
			System.exit(0);
		}

		// set grow rate
		growthRate = newGrowthRate;
	}

	/**
	 * get name of the species
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * gets the population of the species
	 * 
	 * @return the population
	 */
	public int getPopulation() {
		return population;
	}

	/**
	 * gets the growth rate of the population
	 * 
	 * @return the growth rate
	 */
	public double getGrowthRate() {
		return growthRate;
	}
}
