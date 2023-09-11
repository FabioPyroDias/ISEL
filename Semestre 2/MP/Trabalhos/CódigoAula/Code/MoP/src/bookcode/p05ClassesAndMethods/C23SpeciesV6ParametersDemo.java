package bookcode.p05ClassesAndMethods;

public class C23SpeciesV6ParametersDemo {

	/**
	 * main method
	 */
	public static void main(String[] args) {

		// s1 and s2 are references to two species
		C22SpeciesV6Parameters s1 = new C22SpeciesV6Parameters(), s2 = new C22SpeciesV6Parameters();

		// set values and do some interaction with s1
		s1.setSpecies("Klingon ox", 10, 15);
		int aPopulation = 42;
		System.out.println("s1: aPopulation BEFORE calling tryToChange: "
				+ aPopulation);
		s1.tryToChange(aPopulation);
		System.out.println("s1: aPopulation AFTER calling tryToChange: "
				+ aPopulation);

		System.out.println();

		// do some interactions with s2
		s2.setSpecies("s2 Ferengie Fur Ball", 90, 56);
		System.out.println("s2 BEFORE calling s1.tryToReplace(s2): ");
		s2.writeOutput();
		s1.tryToReplace(s2);
		System.out.println("s2 AFTER calling s1.tryToReplace(s2): ");
		s2.writeOutput();

		System.out.println();

		// change the contents of s2 with the values of s1
		s1.writeTo(s2);
		System.out.println("s2 AFTER calling s1.change(s2): ");
		s2.writeOutput();
	}
}
