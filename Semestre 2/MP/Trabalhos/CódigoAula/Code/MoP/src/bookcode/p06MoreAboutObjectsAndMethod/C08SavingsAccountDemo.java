package bookcode.p06MoreAboutObjectsAndMethod;

/*
 * Test of Savings account class
 */
public class C08SavingsAccountDemo {

	/**
	 * Main method
	 */
	public static void main(String[] args) {

		// set the global interest rate
		C07SavingsAccount.setInterestRate(0.01);

		// create two accounts
		C07SavingsAccount mySavings = new C07SavingsAccount();
		C07SavingsAccount yourSavings = new C07SavingsAccount();

		// mySavings.setInterestRate(0.01);

		// deposit some money in my account
		System.out.println("I deposited $10.75.");
		mySavings.deposit(10.75);

		// deposit some money in your account
		System.out.println("You deposited $75.");
		yourSavings.deposit(75.00);

		// deposit some money in your account
		System.out.println("You deposited $55.");
		yourSavings.deposit(55.00);

		// withdraw some money and get interests
		double cash = yourSavings.withdraw(15.75);
		System.out.println("You withdrew $" + cash + ".");
		if (yourSavings.getBalance() > 100.00) {
			System.out.println("You received interest.");
			yourSavings.addInterest();
		}

		// get new balance
		System.out.println("Your savings is $" + yourSavings.getBalance());

		// show balance
		System.out.print("My savings is $");
		C07SavingsAccount.showBalance(mySavings);
		System.out.println();

		// get the global number of accounts created
		int count = C07SavingsAccount.getNumberOfAccounts();
		System.out.println("We opened " + count + " savings accounts today.");
	}
}
