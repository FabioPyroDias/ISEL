package tp1.pack1Revisoes;

import java.util.Scanner;

public class P01CheckPrime {

    /**
     * Corre o programa, pedindo ao jogador um número inteiro e validando o seu input.
     */
    public static void main(String[] args) {
        
    	Scanner scanner = new Scanner(System.in);
    	boolean isExecuting = true;
    	
    	int number = -1;
    	
    	while(isExecuting)
    	{
    		boolean isString = false;
    		
    		System.out.println("Introduza um número inteiro positivo: ");
    		String inputReceived = scanner.nextLine();

    		try
    		{
    			number = Integer.parseInt(inputReceived);
    		}
    		catch (Exception e) {
				System.out.println("Input recebido é inválido.");
				System.out.println();
				isString = true;
			}
    		
    		if(!isString)
    		{
    			if(number == 0)
    			{
    				isExecuting = false;
    				System.out.println("Programa Terminado");
    			}
    			else if(number < 0)
    			{
    				System.out.println("Input recebido é inválido. O número tem de ser positivo.");
    				System.out.println();
    			}
    			else
    			{
    				System.out.print("O número " + number);
    				
    				if(isPrime(number))
    				{
    					System.out.print(" é");    					
    				}
    				else
    				{
    					System.out.print(" não é");
    				
    				}
    				System.out.println(" primo");
    				System.out.println();
    			}
    		}
    	}
    	
    	scanner.close();
    }

    /**
     * Avalia se o número introduzido pelo utilizador é, ou não, primo.
     * 
     * @param number O número a ser avaliado	
     */
    public static boolean isPrime(int number) {
    	
    	int i = 2;
    	boolean isPrime = true;
    	
    	if(number == 1)
    	{
    		return true;
    	}
    	
		while(number / 2 >= i)
		{
			if(number % i == 0)
			{
				isPrime = false;
				break;
			}
			
			i++;
		}
    	
    	if(isPrime)
    	{
    		return true;
    	}
    	
        return false;
    }
}
