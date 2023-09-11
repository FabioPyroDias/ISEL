package bookcode.p08Inheritance;

/**
 * Class Person
 */
public class C01Person {
	private String name;

	/**
	 * Empty constructor
	 */
	public C01Person() {
		name = "No name yet";
	}

	/**
	 * Constructor
	 */
	public C01Person(String initialName) {
		name = initialName;
	}

	/**
	 * getName
	 */
	public void setName(String newName) {
		name = newName;
	}

	/**
	 * getName
	 */
	public String getName() {
		return name;
	}

	/**
	 * writeOutput
	 */
	public void writeOutput() {
		System.out.println("Name: " + name);
	}

	/**
	 * hasSameName
	 */
	public boolean hasSameName(C01Person otherPerson) {
		return this.name.equalsIgnoreCase(otherPerson.name);
	}

	/**
	 * toString
	 */
	public String toString() {
		return name;
	}
}