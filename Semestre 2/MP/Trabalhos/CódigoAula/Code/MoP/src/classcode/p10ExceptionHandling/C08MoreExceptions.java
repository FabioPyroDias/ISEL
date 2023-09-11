package classcode.p10ExceptionHandling;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Apanhar várias excepções e diferenciar o seu tratamento por vários blocos de
 * catch. Para experimentar um teste retirar o respectivo comentário
 */
public class C08MoreExceptions {
	int value = 0;

	/**
	 * main
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		System.out.println("Realizacao da operacao de divisao...");

		try {
			System.out.print("Introduza o dividendo -> ");
			int dividendo = keyboard.nextInt();
			//
			// System.out.print("Introduza o divisor -> ");
			// int divisor = input.nextInt();

			// realizar a processamento
			// int quociente = dividendo / divisor;

			// mostrar resultado
			// System.out.println("Divisao de " + dividendo + " por " + divisor
			// + " -> " + quociente);

			C08MoreExceptions obj = null;
			// obj.value = 10; // teste 1

			int[] vect = null;
			// int l = vect.length; // teste 2
			// vect = new int[-1]; // teste 3

			vect = new int[10];
			// vect[10] = 0; // teste 4

			C06SeveralCatchs o = new C06SeveralCatchs();
			// obj = (C08MoreExceptions) (Object) o; // teste 5

			int[] array = new int[10];
			// array[10] = 10; // teste 5
			// array[-1] = 10; // teste 6

			int x = "Ola".charAt(20); // teste 7

		} catch (ArithmeticException e) {
			System.err.println("Ocorreu a excepcao de divisão por zero: "
					+ e.getMessage());
		} catch (InputMismatchException e) {
			System.err.println("Ocorreu a excepcao de Input Mismatch: " + e);
		} catch (NullPointerException e) {
			System.err.println("Ocorreu a excepcao NPE: "
					+ e.getClass().getSimpleName() + ": " + e.getMessage());
		} catch (Exception e) {
			System.err.println("Ocorreu a excepcao: " + e.getClass() + ": "
					+ e.getMessage());
		}
		// experimentar descomentar o seguinte bloco de instruções
		// verificar o que sucede - ler bem.

		// catch (ClassCastException e) {
		// System.out.println("Ocorreu a excepcao: "
		// + e.getClass().getSimpleName() + ": " + e.getMessage());
		// }
		
		keyboard.close();
	}
	// Será possível definir excepções minhas??
	// Que sejam objectos que eu controle??
}
