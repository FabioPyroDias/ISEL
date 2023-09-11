package bookcode.p05ClassesAndMethods;

import java.util.*;

/**
 * Demonstrates the use of the mutator method set.
 */
public class C13SpeciesFourthTryDemo {

	/**
	 * main method
	 */
	public static void main(String[] args) {

		// the keyboard reader
		Scanner keyboard = new Scanner(System.in);

		// create new species and keep the reference in speciesOfTheMonth
		C12SpeciesFourthTry speciesOfTheMonth = new C12SpeciesFourthTry();

		// ask and read the number of the year to calculate the population
		System.out.print("Enter number of years to project -> ");
		int numberOfYears = keyboard.nextInt();

		// ask and enter the species data
		System.out.println("Enter data on the Species of the Month:");
		speciesOfTheMonth.readInput();

		// write species data to console
		speciesOfTheMonth.writeOutput();

		// calculate species population for the years introduced
		int futurePopulation = speciesOfTheMonth
				.projectedPopulation(numberOfYears);
		System.out.println("In " + numberOfYears
				+ " years the population will be " + futurePopulation);

		System.out.println();
		
		// new values for population
		speciesOfTheMonth.set("Klingon ox", 10, 15);
		System.out.println("The new Species of the Month:");
		speciesOfTheMonth.writeOutput();

		// output the new calculation numbers
		System.out.println("In " + numberOfYears
				+ " years the population will be "
				+ speciesOfTheMonth.projectedPopulation(numberOfYears));

		// close keyboard
		keyboard.close();
	}
}
