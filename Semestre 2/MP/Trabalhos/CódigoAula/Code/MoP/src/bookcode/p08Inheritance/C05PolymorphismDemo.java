package bookcode.p08Inheritance;

/**
 * Example that an array of base class could have instance of any class that
 * extends the base class and we can use any of that instance with the method
 * declared in the base class - polymorphism.
 */
public class C05PolymorphismDemo {

	public static void main(String[] args) {

		// array of Persons
		C01Person[] people = new C01Person[4];

		// put the several type of person in the array
		people[0] = new C04Undergraduate("Cotty, Manny", 4910, 1);
		people[1] = new C04Undergraduate("Kick, Anita", 9931, 2);
		people[2] = new C02Student("DeBanque, Robin", 8812);
		people[3] = new C04Undergraduate("Bugg, June", 9901, 4);

		// apply the method writeOutput to each person in the array
		// use of for each type of for - it executes the body for each element
		// of the container received
		for (C01Person p : people) {
			p.writeOutput();
			System.out.println();
		}

		// equivalent to
		for (int i = 0; i < people.length; i++) {
			people[i].writeOutput();
			System.out.println();
		}
	}
}
