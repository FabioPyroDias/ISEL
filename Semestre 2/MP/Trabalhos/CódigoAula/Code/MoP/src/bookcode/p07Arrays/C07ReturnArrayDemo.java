package bookcode.p07Arrays;

import java.util.Scanner;

/**
 * A demonstration of a method that returns an array.
 */
public class C07ReturnArrayDemo {

	/**
	 * Main method
	 */
	public static void main(String[] args) {
		// keyboard reader
		Scanner keyboard = new Scanner(System.in);

		System.out.println("Enter your score on exam 1:");
		int firstScore = keyboard.nextInt();

		// the array to keep the three values scenario
		int[] nextScore = new int[3];

		// / fill the scenario values
		for (int i = 0; i < nextScore.length; i++)
			nextScore[i] = firstScore + 5 * i;

		// get the average of that values
		double[] averageScore = getArrayOfAverages(firstScore, nextScore);

		// show results
		for (int i = 0; i < nextScore.length; i++) {
			System.out.println("If your score on exam 2 is " + nextScore[i]
					+ " your average will be " + averageScore[i]);
		}

		// close keyboard
		keyboard.close();
	}

	/**
	 * calculate the array of averages
	 */
	public static double[] getArrayOfAverages(int firstScore, int[] nextScore) {
		double[] temp = new double[nextScore.length];
		for (int i = 0; i < temp.length; i++)
			temp[i] = getAverage(firstScore, nextScore[i]);
		return temp;
	}

	/**
	 * calculate one average
	 */
	public static double getAverage(int n1, int n2) {
		return (n1 + n2) / 2.0;
	}
}
