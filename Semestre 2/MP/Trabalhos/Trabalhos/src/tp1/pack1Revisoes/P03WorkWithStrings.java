package tp1.pack1Revisoes;

public class P03WorkWithStrings {

    /**
     * Main, método de arranque da execução
     */
    public static void main(String[] args) {
        test_compareStrings(null, null); // result = 0
        test_compareStrings(null, ""); // result = -1
        test_compareStrings("", null); // result = 1
        test_compareStrings("a", ""); // result = 1
        test_compareStrings("", "a"); // result = -1
        test_compareStrings("a", "a"); // result = 0
        test_compareStrings("b", "a"); // result = 1
        test_compareStrings("a", "b"); // result = -1
        test_compareStrings("aa", "a"); // result = 2
        test_compareStrings("a", "aa"); // result = -2
        test_compareStrings("aa", "aa"); // result = 0
        test_compareStrings("ab", "aa"); // result = 2
        test_compareStrings("ab", "ab"); // result = 0
        test_compareStrings("abc", "abc"); // result = 0
        test_compareStrings("abc", "abd"); // result = -3
    }

    /**
     * Este método recebe duas Strings s1 e s2 e procede à sua comparação,
     * devolvendo um valor positivo se s1 for maior que s2, negativo se ao
     * contrário e 0 se iguais. A comparação deve ser feita primeiro em termos
     * lexicográficos caracter a caracter começando pelos caracteres de menor
     * peso ou em segundo lugar em termos de número de caracteres. Se diferentes
     * deve devolver o índice +1/-1 do caractere que faz a diferença. Ex.
     * s1="Bom", s2="Dia", deve devolver -1; s1="Boa", s2="Bom", deve devolver
     * -3; s1="Bom", s2="Bo", deve devolver 3. Uma String a null é considerada
     * menor que uma string não null.
     *
     * @param s1 string a comparar
     * @param s2 string a comparar
     * @return o resultado da comparação
     */
    private static int compareStrings(String s1, String s2) {
        
    	// ---- Null Check
    	if(s1 == null && s2 == null)
    	{
    		return 0;
    	}
    	else if(s1 == null)
    	{
    		return -1;
    	}
    	else if(s2 == null)
    	{
    		return 1;
    	}   	
    	// ---- Null Check End
    	
    	
    	// ---- Length Check
    	if(s1.length() == 0 && s2.length() == 0)
    	{
    		return 0;
    	}
    	else if(s1.length() == 0)
    	{
    		return -1;
    	}
    	else if(s2.length() == 0)
    	{
    		return 1;
    	}
    	// ---- Length Check End
    
    	
    	// ---- Character Check
    	int smallerLength = 0;
    	
    	boolean foundDifference = false;
    	int differentCharacterIndex = 0;
    	
    	if(s1.length() < s2.length())
    	{
    		smallerLength = s1.length();
    	}
    	else if(s1.length() > s2.length())
    	{
    		smallerLength = s2.length();
    	}
    	else if(s1.length() == s2.length())
    	{
    		smallerLength = s1.length();
    	}
    	
    	for(int charIndex = 0; charIndex < smallerLength; charIndex++)
    	{
    		if(s1.charAt(charIndex) != s2.charAt(charIndex))
    		{
    			//System.out.print("Difference in Char's (s1 " + s1 + " | s2 " + s2 + "): " + charIndex);
    			foundDifference = true;
    			differentCharacterIndex = charIndex;
    			break;
    		}
    	}
    	
    	//Passed ALL Char's and didn't find any difference.
    	if(!foundDifference)
    	{
    		if(s1.length() < s2.length())
    		{
    			return -s2.length();    			
    		}
    		else if(s2.length() < s1.length())
    		{
    			return s1.length();
    		}
    		else
    		{
    			return 0;
    		}
    	}
    	
    	if(s1.charAt(differentCharacterIndex) < s2.charAt(differentCharacterIndex))
    	{
    		return -differentCharacterIndex - 1;
    	}
    	else if(s2.charAt(differentCharacterIndex) < s1.charAt(differentCharacterIndex))
    	{
    		return differentCharacterIndex + 1;
    	}
    	// ---- Character Check End
    	
    	return 0;
    }

    /**
     * Auxiliary method that call compareStrings with two strings
     */
    private static void test_compareStrings(String s1, String s2) {
        try {
            System.out.print("compareStrings (" + s1 + ", " + s2 + ") = ");
            int res = compareStrings(s1, s2);
            System.out.println(res);

        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
