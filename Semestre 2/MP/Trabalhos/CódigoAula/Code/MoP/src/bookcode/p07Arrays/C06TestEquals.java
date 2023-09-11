package bookcode.p07Arrays;

import java.util.Arrays;

/**
 * A demonstration program to test two arrays for equality.
 */
public class C06TestEquals {

	/**
	 * Main method
	 */
	public static void main(String[] args) {

		// two array of 3 integers
		int[] a = new int[3];
		int[] b = new int[3];

		// fill array a with 0, 1, ...
		setArray(a);
		// fill array b with 0, 1, ...
		setArray(b);

		// compare by ==
		System.out.print("The arrays are ");
		if (a == b)
			System.out.println("equal by ==.");
		else
			System.out.println("not equal by ==.");

		// compare by equals method
		System.out.print("The arrays are ");
		if (equals(a, b))
			System.out.println("equal by the equals method developed.");
		else
			System.out.println("not equal by the equals method developed.");

		// compare by Arrays.equals method
		System.out.print("The arrays are ");
		if (Arrays.equals(a, b))
			System.out.println("equal by the Arrays.equals method.");
		else
			System.out.println("not equal by the Arrauys.equals method.");

	}

	/*
	 * method equals developed
	 */
	public static boolean equals(int[] array1, int[] array2) {
		// tentatively
		boolean elementsMatch = true;

		// check if the size is the same
		if (array1.length != array2.length)
			elementsMatch = false;
		else {
			// if size is the same compare element by element
			int i = 0;
			while (elementsMatch && (i < array1.length)) {
				if (array1[i] != array2[i])
					elementsMatch = false;
				i++;
			}
		}
		return elementsMatch;
	}

	/*
	 * fill the array with values from 0 to array.length
	 */
	public static void setArray(int[] array) {
		for (int i = 0; i < array.length; i++)
			array[i] = i;
	}
}
