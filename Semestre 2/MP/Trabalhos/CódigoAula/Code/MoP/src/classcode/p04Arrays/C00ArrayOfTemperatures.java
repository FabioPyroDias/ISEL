package classcode.p04Arrays;

/**
 * Array variables, array creation and array access reading and writing
 * 
 * Reads 7 temperatures from the user and shows which are above
 * and which are below the average of the 7 temperatures.
 */
import java.util.Scanner;

public class C00ArrayOfTemperatures {

	/**
	 * Main method
	 */
	public static void main(String[] args) {

		// An array initialized with new objects
		// Object[] x = {1, 2, null, null, new Object(), 4};

		// declare temperature as an array of doubles and create an array of 7
		// double and store its reference in the temperature variable
		double[] temperature = new double[7];

		// Read temperatures and compute their average:
		Scanner keyboard = new Scanner(System.in);

		System.out.println("Enter 7 temperatures:");
		double sum = 0;
		for (int index = 0; index < 7; ++index) {
			// read one temperature
			temperature[index] = keyboard.nextDouble();
		}

		// sum values
		for (int index = 0; index < 7; ++index) {
			// add it to total
			sum = sum + temperature[index];
		}

		// calculate the average
		double average = sum / 7;

		// show average
		System.out.println("The average temperature is " + average);

		// Display each temperature and its relation to the average:
		System.out.println("The temperatures are");
		for (int index = 0; index < 7; ++index) {
			// show the correct message
			if (temperature[index] < average)
				System.out.println(temperature[index] + " below average");
			else if (temperature[index] > average)
				System.out.println(temperature[index] + " above average");
			else
				// temperature[index] == average
				System.out.println(temperature[index] + " the average");
		}

		// signal the end of the game
		System.out.println("Have a nice week.");

		// close keyboard
		keyboard.close();
	}
}
