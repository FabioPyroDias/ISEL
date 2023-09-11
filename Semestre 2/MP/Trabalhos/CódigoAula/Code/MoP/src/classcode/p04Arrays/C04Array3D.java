package classcode.p04Arrays;

/**
 * Teste aos arrays 3D
 */
public class C04Array3D {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int lowerBoud = 0;
		int upperBound = 100;

		// criar um array 3D, y, x, z
		int[][][] array3d = new int[10][10][10];

		// inicializa o array com valores entre lowerBound e upperBound
		initRandomArray3D(array3d, lowerBoud, upperBound);

		// imprime o array como um array 2d indicando para cada [y,x] quantos
		// valores em z são maiores que o valor médio entre lowerBound e
		// upperBound
		printHowManyAboveValueInArray3D(array3d, (upperBound - lowerBoud) / 2);

	}

	/**
	 * Inicializa o array com valores entre [lowerBound e upperBound[
	 */
	public static void initRandomArray3D(int[][][] array, int lowerBound,
			int higherBound) {
		for (int y = 0; y < array.length; ++y) {
			for (int x = 0; x < array[y].length; ++x) {
				for (int z = 0; z < array[y][x].length; ++z) {
					array[y][x][z] = (int) (Math.random()
							* (higherBound - lowerBound) + lowerBound);
				}
			}
		}
	}

	/**
	 * Print o array indicando para cada [y][x] quantos valores em Z são maiores
	 * que value
	 */
	public static void printHowManyAboveValueInArray3D(int[][][] array,
			int value) {
		for (int y = 0; y < array.length; ++y) {
			System.out.print("linha " + y + " -> ");
			for (int x = 0; x < array[y].length; ++x) {
				int n = 0;
				for (int z = 0; z < array[y][x].length; ++z) {
					if (array[y][x][z] > value)
						n++;
				}
				System.out.print(n + " ");
			}
			System.out.println();
		}
	}

}
