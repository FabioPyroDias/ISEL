package bookcode.p06MoreAboutObjectsAndMethod;

import java.util.Scanner;

/**
 * Pet demo
 * 
 */
public class C02PetDemo {

	/**
	 * Main method
	 */
	public static void main(String[] args) {

		// the keyboard reader
		Scanner keyboard = new Scanner(System.in);

		// your pet
		C01Pet yourPet = new C01Pet("Jane Doe");
		System.out.println("My records on your pet are inaccurate.");
		System.out.println("Here is what they currently say:");
		yourPet.writeOutput();

		System.out.println();

		// change the name of the pet
		System.out.print("Please enter the correct pet name -> ");
		String correctName = keyboard.nextLine();
		yourPet.setName(correctName);

		// change the age of the pet
		System.out.print("Please enter the correct pet age -> ");
		int correctAge = keyboard.nextInt();
		yourPet.setAge(correctAge);

		// change the weight of the pet
		System.out.print("Please enter the correct pet weight -> ");
		double correctWeight = keyboard.nextDouble();
		yourPet.setWeight(correctWeight);

		System.out.println();

		// write new data
		System.out.println("My updated records now say:");
		yourPet.writeOutput();

		// close keyboard
		keyboard.close();
	}

}
