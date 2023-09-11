package classcode.p04Arrays;

/**
 * Teste aos arrays 2d utilizando métodos
 */
public class C03Array2DWithMethods {

	/**
	 * main
	 */
	public static void main(String[] args) {
		// tabela é um array de 10 posições de int[20]
		int[][] tabela = new int[10][20];

		// inicializar o array com valores aleatórios entre 0 e 99
		System.out.println("Inicialização do array.....");
		initRandomArray(tabela, 0, 91);
		System.out.println();

		// mostrar o array
		System.out.println("Print do array.....");
		printArray2d(tabela);
		System.out.println();

		// mostrar o array com os headers
		int nDigist = howManyDigist(tabela);
		System.out.println("Print do array com headers.....");
		printArray2dWithHeaders(tabela, nDigist);
		System.out.println();

		// criar um novo array com soma de 10 nos seus elementos
		System.out.println(
				"Obter um novo array com soma de 10 em cada elemento.....");
		int[][] tabela2 = addValue(tabela, 10);
		System.out.println();

		System.out.println("Print do novo array.....");
		nDigist = howManyDigist(tabela2);
		printArray2dWithHeaders(tabela2, nDigist);

		System.out.println("\nHow many digist -> " + howManyDigist(tabela2));

	}

	/**
	 * Inicializar o array com valores aleatórios entre [lowerBound e
	 * upperBound[
	 */
	public static void initRandomArray(int[][] array, int lowerBound,
			int upperBound) {
		for (int y = 0; y < array.length; ++y) {
			for (int x = 0; x < array[0].length; ++x) {
				// generate a random value in [lowerBound ... upperBound[
				array[y][x] = (int) (Math.random() * (upperBound - lowerBound)
						+ lowerBound);
			}
		}
	}

	/**
	 * Fazer print do array com um espaço entre os elementos
	 */
	public static void printArray2d(int[][] array) {

		for (int y = 0; y < array.length; ++y) {
			for (int x = 0; x < array[0].length; ++x) {
				// print element
				System.out.print(array[y][x] + " ");
			}
			// change line at the end of each row
			System.out.println();
		}
	}

	/**
	 * Fazer print do array colocando headers e ajustando cada elemento para o
	 * número de digitos recebido
	 */
	public static void printArray2dWithHeaders(int[][] array, int ndigist) {

		// construir a string de controlo do format
		String str = "%0" + ndigist + "d ";

		// colocar uma linha de cabeçalho
		System.out.print("n coluna -> ");
		for (int x = 0; x < array[0].length; ++x) {
			// System.out.print((x < 10 ? "0" + x : x) + " ");
			System.out.format(str, x);
		}
		System.out.println();
		for (int y = 0; y < array.length; ++y) {
			System.out.print("Linha " + y + "  -> ");
			for (int x = 0; x < array[0].length; ++x) {
				// escrever o elemento
				System.out.format(str, array[y][x]);
			}
			// change line at the end of each row
			System.out.println();
		}
	}

	/**
	 * Devolve número de digitos necessário para descrever o valor máximo no
	 * array, assume que só há valores positivos
	 */
	private static int howManyDigist(int[][] array) {
		int max = maxArray2d(array);

		// positive digits
		int nPosdigits = 1;
		for (int m = max; m > 9; m /= 10)
			nPosdigits++;

		// return result
		return nPosdigits;
	}

	/**
	 * Devolve o valor máximo existente no array
	 */
	public static int maxArray2d(int[][] array) {
		int max = array[0][0];
		for (int y = 0; y < array.length; ++y) {
			for (int x = 0; x < array[0].length; ++x) {
				if (array[y][x] > max)
					max = array[y][x];
			}
		}
		return max;
	}

	/**
	 * Criar um novo array idêntico ao recebido, mas adicionando value a todos
	 * os elementos
	 * 
	 * @param array
	 *            o array recebido
	 * @param value
	 *            o valor a adicionar
	 * @return o novo array que é um cópia do array recebido, mas com value
	 *         adicionado a todos os elementos
	 */
	public static int[][] addValue(int[][] array, int value) {
		// create base array
		int[][] array2 = new int[array.length][];

		// fill new array with values from received array and argument
		for (int y = 0; y < array.length; ++y) {
			// create array second dimension and fill with values from received
			// array and argument
			array2[y] = new int[array[y].length];
			for (int x = 0; x < array[y].length; ++x) {
				array2[y][x] = array[y][x] + value;
			}
		}
		return array2;
	}

	/**
	 * alternative version of previous method that creates all the array,
	 * assuming that the second dimension is constant
	 */
	public static int[][] addValueV2(int[][] array, int value) {
		// create all the array
		int[][] array2 = new int[array.length][array[0].length];

		// fill new array with values from received array and argument
		for (int y = 0; y < array.length; ++y) {
			for (int x = 0; x < array[y].length; ++x) {
				array2[y][x] = array[y][x] + value;
			}
		}
		return array2;
	}

}
