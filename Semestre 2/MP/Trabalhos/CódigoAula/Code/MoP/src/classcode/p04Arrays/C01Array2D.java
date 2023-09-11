package classcode.p04Arrays;

/**
 * Teste aos arrays 2d
 */
public class C01Array2D {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// tabela é um array de 10 posições de int[20]
		int[][] tabela = new int[10][20];

		System.out.print("Inicialização da tabela .............");
		System.out.println();

		// preencher o array com valor de 0 a 99
		// colocar uma linha de cabeçalho
		System.out.print("n coluna -> ");
		for (int x = 0; x < tabela[0].length; ++x) {
			System.out.print((x < 10 ? "0" + x : x) + " ");
		}
		System.out.println();
		for (int y = 0; y < tabela.length; ++y) {
			System.out.print("Linha " + y + "  -> ");
			for (int x = 0; x < tabela[0].length; ++x) {
				// acesso para escrita
				tabela[y][x] = (int) (Math.random() * 100);
				System.out.print(".. ");
			}
			System.out.println();
		}

		System.out.println();

		// mostrar o seu conteúdo
		System.out.print("Mostrar o conteúdo da tabela .............");
		System.out.println();
		// colocar uma linha de cabeçalho
		System.out.print("n coluna -> ");
		for (int x = 0; x < tabela[0].length; ++x) {
			System.out.print((x < 10 ? "0" + x : x) + " ");
		}
		System.out.println();
		for (int y = 0; y < tabela.length; ++y) {
			System.out.print("Linha " + y + "  -> ");
			for (int x = 0; x < tabela[0].length; ++x) {
				// acesso para leitura
				System.out
						.print((tabela[y][x] < 10 ? "0" : tabela[y][x]) + " ");
				// System.out.format("%02d ", tabela[y][x]);
			}
			System.out.println();
		}
	}

}
