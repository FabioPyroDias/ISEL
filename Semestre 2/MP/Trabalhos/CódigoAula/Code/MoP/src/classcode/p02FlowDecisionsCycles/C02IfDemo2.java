package classcode.p02FlowDecisionsCycles;

import java.util.Scanner;

public class C02IfDemo2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// the keyboard reader
		Scanner keyboard = new Scanner(System.in);

		// ask and read an integer
		System.out.print("Introduza um número inteiro: ");
		int num = keyboard.nextInt();

		// if without else part
		if (num >= 0)
			System.out.println("O número " + num + " é um número positivo");

		// close the keyboard
		keyboard.close();
	}

}
