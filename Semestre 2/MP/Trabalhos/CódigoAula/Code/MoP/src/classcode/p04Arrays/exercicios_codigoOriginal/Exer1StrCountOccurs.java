package classcode.p04Arrays.exercicios_codigoOriginal;

public class Exer1StrCountOccurs {

	/**
	 * main
	 */
	public static void main(String[] args) {
		test_countOccurs("banana abacate pera", 'a');
		test_countOccurs("banana abacate pera", 'b');
		test_countOccurs("banana abacate pera", 'x');

	}

	/**
	 * test method, does the inputs and outputs
	 */
	public static void test_countOccurs(String str, char c) {
		int n = countOccurs(str, c);
		System.out.println("\"" + str + "\" have " + n + " chars '" + c + "'");
	}

	/**
	 * count occurs method
	 */
	public static int countOccurs(String s, char c) {
		// TODO ...
		int n = 0;
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == s.charAt(i))
				++n;
		}
		return n;
	}

}
