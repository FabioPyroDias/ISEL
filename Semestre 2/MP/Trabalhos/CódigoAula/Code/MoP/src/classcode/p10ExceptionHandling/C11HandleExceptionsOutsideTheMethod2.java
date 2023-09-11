package classcode.p10ExceptionHandling;

import java.util.Scanner;

/**
 * Agora o método DIVISAO tem de declarar que pode lançar a excepção Exception e
 * o método METODO1 tem de declarar que pode lançar a a excepção
 * NegativeValueException. Deste modo quem usar estes métodos sabe com o que
 * pode esperar.
 * 
 */
public class C11HandleExceptionsOutsideTheMethod2 {

	/**
	 * Método base
	 */
	public static int divisao(int dividendo, int divisor) throws Exception {
		if (divisor == 0)
			throw new Exception("Divisao por zero");
		int quociente = dividendo / divisor;
		return quociente;
	}

	/**
	 * método que utiliza o método base
	 */
	public static int metodo1(int dividendo, int divisor)
			throws NegativeValueException {
		if (divisor < 0)
			throw new NegativeValueException("Divisor negativo.");
		try {
			return divisao(dividendo, divisor);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	/**
	 * main
	 */
	public static void main(String[] args) throws ClassNotFoundException {
		Scanner keyboard = new Scanner(System.in);
		do {

			System.out.println("Realizacao da operacao de divisao...");

			try {
				System.out.print("Introduza o dividendo -> ");
				int dividendo = keyboard.nextInt();

				System.out.print("Introduza o divisor -> ");
				int divisor = keyboard.nextInt();

				// realizar a processamento
				int quociente = metodo1(dividendo, divisor);
				// subsituir a linha anterior pela seguinte, observar a
				// informação do compilador
				// int quociente = divisao(dividendo, divisor);

				// mostrar resultado
				System.out.println("Divisao de " + dividendo + " por "
						+ divisor + " -> " + quociente);

			} catch (NegativeValueException e) {
				System.out.println("Ocorreu a excepcao: "
						+ e.getClass().getSimpleName() + ": " + e.getMessage());
			}
		} while (NegativeValueException.getN() < 2);

		keyboard.close();
	}
	// finally??
	// isto quer dizer que chegámos ao fim????
}