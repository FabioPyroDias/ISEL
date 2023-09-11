package bookcode.p11Recursion;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Class for recursively searching an already sorted array of integers.
 * 
 * Este ficheiro contém código mais simples do que o primeiro ficheiro
 */
public class C06ArraySearcherV2 {

	/**
	 * If target is in the array, returns the index of an occurrence of target.
	 * Returns -1 if target is not in the array.
	 */
	public static int find(int target, int[] theArray) {
		return binarySearch(target, 0, theArray.length - 1, theArray);
	}

	/**
	 * Uses binary search to search for target in theArray[first] through
	 * theArray[last] inclusive. Returns the index of target if target is found.
	 * Returns -1 if target is not found.
	 */
	private static int binarySearch(int target, int first, int last,
			int[] theArray) {

		// if index crossed, the search ended without success
		if (first > last)
			return -1;

		int mid = (first + last) / 2;

		// check if value is in the middle
		if (target == theArray[mid])
			return mid;

		// check if value on the smallest part
		if (target < theArray[mid])
			return binarySearch(target, first, mid - 1, theArray);

		// (target > a[mid]); value is on the bigger part
		return binarySearch(target, mid + 1, last, theArray);
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

		String ans;
		do {
			// ask and read a value to search for
			System.out.print("Enter a value to search for -> ");
			int target = keyboard.nextInt();

			// search for with
			int result = C06ArraySearcherV2.find(target, anArray);

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
