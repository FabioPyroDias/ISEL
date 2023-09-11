package classcode.p08AbstractClassesAndInterfaces;

public class C04ProdutoSimples extends C03ProdutoBase {

	// preço do produto
	private int preco;

	// stock do produto
	private int stock = 0;

	/**
	 * constructor
	 */
	public C04ProdutoSimples(String name, int preco, int initialStock) {
		super(name);
		this.preco = preco;
		stock = initialStock;
	}

	/**
	 * get descricao
	 */
	public String getDescricao() {
		return "produto simples";
	}

	/**
	 * get preço - deve devolver o preço do produto
	 */
	public int getPreco() {
		return preco;
	}

	/**
	 * get stock - deve devolver o número de unidades que se podem vender do
	 * produto
	 */
	public int getStock() {
		return stock;
	}

	/**
	 * main
	 */
	public static void main(String[] args) {
		// um produto simples
		C04ProdutoSimples p1 = new C04ProdutoSimples(
				"Sapatilhas Mike Air Blue Mountain", 60, 100);
		System.out.println("p1 -> " + p1);
		System.out.println();
	}

}
