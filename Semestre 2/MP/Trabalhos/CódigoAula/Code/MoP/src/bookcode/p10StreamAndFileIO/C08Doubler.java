package bookcode.p10StreamAndFileIO;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Writing and reading binary data with ObjectStreams
 */
public class C08Doubler {

	// the streams references
	private ObjectInputStream inputStream = null;
	private ObjectOutputStream outputStream = null;

	/**
	 * Doubles the integers in one file and puts them in another file.
	 */
	/**
	 * main
	 */
	public static void main(String[] args) {
		C08Doubler twoTimer = new C08Doubler();
		twoTimer.connectToInputFile();
		twoTimer.connectToOutputFile();
		twoTimer.timesTwo();
		twoTimer.closeFiles();
		System.out
				.println("Numbers from input file doubled and copied to output file.");
	}

	/**
	 * get input file name and open it
	 */
	public void connectToInputFile() {
		String inputFileName = C06BinaryInputDemo
				.getFileName("Enter name of input file:");
		try {
			inputStream = new ObjectInputStream(new FileInputStream(
					inputFileName));
		} catch (FileNotFoundException e) {
			System.out.println("File " + inputFileName + " not found.");
			System.exit(0);
		} catch (IOException e) {
			System.out.println("Error opening input file" + inputFileName);
			System.exit(0);
		}
	}

	/**
	 * get output file name and open it
	 */
	public void connectToOutputFile() {
		String outputFileName = C06BinaryInputDemo
				.getFileName("Enter name of output file:");
		try {
			outputStream = new ObjectOutputStream(new FileOutputStream(
					outputFileName));
		} catch (IOException e) {
			System.out.println("Erroropeningoutputfile" + outputFileName);
			System.out.println(e.getMessage());
			System.exit(0);
		}
	}

	/**
	 * read int, multiply it by 2, and write it to output file
	 */
	public void timesTwo() {
		try {
			while (true) {
				// read int
				int next = inputStream.readInt();
				// multiply it by 2, write to file
				outputStream.writeInt(2 * next);
			}

		} catch (EOFException e) {
			// Do nothing. This just ends the loop.
		} catch (IOException e) {
			System.out.println("Error: reading or writing files.");
			System.out.println(e.getMessage());
			System.exit(0);
		}
	}

	/**
	 * close files
	 */
	public void closeFiles() {
		try {
			inputStream.close();
			outputStream.close();
		} catch (IOException e) {
			System.out.println("Error closing files " + e.getMessage());
			System.exit(0);
		}
	}
}