package classcode.p01IntroJava;

import java.util.*;

public class C12ScannerDemo3 {

	public static void main(String[] args) {

		// the keyboard reader
		Scanner keyboard = new Scanner(System.in);

		// reading words
		System.out.println("Enter a line of text with three words:");
		String word1 = keyboard.next();
		String word2 = keyboard.next();
		String word3 = keyboard.next();

		// show words read
		System.out.print("With space corrected, you entered: ");
		System.out.println(word1 + " " + word2 + " " + word3);

		// to remove possible extra chars
		keyboard.nextLine();

		// asks, read and show a double
		System.out.println("\nEnter a double (exº: 5,001) :");
		double d = keyboard.nextDouble();
		System.out.println("You entered: " + d);

		// asks, read and show a boolean
		System.out.println("\nEnter a boolean (true or false):");
		boolean b = keyboard.nextBoolean();
		System.out.println("You entered: " + b);

		// close the keyboard
		keyboard.close();
	}
}