package tp2.pack1ColeccoesComHeranca;

public abstract class Obra implements IObra {

	private String titulo;

	/**
	 * Constructor
	 */
	public Obra(String titulo) {
		// título (valida título e guarda-o)
		if(!validarNome(titulo))
		{
			throw new IllegalArgumentException("O título é inválido");
		}

		this.titulo = removeExtraSpaces(titulo);
	}

	/**
	 * Devolve o título da obra
	 */
	public String getTitulo() {

		return titulo;
	}

	/**
	 * Deve devolver true se o array conter apenas nomes válidos. Cada nome deve ser
	 * validado pelo método validarNome
	 */
	public static boolean validarNomes(String[] nomes) {
		
		for(int nomeIndex = 0; nomeIndex < nomes.length; nomeIndex++)
		{
			if(!validarNome(nomes[nomeIndex]))
			{
				return false;
			}
		}
		
		return true;
	}

	/**
	 * Um nome válido se não for null e conter pelo menos uma letra
	 * (Character.isLetter) e só conter letras e espaços (Character.isWhitespace)
	 */
	public static boolean validarNome(String nome) {
		
		if(nome == null || nome.length() == 0)
		{
			return false;
		}		
		
		int letterCounter = 0;
		
		for(int charIndex = 0; charIndex < nome.length(); charIndex++)
    	{
    		if(!Character.isLetter(nome.charAt(charIndex)) && !Character.isWhitespace(nome.charAt(charIndex)) && !Character.isDigit(nome.charAt(charIndex)))
			{
    			return false;
			}
    		
    		if(Character.isLetter(nome.charAt(charIndex)))
    		{
    			letterCounter++;
    		}
    	}
		
		if(letterCounter == 0)
		{
			return false;
		}
		
		return true;
	}

	/**
	 * Recebe um nome já previamente validado, ou seja só com letras ou espaços.
	 * Deve devolver o mesmo nome mas sem espaços (utilizar trim e
	 * Character.isWhitespace) no início nem no fim e só com um espaço ' ' entre
	 * cada nome. Deve utilizar um StringBuilder para ir contendo o nome já
	 * corrigido
	 */
	public static String removeExtraSpaces(String nome) {
		
		StringBuilder builder = new StringBuilder();
    	nome = nome.trim();    	
    	
    	int charIndex = 0;
    	int whitespaceInARow = 0;
    	
    	while(charIndex < nome.length())
    	{
    		if(Character.isWhitespace(nome.charAt(charIndex)))
    		{
    			whitespaceInARow++;
    			
    			if(whitespaceInARow < 2)
    			{
    				builder.append(nome.charAt(charIndex));
    			}
    		}
    		else
    		{
    			whitespaceInARow = 0;
    			builder.append(nome.charAt(charIndex));
    		}
    		
    		charIndex++;
    	}
    	
    	return builder.toString();
	}

	/**
	 * Método que verifica se há elementos repetidos. O array recebido não contém
	 * nulls.
	 */
	public static boolean haRepeticoes(String[] elems) {
		
		for(int elementIndex = 0; elementIndex < elems.length; elementIndex++)
		{
			String elementToBeCompared = elems[elementIndex];
			int elementToBeComparedIndex = elementIndex;
			
			for(int compareElementIndex = 0; compareElementIndex < elems.length; compareElementIndex++)
			{
				if(elementToBeComparedIndex != compareElementIndex)
				{
					if(elementToBeCompared.equals(elems[compareElementIndex]))
					{
						return true;
					}
				}
			}
		}
		
		return false;
	}

	/**
	 * Devolve uma string com a informação da obra (ver outputs desejados e método
	 * toString de Livro)
	 */
	public String toString() {
		
		return titulo;
	}

	/**
	 * Deve mostrar na consola a informação da obra (toString) precedida do prefixo
	 * recebido
	 */
	public void print(String prefix) {
		System.out.println(prefix + toString());
	}

	/**
	 * O Object recebido é igual, se não for null, se for uma obra e se tiver o
	 * mesmo título que o título da obra corrente
	 */
	public boolean equals(Object l) {
		
		if(l == null || !(l instanceof Obra))
		{
			return false;
		}
	
		if(!((Obra) l).getTitulo().equals(getTitulo()))
		{
			return false;
		}
		
		return true;
	}

}