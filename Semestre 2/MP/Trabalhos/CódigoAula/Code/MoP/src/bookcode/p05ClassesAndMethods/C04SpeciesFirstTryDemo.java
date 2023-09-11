package bookcode.p05ClassesAndMethods;

import java.util.Scanner;

/**
 * This class uses instances of SpeciesFirsttry class
 * 
 */
public class C04SpeciesFirstTryDemo {

	public static void main(String[] args) {

		// keyboard access
		Scanner keyboard = new Scanner(System.in);

		// create species, read its data and write it to output
		C03SpeciesFirstTry speciesOfTheMonth = new C03SpeciesFirstTry();
		System.out.println("Enter data on the Species of the Month:");
		speciesOfTheMonth.readInput(keyboard);
		speciesOfTheMonth.writeOutput();

		// to create a visual separation in the console
		System.out.println();

		// get population in ten years
		int futurePopulation = speciesOfTheMonth.getPopulationIn10();
		System.out.println("In ten years the population will be "
				+ futurePopulation);

		System.out.println();

		// Change the species data to show how to change
		// the values of instance variables:
		speciesOfTheMonth.name = "Klingon ox";
		speciesOfTheMonth.population = 10;
		speciesOfTheMonth.growthRate = 15;

		// show the new results: the same object but with data changed
		System.out.println("The new Species of the Month:");
		speciesOfTheMonth.writeOutput();
		System.out.println("In ten years the population will be "
				+ speciesOfTheMonth.getPopulationIn10());

		// close keyboard
		keyboard.close();
	}
}
