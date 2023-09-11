package classcode.p10ExceptionHandling;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Apanhar também as excepções de input e diferenciar o seu tratamento por
 * vários blocos de catch. Experimentar vários inputs com erro e sem erro.
 * 
 */
public class C06SeveralCatchs {

	/**
	 * main
	 */
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		System.out.println("Realizacao da operacao de divisao...");

		try {
			System.out.print("Introduza o dividendo -> ");
			// depois comentar a linha seguinte
			keyboard.close();
			int dividendo = keyboard.nextInt();

			System.out.print("Introduza o divisor -> ");
			int divisor = keyboard.nextInt();

			// realizar a processamento
			int quociente = dividendo / divisor;

			// mostrar resultado
			System.out.println("Divisao de " + dividendo + " por " + divisor
					+ " -> " + quociente);
			// gerar uma excepção
			"ola".charAt(10);
		} catch (ArithmeticException e) {
			System.err.println("Ocorreu a excepcao de divisão por zero: "
					+ e.getMessage());
			// gerar uma excepção
			"ola".charAt(10);
		} catch (InputMismatchException e) {
			System.err.println("Ocorreu a excepcao de Input Mismatch");
		} catch (Exception e) {
			System.err.println("Ocorreu a excepcao: " + e.getMessage());
		}
		System.out.println("Fim de programa...");

		keyboard.close();
	}
	// a excepção é avaliada e ficará entregue ao primeiro catch que seja do seu
	// tipo.

	// e mais excepções!!!
}
