package classcode.p05Recursion;

import java.util.Scanner;

/**
 * Conta quantos bits a 1 existem num inteiro
 * 
 * Sugestão: método recursivo para mostrar os bits de um inteiro
 * 
 * @author ateofilo
 * 
 */
public class C02Nums {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// the keyboard reader
		Scanner keyboard = new Scanner(System.in);

		System.out.println("Teste a algoritmos recursivos...");
		System.out.print("Introduza um inteiro positivo -> ");
		int number = keyboard.nextInt();

		// Count down
		System.out.print("Count down de " + number + " -> ");
		countDown(number);
		System.out.println();

		// Count up
		System.out.print("Count up de " + number + " -> ");
		countUp(number);
		System.out.println();

		// close keyboard
		keyboard.close();
	}

	/**
	 * Prints a count down
	 */
	public static void countDown(int n) {
		// stop case
		if (n <= 0)
			return;
		// write num
		System.out.print(n + " ");
		// do count down (n -1)
		countDown(n - 1);
	}

	/**
	 * Prints a count up
	 */
	public static void countUp(int n) {
		// stop case
		if (n <= 0)
			return;
		// do count up(n-1)
		countUp(n - 1);
		// write num
		System.out.print(n + " ");
	}

}
