package bookcode.p10StreamAndFileIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Serialisation of an array
 */
public class C11ArrayIODemo {

	/**
	 * main
	 */
	public static void main(String[] args) {

		// the array and its data
		C09Species[] oneArray = new C09Species[2];
		oneArray[0] = new C09Species("Calif. Condor", 27, 0.02);
		oneArray[1] = new C09Species("Black Rhino", 100, 1.0);

		// file name and open output object stream
		String fileName = "array.dat";
		try {

			// open object stream
			ObjectOutputStream outputStream = new ObjectOutputStream(
					new FileOutputStream(fileName));

			// write array directly
			outputStream.writeObject(oneArray);

			// close stream
			outputStream.close();
		} catch (IOException e) {
			System.out.println("Error writing to file " + fileName + ".");
			System.exit(0);
		}

		System.out.println("Array written to file " + fileName
				+ " and file is closed.");

		//
		// read the serialised array
		//

		System.out.println("\nOpen the file for input and echo the array.");

		// open the inout file stream connected to the same file
		C09Species[] anotherArray = null;
		try {
			ObjectInputStream inputStream = new ObjectInputStream(
					new FileInputStream(fileName));

			// read the array and all its objects, in just one call
			anotherArray = (C09Species[]) inputStream.readObject();

			// closing the stream
			inputStream.close();
		} catch (Exception e) {
			System.out.println("Error reading file " + fileName + ".");
			System.exit(0);
		}

		// showing the data
		System.out.println("\nThe following were read from " + "the file "
				+ fileName + ":\n");
		for (int i = 0; i < anotherArray.length; i++) {
			System.out.println(anotherArray[i]);
			System.out.println();
		}
		System.out.println("End of program.");
	}
}
