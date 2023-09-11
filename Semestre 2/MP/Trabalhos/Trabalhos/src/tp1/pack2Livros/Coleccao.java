package tp1.pack2Livros;

import java.util.Arrays;

/**
 * Classe Colecca, deve conter a descrição de uma colecção, com título, seus
 * livros e editores
 */
public class Coleccao {

    // número máximo de obras de uma colecção
    private static int MAXOBRAS = 20;

    // prefixo usual
    public static final String GENERALPREFIX = "  ";

    // título da colecção
    private String titulo;

    // Array de livros, em que estas encontram-se sempre nos menores índices e
    // pela ordem de registo
    private Livro[] livros = new Livro[MAXOBRAS];

    // deverá conter sempre o número de livros na colecção
    private int numLivros = 0;

    // Editores, tem as mesmas condicionantes que array de autores na classe
    // livro
    private String[] editores;

    /**
     * Construtor; o título tem de ter pelo menos um caracter que não seja um
     * espaço (Character.isWhitespace); o array de editores devem ser pelo menos
     * um e têm as mesmas restrições que os autores dos livros; o array de
     * livros deve conter os mesmos sempre nos menores índices
     */
    public Coleccao(String titulo, String[] editores) {
        // titulo
        if (titulo == null || titulo.length() == 0)
            throw new IllegalArgumentException(
                    "O titulo tem de ter pelo menos um caracter");
        
        for(int tituloIndex = 0; tituloIndex < titulo.length(); tituloIndex++)
        {
        	if(!Character.isWhitespace(tituloIndex))
        	{
        		break;
        	}
        	
        	if(tituloIndex == titulo.length() - 1)
        	{
        		throw new IllegalArgumentException("O titulo nao pode conter apenas espacos");
        	}
        }
        
        this.titulo = titulo;

        //Editores
        if(editores.length <= 0)
        {
        	throw new IllegalArgumentException("Tem de existir, pelo menos, um editor");
        }
        
        for(String editor : editores)
        {
        	if (editor == null || editor.length() == 0)
                throw new IllegalArgumentException("O editor tem de ter pelo menos um caracter");
        }
        
        this.editores = editores;
    }

    /**
     *
     */
    public String getTitulo() {
        
        return titulo;
    }

    /**
     * Obtem o número total de páginas da colecção
     */
    public int getNumPaginas() {
        
    	int numPaginas = 0;
    	
    	for(int index = 0; index < numLivros; index++)
    	{
    		numPaginas += livros[index].getNumPaginas();
    	}
    	
        return numPaginas;
    }

    /**
     * Devolve o preço da colecção tendo em conta que as colecções com 4 ou mais
     * livros têm um desconto de 20% nos livros que custam pelo menos 10 euros e
     * que têm mais de 200 páginas
     */
    public float getPreco() {

    	float preco = 0;
    	
    	if(numLivros < 4)
    	{
    		for(int index = 0; index < numLivros; index++)
    		{
    			preco += livros[index].getPreco();
    		}
    	}
    	else
    	{
    		for(int index = 0; index < numLivros; index++)
    		{
    			Livro livro = livros[index];
    			
    			if(livro.getPreco() >= 10 && livro.getNumPaginas() > 200)
    			{
    				preco += livro.getPreco() * 0.8f;
    			}
    			else
    			{
    				preco += livro.getPreco();    				
    			}
    		}
    	}
    	
    	return preco;
    }

    /**
     * Adiciona um livro se puder e este não seja null e a colecção não ficar
     * com livros iguais. Deve utilzar o método getIndexOfLivro.
     */
    public boolean addLivro(Livro livro) {
        
    	if(numLivros == livros.length - 1 || livro == null)
    	{
    		return false;
    	}
    	
    	if(getIndexOfLivro(livro.getTitulo()) != -1)
    	{
    		return false;
    	}
    	
    	livros[numLivros] = livro;
    	numLivros++;
    	
        return true;
    }

    /**
     * Devolve o index no array de livros onde estiver o livro com o nome
     * pretendido. Devolve -1 caso não o encontre
     */
    private int getIndexOfLivro(String titulo) {
        
    	for(int livroIndex = 0; livroIndex < numLivros; livroIndex++)
    	{
    		if(livros[livroIndex].getTitulo().equals(titulo))
    		{
    			return livroIndex;
    		}
    	}
    	
        return -1;
    }

    /**
     * Remove do array o livro com o título igual ao título recebido. Devolve o
     * livro removido ou null caso não tenha encontrado o livro. Deve-se
     * utilizar o método getIndexOfLivro. Recorda-se que os livros devem ocupar
     * sempre os menores índices, ou seja, não pode haver nulls entre os livros
     */
    public Livro remLivro(String titulo) {	
    	boolean exists = false;
    	Livro livroARemover = null;
    	int livroIndex = 0;
    	
    	for(int indexLivros = 0; indexLivros < numLivros; indexLivros++)
    	{
    		if(livros[indexLivros].getTitulo().equals(titulo))
    		{
    			exists = true;
    			livroARemover = livros[indexLivros];
    			livroIndex = indexLivros;
    		}
    	}
    	
    	if(!exists)
    	{
    		return null;
    	}
    	
    	Livro[] novosLivros = new Livro[numLivros - 1];
    	int indexes = 0;
    	
    	for(int indexLivros = 0; indexLivros < numLivros; indexLivros++)
    	{
    		if(indexLivros != livroIndex)
    		{
    			novosLivros[indexes] = livros[indexLivros];
    			indexes++;
    		}
    	}
    	
    	livros = novosLivros;
    	numLivros--;
    	
        return livroARemover;
    }

    /**
     * Devolve o nº de obras de uma pessoa. A colecção deve contabilizar-se como
     * uma obra para os editores.
     */
    public int getNumObrasFromPerson(String autorEditor) {
        
    	int numObras = 0;
    	
    	for(String editor : editores)
    	{
    		if(editor.equals(autorEditor))
    		{
    			numObras++;
    		}
    	}
    	
    	for(int indexLivro = 0; indexLivro < numLivros; indexLivro++)
    	{
    		for(String autor : livros[indexLivro].getAutores())
    		{
    			if(autor.equals(autorEditor))
    			{
    				numObras++;
    			}
    		}
    	}
    	
        return numObras;
    }

    /**
     * Devolver um novo array (sem nulls) com os livros de que a pessoa recebida
     * é autor
     */
    public Livro[] getLivrosComoAutor(String autorNome) {
        
    	Livro[] livrosComoAutor = new Livro[numLivros];
    	int numLivrosComoAutor = 0;
    	
    	for(int livroIndex = 0; livroIndex < numLivros; livroIndex++)
    	{
    		if(livros[livroIndex].contemAutor(autorNome))
    		{
    			livrosComoAutor[numLivrosComoAutor] = livros[livroIndex];
    			numLivrosComoAutor++;
    		}
    	}
    	
    	Livro[] livrosComoAutorFinal = new Livro[numLivrosComoAutor];
    	
    	for(int livrosIndex = 0; livrosIndex < numLivrosComoAutor; livrosIndex++)
    	{
    		livrosComoAutorFinal[livrosIndex] = livrosComoAutor[livrosIndex];
    	}
    	
        return livrosComoAutorFinal;
    }

    /**
     * Deve devolver uma string compatível com os outputs desejados
     */
    public String toString() {
        
        String toBeReturned = "Colecção " + titulo + ", editores [ ";
        
        for(int index = 0; index < editores.length; index++)
        {
        	if(index == editores.length - 1)
        	{
        		toBeReturned += editores[index] + "], ";
        	}
        	else
        	{
        		toBeReturned += editores[index] + ", ";
        	}
        }
        
        toBeReturned += numLivros + " livros, " + getNumPaginas() + "p " + getPreco();
        
        return toBeReturned;
    }

    /**
     * Deve devolver um array, sem nulls, com todos os autores e editores
     * existentes na colecção. O resultado não deve conter repetições. Deve
     * utilizar o método mergeWithoutRepetitions
     */
    public String[] getAutoresEditores() {
        
    	String[] autoresEditores = editores.clone();
    	
    	for(int index = 0; index < numLivros; index++)
    	{
    		autoresEditores = mergeWithoutRepetitions(autoresEditores, livros[index].getAutores());
    	}
    	
        return autoresEditores;
    }

    /**
     * Método que recebendo dois arrays sem repetições devolve um novo array com
     * todos os elementos dos arrays recebidos mas sem repetições
     */
    private static String[] mergeWithoutRepetitions(String[] a1, String[] a2) {
        
		int tamanhoFinal = a1.length;
		
		String[] naoRepetidos = new String[a2.length];
		int indexNaoRepetidos = 0;
		
		for(String texto : a2)
		{
			boolean repetido = false;
			
			for(String textoAComparar : a1)
			{
				if(texto.equals(textoAComparar))
				{
					repetido = true;
				}
			}
			
			if(!repetido)
			{
				naoRepetidos[indexNaoRepetidos] = texto;
				indexNaoRepetidos++;
				
				tamanhoFinal++;
			}
		}
    	
		String[] arraySemRepeticoes = new String[tamanhoFinal];
		int indexSemRepeticoes = 0;
		
		for(int index = 0; index < a1.length; index++)
		{
			arraySemRepeticoes[indexSemRepeticoes] = a1[index];
			indexSemRepeticoes++;
		}
		
		for(int index = 0; index < indexNaoRepetidos; index++)
		{
			arraySemRepeticoes[indexSemRepeticoes] = naoRepetidos[index];
		}
    	
        return arraySemRepeticoes;
    }

    /**
     * Devolve true caso a colecção recebida tenha o mesmo título e a mesma
     * lista de editores. Para verificar verificar se os editores são os mesmos
     * devem utilizar o método mergeWithoutRepetitions
     */
    public boolean equals(Coleccao c) {
    	
    	if(!c.getTitulo().equals(titulo))
    	{
    		return false;
    	}
    	
    	String[] merge = mergeWithoutRepetitions(editores, c.editores);
    	
    	if(merge.length != editores.length || merge.length != c.editores.length)
    	{
    		return false;
    	}
    	
        return true;
    }

    /**
     * Mostra uma colecção segundo os outputs desejados
     */
    public void print(String prefix) {
        System.out.println(prefix + toString());
        
        for(int indexLivro = 0; indexLivro < numLivros; indexLivro++)
        {
        	livros[indexLivro].print(" ");
        }
    }

    /**
     * main
     */
    public static void main(String[] args) {
        Livro l1 = new Livro("Viagem aos Himalaias", 340, 12.3f,
                new String[]{"João Mendonça", "Mário Andrade"});
        Livro l2 = new Livro("Viagem aos Pirinéus", 270, 11.5f,
                new String[]{"João Mendonça", "Júlio Pomar"});

        Coleccao c1 = new Coleccao("Primavera",
                new String[]{"João Mendonça", "Manuel Alfazema"});

        boolean res;

        res = c1.addLivro(l1);
        res = c1.addLivro(l2);
        System.out.println("c1 -> " + c1);
        c1.print("");
        System.out.println();

        // adicionar um livro com nome de outro já existente
        res = c1.addLivro(l2);
        System.out.println(
                "adição novamente de Viagem aos Pirinéus a c1 -> " + res);
        System.out.println("c1 -> " + c1);
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
        Livro[] obras = c1.getLivrosComoAutor(nome);
        System.out
                .println("Livros de " + nome + " -> " + Arrays.toString(obras));
        System.out.println();

        // rem livro
        String nomeLivro = "Viagem aos Himalaias";
        Livro l = c1.remLivro(nomeLivro);
        System.out.println("Remoção de " + nomeLivro + " -> " + l);
        c1.print("");
        System.out.println();

        // equals
        Coleccao c2 = new Coleccao("Primavera",
                new String[]{"João Mendonça", "Manuel Alfazema"});
        boolean same = c1.equals(c2);
        System.out.println("c2:");
        c2.print("");
        System.out.println("c1.equals(c2) -> " + same);
        System.out.println();

        Coleccao c3 = new Coleccao("Primavera",
                new String[]{"João Mendonça"});
        same = c1.equals(c3);
        System.out.println("c3:");
        c3.print("");
        System.out.println("c1.equals(c3) -> " + same);
    }
}