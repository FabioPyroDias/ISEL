package bookcode.p03FlowDecisions;

import java.util.*;

/**
 * shows the problem of comparing string with "=="
 * 
 * @author ateofilo
 * 
 */
public class C02StringEqualityDemo {

	/**
	 * the main method
	 */
	public static void main(String[] args) {

		// keybard reader
		Scanner keyboard = new Scanner(System.in);

		// read two lines
		System.out.print("Enter the first line of text : ");
		String l1 = keyboard.nextLine();
		System.out.print("Enter teh second line of text: ");
		String l2 = keyboard.nextLine();

		// show the lines
		System.out.println("\n" + "Line 1 -> " + l1);
		System.out.println("Line 2 -> " + l2 + "\n");

		// compare them by equals
		boolean l1equalsl2 = l1.equals(l2);
		System.out.println("l1.equals(l2) -> " + l1equalsl2);
		System.out.println("l2.equals(l1) -> " + l2.equals(l1));

		// compare them by equalsIgnoreCase
		System.out.println("l1.equalsIgnoreCase(l2) -> "
				+ l1.equalsIgnoreCase(l2));

		// compare them by ==
		System.out.println("l1 == l2 -> " + (l1 == l2));

		// close keyboard
		keyboard.close();
	}
}
