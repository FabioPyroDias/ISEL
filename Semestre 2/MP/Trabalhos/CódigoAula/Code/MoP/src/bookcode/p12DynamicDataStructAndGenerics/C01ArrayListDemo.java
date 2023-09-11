package bookcode.p12DynamicDataStructAndGenerics;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * ArrayList demo
 */
public class C01ArrayListDemo {

	/**
	 * main
	 */
	public static void main(String[] args) {

		// create an array list
		ArrayList<String> toDoList = new ArrayList<String>();

		System.out.println("Enter items for the list, when prompted.");
		boolean done = false;

		// the keyboard
		Scanner keyboard = new Scanner(System.in);

		// ask and read elements to add to the arrayList
		while (!done) {
			System.out.print("Type an entry -> ");
			String entry = keyboard.nextLine();
			toDoList.add(entry);
			System.out.print("More items for the list (\"no\" to exist)? ");
			String ans = keyboard.nextLine();
			if (ans.equalsIgnoreCase("no"))
				done = true;
		}

		// show the elements
		System.out.println("\nThe list contains:");
		int listSize = toDoList.size();
		for (int position = 0; position < listSize; position++)
			System.out.println(toDoList.get(position));

		// keyboard close
		keyboard.close();
	}
}
