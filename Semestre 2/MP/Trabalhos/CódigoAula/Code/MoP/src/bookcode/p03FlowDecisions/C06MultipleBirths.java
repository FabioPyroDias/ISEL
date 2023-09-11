package bookcode.p03FlowDecisions;

import java.util.Scanner;

/**
 * Switch - the multiple decision operator
 * 
 */
public class C06MultipleBirths {

	/*
	 * Main method
	 */
	public static void main(String[] args) {

		// the keyboard reader
		Scanner keyboard = new Scanner(System.in);

		// read the number of babies
		System.out.print("Enter number of babies: ");
		int numberOfBabies = keyboard.nextInt();

		// decide the message to write
		switch (numberOfBabies) {
		case 1:
			// if mumberOfBabies == 1, execute this branch, start the execution
			// here
			System.out.println("Congratulations.");
			// break stops the execution and jumps to out of the switch
			break;
		case 2:
			// if mumberOfBabies == 2, execute this branch
			System.out.println("Wow. Twins.");
			// terminate switch
			break;
		case 3:
			// if mumberOfBabies == 3, execute this branch
			System.out.println("Wow. Triplets.");
			// terminate switch
			break;
		case 4:
			// if mumberOfBabies == 4, execute this branch
		case 5:
			// if mumberOfBabies == 5, execute this branch
			System.out.print("Unbelieveable! ");
			System.out.println(numberOfBabies + " babies!!!!");
			// terminate switch
			break;
		default:
			System.out.println(numberOfBabies
					+ " babies!!!! I don't believe you!!!!");
			// terminate switch
			break;
		}

		// close keyboard
		keyboard.close();
	}
}