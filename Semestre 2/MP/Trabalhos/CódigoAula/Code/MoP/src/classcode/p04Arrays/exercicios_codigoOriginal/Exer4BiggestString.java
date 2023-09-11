package classcode.p04Arrays.exercicios_codigoOriginal;

import java.util.Arrays;

public class Exer4BiggestString {

	/**
	 * main
	 */
	public static void main(String[] args) {
		test_biggestString(null);
		test_biggestString(new String[] {});
		test_biggestString(new String[] {""});
		test_biggestString(new String[] {"abc"});
		test_biggestString(new String[] {"abc", "v"});
		test_biggestString(new String[] {"abc", null, "012345"});
		test_biggestString(new String[] {null, null, "012345"});
	}

	/**
	 * test method, does the inputs and outputs
	 */
	public static void test_biggestString(String[] ss) {
		int res = biggestString(ss);
		System.out.println(Arrays.toString(ss) + " have a maximum of  " + res + " chars in a string");
	}

	/**
	 * Returns the size of the biggest string, the array may have nulls
	 */
	public static int biggestString(String[] ss) {
		// TODO ...
		return 0;
	}

}
