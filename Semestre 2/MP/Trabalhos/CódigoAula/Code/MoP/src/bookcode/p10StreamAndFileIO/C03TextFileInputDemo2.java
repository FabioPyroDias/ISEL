package bookcode.p10StreamAndFileIO;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Same program, but asking and reading the file name from the keyboard
 */
public class C03TextFileInputDemo2 {

	/**
	 * main
	 */
	public static void main(String[] args) {

		// ask the file name
		System.out.print("Enter file name: ");
		Scanner keyboard = new Scanner(System.in);
		String fileName = keyboard.next();

		Scanner inputStream = null;
		System.out.println("The file " + fileName + "\n"
				+ "contains the following lines:\n");

		// open scanner
		try {
			inputStream = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			System.out.println("Error opening the file " + fileName);
			System.exit(0);
		}

		// read data
		while (inputStream.hasNextLine()) {
			String line = inputStream.nextLine();
			System.out.println(line);
		}

		// close scanner
		inputStream.close();

		// close keyboard
		keyboard.close();
	}
}