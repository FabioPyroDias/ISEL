package classcode.p01IntroJava;

/**
 * float operation
 */
public class C08Float {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// one float variable
		float n = 0.3f;

		// show its value
		System.out.println("n = " + n);

		// subtract 0.1
		n = n - 0.1f;

		// show new value
		System.out.println("n = " + n);

		// check if they are equals by ==
		boolean theyAreEquals = (n == 0.2f);
		System.out.println("n == 0.2 -> " + theyAreEquals);
		
		theyAreEquals = Math.abs(n - 0.2f) < 0.000001f;
		System.out.println("n == 0.2 by Math.abs -> " + theyAreEquals);

	}

}
