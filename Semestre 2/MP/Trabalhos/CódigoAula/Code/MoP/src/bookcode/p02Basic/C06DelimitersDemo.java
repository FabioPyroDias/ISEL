package bookcode.p02Basic;

import java.util.Scanner;

public class C06DelimitersDemo {

	public static void main(String[] args) {

		// The delimiters for keyboard are the whitespace
		// characters.
		Scanner keyboard = new Scanner(System.in);

		// testing keyboard
		System.out.print("Enter a line of text with two words:");
		String s1 = keyboard.next();
		String s2 = keyboard.next();
		System.out.println("The two words are \"" + s1 + "\" and \"" + s2
				+ "\"");

		System.out.println();

		// testing keyboard with delimiter '##'
		System.out.print("Enter a line of text with two words"
				+ "delimited by ##:");
		keyboard.useDelimiter("##");
		s1 = keyboard.next();
		s2 = keyboard.next();
		System.out.println("The two words are \"" + s1 + "\" and \"" + s2
				+ "\"");

		// close keyboard 1
		keyboard.close();
	}
}