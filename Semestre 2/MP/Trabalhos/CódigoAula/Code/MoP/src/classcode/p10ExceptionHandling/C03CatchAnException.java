package classcode.p10ExceptionHandling;

import java.util.Scanner;

/**
 * Tratamento da excepção. Colocar no input: 10 e 0
 * 
 */
public class C03CatchAnException {

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

		try {
			// realizar o processamento
			int quociente = dividendo / divisor;

			// mostrar resultado
			System.out.println("Divisao de " + dividendo + " por " + divisor
					+ " -> " + quociente);

		} catch (Exception e) {
			// System.out.println("Erro: nao é possível dividir por zero");
			System.err.println("Ocorreu a excepcao: "
					+ e.getClass().getSimpleName() + ": " + e.getMessage());
			System.err.println("Exception: " + e);
		}
		System.out.println("Fim do programa... ");

		keyboard.close();
	}
	// e se o utilizador introduzir "letras"
}
