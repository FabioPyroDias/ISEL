package classcode.p02FlowDecisionsCycles;

/**
 * Switch com inteiros (bytes) - com múltiplas entradas para o mesmo código
 * 
 * 
 * @author ateofilo
 * 
 */
public class C08SwitchComChars {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// the initials character
		char theChar = 'a';

		// information about that character
		boolean isLowerCaseVowel = false;
		boolean isUpperCaseVowel = false;
		boolean isDigit = false;

		// set what the character is
		switch (theChar) {
		case 'A':
		case 'E':
		case 'I':
		case 'O':
		case 'U':
			isUpperCaseVowel = true;
			break;
		case 'a':
		case 'e':
		case 'i':
		case 'o':
		case 'u':
			isLowerCaseVowel = true;
			break;
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
		case 7:
		case 8:
		case 9:
			isDigit = true;
		}

		// show the results
		System.out.println("The char  -> " + theChar);
		System.out.println("is " + (isLowerCaseVowel ? "" : "not ")
				+ "a lower case vowel,");
		System.out.println("is " + (isUpperCaseVowel ? "" : "not ")
				+ "a upper case vowel and");
		System.out.println("is " + (isDigit ? "" : "not") + " a digit.");

	}
}
