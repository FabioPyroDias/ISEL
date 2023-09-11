package bookcode.p07Arrays;

import java.util.Scanner;

public class C08ListDemo {

	public static final int MAX_SIZE = 3; // Assumed > 0

	/**
	 * Main method
	 */
	public static void main(String[] args) {

		// keyboard reader
		Scanner keyboard = new Scanner(System.in);

		//the list of Strings
		C09OneWayNoRepeatsList toDoList = new C09OneWayNoRepeatsList(MAX_SIZE);
		
		System.out.println("Enter items for the list, when prompted.");
		boolean moreEntries = true;
		String next = null;

		while (moreEntries && !toDoList.isFull()) {
			// ask and read one item
			System.out.println("Enter an item:");
			next = keyboard.nextLine();
			
			// add the item do the list
			toDoList.addItem(next);
			
			// if list is full
			if (toDoList.isFull()) {
				System.out.println("List is now full.");
			} else {
				System.out.print("More items for the list? ");
				String ans = keyboard.nextLine();
				if (ans.trim().equalsIgnoreCase("no"))
					moreEntries = false; // User says no more
			}
		}
		
		// show the list contents
		System.out.println("The list contains:");
		int position = 1;
		next = toDoList.getEntryAt(position);
		
		// null indicates end of list
		while (next != null) {
			System.out.println(next);
			position++;
			next = toDoList.getEntryAt(position);
		}

		// close keyboard
		keyboard.close();
	}
}
