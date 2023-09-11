package tp2.pack1ColeccoesComHeranca;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Classe Coleccao, deve conter a descrição de uma colecção, com título, os seus
 * livros, colecções e editores. Deve utilizar herança para guardar os livros e
 * as colecções num só array
 */
public class Coleccao extends Obra implements IObra {
	// prefixo a colocar no início de cada print mais interno que o corrente
	public static final String GENERALPREFIX = "  ";

	// número máximo de obras de uma colecção
	private static int MAXOBRAS = 20;

	// Array de obras, de Livros ou Coleccçõe, em que estas devem encontrar-se
	// sempre nos menores índices e pela ordem de registo
	private Obra[] obras = new Obra[MAXOBRAS];

	// deverá conter sempre o número de obras na colecção
	private int numObras = 0;

	// Editores, tem as mesmas condicionantes que array de autores na classe
	// livro
	private String[] editores;

	/**
	 * Construtor; o título deve ser guardado e validado na clase obra; o array de
	 * editores devem ser pelo menos um e tem as mesmas restrições que os autores
	 * dos livros;
	 */
	public Coleccao(String titulo, String[] editores) {
		
		super(titulo);
		
		//Editores
		if(editores == null)
		{
			throw new IllegalArgumentException("O array de editores é null");
		}
		
        String[] novosEditores = new String[editores.length];
        
        for(int editoresIndex = 0; editoresIndex < editores.length; editoresIndex++)
        {
        	if(editores[editoresIndex] == null)
        	{
        		throw new IllegalArgumentException("O array de editores não pode conter nulls");
        	}
        	
        	novosEditores[editoresIndex] = removeExtraSpaces(editores[editoresIndex]);
        }
        
        if(!validarNomes(novosEditores))
		{
			throw new IllegalArgumentException("O array de editores só pode conter nomes válidos");
		}
        
        if(haRepeticoes(novosEditores))
        {
        	throw new IllegalArgumentException("O array de editores contém editores repetidos");
        }
        
        this.editores = novosEditores;
	}

	/**
	 * Obtem o número total de páginas da colecção, páginas dos livros e das
	 * colecções
	 */
	public int getNumPaginas() {
		int paginas = 0;
		
		for(int obrasIndex = 0; obrasIndex < numObras; obrasIndex++)
		{
			paginas += obras[obrasIndex].getNumPaginas();
		}
		
		return paginas;
	}

	/**
	 * As colecções com mais de 5000 páginas nos seus livros directos têm um
	 * desconto de 20% nesses livros. As colecções em que o somatório de páginas das
	 * suas subcolecções directas seja igual ou superior ao quádruplo do nº de
	 * páginas da sua subcolecção directa com mais páginas deverão aplicar um
	 * desconto de 10% sobre os preços das suas subcolecções
	 */
	public float getPreco() {
		
		float precoActual = 0;
		float precoColeccoes = 0;
		int numPaginas = 0;
		int maiorNumPaginas = 0;
		
		for(int index = 0; index < numObras; index++)
		{
			if(obras[index] instanceof Livro)
			{
				Livro obra = (Livro) obras[index];
				numPaginas += obra.getNumPaginas();
				precoActual += obra.getPreco();
			}
		}
		
		if(numPaginas > 5000)
		{
			precoActual = precoActual * 0.8f;
		}
		
		numPaginas = 0;
		
		for(int index = 0; index < numObras; index++)
		{
			if(obras[index] instanceof Coleccao)
			{
				Coleccao obra = (Coleccao) obras[index];
				
				if(obra.getNumPaginas() > maiorNumPaginas)
				{
					maiorNumPaginas = obra.getNumPaginas();
				}
				
				numPaginas += obra.getNumPaginas();
				precoColeccoes += obra.getPreco();
			}
		}
		
		if(numPaginas >= 4 * maiorNumPaginas)
		{
			precoColeccoes = precoColeccoes * 0.9f;
		}
		
		return precoActual + precoColeccoes;
	}

	/**
	 * Adiciona uma obra à colecção se puder, se esta não for null e a colecção não
	 * ficar com obras com iguais no seu nível imediato. Deve utilizar o método
	 * getIndexOfLivro e getIndexOfColeccao
	 */
	public boolean addObra(Obra obra) {
		if(numObras == obras.length || obra == null)
		{
			return false;
		}
		
		if(getIndexOfObra(obra.getTitulo()) != -1)
		{
			return false;
		}
		
		obras[numObras] = obra;
		numObras++;
		
		return true;
	}

	/**
	 * Devolve o index no array de obras onde estiver a obra com o nome pretendido.
	 * Devolve -1 caso não o encontre
	 */
	private int getIndexOfObra(String titulo) {
		
		for(int index = 0; index < numObras; index++)
		{
			if(obras[index].getTitulo().equals(titulo))
			{
				return index;
			}
		}
		
		return -1;
	}

	/**
	 * Remove do array a obra com o título igual ao título recebido. Devolve a obra
	 * removida ou null caso não tenha encontrado a obra. Deve-se utilizar o método
	 * getIndexOfLivro. Recorda-se que as obras ocupam sempre os menores índices, ou
	 * seja, não pode haver nulls entre elas.
	 */
	public Obra remObra(String titulo) {
		
		int obraARemoverIndex = getIndexOfObra(titulo);
		
		if(obraARemoverIndex == -1)
		{
			return null;
		}
		
		Obra obraRemovida = obras[obraARemoverIndex];
		
		Obra[] obrasSemObraRemovida = new Obra[MAXOBRAS];
		
		for(int index = 0; index < obraARemoverIndex; index++)
		{
			obrasSemObraRemovida[index] = obras[index];
		}
		
		for(int index = obraARemoverIndex + 1; index < numObras; index++)
		{
			obrasSemObraRemovida[index - 1] = obras[index];
		}
		
		obras = obrasSemObraRemovida;
		numObras--;
		
		return obraRemovida;
	}

	/**
	 * Remove todas as obras (livros ou colecções) dentro da obra corrente, que
	 * tenham um título igual ou título recebido. Devolve true se removeu pelo menos
	 * uma obra, ou false caso não tenha trealizado qualquer remoção. Deve utilizar
	 * os métodos remObra e remAllObra.
	 */
	public boolean remAllObra(String titulo) {
		
		boolean removeu = false;
		boolean removeuRecursivo = false;
		
		if(remObra(titulo) != null)
		{
			removeu = true;
		}
		
		for(int index = 0; index < numObras; index++)
		{
			if(obras[index] instanceof Coleccao)
			{
				removeuRecursivo = ((Coleccao) obras[index]).remAllObra(titulo);
			}
		}
		
		if(removeu || removeuRecursivo)
		{
			return true;
		}
		
		return false;
	}

	/**
	 * Devolve o nº de obras de uma pessoa. Cada colecção deve contabilizar-se como
	 * uma obra para os editores.
	 */
	public int getNumObrasFromPerson(String autorEditor) {
		
		int numObrasFromPerson = 0;
		
		for(int index = 0; index < numObras; index++)
		{
			if(obras[index] instanceof Livro)
			{
				if(((Livro) obras[index]).contemAutor(autorEditor))
				{
					numObrasFromPerson++;
				}
			}
			else if(obras[index] instanceof Coleccao)
			{
				numObrasFromPerson += ((Coleccao) obras[index]).getNumObrasFromPerson(autorEditor);
			}
		}
		
		for(int editoresIndex = 0; editoresIndex < editores.length; editoresIndex++)
		{
			if(editores[editoresIndex].equals(autorEditor))
			{
				numObrasFromPerson++;
				break;
			}
		}
		
		return numObrasFromPerson;
	}

	/**
	 * Deve devolver um novo array, sem repetições, com os livros de que o autor
	 * recebido é autor. O array devolvido não deve conter repetições, para excluir
	 * as repetições devem utilizar o método mergeWithoutRepetitions
	 */
	public Livro[] getLivrosComoAutor(String autorNome) {
		
		Livro[] livrosDoAutor = new Livro[0];
		
		for(int index = 0; index < numObras; index++)
		{
			if(obras[index] instanceof Livro)
			{
				if(((Livro) obras[index]).contemAutor(autorNome))
				{
					livrosDoAutor = mergeWithoutRepetitions(livrosDoAutor, new Livro[] {(Livro) obras[index]});
				}
			}
			else if(obras[index] instanceof Coleccao)
			{
				livrosDoAutor = mergeWithoutRepetitions(livrosDoAutor, ((Coleccao) obras[index]).getLivrosComoAutor(autorNome));
			}	
		}
		
		return livrosDoAutor;
	}

	/**
	 * Deve devolver um array, sem nulls, com todos os autores e editores existentes
	 * na colecção. O resultado não deve conter repetições. Deve utilizar o método
	 * mergeWithoutRepetitions
	 */
	public String[] getAutoresEditores() {
		
		String[] editoresAutores = editores.clone();
		
		for(int index = 0; index < numObras; index++)
		{
			if(obras[index] instanceof Livro)
			{
				editoresAutores = mergeWithoutRepetitions(editoresAutores, ((Livro) obras[index]).getAutores());
			}
			else if(obras[index] instanceof Coleccao)
			{
				editoresAutores = mergeWithoutRepetitions(editoresAutores, ((Coleccao) obras[index]).getAutoresEditores());
			}
		}
		
		return editoresAutores;
	}

	/**
	 * Método que recebendo dois arrays sem repetições devolve um novo array com
	 * todos os elementos dos arrays recebidos mas sem repetições
	 */
	private static String[] mergeWithoutRepetitions(String[] a1, String[] a2) {
		
		String[] arraySemRepeticoes = new String[a1.length + a2.length];
		int indexArraySemRepeticoes = 0;
		
		for(int index = 0; index < a1.length; index++)
		{
			arraySemRepeticoes[indexArraySemRepeticoes] = a1[index];
			indexArraySemRepeticoes++;
		}
		
		for(String texto : a2)
		{
			boolean repetido = false;
			
			for(int indexNovoArray = 0; indexNovoArray < indexArraySemRepeticoes; indexNovoArray++)
			{
				if(texto.equals(arraySemRepeticoes[indexNovoArray]))
				{
					repetido = true;
				}
			}
			
			if(!repetido)
			{
				arraySemRepeticoes[indexArraySemRepeticoes] = texto;
				indexArraySemRepeticoes++;
			}
		}
		
		String[] arraySemRepeticoesSemNulls = new String[indexArraySemRepeticoes];
		
		for(int index = 0; index < indexArraySemRepeticoes; index++)
		{
			arraySemRepeticoesSemNulls[index] = arraySemRepeticoes[index];
		}
		
		return arraySemRepeticoesSemNulls;
	}

	/**
	 * Método idêntico ao método anterior mas agora com arrays de livros
	 */
	private static Livro[] mergeWithoutRepetitions(Livro[] a1, Livro[] a2) {
		
		Livro[] arraySemRepeticoes = new Livro[a1.length + a2.length];
		int indexArraySemRepeticoes = 0;
		
		for(int index = 0; index < a1.length; index++)
		{
			arraySemRepeticoes[indexArraySemRepeticoes] = a1[index];
			indexArraySemRepeticoes++;
		}
		
		for(Livro livro : a2)
		{
			boolean repetido = false;
			
			for(int indexNovoArray = 0; indexNovoArray < indexArraySemRepeticoes; indexNovoArray++)
			{
				if(livro.equals(arraySemRepeticoes[indexNovoArray]))
				{
					repetido = true;
				}
			}
			
			if(!repetido)
			{
				arraySemRepeticoes[indexArraySemRepeticoes] = livro;
				indexArraySemRepeticoes++;
			}
		}
		
		Livro[] arraySemRepeticoesSemNulls = new Livro[indexArraySemRepeticoes];
		
		for(int index = 0; index < indexArraySemRepeticoes; index++)
		{
			arraySemRepeticoesSemNulls[index] = arraySemRepeticoes[index];
		}
		
		return arraySemRepeticoesSemNulls;
	}

	/**
	 * Devolve o nº de livros dentro da colecção
	 */
	public int getNumLivros() {
		int numLivros = 0;
		
		for(Obra obra : obras)
		{
			if(obra instanceof Livro)
			{
				numLivros++;
			}
			else if(obra instanceof Coleccao)
			{
				numLivros += ((Coleccao) obra).getNumLivros();
			}
		}
		
		return numLivros;
	}

	/**
	 * Devolve o nº de colecções dentro da colecção
	 */
	public int getNumColeccoes() {
		int numColeccoes = 0;
		
		for(Obra obra : obras)
		{
			if(obra instanceof Coleccao)
			{
				numColeccoes += ((Coleccao) obra).getNumColeccoes();
				numColeccoes++;
			}
		}
		
		return numColeccoes;
	}

	/**
	 * Devolve a profundidada de máxima de uma colecção em termos de coleccões
	 * dentro de coleccções: uma colecção c1 com uma colecção c2 dentro, c1 deve
	 * devolver 2 e c2 deve devolver 1, independentemente do número do conteúdo de
	 * cada uma.
	 */
	public int getProfundidade() {
		
		int profundidade = 1;
		
		for(int obrasIndex = 0; obrasIndex < numObras; obrasIndex++)
		{
			if(obras[obrasIndex] instanceof Coleccao)
			{
				int aux = ((Coleccao) obras[obrasIndex]).getProfundidade();
				
				if(aux + 1 > profundidade)
				{
					profundidade = aux + 1;
				}
			}
		}
		
		return profundidade;
	}

	/**
	 * Duas colecções são iguais se tiverem o mesmo título e a mesma lista de
	 * editores. Deve utilizar o equals da classe Obra. Para verificar verificar se
	 * os editores são os mesmos devem utilizar o método mergeWithoutRepetitions
	 */
	public boolean equals(Object c) {
		return (super.equals(c) && c instanceof Coleccao && mergeWithoutRepetitions(editores, ((Coleccao) c).editores).length == editores.length);
	}

	/**
	 * Deve devolver uma string compatível com os outputs desejados
	 */
	public String toString() {
		
		String toString = super.toString();
		
		toString += ", " + getNumPaginas() + "p, " + getPreco() + ", editores [";
		
		for(int index = 0; index < editores.length; index++)
		{
			toString += editores[index];
			
			if(index != editores.length - 1)
			{
				toString += ", ";
			}
		}
		
		toString += "], com " + getNumLivros() + " livros, com " + getNumColeccoes() + " colecções e com profundidade máxima de " + getProfundidade();
		
		return toString;
	}

	/**
	 * Mostra uma colecção segundo os outputs desejados. Deve utilizar o método
	 * print da classe Obra.
	 */
	public void print(String prefix) {
		
		System.out.println(prefix + toString());
		
		for(int index = 0; index < numObras; index++)
		{
			if(obras[index] instanceof Livro)
			{
				obras[index].print(prefix + " ");				
			}
			else if(obras[index] instanceof Coleccao)
			{
				((Coleccao) obras[index]).print(prefix + " ");
			}
		}
	}

	/**
	 * main
	 */
	public static void main(String[] args) {
		Livro l1 = new Livro("Viagem aos Himalaias", 340, 12.3f, new String[] { "João Mendonça", "Mário Andrade" });
		Livro l2 = new Livro("Viagem aos Pirinéus", 270, 11.5f, new String[] { "João Mendonça", "Júlio Pomar" });

		Coleccao c1 = new Coleccao("Primavera", new String[] { "João Mendonça", "Manuel Alfazema" });

		boolean res;

		res = c1.addObra(l1);
		res = c1.addObra(l2);
		System.out.println("c1 -> " + c1);
		c1.print("");
		System.out.println();

		// adicionar um livro com nome de outro já existente
		res = c1.addObra(l2);
		System.out.println("adição novamente de Viagem aos Pirinéus a c1 -> " + res);
		System.out.println("c1 -> " + c1);
		System.out.println();

		// Outra colecção
		Livro l21 = new Livro("Viagem aos Himalaias 2", 340, 12.3f, new String[] { "João Mendonça", "Mário Andrade" });
		Livro l22 = new Livro("Viagem aos Pirinéus 2", 270, 11.5f, new String[] { "João Mendonça", "Júlio Pomar" });

		Coleccao cx2 = new Coleccao("Outono", new String[] { "João Mendonça", "Manuel Antunes" });
		cx2.addObra(l21);
		cx2.addObra(l22);
		System.out.println("cx2 -> " + cx2);
		cx2.print("");
		System.out.println();

		// adicioná-la a c1
		c1.addObra(cx2);
		System.out.println("c1 após adição da colecção cx2 -> " + c1);
		c1.print("");
		System.out.println();

		// get editores autores
		String[] ae = c1.getAutoresEditores();
		System.out.println("Autores editores of c1 -> " + Arrays.toString(ae));
		System.out.println();

		// getNumObrasFromPerson
		String nome = "João Mendonça";
		int n = c1.getNumObrasFromPerson(nome);
		System.out.println("Nº de obras de " + nome + " -> " + n);
		System.out.println();

		// getLivrosComoAutor
		nome = "João Mendonça";
		Livro[] livros = c1.getLivrosComoAutor(nome);
		System.out.println("Livros de " + nome + " -> " + Arrays.toString(livros));
		System.out.println();
		System.out.println();

		// testes aos métodos getNumLivros, getNumColeccoes e getProfundidade
		c1.print("");
		System.out.println("Nº de livros na colecção " + c1.getTitulo() + " -> " + c1.getNumLivros());

		System.out.println("Nº de colecções dentro da colecção " + c1.getTitulo() + " -> " + c1.getNumColeccoes());

		System.out.println("Profundidade da colecção " + c1.getTitulo() + " -> " + c1.getProfundidade());
		System.out.println("Profundidade da colecção " + cx2.getTitulo() + " -> " + cx2.getProfundidade());
		System.out.println();

		// rem livro
		String nomeLivro = "Viagem aos Himalaias";
		Obra l = c1.remObra(nomeLivro);
		System.out.println("Remoção de " + nomeLivro + " -> " + l);
		c1.print("");

		//Meus Testes:
		System.out.println();
		System.out.println("------------------------");
		System.out.println("Meus Testes:");
		System.out.println("------------------------");
		
		//Testar Construtor
		System.out.println();
		System.out.println(" -> Testar Construtor");
		System.out.println();
		
		//Editores
		System.out.println("################################# - Editores - #################################");
		System.out.println();
		
		System.out.println("     #O array de editores é null");
		try {
			Coleccao minhaColeccaoErro = new Coleccao("Coleccao Teste", null);			
		} 
		catch(IllegalArgumentException ex)
		{
			ex.printStackTrace();
		}
		System.out.println();
		
		System.out.println("     #O array de editores contem apenas um nome vazio");
		try {
			Coleccao minhaColeccaoErro = new Coleccao("Coleccao Teste", new String[] {""});			
		} 
		catch(IllegalArgumentException ex)
		{
			ex.printStackTrace();
		}
		
		System.out.println("     #O array de editores contem um nome com apenas espaços");
		try {
			Coleccao minhaColeccaoErro = new Coleccao("Coleccao Teste", new String[] {"Editor Teste", "    "});			
		} 
		catch(IllegalArgumentException ex)
		{
			ex.printStackTrace();
		}
		System.out.println();
		
		System.out.println("     #O array de editores contem nomes repetidos");
		try {
			Coleccao minhaColeccaoErro = new Coleccao("Coleccao Teste", new String[] {"Editor Teste, Editor Teste"});			
		} 
		catch(IllegalArgumentException ex)
		{
			ex.printStackTrace();
		}
		System.out.println();
		
		System.out.println("     #O array de editores nomes válidos e não repetidos, com espaços extra");
		try {
			Coleccao minhaColeccaoCorrecta = new Coleccao("       Teste Correcto  123 Espacos   11   Extra  Corta    123123   ", new String[] {"   Editor       Teste   ", "Editora   Teste"});			
			minhaColeccaoCorrecta.print("");
		} 
		catch(IllegalArgumentException ex)
		{
			ex.printStackTrace();
		}
		System.out.println();
		
		System.out.println("################################# -xXx Editores xXx- #################################");
		
		System.out.println();
		System.out.println();
		
		//Testar Métodos
		System.out.println();
		System.out.println(" -> Testar Métodos");
		System.out.println();
		
		Coleccao coleccaoPrincipal = new Coleccao("Coleccao Principal", new String[] {"Bruno Aleixo"});
		Coleccao coleccaoNivel2_1 = new Coleccao("Coleccao Nivel 2 Numero 1", new String[] {"Telmo Afonso"});
		Coleccao coleccaoNivel2_2 = new Coleccao("Coleccao Nivel 2 Numero 2", new String[] {"Carlos Fonseca", "José Ribeiro"});
		Coleccao coleccaoNivel3_1 = new Coleccao("Coleccao Nivel 3 Numero 1", new String[] {"Samuel Torpedo", "Manuel Teixeira"});
		Coleccao coleccaoNivel3_2 = new Coleccao("Coleccao Nivel 3 Numero 2", new String[] {"Afonso Risco"});
		
		Livro livroTeste1 = new Livro("Livro Teste 1", 50, 15f, new String[] {"Afonso Risco"});
		Livro livroTeste2 = new Livro("Livro Teste 2", 20, 5.5f, new String[] {"Beatriz Turim", "Gabriel Caparra"});
		Livro livroTeste3 = new Livro("Livro Teste 3", 99, 18.79f, new String[] {"Filomena T Real"});
		Livro livroTeste4 = new Livro("Livro Teste 4", 24, 0.99f, new String[] {"Miguel Luz", "Sara Luz", "Marco Luz"});
		Livro livroTeste5 = new Livro("Livro Teste 5", 111, 21.31f, new String[] {"Xavier Terno", "Telmo Guilherme", "Lucinda Ferro", "Diogo Ventura"});
		Livro livroTeste6 = new Livro("Livro Teste 6", 15, 2.99f, new String[] {"Vera Cruz", "Afonso Risco"});
		
		//addObra
		System.out.println("################################# - addObra - #################################");
		System.out.println();
		
		System.out.println("  # Adicionar Livro Teste 1, duas vezes a Coleccao Principal.");
		System.out.println("Adicionar Livro Teste 1 a Coleccao Principal > Expectável : true | Recebido : " + coleccaoPrincipal.addObra(livroTeste1));
		System.out.println("Adicionar Livro Teste 1 a Coleccao Principal > Expectável : false | Recebido : " + coleccaoPrincipal.addObra(livroTeste1));
		System.out.println();
		
		System.out.println("  # Adicionar Coleccao Nivel 2 Numero 1, duas vezes a Coleccao Principal.");
		System.out.println("Adicionar Coleccao Nivel 2 Numero 1 a Coleccao Principal > Expectável : true | Recebido : " + coleccaoPrincipal.addObra(coleccaoNivel2_1));
		System.out.println("Adicionar Coleccao Nivel 2 Numero 1 a Coleccao Principal > Expectável : false | Recebido : " + coleccaoPrincipal.addObra(coleccaoNivel2_1));
		System.out.println();
		
		System.out.println("  # Adicionar Livro Teste 1 e Livro Teste 2, duas vezes a Coleccao Nivel 2 Numero 1.");
		System.out.println("Adicionar Livro Teste 2 a Coleccao Nivel 2 Numero 1 > Expectável : true | Recebido : " + coleccaoNivel2_1.addObra(livroTeste2));
		System.out.println("Adicionar Livro Teste 2 a Coleccao Nivel 2 Numero 1 > Expectável : false | Recebido : " + coleccaoNivel2_1.addObra(livroTeste2));
		System.out.println("Adicionar Livro Teste 3 a Coleccao Nivel 2 Numero 1 > Expectável : true | Recebido : " + coleccaoNivel2_1.addObra(livroTeste3));
		System.out.println("Adicionar Livro Teste 3 a Coleccao Nivel 2 Numero 1 > Expectável : false | Recebido : " + coleccaoNivel2_1.addObra(livroTeste3));
		System.out.println();
		
		System.out.println("  # Adicionar Coleccao Nivel 3 Numero 1, duas vezes a Coleccao Nivel 2 Numero 2.");
		System.out.println("Adicionar Coleccao Nivel 3 Numero 1 a Coleccao Nivel 2 Numero 2 > Expectável : true | Recebido : " + coleccaoNivel2_2.addObra(coleccaoNivel3_1));
		System.out.println("Adicionar Coleccao Nivel 3 Numero 1 a Coleccao Nivel 2 Numero 2 > Expectável : false | Recebido : " + coleccaoNivel2_2.addObra(coleccaoNivel3_1));
		System.out.println();
		
		System.out.println("  # Adicionar Livro Teste 1, duas vezes a Coleccao Nivel 3 Numero 1.");
		System.out.println("Adicionar Coleccao Livro Teste 1 a Coleccao Nivel 3 Numero 1 > Expectável : true | Recebido : " + coleccaoNivel3_1.addObra(livroTeste1));
		System.out.println("Adicionar Coleccao Livro Teste 1 a Coleccao Nivel 3 Numero 1 > Expectável : false | Recebido : " + coleccaoNivel3_1.addObra(livroTeste1));
		System.out.println();
		
		System.out.println("  # Adicionar Coleccao Nivel 2 Numero 2, duas vezes a Coleccao Principal.");
		System.out.println("Adicionar Coleccao Nivel 2 Numero 2 a Coleccao Principal > Expectável : true | Recebido : " + coleccaoPrincipal.addObra(coleccaoNivel2_2));
		System.out.println("Adicionar Coleccao Nivel 2 Numero 2 a Coleccao Principal > Expectável : false | Recebido : " + coleccaoPrincipal.addObra(coleccaoNivel2_2));
		System.out.println();
		
		System.out.println("  # Adicionar Livro Teste 4 e Livro Teste 5, duas vezes a Coleccao Principal.");
		System.out.println("Adicionar Livro Teste 4 a Coleccao Principal > Expectável : true | Recebido : " + coleccaoPrincipal.addObra(livroTeste4));
		System.out.println("Adicionar Livro Teste 4 a Coleccao Principal > Expectável : false | Recebido : " + coleccaoPrincipal.addObra(livroTeste4));
		System.out.println("Adicionar Livro Teste 5 a Coleccao Principal > Expectável : true | Recebido : " + coleccaoPrincipal.addObra(livroTeste5));
		System.out.println("Adicionar Livro Teste 5 a Coleccao Principal > Expectável : false | Recebido : " + coleccaoPrincipal.addObra(livroTeste5));
		System.out.println();
		
		System.out.println("  # Adicionar Coleccao Nivel 3 Numero 2, duas vezes a Coleccao Principal.");
		System.out.println("Adicionar Coleccao Nivel 3 Numero 2 a Coleccao Principal > Expectável : true | Recebido : " + coleccaoPrincipal.addObra(coleccaoNivel3_2));
		System.out.println("Adicionar Coleccao Nivel 3 Numero 2 a Coleccao Principal > Expectável : false | Recebido : " + coleccaoPrincipal.addObra(coleccaoNivel3_2));
		System.out.println();
		
		System.out.println("  # Adicionar Livro Teste 6, duas vezes a Nivel 3 Numero 2.");
		System.out.println("Adicionar Livro Teste 6 a Nivel 3 Numero 2 > Expectável : true | Recebido : " + coleccaoNivel3_2.addObra(livroTeste6));
		System.out.println("Adicionar Livro Teste 6 a Nivel 3 Numero 2 > Expectável : false | Recebido : " + coleccaoNivel3_2.addObra(livroTeste6));
		System.out.println();
		
		System.out.println();
		System.out.println("Resultado Até Agora: ");
		coleccaoPrincipal.print("");
		System.out.println();
		
		System.out.println();
		System.out.println("################################# -xXx addObra xXx- #################################");
		
		System.out.println();
		System.out.println();
		
		//getNumPaginas
		System.out.println("################################# - getNumPaginas - #################################");
		System.out.println();
		
		System.out.println("getNumPaginas Coleccao Principal >        Expectável : 369 | Recebido : " + coleccaoPrincipal.getNumPaginas());
		System.out.println("getNumPaginas Coleccao Nivel 2 Numero 1 > Expectável : 119 | Recebido : " + coleccaoNivel2_1.getNumPaginas());
		System.out.println("getNumPaginas Coleccao Nivel 2 Numero 2 > Expectável : 50  | Recebido : " + coleccaoNivel2_2.getNumPaginas());
		System.out.println("getNumPaginas Coleccao Nivel 3 Numero 1 > Expectável : 50  | Recebido : " + coleccaoNivel3_1.getNumPaginas());
		System.out.println();
		
		System.out.println();
		System.out.println("Resultado Até Agora: ");
		coleccaoPrincipal.print("");
		System.out.println();
		
		System.out.println();
		System.out.println("################################# -xXx getNumPaginas xXx- #################################");
		
		System.out.println();
		System.out.println();
		
		//getPreco
		System.out.println("################################# - getPreco - #################################");
		System.out.println();
		
		System.out.println("getNumPaginas Coleccao Principal >        Expectável : 369 | Recebido : " + coleccaoPrincipal.getNumPaginas());
		System.out.println("getNumPaginas Coleccao Nivel 2 Numero 1 > Expectável : 119 | Recebido : " + coleccaoNivel2_1.getNumPaginas());
		System.out.println("getNumPaginas Coleccao Nivel 2 Numero 2 > Expectável : 50  | Recebido : " + coleccaoNivel2_2.getNumPaginas());
		System.out.println("getNumPaginas Coleccao Nivel 3 Numero 1 > Expectável : 50  | Recebido : " + coleccaoNivel3_1.getNumPaginas());
		System.out.println();
		
		System.out.println();
		System.out.println("Resultado Até Agora: ");
		coleccaoPrincipal.print("");
		System.out.println();
		
		System.out.println();
		System.out.println("################################# -xXx getPreco xXx- #################################");
		
		System.out.println();
		System.out.println();

		//getNumLivros
		System.out.println("################################# - getNumLivros - #################################");
		System.out.println();
		
		System.out.println("getNumLivros Coleccao Principal >        Expectável : 7 | Recebido : " + coleccaoPrincipal.getNumLivros());
		System.out.println("getNumLivros Coleccao Nivel 2 Numero 1 > Expectável : 2 | Recebido : " + coleccaoNivel2_1.getNumLivros());
		System.out.println("getNumLivros Coleccao Nivel 2 Numero 2 > Expectável : 1 | Recebido : " + coleccaoNivel2_2.getNumLivros());
		System.out.println("getNumLivros Coleccao Nivel 3 Numero 1 > Expectável : 1 | Recebido : " + coleccaoNivel3_1.getNumLivros());
		System.out.println();
		
		System.out.println();
		System.out.println("Resultado Até Agora: ");
		coleccaoPrincipal.print("");
		System.out.println();
		
		System.out.println();
		System.out.println("################################# -xXx getNumLivros xXx- #################################");
		
		System.out.println();
		System.out.println();
		
		//getNumColeccoes
		System.out.println("################################# - getNumColeccoes - #################################");
		System.out.println();
		
		System.out.println("getNumColeccoes Coleccao Principal >        Expectável : 4 | Recebido : " + coleccaoPrincipal.getNumColeccoes());
		System.out.println("getNumColeccoes Coleccao Nivel 2 Numero 1 > Expectável : 0 | Recebido : " + coleccaoNivel2_1.getNumColeccoes());
		System.out.println("getNumColeccoes Coleccao Nivel 2 Numero 2 > Expectável : 1 | Recebido : " + coleccaoNivel2_2.getNumColeccoes());
		System.out.println("getNumColeccoes Coleccao Nivel 3 Numero 1 > Expectável : 0 | Recebido : " + coleccaoNivel3_1.getNumColeccoes());
		System.out.println();
		
		System.out.println();
		System.out.println("Resultado Até Agora: ");
		coleccaoPrincipal.print("");
		System.out.println();
		
		System.out.println();
		System.out.println("################################# -xXx getNumColeccoes xXx- #################################");
		
		System.out.println();
		System.out.println();
		
		//getIndexOfObra
		System.out.println("################################# - getIndexOfObra - #################################");
		System.out.println();
		
		System.out.println("getIndexObra Livro Teste 1 na Coleccao Principal >             Expectável : 0  | Recebido : " + coleccaoPrincipal.getIndexOfObra("Livro Teste 1"));
		System.out.println("getIndexObra Coleccao Nivel 2 Numero 2 na Coleccao Principal > Expectável : 2  | Recebido : " + coleccaoPrincipal.getIndexOfObra("Coleccao Nivel 2 Numero 2"));
		System.out.println("getIndexObra Livro Teste 3 na Coleccao Principal >             Expectável : -1 | Recebido : " + coleccaoPrincipal.getIndexOfObra("Livro Teste 3"));
		System.out.println("getIndexObra Livro Teste 3 na Coleccao Nivel 2 Numero 1 >      Expectável : 1  | Recebido : " + coleccaoNivel2_1.getIndexOfObra("Livro Teste 3"));
		System.out.println();
		
		System.out.println();
		System.out.println("Resultado Até Agora: ");
		coleccaoPrincipal.print("");
		System.out.println();
		
		System.out.println();
		System.out.println("################################# -xXx getIndexOfObra xXx- #################################");
		
		System.out.println();
		System.out.println();
		
		//getNumObrasFromPerson
		System.out.println("################################# - getNumObrasFromPerson - #################################");
		System.out.println();
		
		System.out.println("getNumObrasFromPerson Afonso Risco na Coleccao Principal >            Expectável : 4 | Recebido : " + coleccaoPrincipal.getNumObrasFromPerson("Afonso Risco"));
		System.out.println("getNumObrasFromPerson Afonso Risco na Coleccao Nivel 2 Numero 2 >     Expectável : 1 | Recebido : " + coleccaoNivel2_2.getNumObrasFromPerson("Afonso Risco"));
		System.out.println("getNumObrasFromPerson Samuel Torpedo na Coleccao Nivel 3 Numero 1 >   Expectável : 1 | Recebido : " + coleccaoNivel3_1.getNumObrasFromPerson("Samuel Torpedo"));
		System.out.println("getNumObrasFromPerson Eduardo Pedreiro na Coleccao Nivel 3 Numero 1 > Expectável : 0 | Recebido : " + coleccaoNivel3_1.getNumObrasFromPerson("Eduardo Pedreiro"));
		System.out.println();
		
		System.out.println();
		System.out.println("Resultado Até Agora: ");
		coleccaoPrincipal.print("");
		System.out.println();
		
		System.out.println();
		System.out.println("################################# -xXx getNumObrasFromPerson xXx- #################################");
	
		System.out.println();
		System.out.println();
		
		//getLivrosComoAutor
		System.out.println("################################# - getLivrosComoAutor - #################################");
		System.out.println();
		
		Livro[] livrosComoAutorTeste1 = coleccaoPrincipal.getLivrosComoAutor("Afonso Risco");
		
		System.out.print("getLivrosComoAutor Afonso Risco na Coleccao Principal > Expectável : [Livro Teste 1, Livro Teste 6] | Recebido : ");
		
		for(int livrosIndex = 0; livrosIndex < livrosComoAutorTeste1.length; livrosIndex++)
		{
			if(livrosIndex == 0)
			{
				System.out.print("[");
			}
			
			System.out.print(livrosComoAutorTeste1[livrosIndex].getTitulo());
			
			if(livrosIndex == livrosComoAutorTeste1.length - 1)
			{
				System.out.println("]");
			}
			else
			{
				System.out.print(", ");
			}
		}
		
		Livro[] livrosComoAutorTeste2 = coleccaoNivel2_2.getLivrosComoAutor("Afonso Risco");
		
		System.out.print("getLivrosComoAutor Afonso Risco na Coleccao Nivel 2 Numero 2 > Expectável : [Livro Teste 1] | Recebido : ");
		
		for(int livrosIndex = 0; livrosIndex < livrosComoAutorTeste2.length; livrosIndex++)
		{
			if(livrosIndex == 0)
			{
				System.out.print("[");
			}
			
			System.out.print(livrosComoAutorTeste2[livrosIndex].getTitulo());
			
			if(livrosIndex == livrosComoAutorTeste2.length - 1)
			{
				System.out.println("]");
			}
			else
			{
				System.out.print(", ");
			}
		}
		
		Livro[] livrosComoAutorTeste3 = coleccaoPrincipal.getLivrosComoAutor("Bruno Aleixo");
		
		System.out.print("getLivrosComoAutor Bruno Aleixo na Coleccao Principal > Expectável : | Recebido : ");
		
		for(int livrosIndex = 0; livrosIndex < livrosComoAutorTeste3.length; livrosIndex++)
		{
			if(livrosIndex == 0)
			{
				System.out.print("[");
			}
			
			System.out.print(livrosComoAutorTeste3[livrosIndex].getTitulo());
			
			if(livrosIndex == livrosComoAutorTeste3.length - 1)
			{
				System.out.println("]");
			}
			else
			{
				System.out.print(", ");
			}
		}
		System.out.println();
		
		Livro[] livrosComoAutorTeste4 = coleccaoPrincipal.getLivrosComoAutor("Vera Cruz");
		
		System.out.print("getLivrosComoAutor Vera Cruz na Coleccao Principal > Expectável : [Livro Teste 6] | Recebido : ");
		
		for(int livrosIndex = 0; livrosIndex < livrosComoAutorTeste4.length; livrosIndex++)
		{
			if(livrosIndex == 0)
			{
				System.out.print("[");
			}
			
			System.out.print(livrosComoAutorTeste4[livrosIndex].getTitulo());
			
			if(livrosIndex == livrosComoAutorTeste4.length - 1)
			{
				System.out.println("]");
			}
			else
			{
				System.out.print(", ");
			}
		}
		System.out.println();
		
		System.out.println();
		System.out.println("Resultado Até Agora: ");
		coleccaoPrincipal.print("");
		System.out.println();
		
		System.out.println();
		System.out.println("################################# -xXx getLivrosComoAutor xXx- #################################");

		System.out.println();
		System.out.println();
		
		//getAutoresEditores
		System.out.println("################################# - getAutoresEditores - #################################");
		System.out.println();
		
		String[] autoresEditoresTeste1 = coleccaoPrincipal.getAutoresEditores();
		
		System.out.println("getAutoresEditores da Coleccao Principal");
		System.out.println("Expectável : [Bruno Aleixo, Afonso Risco, Telmo Afonso, Beatriz Turim, Gabriel Caparra, Filomena T Real, Carlos Fonseca, José Ribeiro, Samuel Torpedo, Manuel Teixeira, Miguel Luz, Sara Luz, Marco Luz, Xavier Terno, Telmo Guilherme, Lucinda Ferro, Diogo Ventura]");
		System.out.print("Recebido :   ");
		
		for(int indexAutoresEditores = 0; indexAutoresEditores < autoresEditoresTeste1.length; indexAutoresEditores++)
		{
			if(indexAutoresEditores == 0)
			{
				System.out.print("[");
			}
			
			System.out.print(autoresEditoresTeste1[indexAutoresEditores]);
			
			if(indexAutoresEditores == autoresEditoresTeste1.length - 1)
			{
				System.out.println("]");
			}
			else
			{
				System.out.print(", ");
			}
		}
		System.out.println();
		
		String[] livrosAutoresEditoresTeste2 = coleccaoNivel2_1.getAutoresEditores();
		
		System.out.println("getAutoresEditores da Coleccao Nivel 2 Numero 1");
		System.out.println("Expectável : [Telmo Afonso, Beatriz Turim, Gabriel Caparra, Filomena T Real]");
		System.out.print("Recebido :   ");
		
		for(int indexAutoresEditores = 0; indexAutoresEditores < livrosAutoresEditoresTeste2.length; indexAutoresEditores++)
		{
			if(indexAutoresEditores == 0)
			{
				System.out.print("[");
			}
			
			System.out.print(livrosAutoresEditoresTeste2[indexAutoresEditores]);
			
			if(indexAutoresEditores == livrosAutoresEditoresTeste2.length - 1)
			{
				System.out.println("]");
			}
			else
			{
				System.out.print(", ");
			}
		}
		System.out.println();
		
		String[] livrosAutoresEditoresTeste3 = coleccaoNivel2_2.getAutoresEditores();
		
		System.out.println("getAutoresEditores da Coleccao Nivel 2 Numero 2");
		System.out.println("Expectável : [Carlos Fonseca, José Ribeiro, Samuel Torpedo, Manuel Teixeira, Afonso Risco]");
		System.out.print("Recebido :   ");
		
		for(int indexAutoresEditores = 0; indexAutoresEditores < livrosAutoresEditoresTeste3.length; indexAutoresEditores++)
		{
			if(indexAutoresEditores == 0)
			{
				System.out.print("[");
			}
			
			System.out.print(livrosAutoresEditoresTeste3[indexAutoresEditores]);
			
			if(indexAutoresEditores == livrosAutoresEditoresTeste3.length - 1)
			{
				System.out.println("]");
			}
			else
			{
				System.out.print(", ");
			}
		}
		System.out.println();
		
		String[] livrosAutoresEditoresTeste4 = coleccaoNivel3_1.getAutoresEditores();
		
		System.out.println("getAutoresEditores da Coleccao Nivel 3 Numero 1");
		System.out.println("Expectável : [Samuel Torpedo, Manuel Teixeira, Afonso Risco]");
		System.out.print("Recebido :   ");
		
		for(int indexAutoresEditores = 0; indexAutoresEditores < livrosAutoresEditoresTeste4.length; indexAutoresEditores++)
		{
			if(indexAutoresEditores == 0)
			{
				System.out.print("[");
			}
			
			System.out.print(livrosAutoresEditoresTeste4[indexAutoresEditores]);
			
			if(indexAutoresEditores == livrosAutoresEditoresTeste4.length - 1)
			{
				System.out.println("]");
			}
			else
			{
				System.out.print(", ");
			}
		}
		System.out.println();
		
		String[] livrosAutoresEditoresTeste5 = coleccaoNivel3_2.getAutoresEditores();
		
		System.out.println("getAutoresEditores da Coleccao Nivel 3 Numero 2");
		System.out.println("Expectável : [Afonso Risco, Vera Cruz]");
		System.out.print("Recebido :   ");
		
		for(int indexAutoresEditores = 0; indexAutoresEditores < livrosAutoresEditoresTeste5.length; indexAutoresEditores++)
		{
			if(indexAutoresEditores == 0)
			{
				System.out.print("[");
			}
			
			System.out.print(livrosAutoresEditoresTeste5[indexAutoresEditores]);
			
			if(indexAutoresEditores == livrosAutoresEditoresTeste5.length - 1)
			{
				System.out.println("]");
			}
			else
			{
				System.out.print(", ");
			}
		}
		System.out.println();
		
		System.out.println();
		System.out.println("Resultado Até Agora: ");
		coleccaoPrincipal.print("");
		System.out.println();
		
		System.out.println();
		System.out.println("################################# -xXx getAutoresEditores xXx- #################################");
		
		System.out.println();
		System.out.println();
		
		//equals
		System.out.println("################################# - equals - #################################");
		System.out.println();
		
		Coleccao coleccaoEqualsTeste1_1 = new Coleccao("Coleccao Nivel 2 Numero 1", new String[] {"Telmo Afonso"});
		Coleccao coleccaoEqualsTeste1_2 = new Coleccao("Coleccao Nivel 2 Numero 1", new String[] {"Daniel Pereira"});
		Coleccao coleccaoEqualsTeste3_1 = new Coleccao("Coleccao Nivel 3 Numero 1", new String[] {"Samuel Torpedo", "Manuel Teixeira"});
		Coleccao coleccaoEqualsTeste3_2 = new Coleccao("Coleccao Nivel 3 Numero 2", new String[] {"Afonso Risco"});
		
		coleccaoEqualsTeste1_1.addObra(livroTeste1);
		coleccaoEqualsTeste1_1.addObra(coleccaoEqualsTeste3_1);
		
		coleccaoNivel2_1.print("");
		System.out.println();
		System.out.println("equals");
		System.out.println();
		coleccaoEqualsTeste1_1.print("");
		System.out.println();
		System.out.println("-------------------------------------------------");
		System.out.println("Expectável : true | Recebido : " + coleccaoNivel2_1.equals(coleccaoEqualsTeste1_1));
		
		System.out.println();
		System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
		System.out.println();
		
		coleccaoEqualsTeste1_2.addObra(coleccaoEqualsTeste3_1);
		
		coleccaoNivel2_1.print("");
		System.out.println();
		System.out.println("equals");
		System.out.println();
		coleccaoEqualsTeste1_2.print("");
		System.out.println();
		System.out.println("-------------------------------------------------");
		System.out.println("Expectável : false | Recebido : " + coleccaoNivel2_1.equals(coleccaoEqualsTeste1_2));
		System.out.println();
		
		System.out.println();
		System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
		System.out.println();
		
		coleccaoEqualsTeste3_2.addObra(livroTeste6);
		
		coleccaoNivel3_2.print("");
		System.out.println();
		System.out.println("equals");
		System.out.println();
		coleccaoEqualsTeste3_2.print("");
		System.out.println();
		System.out.println("-------------------------------------------------");
		System.out.println("Expectável : true | Recebido : " + coleccaoNivel3_2.equals(coleccaoEqualsTeste3_2));
		System.out.println();
		
		System.out.println();
		System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
		System.out.println();
		
		System.out.println();
		System.out.println("Resultado Até Agora: ");
		coleccaoPrincipal.print("");
		System.out.println();
		
		System.out.println();
		System.out.println("################################# -xXx equals xXx- #################################");
		
		System.out.println();
		System.out.println();
		
		//remObra
		System.out.println("################################# - remObra - #################################");
		System.out.println();
		
		System.out.println("Para testes, criação de Livro e Coleccao com o nome: Remover Teste");
		
		Livro removerLivroTeste = new Livro("Remover Teste", 10, 10f, new String[] {"Autor Teste"});
		Coleccao removerColeccaoTeste = new Coleccao("Remover Teste", new String[] {"Autor Teste"});
		
		coleccaoPrincipal.addObra(removerLivroTeste);
		coleccaoNivel3_2.addObra(removerColeccaoTeste);
		
		System.out.println();
		System.out.println("Resultado: ");
		coleccaoPrincipal.print("");
		System.out.println();

		System.out.println("Remover Remover Teste da Coleccao Principal");
		System.out.println("Expectável : Remover Teste | Obra Removida : " + coleccaoPrincipal.remObra("Remover Teste"));
		System.out.println();
		System.out.println("|||||||||||||||||");
		System.out.println();
		System.out.println("Resultado: ");
		coleccaoPrincipal.print("");
		System.out.println();
		
		System.out.println();
		System.out.println("-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-");
		System.out.println();
		
		System.out.println("Remover Remover Teste da Coleccao Principal");
		System.out.println("Expectável : null | Obra Removida : " + coleccaoPrincipal.remObra("Remover Teste"));
		System.out.println();
		System.out.println("|||||||||||||||||");
		System.out.println();
		System.out.println("Resultado: ");
		coleccaoPrincipal.print("");
		System.out.println();
		
		System.out.println();
		System.out.println("-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-");
		System.out.println();

		System.out.println("Remover Remover Teste da Coleccao Nivel 3 Numero 2");
		System.out.println("Expectável : Remover Teste | Obra Removida : " + coleccaoNivel3_2.remObra("Remover Teste"));
		System.out.println();
		System.out.println("|||||||||||||||||");
		System.out.println();
		System.out.println("Resultado: ");
		coleccaoPrincipal.print("");
		System.out.println();
		
		System.out.println();
		System.out.println("################################# -xXx remObra xXx- #################################");
		
		System.out.println();
		System.out.println();
		
		//remAllObra
		System.out.println("################################# - remAllObra - #################################");
		System.out.println();
		
		System.out.println("Para testes, criação de Livro e Coleccao com o nome: Remover Teste");
		
		coleccaoPrincipal.addObra(removerLivroTeste);
		coleccaoNivel3_2.addObra(removerColeccaoTeste);
		
		System.out.println();
		System.out.println("Resultado: ");
		coleccaoPrincipal.print("");
		System.out.println();

		System.out.println("Remover Todos Remover Teste da Coleccao Principal");
		System.out.println("Expectável : true | Recebido : " + coleccaoPrincipal.remAllObra("Remover Teste"));
		System.out.println();
		System.out.println("|||||||||||||||||");
		System.out.println();
		System.out.println("Resultado: ");
		coleccaoPrincipal.print("");
		System.out.println();
		
		System.out.println();
		System.out.println("-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-");
		System.out.println();
		
		System.out.println("Remover Todos Remover Teste da Coleccao Principal");
		System.out.println("Expectável : false | Recebido : " + coleccaoPrincipal.remAllObra("Remover Teste"));
		System.out.println();
		System.out.println("|||||||||||||||||");
		System.out.println();
		System.out.println("Resultado: ");
		coleccaoPrincipal.print("");
		System.out.println();
		
		System.out.println();
		System.out.println("################################# -xXx remAllObra xXx- #################################");
	}
}