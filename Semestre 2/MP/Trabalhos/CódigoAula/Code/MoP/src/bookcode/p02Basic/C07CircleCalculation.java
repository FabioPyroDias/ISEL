package bookcode.p02Basic;

import java.util.*;

/**
 * Program to determine area of a circle. Author: Jane Q. Programmer. E-mail
 * Address: janeq@somemachine.etc.etc. Programming Assignment 2. Last Changed:
 * October 7, 2006.
 */

public class C07CircleCalculation {

	public static void main(String[] args) {

		// keyboard reader
		Scanner keyboard = new Scanner(System.in);

		double radius; // in inches
		double area; // in square inches

		// ask the radius
		System.out.print("Enter the radius of a circle in inches: ");
		radius = keyboard.nextDouble();

		// calculate area
		area = 3.14159 * radius * radius;

		// output data
		System.out.println("A circle of radius " + radius + " inches");
		System.out.println("has an area of " + area + " square inches.");

		// close keyboard
		keyboard.close();
	}
}
