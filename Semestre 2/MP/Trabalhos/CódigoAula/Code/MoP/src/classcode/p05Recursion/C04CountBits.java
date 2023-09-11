package classcode.p05Recursion;

import java.util.Scanner;

/**
 * Conta quantos bits a 1 existem num inteiro
 * 
 * Sugestão: método recursivo para mostrar os bits de um inteiro
 * 
 * @author ateofilo
 * 
 */
public class C04CountBits {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);

		System.out.println("Contagem do número de bits a 1 num inteiro...");
		System.out.print("Introduza um inteiro -> ");
		int number = keyboard.nextInt();

		System.out.println("Inteiro " + number
				+ " em binário (by toBinaryString) -> "
				+ Integer.toBinaryString(number));

		// show the bits of number
		System.out.print("Inteiro " + number
				+ " em binário (by showBits)       -> ");
		showBits(number);
		System.out.println();

		// show2 the bits of number
		System.out.print("Inteiro " + number
				+ " em binário (by showBits2)      -> ");
		showBits2(number);
		System.out.println();

		// count active bits in number
		int nActiveBits = countActiveBits(number);
		System.out.println("O " + number + " contém " + nActiveBits
				+ " bits a 1");

		keyboard.close();
	}

	/**
	 * show bits - supports negative numbers
	 */
	public static void showBits(int n) {
		// second argument is a mask with the initial value of 1 in highest
		// value bit
		showBits(n, 0x80000000);
	}

	/**
	 * Show bits
	 */
	private static void showBits(int n, int mask) {

		// stop case, the mask is empty
		if (mask == 0)
			return;

		// AND mask with n, if is different than zero, that bit is active
		System.out.print("" + ((n & mask) != 0 ? '1' : '0'));

		// process the remaining bits, mask shift to the right
		showBits(n, mask >>> 1);

	}

	/**
	 * show bits2 - supports negative numbers. Second version, based on nbits and
	 * get value before recursion but print value after recursion. A nice
	 * example of recursion.
	 */
	public static void showBits2(int n) {
		showBits2(n, 32);
	}

	/**
	 * Show bits2
	 */
	private static void showBits2(int n, int nBitsLeft) {

		// if negative argument throw exception
		if (nBitsLeft < 0)
			throw new IllegalArgumentException(
					"Show bits internal: nbitsLeft negativo: " + nBitsLeft);

		// stop case
		if (nBitsLeft == 0)
			return;

		// get last bit (lowest value bit), save it in char, this bit will be
		// the last one to be printed
		char lastBit = (char)((n & 1) + '0');

		// process next bits
		showBits2(n >> 1, nBitsLeft - 1);

		// output the saved bit
		System.out.print(lastBit);

	}

	/**
	 * Count the number of active bits - supports negative numbers
	 */
	public static int countActiveBits(int n) {

		// stop case
		if (n == 0)
			return 0;

		// extract if last bit, 1 if active, 0 is not
		int oneIfLastBitIsActive = n & 1;

		// shift right, with new left bits with zero
		return oneIfLastBitIsActive + countActiveBits(n >>> 1);
	}

}
