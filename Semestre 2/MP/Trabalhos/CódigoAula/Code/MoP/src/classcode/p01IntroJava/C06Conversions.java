package classcode.p01IntroJava;

/**
 * Conversions: String -> Integer, Integer -> String, Integer -> int, int ->
 * integer
 */
public class C06Conversions {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String str = "234";
		System.out.println("String original value -> " + str);

		// converting from string to Integer
		Integer i1 = Integer.valueOf(str);

		// converting from Integer to String
		System.out.println("Value extracted from the Integer  by toString() -> " + i1.toString());
		// toString is automatically called
		System.out.println("Value extracted from the Integer -> " + i1);

		// converting from Integer to int - see unboxing latter
		int j = i1.intValue();
		System.out.println("j = " + j);

		Integer i3 = Integer.valueOf(j * 100);
		System.out.println("i3 = new Integer(j*100); -> " + i3);

		// Numa versão mais sintética
		str = "222.44";
		System.out.println("String original value -> " + str);
		// String to Double, from Double to double
		Double d = Double.valueOf(str).doubleValue();
		System.out.println("d = " + d);
	}
}
