package bookcode.p06MoreAboutObjectsAndMethod;

/**
 * Constructors that calls other constructor. One constructor can call one (and
 * only one) constructor in its first instruction. to call another
 * constructor(of the same class) use this(...)
 * 
 */

public class C04Pet3 {

	private String name;
	private int age;// in years
	private double weight;// in pounds

	// private C01Pet pet; // example of attribute that references a object

	/**
	 * constructor
	 */
	public C04Pet3(String initialName, int initialAge, double initialWeight) {
		set(initialName, initialAge, initialWeight);
	}

	/**
	 * constructor that calls another constructor
	 */
	public C04Pet3(String initialName) {
		// System.out.println(initialName); // not allowed
		this(initialName, 0, 0);
		// System.out.println(initialName); // allowed
	}

	/**
	 * constructor that calls another constructor
	 */
	public C04Pet3(C04Pet3 other) {
		this(other.name, other.age, other.weight);
	}

	/**
	 * constructor that calls another constructor
	 */
	public C04Pet3(int initialAge) {
		this("No name yet.", initialAge, 0);
	}

	/**
	 * constructor that calls another constructor
	 */
	public C04Pet3(double initialWeight) {
		this("No name yet.", 0, initialWeight);
	}

	/**
	 * constructor that calls another constructor
	 */
	public C04Pet3() {
		this("No name yet.", 0, 0);
	}

	// <The rest of the class is like C03Pet2>

	public void setPet(String newName, int newAge, double newWeight) {
		set(newName, newAge, newWeight);
	}

	public void setName(String newName) {
		set(newName, age, weight);// age and weight unchanged
	}

	public void setAge(int newAge) {
		set(name, newAge, weight);// name and weight unchanged
	}

	public void setWeight(double newWeight) {
		set(name, age, newWeight);// name and age unchanged
	}

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

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public double getWeight() {
		return weight;
	}

	public void writeOutput() {
		System.out.println("Name: " + name);
		System.out.println("Age: " + age + " years");
		System.out.println("Weight: " + weight + " pounds");
	}
}