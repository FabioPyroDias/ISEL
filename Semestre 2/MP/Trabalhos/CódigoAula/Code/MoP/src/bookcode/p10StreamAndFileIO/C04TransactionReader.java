package bookcode.p10StreamAndFileIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Read with a scanner from a file with several items per line
 */
public class C04TransactionReader {

	/**
	 * main
	 */
	public static void main(String[] args) {
		String fileName = "transactions.txt";
		try {
			Scanner inputStream = new Scanner(new File(fileName));
			// Skip the header line by reading and ignoring it
			String line = inputStream.nextLine();
			// Total sales
			double total = 0;
			// Read the rest of the file line by line
			while (inputStream.hasNextLine()) {
				// Contains SKU,Quantity,Price,Description
				line = inputStream.nextLine();
				// Turn the string into an array of strings
				String[] items = line.split(",");
				// Extract each item into an appropriate variable
				String code = items[0].trim();
				int quantity = Integer.parseInt(items[1].trim());
				double price = Double.parseDouble(items[2].trim());
				String description = items[3].trim();
				// Output item
				System.out.printf("Sold %d of %s (code: %s) at "
						+ "$%1.2f each.\n", quantity, description, code, price);
				// Compute total
				total += quantity * price;
			}
			System.out.printf("Total sales: $%1.2f\n", total);
			// close scanner
			inputStream.close();
		} catch (FileNotFoundException e) {
			System.out.println("Cannot find file " + fileName);
		} catch (Exception e) {
			System.out.println("Problem with input from file " + fileName);
		}
	}
}

/**
 * We must create a file name transactions.txt with the following lines:
 * 
 * 4039, 50, 0.99, SODA
 * 
 * 9100, 5, 9.50, T-SHIRT
 * 
 * 1949, 30, 110.00, JAVA PROGRAMMING TEXTBOOK
 * 
 * 5199, 25, 1.50, COOKIE
 */
