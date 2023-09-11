package bookcode.p05ClassesAndMethods;

/**
 * tests the equals method
 */
public class C19SpeciesEqualsMethodDemo {

	/**
	 * main method
	 */
	public static void main(String[] args) {
		// s1 is one species
		C18SpeciesEqualsMethod s1 = new C18SpeciesEqualsMethod();
		// s2 is another species
		C18SpeciesEqualsMethod s2 = new C18SpeciesEqualsMethod();

		// set values for s1 and s2
		s1.set("Klingon Ox", 10, 15);
		s2.set("Klingon Ox", 10, 15);

		// show values
		System.out.println("s1 -> " + s1);
		s1.writeOutput();
		System.out.println();
		System.out.println("s2 -> " + s2);
		s2.writeOutput();

		System.out.println();

		// compare with ==
		System.out.println("s1 == s2");
		if (s1 == s2)
			System.out.println("Match with ==.");
		else
			System.out.println("Do Not match with ==.");

		System.out.println();

		// compare with equals method
		System.out.println("s1.equals( s2 )");
		if (s1.equals(s2))
			System.out.println("Match with the method equals.");
		else
			System.out.println("Do Not match with the method equals.");

		System.out.println();

		// set new data
		System.out.println("Now we change one Klingon Ox to all lowercase.");
		s2.set("klingon ox", 10, 15);

		// compare again with equals method
		if (s1.equals(s2))
			System.out.println("Still match with the method equals.");
		else
			System.out.println("Do Not match with the method equals.");
	}
}
