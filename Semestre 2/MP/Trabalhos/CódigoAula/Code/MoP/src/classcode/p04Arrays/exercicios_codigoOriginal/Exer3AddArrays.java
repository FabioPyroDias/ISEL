package classcode.p04Arrays.exercicios_codigoOriginal;

import java.util.Arrays;

public class Exer3AddArrays {

	/**
	 * main
	 */
	public static void main(String[] args) {
		test_addArrays(new int[] { 1, 2, 3, 4 }, new int[] { 3, 3 });
		test_addArrays(new int[] { 1, 2, 3, 4 }, new int[] {});
		test_addArrays(new int[] { 1, 2, 3, 4 }, null);

		test_addArrays(new int[] { 1, 2 }, new int[] { 1, 1, 1, 1 });
		test_addArrays(new int[] {}, new int[] { 1, 1, 1, 1 });
		test_addArrays(null, new int[] { 1, 1, 1, 1 });
	}

	/**
	 * test method, does the inputs and outputs
	 */
	public static void test_addArrays(int[] a1, int[] a2) {
		int[] res = addArrays(a1, a2);
		System.out.println(Arrays.toString(a1) + " + " + Arrays.toString(a2)
				+ " = " + Arrays.toString(res));
	}

	/**
	 * Add two arrays, they could have different number of elements, a null
	 * array should be considered as a empty array
	 * 
	 * @param a1
	 *            one array
	 * @param a2
	 *            another array
	 * @return a new array with the sum of the received arrays; returns null if
	 *         both are null;
	 */
	public static int[] addArrays(int[] a1, int[] a2) {
		// TODO ...
		return null;
	}

}
