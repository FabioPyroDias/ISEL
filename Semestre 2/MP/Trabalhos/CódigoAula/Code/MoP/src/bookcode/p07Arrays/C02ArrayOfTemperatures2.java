package bookcode.p07Arrays;

/**
 Reads temperatures from the user and shows which are above
 and which are below the average of all the temperatures.
 First asks for the desired number of temperatures.
 Creates a array with size chosen by the user
 */
import java.util.Scanner;

public class C02ArrayOfTemperatures2 {

	/**
	 * Main method
	 */
	public static void main(String[] args) {

		// the keyboard reader
		Scanner keyboard = new Scanner(System.in);

		// ask and read the number of temperatures
		System.out.println("How many temperatures do you have (minimun of 1)?");
		int size = keyboard.nextInt();

		if (size <= 1) {
			System.out.println("Wrong number of temperatures: " + size);
			System.exit(0);
		}

		// creates the array with the correct size
		double[] temperature = new double[size];

		// Read temperatures and compute their average:
		System.out.println("Enter " + temperature.length + " temperatures:");
		double sum = 0;
		for (int index = 0; index < temperature.length; index++) {
			temperature[index] = keyboard.nextDouble();
			sum = sum + temperature[index];
		}
		double average = sum / temperature.length;
		System.out.println("The average temperature is " + average);

		// Display each temperature and its relation to the
		// average:
		System.out.println("The temperatures are");
		for (int index = 0; index < temperature.length; index++) {
			if (temperature[index] < average)
				System.out.println(temperature[index] + " below average");
			else if (temperature[index] > average)
				System.out.println(temperature[index] + " above average");
			else
				// temperature[index] == average
				System.out.println(temperature[index] + " the average");
		}
		System.out.println("Have a nice week.");

		// close keyboard
		keyboard.close();
	}
}
