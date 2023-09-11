package bookcode.p06MoreAboutObjectsAndMethod;

import java.util.*;

/**
 * OBJECT PARAMETERS. MAIN DECLARED
 * 
 * This is a version of the class Species, but is only a toy example designed to
 * demonstrate the difference between parameters of a class type and parameters
 * of a primitive type.
 */
public class C09Species {

	private String name;
	private int population;
	private double growthRate;

	// the keyboard to be saved as static variable
	static Scanner keyboard;

	public void readInput() {
		System.out.println("What is the species' name?");
		name = keyboard.nextLine();
		System.out.println("What is the population of the species?");
		population = keyboard.nextInt();
		while (population < 0) {
			System.out.println("Population cannot be negative.");
			System.out.println("Reenter population:");
			population = keyboard.nextInt();
		}
		System.out.println("Enter growth rate (% increase per year):");
		growthRate = keyboard.nextDouble();
	}

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
		int result = 0;
		double populationAmount = population;
		int count = years;
		while ((count > 0) && (populationAmount > 0)) {
			populationAmount = (populationAmount + (growthRate / 100)
					* populationAmount);
			count--;
		}
		if (populationAmount > 0)
			result = (int) populationAmount;
		return result;
	}

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

	public String getName() {
		return name;
	}

	public int getPopulation() {
		return population;
	}

	public double getGrowthRate() {
		return growthRate;
	}

	/**
	 * This version of equals is equivalent to the version in Listing 5.17.
	 * Here, the keyword this is understood to be there implicitly.
	 * 
	 * @param otherObject
	 * @return
	 */
	public boolean equals(C09Species otherObject) {
		return (name.equalsIgnoreCase(otherObject.name))
				&& (population == otherObject.population)
				&& (growthRate == otherObject.growthRate);
	}

	/**
	 * Main is a static method. Can not access instance fields
	 */
	public static void main(String[] args) {

		// keyboard reader
		Scanner keyboard = new Scanner(System.in);

		// save the keyboard into species
		C09Species.keyboard = keyboard;

		// create one object of species
		C09Species speciesToday = new C09Species();

		// ask and read data
		System.out.println("Enter data on today's species:");
		speciesToday.readInput();

		// show data
		speciesToday.writeOutput();

		System.out.println();

		// read number of years
		System.out.println("Enter number of years to project:");
		int numberOfYears = keyboard.nextInt();

		// predict population
		int futurePopulation = speciesToday.predictPopulation(numberOfYears);

		// show the results
		System.out.println("In " + numberOfYears
				+ " years the population will be " + futurePopulation);

		System.out.println();

		// set and show new data
		speciesToday.setSpecies("Klingon ox", 10, 15);
		System.out.println("The new species is:");
		speciesToday.writeOutput();

		// close keyboard
		keyboard.close();
	}

}
