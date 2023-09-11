package bookcode.p05ClassesAndMethods;

/**
 * Instantiable class and instance methods and variables
 * 
 * An instantiable class is a non static class. is a class that we can create
 * instances of the class, that is called an object.
 * 
 * Attributes that are non-static are instance attributes. Every instance of
 * this class, that is one object, have a instance of every instance variables.
 * 
 * One instance method, which is a non static method, can work on instance
 * variables.
 * 
 * Static method can't work on instance attribute, because they are static so
 * they dion't run in a instance context, they run in a global class context, so
 * they can access any instance attribute or instance method. But can access
 * instance attributes or instance method on a particular object.
 * 
 * @author ateofilo - comment author
 * 
 */

// an instantiable class - a non static class
public class C01Dog {

	// instance variables - non static variables
	public String name; // name
	public String breed; // "raça"
	public int age; // age

	// private int i = 10;

	/**
	 * An instance method - a method that can access instance attributes Method
	 * 
	 * Method that writes the object data to the console
	 */
	public void writeOutput() {
		System.out.println("Name: " + name);
		System.out.println("Breed: " + breed);
		System.out.println("Age in calendar years: " + age);
		System.out.println("Age in human years: " + getAgeInHumanYears());
		System.out.println();
	}

	/**
	 * Method that gets the age of the dog in human years
	 * 
	 * @return the age in human years
	 */
	public int getAgeInHumanYears() {
		int humanAge;
		if (age <= 2) {
			humanAge = age * 11;
		} else {
			humanAge = 22 + ((age - 2) * 5);
		}
		return humanAge;
	}
}
