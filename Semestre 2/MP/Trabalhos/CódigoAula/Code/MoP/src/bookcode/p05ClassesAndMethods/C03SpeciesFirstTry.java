package bookcode.p05ClassesAndMethods;

import java.util.Scanner;

/**
 * Species definition an instantiable class. A more useful class.
 * 
 */
public class C03SpeciesFirstTry {

	// instance variables
	// name of the species
	public String name;
	// population number
	public int population;
	// population growth rate (per year) in % (30 -> 30%)
	public double growthRate;

	/**
	 * Method that reads the object data from the console
	 * 
	 * @param keyboard
	 */
	public void readInput(Scanner keyboard) {

		// ask and read species name
		System.out.print("Enter the species' name -> ");
		name = keyboard.nextLine();

		// species population
		System.out.print("Enter the population of the species (int value) -> ");
		population = keyboard.nextInt();

		// species growth rate - the scanner reads with the local settings so it
		// reads decimal values with ',' as the decimal separator. But when we
		// write one double to the console the value will apear with the '.' as
		// decimal separator
		System.out.print("Enter the growth rate "
				+ "(% increase per year, a decimal value ex. 1,8) -> ");
		growthRate = keyboard.nextDouble();
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
}
