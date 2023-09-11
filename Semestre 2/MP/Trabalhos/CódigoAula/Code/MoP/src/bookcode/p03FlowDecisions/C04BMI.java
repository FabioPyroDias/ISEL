package bookcode.p03FlowDecisions;

import java.util.Scanner;

/**
 * Body Mass Index - BMI
 * 
 * Multiple Ifs
 * 
 */
public class C04BMI {

	public static void main(String[] args) {

		// the keyboard reader
		Scanner keyboard = new Scanner(System.in);
		int pounds, feet, inches;
		double heightMeters, mass, BMI;

		// ask for weight
		System.out.println("Enter your weight in pounds.");
		pounds = keyboard.nextInt();

		// ask for height
		System.out.println("Enter your height in feet followed by a space"
				+ " then additional inches.");
		feet = keyboard.nextInt();
		inches = keyboard.nextInt();

		// calculate BMI
		heightMeters = ((feet * 12) + inches) * 0.0254;
		mass = (pounds / 2.2);
		BMI = mass / (heightMeters * heightMeters);

		// show BMI
		System.out.println("Your BMI is " + BMI);

		// show risk
		System.out.print("\nYour risk category is ");
		if (BMI < 18.5)
			System.out.println("Underweight.");
		else if (BMI < 25)
			System.out.println("Normal weight.");
		else if (BMI < 30)
			System.out.println("Overweight.");
		else
			System.out.println("Obese.");

		// close keyboard
		keyboard.close();
	}
}
