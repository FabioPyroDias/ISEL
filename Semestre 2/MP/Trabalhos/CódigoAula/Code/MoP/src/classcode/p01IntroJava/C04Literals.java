package classcode.p01IntroJava;

/**
 * Class with some literals from the diferent types
 * 
 */
public class C04Literals {

	/**
	 * Main method
	 */
	public static void main(String[] args) {

		// byte literal
		byte b1 = 100;
		System.out.println("byte b1 = " + b1);

		// short literal
		short s1 = 10000;
		System.out.println("short s1 = " + s1);

		// int literal
		int i1 = 1000000000;
		System.out.println("int i1 = " + i1);

		// int in binary format, starts with 0b
		int iBinary = 0b110011111;
		System.out.println("int iBinary = 0b110011111; -> " + iBinary);

		// int in octal format, starts with zero
		int iOctal = 0234;
		System.out.println("int iOctal = 0234 -> " + iOctal);

		// int in hexadecimal format, starts with 0x
		int iHexadecimal = 0x234;
		System.out.println("int iHexadecimal = 0x234; -> " + iHexadecimal);

		// long literal, ends with l
		long l = 1000000000000000000L, l2 = 3l;
		System.out.println("long l = " + l + ", l2 = " + l2);

		// float literals, ends with f
		float f1 = 1.2f;
		System.out.println("float f1 = 1.2f -> " + f1);

		// double literals, decimal value that may ends with d
		double d1 = 0.1, d2 = 0.2d;
		System.out.println("double d1 = 0.1, d2 = 0.2d; d1 -> " + d1
				+ " d2 -> " + d2);

		// char literals - char literals always use ''
		char c1 = 'a';
		System.out.println("char c1 = \'a\'; -> " + c1);
		char c2 = '\n';
		System.out.println("char c2 = \'\\n\'; -> " + c2);

		// java have the following escape sequences: '\' is a escape char,
		// means that the char after the \ have special meaning: '\n'(new
		// line), '\r' (carriage return),'\t' (tab), '\b' (backspace),
		// '\f' (form feed), '\'' the ' character, '\"' (the " caracter),
		// '\\' (the \ character);

		char c3 = '\u0034'; // unicode char - value must be 4 hexadecimal
							// digits

		System.out.println("char c3 = \'\\u0034\'; -> " + c3);

		// we can put a underscore in any place on a literal, but it has to be
		// in the middle of two digits.
		int j1 = 1_000_000;
		System.out.println("int j1 = 1_000_000; -> " + j1);

		// String literals - string literals always use " "
		String str1 = "olá";
		System.out.println("String str1 = \"olá\"; -> " + str1);

		// explicitly creates a new object
		String str2 = new String("Olá");
		System.out.println("String str2 = new String(\"Olá\"); -> " + str2);

		// null is a special literal that means emptiness, to be used in object
		// references
		String str3 = null;
		System.out.println("String str3 = null; -> " + str3);
		System.out.println();
		
		System.out.println("Byte.MAX_VALUE -> " + Byte.MAX_VALUE);
		System.out.println("Short.MAX_VALUE -> " + Short.MAX_VALUE);
		System.out.println("Integer.MAX_VALUE -> " + Integer.MAX_VALUE);
		System.out.println("Long.MAX_VALUE -> " + Long.MAX_VALUE);
		System.out.println("Float.MAX_VALUE -> " + Float.MAX_VALUE);
		System.out.println("Double.MAX_VALUE -> " + Double.MAX_VALUE);
		
		System.out.println("Float.MIN_VALUE -> " + Float.MIN_VALUE);
		System.out.println("Double.MIN_VALUE -> " + Double.MIN_VALUE);
	}
}
