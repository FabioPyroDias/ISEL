package bookcode.p11Recursion;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Class for recursively searching an already sorted array of integers.
 */
public class C06ArraySearcher {

	private int[] a;

	/**
	 * Precondition: theArray is full and is sorted from lowest to highest.
	 */
	public C06ArraySearcher(int[] theArray) {
		// keep the array in instance variable "a"
		a = theArray;
	}

	/**
	 * If target is in the array, returns the index of an occurrence of target.
	 * Returns -1 if target is not in the array.
	 */
	public int find(int target) {
		return binarySearch(target, 0, a.length - 1);
	}

	// Uses binary search to search for target in a[first] through
	// a[last] inclusive. Returns the index of target if target
	// is found. Returns -1 if target is not found.
	private int binarySearch(int target, int first, int last) {
		int result;
		if (first > last)
			result = -1;
		else {
			int mid = (first + last) / 2;
			if (target == a[mid])
				result = mid;
			else if (target < a[mid])
				result = binarySearch(target, first, mid - 1);
			else
				// (target > a[mid])
				result = binarySearch(target, mid + 1, last);
		}
		return result;
	}

	/**
	 * main
	 */
	public static void main(String[] args) {

		// keyboard reader
		Scanner keyboard = new Scanner(System.in);

		// the array
		int[] anArray = new int[10];

		// reading data
		System.out.print("Enter 10 integers -> ");
		for (int i = 0; i < 10; i++)
			anArray[i] = keyboard.nextInt();

		// sort the array
		Arrays.sort(anArray);

		System.out.println();

		// show the array sorted
		System.out.print("10 sorted integers -> ");
		for (int i = 0; i < 10; i++)
			System.out.print(anArray[i] + " ");

		System.out.println();

		// create an object to make the search
		C06ArraySearcher finder = new C06ArraySearcher(anArray);

		String ans;
		do {
			// ask and read a value to search for
			System.out.print("Enter a value to search for -> ");
			int target = keyboard.nextInt();

			// search for with
			int result = finder.find(target);

			// show result
			if (result < 0)
				System.out.println(target + " is not in the array.");
			else
				System.out.println(target + " is at index " + result);

			// again ?
			System.out.print("Again? (to continue answer: yes) -> ");
			ans = keyboard.next();
		} while (ans.equalsIgnoreCase("yes"));

		System.out.println("May you find what you're searching for.");

		// close keyboard
		keyboard.close();
	}

}
