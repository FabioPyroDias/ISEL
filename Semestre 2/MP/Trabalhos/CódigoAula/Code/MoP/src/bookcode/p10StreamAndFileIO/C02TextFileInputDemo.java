package bookcode.p10StreamAndFileIO;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * File reading by scanner
 */
public class C02TextFileInputDemo {

	/**
	 * main
	 */
	public static void main(String[] args) {
		// the file name
		String fileName = "out.txt";

		Scanner inputStream = null;

		System.out.println("The file " + fileName
				+ "\ncontains the following lines:\n");

		try {
			// use a scanner to read from the file
			inputStream = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			System.out.println("Error opening the file " + fileName);
			System.exit(0);
		}

		// we will read from the file as if like reading from the keyboard
		while (inputStream.hasNextLine()) {
			String line = inputStream.nextLine();
			System.out.println(line);
		}

		// close the scanner that is connected to the file
		inputStream.close();
	}
}
