package bookcode.p11Recursion;

/**
 * Recursive method - a method that call himself
 * 
 * Simple examples of recursion
 */
public class C01RecursiveCountDown {

	/**
	 * Recursive method - count down
	 */
	public static void countDown(int num) {
		// the stop case
		if (num <= 0) {
			System.out.println();
		} else {
			// write num
			System.out.print(num + " ");
			// the recursion
			countDown(num - 1);
		}
	}

	/**
	 * Recursive method - count up
	 */
	public static void countUp(int num) {
		// the stop case is (num == 0)
		if (num > 0) {
			// the recursion
			countUp(num - 1);
			// write num
			System.out.print(num + " ");
		}
	}

	/**
	 * main
	 */
	public static void main(String[] args) {
		// first call to the recursive method count down
		countDown(5);

		// first call to the recursive method count down
		countUp(5);
	}

}
