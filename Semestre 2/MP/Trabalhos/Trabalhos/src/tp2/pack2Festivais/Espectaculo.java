package tp2.pack2Festivais;

public class Espectaculo extends Evento{

	private int nArtistas = 0;
	
	private String[] artistas = new String[10];
	
	private int numBilhetes = 0;
	
	private String localidade = "";
	
	public Espectaculo(String nome, String localidade, int numBilhetes)
	{
		super(nome);
		
		//Localidade
		if(localidade == null)
		{
			throw new IllegalArgumentException("A localidade não pode ser null");
		}		
		
		if(localidade.length() == 0)
		{
			throw new IllegalArgumentException("O tamanho da localidade não pode ser 0");
		}
		
		int letterCounter = 0;
		
		for(int charIndex = 0; charIndex < localidade.length(); charIndex++)
    	{
    		if(!Character.isLetter(localidade.charAt(charIndex)) && !Character.isWhitespace(localidade.charAt(charIndex)) && !Character.isDigit(localidade.charAt(charIndex)))
			{
    			throw new IllegalArgumentException("A localidade só pode possuir letras, espaços e números");
			}
    		
    		if(Character.isLetter(localidade.charAt(charIndex)))
    		{
    			letterCounter++;
    		}
    	}
		
		if(letterCounter == 0)
		{
			throw new IllegalArgumentException("A localidade tem de ter, pelo menos, um caractere");
		}
		
		this.localidade = localidade;
		
		//NumBilhetes
		if(numBilhetes <= 0)
		{
			throw new IllegalArgumentException("O número de bilhetes deve ser superior a 0");
		}
		
		this.numBilhetes = numBilhetes;
	}
	
	public int numActuacoes(String artista) {
		
		for(int index = 0; index < nArtistas; index++)
		{
			if(artistas[index].equals(artista))
			{
				return 1;
			}
		}
		
		return 0;
	}
	
	public boolean addArtista(String artista)
	{
		if(numActuacoes(artista) == 1 || nArtistas == artistas.length)
		{
			return false;
		}
		
		artistas[nArtistas] = artista;
		nArtistas++;
		
		return true;
	}
	
	public int getNumBilhetes() {

		return numBilhetes;
	}

	public String[] getArtistas() {
		
		String[] artistasRegistados = new String[nArtistas];
		
		for(int index = 0; index < nArtistas; index++)
		{
			artistasRegistados[index] = artistas[index];
		}
		
		return artistasRegistados;
	}
	
	public String toString()
	{
		return super.toString() + " em " + localidade;
	}
	
	public static void main(String[] args) {
		
		System.out.println("#####---- Testes ----#####");
		System.out.println();
		
		System.out.println(" - Testar Constructor - ");
		System.out.println();
		
		System.out.println("####### Nome #######");
		System.out.println();
		
		System.out.println(" - Nome é null");
		try {
			Espectaculo espectaculoErrado = new Espectaculo(null, "Main", 404);			
		} 
		catch(IllegalArgumentException ex)
		{
			ex.printStackTrace();
		}
		System.out.println();
		
		System.out.println(" - Nome é vazio");
		try {
			Espectaculo espectaculoErrado = new Espectaculo("", "Main", 404);			
		} 
		catch(IllegalArgumentException ex)
		{
			ex.printStackTrace();
		}
		System.out.println();
		
		System.out.println(" - Nome não pode possuir simbolos");
		try {
			Espectaculo espectaculoErrado = new Espectaculo("Nome Inválido #", "Main", 404);			
		} 
		catch(IllegalArgumentException ex)
		{
			ex.printStackTrace();
		}
		System.out.println();
		
		System.out.println(" - Nome Correcto");
		try {
			Espectaculo espectaculoErrado = new Espectaculo("Nome Válido 23245     F", "Main", 404);
			System.out.println(espectaculoErrado.toString());
		} 
		catch(IllegalArgumentException ex)
		{
			ex.printStackTrace();
		}
		System.out.println();
		
		System.out.println("####### Nome #######");
		System.out.println();
		
		System.out.println("####### Localidade #######");
		System.out.println();
		
		System.out.println(" - Localidade é null");
		try {
			Espectaculo espectaculoErrado = new Espectaculo("Nome Válido", null, 404);			
		} 
		catch(IllegalArgumentException ex)
		{
			ex.printStackTrace();
		}
		System.out.println();
		
		System.out.println(" - Localidade é vazio");
		try {
			Espectaculo espectaculoErrado = new Espectaculo("Nome Válido", "", 404);			
		} 
		catch(IllegalArgumentException ex)
		{
			ex.printStackTrace();
		}
		System.out.println();
		
		System.out.println(" - Localidade não pode possuir simbolos");
		try {
			Espectaculo espectaculoErrado = new Espectaculo("Nome Válido", "Main #", 404);			
		} 
		catch(IllegalArgumentException ex)
		{
			ex.printStackTrace();
		}
		System.out.println();
		
		System.out.println(" - Localidade Correcta");
		try {
			Espectaculo espectaculoErrado = new Espectaculo("Nome Válido", "Eclipse Main", 404);
			System.out.println(espectaculoErrado.toString());
		} 
		catch(IllegalArgumentException ex)
		{
			ex.printStackTrace();
		}
		System.out.println();
		
		System.out.println("####### Localidade #######");
		System.out.println();
		
		System.out.println("####### Número de Bilhetes #######");
		System.out.println();
		
		System.out.println(" - numBilhetes é negativo");
		try {
			Espectaculo espectaculoErrado = new Espectaculo("Nome Válido", "Eclipse Main", -5);			
		} 
		catch(IllegalArgumentException ex)
		{
			ex.printStackTrace();
		}
		System.out.println();
		
		System.out.println(" - numBilhetes é 0");
		try {
			Espectaculo espectaculoErrado = new Espectaculo("Nome Válido", "Eclipse Main", 0);			
		} 
		catch(IllegalArgumentException ex)
		{
			ex.printStackTrace();
		}
		System.out.println();
		
		System.out.println(" - numBilhetes Correcto");
		try {
			Espectaculo espectaculoErrado = new Espectaculo("Nome Válido", "Eclipse Main", 100);
			System.out.println(espectaculoErrado.toString());
		} 
		catch(IllegalArgumentException ex)
		{
			ex.printStackTrace();
		}
		System.out.println();
		
		System.out.println("####### Numero de Bilhetes #######");
		System.out.println();
		
		System.out.println(" - Testar Métodos - ");
		System.out.println();
		
		Espectaculo espectaculoTeste1 = new Espectaculo("Teste Espectulo 1", "Eclipse Main", 120);
		Espectaculo espectaculoTeste2 = new Espectaculo("Teste Espectulo 2", "ISEL", 200);
		Espectaculo espectaculoTeste3 = new Espectaculo("Teste Espectulo 3", "Marte", 1250);
		
		System.out.println("Espectáculos: ");
		System.out.println(espectaculoTeste1.toString());
		System.out.println(espectaculoTeste2.toString());
		System.out.println(espectaculoTeste3.toString());
		System.out.println();
		
		System.out.println("####### getNumBilhetes #######");
		System.out.println();
		
		System.out.println("Espectaculo Teste 1 > Expectável : 120  | Recebido : " + espectaculoTeste1.getNumBilhetes());
		System.out.println("Espectaculo Teste 2 > Expectável : 200  | Recebido : " + espectaculoTeste2.getNumBilhetes());
		System.out.println("Espectaculo Teste 3 > Expectável : 1250 | Recebido : " + espectaculoTeste3.getNumBilhetes());
		System.out.println();
		
		System.out.println("####### getNumBilhetes #######");
		System.out.println();
		
		System.out.println("####### addArtista #######");
		System.out.println();
		
		String artistaTeste1 = "Afonso Risco";
		String artistaTeste2 = "Beatriz Valeta";
		String artistaTeste3 = "Carlos Trindade";
		String artistaTeste4 = "Dionisio Asa";
		String artistaTeste5 = "Eduardo Carreira";
		String artistaTeste6 = "Francisca Gilberto";
		
		System.out.println("Adicionar Afonso Risco, duas vezes, a Espectaculo Teste 1");
		System.out.println("Adicionar Afonso Risco a Espectaculo Teste 1 > Expectável : true  | Recebido : " + espectaculoTeste1.addArtista(artistaTeste1));
		System.out.println("Adicionar Afonso Risco a Espectaculo Teste 1 > Expectável : false | Recebido : " + espectaculoTeste1.addArtista(artistaTeste1));
		System.out.println();
		
		System.out.println("Adicionar Beatriz Valeta, duas vezes, a Espectaculo Teste 2");
		System.out.println("Adicionar Beatriz Valeta a Espectaculo Teste 2 > Expectável : true  | Recebido : " + espectaculoTeste2.addArtista(artistaTeste2));
		System.out.println("Adicionar Beatriz Valeta a Espectaculo Teste 2 > Expectável : false | Recebido : " + espectaculoTeste2.addArtista(artistaTeste2));
		System.out.println();
		
		System.out.println("Adicionar Carlos Trindade, duas vezes, a Espectaculo Teste 2");
		System.out.println("Adicionar Carlos Trindade a Espectaculo Teste 2 > Expectável : true  | Recebido : " + espectaculoTeste2.addArtista(artistaTeste3));
		System.out.println("Adicionar Carlos Trindade a Espectaculo Teste 2 > Expectável : false | Recebido : " + espectaculoTeste2.addArtista(artistaTeste3));
		System.out.println();
		
		System.out.println("Adicionar Dionisio Asa, duas vezes, a Espectaculo Teste 3");
		System.out.println("Adicionar Dionisio Asa a Espectaculo Teste 3 > Expectável : true  | Recebido : " + espectaculoTeste3.addArtista(artistaTeste4));
		System.out.println("Adicionar Dionisio Asa a Espectaculo Teste 3 > Expectável : false | Recebido : " + espectaculoTeste3.addArtista(artistaTeste4));
		System.out.println();
		
		System.out.println("Adicionar Eduardo Carreira, duas vezes, a Espectaculo Teste 3");
		System.out.println("Adicionar Eduardo Carreira a Espectaculo Teste 3 > Expectável : true  | Recebido : " + espectaculoTeste3.addArtista(artistaTeste5));
		System.out.println("Adicionar Eduardo Carreira a Espectaculo Teste 3 > Expectável : false | Recebido : " + espectaculoTeste3.addArtista(artistaTeste5));
		System.out.println();
		
		System.out.println("Adicionar Francisca Gilberto, duas vezes, a Espectaculo Teste 3");
		System.out.println("Adicionar Francisca Gilberto a Espectaculo Teste 3 > Expectável : true  | Recebido : " + espectaculoTeste3.addArtista(artistaTeste6));
		System.out.println("Adicionar Francisca Gilberto a Espectaculo Teste 3 > Expectável : false | Recebido : " + espectaculoTeste3.addArtista(artistaTeste6));
		System.out.println();
		
		System.out.println("Espectáculos: ");
		System.out.println(espectaculoTeste1.toString());
		System.out.println(espectaculoTeste2.toString());
		System.out.println(espectaculoTeste3.toString());
		System.out.println();
		
		System.out.println("####### addArtista #######");
		System.out.println();
		
		System.out.println("####### getArtistas #######");
		System.out.println();
		
		System.out.print("Artistas do Espectaculo Teste 1 : ");
		String[] artistasEspectaculoTeste1 = espectaculoTeste1.getArtistas();
		
		for(int indexArtista = 0; indexArtista < artistasEspectaculoTeste1.length; indexArtista++)
		{
			if(indexArtista == 0)
			{
				System.out.print("[");
			}
			
			System.out.print(artistasEspectaculoTeste1[indexArtista]);
			
			if(indexArtista == artistasEspectaculoTeste1.length - 1)
			{
				System.out.println("]");
			}
			else 
			{
				System.out.print(", ");
			}
		}
		System.out.println();
		
		System.out.print("Artistas do Espectaculo Teste 2 : ");
		String[] artistasEspectaculoTeste2 = espectaculoTeste2.getArtistas();
		
		for(int indexArtista = 0; indexArtista < artistasEspectaculoTeste2.length; indexArtista++)
		{
			if(indexArtista == 0)
			{
				System.out.print("[");
			}
			
			System.out.print(artistasEspectaculoTeste2[indexArtista]);
			
			if(indexArtista == artistasEspectaculoTeste2.length - 1)
			{
				System.out.println("]");
			}
			else 
			{
				System.out.print(", ");
			}
		}
		System.out.println();
		
		System.out.print("Artistas do Espectaculo Teste 3 : ");
		String[] artistasEspectaculoTeste3 = espectaculoTeste3.getArtistas();
		
		for(int indexArtista = 0; indexArtista < artistasEspectaculoTeste3.length; indexArtista++)
		{
			if(indexArtista == 0)
			{
				System.out.print("[");
			}
			
			System.out.print(artistasEspectaculoTeste3[indexArtista]);
			
			if(indexArtista == artistasEspectaculoTeste3.length - 1)
			{
				System.out.println("]");
			}
			else 
			{
				System.out.print(", ");
			}
		}
		System.out.println();
		
		System.out.println("####### getArtistas #######");
		System.out.println();
		
		System.out.println("####### numAtuacoes #######");
		System.out.println();
		
		System.out.println("Numero de Atuações de Afonso Risco no Espectaculo Teste 1 > Expectável : 1 | Recebido : " + espectaculoTeste1.numActuacoes(artistaTeste1));
		System.out.println("Numero de Atuações de Afonso Risco no Espectaculo Teste 3 > Expectável : 0 | Recebido : " + espectaculoTeste3.numActuacoes(artistaTeste1));
		System.out.println();
		
		System.out.println("Numero de Atuações de Beatriz Valeta no Espectaculo Teste 2 > Expectável : 1 | Recebido : " + espectaculoTeste2.numActuacoes(artistaTeste2));
		System.out.println("Numero de Atuações de Beatriz Valeta no Espectaculo Teste 1 > Expectável : 0 | Recebido : " + espectaculoTeste1.numActuacoes(artistaTeste2));
		System.out.println();
		
		System.out.println("Numero de Atuações de Eduardo Carreira no Espectaculo Teste 3 > Expectável : 1 | Recebido : " + espectaculoTeste3.numActuacoes(artistaTeste5));
		System.out.println("Numero de Atuações de Eduardo Carreira no Espectaculo Teste 2 > Expectável : 0 | Recebido : " + espectaculoTeste2.numActuacoes(artistaTeste5));
		System.out.println();
		
		System.out.println("####### numAtuacoes #######");
		System.out.println();
	}
}