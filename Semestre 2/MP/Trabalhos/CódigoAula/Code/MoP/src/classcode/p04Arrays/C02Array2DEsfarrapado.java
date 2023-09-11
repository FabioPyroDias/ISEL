package classcode.p04Arrays;

/**
 * Teste a um array 2d esfarrapado, ou seja um array em que a 2ª dimensão pode
 * variar para cada elemento da 1ª dimensão
 */
public class C02Array2DEsfarrapado {

	/**
	 * main
	 */
	public static void main(String[] args) {

		// criar a primeira dimensão
		int[][] tabela2 = new int[11][];

		// criar a segunda dimensão, que é variável e inicializar o array
		for (int y = 0; y < tabela2.length; ++y) {
			// a 2ª dimensão varia
			tabela2[y] = new int[y < 6 ? y + 1 : 11 - y];
			// inicializar o elementos do array
			for (int x = 0; x < tabela2[y].length; ++x) {
				tabela2[y][x] = (int) (Math.random() * 100);
			}
		}

		// mostrar o array na consola
		for (int y = 0; y < tabela2.length; ++y) {
			for (int x = 0; x < tabela2[y].length; ++x) {
				System.out.print(tabela2[y][x] + " ");
				// System.out.print("#");
			}
			System.out.println();
		}

	}

}
