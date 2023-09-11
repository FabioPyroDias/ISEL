package classcode.p08AbstractClassesAndInterfaces;


public class C05ProdutoComposto extends C03ProdutoBase {

	// suporte aos produtos que este produto composto pode conter - os produtos
	// existentes têm de estar sempre nos menores índexes.
	private C03ProdutoBase[] produtos = new C03ProdutoBase[100];

	// deverá conter sempre o número de produtos existentes
	private int nProdutos = 0;

	/**
	 * constructor
	 */
	public C05ProdutoComposto(String name) {
		super(name);
	}

	/**
	 * add produto - permite adicionar um produto a este produto composto. A
	 * adição deve falhar caso o argumento recebido seja null ou caso não haja
	 * espaço.
	 */
	public boolean addProduto(C03ProdutoBase produto) {
		if (produto == null || nProdutos == produtos.length)
			return false;
		produtos[nProdutos++] = produto;
		return true;
	}

	/**
	 * rem produto - remove o primeiro produto encontrado que tiver o mesmo nome
	 * que o nome recebido. Deve-se então procurar primeiro nos produtos
	 * directamente dentro deste produto composto e só depois se deve procurar
	 * nos produtos compostos dentro dele e sempre pela ordem de adição.
	 */
	public C03ProdutoBase remProduto(String name) {
		// procurar primeiro produtos do próprio produto
		for (int i = 0; i < nProdutos; i++) {
			if (produtos[i].getName().equalsIgnoreCase(name)) {
				C03ProdutoBase oldObj = produtos[i];
				for (int j = i + 1; j < nProdutos; j++) {
					produtos[j - 1] = produtos[j];
				}
				// System.arraycopy(produtos, i + 1, produtos, i, nProdutos - i
				// - 1);
				produtos[nProdutos - 1] = null;
				nProdutos--;
				return oldObj;
			}
		}
		// procurar nos produtos dentro dos produtos compostos que estão dentro
		// do próprio produto
		for (int i = 0; i < nProdutos; i++) {
			if (produtos[i] instanceof C05ProdutoComposto) {
				C03ProdutoBase removedObj = ((C05ProdutoComposto) produtos[i])
						.remProduto(name);
				if (removedObj != null)
					return removedObj;
			}
		}
		return null;
	}

	/**
	 * get descrição
	 */
	public String getDescricao() {
		return "produto composto com " + nProdutos + " produtos";
	}

	/**
	 * get preço - deve devolver o preço total dos vários produtos dentro dele.
	 * Deve-se considerar o preço de uma unidade de cada produto.
	 */
	public int getPreco() {
		int preco = 0;
		for (int i = 0; i < nProdutos; i++) {
			preco += produtos[i].getPreco();
		}
		return preco;
	}

	/**
	 * get stock - deve devolver o stock deste produto composto. O valor a
	 * devolver será o número de vendas que se poderão realizar deste produto.
	 * Considera-se que o produto composto, para efeitos de venda e stock, é
	 * composto de uma unidade de cada produto nele contido. Se contiver um
	 * produto composto, considera-se a venda de uma unidade de cada produto
	 * dentro desse produto composto, e por aí fora...
	 */
	public int getStock() {
		return 0;
	}

	/**
	 * 
	 */
	public String toString() {
		String s = super.toString() + " : [ ";
		for (int i = 0; i < nProdutos; i++) {
			s += produtos[i];
			if (i < nProdutos - 1)
				s += "; ";
		}
		return s + " ]";
	}

	/**
	 * main
	 */
	public static void main(String[] args) {

		// um produto composto
		C05ProdutoComposto pcOutDoor = new C05ProdutoComposto("PackOutdoor");
		pcOutDoor.addProduto(new C04ProdutoSimples(
				"Sapatilhas Mike Air Blue Mountain", 60, 100));
		pcOutDoor.addProduto(new C04ProdutoSimples(
				"Calças desportivas Axics Jungle treck", 25, 200));

		// um produto composto com um artigo composto dentro
		C05ProdutoComposto pc1 = new C05ProdutoComposto("PackPrimavera");
		pc1.addProduto(new C04ProdutoSimples(
				"Mochila The South Face Sunny Walk", 40, 300));
		pc1.addProduto(new C04ProdutoSimples("Binóculos Leca Bright View", 80,
				50));
		pc1.addProduto(pcOutDoor);
		pc1.addProduto(new C04ProdutoSimples("T-Shirt Domyous Spring Forest",
				6, 500));
		pc1.addProduto(new C04ProdutoSimples("Kayak Melo Amazonas 500", 740, 30));

		// chamada ao toString e print de um produto composto
		System.out.println("pc1 -> " + pc1);
		System.out.println();

		// remover um produto simples
		C03ProdutoBase result = pc1.remProduto("Binóculos Leca Bright View");
		System.out.println("pc1.remProduto(\"Binóculos Leca Bright View\") -> "
				+ result);
		System.out.println("pc1 -> " + pc1);
		System.out.println();

		// remover um produto composto
		result = pc1.remProduto("PackOutdoor");
		System.out.println("pc1.remProduto(\"PackOutdoor\") -> " + result);
		System.out.println("pc1 -> " + pc1);
		System.out.println();

		// remover um produto simples
		result = pc1.remProduto("Kayak Melo Amazonas 500");
		System.out.println("pc1.remProduto(\"Kayak Melo Amazonas 500\") -> "
				+ result);
		System.out.println("pc1 -> " + pc1);
		System.out.println();

		// remover um produto simples inexistente
		result = pc1.remProduto("Kayak Melo Amazonas 500");
		System.out.println("pc1.remProduto(\"Kayak Melo Amazonas 500\") -> "
				+ result);
		System.out.println("pc1 -> " + pc1);
		System.out.println();

	}
}
