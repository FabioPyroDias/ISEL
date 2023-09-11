package bookcode.p03FlowDecisions;

import java.util.Scanner;

/**
 * Multiple ifs demo
 * 
 */
public class C03Grader {

	public static void main(String[] args) {

		// the keyboard reader
		Scanner keyboard = new Scanner(System.in);

		char grade;

		// read the score
		System.out.print("Enter your score: ");
		int score = keyboard.nextInt();

		// determine the grade
		if (score >= 90)
			grade = 'A';
		else if (score >= 80)
			grade = 'B';
		else if (score >= 70)
			grade = 'C';
		else if (score >= 60)
			grade = 'D';
		else
			grade = 'F';

		// show results
		System.out.println("Score = " + score);
		System.out.println("Grade = " + grade);

		// close keyboard
		keyboard.close();
	}
}
