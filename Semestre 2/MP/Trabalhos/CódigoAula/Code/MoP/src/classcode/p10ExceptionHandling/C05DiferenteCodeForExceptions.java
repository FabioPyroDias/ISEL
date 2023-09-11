package classcode.p10ExceptionHandling;

import java.util.Scanner;

/**
 * Apanhar também as excepções de input, mas diferenciar o seu tratamento. Teste
 * 1, colocar no input: 10 e 0 Teste 2, colocar no input: A
 * 
 */
public class C05DiferenteCodeForExceptions {

	/**
	 * main
	 */
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		System.out.println("Realizacao da operacao de divisao...");

		try {
			System.out.print("Introduza o dividendo -> ");
			int dividendo = keyboard.nextInt();

			System.out.print("Introduza o divisor -> ");
			int divisor = keyboard.nextInt();

			// realizar a processamento
			int quociente = dividendo / divisor;

			// mostrar resultado
			System.out.println("Divisao de " + dividendo + " por " + divisor
					+ " -> " + quociente);

		} catch (Exception e) {
			if (e.getClass().getSimpleName().equals("ArithmeticException")) {
				System.out.println("Ocorreu a excepcao de divisão por zero: "
						+ e.getMessage());
			} else if (e.getClass().getSimpleName()
					.equals("InputMismatchException")) {
				System.out.println("Ocorreu a excepcao de Input Mismatch");
			} else
				System.err.println("Ocorreu a excepcao: "
						+ e.getClass().getSimpleName() + ": " + e.getMessage());
		}

		keyboard.close();
	}
	// haverá forma de o catch separar logo cada excepção??
}
