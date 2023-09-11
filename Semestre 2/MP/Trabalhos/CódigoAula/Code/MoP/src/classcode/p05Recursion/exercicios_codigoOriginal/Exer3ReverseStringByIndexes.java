package classcode.p05Recursion.exercicios_codigoOriginal;

public class Exer3ReverseStringByIndexes {

	/**
	 * main
	 */
	public static void main(String[] args) {
		test_reverseString("olá bom dia");
		test_reverseString("a");
		test_reverseString("");
		test_reverseString(null);
	}

	/**
	 * test method, does the inputs and outputs
	 */
	public static void test_reverseString(String s) {
		String res = reverseString(s);
		System.out.println("reverseString(" + s + ") = " + res);
	}

	/**
	 * Recursively returns the reverse of the received string
	 */
	public static String reverseString(String s) {
		if (s == null)
			throw new IllegalArgumentException(
					"The argument must be a valid String: " + s);

		// TODO ...
		return null;
	}
	
	/**
	 * Auxiliary method
	 */
	public  static void reverseString(char[] str, int idx1, int idx2){
		 
	}

}
