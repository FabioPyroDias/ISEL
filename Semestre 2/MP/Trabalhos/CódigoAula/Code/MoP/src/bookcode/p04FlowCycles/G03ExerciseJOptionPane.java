package bookcode.p04FlowCycles;

import javax.swing.*;

/**
 * Show two dialogs: confirmDialog and messageDialog
 * 
 */
public class G03ExerciseJOptionPane {

	/**
	 * Main method
	 */
	public static void main(String[] args) {
		boolean adult = false;
		// Initialized to keep the compiler happy.

		// show the confirmDialog
		int answer = JOptionPane.showConfirmDialog(null,
				"Are you 18 years old or older?", "Age Check",
				JOptionPane.YES_NO_OPTION);

		// check the answer
		if (answer == JOptionPane.YES_OPTION)
			adult = true;
		else if (answer == JOptionPane.NO_OPTION)
			adult = false;
		else
			System.out.println("Error");

		// show the second dialog to show the result
		if (adult)
			JOptionPane.showMessageDialog(null, "You are old enough.");
		else
			JOptionPane.showMessageDialog(null, "Sorry. You must be 18.");
	}
}
