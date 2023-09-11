package bookcode.p04FlowCycles;

import javax.swing.*;

/**
 * JOptionPane.showConfirmDialog
 * 
 */
public class G02JOptionPaneYesNoDemo {

	/**
	 * Main method
	 */
	public static void main(String[] args) {

		System.out.println("Showing the dialog dialog...");

		// show confirm dialog: yes or no
		int answer = JOptionPane.showConfirmDialog(null, "End program?",
				"Want to end?", JOptionPane.YES_NO_OPTION);

		// check if option yes selected
		if (answer == JOptionPane.YES_OPTION) {
			// force program to terminate
			System.exit(0);
		} else // check if option no selected
		if (answer == JOptionPane.NO_OPTION)
			System.out.println("One more time");
		else
			// nothing selected
			System.out
					.println("Nothing selected. Dialog close with no option.");
	}
}
