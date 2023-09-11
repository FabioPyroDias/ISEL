package classcode.p10ExceptionHandling;

import java.util.Scanner;

/**
 * Throw de uma exception, fazer new e throw
 * 
 * Apanhar também as excepções de input teste1: Usar exceptions declaradas por
 * "mim"
 * 
 * 
 */
public class C09ThrowExceptions {

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

			keyboard.close();

			Exception e = new Exception("My Divide by zero - divisão por zero");

			// realizar a processamento
			if (divisor == 0) {

				System.out.println("Divisor = 0, print e -> " + e);

				// teste 0:
				throw null; // teste 0

				// teste1:
				// throw e; // comentar o teste 0

				// teste 2: // comentar teste 0 e 1
				// DivideByZeroException dze = new DivideByZeroException(
				// "Divisao por zero");
				// throw dze;

				// teste 3
				// throw (Exception) (Object) new C09ThrowExceptions();

			}
			if (divisor < 0) {
				throw new ArithmeticException("Divisor negativo");
			}
			int quociente = dividendo / divisor;

			// mostrar resultado
			System.out.println("Divisao de " + dividendo + " por " + divisor
					+ " -> " + quociente);

		} catch (Exception e) {
			System.err.println("Ocorreu a excepcao: "
					+ e.getClass().getSimpleName() + ": " + e.getMessage());
			e.printStackTrace();
		}
	}
	// e como lidar com as excepções fora do método onde são geradas?
}
