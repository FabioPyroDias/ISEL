package classcode.p02FlowDecisionsCycles;

import java.util.Scanner;

/**
 * for demo, continue demo
 * 
 */
public class C14forContinue2 {

	/**
	 * main method - ler 10 inteiros e calcular a sua média dos positivos
	 * */
	public static void main(String[] args) {
		// the keyboard reader
		Scanner keyboard = new Scanner(System.in);

		int sum = 0, nPositiveNumbers = 0;

		// read 10 positive integers
		for (int i = 0; i < 10; i++) {
			// read a positive > 0 number
			System.out.print("Introduza o número nº " + (i + 1) + " -> ");
			int number = keyboard.nextInt();
			if (number < 0) {
				continue;
			}
			
			// adicionar o nº para calcular a média
			sum += number;
			++nPositiveNumbers;
		}

		// show a count up
		if(nPositiveNumbers >=0)
		System.out.print("A média dos números introduzidos é -> " + (sum / nPositiveNumbers));
		else
			System.out.print("Foram introduzidos 0 número positivos.");

		// close the keyboard
		keyboard.close();
		
	}
}
