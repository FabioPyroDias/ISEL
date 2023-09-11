package bookcode.p07Arrays;

import java.util.Scanner;

/**
 * A demonstration of using indexed variables as arguments. Three possible
 * scenarios.
 */
public class C05ArgumentDemo {

	/**
	 * Main method
	 */
	public static void main(String[] args) {

		// keyboard reader
		Scanner keyboard = new Scanner(System.in);

		System.out.println("Enter your score on exam 1:");
		int firstScore = keyboard.nextInt();

		// present three scenarios
		int[] nextScore = new int[3];

		// fill the scenarios
		for (int i = 0; i < nextScore.length; i++)
			nextScore[i] = firstScore + 5 * i;

		// present data to user
		for (int i = 0; i < nextScore.length; i++) {
			double possibleAverage = getAverage(firstScore, nextScore[i]);
			System.out.println("If your score on exam 2 is " + nextScore[i]
					+ " your average will be " + possibleAverage);
		}

		// close keyboard
		keyboard.close();
	}

	public static double getAverage(int n1, int n2) {
		return (n1 + n2) / 2.0;
	}
}
