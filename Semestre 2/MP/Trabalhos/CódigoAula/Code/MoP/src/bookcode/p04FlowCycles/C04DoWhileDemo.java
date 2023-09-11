package bookcode.p04FlowCycles;

import java.util.*;

/**
 * Do-while demo. Um do-while primeiro executa o body, depois testa a expressão,
 * se for true volta à execução do corp.o
 * 
 */
public class C04DoWhileDemo {

	/**
	 * Main method
	 */
	public static void main(String[] args) {

		// the keyboard reader
		Scanner keyboard = new Scanner(System.in);

		// ask and read a number
		System.out.println("Enter a number");
		int number = keyboard.nextInt();

		// write from count == 1 to number
		int count = 1;
		do {
			// write count
			System.out.print(count + ", ");
			// increase count
			count++;
			// check it continues or not
		} while (count <= number);

		// show results
		System.out.println();
		System.out.println("End");

		// close keyboard
		keyboard.close();
	}
}