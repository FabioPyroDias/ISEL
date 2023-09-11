package classcode.p02FlowDecisionsCycles;

import javax.swing.*;

/**
 * Input dialog window
 */
public class G01InoutAndDialogMessage {

	/**
	 * main method
	 */
	public static void main(String[] args) {

		// show one input dialog window to read the last name
		String lastName = JOptionPane
				.showInputDialog("Introduza o seu apelido.");

		// show last name in a messageDialog
		JOptionPane.showMessageDialog(null, "O seu apelido é " + lastName);

	}
}
