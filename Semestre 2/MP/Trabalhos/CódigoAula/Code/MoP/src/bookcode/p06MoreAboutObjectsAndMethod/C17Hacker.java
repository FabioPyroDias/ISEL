package bookcode.p06MoreAboutObjectsAndMethod;

/**
 * Toy program to demonstrate how a programmer can access and change private
 * data in an object of the class PetPair.
 */
public class C17Hacker {

	/**
	 * Main method
	 */
	public static void main(String[] args) {
		// create a goodDog
		C04Pet3 goodDog = new C04Pet3("Faithful Guard Dog", 5, 75.0);

		// create the buddy
		C04Pet3 buddy = new C04Pet3("Loyal Companion", 4, 60.5);

		// create the pair
		C16PetPair pair = new C16PetPair(goodDog, buddy);

		// show data
		System.out.println("Our pair:");
		pair.writeOutput();

		// get first on pair, get its reference
		C04Pet3 badGuy = pair.getFirst();

		// change its contents
		badGuy.setPet("Dominion Spy", 1200, 500);

		// show new state
		System.out.println("\nOur pair now:");
		pair.writeOutput();

		// we returned the reference to the object, so the badGuy changed it.
		// Solution: return a reference to a new pet that is a copy of the one
		// that we want to return
		System.out.println("The pet wasn't so private!");
		System.out.println("Looks like a security breach.");
	}
}
