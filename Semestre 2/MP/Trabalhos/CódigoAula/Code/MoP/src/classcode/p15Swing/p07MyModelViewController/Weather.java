package classcode.p15Swing.p07MyModelViewController;

import java.util.Scanner;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * A classe Weather é um Model.
 * 
 * Mas o seu "main" é um controller e um Viewer
 * 
 */
public class Weather implements IChangeNotifier {

	private int value = 0;

	private ChangeNotifier cw = new ChangeNotifier();

	public Weather(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
		fireStateChanged();
	}

	// método auxiliar - eventualmente desnecessário, caso se aceda
	// directamente a cw
	protected void fireStateChanged() {
		cw.fireStateChanged(new ChangeEvent(this));
	}

	public void addChangeListener(ChangeListener l) {
		cw.addChangeListener(l);
	}

	// main
	public static void main(String[] args) {
		System.out.println("..: Text mode application :...");
		Weather weatherLisbon = new Weather(25);
		Scanner input = new Scanner(System.in);
		boolean quit = false;
		do {
			System.out.println("Weather in Lisbon is -> "
					+ weatherLisbon.getValue());
			System.out.println("1 - change weather in Lisbon");
			System.out.println("0 - quit");
			System.out.print("-> ");

			if (input.hasNextInt()) {
				int option = input.nextInt();
				// clear the remainder part of the line
				input.nextLine();
				switch (option) {
				case 0:
					quit = true;
					break;
				case 1:
					System.out.print("New temperature in Lisbon -> ");
					if (input.hasNextInt()) {
						int newTemp = input.nextInt();
						input.nextLine();
						weatherLisbon.setValue(newTemp);
					} else {
						System.out.println("Invalid temperature -> "
								+ input.nextLine());
					}
					break;
				default:
					System.out.println("Invalid option -> " + option);
				}
			} else {
				System.out.println("Invalid option -> " + input.nextLine());
			}

		} while (!quit);
		input.close();
	}

}
