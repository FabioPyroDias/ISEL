package classcode.p07Inheritance.cenario4Produto;

/*
 * Classe base do cenário.
 * Exemplo formado pelas classes: ProdutoBase, ProdutoSimples e ProdutoComposto
 * 
 * Ver a documentação de cada método, colocar o rato por cima do nome do método
 *  
 */

public class C01ProdutoBase {

	/**
	 * Prefixo a ser utilizado aquando da identação de produtos dentro de um
	 * produtoComposto
	 */
	protected static String PREFIXBASE = "  ";

	/**
	 * Nome do produto
	 */
	private String name;

	//
	//
	// ### Métodos ### -------------------------------------------------

	/**
	 * Método constructor, deve guardar o nome recebido na variável name
	 */
	public C01ProdutoBase(String name) {
		this.name = name;
	}

	/**
	 * Devolve o nome do produto
	 * 
	 * @return o nome do produto
	 */
	public String getName() {
		return name;
	}

	/**
	 * Devolve a descrição do produto
	 * 
	 * @return a descrição do produto
	 */
	public String getDescricao() {
		return null;
	}

	/**
	 * Devolve o preço do produto
	 * 
	 * @return o preço do produto
	 */
	public int getPreco() {
		return 0;
	}

	/**
	 * Devolve o stock deste do produto
	 * 
	 * @return o stock deste produto
	 */
	public int getStock() {
		return 0;
	}

	/**
	 * Devolve uma descrição textual do produto
	 * 
	 * @return uma String com a descrição sumária deste produto
	 */
	public String toString() {
		return getName() + ", " + getDescricao() + ", preço de " + getPreco()
				+ ", stock de " + getStock();
	}

	/**
	 * Mostra na consola a descrição do produto, por omissão essa descrição é o
	 * toString aqui declarado. A descrição deve ser prefixada com o prefixo
	 * recebido.
	 * 
	 * @param prefix
	 *            O prefixo a colocar antes da descrição do objecto
	 */
	public void print(String prefix) {
		// A colocação de this na string, vai implicar a chamada ao método
		// toSTring do objecto.
		// É equivalente a System.out.println(prefix + toString());
		System.out.println(prefix + this);
	}

}
