package tp2.pack1ColeccoesComHeranca;

/**
 * Classe que deverá suportar um livro
 */
public class Livro extends Obra implements IObra{

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
		
		super(titulo);
		
		//Numero de Paginas
        if(numPaginas < 1)
        {
            throw new IllegalArgumentException("O nº de páginas não pode ser negativo");
            //Acho que devia ficar "Tem de ter pelo menos uma página".
        }
        
        this.numPaginas = numPaginas;
        
        //Preco
        if(preco < 0)
        {
            throw new IllegalArgumentException("O preço não pode ser negativo");
        }
        
        this.preco = preco;
        
        //Autores
        if(autores == null)
        {
        	throw new IllegalArgumentException("O array de autores não pode ser null");
        }
        
        String[] novosAutores = new String[autores.length];
        
        for(int autoresIndex = 0; autoresIndex < autores.length; autoresIndex++)
        {
        	if(autores[autoresIndex] == null)
        	{
        		throw new IllegalArgumentException("O array de autores não pode conter nulls");
        	}
        	
        	novosAutores[autoresIndex] = removeExtraSpaces(autores[autoresIndex]);
        }
        
        if(!validarNomes(novosAutores))
		{
			throw new IllegalArgumentException("O array de autores só pode conter nomes válidos");
		}
        
        if(haRepeticoes(novosAutores))
        {
        	throw new IllegalArgumentException("O array de autores contém autores repetidos");
        }
        
        this.autores = novosAutores;
	}

	/**
	 * Devolve o número de páginas do livro
	 */
	public int getNumPaginas() {
		
		return numPaginas;
	}

	/**
	 * Devolve o preço do livro
	 */
	public float getPreco() {
		
		return preco;
	}

	/**
	 * Devolve true se o autor recebido existe como autor do livro. O nome
	 * recebido não contém espaços extra.
	 */
	public boolean contemAutor(String autorNome) {
		
		for(String autor : autores)
		{
			if(autorNome.equals(autor))
			{
				return true;
			}
		}
		
		return false;
	}

	/**
	 * Devolve uma cópia do array de autores do livro
	 */
	public String[] getAutores() {
		
		return autores.clone();
	}

	/**
	 * Devolve uma string com a informação do livro (ver outputs desejados)
	 */
	public String toString() {
		String toString = super.toString() + ", " + getNumPaginas() + "p " + getPreco() + " [";
	
		for(int index = 0; index < autores.length; index++)
		{
			toString += autores[index];
			
			if(index != autores.length - 1)
			{
				toString += ", ";
			}
		}
		
		toString += "]";
		
		return toString;
	}

	/**
	 * Iguais se equais no contexto de obra e se o objecto recebido for um Livro.
	 * Deve utilizar o método equals de Obra
	 */
	public boolean equals(Object l) {
		return (super.equals(l) && l instanceof Livro);
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
		
		//Meus Testes:
		System.out.println();
		System.out.println("------------------------");
		System.out.println("Meus Testes:");
		System.out.println("------------------------");
		
		//Testar Construtor
		System.out.println();
		System.out.println(" -> Testar Construtor");
		System.out.println();
		
		//Título
		System.out.println("################################# - Título - #################################");
		System.out.println();
		
		System.out.println("     #Titulo é null");
		try {
			Livro meuLivroErro = new Livro(null, 100, 20.0f, new String[] {"Autor Teste"});			
		} 
		catch(IllegalArgumentException ex)
		{
			ex.printStackTrace();
		}
		System.out.println();
		
		System.out.println("     #Titulo está vazio");
		try {
			Livro meuLivroErro = new Livro("", 100, 20.0f, new String[] {"Autor Teste"});			
		} 
		catch(IllegalArgumentException ex)
		{
			ex.printStackTrace();
		}
		System.out.println();
		
		System.out.println("     #Titulo apenas contém espaços");
		try {
			Livro meuLivroErro = new Livro("    ", 100, 20.0f, new String[] {"Autor Teste"});			
		} 
		catch(IllegalArgumentException ex)
		{
			ex.printStackTrace();
		}
		System.out.println();
		
		System.out.println("     #Titulo apenas contém um ponto");
		try {
			Livro meuLivroErro = new Livro(".", 100, 20.0f, new String[] {"Autor Teste"});
		} 
		catch(IllegalArgumentException ex)
		{
			ex.printStackTrace();
		}
		System.out.println();
		
		System.out.println("     #Titulo possui apenas números");
		try {
			Livro meuLivroErro = new Livro("1312", 100, 20.0f, new String[] {"Autor Teste"});			
		} 
		catch(IllegalArgumentException ex)
		{
			ex.printStackTrace();
		}
		System.out.println();
		
		System.out.println("     #Titulo tem caracteres, espaços extra e números");
		try {
			Livro meuLivroCorrecto = new Livro("Teste Correcto Espacos     W   Extra Corta 010101110101010", 100, 20.0f, new String[] {"Autor Teste"});			
			meuLivroCorrecto.print(" ");
		} 
		catch(IllegalArgumentException ex)
		{
			ex.printStackTrace();
		}
		System.out.println();
		
		System.out.println("################################# -xXx Título xXx- #################################");
		
		System.out.println();
		System.out.println();
		
		//Páginas
		System.out.println("################################# - Páginas - #################################");
		System.out.println();
		
		System.out.println("     #Páginas são 0");
		try {
			Livro meuLivroErro = new Livro("Título Exemplo", 0, 20.0f, new String[] {"Autor Teste"});			
		} 
		catch(IllegalArgumentException ex)
		{
			ex.printStackTrace();
		}
		System.out.println();
		
		System.out.println("     #Páginas é negativo");
		try {
			Livro meuLivroErro = new Livro("Título Exemplo", -100, 20.0f, new String[] {"Autor Teste"});			
		} 
		catch(IllegalArgumentException ex)
		{
			ex.printStackTrace();
		}
		System.out.println();
		
		System.out.println("     #Páginas é 40");
		try {
			Livro meuLivroCorrecto = new Livro("Título Exemplo", 40, 20.0f, new String[] {"Autor Teste"});
			meuLivroCorrecto.print(" ");
		} 
		catch(IllegalArgumentException ex)
		{
			ex.printStackTrace();
		}
		System.out.println();
		
		System.out.println("################################# -xXx Páginas xXx- #################################");

		System.out.println();
		System.out.println();
		
		//Preco
		System.out.println("################################# - Preco - #################################");
		System.out.println();
		
		System.out.println("     #Preco é 0");
		try {
			Livro meuLivroErro = new Livro("Título Exemplo", 40, 0f, new String[] {"Autor Teste"});			
		} 
		catch(IllegalArgumentException ex)
		{
			ex.printStackTrace();
		}
		System.out.println();
		
		System.out.println("     #Preco é negativo");
		try {
			Livro meuLivroErro = new Livro("Título Exemplo", 40, -10.0f, new String[] {"Autor Teste"});			
		} 
		catch(IllegalArgumentException ex)
		{
			ex.printStackTrace();
		}
		System.out.println();
		
		System.out.println("     #Preco é 20");
		try {
			Livro meuLivroCorrecto = new Livro("Título Exemplo", 40, 20f, new String[] {"Autor Teste"});
			meuLivroCorrecto.print(" ");
		} 
		catch(IllegalArgumentException ex)
		{
			ex.printStackTrace();
		}
		System.out.println();
		
		System.out.println("################################# -xXx Preco xXx- #################################");

		System.out.println();
		System.out.println();
		
		//Autores
		System.out.println("################################# - Autores - #################################");
		System.out.println();
		
		System.out.println("     #Autores é null");
		try {
			Livro meuLivroErro = new Livro("Título Exemplo", 40, 20f, null);			
		} 
		catch(IllegalArgumentException ex)
		{
			ex.printStackTrace();
		}
		System.out.println();
		
		System.out.println("     #Autores contém apenas um null");
		try {
			Livro meuLivroErro = new Livro("Título Exemplo", 40, 20.0f, new String[] {null});			
		} 
		catch(IllegalArgumentException ex)
		{
			ex.printStackTrace();
		}
		System.out.println();
		
		System.out.println("     #Autores contém um null");
		try {
			Livro meuLivroCorrecto = new Livro("Título Exemplo", 40, 20f, new String[] {"Autor Teste", null});
			meuLivroCorrecto.print(" ");
		} 
		catch(IllegalArgumentException ex)
		{
			ex.printStackTrace();
		}
		System.out.println();
	
		System.out.println("     #Autores contém uma entrada apenas com espaços");
		try {
			Livro meuLivroErro = new Livro("Título Exemplo", 40, 20.0f, new String[] {"Autor Teste", "     ", "Autora Teste"});			
		} 
		catch(IllegalArgumentException ex)
		{
			ex.printStackTrace();
		}
		System.out.println();
		
		System.out.println("     #Autores contém nomes repetidos");
		try {
			Livro meuLivroErro = new Livro("Título Exemplo", 40, 20.0f, new String[] {"Autor Teste", "Autor Teste"});			
		} 
		catch(IllegalArgumentException ex)
		{
			ex.printStackTrace();
		}
		System.out.println();
		
		
		System.out.println("     #Autores contém nomes não repetidos e válidos");
		try {
			Livro meuLivroCorrecto = new Livro("Título Exemplo", 40, 20f, new String[] {"Autor Teste", "Autora Teste"});
			meuLivroCorrecto.print(" ");
		} 
		catch(IllegalArgumentException ex)
		{
			ex.printStackTrace();
		}
		System.out.println();
		
		System.out.println("################################# -xXx Autores xXx- #################################");
		
		System.out.println();
		System.out.println();
		
		//Testar Métodos
		System.out.println();
		System.out.println(" -> Testar Métodos");
		System.out.println();
		
		Livro livroTeste1 = new Livro("Teste 1", 50, 15f, new String[] {"Afonso Risco"});
		Livro livroTeste2 = new Livro("Teste 2", 20, 5.5f, new String[] {"Beatriz Turim", "Gabriel Caparra"});
		Livro livroTeste3 = new Livro("Teste 3", 99, 18.79f, new String[] {"Filomena T Real"});
		Livro livroTeste4 = new Livro("Teste 4", 24, 0.99f, new String[] {"Miguel Luz", "Sara Luz", "Marco Luz"});
		Livro livroTeste5 = new Livro("Teste 5", 111, 21.31f, new String[] {"Xavier Terno", "Telmo Guilherme", "Lucinda Ferro", "Diogo Ventura"});
		
		//getNumPaginas
		System.out.println("################################# - getNumPaginas - #################################");
		System.out.println();
		
		System.out.println("Expectável : 50  | Recebido : " + livroTeste1.getNumPaginas());
		System.out.println("Expectável : 20  | Recebido : " + livroTeste2.getNumPaginas());
		System.out.println("Expectável : 90  | Recebido : " + livroTeste3.getNumPaginas());
		System.out.println("Expectável : 24  | Recebido : " + livroTeste4.getNumPaginas());
		System.out.println("Expectável : 111 | Recebido : " + livroTeste5.getNumPaginas());
		
		System.out.println();
		System.out.println("################################# -xXx getNumPaginas xXx- #################################");
		
		System.out.println();
		System.out.println();
		
		//getPreco
		System.out.println("################################# - getPreco - #################################");
		System.out.println();
		
		System.out.println("Expectável : 15.0  | Recebido : " + livroTeste1.getPreco());
		System.out.println("Expectável : 5.5   | Recebido : " + livroTeste2.getPreco());
		System.out.println("Expectável : 18.79 | Recebido : " + livroTeste3.getPreco());
		System.out.println("Expectável : 0.99  | Recebido : " + livroTeste4.getPreco());
		System.out.println("Expectável : 21.31 | Recebido : " + livroTeste5.getPreco());
		
		System.out.println();
		System.out.println("################################# -xXx getPreco xXx- #################################");
		
		System.out.println();
		System.out.println();
		
		//contemAutor
		System.out.println("################################# - contemAutor - #################################");
		System.out.println();
		
		System.out.println("Livro Teste 1 Contem Afonso?               Expectável : false   | Recebido : " + livroTeste1.contemAutor("Afonso"));
		System.out.println("Livro Teste 1 Contem Benjamim Fernandes?   Expectável : false   | Recebido : " + livroTeste1.contemAutor("Benjamim Fernades"));
		System.out.println("Livro Teste 1 Contem Afonso Risco?         Expectável : true    | Recebido : " + livroTeste1.contemAutor("Afonso Risco"));
		System.out.println("Livro Teste 2 Contem Beatriz Caparra?      Expectável : false   | Recebido : " + livroTeste2.contemAutor("Beatriz Caparra"));
		System.out.println("Livro Teste 2 Contem Beatriz Tirum?        Expectável : false   | Recebido : " + livroTeste2.contemAutor("Beatriz Tirum"));
		System.out.println("Livro Teste 2 Contem Gabriel Caparra?      Expectável : true    | Recebido : " + livroTeste2.contemAutor("Gabriel Caparra"));
		System.out.println("Livro Teste 3 Contem Filomena A Real?      Expectável : false   | Recebido : " + livroTeste3.contemAutor("Filomena A Real"));
		System.out.println("Livro Teste 3 Contem Filomena T Real?      Expectável : true    | Recebido : " + livroTeste3.contemAutor("Filomena T Real"));
		System.out.println("Livro Teste 4 Contem Rui Luz?              Expectável : false   | Recebido : " + livroTeste4.contemAutor("Rui Luz"));
		System.out.println("Livro Teste 4 Contem Sara Luz?             Expectável : true    | Recebido : " + livroTeste4.contemAutor("Sara Luz"));
		System.out.println("Livro Teste 5 Contem Xavi?                 Expectável : false   | Recebido : " + livroTeste5.contemAutor("Xavi"));
		System.out.println("Livro Teste 5 Contem Diogo Ventura?        Expectável : true    | Recebido : " + livroTeste5.contemAutor("Diogo Ventura"));
		
		System.out.println();
		System.out.println("################################# -xXx contemAutor xXx- #################################");
		
		System.out.println();
		System.out.println();

		//getAutores
		System.out.println("################################# - getAutores - #################################");
		System.out.println();
		
		String[] autoresLivroTeste1 = livroTeste1.getAutores();
		String[] autoresLivroTeste2 = livroTeste2.getAutores();
		String[] autoresLivroTeste3 = livroTeste3.getAutores();
		String[] autoresLivroTeste4 = livroTeste4.getAutores();
		String[] autoresLivroTeste5 = livroTeste5.getAutores();
		
		System.out.print("Autores Livro Teste 1 > Expectável : {Afonso Risco} | Recebido : ");
		
		for(int autoresIndex = 0; autoresIndex < autoresLivroTeste1.length; autoresIndex++)
		{
			if(autoresIndex == 0)
			{
				System.out.print("{");
			}
			
			System.out.print(autoresLivroTeste1[autoresIndex]);
			
			if(autoresIndex == autoresLivroTeste1.length - 1)
			{
				System.out.println("}");
			}
			else
			{
				System.out.print(", ");
			}
		}
		
		System.out.print("Autores Livro Teste 2 > Expectável : {Beatriz Turim, Gabriel Caparra} | Recebido : ");
		
		for(int autoresIndex = 0; autoresIndex < autoresLivroTeste2.length; autoresIndex++)
		{
			if(autoresIndex == 0)
			{
				System.out.print("{");
			}
			
			System.out.print(autoresLivroTeste2[autoresIndex]);
			
			if(autoresIndex == autoresLivroTeste2.length - 1)
			{
				System.out.println("}");
			}
			else
			{
				System.out.print(", ");
			}
		}
		
		System.out.print("Autores Livro Teste 3 > Expectável : {Filomena T Real} | Recebido : ");
		
		for(int autoresIndex = 0; autoresIndex < autoresLivroTeste3.length; autoresIndex++)
		{
			if(autoresIndex == 0)
			{
				System.out.print("{");
			}
			
			System.out.print(autoresLivroTeste3[autoresIndex]);
			
			if(autoresIndex == autoresLivroTeste3.length - 1)
			{
				System.out.println("}");
			}
			else
			{
				System.out.print(", ");
			}
		}
		
		System.out.print("Autores Livro Teste 4 > Expectável : {Miguel Luz, Sara Luz, Marco Luz} | Recebido : ");
		
		for(int autoresIndex = 0; autoresIndex < autoresLivroTeste4.length; autoresIndex++)
		{
			if(autoresIndex == 0)
			{
				System.out.print("{");
			}
			
			System.out.print(autoresLivroTeste4[autoresIndex]);
			
			if(autoresIndex == autoresLivroTeste4.length - 1)
			{
				System.out.println("}");
			}
			else
			{
				System.out.print(", ");
			}
		}
		
		System.out.print("Autores Livro Teste 5 > Expectável : {Xavier Terno, Telmo Guilherme, Lucinda Ferro, Diogo Ventura} | Recebido : ");
		
		for(int autoresIndex = 0; autoresIndex < autoresLivroTeste5.length; autoresIndex++)
		{
			if(autoresIndex == 0)
			{
				System.out.print("{");
			}
			
			System.out.print(autoresLivroTeste5[autoresIndex]);
			
			if(autoresIndex == autoresLivroTeste5.length - 1)
			{
				System.out.println("}");
			}
			else
			{
				System.out.print(", ");
			}
		}
		
		System.out.println();
		System.out.println("################################# -xXx getAutores xXx- #################################");
		
		System.out.println();
		System.out.println();

		//toString
		System.out.println("################################# - toString - #################################");
		System.out.println();
		
		System.out.println("Livro Teste 1 > Expectável : Teste 1, 50p 15.0 [Afonso Risco] | Recebido : " + livroTeste1.toString());
		System.out.println("Livro Teste 2 > Expectável : Teste 2, 20p 5.5 [Beatriz Turim, Gabriel Caparra] | Recebido : " + livroTeste2.toString());
		System.out.println("Livro Teste 3 > Expectável : Teste 3, 99p 18.79 [Filomena T Real] | Recebido : " + livroTeste3.toString());
		System.out.println("Livro Teste 4 > Expectável : Teste 4, 24p 0.99 [Miguel Luz, Sara Luz, Marco Luz] | Recebido : " + livroTeste4.toString());
		System.out.println("Livro Teste 5 > Expectável : Teste 5, 111p 21.31 [Xavier Terno, Telmo Guilherme, Lucinda Ferro, Diogo Ventura] | Recebido : " + livroTeste5.toString());
		
		System.out.println();
		System.out.println("################################# -xXx toString xXx- #################################");
		
		System.out.println();
		System.out.println();

		//equals
		System.out.println("################################# - equals - #################################");
		System.out.println();

		
		System.out.println(" # Teste 1");
		Livro livroEqualsTeste1 = new Livro("Teste 1", 50, 15f, new String[] {"Afonso Risco"});
		Livro livroEqualsTeste2 = new Livro("Teste 1", 30, 7.55f, new String[] {"Carlos Noruega"});
		Livro livroEqualsTeste3 = new Livro("Teste 0", 30, 15f, new String[] {"Afonso Risco"});
		Livro livroEqualsTeste4 = new Livro("Teste 99", 120, 29.98f, new String[] {"Gustavo Albuquerque", "Margarida Feliz"});
		
		System.out.println(livroTeste1.toString() + " Equals " + livroEqualsTeste1.toString() + " ? Expectável : true  | Recebido : " + livroTeste1.equals(livroEqualsTeste1));
		System.out.println(livroTeste1.toString() + " Equals " + livroEqualsTeste2.toString() + " ? Expectável : true  | Recebido : " + livroTeste1.equals(livroEqualsTeste2));
		System.out.println(livroTeste1.toString() + " Equals " + livroEqualsTeste3.toString() + " ? Expectável : false | Recebido : " + livroTeste1.equals(livroEqualsTeste3));
		System.out.println(livroTeste1.toString() + " Equals " + livroEqualsTeste4.toString() + " ? Expectável : false | Recebido : " + livroTeste1.equals(livroEqualsTeste4));
		System.out.println();
		
		System.out.println(" # Teste 2");
		
		livroEqualsTeste1 = new Livro("Teste 2", 20, 5.5f, new String[] {"Beatriz Turim", "Gabriel Caparra"});
		livroEqualsTeste2 = new Livro("Teste 2", 30, 7.55f, new String[] {"Francisca Guerreiro"});
		livroEqualsTeste3 = new Livro("Teste 0", 30, 15f, new String[] {"Beatriz Turim", "Gabriel Caparra"});
		livroEqualsTeste4 = new Livro("Teste 99", 120, 29.98f, new String[] {"Augusto Oliveira", "Sofia Milhar"});
		
		System.out.println(livroTeste2.toString() + " Equals " + livroEqualsTeste1.toString() + " ? Expectável : true  | Recebido : " + livroTeste2.equals(livroEqualsTeste1));
		System.out.println(livroTeste2.toString() + " Equals " + livroEqualsTeste2.toString() + " ? Expectável : true  | Recebido : " + livroTeste2.equals(livroEqualsTeste2));
		System.out.println(livroTeste2.toString() + " Equals " + livroEqualsTeste3.toString() + " ? Expectável : false | Recebido : " + livroTeste2.equals(livroEqualsTeste3));
		System.out.println(livroTeste2.toString() + " Equals " + livroEqualsTeste4.toString() + " ? Expectável : false | Recebido : " + livroTeste2.equals(livroEqualsTeste4));
		System.out.println();		
		
		System.out.println(" # Teste 3");
		
		livroEqualsTeste1 = new Livro("Teste 3", 99, 18.79f, new String[] {"Filomena T Real"});
		livroEqualsTeste2 = new Livro("Teste 3", 30, 7.55f, new String[] {"Vladimir Rute"});
		livroEqualsTeste3 = new Livro("Teste 0", 30, 15f, new String[] {"Filipe Sampaio"});
		livroEqualsTeste4 = new Livro("Teste 99", 120, 29.98f, new String[] {"Frederico Tavares", "David Reboio"});
		
		System.out.println(livroTeste3.toString() + " Equals " + livroEqualsTeste1.toString() + " ? Expectável : true  | Recebido : " + livroTeste3.equals(livroEqualsTeste1));
		System.out.println(livroTeste3.toString() + " Equals " + livroEqualsTeste2.toString() + " ? Expectável : true  | Recebido : " + livroTeste3.equals(livroEqualsTeste2));
		System.out.println(livroTeste3.toString() + " Equals " + livroEqualsTeste3.toString() + " ? Expectável : false | Recebido : " + livroTeste3.equals(livroEqualsTeste3));
		System.out.println(livroTeste3.toString() + " Equals " + livroEqualsTeste4.toString() + " ? Expectável : false | Recebido : " + livroTeste3.equals(livroEqualsTeste4));
		System.out.println();
		
		System.out.println(" # Teste 4");
		
		livroEqualsTeste1 = new Livro("Teste 4", 24, 0.99f, new String[] {"Miguel Luz", "Sara Luz", "Marco Luz"});
		livroEqualsTeste2 = new Livro("Teste 4", 30, 7.55f, new String[] {"Ricardo Silva", "Gilbero Costa"});
		livroEqualsTeste3 = new Livro("Teste 0", 30, 15f, new String[] {"André Flores"});
		livroEqualsTeste4 = new Livro("Teste 99", 120, 29.98f, new String[] {"Susana Dias", "Carlos Dias"});
		
		System.out.println(livroTeste4.toString() + " Equals " + livroEqualsTeste1.toString() + " ? Expectável : true  | Recebido : " + livroTeste4.equals(livroEqualsTeste1));
		System.out.println(livroTeste4.toString() + " Equals " + livroEqualsTeste2.toString() + " ? Expectável : true  | Recebido : " + livroTeste4.equals(livroEqualsTeste2));
		System.out.println(livroTeste4.toString() + " Equals " + livroEqualsTeste3.toString() + " ? Expectável : false | Recebido : " + livroTeste4.equals(livroEqualsTeste3));
		System.out.println(livroTeste4.toString() + " Equals " + livroEqualsTeste4.toString() + " ? Expectável : false | Recebido : " + livroTeste4.equals(livroEqualsTeste4));
		System.out.println();
		
		System.out.println(" # Teste 5");
		
		livroEqualsTeste1 = new Livro("Teste 5", 111, 21.31f, new String[] {"Xavier Terno", "Telmo Guilherme", "Lucinda Ferro", "Diogo Ventura"});
		livroEqualsTeste2 = new Livro("Teste 5", 30, 7.55f, new String[] {"Afonso Dinis", "Luísa Reis"});
		livroEqualsTeste3 = new Livro("Teste 0", 30, 15f, new String[] {"Paulo Páscoa", "Paulo Trindade"});
		livroEqualsTeste4 = new Livro("Teste 99", 120, 29.98f, new String[] {"Telma Dias", "Ivo Gerónimo"});
		
		System.out.println(livroTeste5.toString() + " Equals " + livroEqualsTeste1.toString() + " ? Expectável : true  | Recebido : " + livroTeste5.equals(livroEqualsTeste1));
		System.out.println(livroTeste5.toString() + " Equals " + livroEqualsTeste2.toString() + " ? Expectável : true  | Recebido : " + livroTeste5.equals(livroEqualsTeste2));
		System.out.println(livroTeste5.toString() + " Equals " + livroEqualsTeste3.toString() + " ? Expectável : false | Recebido : " + livroTeste5.equals(livroEqualsTeste3));
		System.out.println(livroTeste5.toString() + " Equals " + livroEqualsTeste4.toString() + " ? Expectável : false | Recebido : " + livroTeste5.equals(livroEqualsTeste4));
		System.out.println();
		
		System.out.println();
		System.out.println("################################# -xXx equals xXx- #################################");
 	}
}
