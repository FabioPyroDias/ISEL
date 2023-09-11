package bookcode.p05ClassesAndMethods;

/**
 * Private fields demo
 * 
 */
public class C09SpeciesThirdTryPrivateFieldsDemo {

	public static void main(String[] args) {

		// create object and fill it with data
		C09SpeciesThirdTryPrivateFields speciesOfTheMonth = new C09SpeciesThirdTryPrivateFields();
		System.out.println("Enter data on the Species of the " + "Month:");
		speciesOfTheMonth.readInput();
		// write data to the console
		speciesOfTheMonth.writeOutput();

		// calculate and write the population on 10 years
		int futurePopulation = speciesOfTheMonth.predictPopulation(10);
		System.out.println("In ten years the population will be "
				+ futurePopulation);

		System.out.println();

		// try to change the data of the species: you can't do it now. Because
		// the fields are now private
		// DESCOMENTAR AS SEGUINTES 3 LINHAS
		// speciesOfTheMonth.name = "Klingon ox";
		// speciesOfTheMonth.population = 10;
		// speciesOfTheMonth.growthRate = 15;
		// System.out.println(speciesOfTheMonth.name);

		// the only way to change data is to read the dat from the keyboard
		// again or used the new method setNewData.
		speciesOfTheMonth.setSpeciesData("Chiuaua", 20, 2.5);
		
		// write the object content, with must have the new value
		System.out.println("The new Species of the Month:");
		speciesOfTheMonth.writeOutput();

		System.out.println("In ten years the population will be "
				+ speciesOfTheMonth.predictPopulation(10));
	}
}
