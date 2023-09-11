package classcode.p02FlowDecisionsCycles;

import java.util.Scanner;

/**
 * for demo
 */
public class C13forDemo1 {

	/**
	 * main method
	 */
	public static void main(String[] args) {
		// the keyboard reader
		Scanner keyboard = new Scanner(System.in);

		// ask the number of integers to read
		System.out
				.print("Introduza o número de números para calcular a média -> ");
		int nNumbersToRead = keyboard.nextInt();

		// the total
		int total = 0;

		// check if we have something to do
		if (nNumbersToRead == 0) {
			System.out
					.println("Não é possível calcular a média de 0 números!!!");
		} else {

			// read the numbers
			for (int nNumbersRead = 0; nNumbersRead < nNumbersToRead; ++nNumbersRead) {

				// ask and read one number
				System.out.print("Introduza um inteiro -> ");
				int value = keyboard.nextInt();

				// add it to total
				total += value;
			}

			// show the average of them
			System.out.println("A média dos números é -> " + total
					/ nNumbersToRead);
		}

		// close the keyboard
		keyboard.close();
	}
}
