package bookcode.p05ClassesAndMethods;

/**
 * Dog demo class
 * 
 */
public class C02DogDemo {

	public static void main(String[] args) {
		// try the two next lines, just to provoque a error
		// C01Dog doggy = null;
		// doggy.name = "dunga";

		// create Balto Dog - create an instance of the class Dog, an object of
		// class Dog
		C01Dog balto = new C01Dog();

		// set dog balto properties
		balto.name = "Balto";
		balto.age = 8;
		balto.breed = "Siberian Husky";

		// write dog balto to the console
		balto.writeOutput();

		// work with another object

		// create Scoopy dog
		C01Dog scooby = new C01Dog();

		// set his properties
		scooby.name = "Scooby";
		scooby.age = 42;
		scooby.breed = "Great Dane";

		// do some action with it
		System.out.println(scooby.name + " is a " + scooby.breed + ".");
		System.out.print("He is " + scooby.age + " years old, or ");

		int humanYears = scooby.getAgeInHumanYears();
		System.out.println(humanYears + " in human years.");
		System.out.println();

		System.out.println("We have two dogs, they are:" + balto.name + " and "
				+ scooby.name);
	}
}
