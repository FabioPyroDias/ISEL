package classcode.p10ExceptionHandling;

import java.util.Scanner;

/**
 * Mostra do trace do stack da excepção. Utiliza a excepção:
 * DivideByZeroException
 * 
 */
public class C14StackTrace {
	public static int divisao(int dividendo, int divisor)
			throws DivideByZeroException {
		if (divisor == 0) {
			throw new DivideByZeroException("Divisao por zero");
		}
		int quociente = dividendo / divisor;
		return quociente;
	}

	public static int divisao2(int dividendo, int divisor)
			throws DivideByZeroException {
		return divisao(dividendo, divisor);
	}

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

			// realizar a processamento
			// int quociente = dividendo / divisor;
			// int quociente = divisao(dividendo,divisor);
			int quociente = divisao2(dividendo, divisor);

			// mostrar resultado
			System.out.println("Divisao de " + dividendo + " por " + divisor
					+ " -> " + quociente);

		} catch (Exception e) {
			System.out.println("Ocorreu a excepcao: "
					+ e.getClass().getSimpleName() + ": " + e.getMessage());
			StackTraceElement elements[] = e.getStackTrace();
			for (int i = 0, n = elements.length; i < n; i++) {
				System.out.println(elements[i].getFileName() + ": "
						+ elements[i].getClassName() + " "
						+ elements[i].getMethodName() + "()" + " line: "
						+ elements[i].getLineNumber());
			}
		}

		keyboard.close();
	}
}
