package classcode.p05Recursion.exercicios_codigoOriginal;

public class Exer1AddDigits {

	/**
	 * main
	 */
	public static void main(String[] args) {
		test_addDigits(123);
		test_addDigits(100);
		test_addDigits(1002);

		test_addDigits(3);
		test_addDigits(0);
	}

	/**
	 * test method, does the inputs and outputs
	 */
	public static void test_addDigits(int n) {
		int res = addDigits(n);
		System.out.println("addDigits(" + n + ") = " + res);
	}

	/**
	 * Recursively returns the sum of the digits of received number
	 */
	public static int addDigits(int n) {
		if (n < 0)
			throw new IllegalArgumentException(
					"The argument must be positive: " + n);

		// TODO ...
		return 0;
	}

}
