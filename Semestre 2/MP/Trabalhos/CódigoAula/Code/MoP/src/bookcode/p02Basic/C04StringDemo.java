package bookcode.p02Basic;

/**
 * String manipulations
 * 
 */
public class C04StringDemo {

	/**
	 * Main method
	 */
	public static void main(String[] args) {

		String sentence = "Text processing is hard!";
		// get index of "hard" occurrence
		int position = sentence.indexOf("hard");

		// show info
		System.out.println("Initial string -> " + sentence);
		System.out.println("                  012345678901234567890123");
		System.out.println("The word \"hard\" starts at index " + position);

		// get part of the string and add easy
		sentence = sentence.substring(0, position) + "easy!";
		// change to uppercase
		sentence = sentence.toUpperCase();

		// show the new string
		System.out.print("The changed string -> " + sentence);

	}
}