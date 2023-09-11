package bookcode.p10StreamAndFileIO;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

/**
 * ObjectInputStream - reading from a file in binary
 */
public class C06BinaryInputDemo {

	// the keyboard
	private static Scanner keyboard = new Scanner(System.in);

	/**
	 * main
	 */
	public static void main(String[] args) {
		String fileName = getFileName("Enter name of input file:");
		try {
			// the binary input stream
			ObjectInputStream inputStream = new ObjectInputStream(
					new FileInputStream(fileName));

			System.out.println("Reading the nonnegative integers"
					+ " in the file " + fileName);

			// reading the numbers in file
			int anInteger = inputStream.readInt();
			while (anInteger >= 0) {
				System.out.println(anInteger);
				anInteger = inputStream.readInt();
			}
			System.out.println("End of reading from file.");

			// closing input stream
			inputStream.close();

		} catch (FileNotFoundException e) {
			System.out.println("Problem opening the file " + fileName);
		} catch (EOFException e) {
			System.out.println("Problem reading the file " + fileName);
			System.out.println("Reached end of the file.");
		} catch (IOException e) {
			System.out.println("Problem reading the file " + fileName);
		}
	}

	/**
	 * get the file name from the keyboard
	 */
	public static String getFileName(String prompt) {
		System.out.print(prompt + " -> ");
		String fileName = keyboard.next();
		return fileName;
	}
}
