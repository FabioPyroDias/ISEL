package classcode.p10ExceptionHandling;

import java.util.Random;

/**
 * Medição do tempo de processamento de IFS versus EXCEPTIONS
 * 
 */
public class C15TimmingExceptions {
	static Random rg = new Random();

	// teste: no final retar os comententários dos dois métodos seguintes e
	// comparar os resultados face aos resultados sem comentárias

	public static int divIf(int divisor, int dividendo) {
		int res = -1;
		if (dividendo != 0) {
			// String str = divisor + " / " + dividendo + " = " + divisor
			// / dividendo;
			res = divisor / dividendo;
		}
		return res;
	}

	public static int divException(int divisor, int dividendo) {
		int res = 0;
		try {
			// String str = divisor + " / " + dividendo + " = " + divisor
			// / dividendo;
			res = divisor / dividendo;
		} catch (ArithmeticException e) {
			res = -1;
		}
		return res;
	}

	public static void test(int delta) {
		final int NTESTES = 1 * 1000 * 1000;// 00;
		final int NREPS = 50;

		long startTime, endTime, ifTest = 0, exceptionTest = 0;
		int dividendo;

		System.out.println("Teste ao if/exception com delta de -> " + delta);

		for (int nreps = 0; nreps < NREPS; ++nreps) {
			// teste do IF
			startTime = System.currentTimeMillis();
			for (int i = 0; i < NTESTES; ++i) {
				dividendo = rg.nextInt(delta);
				divIf(1, dividendo);
			}
			endTime = System.currentTimeMillis();

			ifTest += endTime - startTime;

			// teste da Exception
			startTime = System.currentTimeMillis();
			for (int i = 0; i < NTESTES; ++i) {
				dividendo = rg.nextInt(delta);
				divException(1, dividendo);
			}
			endTime = System.currentTimeMillis();

			exceptionTest += endTime - startTime;
			System.out.print(".");
		}

		System.out.println("\nIF test (ms) -> " + ifTest /*/ NREPS*/);
		System.out.println("EXCEPTION test (ms) -> " + exceptionTest /*/ NREPS*/);
		System.out.println();
		System.out.println();
	}

	/**
	 * main
	 */
	public static void main(String[] args) {
		test(1);
		test(2);
		test(10);
		test(1000);

		System.out.println("End of main...");
	}
}
