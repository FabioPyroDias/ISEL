package classcode.p10ExceptionHandling;

import java.util.Scanner;

/**
 * Tratamento da situação de erro por código normal. Colocar no input: 10 e 0
 * 
 */
public class C02SolveSituationByIf {

	/**
	 * main
	 */
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		System.out.println("Realizacao da operacao de divisao...");

		System.out.print("Introduza o dividendo -> ");
		int dividendo = keyboard.nextInt();

		System.out.print("Introduza o divisor -> ");
		int divisor = keyboard.nextInt();

		if (divisor != 0) {

			// realizar a processamento
			int quociente = dividendo / divisor;

			// mostrar resultado
			System.out.println("Divisao de " + dividendo + " por " + divisor
					+ " -> " + quociente);
		} else {
			System.out.println("Erro: nao é possível dividir por zero");
		}
		keyboard.close();
	}
	// agora vamos utilizar excepções
}
