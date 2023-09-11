package bookcode.p06MoreAboutObjectsAndMethod;

/**
 * Constructor that reuse the set methods
 * 
 */

public class C03Pet2 {

	private String name;
	private int age;// in years
	private double weight;// in pounds

	/**
	 * constructor
	 */
	public C03Pet2(String initialName, int initialAge, double initialWeight) {
		set(initialName, initialAge, initialWeight);
	}

	/**
	 * constructor
	 */
	public C03Pet2(String initialName) {
		set(initialName, 0, 0);
	}

	/**
	 * constructor
	 */
	public C03Pet2(int initialAge) {
		set("No name yet.", initialAge, 0);
	}

	/**
	 * constructor
	 */
	public C03Pet2(double initialWeight) {
		set("No name yet.", 0, initialWeight);
	}

	/**
	 * constructor
	 */
	public C03Pet2() {
		set("No name yet.", 0, 0);
	}

	/**
	 * set all data
	 */
	public void setPet(String newName, int newAge, double newWeight) {
		set(newName, newAge, newWeight);
	}

	/**
	 * set name
	 */
	public void setName(String newName) {
		set(newName, age, weight);// age and weight unchanged
	}

	/**
	 * set age
	 */
	public void setAge(int newAge) {
		set(name, newAge, weight);// name and weight unchanged
	}

	/**
	 * set weight
	 */
	public void setWeight(double newWeight) {
		set(name, age, newWeight);// name and age unchanged
	}

	/**
	 * set all data
	 */
	private void set(String newName, int newAge, double newWeight) {
		name = newName;
		if ((newAge < 0) || (newWeight < 0)) {
			System.out.println("Error: Negative age or weight.");
			System.exit(0);
		} else {
			age = newAge;
			weight = newWeight;
		}
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
	 * write output
	 */
	public void writeOutput() {
		System.out.println("Name: " + name);
		System.out.println("Age: " + age + " years");
		System.out.println("Weight: " + weight + " pounds");
	}
}
