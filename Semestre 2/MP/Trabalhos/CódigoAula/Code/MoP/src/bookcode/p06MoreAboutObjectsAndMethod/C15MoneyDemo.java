package bookcode.p06MoreAboutObjectsAndMethod;

/**
 * Class that teste the Money class that overloads instance methods
 */
public class C15MoneyDemo {

	/**
	 * Main method
	 */
	public static void main(String[] args) {

		C14Money start = new C14Money();
		C14Money goal = new C14Money();

		// ask and read the current savings
		System.out.println("Enter your current savings: ");
		start.readInput();

		// multiply by 2
		goal = start.times(2);
		System.out.print("If you double that, you will have ");
		goal.writeOutput();
		System.out.println(", or better yet:");
		goal = start.add(goal);

		System.out.print("If you triple that original amount, you will have: ");
		goal.writeOutput();
		// End the line, because writeOutput does not end the line.
		System.out.println();

		System.out.println("Remember: A penny saved is a penny earned.");
	}
}
