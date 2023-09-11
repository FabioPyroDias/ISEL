package classcode.p10ExceptionHandling;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Vários blocos de TRY
 * 
 */
public class C07SeveralTryBlocks {

	/**
	 * main
	 */
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		System.out.println("Realizacao da operacao de divisao...");

		try {
			boolean success = false;
			do {
				try {
					System.out.print("Introduza o dividendo -> ");
					int dividendo = keyboard.nextInt();

					System.out.print("Introduza o divisor -> ");
					int divisor = keyboard.nextInt();

					// realizar a processamento
					int quociente = dividendo / divisor;

					// mostrar resultado
					System.out.println("Divisao de " + dividendo + " por "
							+ divisor + " -> " + quociente);
					// gerar uma excepção
					if (quociente % 2 == 1)
						"ola".charAt(10);
					success = true;
				} catch (ArithmeticException e) {
					System.err
							.println("Ocorreu a excepcao de divisão por zero: "
									+ e.getMessage());
					// gerar uma excepção
					"ola".charAt(10);
				} catch (InputMismatchException e) {
					System.err.println("Ocorreu a excepcao de Input Mismatch");
					// eliminar inout errado
					keyboard.nextLine();
				}
				if (!success)
					System.out.println("A operação será repetida.\n");
			} while (!success);
		} catch (Exception e) {
			System.err.println("Ocorreu a excepcao: " + e.getMessage());
			e.printStackTrace();
		}
		System.out.println("Fim de programa...");

		keyboard.close();
	}
	// a excepção é avaliada e ficará entregue ao primeiro catch que seja do seu
	// tipo.

	// e mais excepções!!!
}
