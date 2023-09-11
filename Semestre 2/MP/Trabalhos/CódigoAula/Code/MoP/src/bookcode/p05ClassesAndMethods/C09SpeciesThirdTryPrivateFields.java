package bookcode.p05ClassesAndMethods;

import java.util.Scanner;

/**
 * Now instance variables have private visibility. That means that they are not
 * visible, or accessible, from outside the class code.
 * 
 */
public class C09SpeciesThirdTryPrivateFields {

	// now variables have private visibility
	// they are not visible outside the class
	private String name;
	private int population;
	private double growthRate;

	/**
	 * Method that reads the object data from the console
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

		// species growth rate
		System.out.print("Enter the growth rate "
				+ "(% increase per year, a decimal value ex. 1,8) -> ");
		growthRate = keyboard.nextDouble();

		// close keyboard
		keyboard.close();
	}

	/**
	 * Method that writes the object data to the console
	 */
	public void writeOutput() {
		System.out.println("Name = " + name);
		System.out.println("Population = " + population);
		System.out.println("Growth rate = " + growthRate + "%");
	}

	/**
	 * Method that return the population of the species ten years later
	 * 
	 * @return the population number
	 */
	public int getPopulationIn10() {
		// the result
		int result = 0;
		// the current population
		double populationAmount = population;
		// we will do it for ten times
		int count = 10;

		// execute population calculation for ten times
		while ((count > 0) && (populationAmount > 0)) {
			// population calculation from one year to the next
			populationAmount = populationAmount + (growthRate / 100)
					* populationAmount;
			// one less time to do
			count--;
		}

		// if we did something useful put it in the result
		if (populationAmount > 0)
			result = (int) populationAmount;

		// return result
		return result;
	}

	/**
	 * Returns the projected population of the receiving object after the
	 * specified number of years.
	 */
	public int predictPopulation(int years) {
		// the result
		int result = 0;
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
			result = (int) populationAmount;
		return result;
	}

	// a method that receives new data a nd stores it in the fields of the
	// object
	public void setSpeciesData(String newName, int newPopulation,
			double newgrowthRate) {
		// save newName
		name = newName;
		// save newPopulation
		population = newPopulation;
		// save newgrowthRate
		growthRate = newgrowthRate;
	}
}
