package bookcode.p05ClassesAndMethods;

import java.util.Scanner;

/**
 * Class for data on endangered species. EQUALS METHOD. THIS
 */
public class C18SpeciesEqualsMethod {
	
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
	 *  write data to the console
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
	 * set data to this object
	 */
	public void set(String newName, int newPopulation, double newGrowthRate) {
		name = newName;
		if (newPopulation >= 0)
			population = newPopulation;
		else {
			System.out.println("ERROR: using a negative population.");
			System.exit(0);
		}
		growthRate = newGrowthRate;
	}

	/**
	 * get the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * get the population number
	 */
	public int getPopulation() {
		return population;
	}

	/**
	 * get grow rate
	 */
	public double getGrowthRate() {
		return growthRate;
	}

	/**
	 * Method that compare if the species received are the same
	 * 
	 * @param otherObject
	 *            the species to compare
	 * @return true if they have the same name, so they are the same species
	 */
	public boolean equals(C18SpeciesEqualsMethod otherObject) {
		return ((this.name.equalsIgnoreCase(otherObject.name))
				&& (this.population == otherObject.population) && (this.growthRate == otherObject.growthRate));
	}
}
