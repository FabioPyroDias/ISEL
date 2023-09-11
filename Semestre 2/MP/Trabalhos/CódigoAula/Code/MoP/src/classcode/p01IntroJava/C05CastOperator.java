package classcode.p01IntroJava;

/**
 * Conversion between types using the cast operator. Converting from a bigger
 * type to a smaller type.
 * 
 */

public class C05CastOperator {

	/**
	 * Main method
	 */
	public static void main(String[] args) {
		long l = 100000000000000l;
		System.out.println("long l = " + l);

		// cast long to int
		int i1 = (int) l;
		System.out.println("int i1 = (int) l; i1 = " + i1);

		int i2 = 64 * 1204 + 5;
		System.out.println("int i2 = " + i2);

		// cast int to short
		short s1 = (short) i2;
		System.out.println("short s1 = (short) i2; s1 = " + s1);

		// cast short to byte
		byte b1 = (byte) (256 + 3);
		System.out.println("byte b1 = (byte) (256 + 3); b1 = " + b1);

	}

}
