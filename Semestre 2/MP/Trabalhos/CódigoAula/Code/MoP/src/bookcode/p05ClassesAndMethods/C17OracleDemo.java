package bookcode.p05ClassesAndMethods;

import java.util.Scanner;

/**
 * Oracle demo
 */
public class C17OracleDemo {

	/**
	 * main method
	 */
	public static void main(String[] args) {

		// the keyboard reader
		Scanner keyboard = new Scanner(System.in);

		// create an oracle and keep its reference in delphi local variable
		C16Oracle delphi = new C16Oracle();

		// put oracle to work
		delphi.chat(keyboard);
	}
}