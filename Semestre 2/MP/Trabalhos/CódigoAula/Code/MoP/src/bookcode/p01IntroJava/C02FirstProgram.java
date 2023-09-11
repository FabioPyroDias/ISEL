package bookcode.p01IntroJava;

import java.util.Scanner;

/**
 * A program that show output, read data, and do some calculation
 * 
 */
public class C02FirstProgram {

	public static void main(String[] args) {

		// the object that reads from the keyboard
		Scanner keyboard = new Scanner(System.in);

		// Ask for data
		System.out.println("Hello out there.");
		System.out.println("I will add two numbers for you.");
		System.out.println("Enter two whole numbers on a line:");

		// Declare variables
		int n1, n2;

		// input data
		n1 = keyboard.nextInt();
		n2 = keyboard.nextInt();

		int result = n1 + n2;

		// output results
		System.out.println("The sum of those two numbers is");
		System.out.println(result);

		// close keyboard
		keyboard.close();
	}
}
