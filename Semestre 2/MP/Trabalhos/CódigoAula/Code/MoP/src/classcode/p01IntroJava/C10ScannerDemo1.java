package classcode.p01IntroJava;

import java.util.Scanner;

/**
 * use of Scanner
 */
public class C10ScannerDemo1 {
	public static void main(String[] args) {
		// the keyboard reader
		Scanner keyboard = new Scanner(System.in);

		System.out.print("Introduza algo: ");
		String s = keyboard.next();
		System.out.println(s + ".");
		// s = keyboard.next();
		// System.out.println(s + ".");
		s = keyboard.nextLine();
		System.out.println(s + ".");

		System.out.println( "Introduza dois inteiros:");

		// read first next token (set of chars until a separator) as an int
		int n1 = keyboard.nextInt();
		// keyboard.nextLine();

		// read second next token as an int
		int n2 = keyboard.nextInt();

		// show the results
		System.out.println("Foi introduzido: " + n1 + " e " + n2);

		// close the keyboard
		keyboard.close();

		System.out.println();
	}
}
