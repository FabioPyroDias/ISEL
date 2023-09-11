package tps.tp3.pack1ColeccoesComHeranca;

import java.util.Arrays;

/**
 * Classe Coleccao, deve conter a descri��o de uma colec��o, com t�tulo, os seus
 * livros, colec��es e editores. Deve utilizar heran�a para guardar os livros e
 * as colec��es num s� array
 */
public class Coleccao extends Obra {
	// prefixo a colocar no in�cio de cada print mais interno que o corrente
	public static final String GENERALPREFIX = "  ";

	// n�mero m�ximo de obras de uma colec��o
	private static int MAXOBRAS = 20;

	// Array de obras, de Livros ou Colecc��e, em que estas devem encontrar-se
	// sempre nos menores �ndices e pela ordem de registo
	// TODO
	// private ...[] obras = new ...[MAXOBRAS];

	// dever� conter sempre o n�mero de obras na colec��o
	private int numObras = 0;

	// Editores, tem as mesmas condicionantes que array de autores na classe
	// livro
	private String[] editores;

	/**
	 * Construtor; o t�tulo deve ser guardado e validado na clase obra; o array de
	 * editores devem ser pelo menos um e tem as mesmas restri��es que os autores
	 * dos livros;
	 */
	public Coleccao(String titulo, String[] editores) {
		// TODO
		super(titulo);
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
	 * desconto de 20% nesses livros. As colec��es em que o somat�rio de p�ginas das
	 * suas subcolec��es directas seja igual ou superior ao qu�druplo do n� de
	 * p�ginas da sua subcolec��o directa com mais p�ginas dever�o aplicar um
	 * desconto de 10% sobre os pre�os das suas subcolec��es
	 */

	public float getPreco() {
		// TODO
		return 0;
	}

	/**
	 * Adiciona uma obra � colec��o se puder, se esta n�o for null e a colec��o n�o
	 * ficar com obras com iguais no seu n�vel imediato. Deve utilizar o m�todo
	 * getIndexOfLivro e getIndexOfColeccao
	 */
	public boolean addObra(Obra obra) {
		// TODO
		return false;
	}

	/**
	 * Devolve o index no array de obras onde estiver a obra com o nome pretendido.
	 * Devolve -1 caso n�o o encontre
	 */
	private int getIndexOfObra(String titulo) {
		// TODO
		return 0;
	}

	/**
	 * Remove do array a obra com o t�tulo igual ao t�tulo recebido. Devolve a obra
	 * removida ou null caso n�o tenha encontrado a obra. Deve-se utilizar o m�todo
	 * getIndexOfLivro. Recorda-se que as obras ocupam sempre os menores �ndices, ou
	 * seja, n�o pode haver nulls entre elas.
	 */
	public Obra remObra(String titulo) {
		// TODO
		return null;
	}

	/**
	 * Remove todas as obras (livros ou colec��es) dentro da obra corrente, que
	 * tenham um t�tulo igual ou t�tulo recebido. Devolve true se removeu pelo menos
	 * uma obra, ou false caso n�o tenha trealizado qualquer remo��o. Deve utilizar
	 * os m�todos remObra e remAllObra.
	 */
	public boolean remAllObra(String titulo) {
		// TODO
		return false;
	}

	/**
	 * Devolve o n� de obras de uma pessoa. Cada colec��o deve contabilizar-se como
	 * uma obra para os editores.
	 */
	public int getNumObrasFromPerson(String autorEditor) {
		// TODO
		return 0;
	}

	/**
	 * Deve devolver um novo array, sem repeti��es, com os livros de que o autor
	 * recebido � autor. O array devolvido n�o deve conter repeti��es, para excluir
	 * as repeti��es devem utilizar o m�todo mergeWithoutRepetitions
	 */
	public Livro[] getLivrosComoAutor(String autorNome) {
		// TODO
		return null;
	}

	/**
	 * Deve devolver um array, sem nulls, com todos os autores e editores existentes
	 * na colec��o. O resultado n�o deve conter repeti��es. Deve utilizar o m�todo
	 * mergeWithoutRepetitions
	 */
	public String[] getAutoresEditores() {
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
	 * Devolve o n� de livros dentro da colec��o
	 */
	public int getNumLivros() {
		// TODO
		return 0;
	}

	/**
	 * Devolve o n� de colec��es dentro da colec��o
	 */
	public int getNumColeccoes() {
		// TODO
		return 0;
	}

	/**
	 * Devolve a profundidada de m�xima de uma colec��o em termos de colecc�es
	 * dentro de colecc��es: uma colec��o c1 com uma colec��o c2 dentro, c1 deve
	 * devolver 2 e c2 deve devolver 1, independentemente do n�mero do conte�do de
	 * cada uma.
	 */
	public int getProfundidade() {
		// TODO
		return 0;
	}

	/**
	 * Duas colec��es s�o iguais se tiverem o mesmo t�tulo e a mesma lista de
	 * editores. Deve utilizar o equals da classe Obra. Para verificar verificar se
	 * os editores s�o os mesmos devem utilizar o m�todo mergeWithoutRepetitions
	 */
	public boolean equals(Object c) {
		// TODO
		return false;
	}

	/**
	 * Deve devolver uma string compat�vel com os outputs desejados
	 */
	public String toString() {
		// TODO
		return null;
	}

	/**
	 * Mostra uma colec��o segundo os outputs desejados. Deve utilizar o m�todo
	 * print da classe Obra.
	 */
	public void print(String prefix) {
		// TODO
	}

	/**
	 * main
	 */
	public static void main(String[] args) {
		Livro l1 = new Livro("Viagem aos Himalaias", 340, 12.3f, new String[] { "Jo�o Mendon�a", "M�rio Andrade" });
		Livro l2 = new Livro("Viagem aos Pirin�us", 270, 11.5f, new String[] { "Jo�o Mendon�a", "J�lio Pomar" });

		Coleccao c1 = new Coleccao("Primavera", new String[] { "Jo�o Mendon�a", "Manuel Alfazema" });

		boolean res;

		res = c1.addObra(l1);
		res = c1.addObra(l2);
		System.out.println("c1 -> " + c1);
		c1.print("");
		System.out.println();

		// adicionar um livro com nome de outro j� existente
		res = c1.addObra(l2);
		System.out.println("adi��o novamente de Viagem aos Pirin�us a c1 -> " + res);
		System.out.println("c1 -> " + c1);
		System.out.println();

		// Outra colec��o
		Livro l21 = new Livro("Viagem aos Himalaias 2", 340, 12.3f, new String[] { "Jo�o Mendon�a", "M�rio Andrade" });
		Livro l22 = new Livro("Viagem aos Pirin�us 2", 270, 11.5f, new String[] { "Jo�o Mendon�a", "J�lio Pomar" });

		Coleccao cx2 = new Coleccao("Outono", new String[] { "Jo�o Mendon�a", "Manuel Antunes" });
		cx2.addObra(l21);
		cx2.addObra(l22);
		System.out.println("cx2 -> " + cx2);
		cx2.print("");
		System.out.println();

		// adicion�-la a c1
		c1.addObra(cx2);
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
		Livro[] livros = c1.getLivrosComoAutor(nome);
		System.out.println("Livros de " + nome + " -> " + Arrays.toString(livros));
		System.out.println();
		System.out.println();

		// testes aos m�todos getNumLivros, getNumColeccoes e getProfundidade
		c1.print("");
		System.out.println("N� de livros na colec��o " + c1.getTitulo() + " -> " + c1.getNumLivros());

		System.out.println("N� de colec��es dentro da colec��o " + c1.getTitulo() + " -> " + c1.getNumColeccoes());

		System.out.println("Profundidade da colec��o " + c1.getTitulo() + " -> " + c1.getProfundidade());
		System.out.println("Profundidade da colec��o " + cx2.getTitulo() + " -> " + cx2.getProfundidade());
		System.out.println();

		// rem livro
		String nomeLivro = "Viagem aos Himalaias";
		Obra l = c1.remObra(nomeLivro);
		System.out.println("Remo��o de " + nomeLivro + " -> " + l);
		c1.print("");

	}
}