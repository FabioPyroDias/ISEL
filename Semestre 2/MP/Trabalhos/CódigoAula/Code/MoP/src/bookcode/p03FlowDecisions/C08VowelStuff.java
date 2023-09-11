package bookcode.p03FlowDecisions;

import java.util.Scanner;

/**
 * More about switch ...
 * 
 */
public class C08VowelStuff {

	/**
	 * Main method
	 */
	public static void main(String[] args) {

		// the keyboard reader
		Scanner keyboard = new Scanner(System.in);
		String word;
		char firstChar;
		boolean isVowel;

		// read a word
		System.out.println("Enter a word:");
		word = keyboard.next();

		// get the first character of the word
		firstChar = word.charAt(0);

		// use the switch to see if the char is a vowel or not
		switch (firstChar) {
		case 'a':
		case 'A':
		case 'e':
		case 'E':
		case 'i':
		case 'I':
		case 'o':
		case 'O':
		case 'u':
		case 'U':
			isVowel = true;
			break;
		default:
			isVowel = false;
		}

		// show the results
		if (isVowel) {
			System.out.println(word + " starts with a vowel");
		} else {
			System.out.println(word + " starts with a consonant");
		}

		// close keyboard
		keyboard.close();
	}
}