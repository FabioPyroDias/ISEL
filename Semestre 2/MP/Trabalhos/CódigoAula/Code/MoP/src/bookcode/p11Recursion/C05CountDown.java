package bookcode.p11Recursion;

import java.util.Scanner;

/**
 * A recursive call of a method in a class- a not very useful example. Use of
 * recursion to make a cycle. Another second recursive method to print a
 * counting down
 */
public class C05CountDown {

	Scanner keyboard = new Scanner(System.in);

	private int count;

	/**
	 * ask the number, recursively
	 */
	public void getCount() {
		// ask and read an number
		System.out.print("Enter a positive integer: ");
		count = keyboard.nextInt();

		if (count <= 0) {
			System.out.println("Input must be positive.");
			System.out.println("Try again.");
			// start over, recursively
			getCount();
		}

	}

	/**
	 * show count down
	 */
	public void showCountDown() {
		System.out.print("Counting down: ");

		printCountDown(count);

		System.out.println(" Blast Off!");
	}

	/**
	 * auxiliary recursive method to print a count down sequence
	 */
	private void printCountDown(int number) {
		System.out.print(number);
		if (number > 0) {
			System.out.print(", ");
			printCountDown(number - 1);
		}

	}

	/**
	 * main
	 */
	public static void main(String[] args) {

		// create the count down object
		C05CountDown countDowner = new C05CountDown();

		// read the number
		countDowner.getCount();

		// print the count down
		countDowner.showCountDown();
	}
}