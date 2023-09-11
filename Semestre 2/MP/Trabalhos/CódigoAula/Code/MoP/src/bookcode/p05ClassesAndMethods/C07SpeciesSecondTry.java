package bookcode.p05ClassesAndMethods;

import java.util.Scanner;

/**
 * Methods with arguments
 * 
 * Now the last method that receives one argument
 * 
 */

public class C07SpeciesSecondTry {

	// name of the species
	public String name;
	// population number
	public int population;
	// population growth rate (per year)
	public double growthRate;

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
	 * This method receive one int as a argument. In the method years is as a
	 * local variable.
	 * 
	 * Returns the projected population of the receiving object after the
	 * specified number of years. This method can be used in any value of years.
	 * much more practical that getPopulationIn10
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
}
