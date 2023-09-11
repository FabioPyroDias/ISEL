package classcode.p08AbstractClassesAndInterfaces;

public abstract class C03ProdutoBase {

	protected static String PREFIXBASE = "  ";

	private String name;

	/**
	 * constructor
	 */
	public C03ProdutoBase(String name) {
		this.name = name;
	}

	/**
	 * get name
	 */
	public String getName() {
		return name;
	}

	/**
	 * get descricao
	 */
	public abstract String getDescricao();

	/**
	 * get preco
	 */
	public abstract int getPreco();

	/**
	 * get stock - deve devolver o número de unidades que se podem vender deste
	 * produto
	 */
	public abstract int getStock();

	/**
	 * toString - deve devolver uma descrição sumária do produto
	 */
	public String toString() {
		return getName() + ", " + getDescricao() + ", com preço de "
				+ getPreco() + ", com stock de " + getStock();
	}

}
