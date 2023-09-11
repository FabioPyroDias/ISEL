package classcode.p05Recursion;

import java.util.Arrays;

/**
 * Array initialised with value, recursion with arrays
 */
public class C05ArraySearch {

	/**
	 * Main method
	 */
	public static void main(String[] args) {

		// array created and initialised with the following values
		int[] array = { 7, 5, 11, 2, 16, 4, 18, 14, 12, 30 };

		// display array
		System.out.println("Array -> " + Arrays.toString(array) + "\n");

		int val = 31;

		int idx = search(array, val);
		System.out.println("search: O valor " + val + " existe na posição -> "
				+ idx);

		idx = search2(array, val);
		System.out.println("search2: O valor " + val + " existe na posição -> "
				+ idx + "\n");

		val = 14;

		idx = search(array, val);
		System.out.println("search: O valor " + val + " existe na posição -> "
				+ idx);

		idx = search2(array, val);
		System.out.println("search2: O valor " + val + " existe na posição -> "
				+ idx);
	}

	/**
	 * Search using indexes
	 */
	private static int search(int[] array, int val) {
		if (array == null)
			throw new NullPointerException();

		return search(array, val, 0);
	}

	private static int search(int[] array, int val, int idx) {

		if (idx >= array.length)
			return -1;

		if (array[idx] == val)
			return idx;

		return search(array, val, idx + 1);

	}

	/**
	 * Search by using array copy
	 */
	private static int search2(int[] array, int val) {
		if (array == null)
			throw new NullPointerException();

		if (array.length == 0)
			return -1;

		if (array[0] == val)
			return 0;

//		if (array.length == 1)
//			return -1;

		// copy of array[1, ...] to newArray
		int[] newArray = Arrays.copyOfRange(array, 1, array.length);

		// search in array[1, ...]
		int result = search2(newArray, val);

		// return valid index +1 or -1
		return result == -1 ? -1 : result + 1;
	}

}
