package classcode.p03IntroMethods;

import java.util.Scanner;

public class C04PrintSquare {

	public static void main(String[] args) {
		// the keyboard reader
		Scanner keyboard = new Scanner(System.in);

		// read length of square side
		System.out.println("Entering the length of square side:");
		int squareSide = C02LowestCommonMultipleV2.readPositiveNonZeroInteger(keyboard);
		
		// run over the lines
		for (int nLinha = 0; nLinha < squareSide; nLinha++) {
			
			// run over the columns
			for (int nColuna = 0; nColuna < squareSide; nColuna++) {
				// print one char
				System.out.print("#");
			}
			
			// change line at the end of each line
			System.out.println();
		}
	}
}
