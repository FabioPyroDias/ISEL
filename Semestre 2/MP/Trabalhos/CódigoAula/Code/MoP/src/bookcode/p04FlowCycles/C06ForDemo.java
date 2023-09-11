package bookcode.p04FlowCycles;

/**
 * For demo, "for(exp1, exp2, exp3) body;" is the same of: exp1; while(exp2) {
 * body; exp3; }
 */
public class C06ForDemo {

	/**
	 * Main method
	 */
	public static void main(String[] args) {
		// count down variable
		int countDown;
		// the for will iterate with countDown 3, 2, 1, 0
		for (countDown = 3; countDown >= 0; countDown--) {
			// write the count down value
			System.out.print(countDown);
			System.out.println(" and counting.");
		}
		// write that count down arrived to a end
		System.out.println("Blast off!");
		System.out.println("Countdown -> " + countDown);

		// TEST2
		// a second count down with a variable declared inside the for
		for (int countDown2 = 3; countDown2 >= 0; countDown2--) {
			System.out.print(countDown2);
			System.out.println(" and counting.");
		}
		System.out.println("Blast off!");
		// next line results in error because countDown2 is not visible here
		// System.out.println("Countdown2 -> " + countDown2);
	}
}
