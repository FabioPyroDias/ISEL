package tps.tp2.pack2Coleccoes;

import java.util.Arrays;

import tps.tp2.pack1Livros.Livro;

/**
 * Classe Coleccao, deve conter a descri��o de uma colec��o, com t�tulo, os seus
 * livros, colec��es e editores
 */
public class Coleccao {
	// n�mero m�ximo de obras de uma colec��o
	private static int MAXOBRAS = 20;

	// prefixo usual
	public static final String GENERALPREFIX = "  ";

	// t�tulo da colec��o
	private String titulo;

	// Array de livros, em que estas encontram-se sempre nos menores �ndices e
	// pela ordem de registo
	private Livro[] livros = new Livro[MAXOBRAS];

	// dever� conter sempre o n�mero de livros na colec��o
	private int numLivros = 0;

	// array de colec��es, estas devem ocupar sempre os menores �ndices
	private Coleccao[] coleccoes = new Coleccao[MAXOBRAS];

	// dever� conter sempre o n�mero de colec��es dentro da colec��o
	private int numColeccoes = 0;

	// Editores, tem as mesmas condicionantes que array de autores na classe
	// livro
	private String[] editores;

	/**
	 * Construtor; o t�tulo tem de ter pelo menos um caracter que n�o seja um
	 * espa�o (Character.isWhitespace); o array de editores devem ser pelo menos
	 * um e t�m as mesmas restri��es que os autores dos livros;
	 */
	public Coleccao(String titulo, String[] editores) {
		// titulo
		if (titulo == null || titulo.length() == 0)
			throw new IllegalArgumentException(
					"O titulo tem de ter pelo menos um caracter");
		this.titulo = titulo;

		// TODO
	}

	/**
	 * 
	 */
	public String getTitulo() {
		// TODO
		return null;
	}

	/**
	 * Obtem o n�mero total de p�ginas da colec��o, p�ginas dos livros e das
	 * colec��es
	 */
	public int getNumPaginas() {
		// TODO
		return 0;
	}

	/**
	 * As colec��es com mais de 5000 p�ginas nos seus livros directos t�m um
	 * desconto de 20% nesses livros. As colec��es em que o somat�rio de p�ginas
	 * das suas subcolec��es directas seja igual ou superior ao qu�druplo do n�
	 * de p�ginas da sua subcolec��o directa com mais p�ginas dever�o aplicar um
	 * desconto de 10% sobre os pre�os das suas subcolec��es
	 */
	public float getPreco() {
		// TODO
		return 0;
	}

	/**
	 * Adiciona um livro � colec��o se puder e este n�o seja null e a colec��o
	 * n�o ficar com livros iguais ao n�vel imediato da colec��o. Deve utilzar o
	 * m�todo getIndexOfLivro e getIndexOfColeccao
	 */
	public boolean addLivro(Livro livro) {
		// TODO
		return false;
	}

	/**
	 * 
	 * Adiciona uma colec��o � colec��o se puder, esta n�o seja null e a
	 * colec��o n�o ficar com obras imediatas com t�tulos repetidos. Deve
	 * utilizar o m�todo getIndexOfLivro e getIndexOfColeccao
	 */
	public boolean addColeccao(Coleccao col) {
		// TODO
		return false;
	}

	/**
	 * Devolve o index no array de livros onde estiver o livro com o nome
	 * pretendido. Devolve -1 caso n�o o encontre
	 */
	private int getIndexOfLivro(String titulo) {
		// TODO
		return -1;
	}

	/**
	 * Devolve o index no array de colec��es onde estiver a colec��o com o nome
	 * pretendido. Devolve -1 caso n�o o encontre
	 */
	private int getIndexOfColeccao(String titulo) {
		// TODO
		return -1;
	}

	/**
	 * Remove do array o livro com o t�tulo igual ao t�tulo recebido. Devolve o
	 * livro removido ou null caso n�o tenha encontrado o livro. Deve-se
	 * utilizar o m�todo getIndexOfLivro. Recorda-se que os livros devem ocupar
	 * sempre os menores �ndices, ou seja, n�o pode haver nulls entre os livros
	 */
	public Livro remLivro(String titulo) {
		// TODO
		return null;
	}

	/**
	 * Remove do array de colec��es a colec��o com o t�tulo igual ao t�tulo
	 * recebido. Devolve a colec��o removida ou null caso n�o tenha encontrado.
	 * Deve-se utilizar o m�todo getIndexOfColeccao. Recorda-se que as colec��es
	 * devem ocupar sempre os menores �ndices, ou seja, n�o pode haver nulls
	 * entre elas
	 */
	public Coleccao remColeccao(String titulo) {
		// TODO
		return null;
	}

	/**
	 * Devolve o n� de obras de uma pessoa. Cada colec��o deve contabilizar-se
	 * como uma obra para os editores.
	 */
	public int getNumObrasFromPerson(String autorEditor) {
		// TODO
		return 0;
	}

	/**
	 * Devolver um novo array (sem nulls) com os livros de que a pessoa recebida
	 * � autor. N�o deve conter repeti��es, para excluir as repeti��es devem
	 * utilizar o m�todo mergeWithoutRepetitions
	 */
	public Livro[] getLivrosComoAutor(String autorNome) {
		// TODO
		return null;
	}

	/**
	 * Deve devolver uma string compat�vel com os outputs desejados
	 */
	public String toString() {
		// TODO
		return null;
	}

	/**
	 * Deve devolver um array, sem nulls, com todos os autores e editores
	 * existentes na colec��o. O resultado n�o deve conter repeti��es. Deve
	 * utilizar o m�todo mergeWithoutRepetitions
	 */
	public String[] getAutoresEditores() {
		// TODO
		return null;
	}

	/**
	 * M�todo que recebendo dois arrays sem repeti��es devolve um novo array com
	 * todos os elementos dos arrays recebidos mas sem repeti��es
	 */
	private static String[] mergeWithoutRepetitions(String[] a1, String[] a2) {
		// TODO
		return null;
	}

	/**
	 * M�todo id�ntico ao m�todo anterior mas agora com arrays de livros
	 */
	private static Livro[] mergeWithoutRepetitions(Livro[] a1, Livro[] a2) {
		// TODO
		return null;
	}

	/**
	 * Devolve true caso a colec��o recebida tenha o mesmo t�tulo e a mesma
	 * lista de editores. Para verificar verificar se os editores s�o os mesmos
	 * devem utilizar o m�todo mergeWithoutRepetitions
	 */
	public boolean equals(Coleccao c) {
		// TODO
		return false;
	}

	/**
	 * Mostra uma colec��o segundo os outputs desejados
	 */
	public void print(String prefix) {
		// TODO
	}

	/**
	 * main
	 */
	public static void main(String[] args) {
		Livro l1 = new Livro("Viagem aos Himalaias", 340, 12.3f,
				new String[] { "Jo�o Mendon�a", "M�rio Andrade" });
		Livro l2 = new Livro("Viagem aos Pirin�us", 270, 11.5f,
				new String[] { "Jo�o Mendon�a", "J�lio Pomar" });

		Coleccao c1 = new Coleccao("Primavera",
				new String[] { "Jo�o Mendon�a", "Manuel Alfazema" });

		boolean res;

		res = c1.addLivro(l1);
		res = c1.addLivro(l2);
		System.out.println("c1 -> " + c1);
		c1.print("");
		System.out.println();

		// adicionar um livro com nome de outro j� existente
		res = c1.addLivro(l2);
		System.out.println(
				"adi��o novamente de Viagem aos Pirin�us a c1 -> " + res);
		System.out.println("c1 -> " + c1);
		System.out.println();

		// Outra colec��o
		Livro l21 = new Livro("Viagem aos Himalaias 2", 340, 12.3f,
				new String[] { "Jo�o Mendon�a", "M�rio Andrade" });
		Livro l22 = new Livro("Viagem aos Pirin�us 2", 270, 11.5f,
				new String[] { "Jo�o Mendon�a", "J�lio Pomar" });

		Coleccao cx2 = new Coleccao("Outono",
				new String[] { "Jo�o Mendon�a", "Manuel Antunes" });
		cx2.addLivro(l21);
		cx2.addLivro(l22);
		System.out.println("cx2 -> " + cx2);
		cx2.print("");
		System.out.println();

		// adicion�-la a c1
		c1.addColeccao(cx2);
		System.out.println("c1 ap�s adi��o da colec��o cx2 -> " + c1);
		c1.print("");
		System.out.println();

		// get editores autores
		String[] ae = c1.getAutoresEditores();
		System.out.println("Autores editores of c1 -> " + Arrays.toString(ae));
		System.out.println();

		// getNumObrasFromPerson
		String nome = "Jo�o Mendon�a";
		int n = c1.getNumObrasFromPerson(nome);
		System.out.println("N� de obras de " + nome + " -> " + n);
		System.out.println();

		// getLivrosComoAutor
		nome = "Jo�o Mendon�a";
		Livro[] obras = c1.getLivrosComoAutor(nome);
		System.out
				.println("Livros de " + nome + " -> " + Arrays.toString(obras));
		System.out.println();

		// rem livro
		String nomeLivro = "Viagem aos Himalaias";
		Livro l = c1.remLivro(nomeLivro);
		System.out.println("Remo��o de " + nomeLivro + " -> " + l);
		c1.print("");
		System.out.println();
	}
}