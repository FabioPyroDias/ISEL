package bookcode.p10StreamAndFileIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Object serialisation and des-serialization
 */
public class C10ClassObjectIODemo {

	/**
	 * main
	 */
	public static void main(String[] args) {

		ObjectOutputStream outputStream = null;
		String fileName = "species_records.dat";

		// open an ObjectOutputStream
		try {
			outputStream = new ObjectOutputStream(
					new FileOutputStream(fileName));
		} catch (IOException e) {
			System.out.println("Error opening output file " + fileName);
			System.exit(0);
		}

		// create two objects
		C09Species califCondor = new C09Species("Calif. Condor", 27, 0.02);
		C09Species blackRhino = new C09Species("Black Rhino", 100, 1.0);

		// serialise the object to the stream
		try {
			outputStream.writeObject(califCondor);
			outputStream.writeObject(blackRhino);
			outputStream.close();
		} catch (IOException e) {
			System.out.println("Error writing to file " + fileName);
			System.exit(0);
		}

		System.out.println("Records sent to file " + fileName);
		System.out.println("\nNow let's reopen the file and echo "
				+ "the records.");

		//
		// now we will do the reverse -read the objects from the stream
		//

		// open the input Stream
		ObjectInputStream inputStream = null;
		try {
			inputStream = new ObjectInputStream(new FileInputStream(
					"species.records"));
		} catch (IOException e) {
			System.out.println("Error opening input file " + fileName);
			System.exit(0);
		}

		// read the two objects, des-serialise them
		C09Species readOne = null, readTwo = null;
		try {
			// read one object - the first that has serialised
			readOne = (C09Species) inputStream.readObject();
			// read the second object
			readTwo = (C09Species) inputStream.readObject();

			// close the input stream
			inputStream.close();
		} catch (Exception e) {
			System.out.println("Error reading from file " + fileName);
			System.exit(0);
		}

		// show the two object read
		System.out.println("\nThe following were read from the file "
				+ fileName);
		System.out.println(readOne);
		System.out.println();
		System.out.println(readTwo);
		System.out.println("End of program.");
	}
}
