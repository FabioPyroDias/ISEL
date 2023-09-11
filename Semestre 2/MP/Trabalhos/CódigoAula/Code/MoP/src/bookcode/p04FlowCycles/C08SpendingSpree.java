package bookcode.p04FlowCycles;

import java.util.Scanner;

/**
 * final variables - constants - a constant can not be changed, after it is
 * initialized
 */
public class C08SpendingSpree {

	/**
	 * Main method
	 */
	public static void main(String[] args) {

		// money to spend - this is a constant
		final int SPENDING_MONEY = 100;
		// maximum items that w can buy
		final int MAX_ITEMS = 3;

		// the keyboard reader
		Scanner keyboard = new Scanner(System.in);

		// flag that indicates that we have money to spend, or not
		boolean haveMoney = true;
		// have to money left to be spent
		int leftToSpend = SPENDING_MONEY;
		// the total already spent
		int totalSpent = 0;
		// number of items already bought
		int itemNumber = 1;

		// while we have money and can buy more items continue shopping
		while (haveMoney && (itemNumber <= MAX_ITEMS)) {

			// show actual information
			System.out.println("You may buy up to "
					+ (MAX_ITEMS - itemNumber + 1) + " items");
			System.out.println("costing no more than $" + leftToSpend + ".");

			// ask the cost of the new item
			System.out.print("Enter cost of item #" + itemNumber + ": $");
			int itemCost = keyboard.nextInt();

			// check if we have enough money
			if (itemCost <= leftToSpend) {
				// write that we can buy
				System.out.println("You may buy this item. ");
				// update the total used
				totalSpent = totalSpent + itemCost;
				// write the updated information
				System.out.println("You spent $" + totalSpent + " so far.");
				// calculate the new value that we have to spent
				leftToSpend = SPENDING_MONEY - totalSpent;

				// increase the number of items
				itemNumber++;

				// check if we don't have more money to spent
				if (leftToSpend == 0) {
					// we are out of money
					System.out.println("You are out of money.");
					// signal the flag that we are out of memory
					haveMoney = false;
				}
			} else {
				// we can't buy the selected item
				System.out.println("You cannot buy that item.");
			}
			// end while
		}

		// show shopping result
		System.out.println("You spent $" + totalSpent
				+ ", and are done shopping.");

		// close keyboard
		keyboard.close();
	}
}