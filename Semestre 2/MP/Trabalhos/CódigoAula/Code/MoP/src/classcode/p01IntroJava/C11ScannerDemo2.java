package classcode.p01IntroJava;

import java.util.Scanner;

/**
 * Program to practice using a Scanner.
 * 
 * @author ateofilo
 * 
 */
public class C11ScannerDemo2 {
	/**
	 * Read stuff from the keyboard. Uses nextLine to skip remainder of a line.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// the keyboard reader
		Scanner keyboard = new Scanner(System.in);

		// read the next token (the next set of chars until on separator)
		System.out.println("Introduza o apelido: ");
		String lastName = keyboard.next();

		// read the next token as as int
		System.out.println("Introduza a idade: ");
		int age = keyboard.nextInt();

		// read the remaining chars including the end of line chars
		keyboard.nextLine();

		// read the complete line
		System.out.println("Introduza a morada: ");
		String address = keyboard.nextLine();

		// show the results
		System.out.println("Apelido -> " + lastName);
		System.out.println("Idade -> " + age);
		System.out.println("Morada -> " + address);

		// close the keyboard
		keyboard.close();
	}
}
