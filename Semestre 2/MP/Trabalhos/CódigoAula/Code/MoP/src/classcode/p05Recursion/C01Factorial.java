package classcode.p05Recursion;

import java.util.Scanner;

/**
 * Cálculo do factorial de forma recursiva.
 * 
 * Sugestão: fazer outro método que imprima na consola: factorial(5) = 5 * 4 * 3
 * * 2 * 1 = 120
 * 
 * @author ateofilo
 * 
 */
public class C01Factorial {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);

		System.out.println("Cálculo do factorial...");
		System.out.print("Introduza um inteiro positivo -> ");
		int number = keyboard.nextInt();

		// cálculo do factorial de forma recursiva
		int result = factorial(number);
		System.out.println("O factorial recursivo de " + number + " é -> "
				+ result);

		// cálculo do factorial de forma iterativa
		result = factorialIterativo(number);

		System.out.println("O factorial iterativo de " + number + " é -> "
				+ result);

		keyboard.close();
	}

	/**
	 * Factorial de forma recursiva
	 */
	public static int factorial(int n) {

		// if negative argument throw exception
		if (n < 0)
			throw new IllegalArgumentException(
					"Factorial: foi recebido um argumento negativo: " + n);

		// factorial(0) = 1
		if (n == 0)
			return 1;

		// factorial(n) = n * factorial(n-1)
		int result = n * factorial(n - 1);

		// return the result
		return result;
	}

	/**
	 * factorial de forma iterativa
	 */
	public static int factorialIterativo(int n) {

		// if negative argument throw exception
		if (n < 0)
			throw new IllegalArgumentException(
					"Factorial iterativo: foi recebido um argumento negativo: "
							+ n);

		// the cumulative variable, fact(0) = 1
		int fact = 1;

		// do calculation for values between 1 and n
		for (int i = 1; i <= n; i++) {
			// fact = fact * i
			fact *= i;
		}

		// return cumulative value
		return fact;
	}
}
