package classcode.p10ExceptionHandling;

import java.util.Scanner;

/**
 * Mostra a corrência de uma excepção do Java Colocar no input: 10 e 0
 * 
 */
public class C00ShowOccurOfException {

	/**
	 * main
	 */
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		// teste 2
		// Scanner scan2 = null;
		// scan2.next();
		//
		System.out.println("Realizacao da operacao de divisao...");

		System.out.print("Introduza o dividendo -> ");
		int dividendo = keyboard.nextInt();

		System.out.print("Introduza o divisor (introduza 0) -> ");
		int divisor = keyboard.nextInt();

		// realizar a processamento
		int quociente = dividendo / divisor;

		// mostrar resultado
		System.out.println("Divisao de " + dividendo + " por " + divisor
				+ " -> " + quociente);

		keyboard.close();
	}

}
