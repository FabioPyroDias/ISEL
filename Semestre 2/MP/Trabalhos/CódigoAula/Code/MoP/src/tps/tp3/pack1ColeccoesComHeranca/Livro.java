package tps.tp3.pack1ColeccoesComHeranca;

/**
 * Classe que deverá suportar um livro
 */
public class Livro extends Obra {

	// número de páginas
	private int numPaginas;

	// preço do livro
	private float preco;

	// array de autores, este array não deve ter nulls
	private String[] autores;

	/**
	 * Deve criar um novo livro com os dados recebidos. O número de páginas não
	 * pode ser menor que 1. O preço não pode ser negativo. O array de autores
	 * não deve conter nem nulls e deve conter pelo menos um autor válido. Não
	 * pode haver repetições dos nomes dos autores, considera-se os nomes sem os
	 * espaços extra (ver removeExtraSpaces). Este método deve utilizar os
	 * métodos auxiliares existentes. Em caso de nome inválido deve lançar uma
	 * excepção de IllegalArgumentException com a indicação do erro ocorrido
	 */
	public Livro(String titulo, int numPaginas, float preco, String[] autores) {
		// TODO
		super(titulo);
	}

	/**
	 * Devolve o número de páginas do livro
	 */
	public int getNumPaginas() {
		// TODO
		return 0;
	}

	/**
	 * Devolve o preço do livro
	 */
	public float getPreco() {
		// TODO
		return 0;
	}

	/**
	 * Devolve true se o autor recebido existe como autor do livro. O nome
	 * recebido não contém espaços extra.
	 */
	public boolean contemAutor(String autorNome) {
		// TODO
		return false;
	}

	/**
	 * Devolve uma cópia do array de autores do livro
	 */
	public String[] getAutores() {
		// TODO
		return null;
	}

	/**
	 * Devolve uma string com a informação do livro (ver outputs desejados)
	 */
	public String toString() {
		return super.toString() + ", autores " /* + ... */;
	}

	/**
	 * Iguais se equais no contexto de obra e se o objecto recebido for um Livro.
	 * Deve utilizar o método equals de Obra
	 */
	public boolean equals(Object l) {
		return false;
	}
	


	/**
	 * main
	 */
	public static void main(String[] args) {

		// constructor e toString
		Livro l = new Livro("Viagem aos Himalaias", 340, 12.3f,
				new String[] { "João Mendonça", "Mário Andrade" });
		System.out.println("Livro -> " + l);
		l.print("");
		l.print("-> ");
		System.out.println();

		// contém autor
		String autorNome = "Mário Andrade";
		System.out.println("Livro com o autor " + autorNome + "? -> "
				+ l.contemAutor(autorNome));
		autorNome = "Mário Zambujal";
		System.out.println("Livro com o autor " + autorNome + "? -> "
				+ l.contemAutor(autorNome));
		System.out.println();

		// equals
		System.out.println("Livro: " + l);
		System.out.println("equals Livro: " + l);
		System.out.println(" -> " + l.equals(l));

		Livro l2 = new Livro("Viagem aos Himalaias", 100, 10.3f,
				new String[] { "Vitor Záspara" });
		System.out.println("Livro: " + l);
		System.out.println("equals Livro: " + l2);
		System.out.println(" -> " + l.equals(l2));
		System.out.println();

		// testes que dão excepção - mostra-se a excepção

		// livro lx1
		System.out.println("Livro lx1: ");
		try {
			Livro lx1 = new Livro("Viagem aos Himalaias", -1, 12.3f,
					new String[] { "João Mendonça", "Mário Andrade" });
			System.out.println("Livro lx1: " + lx1);
		} catch (IllegalArgumentException ex) {
			ex.printStackTrace();
		}
		System.out.println();

		// livro lx2
		System.out.println("Livro lx2: ");
		try {
			Livro lx2 = new Livro("Viagem aos Himalaias", 200, -12.3f,
					new String[] { "João Mendonça", "Mário Andrade" });
			System.out.println("Livro lx2: " + lx2);
		} catch (IllegalArgumentException ex) {
			ex.printStackTrace();
		}
		System.out.println();

		// livro lx3
		System.out.println("Livro lx3: ");
		try {
			Livro lx3 = new Livro(null, 200, -12.3f,
					new String[] { "João Mendonça", "Mário Andrade" });
			System.out.println("Livro lx3: " + lx3);
		} catch (IllegalArgumentException ex) {
			ex.printStackTrace();
		}
		System.out.println();

		// livro lx4
		System.out.println("Livro lx4: ");
		try {
			Livro lx4 = new Livro("Viagem aos Himalaias", 200, 12.3f,
					new String[] { "João Mendonça", "Mário Andrade",
							"João Mendonça" });
			System.out.println("Livro lx4: " + lx4);
		} catch (IllegalArgumentException ex) {
			ex.printStackTrace();
		}
	}
}
