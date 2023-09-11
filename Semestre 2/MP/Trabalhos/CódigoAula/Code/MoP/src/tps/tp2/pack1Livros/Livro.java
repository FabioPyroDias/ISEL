package tps.tp2.pack1Livros;

/**
 * Classe que dever� suportar um livro
 */
public class Livro {

	// T�tulo do livro
	private String titulo;

	// n�mero de p�ginas
	private int numPaginas;

	// pre�o do livro
	private float preco;

	// array de autores, este array n�o deve ter nulls
	private String[] autores;

	/**
	 * Deve criar um novo livro com os dados recebidos. O t�tulo n�o deve ser
	 * null nem vazio. O n�mero de p�ginas n�o pode ser menor que 1. O pre�o n�o
	 * pode ser negativo. O array de autores n�o deve conter nem nulls e deve
	 * conter pelo menos um autor v�lido. N�o pode haver repeti��es dos nomes
	 * dos autores, considera-se os nomes sem os espa�os extra (ver
	 * removeExtraSpaces). Este m�todo deve utilizar os m�todos auxiliares
	 * existentes. Em caso de nome inv�lido deve lan�ar uma excep��o de
	 * IllegalArgumentException com a indica��o do erro ocorrido
	 */
	public Livro(String titulo, int numPaginas, float preco, String[] autores) {

		// t�tulo
		if (titulo == null || titulo.length() == 0)
			throw new IllegalArgumentException("O titulo tem de ter pelo menos um caracter");
		this.titulo = titulo;
		
		// TODO
		
	}

	/**
	 * Devolve o t�tulo do livro
	 */
	public String getTitulo() {
		// TODO
		return null;
	}

	/**
	 * Devolve o n�mero de p�ginas do livro
	 */
	public int getNumPaginas() {
		// TODO
		return 0;
	}

	/**
	 * Devolve o pre�o do livro
	 */
	public float getPreco() {
		// TODO
		return 0;
	}

	/**
	 * Devolve uma c�pia do array de autores do livro
	 */
	public String[] getAutores() {
		// TODO
		return null;
	}

	/**
	 * Deve devolver true se o array conter apenas nomes v�lidos. Um nome �
	 * v�lido se conter pelo menos uma letra (Character.isLetter) e s� conter
	 * letras e espa�os (Character.isWhitespace). Deve chamar validarNome.
	 */
	public static boolean validarNomes(String[] nomes) {
		// TODO
		return false;
	}

	/**
	 * Um nome v�lido se n�o for null e n�o conter pelo menos uma letra
	 * (Character.isLetter) e s� conter letras e espa�os
	 * (Character.isWhitespace)
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
	 * M�todo que verifica se h� elementos repetidos. O array recebido n�o
	 * cont�m nulls.
	 */
	public static boolean haRepeticoes(String[] elems) {
		// TODO
		return false;
	}

	/**
	 * Devolve true se o autor recebido existe como autor do livro. O nome
	 * recebido n�o cont�m espa�os extra.
	 */
	public boolean contemAutor(String autorNome) {
		// TODO
		return false;
	}

	/**
	 * Devolve uma string com a informa��o do livro (ver outputs desejados)
	 */
	public String toString() {
		// TODO
		return null;
	}

	/**
	 * Deve mostrar na consola a informa��o do livro precedida do prefixo
	 */
	public void print(String prefix) {
		// TODO
	}

	/**
	 * O Livro recebido � igual se tiver o mesmo t�tulo que o t�tulo do livro
	 * corrente
	 */
	public boolean equals(Livro l) {
		// TODO
		return false;
	}

	/**
	 * main
	 */
	public static void main(String[] args) {

		// constructor e toString
		Livro l = new Livro("Viagem aos Himalaias", 340, 12.3f, new String[] { "Jo�o Mendon�a", "M�rio Andrade" });
		System.out.println("Livro -> " + l);
		l.print("");
		l.print("-> ");
		System.out.println();

		// cont�m autor
		String autorNome = "M�rio Andrade";
		System.out.println("Livro com o autor " + autorNome + "? -> " + l.contemAutor(autorNome));
		autorNome = "M�rio Zambujal";
		System.out.println("Livro com o autor " + autorNome + "? -> " + l.contemAutor(autorNome));
		System.out.println();

		// equals
		System.out.println("Livro: " + l);
		System.out.println("equals Livro: " + l);
		System.out.println(" -> " + l.equals(l));

		Livro l2 = new Livro("Viagem aos Himalaias", 100, 10.3f, new String[] { "Vitor Z�spara" });
		System.out.println("Livro: " + l);
		System.out.println("equals Livro: " + l2);
		System.out.println(" -> " + l.equals(l2));
		System.out.println();

		// testes que d�o excep��o - mostra-se a excep��o

		// livro lx1
		System.out.println("Livro lx1: ");
		try {
			Livro lx1 = new Livro("Viagem aos Himalaias", -1, 12.3f, new String[] { "Jo�o Mendon�a", "M�rio Andrade" });
			System.out.println("Livro lx1: " + lx1);
		} catch (IllegalArgumentException ex) {
			ex.printStackTrace();
		}
		System.out.println();

		// livro lx2
		System.out.println("Livro lx2: ");
		try {
			Livro lx2 = new Livro("Viagem aos Himalaias", 200, -12.3f,
					new String[] { "Jo�o Mendon�a", "M�rio Andrade" });
			System.out.println("Livro lx2: " + lx2);
		} catch (IllegalArgumentException ex) {
			ex.printStackTrace();
		}
		System.out.println();

		// livro lx3
		System.out.println("Livro lx3: ");
		try {
			Livro lx3 = new Livro(null, 200, -12.3f, new String[] { "Jo�o Mendon�a", "M�rio Andrade" });
			System.out.println("Livro lx3: " + lx3);
		} catch (IllegalArgumentException ex) {
			ex.printStackTrace();
		}
		System.out.println();

		// livro lx4
		System.out.println("Livro lx4: ");
		try {
			Livro lx4 = new Livro("Viagem aos Himalaias", 200, 12.3f,
					new String[] { "Jo�o Mendon�a", "M�rio Andrade", "Jo�o Mendon�a" });
			System.out.println("Livro lx4: " + lx4);
		} catch (IllegalArgumentException ex) {
			ex.printStackTrace();
		}
	}
}

