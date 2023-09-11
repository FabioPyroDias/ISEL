package bookcode.p04FlowCycles;

import java.util.*;

/**
 * WHile demo
 * 
 */
public class C01WhileDemo {

	/**
	 * Main method
	 */
	public static void main(String[] args) {

		// the keyboard reader
		Scanner keyboard = new Scanner(System.in);

		// ask and read a number
		System.out.print("Enter a number -> ");
		int number = keyboard.nextInt();

		// Initialize the counter to 1
		int count = 1;
		// execution of a while: test expression, if true execute body, return
		// to the test
		while (count <= number) {
			// print the count
			System.out.print(count);
			// if the count is the last one, don't put the "coma"
			if (count < number)
				System.out.print(", ");
			// increase the count
			count++;
		}

		// put end of line
		System.out.println();
		// just say goodbye
		System.out.println("End");

		// close keyboard
		keyboard.close();
	}

}