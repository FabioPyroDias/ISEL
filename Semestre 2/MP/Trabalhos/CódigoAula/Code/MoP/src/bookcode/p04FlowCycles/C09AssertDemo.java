package bookcode.p04FlowCycles;

import java.util.Scanner;

/**
 * Assert - assertions enables us to put checks in the code that results in a
 * false evaluation it results in AssertionError
 */

/**
 * Primeiro executar uma vez a aplicaçao. Colocar -enableassertions nos
 * argumentos da VM. No icon circular de Run, Escolher Run Configuration,
 * escolher Java Application e escolher a C09AssertDemo, ir a Arguments, em "VM
 * arguments" colocar: -enableassertions. Voltar a testar com um número
 * negativo.
 */
public class C09AssertDemo {

	/**
	 * Main method
	 */

	public static void main(String[] args) {

		// the keyboard reader
		Scanner keyboard = new Scanner(System.in);

		System.out.print("Introduza um número positivo -> ");
		int n = keyboard.nextInt();

		// execute a fatal test, the condition should evaluate to true to
		// continue
		assert n > 1 : "n have a negative value: " + n;

		// show the result
		System.out.println("O valor introduzido foi -> " + n);

		// close keyboard
		keyboard.close();
	}
}
