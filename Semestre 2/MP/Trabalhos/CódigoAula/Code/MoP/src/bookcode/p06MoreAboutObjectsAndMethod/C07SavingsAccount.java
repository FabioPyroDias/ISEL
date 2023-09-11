package bookcode.p06MoreAboutObjectsAndMethod;

/**
 * Class with static and instance (non-static) members.
 */
public class C07SavingsAccount {

	// An instance variable (non-static)
	private double balance;

	// Static variables - that means they are global to all instances
	public static double interestRate = 0;
	public static int numberOfAccounts = 0;

	/**
	 * constructor
	 */
	public C07SavingsAccount() {
		balance = 0;
		// A nonstatic method can reference a static variable.
		numberOfAccounts++;
	}

	/**
	 * set interest rate
	 */
	public static void setInterestRate(double newRate) {
		// A static method can reference a static variable
		// but not an instance variable. Try it:
		// System.out.println("Balance -> " + balance);

		interestRate = newRate;
	}

	/**
	 * get interest rate
	 */
	public static double getInterestRate() {
		return interestRate;
	}

	/**
	 * get number of accounts
	 */
	public static int getNumberOfAccounts() {
		return numberOfAccounts;
	}

	/**
	 * deposit money
	 */
	public void deposit(double amount) {
		balance = balance + amount;
	}

	/**
	 * withdraw money
	 */
	public double withdraw(double amount) {
		if (balance >= amount)
			balance = balance - amount;
		else
			amount = 0;
		return amount;
	}

	/**
	 * add interest - A non-static method can reference a static variable or
	 * call a static method.
	 */
	public void addInterest() {
		double interest = balance * interestRate;
		// you can replace interestRate with getInterestRate()
		balance = balance + interest;
	}

	/**
	 * get balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * show balance - A static method cannot call a non-static method unless it
	 * has an object to do so.
	 */
	public static void showBalance(C07SavingsAccount account) {
		System.out.print(account.getBalance());
	}

}