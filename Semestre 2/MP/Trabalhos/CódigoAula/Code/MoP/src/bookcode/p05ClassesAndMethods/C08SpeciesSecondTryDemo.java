package bookcode.p05ClassesAndMethods;

/**
 * Test the species Second Try
 * 
 */
public class C08SpeciesSecondTryDemo {

	public static void main(String[] args) {

		// create object and fill it with data
		C07SpeciesSecondTry speciesOfTheMonth = new C07SpeciesSecondTry();
		System.out.println("Enter data on the Species of the " + "Month:");
		speciesOfTheMonth.readInput();

		// write the object data to the console
		speciesOfTheMonth.writeOutput();
		
		System.out.println();

		// calculate the predict population for 10 years
		int futurePopulation = speciesOfTheMonth.predictPopulation(10);
		System.out.println("In ten years the population will be "
				+ futurePopulation);
		
		System.out.println();

		// Change the species to show how to change the values of instance
		// variables:
		speciesOfTheMonth.name = "Klingon ox";
		speciesOfTheMonth.population = 10;
		speciesOfTheMonth.growthRate = 15;
		System.out.println("The new Species of the Month:");
		// write its the same object with the new data to the console
		speciesOfTheMonth.writeOutput();
		
		System.out.println();

		// make new prediction for 10 years
		System.out.println("In ten years the population will be "
				+ speciesOfTheMonth.predictPopulation(10));

		// make new prediction for 20 years
		System.out.println("In ten years the population will be "
				+ speciesOfTheMonth.predictPopulation(20));

		// make new prediction for 50 years
		System.out.println("In ten years the population will be "
				+ speciesOfTheMonth.predictPopulation(50));

	}
}
