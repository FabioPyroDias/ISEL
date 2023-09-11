package bookcode.p05ClassesAndMethods;

/**
 * Purchase demo
 * 
 */
public class C15PurchaseDemo {

	/**
	 * Main method
	 */
	public static void main(String[] args) {

		// create a new purchase and keep its referenece in onSale
		C14Purchase oneSale = new C14Purchase();
		// read data in to it
		oneSale.readInput();

		System.out.println();

		// write it to console
		oneSale.writeOutput();

		// write unitCost an total Cost
		System.out.println("Cost each $" + oneSale.getUnitCost());
		System.out.println("Total cost $" + oneSale.getTotalCost());
	}
}
