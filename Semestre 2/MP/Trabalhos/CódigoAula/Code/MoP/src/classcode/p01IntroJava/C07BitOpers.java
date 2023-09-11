package classcode.p01IntroJava;

/**
 * Bit operators
 */
public class C07BitOpers {

	public static void main(String[] args) {

		// declaration of two ints with two int literals in hexadecimal values
		int bitmask = 0x000F;
		int val = 0x2222;

		// format enables us to format the output, its first string is the
		// control string, that string can have arguments that will be place
		// after the string, %d means that its a integer argument, %x means its
		// an argument that must be shown in hexadecimal, %04x means its an
		// argument that must be shown in hexadecimal with 4 hex digits and with
		// 0 on the left if necessary
		System.out.format("Printing one int in hexadecimal %d -> 0x%04x\n",
				val, val);

		val = 0x2;
		System.out.format("Printing one int in hexadecimal %d -> 0x%04x\n",
				val, val);

		// operator AND bit to bit
		System.out.format("0x%04x & 0x%04x = 0x%04x\n", val, bitmask, val
				& bitmask);

		// operator OR bit to bit
		System.out.format("0x%04x | 0x%04x = 0x%04x\n", val, bitmask, val
				| bitmask);

		// operator XOR bit to bit
		System.out.format("0x%04x ^ 0x%04x = 0x%04x\n", val, bitmask, val
				^ bitmask);

		// shift to the right
		int nbits = 1;
		System.out.format("0x%04x >> %d = 0x%04x\n", val, nbits, val >> nbits);

		// shift to the right, and shift to the right putting zero on the left
		int j = -16;
		System.out.format("0x%04x >> 1 = 0x%04x\n", j, j >> 1);
		System.out.format("0x%04x >>> 1 = 0x%04x\n", j, j >>> 1);

		// operator AND
		boolean b1 = false, b2 = true;
		System.out.println("\nBoolean test bit to bit operator");
		System.out.println("b1 = " + b1 + ", b2 = " + b2);
		System.out.println("b2 & b2 -> " + (b1 & b2));
		System.out.println("b1 | b2 -> " + (b1 | b2));
		System.out.println("b1 ^ b2 -> " + (b1 ^ b2));

		System.out.println("\nCharacters test bit to bit operator");
		// no caso de char, eles são convertidos em int
		char c1 = '\u00F2', c2 = '\u004F', c3 = (char) (c1 & c2);
		System.out.println(c1 + " & " + c2 + " = " + c3);
		
		// int h = Integer.valueOf("234").intValue();  // warning
	}
}
