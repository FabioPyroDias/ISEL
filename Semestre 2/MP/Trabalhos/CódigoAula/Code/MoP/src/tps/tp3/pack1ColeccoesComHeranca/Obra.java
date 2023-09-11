package tps.tp3.pack1ColeccoesComHeranca;

public abstract class Obra {

	private String titulo;

	/**
	 * Constructor
	 */
	public Obra(String titulo) {
		// t�tulo (valida t�tulo e guarda-o)
		// TODO
	}

	/**
	 * Devolve o t�tulo da obra
	 */
	public String getTitulo() {
		// TODO
		return null;
	}

	/**
	 * Devolve o n�mero de p�ginas da obra
	 */
	public abstract int getNumPaginas();

	/**
	 * Devolve o pre�o da obra
	 */
	public abstract float getPreco();

	/**
	 * Deve devolver true se o array conter apenas nomes v�lidos. Cada nome deve ser
	 * validado pelo m�todo validarNome
	 */
	public static boolean validarNomes(String[] nomes) {
		// TODO
		return false;
	}

	/**
	 * Um nome v�lido se n�o for null e conter pelo menos uma letra
	 * (Character.isLetter) e s� conter letras e espa�os (Character.isWhitespace)
	 */
	public static boolean validarNome(String nome) {
		// TODO
		return false;
	}

	/**
	 * Recebe um nome j� previamente validado, ou seja s� com letras ou espa�os.
	 * Deve devolver o mesmo nome mas sem espa�os (utilizar trim e
	 * Character.isWhitespace) no in�cio nem no fim e s� com um espa�o ' ' entre
	 * cada nome. Deve utilizar um StringBuilder para ir contendo o nome j�
	 * corrigido
	 */
	public static String removeExtraSpaces(String nome) {
		// TODO
		return null;
	}

	/**
	 * M�todo que verifica se h� elementos repetidos. O array recebido n�o cont�m
	 * nulls.
	 */
	public static boolean haRepeticoes(String[] elems) {
		// TODO
		return false;
	}

	/**
	 * Devolve uma string com a informa��o da obra (ver outputs desejados e m�todo
	 * toString de Livro)
	 */
	public String toString() {
		// TODO
		return null;
	}

	/**
	 * Deve mostrar na consola a informa��o da obra (toString) precedida do prefixo
	 * recebido
	 */
	public void print(String prefix) {
		// TODO
	}

	/**
	 * O Object recebido � igual, se n�o for null, se for uma obra e se tiver o
	 * mesmo t�tulo que o t�tulo da obra corrente
	 */
	public boolean equals(Object l) {
		// TODO
		return false;
	}

}