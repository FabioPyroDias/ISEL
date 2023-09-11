package bookcode.p06MoreAboutObjectsAndMethod;

/**
 * CONSTRUTORs
 * 
 * Class for basic pet records: name, age, and weight.
 */
public class C01Pet {

	// pet name
	private String name;

	// age in years
	private int age;

	// weight in pounds
	private double weight;

	// private String cidade = "Lisboa"; // Example of a attribute that is
	// initialized

	/**
	 * no arguments constructor
	 */
	public C01Pet() {
		name = "No name yet.";
		age = 0;
		weight = 0;
	}

	/**
	 * constructor that only receives the name
	 */
	public C01Pet(String initialName) {
		name = initialName;
		age = 0;
		weight = 0;
	}

	/**
	 * constructor that only receives the age
	 */
	public C01Pet(int initialAge) {
		name = "No name yet.";
		weight = 0;
		if (initialAge < 0) {
			System.out.println("Error: Negative age.");
			System.exit(0);
		} else
			age = initialAge;
	}

	/**
	 * constructor that only receives the weight
	 */
	public C01Pet(double initialWeight) {
		name = "No name yet";
		age = 0;
		if (initialWeight < 0) {
			System.out.println("Error: Negative weight.");
			System.exit(0);
		}
		// no need to use else here
		weight = initialWeight;
	}

	/**
	 * constructor with full arguments
	 */
	public C01Pet(String initialName, int initialAge, double initialWeight) {
		// save the name
		name = initialName;
		// check and its ok save the age and weight
		if ((initialAge < 0) || (initialWeight < 0)) {
			System.out.println("Error: Negative age or weight.");
			System.exit(0);
		}
		// no need to use the else
		age = initialAge;
		weight = initialWeight;
	}

	/**
	 * set method that change set new values
	 */
	public void setPet(String newName, int newAge, double newWeight) {
		// save the name
		name = newName;
		// check and its ok save the age and weight
		if ((newAge < 0) || (newWeight < 0)) {
			System.out.println("Error: Negative age or weight.");
			System.exit(0);
		}
		// no need to use the else
		age = newAge;
		weight = newWeight;
	}

	/**
	 * set name
	 */
	public void setName(String newName) {
		// age and weight are unchanged.
		name = newName;
	}

	/**
	 * set age
	 */
	public void setAge(int newAge) {
		if (newAge < 0) {
			System.out.println("Error: Negative age.");
			System.exit(0);
		}
		// name and weight are unchanged.
		age = newAge;
	}

	/**
	 * set weight
	 */
	public void setWeight(double newWeight) {
		if (newWeight < 0) {
			System.out.println("Error: Negative weight.");
			System.exit(0);
		}
		// name and age are unchanged.
		weight = newWeight;
	}

	/**
	 * get name
	 */
	public String getName() {
		return name;
	}

	/**
	 * get age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * get weight
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * write data to console
	 */
	public void writeOutput() {
		System.out.println("Name: " + name);
		System.out.println("Age: " + age + " years");
		System.out.println("Weight: " + weight + " pounds");
	}
}
