package bookcode.p06MoreAboutObjectsAndMethod;

/**
 * Class whose privacy can be breached.
 */
public class C16PetPair {
	
	// two private object references
	private C04Pet3 first, second;

	/**
	 * constructor that receives two pets
	 */
	public C16PetPair(C04Pet3 firstPet, C04Pet3 secondPet) {
		first = firstPet;
		second = secondPet;
	}

	public C04Pet3 getFirst() {
		return first;
	}

	public C04Pet3 getSecond() {
		return second;
	}

	public void writeOutput() {
		System.out.println("First pet in the pair:");
		first.writeOutput();
		System.out.println("\nSecond pet in the pair:");
		second.writeOutput();
	}
}
