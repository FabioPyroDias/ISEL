package bookcode.p10StreamAndFileIO;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * ObjectInputStream - reading from a file in binary. Dealing with EOF.
 */
public class C07EOFExceptionDemo {

	/**
	 * main
	 */
	public static void main(String[] args) {
		String fileName = "numbers.dat";
		try {
			// open the inputStream
			ObjectInputStream inputStream = new ObjectInputStream(
					new FileInputStream(fileName));

			System.out.println("Reading ALL the integers in the file "
					+ fileName);
			// reading data from file
			try {
				// the while will finish when we read the end of file.
				// reading the EOF will launch an exception
				while (true) {
					int anInteger = inputStream.readInt();
					System.out.println(anInteger);
				}

			} catch (EOFException e) {
				// no problem, we just reach the end of file
				System.out.println("End of reading from file.");
			}

			// close the input stream
			inputStream.close();

		} // deal with other exceptions
		catch (FileNotFoundException e) {
			System.out.println("Cannot find file " + fileName);
		} catch (IOException e) {
			System.out.println("Problem with input from file " + fileName);
		}
	}
}
