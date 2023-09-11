package bookcode.p02Basic;

import javax.swing.JOptionPane;

/**
 * another example with JOptionPane
 * 
 * @author ateofilo
 * 
 */
public class G04ChangeMakerWindow {
	public static void main(String[] args) {
		// input the amount of money
		String amountString = JOptionPane
				.showInputDialog("Enter a whole number from 1 to 99.\n"
						+ "I will output a combination of coins\n"
						+ "that equals that amount of change.");

		// variables
		int amount, originalAmount, quarters, dimes, nickels, pennies;

		// get the value as an int
		amount = Integer.parseInt(amountString);

		// calc the coins
		originalAmount = amount;
		quarters = amount / 25;
		amount = amount % 25; // amount %= 25;
		dimes = amount / 10;
		amount = amount % 10;// amount %= 10;
		nickels = amount / 5;
		amount = amount % 5; // amount %= 5;
		pennies = amount;

		// output the results
		JOptionPane.showMessageDialog(null, originalAmount
				+ " cents in coins can be given as:\n" + quarters
				+ " quarters(25c)\n" + dimes + " dimes(10c)\n" + nickels
				+ " nickels(5c) and\n" + pennies + " pennies(1c)");

	}
}