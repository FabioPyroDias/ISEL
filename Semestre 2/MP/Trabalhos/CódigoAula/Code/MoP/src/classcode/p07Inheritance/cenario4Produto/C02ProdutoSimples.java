package classcode.p07Inheritance.cenario4Produto;

public class C02ProdutoSimples extends C01ProdutoBase {

	// preço do produto
	private int preco;

	// stock do produto
	private int stock = 0;

	//
	//
	// ### Métodos ### -------------------------------------------------

	/**
	 * constructor
	 */
	public C02ProdutoSimples(String name, int preco, int initialStock) {
		super(name);
		this.preco = preco;
		stock = initialStock;
	}

	/**
	 * Devolve a descrição do produto
	 * 
	 * @return a descrição do produto
	 */
	public String getDescricao() {
		return "produto simples";
	}

	/**
	 * Devolve o preço do produto
	 * 
	 * @return o preço do produto
	 */
	public int getPreco() {
		return preco;
	}

	/**
	 * Devolve o stock deste do produto
	 * 
	 * @return o stock deste produto
	 */
	public int getStock() {
		return stock;
	}


	/**
	 * main
	 */
	public static void main(String[] args) {
		// um produto simples
		C02ProdutoSimples p1 = new C02ProdutoSimples(
				"Sapatilhas Mike Air Blue Mountain", 60, 100);
		p1.print("p1 -> ");
		System.out.println(p1);
	}

}
