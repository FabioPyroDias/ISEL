package bookcode.p05ClassesAndMethods;

import java.util.*;

/**
 * Instance variables can keep values between method calls. Execute at least two
 * times. PRIVATE METHODS
 * 
 * Private methods are method that can only be called inside the class. Can be
 * called in static methods of the class on instances of the class.
 * 
 */

public class C16Oracle {

	// instance variables
	private String oldAnswer = "The answer is in your heart.";
	private String newAnswer;
	private String question;

	// the keyboard
	private Scanner keyboard;

	/**
	 * method that executes the oracle
	 */
	public void chat(Scanner theKeyboard) {

		// save the keyboard
		keyboard = theKeyboard;

		// announce the oracle
		System.out.print("I am the oracle. ");
		System.out.println("I will answer any one-line question.");

		String response;
		do {
			// execute one question and answer
			doQuestionAndDoAnswer();

			// ask and read if user wants more wisdom
			System.out.println("Do you wish to ask another question?");
			response = keyboard.next();
			// if afirmative, cntinue with the oracle
		} while (response.equalsIgnoreCase("yes"));

		// if not rest
		System.out.println("The oracle will now rest.");

		// close keyboard
		keyboard.close();
	}

	private void doQuestionAndDoAnswer() {
		// ask what is the question
		System.out.println("What is your question?");
		question = keyboard.nextLine();

		// seek advice
		seekAdvice();

		// present answer
		System.out.println("You asked the question: " + question);
		System.out.println("Now, here is my answer: " + oldAnswer);

		// save data to next question
		update();
	}

	// seek a hint from the person
	private void seekAdvice() {
		System.out.println("Hmm, I need some help on that.");
		System.out.println("Please give me one line of advice.");
		newAnswer = keyboard.nextLine();
		System.out.println("Thank you. That helped a lot.");
	}

	// save the current answer to next question - strange strategy!!!
	private void update() {
		oldAnswer = newAnswer;
	}
}
