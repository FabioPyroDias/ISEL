package bookcode.p03FlowDecisions;

import java.util.*;

/**
 * Calcula o novo valor da conta bancária no final de um mês. Caso o saldo
 * introduzido seja 0 ou negativo deduz 8 euros. CAso o saldo seja positivo,
 * adiciona os juros, tendo em conta que os juro anual é de 2%.
 */
public class C01BankBalance {
	public static final double OVERDRAWN_PENALTY = 8.00; // penalização
	public static final double INTEREST_RATE = 0.02; // 2% - taxa de juro anual

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		double balance;

		// input the account balance
		System.out.print("Enter your checking account balance: ");
		balance = keyboard.nextDouble();

		System.out.println("Original balance " + balance);

		// calculate the new balance
		if (balance >= 0)
			balance = balance + (INTEREST_RATE * balance) / 12;
		else
			balance = balance - OVERDRAWN_PENALTY;

		// output the new value
		System.out.println("After adjusting for one month "
				+ "of interest and penalties, ");
		System.out.println("your new balance is " + balance);

		// close keyboard
		keyboard.close();
	}
}
