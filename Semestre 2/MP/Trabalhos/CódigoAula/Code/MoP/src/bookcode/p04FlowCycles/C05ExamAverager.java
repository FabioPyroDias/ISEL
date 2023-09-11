package bookcode.p04FlowCycles;

import java.util.*;

/**
 * whiles and do-while together
 * 
 * Determines the average of a list of (nonnegative) exam scores. Repeats for
 * more exams until the user says she/he is finished.
 */
public class C05ExamAverager {

	/**
	 * Main method
	 */
	public static void main(String[] args) {

		// the keyboard reader
		Scanner keyboard = new Scanner(System.in);

		System.out.println("This program computes the average of"
				+ "a list of (nonnegative) exam scores.");

		// variable to have the continue execution or no
		String answer;

		// cycle to process several exams
		do {
			// show information
			System.out.println();
			System.out.println("Enter all the scores to be averaged.");
			System.out.println("Enter a negative number after"
					+ "you have entered all the scores.");

			// sum of scores (notes)
			double sum = 0;
			// the number of students
			int numberOfStudents = 0;

			// read first value
			double next = keyboard.nextDouble();
			// if a correct value, process it
			while (next >= 0) {
				// add it to sum
				sum = sum + next;
				// increase the number o fstudents
				numberOfStudents++;
				// read the next value
				next = keyboard.nextDouble();
			}

			// calculate the average if number of students > 0
			if (numberOfStudents > 0)
				System.out
						.println("The average is " + (sum / numberOfStudents));
			else
				System.out.println("No scores to average.");

			// ask and read if user want to continue
			System.out.println("Want to average another exam?");
			System.out.println("Enter yes or no.");
			answer = keyboard.next();

			// if yes, the do-while will execute the cycle again
		} while (answer.equalsIgnoreCase("yes"));

		System.out.println("End...");

		// close keyboard
		keyboard.close();

	}
}