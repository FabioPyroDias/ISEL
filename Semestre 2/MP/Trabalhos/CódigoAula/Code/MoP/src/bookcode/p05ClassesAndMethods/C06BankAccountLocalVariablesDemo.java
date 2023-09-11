package bookcode.p05ClassesAndMethods;

/**
 * Local variables in main and local variables in method - no conflict
 * 
 */

public class C06BankAccountLocalVariablesDemo {

	/**
	 * The main method is a static method, so this static context, runs in a
	 * context outside any obect
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// but can create objects and access to attribute and methods of that
		// objects
		// create an account, keep the reference to that account in the local
		// variable myAccount
		C05BankAccountLocalVariables myAccount = new C05BankAccountLocalVariables();
		
		// change the data in myAccount
		myAccount.amount = 100.00;
		myAccount.rate = 5;

		// use a local variable
		double newAmount = 800.00;
		
		// show myBalance
		myAccount.showNewBalance();
		
		// wish more
		System.out.println("I wish my new amount were $" + newAmount);
	}
}
