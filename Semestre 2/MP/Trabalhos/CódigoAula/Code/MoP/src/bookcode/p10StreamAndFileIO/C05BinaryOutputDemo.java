package bookcode.p10StreamAndFileIO;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * ObjectOutputStream - writing to a file in binary
 */
public class C05BinaryOutputDemo {

	/**
	 * main
	 */
	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);

		String fileName = "numbers.dat";
		try {
			// open an ObjectOutputStream connected to a FileOutputStream
			ObjectOutputStream outputStream = new ObjectOutputStream(
					new FileOutputStream(fileName));

			// asks and read data from the keyboard and write it to the
			// outputStream
			System.out.println("Enter nonnegative integers.");
			System.out.println("Place a negative number at the " + "end.");
			int anInteger;

			// read several integers from the keyboard
			do {
				anInteger = keyboard.nextInt();
				// write it as an int in binary
				outputStream.writeInt(anInteger);
			} while (anInteger >= 0);

			System.out.println("Numbers and sentinel value"
					+ " written to the file " + fileName);

			// close the outputStream
			outputStream.close();

		} catch (FileNotFoundException e) {
			System.out.println("Problem opening the file " + fileName);
		} catch (IOException e) {
			System.out.println("Problem with output to file " + fileName);
		}

		// close keyboard
		keyboard.close();
	}
}
