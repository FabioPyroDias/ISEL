package classcode.p05Recursion.exercicios_codigoOriginal;

public class Exer2DivisaoPorSubtraccoes {

	/**
	 * main
	 */
	public static void main(String[] args) {
		test_div(123, 10);
		test_div(100, 3);
		test_div(100, 300);
		test_div(100, 100);
		test_div(0, 5);
		
		test_div(1002, 0);
		test_div(-1, 3);
		test_div(0, -3);
	}

	/**
	 * test method, does the inputs and outputs
	 */
	public static void test_div(int n1, int n2) {
		int res = div(n1, n2);
		System.out.println("div(" + n1 + ", " + n2 + ") = " + res);
	}

	/**
	 * Recursively returns the integer division of arguments, arguments should be positive
	 */
	public static int div(int a, int b) {
		if (a < 0)
			throw new IllegalArgumentException(
					"The arguments must be positive: " + a);

		// TODO ...
		return 0;
	}

}
