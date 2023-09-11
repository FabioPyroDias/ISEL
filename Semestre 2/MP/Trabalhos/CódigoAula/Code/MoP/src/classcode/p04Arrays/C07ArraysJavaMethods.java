package classcode.p04Arrays;

import java.util.Arrays;

/**
 * Teste aos métodos disponíveis nas classes java para trabalhar com arrays
 * 
 * Classes: java.lang.System e java.util.Arrays
 */
public class C07ArraysJavaMethods {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = new int[20];

		System.out.println("Array inicializado com os valores por omissão ...");

		System.out.println("array.toString()) -> " + array);

		// Arrays.toString(int [] a)
		System.out
				.println("Arrays.toString(array) -> " + Arrays.toString(array));

		// Arrays.fill(int[] a, int value)
		Arrays.fill(array, 20);
		System.out.println("\nArray preenchido com 20 ...");
		System.out.println("array -> " + Arrays.toString(array));

		initRandomArray(array, 0, 100);
		System.out.println("\nArray inicializado com valores aleatórios ...");
		System.out.println("array -> " + Arrays.toString(array));

		// Arrays.sort(int[] a)
		Arrays.sort(array);
		System.out.println("\nArray ordenado...");
		System.out.println("array -> " + Arrays.toString(array));

		// Arrays.binarySearch(int[] a, int value), o array deve estar ordenado
		int valueToSearch = 24;
		System.out.println(
				"\nArray, pesquisa do valor " + valueToSearch + " ...");
		int idx = Arrays.binarySearch(array, valueToSearch);
		if (idx >= 0)
			System.out.println("Indice do " + valueToSearch + " -> " + idx);
		else
			System.out.println("O " + valueToSearch + " não existe no array");

		// Arrays.copyOf(int[] a, int newDim)
		int[] array2 = Arrays.copyOf(array, 5);
		System.out.println("\nArray2 =  Arrays.copyOf(array, 5)  ...");
		System.out.println("array2 -> " + Arrays.toString(array2));

		// Arrays.copyOfRange(int[] a, int from, int to)
		int[] array3 = Arrays.copyOfRange(array, 5, 10);
		System.out.println("\nArray3 =  Arrays.copyOfRange(array, 5, 10)  ...");
		System.out.println("array3 -> " + Arrays.toString(array3));

		// Arrays.copyOf(int[] a, int newDim)
		int[] array4 = Arrays.copyOf(array, 5);
		System.out.println("\nArray4 =  Arrays.copyOf(array, 5)  ...");
		System.out.println("array4 -> " + Arrays.toString(array4));

		// Arrays.equals(int[] a, int[] b)
		System.out.println("array2 == array4 -> " + (array2 == array4));
		System.out
				.println("array2.equals(array4) -> " + (array2.equals(array4)));
		boolean theyAreEquals = Arrays.equals(array2, array4);
		System.out
				.println("\nArrays.equals(array2, array4) -> " + theyAreEquals);
		System.out.println("array2.equals(array4) -> " + array2.equals(array4));

		
		
		Integer[] ia1 = { 10, 20, 30 };
		Integer[] ia2 = { 11, 21, 31 };
		Integer[][] i1 = { ia1, ia2 };
		Integer[] ia3 = { 10, 20, 30 };
		Integer[] ia4 = { 11, 21, 31 };
		Integer[][] i2 = { ia3, ia4 };
		System.out.println("\ni1.toString() -> " + i1);
		System.out.println("i2.toString() -> " + i2);
		System.out.println("Arrays.toString(i1) -> " + Arrays.toString(i1));
		System.out.println("Arrays.toString(i2) -> " + Arrays.toString(i2));
		System.out.println(
				"Arrays.deepToString(i1) -> " + Arrays.deepToString(i1));
		System.out.println(
				"Arrays.deepToString(i2) -> " + Arrays.deepToString(i2));
		theyAreEquals = Arrays.equals(i1, i2);
		System.out.println("\nArrays.equals(i1, i2) -> " + theyAreEquals);
		System.out.println("i1.equals(i2) -> " + i1.equals(i2));
		System.out.println("i1.deepEquals(i2) -> " + Arrays.deepEquals(i1, i2));

		// System.arrayCopy(Object src, int srcPos, Object dest, int destPos,
		// int length)
		System.arraycopy(array2, 0, array3, 1, 3);
		System.out.println("\nSystem.arraycopy(array2, 0, array3, 1, 3)");
		System.out.println("array3 -> " + Arrays.toString(array3));

	}

	/**
	 * Initialize the array with random values between lowerBound and
	 * upperBound. Com lowerBound = 10 e upperBound = 20, inicializa o array com
	 * avalores entre 10 e 19
	 */
	public static void initRandomArray(int[] array, int lowerBound,
			int upperBound) {
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * (upperBound - lowerBound)
					+ lowerBound);
		}
	}

}
