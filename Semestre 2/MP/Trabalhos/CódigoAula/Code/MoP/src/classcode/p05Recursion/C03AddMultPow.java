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
public class C03AddMultPow {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// int j = 0;
		//
		// int k = 20 / j;
		//
		// System.out.println(k);

		// the keyboard reader
		Scanner keyboard = new Scanner(System.in);

		System.out.println("Teste a algoritmos recursivos...");
		System.out.print("Introduza um inteiro positivo -> ");
		int number1 = keyboard.nextInt();

		System.out.print("Introduza outro inteiro positivo -> ");
		int number2 = keyboard.nextInt();

		// add
		int result = add(number1, number2);
		System.out.print("Add(" + number1 + "," + number2 + ") -> " + result);
		System.out.println();

		// mult
		result = mult(number1, number2);
		System.out.print("Mult(" + number1 + "," + number2 + ") -> " + result);
		System.out.println();

		// pow
		result = pow(number1, number2);
		System.out.print("Pow(" + number1 + "," + number2 + ") -> " + result);
		System.out.println();

		// close keyboard
		keyboard.close();
	}

	/**
	 * Recursive addition by increments and decrements
	 */
	public static int add(int a, int b) {
	
		// stop case
		if (b == 0)
			return a;

		if (b > 0)
			return add(a + 1, b - 1);

		// b < 0
		return add(a - 1, b + 1);
	}

	/**
	 * Recursive multiplication by adds and subtractions
	 */
	public static int mult(int a, int b) {

		// stop case
		if (a == 0 || b == 0)
			return 0;

		if (b > 0)
			return a + mult(a, b - 1);

		// b < 0
		return -(a + mult(a, -b - 1));
	}

	/**
	 * Recursive multiplication by adds and subtractions
	 * 
	 * @param exp
	 *            must be positive
	 */
	public static int pow(int base, int exp) {

		// if negative argument throw exception
		if (exp < 0)
			throw new IllegalArgumentException(
					"Pow: foi recebido um expoente negativo: " + exp);

		// stop case
		if (exp == 0)
			return 1;

		// recursion
		return base * pow(base, exp - 1);

	}
}
