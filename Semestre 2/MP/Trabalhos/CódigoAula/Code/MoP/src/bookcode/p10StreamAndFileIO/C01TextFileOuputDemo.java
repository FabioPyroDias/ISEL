package bookcode.p10StreamAndFileIO;

import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * OutputStream - write data to a file
 */
public class C01TextFileOuputDemo {

	/**
	 * main
	 */
	public static void main(String[] args) {
		// The name could be read from the keyboard.
		String fileName = "out.txt";

		PrintWriter outputStream = null;
		try {
			// open the file
			outputStream = new PrintWriter(fileName);
		} catch (FileNotFoundException e) {
			// if exception occurred exit program
			System.out.println("Error opening the file" + fileName);
			System.exit(0);
		}

		// read three line of data and write them to file
		System.out.println("Enter three lines of text:");
		Scanner keyboard = new Scanner(System.in);
		for (int count = 1; count <= 3; count++) {
			System.out.print("Line " + count + " -> ");
			String line = keyboard.nextLine();
			// write line to file
			outputStream.println(count + " " + line);
		}

		// close output stream
		outputStream.close();

		System.out.println("Those lines were written to " + fileName);

		// close keyboard
		keyboard.close();
	}
}
