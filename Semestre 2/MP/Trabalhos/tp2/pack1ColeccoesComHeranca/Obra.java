package pack1ColeccoesComHeranca;

public abstract class Obra {

	private String titulo;

	/**
	 * Constructor
	 */
	public Obra(String titulo) {
		// título (valida título e guarda-o)
		// TODO
	}

	/**
	 * Devolve o título da obra
	 */
	public String getTitulo() {
		// TODO
		return null;
	}

	/**
	 * Devolve o número de páginas da obra
	 */
	public abstract int getNumPaginas();

	/**
	 * Devolve o preço da obra
	 */
	public abstract float getPreco();

	/**
	 * Deve devolver true se o array conter apenas nomes válidos. Cada nome deve ser
	 * validado pelo método validarNome
	 */
	public static boolean validarNomes(String[] nomes) {
		// TODO
		return false;
	}

	/**
	 * Um nome válido se não for null e conter pelo menos uma letra
	 * (Character.isLetter) e só conter letras e espaços (Character.isWhitespace)
	 */
	public static boolean validarNome(String nome) {
		// TODO
		return false;
	}

	/**
	 * Recebe um nome já previamente validado, ou seja só com letras ou espaços.
	 * Deve devolver o mesmo nome mas sem espaços (utilizar trim e
	 * Character.isWhitespace) no início nem no fim e só com um espaço ' ' entre
	 * cada nome. Deve utilizar um StringBuilder para ir contendo o nome já
	 * corrigido
	 */
	public static String removeExtraSpaces(String nome) {
		// TODO
		return null;
	}

	/**
	 * Método que verifica se há elementos repetidos. O array recebido não contém
	 * nulls.
	 */
	public static boolean haRepeticoes(String[] elems) {
		// TODO
		return false;
	}

	/**
	 * Devolve uma string com a informação da obra (ver outputs desejados e método
	 * toString de Livro)
	 */
	public String toString() {
		// TODO
		return null;
	}

	/**
	 * Deve mostrar na consola a informação da obra (toString) precedida do prefixo
	 * recebido
	 */
	public void print(String prefix) {
		// TODO
	}

	/**
	 * O Object recebido é igual, se não for null, se for uma obra e se tiver o
	 * mesmo título que o título da obra corrente
	 */
	public boolean equals(Object l) {
		// TODO
		return false;
	}

}