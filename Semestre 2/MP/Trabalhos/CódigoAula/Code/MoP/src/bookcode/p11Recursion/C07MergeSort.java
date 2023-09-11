package bookcode.p11Recursion;

import java.util.Arrays;

/**
 * Class for sorting an array of integers from smallest to largest using the
 * merge sort algorithm.
 */
public class C07MergeSort {
	/**
	 * Precondition: Every indexed variable of the array a has a value.
	 * Postcondition: a[0] <= a[1] <= . . . <= a[a. length - 1].
	 */
	public static void sort(int[] a) {

		if (a.length >= 2) {

			// get the halfLength
			int halfLength = a.length / 2;

			// create the two auxiliary arrays
			int[] firstHalf = new int[halfLength];
			int[] lastHalf = new int[a.length - halfLength];

			// split data to that arrays
			divide(a, firstHalf, lastHalf);

			// sort the arrays
			sort(firstHalf);
			sort(lastHalf);

			// merge arrays
			merge(a, firstHalf, lastHalf);
		}
		// else do nothing. a.length == 1, so a is sorted.
	}

	/**
	 * Just to use the methods Arrays.CopyTo
	 */
	public static void sort2(int[] a) {

		if (a.length >= 2) {

			// get the halfLength
			int halfLength = a.length / 2;

			// create the two auxiliary arrays with half data from the array
			int[] firstHalf = Arrays.copyOf(a, halfLength);
			int[] lastHalf = Arrays.copyOfRange(a, halfLength, a.length);

			// sort the arrays
			sort(firstHalf);
			sort(lastHalf);

			// merge arrays
			merge(a, firstHalf, lastHalf);
		}
		// else do nothing. a.length == 1, so a is sorted.
	}

	// Precondition: a.length = firstHalf.length + lastHalf.length.
	// Postcondition: All the elements of a are divided
	// between the arrays firstHalf and lastHalf.
	private static void divide(int[] a, int[] firstHalf, int[] lastHalf) {
		for (int i = 0; i < firstHalf.length; i++)
			firstHalf[i] = a[i];
		for (int i = 0; i < lastHalf.length; i++)
			lastHalf[i] = a[firstHalf.length + i];
	}

	public static void divide2(int[] a, int[] firstHalf, int[] lastHalf) {
		System.arraycopy(a, 0, firstHalf, 0, firstHalf.length);
		System.arraycopy(a, firstHalf.length, lastHalf, 0, lastHalf.length);
	}

	// Precondition: Arrays firstHalf and lastHalf are sorted from
	// smallest to largest; a. length = firstHalf.length +
	// lastHalf.length.
	// Postcondition: Array a contains all the values from firstHalf
	// and lastHalf and is sorted from smallest to largest.
	private static void merge(int[] a, int[] firstHalf, int[] lastHalf) {
		int firstHalfIndex = 0, lastHalfIndex = 0, aIndex = 0;
		while ((firstHalfIndex < firstHalf.length)
				&& (lastHalfIndex < lastHalf.length)) {
			if (firstHalf[firstHalfIndex] < lastHalf[lastHalfIndex]) {
				a[aIndex] = firstHalf[firstHalfIndex];
				firstHalfIndex++;
			} else {
				a[aIndex] = lastHalf[lastHalfIndex];
				lastHalfIndex++;
			}
			aIndex++;
		}
		// At least one of firstHalf and lastHalf has been
		// completely copied to a.
		// Copy rest of firstHalf, if any.
		while (firstHalfIndex < firstHalf.length) {
			a[aIndex] = firstHalf[firstHalfIndex];
			aIndex++;
			firstHalfIndex++;
		}
		// Copy rest of lastHalf, if any.
		while (lastHalfIndex < lastHalf.length) {
			a[aIndex] = lastHalf[lastHalfIndex];
			aIndex++;
			lastHalfIndex++;
		}
	}

	/**
	 * main
	 */
	public static void main(String[] args) {

		// an array of number initialised
		int[] anArray = { 7, 5, 11, 2, 16, 4, 18, 14, 12, 30 };

		// show array before sorting
		System.out.print("Array values before sorting -> ");
		for (int i = 0; i < anArray.length; i++)
			System.out.print(anArray[i] + " ");

		System.out.println();

		// sort the array
		sort(anArray);

		// show the array after sorting
		System.out.println("Array values after sorting -> "
				+ Arrays.toString(anArray));

		System.out.println();
	}
}
