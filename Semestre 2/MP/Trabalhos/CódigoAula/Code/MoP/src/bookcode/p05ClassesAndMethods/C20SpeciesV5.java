package bookcode.p05ClassesAndMethods;

import java.util.*;

/**
 * Demonstrate the difference between parameters of a class type and parameters
 * of a primitive type.
 */
public class C20SpeciesV5 {

	// instance attributes
	private String name;
	private int population;
	private double growthRate;

	/**
	 * 
	 */
	public void readInput() {
		// keyboard access
		Scanner keyboard = new Scanner(System.in);

		// ask and read species name
		System.out.println("What is the species' name?");
		name = keyboard.nextLine();

		// species population
		System.out.println("What is the population of the species?");
		population = keyboard.nextInt();

		// check and read population until it is greater than 0
		while (population < 0) {
			System.out.println("Population cannot be negative.");
			System.out.println("Reenter population:");
			population = keyboard.nextInt();
		}

		// species growth rate
		System.out.println("Enter growth rate (percent increase per year):");
		growthRate = keyboard.nextDouble();

		// close keyboard
		keyboard.close();
	}

	/**
	 * 
	 */
	public void writeOutput() {
		System.out.println("Name = " + name);
		System.out.println("Population = " + population);
		System.out.println("Growth rate = " + growthRate + "%");
	}

	/**
	 * Precondition: years is a nonnegative number. Returns the projected
	 * population of the receiving object after the specified number of years.
	 */
	public int predictPopulation(int years) {
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

		// return the result
		return (int) populationAmount;
	}

	/**
	 * 
	 */
	public void setSpecies(String newName, int newPopulation,
			double newGrowthRate) {
		name = newName;
		if (newPopulation >= 0)
			population = newPopulation;
		else {
			System.out.println("ERROR: using a negative " + "population.");
			System.exit(0);
		}
		growthRate = newGrowthRate;
	}

	/**
	 * 
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 */
	public int getPopulation() {
		return population;
	}

	/**
	 * 
	 */
	public double getGrowthRate() {
		return growthRate;
	}

	/**
	 * This version of equals is equivalent to the version in C18Species
	 * 
	 * @param otherObject
	 * @return
	 */
	public boolean equals(C20SpeciesV5 otherObject) {
		return (name.equalsIgnoreCase(otherObject.name))
				&& (population == otherObject.population)
				&& (growthRate == otherObject.growthRate);
	}
}
