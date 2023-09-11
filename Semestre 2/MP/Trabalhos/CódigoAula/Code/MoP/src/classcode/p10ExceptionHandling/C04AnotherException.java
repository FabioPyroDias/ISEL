package classcode.p10ExceptionHandling;

import java.util.Scanner;

/**
 * Apanhar também as excepções de input. Colocar no input a letra: A
 * 
 */
public class C04AnotherException {

	/**
	 * main
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("Realizacao da operacao de divisao...");

		try {
			System.out.print("Introduza o dividendo -> ");
			input.close();
			int dividendo = input.nextInt();

			System.out.print("Introduza o divisor -> ");
			int divisor = input.nextInt();

			// realizar a processamento
			int quociente = dividendo / divisor;

			// mostrar resultado
			System.out.println("Divisao de " + dividendo + " por " + divisor
					+ " -> " + quociente);

		} catch (Exception e) {
			// getSimpleName devolve só o nome da classe
			System.err.println("Ocorreu a excepção: "
					+ e.getClass().getSimpleName() + ": " + e.getMessage());
		}
	}
	// e como diferenciar as excepções ocorridas?
}
