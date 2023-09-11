package classcode.p02FlowDecisionsCycles;

import java.util.Scanner;

public class C00SequentialCode {

	public static void main(String[] args) {

		// the keyboard reader
		Scanner keyboard = new Scanner(System.in);

		// ask and read an integer
		System.out.print("Introduza um número inteiro: ");
		int num = keyboard.nextInt();
		
		// calculate the double of the input value
		int dobro = num * 2;
		
		// show input value and the double of it
		System.out.println("O dobro de " + num + " é " + dobro);

		// close the keyboard
		keyboard.close();
		
		// int x = 0;
		
	}

}
