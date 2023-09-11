package bookcode.p02Basic;

import java.util.Scanner;

public class C08CircleCalculator2 {

	// declaration of a final variable
	public static final double PI = 3.14159;

	/**
	 * main method
	 */
	public static void main(String[] args) {

		// keyboard reader
		Scanner keyboard = new Scanner(System.in);

		// variables
		double radius; // in inches
		double area; // in square inches

		// ask the radius
		System.out.print("Enter the radius of a circle in inches: ");
		radius = keyboard.nextDouble();

		// calculate area
		area = PI * radius * radius;

		// show results
		System.out.println("A circle of radius " + radius + " inches");
		System.out.println("has an area of " + area + " square inches.");

		// close keyboard
		keyboard.close();

	}
}
