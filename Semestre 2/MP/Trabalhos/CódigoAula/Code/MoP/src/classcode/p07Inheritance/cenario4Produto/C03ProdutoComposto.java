package classcode.p07Inheritance.cenario4Produto;

/**
 * Exemplo de herança com um array com possibilidade de ter elementos a null
 * entre posições ocupadas. Exemplo do uso de instanceof e casts de classes.
 * 
 */
public class C03ProdutoComposto extends C01ProdutoBase {

	// Suporte aos produtos que este produto composto pode conter - os produtos
	// existentes poderão estar em quaisquer índexes, o que significa que pode
	// haver posições a null em qualquer posição e que não se deve alterar a
	// posição dos produtos uma vez colocados.

	// Os produtos nele contido podem ser produtosSimples ou ProdutosCompostos
	private C01ProdutoBase[] produtos = new C01ProdutoBase[40];

	// Conterá o número de produtos existentes
	private int nProdutos = 0;

	//
	//
	// ### Métodos ### -------------------------------------------------

	/**
	 * constructor
	 */
	public C03ProdutoComposto(String name) {
		super(name);
	}

	/**
	 * Adicionar um produto a este produto composto, caso o argumento recebido
	 * seja null ou caso não haja espaço.
	 * 
	 * @param produto
	 *            o produto a inserir, pode ser um produto simples ou produto
	 *            composto
	 * @return true se a inserção tiver sido realizada, false caso contrário
	 */
	public boolean addProduto(C01ProdutoBase produto) {
		if (produto == null || nProdutos == produtos.length)
			return false;

		for (int i = 0; i < produtos.length; i++) {
			if (produtos[i] == null) {
				produtos[i] = produto;
				nProdutos++;
				return true;
			}
		}

		// nunca deve ocorrer
		return false;
	}

	/**
	 * Remove o primeiro produto encontrado que tiver o mesmo nome que o nome
	 * recebido. Para já só se deve procurar nos produtos directos deste
	 * produtoComposto
	 * 
	 * @param name
	 *            O nome do produto a remover
	 * @return O produto removido ou null se não encontrar um produto com esse
	 *         nome
	 */
	public C01ProdutoBase remProduto(String name) {
		// Percorrer todos os produtos do produtoComposto
		// O for só deve continuar até atingirmos os nProdutos consultados
		for (int i = 0, nprods = 0; i < produtos.length && nprods < nProdutos; i++) {
			// verificar se a posição i contém um produto
			if (produtos[i] != null) {
				// verificar se o produto na posição i é o produto pretendido
				if (produtos[i].getName().equalsIgnoreCase(name)) {
					// remover e devolver o produto
					C01ProdutoBase prod = produtos[i];
					produtos[i] = null;
					nProdutos--;
					return prod;
				}
				// incrementar o número de produtos consultados
				nprods++;
			}
		}

		// significa que não encontrou nenhum produto com o nome recebido
		return null;
	}

	/**
	 * Devolve a descrição do produto
	 * 
	 * @return a descrição do produto
	 */
	public String getDescricao() {
		return "produto composto com " + nProdutos + " produtos";
	}

	/**
	 * Devolve o preço total dos vários produtos dentro dele. Deve-se considerar
	 * o preço de uma unidade de cada produto.
	 * 
	 * @return o preço total do produto composto
	 */
	public int getPreco() {
		int preco = 0;
		// percorrer o array até se ter consultado nProdutos produtos
		for (int i = 0, nprods = 0; i < produtos.length && nprods < nProdutos; i++) {
			if (produtos[i] != null) {
				preco += produtos[i].getPreco();
				nprods++;
			}
		}
		return preco;
	}

	/**
	 * Devolve o stock deste do produto composto. O valor a devolver será o
	 * número de vendas que se poderão realizar deste produto. Considera-se que
	 * o produto composto, para efeitos de venda e stock, é composto por uma
	 * unidade de cada produto nele contido.
	 * 
	 * @return o stock deste produto
	 */
	public int getStock() {

		// sem produtos o stock é zero
		if (nProdutos == 0)
			return 0;

		// para conter o valor mínimo dos stocks de todos os produtos
		int minStock = 0;

		// inicializar o minStock com o stock do primeiro produto
		int i = 0;
		for (; i < produtos.length; i++) {
			if (produtos[i] != null) {
				minStock = produtos[i].getStock();
				i++;
				break;
			}
		}

		// percorrer o array até se ter consultado os nProdutos produtos
		for (int nprods = 1; i < produtos.length && nprods < nProdutos; i++) {
			if (produtos[i] != null) {
				// se este produto tiver um stock inferior ao mínimo, colocá-lo
				// como mínimo
				if (produtos[i].getStock() < minStock)
					minStock = produtos[i].getStock();
			}
		}
		return minStock;
	}

	/**
	 * Devolve o número total de produtos compostos dentro destre produto
	 * composto
	 */
	public int getNumProdutosCompostos() {
		int total = 0;
		for (int i = 0, nprods = 0; i < produtos.length && nprods < nProdutos; i++) {
			if (produtos[i] != null) {

				if (produtos[i] instanceof C03ProdutoComposto) {
					// fazer o cast para produto composto
					C03ProdutoComposto pc = (C03ProdutoComposto) produtos[i];
					// obter o número de produtos compostos dentro desse produto
					// composto, contar com ele mesmo
					total += 1 + pc.getNumProdutosCompostos();
				}

			}
		}
		return total;
	}

	/**
	 * Devolve uma descrição textual do produto
	 * 
	 * @return uma String com a descrição textual deste produto
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
	 * Mostra na consola a descrição do produto. A descrição deve ser prefixada
	 * com o prefixo recebido. Os seus produtos devem ser ainda ser prefixado
	 * previamente com o prefixo por omissão que é o ProdutoBase.PREFIXBASE
	 * 
	 * @param prefix
	 *            O prefixo a colocar antes da descrição do objecto
	 */
	public void print(String prefix) {

		// header do produto
		System.out.println(prefix + super.toString());

		// percorrer todos os seus produtos
		for (int i = 0, nprods = 0; i < produtos.length && nprods < nProdutos; i++) {
			if (produtos[i] != null) {
				produtos[i].print(PREFIXBASE + prefix);
			}
		}
	}

	/**
	 * main
	 */
	public static void main(String[] args) {

		// um produto composto
		C03ProdutoComposto pcOutDoor = new C03ProdutoComposto("PackOutdoor");
		pcOutDoor.addProduto(new C02ProdutoSimples("Sapatilhas Mike Air Blue Mountain", 60, 100));
		pcOutDoor.addProduto(new C02ProdutoSimples("Calças desportivas Axics Jungle treck", 25, 200));

		// um produto composto com um artigo composto dentro
		C03ProdutoComposto pc1 = new C03ProdutoComposto("PackPrimavera");
		pc1.addProduto(new C02ProdutoSimples("Mochila The South Face Sunny Walk", 40, 300));
		pc1.addProduto(new C02ProdutoSimples("Binóculos Laica Bright View", 80, 50));
		pc1.addProduto(pcOutDoor);
		pc1.addProduto(new C02ProdutoSimples("T-Shirt Domyous Spring Forest", 6, 500));
		pc1.addProduto(new C02ProdutoSimples("Kayak Melo Amazonas 500", 740, 30));

		// chamada ao toString e print de um produto composto
		System.out.println("pc1 -> " + pc1);
		System.out.println();

		pc1.print("");
		System.out.println();

		int n = pc1.getNumProdutosCompostos();
		System.out.println("pc1.getNumProdutosCompostos() -> " + n);
		System.out.println();

		// remover um produto simples
		C01ProdutoBase result = pc1.remProduto("Binóculos Laica Bright View");
		System.out.println("pc1.remProduto(\"Binóculos Laica Bright View\") -> " + result);
		pc1.print("");
		System.out.println();

		// remover um produto composto
		result = pc1.remProduto("PackOutdoor");
		System.out.println("pc1.remProduto(\"PackOutdoor\") -> " + result);
		pc1.print("");
		System.out.println();

		// remover um produto simples
		result = pc1.remProduto("Kayak Melo Amazonas 500");
		System.out.println("pc1.remProduto(\"Kayak Melo Amazonas 500\") -> " + result);
		pc1.print("");
		System.out.println();

		// remover um produto simples inexistente
		result = pc1.remProduto("Kayak Melo Amazonas 500");
		System.out.println("pc1.remProduto(\"Kayak Melo Amazonas 500\") -> " + result);
		pc1.print("");
		System.out.println();

	}
}
