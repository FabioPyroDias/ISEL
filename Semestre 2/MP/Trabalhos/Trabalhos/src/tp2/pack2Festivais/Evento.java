package tp2.pack2Festivais;

public abstract class Evento {
	
	private String nome;
	
	public Evento(String nome)
	{
		if(nome == null)
		{
			throw new IllegalArgumentException("O nome não pode ser null");
		}		
		
		if(nome.length() == 0)
		{
			throw new IllegalArgumentException("O tamanho do nome não pode ser 0");
		}
		
		int letterCounter = 0;
		
		for(int charIndex = 0; charIndex < nome.length(); charIndex++)
    	{
    		if(!Character.isLetter(nome.charAt(charIndex)) && !Character.isWhitespace(nome.charAt(charIndex)) && !Character.isDigit(nome.charAt(charIndex)))
			{
    			throw new IllegalArgumentException("O nome só pode possuir letras, espaços e números");
			}
    		
    		if(Character.isLetter(nome.charAt(charIndex)))
    		{
    			letterCounter++;
    		}
    	}
		
		if(letterCounter == 0)
		{
			throw new IllegalArgumentException("O nome tem de ter, pelo menos, um caractere");
		}
		
		this.nome = nome;
	}
	
	public abstract int getNumBilhetes();
	
	public abstract String[] getArtistas();
	
	public abstract int numActuacoes(String artista);
	
	public String toString()
	{
		String toString = nome + " com " + getNumBilhetes() + " bilhetes e com ";
		
		if(getArtistas().length > 1)
		{
			toString += "os artistas [";
		}
		else
		{
			toString += "o artista [";
		}
		
		for(int index = 0; index < getArtistas().length; index++)
		{
			toString += getArtistas()[index];
			
			if(index != getArtistas().length - 1)
			{
				toString += ", ";
			}
		}
		
		toString += "]";
		
		return toString;
	}
}