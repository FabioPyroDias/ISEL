package classcode.p02FlowDecisionsCycles;

import java.util.Scanner;

/**
 * Do-While demo
 */
public class C12DoWhile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// the keyboard reader
		Scanner keyboard = new Scanner(System.in);

		// mensagem de título
		System.out.println("Cálculo da média de números inteiros positivos...");

		// variáveis necessárias

		// para controlar o ciclo de leitura
		boolean numeroNegativo = false;

		// para conter o número de números lidos
		int numerosLidos = 0;

		// para conter a soma dos números lidos
		int total = 0;

		// ciclo de leitura
		do {
			// pedir e ler um número
			System.out
					.print("Introduza um número positivo (ou negativo para terminar) -> ");
			int numero = keyboard.nextInt();

			// se for negativo sinalizar que é para terminar o ciclo
			if (numero < 0)
				numeroNegativo = true;
			else {
				// se for positivo, incrementar o número de números lidos
				++numerosLidos;
				// adicioná-lo ao total
				total += numero;
			}
			// continuar com o ciclo se não tiver sido encontrado um número
			// negativo
		} while (!numeroNegativo);

		// mostrar os resultados
		if (numerosLidos > 0) {
			System.out.println("Foram introduzidos " + numerosLidos
					+ " números.");
			System.out.println("A sua média é -> " + total / numerosLidos);
		} else
			System.out
					.println("Não é possível calcular a média de 0 números!!!");

		
		
		// close the keyboard
		keyboard.close();

	}
}
