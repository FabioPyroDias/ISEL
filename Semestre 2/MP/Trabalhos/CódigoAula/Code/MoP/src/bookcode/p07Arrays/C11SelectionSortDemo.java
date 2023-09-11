package bookcode.p07Arrays;


/*
 * Array initialised with value
 */
public class C11SelectionSortDemo {

	/**
	 * Main method
	 */
	public static void main(String[] args) {

		// array created and initialised with the following values
		int[] b = { 7, 5, 11, 2, 16, 4, 18, 14, 12, 30 };

		// display array before sorting
		display(b, "Array before -> ");

		C10ArraySorter.selectionSort(b);

		display(b, "Array after");

	}

	/**
	 * method that display one array
	 */
	public static void display(int[] array, String when) {
		System.out.println("Array values " + when + " sorting:");
		for (int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
		System.out.println();
	}
}
