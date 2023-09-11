package bookcode.p05ClassesAndMethods;

/**
 * Auxiliary class - with local variables in methods. This local variables are
 * stored in the stack. Instance variable are stored in the object space. Class
 * or static variables are stored in the class space. Object and class space are
 * conceptual spaces for now.
 * 
 */

public class C05BankAccountLocalVariables {

	// instance variables called a field in eclipse
	public double amount;
	public double rate;

	// instance method - write data to output
	public void showNewBalance() {

		System.out.println("rate -> " + rate + " this.rate -> " + this.rate);

		// newAmount is a local variable in this method
		// if you delete the double and see the suggestions in the red left mar
		// the editor will suggest you to create a local variable or a field
		// variable. Choose local.s
		double newAmount = amount + (rate / 100.0) * amount;
		System.out.println("With interest added, the new amount is $"
				+ newAmount);

		// rate is a local variable, it is disappear after the method finish its
		// execution
		// as rate overlaps the field rate, if we write just rate the nearest
		// symbol is the symbol accessed. So to access the field (class
		// instance) rate we must use "this.race". "This." Means this object.
		double rate = 0.0;
		// just to show the access to one local variable with the same name of a
		// field
		System.out.println("local variable rate was created with 0.0");
		System.out.println("rate -> " + rate + " this.rate -> " + +this.rate);
	}
}
