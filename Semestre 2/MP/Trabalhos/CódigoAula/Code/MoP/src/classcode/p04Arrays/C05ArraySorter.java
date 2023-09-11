package classcode.p04Arrays;

/**
 * Class for sorting an array of base type int from smallest to largest.
 * 
 * @Author: Walter Savitch
 */
public class C05ArraySorter {

	/**
	 * Precondition: Every element in anArray has a value. Action: Sorts the array
	 * into ascending order.
	 */
	public static void selectionSort(int[] anArray) {
		// Place the correct value in anArray[index]
		for (int index = 0; index < anArray.length - 1; ++index) {
			int indexOfNextSmallest = getIndexOfSmallest(index, anArray);
			interchange(index, indexOfNextSmallest, anArray);
			// Assertion:anArray[0] <= anArray[1] <=...<= anArray[index]
			// and these are the smallest of the original array elements.
			// The remaining positions contain the rest of the original
			// array elements.
		}
	}

	/**
	 * Returns the index of the smallest value in the portion of the array that
	 * begins at the element whose index is startIndex and ends at the last element.
	 */
	private static int getIndexOfSmallest(int startIndex, int[] a) {
		int min = a[startIndex];
		int indexOfMin = startIndex;
		for (int index = startIndex + 1; index < a.length; ++index) {
			if (a[index] < min) {
				min = a[index];
				indexOfMin = index;
				// min is smallest of a[startIndex] through a[index]
			}
		}
		return indexOfMin;
	}

	/**
	 * Precondition: i and j are valid indices for the array a. Postcondition:
	 * Values of a[i] and a[j] have been interchanged.
	 */
	private static void interchange(int idx1, int idx2, int[] a) {
		int temp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = temp; // original value of a[i]
	}
}
