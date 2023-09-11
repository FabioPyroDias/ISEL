package classcode.p10ExceptionHandling;

import java.util.Scanner;

/**
 * Agora com o lançamento da excepção (de Runtime) dentro de um método e
 * 
 */
public class C10HandleExceptionsOutsideTheMethod1 {

	/**
	 * Método base
	 */
	public static int divisao(int dividendo, int divisor) {
		if (divisor == 0) {
			throw new ArithmeticException("Divisao por zero");
		}
		int quociente = dividendo / divisor;
		return quociente;
	}

	/**
	 * método que utiliza o método base
	 */
	public static int metodo1(int dividendo, int divisor) {
		return divisao(dividendo, divisor);
	}

	/**
	 * main
	 */
	public static void main(String[] args) throws ClassNotFoundException {
		//metodo1(10, 0);
		Scanner keyboard = new Scanner(System.in);

		System.out.println("Realizacao da operacao de divisao...");

		try {
			System.out.print("Introduza o dividendo -> ");
			int dividendo = keyboard.nextInt();

			System.out.print("Introduza o divisor -> ");
			int divisor = keyboard.nextInt();

			// realizar a processamento
			int quociente = metodo1(dividendo, divisor);

			// mostrar resultado
			System.out.println("Divisao de " + dividendo + " por " + divisor
					+ " -> " + quociente);

		} catch (ArithmeticException e) {
			System.out.println("Ocorreu a excepcao: "
					+ e.getClass().getSimpleName() + ": " + e.getMessage());
		}

		keyboard.close();
	}
	// e se for uma excepção que não seja de runtime??
	// por exemplo uma excepção Exception???
}
